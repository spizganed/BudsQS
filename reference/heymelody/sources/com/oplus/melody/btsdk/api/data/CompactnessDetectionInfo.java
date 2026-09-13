package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class CompactnessDetectionInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<CompactnessDetectionInfo> CREATOR = new a();
    public static final int LENGTH_COMPACTNESS_DETECTION_EVENT_INFO = 4;
    public static final int LENGTH_COMPACTNESS_DETECTION_SINGLE_INFO = 2;
    private static final int OFFSET_DETECTION_STATUS = 1;
    private static final int OFFSET_DEVICE_TYPE = 0;
    private int mCompactStatus;
    private int mDeviceType;

    public class a implements Parcelable.Creator<CompactnessDetectionInfo> {
        @Override // android.os.Parcelable.Creator
        public final CompactnessDetectionInfo createFromParcel(Parcel parcel) {
            return new CompactnessDetectionInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final CompactnessDetectionInfo[] newArray(int i10) {
            return new CompactnessDetectionInfo[i10];
        }
    }

    public CompactnessDetectionInfo(int i10, byte[] bArr) {
        this.mDeviceType = bArr[i10];
        this.mCompactStatus = bArr[i10 + 1];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCompactStatus() {
        return this.mCompactStatus;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public void setCompactStatus(int i10) {
        this.mCompactStatus = i10;
    }

    public void setDeviceType(int i10) {
        this.mDeviceType = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mDeviceType);
        parcel.writeInt(this.mCompactStatus);
    }

    public CompactnessDetectionInfo(Parcel parcel) {
        this.mDeviceType = parcel.readInt();
        this.mCompactStatus = parcel.readInt();
    }
}
