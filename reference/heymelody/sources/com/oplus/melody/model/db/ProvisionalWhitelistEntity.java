package com.oplus.melody.model.db;

import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.oplus.melody.model.db.K, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ProvisionalWhitelistEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR$\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/oplus/melody/model/db/ProvisionalWhitelistEntity;", "Lcom/oplus/melody/common/data/BaseBean;", "<init>", "()V", "pid", "", "getPid", "()Ljava/lang/String;", "setPid", "(Ljava/lang/String;)V", "name", "getName", "setName", "brand", "getBrand", "setBrand", SpeechFindManager.TYPE, "getType", "setType", "uuid", "getUuid", "setUuid", "fastDiscovery", "", "getFastDiscovery$annotations", "getFastDiscovery", "()I", "setFastDiscovery", "(I)V", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ProvisionalWhitelistEntity extends com.oplus.melody.common.data.a {
    private String brand;
    private int fastDiscovery;
    private String name;
    private String pid = "";
    private String type;
    private String uuid;

    public final String getBrand() {
        return this.brand;
    }

    public final int getFastDiscovery() {
        return this.fastDiscovery;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPid() {
        return this.pid;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final void setBrand(String str) {
        this.brand = str;
    }

    public final void setFastDiscovery(int i10) {
        this.fastDiscovery = i10;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPid(String str) {
        kotlin.jvm.internal.h.e(str, "<set-?>");
        this.pid = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUuid(String str) {
        this.uuid = str;
    }

    public static /* synthetic */ void getFastDiscovery$annotations() {
    }
}
