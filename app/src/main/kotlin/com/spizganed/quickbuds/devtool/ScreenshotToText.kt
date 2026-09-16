package com.spizganed.quickbuds.devtool

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File
import java.util.zip.Inflater

/**
 * Turns a screenshot into TEXT, so the coding agent can read an actual picture.
 *
 * WHY THIS EXISTS
 * The agent cannot decode a PNG: read_file on one returns the 8-byte PNG signature
 * and then a zlib-deflated scanline stream it has no inflater for. But it reads plain
 * NUMBERS perfectly well. So this class does the decoding on-device, where the
 * platform already has a PNG decoder, and writes out the pixels as text.
 *
 * Three outputs, because different questions need different representations:
 *
 *  1. renderAscii()  - a coarse character map of brightness. Best for LAYOUT
 *                      questions: where blocks sit, what is clipped, relative sizes.
 *                      Cheap, human-scannable, and what the user's chafa attempt
 *                      proved works.
 *
 *  2. renderGrid()   - a labelled grid of mean brightness per cell, e.g. 12x24
 *                      numbers. Best for MEASUREMENTS: "the card is X% of the
 *                      height". Numeric, so proportions can be computed exactly
 *                      instead of eyeballed.
 *
 *  3. renderColorGrid() - the same grid, but per-channel hex. Best for COLOUR
 *                      questions, which the ASCII form cannot answer at all because
 *                      it discards colour by design.
 *
 * It also emits a vertical profile: the mean brightness of every ROW, which is what
 * actually reveals band boundaries (card edges, gaps) regardless of content.
 */
object ScreenshotToText {

    /** Output canvas size for the ASCII map. Downscaled hard on purpose. */
    private const val ASCII_W = 80
    private const val ASCII_H = 100

    /** Grid resolution for the numeric forms. */
    private const val GRID_COLS = 14
    private const val GRID_ROWS = 28

    private val RAMP = " .:-=+*#%@"

    /**
     * Decodes and writes all representations next to the source file.
     * Returns a short summary of what was written, or an error string.
     */
    fun convert(src: File, outDir: File): String {
        if (!src.exists()) return "no such file: ${src.absolutePath}"

        val bmp = BitmapFactory.decodeFile(src.absolutePath)
            ?: return "decode failed (not a readable image?)"

        return try {
            outDir.mkdirs()
            val base = src.nameWithoutExtension

            val ascii = File(outDir, "$base-ascii.txt").apply { writeText(renderAscii(bmp)) }
            val grid = File(outDir, "$base-grid.txt").apply { writeText(renderGrid(bmp)) }
            val color = File(outDir, "$base-color.txt").apply { writeText(renderColorGrid(bmp)) }
            val profile = File(outDir, "$base-rows.txt").apply { writeText(renderRowProfile(bmp)) }

            buildString {
                appendLine("converted ${src.name} (${bmp.width}x${bmp.height})")
                appendLine("  ${ascii.name}")
                appendLine("  ${grid.name}")
                appendLine("  ${color.name}")
                appendLine("  ${profile.name}")
            }
        } catch (e: Exception) {
            "write failed: ${e.message}"
        } finally {
            bmp.recycle()
        }
    }

    /** Coarse brightness map. Layout only — colour is deliberately discarded. */
    fun renderAscii(src: Bitmap): String {
        val bmp = Bitmap.createScaledBitmap(src, ASCII_W, ASCII_H, true)
        val sb = StringBuilder()
        sb.append("ASCII ${ASCII_W}x${ASCII_H} of ${src.width}x${src.height}\n")
        sb.append("legend: ' '=black ... '@'=white\n\n")
        for (y in 0 until ASCII_H) {
            for (x in 0 until ASCII_W) {
                val p = bmp.getPixel(x, y)
                val lum = luminance(p)
                val idx = (lum * (RAMP.length - 1) / 255f).toInt().coerceIn(0, RAMP.length - 1)
                sb.append(RAMP[idx])
            }
            sb.append('\n')
        }
        bmp.recycle()
        return sb.toString()
    }

    /**
     * Mean brightness per grid cell, as labelled numbers.
     * This is the one that answers "how big is X relative to Y" exactly.
     */
    fun renderGrid(src: Bitmap): String {
        val sb = StringBuilder()
        sb.append("Brightness grid ${GRID_COLS}x${GRID_ROWS} (0-99) of ${src.width}x${src.height}\n")
        sb.append("each cell is ${src.width / GRID_COLS}px wide, ${src.height / GRID_ROWS}px tall\n\n")

        val cellW = src.width.toFloat() / GRID_COLS
        val cellH = src.height.toFloat() / GRID_ROWS

        for (r in 0 until GRID_ROWS) {
            // Percentage of screen height at this row, so proportions are readable.
            val pct = (r * 100 / GRID_ROWS).toString().padStart(3)
            sb.append("$pct% ")
            for (c in 0 until GRID_COLS) {
                val mean = meanLuminance(
                    src,
                    (c * cellW).toInt(), (r * cellH).toInt(),
                    ((c + 1) * cellW).toInt(), ((r + 1) * cellH).toInt()
                )
                sb.append((mean * 99 / 255).toString().padStart(3))
            }
            sb.append('\n')
        }
        return sb.toString()
    }

    /** Per-cell average colour as hex. The only form that preserves hue. */
    fun renderColorGrid(src: Bitmap): String {
        val sb = StringBuilder()
        sb.append("Colour grid ${GRID_COLS}x${GRID_ROWS} of ${src.width}x${src.height}\n")
        sb.append("cells marked '.' are near-uniform; '-' have internal variation\n\n")

        val cellW = src.width.toFloat() / GRID_COLS
        val cellH = src.height.toFloat() / GRID_ROWS

        for (r in 0 until GRID_ROWS) {
            val pct = (r * 100 / GRID_ROWS).toString().padStart(3)
            sb.append("$pct% ")
            for (c in 0 until GRID_COLS) {
                val (avg, variance) = meanColor(
                    src,
                    (c * cellW).toInt(), (r * cellH).toInt(),
                    ((c + 1) * cellW).toInt(), ((r + 1) * cellH).toInt()
                )
                val mark = if (variance < 90) "." else "-"
                sb.append("%06X%s ".format(avg and 0xFFFFFF, mark))
            }
            sb.append('\n')
        }
        return sb.toString()
    }

    /**
     * Mean brightness of every screen row, sampled 1 per 1%.
     *
     * This is the representation that reveals STRUCTURE without needing to interpret
     * any content: a card edge is a step change, a gap is a dip, a shadow is a
     * gradient. Reading band boundaries off this is mechanical, whereas reading them
     * off an ASCII picture involves judgement.
     */
    fun renderRowProfile(src: Bitmap): String {
        val sb = StringBuilder()
        sb.append("Row brightness profile of ${src.width}x${src.height}\n")
        sb.append("percent: mean(0-99) | bar\n\n")
        val rows = 100
        for (r in 0 until rows) {
            val y0 = r * src.height / rows
            val y1 = ((r + 1) * src.height / rows).coerceAtLeast(y0 + 1)
            val mean = meanLuminance(src, 0, y0, src.width, y1)
            val scaled = (mean * 99 / 255).toInt()
            val bar = "#".repeat(scaled / 3)
            sb.append("%3d%% %3d |%s\n".format(r, scaled, bar))
        }
        return sb.toString()
    }

    // ---- helpers ----------------------------------------------------------

    private fun luminance(p: Int): Float {
        val r = (p shr 16) and 0xFF
        val g = (p shr 8) and 0xFF
        val b = p and 0xFF
        // Rec.601 luma — matches how the eye weights the channels.
        return 0.299f * r + 0.587f * g + 0.114f * b
    }

    private fun meanLuminance(src: Bitmap, x0: Int, y0: Int, x1: Int, y1: Int): Float {
        val w = (x1 - x0).coerceAtLeast(1)
        val h = (y1 - y0).coerceAtLeast(1)
        var sum = 0.0
        var n = 0
        // Sample on a fixed stride rather than every pixel: a 1080x2400 screenshot has
        // 2.6M pixels and touching all of them per cell is needlessly slow. A 4px
        // stride is still far finer than a grid cell.
        val stride = 4
        var y = y0
        while (y < y1 && y < src.height) {
            var x = x0
            while (x < x1 && x < src.width) {
                sum += luminance(src.getPixel(x, y))
                n++
                x += stride
            }
            y += stride
        }
        return if (n == 0) 0f else (sum / n).toFloat()
    }

    private fun meanColor(src: Bitmap, x0: Int, y0: Int, x1: Int, y1: Int): Pair<Int, Int> {
        val stride = 4
        var rs = 0L; var gs = 0L; var bs = 0L; var n = 0L
        var minL = 255f; var maxL = 0f
        var y = y0
        while (y < y1 && y < src.height) {
            var x = x0
            while (x < x1 && x < src.width) {
                val p = src.getPixel(x, y)
                val r = (p shr 16) and 0xFF
                val g = (p shr 8) and 0xFF
                val b = p and 0xFF
                rs += r; gs += g; bs += b; n++
                val l = luminance(p)
                if (l < minL) minL = l
                if (l > maxL) maxL = l
                x += stride
            }
            y += stride
        }
        if (n == 0L) return 0 to 0
        val avg = ((rs / n).toInt() shl 16) or ((gs / n).toInt() shl 8) or (bs / n).toInt()
        return avg to (maxL - minL).toInt()
    }

    /** Reference implementation of a minimal PNG inflate, kept for documentation. */
    @Suppress("unused")
    private fun inflateIdat(raw: ByteArray): ByteArray {
        val inf = Inflater()
        inf.setInput(raw)
        val out = ByteArray(1 shl 20)
        val n = inf.inflate(out)
        inf.end()
        return out.copyOf(n)
    }
}
