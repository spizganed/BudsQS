package com.oplus.melody.model.repository.earphone;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: EarStatusDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0004J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/oplus/melody/model/repository/earphone/EarStatusDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "boxStatus", "", "leftStatus", "rightStatus", "<init>", "(III)V", "getBoxStatus", "()I", "getLeftStatus", "getRightStatus", "bothInEar", "", "leastOneInEar", "bothNotInEar", "onlyOneInBox", "bothInBox", "leastOneInBox", "component1", "component2", "component3", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class EarStatusDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<EarStatusDTO> CREATOR = new a();
    private final int boxStatus;
    private final int leftStatus;
    private final int rightStatus;

    /* JADX INFO: compiled from: EarStatusDTO.kt */
    public static final class a implements Parcelable.Creator<EarStatusDTO> {
        @Override // android.os.Parcelable.Creator
        public final EarStatusDTO createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "parcel");
            return new EarStatusDTO(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final EarStatusDTO[] newArray(int i10) {
            return new EarStatusDTO[i10];
        }
    }

    public EarStatusDTO(int i10, int i11, int i12) {
        this.boxStatus = i10;
        this.leftStatus = i11;
        this.rightStatus = i12;
    }

    public static /* synthetic */ EarStatusDTO copy$default(EarStatusDTO earStatusDTO, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = earStatusDTO.boxStatus;
        }
        if ((i13 & 2) != 0) {
            i11 = earStatusDTO.leftStatus;
        }
        if ((i13 & 4) != 0) {
            i12 = earStatusDTO.rightStatus;
        }
        return earStatusDTO.copy(i10, i11, i12);
    }

    public final boolean bothInBox() {
        return (this.leftStatus & 1) == 1 && (this.rightStatus & 1) == 1;
    }

    public final boolean bothInEar() {
        return (this.leftStatus & 2) == 2 && (this.rightStatus & 2) == 2;
    }

    public final boolean bothNotInEar() {
        return ((this.leftStatus & 2) == 2 || (this.rightStatus & 2) == 2) ? false : true;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBoxStatus() {
        return this.boxStatus;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLeftStatus() {
        return this.leftStatus;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRightStatus() {
        return this.rightStatus;
    }

    public final EarStatusDTO copy(int boxStatus, int leftStatus, int rightStatus) {
        return new EarStatusDTO(boxStatus, leftStatus, rightStatus);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getBoxStatus() {
        return this.boxStatus;
    }

    public final int getLeftStatus() {
        return this.leftStatus;
    }

    public final int getRightStatus() {
        return this.rightStatus;
    }

    public final boolean leastOneInBox() {
        return (this.leftStatus & 1) == 1 || (this.rightStatus & 1) == 1;
    }

    public final boolean leastOneInEar() {
        return (this.leftStatus & 2) == 2 || (this.rightStatus & 2) == 2;
    }

    public final boolean onlyOneInBox() {
        int i10 = this.leftStatus;
        return ((i10 & 1) == 1 && (this.rightStatus & 1) != 1) || ((i10 & 1) != 1 && (this.rightStatus & 1) == 1);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeInt(this.boxStatus);
        dest.writeInt(this.leftStatus);
        dest.writeInt(this.rightStatus);
    }
}
