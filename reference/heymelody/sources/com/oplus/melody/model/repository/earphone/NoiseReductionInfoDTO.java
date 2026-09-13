package com.oplus.melody.model.repository.earphone;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.btsdk.api.data.NoiseReductionInfo;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: NoiseReductionInfoDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0017\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0013J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\nJ\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J'\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u0004J\u0016\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/oplus/melody/model/repository/earphone/NoiseReductionInfoDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "action", "", SpeechFindManager.TYPE, "value", "<init>", "(III)V", "info", "Lcom/oplus/melody/btsdk/api/data/NoiseReductionInfo;", "(Lcom/oplus/melody/btsdk/api/data/NoiseReductionInfo;)V", "getAction", "()I", "getType", "getValue", "setValue", "(I)V", "isSupportNoiseReductionModeValue", "", "index", "isNoiseReductionModeInfo", "setSupportNoiseReductionModeValue", "", "support", "toNoiseReductionInfo", "component1", "component2", "component3", "copy", "describeContents", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "Companion", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class NoiseReductionInfoDTO extends com.oplus.melody.common.data.a implements Parcelable {
    private static final String TAG = "NoiseReductionInfoDTO";
    private final int action;
    private final int type;
    private int value;
    public static final Parcelable.Creator<NoiseReductionInfoDTO> CREATOR = new b();

    /* JADX INFO: compiled from: NoiseReductionInfoDTO.kt */
    public static final class b implements Parcelable.Creator<NoiseReductionInfoDTO> {
        @Override // android.os.Parcelable.Creator
        public final NoiseReductionInfoDTO createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "parcel");
            return new NoiseReductionInfoDTO(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final NoiseReductionInfoDTO[] newArray(int i10) {
            return new NoiseReductionInfoDTO[i10];
        }
    }

    public NoiseReductionInfoDTO(int i10, int i11, int i12) {
        this.action = i10;
        this.type = i11;
        this.value = i12;
    }

    public static /* synthetic */ NoiseReductionInfoDTO copy$default(NoiseReductionInfoDTO noiseReductionInfoDTO, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = noiseReductionInfoDTO.action;
        }
        if ((i13 & 2) != 0) {
            i11 = noiseReductionInfoDTO.type;
        }
        if ((i13 & 4) != 0) {
            i12 = noiseReductionInfoDTO.value;
        }
        return noiseReductionInfoDTO.copy(i10, i11, i12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAction() {
        return this.action;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    public final NoiseReductionInfoDTO copy(int action, int type, int value) {
        return new NoiseReductionInfoDTO(action, type, value);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getAction() {
        return this.action;
    }

    public final int getType() {
        return this.type;
    }

    public final int getValue() {
        return this.value;
    }

    public final boolean isNoiseReductionModeInfo() {
        int i10 = this.type;
        return i10 == 1 || i10 == 3 || i10 == 4;
    }

    public final boolean isSupportNoiseReductionModeValue(int index) {
        return ((1 << index) & this.value) != 0;
    }

    public final void setSupportNoiseReductionModeValue(int index, boolean support) {
        int i10;
        int i11 = 1 << index;
        if (support) {
            i10 = i11 | this.value;
        } else {
            i10 = (~i11) & this.value;
        }
        this.value = i10;
    }

    public final void setValue(int i10) {
        this.value = i10;
    }

    public final NoiseReductionInfo toNoiseReductionInfo() {
        NoiseReductionInfo noiseReductionInfo = new NoiseReductionInfo();
        noiseReductionInfo.setAction(this.action);
        noiseReductionInfo.setType(this.type);
        noiseReductionInfo.setValue(this.value);
        return noiseReductionInfo;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeInt(this.action);
        dest.writeInt(this.type);
        dest.writeInt(this.value);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"WrongConstant"})
    public NoiseReductionInfoDTO(NoiseReductionInfo info) {
        this(info.getAction(), info.getType(), info.getValue());
        kotlin.jvm.internal.h.e(info, "info");
    }
}
