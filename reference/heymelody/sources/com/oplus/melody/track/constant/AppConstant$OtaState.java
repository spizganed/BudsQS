package com.oplus.melody.track.constant;

import com.oplus.drs.statistics.DataTypeConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: AppConstant.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/oplus/melody/track/constant/AppConstant$OtaState;", "", "state", "", "<init>", "(Ljava/lang/String;II)V", "getState", "()I", "NONE", "ENTER", "FOUND_NEW_UPDATE", "DOWNLOAD_SUCCESS", "DOWNLOAD_FAILED", "UPGRADE_START", "UPGRADE_SUCCESS", "UPGRADE_FAILED", "REQUEST_RESULT", "track_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum AppConstant$OtaState {
    /* JADX INFO: Fake field, exist only in values array */
    NONE(0),
    ENTER(1),
    FOUND_NEW_UPDATE(2),
    DOWNLOAD_SUCCESS(3),
    DOWNLOAD_FAILED(4),
    UPGRADE_START(5),
    UPGRADE_SUCCESS(6),
    /* JADX INFO: Fake field, exist only in values array */
    UPGRADE_FAILED(7),
    REQUEST_RESULT(DataTypeConstants.USER_ACTION);

    private final int state;

    AppConstant$OtaState(int i10) {
        this.state = i10;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getState() {
        return this.state;
    }
}
