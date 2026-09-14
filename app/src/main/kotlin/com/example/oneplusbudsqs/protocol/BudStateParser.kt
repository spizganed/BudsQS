package com.example.oneplusbudsqs.protocol

object BudStateParser {
    sealed class State {
        object BothInCase : State()
        object BothOut : State()
        object LeftOut : State()
        object RightOut : State()
        data class Unknown(val raw: Int) : State()
    }

    /**
     * Parse AA 07 state packet. Format: AA LL 00 00 01 05 [XX] 00 00.
     * Observed XX values:
     *   0x00 → both in case (probably)
     *   0x01 → both out (probably)
     *   0x05 → right bud out
     *   0x06 → left bud out
     */
    fun parse(data: ByteArray): State? {
        if (data.size < 10 || data[0] != 0xAA.toByte()) return null
        val cmd = (data[4].toInt() and 0xFF) or ((data[5].toInt() and 0xFF) shl 8)
        if (cmd != 0x0501) return null
        val payLen = (data[7].toInt() and 0xFF) or ((data[8].toInt() and 0xFF) shl 8)
        if (payLen < 1) return null
        val valByte = data[9].toInt() and 0xFF
        return when (valByte) {
            0x00 -> State.BothInCase
            0x01, 0x02 -> State.BothOut
            0x05 -> State.RightOut
            0x06 -> State.LeftOut
            else -> State.Unknown(valByte)
        }
    }
}