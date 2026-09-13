package com.example.oneplusbudsqs.protocol

object OpoProtocol {

    const val SERVICE_UUID = "0000079A-D102-11E1-9B23-00025B00A5A5"
    const val WRITE_CHAR_UUID = "0100079A-D102-11E1-9B23-00025B00A5A5"
    const val NOTIFY_CHAR_UUID = "0200079A-D102-11E1-9B23-00025B00A5A5"

    val HELLO = hexToBytes("AA 07 00 00 00 01 23 00 00 12")
    val REGISTER = hexToBytes("AA 0C 00 00 00 85 41 05 00 00 B5 50 A0 69")
    val REQUEST_STATE = hexToBytes("AA 05 00 00 00 01 01")

    const val ANC_OFF = 0x01.toByte()
    const val ANC_TRANSPARENCY = 0x02.toByte()
    const val ANC_HIGH = 0x10.toByte()
    const val ANC_MODERATE = 0x20.toByte()
    const val ANC_LOW = 0x40.toByte()

    private var sequenceId = 0x46

    @Synchronized
    private fun getNextSequence(): Byte {
        val seq = sequenceId
        sequenceId += 2
        if (sequenceId > 0xFE) sequenceId = 0x46
        return seq.toByte()
    }

    @Synchronized
    fun ancSetPacket(mode: Byte): ByteArray {
        val seq = getNextSequence()
        return hexToBytes("AA 0A 00 00 04 04") + byteArrayOf(seq) + hexToBytes("03 00 01 01") + byteArrayOf(mode)
    }

    // Game Mode (category 0x0C). Exact 15-byte form captured from HeyMelody, which the buds ACK
    // with: AA 0C 00 00 0C 81 <seq> 05 00 00 02 01 03 00 (00 00 = success).
    // Layout: AA 09 00 00 0C 01 [SEQ] 02 00 02 01 [STATE] 00 00 00
    //   STATE: 0xF1 = ON (low-latency / game sound enabled)
    //          0xF0 = OFF
    // The earlier long variants were rejected (00 02) because bytes were appended past the
    // declared length (0x09), so the buds saw trailing garbage.
    @Synchronized
    fun gameModeOn(): ByteArray {
        val seq = getNextSequence()
        return hexToBytes("AA 09 00 00 0C 01") + byteArrayOf(seq) +
            hexToBytes("02 00 02 01 F1 00 00 00")
    }

    @Synchronized
    fun gameModeOff(): ByteArray {
        val seq = getNextSequence()
        return hexToBytes("AA 09 00 00 0C 01") + byteArrayOf(seq) +
            hexToBytes("02 00 02 01 F0 00 00 00")
    }

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