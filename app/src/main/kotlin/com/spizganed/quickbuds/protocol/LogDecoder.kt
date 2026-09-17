package com.spizganed.quickbuds.protocol

/**
 * Decodes raw PacketLogger lines (e.g. "TX[handshake]: AA 07 00 00 ...")
 * into human-readable descriptions for the Dev Tools screen (roadmap #7).
 *
 * Lines that don't contain a hex payload (pure status messages like
 * "Already connecting/connected, ignoring." or "WEAR EVT: L=EAR ...")
 * are passed through as-is for the human-readable view.
 */
object LogDecoder {

    enum class Direction { TX, RX, STATUS }

    /** Describes a decoded packet for human-readable display. */
    data class DecodedLine(
        val rawTimestamp: String,
        val direction: Direction,
        val label: String?,
        val description: String,
        val hexPayload: String?
    )

    /**
     * Timestamp for the human-readable view: "HH:mm:ss", milliseconds removed.
     * The raw hex view keeps the full "HH:mm:ss.SSS" from the log line.
     */
    fun displayTime(timestamp: String): String {
        val dot = timestamp.lastIndexOf('.')
        return if (dot > 0) timestamp.substring(0, dot) else timestamp
    }

    /**
     * Decode a single PacketLogger line into a human-readable description.
     * For lines with hex payloads (TX/RX), the description is a decoded
     * packet interpretation. For all other lines, the message is passed
     * through unchanged.
     */
    fun decode(line: String): DecodedLine {
        // Split: "HH:mm:ss.SSS  message"
        val sep = line.indexOf("  ")
        val timestamp = if (sep >= 0) line.substring(0, sep) else ""
        val msg = if (sep >= 0) line.substring(sep + 2) else line

        var hexPart: String? = null
        var direction: Direction = Direction.STATUS
        var label: String? = null

        if (msg.startsWith("TX[")) {
            direction = Direction.TX
            val bracketEnd = msg.indexOf(']')
            if (bracketEnd > 2) {
                label = msg.substring(3, bracketEnd)
                hexPart = msg.substring(bracketEnd + 3) // skip "]: "
            }
        } else if (msg.startsWith("RX")) {
            direction = Direction.RX
            // Format: "RX: AA 08 ..." or "RX[cmd=0x8106]: AA 08 ..."
            val bracketStart = msg.indexOf('[')
            if (bracketStart >= 0) {
                val bracketEnd = msg.indexOf(']')
                if (bracketEnd > bracketStart) {
                    label = msg.substring(bracketStart + 1, bracketEnd)
                    hexPart = msg.substring(bracketEnd + 3) // skip "]: "
                }
            } else {
                hexPart = msg.substring(3) // skip "RX: "
            }
        } else {
            // Status messages (WEAR EVT/QRY, connection messages, etc.)
            // These are already human-readable — pass through.
            return DecodedLine(
                rawTimestamp = timestamp,
                direction = Direction.STATUS,
                label = null,
                description = msg,
                hexPayload = null
            )
        }

        // Try to parse the hex payload into a description
        val payload = parseHex(hexPart)
        val description = if (payload != null && payload.isNotEmpty()) {
            describePacket(payload, direction, label)
        } else {
            msg
        }

        return DecodedLine(
            rawTimestamp = timestamp,
            direction = direction,
            label = label,
            description = description,
            hexPayload = hexPart?.trim()
        )
    }

    private fun parseHex(hexStr: String?): ByteArray? {
        if (hexStr == null) return null
        val clean = hexStr.trim().replace(" ", "")
        if (clean.isEmpty() || clean.length % 2 != 0) return null
        return try {
            ByteArray(clean.length / 2) { i ->
                clean.substring(i * 2, i * 2 + 2).toInt(16).toByte()
            }
        } catch (e: NumberFormatException) {
            null
        }
    }

    private fun describePacket(data: ByteArray, direction: Direction, label: String?): String {
        if (data.isEmpty() || data[0] != 0xAA.toByte()) {
            return data.joinToString(" ") { "%02X".format(it) }
        }

        if (data.size < 9) {
            return "Malformed: ${data.joinToString(" ") { "%02X".format(it) }}"
        }

        val cmd = (data[4].toInt() and 0xFF) or ((data[5].toInt() and 0xFF) shl 8)
        val payLen = (data[7].toInt() and 0xFF) or ((data[8].toInt() and 0xFF) shl 8)
        val payload = if (data.size >= 9 + payLen) data.copyOfRange(9, 9 + payLen) else ByteArray(0)

        val cmdHex = "0x${"%04X".format(cmd)}"

        return when (cmd) {
            OpoProtocol.CMD_HANDSHAKE -> "Handshake init"
            OpoProtocol.CMD_QUERY_PRODUCT_ID -> "Query product ID"
            OpoProtocol.CMD_QUERY_BROADCAST -> "Query broadcast codes"
            OpoProtocol.CMD_QUERY_BATTERY -> "Battery query"
            OpoProtocol.CMD_QUERY_STATUS -> "Status query"
            OpoProtocol.CMD_QUERY_ANC -> "ANC query"
            OpoProtocol.CMD_QUERY_WEARING -> "Wearing query (0x0109)"
            OpoProtocol.CMD_QUERY_KEY_FUNCTION -> "Key function query (0x0108)"
            OpoProtocol.CMD_RESP_KEY_FUNCTION -> KeyFunctionParser.describe(payload)
            OpoProtocol.CMD_REGISTER_NOTIFY -> "Register notifications (0x0205)"
            OpoProtocol.CMD_SET_ANC -> {
                val ancStr = ancPayloadToString(payload)
                if (direction == Direction.TX) "ANC -> $ancStr" else "ANC response: $ancStr"
            }
            OpoProtocol.CMD_SET_FEATURE -> {
                val featStr = featurePayloadToString(payload)
                if (direction == Direction.TX) "Feature -> $featStr" else "Feature response"
            }
            OpoProtocol.CMD_SET_SPATIAL -> "Spatial sound set"
            OpoProtocol.CMD_QUERY_EQ, OpoProtocol.CMD_QUERY_EQ_ALL -> "EQ query"
            OpoProtocol.CMD_ACTIVE_REPORT -> {
                // 0x0204: subType in payload[0]
                val sb = StringBuilder()
                if (payload.isNotEmpty()) {
                    val subType = payload[0].toInt() and 0xFF
                    when (subType) {
                        BatteryParser.EVT_BATTERY -> {
                            sb.append("Active report: battery")
                            BatteryParser.parseActive(data)?.let { r ->
                                appendBattery(sb, r)
                            }
                        }
                        OpoProtocol.EVT_WEARING -> {
                            sb.append("Active report: wearing")
                            WearingStatusParser.parseActiveReport(payload)?.let { w ->
                                appendWearing(sb, w)
                            }
                        }
                        OpoProtocol.EVT_GAME_MODE -> {
                            sb.append("Active report: game mode")
                            GameModeParser.parseActive(payload)?.let { on ->
                                sb.append(if (on) " ON" else " OFF")
                            }
                        }
                        AncEventParser.EVT_ANC -> {
                            sb.append("Active report: ANC ")
                            sb.append(AncEventParser.describe(payload))
                        }
                        UserInteractionParser.EVT_USER_INTERACTION -> {
                            sb.append("Button/gesture: ")
                            sb.append(UserInteractionParser.describe(payload))
                        }
                        else -> {
                            // A subType we don't decode. Annotated with its payload head
                            // so an unattributed gesture frame (e.g. subType 0xFF /
                            // "02 FF 06 00 F1 ...") stays visible on this screen.
                            val head = payload.take(6).joinToString(" ") { "%02X".format(it) }
                            sb.append("Unattributed active report: subType=0x${"%02X".format(subType)} [$head]")
                        }
                    }
                } else {
                    sb.append("Active report (empty payload)")
                }
                sb.toString()
            }
            0x8100 -> "Handshake response"
            0x8103 -> "Product ID response"
            0x8106 -> {
                val sb = StringBuilder("Battery response")
                BatteryParser.parse(data)?.let { r ->
                    appendBattery(sb, r)
                }
                sb.toString()
            }
            0x810C -> "ANC query response ($cmdHex)"
            0x8109 -> {
                val sb = StringBuilder("Wearing query response (0x8109)")
                WearingStatusParser.parseQueryResponse(payload)?.let { w ->
                    appendWearing(sb, w)
                }
                sb.toString()
            }
            0x810D -> "Status query response ($cmdHex)"
            0x8105 -> "Ear status response (legacy) ($cmdHex)"
            0x8122 -> "EQ query response ($cmdHex)"
            0x0501 -> {
                BudStateParser.parse(data)?.let { state ->
                    "Bud state: ${stateToString(state)}"
                } ?: "Bud state (unparsed)"
            }
            // Acks for the 0x04xx SET commands come back as 0x84xx (cmd | 0x8000). NAMED
            // rather than left to the catch-all, because an unnamed ack is a large part of
            // what made a broken write so hard to read: our successful gesture writes
            // printed as "0x8401 - 00" with nothing saying that was the confirmation being
            // waited for, and the FAILING variant produced no ack line at all. Stating both
            // clearly is what makes "ignored" vs "accepted" visible at a glance.
            in 0x8400..0x84FF -> {
                val setCmd = cmd and 0x7FFF
                val ok = payload.isNotEmpty() && (payload[0].toInt() and 0xFF) == 0
                val status = if (payload.isEmpty()) "no payload"
                else "status=0x%02X".format(payload[0].toInt() and 0xFF)
                "Ack for set 0x%04X (%s%s)".format(setCmd, status, if (ok) " = ok" else "")
            }
            else -> "$cmdHex - ${data.joinToString(" ") { "%02X".format(it) }}"
        }
    }

    private fun appendBattery(sb: StringBuilder, r: BatteryParser.Result) {
        val parts = mutableListOf<String>()
        r.left?.let { parts.add("L=${it.level}${if (it.isCharging) "!" else ""}") }
        r.right?.let { parts.add("R=${it.level}${if (it.isCharging) "!" else ""}") }
        r.case?.let { parts.add("C=${it.level}${if (it.isCharging) "!" else ""}") }
        if (parts.isEmpty()) {
            sb.append(" (no data)")
        } else {
            sb.append(" (${parts.joinToString(" ")})")
        }
    }

    private fun appendWearing(sb: StringBuilder, w: WearingStatusParser.Result) {
        val parts = mutableListOf<String>()
        if (w.leftValid) parts.add("L=${wearLabel(w.leftStatus)}")
        if (w.rightValid) parts.add("R=${wearLabel(w.rightStatus)}")
        if (w.caseStatus >= 0) parts.add("Case=${wearLabel(w.caseStatus)}")
        sb.append(" (${parts.joinToString(" ")})")
    }

    private fun wearLabel(st: Int): String = when (st) {
        3, 7 -> "EAR"
        4 -> "CASE"
        1, 5 -> "OUT"
        0 -> "OFF"
        else -> "?"
    }

    /**
     * Names an ANC payload using the SET_ANC table (OpoPodsManager Anc*.cs).
     *
     * This is the SET encoding, which is NOT the same as the query/notify
     * encoding used by 0x810C replies and 0x0204 subType 0x03 (see
     * AncEventParser). Reading only byte 2 would miss Adaptive, whose bit is in
     * the next byte, so the field is read as a little-endian int across bytes.
     */
    private fun ancPayloadToString(payload: ByteArray): String {
        if (payload.isEmpty()) return "?"
        var bits = 0
        for (i in 2 until payload.size) {
            bits = bits or ((payload[i].toInt() and 0xFF) shl ((i - 2) * 8))
        }
        return when {
            (bits and 0x0001) != 0 -> "Off"
            (bits and 0x0004) != 0 -> "Trans"
            (bits and 0x0010) != 0 -> "Deep"
            (bits and 0x0020) != 0 -> "Med"
            (bits and 0x0040) != 0 -> "Light"
            (bits and 0x0080) != 0 -> "Smart"
            (bits and 0x0100) != 0 -> "Adaptive"
            (bits and 0x0002) != 0 -> "On"
            else -> "Unknown (0x%04X)".format(bits)
        }
    }

    private fun featurePayloadToString(payload: ByteArray): String {
        if (payload.size < 2) return "?"
        val fid = payload[0].toInt() and 0xFF
        val on = (payload[1].toInt() and 0xFF) != 0
        val name = when (fid) {
            OpoProtocol.FEATURE_GAME_MODE -> "Game Mode"
            OpoProtocol.FEATURE_AUTO_PLAY_PAUSE -> "Auto Play/Pause"
            OpoProtocol.FEATURE_DUAL_DEVICE -> "Dual Device"
            OpoProtocol.FEATURE_SPATIAL_SOUND -> "Spatial Sound"
            else -> "Feature 0x${"%02X".format(fid)}"
        }
        return "$name ${if (on) "ON" else "OFF"}"
    }

    private fun stateToString(state: BudStateParser.State): String = when (state) {
        is BudStateParser.State.BothInCase -> "Both in case"
        is BudStateParser.State.BothOut -> "Both out"
        is BudStateParser.State.LeftOut -> "Left out"
        is BudStateParser.State.RightOut -> "Right out"
        is BudStateParser.State.Unknown -> "Unknown(0x${"%02X".format(state.raw)})"
    }
}
