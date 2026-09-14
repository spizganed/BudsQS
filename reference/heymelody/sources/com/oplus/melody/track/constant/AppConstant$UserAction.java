package com.oplus.melody.track.constant;

import kotlin.Metadata;

/* JADX INFO: compiled from: AppConstant.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/oplus/melody/track/constant/AppConstant$UserAction;", "", "userAction", "", "<init>", "(Ljava/lang/String;II)V", "getUserAction", "()I", "ACTION_CONFIRM", "ACTION_CANCEL", "ACTION_COMPLETE", "ACTION_GO_GUIDE", "ACTION_GO_SETTINGS", "ACTION_RETRY", "track_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum AppConstant$UserAction {
    ACTION_CONFIRM(1),
    ACTION_CANCEL(2),
    ACTION_COMPLETE(3),
    ACTION_GO_GUIDE(4),
    ACTION_GO_SETTINGS(5),
    ACTION_RETRY(6);

    private final int userAction;

    AppConstant$UserAction(int i10) {
        this.userAction = i10;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getUserAction() {
        return this.userAction;
    }
}
