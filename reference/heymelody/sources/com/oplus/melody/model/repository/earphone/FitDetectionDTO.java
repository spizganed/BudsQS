package com.oplus.melody.model.repository.earphone;

import kotlin.Metadata;

/* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.O, reason: from Kotlin metadata */
/* JADX INFO: compiled from: FitDetectionDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/oplus/melody/model/repository/earphone/FitDetectionDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "deviceType", "", "detectStatus", "<init>", "(II)V", "getDeviceType", "()I", "setDeviceType", "(I)V", "getDetectStatus", "setDetectStatus", "isDetectError", "", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FitDetectionDTO extends com.oplus.melody.common.data.a {
    private int detectStatus;
    private int deviceType;

    /* JADX WARN: Illegal instructions before constructor call */
    public FitDetectionDTO() {
        int i10 = 0;
        this(i10, i10, 3, null);
    }

    public final int getDetectStatus() {
        return this.detectStatus;
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    public final boolean isDetectError() {
        int i10 = this.detectStatus;
        return (i10 == 0 || i10 == 1 || i10 == 6) ? false : true;
    }

    public final void setDetectStatus(int i10) {
        this.detectStatus = i10;
    }

    public final void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public FitDetectionDTO(int i10, int i11) {
        this.deviceType = i10;
        this.detectStatus = i11;
    }

    public /* synthetic */ FitDetectionDTO(int i10, int i11, int i12, kotlin.jvm.internal.d dVar) {
        this((i12 & 1) != 0 ? 255 : i10, (i12 & 2) != 0 ? 0 : i11);
    }
}
