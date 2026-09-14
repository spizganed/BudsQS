package com.oplus.melody.model.repository.firmware;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.btsdk.api.data.UpgradeStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: FirmwareUpgradeStateDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nB#\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u001c\u001a\u00020\u0004J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006\""}, d2 = {"Lcom/oplus/melody/model/repository/firmware/FirmwareUpgradeStateDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "mUpgradeState", "", "mUpgradePercent", "mUpgradeFinishStatus", "melodyUpgradeStatus", "melodyUpgradeType", "<init>", "(IIIII)V", "upgradeStateInfo", "Lcom/oplus/melody/btsdk/api/data/UpgradeStateInfo;", ClientDataEntity.COL_STATUS, SpeechFindManager.TYPE, "(Lcom/oplus/melody/btsdk/api/data/UpgradeStateInfo;II)V", "getMUpgradeState", "()I", "getMUpgradePercent", "getMUpgradeFinishStatus", "getMelodyUpgradeStatus", "getMelodyUpgradeType", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class FirmwareUpgradeStateDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<FirmwareUpgradeStateDTO> CREATOR = new a();
    private final int mUpgradeFinishStatus;
    private final int mUpgradePercent;
    private final int mUpgradeState;
    private final int melodyUpgradeStatus;
    private final int melodyUpgradeType;

    /* JADX INFO: compiled from: FirmwareUpgradeStateDTO.kt */
    public static final class a implements Parcelable.Creator<FirmwareUpgradeStateDTO> {
        @Override // android.os.Parcelable.Creator
        public final FirmwareUpgradeStateDTO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new FirmwareUpgradeStateDTO(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final FirmwareUpgradeStateDTO[] newArray(int i10) {
            return new FirmwareUpgradeStateDTO[i10];
        }
    }

    public FirmwareUpgradeStateDTO(int i10, int i11, int i12, int i13, int i14) {
        this.mUpgradeState = i10;
        this.mUpgradePercent = i11;
        this.mUpgradeFinishStatus = i12;
        this.melodyUpgradeStatus = i13;
        this.melodyUpgradeType = i14;
    }

    public static /* synthetic */ FirmwareUpgradeStateDTO copy$default(FirmwareUpgradeStateDTO firmwareUpgradeStateDTO, int i10, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i10 = firmwareUpgradeStateDTO.mUpgradeState;
        }
        if ((i15 & 2) != 0) {
            i11 = firmwareUpgradeStateDTO.mUpgradePercent;
        }
        if ((i15 & 4) != 0) {
            i12 = firmwareUpgradeStateDTO.mUpgradeFinishStatus;
        }
        if ((i15 & 8) != 0) {
            i13 = firmwareUpgradeStateDTO.melodyUpgradeStatus;
        }
        if ((i15 & 16) != 0) {
            i14 = firmwareUpgradeStateDTO.melodyUpgradeType;
        }
        int i16 = i14;
        int i17 = i12;
        return firmwareUpgradeStateDTO.copy(i10, i11, i17, i13, i16);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMUpgradeState() {
        return this.mUpgradeState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMUpgradePercent() {
        return this.mUpgradePercent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMUpgradeFinishStatus() {
        return this.mUpgradeFinishStatus;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getMelodyUpgradeStatus() {
        return this.melodyUpgradeStatus;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getMelodyUpgradeType() {
        return this.melodyUpgradeType;
    }

    public final FirmwareUpgradeStateDTO copy(int mUpgradeState, int mUpgradePercent, int mUpgradeFinishStatus, int melodyUpgradeStatus, int melodyUpgradeType) {
        return new FirmwareUpgradeStateDTO(mUpgradeState, mUpgradePercent, mUpgradeFinishStatus, melodyUpgradeStatus, melodyUpgradeType);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getMUpgradeFinishStatus() {
        return this.mUpgradeFinishStatus;
    }

    public final int getMUpgradePercent() {
        return this.mUpgradePercent;
    }

    public final int getMUpgradeState() {
        return this.mUpgradeState;
    }

    public final int getMelodyUpgradeStatus() {
        return this.melodyUpgradeStatus;
    }

    public final int getMelodyUpgradeType() {
        return this.melodyUpgradeType;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeInt(this.mUpgradeState);
        dest.writeInt(this.mUpgradePercent);
        dest.writeInt(this.mUpgradeFinishStatus);
        dest.writeInt(this.melodyUpgradeStatus);
        dest.writeInt(this.melodyUpgradeType);
    }

    public FirmwareUpgradeStateDTO(UpgradeStateInfo upgradeStateInfo, int i10, int i11) {
        this(upgradeStateInfo != null ? upgradeStateInfo.mUpgradeState : 0, upgradeStateInfo != null ? upgradeStateInfo.mUpgradePercent : 0, upgradeStateInfo != null ? upgradeStateInfo.mUpgradeFinishStatus : 0, i10, i11);
    }
}
