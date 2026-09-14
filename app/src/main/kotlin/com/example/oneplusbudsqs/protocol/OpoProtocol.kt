package com.example.oneplusbudsqs.protocol

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

    // Feature IDs for 0x0403 "set feature" command
    const val FEATURE_GAME_MODE = 0x06   // OnePlus Buds 4 low latency
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

    // --- Feature switches ---
    private fun featurePayload(featureId: Int, on: Boolean): ByteArray =
        byteArrayOf(featureId.toByte(), if (on) 0x01 else 0x00)

    /** Game Mode / Low Latency — feature 0x06 */
    fun gameModeOn(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_GAME_MODE, true))
    fun gameModeOff(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_GAME_MODE, false))

    fun autoPlayPauseOn(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_AUTO_PLAY_PAUSE, true))
    fun autoPlayPauseOff(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_AUTO_PLAY_PAUSE, false))

    fun dualDeviceOn(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_DUAL_DEVICE, true))
    fun dualDeviceOff(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_DUAL_DEVICE, false))

    fun spatialSoundOn(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_SPATIAL_SOUND, true))
    fun spatialSoundOff(): ByteArray = buildPacket(CMD_SET_FEATURE, payload = featurePayload(FEATURE_SPATIAL_SOUND, false))

    // --- Spatial audio modes ---
    fun spatialOff(): ByteArray = buildPacket(CMD_SET_SPATIAL, payload = byteArrayOf(0x00))
    fun spatialFixed(): ByteArray = buildPacket(CMD_SET_SPATIAL, payload = byteArrayOf(0x01))
    fun spatialHeadTracking(): ByteArray = buildPacket(CMD_SET_SPATIAL, payload = byteArrayOf(0x02))

    // --- Queries ---
    fun queryBattery(): ByteArray = buildPacket(CMD_QUERY_BATTERY, seq = 0xF0)
    fun queryAncMode(): ByteArray = buildPacket(CMD_QUERY_ANC, payload = byteArrayOf(0x01, 0x01))
    fun queryEq(): ByteArray = buildPacket(CMD_QUERY_EQ)
    fun queryEqAll(): ByteArray = buildPacket(CMD_QUERY_EQ_ALL, payload = byteArrayOf(0x01, 0x05))

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