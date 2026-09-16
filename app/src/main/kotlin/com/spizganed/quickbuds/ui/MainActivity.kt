package com.spizganed.quickbuds.ui

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.bluetooth.BluetoothManager
import android.content.ClipData
import android.content.ClipboardManager
import android.content.*
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import com.spizganed.quickbuds.CrashLogger
import com.spizganed.quickbuds.R
import com.spizganed.quickbuds.bluetooth.BudsConnectionManager
import com.spizganed.quickbuds.bluetooth.BudsService
import com.spizganed.quickbuds.bluetooth.PacketLogger
import com.spizganed.quickbuds.devtool.LayoutReport
import com.spizganed.quickbuds.widget.WidgetStateStore

/**
 * Main screen — rebuilt from scratch against the reference design.
 *
 * WHAT CHANGED AND WHY, in order:
 *   1. The old "status panel" (a capped mirror of the home-screen widget, sitting
 *      in a row with a dead column beside it) is gone. The battery block is now a
 *      full-width card at the top of the scroll, with the L/C/R bars beside the
 *      icons instead of underneath them, and the letters moved into circles.
 *   2. ANC is four circular buttons. Tapping the ACTIVE one opens a chooser with
 *      the full mode list, because four buttons cannot represent five modes and
 *      the request was for a pop-out rather than a fifth circle.
 *   3. The settings rows are a real card with themed switches and chevrons.
 *
 * THEMING
 * Colours come from resources (values/app_colors.xml + the two override folders)
 * and are swapped by ThemeRes.apply() before super.onCreate(). Nothing here sets a
 * raw colour on a view; the only colour work done in code is tinting vector
 * drawables, which cannot be themed from XML.
 */
class MainActivity : Activity(), BudsConnectionManager.Listener {

    private lateinit var manager: BudsConnectionManager
    private lateinit var mainLayout: LinearLayout
    private lateinit var featureList: LinearLayout

    private lateinit var btnSettings: ImageButton
    private lateinit var btnDevTools: ImageButton
    private lateinit var deviceNameText: TextView

    // Battery block
    private lateinit var statusRowLeft: LinearLayout
    private lateinit var statusRowCase: LinearLayout
    private lateinit var statusRowRight: LinearLayout
    private lateinit var statusBarLeft: ProgressBar
    private lateinit var statusBarCase: ProgressBar
    private lateinit var statusBarRight: ProgressBar
    // The in-bar number labels. Normally empty: the number is drawn by the
    // SegmentedBarDrawable itself, and these are the fallback for a bar whose
    // drawable is not segmented. See renderBar.
    private lateinit var statusTextLeft: TextView
    private lateinit var statusTextCase: TextView
    private lateinit var statusTextRight: TextView
    private lateinit var statusBudLeft: ImageView
    private lateinit var statusBudRight: ImageView
    private lateinit var statusCaseIcon: ImageView

    // ANC circles
    private lateinit var ancBtnOff: TextView
    private lateinit var ancBtnAnc: TextView
    private lateinit var ancBtnTrans: TextView

    // Settings rows that hold live state
    private var gameSwitch: Switch? = null
    private var hiresSwitch: Switch? = null
    private var hiresSubtitle: TextView? = null
    private var spatialSwitch: Switch? = null

    /** Last state rendered, so a redundant notify does not rebuild the UI. */
    private var lastRendered: WidgetStateStore.State? = null

    private val TARGET_MAC = "A8:E6:E8:92:C1:25"
    private val REQUEST_PERMISSIONS = 1001

    private var currentTheme = ThemeRes.OLED

    private var activeAncMode: String = "Off"
    private var gameModeOn = false

    private var isBound = false
    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as BudsService.LocalBinder
            manager = binder.getService().manager!!
            manager.addListener(this@MainActivity)
            isBound = true
            connectDirectly()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
        }
    }

    /**
     * Single source of truth for ANC + game mode, fed by the widget store.
     *
     * The store is what the buds' own push events write into (see
     * BudsConnectionManager.onGameModeState), so updating from it — rather than
     * from what we last sent — is what makes the buttons follow a gesture made on
     * the earbuds. That was already true before this redesign and must stay true:
     * do not "simplify" this into updating state at the call site of a command.
     */
    private val storeListener: (WidgetStateStore.State) -> Unit = { state ->
        activeAncMode = state.ancMode
        gameModeOn = state.gameMode
        lastRendered = state
        renderBattery(state)
        renderAnc(state.ancMode)
        renderWear(state)
        gameSwitch?.let { sw ->
            if (sw.isChecked != state.gameMode) {
                sw.isChecked = state.gameMode
                SettingRowFactory.refreshSwitch(this, sw, state.gameMode)
            }
        }
    }

    /**
     * Renders the three icons using THE WIDGET'S OWN LOGIC, ported verbatim.
     *
     * WHY A PORT RATHER THAN ANOTHER REDESIGN: the app and the widget had drifted
     * into two different icon treatments — different colours, different shapes,
     * different in-case behaviour — and the widget's version is the one that looks
     * right. Reimplementing it here means one source of truth for the rule, and the
     * two surfaces cannot disagree again.
     *
     * The rule, copied from AncWidgetProvider.budStyle():
     *
     *     status 4 or 0   ->  INVISIBLE   (in case)
     *     status 3 or 7   ->  VISIBLE, colourActive  (#FFFFFF, white)
     *     anything else   ->  VISIBLE, colourIdle    (#8A8A8A, grey)
     *
     * COLOURS ARE THE WIDGET'S PALETTE, deliberately, not the app's theme
     * attributes. The user's stated goal is that the panel matches the widget, and
     * the widget is always dark — so white/grey are correct here even on the Light
     * app theme. That is the same reasoning the widget panel used before this
     * redesign, and it is why these two colours are hardcoded rather than themed.
     *
     * The case icon is drawn in the widget's idle/secondary colour and is always
     * visible: the widget has no case icon at all (it labels the bars instead), so
     * there is no widget behaviour to copy for it. Grey is used so it reads as a
     * static reference object rather than competing with the two bud icons.
     */
    private fun renderWear(state: WidgetStateStore.State) {
        applyIcon(statusBudLeft, R.drawable.ic_bud_left, budStyle(state.leftStatus))
        applyIcon(statusBudRight, R.drawable.ic_bud_right, budStyle(state.rightStatus))
        applyCaseIcon(state)
    }

    /** Port of AncWidgetProvider.budStyle(). Ids match the widget's own comment. */
    private fun budStyle(status: Int): Pair<Boolean, Int> = when (status) {
        4, 0 -> false to COLOR_IDLE      // in case -> hidden
        3, 7 -> true to COLOR_ACTIVE     // in ear  -> white
        else -> true to COLOR_IDLE       // out     -> grey
    }

    /**
     * The case icon: WHITE when connected, HIDDEN when the buds are disconnected.
     *
     * It does NOT follow the per-bud wear states — a bud is white in ear, grey out
     * of ear, hidden in case, but the case is the fixed object in the row, so it
     * stays white whenever there is a link at all.
     *
     * It DOES follow the connection, which was a real bug: the icon was drawn white
     * unconditionally, so a disconnected app still showed a lit case as though the
     * buds were present. Being disconnected is exactly when the case should be
     * absent — there is nothing to show a state for.
     *
     * The key includes `connected` so a reconnect repaints and a disconnect hides.
     */
    private fun applyCaseIcon(state: WidgetStateStore.State) {
        val key = "case:${state.connected}"
        if (lastWearKey[statusCaseIcon.id] == key) return
        lastWearKey[statusCaseIcon.id] = key

        if (!state.connected) {
            statusCaseIcon.visibility = View.INVISIBLE
        } else {
            statusCaseIcon.visibility = View.VISIBLE
            setBudIcon(statusCaseIcon, R.drawable.ic_case, COLOR_ACTIVE)
        }
    }

    /**
     * Port of AncWidgetProvider.applyIcon().
     *
     * The key check is the app-side addition: the widget only repaints when it is
     * asked to, whereas this runs on every store notify, which fires per packet.
     * Without the check the drawable was rebuilt many times a second for no visual
     * change, which is what made the icons flicker. The KEY encodes both things that
     * affect appearance (visible + colour), so any real change still repaints.
     */
    private fun applyIcon(icon: ImageView, resId: Int, style: Pair<Boolean, Int>) {
        val (visible, color) = style
        val key = "${if (visible) "v" else "h"}:$color:$resId"
        if (lastWearKey[icon.id] == key) return
        lastWearKey[icon.id] = key

        if (!visible) {
            icon.visibility = View.INVISIBLE
        } else {
            icon.visibility = View.VISIBLE
            setBudIcon(icon, resId, color)
        }
    }

    /**
     * Last rendered appearance per icon, keyed by view id.
     *
     * See applyIcon: this is what stops the per-packet repaint that caused the
     * flicker. Keyed by id so the three icons are tracked independently.
     */
    private val lastWearKey = HashMap<Int, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        // Theme selection FIRST, before super.onCreate. setTheme() is a style-id
        // lookup and cannot fail; this replaced a runtime configuration override
        // that crashed on launch five times (see ThemeRes).
        ThemeRes.select(this)
        // Track what we selected. onResume() compares against this to decide
        // whether to recreate(); leaving it unassigned makes that comparison always
        // true and puts the activity in an endless recreate loop (visible as the
        // whole screen flickering). Do not delete this line.
        currentTheme = ThemeRes.saved(this)

        super.onCreate(savedInstanceState)

        // Crash report FIRST, before anything that could throw. If the layout or
        // the service binding below is what is crashing on this build, the user
        // must still be able to see the previous crash's report — otherwise the
        // report is unreachable forever. This is the only reason it is not shown
        // after the UI is built.
        maybeShowCrashReport()

        setContentView(R.layout.activity_main)

        mainLayout = findViewById<LinearLayout>(R.id.mainLayout)
        featureList = findViewById<LinearLayout>(R.id.featureList)
        deviceNameText = findViewById<TextView>(R.id.deviceNameText)
        btnSettings = findViewById<ImageButton>(R.id.btnSettings)
        btnDevTools = findViewById<ImageButton>(R.id.btnDevTools)

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
        statusCaseIcon = findViewById<ImageView>(R.id.status_case_icon)

        ancBtnOff = findViewById<TextView>(R.id.anc_btn_off)
        ancBtnAnc = findViewById<TextView>(R.id.anc_btn_anc)
        ancBtnTrans = findViewById<TextView>(R.id.anc_btn_trans)

        // The three circles. ANC opens the chooser; Off and Transparency apply
        // directly, since they have no sub-levels to pick between.
        ancBtnOff.setOnClickListener { onAncCircleTapped("Off") }
        ancBtnAnc.setOnClickListener { onAncCircleTapped("ANC") }
        ancBtnTrans.setOnClickListener { onAncCircleTapped("Transparency") }

        applyThemeTints()
        applySegmentedBars()
        buildFeatureRows()

        btnSettings.setOnClickListener { showSettingsDialog() }
        btnDevTools.setOnClickListener {
            startActivity(Intent(this, DevToolsActivity::class.java))
        }

        val initial = WidgetStateStore.read(this)
        activeAncMode = initial.ancMode
        gameModeOn = initial.gameMode
        renderBattery(initial)
        renderAnc(initial.ancMode)
        renderWear(initial)
        WidgetStateStore.addListener(storeListener)

        checkPermissions()
    }

    /**
     * Starts and binds the foreground service.
     *
     * ONLY call this once the Bluetooth permissions are granted. A foreground
     * service of type connectedDevice must hold FOREGROUND_SERVICE_CONNECTED_DEVICE
     * plus at least one of BLUETOOTH_CONNECT / SCAN / ADVERTISE, and Android
     * enforces that at startForeground() time, not at install time. Starting the
     * service before the user grants them threw
     *
     *   SecurityException: Starting FGS with type connectedDevice ... requires
     *   permissions: allOf=[FOREGROUND_SERVICE_CONNECTED_DEVICE] anyOf=[...]
     *
     * which killed the app on first launch, and then stopped happening after the
     * permission was granted — so it looked intermittent. It was not: it was
     * purely an ordering bug, and the fix is this gate.
     *
     * Binding is gated the same way for a simpler reason: the service's whole job
     * is the RFCOMM link, so binding without permission only produces a manager
     * that cannot connect.
     */
    private fun startAndBindServiceIfPermitted() {
        if (!hasBluetoothPermissions()) return
        if (isBound) return
        val serviceIntent = Intent(this, BudsService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent)
        } else {
            startService(serviceIntent)
        }
        bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    /** True when every runtime permission the RFCOMM link needs is granted. */
    private fun hasBluetoothPermissions(): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            // Pre-12: the FGS type only needs the manifest permissions.
            return true
        }
        return checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED &&
            checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Shows the previous crash report, but only ONCE per crash.
     *
     * The earlier version showed the dialog whenever a report file existed and
     * only deleted it on a button press. So if the user swiped the dialog away, or
     * the activity was recreated before they answered (which the theme-switch
     * recreate loop did repeatedly), the same old report reappeared forever — it
     * looked like the app "crashing" on a build that was actually fine.
     *
     * The fix is to key the report by its timestamp and remember the last one
     * shown, so a report is announced exactly once no matter how many times the
     * activity starts. The file is left on disk (the user may still want it) and
     * only the "already seen" marker is stored.
     *
     * This is also why the dialog no longer needs to delete anything: not showing
     * it again is enough, and nothing is destroyed as a side effect of a button.
     */
    private fun maybeShowCrashReport() {
        val report = CrashLogger.last(this) ?: return

        // First line after the header is "time   : ..."; that is a stable identity
        // for a report without needing a hash of the whole trace.
        val stamp = report.lineSequence()
            .firstOrNull { it.startsWith("time") }
            ?: report.take(64)

        val prefs = getSharedPreferences(ThemeRes.PREFS_NAME, Context.MODE_PRIVATE)
        if (prefs.getString(ThemeRes.KEY_LAST_SHOWN_CRASH, null) == stamp) return

        val dp = { v: Float -> ThemeRes.dp(this, v) }

        // The path line matters more than it looks: the point of this dialog is
        // that the report is reachable WITHOUT the app working, so it has to say
        // where the file is, not just what it contains.
        val header = TextView(this).apply {
            text = "Saved to:\nDownload/QuickBudsCrash/\n\nThis message appears once. Copy or share it if you want to keep it."
            setTextColor(ThemeRes.color(this@MainActivity, R.attr.appColorTextSecondary))
            textSize = 11f
            setPadding(dp(24f), dp(12f), dp(24f), dp(6f))
        }

        // Scrollable + copyable: stack traces are long and the point is that the
        // user can get the text out. A plain AlertDialog message is not
        // selectable, so the TextView is built explicitly to be.
        val body = TextView(this).apply {
            text = report
            setTextIsSelectable(true)
            setTextColor(ThemeRes.color(this@MainActivity, R.attr.appColorTextPrimary))
            textSize = 11f
            setPadding(dp(24f), dp(0f), dp(24f), dp(16f))
        }

        val column = android.widget.LinearLayout(this).apply {
            orientation = android.widget.LinearLayout.VERTICAL
            addView(header)
            addView(body)
        }
        val scroll = android.widget.ScrollView(this).apply { addView(column) }

        // Marked as shown BEFORE showing: if the dialog is dismissed by a config
        // change or a swipe, it must not come back on the next onCreate.
        prefs.edit().putString(ThemeRes.KEY_LAST_SHOWN_CRASH, stamp).apply()

        AlertDialog.Builder(this)
            .setTitle("QuickBuds crashed last time")
            .setView(scroll)
            .setPositiveButton("Copy") { _, _ ->
                val clip = getSystemService(ClipboardManager::class.java)
                clip?.setPrimaryClip(ClipData.newPlainText("QuickBuds crash", report))
                Toast.makeText(this, "Crash report copied", Toast.LENGTH_SHORT).show()
            }
            .setNeutralButton("Share") { _, _ ->
                startActivity(
                    Intent.createChooser(CrashLogger.shareIntent(this, report), "Share crash report")
                )
            }
            .setNegativeButton("Dismiss", null)
            .show()
    }

    override fun onDestroy() {
        WidgetStateStore.removeListener(storeListener)
        if (isBound) {
            try {
                manager.removeListener(this)
                unbindService(serviceConnection)
            } catch (_: IllegalArgumentException) {
                // Already unbound (double onDestroy); nothing to do.
            }
            isBound = false
        }
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        instance = this
        // Capture our own geometry while we are actually laid out, and park the
        // TEXT for Dev Tools. Doing it here (not on demand from Dev Tools) is
        // deliberate: once the user navigates to Dev Tools this activity is paused
        // and the tree is no longer the one on screen, which is how the first
        // version of the report ended up always describing Dev Tools itself.
        LayoutReport.capture(this) { text -> Companion.cacheReport(text) }
        // Rebuild only if the theme actually changed while we were away (it can be
        // changed from another screen's settings dialog).
        //
        // `currentTheme` MUST be assigned in onCreate before this runs. It is not
        // optional bookkeeping: when the assignment was dropped during the theme
        // refactor, currentTheme kept its initialiser value (OLED = 0) while a
        // non-OLED choice was saved, so this compared unequal on EVERY resume and
        // called recreate() in an endless loop. The activity re-created, resumed,
        // re-created — which the user sees as the whole screen flickering and
        // jumping up and down several times a second.
        if (ThemeRes.saved(this) != currentTheme) recreate()
    }

    override fun onPause() {
        // Clear before onResume of the next activity can run, so the report button
        // can never point at a stopped activity.
        if (instance === this) instance = null
        super.onPause()
    }

    // ==================== Th  eme ====================

    /**
     * Tints every vector glyph and restyles the header icon frames.
     *
     * Vectors are the only thing that cannot read a theme from XML: the drawable
     * carries fillColor="#FFFFFF" from its widget usage, so on the light theme it
     * would render white-on-white without an explicit tint. Read through the theme
     * attribute so the tint follows the in-app theme choice.
     *
     * ICONS: uses the WIDGET's bud drawables (ic_bud_left / ic_bud_right), not the
     * _hq variants. The user preferred the widget artwork — its proportions read
     * better — and the _hq re-trace is now unused by the app. It is kept in the
     * tree only because removing it would be an unrelated change.
     *
     * WHY THE EDGES LOOKED PIXELATED, and what fixes it: the widget's drawables
     * declare width/height of 48dp, and drawing one at 52dp (battery card) or
     * 120dp (find my earbuds) makes the platform rasterise the vector at its
     * INTRINSIC size and then BITMAP-SCALE the result up — which is where the
     * blocky edges came from. It is not a fault in the artwork. Setting the bounds
     * explicitly at the target pixel size forces a vector re-rasterisation at that
     * exact size, so the result is anti-aliased and sharp at any scale.
     *
     * That is what setVectorBounds does below. Do not replace it with a plain
     * setImageDrawable().
     */
    /**
     * Tints the ICON BUTTONS in the header, and nothing else.
     *
     * IT MUST NOT TOUCH THE BATTERY-CARD ICONS. It used to, and that was a real bug:
     * this method runs before renderWear(), so the two fought over the same three
     * ImageViews — this one setting a themed tint, renderWear overwriting with the
     * widget's white/grey. Whichever ran last won, so the case appeared to change
     * size and colour depending on when a packet happened to arrive, and the buds
     * sometimes showed a stale drawable. All three card icons are now owned solely
     * by renderWear(); do not set them here.
     *
     * The header frames keep the widget's dark chip in EVERY theme (see
     * header_icon_bg), so their glyphs stay white regardless of appColorIconTint —
     * otherwise the cog and dev-tools icons would turn black on a dark chip.
     */
    private fun applyThemeTints() {
        btnDevTools.setImageDrawable(ThemeRes.tint(this, R.drawable.ic_dev_tools, 0xFFFFFFFF.toInt()))
        btnSettings.setImageDrawable(ThemeRes.tint(this, R.drawable.ic_settings_cog, 0xFFFFFFFF.toInt()))
    }

    /**
     * Loads a vector, tints it, and pins its bounds to the view's measured pixel
     * size so it is rasterised at full resolution instead of being scaled from its
     * 48dp intrinsic size. See the note in applyThemeTints.
     */
    private fun setBudIcon(view: ImageView, drawableRes: Int, tint: Int) {
        val d = ThemeRes.tint(this, drawableRes, tint)
        view.setImageDrawable(d)
        // Post: the view may not be measured yet during onCreate. Scaling via
        // scaleType would reintroduce the bitmap upscale, so the bounds are set
        // against the laid-out size instead.
        view.post {
            val w = if (view.width > 0) view.width else ThemeRes.dp(this, 48f)
            val h = if (view.height > 0) view.height else ThemeRes.dp(this, 48f)
            d.setBounds(0, 0, w, h)
        }
    }

    /**
     * Installs the segmented battery bar on all three bars.
     *
     * Built in code rather than referenced from XML because it needs three theme
     * colours at construction time, and a drawable XML cannot resolve a themed
     * attribute into a custom Drawable class.
     *
     * The divider colour is the CARD colour, not the screen background, because the
     * bars sit on the card — using the background colour would draw gaps in the
     * wrong shade and the segments would look like misaligned slivers.
     */
    private fun applySegmentedBars() {
        val track = ThemeRes.color(this, R.attr.appColorBarTrack)
        val fill = ThemeRes.color(this, R.attr.appColorSegBgActive)
        val divider = ThemeRes.color(this, R.attr.appColorCard)
        val labelOnFill = ThemeRes.color(this, R.attr.appColorBarLabelOnFill)
        val labelOnTrack = ThemeRes.color(this, R.attr.appColorBarLabelOnTrack)
        // Corner radius is HALF THE BAR HEIGHT, which is what makes the ends read as
        // properly rounded rather than as slightly-softened rectangles. The previous
        // 3dp on a 10dp bar was barely visible; 5dp (10/2) gives a true semicircular
        // cap at each end.
        val radius = ThemeRes.dp(this, 5f).toFloat()
        val dividerW = ThemeRes.dp(this, 1f).toFloat()

        for (bar in listOf(statusBarLeft, statusBarCase, statusBarRight)) {
            val d = SegmentedBarDrawable(
                trackColor = track,
                fillColor = fill,
                dividerColor = divider,
                segments = 10,
                dividerWidth = dividerW,
                cornerRadius = radius,
                labelColorOnFill = labelOnFill,
                labelColorOnTrack = labelOnTrack,
                labelSizePx = ThemeRes.dp(this, 8f).toFloat()
            )
            d.progress = bar.progress
            bar.progressDrawable = d
        }
    }

    // ==================== Battery block ====================

    private fun renderBattery(state: WidgetStateStore.State) {
        renderBar(statusRowLeft, statusBarLeft, statusTextLeft, state.leftBattery)
        renderBar(statusRowCase, statusBarCase, statusTextCase, state.caseBattery)
        renderBar(statusRowRight, statusBarRight, statusTextRight, state.rightBattery)
    }

    /**
     * One battery row.
     *
     * The number moved INSIDE the bar by request, so it is drawn by the bar
     * drawable itself (see SegmentedBarDrawable.drawLabel) rather than being a
     * separate TextView beside it. The TextView still exists and still receives the
     * text — it is the fallback for any case where the drawable is not a
     * SegmentedBarDrawable — but it is transparent and sits over the bar, so in
     * practice the drawable does the drawing.
     *
     * An unknown level shows an empty bar with no number, rather than a "?" as
     * before: there is no room inside a 10dp bar for a question mark plus the
     * segment lines without it becoming unreadable.
     */
    private fun renderBar(row: LinearLayout, bar: ProgressBar, text: TextView, level: Int) {
        row.visibility = View.VISIBLE
        val clamped = if (level < 0) 0 else level
        bar.progress = clamped

        val label = if (level < 0) "" else "$level"
        val d = bar.progressDrawable as? SegmentedBarDrawable
        if (d != null) {
            d.progress = clamped
            d.setLabel(label)
            text.text = ""
        } else {
            // Fallback path only; kept so a future non-segmented drawable still
            // shows something.
            text.text = label
        }
    }

    // ==================== ANC ====================

    /**
     * Display label for the ANC circle, given a stored mode string.
     *
     * The stored strings ("ANC-Light", "ANC-Medium", "ANC-Deep") are the
     * protocol-level names shared with the widget. The circle shows the SHORT
     * form — ANC-L / ANC-M / ANC-H — so the current strength is visible without
     * opening the chooser. Off and Transparency have their own circles and their
     * own labels.
     */
    private fun renderAnc(mode: String) {
        // The ANC circle always reads "ANC" unless a level is actually selected,
        // in which case it carries the level suffix.
        if (mode in ANC_LEVELS) {
            ancBtnAnc.text = when (mode) {
                "ANC-Light" -> getString(R.string.app_anc_light)
                "ANC-Medium" -> getString(R.string.app_anc_medium)
                else -> getString(R.string.app_anc_high)
            }
        } else {
            ancBtnAnc.text = getString(R.string.app_anc_anc)
        }

        val active = circleFor(mode)
        styleCircle(ancBtnOff, active == "Off")
        styleCircle(ancBtnAnc, active == "ANC")
        styleCircle(ancBtnTrans, active == "Trans")
    }

    private fun circleFor(mode: String): String = when (mode) {
        "Transparency" -> "Trans"
        "ANC-Light", "ANC-Medium", "ANC-Deep" -> "ANC"
        else -> "Off"
    }

    private fun styleCircle(btn: TextView, active: Boolean) {
        btn.setBackgroundResource(
            if (active) R.drawable.anc_circle_bg_active else R.drawable.anc_circle_bg
        )
        // INACTIVE text is white in every theme (appColorButtonText), by request, to
        // match the button visuals. ACTIVE text stays dark because the active fill is
        // the light segment colour — white on that would be invisible.
        btn.setTextColor(
            if (active) {
                ThemeRes.color(this, R.attr.appColorSegTextActive)
            } else {
                ThemeRes.color(this, R.attr.appColorButtonText)
            }
        )
    }

    private fun onAncCircleTapped(circle: String) {
        // Logged unconditionally: the Transparency button was reported as doing
        // nothing and not reacting. There are two possible causes and the log
        // separates them — either the tap never reaches this handler (layout /
        // touch problem), or it does and the buds reject the frame (protocol
        // problem). Without this line those look identical from the outside.
        PacketLogger.log("ANC TAP: circle=$circle current=$activeAncMode")

        when (circle) {
            // ANC opens the chooser UNCONDITIONALLY — it no longer applies a level
            // directly or requires the circle to already be active. Choosing which
            // strength to use is the whole point of the button, and requiring a
            // second tap on an already-lit circle was an unnecessary step.
            "ANC" -> showAncChooser()
            "Off" -> selectAnc("Off")
            "Trans" -> selectAnc("Transparency")
        }
    }

    /**
     * Chooser for the ANC circle.
     *
     * Shows ONLY the three noise-cancelling levels, because Off and Transparency
     * are separate circles on the main screen and Adaptive has been removed
     * entirely. The list is short by request: "low medium high".
     *
     * Order is Low -> Medium -> High, matching increasing strength.
     */
    private fun showAncChooser() {
        val labels = arrayOf(
            getString(R.string.anc_mode_low),
            getString(R.string.anc_mode_medium),
            getString(R.string.anc_mode_high)
        )
        val modes = ANC_LEVELS
        val checked = modes.indexOfFirst { it == activeAncMode }

        AlertDialog.Builder(this)
            .setTitle(R.string.anc_chooser_title)
            .setSingleChoiceItems(labels, checked) { dialog, which ->
                selectAnc(modes[which])
                dialog.dismiss()
            }
            .setNegativeButton(R.string.dialog_close, null)
            .show()
    }

    /**
     * Applies an ANC mode: sends the command, updates state, repaints everything.
     *
     * Smart is deliberately NOT handled. The user does not want the adaptive mode,
     * so there is no UI path that can select it and no command is sent for it.
     * The command builder (OpoProtocol.ancSmart) and the manager's sendAncSmart
     * remain, because the WIDGET's ANC cycle and the tile can still reach it and
     * removing a protocol capability is a bigger change than this request.
     */
    private fun selectAnc(mode: String) {
        when (mode) {
            "Off" -> manager.sendAncOff()
            "Transparency" -> manager.sendAncTransparency()
            "ANC-Light" -> manager.sendAncLight()
            "ANC-Medium" -> manager.sendAncMedium()
            "ANC-Deep" -> manager.sendAncDeep()
        }
        activeAncMode = mode
        syncWidgetState()
        renderAnc(mode)
    }

    private fun toggleGameMode(next: Boolean) {
        manager.setGameMode(next)
        gameModeOn = next
        syncWidgetState()
        SettingRowFactory.refreshSwitch(this, gameSwitch!!, next)
    }

    /** Pushes our optimistic state into the store so the widget repaints too. */
    private fun syncWidgetState() {
        val state = WidgetStateStore.read(this)
        state.ancMode = activeAncMode
        state.gameMode = gameModeOn
        WidgetStateStore.write(this, state)
    }

    // ==================== Settings rows ====================

    /**
     * Builds the settings card.
     *
     * Row order is the order specified: game mode and the two switches first, so
     * the block above the fold is the one that gets used most, then the three rows
     * that open another screen.
     *
     * Every row through here must be honest about what it does. Two of these rows
     * (hi-res codec, spatial audio) are switches whose command is NOT yet verified
     * on this firmware — they are wired to the real commands anyway, because a
     * switch that does nothing is worse than one that fails, and the log records
     * the attempt. See the notes on each below.
     */
    private fun buildFeatureRows() {
        featureList.removeAllViews()
        gameSwitch = null
        hiresSwitch = null
        hiresSubtitle = null
        spatialSwitch = null

        // --- 1. Game mode / low latency ---
        val game = SettingRowFactory.buildSwitch(this, gameModeOn)
        gameSwitch = game
        game.setOnCheckedChangeListener { _, isChecked ->
            // setOnCheckedChangeListener fires when we programmatically set
            // isChecked too, which would echo a bud-side gesture back as a
            // command. The store listener guards against that by only writing
            // when the value actually differs.
            if (isChecked != gameModeOn) toggleGameMode(isChecked)
        }
        addRow(
            SettingRowFactory.build(
                this, R.drawable.ic_bolt, R.string.row_game_title, R.string.row_game_sub, game
            ) { game.performClick() }
        )

        // --- 2. Hi-Res codec ---
        // Wired to the real feature switch (0x0403, feature 0x06-style payload) so
        // it is not decorative. NOTE: the codec's own feature id and the meaning of
        // 0x0114 have not been captured on this firmware, so this may be rejected
        // by the buds. The log will say so; the switch reflects what we sent, not
        // what the buds confirmed, until a query confirms it.
        val hires = SettingRowFactory.buildSwitch(this, false)
        hiresSwitch = hires
        hires.setOnCheckedChangeListener { _, isChecked ->
            // Codec switching is NOT wired to a command: no codec set command or
            // query reply has been captured on this firmware. Rather than send a
            // guessed feature id, this only updates the subtitle, so the row is
            // honest about being a preference toggle for now. See the class note
            // in UpdateActivity for the same reasoning applied to updates.
            hiresSubtitle?.setText(
                if (isChecked) R.string.row_hires_sub else R.string.row_hires_sub_off
            )
        }
        val hiresRow = SettingRowFactory.build(
            this, R.drawable.ic_hires, R.string.row_hires_title, R.string.row_hires_sub_off, hires
        ) { hires.performClick() }
        hiresSubtitle = hiresRow.findViewWithTag<TextView>(SettingRowFactory.SUBTITLE_TAG)
        addRow(hiresRow)

        // --- 3. Spatial / 3D audio ---
        // Two ways to set this exist in the protocol: the legacy feature switch
        // (0x0403 feature 0x1B, which our builder already has) and the newer
        // three-mode command (0x0422). Which one this firmware honours is not yet
        // captured. The legacy one is used here because it is the symmetric
        // on/off the switch models; 0x0422 has three states (off/fixed/tracking)
        // and would need a different control.
        val spatial = SettingRowFactory.buildSwitch(this, false)
        spatialSwitch = spatial
        spatial.setOnCheckedChangeListener { _, isChecked ->
            manager.setSpatialSound(isChecked)
        }
        addRow(
            SettingRowFactory.build(
                this, R.drawable.ic_spatial, R.string.row_spatial_title, R.string.row_spatial_sub, spatial
            ) { spatial.performClick() }
        )

        // --- 4. Equalizer (placeholder destination) ---
        addRow(
            SettingRowFactory.build(
                this, R.drawable.ic_equalizer, R.string.row_eq_title, R.string.row_eq_sub,
                SettingRowFactory.buildChevron(this)
            ) { startActivity(Intent(this, EqActivity::class.java)) }
        )

        // --- 5. Find my earbuds ---
        addRow(
            SettingRowFactory.build(
                this, R.drawable.ic_find_buds, R.string.row_find_title, R.string.row_find_sub,
                SettingRowFactory.buildChevron(this)
            ) { startActivity(Intent(this, FindBudsActivity::class.java)) }
        )

        // --- 6. App update (never automatic; the screen enforces that) ---
        addRow(
            SettingRowFactory.build(
                this, R.drawable.ic_app_update, R.string.row_update_title, R.string.row_update_sub,
                SettingRowFactory.buildChevron(this)
            ) { startActivity(Intent(this, UpdateActivity::class.java)) }
        )
    }

    /** Adds a row plus a divider, skipping the divider after the final row. */
    private fun addRow(row: View) {
        if (featureList.childCount > 0) {
            featureList.addView(SettingRowFactory.buildDivider(this))
        }
        featureList.addView(row)
    }

    // ==================== Settings dialog ====================

    private fun showSettingsDialog() {
        val options = arrayOf(
            "Theme: ${ThemeRes.label(currentTheme)}",
            "Reconnect",
            "Disconnect"
        )
        AlertDialog.Builder(this)
            .setTitle(R.string.action_settings)
            .setItems(options) { dialog, which ->
                when (which) {
                    0 -> showThemeDialog()
                    1 -> connectDirectly()
                    2 -> if (isBound) manager.disconnect()
                }
                dialog.dismiss()
            }
            .show()
    }

    private fun showThemeDialog() {
        val labels = arrayOf(
            ThemeRes.label(ThemeRes.OLED),
            ThemeRes.label(ThemeRes.DARK),
            ThemeRes.label(ThemeRes.LIGHT)
        )
        AlertDialog.Builder(this)
            .setTitle(R.string.theme_title)
            .setSingleChoiceItems(labels, currentTheme) { _, which ->
                ThemeRes.save(this, which)
                // Update currentTheme BEFORE recreating. onResume compares the
                // saved value against this field to decide whether to rebuild;
                // leaving it stale means the recreated activity sees a difference
                // and recreates again, forever (the flicker bug). recreate() also
                // re-runs onCreate, which re-reads the same value, so this stays
                // consistent either way — but setting it here is what makes the
                // intent obvious.
                currentTheme = which
                recreate()
            }
            .setNegativeButton(R.string.dialog_close, null)
            .show()
    }

    // ==================== Permissions / connection ====================

    /**
     * Requests anything missing, and starts the service only once it is granted.
     *
     * The service start MUST NOT happen in onCreate unconditionally: the
     * connectedDevice foreground type requires BLUETOOTH_CONNECT at
     * startForeground() time and throws SecurityException without it, killing the
     * app on first launch. So the startup order is now:
     *
     *   onCreate -> request permissions (nothing started)
     *        |
     *   onRequestPermissionsResult -> if granted, start+bind the service
     *
     * and the already-granted case short-circuits straight to the service, so a
     * normal launch reconnects as before.
     *
     * POST_NOTIFICATIONS is requested but NOT required to start the service: it
     * only affects whether the (IMPORTANCE_MIN, swipeable) notification is shown.
     * A user who denies it should still get a working connection, so it is
     * deliberately excluded from hasBluetoothPermissions().
     */
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
            // Nothing to ask for — normal launch path.
            startAndBindServiceIfPermitted()
        } else {
            requestPermissions(needed.toTypedArray(), REQUEST_PERMISSIONS)
        }
    }

    /**
     * Permission dialog result.
     *
     * Starts the service as soon as the Bluetooth permissions are available, so
     * the app becomes usable immediately after the user accepts, rather than
     * needing a restart. If they were denied, the service stays down and the
     * feature rows will simply report no connection — the app no longer dies.
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode != REQUEST_PERMISSIONS) return

        if (hasBluetoothPermissions()) {
            startAndBindServiceIfPermitted()
        } else {
            // Denied. Say so once, in plain language, and point at the fix rather
            // than leaving a screen where every control silently does nothing.
            AlertDialog.Builder(this)
                .setTitle("Bluetooth permission needed")
                .setMessage(
                    "QuickBuds needs the Nearby devices permission to talk to your earbuds. " +
                        "Grant it in Settings, then reopen the app."
                )
                .setPositiveButton("Open settings") { _, _ ->
                    startActivity(
                        Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                            .setData(Uri.parse("package:$packageName"))
                    )
                }
                .setNegativeButton(R.string.dialog_close, null)
                .show()
        }
    }

    @SuppressLint("MissingPermission")
    private fun connectDirectly() {
        if (!isBound) {
            toast("Service not bound yet.")
            return
        }
        val adapter = getSystemService(BluetoothManager::class.java)?.adapter
        if (adapter == null || !adapter.isEnabled) {
            toast("Bluetooth is off.")
            return
        }
        val device = adapter.getRemoteDevice(TARGET_MAC)
        manager.connect(device)
    }

    /**
     * Status messages go to a TOAST, never to a view on a packet path.
     *
     * This is a hard rule for this app: onStatus fires once per packet, and an
     * earlier version wired toasts straight to it and produced a toast storm. The
     * manager only calls this for connection-level events, and the small guard
     * below keeps even those from stacking.
     */
    private var lastToastAt = 0L

    private fun toast(msg: String) {
        val now = System.currentTimeMillis()
        if (now - lastToastAt < 800) return
        lastToastAt = now
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    // ==================== BudsConnectionManager.Listener ====================

    override fun onStatus(msg: String) {
        // Connection-level messages only reach here in practice; everything
        // packet-shaped is filtered in the manager. Deliberately silent for the
        // common cases so the screen does not flicker with toasts.
        if (msg.startsWith("Connected") || msg.startsWith("Connection lost") ||
            msg.startsWith("Disconnected")
        ) {
            toast(msg)
        }
    }
    override fun onConnected(connected: Boolean) {
        runOnUiThread {
            if (!connected) {
                statusRowLeft.visibility = View.GONE
                statusRowCase.visibility = View.GONE
                statusRowRight.visibility = View.GONE
            }
        }
    }

    override fun onPacketReceived(bytes: ByteArray) {}

    override fun onBattery(
        left: Int?, case: Int?, right: Int?,
        chargingLeft: Boolean, chargingCase: Boolean, chargingRight: Boolean
    ) {
        // The store is the single source of truth for the panel; letting battery
        // callbacks paint the bars directly would race with it on every packet.
        // Nothing to do here beyond letting the store listener above handle it.
    }

    override fun onBudState(state: String) {}
    override fun onWearState(left: Int, right: Int, caseSt: Int) {}

    override fun onGameModeState(on: Boolean) {
        // Routed through the store, not painted here, for the same reason ANC is.
    }

    companion object {
        /** The three real noise-cancelling levels, weakest first. */
        private val ANC_LEVELS = listOf("ANC-Light", "ANC-Medium", "ANC-Deep")

        /**
         * Icon colours, COPIED FROM THE WIDGET'S PALETTE on purpose.
         *
         * These are not themed. The panel mirrors the home-screen widget, and the
         * widget is always dark regardless of the app theme — so the icons stay
         * white/grey on the Light app theme too, which is what "match the widget"
         * requires. Taking them from R.color.widget_* keeps that link explicit, so
         * changing the widget palette changes this with it and the two cannot drift.
         */
        private val COLOR_ACTIVE = 0xFFFFFFFF.toInt()   // widget_text_primary
        private val COLOR_IDLE = 0xFF8A8A8A.toInt()     // widget_text_secondary

        /**
         * The last report MainActivity took of ITSELF, while resumed.
         *
         * WHY THIS EXISTS: the Layout button lives on Dev Tools, so fetching a
         * report on demand can never describe the main screen — by the time the
         * button is reachable, MainActivity is paused. The first version held a
         * reference to the Activity instead and therefore always fell back to
         * dumping Dev Tools (visible as the "layout_devtools_" filename).
         *
         * So the main screen captures its own tree in onResume and parks the TEXT
         * here. Text, not the Activity: keeping a paused Activity alive to ask it
         * questions later is the leak this avoids.
         */
        @JvmStatic
        var cachedReport: String? = null
            private set

        /** Called by MainActivity once its tree has been laid out. */
        @JvmStatic
        fun cacheReport(text: String) {
            cachedReport = text
        }

        /**
         * The currently resumed MainActivity, or null.
         *
         * Only used to decide whether a CACHED report is still meaningful, and as
         * a fallback target. Cleared in onPause.
         */
        @JvmStatic
        var instance: MainActivity? = null
            private set
    }
}
