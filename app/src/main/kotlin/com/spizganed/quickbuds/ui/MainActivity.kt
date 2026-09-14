package com.spizganed.quickbuds.ui

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.bluetooth.BluetoothManager
import android.content.ClipData
import android.content.ClipboardManager
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
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import com.spizganed.quickbuds.R
import com.spizganed.quickbuds.bluetooth.BudsConnectionManager
import com.spizganed.quickbuds.bluetooth.BudsService
import com.spizganed.quickbuds.widget.AncWidgetProvider
import com.spizganed.quickbuds.widget.WidgetStateStore
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : Activity(), BudsConnectionManager.Listener {

    private lateinit var statusText: TextView
    private lateinit var scroll: ScrollView
    private lateinit var manager: BudsConnectionManager
    private lateinit var mainLayout: LinearLayout

    private lateinit var batteryLeftText: TextView
    private lateinit var batteryCaseText: TextView
    private lateinit var batteryRightText: TextView
    private lateinit var btnToggleLog: Button
    private lateinit var btnAncMode: Button
    private lateinit var btnTransparency: Button
    private lateinit var btnAncOff: Button
    private lateinit var btnGameOn: Button
    private lateinit var btnGameOff: Button
    private lateinit var btnSettings: Button

    private val TARGET_MAC = "A8:E6:E8:92:C1:25"
    private val REQUEST_PERMISSIONS = 1001

    private val THEME_OLED = 0
    private val THEME_DARK = 1
    private val THEME_LIGHT = 2
    private var currentTheme = THEME_OLED

    private val timeFormat = SimpleDateFormat("HH:mm:ss.SSS", Locale.US)

    private var activeAncMode: String = "Off"
    private var gameModeOn = false

    private var accentColor: Int = Color.parseColor("#CC0000")
    private var inactiveBtnColor: Int = Color.parseColor("#333333")
    private var textColor: Int = Color.WHITE

    private var isBound = false
    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as BudsService.LocalBinder
            manager = binder.getService().manager!!
            manager.addListener(this@MainActivity)
            isBound = true
            appendStatus("Service connected")
            connectDirectly()
        }
        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
        }
    }

    private val storeListener: (WidgetStateStore.State) -> Unit = { state ->
        val ancChanged = state.ancMode != activeAncMode
        val gameChanged = state.gameMode != gameModeOn
        if (ancChanged || gameChanged) {
            activeAncMode = state.ancMode
            gameModeOn = state.gameMode
            updateAncButtons()
            updateGameButtons()
            appendStatus("Sync -> $activeAncMode (game=$gameModeOn)")
        }
        runOnUiThread {
            batteryLeftText.text  = if (state.hasLeft())  "L: ${state.leftBattery}"  else "L: --"
            batteryCaseText.text  = if (state.hasCase())  "C: ${state.caseBattery}"  else "C: --"
            batteryRightText.text = if (state.hasRight()) "R: ${state.rightBattery}" else "R: --"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceIntent = Intent(this, BudsService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) startForegroundService(serviceIntent)
        else startService(serviceIntent)

        mainLayout = findViewById<LinearLayout>(R.id.mainLayout)
        statusText = findViewById<TextView>(R.id.statusText)
        scroll = findViewById<ScrollView>(R.id.scroll)
        batteryLeftText = findViewById<TextView>(R.id.batteryLeftText)
        batteryCaseText = findViewById<TextView>(R.id.batteryCaseText)
        batteryRightText = findViewById<TextView>(R.id.batteryRightText)
        btnToggleLog = findViewById<Button>(R.id.btnToggleLog)
        btnAncMode = findViewById<Button>(R.id.btnAncMode)
        btnTransparency = findViewById<Button>(R.id.btnTransparency)
        btnAncOff = findViewById<Button>(R.id.btnAncOff)
        btnGameOn = findViewById<Button>(R.id.btnGameOn)
        btnGameOff = findViewById<Button>(R.id.btnGameOff)
        btnSettings = findViewById<Button>(R.id.btnSettings)

        WidgetStateStore.addListener(storeListener)
        val initial = WidgetStateStore.read(this)
        activeAncMode = initial.ancMode
        gameModeOn = initial.gameMode

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

        btnAncMode.setOnClickListener { view -> showAncPopup(view) }

        btnTransparency.setOnClickListener {
            activeAncMode = "Transparency"
            appendStatus("ANC -> Transparency")
            manager.sendAncTransparency()
            updateAncButtons()
            syncWidgetState()
        }
        btnAncOff.setOnClickListener {
            activeAncMode = "Off"
            appendStatus("ANC -> Off")
            manager.sendAncOff()
            updateAncButtons()
            syncWidgetState()
        }

        btnGameOn.setOnClickListener {
            appendStatus("Game Mode ON")
            manager.setGameMode(true)
            gameModeOn = true
            updateGameButtons()
            syncWidgetState()
        }
        btnGameOff.setOnClickListener {
            appendStatus("Game Mode OFF")
            manager.setGameMode(false)
            gameModeOn = false
            updateGameButtons()
            syncWidgetState()
        }

        updateAncButtons()
        updateGameButtons()
        checkPermissions()
    }

    override fun onDestroy() {
        WidgetStateStore.removeListener(storeListener)
        super.onDestroy()
    }

    private fun syncWidgetState() {
        val state = WidgetStateStore.read(this)
        state.ancMode = activeAncMode
        state.gameMode = gameModeOn
        WidgetStateStore.write(this, state)
        AncWidgetProvider.refreshAll(this)
    }

    private fun showAncPopup(anchor: View) {
        val popup = PopupMenu(this, anchor)
        popup.menu.add("Deep")
        popup.menu.add("Medium")
        popup.menu.add("Light")
        popup.menu.add("Smart")
        popup.setOnMenuItemClickListener { item ->
            when (item.title) {
                "Deep" -> { activeAncMode = "ANC-Deep"; manager.sendAncDeep(); appendStatus("ANC -> Deep") }
                "Medium" -> { activeAncMode = "ANC-Medium"; manager.sendAncMedium(); appendStatus("ANC -> Medium") }
                "Light" -> { activeAncMode = "ANC-Light"; manager.sendAncLight(); appendStatus("ANC -> Light") }
                "Smart" -> { activeAncMode = "ANC-Smart"; manager.sendAncSmart(); appendStatus("ANC -> Smart") }
            }
            updateAncButtons()
            syncWidgetState()
            true
        }
        popup.show()
    }

    private fun updateAncButtons() {
        runOnUiThread {
            btnAncMode.setBackgroundColor(inactiveBtnColor)
            btnTransparency.setBackgroundColor(inactiveBtnColor)
            btnAncOff.setBackgroundColor(inactiveBtnColor)
            btnAncMode.setTextColor(textColor)
            btnTransparency.setTextColor(textColor)
            btnAncOff.setTextColor(textColor)

            when {
                activeAncMode == "Off" -> {
                    btnAncOff.setBackgroundColor(accentColor)
                    btnAncOff.setTextColor(Color.WHITE)
                    btnAncMode.text = "ANC"
                }
                activeAncMode == "Transparency" -> {
                    btnTransparency.setBackgroundColor(accentColor)
                    btnTransparency.setTextColor(Color.WHITE)
                    btnAncMode.text = "ANC"
                }
                activeAncMode.startsWith("ANC-") -> {
                    btnAncMode.setBackgroundColor(accentColor)
                    btnAncMode.setTextColor(Color.WHITE)
                    btnAncMode.text = when (activeAncMode) {
                        "ANC-Deep" -> "ANC: Deep"
                        "ANC-Medium" -> "ANC: Med"
                        "ANC-Light" -> "ANC: Light"
                        "ANC-Smart" -> "ANC: Smart"
                        else -> "ANC"
                    }
                }
            }
        }
    }

    private fun updateGameButtons() {
        runOnUiThread {
            if (gameModeOn) {
                btnGameOn.setBackgroundColor(accentColor)
                btnGameOn.setTextColor(Color.WHITE)
                btnGameOff.setBackgroundColor(inactiveBtnColor)
                btnGameOff.setTextColor(textColor)
            } else {
                btnGameOn.setBackgroundColor(inactiveBtnColor)
                btnGameOn.setTextColor(textColor)
                btnGameOff.setBackgroundColor(accentColor)
                btnGameOff.setTextColor(Color.WHITE)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, BudsService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
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
        val options = arrayOf(
            "Theme: OLED Black",
            "Theme: Standard Dark",
            "Theme: Light",
            "Reconnect to buds",
            "Disconnect from buds"
        )
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Settings")
        builder.setItems(options) { dialog, which ->
            when (which) {
                0, 1, 2 -> {
                    currentTheme = which
                    applyTheme(currentTheme)
                    getSharedPreferences("BudsQSPrefs", Context.MODE_PRIVATE).edit()
                        .putInt("theme", currentTheme).apply()
                }
                3 -> { connectDirectly(); appendStatus("Manual reconnect triggered") }
                4 -> { manager.disconnect(); appendStatus("Manual disconnect triggered") }
            }
            dialog.dismiss()
        }
        builder.show()
    }

    private fun applyTheme(theme: Int) {
        val bgColor: Int = when (theme) {
            THEME_OLED -> Color.BLACK
            THEME_DARK -> Color.parseColor("#121212")
            else -> Color.WHITE
        }
        val newTextColor: Int = when (theme) {
            THEME_OLED -> Color.WHITE
            THEME_DARK -> Color.parseColor("#E0E0E0")
            else -> Color.BLACK
        }
        val newInactive: Int = when (theme) {
            THEME_OLED -> Color.parseColor("#333333")
            THEME_DARK -> Color.parseColor("#424242")
            else -> Color.parseColor("#EEEEEE")
        }
        val newAccent: Int = Color.parseColor("#CC0000")

        textColor = newTextColor
        inactiveBtnColor = newInactive
        accentColor = newAccent

        mainLayout.setBackgroundColor(bgColor)
        scroll.setBackgroundColor(
            if (theme == THEME_LIGHT) Color.parseColor("#F5F5F5")
            else Color.parseColor("#111111")
        )
        statusText.setTextColor(textColor)
        applyColorsToViews(mainLayout, textColor, inactiveBtnColor)
        updateAncButtons()
        updateGameButtons()
        statusText.setOnLongClickListener {
            val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            cm.setPrimaryClip(ClipData.newPlainText("QuickBuds Log", statusText.text.toString()))
            Toast.makeText(this, "Log copied", Toast.LENGTH_SHORT).show()
            true
        }
    }

    private fun applyColorsToViews(view: View, tc: Int, btnBg: Int) {
        if (view is TextView) view.setTextColor(tc)
        if (view is Button) {
            view.setBackgroundColor(btnBg)
            view.setTextColor(tc)
        }
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) applyColorsToViews(view.getChildAt(i), tc, btnBg)
        }
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
        if (needed.isNotEmpty()) requestPermissions(needed.toTypedArray(), REQUEST_PERMISSIONS)
    }

    @SuppressLint("MissingPermission")
    private fun connectDirectly() {
        if (!isBound) { appendStatus("Service not bound yet."); return }
        val btManager = getSystemService(BluetoothManager::class.java)
        val adapter = btManager?.adapter
        if (adapter == null || !adapter.isEnabled) { appendStatus("Bluetooth not enabled"); return }
        try {
            val device = adapter.getRemoteDevice(TARGET_MAC)
            manager.connect(device)
        } catch (e: IllegalArgumentException) {
            appendStatus("Invalid MAC: ${e.message}")
        }
    }

    override fun onStatus(msg: String) { appendStatus(msg) }

    override fun onConnected(connected: Boolean) {
        runOnUiThread {
            appendStatus(if (connected) ">>> READY <<<" else "Disconnected")
        }
    }

    override fun onPacketReceived(bytes: ByteArray) {}

    override fun onBattery(
        left: Int?, case: Int?, right: Int?,
        chargingLeft: Boolean, chargingCase: Boolean, chargingRight: Boolean
    ) {
        // UI is driven by storeListener; nothing to do here
    }

    override fun onBudState(state: String) {
        runOnUiThread { appendStatus("Bud state: $state") }
    }

    private fun appendStatus(msg: String) {
        runOnUiThread {
            try {
                val ts = timeFormat.format(Date())
                statusText.append("\n[$ts] $msg")
                scroll.post { scroll.fullScroll(ScrollView.FOCUS_DOWN) }
            } catch (_: Exception) {}
        }
    }
}
