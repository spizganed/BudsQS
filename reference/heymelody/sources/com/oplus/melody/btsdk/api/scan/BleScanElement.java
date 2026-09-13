package com.oplus.melody.btsdk.api.scan;

import D7.C0391z;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class BleScanElement extends ScanElement implements Parcelable {
    public static final Parcelable.Creator<BleScanElement> CREATOR = new a();
    public static final int DEVICE_IN_BONDED_STATE = 2;
    public static final int DEVICE_IN_OPEN_STATE = 0;
    public static final int DEVICE_IN_PAIR_STATE = 1;
    public static final int EARBUDS_BOX_MASK = 1;
    public int mBatteryStatus;
    public int mColor;
    public int mEarbudsStatus;
    public int mFlag;
    public boolean mIsSupportEarBudsStatus;
    public String mMacAddress;
    public String mName;
    public int mProductId;
    public int mRssi;
    public int mState;
    public int mType;

    public class a implements Parcelable.Creator<BleScanElement> {
        @Override // android.os.Parcelable.Creator
        public final BleScanElement createFromParcel(Parcel parcel) {
            return new BleScanElement(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final BleScanElement[] newArray(int i10) {
            return new BleScanElement[i10];
        }
    }

    public BleScanElement() {
        this.mFlag = -1;
        this.mType = -1;
        this.mState = -1;
        this.mProductId = 0;
        this.mColor = -1;
    }

    @Override // com.oplus.melody.btsdk.api.scan.ScanElement, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isBoxClose() {
        String strF = this.mName;
        if (TextUtils.isEmpty(strF)) {
            strF = C0391z.f1171d.f(this.mDevice);
        }
        return (strF == null || !strF.contains("OnePlus")) && this.mIsSupportEarBudsStatus && (this.mEarbudsStatus & 1) == 0;
    }

    @Override // com.oplus.melody.btsdk.api.scan.ScanElement, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.mFlag);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mState);
        parcel.writeInt(this.mProductId);
        parcel.writeInt(this.mColor);
        parcel.writeByte(this.mIsSupportEarBudsStatus ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mEarbudsStatus);
        parcel.writeInt(this.mBatteryStatus);
        parcel.writeInt(this.mRssi);
        parcel.writeString(this.mMacAddress);
        parcel.writeString(this.mName);
    }

    public BleScanElement(Parcel parcel) {
        super(parcel);
        this.mFlag = -1;
        this.mType = -1;
        this.mState = -1;
        this.mProductId = 0;
        this.mColor = -1;
        this.mFlag = parcel.readInt();
        this.mType = parcel.readInt();
        this.mState = parcel.readInt();
        this.mProductId = parcel.readInt();
        this.mColor = parcel.readInt();
        this.mIsSupportEarBudsStatus = parcel.readByte() != 0;
        this.mEarbudsStatus = parcel.readInt();
        this.mBatteryStatus = parcel.readInt();
        this.mRssi = parcel.readInt();
        this.mMacAddress = parcel.readString();
        this.mName = parcel.readString();
    }
}
