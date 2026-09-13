package com.oplus.melody.common.util;

import D7.o0;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.app.OplusActivityManager;
import android.app.OplusStatusBarManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Insets;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.drs.core.provider.DcsCompatEventConverter;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import com.oplus.os.OplusBuild;
import j$.util.DesugarTimeZone;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PhoneUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class S {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Object f19465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f19466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f19467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Integer f19468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f19469g;
    public static Integer h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f19470i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Integer f19471j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f19463a = Arrays.asList("OnePlus Buds", "OnePlus Buds Z", "OnePlus Buds Pro");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f19464b = Arrays.asList("com.market.heydemo", "com.oplus.heydemo", "com.oppo.marketdemo", "com.opposs.marketdemo");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f19472k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Object f19473l = null;

    public static boolean A() {
        WindowManager windowManager;
        if (j() > 0) {
            try {
                if (f19465c == null) {
                    f19465c = new OplusStatusBarManager();
                }
                Object obj = f19465c;
                if (obj instanceof OplusStatusBarManager) {
                    boolean topIsFullscreen = ((OplusStatusBarManager) obj).getTopIsFullscreen();
                    if (A.l()) {
                        A.b("PhoneUtils", "topIsFullscreen " + topIsFullscreen + " from oplus");
                    }
                    if (!topIsFullscreen || !r()) {
                        return topIsFullscreen;
                    }
                    A.x("PhoneUtils", "topIsFullscreen = true, exclude pkg, return false.");
                    return false;
                }
            } catch (Exception e10) {
                e = e10;
                A.i("PhoneUtils", "topIsIsFullscreen", e);
            } catch (NoClassDefFoundError e11) {
                e = e11;
                A.i("PhoneUtils", "topIsIsFullscreen", e);
            }
        }
        if (Build.VERSION.SDK_INT < 30 || (windowManager = (WindowManager) C0906l.f19501a.getSystemService("window")) == null) {
            boolean z2 = C0906l.f19501a.getResources().getConfiguration().orientation != 1;
            if (A.l()) {
                A.b("PhoneUtils", "topIsFullscreen " + z2 + " from orientation");
            }
            return z2;
        }
        Insets insets = windowManager.getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.statusBars());
        boolean z4 = insets.bottom + insets.top == 0;
        if (A.l()) {
            A.b("PhoneUtils", "topIsFullscreen " + z4 + " from statusBars");
        }
        if (!z4 || !r()) {
            return z4;
        }
        A.x("PhoneUtils", "topIsFullscreen = true, exclude pkg, return false.");
        return false;
    }

    public static void a(ContextWrapper contextWrapper) {
        int i10;
        if (P1.a.h(contextWrapper)) {
            return;
        }
        if (contextWrapper instanceof Activity) {
            Activity activity = (Activity) contextWrapper;
            try {
                i10 = activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).theme;
            } catch (Exception e10) {
                A.i("PhoneUtils", "applyBrandStyle", e10);
                i10 = -1;
            }
        } else if (contextWrapper instanceof Application) {
            try {
                i10 = contextWrapper.getPackageManager().getApplicationInfo(contextWrapper.getPackageName(), 0).theme;
            } catch (Exception e11) {
                A.i("PhoneUtils", "applyBrandStyle", e11);
                i10 = -1;
            }
        } else {
            i10 = -1;
        }
        if (i10 == -1) {
            A.h("PhoneUtils", "applyBrandStyle ERROR ".concat(contextWrapper.getClass().getSimpleName()));
            return;
        }
        if ("com.heytap.headset".equals(contextWrapper.getPackageName())) {
            A.b("PhoneUtils", "applyBrandStyle hey");
            contextWrapper.setTheme(R.style.MelodyCommonAppThemeHeyBlue);
        } else {
            String str = Build.BRAND;
            if ("OnePlus".equalsIgnoreCase(str)) {
                A.b("PhoneUtils", "applyBrandStyle OPS");
                if ("com.oplus.melody".equals(contextWrapper.getPackageName())) {
                    contextWrapper.setTheme(R.style.MelodyCommonAppThemeBlue);
                } else {
                    contextWrapper.setTheme(R.style.MelodyCommonAppThemeRed);
                }
            } else if ("realme".equalsIgnoreCase(str)) {
                A.b("PhoneUtils", "applyBrandStyle rlm");
                contextWrapper.setTheme(R.style.MelodyCommonAppThemeBlue);
            } else {
                A.b("PhoneUtils", "applyBrandStyle OPO");
                if (j() < 26) {
                    contextWrapper.setTheme(R.style.MelodyCommonAppThemeGreen);
                } else {
                    contextWrapper.setTheme(R.style.MelodyCommonAppThemeBlue);
                }
            }
        }
        if (i10 != 0) {
            contextWrapper.setTheme(i10);
        }
    }

    public static void b(androidx.fragment.app.f fVar) {
        if (fVar == null || fVar.getWindow() == null) {
            return;
        }
        o0.d(new com.airbnb.lottie.B(fVar, 9));
    }

    public static int c(String str, String str2) {
        int i10;
        int i11;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
            for (int i12 = 0; i12 < iMax; i12++) {
                if (i12 >= strArrSplit.length) {
                    i10 = 0;
                } else {
                    try {
                        i10 = Integer.parseInt(strArrSplit[i12]);
                    } catch (NumberFormatException unused) {
                        i10 = 0;
                    }
                }
                if (i12 >= strArrSplit2.length) {
                    i11 = 0;
                } else {
                    try {
                        i11 = Integer.parseInt(strArrSplit2[i12]);
                    } catch (NumberFormatException unused2) {
                        i11 = 0;
                    }
                }
                if (i10 > i11) {
                    return -1;
                }
                if (i10 < i11) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static Bundle d(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE);
            if (packageInfo != null) {
                return packageInfo.applicationInfo.metaData;
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            A.f("PhoneUtils", "getAppMetaData: NOT_FOUND " + str);
            return null;
        } catch (Exception e10) {
            A.i("PhoneUtils", "getAppMetaData", e10);
            return null;
        }
    }

    public static String e(Context context) {
        int iF = f(context);
        return iF == 0 ? context.getPackageName() : context.getString(iF);
    }

    public static int f(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.applicationInfo.labelRes;
            }
        } catch (PackageManager.NameNotFoundException e10) {
            A.i("PhoneUtils", "getAppNameId", e10);
        }
        return 0;
    }

    public static ComponentName g() {
        ComponentName topActivityComponentName = null;
        if (j() > 0) {
            try {
                if (f19473l == null) {
                    f19473l = new OplusActivityManager();
                }
                Object obj = f19473l;
                if (obj != null && (obj instanceof OplusActivityManager)) {
                    topActivityComponentName = ((OplusActivityManager) obj).getTopActivityComponentName();
                }
            } catch (Throwable th) {
                A.i("PhoneUtils", "getCurrentTopActivityComponentName", th);
            }
        }
        if (A.l()) {
            A.f("PhoneUtils", "getCurrentTopActivityComponentName = " + topActivityComponentName);
        }
        return topActivityComponentName;
    }

    public static int h(String str, List<WhitelistConfigDTO> list) {
        if (TextUtils.isEmpty(str)) {
            A.x("PhoneUtils", "getLocalCompatibleType name is empty");
            return -1;
        }
        if (list == null || list.isEmpty()) {
            A.x("PhoneUtils", "getLocalCompatibleType whitelist is empty");
            return -1;
        }
        String str2 = Build.BRAND;
        if (!"OPPO".equalsIgnoreCase(str2) && !"OnePlus".equalsIgnoreCase(str2) && !"realme".equalsIgnoreCase(str2)) {
            A.c("PhoneUtils", new com.oplus.melody.btsdk.protocol.commands.p(2));
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            if (!v(C0906l.f19501a, "com.oplus.melody")) {
                A.b("PhoneUtils", "getLocalCompatibleType: melody not found");
                return -1;
            }
            int iN = n(C0906l.f19501a, "com.oplus.melody");
            A.c("PhoneUtils", new com.oplus.melody.btsdk.protocol.commands.k(iN, 9));
            for (WhitelistConfigDTO whitelistConfigDTO : list) {
                if (Y.n(str, whitelistConfigDTO)) {
                    if (whitelistConfigDTO.getMinVersion() == 0) {
                        break;
                    }
                    if (iN >= whitelistConfigDTO.getMinVersion()) {
                        return 2;
                    }
                }
            }
        } else if (v(C0906l.f19501a, "com.coloros.oppopods")) {
            int iN2 = n(C0906l.f19501a, "com.coloros.oppopods");
            A.c("PhoneUtils", new com.oplus.melody.btsdk.protocol.commands.h(iN2, 11));
            for (WhitelistConfigDTO whitelistConfigDTO2 : list) {
                if (Y.n(str, whitelistConfigDTO2)) {
                    if (whitelistConfigDTO2.getPodsVersion() == 0) {
                        break;
                    }
                    if (iN2 >= whitelistConfigDTO2.getPodsVersion()) {
                        return 1;
                    }
                }
            }
        } else {
            if (!v(C0906l.f19501a, "com.oneplus.twspods")) {
                A.b("PhoneUtils", "getLocalCompatibleType: pods not found");
                return -1;
            }
            int iN3 = n(C0906l.f19501a, "com.oneplus.twspods");
            A.c("PhoneUtils", new O(iN3, 1));
            if (iN3 >= 4001230) {
                for (WhitelistConfigDTO whitelistConfigDTO3 : list) {
                    if (Y.n(str, whitelistConfigDTO3)) {
                        if (whitelistConfigDTO3.getOpsPodsVersion() == 0) {
                            break;
                        }
                        if (iN3 >= whitelistConfigDTO3.getOpsPodsVersion()) {
                            return 3;
                        }
                    }
                }
            } else if (f19463a.contains(str)) {
                return 3;
            }
        }
        return -1;
    }

    public static int i(HeyMelodyApplication heyMelodyApplication) {
        if (f19471j == null) {
            q(heyMelodyApplication);
        }
        return f19471j.intValue();
    }

    public static int j() {
        if (f19468f == null) {
            try {
                f19468f = Integer.valueOf(OplusBuild.getOplusOSVERSION());
            } catch (NoClassDefFoundError | NoSuchMethodError unused) {
                f19468f = 0;
            }
            A.x("PhoneUtils", "getOplusOSVersion " + f19468f);
        }
        return f19468f.intValue();
    }

    public static String k() {
        if (f19466d == null) {
            f19466d = l("ro.build.version.opporom", "ro.build.version.oplusrom");
        }
        return f19466d;
    }

    public static String l(String... strArr) {
        String strA;
        for (String str : strArr) {
            try {
                strA = B4.a.a(str);
            } catch (Exception e10) {
                A.i("PhoneUtils", "getSystemProperties failed, key: " + str, e10);
            }
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        return "";
    }

    public static int m() {
        if (h == null) {
            q(C0906l.f19501a);
        }
        return h.intValue();
    }

    public static int n(HeyMelodyApplication heyMelodyApplication, String str) {
        try {
            PackageInfo packageInfo = heyMelodyApplication.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
        } catch (PackageManager.NameNotFoundException e10) {
            A.i("PhoneUtils", "getVersionCode", e10);
        }
        return 0;
    }

    public static String o(HeyMelodyApplication heyMelodyApplication, String str) {
        try {
            PackageInfo packageInfo = heyMelodyApplication.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            A.i("PhoneUtils", "getVersionName", e10);
            return null;
        }
    }

    public static boolean p() {
        try {
            List<ResolveInfo> listQueryIntentActivities = Build.VERSION.SDK_INT >= 33 ? C0906l.f19501a.getPackageManager().queryIntentActivities(new Intent("wireless.settings.DEVICE_PROFILES_SETTINGS"), PackageManager.ResolveInfoFlags.of(65536L)) : C0906l.f19501a.getPackageManager().queryIntentActivities(new Intent("wireless.settings.DEVICE_PROFILES_SETTINGS"), ArrayPool.STANDARD_BUFFER_SIZE_BYTES);
            if (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) {
                A.x("PhoneUtils", "hasAction = false, action: wireless.settings.DEVICE_PROFILES_SETTINGS");
                return false;
            }
            if (!A.l()) {
                return true;
            }
            A.b("PhoneUtils", "hasAction = true, action: wireless.settings.DEVICE_PROFILES_SETTINGS, infos: " + listQueryIntentActivities);
            return true;
        } catch (Exception e10) {
            A.i("PhoneUtils", "hasAction", e10);
            return false;
        }
    }

    public static void q(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE);
            f19469g = packageInfo.versionName;
            h = Integer.valueOf(packageInfo.versionCode);
            Bundle bundle = packageInfo.applicationInfo.metaData;
            if (bundle != null) {
                Object obj = bundle.get("versionCode");
                if (obj != null) {
                    f19471j = Integer.valueOf(Integer.parseInt(obj.toString()));
                }
                Object obj2 = bundle.get("versionCommit");
                String string = null;
                String string2 = obj2 != null ? obj2.toString() : null;
                Object obj3 = bundle.get("versionDate");
                if (obj3 != null) {
                    string = obj3.toString();
                    if (!TextUtils.isEmpty(string) && string.length() == 6) {
                        int i10 = Integer.parseInt(string);
                        Calendar calendar = Calendar.getInstance(DesugarTimeZone.getTimeZone("CST"));
                        calendar.set(((i10 / 100) / 100) + DcsCompatEventConverter.DATA_TYPE_COMMON_MIX_LIST, (r9 % 100) - 1, i10 % 100, 0, 0, 0);
                        calendar.getTimeInMillis();
                    }
                }
                f19470i = f19469g + '_' + string2 + '_' + string;
            }
        } catch (Exception e10) {
            A.i("PhoneUtils", "initAppVersions", e10);
        }
    }

    public static boolean r() {
        ComponentName componentNameG = g();
        if (componentNameG == null) {
            return false;
        }
        String packageName = componentNameG.getPackageName();
        Iterator<String> it = f19464b.iterator();
        while (it.hasNext()) {
            if (packageName.contains(it.next())) {
                A.x("PhoneUtils", "isExcludePackage, topPkgName: ".concat(packageName));
                return true;
            }
        }
        return false;
    }

    public static boolean s(Context context) {
        return "com.heytap.headset".equals(context.getPackageName());
    }

    public static boolean t(Context context) {
        return "com.oplus.melody".equals(context.getPackageName());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean u() {
        /*
            int r0 = j()
            r1 = 19
            r2 = 0
            if (r0 >= r1) goto La
            goto L4b
        La:
            com.heytap.headset.HeyMelodyApplication r1 = com.oplus.melody.common.util.C0906l.f19501a
            java.lang.String r1 = r1.getPackageName()
            int r3 = r1.hashCode()
            java.lang.String r4 = "com.oneplus.twspods"
            r5 = 2
            java.lang.String r6 = "com.coloros.oppopods"
            r7 = 1
            switch(r3) {
                case -1531668541: goto L3a;
                case 694226114: goto L32;
                case 1822426792: goto L28;
                case 1881494850: goto L1e;
                default: goto L1d;
            }
        L1d:
            goto L42
        L1e:
            java.lang.String r3 = "com.oplus.melody"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L42
            r3 = r2
            goto L43
        L28:
            java.lang.String r3 = "com.heytap.headset"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L42
            r3 = 3
            goto L43
        L32:
            boolean r3 = r1.equals(r6)
            if (r3 == 0) goto L42
            r3 = r5
            goto L43
        L3a:
            boolean r3 = r1.equals(r4)
            if (r3 == 0) goto L42
            r3 = r7
            goto L43
        L42:
            r3 = -1
        L43:
            r8 = 23
            if (r3 == 0) goto L50
            if (r3 == r7) goto L4c
            if (r3 == r5) goto L4c
        L4b:
            return r2
        L4c:
            if (r0 < r8) goto L63
        L4e:
            r2 = r7
            goto L63
        L50:
            if (r0 >= r8) goto L63
            com.heytap.headset.HeyMelodyApplication r3 = com.oplus.melody.common.util.C0906l.f19501a
            boolean r3 = v(r3, r6)
            if (r3 != 0) goto L4e
            com.heytap.headset.HeyMelodyApplication r3 = com.oplus.melody.common.util.C0906l.f19501a
            boolean r3 = v(r3, r4)
            if (r3 == 0) goto L63
            goto L4e
        L63:
            if (r2 == 0) goto L80
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "isOsIncompatible osVersion: "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r0 = ", pkgName: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "PhoneUtils"
            com.oplus.melody.common.util.A.x(r1, r0)
        L80:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.common.util.S.u():boolean");
    }

    public static boolean v(Context context, String str) {
        PackageManager packageManager;
        if (context == null || TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        try {
            packageManager.getApplicationInfo(str, 0);
            A.f("PhoneUtils", "isPkgInstalled: true " + str);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            A.f("PhoneUtils", "isPkgInstalled: false " + str);
            return false;
        } catch (Exception e10) {
            A.i("PhoneUtils", "isPkgInstalled", e10);
            return false;
        }
    }

    public static boolean w(HeyMelodyApplication heyMelodyApplication, int i10) {
        boolean zEquals;
        if (heyMelodyApplication == null) {
            A.b("PhoneUtils", "isRejectDialog context is null");
            return true;
        }
        if ((i10 & 1) == 0 && !y(heyMelodyApplication)) {
            A.b("PhoneUtils", "isRejectDialog Setup");
            return true;
        }
        if (Settings.Global.getInt(heyMelodyApplication.getContentResolver(), "a2dp_gamemode_value", 0) == 1) {
            A.b("PhoneUtils", "now is game mode");
            A.b("PhoneUtils", "isRejectDialog GameMode");
            return true;
        }
        KeyguardManager keyguardManager = (KeyguardManager) heyMelodyApplication.getSystemService("keyguard");
        if (keyguardManager != null ? keyguardManager.isKeyguardLocked() : false) {
            A.b("PhoneUtils", "isRejectDialog ScreenLocked");
            return true;
        }
        if (A()) {
            A.b("PhoneUtils", "isRejectDialog FullScreen");
            return true;
        }
        if (C0900f.a()) {
            A.b("PhoneUtils", "isRejectDialog Camera");
            return true;
        }
        if ((i10 & 64) == 0) {
            if (s(C0906l.f19501a)) {
                zEquals = false;
            } else {
                ComponentName componentNameG = g();
                zEquals = componentNameG != null ? "com.heytap.headset.component.scan.ScanActivity".equals(componentNameG.getClassName()) : false;
                if (A.l()) {
                    A.b("PhoneUtils", "isHeyScanActivityOnForeground " + zEquals);
                }
            }
            if (zEquals) {
                A.b("PhoneUtils", "isRejectDialog scanActivity");
                return true;
            }
        }
        if ((i10 & 32) == 0) {
            Display display = ((DisplayManager) heyMelodyApplication.getSystemService("display")).getDisplay(0);
            if (display == null || display.getState() == 1) {
                A.b("PhoneUtils", "isRejectDialog DisplayOff");
                return true;
            }
        }
        return false;
    }

    public static boolean x(HeyMelodyApplication heyMelodyApplication) {
        if (Build.VERSION.SDK_INT < 31) {
            return true;
        }
        UserManager userManager = (UserManager) heyMelodyApplication.getSystemService("user");
        return userManager != null && userManager.isUserForeground();
    }

    public static boolean y(HeyMelodyApplication heyMelodyApplication) {
        if (!f19472k) {
            if (t(heyMelodyApplication)) {
                boolean z2 = Settings.Secure.getInt(heyMelodyApplication.getContentResolver(), "user_setup_complete", 0) == 1;
                boolean z4 = Settings.Global.getInt(heyMelodyApplication.getContentResolver(), "device_provisioned", 0) == 1;
                A.x("PhoneUtils", "isUserSetupComplete = " + z2 + ", isDeviceProvisioned = " + z4);
                f19472k = z2 && z4;
            } else {
                f19472k = true;
            }
        }
        return f19472k;
    }

    public static void z(androidx.fragment.app.f fVar) {
        if (fVar == null || fVar.getWindow() == null) {
            return;
        }
        o0.d(new X3.w(fVar, 18));
    }
}
