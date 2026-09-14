package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class EqInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<EqInfo> CREATOR = new a();
    private static final int FIX_SETCOMMAND_BYTE_LENGTH = 5;
    private int[] mDbValue;
    private int mEqId;
    private int[] mFrequency;
    private int mIsSelected;
    private int mMaxValue;
    private int mMinValue;
    private String mName;
    private int mNameLength;

    public class a implements Parcelable.Creator<EqInfo> {
        @Override // android.os.Parcelable.Creator
        public final EqInfo createFromParcel(Parcel parcel) {
            return new EqInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final EqInfo[] newArray(int i10) {
            return new EqInfo[i10];
        }
    }

    public EqInfo() {
        this.mNameLength = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int[] getDbValue() {
        return this.mDbValue;
    }

    public int getEqId() {
        return this.mEqId;
    }

    public int[] getFrequency() {
        return this.mFrequency;
    }

    public int getIsSelected() {
        return this.mIsSelected;
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public int getMinValue() {
        return this.mMinValue;
    }

    public String getName() {
        return this.mName;
    }

    public int getNameLength() {
        return this.mNameLength;
    }

    public int getSetCommandByteLength() {
        int[] iArr = this.mFrequency;
        int length = iArr != null ? iArr.length * 2 : 0;
        int[] iArr2 = this.mDbValue;
        int length2 = iArr2 != null ? iArr2.length : 0;
        this.mNameLength = 0;
        if (!TextUtils.isEmpty(this.mName)) {
            this.mNameLength = this.mName.getBytes(StandardCharsets.UTF_8).length;
        }
        return this.mNameLength + 5 + length + length2;
    }

    public void setDbValue(int[] iArr) {
        this.mDbValue = iArr;
    }

    public void setEqId(int i10) {
        this.mEqId = i10;
    }

    public void setFrequency(int[] iArr) {
        this.mFrequency = iArr;
    }

    public void setIsSelected(int i10) {
        this.mIsSelected = i10;
    }

    public void setMaxValue(int i10) {
        this.mMaxValue = i10;
    }

    public void setMinValue(int i10) {
        this.mMinValue = i10;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setNameLength(int i10) {
        this.mNameLength = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mIsSelected);
        parcel.writeInt(this.mMinValue);
        parcel.writeInt(this.mMaxValue);
        parcel.writeInt(this.mEqId);
        parcel.writeInt(this.mNameLength);
        parcel.writeString(this.mName);
        parcel.writeIntArray(this.mFrequency);
        parcel.writeIntArray(this.mDbValue);
    }

    public EqInfo(Parcel parcel) {
        this.mNameLength = 0;
        this.mIsSelected = parcel.readInt();
        this.mMinValue = parcel.readInt();
        this.mMaxValue = parcel.readInt();
        this.mEqId = parcel.readInt();
        this.mNameLength = parcel.readInt();
        this.mName = parcel.readString();
        this.mFrequency = parcel.createIntArray();
        this.mDbValue = parcel.createIntArray();
    }
}
