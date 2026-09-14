package com.oplus.melody.model.helper;

import O7.r;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.appcompat.widget.a;
import androidx.media3.exoplayer.C0625v;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.Q;
import com.oplus.melody.common.util.S;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class WirelessSettingHelper {
    private static final String ACTION_BATTERY_INFO = "heytap.headsets.intent.action.BATTERY_INFO";
    private static final String ACTION_WHITELIST_UPDATE = "heytap.headsets.intent.action.whiltelist.change";
    private static final String EXTRA_ADDRESS = "address";
    private static final String EXTRA_LEFT_HEADSET_BATTERY = "LEFT_HEADSET_BATTERY";
    private static final String EXTRA_RIGHT_HEADSET_BATTERY = "RIGHT_HEADSET_BATTERY";
    private static final String OPL_COMPONENT_SAFE = "oplus.permission.OPLUS_COMPONENT_SAFE";
    private static final String OPO_COMPONENT_SAFE = "oppo.permission.OPPO_COMPONENT_SAFE";
    private static final String TAG = "WirelessSettingHelper";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$sendBatteryInfo$0(int i10, int i11, String str) {
        return C0625v.i(str, a.m(i10, i11, "sendBatteryInfo: left:", " right:", " address:"));
    }

    public static void sendBatteryInfo(Context context, String str, int i10, int i11) {
        int i12;
        if (context == null) {
            A.h(TAG, "sendBatteryInfo: context is null !");
            return;
        }
        if (S.j() >= 30 || "com.heytap.headset".equals(context.getPackageName())) {
            return;
        }
        if (i10 < 1 && i11 < 1) {
            A.h(TAG, "sendBatteryInfo() invalid parameter, return.");
            return;
        }
        int iMin = Math.min(i10, 100);
        int iMin2 = Math.min(i11, 100);
        Intent intent = new Intent(ACTION_BATTERY_INFO);
        intent.setFlags(32);
        intent.putExtra(EXTRA_ADDRESS, str);
        intent.putExtra(EXTRA_LEFT_HEADSET_BATTERY, iMin);
        intent.putExtra(EXTRA_RIGHT_HEADSET_BATTERY, iMin2);
        A.c(TAG, new r(iMin, iMin2, str));
        try {
            i12 = context.getPackageManager().getPackageInfo("com.oplus.wirelesssettings", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            A.i("PhoneUtils", "getAppVersionCode", e10);
            i12 = -1;
        }
        if (i12 > 0) {
            intent.setPackage("com.oplus.wirelesssettings");
            C0905k.i(context, intent, OPL_COMPONENT_SAFE);
        } else {
            intent.setPackage("com.coloros.wirelesssettings");
            C0905k.i(context, intent, OPO_COMPONENT_SAFE);
        }
    }

    public static void sendWhiteListChangedBroadCast(Context context) {
        sendWhiteListChangedToSettings(context);
        sendWhiteListChangedToBluetooth(context);
    }

    public static void sendWhiteListChangedToBluetooth(Context context) {
        if (context == null) {
            A.h(TAG, "sendWhiteListChangedToBluetooth: context is null !");
            return;
        }
        List<String> list = S.f19463a;
        if ("com.heytap.headset".equals(context.getPackageName())) {
            return;
        }
        if (!Q.a()) {
            A.h(TAG, "sendWhiteListChangedBroadCast: no bt permissions!");
            return;
        }
        Intent intent = new Intent(ACTION_WHITELIST_UPDATE);
        intent.setPackage("com.android.bluetooth");
        C0905k.i(context, intent, OPO_COMPONENT_SAFE);
    }

    public static void sendWhiteListChangedToSettings(Context context) {
        int i10;
        if (context == null) {
            A.h(TAG, "sendWhiteListChangedToSettings: context is null !");
            return;
        }
        List<String> list = S.f19463a;
        if ("com.heytap.headset".equals(context.getPackageName())) {
            return;
        }
        Intent intent = new Intent(ACTION_WHITELIST_UPDATE);
        try {
            i10 = context.getPackageManager().getPackageInfo("com.oplus.wirelesssettings", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            A.i("PhoneUtils", "getAppVersionCode", e10);
            i10 = -1;
        }
        if (i10 > 0) {
            intent.setPackage("com.oplus.wirelesssettings");
        } else {
            intent.setPackage("com.coloros.wirelesssettings");
        }
        C0905k.i(context, intent, OPO_COMPONENT_SAFE);
    }
}
