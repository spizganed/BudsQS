package com.spizganed.quickbuds.ui

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import com.spizganed.quickbuds.R
import com.spizganed.quickbuds.bluetooth.PacketLogger
import com.spizganed.quickbuds.devtool.LayoutReport
import com.spizganed.quickbuds.devtool.ScreenshotToText
import com.spizganed.quickbuds.protocol.LogDecoder
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Dev Tools screen.
 *
 * Shows two views of the PacketLogger log:
 *   - Human-readable: decoded packet descriptions (e.g. "L=EAR R=OUT Case=CASE", "ANC -> Deep")
 *   - Raw hex: the original timestamped log lines as written to packets.log
 *
 * Also provides Clear and Export-to-file buttons.
 */
class DevToolsActivity : Activity() {

    private companion object {
        /** Folder created under Download for exported logs. */
        const val EXPORT_DIR_NAME = "QuickBudsLogs"

        /** Request code for the screenshot picker. */
        const val REQUEST_PICK_IMAGE = 2001
    }

    private lateinit var logText: TextView
    private lateinit var scroll: ScrollView
    private lateinit var logScroll: ScrollView
    private lateinit var btnScreenshot: Button
    private lateinit var btnLayout: Button
    private lateinit var btnWidgetLayout: Button
    private lateinit var btnWidgetLogic: Button
    private lateinit var btnTabHuman: Button
    private lateinit var btnTabRaw: Button
    private lateinit var btnClear: Button
    private lateinit var btnExport: Button
    private lateinit var btnMark: Button
    private lateinit var btnReconnect: Button
    private lateinit var btnDisconnect: Button
    private lateinit var clockText: TextView
    private lateinit var sinceMarkText: TextView
    private lateinit var devToolsRoot: LinearLayout

    private val handler = Handler(Looper.getMainLooper())

    private var isHumanTab = true

    /** Line count at the last paint — lets refreshLog() skip no-op rebuilds. */
    private var lastLineCount = -1

    /** Clock format: HH:mm:ss.SSS, matching the log timestamp format. */
    private val clockFormat = SimpleDateFormat("HH:mm:ss.SSS", Locale.US)

    /** When the Mark button was last pressed, for the elapsed-since readout. */
    private var lastMarkAt = 0L

    /** Counter so successive marks are distinguishable in the log. */
    private var markCount = 0

    // --- Theme colors (mirrors MainActivity) ---
    private var accentColor: Int = Color.parseColor("#CC0000")
    private var inactiveBtnColor: Int = Color.parseColor("#333333")
    private var textColor: Int = Color.WHITE

    private val THEME_OLED = 0
    private val THEME_DARK = 1
    private val THEME_LIGHT = 2

    /** Polling task that refreshes the log every 500ms. */
    private val refreshTask = object : Runnable {
        override fun run() {
            tickClock()
            refreshLog()
            handler.postDelayed(this, 500)
        }
    }

    /**
     * Updates the live clock readout. Refreshed on every tick rather than
     * every log change, since it is the reference for timing manual actions.
     */
    private fun tickClock() {
        clockText.text = clockFormat.format(Date())
        if (lastMarkAt > 0L) {
            val elapsed = System.currentTimeMillis() - lastMarkAt
            sinceMarkText.text = "+%.1fs".format(Locale.US, elapsed / 1000.0)
        } else {
            sinceMarkText.text = ""
        }
    }

    /**
     * Writes a numbered marker line into the PacketLogger stream.
     *
     * Because it goes through PacketLogger, the mark lands in the same
     * timeline as the packets: it shows up in both tabs, the on-disk
     * packets.log, and any export. Used to timestamp physical actions
     * (bud in/out) while testing.
     */
    private fun addMark() {
        markCount++
        lastMarkAt = System.currentTimeMillis()
        PacketLogger.log("MARK #$markCount")
        lastLineCount = -1
        tickClock()
        refreshLog()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // Theme before super.onCreate, same as every other screen. Previously this
        // screen hardcoded its own colours and never called setTheme at all, which
        // is part of why it did not match the rest of the app.
        ThemeRes.select(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_tools)

        logText = findViewById<TextView>(R.id.logText)
        scroll = findViewById<ScrollView>(R.id.scroll)
        logScroll = findViewById<ScrollView>(R.id.scroll)
        btnScreenshot = findViewById<Button>(R.id.btnScreenshot)
        btnLayout = findViewById<Button>(R.id.btnLayout)
        btnTabHuman = findViewById<Button>(R.id.btnTabHuman)
        btnTabRaw = findViewById<Button>(R.id.btnTabRaw)
        btnClear = findViewById<Button>(R.id.btnClear)
        btnExport = findViewById<Button>(R.id.btnExport)
        btnMark = findViewById<Button>(R.id.btnMark)
        clockText = findViewById<TextView>(R.id.clockText)
        sinceMarkText = findViewById<TextView>(R.id.sinceMarkText)
        devToolsRoot = findViewById<LinearLayout>(R.id.devToolsRoot)
        // WIDGET -> text, added 2026-09-18 because the widget had NO diagnostic.
        //
        // LayoutReport walks an Activity's view tree, and a widget is not an
        // Activity: it is drawn by the launcher from a RemoteViews parcel, in
        // another process. So the Layout button could never describe it, which is
        // why "the widget won't load" had to be debugged blind. This inflates the
        // widget layout in-process at the size the launcher currently reports and
        // writes it out the same way.
        //
        // THESE TWO MUST BE BOUND BEFORE applyTheme(). They used to be assigned at
        // the very bottom of onCreate, which was harmless while only their click
        // listeners read them — but applyTheme() now paints every action button,
        // including these two, so leaving them unbound here would throw
        // UninitializedPropertyAccessException the moment this screen opens.
        btnWidgetLayout = findViewById<Button>(R.id.btnWidgetLayout)
        btnWidgetLogic = findViewById<Button>(R.id.btnWidgetLogic)
        // Bound here, with the other buttons, because applyTheme() paints every
        // action button below — an unbound lateinit would throw on open.
        btnReconnect = findViewById<Button>(R.id.btnReconnect)
        btnDisconnect = findViewById<Button>(R.id.btnDisconnect)
        val prefs = getSharedPreferences(ThemeRes.PREFS_NAME, Context.MODE_PRIVATE)
        val theme = prefs.getInt("theme", THEME_OLED)
        applyTheme(theme)

        btnTabHuman.setOnClickListener { switchToHumanTab() }
        btnTabRaw.setOnClickListener { switchToRawTab() }
        btnClear.setOnClickListener {
            PacketLogger.clear()
            logText.text = ""
            lastLineCount = 0
        }
        btnMark.setOnClickListener { addMark() }
        btnExport.setOnClickListener {
            if (checkStoragePermission()) {
                exportLog()
            }
        }

        // CONNECTION CONTROLS, moved here from the main screen's settings cog at his
        // request. They are connection plumbing rather than a setting, and Dev Tools
        // is where the connection is already diagnosed.
        //
        // Sent as a service ACTION rather than through a bound manager: this screen
        // does not bind BudsService, and ACTION_FORCE_CONNECT / ACTION_FORCE_DISCONNECT
        // already exist and are already handled there, so this reuses a path that is
        // known to work instead of adding a second one.
        btnReconnect.setOnClickListener {
            startService(
                Intent(this, com.spizganed.quickbuds.bluetooth.BudsService::class.java)
                    .setAction(com.spizganed.quickbuds.bluetooth.BudsService.ACTION_FORCE_CONNECT)
            )
            showInLog("reconnect requested (FORCE_CONNECT)")
        }
        btnDisconnect.setOnClickListener {
            startService(
                Intent(this, com.spizganed.quickbuds.bluetooth.BudsService::class.java)
                    .setAction(com.spizganed.quickbuds.bluetooth.BudsService.ACTION_FORCE_DISCONNECT)
            )
            showInLog("disconnect requested (FORCE_DISCONNECT)")
        }

        // Long-press the log to copy its whole visible contents.
        //
        // This was previously missing: the TextView had textIsSelectable, so text
        // COULD be selected, but there was no one-gesture copy and no clipboard
        // write at all — which is why copying felt broken. Selectable stays on so
        // precise partial selection still works; long-press now copies everything
        // at once, which is what is actually wanted when pasting a capture out.
        //
        // Copies the CURRENTLY DISPLAYED tab (human-readable or raw hex), matching
        // what is on screen, and says which so the toast is self-explanatory.
        logText.setOnLongClickListener {
            val body = logText.text?.toString().orEmpty()
            if (body.isBlank()) {
                Toast.makeText(this, "Nothing to copy", Toast.LENGTH_SHORT).show()
                return@setOnLongClickListener true
            }
            val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val label = if (isHumanTab) "QuickBuds Log (human)" else "QuickBuds Log (raw)"
            cm.setPrimaryClip(ClipData.newPlainText(label, body))
            val tabName = if (isHumanTab) "human-readable" else "raw hex"
            Toast.makeText(
                this,
                "Copied ${body.count { it == '\n' }} lines ($tabName)",
                Toast.LENGTH_SHORT
            ).show()
            true
        }

        updateTabButtons()
        refreshLog()

        // Screenshot -> text conversion, for the coding agent.
        //
        // The agent cannot decode a compressed image, so a screenshot of a layout
        // problem is unreadable to it. This runs the decode ON DEVICE (where the
        // platform has a PNG decoder) and writes the pixels out as text into
        // Download/QuickBudsShot/, which the agent CAN read.
        //
        // Kept in Dev Tools rather than the main screen because it is a diagnostic,
        // not a feature.
        btnScreenshot.setOnClickListener { convertScreenshot() }

        // Layout -> text. Writes the measured geometry of the screen the user
        // is LOOKING AT (the main screen, in practice) into
        // Download/QuickBudsShot/layout_<stamp>.txt.
        //
        // This is the answer to "the agent cannot see my screenshot and does not
        // understand what is wrong": instead of describing a picture, the app
        // reports the numbers the framework already computed. It also means the
        // report is about the ACTUAL main screen, which is the one with layout
        // problems — Dev Tools itself is a diagnostic screen and its own layout is
        // not interesting.
        btnLayout.setOnClickListener { writeLayoutReport() }

        // Widget report listeners. The views themselves are bound at the TOP of
        // onCreate, before applyTheme(), because applyTheme() paints them.
        btnWidgetLayout.setOnClickListener { writeWidgetReport() }

        // The RemoteViews / logic check. See writeWidgetLogicReport: the layout button
        // reports geometry, which was already correct; this one reports whether the
        // widget's real update path produces something the launcher can accept.
        btnWidgetLogic.setOnClickListener { writeWidgetLogicReport() }
    }

    /**
     * Runs the widget's REAL RemoteViews builder and writes the result.
     *
     * This is the answer to "the widget's problem is logic, not layout" — which he
     * was right about. It calls the same builder the live update uses, for the current
     * state, and round-trips the RemoteViews through a Parcel, which is what the
     * AppWidgetService does before the launcher sees it. Written to Downloads like the
     * other diagnostics.
     */
    private fun writeWidgetLogicReport() {
        val stamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
        val name = "layout_widget_logic_$stamp.txt"
        val text = try {
            com.spizganed.quickbuds.widget.AncWidgetProvider
                .buildWidgetRemoteViews(this)
        } catch (t: Throwable) {
            "WIDGET LOGIC CHECK FAILED TO RUN\n\n$t\n\n${t.stackTraceToString()}"
        }
        val copied = copyTextToDownloads(name, text)
        showInLog(
            "widget logic check written\n" +
                if (copied == null) "Downloads copy FAILED"
                else "Downloads/QuickBudsShot/$name"
        )
    }

    /**
     * Writes a report of the WIDGET layout.
     *
     * Reads the real widget size from AppWidgetManager so the report matches what
     * the launcher has actually given it — a widget can be resized by the user, and
     * reporting a guessed size would describe a layout that does not exist.
     *
     * Also reports the live widget state, because "the widget won't load" has two
     * very different causes and this distinguishes them:
     *   - the layout measures wrong  -> geometry lines below look wrong
     *   - the state is empty/gated   -> hasLeft/hasRight/hasCase all false, so every
     *                                   row is INVISIBLE and the widget is blank
     * The second one is invisible in a geometry report alone, hence the state block.
     */
    private fun writeWidgetReport() {
        val stamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
        val name = "layout_widget_$stamp.txt"

        val mgr = android.appwidget.AppWidgetManager.getInstance(this)
        val ids = mgr.getAppWidgetIds(
            android.content.ComponentName(
                this,
                com.spizganed.quickbuds.widget.AncWidgetProvider::class.java
            )
        )

        val sb = StringBuilder()
        sb.appendLine("WIDGET DIAGNOSTIC")
        sb.appendLine("placed widget instances: ${ids.size}")
        if (ids.isEmpty()) {
            sb.appendLine("!! No widget instance is on the home screen. Add one first,")
            sb.appendLine("   otherwise this reports the layout only, with no live state.")
        }
        sb.appendLine()

        for (id in ids) {
            val opts = mgr.getAppWidgetOptions(id)
            val w = opts.getInt(android.appwidget.AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH)
            val h = opts.getInt(android.appwidget.AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT)
            sb.appendLine("--- widget id=$id  reported size ${w}x${h}dp ---")
        }
        sb.appendLine()

        // Live state: this is the part that explains a blank widget.
        //
        // EVERYTHING BELOW IS INSIDE THE try, including the layout walk. This method
        // is a DIAGNOSTIC, and it has now crashed the app twice on its own bugs (a
        // null LayoutParams, then getResourceEntryName on View.NO_ID). A tool whose
        // job is to report a problem must never itself become the problem: whatever
        // fails, the stack trace is written into the report and the user still gets a
        // file. It is also self-documenting, because the trace lands in the report
        // rather than only in a crash log.
        val state = try {
            val s = com.spizganed.quickbuds.widget.WidgetStateStore.read(this)
            sb.appendLine("LIVE STATE")
            sb.appendLine("  connected   = ${s.connected}")
            sb.appendLine("  leftStatus  = ${s.leftStatus}  hasLeft=${s.hasLeft()}")
            sb.appendLine("  rightStatus = ${s.rightStatus}  hasRight=${s.hasRight()}")
            sb.appendLine("  caseBattery = ${s.caseBattery}  hasCase=${s.hasCase()}")
            sb.appendLine("  caseLidClosed = ${s.caseLidClosed}  (gates the bud icons, not the case icon)")
            sb.appendLine("  leftDocked=${s.leftDocked} rightDocked=${s.rightDocked}")
            sb.appendLine("  bars: L=${s.leftProgress()}% C=${s.caseProgress()}% R=${s.rightProgress()}%")
            sb.appendLine("  text: L='${s.leftText()}' C='${s.caseText()}' R='${s.rightText()}'")
            sb.appendLine()
            s
        } catch (t: Throwable) {
            sb.appendLine("!! reading widget state FAILED: $t")
            sb.appendLine()
            null
        }

        // Measure at the launcher's size where known, else the widget's own declared
        // minimum (180x110dp), so the numbers are at least a real configuration.
        val density = resources.displayMetrics.density
        val px = { dp: Int -> (dp * density).toInt() }
        val anyOpts = ids.firstOrNull()?.let { mgr.getAppWidgetOptions(it) }
        val wPx = anyOpts
            ?.getInt(android.appwidget.AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH)
            ?.takeIf { it > 0 }?.let { px(it) } ?: px(180)
        val hPx = anyOpts
            ?.getInt(android.appwidget.AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT)
            ?.takeIf { it > 0 }?.let { px(it) } ?: px(110)

        try {
            sb.appendLine(LayoutReport.buildWidget(this, wPx, hPx))
        } catch (t: Throwable) {
            sb.appendLine("!! widget layout walk FAILED: $t")
            sb.appendLine()
            sb.appendLine(t.stackTraceToString())
        }

        // THE PART THE LAYOUT REPORT CANNOT ANSWER.
        //
        // The layout walk above measures the INITIAL layout, which is already correct
        // — so it kept saying "the layout is fine" while the widget still failed. He
        // spotted that the button was misleading, and it was. This runs the REAL
        // builder for the CURRENT state and round-trips the result through a Parcel,
        // which is exactly what the AppWidgetService does before the launcher ever
        // sees it. A throw here is the actual cause.
        sb.appendLine()
        try {
            sb.appendLine(
                com.spizganed.quickbuds.widget.AncWidgetProvider
                    .buildWidgetRemoteViews(this)
            )
        } catch (t: Throwable) {
            sb.appendLine("!! RemoteViews check FAILED: $t")
            sb.appendLine(t.stackTraceToString())
        }

        val copied = copyTextToDownloads(name, sb.toString())
        showInLog(
            "widget report: ${ids.size} instance(s), ${sb.lineSequence().count()} lines\n" +
                "state read: ${if (state == null) "FAILED" else "ok"}\n" +
                if (copied == null) "Downloads copy FAILED"
                else "Downloads/QuickBudsShot/$name"
        )
    }

    /**
     * Writes a layout report for the main screen.
     *
     * Dumps MainActivity's tree rather than this screen's, because the layout bugs
     * are on the main screen. If MainActivity is not running it falls back to this
     * screen, so the button always produces something.
     *
     * The report is generated after a layout pass (LayoutReport.report posts it),
     * so it must be called after the tree has been measured — a button press is
     * always safe.
     */
    private fun writeLayoutReport() {
        // Prefer the report MainActivity took of itself while resumed. Falling back
        // to this screen is honest about which tree is described (filename says so),
        // but it is a fallback, not the goal: the main screen is where the layout
        // problems are.
        val cached = MainActivity.cachedReport
        if (cached != null) {
            val stamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
            val name = "layout_main_$stamp.txt"
            val copied = copyTextToDownloads(name, cached)
            showInLog(
                "layout report (main, cached on resume): " +
                    cached.lineSequence().count() + " lines\n" +
                    if (copied == null) {
                        "Downloads copy FAILED"
                    } else {
                        "Downloads/QuickBudsShot/$name"
                    }
            )
            return
        }

        val main = MainActivity.instance
        if (main != null) {
            LayoutReport.report(main, File(cacheDir, "layout_main_live.txt")) { text ->
                val stamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
                val name = "layout_main_$stamp.txt"
                val copied = copyTextToDownloads(name, text)
                showInLog(
                    "layout report (main, live): ${text.lineSequence().count()} lines\n" +
                        if (copied == null) "Downloads copy FAILED"
                        else "Downloads/QuickBudsShot/$name"
                )
            }
            return
        }

        // Last resort: describe this screen, and say so in the filename so the
        // report is never mistaken for the main screen's.
        val stamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
        val name = "layout_devtools_$stamp.txt"
        LayoutReport.report(this, File(cacheDir, name)) { text ->
            val copied = copyTextToDownloads(name, text)
            showInLog(
                "layout report (DEV TOOLS ONLY — open the main screen once so it can " +
                    "be cached): ${text.lineSequence().count()} lines\n" +
                    if (copied == null) "Downloads copy FAILED"
                    else "Downloads/QuickBudsShot/$name"
            )
        }
    }

    /**
     * Copies a text file into Download/QuickBudsShot via MediaStore.
     *
     * Same reasoning as the screenshot outputs: public Downloads is visible to a
     * file manager, to MTP and to Termux, whereas app-specific storage is not.
     * Returns null on failure so the caller can report the fallback path.
     */
    private fun copyTextToDownloads(name: String, body: String): String? = try {
        val values = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
            put(MediaStore.MediaColumns.MIME_TYPE, "text/plain")
            put(
                MediaStore.MediaColumns.RELATIVE_PATH,
                "${Environment.DIRECTORY_DOWNLOADS}/QuickBudsShot"
            )
        }
        val collection = MediaStore.Downloads.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
        val item = contentResolver.insert(collection, values)
        if (item == null) {
            null
        } else {
            contentResolver.openOutputStream(item)?.use { out ->
                out.write(body.toByteArray())
            }
            name
        }
    } catch (e: Exception) {
        null
    }

    /**
     * Picks a screenshot and converts it to text.
     *
     * Uses ACTION_OPEN_DOCUMENT so any image in any app's storage can be chosen —
     * screenshots live in Pictures/Screenshots on most devices, but the user may
     * have moved them.
     */
    private fun convertScreenshot() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "image/*"
        }
        @Suppress("DEPRECATION")
        startActivityForResult(intent, REQUEST_PICK_IMAGE)
    }

    @Deprecated("Deprecated in Activity; onActivityResult still works and keeps this screen dependency-free.")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode != REQUEST_PICK_IMAGE || resultCode != RESULT_OK) return
        val uri = data?.data ?: return

        val summary = writeOutputs(uri)

        AlertDialog.Builder(this)
            .setTitle("Screenshot converted")
            .setMessage(
                "$summary\n" +
                    "Folder: Download/QuickBudsShot/\n\n" +
                    "files: -ascii (layout), -grid (brightness numbers), " +
                    "-color (per-cell hex), -rows (row brightness profile)"
            )
            .setPositiveButton("OK", null)
            .show()
    }

    /**
     * Decodes the picked image and writes the text representations to Downloads.
     *
     * WHY THIS GOES THROUGH MediaStore AND NOT File:
     * this screen originally wrote with a plain File to
     * Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS). On API 29+
     * that is SCOPED STORAGE: the app cannot create files in the public Downloads
     * directory directly, the write throws, and because the original code did not
     * check the result the user was told "converted" while nothing appeared. That is
     * the bug that produced an empty QuickBudsShot folder.
     *
     * MediaStore.Downloads needs no permission on API 29+ and registers each file
     * with the media database, so the files show up to the user and to the agent
     * immediately. The same approach is used by the crash reporter; keep them
     * consistent.
     *
     * The conversion itself happens into a temp directory first, because
     * ScreenshotToText writes four files and it is simpler to generate them locally
     * and then copy each one into MediaStore than to make that class aware of
     * ContentResolver.
     */
    private fun writeOutputs(uri: android.net.Uri): String {
        val tmpDir = File(cacheDir, "shotout")
        tmpDir.deleteRecursively()
        tmpDir.mkdirs()

        // The decode step needs a real path; content:// streams cannot be seeked.
        val tmp = File(cacheDir, "picked.png")
        try {
            contentResolver.openInputStream(uri)?.use { input ->
                tmp.outputStream().use { output -> input.copyTo(output) }
            }
        } catch (e: Exception) {
            return "Could not read image: ${e.message}"
        }

        val summary = ScreenshotToText.convert(tmp, tmpDir)
        tmp.delete()

        // Copy each generated file into public Download/QuickBudsShot via MediaStore.
        var copied = 0
        val failures = mutableListOf<String>()
        for (f in tmpDir.listFiles().orEmpty()) {
            val ok = try {
                val values = ContentValues().apply {
                    put(MediaStore.MediaColumns.DISPLAY_NAME, f.name)
                    put(MediaStore.MediaColumns.MIME_TYPE, "text/plain")
                    put(
                        MediaStore.MediaColumns.RELATIVE_PATH,
                        "${Environment.DIRECTORY_DOWNLOADS}/QuickBudsShot"
                    )
                }
                val collection =
                    MediaStore.Downloads.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
                val item = contentResolver.insert(collection, values)
                if (item == null) {
                    false
                } else {
                    contentResolver.openOutputStream(item)?.use { out ->
                        f.inputStream().use { input -> input.copyTo(out) }
                    }
                    true
                }
            } catch (e: Exception) {
                failures.add("${f.name}: ${e.message}")
                false
            }
            if (ok) copied++
        }
        tmpDir.deleteRecursively()

        return if (failures.isEmpty()) {
            "$summary\ncopied $copied file(s) to Downloads"
        } else {
            "$summary\ncopied $copied, FAILED:\n" + failures.joinToString("\n")
        }
    }

    override fun onResume() {
        super.onResume()
        handler.post(refreshTask)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(refreshTask)
    }

    private fun switchToHumanTab() {
        isHumanTab = true
        lastLineCount = -1
        updateTabButtons()
        refreshLog()
    }

    private fun switchToRawTab() {
        isHumanTab = false
        lastLineCount = -1
        updateTabButtons()
        refreshLog()
    }

    /**
     * Paints the selected tab.
     *
     * Rewritten to use the shared chip drawables instead of flat background
     * colours. The old version set the active tab's background to a hardcoded
     * #CC0000, which is why the active log button rendered as red on a screen that
     * otherwise has no red in it. The drawables read the theme, so this now matches
     * the rest of the app in all three themes.
     */
    private fun updateTabButtons() {
        val activeText = 0xFFFFFFFF.toInt()
        val normalText = ThemeRes.color(this, R.attr.appColorTextPrimary)

        btnTabHuman.background = getDrawable(
            if (isHumanTab) R.drawable.dev_button_bg_active else R.drawable.dev_button_bg
        )
        btnTabHuman.setTextColor(if (isHumanTab) activeText else normalText)

        btnTabRaw.background = getDrawable(
            if (isHumanTab) R.drawable.dev_button_bg else R.drawable.dev_button_bg_active
        )
        btnTabRaw.setTextColor(if (isHumanTab) normalText else activeText)
    }

    /**
     * Shows a one-off diagnostic message in the log pane.
     *
     * Used by the layout-report button, which is not a packet and therefore has
     * nowhere else to report to. It writes to the on-screen TextView only — NOT
     * through PacketLogger, because injecting non-packet text into the packet
     * timeline would corrupt a capture, and the log file is the thing being used
     * to reason about the protocol.
     *
     * The result is only readable while the human tab is selected, so this checks
     * first rather than silently writing into a hex view.
     */
    private fun showInLog(message: String) {
        if (!isHumanTab) switchToHumanTab()
        val existing = logText.text?.toString().orEmpty()
        logText.text = existing + "\n[layout] " + message + "\n"
        lastLineCount = PacketLogger.getLines().size
        scroll.post { scroll.fullScroll(ScrollView.FOCUS_DOWN) }
    }

    private fun refreshLog() {        val lines = PacketLogger.getLines()
        // Nothing new since the last paint — don't rebuild or move the scroll.
        if (lines.size == lastLineCount) return
        lastLineCount = lines.size

        // Follow only if the user is already at the bottom.
        val wasAtBottom = !scroll.canScrollVertically(1)

        val sb = StringBuilder()
        for (line in lines) {
            val decoded = LogDecoder.decode(line)
            val display: String
            if (isHumanTab) {
                // Human-readable: timestamp + direction + description
                val dirMarker = when (decoded.direction) {
                    LogDecoder.Direction.TX -> "\u2192 TX${if (decoded.label != null) "[${decoded.label}]" else ""} "
                    LogDecoder.Direction.RX -> "\u2190 RX${if (decoded.label != null) "[${decoded.label}]" else ""} "
                    LogDecoder.Direction.STATUS -> ""
                }
                display = "${LogDecoder.displayTime(decoded.rawTimestamp)}  $dirMarker${decoded.description}"
            } else {
                // Raw: show the original line as-is
                display = line
            }
            sb.append(display).append("\n")
        }
        logText.text = sb.toString()
        if (wasAtBottom) {
            scroll.post { scroll.fullScroll(ScrollView.FOCUS_DOWN) }
        }
    }

    private fun checkStoragePermission(): Boolean {
        // On Android 10+ we can write to app-specific external dir without permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            return true
        }
        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1002)
            return false
        }
        return true
    }

    private fun exportLog() {
        try {
            val content = PacketLogger.getFileContent()
            if (content.isEmpty()) {
                Toast.makeText(this, "Nothing to export yet (log is empty).", Toast.LENGTH_LONG).show()
                return
            }
            val name = "packets_export_${stamp()}.log"
            val where = writeToDownloads(name, content)
            Toast.makeText(this, "Exported to\n$where", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Export failed: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun stamp(): String =
        SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())

    /**
     * Writes the export into Download/QuickBudsLogs/ so it is visible to file managers
     * and USB/MTP, and reachable over adb.
     *
     * Why MediaStore rather than File(): on Android 10+ the shared Download directory is
     * only writable through MediaStore for apps that do not hold All-Files-Access. Writing
     * it as a plain File fails silently or throws on 11+. The sibling
     * /storage/emulated/0/QuickBudsLogs/ some file managers show is NOT reliably writable
     * for the same reason, so Download/QuickBudsLogs is the dependable location.
     *
     * Returns a human-readable location for the toast.
     */
    private fun writeToDownloads(name: String, content: String): String {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val values = ContentValues().apply {
                put(MediaStore.Downloads.DISPLAY_NAME, name)
                put(MediaStore.Downloads.MIME_TYPE, "text/plain")
                put(MediaStore.Downloads.RELATIVE_PATH,
                    Environment.DIRECTORY_DOWNLOADS + "/" + EXPORT_DIR_NAME)
            }
            val resolver = contentResolver
            val uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, values)
                ?: throw IllegalStateException("MediaStore refused the export entry")
            resolver.openOutputStream(uri)?.use { it.write(content.toByteArray()) }
                ?: throw IllegalStateException("Could not open $name for writing")
            return "Download/$EXPORT_DIR_NAME/$name"
        }

        // Legacy path (API < 29): plain files, permission already checked by caller.
        @Suppress("DEPRECATION")
        val dir = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            EXPORT_DIR_NAME)
        if (!dir.exists() && !dir.mkdirs()) {
            throw IllegalStateException("Could not create ${dir.absolutePath}")
        }
        File(dir, name).writeText(content)
        return "${dir.absolutePath}/$name"
    }

    /**
     * Applies the theme to this screen.
     *
     * REWRITTEN to read the themed @color/app_* resources instead of hardcoding
     * hex values. The old version used Color.WHITE for the background on the LIGHT
     * branch and Color.BLACK for text in some paths, which is how the log screen
     * ended up with white text on a white background: two independent literals that
     * were not guaranteed to agree, and a "theme" that did not follow the palette
     * the rest of the app uses.
     *
     * Using the same resources as every other screen means this cannot drift from
     * the main screen's colours, and a palette change is one edit in one file.
     */
    private fun applyTheme(theme: Int) {
        // The theme was already selected by ThemeRes.select() before
        // super.onCreate, so these resolve against the right palette. The `theme`
        // parameter is kept because callers still pass it, but the colours are no
        // longer derived from it here — the resources are authoritative.
        @Suppress("UNUSED_PARAMETER")
        val unused = theme

        val bgColor = ThemeRes.color(this, R.attr.appColorBg)
        val cardColor = ThemeRes.color(this, R.attr.appColorCard)
        val txtColor = ThemeRes.color(this, R.attr.appColorTextPrimary)
        val secondary = ThemeRes.color(this, R.attr.appColorTextSecondary)

        inactiveBtnColor = cardColor
        textColor = txtColor

        devToolsRoot.setBackgroundColor(bgColor)
        logText.setBackgroundColor(cardColor)
        logText.setTextColor(txtColor)
        logScroll.setBackground(getDrawable(R.drawable.log_card_bg))

        // The title is now found by ID. It used to be found BY POSITION (child 0 of
        // child 0 of the root), which only worked while this screen happened to keep
        // that exact shape — the restyle moved the buttons into their own card, so a
        // positional walk would have been one edit away from silently colouring the
        // wrong view. The id makes the binding explicit.
        findViewById<TextView>(R.id.devToolsTitle)?.setTextColor(txtColor)

        clockText.setTextColor(secondary)
        sinceMarkText.setTextColor(secondary)

        // Buttons get the shared chip drawable. ALL SEVEN action buttons are in this
        // list now: previously only Mark/Clear/Export were, so Shot, Layout, Widg and
        // Wlog kept the platform's default button background and sat in the same row
        // looking like a different family. The tab buttons are NOT here — they are
        // repainted by updateTabButtons(), which knows which one is selected.
        for (b in listOf(
            btnClear, btnMark, btnExport,
            btnScreenshot, btnLayout, btnWidgetLayout, btnWidgetLogic,
            btnReconnect, btnDisconnect
        )) {
            b.background = getDrawable(R.drawable.dev_button_bg)
            b.setTextColor(txtColor)
        }

        // Re-apply active tab highlight
        updateTabButtons()
    }
}
