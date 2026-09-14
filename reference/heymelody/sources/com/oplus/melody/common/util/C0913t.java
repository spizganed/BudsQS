package com.oplus.melody.common.util;

import com.oplus.content.OplusFeatureConfigManager;

/* JADX INFO: renamed from: com.oplus.melody.common.util.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FoldScreenUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0913t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f19511a;

    public static final boolean a() {
        try {
            if (f19511a == null) {
                f19511a = Boolean.valueOf(OplusFeatureConfigManager.getInstance().hasFeature("oplus.hardware.type.fold"));
            }
        } catch (Throwable th) {
            A.i("FoldScreenUtils", "isFoldDevice, error: ", th);
        }
        Boolean bool = f19511a;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
