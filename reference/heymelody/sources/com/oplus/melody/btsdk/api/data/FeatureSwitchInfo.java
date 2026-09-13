package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class FeatureSwitchInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<FeatureSwitchInfo> CREATOR = new a();
    public static final int LENGTH_FEATURE_SWITCH_ITEM = 2;
    private int mFeatureType;
    private int mStatus;

    public class a implements Parcelable.Creator<FeatureSwitchInfo> {
        @Override // android.os.Parcelable.Creator
        public final FeatureSwitchInfo createFromParcel(Parcel parcel) {
            return new FeatureSwitchInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureSwitchInfo[] newArray(int i10) {
            return new FeatureSwitchInfo[i10];
        }
    }

    public FeatureSwitchInfo(int i10, byte[] bArr) {
        this.mFeatureType = bArr[i10];
        this.mStatus = bArr[i10 + 1];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFeatureType() {
        return this.mFeatureType;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setFeatureType(int i10) {
        this.mFeatureType = i10;
    }

    public void setStatus(int i10) {
        this.mStatus = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mFeatureType);
        parcel.writeInt(this.mStatus);
    }

    public FeatureSwitchInfo(int i10, int i11) {
        this.mFeatureType = i10;
        this.mStatus = i11;
    }

    public FeatureSwitchInfo(Parcel parcel) {
        this.mFeatureType = parcel.readInt();
        this.mStatus = parcel.readInt();
    }
}
