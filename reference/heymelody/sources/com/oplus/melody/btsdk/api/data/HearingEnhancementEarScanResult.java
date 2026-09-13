package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class HearingEnhancementEarScanResult extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<HearingEnhancementEarScanResult> CREATOR = new a();
    private int mAction;
    private String mAddress;
    private int mDataLength;
    private byte[] mResultData;
    private int mUniqueId;

    public class a implements Parcelable.Creator<HearingEnhancementEarScanResult> {
        @Override // android.os.Parcelable.Creator
        public final HearingEnhancementEarScanResult createFromParcel(Parcel parcel) {
            return new HearingEnhancementEarScanResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final HearingEnhancementEarScanResult[] newArray(int i10) {
            return new HearingEnhancementEarScanResult[i10];
        }
    }

    public HearingEnhancementEarScanResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAction() {
        return this.mAction;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getDataLength() {
        return this.mDataLength;
    }

    public byte[] getResultData() {
        return this.mResultData;
    }

    public int getUniqueId() {
        return this.mUniqueId;
    }

    public void readFromParcel(Parcel parcel) {
        this.mAddress = parcel.readString();
        this.mAction = parcel.readInt();
        this.mDataLength = parcel.readInt();
        this.mUniqueId = parcel.readInt();
        this.mResultData = parcel.createByteArray();
    }

    public void setAction(int i10) {
        this.mAction = i10;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setDataLength(int i10) {
        this.mDataLength = i10;
    }

    public void setResultData(byte[] bArr) {
        this.mResultData = bArr;
    }

    public void setUniqueId(int i10) {
        this.mUniqueId = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mAddress);
        parcel.writeInt(this.mAction);
        parcel.writeInt(this.mDataLength);
        parcel.writeInt(this.mUniqueId);
        parcel.writeByteArray(this.mResultData);
    }

    public HearingEnhancementEarScanResult(Parcel parcel) {
        this.mAddress = parcel.readString();
        this.mAction = parcel.readInt();
        this.mDataLength = parcel.readInt();
        this.mUniqueId = parcel.readInt();
        this.mResultData = parcel.createByteArray();
    }
}
