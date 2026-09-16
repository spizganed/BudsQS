package com.spizganed.quickbuds.protocol

/**
 * Parser for the 0x0204 subType 0x05 "game mode changed" active report.
 *
 * Frame shape (7-byte payload after the 8-byte header):
 *
 *     AA 09 00 00 04 02 FF 02 00 05 01
 *     |  |  |  |  |  |  |  |  |  |  +-- payload[1] = state (0x01 ON, 0x00 OFF)
 *     |  |  |  |  |  |  |  |  |  +----- payload[0] = subType 0x05
 *     |  |  |  |  |  |  |  |  +-------- 0x00  (constant)
 *     |  |  |  |  |  |  |  +---------- 0x02  (constant)
 *     |  |  |  |  |  |  +------------- 0xFF  (event marker, same as wear/battery)
 *     |  |  |  |  +-------------------- sub-command 0x02
 *     |  |  |  +----------------------- 0x04  (active report)
 *     +--+--+-------------------------- length / flags
 *
 * The length field is 0x09 (9) because the payload is only 2 bytes, versus 8 for
 * wear and 6 for battery. Do not assume a fixed frame length.
 *
 * EVIDENCE (five samples, all from one continuous capture, `bytes[1]` = state):
 *
 *   time          frame                        state   cause
 *   14:00:44.480  ... 04 02 FF 02 00 05 01       ON     TX[GameMode] ON  (... 06 01)
 *   14:34:04.881  ... 04 02 FF 02 00 05 00       OFF    TX[GameMode] OFF (... 06 00)
 *   14:45:54.627  ... 04 02 FF 02 00 05 01       ON     TX[GameMode] ON  (... 06 01)
 *   14:50:32.433  ... 04 02 FF 02 00 05 00       OFF    BUDS GESTURE (no TX)
 *   14:50:35.743  ... 04 02 FF 02 00 05 01       ON     BUDS GESTURE (no TX)
 *
 * The last two are the important ones: they arrive with no preceding TX frame, so
 * this is a genuine push from the buds and not an echo of our own command. State
 * correlates 5/5 with the game-mode value, so the encoding is safe to rely on.
 *
 * IMPORTANT SCOPE LIMIT: this event is GAME MODE ONLY. It is NOT raised for ANC
 * changes — ANC Off at 14:41:46 and ANC Light at 14:43:57 produced no 0x05 frame.
 * Do not try to read ANC out of this packet.
 */
object GameModeParser {

    /** True if this 0x0204 payload is a game-mode change event. */
    fun isGameModeEvent(payload: ByteArray): Boolean {
        if (payload.size < 2) return false
        return payload[0].toInt() and 0xFF == OpoProtocol.EVT_GAME_MODE
    }

    /**
     * Reads the game-mode state from a 0x0204 subType 0x05 payload.
     * Returns null when the payload is too short to contain a state byte.
     */
    fun parseActive(payload: ByteArray): Boolean? {
        if (!isGameModeEvent(payload)) return null
        // payload[1]: 0x01 = ON, 0x00 = OFF.
        // Read as "non-zero means ON" rather than "== 1" so an unexpected value
        // still produces a sane state instead of decoding as OFF.
        return (payload[1].toInt() and 0xFF) != 0
    }
}
