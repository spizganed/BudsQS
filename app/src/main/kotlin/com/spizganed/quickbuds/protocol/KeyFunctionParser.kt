package com.spizganed.quickbuds.protocol

/**
 * Parser for the `0x8108` reply to `getKeyFunction` (`0x0108`) — the CURRENT
 * gesture bindings, as the buds themselves report them.
 *
 * WHY THIS EXISTS: gesture configuration is blocked on one unknown, the `function`
 * enum (which value means ANC cycle / game mode / voice assistant). Nobody
 * publishes it. This reply describes the CURRENT assignment, so DIFFING two
 * readings — before and after changing one gesture in HeyMelody — reveals the enum
 * without an HCI capture. It is a READ, so it cannot change a binding.
 *
 * THE LAYOUT IS NOW [CAPTURE], AND THE FIRST READING OF IT WAS WRONG.
 * The `[OSS]` shape `<count> <4-byte entries>` omitted a LEADING STATUS BYTE, so
 * the first real reply printed `count=0 parsed=18 !LAYOUT`. The payload is:
 *
 *     <status> <count> <deviceType, button, buttonAction, function>...
 *      0x00     0x12     4 bytes each
 *
 * Evidence: a 74-byte payload, `00 12 ...`, where 2 + 0x12*4 = 74 EXACTLY. The
 * count is the second byte. `KeyFunctionItem.cs` does not model this: it describes
 * ONE entry's bytes, not the payload around it — which is exactly how the off-by-one
 * got in. See PROTOCOL.md §6 and local/logs/keyfn-reply-capture.txt.
 *
 * THE ENTRY FIELD ORDER IS AS THAT FILE SAYS, and the reply supports it: the third
 * byte is a small value (1..6, one per action this button supports) and the fourth
 * is the function (`0x00`, `0x07`, `0x08`, `0x11` seen). Swapping them would make
 * the "action" set `{0x00, 0x07, 0x08, 0x11}` and the "function" set `{1..6}`,
 * which is the less plausible reading.
 *
 * WHAT IS STILL UNKNOWN, AND MUST NOT BE NAMED:
 *   - the `function` VALUES: no name attaches to `0x00` / `0x07` / `0x08` / `0x11`.
 *   - the `buttonAction` NUMBERS: they are NOT the `0x0204` subType `0xF1` action
 *     numbers. `F1` reports single tap as `0x00` and long press as `0x04`; this
 *     reply binds `0x01` as well as `0x04`. Plausible that 1..6 = single, double,
 *     triple, long press, slide up, slide down, but that is `[GUESS]`.
 *
 * So BOTH mutable fields are printed as NUMBERS ONLY. A dropdown built on a guessed
 * enum looks finished while sending the wrong thing, and guessing ANC bits already
 * cost this project a regression (PROTOCOL.md §5).
 *
 * Because the layout is exactly the thing that was once wrong here, the log line
 * still ends with `RAW=[...]`, so a capture stays readable by eye even if a future
 * firmware reshapes the reply.
 */
object KeyFunctionParser {

    /** Bytes per entry: deviceType, button, buttonAction, function. [OSS]+[CAPTURE] */
    const val ENTRY_SIZE = 4

    /**
     * Bytes before the first entry: a status/result byte, then the count.
     * `[CAPTURE]` — see the class comment. The count is NOT `payload[0]`.
     */
    const val HEADER_SIZE = 2

    data class Entry(
        val deviceType: Int,
        val button: Int,
        val action: Int,
        val function: Int
    )

    /**
     * Named `Table`, not `Result` — a nested class called `Result` collided with
     * `kotlin.Result` and failed to compile ("inferred type is Result but Result
     * was expected"). Do not rename it back.
     */
    data class Table(
        /** `payload[0]` — a status/result byte, `0x00` in every reply so far. */
        val status: Int,
        val count: Int,
        val entries: List<Entry>,
        /** Bytes left over after `entries` — non-empty means the layout is wrong. */
        val trailing: ByteArray,
        /** True when `count` disagrees with the number of whole entries found. */
        val layoutMismatch: Boolean
    )

    /**
     * Structured read. Tolerant by design: it reads as many whole 4-byte entries as
     * the payload holds and reports any shortfall instead of throwing, so a reshaped
     * reply still prints something a human can read.
     */
    fun parse(payload: ByteArray): Table {
        if (payload.size < HEADER_SIZE) {
            return Table(-1, 0, emptyList(), payload.copyOf(), true)
        }
        val status = payload[0].toInt() and 0xFF
        val count = payload[1].toInt() and 0xFF
        val body = payload.copyOfRange(HEADER_SIZE, payload.size)

        val whole = body.size / ENTRY_SIZE
        val entries = ArrayList<Entry>(whole)
        for (i in 0 until whole) {
            val o = i * ENTRY_SIZE
            entries.add(
                Entry(
                    deviceType = body[o].toInt() and 0xFF,
                    button = body[o + 1].toInt() and 0xFF,
                    action = body[o + 2].toInt() and 0xFF,
                    function = body[o + 3].toInt() and 0xFF
                )
            )
        }
        val trailing = body.copyOfRange(whole * ENTRY_SIZE, body.size)
        // The count byte should account for every entry AND leave nothing over.
        val mismatch = count != whole || trailing.isNotEmpty()
        return Table(status, count, entries, trailing, mismatch)
    }

    /**
     * One log line for the reply, GROUPED PER DEVICE/BUTTON and ending with the raw
     * payload:
     *
     *     getKeyFunction reply: status=0x00 count=18 parsed=18
     *       dev=0x01/btn=0x01[01:00 02:11 ...] dev=0x01/btn=0x06[...] ...
     *
     * `act:fn` pairs, both as raw numbers. The grouping is the point: the reply is
     * read in order to be COMPARED with one taken after a HeyMelody change, and a
     * per-button list makes the single entry that moved obvious. Groups are sorted by
     * (device, button) so each bud's rows sit together; the entries inside a group
     * keep the buds' own order, which is itself a fact about their action enum.
     */
    fun describe(payload: ByteArray): String {
        val raw = payload.joinToString(" ") { "%02X".format(it) }
        if (payload.isEmpty()) return "getKeyFunction reply: EMPTY payload RAW=[]"

        val r = parse(payload)
        val sb = StringBuilder("getKeyFunction reply: status=0x")
        sb.append("%02X".format(r.status)).append(" count=").append(r.count)
            .append(" parsed=").append(r.entries.size)
        if (r.entries.isEmpty()) {
            sb.append(" (no whole ").append(ENTRY_SIZE).append("-byte entries)")
        }
        val groups = sortedMapOf<Int, StringBuilder>()
        for (e in r.entries) {
            val key = (e.deviceType shl 8) or e.button
            val g = groups.getOrPut(key) { StringBuilder() }
            if (g.isNotEmpty()) g.append(' ')
            g.append("%02X:%02X".format(e.action, e.function))
        }
        for ((key, g) in groups) {
            sb.append(" dev=0x").append("%02X".format((key shr 8) and 0xFF))
                .append("/btn=0x").append("%02X".format(key and 0xFF))
                .append('[').append(g).append(']')
        }
        if (r.trailing.isNotEmpty()) {
            sb.append(" trailing=[").append(r.trailing.joinToString(" ") { "%02X".format(it) })
            sb.append(']')
        }
        if (r.layoutMismatch) {
            sb.append(" !LAYOUT expected ").append(HEADER_SIZE).append('+').append(r.count)
                .append('*').append(ENTRY_SIZE)
                .append(" bytes, got ").append(payload.size)
        }
        sb.append(" RAW=[").append(raw).append(']')
        return sb.toString()
    }
}