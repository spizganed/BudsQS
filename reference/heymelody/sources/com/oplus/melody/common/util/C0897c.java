package com.oplus.melody.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.drs.statistics.DataTypeConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: renamed from: com.oplus.melody.common.util.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0897c {
    public static Activity a(Context context) {
        while (context instanceof ContextWrapper) {
            if (Activity.class.isInstance(context)) {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static boolean b(Context context) {
        Activity activityA = a(context);
        if (activityA != null) {
            String string = activityA.getResources().getConfiguration().toString();
            kotlin.jvm.internal.h.d(string, "toString(...)");
            if (ec.m.I(string, "oplus-magic-windows", false)) {
                return true;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                String string2 = activityA.getResources().getConfiguration().toString();
                kotlin.jvm.internal.h.d(string2, "toString(...)");
                if (ec.m.I(string2, "multi-window", false)) {
                    return true;
                }
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                if (heyMelodyApplication == null) {
                    kotlin.jvm.internal.h.i("context");
                    throw null;
                }
                String string3 = heyMelodyApplication.getResources().getConfiguration().toString();
                kotlin.jvm.internal.h.d(string3, "toString(...)");
                if (ec.m.I(string3, "multi-window", false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        if (context == null) {
            A.h("ActivityUtils", "isInSquareWindow context is null, return false;");
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            A.h("ActivityUtils", "isInSquareWindow dm is null, return false;");
            return false;
        }
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        A.c("ActivityUtils", new R7.b(i10, i11, 5));
        if (i10 == 0) {
            A.h("ActivityUtils", "isInSquareWindow displayWidth is 0!");
            return false;
        }
        float f9 = i11 / i10;
        return f9 < 1.2f && f9 > ((float) 1) / 1.2f;
    }

    public static void d(Activity activity, ArrayList arrayList, boolean z2) {
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        List<String> list = S.f19463a;
        if ("com.oplus.melody".equals(activity.getPackageName()) && !z2) {
            Bundle bundleD = S.d(activity, "com.oplus.securitypermission");
            if (bundleD != null) {
                ref$BooleanRef.element = bundleD.getBoolean("navigateToAppPermissions", false);
            }
            A.c("ActivityUtils", new C0896b(ref$BooleanRef, 0));
            if (ref$BooleanRef.element) {
                Intent intent = new Intent("oplus.intent.action.PERMISSION_APP_DETAIL");
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("permissionList", arrayList);
                bundle.putString("packageName", activity.getPackageName());
                intent.putExtras(bundle);
                ref$BooleanRef.element = C0905k.k(activity, intent, DataTypeConstants.APP_LOG);
            }
        }
        if (ref$BooleanRef.element) {
            return;
        }
        Intent intent2 = new Intent();
        intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent2.setData(Uri.fromParts("package", activity.getPackageName(), null));
        C0905k.k(activity, intent2, DataTypeConstants.APP_LOG);
    }
}
