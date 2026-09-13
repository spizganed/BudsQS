package com.oplus.melody.model.repository.earphone;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: HeadMotionTryResultDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/oplus/melody/model/repository/earphone/HeadMotionTryResultDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "address", "", "resultCode", "", "<init>", "(Ljava/lang/String;I)V", "getAddress", "()Ljava/lang/String;", "getResultCode", "()I", "component1", "component2", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class HeadMotionTryResultDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<HeadMotionTryResultDTO> CREATOR = new a();
    private final String address;
    private final int resultCode;

    /* JADX INFO: compiled from: HeadMotionTryResultDTO.kt */
    public static final class a implements Parcelable.Creator<HeadMotionTryResultDTO> {
        @Override // android.os.Parcelable.Creator
        public final HeadMotionTryResultDTO createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "parcel");
            return new HeadMotionTryResultDTO(parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final HeadMotionTryResultDTO[] newArray(int i10) {
            return new HeadMotionTryResultDTO[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HeadMotionTryResultDTO() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ HeadMotionTryResultDTO copy$default(HeadMotionTryResultDTO headMotionTryResultDTO, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = headMotionTryResultDTO.address;
        }
        if ((i11 & 2) != 0) {
            i10 = headMotionTryResultDTO.resultCode;
        }
        return headMotionTryResultDTO.copy(str, i10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getResultCode() {
        return this.resultCode;
    }

    public final HeadMotionTryResultDTO copy(String address, int resultCode) {
        return new HeadMotionTryResultDTO(address, resultCode);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeString(this.address);
        dest.writeInt(this.resultCode);
    }

    public HeadMotionTryResultDTO(String str, int i10) {
        this.address = str;
        this.resultCode = i10;
    }

    public /* synthetic */ HeadMotionTryResultDTO(String str, int i10, int i11, kotlin.jvm.internal.d dVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 0 : i10);
    }
}
