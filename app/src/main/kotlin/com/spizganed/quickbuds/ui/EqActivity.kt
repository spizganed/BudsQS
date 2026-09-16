package com.spizganed.quickbuds.ui

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.spizganed.quickbuds.R

/**
 * Equalizer — deliberate placeholder.
 *
 * This screen exists so the home row has somewhere real to go, and so the
 * eventual implementation has a defined home. It intentionally does nothing:
 * the buds' equalizer is a get/set pair over the same RFCOMM link (the reference
 * implementation has query 0x010F and an EQ notification 0x0504), but neither has
 * been captured on THIS firmware yet. Building controls against an unverified
 * command would produce a screen that looks finished and silently does nothing,
 * which is worse than this one.
 *
 * When the capture lands, the plan is: list presets here, send the set command,
 * and gate the UI on the 0x810D feature bitmap rather than assuming support.
 */
class EqActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Before super.onCreate — see ThemeRes.select.
        ThemeRes.select(this)
        super.onCreate(savedInstanceState)

        val dp = { v: Float -> ThemeRes.dp(this, v) }
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(ThemeRes.color(this@EqActivity, R.attr.appColorBg))
            setPadding(dp(20f), dp(48f), dp(20f), dp(20f))
        }

        root.addView(TextView(this).apply {
            setText(R.string.eq_title)
            setTextColor(ThemeRes.color(this@EqActivity, R.attr.appColorTextPrimary))
            textSize = 22f
        })

        root.addView(TextView(this).apply {
            setText(R.string.eq_placeholder)
            setTextColor(ThemeRes.color(this@EqActivity, R.attr.appColorTextPrimary))
            textSize = 16f
            setPadding(0, dp(28f), 0, 0)
        })

        root.addView(TextView(this).apply {
            setText(R.string.eq_placeholder_detail)
            setTextColor(ThemeRes.color(this@EqActivity, R.attr.appColorTextSecondary))
            textSize = 14f
            setPadding(0, dp(10f), 0, 0)
        })

        setContentView(root)
    }
}
