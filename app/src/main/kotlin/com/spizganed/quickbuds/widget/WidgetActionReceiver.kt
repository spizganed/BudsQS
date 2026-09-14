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
        if (action == WidgetActions.ACTION_NOOP) return

        Log.d("BudsWidget", "[RX] Action: $action")

        val state = WidgetStateStore.read(context)
        var shortAction: String? = null
        var sendAncMode: String = state.ancMode

        when (action) {
            WidgetActions.ACTION_ANC_SELECT -> {
                val target = intent.getStringExtra(WidgetActions.EXTRA_ANC_TARGET) ?: return
                when (target) {
                    "off"   -> { state.ancMode = "Off";          shortAction = "OFF" }
                    "trans" -> { state.ancMode = "Transparency"; shortAction = "TRANS" }
                    "low"   -> { state.ancMode = "ANC-Light";    shortAction = "ANC_CYCLE" }
                    "med"   -> { state.ancMode = "ANC-Medium";   shortAction = "ANC_CYCLE" }
                    "high"  -> { state.ancMode = "ANC-Deep";     shortAction = "ANC_CYCLE" }
                }
                sendAncMode = state.ancMode
            }
            WidgetActions.ACTION_GAME_TOGGLE -> {
                state.gameMode = !state.gameMode
                shortAction = "GAME_TOGGLE"
            }
            WidgetActions.ACTION_ANC_CYCLE -> {
                state.ancMode = when (state.ancMode) {
                    "Off" -> "ANC-Light"
                    "ANC-Light" -> "ANC-Medium"
                    "ANC-Medium" -> "ANC-Deep"
                    "ANC-Deep" -> "ANC-Light"
                    "Transparency" -> "ANC-Light"
                    else -> "ANC-Light"
                }
                shortAction = "ANC_CYCLE"
                sendAncMode = state.ancMode
            }
            WidgetActions.ACTION_TRANS -> {
                state.ancMode = "Transparency"; shortAction = "TRANS"
            }
            WidgetActions.ACTION_OFF -> {
                state.ancMode = "Off"; shortAction = "OFF"
            }
            else -> {
                Log.d("BudsWidget", "[RX] Unknown action, ignoring")
                return
            }
        }

        WidgetStateStore.write(context, state)
        AncWidgetProvider.refreshAll(context)

        val finalShort = shortAction ?: return

        val localIntent = Intent(BudsService.ACTION_WIDGET_COMMAND).apply {
            putExtra(BudsService.EXTRA_WIDGET_ACTION, finalShort)
            putExtra(BudsService.EXTRA_WIDGET_ANC_MODE, sendAncMode)
            putExtra(BudsService.EXTRA_WIDGET_GAME_MODE, state.gameMode)
        }
        context.sendBroadcast(localIntent)

        try {
            val serviceIntent = Intent(context, BudsService::class.java).apply {
                this.action = BudsService.ACTION_WIDGET_COMMAND
                putExtra(BudsService.EXTRA_WIDGET_ACTION, finalShort)
                putExtra(BudsService.EXTRA_WIDGET_ANC_MODE, sendAncMode)
                putExtra(BudsService.EXTRA_WIDGET_GAME_MODE, state.gameMode)
            }
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                context.startForegroundService(serviceIntent)
            } else {
                context.startService(serviceIntent)
            }
        } catch (e: Exception) {
            Log.e("BudsWidget", "[RX] startService failed", e)
        }
    }
}
