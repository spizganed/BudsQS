package com.oplus.melody.model.repository.hearingenhance;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: EarRestoreDataDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0004J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/oplus/melody/model/repository/hearingenhance/EarRestoreDataDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "restoreDataType", "", "dataLength", ClientDataEntity.COL_DATA, "", "<init>", "(II[B)V", "getRestoreDataType", "()I", "setRestoreDataType", "(I)V", "getDataLength", "setDataLength", "getData", "()[B", "setData", "([B)V", "component1", "component2", "component3", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class EarRestoreDataDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<EarRestoreDataDTO> CREATOR = new a();
    private byte[] data;
    private int dataLength;
    private int restoreDataType;

    /* JADX INFO: compiled from: EarRestoreDataDTO.kt */
    public static final class a implements Parcelable.Creator<EarRestoreDataDTO> {
        @Override // android.os.Parcelable.Creator
        public final EarRestoreDataDTO createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "parcel");
            return new EarRestoreDataDTO(parcel.readInt(), parcel.readInt(), parcel.createByteArray());
        }

        @Override // android.os.Parcelable.Creator
        public final EarRestoreDataDTO[] newArray(int i10) {
            return new EarRestoreDataDTO[i10];
        }
    }

    public EarRestoreDataDTO() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ EarRestoreDataDTO copy$default(EarRestoreDataDTO earRestoreDataDTO, int i10, int i11, byte[] bArr, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = earRestoreDataDTO.restoreDataType;
        }
        if ((i12 & 2) != 0) {
            i11 = earRestoreDataDTO.dataLength;
        }
        if ((i12 & 4) != 0) {
            bArr = earRestoreDataDTO.data;
        }
        return earRestoreDataDTO.copy(i10, i11, bArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getRestoreDataType() {
        return this.restoreDataType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDataLength() {
        return this.dataLength;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    public final EarRestoreDataDTO copy(int restoreDataType, int dataLength, byte[] data) {
        return new EarRestoreDataDTO(restoreDataType, dataLength, data);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final int getDataLength() {
        return this.dataLength;
    }

    public final int getRestoreDataType() {
        return this.restoreDataType;
    }

    public final void setData(byte[] bArr) {
        this.data = bArr;
    }

    public final void setDataLength(int i10) {
        this.dataLength = i10;
    }

    public final void setRestoreDataType(int i10) {
        this.restoreDataType = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeInt(this.restoreDataType);
        dest.writeInt(this.dataLength);
        dest.writeByteArray(this.data);
    }

    public EarRestoreDataDTO(int i10, int i11, byte[] bArr) {
        this.restoreDataType = i10;
        this.dataLength = i11;
        this.data = bArr;
    }

    public /* synthetic */ EarRestoreDataDTO(int i10, int i11, byte[] bArr, int i12, kotlin.jvm.internal.d dVar) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 0 : i11, (i12 & 4) != 0 ? null : bArr);
    }
}
