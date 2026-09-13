package com.oplus.melody.model.repository.interrupt;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: InterruptInfoDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/oplus/melody/model/repository/interrupt/InterruptInfoDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "address", "", "interruptType", "", "interruptReason", "<init>", "(Ljava/lang/String;II)V", "getAddress", "()Ljava/lang/String;", "getInterruptType", "()I", "getInterruptReason", "component1", "component2", "component3", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class InterruptInfoDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<InterruptInfoDTO> CREATOR = new a();
    private final String address;
    private final int interruptReason;
    private final int interruptType;

    /* JADX INFO: compiled from: InterruptInfoDTO.kt */
    public static final class a implements Parcelable.Creator<InterruptInfoDTO> {
        @Override // android.os.Parcelable.Creator
        public final InterruptInfoDTO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new InterruptInfoDTO(parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final InterruptInfoDTO[] newArray(int i10) {
            return new InterruptInfoDTO[i10];
        }
    }

    public InterruptInfoDTO() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ InterruptInfoDTO copy$default(InterruptInfoDTO interruptInfoDTO, String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = interruptInfoDTO.address;
        }
        if ((i12 & 2) != 0) {
            i10 = interruptInfoDTO.interruptType;
        }
        if ((i12 & 4) != 0) {
            i11 = interruptInfoDTO.interruptReason;
        }
        return interruptInfoDTO.copy(str, i10, i11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getInterruptType() {
        return this.interruptType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getInterruptReason() {
        return this.interruptReason;
    }

    public final InterruptInfoDTO copy(String address, int interruptType, int interruptReason) {
        h.e(address, "address");
        return new InterruptInfoDTO(address, interruptType, interruptReason);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getInterruptReason() {
        return this.interruptReason;
    }

    public final int getInterruptType() {
        return this.interruptType;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.address);
        dest.writeInt(this.interruptType);
        dest.writeInt(this.interruptReason);
    }

    public InterruptInfoDTO(String address, int i10, int i11) {
        h.e(address, "address");
        this.address = address;
        this.interruptType = i10;
        this.interruptReason = i11;
    }

    public /* synthetic */ InterruptInfoDTO(String str, int i10, int i11, int i12, d dVar) {
        this((i12 & 1) != 0 ? "" : str, (i12 & 2) != 0 ? -1 : i10, (i12 & 4) != 0 ? -1 : i11);
    }
}
