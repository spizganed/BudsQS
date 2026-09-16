package com.spizganed.quickbuds.protocol

/**
 * Decoder for the 0x0204 "user interaction" active report — the F1 family.
 *
 * Frame shape (captured on Buds 4, 5 samples across several sessions):
 *
 *     AA 0D 00 00 04 02 FF 06 00 F1 01 01 XX YY 02
 *     |  |  |  |  |  |  |  |  |  |  |  |  |  |  +-- ? (constant 0x02 so far)
 *     |  |  |  |  |  |  |  |  |  |  |  |  +--+----- options int16 (see below)
 *     |  |  |  |  |  |  |  |  |  |  |  +---------- payload[4] = context/field
 *     |  |  |  |  |  |  |  |  |  |  +------------- payload[3] = button id
 *     |  |  |  |  |  |  |  |  |  +---------------- payload[2] = action
 *     |  |  |  |  |  |  |  |  +------------------- payload[1] = side (0x01 L, 0x02 R)
 *     |  |  |  |  |  |  |  +---------------------- payload[0] = subType 0xF1
 *     |  |  |  |  |  |  +------------------------- 0x06  (payload length)
 *     |  |  |  |  |  +---------------------------- 0xFF  (event marker)
 *     |  |  |  |  +------------------------------- 0x02  (sub-command)
 *     |  |  |  +---------------------------------- 0x04  (active report)
 *     +--+--+------------------------------------- length / flags
 *
 * SOURCE (not guessed): Zhaoyi-ya/OppoPodsManager, `Models/UserInteractionEventInfo.cs`.
 * That class is explicitly documented as the data body of "0x0204 subType=0xF1", derived
 * from the Melody APK (`h.b()` packed-switch offset -0xf). Its field order matches this
 * frame byte for byte, including the trailing int16 options array.
 *
 *     byte0 = side        0x01 = left, 0x02 = right (confirmed by that project)
 *     byte1 = button id   model dependent (0x06 on Enco Air5 Pro)
 *     byte2 = action      0x00 single, 0x02 double, 0x03 triple,
 *                         0x04 long press, 0x07 slide up, 0x08 slide down
 *     byte3 = modifier    non-zero on some long presses
 *     byte4 = context
 *     then  = int16 options, little endian
 *
 * WHY THIS MATTERS (do not delete): ANC changes made on the BUDS raise no 0x0204
 * subtype event — verified three times. The open question after every ANC gesture
 * capture has been "did the buds say nothing at all, or did they speak in a frame we
 * simply don't name?" This is the candidate for the second case. Until a capture shows
 * an F1 frame landing ~a second after a gesture, the link is UNPROVEN — treat the F1
 * log line as diagnostic evidence, not as a control signal.
 */
object UserInteractionParser {

    /** SubType of the user-interaction active report. */
    const val EVT_USER_INTERACTION = 0xF1

    /** True if this 0x0204 payload is a user-interaction (button/gesture) event. */
    fun isUserInteractionEvent(payload: ByteArray): Boolean {
        if (payload.size < 3) return false
        return payload[0].toInt() and 0xFF == EVT_USER_INTERACTION
    }

    private fun sideName(v: Int): String = when (v) {
        0x01 -> "L"
        0x02 -> "R"
        else -> "?0x%02X".format(v)
    }

    private fun actionName(v: Int): String = when (v) {
        0x00 -> "single tap"
        0x02 -> "double tap"
        0x03 -> "triple tap"
        0x04 -> "long press"
        0x07 -> "slide up"
        0x08 -> "slide down"
        else -> "action=0x%02X".format(v)
    }

    /**
     * Human-readable one-liner for the log, e.g.
     * "L btn0x01 long press (ctx=0x02 opts=[2])".
     */
    fun describe(payload: ByteArray): String {
        if (!isUserInteractionEvent(payload)) return "not a user-interaction event"
        // payload[0] = 0xF1, fields start at payload[1].
        val side = payload.getOrElse(1) { 0 }.toInt() and 0xFF
        val button = payload.getOrElse(2) { 0 }.toInt() and 0xFF
        val action = payload.getOrElse(3) { 0 }.toInt() and 0xFF
        val modifier = payload.getOrElse(4) { 0 }.toInt() and 0xFF
        val context = payload.getOrElse(5) { 0 }.toInt() and 0xFF

        // Options: little-endian int16 pairs from payload[5] onward, matching
        // UserInteractionEventInfo's own walk (pos += 2 while pos+1 < end).
        val options = mutableListOf<Int>()
        var pos = 5
        while (pos + 1 < payload.size) {
            options.add((payload[pos].toInt() and 0xFF) or ((payload[pos + 1].toInt() and 0xFF) shl 8))
            pos += 2
        }

        val sb = StringBuilder()
        sb.append(sideName(side))
        sb.append(" btn=0x").append("%02X".format(button))
        sb.append(' ').append(actionName(action))
        if (modifier != 0) sb.append(" +0x").append("%02X".format(modifier))
        sb.append(" ctx=0x").append("%02X".format(context))
        if (options.isNotEmpty()) sb.append(" opts=[").append(options.joinToString(",")).append(']')
        return sb.toString()
    }
}
