package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class EarTone extends com.oplus.melody.common.data.a implements Parcelable {
    public static final int CRC_OFFSET = 4;
    public static final Parcelable.Creator<EarTone> CREATOR = new a();
    public static final int ID_OFFSET = 4;
    public static final int SELECT_OFFSET = 1;
    public static final int SIZE_OFFSET = 1;
    public static final int STATUS_OFFSET = 1;
    private static final String TAG = "EarTone";
    private int mCrc;
    private int mId;
    private int mIsSelect;
    private String mName;
    private int mVaild;

    public class a implements Parcelable.Creator<EarTone> {
        @Override // android.os.Parcelable.Creator
        public final EarTone createFromParcel(Parcel parcel) {
            return new EarTone(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final EarTone[] newArray(int i10) {
            return new EarTone[i10];
        }
    }

    public EarTone() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCrc() {
        return this.mCrc;
    }

    public int getId() {
        return this.mId;
    }

    public int getIsSelect() {
        return this.mIsSelect;
    }

    public String getName() {
        return this.mName;
    }

    public int isVaild() {
        return this.mVaild;
    }

    public void setCrc(int i10) {
        this.mCrc = i10;
    }

    public void setId(int i10) {
        this.mId = i10;
    }

    public void setIsSelect(int i10) {
        this.mIsSelect = i10;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setVaild(int i10) {
        this.mVaild = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mId);
        parcel.writeInt(this.mVaild);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIsSelect);
        parcel.writeInt(this.mCrc);
    }

    public EarTone(int i10, int i11, String str, int i12, int i13) {
        this.mId = i10;
        this.mVaild = i11;
        this.mName = str;
        this.mCrc = i12;
        this.mIsSelect = i13;
    }

    public EarTone(Parcel parcel) {
        this.mId = parcel.readInt();
        this.mVaild = parcel.readInt();
        this.mName = parcel.readString();
        this.mIsSelect = parcel.readInt();
        this.mCrc = parcel.readInt();
    }
}
