package com.spizganed.quickbuds.protocol

/**
 * OPPO / OnePlus / realme earbud RFCOMM protocol constants.
 *
 * PROVENANCE — almost nothing here was documented by the vendor. The command
 * numbers and payload shapes are reverse-engineered, and the main source is
 * Zhaoyi-ya/OppoPodsManager (https://github.com/Zhaoyi-ya/OppoPodsManager),
 * with additional framing details from
 * Star-ZER0/Pods-Protocol-Reverse-Engineering.
 *
 * READ PROTOCOL.md AT THE REPO ROOT BEFORE EDITING THIS FILE. It documents the
 * frame layout, every known command, the ANC set-vs-notify trap, and the
 * assumptions that were already proven wrong once. CREDITS.md records which
 * source each area came from; add to it when you add a constant here.
 *
 * Do not copy code from those projects without checking their licenses first.
 */
object OpoProtocol {

    const val SPP_UUID_PRIMARY = "00001107-D102-11E1-9B23-00025B00A5A5"
    const val SPP_UUID_FALLBACK = "0000079A-D102-11E1-9B23-00025B00A5A5"

    const val CMD_HANDSHAKE = 0x0100
    const val CMD_QUERY_PRODUCT_ID = 0x0103
    const val CMD_QUERY_BROADCAST = 0x0200
    const val CMD_SET_FEATURE = 0x0403
    const val CMD_SET_ANC = 0x0404
    const val CMD_SET_SPATIAL = 0x0422
    const val CMD_QUERY_BATTERY = 0x0106
    const val CMD_QUERY_ANC = 0x010C
    const val CMD_QUERY_STATUS = 0x010D
    const val CMD_QUERY_EQ = 0x010F
    const val CMD_QUERY_EQ_ALL = 0x0122

    // --- gesture / key-function bindings ---
    const val CMD_QUERY_KEY_FUNCTION = 0x0108  // getKeyFunction — current bindings
    const val CMD_RESP_KEY_FUNCTION = 0x8108
    /**
     * setKeyFunction — write the gesture bindings back.
     *
     * THE DEVICE PROVED 0x0402 WRONG; 0x0401 IS THE CANDIDATE THAT REPLACES IT. Both are
     * `[OSS]`, so this is the better-supported of two unverified numbers — NOT a
     * confirmed one:
     *   - 0x0402 was sent repeatedly in a WELL-FORMED frame (`TotalLen 80 = 7 + 73`,
     *     payload `12` + 18x4) and the buds ignored it in total silence: no ack, and the
     *     0x8108 read-back still showed the old table. That much IS settled — 0x0402 is
     *     not the write.
     *   - **0x0401** is what the Melody-derived setting tables list for `setKeyFunction`
     *     (`BtOperate.m2699L`), and those tables run 0x0400, 0x0401, 0x0403, 0x0404 —
     *     0x0402 does not appear among them at all.
     *   - OppoPodsManager mentions 0x0402 only inside a COMMENT on its 0x0108 query line,
     *     and defines no constant for it. The old note here took that comment as a table
     *     entry, which is how the wrong number got in.
     *
     * STILL UNVERIFIED: only the device can confirm 0x0401, and if it is also wrong the
     * failure is equally silent, so the read-back is the only evidence either way.
     *
     * Payload SHAPE is corroborated rather than assumed: `<count> [deviceType, button,
     * buttonAction, function]...` is what the 0x8108 read reply returns (minus the read's
     * leading status byte), and the Melody tables list the write payload in that form.
     */
    const val CMD_SET_KEY_FUNCTION = 0x0401

    // --- wearing / in-case status (reverse-engineered from OppoPodsManager) ---
    const val CMD_QUERY_WEARING = 0x0109      // getEarBudsStatus — THE in-case query
    const val CMD_RESP_WEARING = 0x8109
    const val CMD_ACTIVE_REPORT = 0x0204      // spontaneous notification, payload[0] = subType
    const val CMD_REGISTER_NOTIFY = 0x0205    // subscribe to spontaneous notifications
    const val EVT_WEARING = 0x02              // 0x0204 subType: wearing status changed
    const val EVT_GAME_MODE = 0x05            // 0x0204 subType: game mode changed

    // Legacy misnomers — 0x0105 is actually getRemoteVersion (returns firmware CSV).
    // Kept only so the old unused EarStatusParser still compiles; do NOT call.
    const val CMD_QUERY_EAR_STATUS = 0x0105
    const val CMD_RESP_EAR_STATUS = 0x8105

    const val FEATURE_GAME_MODE = 0x06
    const val FEATURE_AUTO_PLAY_PAUSE = 0x04
    const val FEATURE_DUAL_DEVICE = 0x11
    const val FEATURE_SPATIAL_SOUND = 0x1B

    private var seqCounter = 0x01

    @Synchronized
    private fun nextSeq(): Int {
        val seq = seqCounter
        seqCounter = if (seqCounter >= 0xFE) 0x01 else seqCounter + 1
        return seq
    }

    @Synchronized
    fun buildPacket(cmd: Int, seq: Int? = null, payload: ByteArray = ByteArray(0)): ByteArray {
        val s = seq ?: nextSeq()
        val payLen = payload.size
        val totalLen = 7 + payLen
        val pkt = ByteArray(2 + totalLen)
        pkt[0] = 0xAA.toByte()
        pkt[1] = totalLen.toByte()
        pkt[2] = 0x00
        pkt[3] = 0x00
        pkt[4] = (cmd and 0xFF).toByte()
        pkt[5] = ((cmd shr 8) and 0xFF).toByte()
        pkt[6] = s.toByte()
        pkt[7] = (payLen and 0xFF).toByte()
        pkt[8] = ((payLen shr 8) and 0xFF).toByte()
        System.arraycopy(payload, 0, pkt, 9, payLen)
        return pkt
    }

    fun buildHandshake(): ByteArray = buildPacket(CMD_HANDSHAKE)
    fun buildQueryProductId(): ByteArray = buildPacket(CMD_QUERY_PRODUCT_ID)
    fun buildQueryBroadcastCodes(): ByteArray = buildPacket(CMD_QUERY_BROADCAST)

    /** getEarBudsStatus (0x0109) — returns [count][comp,st] pairs, st=4 means in case. */
    fun queryWearingStatus(): ByteArray = buildPacket(CMD_QUERY_WEARING, seq = 0xF2)

    /**
     * Subscribe to spontaneous 0x0204 notifications (battery + wearing + ANC).
     *
     * Payload is canonical: a count byte followed by event ids.
     *
     * CONFIRMED on device: with count=2 and events battery (0x01) + wearing (0x02),
     * the ACK lists BOTH and the buds then emit 0x0204 subtype 02 on every wear
     * change. Wear updates are effectively instant — no polling needed.
     *
     * The old legacy literal 01 01 02 02 was a misread: under the count-first
     * shape it means count=1 (register battery only) with 02 02 left over. The
     * firmware ACKed that happily and silently never sent wear events, which is
     * why wear appeared to be poll-only. Do NOT revert to that.
     *
     * 0x03 (ANC) WAS ADDED on 2026-09-18. The buds advertise their event ids in
     * the 0x8200 broadcast-codes reply, which lists `01 02 03 04 08 0B F1 F2 F3` —
     * 03 is offered, and the ANC subType 0x03 push arrived only unreliably while we
     * had not subscribed to it. Subscribing is the documented way to make a 0x0204
     * subType arrive, and it is how wear was fixed, so the same reasoning applies.
     *
     * CONFIRMED ON DEVICE 2026-09-19. The 0x8205 ACK lists `01 02 03`, and a bud-side
     * gesture now updates the app circles AND the widget, including a gesture REBOUND
     * to a different mode cycle. If ANC ever stops following gestures, check the ACK
     * still lists `01 02 03` first — a firmware that rejects the longer list would ACK
     * a shorter one.
     */
    fun registerNotifications(): ByteArray =
        buildPacket(CMD_REGISTER_NOTIFY, payload = byteArrayOf(0x03, 0x01, 0x02, 0x03))

    /**
     * SET_ANC (0x0404) payload: `01 01` then a bit field, bit `index` set.
     *
     * THE SET AND QUERY/NOTIFY ENCODINGS ARE DIFFERENT TABLES. Do not "unify" them.
     *
     * SET (this function) — bit indices below, sourced from OppoPodsManager
     * `Protocol/OppoProtocol.Anc.cs` (AncOff/AncLight/AncMedium/AncDeep/
     * AncTransparency, and PktAncByIndex which is this exact algorithm):
     *
     *     Off          01 01 01      (bit 0)
     *     Transparency 01 01 04      (bit 2)
     *     Deep         01 01 10      (bit 4)
     *     Medium       01 01 20      (bit 5)
     *     Light        01 01 40      (bit 6)
     *     Smart        01 01 80      (bit 7)
     *     Adaptive     01 01 00 08   (bit 8, 4-byte payload)
     *
     * QUERY reply / 0x0204 subType 0x03 NOTIFY use bits 3 and 8 instead:
     * 0x0008 Off, 0x0100 Transparency(+voice enhance off), 0x0010 Deep,
     * 0x0020 Medium, 0x0040 Light, 0x0080 Smart, 0x0000 0x0002/0x0008 Adaptive.
     * Those live in AncEventParser and are deliberately NOT reused here.
     *
     * WARNING / DO NOT REPEAT: this table was briefly "corrected" to the notify
     * bits (Off->3, Transparency->8) on the theory that set and query must agree.
     * They do not. That change sent the wrong bits. It is reverted.
     */
    private fun ancPayload(index: Int): ByteArray {
        val byteCount = index / 8 + 1
        val arr = ByteArray(2 + byteCount)
        arr[0] = 0x01
        arr[1] = 0x01
        arr[2 + index / 8] = (1 shl (index % 8)).toByte()
        return arr
    }

    fun ancOff(): ByteArray = buildPacket(CMD_SET_ANC, payload = ancPayload(0))
    fun ancOn(): ByteArray = buildPacket(CMD_SET_ANC, payload = ancPayload(1))
    fun ancTransparency(): ByteArray = buildPacket(CMD_SET_ANC, payload = ancPayload(2))
    fun ancDeep(): ByteArray = buildPacket(CMD_SET_ANC, payload = ancPayload(4))
    fun ancMedium(): ByteArray = buildPacket(CMD_SET_ANC, payload = ancPayload(5))
    fun ancLight(): ByteArray = buildPacket(CMD_SET_ANC, payload = ancPayload(6))
    fun ancSmart(): ByteArray = buildPacket(CMD_SET_ANC, payload = ancPayload(7))
    fun ancAdaptive(): ByteArray = buildPacket(CMD_SET_ANC, payload = ancPayload(8))

    private fun featurePayload(featureId: Int, on: Boolean): ByteArray =
        byteArrayOf(featureId.toByte(), if (on) 0x01 else 0x00)

    fun gameModeOn(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_GAME_MODE, true))
    fun gameModeOff(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_GAME_MODE, false))

    fun autoPlayPauseOn(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_AUTO_PLAY_PAUSE, true))
    fun autoPlayPauseOff(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_AUTO_PLAY_PAUSE, false))

    fun dualDeviceOn(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_DUAL_DEVICE, true))
    fun dualDeviceOff(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_DUAL_DEVICE, false))

    fun spatialSoundOn(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_SPATIAL_SOUND, true))
    fun spatialSoundOff(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_SPATIAL_SOUND, false))

    fun spatialOff(): ByteArray = buildPacket(CMD_SET_SPATIAL, payload = byteArrayOf(0x00))
    fun spatialFixed(): ByteArray = buildPacket(CMD_SET_SPATIAL, payload = byteArrayOf(0x01))
    fun spatialHeadTracking(): ByteArray = buildPacket(CMD_SET_SPATIAL, payload = byteArrayOf(0x02))

    fun queryBattery(): ByteArray = buildPacket(CMD_QUERY_BATTERY, seq = 0xF0)
    fun queryAncMode(): ByteArray = buildPacket(CMD_QUERY_ANC, payload = byteArrayOf(0x01, 0x01))
    fun queryEq(): ByteArray = buildPacket(CMD_QUERY_EQ)
    fun queryEqAll(): ByteArray = buildPacket(CMD_QUERY_EQ_ALL, payload = byteArrayOf(0x01, 0x05))

    /**
     * getKeyFunction (0x0108) — read the CURRENT gesture bindings.
     *
     * READ-ONLY, and deliberately so: it reports what the buds are already doing,
     * so it cannot change state or break a binding. The 0x8108 reply is the cheapest
     * shot at learning the `function` enum, which is the one thing blocking gesture
     * configuration in our app (PROTOCOL.md §6). It may also hand us the enum straight
     * from the device, which would remove the need for a HeyMelody capture.
     *
     * Payload is a bare query (no payload), matching the other 0x01xx reads. The buds
     * DO answer it: the reply is `<status> <count> <4-byte entries>...` and its layout
     * is `[CAPTURE]`-confirmed — see PROTOCOL.md §6 and `KeyFunctionParser`, which
     * logs it RAW and grouped so two readings can be diffed.
     *
     * The `function` VALUES are no longer a mystery either: they were MEASURED by
     * diffing two of these replies around a change made in the vendor app. See
     * `GestureAction.functionByte`.
     */
    fun queryKeyFunction(): ByteArray = buildPacket(CMD_QUERY_KEY_FUNCTION)

    /**
     * setKeyFunction (0x0401) — write gesture bindings back.
     *
     * Payload is `<count>` then 4 bytes per entry, and the entries are the SAME
     * [KeyFunctionParser.Entry] type the read reply decodes into, deliberately: using
     * one type for both directions is what stops the two from drifting, and it means a
     * table read back from the buds can be written out again unmodified.
     *
     * NO LEADING STATUS BYTE, unlike the reply. The reply is `<status> <count> ...`
     * (`[CAPTURE]`), but a status byte is something the device REPORTS; a write supplies
     * only the count and its entries.
     *
     * WHY THE CALLER STILL RE-READS: the payload layout above is `[OSS]`, and the ONE
     * thing the device has taught us about this command is that it ignores a wrong
     * command number in total silence (see CMD_SET_KEY_FUNCTION). A silent ignore looks
     * exactly like success unless the table is read back, so the read-back is not
     * belt-and-braces — it is the only evidence there is.
     *
     * LEB128 is safe here: the largest realistic payload is an 18-entry table,
     * `1 + 18*4 = 73` bytes, so `TotalLen = 80` fits in one LEB128 byte. `buildPacket()`
     * would only need real LEB128 above ~30 entries, which this device does not have.
     */
    fun setKeyFunction(entries: List<KeyFunctionParser.Entry>): ByteArray {
        val payload = ByteArray(1 + entries.size * KeyFunctionParser.ENTRY_SIZE)
        payload[0] = entries.size.toByte()
        for ((i, e) in entries.withIndex()) {
            val o = 1 + i * KeyFunctionParser.ENTRY_SIZE
            payload[o] = e.deviceType.toByte()
            payload[o + 1] = e.button.toByte()
            payload[o + 2] = e.action.toByte()
            payload[o + 3] = e.function.toByte()
        }
        return buildPacket(CMD_SET_KEY_FUNCTION, payload = payload)
    }

    fun queryStatus(): ByteArray = buildPacket(
        CMD_QUERY_STATUS,
        seq = 0x00,
        payload = byteArrayOf(
            0x0B, 0x05, 0x04, 0x0B, 0x11, 0x13,
            0x18, 0x06, 0x1B, 0x1C, 0x27, 0x28
        )
    )

    fun hexToBytes(hex: String): ByteArray {
        val clean = hex.replace(" ", "").replace("0x", "")
        require(clean.length % 2 == 0)
        return ByteArray(clean.length / 2) { i ->
            clean.substring(i * 2, i * 2 + 2).toInt(16).toByte()
        }
    }

    fun bytesToHex(bytes: ByteArray): String =
        bytes.joinToString(" ") { "%02X".format(it) }
}
