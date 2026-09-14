package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class HeadsetTipInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<HeadsetTipInfo> CREATOR = new a();
    private String mAddress;
    private int mType;

    public class a implements Parcelable.Creator<HeadsetTipInfo> {
        @Override // android.os.Parcelable.Creator
        public final HeadsetTipInfo createFromParcel(Parcel parcel) {
            return new HeadsetTipInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final HeadsetTipInfo[] newArray(int i10) {
            return new HeadsetTipInfo[i10];
        }
    }

    public HeadsetTipInfo(String str, int i10) {
        this.mAddress = str;
        this.mType = i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getType() {
        return this.mType;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setType(int i10) {
        this.mType = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mAddress);
        parcel.writeInt(this.mType);
    }

    public HeadsetTipInfo(Parcel parcel) {
        this.mAddress = parcel.readString();
        this.mType = parcel.readInt();
    }
}
