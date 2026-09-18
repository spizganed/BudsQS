package com.spizganed.quickbuds.ui

import android.app.Activity
import android.content.Context
import android.util.TypedValue
import com.spizganed.quickbuds.R

/**
 * App theming: which theme is selected, and the palette.
 *
 * WHY THIS CLASS EXISTS
 * The old MainActivity.applyTheme walked the view tree after inflation and pushed
 * colours onto each TextView/Button. That worked while the screen had a header and
 * a panel, but it cannot express the redesigned UI: a settings row is a card, an
 * ANC circle is a segment, a chevron is secondary text — a tree walk flattens all
 * of them to one colour. So colours moved into resources and the theme is now
 * chosen by a STYLE, with Kotlin only retinting vector icons.
 *
 * HOW A THEME IS APPLIED — the third design, and why the first two failed
 *
 * Attempt 1: applyOverrideConfiguration() with a uiMode override, so the
 *   values-night / values-notnight palette folders would resolve.
 *   FAILED: throws "getResources() or getAssets() has already been called" on
 *   this device, because something in the Activity ATTACH path touches resources
 *   before onCreate. Five reorderings inside onCreate all failed identically.
 *   Do NOT reintroduce it.
 *
 * Attempt 2: three real styles (Theme.App.OLED / .Dark / .Light) selected with
 *   setTheme(). This stopped the crash, but the themes did not visibly change:
 *   setTheme() picks a STYLE, and a style cannot change which @color/app_*
 *   resource resolves. Those still came from values-night (-notnight), which
 *   follow the SYSTEM dark-mode setting, not the in-app choice. So choosing
 *   "Light" in the app still rendered the OLED palette.
 *
 * Attempt 3 (this one): make the distinction an ATTRIBUTE. Theme.App.Base sets
 *   appPalette, and each of the three themes points appPalette at a different
 *   colour set defined in values/themes.xml. Colours are then read through
 *   ThemeRes.color(), which resolves the attribute against the CURRENT theme.
 *   That is a normal resource lookup at inflate/query time, so it follows the
 *   in-app choice and cannot throw.
 *
 * Anything that needs a themed colour should call ThemeRes.color(context, R.attr.x)
 * rather than getColor(R.color.x) directly, when the value differs per theme.
 */
object ThemeRes {

    const val OLED = 0
    const val DARK = 1
    const val LIGHT = 2

    // Renamed from "BudsQSPrefs" with the project's move to the QuickBuds name. The
    // file name IS the string, so this is a genuine one-time settings reset: the theme
    // preference and the stored gesture selections start from their defaults again,
    // and the crash dialog may announce one older report once. Cheap here (the 1.0.0
    // release had no downloads), and worth doing while it is still cheap — after this
    // release the name is permanent.
    private const val PREFS = "QuickBudsPrefs"
    private const val KEY = "theme"

    /** Exposed so other screens reuse this prefs file rather than duplicating the name. */
    const val PREFS_NAME = PREFS

    /** Timestamp of the last crash report already shown, so it is announced once. */
    const val KEY_LAST_SHOWN_CRASH = "lastShownCrash"

    /** Persisted theme index. OLED is the default, as specified. */
    fun saved(context: Context): Int =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getInt(KEY, OLED)

    fun save(context: Context, theme: Int) {
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit().putInt(KEY, theme).apply()
    }

    /**
     * Selects and applies the theme for one activity.
     *
     * Call as the FIRST statement of onCreate, BEFORE super.onCreate().
     *
     * setTheme() is safe before super.onCreate because it only records a style id
     * and resolves it lazily. That is the whole reason this approach replaced
     * applyOverrideConfiguration().
     */
    fun select(activity: Activity) {
        activity.setTheme(styleFor(saved(activity)))
    }

    private fun styleFor(theme: Int): Int = when (theme) {
        OLED -> R.style.Theme_App_OLED
        DARK -> R.style.Theme_App_Dark
        else -> R.style.Theme_App_Light
    }

    /**
     * Reads a themed colour.
     *
     * Accepts either a colour resource id or an attribute id — `resolveAttribute`
     * is tried first and the plain lookup is the fallback, so call sites can pass
     * @color/app_* for values that are the same in every theme and
     * R.attr.appColor* for values that differ. That keeps this method useful for
     * both without two functions.
     */
    fun color(context: Context, resId: Int): Int = try {
        val tv = TypedValue()
        if (context.theme.resolveAttribute(resId, tv, true)) {
            if (tv.resourceId != 0) context.getColor(tv.resourceId) else tv.data
        } else {
            context.getColor(resId)
        }
    } catch (_: Exception) {
        // Never let a missing colour take down a screen: fall back to mid grey,
        // which is legible against both the dark and light palettes.
        0xFF808080.toInt()
    }

    /**
     * Tints a vector drawable for the current theme.
     *
     * Every glyph here is drawn with fillColor="#FFFFFF" because it is used
     * white-on-dark in the widget. On the light theme that would be invisible, so
     * icons are tinted explicitly instead of relying on their baked-in colour.
     */
    fun tint(context: Context, drawableRes: Int, color: Int): android.graphics.drawable.Drawable {
        val d = context.getDrawable(drawableRes)!!.mutate()
        d.setTint(color)
        return d
    }

    /** dp -> px, for the programmatically built rows. */
    fun dp(context: Context, value: Float): Int = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, value, context.resources.displayMetrics
    ).toInt()

    /** Labels for the theme picker. */
    fun label(theme: Int): String = when (theme) {
        OLED -> "OLED Black"
        DARK -> "Dark"
        else -> "Light"
    }
}
