package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class HearingStatusInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<HearingStatusInfo> CREATOR = new a();
    private String mAddress;
    private int mHearingType;
    private int mStatus;

    public class a implements Parcelable.Creator<HearingStatusInfo> {
        @Override // android.os.Parcelable.Creator
        public final HearingStatusInfo createFromParcel(Parcel parcel) {
            return new HearingStatusInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final HearingStatusInfo[] newArray(int i10) {
            return new HearingStatusInfo[i10];
        }
    }

    public HearingStatusInfo() {
        this.mStatus = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getHearingType() {
        return this.mHearingType;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setHearingType(int i10) {
        this.mHearingType = i10;
    }

    public void setStatus(int i10) {
        this.mStatus = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mAddress);
        parcel.writeInt(this.mHearingType);
        parcel.writeInt(this.mStatus);
    }

    public HearingStatusInfo(Parcel parcel) {
        this.mStatus = 0;
        this.mAddress = parcel.readString();
        this.mHearingType = parcel.readInt();
        this.mStatus = parcel.readInt();
    }
}
