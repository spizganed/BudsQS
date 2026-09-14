package com.oplus.melody.model.repository.hearingenhance;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: EarScanStatusDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/oplus/melody/model/repository/hearingenhance/EarScanStatusDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "address", "", "hearingType", "", ClientDataEntity.COL_STATUS, "<init>", "(Ljava/lang/String;II)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getHearingType", "()I", "setHearingType", "(I)V", "getStatus", "setStatus", "component1", "component2", "component3", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class EarScanStatusDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<EarScanStatusDTO> CREATOR = new a();
    private String address;
    private int hearingType;
    private int status;

    /* JADX INFO: compiled from: EarScanStatusDTO.kt */
    public static final class a implements Parcelable.Creator<EarScanStatusDTO> {
        @Override // android.os.Parcelable.Creator
        public final EarScanStatusDTO createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "parcel");
            return new EarScanStatusDTO(parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final EarScanStatusDTO[] newArray(int i10) {
            return new EarScanStatusDTO[i10];
        }
    }

    public EarScanStatusDTO() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ EarScanStatusDTO copy$default(EarScanStatusDTO earScanStatusDTO, String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = earScanStatusDTO.address;
        }
        if ((i12 & 2) != 0) {
            i10 = earScanStatusDTO.hearingType;
        }
        if ((i12 & 4) != 0) {
            i11 = earScanStatusDTO.status;
        }
        return earScanStatusDTO.copy(str, i10, i11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHearingType() {
        return this.hearingType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final EarScanStatusDTO copy(String address, int hearingType, int status) {
        return new EarScanStatusDTO(address, hearingType, status);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getHearingType() {
        return this.hearingType;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setHearingType(int i10) {
        this.hearingType = i10;
    }

    public final void setStatus(int i10) {
        this.status = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeString(this.address);
        dest.writeInt(this.hearingType);
        dest.writeInt(this.status);
    }

    public EarScanStatusDTO(String str, int i10, int i11) {
        this.address = str;
        this.hearingType = i10;
        this.status = i11;
    }

    public /* synthetic */ EarScanStatusDTO(String str, int i10, int i11, int i12, kotlin.jvm.internal.d dVar) {
        this((i12 & 1) != 0 ? null : str, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? 0 : i11);
    }
}
