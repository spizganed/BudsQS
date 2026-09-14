package com.example.oneplusbudsqs.bluetooth

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothProfile
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class KeepAliveReceiver : BroadcastReceiver() {

    private val TARGET_MAC = "A8:E6:E8:92:C1:25"

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action ?: return
        val device = intent.getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE)

        if (device?.address != TARGET_MAC) return

        when (action) {
            BluetoothDevice.ACTION_ACL_CONNECTED -> {
                Log.d("BudsConn", "KeepAlive: ACL_CONNECTED")
                fireForceConnect(context)
            }
            BluetoothDevice.ACTION_ACL_DISCONNECTED -> {
                Log.d("BudsConn", "KeepAlive: ACL_DISCONNECTED (no action)")
            }
            "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED" -> {
                val state = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, -1)
                Log.d("BudsConn", "KeepAlive: A2DP state=$state")
            }
            "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED" -> {
                val state = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, -1)
                Log.d("BudsConn", "KeepAlive: HFP state=$state")
            }
        }
    }

    private fun fireForceConnect(context: Context) {
        val serviceIntent = Intent(context, BudsService::class.java)
        serviceIntent.action = BudsService.ACTION_FORCE_CONNECT
        context.startService(serviceIntent)
    }
}