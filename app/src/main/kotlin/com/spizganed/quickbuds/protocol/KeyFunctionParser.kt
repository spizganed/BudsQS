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

    /**
     * The physical-button group: what every `F1` frame this project has captured reports
     * (`btn=0x01` on both buds), so it is where the user's taps and holds live.
     *
     * It is NOT the only group a gesture writes to, and treating it as such was a real bug
     * — see [BUTTON_ON_CALL_GUESS] and `writeGestureBinding()`.
     */
    const val BUTTON_PRIMARY = 0x01

    /**
     * The group we NEVER write: `btn 0x06`, believed to be the on-call bindings.
     *
     * It carries its own smaller gesture list (`act 02/03/06`) and every entry in it reads
     * `fn=0x00` = "no action", which is what an unset on-call group looks like. NO capture
     * has ever reported an `F1` frame for it, so the guess is unconfirmed — which is exactly
     * why a write leaves it **byte-for-byte untouched** rather than "fixing" it.
     *
     * This matters because `act 0x02` and `act 0x03` exist in BOTH `btn 0x01` and `btn 0x06`.
     * A write that matched on (side, action) alone would silently re-bind a second, unrelated
     * gesture — the kind of change nothing in our UI would show.
     */
    const val BUTTON_ON_CALL_GUESS = 0x06

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

    /**
     * Canonical, order-independent signature of a reading: one
     * `dev=0x01/btn=0x01 act=0x02 -> 0x11` token per entry, sorted.
     *
     * A PLAIN STRING on purpose, so it can be STORED between connections. The
     * experiment this exists for requires disconnecting our app — the vendor app needs
     * the RFCOMM socket — and reconnecting it, which may restart the process. An
     * in-memory baseline would be lost exactly in the gap it exists to span, and a lost
     * baseline is indistinguishable from "nothing changed".
     */
    fun signature(table: Table): String =
        table.entries
            .map { slotOf(it) + " -> " + "0x%02X".format(it.function) }
            .sorted()
            .joinToString("; ")

    /** `dev=0x01/btn=0x01 act=0x02` — the part of an entry a function is bound TO. */
    private fun slotOf(e: Entry): String =
        "dev=0x%02X/btn=0x%02X act=0x%02X".format(e.deviceType, e.button, e.action)

    /**
     * Describes ONLY what moved between two readings, which is the whole reason the
     * reply is read: change ONE gesture in the vendor app and the single `fn` that
     * moved names that function's value. The line is built for exactly that reading:
     *
     *     dev=0x01/btn=0x01 act=0x02: 0x00 -> 0x12
     *
     * A slot present in only ONE of the two is reported as added/removed, because a
     * missing entry is a different fact from a changed one — and on this firmware a
     * slot does appear and disappear as a binding is cleared.
     *
     * NO CHANGE is stated explicitly rather than returning an empty string, because it
     * is a REAL RESULT here: rebinding the HOLD cannot move `fn` at all (the vendor app
     * offers the hold only the ANC cycle), so "nothing moved" is the expected outcome
     * of that particular experiment and must not be readable as a failure to run.
     */
    fun diff(previous: String, current: String): String {
        val before = parseSignature(previous)
        val after = parseSignature(current)
        if (before.isEmpty() && after.isEmpty()) return "unreadable baseline and reading"

        val changed = ArrayList<String>()
        for (slot in (before.keys + after.keys).sorted()) {
            val a = before[slot]
            val b = after[slot]
            when {
                a == null -> changed.add("$slot added: 0x%02X".format(b!!))
                b == null -> changed.add("$slot removed (was 0x%02X)".format(a))
                a != b -> changed.add("$slot: 0x%02X -> 0x%02X".format(a, b))
            }
        }
        return if (changed.isEmpty()) {
            "NO CHANGE (${after.size} slots identical)"
        } else {
            changed.joinToString(" | ")
        }
    }

    /** `dev=0x01/btn=0x01 act=0x02 -> 0x11` tokens -> slot to function. */
    private fun parseSignature(sig: String): Map<String, Int> {
        val out = HashMap<String, Int>()
        for (token in sig.split(';')) {
            if (token.isBlank()) continue
            val at = token.lastIndexOf(" -> ")
            if (at <= 0) continue
            val fn = parseHex(token.substring(at + 4)) ?: continue
            out[token.substring(0, at).trim()] = fn
        }
        return out
    }

    /**
     * Reads a `0x`-prefixed hex byte out of a signature, or null if it is not one.
     *
     * WHY NOT `toIntOrNull(16)`: that delegates to `Integer.parseInt`, which REJECTS a
     * `0x` prefix. Since [signature] writes exactly that prefix, the naive call returns
     * null for EVERY field, so [parseSignature] yields an empty map for both readings and
     * every diff silently reports "unreadable baseline and reading" — a failure that
     * looks like an inconclusive experiment rather than a bug. Strip the prefix first.
     */
    private fun parseHex(s: String): Int? {
        val t = s.trim()
        val body = if (t.startsWith("0x", ignoreCase = true)) t.substring(2) else t
        if (body.isEmpty()) return null
        return body.toIntOrNull(16)
    }
}