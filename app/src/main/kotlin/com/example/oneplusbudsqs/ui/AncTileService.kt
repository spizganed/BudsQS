package com.example.oneplusbudsqs.ui

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.graphics.drawable.Icon
import android.os.Build
import android.os.IBinder
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import com.example.oneplusbudsqs.R
import com.example.oneplusbudsqs.bluetooth.BudsConnectionManager
import com.example.oneplusbudsqs.bluetooth.BudsService
import com.example.oneplusbudsqs.protocol.OpoProtocol

class AncTileService : TileService(), BudsConnectionManager.Listener {

    private var isBound = false
    private var manager: BudsConnectionManager? = null

    private var currentAncModeName: String = "Off"
    private var currentCycleIndex: Int = 0
    private var batteryLeft: Int = -1
    private var batteryCase: Int = -1
    private var batteryRight: Int = -1

    // 3-Mode cycle: Off -> Trans -> Med -> Off
    private val ancCycle = listOf(
        "Off" to OpoProtocol.ANC_OFF,
        "Trans" to OpoProtocol.ANC_TRANSPARENCY,
        "Med" to OpoProtocol.ANC_MODERATE
    )

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as BudsService.LocalBinder
            manager = binder.getService().manager
            manager?.addListener(this@AncTileService)
            isBound = true
            updateTile()
        }
        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
            manager = null
        }
    }

    override fun onStartListening() {
        super.onStartListening()
        val intent = Intent(this, BudsService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onStopListening() {
        super.onStopListening()
        if (isBound) {
            manager?.removeListener(this)
            unbindService(serviceConnection)
            isBound = false
        }
    }

    override fun onClick() {
        super.onClick()

        if (!isBound || manager == null) {
            val intent = Intent(this, BudsService::class.java)
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
            return
        }

        currentCycleIndex = (currentCycleIndex + 1) % ancCycle.size
        val (name, mode) = ancCycle[currentCycleIndex]
        currentAncModeName = name
        manager?.sendAncMode(mode)
        updateTile()
    }

    override fun onTileAdded() {
        super.onTileAdded()
        updateTile()
    }

    private fun updateTile() {
        val tile = qsTile ?: return

        tile.icon = Icon.createWithResource(this, R.drawable.ic_anc_tile)

        // Compact label: "Off 80/80" or just "Off" if battery unknown
        val batLabel = if (batteryLeft >= 0 && batteryRight >= 0) {
            "$batteryLeft/$batteryRight"
        } else ""

        tile.label = if (batLabel.isNotEmpty()) {
            "$currentAncModeName $batLabel"
        } else {
            "ANC: $currentAncModeName"
        }

        // Subtitle works on Android 13+ (may not render on Nothing OS, but costs nothing)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val l = if (batteryLeft >= 0) "$batteryLeft%" else "--"
            val c = if (batteryCase >= 0) "$batteryCase%" else "--"
            val r = if (batteryRight >= 0) "$batteryRight%" else "--"
            tile.subtitle = "L:$l C:$c R:$r"
        }

        tile.state = when (currentAncModeName) {
            "Off", "Trans" -> Tile.STATE_INACTIVE
            else -> Tile.STATE_ACTIVE
        }

        tile.updateTile()
    }

    // Decode one battery byte: low 7 bits = percent, top bit = charging.
    // Returns -1 for "unknown" (level 0).
    private fun decodeBatteryLevel(b: Byte): Int {
        val level = b.toInt() and 0x7F
        return if (level in 1..100) level else -1
    }

    override fun onStatus(msg: String) {}
    override fun onConnected(connected: Boolean) { updateTile() }

    override fun onPacketReceived(bytes: ByteArray) {
        if (bytes.size < 5) return

        // AA 0D battery packet. Real capture:
        //   AA 0D 00 00 04 02 FF 06 00 F1 [L] [R] 00 00 03
        // Per HeyMelody's decompiled BatteryInfo decoder each level byte is:
        //   level    = b & 0x7F  (low 7 bits = percent)
        //   charging = b & 0x80  (top bit)
        // NOTE: exact L/R/Case offsets still need a live capture with the buds at a
        // known, non-trivial charge to confirm (the reference capture read 01/01).
        if (bytes[0] == 0xAA.toByte() && bytes[1] == 0x0D.toByte() && bytes.size >= 12) {
            batteryLeft = decodeBatteryLevel(bytes[10])
            batteryRight = decodeBatteryLevel(bytes[11])
            // Case battery byte not yet located in this packet; leave as unknown.
            updateTile()
        }
    }
}
