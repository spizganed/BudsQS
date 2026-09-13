package com.example.oneplusbudsqs.bluetooth

import android.annotation.SuppressLint
import android.bluetooth.*
import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.oneplusbudsqs.protocol.OpoProtocol
import java.util.*
import java.util.concurrent.CopyOnWriteArrayList

@SuppressLint("MissingPermission")
class BudsConnectionManager(private val context: Context) {

    interface Listener {
        fun onStatus(msg: String)
        fun onConnected(connected: Boolean)
        fun onPacketReceived(bytes: ByteArray)
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
    private var bluetoothGatt: BluetoothGatt? = null
    private var writeChar: BluetoothGattCharacteristic? = null
    private var notifyChar: BluetoothGattCharacteristic? = null
    private var isReady = false
    private var lastConnectAttempt = 0L

    private val gattCallback = object : BluetoothGattCallback() {
        override fun onConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
            Log.d("BudsConn", "onConnectionStateChange status: $status, newState: $newState")
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                log("Connected! Discovering services...")
                gatt.discoverServices()
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                log("GATT disconnected (Status: $status)")
                isReady = false
                try { bluetoothGatt?.close() } catch (e: Exception) {}
                bluetoothGatt = null
                writeChar = null
                notifyChar = null
                handler.post { listeners.forEach { it.onConnected(false) } }
            }
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
            if (status != BluetoothGatt.GATT_SUCCESS) return
            val service = gatt.getService(UUID.fromString(OpoProtocol.SERVICE_UUID)) ?: return
            writeChar = service.getCharacteristic(UUID.fromString(OpoProtocol.WRITE_CHAR_UUID))
            notifyChar = service.getCharacteristic(UUID.fromString(OpoProtocol.NOTIFY_CHAR_UUID))

            val nChar = notifyChar
            if (nChar == null) {
                log("Notify characteristic not found!")
                return
            }
            gatt.setCharacteristicNotification(nChar, true)
            val descriptor = nChar.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"))
            if (descriptor == null) {
                // No CCCD; fall back to starting the handshake anyway.
                log("CCCD descriptor missing; starting handshake without it.")
                startHandshake()
                return
            }
            // IMPORTANT: only ONE GATT op may be in flight. We must wait for the CCCD
            // write to complete (onDescriptorWrite) BEFORE writing HELLO, otherwise the
            // descriptor write is clobbered and the buds never send notifications.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                gatt.writeDescriptor(descriptor, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE)
            } else {
                @Suppress("DEPRECATION")
                descriptor.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
                @Suppress("DEPRECATION")
                gatt.writeDescriptor(descriptor)
            }
        }

        override fun onDescriptorWrite(gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int) {
            log("CCCD write complete (status=$status). Notifications enabled; starting handshake.")
            startHandshake()
        }

        override fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, value: ByteArray) {
            log("RX: ${OpoProtocol.bytesToHex(value)}")
            handler.post { listeners.forEach { it.onPacketReceived(value) } }
        }

        @Deprecated("Deprecated in Java")
        override fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
                @Suppress("DEPRECATION")
                val data = characteristic.value ?: return
                log("RX: ${OpoProtocol.bytesToHex(data)}")
                handler.post { listeners.forEach { it.onPacketReceived(data) } }
            }
        }
    }

    fun connect(device: BluetoothDevice) {
        val now = System.currentTimeMillis()
        if (now - lastConnectAttempt < 3000) {
            Log.d("BudsConn", "Connect debounced.")
            return
        }
        lastConnectAttempt = now

        if (bluetoothGatt != null) {
            log("Already connected or connecting.")
            return
        }

        log("Initiating silent background connection to ${device.name}...")
        bluetoothGatt = device.connectGatt(context, true, gattCallback, BluetoothDevice.TRANSPORT_LE)
    }

    /**
     * Called by KeepAliveReceiver when ACL/profile CONNECTED fires.
     * KEY FIX: If we're already ready (handshake complete), do NOTHING.
     * Only tear down and reconnect if we're not currently connected.
     */
    fun forceReconnect(device: BluetoothDevice) {
        // If we're already fully connected and ready, don't touch it!
        if (isReady && bluetoothGatt != null) {
            Log.d("BudsConn", "forceReconnect ignored — already READY.")
            return
        }
        // If we have a GATT that's still connecting (not yet ready), also let it be
        if (bluetoothGatt != null) {
            Log.d("BudsConn", "forceReconnect ignored — connection in progress.")
            return
        }

        Log.d("BudsConn", "forceReconnect proceeding.")
        lastConnectAttempt = 0L
        log("Force-reconnecting to ${device.name}...")
        bluetoothGatt = device.connectGatt(context, true, gattCallback, BluetoothDevice.TRANSPORT_LE)
    }

    /**
     * Called by KeepAliveReceiver when ACL_DISCONNECTED fires.
     */
    fun forceCleanup() {
        Log.d("BudsConn", "forceCleanup called.")
        isReady = false
        try { bluetoothGatt?.close() } catch (e: Exception) {}
        bluetoothGatt = null
        writeChar = null
        notifyChar = null
        handler.post { listeners.forEach { it.onConnected(false) } }
    }

    fun connectAudioProfile(device: BluetoothDevice) {
        val adapter = BluetoothAdapter.getDefaultAdapter()
        adapter?.getProfileProxy(context, object : BluetoothProfile.ServiceListener {
            override fun onServiceConnected(profile: Int, proxy: BluetoothProfile) {
                if (profile == BluetoothProfile.A2DP) {
                    try {
                        val method = proxy.javaClass.getMethod("connect", BluetoothDevice::class.java)
                        method.invoke(proxy, device)
                    } catch (e: Exception) { }
                    adapter.closeProfileProxy(BluetoothProfile.A2DP, proxy)
                }
            }
            override fun onServiceDisconnected(profile: Int) {}
        }, BluetoothProfile.A2DP)
    }

    fun disconnect() {
        bluetoothGatt?.disconnect()
        bluetoothGatt?.close()
        bluetoothGatt = null
        isReady = false
        handler.post { listeners.forEach { it.onConnected(false) } }
    }

    private fun startHandshake() {
        sendRaw(OpoProtocol.HELLO)
        handler.postDelayed({
            sendRaw(OpoProtocol.REGISTER)
            handler.postDelayed({
                isReady = true
                log("Handshake complete. Ready for commands.")
                handler.post { listeners.forEach { it.onConnected(true) } }
            }, 1500)
        }, 2000)
    }

    fun sendAncMode(mode: Byte) {
        if (!isReady) { log("Not ready"); return }
        sendRaw(OpoProtocol.ancSetPacket(mode))
    }

    fun setGameMode(on: Boolean) {
        if (!isReady) { log("Not ready"); return }
        sendRaw(if (on) OpoProtocol.gameModeOn() else OpoProtocol.gameModeOff())
    }

    @Suppress("DEPRECATION")
    private fun sendRaw(data: ByteArray) {
        val char = writeChar ?: return
        val gatt = bluetoothGatt ?: return
        log("TX: ${OpoProtocol.bytesToHex(data)}")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            gatt.writeCharacteristic(char, data, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE)
        } else {
            char.value = data
            char.writeType = BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
            gatt.writeCharacteristic(char)
        }
    }

    private fun log(msg: String) {
        Log.d("BudsConn", msg)
        handler.post { listeners.forEach { it.onStatus(msg) } }
    }
}