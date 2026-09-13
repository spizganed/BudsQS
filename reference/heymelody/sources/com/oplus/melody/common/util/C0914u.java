package com.oplus.melody.common.util;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.oplus.melody.common.util.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: IntentUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0914u {
    public static void a(int i10, Intent intent) {
        if (i10 == 0 || Build.VERSION.SDK_INT < 29 || S.j() < 19) {
            return;
        }
        try {
            A4.a.b(A4.a.a(intent) | i10, intent);
        } catch (UnSupportedApiVersionException e10) {
            A.i("IntentUtils", "addOplusFlags 0x" + Integer.toHexString(i10), e10);
        }
    }

    public static boolean b(Intent intent, String str, boolean z2) {
        if (intent != null) {
            try {
                return intent.getBooleanExtra(str, z2);
            } catch (Exception e10) {
                A.o(5, "IntentUtils", "getBooleanExtra", e10);
            }
        }
        return z2;
    }

    public static int c(Intent intent, String str, int i10) {
        if (intent != null) {
            try {
                return intent.getIntExtra(str, i10);
            } catch (Exception e10) {
                A.o(5, "IntentUtils", "getIntExtra", e10);
            }
        }
        return i10;
    }

    public static <T extends Parcelable> ArrayList<T> d(Intent intent, String str, Class<T> cls) {
        if (intent != null) {
            return e(intent.getExtras(), str, cls);
        }
        return null;
    }

    public static <T extends Parcelable> ArrayList<T> e(Bundle bundle, String str, Class<T> cls) {
        if (bundle == null) {
            return null;
        }
        try {
            bundle.setClassLoader(cls.getClassLoader());
            return Build.VERSION.SDK_INT >= 33 ? bundle.getParcelableArrayList(str, cls) : bundle.getParcelableArrayList(str);
        } catch (Exception e10) {
            A.o(5, "IntentUtils", "getParcelableArrayListExtra", e10);
            return null;
        }
    }

    public static <T extends Parcelable> T f(Intent intent, String str, Class<T> cls) {
        if (intent != null) {
            return (T) g(intent.getExtras(), str, cls);
        }
        return null;
    }

    public static <T extends Parcelable> T g(Bundle bundle, String str, Class<T> cls) {
        if (bundle == null) {
            return null;
        }
        try {
            bundle.setClassLoader(cls.getClassLoader());
            return Build.VERSION.SDK_INT >= 33 ? (T) bundle.getParcelable(str, cls) : (T) bundle.getParcelable(str);
        } catch (Exception e10) {
            A.o(5, "IntentUtils", "getParcelableExtra", e10);
            return null;
        }
    }

    public static String h(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.getStringExtra(str);
        } catch (Exception e10) {
            A.o(5, "IntentUtils", "getStringExtra", e10);
            return null;
        }
    }
}
