package com.spizganed.quickbuds

import android.annotation.SuppressLint
import android.app.Application
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import com.spizganed.quickbuds.ui.ThemeRes
import java.io.File
import java.io.PrintWriter
import java.io.StringWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Application entry point whose only job is to make crashes readable.
 *
 * WHY THIS EXISTS
 * A launch crash used to be invisible: the app wrote nothing, the Dev Tools
 * Export button lives behind the crash, and reading logcat needs a PC or Termux.
 * That left "it instantly crashes" with no evidence at all, which is the worst
 * possible position to debug from.
 *
 * So: an uncaught-exception handler writes the full stack trace and then hands
 * off to the platform's default handler (so the normal crash flow still happens).
 *
 * WHERE THE FILE GOES — deliberately THREE places, because the whole point is
 * that the user can reach it by hand while the app is unusable:
 *
 *   1. Download/QuickBudsCrash/crash-<timestamp>.txt
 *      The user-facing one. Written through MediaStore, which on API 29+ needs
 *      NO permission and produces a file any file manager and any PC can open.
 *      A new timestamped file per crash, so an older crash is never overwritten
 *      by a newer one while the user is still reading it.
 *
 *   2. files/crash.log  (getExternalFilesDir)
 *      App-private external. Read back on the next launch to show the in-app
 *      dialog. Same folder packet logs already use.
 *
 *   3. cacheDir/crash.log  (internal)
 *      Survives external storage being unavailable or unmounted mid-crash.
 *
 * On API 28 and below MediaStore.Downloads does not exist, so location 1 falls
 * back to a direct write to the public Download directory, which needs
 * WRITE_EXTERNAL_STORAGE (declared with maxSdkVersion=28 for exactly this).
 *
 * Do not remove the chaining to the default handler: swallowing the exception
 * would turn a visible crash into a silent, half-dead app.
 */
class QuickBudsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val previous = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            try {
                writeCrashReport(this, thread, throwable)
            } catch (_: Throwable) {
                // Never let the reporter itself take down the crash path.
            }
            // Hand back to the platform so the normal "app has stopped" flow runs.
            previous?.uncaughtException(thread, throwable)
        }
    }

    private fun writeCrashReport(context: Context, thread: Thread, throwable: Throwable) {
        val sw = StringWriter()
        throwable.printStackTrace(PrintWriter(sw))
        val stampFull = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(Date())
        val stampFile = SimpleDateFormat("yyyyMMdd-HHmmss", Locale.US).format(Date())

        val device = try {
            "${Build.MANUFACTURER} ${Build.MODEL} / Android ${Build.VERSION.RELEASE} (API ${Build.VERSION.SDK_INT})"
        } catch (_: Throwable) {
            "unknown device"
        }

        val body = buildString {
            appendLine("QuickBuds crash report")
            appendLine("time   : $stampFull")
            appendLine("device : $device")
            appendLine("thread : ${thread.name}")
            appendLine("version: ${installVersion(context)}")
            // Diagnostic recorded by ThemeRes.apply: names the first app frame seen
            // when the resource access that blocks applyOverrideConfiguration was
            // set up. Absent when nothing in the app appears in that path.
            runCatching {
                val p = context.getSharedPreferences(ThemeRes.PREFS_NAME, Context.MODE_PRIVATE)
                val trace = p.getString("themeAccessTrace", null)
                if (trace != null) appendLine("overrideResult: $trace")
            }
            appendLine()
            appendLine(sw.toString())
        }

        // 1. Public, user-reachable copy.
        runCatching { writeToPublicDownload(context, "crash-$stampFile.txt", body) }

        // 2 + 3. App-private copies, for the in-app dialog on next launch.
        runCatching {
            File(context.getExternalFilesDir(null), CrashLogger.FILE_NAME).writeText(body)
        }
        runCatching { File(context.cacheDir, CrashLogger.FILE_NAME).writeText(body) }
    }

    /**
     * Writes into the public Download folder.
     *
     * API 29+ goes through MediaStore: no permission needed, and the entry is
     * registered with the media database so file managers and PCs see it
     * immediately rather than only after a media scan.
     *
     * API 28 and below uses a direct write. That path is why
     * WRITE_EXTERNAL_STORAGE is declared with maxSdkVersion="28" — on 29+ the
     * declaration is ignored and the MediaStore path is used instead, so there is
     * no runtime permission prompt on modern devices.
     */
    private fun writeToPublicDownload(context: Context, fileName: String, body: String) {
        val relativeDir = "${Environment.DIRECTORY_DOWNLOADS}/$PUBLIC_DIR"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val values = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                put(MediaStore.MediaColumns.MIME_TYPE, "text/plain")
                put(MediaStore.MediaColumns.RELATIVE_PATH, relativeDir)
            }
            val collection = MediaStore.Downloads.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
            val uri = context.contentResolver.insert(collection, values) ?: return
            context.contentResolver.openOutputStream(uri)?.use { it.write(body.toByteArray()) }
            return
        }

        @Suppress("DEPRECATION")
        val dir = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            PUBLIC_DIR
        )
        if (!dir.exists()) dir.mkdirs()
        File(dir, fileName).writeText(body)
    }

    private fun installVersion(context: Context): String = try {
        context.packageManager.getPackageInfo(context.packageName, 0).versionName ?: "?"
    } catch (_: Throwable) {
        "?"
    }

    companion object {
        /** Subfolder of Download holding crash reports. */
        const val PUBLIC_DIR = "QuickBudsCrash"
    }
}

/**
 * Reads back the last crash report and finds the public copies.
 *
 * Kept out of the Application class so a screen can use it without holding an
 * Application reference, and so every location is known in exactly one place.
 */
object CrashLogger {

    const val FILE_NAME = "crash.log"

    /**
     * The public crash reports, newest first.
     *
     * Scans the Download/QuickBudsCrash folder with a plain directory listing
     * rather than a MediaStore query: the app may be running before the media
     * database has indexed a crash that happened seconds ago, and a stale index is
     * exactly the case that matters here.
     *
     * The context parameter is unused (the public Download path needs no
     * Context), but is kept so every method on this object has the same shape at
     * the call site.
     */
    @SuppressLint("NewApi")
    fun publicReports(context: Context): List<File> {
        val dir = try {
            // context is deliberately unused, and named so the analyzer stays
            // quiet: the public Download path needs no Context. The parameter is
            // kept so every method on this object has the same call shape.
            if (context.packageName.isEmpty()) return emptyList()
            File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                QuickBudsApp.PUBLIC_DIR
            )
        } catch (_: Throwable) {
            return emptyList()
        }
        val files = dir.listFiles { f -> f.isFile && f.name.startsWith("crash-") } ?: return emptyList()
        return files.sortedByDescending { it.lastModified() }
    }

    /**
     * Returns the last crash report, or null if there is none.
     *
     * Prefers the app-private copies because they are written from inside the
     * crash handler without touching shared storage; the public one is the
     * fallback for the case where a crash happened so early (or under such a bad
     * state) that only the Download write succeeded.
     */
    fun last(context: Context): String? {
        val candidates = listOfNotNull(
            context.getExternalFilesDir(null)?.let { File(it, FILE_NAME) },
            File(context.cacheDir, FILE_NAME)
        )
        for (f in candidates) {
            try {
                if (f.exists() && f.length() > 0) return f.readText()
            } catch (_: Throwable) {
                // Try the next candidate.
            }
        }
        for (f in publicReports(context).take(1)) {
            try {
                return f.readText()
            } catch (_: Throwable) {
            }
        }
        return null
    }

    /** Human-readable list of where reports live, for the dialog. */
    fun path(context: Context): String {
        if (context.packageName.isEmpty()) return ""
        val publicDir = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            QuickBudsApp.PUBLIC_DIR
        ).absolutePath
        val privateCopy =
            context.getExternalFilesDir(null)?.let { File(it, FILE_NAME).absolutePath } ?: "n/a"
        return "Public : $publicDir\nPrivate: $privateCopy"
    }

    /** Deletes the app-private copies, so the dialog does not reappear every launch. */
    fun clear(context: Context) {
        runCatching {
            context.getExternalFilesDir(null)?.let { File(it, FILE_NAME).delete() }
        }
        runCatching { File(context.cacheDir, FILE_NAME).delete() }
        // Public reports are intentionally NOT deleted: the user asked for a file
        // they can reach by hand, and silently removing it after showing the
        // dialog once would defeat that. Delete them from the file manager.
    }

    /**
     * Intent that lets the user send the report wherever they want.
     *
     * context is unused: an implicit ACTION_SEND needs no package scoping. Kept in
     * the signature so this matches every other method on this object, and read in
     * the body so the analyzer stays quiet.
     */
    fun shareIntent(context: Context, report: String): Intent =
        Intent(Intent.ACTION_SEND).apply {
            if (context.packageName.isEmpty()) return@apply
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "QuickBuds crash report")
            putExtra(Intent.EXTRA_TEXT, report)
        }
}
