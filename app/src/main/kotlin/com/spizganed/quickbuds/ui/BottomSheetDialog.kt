package com.spizganed.quickbuds.ui

import android.app.Activity
import android.app.Dialog
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import com.spizganed.quickbuds.R

/**
 * The app's own bottom sheet dialog.
 *
 * WHY THIS EXISTS RATHER THAN AlertDialog
 *
 * Three places needed the same thing and each had grown its own AlertDialog: the
 * theme picker, the ANC mode chooser and the gesture action picker. An AlertDialog
 * on this project's theme renders as a platform box with the stock blue accents,
 * which is the "does not match the rest of the app" problem, and it appears
 * CENTRED — the request was explicitly for these to come up from the BOTTOM.
 *
 * A real Material BottomSheetDialog is not an option: this project has no Material
 * dependency (see SettingRowFactory's note on why the switch had to be tinted by
 * hand). So this is a plain Dialog with a bottom-gravity window, no new dependency.
 *
 * WHY NOT A View ON TOP OF THE ACTIVITY: it would need its own back handling, its
 * own outside-tap dismissal and its own dim. A Dialog gets all three for free.
 *
 * MUTABLE IN PLACE, ON PURPOSE. `updateItems` and `updateMessage` re-render the
 * already-open sheet. The first version of this class could only be built once, so
 * the multi-select gesture picker had to create a NEW dialog on every toggle —
 * which stacked dialogs and made the screen flicker on each tap. Rows also never
 * dismissed the sheet, so a single-select tap (theme, ANC) left it open. Both are
 * fixed here: rows dismiss by default via [dismissOnSelect], and updates happen in
 * place.
 */
class BottomSheetDialog(private val activity: Activity) {

    /**
     * One selectable row.
     *
     * @param label    already-localised text, so this class never resolves strings
     *                 itself and cannot disagree with its callers.
     * @param selected draws the tick and the accent label.
     * @param enabled  false renders the row dimmed and untappable.
     */
    data class Item(
        val label: String,
        val selected: Boolean,
        val enabled: Boolean = true,
        val onClick: (() -> Unit)? = null
    )

    private var titleText: String? = null
    private var messageText: String? = null
    private var itemList: List<Item> = emptyList()
    private var confirmText: String? = null
    private var onConfirm: (() -> Unit)? = null

    /**
     * Whether tapping a row closes the sheet. True is right for a chooser where one
     * tap settles the question (theme, ANC, single-select gestures). False is for
     * multi-select, where the user is editing a set and a tap is not a decision.
     */
    private var dismissOnSelect = true

    private var dialog: Dialog? = null
    private var listColumn: LinearLayout? = null
    private var messageView: TextView? = null

    fun title(text: String?) = apply { titleText = text }

    fun message(text: String?) = apply {
        messageText = text
        // If the sheet is already up, reflect it immediately rather than storing a
        // value that only appears next time — that is the whole point of the
        // in-place update.
        messageView?.let { renderMessage(it) }
    }
    fun items(list: List<Item>) = apply {
        itemList = list
        listColumn?.let { renderItems(it) }
    }

    fun dismissOnSelect(enabled: Boolean) = apply { dismissOnSelect = enabled }

    /** The confirm button. Does NOT auto-dismiss — the caller calls [close]. */
    fun confirm(label: String, onClick: () -> Unit) = apply {
        confirmText = label
        onConfirm = onClick
    }

    /** Dismisses the sheet if it is showing. Safe to call when it is not. */
    fun close() {
        dialog?.dismiss()
    }

    fun show() {
        if (dialog != null) return

        val d = Dialog(activity)
        d.requestWindowFeature(Window.FEATURE_NO_TITLE)

        val dp = { v: Float -> ThemeRes.dp(activity, v) }
        val primary = ThemeRes.color(activity, R.attr.appColorTextPrimary)

        val root = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            background = activity.getDrawable(R.drawable.dialog_sheet_bg)
            setPadding(dp(6f), dp(14f), dp(6f), dp(14f))
        }

        // Grab handle: the conventional affordance that this came up from the bottom
        // and can be dismissed. Without it the sheet reads as a panel that merely
        // happens to sit low on the screen.
        root.addView(View(activity).apply {
            layoutParams = LinearLayout.LayoutParams(dp(36f), dp(4f)).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                bottomMargin = dp(12f)
            }
            setBackgroundColor(ThemeRes.color(activity, R.attr.appColorOutline))
            alpha = 0.7f
        })

        titleText?.let {
            root.addView(TextView(activity).apply {
                setText(it)
                setTextColor(primary)
                textSize = 16f
                typeface = Typeface.DEFAULT_BOLD
                setPadding(dp(14f), 0, dp(14f), dp(4f))
            })
        }

        // Created unconditionally and hidden when empty, so a later updateMessage()
        // has a view to write into without rebuilding the sheet.
        // Created unconditionally and hidden when empty, so a later updateMessage()
        // has a view to write into without rebuilding the sheet.
        val msgView = TextView(activity).apply {
            setTextColor(ThemeRes.color(activity, R.attr.appColorTextSecondary))
            textSize = 13f
            setPadding(dp(14f), dp(4f), dp(14f), dp(8f))
        }
        messageView = msgView
        renderMessage(msgView)
        root.addView(msgView)

        val column = LinearLayout(activity).apply { orientation = LinearLayout.VERTICAL }
        listColumn = column
        renderItems(column)

        // Rows scroll rather than pushing the sheet past the top of the screen: the
        // gesture action list is six entries. Capped by the window layout below so
        // the content behind stays visible, which is the point of a bottom sheet.
        val scroll = ScrollView(activity).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f
            )
            addView(column)
        }
        root.addView(scroll)

        confirmText?.let { label ->
            root.addView(TextView(activity).apply {
                setText(label)
                textSize = 15f
                typeface = Typeface.DEFAULT_BOLD
                gravity = Gravity.CENTER
                setTextColor(0xFFFFFFFF.toInt())
                background = activity.getDrawable(R.drawable.dev_button_bg_active)
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, dp(46f)
                ).apply {
                    topMargin = dp(10f)
                    marginStart = dp(10f)
                    marginEnd = dp(10f)
                }
                setOnClickListener { onConfirm?.invoke() }
            })
        }

        d.setContentView(root)
        d.setCanceledOnTouchOutside(true)

        d.window?.let { w ->
            w.setBackgroundDrawable(ColorDrawable(0x00000000))
            w.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            // A light dim: the sheet is a chooser over content the user is still
            // looking at (the ANC circles, the gesture list), not a modal that
            // should blank the screen.
            w.setDimAmount(0.45f)
            w.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            w.setGravity(Gravity.BOTTOM)
        }

        d.setOnDismissListener { dialog = null }
        dialog = d
        d.show()
    }

    private fun renderMessage(view: TextView) {
        val text = messageText
        if (text == null || text.isEmpty()) {
            view.visibility = View.GONE
        } else {
            view.visibility = View.VISIBLE
            view.text = text
        }
    }

    private fun renderItems(column: LinearLayout) {
        column.removeAllViews()
        for (item in itemList) column.addView(buildRow(item))
    }

    private fun buildRow(item: Item): View {
        val dp = { v: Float -> ThemeRes.dp(activity, v) }
        val primary = ThemeRes.color(activity, R.attr.appColorTextPrimary)
        val secondary = ThemeRes.color(activity, R.attr.appColorTextSecondary)
        val accent = ThemeRes.color(activity, R.attr.appColorAccent)

        val row = LinearLayout(activity).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, dp(52f)
            )
            setPadding(dp(14f), 0, dp(14f), 0)
            isClickable = item.enabled
            if (item.enabled && item.onClick != null) {
                setOnClickListener {
                    item.onClick.invoke()
                    if (dismissOnSelect) close()
                }
            }
            // A disabled row is dimmed rather than hidden, so a rule-restricted
            // option is visible as something that exists but is not currently
            // allowed. Hiding it would look like a missing option.
            alpha = if (item.enabled) 1f else 0.4f
        }

        row.addView(TextView(activity).apply {
            setText(item.label)
            setTextColor(if (item.selected && item.enabled) accent else primary)
            textSize = 15f
            layoutParams = LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f
            )
        })

        if (item.selected) {
            row.addView(ImageView(activity).apply {
                layoutParams = LinearLayout.LayoutParams(dp(20f), dp(20f))
                scaleType = ImageView.ScaleType.FIT_CENTER
                setImageDrawable(
                    ThemeRes.tint(
                        activity,
                        R.drawable.ic_check,
                        if (item.enabled) accent else secondary
                    )
                )
                contentDescription = ""
            })
        }

        return row
    }
}
