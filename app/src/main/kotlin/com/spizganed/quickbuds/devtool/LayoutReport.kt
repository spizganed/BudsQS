package com.spizganed.quickbuds.devtool

import android.app.Activity
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

/**
 * Turns a laid-out view tree into PLAIN TEXT — the numbers, not the pixels.
 *
 * WHY THIS EXISTS
 * The agent that works on this project cannot see images. Descriptions of a layout
 * ("the card looks too close to the header") fail because the agent has to guess
 * which of ~30 view ids the description refers to, and a wrong guess costs a build
 * cycle. A screenshot cannot be made readable, but the LAYOUT can: everything a
 * layout bug consists of — x, y, width, height, margins, padding, gravity,
 * weights, text sizes — is already known exactly by the framework at measure /
 * layout time. This class simply writes those numbers out.
 *
 * This is strictly better than an image for the agent's purpose. A pixel grid is
 * at best an approximation of geometry that the framework knows exactly; a text
 * report is exact, cheap, and mentions view ids by name.
 *
 * WHAT IT SOLVES
 *   - "x sits too low / too far right"          -> per-view bounds + gaps
 *   - "these two are not aligned"               -> left/right/top edges side by side
 *   - "the spacing is inconsistent"             -> a gap list, so an outlier is visible
 *   - "this is clipped / off screen"            -> bounds vs parent and vs screen
 *   - "the text is too small / bold is lost"    -> text size and style per TextView
 *   - "the bar is not filling its row"          -> ProgressBar progress and bounds
 *   - "the icon is the wrong size"              -> icon view bounds vs its drawable
 *
 * THE OVERLAY
 * report() writes text. overlay() is the companion for a HUMAN: it burns the view
 * ids straight onto the screen so a screenshot becomes self-describing — every box
 * is labelled with the id it stands for, which removes the guesswork from a
 * screenshot description as well. Both are driven from the same walk.
 *
 * COORDINATES
 * All bounds are in PIXELS (device px) relative to the ROOT view's top-left, so
 * they are directly comparable to each other and to the screen size. dp is given
 * alongside the sizes where a dimension matters, because dp is what the layout XML
 * is written in and therefore what the fix has to be expressed in.
 */
object LayoutReport {

    /**
     * Captures [activity]'s laid-out tree as text and hands it to [onReady],
     * WITHOUT touching the filesystem.
     *
     * This exists because of a design flaw in the first version: the Layout button
     * lives on Dev Tools, and reaching it means leaving the main screen — which
     * pauses MainActivity and clears the `instance` reference the button wanted to
     * report. So the button could only ever describe the screen it was already on,
     * never the screen with the layout problems.
     *
     * The fix is for each screen to capture ITSELF while it is resumed, and park
     * the text somewhere a still-running component can collect. MainActivity calls
     * this in onResume; Dev Tools reads whatever was parked. That way the report
     * always describes the main screen as it was actually laid out on device.
     */
    fun capture(activity: Activity, onReady: (String) -> Unit) {
        activity.window.decorView.post { onReady(build(activity)) }
    }

    /**
     * Writes a full text report of [activity]'s view tree to [out].
     *
     * Call AFTER the first layout pass (post the call from onResume, or from a
     * button, or from onWindowFocusChanged) — before that every view reports
     * 0x0 and the report is useless. [onReady] receives the text so the caller can
     * also show or copy it.
     */
    fun report(activity: Activity, out: java.io.File, onReady: ((String) -> Unit)? = null) {
        // Post so it runs after the current pass has laid the tree out.
        activity.window.decorView.post {
            val text = build(activity)
            try {
                out.parentFile?.mkdirs()
                out.writeText(text)
            } catch (e: Exception) {
                // Never let diagnostics crash the screen they are diagnosing.
            }
            onReady?.invoke(text)
        }
    }

    /** Builds the report text without writing it anywhere. */
    fun build(activity: Activity): String {
        val root = activity.window.decorView
        val screenW = activity.resources.displayMetrics.widthPixels
        val screenH = activity.resources.displayMetrics.heightPixels
        val density = activity.resources.displayMetrics.density

        val sb = StringBuilder()
        sb.appendLine("LAYOUT REPORT")
        sb.appendLine("root=${name(root)}  screen=${screenW}x${screenH}px  density=$density")
        sb.appendLine("units: px (dp shown where a size/dimension matters)")
        sb.appendLine("bounds are relative to the root view's top-left")
        sb.appendLine()

        // The gap list is collected across the whole tree and printed at the end:
        // an inconsistent spacing bug is only visible when the values are adjacent.
        val gaps = ArrayList<String>()
        walk(root, root, density, 0, sb, gaps, 0, 0, 0, 0)

        sb.appendLine()
        sb.appendLine("SIBLING GAPS (spacing along the container's own stacking axis)")
        if (gaps.isEmpty()) sb.appendLine("  (none)")
        else gaps.forEach { sb.appendLine("  $it") }

        return sb.toString()
    }

    /**
     * Depth-first walk. Prints one line per view plus an INDENT marker per empty
     * parent, because a zero-child container is the usual cause of a "dead area"
     * complaint and is invisible in a screenshot.
     *
     * COORDINATE FRAMES — read this before changing any comparison here.
     * Everything is reported in ROOT space (offsets from the root view's top-left),
     * because that is the only frame in which rows from different depths can be
     * compared. The first version of this file mixed frames: it reported positions
     * in root space but compared children against `parent.width`, which is a LOCAL
     * size, so every view looked like it escaped its parent and the gap list was
     * mostly negative. Root space is therefore threaded down as parameters rather
     * than recomputed, so parents and children are guaranteed to share a frame.
     *
     * @param parentX parent's left edge in root space, or NO_VALUE for the root.
     * @param parentY parent's top edge in root space, or NO_VALUE for the root.
     */
    private fun walk(
        view: View,
        root: View,
        density: Float,
        depth: Int,
        sb: StringBuilder,
        gaps: MutableList<String>,
        parentX: Int,
        parentY: Int,
        parentW: Int,
        parentH: Int
    ) {
        val loc = IntArray(2)
        view.getLocationInWindow(loc)
        val rootLoc = IntArray(2)
        root.getLocationInWindow(rootLoc)
        val x = loc[0] - rootLoc[0]
        val y = loc[1] - rootLoc[1]
        val w = view.width
        val h = view.height

        val pad = "  ".repeat(depth)
        val idName = name(view)
        val cls = view.javaClass.simpleName

        val size = "w=${w}px(${px2dp(w, density)}) h=${h}px(${px2dp(h, density)})"
        val pos = "x=$x y=$y"

        val lp = view.layoutParams
        val params = buildString {
            if (lp is ViewGroup.MarginLayoutParams) {
                if (lp.leftMargin != 0 || lp.rightMargin != 0 || lp.topMargin != 0 || lp.bottomMargin != 0) {
                    append(" margins=")
                    append(dp(lp.leftMargin, density)).append(',')
                    append(dp(lp.topMargin, density)).append(',')
                    append(dp(lp.rightMargin, density)).append(',')
                    append(dp(lp.bottomMargin, density))
                }
            }
            if (lp is android.widget.LinearLayout.LayoutParams && lp.weight != 0f) {
                append(" weight=").append(lp.weight)
            }
            if (lp != null) {
                append(" lp=")
                append(
                    when (lp.width) {
                        ViewGroup.LayoutParams.MATCH_PARENT -> "match"
                        ViewGroup.LayoutParams.WRAP_CONTENT -> "wrap"
                        else -> dp(lp.width, density)
                    }
                )
                append('x')
                append(
                    when (lp.height) {
                        ViewGroup.LayoutParams.MATCH_PARENT -> "match"
                        ViewGroup.LayoutParams.WRAP_CONTENT -> "wrap"
                        else -> dp(lp.height, density)
                    }
                )
            }
        }

        val padding = buildString {
            if (view.paddingLeft != 0 || view.paddingTop != 0 ||
                view.paddingRight != 0 || view.paddingBottom != 0
            ) {
                append(" padding=")
                append(dp(view.paddingLeft, density)).append(',')
                append(dp(view.paddingTop, density)).append(',')
                append(dp(view.paddingRight, density)).append(',')
                append(dp(view.paddingBottom, density))
            }
        }

        sb.append(pad)
            .append(idName)
            .append("  [").append(cls).append(']')
            .append("  ").append(pos)
            .append("  ").append(size)
            .append(params)
            .append(padding)

        // Visibility that is not VISIBLE is the second most common surprise.
        if (view.visibility != View.VISIBLE) {
            sb.append("  VISIBILITY=")
                .append(if (view.visibility == View.GONE) "GONE" else "INVISIBLE")
        }

        sb.appendLine()
        sb.append(pad).append("  text: ").appendLine(describeContent(view, density))

        // Clipping: a view whose bounds escape its parent cannot be seen in full,
        // which reads as "cut off" in a screenshot but is exact here.
        //
        // Compared in ROOT space on both sides. The parent's own bounds are passed
        // in, NOT `parent.width`/`parent.height` — those are local sizes and
        // comparing root-space positions against them is what made the first
        // version of this check report an escape for every view on screen.
        if (parentW > 0 && parentH > 0) {
            val overflowLeft = parentX - x
            val overflowTop = parentY - y
            val overflowRight = (x + w) - (parentX + parentW)
            val overflowBottom = (y + h) - (parentY + parentH)
            if (overflowLeft > 0 || overflowTop > 0 || overflowRight > 0 || overflowBottom > 0) {
                sb.append(pad).append("  !! ESCAPES PARENT")
                if (overflowLeft > 0) sb.append(" left+${px2dp(overflowLeft, density)}dp")
                if (overflowTop > 0) sb.append(" top+${px2dp(overflowTop, density)}dp")
                if (overflowRight > 0) sb.append(" right+${px2dp(overflowRight, density)}dp")
                if (overflowBottom > 0) sb.append(" bottom+${px2dp(overflowBottom, density)}dp")
                sb.appendLine()
            }
        }

        if (view is ViewGroup) {
            if (view.childCount == 0) {
                sb.append(pad).appendLine("  (no children — empty container)")
            } else {
                collectGaps(view, density, gaps)
            }
            for (i in 0 until view.childCount) {
                walk(
                    view.getChildAt(i), root, density, depth + 1, sb, gaps,
                    x, y, w, h
                )
            }
        }
    }

    /**
     * Records the gaps between siblings, in the direction the container actually
     * stacks them.
     *
     * ORIENTATION MATTERS, and getting it wrong produced nonsense in the first
     * version: it computed a VERTICAL gap for every pair of siblings, so a
     * horizontal toolbar reported -48dp between buttons standing side by side.
     * A gap that is measured along the wrong axis is worse than no gap at all,
     * because it looks like a finding.
     *
     * Only real spacing is reported: for a LinearLayout with no margins the
     * children are laid adjacent, so the gap is 0 and the useful signal is the
     * nonzero ones. A negative gap cannot occur in a correct layout, so it is
     * flagged rather than silently printed.
     */
    private fun collectGaps(view: ViewGroup, density: Float, gaps: MutableList<String>) {
        val horizontal = (view as? android.widget.LinearLayout)?.orientation ==
            android.widget.LinearLayout.HORIZONTAL
        val axis = if (horizontal) "h" else "v"

        // Gaps are reported between the DIRECT children of this container, which is
        // the only set of views that is guaranteed to be laid out along this
        // container's own stacking axis and in one coordinate frame.
        //
        // The previous attempt flattened whole subtrees into a single sequence by
        // descending through unnamed wrappers. That was wrong in a way the output
        // made obvious: a row's children are laid out along the ROW's axis, not the
        // grandparent's, so `status_row_left` and `status_row_case` (children of the
        // vertical bars column) got compared along h and reported -202.3dp of
        // "overlap" -- they are full-width stacked siblings, so their horizontal
        // extent overlaps by design. It also double-reported every pair, once from
        // the wrapper's own level and once from the parent's.
        //
        // A wrapper still needs a NAME for the gap line to be useful, so unnamed
        // children are described by their contents instead of being merged
        // (`(group)` style). Their own children get their own gap block, reported
        // against their own axis and origin, further down the tree.
        var prevEnd = Int.MIN_VALUE
        var prevName = ""
        val viewLoc = IntArray(2)
        val childLoc = IntArray(2)
        view.getLocationInWindow(viewLoc)

        for (i in 0 until view.childCount) {
            val child = view.getChildAt(i)
            if (child.visibility == View.GONE) continue
            if (child.width == 0 && child.height == 0) continue
            child.getLocationInWindow(childLoc)
            val start = if (horizontal) childLoc[0] - viewLoc[0] else childLoc[1] - viewLoc[1]
            val end = start + if (horizontal) child.width else child.height

            if (prevEnd != Int.MIN_VALUE) {
                val gap = start - prevEnd
                val flag = if (gap < 0) "  !! OVERLAP" else ""
                gaps.add(
                    "${name(view)} [$axis]: $prevName -> ${describeChild(child)} = " +
                        "${px2dp(gap, density)}dp$flag"
                )
            }
            prevEnd = end
            prevName = describeChild(child)
        }
    }

    /**
     * A readable label for a view in a gap line.
     *
     * Unnamed views are the norm here (the battery card's two halves, the case's
     * FrameLayout slot, every feature row), so "?" would make the line useless.
     * They are therefore described by what they are and what they most usefully
     * contain: `[LinearLayout h x2]` for a container, or the first labelled child
     * for a leaf wrapper, which is what makes `status_bud_left -> [case slot]`
     * readable.
     */
    private fun describeChild(view: View): String {
        val id = view.id
        if (id != View.NO_ID) return name(view)
        val cls = view.javaClass.simpleName
        if (view is ViewGroup) {
            val dir = (view as? android.widget.LinearLayout)?.let {
                if (it.orientation == android.widget.LinearLayout.HORIZONTAL) "h" else "v"
            } ?: ""
            val inner = firstLabelled(view)
            val tag = if (inner != null) " -> $inner" else ""
            return "[$cls $dir x${view.childCount}$tag]"
        }
        return "[$cls]"
    }

    /** First labelled descendant, for labelling an otherwise anonymous wrapper. */
    private fun firstLabelled(v: ViewGroup): String? {
        for (i in 0 until v.childCount) {
            val c = v.getChildAt(i)
            if (c.id != View.NO_ID) return name(c)
            if (c is ViewGroup) {
                val r = firstLabelled(c)
                if (r != null) return r
            }
        }
        return null
    }

    /** Content, per view type. This is the part a screenshot cannot tell you. */
    private fun describeContent(view: View, density: Float): String = when (view) {
        is TextView -> {
            val text = if (view.text == null) "" else "\"" + view.text.toString() + "\""
            val gravity = gravity(view.gravity)
            var s = "$text size=${view.textSize / density}dp"
            val tf = view.typeface
            s += " style=${if (tf != null && tf.isBold) "bold" else if (tf != null && tf.isItalic) "italic" else "normal"}"
            s += " color=#" + String.format("%08X", view.currentTextColor)
            s += " gravity=$gravity"
            s += " lines=${view.lineCount}"
            s
        }
        is ProgressBar -> {
            var s = "progress=${view.progress}/${view.max}"
            val d = view.progressDrawable
            if (d != null) {
                s += " drawable=${d.javaClass.simpleName}"
                val b = Rect()
                d.getPadding(b)
                if (b.left != 0 || b.top != 0 || b.right != 0 || b.bottom != 0) {
                    s += " drawablePadding=$b"
                }
            }
            s += " indeterminate=${view.isIndeterminate}"
            s
        }
        is ImageView -> {
            val d = view.drawable
            var s = "scaleType=${view.scaleType}"
            if (d != null) {
                s += " drawable=${d.javaClass.simpleName}"
                s += " drawableBounds=${d.bounds.width()}x${d.bounds.height()}"
                s += " intrinsic=${d.intrinsicWidth}x${d.intrinsicHeight}"
            } else {
                s += " drawable=null"
            }
            s
        }
        else -> {
            var s = "background=${if (view.background != null) view.background.javaClass.simpleName else "null"}"
            if (view is ViewGroup) {
                s += " childCount=${view.childCount}"
                if (view is android.widget.LinearLayout) {
                    s += " orientation=${if (view.orientation == android.widget.LinearLayout.HORIZONTAL) "horizontal" else "vertical"}"
                }
            }
            s += " clickable=${view.isClickable}"
            s
        }
    }

    /** View id as a readable name, falling back to class + index when it has none. */
    private fun name(view: View): String {
        val id = view.id
        if (id == View.NO_ID) return "(no id)"
        return try {
            view.resources.getResourceEntryName(id)
        } catch (e: Exception) {
            "id/$id"
        }
    }

    /**
     * Burn an id label onto every view, for a HUMAN reader.
     *
     * This is the other half of the same idea: the agent reads the text report,
     * but a person still looks at the picture. Labelling the boxes with their ids
     * means a screenshot becomes self-describing, so "the thing under the header
     * is squashed" can be stated as "batteryCard is squashed" instead.
     *
     * Debug-only. Must be turned off before taking a screenshot meant to show the
     * design (the labels are drawn over the UI).
     */
    fun overlay(activity: Activity, on: Boolean) {
        val root = activity.window.decorView
        if (!on) {
            // Remove every label we added, identified by tag.
            removeLabels(root)
            return
        }
        root.post { labelAll(root, root) }
    }

    private const val LABEL_TAG = "layout_report_label"

    private fun removeLabels(view: View) {
        if (view is ViewGroup) {
            val doomed = ArrayList<View>()
            for (i in 0 until view.childCount) {
                val child = view.getChildAt(i)
                if (child.tag === LABEL_TAG) doomed.add(child) else removeLabels(child)
            }
            doomed.forEach { view.removeView(it) }
        }
    }

    /**
     * Adds one label per view. Uses a FRAMELAYOUT parent when it can (so the label
     * does not participate in the real layout); when the parent is not a
     * FrameLayout the label is skipped rather than inserted, because inserting a
     * child into a LinearLayout would change the very layout being measured.
     */
    private fun labelAll(view: View, root: View) {
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                labelAll(view.getChildAt(i), root)
            }
            if (view is android.widget.FrameLayout && view !== root) {
                val label = TextView(view.context).apply {
                    text = name(view)
                    textSize = 8f
                    setTextColor(0xFFFF00FF.toInt())
                    setBackgroundColor(0x99000000.toInt())
                    tag = LABEL_TAG
                    layoutParams = android.widget.FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    ).apply { gravity = android.view.Gravity.TOP or android.view.Gravity.START }
                }
                view.addView(label)
            }
        }
    }

    // --- small helpers ---

    private fun gravity(g: Int): String {
        val v = when (g and android.view.Gravity.VERTICAL_GRAVITY_MASK) {
            android.view.Gravity.TOP -> "top"
            android.view.Gravity.BOTTOM -> "bottom"
            android.view.Gravity.CENTER_VERTICAL -> "center_v"
            else -> "?"
        }
        val h = when (g and android.view.Gravity.HORIZONTAL_GRAVITY_MASK) {
            android.view.Gravity.LEFT -> "left"
            android.view.Gravity.RIGHT -> "right"
            android.view.Gravity.CENTER_HORIZONTAL -> "center_h"
            else -> "?"
        }
        return "$v|$h"
    }

    private fun px2dp(px: Int, density: Float): String = String.format("%.1f", px / density)

    private fun dp(px: Int, density: Float): String = String.format("%.1fdp", px / density)

    private fun StringBuilder.appendLine(s: String) = append(s).append('\n')
}
