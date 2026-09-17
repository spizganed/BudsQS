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
        // A host-initiated update means the widget is being (re)added or the device
        // reconfigured, so clear any id marked bad and try again.
        badWidgetIds.clear()
        for (id in appWidgetIds) updateWidget(context, appWidgetManager, id)
    }

    override fun onEnabled(context: Context) {
        super.onEnabled(context)
        refreshAll(context)
    }

    /**
     * Drop the cached icon/fade bitmaps when the last widget is removed. Without
     * this the process would keep a fade's worth of bitmaps alive for a widget that
     * is no longer on any home screen.
     */
    override fun onDisabled(context: Context) {
        super.onDisabled(context)
        WidgetIcons.clearCache()
    }

    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        super.onDeleted(context, appWidgetIds)
        for (id in appWidgetIds) {
            lastWidgetIconState.remove(id)
            badWidgetIds.remove(id)
        }
        if (appWidgetIds.isNotEmpty()) WidgetIcons.clearCache()
    }

    companion object {

        /**
         * Last icon state pushed PER WIDGET ID, so a fade only runs on a real change.
         *
         * Keyed by widget id rather than held globally because a user can have more
         * than one copy of this widget on their home screen, and they do get updated
         * independently; a single shared value would make the second widget's icons
         * appear to change when the first one did.
         *
         * The value is a compact signature of what is DRAWN — "<L>|<R>" where each
         * side is "v<colour>" or "h" — not the whole state, because only the icons
         * animate. Bars and text still repaint on every update.
         */
        private val lastWidgetIconState = HashMap<Int, String>()

        /**
         * Runs the fade steps. Main looper: RemoteViews pushes are cheap parcels and
         * the AppWidgetManager calls from a background thread would need care that
         * buys nothing here.
         */
        private val handler = android.os.Handler(android.os.Looper.getMainLooper())

        /** The in-flight fade per widget id, so a new one can cancel the old. */
        private val fadeTokens = HashMap<Int, Runnable>()

        /**
         * Widget ids whose update threw. They are skipped rather than retried on every
         * packet: one bad widget should not spam the log hundreds of times a second,
         * and a fresh onUpdate (which the host sends when the widget is re-added or
         * the device rotates) clears it.
         */
        private val badWidgetIds = HashSet<Int>()

        /** How many times each widget's update has thrown, for the log throttle. */
        private val failureCounts = HashMap<Int, Int>()

        /**
         * A widget fade is a SEQUENCE of RemoteViews pushes, so it has to be short:
         * each step is a full widget update over the AppWidgetService, and a busy
         * home screen should not be asked to do a dozen of them. Four steps at 50ms
         * reads as a fade and costs 4 updates.
         */
        private const val FADE_STEPS = 4
        private const val FADE_STEP_MS = 50L

        // ---- Icon colors (match widget palette) ----
        // white: bud in ear. grey: bud out of ear. hidden: bud in case.
        private fun colorActive(context: Context) = context.getColor(R.color.widget_text_primary)   // #FFFFFF
        private fun colorIdle(context: Context)   = context.getColor(R.color.widget_text_secondary) // #8A8A8A

        fun refreshAll(context: Context) {
            val mgr = AppWidgetManager.getInstance(context)
            val ids = mgr.getAppWidgetIds(
                ComponentName(context, AncWidgetProvider::class.java)
            )
            for (id in ids) updateWidget(context, mgr, id)
        }

        /** Bud state -> (mode, color). st: 4=in case, 0=in case asleep, 3/7=in ear, 1/5=out idle */
        private fun budStyle(context: Context, status: Int): Pair<Int, Int> = when (status) {
            4, 0 -> WidgetIcons.MODE_GONE to colorIdle(context)
            3, 7 -> WidgetIcons.MODE_FILLED to colorActive(context)
            else -> WidgetIcons.MODE_FILLED to colorIdle(context)
        }

        private fun applyIcon(
            context: Context, views: RemoteViews,
            viewId: Int, resId: Int, style: Pair<Int, Int>, alpha: Float = 1f
        ) {
            val (mode, color) = style
            if (mode == WidgetIcons.MODE_GONE) {
                views.setViewVisibility(viewId, View.INVISIBLE)
            } else {
                views.setViewVisibility(viewId, View.VISIBLE)
                views.setImageViewBitmap(
                    viewId,
                    WidgetIcons.tintedAlpha(context, resId, color, alpha)
                )
            }
        }

        /**
         * The widget's show/hide animation, such as it can be.
         *
         * A home-screen widget is RemoteViews: no AnimatorSet, no view animation, no
         * setAlpha on a view. The ONLY way to animate appearance is to push a short
         * sequence of complete widget updates whose icon bitmaps already have the fade
         * drawn into them — which is what WidgetIcons.tintedAlpha produces.
         *
         * THE HONEST LIMIT: this fades IN only. A bud appearing is drawn at rising
         * alpha over four steps, which reads as a fade-in. A bud DISAPPEARING cannot
         * fade out this way, because RemoteViews is stateless — by the time the new
         * state is built, the icon being removed is no longer in it, so there is
         * nothing left to draw at falling alpha. Re-sending the old drawable for a
         * few frames is possible but means holding a second full RemoteViews per step
         * and racing the update that hid it, which is not worth the fragility for a
         * 200ms effect on a small icon. Disappearance is therefore an instant hide,
         * exactly as it was before.
         *
         * CALLED ONLY FOR A GENUINE APPEARANCE (see updateWidgetInner). This is the
         * important constraint: the first frame below is drawn at 25% opacity, so if
         * this ran for a COLOUR-ONLY change it would dim an icon that was already on
         * screen and then brighten it again — the reported blink. Fading is only ever
         * correct for an icon that was hidden a moment ago.
         *
         * Every fade ends by calling updateWidget() again, which pushes the settled
         * state at full alpha. That is deliberate: these steps run on a Handler while
         * battery and wear updates arrive at any time, so an interrupted fade must
         * never be able to leave an icon stuck at partial alpha.
         */
        private fun fadeIcons(context: Context, mgr: AppWidgetManager, id: Int) {
            cancelFade(id)

            val runnable = object : Runnable {
                var step = 0
                override fun run() {
                    if (step >= FADE_STEPS) {
                        fadeTokens.remove(id)
                        updateWidget(context, mgr, id)
                        return
                    }
                    // Never push alpha 0: that is a blank frame, and a blank frame
                    // followed by the real one is a flicker, not a fade.
                    val alpha = (step + 1).toFloat() / FADE_STEPS
                    val state = WidgetStateStore.read(context)
                    mgr.updateAppWidget(id, buildViews(context, state, alpha))
                    step++
                    handler.postDelayed(this, FADE_STEP_MS)
                }
            }
            fadeTokens[id] = runnable
            handler.post(runnable)
        }

        private fun updateWidget(context: Context, mgr: AppWidgetManager, id: Int) {
            // WRAPPED, because a throw in here is invisible: AppWidgetProvider
            // swallows it, the widget host keeps the last good RemoteViews, and the
            // user sees a widget that "won't load" with nothing in the crash log.
            try {
                if (badWidgetIds.contains(id)) return
                updateWidgetInner(context, mgr, id)
            } catch (t: Throwable) {
                // NOT a permanent blacklist any more.
                //
                // The first version added the id to badWidgetIds and SKIPPED it on every
                // later update, so one transient throw disabled that widget for the rest
                // of the session — it kept showing the initial layout and never updated,
                // which is indistinguishable from "the widget doesn't work". The id is
                // still recorded so the log is not spammed, but the update is RETRIED
                // and the failure count is tracked instead of blocking forever.
                badWidgetIds.add(id)
                val n = (failureCounts[id] ?: 0) + 1
                failureCounts[id] = n
                // Log the first few, then every fiftieth: a per-packet failure would
                // otherwise flood the log with thousands of identical lines.
                if (n <= 3 || n % 50 == 0) {
                    android.util.Log.e(
                        "AncWidget",
                        "widget $id update failed (failure #$n)", t
                    )
                }
            }
        }

        private fun updateWidgetInner(context: Context, mgr: AppWidgetManager, id: Int) {
            val state = WidgetStateStore.read(context)

            // What the icons WILL look like, and what they looked like last time.
            // Only a change in this signature animates; bars and text repaint every
            // update regardless.
            val sig = iconSignature(context, state)
            val prev = lastWidgetIconState[id]
            val changed = prev != null && prev != sig
            lastWidgetIconState[id] = sig

            // FADE ONLY SOMETHING THAT IS APPEARING.
            //
            // The fade steps draw the icons at rising alpha, so the FIRST frame of a
            // fade is the new state drawn at 25% opacity. Running that for a change
            // where the icon was ALREADY on screen — the common case, a bud going from
            // out-of-ear grey to in-ear white, where only the colour differs — makes
            // the icon visibly dim and brighten again. That is the reported blink: the
            // icon never leaves the screen, so there is nothing to fade in, and the
            // 25% frame is a flash rather than a transition.
            //
            // So the fade is gated on something genuinely appearing:
            //   - a bud going hidden -> visible (a real fade-in), or
            //   - the connection pill appearing, i.e. the widget going DISCONNECTED.
            //     The pill cross-fades with the body and only exists when
            //     disconnected, so that transition keeps its animation.
            //
            // For every other change — a colour-only icon swap, or an icon
            // disappearing — the settled frame is pushed directly.
            //
            // A disappearance stays instant for the reason documented on fadeIcons:
            // RemoteViews is stateless, so the removed icon is no longer in the new
            // tree and there is nothing left to draw at falling alpha.
            val pillAppearing = prev != null && prev.startsWith("true|") && sig.startsWith("false|")
            val appearing = prev != null && changed &&
                (sideAppeared(prev, sig) || pillAppearing)

            if (appearing) {
                fadeIcons(context, mgr, id)
                return
            }

            // A colour-only change must not be faded, but it must still cancel an
            // in-flight fade: otherwise the fade's remaining frames (built from the
            // state at each step) would land after this settled push and repaint the
            // icon at a stale alpha.
            cancelFade(id)
            mgr.updateAppWidget(id, buildViews(context, state, 1f))
        }

        /**
         * True when a side of the icon signature went from hidden to visible.
         *
         * The signature is "<connected>|<left>|<right>", where each side is "h" when
         * the bud is hidden (in case) and "v<colour>" when it is drawn. Only "h" ->
         * "v..." is an appearance; "v<grey>" -> "v<white>" is a colour change on an
         * icon that was already visible, and fading that is what caused the blink.
         *
         * Defensive about shape: an unexpected signature falls back to "not appearing",
         * which pushes the settled frame immediately — the safe outcome, since a missed
         * fade is invisible while a spurious one is a visible flash.
         */
        private fun sideAppeared(prev: String, now: String): Boolean {
            val a = prev.split("|")
            val b = now.split("|")
            if (a.size != 3 || b.size != 3) return false
            // Index 0 is `connected`, which is not an icon side.
            for (i in 1..2) {
                val wasHidden = a[i] == "h"
                val isVisible = b[i].startsWith("v")
                if (wasHidden && isVisible) return true
            }
            return false
        }

        /** Cancels any in-flight fade for [id] so its remaining frames cannot land late. */
        private fun cancelFade(id: Int) {
            fadeTokens.remove(id)?.let { handler.removeCallbacks(it) }
        }

        /**
         * Compact signature of the DRAWN icon state, for change detection only.
         * "v<colour>" is a visible icon in that colour; "h" is a hidden one. The bars
         * and the text are excluded because they never animate — including them would
         * make every battery tick start a fade.
         */
        private fun iconSignature(context: Context, state: WidgetStateStore.State): String {
            fun side(status: Int): String {
                val (mode, color) = budStyle(context, status)
                return if (mode == WidgetIcons.MODE_GONE) "h" else "v$color"
            }
            // `connected` is part of the signature because the CONNECTION change is
            // the biggest visual change the widget has now: it swaps the whole body
            // between the battery content and the status pill.
            return "${state.connected}|${side(state.leftStatus)}|${side(state.rightStatus)}"
        }

        /**
         * Builds the complete widget RemoteViews, with every icon drawn at [alpha].
         *
         * Takes an alpha so the fade can render the SAME layout at intermediate
         * opacities; the plain update passes 1f. Kept as one function so a fade frame
         * and a settled frame cannot drift apart — they are the same widget, only the
         * icon alpha differs.
         */
        private fun buildViews(
            context: Context,
            state: WidgetStateStore.State,
            alpha: Float
        ): RemoteViews {
            val views = RemoteViews(context.packageName, R.layout.widget_anc)

            views.setOnClickPendingIntent(R.id.widget_root, noopPI(context))

            views.setProgressBar(R.id.widget_bar_left, 100, state.leftProgress(), false)
            views.setProgressBar(R.id.widget_bar_right, 100, state.rightProgress(), false)
            views.setProgressBar(R.id.widget_bar_case, 100, state.caseProgress(), false)

            views.setTextViewText(R.id.widget_text_left, state.leftText())
            views.setTextViewText(R.id.widget_text_right, state.rightText())
            views.setTextViewText(R.id.widget_text_case, state.caseText())

            // Hide entire battery row when unknown
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

            // Buds: white filled in ear; grey filled out of ear; hidden in case
            applyIcon(context, views, R.id.widget_bud_left,
                R.drawable.ic_bud_left, budStyle(context, state.leftStatus), alpha)
            applyIcon(context, views, R.id.widget_bud_right,
                R.drawable.ic_bud_right, budStyle(context, state.rightStatus), alpha)

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

            // Disconnected, the controls must not be tappable: a tap would send a
            // command that has nowhere to go. RemoteViews cannot disable a view, so
            // the pending intent is REPLACED by the no-op one — same visual, no
            // action. Removing the intent entirely is not an option; the widget host
            // keeps the last one it was given.
            if (!state.connected) {
                val dead = noopPI(context)
                views.setOnClickPendingIntent(R.id.widget_seg_off, dead)
                views.setOnClickPendingIntent(R.id.widget_seg_trans, dead)
                views.setOnClickPendingIntent(R.id.widget_seg_low, dead)
                views.setOnClickPendingIntent(R.id.widget_seg_med, dead)
                views.setOnClickPendingIntent(R.id.widget_seg_high, dead)
                views.setOnClickPendingIntent(R.id.widget_game_row, dead)
            }

            // ==================== CONNECTED / DISCONNECTED ====================
            //
            // Disconnected, the battery rows carry no data and were each gated
            // INVISIBLE, which left a blank card — reported as "the widget won't
            // load". It was loading; it had nothing to show. So the widget now has
            // two explicit states:
            //
            //   connected     -> the battery card, the ANC segments and the game row
            //   disconnected  -> a single dot-and-word pill, same as the app header
            //
            // The CONTENT rows hide rather than merely being emptied, so the pill is
            // centred in the space instead of sitting under three empty bars.
            views.setViewVisibility(
                R.id.widget_battery_card,
                if (state.connected) View.VISIBLE else View.GONE
            )
            views.setViewVisibility(
                R.id.widget_anc_segments,
                if (state.connected) View.VISIBLE else View.GONE
            )
            views.setViewVisibility(
                R.id.widget_game_row,
                if (state.connected) View.VISIBLE else View.GONE
            )

            // The pill: shown when disconnected, hidden when connected.
            //
            // The FADE between the two states comes from the staged-update path below,
            // not from here: this method renders one settled frame. applyAlpha() is the
            // hook the fade steps use to draw the pill at intermediate opacity.
            views.setViewVisibility(
                R.id.widget_conn_row,
                if (state.connected) View.GONE else View.VISIBLE
            )
            views.setImageViewResource(
                R.id.widget_conn_dot,
                if (state.connected) R.drawable.ic_status_dot_filled
                else R.drawable.ic_status_dot_empty
            )
            views.setTextViewText(
                R.id.widget_conn_text,
                if (state.connected) "Connected" else "Disconnected"
            )

            // The pill cross-fades with the content, driven by the same `alpha` the fade
            // steps pass in. Connected, the pill is GONE and alpha is irrelevant;
            // disconnected it is VISIBLE and fades in over the steps.
            if (!state.connected) applyPillAlpha(views, alpha)

            return views
        }

        /**
         * Alpha for the connection pill, 0..1.
         *
         * THE WIDGET CANNOT ANIMATE, so this is not a property: it is a value the
         * fade steps pass in when they rebuild the RemoteViews, and it is applied to
         * whatever is on screen by picking one of a few pre-set opacities. RemoteViews
         * has no setAlpha on a view, and the ONLY per-pixel knob it offers is the
         * bitmap, which is why the icons fade through WidgetIcons.tintedAlpha and the
         * pill fades through text COLOUR instead (an alpha-composited #AARRGGBB),
         * which needs no bitmap at all.
         */
        private fun applyPillAlpha(views: RemoteViews, alpha: Float) {
            val a = (alpha.coerceIn(0f, 1f) * 255).toInt()
            views.setTextColor(R.id.widget_conn_text, (a shl 24) or 0x8A8A8A)
            views.setInt(
                R.id.widget_conn_dot,
                "setImageAlpha",
                a
            )
        }

        /**
         * Builds the widget's REAL RemoteViews and reports whether that succeeds.
         *
         * WHY THIS EXISTS SEPARATELY FROM THE LAYOUT REPORT — the layout report
         * measures the INITIAL layout, so it can never answer "does the widget's
         * actual logic produce valid RemoteViews?". He spotted that gap and he was
         * right: the button was reporting a layout that was already correct while the
         * widget still failed, which made the button misleading.
         *
         * This calls the REAL builder used by the live update path, for the CURRENT
         * state, and reports:
         *   - whether it threw, and where
         *   - how many actions the resulting RemoteViews carries
         *   - whether it can be written to a Parcel, which is the actual test: the
         *     widget is sent to the launcher as a parcel, and anything unserialisable
         *     fails THERE, at Runtime, with the opaque message the user sees.
         *
         * That parcel round-trip is the closest we can get to the launcher's own
         * validation from inside the app, and it is the step that was never tested.
         */
        fun buildWidgetRemoteViews(context: Context): String {
            val sb = StringBuilder()
            sb.appendLine("WIDGET REMOTEVIEWS CHECK")
            sb.appendLine()

            // Failures recorded by the live update path. If this is non-zero, the
            // widget IS being updated and IS throwing — which is the whole question
            // a layout report can never answer.
            sb.appendLine("recorded update failures: $failureCounts")
            sb.appendLine("ids marked bad: $badWidgetIds")
            sb.appendLine()

            val state = WidgetStateStore.read(context)
            sb.appendLine("state: connected=${state.connected}")
            sb.appendLine()

            // 1. Does the real builder run?
            val views = try {
                buildViews(context, state, 1f)
            } catch (t: Throwable) {
                sb.appendLine("!! buildViews() THREW — this is the bug.")
                sb.appendLine()
                sb.appendLine(t.stackTraceToString())
                return sb.toString()
            }
            sb.appendLine("buildViews() OK")

            // 2. Can it be parcelled? This is what the AppWidgetService does.
            try {
                val parcel = android.os.Parcel.obtain()
                try {
                    views.writeToParcel(parcel, 0)
                    val bytes = parcel.dataSize()
                    sb.appendLine("writeToParcel() OK — ${bytes} bytes")
                    if (bytes > 1_000_000) {
                        sb.appendLine("!! but that is very large; the service may reject it")
                    }
                    parcel.setDataPosition(0)
                    val back = RemoteViews.CREATOR.createFromParcel(parcel)
                    sb.appendLine("read back OK — actions=${back?.let { countLayoutActions(it) }}")
                } finally {
                    parcel.recycle()
                }
            } catch (t: Throwable) {
                sb.appendLine("!! writeToParcel()/read THREW — THIS is why the widget")
                sb.appendLine("   fails to load: the launcher cannot receive this.")
                sb.appendLine()
                sb.appendLine(t.stackTraceToString())
            }

            return sb.toString()
        }

        /**
         * Counts the layout actions in a RemoteViews via reflection.
         *
         * RemoteViews exposes no public action count, and the count matters here: a
         * RemoteViews that came back with zero actions would mean the parcel carried
         * nothing, which would ALSO explain a widget that never updates. Reflection is
         * guarded so a future platform change degrades to "?" rather than a crash in
         * a diagnostic.
         */
        private fun countLayoutActions(views: RemoteViews): String {
            return try {
                val f = RemoteViews::class.java.getDeclaredField("mActions")
                f.isAccessible = true
                val list = f.get(views) as? List<*>
                list?.size?.toString() ?: "?"
            } catch (_: Throwable) {
                "?"
            }
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
