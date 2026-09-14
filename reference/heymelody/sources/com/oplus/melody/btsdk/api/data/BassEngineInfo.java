package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class BassEngineInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<BassEngineInfo> CREATOR = new a();
    private int mCurrentValue;
    private int mMaxValue;
    private int mMinValue;

    public class a implements Parcelable.Creator<BassEngineInfo> {
        @Override // android.os.Parcelable.Creator
        public final BassEngineInfo createFromParcel(Parcel parcel) {
            return new BassEngineInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final BassEngineInfo[] newArray(int i10) {
            return new BassEngineInfo[i10];
        }
    }

    public BassEngineInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCurrentValue() {
        return this.mCurrentValue;
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public int getMinValue() {
        return this.mMinValue;
    }

    public void readFromParcel(Parcel parcel) {
        this.mMinValue = parcel.readInt();
        this.mMaxValue = parcel.readInt();
        this.mCurrentValue = parcel.readInt();
    }

    public void setCurrentValue(int i10) {
        this.mCurrentValue = i10;
    }

    public void setMaxValue(int i10) {
        this.mMaxValue = i10;
    }

    public void setMinValue(int i10) {
        this.mMinValue = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mMinValue);
        parcel.writeInt(this.mMaxValue);
        parcel.writeInt(this.mCurrentValue);
    }

    public BassEngineInfo(Parcel parcel) {
        this.mMinValue = parcel.readInt();
        this.mMaxValue = parcel.readInt();
        this.mCurrentValue = parcel.readInt();
    }
}
