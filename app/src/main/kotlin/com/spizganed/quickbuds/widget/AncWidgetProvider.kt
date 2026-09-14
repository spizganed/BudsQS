package com.spizganed.quickbuds.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.RemoteViews
import com.spizganed.quickbuds.R
import com.spizganed.quickbuds.bluetooth.WidgetActions

class AncWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (id in appWidgetIds) updateWidget(context, appWidgetManager, id)
    }

    override fun onEnabled(context: Context) {
        super.onEnabled(context)
        refreshAll(context)
    }

    companion object {

        fun refreshAll(context: Context) {
            val mgr = AppWidgetManager.getInstance(context)
            val ids = mgr.getAppWidgetIds(
                ComponentName(context, AncWidgetProvider::class.java)
            )
            for (id in ids) updateWidget(context, mgr, id)
        }

        private fun updateWidget(context: Context, mgr: AppWidgetManager, id: Int) {
            val state = WidgetStateStore.read(context)
            val views = RemoteViews(context.packageName, R.layout.widget_anc)

            views.setOnClickPendingIntent(R.id.widget_root, noopPI(context))

            views.setProgressBar(R.id.widget_bar_left, 100, state.leftProgress(), false)
            views.setProgressBar(R.id.widget_bar_right, 100, state.rightProgress(), false)
            views.setProgressBar(R.id.widget_bar_case, 100, state.caseProgress(), false)

            views.setTextViewText(R.id.widget_text_left, state.leftText())
            views.setTextViewText(R.id.widget_text_right, state.rightText())
            views.setTextViewText(R.id.widget_text_case, state.caseText())

            views.setViewVisibility(
                R.id.widget_row_left,
                if (state.hasLeft()) View.VISIBLE else View.INVISIBLE
            )
            views.setViewVisibility(
                R.id.widget_row_right,
                if (state.hasRight()) View.VISIBLE else View.INVISIBLE
            )
            views.setViewVisibility(
                R.id.widget_row_case,
                if (state.hasCase()) View.VISIBLE else View.INVISIBLE
            )

            setSegment(views, R.id.widget_seg_off,   state.offIsActive())
            setSegment(views, R.id.widget_seg_trans, state.transIsActive())
            setSegment(views, R.id.widget_seg_low,   state.lowIsActive())
            setSegment(views, R.id.widget_seg_med,   state.medIsActive())
            setSegment(views, R.id.widget_seg_high,  state.highIsActive())

            views.setOnClickPendingIntent(R.id.widget_seg_off,   ancSelectPI(context, "off",   200))
            views.setOnClickPendingIntent(R.id.widget_seg_trans, ancSelectPI(context, "trans", 201))
            views.setOnClickPendingIntent(R.id.widget_seg_low,   ancSelectPI(context, "low",   202))
            views.setOnClickPendingIntent(R.id.widget_seg_med,   ancSelectPI(context, "med",   203))
            views.setOnClickPendingIntent(R.id.widget_seg_high,  ancSelectPI(context, "high",  204))

            views.setTextViewText(
                R.id.widget_game_switch,
                if (state.gameMode) "ON" else "OFF"
            )
            views.setInt(
                R.id.widget_game_switch, "setBackgroundResource",
                if (state.gameMode) R.drawable.widget_button_bg_active
                else R.drawable.widget_button_bg
            )
            views.setOnClickPendingIntent(R.id.widget_game_row, gamePI(context))

            mgr.updateAppWidget(id, views)
        }

        private fun setSegment(views: RemoteViews, viewId: Int, active: Boolean) {
            views.setInt(
                viewId, "setBackgroundResource",
                if (active) R.drawable.widget_segment_bg_active
                else R.drawable.widget_segment_bg
            )
            views.setTextColor(
                viewId,
                if (active) 0xFF000000.toInt() else 0xFF8A8A8A.toInt()
            )
        }

        private fun ancSelectPI(context: Context, target: String, reqCode: Int): PendingIntent {
            val intent = Intent(context, WidgetActionReceiver::class.java).apply {
                action = WidgetActions.ACTION_ANC_SELECT
                putExtra(WidgetActions.EXTRA_ANC_TARGET, target)
            }
            return PendingIntent.getBroadcast(
                context, reqCode, intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        }

        private fun gamePI(context: Context): PendingIntent {
            val intent = Intent(context, WidgetActionReceiver::class.java).apply {
                action = WidgetActions.ACTION_GAME_TOGGLE
            }
            return PendingIntent.getBroadcast(
                context, 101, intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        }

        private fun noopPI(context: Context): PendingIntent {
            val intent = Intent(context, WidgetActionReceiver::class.java).apply {
                action = WidgetActions.ACTION_NOOP
            }
            return PendingIntent.getBroadcast(
                context, 999, intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        }
    }
}
