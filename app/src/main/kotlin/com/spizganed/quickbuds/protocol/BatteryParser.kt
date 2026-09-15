package com.spizganed.quickbuds.protocol

object BatteryParser {

    data class Info(val level: Int, val isCharging: Boolean)
    data class Result(val left: Info?, val right: Info?, val case: Info?)

    /**
     * Parse battery query response (Cmd=0x8106).
     * Payload: [status][count][Index, RawValue] pairs  (status byte is skipped:
     * it is not 1/2/3, so the pair loop ignores it naturally)
     * Index: 1=Left, 2=Right, 3=Case.
     * RawValue: level = val & 0x7F, charging = (val & 0x80) != 0
     */
    fun parse(data: ByteArray): Result? {
        if (data.size < 9 || data[0] != 0xAA.toByte()) return null
        val cmd = (data[4].toInt() and 0xFF) or ((data[5].toInt() and 0xFF) shl 8)
        if (cmd != 0x8106) return null
        val payLen = (data[7].toInt() and 0xFF) or ((data[8].toInt() and 0xFF) shl 8)
        if (data.size < 9 + payLen) return null

        var l: Info? = null
        var r: Info? = null
        var c: Info? = null
        var i = 9
        while (i + 1 < 9 + payLen) {
            val idx = data[i].toInt() and 0xFF
            val raw = data[i + 1].toInt() and 0xFF
            val info = Info(raw and 0x7F, (raw and 0x80) != 0)
            when (idx) {
                1 -> l = info
                2 -> r = info
                3 -> c = info
            }
            i += 2
        }
        return Result(l, r, c)
    }

    /**
     * Parse active/unsolicited battery report (Cmd=0x0204, reportType=0x01).
     * Payload: [reportType=0x01][count][Index, StatusValue]...
     */
    fun parseActive(data: ByteArray): Result? {
        if (data.size < 9 || data[0] != 0xAA.toByte()) return null
        val cmd = (data[4].toInt() and 0xFF) or ((data[5].toInt() and 0xFF) shl 8)
        if (cmd != 0x0204) return null
        val payLen = (data[7].toInt() and 0xFF) or ((data[8].toInt() and 0xFF) shl 8)
        if (data.size < 9 + payLen || payLen < 2) return null
        if ((data[9].toInt() and 0xFF) != 0x01) return null
        val count = data[10].toInt() and 0xFF
        if (payLen < 2 + count * 2) return null

        var l: Info? = null
        var r: Info? = null
        var c: Info? = null
        for (j in 0 until count) {
            val idx = 11 + j * 2
            if (idx + 1 >= data.size) break
            val index = data[idx].toInt() and 0xFF
            val raw = data[idx + 1].toInt() and 0xFF
            val info = Info(raw and 0x7F, (raw and 0x80) != 0)
            when (index) {
                1 -> l = info
                2 -> r = info
                3 -> c = info
            }
        }
        return Result(l, r, c)
    }
}
