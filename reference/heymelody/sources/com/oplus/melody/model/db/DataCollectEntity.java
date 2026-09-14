package com.oplus.melody.model.db;

import kotlin.Metadata;

/* JADX INFO: renamed from: com.oplus.melody.model.db.q, reason: from Kotlin metadata */
/* JADX INFO: compiled from: DataCollectEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/oplus/melody/model/db/DataCollectEntity;", "Lcom/oplus/melody/common/data/BaseBean;", "<init>", "()V", "id", "", "getId", "()I", "setId", "(I)V", "mDataType", "getMDataType", "setMDataType", "mTime", "", "getMTime", "()J", "setMTime", "(J)V", "mDataContentType", "getMDataContentType", "setMDataContentType", "mDataContent", "", "getMDataContent", "()Ljava/lang/String;", "setMDataContent", "(Ljava/lang/String;)V", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class DataCollectEntity extends com.oplus.melody.common.data.a {
    private int id;
    private String mDataContent;
    private int mDataContentType;
    private int mDataType;
    private long mTime;

    public final int getId() {
        return this.id;
    }

    public final String getMDataContent() {
        return this.mDataContent;
    }

    public final int getMDataContentType() {
        return this.mDataContentType;
    }

    public final int getMDataType() {
        return this.mDataType;
    }

    public final long getMTime() {
        return this.mTime;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setMDataContent(String str) {
        this.mDataContent = str;
    }

    public final void setMDataContentType(int i10) {
        this.mDataContentType = i10;
    }

    public final void setMDataType(int i10) {
        this.mDataType = i10;
    }

    public final void setMTime(long j5) {
        this.mTime = j5;
    }
}
