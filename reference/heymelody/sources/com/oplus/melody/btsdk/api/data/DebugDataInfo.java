package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class DebugDataInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<DebugDataInfo> CREATOR = new a();
    private static final String TAG = "DebugDataInfo";
    private byte[] mData;
    private int mDataLength;
    private int mStatus;
    private int mType;

    public class a implements Parcelable.Creator<DebugDataInfo> {
        @Override // android.os.Parcelable.Creator
        public final DebugDataInfo createFromParcel(Parcel parcel) {
            return new DebugDataInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final DebugDataInfo[] newArray(int i10) {
            return new DebugDataInfo[i10];
        }
    }

    public DebugDataInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.mData;
    }

    public int getDataLength() {
        return this.mDataLength;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int getType() {
        return this.mType;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public void setDataLength(int i10) {
        this.mDataLength = i10;
    }

    public void setStatus(int i10) {
        this.mStatus = i10;
    }

    public void setType(int i10) {
        this.mType = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mStatus);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mDataLength);
        parcel.writeByteArray(this.mData);
    }

    public DebugDataInfo(Parcel parcel) {
        this.mStatus = parcel.readInt();
        this.mType = parcel.readInt();
        this.mDataLength = parcel.readInt();
        this.mData = parcel.createByteArray();
    }
}
