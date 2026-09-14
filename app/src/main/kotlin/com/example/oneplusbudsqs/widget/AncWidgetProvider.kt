package com.example.oneplusbudsqs.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.example.oneplusbudsqs.R
import com.example.oneplusbudsqs.bluetooth.WidgetActions

class AncWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (id in appWidgetIds) {
            updateWidget(context, appWidgetManager, id)
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        // Refresh the widget if the state changed
        if (intent.action == WidgetActions.ACTION_STATE_CHANGED) {
            val mgr = AppWidgetManager.getInstance(context)
            val ids = mgr.getAppWidgetIds(ComponentName(context, AncWidgetProvider::class.java))
            for (id in ids) updateWidget(context, mgr, id)
        }
    }

    companion object {
        fun refreshAll(context: Context) {
            val intent = Intent(context, AncWidgetProvider::class.java)
            intent.action = WidgetActions.ACTION_STATE_CHANGED
            context.sendBroadcast(intent)
        }

        private fun updateWidget(
            context: Context,
            appWidgetManager: AppWidgetManager,
            widgetId: Int
        ) {
            val views = RemoteViews(context.packageName, R.layout.widget_anc)
            val state = WidgetStateStore.read(context)

            views.setTextViewText(R.id.widgetBattery, state.batteryText())
            views.setTextViewText(R.id.widgetAncBtn, state.ancButtonLabel())

            val accent = 0xFFCC0000.toInt()
            val inactive = 0xFF333333.toInt()

            views.setInt(R.id.widgetAncBtn, "setBackgroundColor",
                if (state.ancMode.startsWith("ANC-")) accent else inactive)
            views.setInt(R.id.widgetTransBtn, "setBackgroundColor",
                if (state.ancMode == "Transparency") accent else inactive)
            views.setInt(R.id.widgetOffBtn, "setBackgroundColor",
                if (state.ancMode == "Off") accent else inactive)
            views.setInt(R.id.widgetGameBtn, "setBackgroundColor",
                if (state.gameMode) accent else inactive)

            // PendingIntents now target WidgetActionReceiver DIRECTLY
            views.setOnClickPendingIntent(R.id.widgetAncBtn, pending(context, WidgetActions.ACTION_ANC_CYCLE, 1))
            views.setOnClickPendingIntent(R.id.widgetTransBtn, pending(context, WidgetActions.ACTION_TRANS, 2))
            views.setOnClickPendingIntent(R.id.widgetOffBtn, pending(context, WidgetActions.ACTION_OFF, 3))
            views.setOnClickPendingIntent(R.id.widgetGameBtn, pending(context, WidgetActions.ACTION_GAME_TOGGLE, 4))

            appWidgetManager.updateAppWidget(widgetId, views)
        }

        private fun pending(context: Context, action: String, reqCode: Int): PendingIntent {
            // The key fix: point at WidgetActionReceiver, not AncWidgetProvider
            val intent = Intent(context, WidgetActionReceiver::class.java)
            intent.action = action
            return PendingIntent.getBroadcast(
                context, reqCode, intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        }
    }
}