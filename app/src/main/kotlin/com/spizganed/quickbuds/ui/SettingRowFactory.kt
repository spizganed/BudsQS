package com.spizganed.quickbuds.ui

import android.content.Context
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.spizganed.quickbuds.R

/**
 * Builds the rows inside the main screen's settings card.
 *
 * WHY ROWS ARE BUILT IN CODE AND NOT IN XML
 * Every row is the same shape (icon, title + subtitle, control) and only the
 * control differs. Six near-identical blocks in XML would mean six places to edit
 * on any change, and — more importantly — the theme has to tint each icon and
 * switch, which XML cannot do for a vector drawable. Building them here keeps
 * "what a row looks like" in exactly one place.
 *
 * The row is a plain LinearLayout rather than a custom View class: it needs no
 * state of its own, so a custom ViewGroup would be ceremony with no payoff.
 */
object SettingRowFactory {

    /**
     * One settings row: leading icon, title, optional subtitle, trailing control.
     *
     * @param trailing the switch / chevron / value view to place on the right.
     * @param onClick  invoked for a tap anywhere on the row. Rows with a live
     *                 switch still get a row-wide handler so the whole row is a
     *                 hit target, which is what people expect on a phone.
     */
    fun build(
        context: Context,
        iconRes: Int,
        titleRes: Int,
        subtitleRes: Int,
        trailing: View,
        onClick: (() -> Unit)? = null
    ): LinearLayout {
        val dp = { v: Float -> ThemeRes.dp(context, v) }

        val row = LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, dp(56f)
            )
            setPadding(dp(14f), 0, dp(14f), 0)
            // Rows are separated by a hairline drawn by the card, not by margin,
            // so the group reads as one contiguous card.
            isClickable = onClick != null
            if (onClick != null) setOnClickListener { onClick() }
        }

        val icon = ImageView(context).apply {
            layoutParams = LinearLayout.LayoutParams(dp(22f), dp(22f))
            scaleType = ImageView.ScaleType.FIT_CENTER
            setImageDrawable(ThemeRes.tint(context, iconRes, ThemeRes.color(context, R.attr.appColorIconTint)))
            contentDescription = ""
            // Tagged so a theme change can retint without rebuilding the row.
            tag = iconRes
        }
        row.addView(icon)

        val textColumn = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            setPadding(dp(14f), 0, dp(10f), 0)
        }

        textColumn.addView(TextView(context).apply {
            setText(titleRes)
            setTextColor(ThemeRes.color(context, R.attr.appColorTextPrimary))
            textSize = 15f
            typeface = Typeface.DEFAULT_BOLD
        })

        if (subtitleRes != 0) {
            textColumn.addView(TextView(context).apply {
                setText(subtitleRes)
                setTextColor(ThemeRes.color(context, R.attr.appColorTextSecondary))
                textSize = 12f
                setPadding(0, dp(2f), 0, 0)
                // Tagged so a live row (hi-res codec) can swap its subtitle text
                // without rebuilding the row and losing its switch state.
                tag = SUBTITLE_TAG
            })
        }

        row.addView(textColumn)
        row.addView(trailing)
        return row
    }

    /** Tag for the subtitle TextView, so callers can find and update it. */
    const val SUBTITLE_TAG = "setting_row_subtitle"

    /** Tag for the leading icon ImageView. */
    const val ICON_TAG = "setting_row_icon"

    /**
     * Themed switch.
     *
     * Uses a plain android.widget.Switch with an explicit track/thumb tint rather
     * than SwitchCompat (no appcompat dependency in this project) or a
     * MaterialSwitch (no Material dependency). The stock Material switch on this
     * project's theme ignores the palette entirely, which is why both the track
     * and the thumb are set here.
     */
    fun buildSwitch(context: Context, checked: Boolean): android.widget.Switch {
        val dp = { v: Float -> ThemeRes.dp(context, v) }
        val sw = android.widget.Switch(context)
        sw.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
        )
        sw.isChecked = checked
        sw.setText("")
        sw.showText = false
        sw.buttonDrawable = context.getDrawable(
            if (checked) R.drawable.app_switch_track_on else R.drawable.app_switch_track
        )
        sw.thumbTintList = android.content.res.ColorStateList.valueOf(
            ThemeRes.color(context, R.attr.appColorSegBgActive)
        )
        sw.trackTintList = null
        // Keep the switch from stealing the row's ripple when the row is clickable.
        sw.isFocusable = true
        return sw
    }

    /** Re-applies the track drawable after the state changes. */
    fun refreshSwitch(context: Context, sw: android.widget.Switch, checked: Boolean) {
        sw.buttonDrawable = context.getDrawable(
            if (checked) R.drawable.app_switch_track_on else R.drawable.app_switch_track
        )
    }

    /**
     * Chevron button for rows that open another screen.
     *
     * Given a visible frame rather than a bare glyph: on the OLED theme a
     * floating chevron with no surface next to it reads as decoration, and the
     * request was explicitly for the widget's bordered language.
     */
    fun buildChevron(context: Context): ImageView {
        val dp = { v: Float -> ThemeRes.dp(context, v) }
        return ImageView(context).apply {
            layoutParams = LinearLayout.LayoutParams(dp(32f), dp(32f))
            scaleType = ImageView.ScaleType.FIT_CENTER
            setPadding(dp(6f), dp(6f), dp(6f), dp(6f))
            background = context.getDrawable(R.drawable.header_icon_bg)
            setImageDrawable(
                ThemeRes.tint(context, R.drawable.ic_chevron_right, ThemeRes.color(context, R.attr.appColorTextSecondary))
            )
            contentDescription = ""
        }
    }

    /** A muted right-aligned value label, used by rows that only report state. */
    fun buildValue(context: Context, text: String): TextView {
        val dp = { v: Float -> ThemeRes.dp(context, v) }
        return TextView(context).apply {
            setText(text)
            setTextColor(ThemeRes.color(context, R.attr.appColorTextSecondary))
            textSize = 13f
            gravity = Gravity.END
            setPadding(dp(8f), 0, 0, 0)
        }
    }

    /** Hairline divider between rows inside a card. Not drawn after the last row. */
    fun buildDivider(context: Context): View {
        val dp = { v: Float -> ThemeRes.dp(context, v) }
        return View(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, dp(1f)
            )
            setBackgroundColor(ThemeRes.color(context, R.attr.appColorOutline))
            alpha = 0.5f
        }
    }
}
