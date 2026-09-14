package com.oplus.melody.model.repository.hearingenhance;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: EarScanResultDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001a\u001a\u00020\u0006J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/oplus/melody/model/repository/hearingenhance/EarScanResultDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "address", "", "action", "", "uniqueId", "resultData", "", "<init>", "(Ljava/lang/String;II[B)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getAction", "()I", "setAction", "(I)V", "getUniqueId", "setUniqueId", "getResultData", "()[B", "setResultData", "([B)V", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EarScanResultDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<EarScanResultDTO> CREATOR = new a();
    private int action;
    private String address;
    private byte[] resultData;
    private int uniqueId;

    /* JADX INFO: compiled from: EarScanResultDTO.kt */
    public static final class a implements Parcelable.Creator<EarScanResultDTO> {
        @Override // android.os.Parcelable.Creator
        public final EarScanResultDTO createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "parcel");
            return new EarScanResultDTO(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
        }

        @Override // android.os.Parcelable.Creator
        public final EarScanResultDTO[] newArray(int i10) {
            return new EarScanResultDTO[i10];
        }
    }

    public EarScanResultDTO() {
        this(null, 0, 0, null, 15, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getAction() {
        return this.action;
    }

    public final String getAddress() {
        return this.address;
    }

    public final byte[] getResultData() {
        return this.resultData;
    }

    public final int getUniqueId() {
        return this.uniqueId;
    }

    public final void setAction(int i10) {
        this.action = i10;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setResultData(byte[] bArr) {
        this.resultData = bArr;
    }

    public final void setUniqueId(int i10) {
        this.uniqueId = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeString(this.address);
        dest.writeInt(this.action);
        dest.writeInt(this.uniqueId);
        dest.writeByteArray(this.resultData);
    }

    public EarScanResultDTO(String str, int i10, int i11, byte[] bArr) {
        this.address = str;
        this.action = i10;
        this.uniqueId = i11;
        this.resultData = bArr;
    }

    public /* synthetic */ EarScanResultDTO(String str, int i10, int i11, byte[] bArr, int i12, kotlin.jvm.internal.d dVar) {
        this((i12 & 1) != 0 ? null : str, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? null : bArr);
    }
}
