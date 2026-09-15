package com.spizganed.quickbuds.bluetooth

import android.content.Context
import android.util.Log
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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
 *
 * Toggle ENABLED to false for release builds. Will later be exposed as the
 * dev-mode switch (roadmap item #7).
 */
object PacketLogger {

    var ENABLED = true

    private const val TAG = "BudsQS-Packets"
    private const val MAX_BYTES = 512 * 1024L

    private val ts = SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US)

    private var logFile: File? = null

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
}
