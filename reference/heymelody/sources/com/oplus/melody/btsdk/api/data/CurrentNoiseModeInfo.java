package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CurrentNoiseModeInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<CurrentNoiseModeInfo> CREATOR = new a();
    private static final int INIT_BYTE_LENGTH = 1;
    private static final int NOISE_REDUCTION_DSP_LENGTH = 3;
    private static final int OFFSET_TYPE = 0;
    private static final int OFFSET_VALUE = 1;
    private int mLevel;
    private byte[] mMode;
    private boolean[] mOpenNoiseReductionMode;
    private int mType;

    public class a implements Parcelable.Creator<CurrentNoiseModeInfo> {
        @Override // android.os.Parcelable.Creator
        public final CurrentNoiseModeInfo createFromParcel(Parcel parcel) {
            return new CurrentNoiseModeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final CurrentNoiseModeInfo[] newArray(int i10) {
            return new CurrentNoiseModeInfo[i10];
        }
    }

    public CurrentNoiseModeInfo(int i10, byte[] bArr) {
        this.mOpenNoiseReductionMode = new boolean[8];
        byte b4 = bArr[i10];
        this.mType = b4;
        if (b4 != 1) {
            if (b4 == 2) {
                this.mLevel = bArr[i10 + 1];
                return;
            }
            return;
        }
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

    private void growArray(int i10) {
        this.mOpenNoiseReductionMode = Arrays.copyOf(this.mOpenNoiseReductionMode, ((i10 / 8) + 1) * 8);
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

    public byte[] getData() {
        byte[] bArr = new byte[0];
        int i10 = this.mType;
        if (i10 != 1) {
            return i10 == 2 ? new byte[]{1, (byte) i10, (byte) this.mLevel} : bArr;
        }
        int length = (this.mOpenNoiseReductionMode.length - 1) / 8;
        int i11 = length + 1;
        byte[] bArr2 = new byte[length + 3];
        bArr2[0] = 1;
        bArr2[1] = (byte) i10;
        byte[] bArr3 = new byte[i11];
        int i12 = 0;
        byte b4 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            boolean[] zArr = this.mOpenNoiseReductionMode;
            if (i12 >= zArr.length) {
                System.arraycopy(bArr3, 0, bArr2, 2, i11);
                return bArr2;
            }
            b4 = (byte) (b4 | (zArr[i12] ? 1 << i13 : 0));
            i13++;
            if (i13 == 8) {
                bArr3[i14] = b4;
                i14++;
                b4 = 0;
                i13 = 0;
            }
            i12++;
        }
    }

    public int getLevel() {
        return this.mLevel;
    }

    public byte[] getMode() {
        return this.mMode;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isNoiseReductionModeInfo() {
        return this.mType == 1;
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
        this.mMode = parcel.createByteArray();
        this.mLevel = parcel.readInt();
        this.mOpenNoiseReductionMode = parcel.createBooleanArray();
    }

    public void setCurrentNoiseReductionModeValue(int i10, boolean z2) {
        if (i10 >= this.mOpenNoiseReductionMode.length) {
            growArray(i10);
        }
        this.mOpenNoiseReductionMode[i10] = z2;
    }

    public void setLevel(int i10) {
        this.mLevel = i10;
    }

    public void setMode(byte[] bArr) {
        this.mMode = bArr;
    }

    public void setType(int i10) {
        this.mType = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mType);
        parcel.writeByteArray(this.mMode);
        parcel.writeInt(this.mLevel);
        parcel.writeBooleanArray(this.mOpenNoiseReductionMode);
    }

    public CurrentNoiseModeInfo() {
        this.mOpenNoiseReductionMode = new boolean[8];
    }

    public CurrentNoiseModeInfo(Parcel parcel) {
        this.mOpenNoiseReductionMode = new boolean[8];
        this.mType = parcel.readInt();
        this.mMode = parcel.createByteArray();
        this.mLevel = parcel.readInt();
        this.mOpenNoiseReductionMode = parcel.createBooleanArray();
    }
}
