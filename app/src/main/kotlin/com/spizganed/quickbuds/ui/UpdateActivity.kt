package com.spizganed.quickbuds.ui

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.content.FileProvider
import com.spizganed.quickbuds.R
import java.io.File

/**
 * App update — checks GitHub releases for a newer APK of THIS app.
 *
 * NOT FIRMWARE. The row this screen replaces was going to talk to the earbuds'
 * firmware updater; the request was explicit that it should instead check the
 * app's own GitHub releases.
 *
 * NEVER AUTOMATIC
 * Nothing here runs on launch, on resume, or on a timer. The only entry point is
 * the button, and a second press while a check is in flight is ignored rather
 * than queued. That is a deliberate privacy/behaviour choice, not an oversight —
 * so if this screen is ever refactored, keep the "user pressed it" precondition.
 *
 * UPDATE FLOW, and where it stops
 *   1. GET the releases API, take the newest release tag
 *   2. compare with the installed versionName, read through PackageManager, so
 *      the release tag must be a version-ish string
 *   3. if newer, find the .apk asset and download it to app cache
 *   4. hand the file to Android's package installer via FileProvider, which shows
 *      the system's own "do you want to update this app" dialog
 *
 * Step 4 is the ONLY install path used: the app never installs anything itself,
 * so the user confirms in the system UI. On API 26+ the download URL must be
 * HTTPS, and the FileProvider authority is <applicationId>.fileprovider (declared
 * in the manifest) because a content:// URI is required for a private cache file.
 */
class UpdateActivity : Activity() {

    private companion object {
        /** Owner/repo whose releases are the update source. */
        const val REPO = "spizganed/BudsQS"
        const val API = "https://api.github.com/repos/$REPO/releases/latest"
        const val APK_NAME = "quickbuds-update.apk"
    }

    private val handler = Handler(Looper.getMainLooper())

    private lateinit var statusText: TextView
    private lateinit var actionButton: Button

    /** True while a check/download is running, so taps are ignored not queued. */
    private var busy = false

    /** Latest release info, only populated by an explicit check. */
    private var pendingTag: String? = null
    private var pendingApkUrl: String? = null
    private var downloadedApk: File? = null

    /**
     * The installed version, read from the package rather than from a generated
     * constant: this project's build script does not emit a BuildConfig, so this
     * is the only value guaranteed to reflect what is actually installed.
     */
    private val installedVersion: String by lazy {
        try {
            packageManager.getPackageInfo(packageName, 0).versionName ?: "0"
        } catch (_: Exception) {
            "0"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // Before super.onCreate — see ThemeRes.select.
        ThemeRes.select(this)
        super.onCreate(savedInstanceState)

        val dp = { v: Float -> ThemeRes.dp(this, v) }
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(ThemeRes.color(this@UpdateActivity, R.attr.appColorBg))
            setPadding(dp(20f), dp(48f), dp(20f), dp(20f))
        }

        root.addView(TextView(this).apply {
            setText(R.string.update_title)
            setTextColor(ThemeRes.color(this@UpdateActivity, R.attr.appColorTextPrimary))
            textSize = 22f
        })

        root.addView(TextView(this).apply {
            setText(getString(R.string.update_never_auto))
            setTextColor(ThemeRes.color(this@UpdateActivity, R.attr.appColorTextSecondary))
            textSize = 13f
            setPadding(0, dp(10f), 0, 0)
        })

        root.addView(TextView(this).apply {
            setText("Installed: $installedVersion")
            setTextColor(ThemeRes.color(this@UpdateActivity, R.attr.appColorTextSecondary))
            textSize = 13f
            setPadding(0, dp(12f), 0, 0)
        })

        actionButton = Button(this).apply {
            setText(R.string.update_check)
            setTextColor(ThemeRes.color(this@UpdateActivity, R.attr.appColorTextPrimary))
            background = getDrawable(R.drawable.header_icon_bg)
            setPadding(dp(24f), dp(12f), dp(24f), dp(12f))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { topMargin = dp(24f) }
            setOnClickListener { onActionPressed() }
        }
        root.addView(actionButton)

        statusText = TextView(this).apply {
            setText("")
            setTextColor(ThemeRes.color(this@UpdateActivity, R.attr.appColorTextPrimary))
            textSize = 14f
            setPadding(0, dp(20f), 0, 0)
        }
        root.addView(statusText)

        setContentView(ScrollView(this).apply { addView(root) })
    }

    /**
     * Single button, three roles: check, then download, then install. Keeping one
     * button (rather than showing three) means there is never a second control
     * that could start a network call while another is in flight.
     */
    private fun onActionPressed() {
        if (busy) return
        when {
            downloadedApk != null -> installDownloaded()
            pendingApkUrl != null -> downloadApk(pendingApkUrl!!)
            else -> checkForUpdate()
        }
    }

    private fun setStatus(resId: Int, vararg args: Any) {
        handler.post { statusText.text = getString(resId, *args) }
    }

    private fun checkForUpdate() {
        busy = true
        handler.post {
            actionButton.isEnabled = false
            statusText.setText(R.string.update_checking)
        }

        Thread {
            try {
                val body = httpGet(API)
                val tag = extractJsonString(body, "tag_name")
                val apkUrl = extractApkUrl(body)

                handler.post {
                    busy = false
                    actionButton.isEnabled = true

                    if (tag == null) {
                        statusText.text = getString(R.string.update_failed, "no tag_name in release")
                        return@post
                    }
                    if (apkUrl == null) {
                        statusText.text = getString(R.string.update_failed, "release has no .apk asset")
                        return@post
                    }
                    if (!isNewer(tag, installedVersion)) {
                        statusText.setText(R.string.update_up_to_date)
                        return@post
                    }
                    pendingTag = tag
                    pendingApkUrl = apkUrl
                    statusText.text = getString(
                        R.string.update_available, tag, installedVersion
                    )
                    actionButton.setText(R.string.update_download)
                }
            } catch (e: Exception) {
                handler.post {
                    busy = false
                    actionButton.isEnabled = true
                    statusText.text = getString(R.string.update_failed, e.message ?: "network error")
                }
            }
        }.apply { isDaemon = true }.start()
    }

    private fun downloadApk(url: String) {
        busy = true
        handler.post {
            actionButton.isEnabled = false
            statusText.setText(R.string.update_downloading)
        }

        Thread {
            try {
                val out = File(cacheDir, APK_NAME)
                download(url, out)
                handler.post {
                    busy = false
                    actionButton.isEnabled = true
                    downloadedApk = out
                    statusText.setText(R.string.update_downloaded)
                    actionButton.setText(R.string.update_install)
                }
            } catch (e: Exception) {
                handler.post {
                    busy = false
                    actionButton.isEnabled = true
                    statusText.text = getString(R.string.update_failed, e.message ?: "download error")
                }
            }
        }.apply { isDaemon = true }.start()
    }

    /**
     * Hands the APK to the system installer.
     *
     * Two things are checked first because both produce a confusing failure
     * otherwise: the file actually exists, and this app is allowed to request
     * installs. The second needs REQUEST_INSTALL_PACKAGES granted by the user in
     * Settings; if it is missing we say so and offer to open that screen rather
     * than firing an intent that silently does nothing.
     */
    private fun installDownloaded() {
        val apk = downloadedApk ?: return
        if (!apk.exists() || apk.length() == 0L) {
            setStatus(R.string.update_failed, "downloaded file is missing")
            return
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O &&
            !packageManager.canRequestPackageInstalls()
        ) {
            AlertDialog.Builder(this)
                .setTitle(R.string.update_title)
                .setMessage("Android needs permission to install updates from QuickBuds.")
                .setPositiveButton("Open settings") { _, _ ->
                    startActivity(
                        Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES)
                            .setData(Uri.parse("package:$packageName"))
                    )
                }
                .setNegativeButton(R.string.dialog_close, null)
                .show()
            return
        }

        val uri = FileProvider.getUriForFile(this, "$packageName.fileprovider", apk)
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, "application/vnd.android.package-archive")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
    }

    // --- Minimal HTTP + JSON helpers ---------------------------------------
    // Deliberately hand-rolled: this is one GET of one well-known document, and
    // adding an HTTP/JSON dependency to the project for it is not worth the APK
    // size or the extra attack surface. If more API calls appear later, replace
    // both of these with a real client in one place.

    private fun httpGet(url: String): String {
        val conn = java.net.URL(url).openConnection() as java.net.HttpURLConnection
        return try {
            conn.requestMethod = "GET"
            conn.setRequestProperty("Accept", "application/vnd.github+json")
            conn.connectTimeout = 15_000
            conn.readTimeout = 20_000
            val code = conn.responseCode
            if (code !in 200..299) throw IllegalStateException("HTTP $code")
            conn.inputStream.bufferedReader().use { it.readText() }
        } finally {
            conn.disconnect()
        }
    }

    private fun download(url: String, dest: File) {
        val conn = java.net.URL(url).openConnection() as java.net.HttpURLConnection
        try {
            conn.requestMethod = "GET"
            conn.instanceFollowRedirects = true
            conn.connectTimeout = 15_000
            conn.readTimeout = 30_000
            val code = conn.responseCode
            if (code !in 200..299) throw IllegalStateException("HTTP $code")
            conn.inputStream.use { input ->
                dest.outputStream().use { output -> input.copyTo(output) }
            }
        } finally {
            conn.disconnect()
        }
    }

    /**
     * Extracts a top-level string field. Not a JSON parser — see the note above.
     * Handles escaped quotes minimally, which is all a tag_name needs.
     */
    private fun extractJsonString(json: String, field: String): String? {
        val key = "\"$field\""
        val i = json.indexOf(key)
        if (i < 0) return null
        val colon = json.indexOf(':', i + key.length)
        if (colon < 0) return null
        val open = json.indexOf('"', colon + 1)
        if (open < 0) return null
        var j = open + 1
        val sb = StringBuilder()
        while (j < json.length) {
            val c = json[j]
            if (c == '\\' && j + 1 < json.length) {
                sb.append(json[j + 1]); j += 2; continue
            }
            if (c == '"') break
            sb.append(c); j++
        }
        return sb.toString()
    }

    /** First .apk asset download URL in the release body. */
    private fun extractApkUrl(json: String): String? {
        val marker = "\"browser_download_url\""
        var from = 0
        while (true) {
            val i = json.indexOf(marker, from)
            if (i < 0) return null
            val url = extractJsonString(json.substring(i - 1), "browser_download_url")
            if (url != null && url.endsWith(".apk", ignoreCase = true)) return url
            from = i + marker.length
        }
    }

    /**
     * Compares version strings chunk by chunk, ignoring a leading "v" and any
     * suffix after "-". Deliberately not a full semver implementation: this only
     * needs to answer "is the release newer than what is installed", and a wrong
     * "yes" here is harmless (the user sees the system installer and can decline).
     */
    private fun isNewer(remote: String, local: String): Boolean {
        val a = remote.trim().removePrefix("v").substringBefore('-').split('.')
        val b = local.trim().removePrefix("v").substringBefore('-').split('.')
        for (i in 0 until maxOf(a.size, b.size)) {
            val x = a.getOrNull(i)?.toIntOrNull() ?: 0
            val y = b.getOrNull(i)?.toIntOrNull() ?: 0
            if (x != y) return x > y
        }
        return false
    }
}
