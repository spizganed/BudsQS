package com.spizganed.quickbuds.ui

import android.content.Context
import com.spizganed.quickbuds.R

/**
 * Gesture configuration — the model behind the Earbud controls screen.
 *
 * WHAT THIS FILE DOES AND DOES NOT KNOW
 *
 * It knows the GESTURES exactly. Each gesture's protocol identity is the action
 * byte the buds put in the 0x0204 subType 0xF1 report, which this project has
 * captured and confirmed (PROTOCOL.md §6, `UserInteractionParser`).
 *
 * It does NOT know the `function` enum — the value that means "play/pause" versus
 * "voice assistant" versus "ANC" in a `setKeyFunction` (0x0402) write. Nobody
 * publishes it, and it is the one remaining blocker (PROTOCOL.md §6). So
 * [GestureAction] deliberately carries a LABEL and no protocol value.
 *
 * WHY THAT IS NOT AN OVERSIGHT: guessing an ANC bit is exactly what produced the
 * SET-vs-NOTIFY regression this project already had to revert, and a dropdown of
 * guessed values would look finished while silently sending the wrong thing. The
 * selections here are therefore stored ON THE PHONE ONLY until the enum is
 * confirmed from the 0x8108 reply (or a HeyMelody capture). The screen says so
 * rather than pretending. When the enum lands, add the byte to [GestureAction]
 * and send it from the screen — nothing else about this model needs to change.
 */
enum class GestureSide(val labelRes: Int) {
    LEFT(R.string.gesture_bud_left),
    RIGHT(R.string.gesture_bud_right)
}

/**
 * A physical gesture on one bud.
 *
 * @param reportBytes the 0x0204 subType 0xF1 `action` byte(s) this gesture raises.
 *                    `[CAPTURE]`+`[OSS]` — from `UserInteractionParser`'s action
 *                    table (0x00 single, 0x02 double, 0x03 triple, 0x04 long press,
 *                    0x07 slide up, 0x08 slide down).
 * @param multiSelect true if more than one action may be bound, so the gesture
 *                    CYCLES through them on each use. Only tap-and-hold, by request.
 */
enum class Gesture(
    val labelRes: Int,
    val reportBytes: IntArray,
    val multiSelect: Boolean
) {
    SINGLE_TAP(R.string.gesture_single, intArrayOf(0x00), false),
    DOUBLE_TAP(R.string.gesture_double, intArrayOf(0x02), false),
    TRIPLE_TAP(R.string.gesture_triple, intArrayOf(0x03), false),

    /**
     * SLIDE IS ONE ROW BUT TWO PROTOCOL ACTIONS.
     *
     * The buds report slide UP (0x07) and slide DOWN (0x08) separately, and a
     * `setKeyFunction` write will need one entry per direction. The UI shows a
     * single "Slide" row because that is how the gesture is described to the user,
     * but the eventual write MUST expand it into both directions — writing only
     * 0x07 would leave slide-down unbound. Flagged here so that is not discovered
     * at write time.
     */
    SLIDE(R.string.gesture_slide, intArrayOf(0x07, 0x08), false),

    TAP_HOLD(R.string.gesture_hold, intArrayOf(0x04), true)
}

/**
 * An assignable action. LABEL ONLY — see the class comment for why there is no
 * protocol byte here yet.
 */
enum class GestureAction(val labelRes: Int) {
    NONE(R.string.gesture_action_none),
    PLAY_PAUSE(R.string.gesture_action_play_pause),
    PREV_TRACK(R.string.gesture_action_prev),
    NEXT_TRACK(R.string.gesture_action_next),
    VOICE_ASSISTANT(R.string.gesture_action_assistant),
    GAME_MODE(R.string.gesture_action_game),
    VOLUME(R.string.gesture_action_volume),
    SWITCH_TRACK(R.string.gesture_action_switch_track),
    ANC_ON(R.string.gesture_action_anc_on),
    ANC_ADAPTIVE(R.string.gesture_action_anc_adaptive),
    ANC_TRANSPARENCY(R.string.gesture_action_anc_transparency),
    ANC_OFF(R.string.gesture_action_anc_off)
}

/**
 * Which actions each gesture may be bound to, exactly as specified.
 *
 * Kept as a function rather than a field on the enum so the vocabulary and the
 * permitted pairings stay separate: adding an action does not mean adding it to
 * every gesture, and the allowed set is the part a user can see.
 */
fun actionsFor(gesture: Gesture): List<GestureAction> = when (gesture) {
    Gesture.SINGLE_TAP -> listOf(GestureAction.NONE, GestureAction.PLAY_PAUSE)

    Gesture.DOUBLE_TAP -> listOf(
        GestureAction.NONE, GestureAction.PLAY_PAUSE, GestureAction.PREV_TRACK,
        GestureAction.NEXT_TRACK, GestureAction.VOICE_ASSISTANT, GestureAction.GAME_MODE
    )

    Gesture.TRIPLE_TAP -> listOf(
        GestureAction.NONE, GestureAction.PREV_TRACK, GestureAction.NEXT_TRACK,
        GestureAction.VOICE_ASSISTANT, GestureAction.GAME_MODE
    )

    Gesture.SLIDE -> listOf(
        GestureAction.NONE, GestureAction.VOLUME, GestureAction.SWITCH_TRACK
    )

    // Tap-and-hold cycles through ANC modes. There is deliberately no NONE here:
    // a hold that does nothing is not a mode cycle, and an empty binding is
    // represented by an empty list instead (see the store's default).
    Gesture.TAP_HOLD -> listOf(
        GestureAction.ANC_ON, GestureAction.ANC_ADAPTIVE,
        GestureAction.ANC_TRANSPARENCY, GestureAction.ANC_OFF
    )
}

/**
 * Persists the per-bud, per-gesture selection ON THE PHONE.
 *
 * Local-only on purpose — these are NOT sent to the buds while the `function`
 * enum is unknown. Stored per SIDE because the whole point of the Left/Right
 * selector is that the two buds can be bound differently.
 *
 * Uses the shared prefs file every other screen uses, so there is one place to
 * look and no second preferences file to discover later.
 */
object GestureConfigStore {

    private fun prefs(context: Context) =
        context.getSharedPreferences(ThemeRes.PREFS_NAME, Context.MODE_PRIVATE)

    private fun key(side: GestureSide, gesture: Gesture) =
        "gesture_${side.name}_${gesture.name}"

    /** What a gesture does when the user has never opened this screen. */
    fun defaultFor(gesture: Gesture): List<GestureAction> = when (gesture) {
        // A hold with nothing bound would make the cycle unreachable, so it starts
        // on ANC. Every other gesture starts unbound, matching the firmware's own
        // "no action" default.
        Gesture.TAP_HOLD -> listOf(GestureAction.ANC_ON)
        else -> listOf(GestureAction.NONE)
    }

    fun load(context: Context, side: GestureSide, gesture: Gesture): List<GestureAction> {
        val raw = prefs(context).getString(key(side, gesture), null)
            ?: return defaultFor(gesture)
        if (raw.isEmpty()) return emptyList()
        // Unknown names are dropped rather than crashing, so a value written by a
        // future version of this enum cannot brick the screen.
        return raw.split(",").mapNotNull { name ->
            GestureAction.values().firstOrNull { it.name == name }
        }
    }

    fun save(
        context: Context,
        side: GestureSide,
        gesture: Gesture,
        actions: List<GestureAction>
    ) {
        prefs(context).edit()
            .putString(key(side, gesture), actions.joinToString(",") { it.name })
            .apply()
    }

    /** Human-readable summary of a binding, for the row's right-hand value. */
    fun describe(context: Context, actions: List<GestureAction>): String = when {
        actions.isEmpty() -> context.getString(R.string.gesture_not_set)
        else -> actions.joinToString(", ") { context.getString(it.labelRes) }
    }
}
