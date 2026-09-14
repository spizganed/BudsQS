package com.oplus.melody.btsdk.api.data;

import D5.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.common.util.A;
import z7.C1725a;

/* JADX INFO: loaded from: classes.dex */
public class NoiseReductionInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<NoiseReductionInfo> CREATOR = new a();
    private static final String TAG = "NoiseReductionInfo";
    private int mAction;
    private int mType;
    private int mValue;

    public class a implements Parcelable.Creator<NoiseReductionInfo> {
        @Override // android.os.Parcelable.Creator
        public final NoiseReductionInfo createFromParcel(Parcel parcel) {
            return new NoiseReductionInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final NoiseReductionInfo[] newArray(int i10) {
            return new NoiseReductionInfo[i10];
        }
    }

    public NoiseReductionInfo(int i10, byte[] bArr) {
        int i11 = i10 + 1;
        this.mAction = bArr[i10];
        int i12 = i10 + 2;
        this.mType = bArr[i11];
        if (i12 < bArr.length) {
            this.mValue = c.p(bArr, i12, Math.min(4, bArr.length - i12), true);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAction() {
        return this.mAction;
    }

    public byte[] getData() {
        int i10 = this.mValue;
        int i11 = 4;
        while (true) {
            if (i11 <= 1) {
                i11 = 1;
                break;
            }
            if (((255 << ((i11 - 1) * 8)) & i10) != 0) {
                break;
            }
            i11--;
        }
        int i12 = i11 + 2;
        byte[] bArr = new byte[i12];
        bArr[0] = (byte) this.mAction;
        bArr[1] = (byte) this.mType;
        c.i(this.mValue, 2, i11, bArr);
        A.a aVar = C1725a.f29476a;
        if (A.l()) {
            C1725a.a(TAG, "getData type=" + this.mType + " dataLength=" + i12);
        }
        return bArr;
    }

    public int getType() {
        return this.mType;
    }

    public int getValue() {
        return this.mValue;
    }

    public void setAction(int i10) {
        this.mAction = i10;
    }

    public void setType(int i10) {
        this.mType = i10;
    }

    public void setValue(int i10) {
        this.mValue = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mAction);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mValue);
    }

    public NoiseReductionInfo() {
    }

    public NoiseReductionInfo(Parcel parcel) {
        this.mAction = parcel.readInt();
        this.mType = parcel.readInt();
        this.mValue = parcel.readInt();
    }
}
