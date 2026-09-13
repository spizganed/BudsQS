package com.oplus.melody.common.addon;

import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyAppEnterInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/oplus/melody/common/addon/MelodyAppEnterInfo;", "Lcom/oplus/melody/common/addon/MelodyAppSwitchInfo;", "targetName", "", "<init>", "(Ljava/lang/String;)V", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyAppEnterInfo extends MelodyAppSwitchInfo {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyAppEnterInfo(String targetName) {
        super(targetName);
        h.e(targetName, "targetName");
    }
}
