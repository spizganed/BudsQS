package com.spizganed.quickbuds.protocol

/**
 * Parser for the 0x0204 subType 0x03 "ANC changed on the buds" active report.
 *
 * Frame shape (14 bytes):
 *
 *     AA 0C 00 00 04 02 FF 05 00 03 01 01 20 00
 *     |  |  |  |  |  |  |  |  |  |  |  |  +--+-- value (2 bytes, little endian)
 *     |  |  |  |  |  |  |  |  |  |  +--+-------- 0x01 0x01 (constant)
 *     |  |  |  |  |  |  |  |  |  +--------------- payload[0] = subType 0x03
 *     |  |  |  |  |  |  |  |  +------------------ payLen = 5
 *     |  |  |  |  |  |  +---------------------- 0xFF (event marker)
 *     |  |  |  |  |  +------------------------- sub-command 0x02
 *     |  |  |  |  +---------------------------- 0x04 (active report)
 *     |  |  |  +------------------------------- 0x00 0x00
 *     +--+--+---------------------------------- sync 0xAA + length (total - 2)
 *
 * PAYLOAD is exactly 5 bytes: `03 01 01 LO HI`.
 *
 * THE MAPPING IS NOW CONFIRMED (2026-09-18, capture with a known starting mode).
 * He cycled from Off on BOTH buds and reported the order, and both buds produced
 * the identical three values, so this is not side-dependent:
 *
 *     start        Off
 *     1st gesture  03 01 01 20 00   -> 0x0020   ANC on   (Medium)
 *     2nd gesture  03 01 01 00 01   -> 0x0100   Transparency
 *     3rd gesture  03 01 01 08 00   -> 0x0008   Off
 *
 * An earlier capture began from a different level and gave 0x0010 for its
 * "ANC on" stop, which is exactly the pattern to expect: the value is the buds'
 * own ANC bitmask (bit `index` set), so the ANC-on stop restores whichever LEVEL
 * was last used — 0x0010 = Deep (bit 4), 0x0020 = Medium (bit 5). That is the same
 * encoding OpoProtocol.ancPayload() writes. So this must NOT be treated as a
 * fixed enum of three values.
 *
 * WHY THE FRAME WAS INVISIBLE FOR THREE CAPTURES: `noteUnattributed` in
 * BudsConnectionManager blanket-excludes cmd 0x0204, so an undecoded 0x0204
 * subType prints NOTHING AT ALL. The F1 button frame fires for every gesture with
 * identical content, so it says WHEN but never WHAT. Both are documented below
 * because that combination is what made ANC look silent.
 */
object AncEventParser {

    /** 0x0204 subType: ANC mode changed on the buds. */
    const val EVT_ANC = 0x03

    /** True if this 0x0204 payload is an ANC-changed event. */
    fun isAncEvent(payload: ByteArray): Boolean {
        if (payload.size < 4) return false
        return payload[0].toInt() and 0xFF == EVT_ANC
    }

    /**
     * Raw 16-bit value from the event, little endian, or -1 if too short.
     * Kept separate from the name lookup so a capture can always be read back as
     * numbers, even when the name table is incomplete.
     */
    fun rawValue(payload: ByteArray): Int {
        if (payload.size < 5) return -1
        return (payload[3].toInt() and 0xFF) or ((payload[4].toInt() and 0xFF) shl 8)
    }

    /**
     * ANC mode name for a raw event value, or null if it cannot be named.
     *
     * THE NOTIFY TABLE, fully confirmed — our own observations plus the
     * `AncValues` dictionary in OppoPodsManager `Protocol/OppoProtocol.Anc.cs`.
     * Both agree exactly, and the two-byte value is (Val1, Val2) little endian:
     *
     *     08 00  Off                   20 00  Medium
     *     02 00  ANC (generic)         10 00  Deep
     *     80 00  Smart                 00 01  Transparency
     *     40 00  Light                 00 02  Transparency (voice enhance on)
     *                                  00 08  Adaptive
     *
     * THIS IS NOT THE SET_ANC TABLE. Setting uses bit 0 for Off and bit 2 for
     * Transparency (see OpoProtocol.ancPayload); the buds REPORT with bits 3 and
     * 8. The two encodings genuinely differ — do not unify them.
     *
     * `currentLevel` is used ONLY for an unlisted ANC bit, so the UI highlights the
     * right circle rather than guessing a level; it never overrides a known value.
     * Adaptive is now named as itself (`0x0800 -> "Adaptive"`), not folded into Light.
     * The fold was correct while the app had NO Adaptive control; it has one now, so a
     * bud-side Adaptive must light the ADAPT circle rather than ANC-L.
     */
    fun modeForRaw(raw: Int, currentLevel: String? = null): String? = when (raw) {
        0x0008 -> "Off"
        0x0100 -> "Transparency"
        0x0200 -> "Transparency"
        0x0800 -> "Adaptive"    // its own circle; see MainActivity.circleFor
        0x0010 -> "ANC-Deep"
        0x0020 -> "ANC-Medium"
        0x0040 -> "ANC-Light"
        0x0080 -> "ANC-Light"
        else -> {
            val ancBits = raw and (0x0002 or 0x0010 or 0x0020 or 0x0040 or 0x0080)
            if (ancBits != 0) {
                if (currentLevel in listOf("ANC-Light", "ANC-Medium", "ANC-Deep")) {
                    currentLevel
                } else {
                    "ANC-Light"
                }
            } else {
                null
            }
        }
    }

    /** Reads the ANC mode from a 0x0204 subType 0x03 payload. Null if unreadable. */
    fun parseActive(payload: ByteArray, currentLevel: String? = null): String? {
        if (!isAncEvent(payload)) return null
        val raw = rawValue(payload)
        if (raw < 0) return null
        return modeForRaw(raw, currentLevel)
    }

    /** One-liner for the log, e.g. "raw=0x0020 -> ANC-Medium". */
    fun describe(payload: ByteArray, currentLevel: String? = null): String {
        val raw = rawValue(payload)
        if (raw < 0) return "ANC event (payload too short)"
        val hex = "0x%04X".format(raw)

        // The old 0x0800 special case is GONE, and it is worth saying why rather than
        // just deleting it: it existed because modeForRaw() folded Adaptive into
        // "ANC-Light", so the four-stop cycle he ran printed "raw=0x0040 -> ANC-Light"
        // followed by "raw=0x0800 -> ANC-Light" — two different stops, identical lines.
        // NAMING Adaptive is what fixes that, at the source; a special case in the log
        // formatter only papered over the indistinguishable mapping.
        val mode = modeForRaw(raw, currentLevel)
        return if (mode == null) "raw=$hex -> unknown ANC value" else "raw=$hex -> $mode"
    }
}
