package com.oplus.melody.track.constant;

import kotlin.Metadata;

/* JADX INFO: compiled from: AppConstant.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/oplus/melody/track/constant/AppConstant$DialogType;", "", "dialogType", "", "<init>", "(Ljava/lang/String;II)V", "getDialogType", "()I", "CONNECT_BY_ACCOUNT", "BACK_CONNECT_BY_ACCOUNT", "NORMAL_CONNECT", "NORMAL_BACK_CONNECT", "track_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum AppConstant$DialogType {
    CONNECT_BY_ACCOUNT(1),
    BACK_CONNECT_BY_ACCOUNT(2),
    NORMAL_CONNECT(3),
    NORMAL_BACK_CONNECT(4);

    private final int dialogType;

    AppConstant$DialogType(int i10) {
        this.dialogType = i10;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getDialogType() {
        return this.dialogType;
    }
}
