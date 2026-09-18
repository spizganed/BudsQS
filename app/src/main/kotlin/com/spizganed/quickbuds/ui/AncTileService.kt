package com.spizganed.quickbuds.ui

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.graphics.drawable.Icon
import android.os.Build
import android.os.IBinder
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import com.spizganed.quickbuds.R
import com.spizganed.quickbuds.bluetooth.BudsConnectionManager
import com.spizganed.quickbuds.bluetooth.BudsService

class AncTileService : TileService(), BudsConnectionManager.Listener {

    private var isBound = false
    private var manager: BudsConnectionManager? = null

    private var currentAncModeName: String = "Off"
    private var currentCycleIndex: Int = 0
    private var batteryLeft: Int = -1
    private var batteryCase: Int = -1
    private var batteryRight: Int = -1

    private val ancCycle = listOf("Off", "Trans", "Smart", "Adaptive")

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
        currentAncModeName = ancCycle[currentCycleIndex]
        when (currentAncModeName) {
            "Off" -> manager?.sendAncOff()
            "Trans" -> manager?.sendAncTransparency()
            "Smart" -> manager?.sendAncSmart()
            // Adaptive is NOT Smart: different bits (0x0800 vs 0x0080) and a different
            // bud state. It is appended to the cycle rather than replacing Smart, so
            // this change adds a mode instead of quietly removing one.
            "Adaptive" -> manager?.sendAncAdaptive()
        }
        updateTile()
    }

    override fun onTileAdded() {
        super.onTileAdded()
        updateTile()
    }

    private fun updateTile() {
        val tile = qsTile ?: return
        tile.icon = Icon.createWithResource(this, R.drawable.ic_anc_tile)

        val batLabel = if (batteryLeft >= 0 && batteryRight >= 0) {
            "$batteryLeft/$batteryRight"
        } else ""

        tile.label = if (batLabel.isNotEmpty()) {
            "$currentAncModeName $batLabel"
        } else {
            "ANC: $currentAncModeName"
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val l = if (batteryLeft >= 0) "$batteryLeft%" else "--"
            val c = if (batteryCase >= 0) "$batteryCase%" else "--"
            val r = if (batteryRight >= 0) "$batteryRight%" else "--"
            tile.subtitle = "L:$l C:$c R:$r"
        }

        tile.state = when (currentAncModeName) {
            // Adaptive counts as ACTIVE: cancelling is on, the buds are just choosing
            // the strength themselves. Treating it as inactive would make the tile
            // read as "nothing is on" while the buds were actively cancelling.
            "Off", "Trans" -> Tile.STATE_INACTIVE
            else -> Tile.STATE_ACTIVE
        }
        tile.updateTile()
    }

    override fun onStatus(msg: String) {}
    override fun onConnected(connected: Boolean) { updateTile() }
    override fun onPacketReceived(bytes: ByteArray) {}

    override fun onBattery(
        left: Int?, case: Int?, right: Int?,
        chargingLeft: Boolean, chargingCase: Boolean, chargingRight: Boolean
    ) {
        if (left != null) batteryLeft = left
        if (case != null) batteryCase = case
        if (right != null) batteryRight = right
        updateTile()
    }

    override fun onBudState(state: String) {}
}