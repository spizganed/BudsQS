package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class UpgradeStateInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<UpgradeStateInfo> CREATOR = new a();
    public String mAddress;
    public int mUpgradeFinishStatus;
    public int mUpgradePercent;
    public int mUpgradeState;

    public class a implements Parcelable.Creator<UpgradeStateInfo> {
        @Override // android.os.Parcelable.Creator
        public final UpgradeStateInfo createFromParcel(Parcel parcel) {
            return new UpgradeStateInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final UpgradeStateInfo[] newArray(int i10) {
            return new UpgradeStateInfo[i10];
        }
    }

    public UpgradeStateInfo() {
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

    public UpgradeStateInfo(Parcel parcel) {
        this.mAddress = parcel.readString();
        this.mUpgradeState = parcel.readInt();
        this.mUpgradePercent = parcel.readInt();
        this.mUpgradeFinishStatus = parcel.readInt();
    }
}
