package com.example.oneplusbudsqs.ui

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.bluetooth.BluetoothManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.oneplusbudsqs.R
import com.example.oneplusbudsqs.bluetooth.BudsConnectionManager
import com.example.oneplusbudsqs.bluetooth.BudsService
import com.example.oneplusbudsqs.protocol.OpoProtocol

class MainActivity : Activity(), BudsConnectionManager.Listener {

    private lateinit var statusText: TextView
    private lateinit var scroll: ScrollView
    private lateinit var manager: BudsConnectionManager
    private lateinit var mainLayout: LinearLayout

    private lateinit var batteryLeftText: TextView
    private lateinit var batteryCaseText: TextView
    private lateinit var batteryRightText: TextView
    private lateinit var btnToggleLog: Button
    private lateinit var btnAncOn: Button
    private lateinit var btnSettings: Button

    private val TARGET_MAC = "A8:E6:E8:92:C1:25"
    private val REQUEST_PERMISSIONS = 1001

    private val THEME_OLED = 0
    private val THEME_DARK = 1
    private val THEME_LIGHT = 2
    private var currentTheme = THEME_OLED

    private var isBound = false
    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as BudsService.LocalBinder
            manager = binder.getService().manager!!
            manager.addListener(this@MainActivity)
            isBound = true
            appendStatus("Foreground Service Connected")
            connectDirectly()
        }
        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainLayout = findViewById(R.id.mainLayout)
        statusText = findViewById(R.id.statusText)
        scroll = findViewById(R.id.scroll)
        batteryLeftText = findViewById(R.id.batteryLeftText)
        batteryCaseText = findViewById(R.id.batteryCaseText)
        batteryRightText = findViewById(R.id.batteryRightText)
        btnToggleLog = findViewById(R.id.btnToggleLog)
        btnAncOn = findViewById(R.id.btnAncOn)
        btnSettings = findViewById(R.id.btnSettings)

        val prefs = getSharedPreferences("BudsQSPrefs", Context.MODE_PRIVATE)
        currentTheme = prefs.getInt("theme", THEME_OLED)
        applyTheme(currentTheme)

        btnSettings.setOnClickListener { showSettingsDialog() }
        btnToggleLog.setOnClickListener {
            if (scroll.visibility == View.GONE) {
                scroll.visibility = View.VISIBLE
                btnToggleLog.text = "Hide Log"
            } else {
                scroll.visibility = View.GONE
                btnToggleLog.text = "Show Log"
            }
        }

        findViewById<Button>(R.id.btnConnect).setOnClickListener { connectDirectly() }
        findViewById<Button>(R.id.btnDisconnect).setOnClickListener { manager.disconnect() }

        btnAncOn.setOnClickListener { view ->
            val popup = PopupMenu(this, view)
            popup.menu.add("High (Real-time)")
            popup.menu.add("Medium")
            popup.menu.add("Low")
            popup.setOnMenuItemClickListener { item ->
                when (item.title) {
                    "High (Real-time)" -> { btnAncOn.text = "ANC: High"; manager.sendAncMode(OpoProtocol.ANC_HIGH) }
                    "Medium" -> { btnAncOn.text = "ANC: Med"; manager.sendAncMode(OpoProtocol.ANC_MODERATE) }
                    "Low" -> { btnAncOn.text = "ANC: Low"; manager.sendAncMode(OpoProtocol.ANC_LOW) }
                }
                true
            }
            popup.show()
        }

        findViewById<Button>(R.id.btnTransparency).setOnClickListener {
            btnAncOn.text = "ANC"
            manager.sendAncMode(OpoProtocol.ANC_TRANSPARENCY)
        }
        findViewById<Button>(R.id.btnAncOff).setOnClickListener {
            btnAncOn.text = "ANC"
            manager.sendAncMode(OpoProtocol.ANC_OFF)
        }
        // Game Mode: fixed packet format (15 bytes) confirmed from HeyMelody capture.
        findViewById<Button>(R.id.btnGameOn).setOnClickListener {
            appendStatus("Game Mode ON")
            manager.setGameMode(true)
        }
        findViewById<Button>(R.id.btnGameOff).setOnClickListener {
            appendStatus("Game Mode OFF")
            manager.setGameMode(false)
        }

        checkPermissions()
    }

    private fun startServiceIfAllowed() {
        if (!hasAllRequiredPermissions()) return
        val serviceIntent = Intent(this, BudsService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent)
        } else {
            startService(serviceIntent)
        }
    }

    private fun hasAllRequiredPermissions(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED &&
            checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_GRANTED &&
            checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED
        } else {
            checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSIONS) {
            if (hasAllRequiredPermissions()) {
                startServiceIfAllowed()
                val intent = Intent(this, BudsService::class.java)
                bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
            } else {
                appendStatus("Permissions denied. App cannot function.")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (hasAllRequiredPermissions()) {
            startServiceIfAllowed()
            val intent = Intent(this, BudsService::class.java)
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()
        if (isBound) {
            manager.removeListener(this)
            unbindService(serviceConnection)
            isBound = false
        }
    }

    private fun showSettingsDialog() {
        val options = arrayOf("OLED Black (Default)", "Standard Dark", "Light")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("App Theme")
        builder.setSingleChoiceItems(options, currentTheme) { dialog, which ->
            currentTheme = which
            applyTheme(currentTheme)
            val prefs = getSharedPreferences("BudsQSPrefs", Context.MODE_PRIVATE)
            prefs.edit().putInt("theme", currentTheme).apply()
            dialog.dismiss()
        }
        builder.show()
    }

    private fun applyTheme(theme: Int) {
        val bgColor: Int; val textColor: Int; val btnBgColor: Int; val logBgColor: Int
        when (theme) {
            THEME_OLED -> { bgColor = Color.BLACK; textColor = Color.WHITE; btnBgColor = Color.parseColor("#333333"); logBgColor = Color.parseColor("#111111") }
            THEME_DARK -> { bgColor = Color.parseColor("#121212"); textColor = Color.parseColor("#E0E0E0"); btnBgColor = Color.parseColor("#424242"); logBgColor = Color.parseColor("#1E1E1E") }
            else -> { bgColor = Color.WHITE; textColor = Color.BLACK; btnBgColor = Color.parseColor("#EEEEEE"); logBgColor = Color.parseColor("#F5F5F5") }
        }
        mainLayout.setBackgroundColor(bgColor)
        scroll.setBackgroundColor(logBgColor)
        statusText.setTextColor(textColor)
        applyColorsToViews(mainLayout, textColor, btnBgColor)
    }

    private fun applyColorsToViews(view: View, textColor: Int, btnBgColor: Int) {
        if (view is TextView) view.setTextColor(textColor)
        if (view is Button) { view.setBackgroundColor(btnBgColor); view.setTextColor(textColor) }
        if (view is ViewGroup) { for (i in 0 until view.childCount) applyColorsToViews(view.getChildAt(i), textColor, btnBgColor) }
    }

    private fun checkPermissions() {
        val needed = mutableListOf<String>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) needed.add(Manifest.permission.BLUETOOTH_CONNECT)
            if (checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) needed.add(Manifest.permission.BLUETOOTH_SCAN)
            if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) needed.add(Manifest.permission.POST_NOTIFICATIONS)
        } else {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) needed.add(Manifest.permission.ACCESS_FINE_LOCATION)
        }
        if (needed.isEmpty()) {
            startServiceIfAllowed()
        } else {
            requestPermissions(needed.toTypedArray(), REQUEST_PERMISSIONS)
        }
    }

    @SuppressLint("MissingPermission")
    private fun connectDirectly() {
        if (!isBound) return
        val btManager = getSystemService(BluetoothManager::class.java)
        val adapter = btManager?.adapter
        if (adapter == null || !adapter.isEnabled) return
        try {
            val device = adapter.getRemoteDevice(TARGET_MAC)
            manager.connect(device)
        } catch (e: IllegalArgumentException) {
            appendStatus("Invalid MAC address: ${e.message}")
        }
    }

    override fun onStatus(msg: String) { appendStatus(msg) }

    override fun onConnected(connected: Boolean) {
        runOnUiThread {
            appendStatus(if (connected) ">>> READY <<<" else "Disconnected")
            if (connected) {
                val btManager = getSystemService(BluetoothManager::class.java)
                val device = btManager?.adapter?.getRemoteDevice(TARGET_MAC)
                if (device != null) {
                    manager.connectAudioProfile(device)
                }
            }
        }
    }

    override fun onPacketReceived(bytes: ByteArray) {
        if (bytes.size < 5) return
        val hexString = OpoProtocol.bytesToHex(bytes)
        if (bytes[0] == 0xAA.toByte()) {
            appendStatus("[RAW] $hexString")
        }
        // Battery packet: AA 0D 00 00 04 02 FF 06 00 F1 [L] [R] 00 00 03
        if (bytes[0] == 0xAA.toByte() && bytes[1] == 0x0D.toByte() && bytes.size >= 12) {
            val l = bytes[10].toInt() and 0x7F
            val r = bytes[11].toInt() and 0x7F
            runOnUiThread {
                batteryLeftText.text = "L: ${if (l in 1..100) "$l%" else "--"}"
                batteryRightText.text = "R: ${if (r in 1..100) "$r%" else "--"}"
                // Case offset not yet located; leave as-is until confirmed.
            }
        }
    }

    private fun appendStatus(msg: String) {
        runOnUiThread {
            statusText.append("\n$msg")
            scroll.post { scroll.fullScroll(ScrollView.FOCUS_DOWN) }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
