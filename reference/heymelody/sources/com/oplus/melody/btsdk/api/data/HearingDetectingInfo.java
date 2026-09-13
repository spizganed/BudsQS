package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class HearingDetectingInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final int BYTE_COUNT = 3;
    public static final Parcelable.Creator<HearingDetectingInfo> CREATOR = new a();
    private static final int FREQ_ID_INDEX = 1;
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 2;
    private int mDbValue;
    private int mDeviceType;
    private int mFreqType;

    public class a implements Parcelable.Creator<HearingDetectingInfo> {
        @Override // android.os.Parcelable.Creator
        public final HearingDetectingInfo createFromParcel(Parcel parcel) {
            return new HearingDetectingInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final HearingDetectingInfo[] newArray(int i10) {
            return new HearingDetectingInfo[i10];
        }
    }

    public HearingDetectingInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(3);
        byteBufferAllocate.put((byte) this.mDeviceType);
        byteBufferAllocate.put((byte) this.mFreqType);
        byteBufferAllocate.put((byte) this.mDbValue);
        return byteBufferAllocate.array();
    }

    public int getDbValue() {
        return this.mDbValue;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public int getType() {
        return this.mFreqType;
    }

    public void setDbValue(int i10) {
        this.mDbValue = i10;
    }

    public void setDeviceType(int i10) {
        this.mDeviceType = i10;
    }

    public void setType(int i10) {
        this.mFreqType = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mDeviceType);
        parcel.writeInt(this.mFreqType);
        parcel.writeInt(this.mDbValue);
    }

    public HearingDetectingInfo(int i10, int i11, int i12) {
        this.mDeviceType = i10;
        this.mFreqType = i11;
        this.mDbValue = i12;
    }

    public HearingDetectingInfo(byte[] bArr) {
        this.mDeviceType = bArr[0];
        this.mFreqType = bArr[1];
        this.mDbValue = bArr[2];
    }

    public HearingDetectingInfo(Parcel parcel) {
        this.mDeviceType = parcel.readInt();
        this.mFreqType = parcel.readInt();
        this.mDbValue = parcel.readInt();
    }
}
