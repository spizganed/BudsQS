package com.example.oneplusbudsqs.bluetooth

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.os.PowerManager
import android.util.Log

class BudsService : Service() {

    private val binder = LocalBinder()
    var manager: BudsConnectionManager? = null
        private set

    private var wakeLock: PowerManager.WakeLock? = null
    private val TARGET_MAC = "A8:E6:E8:92:C1:25"

    inner class LocalBinder : Binder() {
        fun getService(): BudsService = this@BudsService
    }

    override fun onCreate() {
        super.onCreate()
        val pm = getSystemService(POWER_SERVICE) as PowerManager
        wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "BudsQS::GattWakeLock")
        wakeLock?.setReferenceCounted(false)
        wakeLock?.acquire(60 * 60 * 1000L)

        manager = BudsConnectionManager(this)
        startForegroundService()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            "com.example.oneplusbudsqs.FORCE_CONNECT" -> {
                Log.d("BudsConn", "BudsService: FORCE_CONNECT received.")
                val btAdapter = BluetoothAdapter.getDefaultAdapter()
                try {
                    val device = btAdapter?.getRemoteDevice(TARGET_MAC)
                    if (device != null) {
                        manager?.forceReconnect(device)
                    }
                } catch (e: Exception) {
                    Log.e("BudsConn", "Force connect failed: ${e.message}")
                }
            }
            "com.example.oneplusbudsqs.FORCE_DISCONNECT" -> {
                Log.d("BudsConn", "BudsService: FORCE_DISCONNECT received. Clearing GATT state.")
                manager?.forceCleanup()
            }
        }
        return START_STICKY
    }

    private fun startForegroundService() {
        val channelId = "BudsQS_Service"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "Buds Connection Service", NotificationManager.IMPORTANCE_LOW)
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }

        val notification: Notification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(this, channelId)
                .setContentTitle("Buds QS")
                .setContentText("Maintaining connection to earbuds...")
                .setSmallIcon(android.R.drawable.stat_sys_headset)
                .build()
        } else {
            @Suppress("DEPRECATION")
            Notification.Builder(this)
                .setContentTitle("Buds QS")
                .setContentText("Maintaining connection to earbuds...")
                .setSmallIcon(android.R.drawable.stat_sys_headset)
                .build()
        }
        startForeground(1, notification)
    }

    override fun onBind(intent: Intent?): IBinder = binder

    override fun onDestroy() {
        try { wakeLock?.release() } catch (e: Exception) { }
        wakeLock = null
        super.onDestroy()
    }
}