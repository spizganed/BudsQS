package com.oplus.melody.model.repository.earphone;

import kotlin.Metadata;

/* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.Q, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SetCommandStateDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "address", "", "setCommandStatus", "", "<init>", "(Ljava/lang/String;I)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getSetCommandStatus", "()I", "setSetCommandStatus", "(I)V", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SetCommandStateDTO extends com.oplus.melody.common.data.a {
    private String address;
    private int setCommandStatus;

    /* JADX WARN: Multi-variable type inference failed */
    public SetCommandStateDTO() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getSetCommandStatus() {
        return this.setCommandStatus;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setSetCommandStatus(int i10) {
        this.setCommandStatus = i10;
    }

    public SetCommandStateDTO(String str, int i10) {
        this.address = str;
        this.setCommandStatus = i10;
    }

    public /* synthetic */ SetCommandStateDTO(String str, int i10, int i11, kotlin.jvm.internal.d dVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? -1 : i10);
    }
}
