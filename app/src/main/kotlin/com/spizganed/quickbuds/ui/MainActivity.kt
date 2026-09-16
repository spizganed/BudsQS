package com.spizganed.quickbuds.ui

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.bluetooth.BluetoothManager
import android.content.*
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.spizganed.quickbuds.R
import com.spizganed.quickbuds.bluetooth.BudsConnectionManager
import com.spizganed.quickbuds.bluetooth.BudsService
import com.spizganed.quickbuds.widget.AncWidgetProvider
import com.spizganed.quickbuds.widget.WidgetIcons
import com.spizganed.quickbuds.widget.WidgetStateStore
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : Activity(), BudsConnectionManager.Listener {

    private lateinit var statusText: TextView
    private lateinit var scroll: ScrollView
    private lateinit var manager: BudsConnectionManager
    private lateinit var mainLayout: LinearLayout

    private lateinit var btnSettings: Button
    private lateinit var btnDevTools: Button

    // --- In-app status panel (mirrors the widget visuals) ---
    private lateinit var statusRowLeft: LinearLayout
    private lateinit var statusRowCase: LinearLayout
    private lateinit var statusRowRight: LinearLayout
    private lateinit var statusBarLeft: ProgressBar
    private lateinit var statusBarCase: ProgressBar
    private lateinit var statusBarRight: ProgressBar
    private lateinit var statusTextLeft: TextView
    private lateinit var statusTextCase: TextView
    private lateinit var statusTextRight: TextView
    private lateinit var statusBudLeft: ImageView
    private lateinit var statusBudRight: ImageView
    private lateinit var statusSegOff: TextView
    private lateinit var statusSegTrans: TextView
    private lateinit var statusSegLow: TextView
    private lateinit var statusSegMed: TextView
    private lateinit var statusSegHigh: TextView
    private lateinit var statusGameRow: LinearLayout
    private lateinit var statusGameSwitch: TextView

    /** Last state rendered into the panel, so we don't redo work on every notify. */
    private var lastRendered: WidgetStateStore.State? = null

    private val TARGET_MAC = "A8:E6:E8:92:C1:25"
    private val REQUEST_PERMISSIONS = 1001

    private val THEME_OLED = 0
    private val THEME_DARK = 1
    private val THEME_LIGHT = 2
    private var currentTheme = THEME_OLED

    private val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.US)

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
            appendStatus("Sync -> $activeAncMode (game=$gameModeOn)")
        }
        lastRendered = state
        renderStatusPanel(state)
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
        btnSettings = findViewById<Button>(R.id.btnSettings)
        btnDevTools = findViewById<Button>(R.id.btnDevTools)

        // In-app status panel (widget-mirroring visuals)
        statusRowLeft = findViewById<LinearLayout>(R.id.status_row_left)
        statusRowCase = findViewById<LinearLayout>(R.id.status_row_case)
        statusRowRight = findViewById<LinearLayout>(R.id.status_row_right)
        statusBarLeft = findViewById<ProgressBar>(R.id.status_bar_left)
        statusBarCase = findViewById<ProgressBar>(R.id.status_bar_case)
        statusBarRight = findViewById<ProgressBar>(R.id.status_bar_right)
        statusTextLeft = findViewById<TextView>(R.id.status_text_left)
        statusTextCase = findViewById<TextView>(R.id.status_text_case)
        statusTextRight = findViewById<TextView>(R.id.status_text_right)
        statusBudLeft = findViewById<ImageView>(R.id.status_bud_left)
        statusBudRight = findViewById<ImageView>(R.id.status_bud_right)
        statusSegOff = findViewById<TextView>(R.id.status_seg_off)
        statusSegTrans = findViewById<TextView>(R.id.status_seg_trans)
        statusSegLow = findViewById<TextView>(R.id.status_seg_low)
        statusSegMed = findViewById<TextView>(R.id.status_seg_med)
        statusSegHigh = findViewById<TextView>(R.id.status_seg_high)
        statusGameRow = findViewById<LinearLayout>(R.id.status_game_row)
        statusGameSwitch = findViewById<TextView>(R.id.status_game_switch)

        WidgetStateStore.addListener(storeListener)
        val initial = WidgetStateStore.read(this)
        activeAncMode = initial.ancMode
        gameModeOn = initial.gameMode

        val prefs = getSharedPreferences("BudsQSPrefs", Context.MODE_PRIVATE)
        currentTheme = prefs.getInt("theme", THEME_OLED)
        applyTheme(currentTheme)

        btnSettings.setOnClickListener { showSettingsDialog() }
        btnDevTools.setOnClickListener {
            startActivity(Intent(this, DevToolsActivity::class.java))
        }

        // --- Status panel tap handlers (same commands the widget fires) ---
        statusSegOff.setOnClickListener { selectAnc("Off") }
        statusSegTrans.setOnClickListener { selectAnc("Transparency") }
        statusSegLow.setOnClickListener { selectAnc("ANC-Light") }
        statusSegMed.setOnClickListener { selectAnc("ANC-Medium") }
        statusSegHigh.setOnClickListener { selectAnc("ANC-Deep") }
        statusGameRow.setOnClickListener { toggleGameMode() }

        renderStatusPanel(WidgetStateStore.read(this))
        checkPermissions()
    }

    override fun onDestroy() {
        WidgetStateStore.removeListener(storeListener)
        super.onDestroy()
    }

    /** Applies an ANC mode: sends the command, updates state, repaints panel + widget. */
    private fun selectAnc(mode: String) {
        when (mode) {
            "Off" -> manager.sendAncOff()
            "Transparency" -> manager.sendAncTransparency()
            "ANC-Light" -> manager.sendAncLight()
            "ANC-Medium" -> manager.sendAncMedium()
            "ANC-Deep" -> manager.sendAncDeep()
            "ANC-Smart" -> manager.sendAncSmart()
        }
        activeAncMode = mode
        appendStatus("ANC -> ${ancLabel(mode)}")
        syncWidgetState()
        renderStatusPanel(WidgetStateStore.read(this))
    }

    private fun toggleGameMode() {
        val next = !gameModeOn
        manager.setGameMode(next)
        gameModeOn = next
        appendStatus("Game Mode ${if (next) "ON" else "OFF"}")
        syncWidgetState()
        renderStatusPanel(WidgetStateStore.read(this))
    }

    /** "ANC-Deep" -> "Deep", "Transparency" -> "Transparency" */
    private fun ancLabel(mode: String): String =
        if (mode.startsWith("ANC-")) mode.substring(4) else mode

    private fun syncWidgetState() {
        val state = WidgetStateStore.read(this)
        state.ancMode = activeAncMode
        state.gameMode = gameModeOn
        WidgetStateStore.write(this, state)
        AncWidgetProvider.refreshAll(this)
    }

    /**
     * Renders the in-app status panel from a WidgetStateStore snapshot.
     *
     * Uses the same icon rule as AncWidgetProvider.budStyle():
     *   status 4/0 = in case  -> icon hidden
     *   status 3/7 = in ear   -> icon tinted white (primary)
     *   otherwise  = out idle -> icon tinted grey (secondary)
     */
    private fun renderStatusPanel(state: WidgetStateStore.State) {
        runOnUiThread {
            statusBarLeft.progress = state.leftProgress()
            statusBarCase.progress = state.caseProgress()
            statusBarRight.progress = state.rightProgress()

            statusTextLeft.text = state.leftText()
            statusTextCase.text = state.caseText()
            statusTextRight.text = state.rightText()

            statusRowLeft.visibility = if (state.hasLeft()) View.VISIBLE else View.INVISIBLE
            statusRowCase.visibility = if (state.hasCase()) View.VISIBLE else View.INVISIBLE
            statusRowRight.visibility = if (state.hasRight()) View.VISIBLE else View.INVISIBLE

            applyBudIcon(statusBudLeft, R.drawable.ic_bud_left, state.leftStatus)
            applyBudIcon(statusBudRight, R.drawable.ic_bud_right, state.rightStatus)

            setSegment(statusSegOff, state.offIsActive())
            setSegment(statusSegTrans, state.transIsActive())
            setSegment(statusSegLow, state.lowIsActive())
            setSegment(statusSegMed, state.medIsActive())
            setSegment(statusSegHigh, state.highIsActive())

            statusGameSwitch.text = if (state.gameMode) "ON" else "OFF"
            statusGameSwitch.setBackgroundResource(
                if (state.gameMode) R.drawable.widget_button_bg_active
                else R.drawable.widget_button_bg
            )
        }
    }

    private fun applyBudIcon(view: ImageView, resId: Int, status: Int) {
        when (status) {
            4, 0 -> view.visibility = View.INVISIBLE
            else -> {
                view.visibility = View.VISIBLE
                val color = if (status == 3 || status == 7) {
                    getColor(R.color.widget_text_primary)
                } else {
                    getColor(R.color.widget_text_secondary)
                }
                view.setImageBitmap(WidgetIcons.tinted(this, resId, color))
            }
        }
    }

    private fun setSegment(view: TextView, active: Boolean) {
        view.setBackgroundResource(
            if (active) R.drawable.widget_segment_bg_active
            else R.drawable.widget_segment_bg
        )
        view.setTextColor(if (active) 0xFF000000.toInt() else 0xFF8A8A8A.toInt())
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

        // Recolor header buttons/labels, but leave the status panel alone —
        // it uses the widget's own fixed palette on its own card backgrounds.
        for (i in 0 until mainLayout.childCount) {
            val child = mainLayout.getChildAt(i)
            if (child.id == R.id.statusPanel) continue
            applyColorsToViews(child, textColor, inactiveBtnColor)
        }

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
                // Follow the log only when the user is already at the bottom,
                // so scrolling back through history isn't yanked away.
                val wasAtBottom = !scroll.canScrollVertically(1)
                statusText.append("\n[$ts] $msg")
                if (wasAtBottom) {
                    scroll.post { scroll.fullScroll(ScrollView.FOCUS_DOWN) }
                }
            } catch (_: Exception) {}
        }
    }
}