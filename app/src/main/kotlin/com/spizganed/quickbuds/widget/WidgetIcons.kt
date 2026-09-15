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
 * Rendered at 4x intrinsic size and cached — the widget refreshes every few
 * seconds, so this stays cheap.
 */
object WidgetIcons {

    const val MODE_GONE = 0
    const val MODE_FILLED = 1

    private const val RENDER_SCALE = 4

    private val cache = HashMap<String, Bitmap>()

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun drawableToBitmap(context: Context, resId: Int): Bitmap {
        val d: Drawable = context.resources.getDrawable(resId, context.theme)
        val w = (d.intrinsicWidth.coerceAtLeast(1)) * RENDER_SCALE
        val h = (d.intrinsicHeight.coerceAtLeast(1)) * RENDER_SCALE
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
}
