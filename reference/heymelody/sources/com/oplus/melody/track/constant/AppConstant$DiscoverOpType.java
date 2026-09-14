package com.oplus.melody.track.constant;

import kotlin.Metadata;

/* JADX INFO: compiled from: AppConstant.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/oplus/melody/track/constant/AppConstant$DiscoverOpType;", "", "opType", "", "<init>", "(Ljava/lang/String;II)V", "getOpType", "()I", "NONE", "SHOW_DIALOG", "CONNECTING", "CONNECTED", "CANCEL", "ERROR", "SHOW_RES", "BACK_CONNECT", "track_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum AppConstant$DiscoverOpType {
    /* JADX INFO: Fake field, exist only in values array */
    NONE(0),
    SHOW_DIALOG(1),
    CONNECTING(2),
    CONNECTED(3),
    CANCEL(4),
    ERROR(5),
    SHOW_RES(6),
    BACK_CONNECT(7);

    private final int opType;

    AppConstant$DiscoverOpType(int i10) {
        this.opType = i10;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getOpType() {
        return this.opType;
    }
}
