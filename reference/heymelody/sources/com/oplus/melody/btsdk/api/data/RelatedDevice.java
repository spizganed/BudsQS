package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class RelatedDevice extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<RelatedDevice> CREATOR = new a();
    public static final int MULTI_DEVICE_ACTION_LENGTH = 1;
    public static final int MULTI_DEVICE_NUMBER_LENGTH = 1;
    public static final int RELATED_INFO_DEVICE_ARRAY_LEN = 1;
    public static final int RELATED_INFO_DEVICE_MAC_LEN = 6;
    public static final int RELATED_INFO_DEVICE_MAX_SIZE = 6;
    public static final int RELATED_INFO_DEVICE_STATE_LEN = 1;
    public static final int RELATED_INFO_DEVICE_TYPE_LEN = 1;
    private String mAddress;
    private int mState;
    private int mType;

    public class a implements Parcelable.Creator<RelatedDevice> {
        @Override // android.os.Parcelable.Creator
        public final RelatedDevice createFromParcel(Parcel parcel) {
            return new RelatedDevice(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final RelatedDevice[] newArray(int i10) {
            return new RelatedDevice[i10];
        }
    }

    public RelatedDevice() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getState() {
        return this.mState;
    }

    public int getType() {
        return this.mType;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setState(int i10) {
        this.mState = i10;
    }

    public void setType(int i10) {
        this.mType = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mState);
        parcel.writeString(this.mAddress);
    }

    public RelatedDevice(Parcel parcel) {
        this.mType = parcel.readInt();
        this.mState = parcel.readInt();
        this.mAddress = parcel.readString();
    }
}
