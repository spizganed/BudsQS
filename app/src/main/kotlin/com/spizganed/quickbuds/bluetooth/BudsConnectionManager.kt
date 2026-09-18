package com.spizganed.quickbuds.bluetooth

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.spizganed.quickbuds.protocol.AncEventParser
import com.spizganed.quickbuds.protocol.BatteryParser
import com.spizganed.quickbuds.protocol.GameModeParser
import com.spizganed.quickbuds.protocol.KeyFunctionParser
import com.spizganed.quickbuds.protocol.OpoProtocol
import com.spizganed.quickbuds.protocol.OppoPacketFramer
import com.spizganed.quickbuds.protocol.UserInteractionParser
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

        /**
         * Game mode changed on the BUDS themselves (0x0204 subType 0x05).
         *
         * This fires both when we set game mode and when the user toggles it with a
         * buds gesture — the buds push the new state either way, so it is the
         * authoritative source. Implementers should persist it to WidgetStateStore
         * so the widget and app buttons reflect reality rather than our last command.
         *
         * NOTE: ANC has its own event, subType 0x03 — see onAncModeState.
         */
        fun onGameModeState(on: Boolean) {}

        /**
         * ANC mode changed on the BUDS themselves (0x0204 subType 0x03).
         *
         * Mirrors onGameModeState: raised for a buds gesture AND for our own command
         * (the buds push real state either way), so implementers should persist it to
         * WidgetStateStore and let the store listener repaint both surfaces. An
         * implementation that ignores an equal value is what keeps an echo a no-op.
         *
         * `mode` is a store ANC name ("Off", "Transparency", "Adaptive",
         * "ANC-Light", "ANC-Medium", "ANC-Deep"). "Adaptive" is included because the
         * buds CAN report it (0x0800) and the app now has a circle for it — before the
         * circle existed it was folded into "ANC-Light". An unnameable raw value is
         * never reported, so an
         * implementer can never be handed a mode the buds did not actually report.
         */
        fun onAncModeState(mode: String) {}
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
                    socket?.connect()
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
                    socket?.connect()
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
                // Read-only: reports the CURRENT gesture bindings so a capture can
                // reveal the `function` enum. See OpoProtocol.queryKeyFunction().
                delay(200); sendRawBlocking(OpoProtocol.queryKeyFunction(), "query key function")
                // Read-only: the HOLD's ANC mode list, which is the one gesture this app
                // still cannot configure — its key-function byte only reports that the hold
                // cycles ANC, not which modes. See OpoProtocol.queryNoiseSwitchModes().
                delay(200); sendRawBlocking(OpoProtocol.queryNoiseSwitchModes(), "query noise switch")
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
        // Clear the poll-latch so the NEXT connection starts a fresh poller.
        // Without this, pollingStarted stayed true for the process lifetime and
        // startBatteryPolling() short-circuited on every reconnect ("Polling
        // already running"), silently depending on the previous session's
        // executor still being alive. Seen in packets_export_20260916_133141.
        pollingStarted = false
        handler.post { listeners.forEach { it.onConnected(false) } }
        log("Disconnected")
    }

    fun sendAncOff() { lastAncLevelSent = null; sendRaw(OpoProtocol.ancOff(), "ANC Off") }
    fun sendAncOn() { sendRaw(OpoProtocol.ancOn(), "ANC On") }
    fun sendAncTransparency() { sendRaw(OpoProtocol.ancTransparency(), "ANC Trans") }
    fun sendAncSmart() { sendRaw(OpoProtocol.ancSmart(), "ANC Smart") }
    fun sendAncDeep() { lastAncLevelSent = "ANC-Deep"; sendRaw(OpoProtocol.ancDeep(), "ANC Deep") }
    fun sendAncMedium() { lastAncLevelSent = "ANC-Medium"; sendRaw(OpoProtocol.ancMedium(), "ANC Medium") }
    fun sendAncLight() { lastAncLevelSent = "ANC-Light"; sendRaw(OpoProtocol.ancLight(), "ANC Light") }

    /**
     * Adaptive — a state of its own, NOT a fourth level.
     *
     * `lastAncLevelSent` stays null (like Off), because that field exists only to
     * interpret the ambiguous "ANC on" stop, which reports whichever LEVEL was last
     * used. Adaptive reports itself unambiguously as 0x0800, which AncEventParser now
     * names outright, so there is nothing for a hint to disambiguate.
     */
    fun sendAncAdaptive() { lastAncLevelSent = null; sendRaw(OpoProtocol.ancAdaptive(), "ANC Adaptive") }

    fun setGameMode(on: Boolean) =
        sendRaw(if (on) OpoProtocol.gameModeOn() else OpoProtocol.gameModeOff(), "GameMode")

    fun setDualDevice(on: Boolean) =
        sendRaw(if (on) OpoProtocol.dualDeviceOn() else OpoProtocol.dualDeviceOff(), "DualDevice")

    fun setSpatialSound(on: Boolean) =
        sendRaw(if (on) OpoProtocol.spatialSoundOn() else OpoProtocol.spatialSoundOff(), "SpatialSound")

    fun setAutoPlayPause(on: Boolean) =
        sendRaw(if (on) OpoProtocol.autoPlayPauseOn() else OpoProtocol.autoPlayPauseOff(), "AutoPlayPause")

    fun requestFullStatus() { sendRaw(OpoProtocol.queryStatus(), "manual status") }

    /** Timestamp of the last ANC command we flushed; see noteUnattributed(). */
    private var lastAncFlushAt = 0L

    /**
     * Marks that an ANC frame is now on the wire.
     *
     * Called from sendRawBlocking() right after the write succeeds, so the ONLY
     * requirement is that ANC goes through sendRaw() — which every ANC path does
     * (service, widget, tile, app all end up in BudsConnectionManager.sendAnc*).
     * If an ANC command is ever written directly to ConnectedThread, this must be
     * called alongside it or the attribution probe silently stops working.
     */
    private fun markAncFlush() { lastAncFlushAt = System.currentTimeMillis() }

    /**
     * The ANC LEVEL the app last sent ("ANC-Light"/"ANC-Medium"/"ANC-Deep", or null).
     *
     * Used only to interpret the buds' subType 0x03 push when its value is the
     * ambiguous "ANC on" stop: that stop echoes whichever level was last active, so
     * the level the app just set is the best available hint. It never overrides a
     * value we can name outright — see AncEventParser.modeForRaw().
     *
     * Deliberately a plain field rather than a WidgetStateStore read: the manager
     * has no Context, and the store is owned by the service.
     */
    private var lastAncLevelSent: String? = null

    /**
     * The most recent `0x8108` table, i.e. the buds' own view of their bindings.
     *
     * Kept because a `setKeyFunction` write takes the COMPLETE list: to change one slot
     * we must send every entry back, and the untouched ones have to come from somewhere
     * truthful. Inventing them from our own UI would wipe the bindings we do not model
     * (the `btn 0x06` group, `act 0x06`, and anything else the firmware carries), so the
     * last reading is the only safe source. Read-only until then: null means no write
     * may happen at all.
     *
     * @Volatile because it is written on the socket reader thread and read from the
     * service/main thread that issues a write.
     */
    @Volatile
    private var lastKeyFnTable: KeyFunctionParser.Table? = null

    /**
     * Changes ONE binding on ONE bud and writes the whole table back.
     *
     * `side` is the reply's `deviceType` (0x01 left, 0x02 right) and `keyFnAction` is the
     * keyfn `buttonAction` — NOT the F1 action byte. The two numberings genuinely differ
     * (keyfn 1=single; F1 0x00=single), so passing an F1 byte here would write the wrong
     * slot. See `Gesture.keyFnAction`.
     *
     * WHICH SLOTS ARE WRITTEN IS DECIDED BY THE TABLE, NOT BY A LIST IN OUR CODE. That is
     * the correction of a real bug, and the reason is worth keeping: a table in this very
     * project's capture history has held a gesture in THREE different places.
     *
     *     LEFT   19 entries   dev=0x01/btn=0x01[.. 05:07]      slide in btn 0x01
     *     RIGHT  19 entries   dev=0x02/btn=0x02[05:00]         slide split out
     *                         dev=0x02/btn=0x03[05:00]
     *     both   20 entries   (an earlier session)             slide split out, other side
     *
     * A hardcoded per-gesture button list was tried and it broke: aiming slide's write at
     * `btn 0x02`/`0x03` produced `NO SLOT MATCHED` on a bud whose slide sits in `btn 0x01`,
     * and aiming at `0x01` misses the split shape. So the rule is now simply "every slot
     * this bud actually has for this action", excluding only [KeyFunctionParser.BUTTON_ON_CALL_GUESS].
     *
     * MEASURED BONUS: writing slide's two split groups makes the DEVICE CONSOLIDATE them
     * into `btn 0x01 act 0x05` and drop the extras. So the split shape is not permanent,
     * the device normalises it, and our table-driven rule follows that automatically.
     *
     * ZERO MATCHES REFUSES THE WRITE, LOUDLY. A write that matches no slot is by definition
     * a no-op, and silently sending one is what made slide look "broken but sometimes
     * working": the writes went to a group that bud did not have, and came back unchanged
     * with nothing in the log to say why. A one-line answer beats a mystery.
     *
     * Returns false and does nothing when no table has been read yet. That is the point:
     * a write needs all the other entries, and guessing them would silently destroy
     * bindings this app cannot even display.
     */
    fun writeGestureBinding(
        side: Int,
        keyFnAction: Int,
        functionByte: Int
    ): Boolean {
        val table = lastKeyFnTable
        if (table == null || table.entries.isEmpty()) {
            log("KEYFN WRITE: refused - no 0x8108 reading yet, will not invent a table")
            return false
        }

        var matched = 0
        val buttons = LinkedHashSet<Int>()
        val updated = table.entries.map { e ->
            if (e.deviceType == side && e.action == keyFnAction &&
                e.button != KeyFunctionParser.BUTTON_ON_CALL_GUESS) {
                matched++
                buttons.add(e.button)
                e.copy(function = functionByte)
            } else {
                e
            }
        }
        if (matched == 0) {
            log("KEYFN WRITE: no slot for dev=0x%02X act=0x%02X - nothing sent"
                .format(side, keyFnAction))
            return false
        }

        log("KEYFN WRITE: dev=0x%02X btn=%s act=0x%02X -> 0x%02X (%d slot(s), full table %d entries)"
            .format(
                side, buttons.joinToString(",") { "0x%02X".format(it) },
                keyFnAction, functionByte, matched, updated.size
            ))

        // Adopt the change IN MEMORY before the reply comes back. The verify re-read
        // below takes ~600ms, and without this a second write inside that window would be
        // built from the pre-write table and silently revert the first change. The
        // reply still overwrites this with the device's own truth, so a write that the
        // buds reject does not leave us believing a lie for long.
        lastKeyFnTable = table.copy(entries = updated)

        sendRaw(OpoProtocol.setKeyFunction(updated), "set key function")

        // Read it straight back. The write's payload layout is [OSS], and the device has
        // shown that it ignores a WRONG command number in total silence (0x0402 produced no
        // ack and no change), so the ONLY evidence the write landed is the device's own
        // table — and because the reply re-runs the diff, any change is printed for us
        // rather than assumed. A short delay: the buds answer a query in ~40ms, but the
        // write needs to be applied before the read is meaningful.
        Thread {
            try {
                Thread.sleep(600)
                sendRawBlocking(OpoProtocol.queryKeyFunction(), "verify key function")
            } catch (e: Exception) {
                log("KEYFN WRITE: verify query failed: ${e.message}")
            }
        }.start()
        return true
    }

    /**
     * Baseline for the gesture-binding diff, in the app's own prefs file.
     *
     * PERSISTED, NOT A FIELD, and that is the whole point: the enum hunt requires
     * disconnecting our app (the vendor app needs the RFCOMM socket) and reconnecting
     * it, which may restart the process. An in-memory baseline would be lost in exactly
     * the gap it exists to span, and a lost baseline reads as "nothing changed", which
     * is the one wrong answer that would end the hunt early.
     *
     * Deliberately NOT WidgetStateStore: that store is state the widget and home screen
     * render, and this is a diagnostic no UI reads. Putting it there would push a
     * question about `0x8108` into the widget's data model.
     *
     * The baseline is updated on every reading, so each reconnect is compared against
     * the immediately previous one. A reply with no entries does NOT overwrite a good
     * baseline — a garbled read must not cost us the reading we already had.
     */
    private fun keyFnDiff(table: KeyFunctionParser.Table): String {
        if (table.entries.isEmpty()) return "no entries in reply - baseline left untouched"

        val prefs = context.getSharedPreferences(KEYFN_PREFS, Context.MODE_PRIVATE)
        val signature = KeyFunctionParser.signature(table)
        val previous = prefs.getString(KEYFN_BASELINE, null)
        prefs.edit().putString(KEYFN_BASELINE, signature).apply()

        if (previous == null) {
            return "baseline stored (${table.entries.size} slots) - change ONE gesture in " +
                "the vendor app, then reconnect for a real diff"
        }
        return KeyFunctionParser.diff(previous, signature)
    }

    private val KEYFN_PREFS = "QuickBudsKeyFnDiff"
    private val KEYFN_BASELINE = "keyFnBaseline"

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
            // Write bytes FIRST, log after. The buds ACK most commands in under 100ms
            // (see any handshake in local/logs), so logging first is a race: a fast reply
            // could land in the log ABOVE our own TX line and look causally backwards.
            thread.write(data)
            markAncFlush()
            log("TX[$label]: ${OpoProtocol.bytesToHex(data)}")
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

    /**
     * Attribution probe for gestures that produce no known event.
     *
     * Why this exists: ANC changes made on the BUDS raise no 0x0204 event (verified
     * three separate captures — Off/Light/Medium each emitted nothing identifiable).
     * That leaves two possibilities and the raw log cannot tell them apart:
     *
     *   A. the buds said nothing at all, so the only fix is a poll-after-gesture;
     *   B. the buds DID say something in a frame we don't decode yet (the recurring
     *      `AA 0D 00 00 04 02 FF 06 00 F1 01 01 XX YY 02` shape), and it only looks
     *      like silence because nothing in the log names it.
     *
     * This stamps the two cases differently so one capture decides it. It is a
     * DIAGNOSTIC only — it never changes state and never touches the UI, so it is
     * safe to leave in permanently; `sendAnc`'s flush flag is the only extra signal.
     *
     * Classification is deliberately "everything not already explained", because the
     * frames we DO decode (handshake, battery, wear, game mode, status/ANC query
     * replies) are handled by their own branches further down.
     */
    private fun noteUnattributed(packet: ByteArray) {
        if (packet.size < 9) return
        val cmd = (packet[4].toInt() and 0xFF) or ((packet[5].toInt() and 0xFF) shl 8)
        val payload = payloadOf(packet)

        val explained = cmd == 0x8100 ||                 // handshake
            cmd == 0x8103 ||                             // product id
            cmd == 0x8106 ||                             // battery query reply
            cmd == 0x8109 ||                             // wearing query reply
            cmd == OpoProtocol.CMD_RESP_WEARING ||
            cmd == 0x810C ||                             // ANC query reply
            cmd == 0x810D ||                             // status query reply
            cmd == 0x8122 ||                             // EQ query reply
            cmd == OpoProtocol.CMD_ACTIVE_REPORT ||
            cmd == OpoProtocol.CMD_RESP_KEY_FUNCTION ||   // gesture-config query reply
            cmd in 0x8400..0x84FF ||                     // acks for 0x04xx set commands
            cmd == OpoProtocol.CMD_REGISTER_NOTIFY
        if (explained) return

        val head = payload.take(4).joinToString(" ") { "%02X".format(it) }
        log("UNATTR RX: cmd=0x${"%04X".format(cmd)} len=${payload.size} " +
            "head=[$head] ancFlush=${if (System.currentTimeMillis() - lastAncFlushAt < 4000) "YES" else "no"}")
    }

    private fun handlePacket(packet: ByteArray) {
        log("RX: ${OpoProtocol.bytesToHex(packet)}")
        noteUnattributed(packet)
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

        // --- getKeyFunction reply: 0x8108, the CURRENT gesture bindings ---
        // This reply is BOTH a diagnostic and the source of truth a write is built from:
        // a setKeyFunction payload carries the WHOLE table, so the entries we are not
        // changing have to come from here. The last good reading is parked in
        // lastKeyFnTable for exactly that, and writeGestureBinding() refuses to run
        // without it rather than inventing the other entries.
        if (cmd == OpoProtocol.CMD_RESP_KEY_FUNCTION) {
            log("KEYFN: ${KeyFunctionParser.describe(payload)}")

            // The diff is the whole point of reading this reply: it describes the
            // CURRENT bindings, so ONE change made in the vendor app names that
            // function's `fn` value. Printed on its own line, and only when there is a
            // baseline to compare against, so the ordinary init-sequence reading does
            // not grow a second line that says nothing.
            val table = KeyFunctionParser.parse(payload)
            if (table.entries.isNotEmpty()) {
                // Only a reply with entries replaces the stored table, for the same
                // reason the diff baseline is not overwritten by an empty one: a
                // garbled read must not cost us the table we would write back from.
                lastKeyFnTable = table
                log("KEYFN DIFF: ${keyFnDiff(table)}")
            }
            return
        }

        // --- User-interaction (button/gesture) report: 0x0204 subType 0xF1 ---
        // This is the F1 family that has been sitting unexplained in the captures.
        // We now at least NAME it, so an ANC-gesture capture can answer the question
        // "nothing arrived" vs "a frame arrived that we don't decode".
        // Handled before the game-mode branch because both are 2..6 byte payloads.
        if (cmd == OpoProtocol.CMD_ACTIVE_REPORT &&
            UserInteractionParser.isUserInteractionEvent(payload)) {
            log("BTN EVT: ${UserInteractionParser.describe(payload)}")
            return
        }

        // --- ANC changed on the buds: 0x0204 spontaneous event, subType 0x03 ---
        // Raised by an ANC gesture on either bud. Mapped and confirmed — see
        // AncEventParser for the frame shape and the four known values.
        //
        // Handled BEFORE the length-based checks below because the payload is only
        // 5 bytes.
        //
        // The event reflects the buds' real state whether the change came from a
        // gesture or from our own command, so there is deliberately NO suppression
        // of "our own" echoes: BudsService drops a mode equal to the stored one, so
        // an echo is a no-op and a genuine external change always lands.
        //
        // A mode that cannot be named (unrecognised value) is logged but NOT pushed,
        // so we never invent a mode the buds did not report.
        if (cmd == OpoProtocol.CMD_ACTIVE_REPORT &&
            AncEventParser.isAncEvent(payload)) {
            val mode = AncEventParser.parseActive(payload, lastAncLevelSent)
            log("ANC EVT: ${AncEventParser.describe(payload, lastAncLevelSent)}")
            if (mode != null) {
                handler.post { listeners.forEach { it.onAncModeState(mode) } }
            }
            return
        }

        // --- Game mode changed on the buds: 0x0204 spontaneous event, subType 0x05 ---
        // Raised for BOTH our own setGameMode() and the user's buds gesture, so this
        // is what keeps the widget/app buttons honest. Previously this frame fell
        // through to the battery checks below, matched neither, and was discarded —
        // which is why the buttons never updated after a gesture.
        // Payload is only 2 bytes, so this must come before any length assumption.
        if (cmd == OpoProtocol.CMD_ACTIVE_REPORT &&
            GameModeParser.isGameModeEvent(payload)) {
            val on = GameModeParser.parseActive(payload)
            if (on != null) {
                log("GAME EVT: ${if (on) "ON" else "OFF"}")
                handler.post { listeners.forEach { it.onGameModeState(on) } }
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
