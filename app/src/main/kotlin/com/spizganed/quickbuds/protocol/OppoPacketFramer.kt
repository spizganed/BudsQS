package com.spizganed.quickbuds.protocol

/**
 * Reassembles 0xAA-framed OPPO protocol packets from a byte stream.
 * Handles partial frames, multiple frames in one read, and garbage before headers.
 */
class OppoPacketFramer {
    private var pending = ByteArray(0)

    fun append(buffer: ByteArray, length: Int): List<ByteArray> {
        if (length <= 0) return emptyList()
        pending += buffer.copyOfRange(0, length)
        val frames = mutableListOf<ByteArray>()

        while (pending.isNotEmpty()) {
            val start = pending.indexOf(0xAA.toByte())
            if (start < 0) {
                pending = ByteArray(0)
                break
            }
            if (start > 0) pending = pending.copyOfRange(start, pending.size)
            if (pending.size < 2) break

            val totalLen = pending[1].toInt() and 0xFF
            val frameLen = totalLen + 2
            if (totalLen < 7 || frameLen > 512) {
                pending = pending.copyOfRange(1, pending.size)
                continue
            }
            if (pending.size < frameLen) break

            frames += pending.copyOfRange(0, frameLen)
            pending = pending.copyOfRange(frameLen, pending.size)
        }
        return frames
    }
}