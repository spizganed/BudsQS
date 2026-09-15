package com.spizganed.quickbuds.bluetooth

/** Action strings broadcast between the widget receiver, provider, and service. */
object WidgetActions {
    const val ACTION_NOOP       = "com.spizganed.quickbuds.action.NOOP"
    const val ACTION_ANC_SELECT = "com.spizganed.quickbuds.action.ANC_SELECT"
    const val ACTION_ANC_CYCLE  = "com.spizganed.quickbuds.action.ANC_CYCLE"
    const val ACTION_TRANS      = "com.spizganed.quickbuds.action.TRANS"
    const val ACTION_OFF        = "com.spizganed.quickbuds.action.OFF"
    const val ACTION_GAME_TOGGLE = "com.spizganed.quickbuds.action.GAME_TOGGLE"

    const val EXTRA_ANC_TARGET = "anc_target"
}
