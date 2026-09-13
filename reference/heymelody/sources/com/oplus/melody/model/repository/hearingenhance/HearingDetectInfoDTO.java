package com.oplus.melody.model.repository.hearingenhance;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: HearingDetectInfoDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/oplus/melody/model/repository/hearingenhance/HearingDetectInfoDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "deviceType", "", SpeechFindManager.TYPE, "dbValue", "<init>", "(III)V", "getDeviceType", "()I", "setDeviceType", "(I)V", "getType", "setType", "getDbValue", "setDbValue", "component1", "component2", "component3", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class HearingDetectInfoDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<HearingDetectInfoDTO> CREATOR = new a();

    @I3.b("mDbValue")
    private int dbValue;

    @I3.b("mDeviceType")
    private int deviceType;

    @I3.b("mType")
    private int type;

    /* JADX INFO: compiled from: HearingDetectInfoDTO.kt */
    public static final class a implements Parcelable.Creator<HearingDetectInfoDTO> {
        @Override // android.os.Parcelable.Creator
        public final HearingDetectInfoDTO createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "parcel");
            return new HearingDetectInfoDTO(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final HearingDetectInfoDTO[] newArray(int i10) {
            return new HearingDetectInfoDTO[i10];
        }
    }

    public HearingDetectInfoDTO() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ HearingDetectInfoDTO copy$default(HearingDetectInfoDTO hearingDetectInfoDTO, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = hearingDetectInfoDTO.deviceType;
        }
        if ((i13 & 2) != 0) {
            i11 = hearingDetectInfoDTO.type;
        }
        if ((i13 & 4) != 0) {
            i12 = hearingDetectInfoDTO.dbValue;
        }
        return hearingDetectInfoDTO.copy(i10, i11, i12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDbValue() {
        return this.dbValue;
    }

    public final HearingDetectInfoDTO copy(int deviceType, int type, int dbValue) {
        return new HearingDetectInfoDTO(deviceType, type, dbValue);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getDbValue() {
        return this.dbValue;
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    public final int getType() {
        return this.type;
    }

    public final void setDbValue(int i10) {
        this.dbValue = i10;
    }

    public final void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeInt(this.deviceType);
        dest.writeInt(this.type);
        dest.writeInt(this.dbValue);
    }

    public HearingDetectInfoDTO(int i10, int i11, int i12) {
        this.deviceType = i10;
        this.type = i11;
        this.dbValue = i12;
    }

    public /* synthetic */ HearingDetectInfoDTO(int i10, int i11, int i12, int i13, kotlin.jvm.internal.d dVar) {
        this((i13 & 1) != 0 ? 0 : i10, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? 0 : i12);
    }
}
