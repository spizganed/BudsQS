package com.oplus.melody.common.addon;

import android.os.Bundle;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyAppCacheManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/oplus/melody/common/addon/MelodyAppCacheManager;", "", "<init>", "()V", "TAG", "", "queryProviderCache", "Landroid/os/Bundle;", SpeechFindManager.TYPE, "extra", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyAppCacheManager {
    public static final MelodyAppCacheManager INSTANCE = new MelodyAppCacheManager();
    public static final String TAG = "MelodyAppCacheManager";

    private MelodyAppCacheManager() {
    }

    public final Bundle queryProviderCache(String type, Bundle extra) {
        h.e(type, "type");
        h.e(extra, "extra");
        return null;
    }
}
