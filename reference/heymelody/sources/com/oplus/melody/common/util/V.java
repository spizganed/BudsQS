package com.oplus.melody.common.util;

import Qa.a;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.net.Uri;
import com.heytap.headset.HeyMelodyApplication;
import x3.C1656o;

/* JADX INFO: compiled from: SettingsUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f19476a;

    public static String a(String str) {
        return C1656o.a("oplus_lea_dual_connection_preference_", C0911q.j(str));
    }

    public static final boolean b(String str) {
        if (str == null) {
            return false;
        }
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            kotlin.jvm.internal.h.i("context");
            throw null;
        }
        boolean z2 = a.b.a(heyMelodyApplication.getContentResolver(), a(str), 0) == 1;
        A.f("SettingsUtils", "isBrLeCoexistOpen, addr: " + str + ", open: " + z2 + ", key: " + a(str));
        return z2;
    }

    public static final void c(String str, boolean z2) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            A.h("SettingsUtils", "setBrLeCoexistStatus, addr invalid");
            return;
        }
        try {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                kotlin.jvm.internal.h.i("context");
                throw null;
            }
            ContentResolver contentResolver = heyMelodyApplication.getContentResolver();
            String strA = a(str);
            Uri uri = a.b.f4214a;
            a.b.c(contentResolver, strA, Integer.toString(z2 ? 1 : 0));
            A.f("SettingsUtils", "setBrLeCoexistStatus ok, addr: " + str + ", open: " + z2 + ", key: " + a(str));
        } catch (Exception e10) {
            A.i("SettingsUtils", "setBrLeCoexistStatus, error: ", e10);
        }
    }
}
