package com.oplus.melody.btsdk.api.data;

import D5.c;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class EarRestoreDataInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<EarRestoreDataInfo> CREATOR = new a();
    private static final int FASTEN_LENGTH = 3;
    private byte[] mData;
    private int mDataLength;
    private int mRestoreDataType;

    public class a implements Parcelable.Creator<EarRestoreDataInfo> {
        @Override // android.os.Parcelable.Creator
        public final EarRestoreDataInfo createFromParcel(Parcel parcel) {
            return new EarRestoreDataInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final EarRestoreDataInfo[] newArray(int i10) {
            return new EarRestoreDataInfo[i10];
        }
    }

    public EarRestoreDataInfo(int i10, int i11, byte[] bArr) {
        this.mRestoreDataType = i10;
        this.mDataLength = i11;
        this.mData = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.mData;
    }

    public int getDataByteLength() {
        byte[] bArr = this.mData;
        if (bArr == null || bArr.length == 0) {
            return 0;
        }
        return bArr.length + 3;
    }

    public byte[] getDataBytes() {
        byte[] bArr = this.mData;
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 3);
        byteBufferAllocate.put((byte) this.mRestoreDataType);
        byte[] bArr2 = new byte[2];
        c.i((short) this.mDataLength, 0, 2, bArr2);
        byteBufferAllocate.put(bArr2);
        byteBufferAllocate.put(this.mData);
        return byteBufferAllocate.array();
    }

    public int getDataLength() {
        return this.mDataLength;
    }

    public int getRestoreDataType() {
        return this.mRestoreDataType;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public void setDataLength(int i10) {
        this.mDataLength = i10;
    }

    public void setRestoreDataType(int i10) {
        this.mRestoreDataType = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mRestoreDataType);
        parcel.writeInt(this.mDataLength);
        parcel.writeByteArray(this.mData);
    }

    public EarRestoreDataInfo(Parcel parcel) {
        this.mRestoreDataType = parcel.readInt();
        this.mDataLength = parcel.readInt();
        this.mData = parcel.createByteArray();
    }
}
