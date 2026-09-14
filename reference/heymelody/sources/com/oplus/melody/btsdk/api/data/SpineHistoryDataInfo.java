package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class SpineHistoryDataInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<SpineHistoryDataInfo> CREATOR = new a();
    public int mBadTimes;
    public int mMildTimes;
    public int mNormalTimes;
    public int mUnknowns;
    public int mUtcTime;

    public class a implements Parcelable.Creator<SpineHistoryDataInfo> {
        @Override // android.os.Parcelable.Creator
        public final SpineHistoryDataInfo createFromParcel(Parcel parcel) {
            return new SpineHistoryDataInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final SpineHistoryDataInfo[] newArray(int i10) {
            return new SpineHistoryDataInfo[i10];
        }
    }

    public SpineHistoryDataInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.mUtcTime = parcel.readInt();
        this.mNormalTimes = parcel.readInt();
        this.mMildTimes = parcel.readInt();
        this.mBadTimes = parcel.readInt();
        this.mUnknowns = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mUtcTime);
        parcel.writeInt(this.mNormalTimes);
        parcel.writeInt(this.mMildTimes);
        parcel.writeInt(this.mBadTimes);
        parcel.writeInt(this.mUnknowns);
    }

    public SpineHistoryDataInfo(Parcel parcel) {
        this.mUtcTime = parcel.readInt();
        this.mNormalTimes = parcel.readInt();
        this.mMildTimes = parcel.readInt();
        this.mBadTimes = parcel.readInt();
        this.mUnknowns = parcel.readInt();
    }
}
