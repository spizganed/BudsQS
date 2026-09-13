package com.oplus.melody.model.repository.soundplay;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ListenLimitedTime.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/oplus/melody/model/repository/soundplay/ViewStatus;", "", "<init>", "(Ljava/lang/String;I)V", "OPENED", "OPENING", "CLOSED", "CLOSING", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ViewStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ViewStatus f20124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ViewStatus f20125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ViewStatus f20126c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ViewStatus f20127p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ ViewStatus[] f20128q;

    static {
        ViewStatus viewStatus = new ViewStatus("OPENED", 0);
        f20124a = viewStatus;
        ViewStatus viewStatus2 = new ViewStatus("OPENING", 1);
        f20125b = viewStatus2;
        ViewStatus viewStatus3 = new ViewStatus("CLOSED", 2);
        f20126c = viewStatus3;
        ViewStatus viewStatus4 = new ViewStatus("CLOSING", 3);
        f20127p = viewStatus4;
        f20128q = new ViewStatus[]{viewStatus, viewStatus2, viewStatus3, viewStatus4};
    }

    public ViewStatus() {
        throw null;
    }

    public static ViewStatus valueOf(String str) {
        return (ViewStatus) Enum.valueOf(ViewStatus.class, str);
    }

    public static ViewStatus[] values() {
        return (ViewStatus[]) f20128q.clone();
    }
}
