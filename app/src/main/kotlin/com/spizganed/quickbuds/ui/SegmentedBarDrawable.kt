package com.spizganed.quickbuds.ui

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.RectF
import android.graphics.drawable.Drawable

/**
 * A battery bar that draws itself in evenly spaced segments.
 *
 * WHY THIS IS CODE AND NOT A LAYER-LIST
 * The request was to divide the bar with lines so the level is easier to read.
 * A layer-list cannot do that correctly: its items are positioned by fixed dp or
 * gravity, so four dividers placed that way would sit at the right fractions in
 * ONE width and drift in every other. The app bar and the widget bar are
 * different widths, so they would visibly disagree. Drawing at computed fractions
 * of the current width makes the spacing correct at any size.
 *
 * WHAT IT DRAWS, in order:
 *   1. the track                - full width, rounded
 *   2. the fill, clipped to the current progress
 *   3. the dividers             - n-1 vertical gaps ON TOP of both, so they read
 *                                 as cuts through the bar rather than as ink. A
 *                                 divider drawn under the fill would disappear
 *                                 once the bar passed it, making the segments
 *                                 uncountable exactly when the level is high.
 *
 * The divider colour is passed in rather than hardcoded, because the app wants the
 * card colour behind the gap (it sits on a card) while the widget wants its own
 * card colour. Callers supply it.
 */
class SegmentedBarDrawable(
    /** Empty part of the bar. */
    private val trackColor: Int,
    /** Filled part of the bar. */
    private val fillColor: Int,
    /** Colour of the divider gaps — should match the surface BEHIND the bar. */
    private val dividerColor: Int,
    /** Number of segments. 10 matches the requested "10 lines" reading. */
    private val segments: Int = 10,
    /** Divider thickness in px. */
    private val dividerWidth: Float,
    /** Corner radius in px for the track and fill. */
    private val cornerRadius: Float,
    /**
     * Optional percentage label drawn centred in the bar.
     *
     * The number moved INSIDE the bar by request. Null or empty draws nothing.
     * The colour is supplied so it can contrast against the FILL on the left and
     * the TRACK on the right — see drawLabel for how both cases are handled.
     */
    private var labelText: String? = null,
    private val labelColorOnFill: Int = Color.BLACK,
    private val labelColorOnTrack: Int = Color.WHITE,
    private val labelSizePx: Float = 24f
) : Drawable() {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
        typeface = android.graphics.Typeface.DEFAULT_BOLD
    }

    /** Updates the label without rebuilding the drawable. */
    fun setLabel(text: String?) {
        labelText = text
        invalidateSelf()
    }

    /** 0..100. Set by the ProgressBar via level-based calls in the caller. */
    var progress: Int = 0
        set(value) {
            field = value.coerceIn(0, 100)
            invalidateSelf()
        }

    private val rect = RectF()

    override fun draw(canvas: Canvas) {
        val w = bounds.width().toFloat()
        val h = bounds.height().toFloat()
        if (w <= 0f || h <= 0f) return

        val left = bounds.left.toFloat()
        val top = bounds.top.toFloat()
        rect.set(left, top, left + w, top + h)

        // 1. Track
        paint.color = trackColor
        canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint)

        // 2. Fill
        val fillW = w * (progress / 100f)
        if (fillW > 0f) {
            val saved = canvas.save()
            // Clip rather than recompute the rounded rect, so the fill keeps a
            // clean rounded left cap and a straight right edge — the standard
            // battery-bar look.
            canvas.clipRect(left, top, left + fillW, top + h)
            rect.set(left, top, left + w, top + h)
            paint.color = fillColor
            canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint)
            canvas.restoreToCount(saved)
        }

        // 3. Dividers, on top. n-1 of them, at i/n of the width.
        if (segments > 1 && dividerWidth > 0f) {
            paint.color = dividerColor
            for (i in 1 until segments) {
                val x = left + w * (i.toFloat() / segments)
                canvas.drawRect(
                    x - dividerWidth / 2f, top,
                    x + dividerWidth / 2f, top + h,
                    paint
                )
            }
        }

        // 4. The label, inside the last filled cell.
        drawLabel(canvas, w, h)
    }

    /**
     * Draws the percentage inside the LAST FILLED SEGMENT.
     *
     * The rule, as specified with the `|*|*|*|*|*|80|x|x|x|` diagram: the number
     * belongs to the final cell that the fill has reached, and takes the colour that
     * contrasts with THAT cell's own background.
     *
     * Two consequences the earlier centred version got wrong:
     *   - the number MOVES as the level changes, so it always sits against the edge
     *     of the fill rather than floating in the middle of the bar. At 50% with the
     *     fill half-covering the fifth cell, the number is still readable because it
     *     is measured against the cell it occupies, not against the whole bar.
     *   - the colour is per-CELL, not per-bar. A cell is "filled" if its midpoint is
     *     at or below the fill edge, so a partially-covered cell counts as filled
     *     once the fill passes its middle — which is what makes the choice stable
     *     rather than flickering between colours as the edge sweeps across.
     *
     * Edge case: at 0% there is no filled cell, so the number is drawn in the FIRST
     * cell using the track colour. Without this the label would vanish at exactly
     * the level where the user most wants to confirm it is zero.
     */
    private fun drawLabel(canvas: Canvas, w: Float, h: Float) {
        val text = labelText ?: return
        if (text.isEmpty()) return

        textPaint.textSize = labelSizePx

        // Which cell does the fill reach? progress 1..100 maps to cells 1..segments.
        val filledCells = if (progress <= 0) {
            0
        } else {
            // Ceil so any nonzero progress lights at least the first cell.
            ((progress.toFloat() / 100f) * segments).let {
                val c = kotlin.math.ceil(it).toInt()
                if (c < 1) 1 else if (c > segments) segments else c
            }
        }

        // The cell that carries the number: the last filled one, or the first if
        // nothing is filled.
        val labelCell = if (filledCells == 0) 1 else filledCells
        val isLabelCellFilled = filledCells > 0

        // Centre of that cell.
        val cellWidth = w / segments
        val cellCentreX = bounds.left + cellWidth * (labelCell - 0.5f)

        // Colour contrasts with the cell's OWN background.
        textPaint.color = if (isLabelCellFilled) labelColorOnFill else labelColorOnTrack

        val baseline = bounds.top + h / 2f - (textPaint.descent() + textPaint.ascent()) / 2f
        canvas.drawText(text, cellCentreX, baseline, textPaint)
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
        invalidateSelf()
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
        invalidateSelf()
    }

    @Deprecated("Deprecated in Drawable; kept for compatibility.", ReplaceWith("PixelFormat.UNKNOWN"))
    override fun getOpacity(): Int = PixelFormat.UNKNOWN

    /** Convenience for callers using an int argb with no alpha. */
    fun setProgressFraction(fraction: Float) {
        progress = (fraction * 100f).toInt()
    }

    companion object {
        /** Transparent, for callers that want no dividers at all. */
        val NO_DIVIDER: Int = Color.TRANSPARENT
    }
}
