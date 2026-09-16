package com.spizganed.quickbuds.ui

import android.Manifest
import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.ContentValues
import android.content.Context
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
import com.spizganed.quickbuds.protocol.LogDecoder
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Dev Tools screen (roadmap #7).
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
    }

    private lateinit var logText: TextView
    private lateinit var scroll: ScrollView
    private lateinit var btnTabHuman: Button
    private lateinit var btnTabRaw: Button
    private lateinit var btnClear: Button
    private lateinit var btnExport: Button
    private lateinit var btnMark: Button
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
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_tools)

        logText = findViewById<TextView>(R.id.logText)
        scroll = findViewById<ScrollView>(R.id.scroll)
        btnTabHuman = findViewById<Button>(R.id.btnTabHuman)
        btnTabRaw = findViewById<Button>(R.id.btnTabRaw)
        btnClear = findViewById<Button>(R.id.btnClear)
        btnExport = findViewById<Button>(R.id.btnExport)
        btnMark = findViewById<Button>(R.id.btnMark)
        clockText = findViewById<TextView>(R.id.clockText)
        sinceMarkText = findViewById<TextView>(R.id.sinceMarkText)
        devToolsRoot = findViewById<LinearLayout>(R.id.devToolsRoot)
        val prefs = getSharedPreferences("BudsQSPrefs", Context.MODE_PRIVATE)
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

    private fun updateTabButtons() {
        if (isHumanTab) {
            btnTabHuman.setBackgroundColor(accentColor)
            btnTabHuman.setTextColor(Color.WHITE)
            btnTabRaw.setBackgroundColor(inactiveBtnColor)
            btnTabRaw.setTextColor(textColor)
        } else {
            btnTabRaw.setBackgroundColor(accentColor)
            btnTabRaw.setTextColor(Color.WHITE)
            btnTabHuman.setBackgroundColor(inactiveBtnColor)
            btnTabHuman.setTextColor(textColor)
        }
    }

    private fun refreshLog() {
        val lines = PacketLogger.getLines()
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

    private fun applyTheme(theme: Int) {
        var bgColor: Int = Color.BLACK
        var btnColor: Int = inactiveBtnColor
        var txtColor: Int = textColor
        when (theme) {
            THEME_OLED -> {
                bgColor = Color.BLACK
                btnColor = Color.parseColor("#333333")
                txtColor = Color.WHITE
            }
            THEME_DARK -> {
                bgColor = Color.parseColor("#121212")
                btnColor = Color.parseColor("#333333")
                txtColor = Color.WHITE
            }
            THEME_LIGHT -> {
                bgColor = Color.WHITE
                btnColor = Color.parseColor("#DDDDDD")
                txtColor = Color.BLACK
            }
            else -> {
                bgColor = Color.BLACK
                btnColor = Color.parseColor("#333333")
                txtColor = Color.WHITE
            }
        }

        inactiveBtnColor = btnColor
        textColor = txtColor

        devToolsRoot.setBackgroundColor(bgColor)
        logText.setTextColor(txtColor)
        clockText.setTextColor(txtColor)
        sinceMarkText.setTextColor(txtColor)
        btnTabHuman.setBackgroundColor(inactiveBtnColor)
        btnTabHuman.setTextColor(txtColor)
        btnTabRaw.setBackgroundColor(inactiveBtnColor)
        btnTabRaw.setTextColor(txtColor)
        btnClear.setBackgroundColor(inactiveBtnColor)
        btnClear.setTextColor(txtColor)
        btnMark.setBackgroundColor(inactiveBtnColor)
        btnMark.setTextColor(txtColor)
        btnExport.setBackgroundColor(inactiveBtnColor)
        btnExport.setTextColor(txtColor)

        // Re-apply active tab highlight
        updateTabButtons()
    }
}
