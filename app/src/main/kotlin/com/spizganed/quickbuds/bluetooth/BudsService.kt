package com.spizganed.quickbuds.bluetooth

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Binder
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.PowerManager
import android.util.Log
import com.spizganed.quickbuds.widget.AncWidgetProvider
import com.spizganed.quickbuds.widget.WidgetStateStore

class BudsService : Service(), BudsConnectionManager.Listener {

    private val binder = LocalBinder()
    var manager: BudsConnectionManager? = null
        private set

    private var wakeLock: PowerManager.WakeLock? = null
    private val TARGET_MAC = "A8:E6:E8:92:C1:25"
    private val handler = Handler(Looper.getMainLooper())

    private fun statusLog(msg: String) {
        Log.d("BudsConn", msg)
        manager?.let { m ->
            handler.post {
                try {
                    val listenerField = m.javaClass.getDeclaredField("listeners")
                    listenerField.isAccessible = true
                    val listeners = listenerField.get(m) as? java.util.concurrent.CopyOnWriteArrayList<*>
                    listeners?.forEach { l ->
                        if (l === this@BudsService) return@forEach
                        try {
                            val onStatusMethod = l?.javaClass?.getMethod("onStatus", String::class.java)
                            onStatusMethod?.invoke(l, msg)
                        } catch (_: Exception) {}
                    }
                } catch (_: Exception) {}
            }
        }
    }

    private val widgetCommandReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action != ACTION_WIDGET_COMMAND) return
            val widgetAction = intent.getStringExtra(EXTRA_WIDGET_ACTION)
            val ancMode = intent.getStringExtra(EXTRA_WIDGET_ANC_MODE)
            val gameMode = intent.getBooleanExtra(EXTRA_WIDGET_GAME_MODE, false)
            statusLog("<< WIDGET broadcast: action=$widgetAction (anc=$ancMode, game=$gameMode)")
            executeWidgetCommand(widgetAction, ancMode, gameMode)
        }
    }

    inner class LocalBinder : Binder() {
        fun getService(): BudsService = this@BudsService
    }

    override fun onCreate() {
        super.onCreate()
        statusLog("[SVC] onCreate")
        val pm = getSystemService(POWER_SERVICE) as PowerManager
        wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "BudsQS::GattWakeLock")
        wakeLock?.setReferenceCounted(false)
        wakeLock?.acquire(60 * 60 * 1000L)

        manager = BudsConnectionManager(this).also { it.addListener(this) }

        val filter = IntentFilter(ACTION_WIDGET_COMMAND)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(widgetCommandReceiver, filter, Context.RECEIVER_NOT_EXPORTED)
        } else {
            @Suppress("UnspecifiedRegisterReceiverFlag")
            registerReceiver(widgetCommandReceiver, filter)
        }

        startForegroundService()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        statusLog("[SVC] onStartCommand action=${intent?.action}")

        when (intent?.action) {
            ACTION_FORCE_CONNECT -> {
                if (manager?.isConnected() == true) {
                    statusLog("[SVC] FORCE_CONNECT ignored (already connected)")
                } else {
                    statusLog("[SVC] FORCE_CONNECT: connecting...")
                    try {
                        val device = BluetoothAdapter.getDefaultAdapter()?.getRemoteDevice(TARGET_MAC)
                        if (device != null) manager?.connect(device)
                    } catch (e: Exception) {
                        statusLog("[SVC] Force connect failed: ${e.message}")
                    }
                }
            }
            ACTION_FORCE_DISCONNECT -> {
                statusLog("[SVC] FORCE_DISCONNECT")
                manager?.disconnect()
            }
            ACTION_WIDGET_COMMAND -> {
                val widgetAction = intent.getStringExtra(EXTRA_WIDGET_ACTION)
                val ancMode = intent.getStringExtra(EXTRA_WIDGET_ANC_MODE)
                val gameMode = intent.getBooleanExtra(EXTRA_WIDGET_GAME_MODE, false)
                statusLog("<< startService WIDGET_COMMAND: action=$widgetAction (anc=$ancMode, game=$gameMode)")
                if (manager?.isConnected() == true) {
                    executeWidgetCommand(widgetAction, ancMode, gameMode)
                } else {
                    statusLog("<< not connected yet — will retry in 800ms")
                    handler.postDelayed({
                        executeWidgetCommand(widgetAction, ancMode, gameMode)
                    }, 800)
                }
            }
            else -> statusLog("[SVC] onStartCommand (no action)")
        }
        return START_STICKY
    }

    private fun executeWidgetCommand(widgetAction: String?, ancMode: String?, gameMode: Boolean) {
        val connected = manager?.isConnected() == true
        statusLog("<< executeWidgetCommand: action=$widgetAction (anc=$ancMode, game=$gameMode, connected=$connected)")

        if (!connected) {
            statusLog("<< SKIPPED — not connected")
            return
        }

        when (widgetAction) {
            "ANC_CYCLE" -> when (ancMode) {
                "ANC-Deep" -> { statusLog("<< sending ANC Deep"); manager?.sendAncDeep() }
                "ANC-Medium" -> { statusLog("<< sending ANC Medium"); manager?.sendAncMedium() }
                "ANC-Light" -> { statusLog("<< sending ANC Light"); manager?.sendAncLight() }
                "ANC-Smart" -> { statusLog("<< sending ANC Smart"); manager?.sendAncSmart() }
            }
            "TRANS" -> { statusLog("<< sending Transparency"); manager?.sendAncTransparency() }
            "OFF" -> { statusLog("<< sending ANC Off"); manager?.sendAncOff() }
            "GAME_TOGGLE" -> { statusLog("<< sending Game $gameMode"); manager?.setGameMode(gameMode) }
            else -> statusLog("<< UNKNOWN widget action: '$widgetAction'")
        }
    }

    private fun startForegroundService() {
        val channelId = "BudsQS_Service"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Buds Connection",
                NotificationManager.IMPORTANCE_MIN
            ).apply {
                setShowBadge(false)
                enableLights(false)
                enableVibration(false)
                setSound(null, null)
                description = "Keeps the connection to your earbuds alive"
            }
            getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        }

        val notification: Notification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(this, channelId)
                .setContentTitle("QuickBuds")
                .setContentText("Maintaining connection to earbuds")
                .setSmallIcon(android.R.drawable.stat_sys_headset)
                .setOngoing(false)
                .setShowWhen(false)
                .setPriority(Notification.PRIORITY_MIN)
                .build()
        } else {
            @Suppress("DEPRECATION")
            Notification.Builder(this)
                .setContentTitle("QuickBuds")
                .setContentText("Maintaining connection to earbuds")
                .setSmallIcon(android.R.drawable.stat_sys_headset)
                .setOngoing(false)
                .setShowWhen(false)
                .setPriority(Notification.PRIORITY_MIN)
                .build()
        }
        startForeground(1, notification)
    }

    override fun onBind(intent: Intent?): IBinder {
        statusLog("[SVC] onBind")
        return binder
    }

    override fun onDestroy() {
        statusLog("[SVC] onDestroy")
        try { manager?.removeListener(this) } catch (_: Exception) {}
        try { unregisterReceiver(widgetCommandReceiver) } catch (_: Exception) {}
        try { wakeLock?.release() } catch (_: Exception) {}
        wakeLock = null
        super.onDestroy()
    }

    override fun onStatus(msg: String) {}

    override fun onConnected(connected: Boolean) {
        val st = WidgetStateStore.read(this)
        if (connected) {
            statusLog("[SVC] Connected")
            if (st.caseLidClosed || st.leftDocked || st.rightDocked) {
                st.caseLidClosed = false
                st.leftDocked = false
                st.rightDocked = false
                WidgetStateStore.write(this, st)
                AncWidgetProvider.refreshAll(this)
            }
        } else {
            statusLog("[SVC] Disconnected")
            st.leftBattery = -1
            st.caseBattery = -1
            st.rightBattery = -1
            // Socket died with a bud in the case (4 = docked, 0 = docked & asleep)
            // => lid closed. Freeze the docked set so those icons stay hidden.
            if (st.leftStatus == 4 || st.rightStatus == 4 ||
                st.leftStatus == 0 || st.rightStatus == 0) {
                st.caseLidClosed = true
                st.leftDocked = (st.leftStatus == 4 || st.leftStatus == 0)
                st.rightDocked = (st.rightStatus == 4 || st.rightStatus == 0)
            }
            WidgetStateStore.write(this, st)
            AncWidgetProvider.refreshAll(this)
        }
    }

    override fun onPacketReceived(bytes: ByteArray) {}

    override fun onBattery(
        left: Int?, case: Int?, right: Int?,
        chargingLeft: Boolean, chargingCase: Boolean, chargingRight: Boolean
    ) {
        statusLog("[SVC] Battery: L=$left C=$case R=$right " +
                "(chg: $chargingLeft/$chargingCase/$chargingRight)")
        val st = WidgetStateStore.read(this)
        if (left != null) st.leftBattery = left
        if (case != null) st.caseBattery = case
        if (right != null) st.rightBattery = right
        WidgetStateStore.write(this, st)
        AncWidgetProvider.refreshAll(this)
    }

    override fun onBudState(state: String) {}

    override fun onEarStatus(leftInBox: Boolean, rightInBox: Boolean) {}

    override fun onWearState(left: Int, right: Int, caseSt: Int) {
        val st = WidgetStateStore.read(this)
        var changed = false
        if (left >= 0 && st.leftStatus != left) {
            st.leftStatus = left
            st.leftInBox = (left == 4)
            changed = true
        }
        if (right >= 0 && st.rightStatus != right) {
            st.rightStatus = right
            st.rightInBox = (right == 4)
            changed = true
        }
        if (changed) {
            statusLog("[SVC] Wear state: L=$left R=$right case=$caseSt")
            WidgetStateStore.write(this, st)
            AncWidgetProvider.refreshAll(this)
        }
    }

    companion object {
        const val ACTION_FORCE_CONNECT = "com.spizganed.quickbuds.FORCE_CONNECT"
        const val ACTION_FORCE_DISCONNECT = "com.spizganed.quickbuds.FORCE_DISCONNECT"
        const val ACTION_WIDGET_COMMAND = "com.spizganed.quickbuds.WIDGET_COMMAND"
        const val EXTRA_WIDGET_ACTION = "widget_action"
        const val EXTRA_WIDGET_ANC_MODE = "widget_anc_mode"
        const val EXTRA_WIDGET_GAME_MODE = "widget_game_mode"
    }
}
