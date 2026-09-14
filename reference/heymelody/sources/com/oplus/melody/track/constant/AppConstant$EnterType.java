package com.oplus.melody.track.constant;

import kotlin.Metadata;

/* JADX INFO: compiled from: AppConstant.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/oplus/melody/track/constant/AppConstant$EnterType;", "", "enter", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEnter", "()Ljava/lang/String;", "LAUNCHER_ENTER", "DISCOVERY_ENTER", "WIRELESS_ENTER", "DEVICES_ENTER", "HEYMELODY_ENTER", "track_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum AppConstant$EnterType {
    /* JADX INFO: Fake field, exist only in values array */
    LAUNCHER_ENTER("android.intent.action.MAIN"),
    DISCOVERY_ENTER("DiscoveryDialogActivity"),
    WIRELESS_ENTER("android-app://com.oplus.wirelesssettings"),
    DEVICES_ENTER("android-app://com.heytap.mydevices"),
    HEYMELODY_ENTER("android-app://com.heytap.headset");

    private final String enter;

    AppConstant$EnterType(String str) {
        this.enter = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getEnter() {
        return this.enter;
    }
}
