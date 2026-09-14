package com.spizganed.quickbuds.widget

import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import java.util.concurrent.CopyOnWriteArrayList

object WidgetStateStore {

    private const val PREFS = "BudsWidgetState"
    private const val KEY_ANC = "ancMode"
    private const val KEY_GAME = "gameMode"
    private const val KEY_LEFT = "leftBattery"
    private const val KEY_CASE = "caseBattery"
    private const val KEY_RIGHT = "rightBattery"
    private const val KEY_LEFT_IN_BOX = "leftInBox"
    private const val KEY_RIGHT_IN_BOX = "rightInBox"

    private val mainHandler = Handler(Looper.getMainLooper())
    private val listeners = CopyOnWriteArrayList<(State) -> Unit>()

    data class State(
        var ancMode: String = "Off",
        var gameMode: Boolean = false,
        var leftBattery: Int = -1,
        var caseBattery: Int = -1,
        var rightBattery: Int = -1,
        var leftInBox: Boolean = false,
        var rightInBox: Boolean = false
    ) {
        fun leftProgress(): Int = if (leftBattery in 0..100) leftBattery else 0
        fun rightProgress(): Int = if (rightBattery in 0..100) rightBattery else 0
        fun caseProgress(): Int = if (caseBattery in 0..100) caseBattery else 0

        fun hasLeft(): Boolean = leftBattery in 0..100
        fun hasRight(): Boolean = rightBattery in 0..100
        fun hasCase(): Boolean = caseBattery in 0..100

        fun leftText(): String = if (leftBattery in 0..100) leftBattery.toString() else ""
        fun rightText(): String = if (rightBattery in 0..100) rightBattery.toString() else ""
        fun caseText(): String = if (caseBattery in 0..100) caseBattery.toString() else ""

        fun offIsActive(): Boolean = ancMode == "Off" || ancMode.isEmpty()
        fun transIsActive(): Boolean = ancMode == "Transparency"
        fun lowIsActive(): Boolean = ancMode == "ANC-Light"
        fun medIsActive(): Boolean = ancMode == "ANC-Medium"
        fun highIsActive(): Boolean = ancMode == "ANC-Deep"
    }

    fun addListener(l: (State) -> Unit) { listeners.add(l) }
    fun removeListener(l: (State) -> Unit) { listeners.remove(l) }

    private fun notifyListeners(state: State) {
        mainHandler.post {
            for (l in listeners) {
                try { l(state) } catch (_: Exception) {}
            }
        }
    }

    private fun prefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

    fun read(context: Context): State {
        val p = prefs(context)
        val s = State()
        s.ancMode = p.getString(KEY_ANC, "Off") ?: "Off"
        s.gameMode = p.getBoolean(KEY_GAME, false)
        s.leftBattery = p.getInt(KEY_LEFT, -1)
        s.caseBattery = p.getInt(KEY_CASE, -1)
        s.rightBattery = p.getInt(KEY_RIGHT, -1)
        s.leftInBox = p.getBoolean(KEY_LEFT_IN_BOX, false)
        s.rightInBox = p.getBoolean(KEY_RIGHT_IN_BOX, false)
        return s
    }

    fun write(context: Context, state: State) {
        prefs(context).edit()
            .putString(KEY_ANC, state.ancMode)
            .putBoolean(KEY_GAME, state.gameMode)
            .putInt(KEY_LEFT, state.leftBattery)
            .putInt(KEY_CASE, state.caseBattery)
            .putInt(KEY_RIGHT, state.rightBattery)
            .putBoolean(KEY_LEFT_IN_BOX, state.leftInBox)
            .putBoolean(KEY_RIGHT_IN_BOX, state.rightInBox)
            .apply()
        notifyListeners(state)
    }
}