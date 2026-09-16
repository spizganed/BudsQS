package com.spizganed.quickbuds.bluetooth

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.spizganed.quickbuds.protocol.BatteryParser
import com.spizganed.quickbuds.protocol.OpoProtocol
import com.spizganed.quickbuds.protocol.OppoPacketFramer
import com.spizganed.quickbuds.protocol.WearingStatusParser
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.*
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.Executors

@SuppressLint("MissingPermission")
class BudsConnectionManager(private val context: Context) {

    init {
        PacketLogger.init(context)
    }

    interface Listener {
        fun onStatus(msg: String)
        fun onConnected(connected: Boolean)
        fun onPacketReceived(bytes: ByteArray)
        fun onBattery(left: Int?, case: Int?, right: Int?, chargingLeft: Boolean, chargingCase: Boolean, chargingRight: Boolean)
        fun onBudState(state: String)
        fun onEarStatus(leftInBox: Boolean, rightInBox: Boolean) {}

        /**
         * Full wear state (raw status codes from 0x0109 / 0x0204):
         * 4 = in case, 1/5 = out idle, 3/7 = wearing, 0 = disconnected, -1 = side not reported.
         * caseSt is the raw code reported by the case component (comp 3), -1 if absent.
         */
        fun onWearState(left: Int, right: Int, caseSt: Int) {}
    }

    private val listeners = CopyOnWriteArrayList<Listener>()

    var listener: Listener?
        get() = listeners.firstOrNull()
        set(value) {
            listeners.clear()
            value?.let { listeners.add(it) }
        }

    fun addListener(l: Listener) { if (!listeners.contains(l)) listeners.add(l) }
    fun removeListener(l: Listener) { listeners.remove(l) }

    private val handler = Handler(Looper.getMainLooper())
    private val pollExecutor = Executors.newSingleThreadScheduledExecutor()

    private var bluetoothSocket: BluetoothSocket? = null
    private var connectedThread: ConnectedThread? = null
    private var isReady = false
    private var isConnecting = false
    private var reconnectAttempts = 0
    private var pollingStarted = false

    /**
     * Poll period for the status query (0x010D).
     *
     * Why 60s and not 5s: every wear change is now PUSHED by the buds as 0x0204
     * subtype 02, so the poll no longer drives any UI update we care about
     * instantly. At 5s we were sending ~12 packets/minute, i.e. constantly
     * waking the radio for nothing. 60s keeps a sensible safety-net refresh.
     *
     * The wear query (0x0109) is deliberately NOT polled any more — push covers
     * it fully. See pollStatusOnce below.
     *
     * Do NOT remove the 0x010D packet outright: the reference sources describe
     * it as a FIXED packet that wakes the earbuds and likely acts as a
     * keep-alive. Widening is safe; deleting risks the buds sleeping and the
     * link going stale. If battery proves to push on change (needs a long
     * capture to confirm), this can be widened much further or dropped.
     */
    private val POLL_INTERVAL_SECONDS = 60L

    private var lastLeft: BatteryParser.Info? = null
    private var lastRight: BatteryParser.Info? = null
    private var lastCase: BatteryParser.Info? = null

    private var lastLeftInCase = false
    private var lastRightInCase = false
    private var lastLeftStatus = -1
    private var lastRightStatus = -1
    private var lastCaseStatus = -1

    fun isConnected(): Boolean = isReady && bluetoothSocket?.isConnected == true

    fun connect(device: BluetoothDevice) {
        if (isConnecting || isConnected()) {
            log("Already connecting/connected, ignoring.")
            return
        }
        isConnecting = true
        log("Initiating RFCOMM connection to ${device.name}...")
        BluetoothAdapter.getDefaultAdapter()?.cancelDiscovery()

        Thread {
            val uuids = listOf(
                OpoProtocol.SPP_UUID_PRIMARY,
                OpoProtocol.SPP_UUID_FALLBACK
            )
            var socket: BluetoothSocket? = null
            var lastError: String? = null

            for (uuidStr in uuids) {
                try {
                    log("Trying UUID: $uuidStr")
                    val uuid = UUID.fromString(uuidStr)
                    socket = device.createRfcommSocketToServiceRecord(uuid)
                    socket.connect()
                    log("Connected via UUID: $uuidStr")
                    break
                } catch (e: IOException) {
                    log("Failed UUID $uuidStr: ${e.message}")
                    lastError = e.message
                    try { socket?.close() } catch (_: Exception) {}
                    socket = null
                }
            }

            if (socket == null) {
                try {
                    log("Trying RFCOMM channel 15...")
                    val m = device.javaClass.getMethod("createRfcommSocket", Int::class.javaPrimitiveType)
                    socket = m.invoke(device, 15) as BluetoothSocket
                    socket.connect()
                    log("Connected via raw channel 15")
                } catch (e: Exception) {
                    log("Channel 15 failed: ${e.message}")
                    lastError = e.message
                    socket = null
                }
            }

            if (socket != null) {
                bluetoothSocket = socket
                connectedThread = ConnectedThread(socket)
                connectedThread?.start()
                isReady = true
                reconnectAttempts = 0
                handler.post { listeners.forEach { it.onConnected(true) } }
                log("Ready for commands. Running init sequence...")
                runInitSequence()
                startBatteryPolling()
            } else {
                log("All connection methods failed: $lastError")
                isConnecting = false
                disconnect()
                if (reconnectAttempts < 3) {
                    reconnectAttempts++
                    log("Auto-retry $reconnectAttempts/3 in 5s...")
                    handler.postDelayed({
                        if (!isConnected() && !isConnecting) connect(device)
                    }, 5000)
                } else {
                    log("Giving up. Tap CONNECT to retry manually.")
                    reconnectAttempts = 0
                }
                return@Thread
            }
            isConnecting = false
        }.start()
    }

    private fun runInitSequence() {
        Thread {
            try {
                delay(300); sendRawBlocking(OpoProtocol.buildHandshake(), "handshake")
                delay(200); sendRawBlocking(OpoProtocol.buildQueryProductId(), "query product id")
                delay(200); sendRawBlocking(OpoProtocol.buildQueryBroadcastCodes(), "query broadcast codes")
                delay(200); sendRawBlocking(OpoProtocol.registerNotifications(), "register notify")
                delay(200); sendRawBlocking(OpoProtocol.queryStatus(), "query status")
                delay(200); sendRawBlocking(OpoProtocol.queryAncMode(), "query anc")
                delay(200); sendRawBlocking(OpoProtocol.queryBattery(), "query battery")
                delay(200); sendRawBlocking(OpoProtocol.queryWearingStatus(), "query wearing")
            } catch (e: Exception) {
                log("Init sequence error: ${e.message}")
            }
        }.start()
    }

    private fun startBatteryPolling() {
        if (pollingStarted) {
            log("Polling already running, not starting a second poller.")
            return
        }
        pollingStarted = true
        pollExecutor.scheduleWithFixedDelay({
            if (isReady) {
                try {
                    // Status query only. The wear query (0x0109) is intentionally
                    // not polled — the buds push wear changes as 0x0204 subtype 02,
                    // measured at 1-3 ms, so polling it just wastes radio time.
                    sendRaw(OpoProtocol.queryStatus(), "poll status")
                } catch (_: Exception) {}
            }
        }, POLL_INTERVAL_SECONDS, POLL_INTERVAL_SECONDS, java.util.concurrent.TimeUnit.SECONDS)
    }

    fun disconnect() {
        isReady = false
        isConnecting = false
        connectedThread?.cancel()
        connectedThread = null
        bluetoothSocket = null
        handler.post { listeners.forEach { it.onConnected(false) } }
        log("Disconnected")
    }

    fun sendAncOff() { sendRaw(OpoProtocol.ancOff(), "ANC Off") }
    fun sendAncOn() { sendRaw(OpoProtocol.ancOn(), "ANC On") }
    fun sendAncTransparency() { sendRaw(OpoProtocol.ancTransparency(), "ANC Trans") }
    fun sendAncSmart() { sendRaw(OpoProtocol.ancSmart(), "ANC Smart") }
    fun sendAncDeep() { sendRaw(OpoProtocol.ancDeep(), "ANC Deep") }
    fun sendAncMedium() { sendRaw(OpoProtocol.ancMedium(), "ANC Medium") }
    fun sendAncLight() { sendRaw(OpoProtocol.ancLight(), "ANC Light") }

    fun setGameMode(on: Boolean) =
        sendRaw(if (on) OpoProtocol.gameModeOn() else OpoProtocol.gameModeOff(), "GameMode")

    fun setDualDevice(on: Boolean) =
        sendRaw(if (on) OpoProtocol.dualDeviceOn() else OpoProtocol.dualDeviceOff(), "DualDevice")

    fun setSpatialSound(on: Boolean) =
        sendRaw(if (on) OpoProtocol.spatialSoundOn() else OpoProtocol.spatialSoundOff(), "SpatialSound")

    fun setAutoPlayPause(on: Boolean) =
        sendRaw(if (on) OpoProtocol.autoPlayPauseOn() else OpoProtocol.autoPlayPauseOff(), "AutoPlayPause")

    fun requestFullStatus() { sendRaw(OpoProtocol.queryStatus(), "manual status") }

    private fun sendRaw(data: ByteArray, label: String = "") {
        Thread {
            sendRawBlocking(data, label)
        }.start()
    }

    private fun sendRawBlocking(data: ByteArray, label: String = "") {
        try {
            val thread = connectedThread
            if (thread == null) {
                log("sendRaw[$label]: no active connection.")
                return
            }
            if (bluetoothSocket?.isConnected != true) {
                log("sendRaw[$label]: socket reports not connected.")
                return
            }
            log("TX[$label]: ${OpoProtocol.bytesToHex(data)}")
            thread.write(data)
        } catch (e: Exception) {
            log("sendRaw[$label] error: ${e.message}")
        }
    }

    private fun delay(ms: Long) {
        try { Thread.sleep(ms) } catch (_: InterruptedException) {}
    }

    private fun wearLabel(st: Int): String = when (st) {
        3, 7 -> "EAR"
        4 -> "CASE"
        1, 5 -> "out"
        0 -> "off"
        else -> "?"
    }

    private inner class ConnectedThread(private val socket: BluetoothSocket) : Thread() {
        private val inputStream: InputStream = socket.inputStream
        private val outputStream: OutputStream = socket.outputStream
        private val buffer = ByteArray(1024)
        private val framer = OppoPacketFramer()

        override fun run() {
            while (true) {
                try {
                    val bytes = inputStream.read(buffer)
                    if (bytes > 0) {
                        val frames = framer.append(buffer, bytes)
                        for (frame in frames) {
                            handlePacket(frame)
                        }
                    }
                } catch (e: IOException) {
                    log("Connection lost: ${e.message}")
                    disconnect()
                    break
                }
            }
        }

        fun write(bytes: ByteArray) {
            try {
                outputStream.write(bytes)
                outputStream.flush()
            } catch (e: IOException) {
                log("Write failed: ${e.message}")
            }
        }

        fun cancel() {
            try { socket.close() } catch (_: IOException) {}
        }
    }

    private fun payloadOf(packet: ByteArray): ByteArray {
        if (packet.size < 9) return ByteArray(0)
        val payLen = (packet[7].toInt() and 0xFF) or ((packet[8].toInt() and 0xFF) shl 8)
        val end = minOf(9 + payLen, packet.size)
        return if (end > 9) packet.copyOfRange(9, end) else ByteArray(0)
    }

    private fun handlePacket(packet: ByteArray) {
        log("RX: ${OpoProtocol.bytesToHex(packet)}")
        handler.post { listeners.forEach { it.onPacketReceived(packet) } }

        if (packet.size < 9) return
        val cmd = (packet[4].toInt() and 0xFF) or ((packet[5].toInt() and 0xFF) shl 8)
        val payload = payloadOf(packet)

        // --- Wearing / in-case state: 0x8109 query response OR 0x0204 spontaneous event ---
        var wearing: WearingStatusParser.Result? = null
        var fromEvent = false
        if (cmd == OpoProtocol.CMD_RESP_WEARING) {
            wearing = WearingStatusParser.parseQueryResponse(payload)
        } else if (cmd == OpoProtocol.CMD_ACTIVE_REPORT && payload.isNotEmpty() &&
                   payload[0].toInt() and 0xFF == OpoProtocol.EVT_WEARING) {
            wearing = WearingStatusParser.parseActiveReport(payload)
            fromEvent = true
        }
        if (wearing != null) {
            if (wearing.leftValid) {
                lastLeftInCase = wearing.leftInCase
                lastLeftStatus = wearing.leftStatus
            }
            if (wearing.rightValid) {
                lastRightInCase = wearing.rightInCase
                lastRightStatus = wearing.rightStatus
            }
            if (wearing.caseStatus >= 0) lastCaseStatus = wearing.caseStatus
            log("WEAR ${if (fromEvent) "EVT" else "QRY"}: " +
                "L=${wearLabel(lastLeftStatus)} " +
                "R=${wearLabel(lastRightStatus)} " +
                "case=${wearLabel(lastCaseStatus)}")
            handler.post {
                listeners.forEach {
                    it.onEarStatus(lastLeftInCase, lastRightInCase)
                    it.onWearState(lastLeftStatus, lastRightStatus, lastCaseStatus)
                }
            }
            return
        }

        val battery = BatteryParser.parse(packet)
        val activeBattery = BatteryParser.parseActive(packet)

        if (battery != null) {
            if (battery.left != null) lastLeft = battery.left
            if (battery.right != null) lastRight = battery.right
            if (battery.case != null) lastCase = battery.case
            emitBattery()
        } else if (activeBattery != null) {
            if (activeBattery.left != null) lastLeft = activeBattery.left
            if (activeBattery.right != null) lastRight = activeBattery.right
            if (activeBattery.case != null) lastCase = activeBattery.case
            emitBattery()
        }
    }

    private fun emitBattery() {
        handler.post {
            listeners.forEach {
                it.onBattery(
                    lastLeft?.level, lastCase?.level, lastRight?.level,
                    lastLeft?.isCharging ?: false,
                    lastCase?.isCharging ?: false,
                    lastRight?.isCharging ?: false
                )
            }
        }
    }

    private fun log(msg: String) {
        Log.d("BudsConn", msg)
        PacketLogger.log(msg)
        handler.post { listeners.forEach { it.onStatus(msg) } }
    }
}
