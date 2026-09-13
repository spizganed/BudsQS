package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class EqualizerModeInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<EqualizerModeInfo> CREATOR = new a();
    private static final int OFFSET_TYPE = 0;
    private int mEqualizerModeType;

    public class a implements Parcelable.Creator<EqualizerModeInfo> {
        @Override // android.os.Parcelable.Creator
        public final EqualizerModeInfo createFromParcel(Parcel parcel) {
            return new EqualizerModeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final EqualizerModeInfo[] newArray(int i10) {
            return new EqualizerModeInfo[i10];
        }
    }

    public EqualizerModeInfo(int i10, byte[] bArr) {
        this.mEqualizerModeType = bArr[i10];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEqualizerModeType() {
        return this.mEqualizerModeType;
    }

    public void setEqualizerModeType(int i10) {
        this.mEqualizerModeType = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mEqualizerModeType);
    }

    public EqualizerModeInfo(int i10) {
        this.mEqualizerModeType = i10;
    }

    public EqualizerModeInfo(Parcel parcel) {
        this.mEqualizerModeType = parcel.readInt();
    }
}
