package com.spizganed.quickbuds.protocol

/**
 * Parses the 0x8105 response (ear status) from the buds.
 *
 * Format (from HeyMelody decompile, CommandUtil.e() + StatusInfo.java):
 *
 *   payload[0]              = entry count
 *   payload[1..2]           = entry 1: [deviceType, statusByte]
 *   payload[3..4]           = entry 2: [deviceType, statusByte]
 *   ...
 *
 * deviceType: 1 = Left, 2 = Right, 3 = Case
 *
 * statusByte bit meanings (from StatusInfo):
 *   bit 0 (0x01): 0 = IN BOX,    1 = out of box       ← inverted!
 *   bit 1 (0x02): 1 = in ear,    0 = not in ear
 *   bit 2 (0x04): 0 = cover closed, 1 = cover open     ← inverted!
 *   bit 3 (0x08): 1 = safe remind
 */
object EarStatusParser {

    data class Result(
        val leftInBox: Boolean,
        val rightInBox: Boolean,
        val leftValid: Boolean,
        val rightValid: Boolean
    )

    fun parse(packet: ByteArray): Result? {
        if (packet.size < 10) return null
        if (packet[0] != 0xAA.toByte()) return null

        val cmd = (packet[4].toInt() and 0xFF) or ((packet[5].toInt() and 0xFF) shl 8)
        if (cmd != OpoProtocol.CMD_RESP_EAR_STATUS) return null

        val payLen = (packet[7].toInt() and 0xFF) or ((packet[8].toInt() and 0xFF) shl 8)
        if (payLen < 1) return null
        if (packet.size < 9 + payLen) return null

        val payload = packet.copyOfRange(9, 9 + payLen)
        val count = payload[0].toInt() and 0xFF
        if (count == 0) return null

        var leftInBox = false
        var rightInBox = false
        var leftValid = false
        var rightValid = false

        var offset = 1
        for (i in 0 until count) {
            if (offset + 1 >= payload.size) break
            val devType = payload[offset].toInt() and 0xFF
            val status = payload[offset + 1].toInt() and 0xFF
            val inBox = (status and 0x01) == 0
            when (devType) {
                1 -> { leftInBox = inBox; leftValid = true }
                2 -> { rightInBox = inBox; rightValid = true }
            }
            offset += 2
        }

        return Result(leftInBox, rightInBox, leftValid, rightValid)
    }
}