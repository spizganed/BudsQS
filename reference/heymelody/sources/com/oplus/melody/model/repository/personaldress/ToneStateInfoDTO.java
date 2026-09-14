package com.oplus.melody.model.repository.personaldress;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class ToneStateInfoDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<ToneStateInfoDTO> CREATOR = new a();
    public String mAddress;
    public int mUpgradeFinishStatus;
    public int mUpgradePercent;
    public int mUpgradeState;

    public class a implements Parcelable.Creator<ToneStateInfoDTO> {
        @Override // android.os.Parcelable.Creator
        public final ToneStateInfoDTO createFromParcel(Parcel parcel) {
            return new ToneStateInfoDTO(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ToneStateInfoDTO[] newArray(int i10) {
            return new ToneStateInfoDTO[i10];
        }
    }

    public ToneStateInfoDTO() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mAddress);
        parcel.writeInt(this.mUpgradeState);
        parcel.writeInt(this.mUpgradePercent);
        parcel.writeInt(this.mUpgradeFinishStatus);
    }

    public ToneStateInfoDTO(Parcel parcel) {
        this.mAddress = parcel.readString();
        this.mUpgradeState = parcel.readInt();
        this.mUpgradePercent = parcel.readInt();
        this.mUpgradeFinishStatus = parcel.readInt();
    }
}
