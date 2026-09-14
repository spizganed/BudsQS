package com.oplus.melody.common.util;

import android.os.Build;
import com.heytap.headset.HeyMelodyApplication;

/* JADX INFO: compiled from: PermissionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class Q {
    public static boolean a() {
        if (Build.VERSION.SDK_INT >= 31) {
            return c("android.permission.BLUETOOTH_SCAN") && c("android.permission.BLUETOOTH_CONNECT");
        }
        return true;
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT >= 33) {
            return c("android.permission.POST_NOTIFICATIONS");
        }
        return true;
    }

    public static boolean c(String str) {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        return heyMelodyApplication.getPackageManager().checkPermission(str, heyMelodyApplication.getPackageName()) == 0;
    }
}
