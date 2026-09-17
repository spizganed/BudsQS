package com.spizganed.quickbuds.ui

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import com.spizganed.quickbuds.R

/**
 * Earbud controls — bind a gesture to an action, per bud.
 *
 * LAYOUT, top to bottom (as specified):
 *   1. the selected bud's icon
 *   2. a Left / Right selector — the two buds are configured separately, because
 *      they can be bound to different actions
 *   3. "When not on call", then one row per gesture
 *
 * Tapping a gesture row opens a bottom dialog listing the actions that gesture
 * may be bound to. Tap-and-hold accepts MORE THAN ONE, which makes the gesture
 * cycle through them on each use; every other gesture takes exactly one.
 *
 * ON-CALL GESTURES ARE DELIBERATELY ABSENT. Not implemented by request, so there
 * is no "When on call" section and nothing to switch to it. The section header
 * exists as a single string for the not-on-call case; do not add the call variant
 * as an empty section, which would look like a bug.
 *
 * THE SELECTIONS ARE NOT SENT TO THE BUDS. See [GestureConfigStore] and the note
 * rendered at the bottom of this screen: the `function` enum is unknown, and
 * guessing it is the error that already cost this project one regression
 * (PROTOCOL.md §5). The screen is complete and usable; only the write is held
 * back, and it says so in plain words rather than looking finished and failing
 * silently.
 */
class GestureActivity : Activity() {

    private var side: GestureSide = GestureSide.LEFT

    private lateinit var budIcon: ImageView
    private lateinit var btnLeft: Button
    private lateinit var btnRight: Button
    private lateinit var gestureList: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        // Before super.onCreate — see ThemeRes.select.
        ThemeRes.select(this)
        super.onCreate(savedInstanceState)

        val dp = { v: Float -> ThemeRes.dp(this, v) }
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(ThemeRes.color(this@GestureActivity, R.attr.appColorBg))
            setPadding(dp(16f), dp(44f), dp(16f), dp(16f))
        }

        root.addView(TextView(this).apply {
            setText(R.string.gesture_title)
            setTextColor(ThemeRes.color(this@GestureActivity, R.attr.appColorTextPrimary))
            textSize = 16f
            typeface = Typeface.DEFAULT_BOLD
        })

        // --- 1. The selected bud's icon ---
        //
        // The two bud drawables are the same artwork this project already uses on
        // the battery card and the Find screen (his own SVGs, copied verbatim), so
        // the icon here cannot drift from the rest of the app.
        //
        // The box keeps the drawable's own tall ratio. A square box would letterbox
        // it and shrink the ink — the same trap FindBudsActivity documents.
        budIcon = ImageView(this).apply {
            layoutParams = LinearLayout.LayoutParams(dp(72f), dp(112f)).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = dp(18f)
                bottomMargin = dp(14f)
            }
            scaleType = ImageView.ScaleType.FIT_CENTER
            contentDescription = getString(R.string.gesture_bud_desc)
        }
        root.addView(budIcon)

        // --- 2. Left / Right selector ---
        //
        // Two equal buttons rather than a segmented control: the project has no
        // segmented widget and the chip drawables already exist, so this matches
        // the Dev Tools tab row exactly. Selection is shown by the active chip
        // drawable, the same language updateTabButtons() uses.
        val sideRow = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        btnLeft = sideButton(R.string.gesture_bud_left) { selectSide(GestureSide.LEFT) }
        btnRight = sideButton(R.string.gesture_bud_right) { selectSide(GestureSide.RIGHT) }
        sideRow.addView(btnLeft)
        sideRow.addView(btnRight)
        root.addView(sideRow)

        // --- 3. Gesture list ---
        val scroll = ScrollView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f
            )
        }

        val column = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        column.addView(TextView(this).apply {
            setText(R.string.gesture_section_not_in_call)
            setTextColor(ThemeRes.color(this@GestureActivity, R.attr.appColorTextSecondary))
            textSize = 13f
            setPadding(dp(4f), dp(22f), 0, dp(8f))
        })

        gestureList = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            background = getDrawable(R.drawable.app_card_bg)
            setPadding(dp(4f), dp(4f), dp(4f), dp(4f))
        }
        column.addView(gestureList)

        // The honest note. Deliberately below the list and in secondary colour: it
        // is information, not an error state, and it must not look like a warning
        // that something failed.
        column.addView(TextView(this).apply {
            setText(R.string.gesture_not_written)
            setTextColor(ThemeRes.color(this@GestureActivity, R.attr.appColorTextSecondary))
            textSize = 12f
            setPadding(dp(4f), dp(16f), dp(4f), dp(8f))
        })

        scroll.addView(column)
        root.addView(scroll)

        setContentView(root)

        render()
    }

    /** A Left/Right chip. Equal width via weight, so neither label can clip. */
    private fun sideButton(labelRes: Int, onClick: () -> Unit): Button {
        val dp = { v: Float -> ThemeRes.dp(this, v) }
        return Button(this).apply {
            setText(labelRes)
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
                .apply { marginStart = dp(4f); marginEnd = dp(4f) }
            minWidth = 0
            minHeight = dp(42f)
            textSize = 13f
            typeface = Typeface.DEFAULT_BOLD
            setOnClickListener { onClick() }
        }
    }

    private fun selectSide(newSide: GestureSide) {
        side = newSide
        render()
    }

    /**
     * Repaints the whole screen for the current side.
     *
     * Called on create and on every side switch. Rebuilding rather than mutating
     * in place keeps the two buds' states from bleeding into each other — the
     * whole reason the selector exists is that they differ.
     */
    private fun render() {
        val iconTint = ThemeRes.color(this, R.attr.appColorIconTint)
        budIcon.setImageDrawable(
            ThemeRes.tint(
                this,
                if (side == GestureSide.LEFT) R.drawable.ic_bud_left else R.drawable.ic_bud_right,
                iconTint
            )
        )

        paintSideButton(btnLeft, side == GestureSide.LEFT)
        paintSideButton(btnRight, side == GestureSide.RIGHT)

        gestureList.removeAllViews()
        val gestures = Gesture.values()
        for ((index, gesture) in gestures.withIndex()) {
            if (index > 0) gestureList.addView(SettingRowFactory.buildDivider(this))
            gestureList.addView(buildGestureRow(gesture))
        }
    }

    private fun paintSideButton(button: Button, active: Boolean) {
        button.background = getDrawable(
            if (active) R.drawable.dev_button_bg_active else R.drawable.dev_button_bg
        )
        // Active chips are drawn on the accent fill, so the label has to be the
        // on-accent colour, not the theme's primary text colour — reading
        // appColorTextPrimary here would put dark text on a dark fill in OLED.
        button.setTextColor(
            if (active) 0xFFFFFFFF.toInt()
            else ThemeRes.color(this, R.attr.appColorTextPrimary)
        )
    }

    /**
     * One gesture row: name on the left, current binding on the right, chevron.
     *
     * Reuses SettingRowFactory so a row looks identical to the main screen's rows
     * (same 56dp height, same 14dp inset, same chevron). A second row style would
     * be a second thing to keep in sync.
     */
    private fun buildGestureRow(gesture: Gesture): View {
        val current = GestureConfigStore.load(this, side, gesture)
        val summary = GestureConfigStore.describe(this, current)

        val trailing = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        trailing.addView(SettingRowFactory.buildValue(this, summary))
        trailing.addView(SettingRowFactory.buildChevron(this))

        // The gesture label plus a marker for the multi-select one, so the
        // difference is visible before opening the dialog rather than only in it.
        val row = SettingRowFactory.build(
            this,
            iconFor(gesture),
            gesture.labelRes,
            if (gesture.multiSelect) R.string.gesture_hold_multi_sub else 0,
            trailing
        ) { showActionDialog(gesture) }

        return row
    }

    /**
     * Icon per gesture. Reuses existing drawables rather than adding five new
     * vectors: the project has no gesture glyphs, and inventing them would be
     * guesswork about a visual language that has not been specified. The mapping is
     * by meaning (a tap is the equalizer's dot-ish glyph, a hold is the bolt, and
     * so on) and is easy to swap when real icons exist.
     */
    private fun iconFor(gesture: Gesture): Int = when (gesture) {
        Gesture.SINGLE_TAP -> R.drawable.ic_status_dot_filled
        Gesture.DOUBLE_TAP -> R.drawable.ic_status_dot_empty
        Gesture.TRIPLE_TAP -> R.drawable.ic_status_dot_filled
        Gesture.SLIDE -> R.drawable.ic_chevron_right
        Gesture.TAP_HOLD -> R.drawable.ic_bolt
    }

    /**
     * Bottom dialog listing the actions this gesture may take.
     *
     * Single-select gestures close on tap. The multi-select one (tap-and-hold)
     * toggles and stays open, with a Done button, because "add or remove several"
     * cannot work if the first tap dismisses the sheet.
     *
     * A plain AlertDialog positioned at the bottom, not a BottomSheetDialog: this
     * project has no Material dependency (see SettingRowFactory's note on why the
     * stock switch had to be tinted by hand), so a real bottom sheet is not
     * available without adding one.
     */
    private fun showActionDialog(gesture: Gesture) {
        val options = actionsFor(gesture)
        val selected = GestureConfigStore.load(this, side, gesture).toMutableList()

        val labels = options.map { getString(it.labelRes) }.toTypedArray()

        if (!gesture.multiSelect) {
            // Single-select: the current binding is the pre-checked item. An empty
            // or unrecognised binding simply shows nothing checked.
            val checked = options.indexOfFirst { selected.contains(it) }
            AlertDialog.Builder(this)
                .setTitle(getString(gesture.labelRes))
                .setSingleChoiceItems(labels, checked) { dialog, which ->
                    GestureConfigStore.save(this, side, gesture, listOf(options[which]))
                    dialog.dismiss()
                    render()
                }
                .setNegativeButton(R.string.dialog_close, null)
                .show()
            return
        }

        // Multi-select: tap toggles, Done commits.
        val checked = BooleanArray(options.size) { selected.contains(options[it]) }
        val working = BooleanArray(options.size) { checked[it] }

        AlertDialog.Builder(this)
            .setTitle(getString(gesture.labelRes))
            .setMultiChoiceItems(labels, checked) { _, which, isChecked ->
                working[which] = isChecked
            }
            .setMessage(R.string.gesture_multi_hint)
            .setPositiveButton(R.string.gesture_done) { _, _ ->
                // Preserve the declared order rather than tap order, so the cycle
                // is deterministic and matches the list the user just saw.
                val chosen = options.filterIndexed { i, _ -> working[i] }
                GestureConfigStore.save(this, side, gesture, chosen)
                render()
            }
            .setNegativeButton(R.string.dialog_close, null)
            .show()
    }
}
