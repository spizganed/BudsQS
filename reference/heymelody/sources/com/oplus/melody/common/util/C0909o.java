package com.oplus.melody.common.util;

import D7.i0;
import D7.j0;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.provider.Settings;
import android.view.Window;
import b9.C0738g;
import com.heytap.headset.R;
import com.oplus.compat.view.WindowManagerNative;
import java.util.Optional;

/* JADX INFO: renamed from: com.oplus.melody.common.util.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DisplayUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0909o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f19507a;

    public static int a(int i10) {
        if (i10 == 1080) {
            return 480;
        }
        if (i10 == 1256 || i10 == 1272) {
            return 560;
        }
        if (i10 == 1440) {
            return 640;
        }
        return i10 == 720 ? 320 : -1;
    }

    public static int b() {
        int iC;
        int i10;
        try {
            iC = B4.a.c("persist.sys.display.density", -1);
            A.c("DisplayUtils", new com.oplus.melody.btsdk.protocol.commands.q(iC, 2));
            i10 = 480;
        } catch (Exception e10) {
            A.i("DisplayUtils", "getDensityFromSwitch", e10);
        }
        if (iC != 420 && iC != 480) {
            i10 = 640;
            if (iC != 560 && iC != 640) {
                return -1;
            }
        }
        return i10;
    }

    public static int c() {
        try {
            return S.s(C0906l.f19501a) ? ((Integer) Optional.ofNullable(j0.g("android.view.WindowManagerGlobal").d("getWindowManagerService", new i0[0])).map(new com.oplus.melody.model.repository.zenmode.f(6)).map(new C0738g(5)).orElse(-1)).intValue() : WindowManagerNative.getInitialDisplayDensity(0);
        } catch (Exception e10) {
            A.i("DisplayUtils", "getInitialDisplayDensity", e10);
            return -1;
        }
    }

    public static int d(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        A.x("DisplayUtils", "getScreenHeight context is null, return default value;");
        return 0;
    }

    public static int e(ContextWrapper contextWrapper) {
        if (contextWrapper != null) {
            return contextWrapper.getResources().getDisplayMetrics().widthPixels;
        }
        A.x("DisplayUtils", "getScreenWidth context is null, return default value;");
        return 0;
    }

    public static int f(Context context, int i10) {
        return (int) (i10 / context.getResources().getDisplayMetrics().density);
    }

    public static void g(Activity activity, int i10) {
        Window window;
        if (S.s(C0906l.f19501a) || activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        window.setNavigationBarColor(i10);
    }

    public static void h(Activity activity, int i10) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i10);
    }

    public static void i(F8.a aVar, boolean z2, boolean z4) {
        Window window = aVar.getWindow();
        if (window == null) {
            return;
        }
        window.setStatusBarColor(0);
        if (j()) {
            window.setNavigationBarColor(0);
        }
        window.addFlags(Integer.MIN_VALUE);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        int i10 = systemUiVisibility & (-9473);
        int i11 = j() ? i10 | 1536 : (i10 | 1024) & (-513);
        int i12 = (!(z2 && aVar.getResources().getBoolean(R.bool.melody_common_is_status_white)) ? z4 : !z4) ? i11 | 256 : i11 | 8192;
        if (i12 != systemUiVisibility) {
            window.getDecorView().setSystemUiVisibility(i12);
        }
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT >= 33 && !S.s(C0906l.f19501a) && Settings.Secure.getInt(C0906l.f19501a.getContentResolver(), "navigation_mode", 0) == 2;
    }
}
