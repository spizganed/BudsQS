package com.spizganed.quickbuds.widget

import android.content.Context
import android.content.SharedPreferences

/**
 * SharedPreferences-backed state shared between:
 *   - MainActivity (writes on button tap / status update)
 *   - Widget providers (read to render)
 *   - Service (writes on incoming packets)
 */
object WidgetStateStore {

    private const val PREFS = "BudsWidgetState"
    private const val KEY_ANC = "ancMode"
    private const val KEY_GAME = "gameMode"
    private const val KEY_LEFT = "leftBattery"
    private const val KEY_CASE = "caseBattery"
    private const val KEY_RIGHT = "rightBattery"

    data class State(
        var ancMode: String = "Off",
        var gameMode: Boolean = false,
        var leftBattery: Int = -1,
        var caseBattery: Int = -1,
        var rightBattery: Int = -1
    ) {
        fun batteryText(): String {
            val l = if (leftBattery >= 0) "$leftBattery" else "--"
            val r = if (rightBattery >= 0) "$rightBattery" else "--"
            return if (caseBattery >= 0) {
                "L$l C$caseBattery R$r"
            } else {
                "L$l R$r"
            }
        }

        fun ancButtonLabel(): String = when (ancMode) {
            "ANC-Deep" -> "D"
            "ANC-Medium" -> "M"
            "ANC-Light" -> "L"
            "ANC-Smart" -> "S"
            else -> "ANC"
        }
    }

    private fun prefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

    fun read(context: Context): State {
        val p = prefs(context)
        return State(
            ancMode = p.getString(KEY_ANC, "Off") ?: "Off",
            gameMode = p.getBoolean(KEY_GAME, false),
            leftBattery = p.getInt(KEY_LEFT, -1),
            caseBattery = p.getInt(KEY_CASE, -1),
            rightBattery = p.getInt(KEY_RIGHT, -1)
        )
    }

    fun write(context: Context, state: State) {
        prefs(context).edit()
            .putString(KEY_ANC, state.ancMode)
            .putBoolean(KEY_GAME, state.gameMode)
            .putInt(KEY_LEFT, state.leftBattery)
            .putInt(KEY_CASE, state.caseBattery)
            .putInt(KEY_RIGHT, state.rightBattery)
            .apply()
    }
}