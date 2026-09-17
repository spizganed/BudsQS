package com.spizganed.quickbuds.ui

import android.app.Activity
import android.content.Intent
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
import com.spizganed.quickbuds.bluetooth.BudsService

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

        // The status note. Deliberately below the list and in secondary colour: it
        // is information, not an error state, and it must not look like a warning
        // that something failed. It states what actually happens now — a write to the
        // buds, read back to confirm — rather than the old "phone only", which the
        // measured enum made untrue.
        column.addView(TextView(this).apply {
            setText(R.string.gesture_write_note)
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
     * Sends ONE gesture's new binding to the buds.
     *
     * Goes through BudsService rather than binding it here, which is the same pattern
     * Dev Tools uses for Reconnect/Disconnect: the service already owns the connection
     * and the manager, and an Activity that bound the service itself would need its own
     * lifecycle handling for no gain.
     *
     * This is fire-and-forget on purpose. The write is confirmed by the SERVICE re-reading
     * the table and logging the resulting diff (`KEYFN DIFF:`), not by a callback into
     * this screen — the write crosses a socket to a device that may be asleep, and a UI
     * that waited for it would either lie about success or stall. If no table has been read
     * yet the manager REFUSES the write and says so in the log, rather than inventing the
     * other entries; that refusal is deliberate, not a silent no-op.
     *
     * WHICH BUTTON GROUPS ARE WRITTEN is NOT decided here or in [Gesture]. The manager reads
     * the buds' own table and writes every slot that bud actually has for this action, which
     * is the only rule that survives what the hardware does: slide has been seen inside
     * `btn 0x01` on one bud and split across `btn 0x02`/`0x03` on the other, in the SAME
     * capture. Both a hardcoded `0x01` and a hardcoded `0x02,0x03` are wrong half the time,
     * and each failure is silent — which is exactly how slide looked "broken but sometimes
     * working" for a session. See BudsConnectionManager.writeGestureBinding().
     *
     * THE HOLD'S EMPTY CASE SENDS NOTHING, and that is deliberate too. Measured on the
     * device: clearing the hold's function byte to `0x00` does NOT stop the ANC cycle —
     * the very next long press still changed the noise mode. So writing `0x00` cannot turn
     * the gesture off; all it does is make the buds' stored table disagree with what the
     * gesture actually does. Sending nothing keeps the table honest. Turning the cycle off
     * for real needs the separate `setSupportNoiseReduction` (`0x0404`) command — see
     * [GestureConfigStore] and PROTOCOL.md §5.
     */
    private fun writeToBuds(gesture: Gesture, actions: List<GestureAction>) {
        if (gesture == Gesture.TAP_HOLD && actions.isEmpty()) {
            // Nothing to send: `0x00` does not disable the cycle, so writing it would only
            // corrupt the table's description of a gesture that still works.
            return
        }
        val intent = Intent(this, BudsService::class.java).apply {
            action = BudsService.ACTION_SET_GESTURE
            putExtra(BudsService.EXTRA_GESTURE_DEVICE, side.deviceType)
            putExtra(BudsService.EXTRA_GESTURE_ACTION, gesture.keyFnAction)
            putExtra(BudsService.EXTRA_GESTURE_FUNCTION, GestureAction.functionByteFor(actions))
        }
        startService(intent)
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

        // NO SUBTITLE, on any gesture row.
        //
        // The hold row used to carry "cycles through the actions you pick". It was
        // removed because it made that row TALLER than the others and pushed the
        // binding value onto an extra line — so the row grew to fit its own
        // explanation and stood out as a different size. The behaviour is
        // discoverable without it (the rule explains itself when it is broken), and
        // every row now has the same shape.
        val row = SettingRowFactory.build(
            this,
            iconFor(gesture),
            gesture.labelRes,
            0,
            trailing
        ) { showActionDialog(gesture) }

        return row
    }

    /**
     * Icon per gesture. Reuses existing drawables rather than adding five new
     * vectors: the project has no gesture glyphs, and inventing them would be
     * guesswork about a visual language that has not been specified.
     *
     * ALL THREE TAPS USE THE SAME FILLED DOT. They previously differed (double tap
     * had the hollow dot), which read as if the gestures were different KINDS of
     * thing rather than three variants of the same one. The filled dot is used for
     * all three, by request, for consistency.
     */
    private fun iconFor(gesture: Gesture): Int = when (gesture) {
        Gesture.SINGLE_TAP -> R.drawable.ic_status_dot_filled
        Gesture.DOUBLE_TAP -> R.drawable.ic_status_dot_filled
        Gesture.TRIPLE_TAP -> R.drawable.ic_status_dot_filled
        Gesture.SLIDE -> R.drawable.ic_chevron_right
        Gesture.TAP_HOLD -> R.drawable.ic_bolt
    }

    /**
     * Bottom sheet listing the actions this gesture may take.
     *
     * SINGLE-SELECT gestures commit on tap and the sheet closes. TAP-AND-HOLD is
     * multi-select ([dismissOnSelect] false): tapping toggles and the sheet stays
     * open with a Done button, because "add or remove several" cannot work if the
     * first tap dismisses it.
     *
     * THE TAP-AND-HOLD RULE — none, or at least two — is enforced at the moment of
     * the attempt, and the rule is mentioned ONLY then. An empty selection
     * (unbinding the gesture) and two-or-more (a real cycle) are both allowed;
     * exactly one is not, because a hold bound to a single action is not a cycle and
     * would behave differently from every other gesture for no visible reason.
     *
     * So pressing Done with exactly one selected does NOT save and does NOT close —
     * it surfaces the explanation in place. That is deliberate: a permanently
     * visible hint would be noise for the majority of the time the rule is not
     * being broken, and a disabled button would leave the user with no idea why.
     */
    private fun showActionDialog(gesture: Gesture) {
        val options = actionsFor(gesture)
        val selected = GestureConfigStore.load(this, side, gesture).toMutableList()

        if (!gesture.multiSelect) {
            BottomSheetDialog(this)
                .title(getString(gesture.labelRes))
                .items(options.map { action ->
                    BottomSheetDialog.Item(
                        label = getString(action.labelRes),
                        selected = selected.contains(action),
                        onClick = {
                            GestureConfigStore.save(this, side, gesture, listOf(action))
                            writeToBuds(gesture, listOf(action))
                            render()
                        }
                    )
                })
                .show()
            return
        }

        // ONE sheet, updated in place. Toggling rebuilds only the rows and the
        // message, so the sheet does not stack or flicker on every tap.
        val working = options.filter { selected.contains(it) }.toMutableList()

        val sheet = BottomSheetDialog(this)
        sheet.title(getString(gesture.labelRes))
            .dismissOnSelect(false)
            .confirm(getString(R.string.gesture_done)) {
                if (working.size == 1) {
                    // The attempt. Explain, and stay open so it can be fixed.
                    sheet.message(getString(R.string.gesture_hold_rule))
                } else {
                    // Persist in the declared order, not tap order, so the cycle is
                    // deterministic and matches the list the user just saw.
                    val ordered = options.filter { working.contains(it) }
                    GestureConfigStore.save(this, side, gesture, ordered)
                    // Only reached with a VALID selection (none, or two or more), so this
                    // is the point the hold is actually committed — the exactly-one case
                    // above returns early without saving.
                    writeToBuds(gesture, ordered)
                    sheet.close()
                    render()
                }
            }

        fun refresh() {
            sheet.items(options.map { action ->
                BottomSheetDialog.Item(
                    label = getString(action.labelRes),
                    selected = working.contains(action),
                    onClick = {
                        if (working.contains(action)) working.remove(action)
                        else working.add(action)
                        refresh()
                    }
                )
            })
            // Clears the reminder as soon as the selection becomes valid again, so
            // it is only ever on screen while the rule is actually broken.
            if (working.size != 1) sheet.message(null)
        }

        refresh()
        sheet.show()
    }
}
