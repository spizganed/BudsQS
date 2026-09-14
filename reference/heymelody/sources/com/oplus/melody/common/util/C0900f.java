package com.oplus.melody.common.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: renamed from: com.oplus.melody.common.util.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CameraUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0900f {
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a() {
        /*
            com.heytap.headset.HeyMelodyApplication r0 = com.oplus.melody.common.util.C0906l.f19501a
            boolean r0 = com.oplus.melody.common.util.S.s(r0)
            r1 = 0
            if (r0 == 0) goto La
            return r1
        La:
            android.content.ComponentName r0 = com.oplus.melody.common.util.S.g()
            if (r0 == 0) goto L3b
            java.lang.String r2 = r0.getClassName()
            java.lang.String r3 = "com.oplus.camera.Camera"
            boolean r3 = r3.equals(r2)
            r4 = 1
            if (r3 != 0) goto L3a
            java.lang.String r3 = "com.oppo.camera.Camera"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L26
            goto L3a
        L26:
            java.lang.String r0 = r0.getPackageName()
            java.lang.String r2 = "com.oplus.engineercamera"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L3a
            java.lang.String r2 = "com.oplus.engineermode"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L3b
        L3a:
            r1 = r4
        L3b:
            boolean r0 = com.oplus.melody.common.util.A.l()
            if (r0 == 0) goto L54
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "isCameraOnForeground "
            r0.<init>(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "CameraUtils"
            com.oplus.melody.common.util.A.b(r2, r0)
        L54:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.common.util.C0900f.a():boolean");
    }

    public static boolean b(Context context) {
        String str = "com.oplus.camera";
        if (!S.v(context, "com.oplus.camera")) {
            str = "com.oppo.camera";
            if (!S.v(context, "com.oppo.camera")) {
                str = null;
            }
        }
        boolean z2 = false;
        if (!TextUtils.isEmpty(str)) {
            try {
                if (S.j() == 22) {
                    return true;
                }
            } catch (Throwable th) {
                A.i("CameraUtils", "Get OsVersion Exception : ", th);
            }
            if (context != null) {
                Bundle bundleD = S.d(context, str);
                if (bundleD != null && bundleD.getBoolean("isSupportHeadsetPhoto")) {
                    z2 = true;
                }
                A.c("CameraUtils", new C0899e(z2, str, 0));
            }
        }
        return z2;
    }
}
