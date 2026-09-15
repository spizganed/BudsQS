package com.spizganed.quickbuds.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.drawable.Drawable

/**
 * Renders widget status icons at runtime from the silhouette drawables.
 *
 * - filled(): silhouette tinted [color]
 * - outline(): only the silhouette's outer ring, interior transparent so the
 *   widget card background shows through ("out of case, not worn" state)
 *
 * Results are cached — the widget refreshes every few seconds, so this stays cheap.
 */
object WidgetIcons {

    const val MODE_GONE = 0
    const val MODE_FILLED = 1
    const val MODE_OUTLINE = 2

    private const val STROKE_FRACTION = 22   // ring width ≈ iconSize/22

    private val cache = HashMap<String, Bitmap>()

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun drawableToBitmap(context: Context, resId: Int): Bitmap {
        val d: Drawable = context.resources.getDrawable(resId, context.theme)
        val w = d.intrinsicWidth.coerceAtLeast(1)
        val h = d.intrinsicHeight.coerceAtLeast(1)
        val b = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val c = Canvas(b)
        d.setBounds(0, 0, w, h)
        d.draw(c)
        return b
    }

    @Synchronized
    fun filled(context: Context, resId: Int, color: Int): Bitmap {
        val key = "f${resId}_$color"
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

    @Synchronized
    fun outline(context: Context, resId: Int, color: Int): Bitmap {
        val key = "o${resId}_$color"
        return cache.getOrPut(key) {
            val src = drawableToBitmap(context, resId)
            val w = src.width
            val h = src.height
            val px = IntArray(w * h)
            src.getPixels(px, 0, w, 0, 0, w, h)
            val alpha = IntArray(w * h) { Color.alpha(px[it]) }

            val r = (minOf(w, h) / STROKE_FRACTION).coerceAtLeast(2)
            val eroded = erode(alpha, w, h, r)

            val res = IntArray(w * h) {
                if (alpha[it] >= 100 && eroded[it] < 100) color else Color.TRANSPARENT
            }
            val out = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
            out.setPixels(res, 0, w, 0, 0, w, h)
            out
        }
    }

    /** Min-filter erosion: outside the bitmap counts as transparent (0). */
    private fun erode(a: IntArray, w: Int, h: Int, r: Int): IntArray {
        val out = IntArray(w * h)
        for (y in 0 until h) {
            for (x in 0 until w) {
                var m = 255
                var dy = -r
                while (dy <= r && m > 0) {
                    var dx = -r
                    while (dx <= r) {
                        val xx = x + dx
                        val yy = y + dy
                        val v = if (xx in 0 until w && yy in 0 until h) a[yy * w + xx] else 0
                        if (v < m) m = v
                        dx++
                    }
                    dy++
                }
                out[y * w + x] = m
            }
        }
        return out
    }
}
