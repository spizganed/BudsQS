package com.spizganed.quickbuds.bluetooth

import android.content.Context
import android.util.Log
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.CopyOnWriteArrayList

/**
 * Packet logging foundation (roadmap item #1).
 *
 * Every TX frame, RX frame and status line in BudsConnectionManager flows
 * through its private log(), which now also calls PacketLogger.log().
 * So this single object captures the ENTIRE protocol conversation:
 *
 *   - Logcat tag "BudsQS-Packets" for live watching:
 *         logcat | grep BudsQS-Packets
 *   - Appends to packets.log in app-specific external storage, so the log
 *     survives app restarts and can be opened in a hex editor / text viewer.
 *   - In-memory ring buffer (getLines()) so the Dev Tools screen (#7) can
 *     display live log content without file I/O on the UI thread.
 *
 * Toggle ENABLED to false for release builds. Will later be exposed as the
 * dev-mode switch (roadmap item #7).
 */
object PacketLogger {

    var ENABLED = true

    private const val TAG = "BudsQS-Packets"
    private const val MAX_BYTES = 512 * 1024L
    private const val MAX_BUFFER_LINES = 2000

    // Time only — the date is noise for an on-device diagnostic log.
    // Milliseconds are kept because the raw hex view needs the extra
    // precision to see event ordering; the human-readable view drops
    // them at display time (see LogDecoder).
    private val ts = SimpleDateFormat("HH:mm:ss.SSS", Locale.US)

    private var logFile: File? = null

    /** In-memory ring buffer for the Dev Tools screen. */
    private val buffer = CopyOnWriteArrayList<String>()

    fun init(context: Context) {
        if (logFile == null) {
            logFile = File(context.getExternalFilesDir(null), "packets.log")
        }
    }

    @Synchronized
    fun log(msg: String) {
        if (!ENABLED) return
        val line = "${ts.format(Date())}  $msg"
        Log.d(TAG, line)
        buffer.add(line)
        while (buffer.size > MAX_BUFFER_LINES) {
            buffer.removeAt(0)
        }
        val f = logFile ?: return
        try {
            if (f.length() > MAX_BYTES) {
                val old = File(f.parentFile, "packets.old.log")
                if (old.exists()) old.delete()
                f.renameTo(old)
            }
            f.appendText(line + "\n")
        } catch (e: Exception) {
            Log.w(TAG, "file write failed: ${e.message}")
        }
    }

    /** Returns a snapshot of the in-memory log buffer (oldest-first). */
    @Synchronized
    fun getLines(): List<String> = buffer.toList()

    /** Clears the in-memory buffer and truncates the log file. */
    @Synchronized
    fun clear() {
        buffer.clear()
        val f = logFile ?: return
        try {
            f.writeText("")
        } catch (e: Exception) {
            Log.w(TAG, "file clear failed: ${e.message}")
        }
    }

    /** Reads the full on-disk log file content for export. */
    @Synchronized
    fun getFileContent(): String {
        val f = logFile ?: return ""
        return try {
            f.readText()
        } catch (e: Exception) {
            ""
        }
    }
}
