package com.spizganed.quickbuds.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.drawable.Drawable

/**
 * Renders widget status icons from vector drawables.
 *
 * tinted(): renders the vector, tinted [color]. Edges are anti-aliased by the
 * platform vector rasterizer at any size — this replaces the old PNG + erosion
 * pipeline, which produced visible pixel blocks.
 *
 * ==================================================================
 * SIZE IS CAPPED — this cost a crash, do not remove the cap
 * ==================================================================
 * This used to size each bitmap at `intrinsicSize * RENDER_SCALE`, with no ceiling.
 * When the icon vectors were briefly authored at 1024dp (their source viewBox used as
 * the dp size — never do that), that meant 1024 * 4 = 4096px square, i.e. 67 MB per
 * bitmap ARGB_8888, and the tint pass allocated a second one the same size. The widget
 * then died on connect with:
 *
 *     RemoteViews for widget update exceeds maximum bitmap memory usage
 *     (used: 464658432, max: 15500160)
 *
 * 464 MB for a home-screen widget, and the crash surfaced as an app crash on connect
 * because that is when the widget is first refreshed.
 *
 * So: the render size is the intrinsic size times RENDER_SCALE (for a crisp result on
 * a scaled-up widget), CLAMPED to MAX_PX. Icons are small; 192px is ample for the
 * sizes this widget draws at, and the cap means a bad intrinsic size in a future
 * vector degrades to slightly soft rather than to a crash.
 */
object WidgetIcons {

    const val MODE_GONE = 0
    const val MODE_FILLED = 1

    private const val RENDER_SCALE = 4

    /** Hard ceiling on either dimension of a rendered icon, in pixels. */
    private const val MAX_PX = 192

    private val cache = HashMap<String, Bitmap>()

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun drawableToBitmap(context: Context, resId: Int): Bitmap {
        val d: Drawable = context.resources.getDrawable(resId, context.theme)
        val w = ((d.intrinsicWidth.coerceAtLeast(1)) * RENDER_SCALE).coerceAtMost(MAX_PX)
        val h = ((d.intrinsicHeight.coerceAtLeast(1)) * RENDER_SCALE).coerceAtMost(MAX_PX)
        val b = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val c = Canvas(b)
        d.setBounds(0, 0, w, h)
        d.draw(c)
        return b
    }

    @Synchronized
    fun tinted(context: Context, resId: Int, color: Int): Bitmap {
        val key = "${resId}_$color"
        return cache.getOrPut(key) {
            val src = drawableToBitmap(context, resId)
            val out = Bitmap.createBitmap(src.width, src.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(out)
            canvas.drawBitmap(src, 0f, 0f, null)
            val p = Paint()
            p.color = color
            p.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
            canvas.drawRect(0f, 0f, src.width.toFloat(), src.height.toFloat(), p)
            out
        }
    }

    /**
     * The same icon at a fraction of full alpha, for the widget's show/hide fade.
     *
     * WHY ALPHA IS BAKED INTO THE BITMAP:
     * a home-screen widget is RemoteViews only. It gets no AnimatorSet, no view
     * animation, no setAlpha on an ImageView — the widget host draws whatever
     * bitmap it is handed, once. The ONLY way to animate appearance there is to
     * push a short sequence of frames with the fade already rendered into each one.
     * That is what this produces, and `AncWidgetProvider` steps through them.
     *
     * Cached like tinted(), keyed by alpha too, so a fade costs one bitmap per step
     * and nothing at all on the second fade (the common case: the same two wear
     * states alternate all day).
     */
    @Synchronized
    fun tintedAlpha(context: Context, resId: Int, color: Int, alpha: Float): Bitmap {
        val a = alpha.coerceIn(0f, 1f)
        val key = "${resId}_${color}_a${(a * 255).toInt()}"
        return cache.getOrPut(key) {
            val base = tinted(context, resId, color)
            val out = Bitmap.createBitmap(base.width, base.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(out)
            val p = Paint()
            p.alpha = (a * 255).toInt()
            canvas.drawBitmap(base, 0f, 0f, p)
            out
        }
    }

    /**
     * Drops every cached bitmap.
     *
     * Called when the widget is removed, so a long-lived process does not hold a
     * fade's worth of bitmaps for a widget that no longer exists. The cache is
     * small (a few hundred KB) so this is housekeeping, not a leak fix.
     */
    @Synchronized
    fun clearCache() {
        cache.clear()
    }
}
