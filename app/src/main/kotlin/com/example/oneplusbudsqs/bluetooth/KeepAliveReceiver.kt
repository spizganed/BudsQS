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
                Log.d("BudsConn", "KeepAlive: ACL_DISCONNECTED - forcing cleanup")
                fireForceDisconnect(context)
            }
            "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED" -> {
                val state = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, -1)
                Log.d("BudsConn", "KeepAlive: A2DP state=$state")
                if (state == BluetoothProfile.STATE_CONNECTED) {
                    fireForceConnect(context)
                }
            }
            "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED" -> {
                val state = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, -1)
                Log.d("BudsConn", "KeepAlive: HFP state=$state")
                if (state == BluetoothProfile.STATE_CONNECTED) {
                    fireForceConnect(context)
                }
            }
        }
    }

    private fun fireForceConnect(context: Context) {
        val serviceIntent = Intent(context, BudsService::class.java)
        serviceIntent.action = "com.example.oneplusbudsqs.FORCE_CONNECT"
        context.startService(serviceIntent)
    }

    private fun fireForceDisconnect(context: Context) {
        val serviceIntent = Intent(context, BudsService::class.java)
        serviceIntent.action = "com.example.oneplusbudsqs.FORCE_DISCONNECT"
        context.startService(serviceIntent)
    }
}