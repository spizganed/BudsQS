package com.spizganed.quickbuds.ui

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import com.spizganed.quickbuds.R

/**
 * Find my earbuds.
 *
 * Shows two large bud buttons; tapping one plays a locating chime on that side.
 *
 * WHY THERE IS A HARDWARE-TONE PATH AND A FALLBACK PATH
 * The request was explicit: prefer the firmware's own locator tone if it has one,
 * because a tone the buds generate themselves runs at the buds' own level and
 * cannot damage anything. A phone-generated chime has to be pushed over the
 * stereo link at a level we choose, which is the risky case — hence the strict
 * gain ceiling and fades in ChimePlayer.
 *
 * NO LOCATOR COMMAND HAS BEEN CAPTURED on this firmware. The reference
 * implementation has no find-my-earbuds call, and the 0x810D feature bitmap does
 * not advertise one. So at the time of writing the hardware path is a hook
 * (hardwareToneAvailable) that returns false and the fallback runs. If a capture
 * later shows a real command, implement it in sendHardwareTone() and flip the
 * flag — the UI already handles both cases and shows the explanatory note only
 * when the fallback is in use.
 *
 * SAFETY, since the request flagged driver damage explicitly:
 *   - never plays at more than a fraction of full scale (ChimePlayer.MAX_AMPLITUDE)
 *   - the channel split is done by SILENCE in the opposite channel, not by
 *     balance, so the other bud physically receives nothing
 *   - raised-cosine fades, pulsed rather than continuous, hard cap on duration
 *   - stop() on onStop, so a chime cannot outlive this screen
 */
class FindBudsActivity : Activity() {

    private lateinit var player: ChimePlayer
    private lateinit var statusText: TextView

    /** False until a capture proves the firmware has its own locator tone. */
    private val hardwareToneAvailable = false

    override fun onCreate(savedInstanceState: Bundle?) {
        // Before super.onCreate — see ThemeRes.select.
        ThemeRes.select(this)
        super.onCreate(savedInstanceState)

        player = ChimePlayer(this)

        val dp = { v: Float -> ThemeRes.dp(this, v) }
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(ThemeRes.color(this@FindBudsActivity, R.attr.appColorBg))
            setPadding(dp(20f), dp(48f), dp(20f), dp(20f))
            gravity = Gravity.CENTER_HORIZONTAL
        }

        root.addView(TextView(this).apply {
            setText(R.string.find_title)
            setTextColor(ThemeRes.color(this@FindBudsActivity, R.attr.appColorTextPrimary))
            textSize = 22f
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        })

        root.addView(TextView(this).apply {
            setText(R.string.find_hint)
            setTextColor(ThemeRes.color(this@FindBudsActivity, R.attr.appColorTextSecondary))
            textSize = 14f
            setPadding(0, dp(10f), 0, dp(30f))
        })

        val budRow = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
        }

        budRow.addView(
            budButton(R.drawable.ic_bud_left_hq, R.string.widget_battery_left) {
                play(ChimePlayer.Side.LEFT)
            }
        )

        budRow.addView(View(this).apply {
            layoutParams = LinearLayout.LayoutParams(dp(28f), dp(1f))
        })

        budRow.addView(
            budButton(R.drawable.ic_bud_right_hq, R.string.widget_battery_right) {
                play(ChimePlayer.Side.RIGHT)
            }
        )

        root.addView(budRow)

        statusText = TextView(this).apply {
            setText("")
            setTextColor(ThemeRes.color(this@FindBudsActivity, R.attr.appColorTextSecondary))
            textSize = 14f
            setPadding(0, dp(26f), 0, 0)
            gravity = Gravity.CENTER
        }
        root.addView(statusText)

        root.addView(Button(this).apply {
            setText(R.string.find_stop)
            setTextColor(ThemeRes.color(this@FindBudsActivity, R.attr.appColorTextPrimary))
            background = getDrawable(R.drawable.header_icon_bg)
            setPadding(dp(24f), dp(10f), dp(24f), dp(10f))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { topMargin = dp(20f) }
            setOnClickListener {
                player.stop()
                statusText.setText("")
            }
        })

        // Only shown when we are NOT using a firmware tone: the user should know
        // why the sound comes from the phone rather than the buds.
        if (!hardwareToneAvailable) {
            root.addView(TextView(this).apply {
                setText(R.string.find_no_hardware_tone)
                setTextColor(ThemeRes.color(this@FindBudsActivity, R.attr.appColorTextSecondary))
                textSize = 12f
                setPadding(0, dp(22f), 0, 0)
                gravity = Gravity.CENTER
            })
        }

        setContentView(ScrollView(this).apply { addView(root) })
    }

    /** A large tappable bud icon. Sized generously — it is the whole interaction. */
    private fun budButton(
        iconRes: Int,
        contentDescRes: Int,
        onClick: () -> Unit
    ): ImageButton {
        val dp = { v: Float -> ThemeRes.dp(this, v) }
        return ImageButton(this).apply {
            layoutParams = LinearLayout.LayoutParams(dp(120f), dp(120f))
            background = getDrawable(R.drawable.app_card_bg)
            setPadding(dp(14f), dp(14f), dp(14f), dp(14f))
            scaleType = ImageView.ScaleType.FIT_CENTER
            setImageDrawable(
                ThemeRes.tint(
                    this@FindBudsActivity,
                    iconRes,
                    ThemeRes.color(this@FindBudsActivity, R.attr.appColorIconTint)
                )
            )
            contentDescription = getString(contentDescRes)
            setOnClickListener { onClick() }
        }
    }

    private fun play(side: ChimePlayer.Side) {
        if (hardwareToneAvailable) {
            // Hook for the day a capture shows a real locator command.
            sendHardwareTone(side)
        }
        player.play(side)
        statusText.setText(
            if (side == ChimePlayer.Side.LEFT) R.string.find_playing_left
            else R.string.find_playing_right
        )
    }

    private fun sendHardwareTone(side: ChimePlayer.Side) {
        // Intentionally empty. No locator command has been captured; do not invent
        // one. See the class comment. Suppressed so the unused parameter is not a
        // warning while the hook is dormant.
        @Suppress("UNUSED_EXPRESSION")
        side
    }

    override fun onStop() {
        super.onStop()
        // Never let a chime outlive the screen: a process that keeps playing after
        // the user leaves is both confusing and, at any level, unnecessary stress
        // on the drivers.
        player.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}
