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
 *                         for the taps this is ALSO the key-function `act` — see below
 *     byte3 = the bound FUNCTION, as the buds report it — matching the 0x8108 reply's
 *                         `function` byte. See the correspondence below.
 *     byte4 = context
 *     then  = int16 options, little endian
 *
 * THE OLD CLAIM HERE WAS WRONG — do not restore it. This comment used to say "ANC
 * changes made on the BUDS raise no 0x0204 subtype event — verified three times".
 * They DO: subType 0x03, mapped in AncEventParser, and the belief survived three
 * captures only because `noteUnattributed` blanket-excludes cmd 0x0204, so an
 * undecoded subType printed nothing at all (PROTOCOL.md §5).
 *
 * WHAT THE F1 FRAME IS FOR: it says WHEN, and which side and action. On a real ANC
 * hold, F1 lands FIRST and the 0x0204 subType 0x03 frame follows 1.3-2.0 s later.
 * So a capture window that stops at the F1 line misses the answer, and the F1 log
 * line stays diagnostic evidence, never a control signal.
 *
 * THE CONCLUSION THAT USED TO SIT HERE WAS TOO STRONG, and it is kept only so it is not
 * restored. It read "byte3 is identical for every gesture of the same action+side,
 * therefore it cannot say what the gesture did", with two long presses — one cycling ANC,
 * one firing voice assistant — offered as the proof. That example cannot exist: the hold
 * is offered only the ANC modes, so a hold cannot be bound to voice assistant, and a
 * binding is one function per (device, button, action) anyway. The observation never
 * supported the conclusion.
 *
 * BYTE2 AND BYTE3 ARE THE KEY-FUNCTION MAPPING. PROTOCOL.md §6.1 asked whether byte3
 * carries the bound function. It does — and byte2 carries the key-function *action*
 * number, so the F1 frame is the key-function entry for the gesture that fired:
 *
 *     F1 payload      byte2  byte3   key-function entry      its fn
 *     01 01 01 01 0x    01     01     dev=01/btn=01 act 01     0x01
 *     01 01 02 06 0x    02     06     dev=01/btn=01 act 02     0x06
 *     01 01 03 05 0x    03     05     dev=01/btn=01 act 03     0x05
 *     01 01 04 08 0x    04     08     dev=01/btn=01 act 04     0x08
 *
 * Four independent slots, four DIFFERENT function values, all matching — that is not a
 * coincidence, and byte2 == the key-function `act` in every one of them. The F1 numbering
 * is therefore NOT the key-function numbering (as §6.1 already warned); byte2 here is
 * already a key-function `act`, not an F1 action id.
 *
 * AN EARLIER REVISION OF THIS COMMENT CLAIMED THE OPPOSITE, using this frame as its
 * counter-example:
 *
 *     payload F1 01 01 00 00 03   byte2 = 0x00, byte3 = 0x00 (parsed as "single tap")
 *     key-function table:         act 01 -> fn 0x01
 *
 * byte3 (0x00) is not fn (0x01), so the theory was declared dead. That was too hasty:
 * byte2 = 0x00 is not a key-function `act` at all (the table has none — its acts are
 * 1..6), so this frame is not the single-tap BINDING entry and is not comparable to one.
 * It is very likely a different event (a touch/tap report rather than a binding firing),
 * which also means the [OSS] reading of 0x00 as "single tap" is suspect.
 *
 * STILL UNEXPLAINED, and the reason this is not written as settled:
 *   - slides. byte2 0x07 / 0x08 give byte3 0x05 / 0x06, while the slide slot's fn is
 *     0x0A. Possibly "switch track" (0x0A) is a COMPOSITE that the firmware reports
 *     per-direction as prev (0x05) and next (0x06) — coherent, but unproven.
 *   - whether byte2 is ever an F1 action number, or always a key-function `act`.
 *
 * So: this frame MAY carry the function, and the evidence for that is now strong rather
 * than absent. It is still not a control signal — nothing may switch on byte3 until the
 * two outliers above are explained.
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
