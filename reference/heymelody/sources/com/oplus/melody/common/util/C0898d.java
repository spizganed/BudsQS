package com.oplus.melody.common.util;

import android.content.ContentValues;
import android.net.Uri;
import com.heytap.headset.HeyMelodyApplication;

/* JADX INFO: renamed from: com.oplus.melody.common.util.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppManagerProviderUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0898d {
    public static void a(HeyMelodyApplication heyMelodyApplication, int i10) {
        if (heyMelodyApplication == null) {
            A.b("AppManagerProviderUtils", "put: context is null ");
            return;
        }
        if (i10 != 1 && i10 != 0) {
            A.c("AppManagerProviderUtils", new com.oplus.melody.btsdk.protocol.commands.h(i10, 9));
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("packageName", heyMelodyApplication.getPackageName());
            contentValues.put("startState", Integer.valueOf(i10));
            heyMelodyApplication.getContentResolver().insert(Uri.parse("content://com.heytap.accessory.persistent.provider.db/settings_table"), contentValues);
            A.c("AppManagerProviderUtils", new Ea.D(i10, 29));
        } catch (Exception e10) {
            A.o(5, "AppManagerProviderUtils", "put: error!!", e10);
        }
    }
}
