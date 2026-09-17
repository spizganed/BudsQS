package com.spizganed.quickbuds.protocol

/**
 * Parser for the `0x8108` reply to `getKeyFunction` (`0x0108`) — the CURRENT
 * gesture bindings, as the buds themselves report them.
 *
 * WHY THIS EXISTS: gesture configuration is blocked on one unknown, the `function`
 * enum (which value means ANC cycle / game mode / voice assistant). Nobody
 * publishes it. This reply may hand it to us straight from the device, which would
 * remove the need for a HeyMelody capture. It is a READ, so it cannot change a
 * binding or break anything.
 *
 * THE ENTRY LAYOUT IS A [OSS] ASSUMPTION, NOT A CAPTURE. From `KeyFunctionItem.cs`
 * in OppoPodsManager, the payload is:
 *
 *     <count> <deviceType, button, buttonAction, function>...
 *
 * Each entry is 4 bytes. That is the ONLY source for this shape, so this parser
 * NEVER hides the raw bytes: the log line always ends with `RAW=[...]`, so a
 * capture can still be read by eye if the shape turns out to be wrong. A layout
 * mismatch is reported as `!LAYOUT` rather than being silently padded.
 *
 * The `function` byte is printed as a NUMBER ONLY. It is deliberately not named:
 * guessing ANC bits already cost this project a regression (PROTOCOL.md §5), and a
 * dropdown built on a guessed enum is worse than no UI. Names go in only once an
 * observed reply or a HeyMelody capture confirms them.
 */
object KeyFunctionParser {

    /** Bytes per entry, per KeyFunctionItem.cs. [OSS] — unconfirmed by capture. */
    const val ENTRY_SIZE = 4

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
        val count: Int,
        val entries: List<Entry>,
        /** Bytes left over after `entries` — non-empty means the layout is wrong. */
        val trailing: ByteArray,
        /** True when `count` disagrees with the number of whole entries found. */
        val layoutMismatch: Boolean
    )

    /**
     * Structured read. Tolerant by design: it reads as many whole 4-byte entries as
     * the payload holds and reports any shortfall instead of throwing.
     */
    fun parse(payload: ByteArray): Table {
        if (payload.isEmpty()) {
            return Table(0, emptyList(), ByteArray(0), true)
        }
        val count = payload[0].toInt() and 0xFF
        val body = payload.copyOfRange(1, payload.size)

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
        return Table(count, entries, trailing, mismatch)
    }

    /**
     * One log line for the reply: counts, per-entry bytes, and the raw payload last
     * so the raw bytes survive even if the layout guess is wrong.
     */
    fun describe(payload: ByteArray): String {
        val raw = payload.joinToString(" ") { "%02X".format(it) }
        if (payload.isEmpty()) return "getKeyFunction reply: EMPTY payload RAW=[]"

        val r = parse(payload)
        val sb = StringBuilder("getKeyFunction reply: count=")
        sb.append(r.count).append(" parsed=").append(r.entries.size)
        if (r.entries.isEmpty()) {
            sb.append(" (no whole ").append(ENTRY_SIZE).append("-byte entries)")
        }
        for (e in r.entries) {
            sb.append(" [dev=0x").append("%02X".format(e.deviceType))
            sb.append(" btn=0x").append("%02X".format(e.button))
            sb.append(" act=0x").append("%02X".format(e.action))
            // fn= is the unknown: printed, never named. See the class comment.
            sb.append(" fn=0x").append("%02X".format(e.function)).append(']')
        }
        if (r.trailing.isNotEmpty()) {
            sb.append(" trailing=[").append(r.trailing.joinToString(" ") { "%02X".format(it) })
            sb.append(']')
        }
        if (r.layoutMismatch) {
            sb.append(" !LAYOUT expected 1+").append(r.count).append('*').append(ENTRY_SIZE)
                .append(" bytes, got ").append(payload.size)
        }
        sb.append(" RAW=[").append(raw).append(']')
        return sb.toString()
    }
}
