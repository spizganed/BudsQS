package com.oplus.melody.model.repository.earphone;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.btsdk.api.data.KeyFunctionInfo;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: KeyFunctionInfoDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0017\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u0004J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/oplus/melody/model/repository/earphone/KeyFunctionInfoDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "deviceType", "", "deviceButton", "buttonAction", "function", "<init>", "(IIII)V", "info", "Lcom/oplus/melody/btsdk/api/data/KeyFunctionInfo;", "(Lcom/oplus/melody/btsdk/api/data/KeyFunctionInfo;)V", "getDeviceType", "()I", "getDeviceButton", "getButtonAction", "getFunction", "setFunction", "(I)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class KeyFunctionInfoDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<KeyFunctionInfoDTO> CREATOR = new a();
    private final int buttonAction;
    private final int deviceButton;
    private final int deviceType;
    private int function;

    /* JADX INFO: compiled from: KeyFunctionInfoDTO.kt */
    public static final class a implements Parcelable.Creator<KeyFunctionInfoDTO> {
        @Override // android.os.Parcelable.Creator
        public final KeyFunctionInfoDTO createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "parcel");
            return new KeyFunctionInfoDTO(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final KeyFunctionInfoDTO[] newArray(int i10) {
            return new KeyFunctionInfoDTO[i10];
        }
    }

    public KeyFunctionInfoDTO(int i10, int i11, int i12, int i13) {
        this.deviceType = i10;
        this.deviceButton = i11;
        this.buttonAction = i12;
        this.function = i13;
    }

    public static /* synthetic */ KeyFunctionInfoDTO copy$default(KeyFunctionInfoDTO keyFunctionInfoDTO, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = keyFunctionInfoDTO.deviceType;
        }
        if ((i14 & 2) != 0) {
            i11 = keyFunctionInfoDTO.deviceButton;
        }
        if ((i14 & 4) != 0) {
            i12 = keyFunctionInfoDTO.buttonAction;
        }
        if ((i14 & 8) != 0) {
            i13 = keyFunctionInfoDTO.function;
        }
        return keyFunctionInfoDTO.copy(i10, i11, i12, i13);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDeviceButton() {
        return this.deviceButton;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getButtonAction() {
        return this.buttonAction;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getFunction() {
        return this.function;
    }

    public final KeyFunctionInfoDTO copy(int deviceType, int deviceButton, int buttonAction, int function) {
        return new KeyFunctionInfoDTO(deviceType, deviceButton, buttonAction, function);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getButtonAction() {
        return this.buttonAction;
    }

    public final int getDeviceButton() {
        return this.deviceButton;
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    public final int getFunction() {
        return this.function;
    }

    public final void setFunction(int i10) {
        this.function = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeInt(this.deviceType);
        dest.writeInt(this.deviceButton);
        dest.writeInt(this.buttonAction);
        dest.writeInt(this.function);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"WrongConstant"})
    public KeyFunctionInfoDTO(KeyFunctionInfo info) {
        this(info.getDeviceType(), info.getDeviceButton(), info.getButtonAction(), info.getFunction());
        kotlin.jvm.internal.h.e(info, "info");
    }
}
