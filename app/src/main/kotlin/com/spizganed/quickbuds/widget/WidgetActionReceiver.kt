package com.spizganed.quickbuds.widget

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.spizganed.quickbuds.bluetooth.BudsService
import com.spizganed.quickbuds.bluetooth.WidgetActions

class WidgetActionReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action ?: return
        Log.d("BudsWidget", "[RX] Action: $action")

        // Determine the SHORT action name that BudsService expects
        val shortAction = when (action) {
            WidgetActions.ACTION_ANC_CYCLE -> "ANC_CYCLE"
            WidgetActions.ACTION_TRANS -> "TRANS"
            WidgetActions.ACTION_OFF -> "OFF"
            WidgetActions.ACTION_GAME_TOGGLE -> "GAME_TOGGLE"
            else -> {
                Log.d("BudsWidget", "[RX] Unknown action, ignoring")
                return
            }
        }

        val state = WidgetStateStore.read(context)
        when (shortAction) {
            "ANC_CYCLE" -> {
                state.ancMode = when (state.ancMode) {
                    "ANC-Deep" -> "ANC-Medium"
                    "ANC-Medium" -> "ANC-Light"
                    "ANC-Light" -> "ANC-Smart"
                    else -> "ANC-Deep"
                }
            }
            "TRANS" -> state.ancMode = "Transparency"
            "OFF" -> state.ancMode = "Off"
            "GAME_TOGGLE" -> state.gameMode = !state.gameMode
        }
        Log.d("BudsWidget", "[RX] New state: ${state.ancMode} game=${state.gameMode}")
        WidgetStateStore.write(context, state)
        AncWidgetProvider.refreshAll(context)

        // Send a local broadcast with the SHORT action name
        val localIntent = Intent(BudsService.ACTION_WIDGET_COMMAND).apply {
            putExtra(BudsService.EXTRA_WIDGET_ACTION, shortAction)  // <-- short name
            putExtra(BudsService.EXTRA_WIDGET_ANC_MODE, state.ancMode)
            putExtra(BudsService.EXTRA_WIDGET_GAME_MODE, state.gameMode)
        }
        context.sendBroadcast(localIntent)
        Log.d("BudsWidget", "[RX] Sent broadcast with action=$shortAction")

        // Fallback: startService in case the service was cold-started
        try {
            val serviceIntent = Intent(context, BudsService::class.java).apply {
                this.action = BudsService.ACTION_WIDGET_COMMAND
                putExtra(BudsService.EXTRA_WIDGET_ACTION, shortAction)  // <-- short name
                putExtra(BudsService.EXTRA_WIDGET_ANC_MODE, state.ancMode)
                putExtra(BudsService.EXTRA_WIDGET_GAME_MODE, state.gameMode)
            }
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                context.startForegroundService(serviceIntent)
            } else {
                context.startService(serviceIntent)
            }
        } catch (e: Exception) {
            Log.e("BudsWidget", "[RX] startService failed (ok if broadcast handled it)", e)
        }
    }
}