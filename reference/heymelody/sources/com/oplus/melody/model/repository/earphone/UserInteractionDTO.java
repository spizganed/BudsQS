package com.oplus.melody.model.repository.earphone;

import kotlin.Metadata;

/* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.S, reason: from Kotlin metadata */
/* JADX INFO: compiled from: UserInteractionDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/oplus/melody/model/repository/earphone/UserInteractionDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "deviceType", "", "action", "function", "button", "<init>", "(IIII)V", "getDeviceType", "()I", "setDeviceType", "(I)V", "getAction", "setAction", "getFunction", "setFunction", "getButton", "setButton", "component1", "component2", "component3", "component4", "copy", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class UserInteractionDTO extends com.oplus.melody.common.data.a {
    private int action;
    private int button;
    private int deviceType;
    private int function;

    public UserInteractionDTO(int i10, int i11, int i12, int i13) {
        this.deviceType = i10;
        this.action = i11;
        this.function = i12;
        this.button = i13;
    }

    public static /* synthetic */ UserInteractionDTO copy$default(UserInteractionDTO userInteractionDTO, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = userInteractionDTO.deviceType;
        }
        if ((i14 & 2) != 0) {
            i11 = userInteractionDTO.action;
        }
        if ((i14 & 4) != 0) {
            i12 = userInteractionDTO.function;
        }
        if ((i14 & 8) != 0) {
            i13 = userInteractionDTO.button;
        }
        return userInteractionDTO.copy(i10, i11, i12, i13);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAction() {
        return this.action;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFunction() {
        return this.function;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getButton() {
        return this.button;
    }

    public final UserInteractionDTO copy(int i10, int i11, int i12, int i13) {
        return new UserInteractionDTO(i10, i11, i12, i13);
    }

    public final int getAction() {
        return this.action;
    }

    public final int getButton() {
        return this.button;
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    public final int getFunction() {
        return this.function;
    }

    public final void setAction(int i10) {
        this.action = i10;
    }

    public final void setButton(int i10) {
        this.button = i10;
    }

    public final void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public final void setFunction(int i10) {
        this.function = i10;
    }
}
