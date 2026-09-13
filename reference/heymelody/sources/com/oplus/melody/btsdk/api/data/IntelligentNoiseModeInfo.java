package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class IntelligentNoiseModeInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<IntelligentNoiseModeInfo> CREATOR = new a();
    private static final int INIT_BYTE_LENGTH = 1;
    private static final int OFFSET_TYPE = 0;
    private static final int OFFSET_VALUE = 1;
    private boolean[] mOpenNoiseReductionMode;
    private int mType;

    public class a implements Parcelable.Creator<IntelligentNoiseModeInfo> {
        @Override // android.os.Parcelable.Creator
        public final IntelligentNoiseModeInfo createFromParcel(Parcel parcel) {
            return new IntelligentNoiseModeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final IntelligentNoiseModeInfo[] newArray(int i10) {
            return new IntelligentNoiseModeInfo[i10];
        }
    }

    public IntelligentNoiseModeInfo(int i10, byte[] bArr) {
        this.mOpenNoiseReductionMode = new boolean[8];
        byte b4 = bArr[i10];
        this.mType = b4;
        if (b4 == 1) {
            int length = (bArr.length - i10) - 1;
            int i11 = length * 8;
            this.mOpenNoiseReductionMode = new boolean[i11];
            int i12 = i10 + 1;
            byte b5 = bArr[i12];
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                this.mOpenNoiseReductionMode[i15] = ((1 << i13) & b5) != 0;
                i13++;
                if (i13 == 8) {
                    i14++;
                    b5 = i14 < length ? bArr[i12 + i14] : b5;
                    i13 = 0;
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCurrentNoiseReductionModeIndex() {
        int i10 = 0;
        while (true) {
            boolean[] zArr = this.mOpenNoiseReductionMode;
            if (i10 >= zArr.length) {
                return -1;
            }
            if (zArr[i10]) {
                return i10;
            }
            i10++;
        }
    }

    public int getType() {
        return this.mType;
    }

    public boolean isNoiseReductionModeOpened(int i10) {
        boolean[] zArr = this.mOpenNoiseReductionMode;
        if (i10 >= zArr.length) {
            return false;
        }
        return zArr[i10];
    }

    public void readFromParcel(Parcel parcel) {
        this.mType = parcel.readInt();
        this.mOpenNoiseReductionMode = parcel.createBooleanArray();
    }

    public void setType(int i10) {
        this.mType = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mType);
        parcel.writeBooleanArray(this.mOpenNoiseReductionMode);
    }

    public IntelligentNoiseModeInfo() {
        this.mOpenNoiseReductionMode = new boolean[8];
    }

    public IntelligentNoiseModeInfo(Parcel parcel) {
        this.mOpenNoiseReductionMode = new boolean[8];
        this.mType = parcel.readInt();
        this.mOpenNoiseReductionMode = parcel.createBooleanArray();
    }
}
