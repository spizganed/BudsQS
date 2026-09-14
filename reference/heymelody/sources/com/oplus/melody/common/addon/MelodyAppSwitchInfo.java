package com.oplus.melody.common.addon;

import android.os.SystemClock;
import com.oplus.melody.common.data.a;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyAppSwitchInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/oplus/melody/common/addon/MelodyAppSwitchInfo;", "Lcom/oplus/melody/common/data/BaseBean;", "targetName", "", "<init>", "(Ljava/lang/String;)V", "getTargetName", "()Ljava/lang/String;", "switchMillis", "", "getSwitchMillis", "()J", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class MelodyAppSwitchInfo extends a {
    private final long switchMillis;
    private final String targetName;

    public MelodyAppSwitchInfo(String targetName) {
        h.e(targetName, "targetName");
        this.targetName = targetName;
        this.switchMillis = SystemClock.elapsedRealtime();
    }

    public final long getSwitchMillis() {
        return this.switchMillis;
    }

    public final String getTargetName() {
        return this.targetName;
    }
}
