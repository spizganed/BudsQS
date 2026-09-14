package com.oplus.melody.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.helper.MelodyAlivePreferencesHelper;
import java.lang.reflect.Type;

/* JADX INFO: renamed from: com.oplus.melody.common.util.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DefaultSharedPreferencesUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0908n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f19506a;

    public static String a() {
        if (f19506a == null) {
            f19506a = C0906l.f19501a.getPackageName() + "_preferences";
        }
        return f19506a;
    }

    public static SharedPreferences b(Context context) {
        Type type = MelodyAlivePreferencesHelper.f19403a;
        return MelodyAlivePreferencesHelper.d(context.getApplicationContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T c(Context context, String str, T t10) {
        SharedPreferences sharedPreferencesB = b(context);
        return t10 instanceof Integer ? (T) Integer.valueOf(sharedPreferencesB.getInt(str, ((Integer) t10).intValue())) : t10 instanceof String ? (T) sharedPreferencesB.getString(str, (String) t10) : t10 instanceof Boolean ? (T) Boolean.valueOf(sharedPreferencesB.getBoolean(str, ((Boolean) t10).booleanValue())) : t10 instanceof Long ? (T) Long.valueOf(sharedPreferencesB.getLong(str, ((Long) t10).longValue())) : t10 instanceof Float ? (T) Float.valueOf(sharedPreferencesB.getFloat(str, ((Float) t10).floatValue())) : t10;
    }

    @Deprecated
    public static int d(String str) {
        String str2;
        String str3 = str.hashCode() + "_" + A.r(str);
        SharedPreferences sharedPreferencesB = b(C0906l.f19501a);
        if (sharedPreferencesB.contains(str3)) {
            return sharedPreferencesB.getBoolean(str3, false) ? 1 : 0;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str.hashCode());
        sb2.append("_");
        if (TextUtils.isEmpty(str)) {
            str2 = "EMPTY";
        } else {
            String[] strArrSplit = str.split(":");
            if (strArrSplit.length == 6) {
                str2 = strArrSplit[0] + ":" + strArrSplit[1] + "******" + strArrSplit[strArrSplit.length - 2] + ":" + strArrSplit[strArrSplit.length - 1];
            } else {
                str2 = "INVALID";
            }
        }
        sb2.append(str2);
        String string = sb2.toString();
        if (sharedPreferencesB.contains(string)) {
            return sharedPreferencesB.getBoolean(string, false) ? 1 : 0;
        }
        return -1;
    }

    public static void e(HeyMelodyApplication heyMelodyApplication, String str, Boolean bool) {
        if (heyMelodyApplication == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = b(heyMelodyApplication).edit();
        editorEdit.putBoolean(str, bool.booleanValue());
        editorEdit.apply();
    }
}
