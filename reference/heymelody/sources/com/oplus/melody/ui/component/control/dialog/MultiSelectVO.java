package com.oplus.melody.ui.component.control.dialog;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MultiSelectVO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<MultiSelectVO> CREATOR = new a();
    private int mAction;
    private boolean mCacheTips;
    private int mChooseMode;
    private String mChooseValue;
    private List<String> mChooseValueList;
    private List<String> mEntries;
    private List<String> mEntryLongPressTypes;
    private List<String> mEntrySummaries;
    private List<String> mEntryValues;
    private int mMinimumChooseCount;
    private int mNegativeResId;
    private int mPositiveResId;
    private String mProductId;
    private String mTipValue;
    private int mTitleResId;

    public class a implements Parcelable.Creator<MultiSelectVO> {
        @Override // android.os.Parcelable.Creator
        public final MultiSelectVO createFromParcel(Parcel parcel) {
            return new MultiSelectVO(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final MultiSelectVO[] newArray(int i10) {
            return new MultiSelectVO[i10];
        }
    }

    public MultiSelectVO() {
        this.mTitleResId = -1;
        this.mPositiveResId = -1;
        this.mNegativeResId = -1;
        this.mChooseMode = 1;
        this.mMinimumChooseCount = 1;
        this.mAction = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAction() {
        return this.mAction;
    }

    public int getChooseMode() {
        return this.mChooseMode;
    }

    public String getChooseValue() {
        return this.mChooseValue;
    }

    public List<String> getChooseValueList() {
        return this.mChooseValueList;
    }

    public List<String> getEntries() {
        return this.mEntries;
    }

    public List<String> getEntryLongPressTypes() {
        return this.mEntryLongPressTypes;
    }

    public List<String> getEntrySummaries() {
        return this.mEntrySummaries;
    }

    public List<String> getEntryValues() {
        return this.mEntryValues;
    }

    public int getMinimumChooseCount() {
        return this.mMinimumChooseCount;
    }

    public int getNegativeResId() {
        return this.mNegativeResId;
    }

    public int getPositiveResId() {
        return this.mPositiveResId;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public String getTipValue() {
        return this.mTipValue;
    }

    public int getTitleResId() {
        return this.mTitleResId;
    }

    public boolean isCacheTips() {
        return this.mCacheTips;
    }

    public void setAction(int i10) {
        this.mAction = i10;
    }

    public void setCacheTips(boolean z2) {
        this.mCacheTips = z2;
    }

    public void setChooseMode(int i10) {
        this.mChooseMode = i10;
    }

    public void setChooseValue(String str) {
        this.mChooseValue = str;
    }

    public void setChooseValueList(List<String> list) {
        this.mChooseValueList = list;
    }

    public void setEntries(List<String> list) {
        this.mEntries = list;
    }

    public void setEntryLongPressTypes(List<String> list) {
        this.mEntryLongPressTypes = list;
    }

    public void setEntrySummaries(List<String> list) {
        this.mEntrySummaries = list;
    }

    public void setEntryValues(List<String> list) {
        this.mEntryValues = list;
    }

    public void setMinimumChooseCount(int i10) {
        this.mMinimumChooseCount = i10;
    }

    public void setNegativeResId(int i10) {
        this.mNegativeResId = i10;
    }

    public void setPositiveResId(int i10) {
        this.mPositiveResId = i10;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public void setTipValue(String str) {
        this.mTipValue = str;
    }

    public void setTitleResId(int i10) {
        this.mTitleResId = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.mChooseValueList);
        parcel.writeString(this.mTipValue);
        parcel.writeString(this.mChooseValue);
        parcel.writeByte(this.mCacheTips ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.mEntries);
        parcel.writeStringList(this.mEntryValues);
        parcel.writeStringList(this.mEntrySummaries);
        parcel.writeStringList(this.mEntryLongPressTypes);
        parcel.writeInt(this.mTitleResId);
        parcel.writeInt(this.mPositiveResId);
        parcel.writeInt(this.mNegativeResId);
        parcel.writeInt(this.mChooseMode);
        parcel.writeString(this.mProductId);
        parcel.writeInt(this.mMinimumChooseCount);
        parcel.writeInt(this.mAction);
    }

    public MultiSelectVO(Parcel parcel) {
        this.mTitleResId = -1;
        this.mPositiveResId = -1;
        this.mNegativeResId = -1;
        this.mChooseMode = 1;
        this.mMinimumChooseCount = 1;
        this.mAction = 0;
        this.mChooseValueList = parcel.createStringArrayList();
        this.mTipValue = parcel.readString();
        this.mChooseValue = parcel.readString();
        this.mCacheTips = parcel.readByte() != 0;
        this.mEntries = parcel.createStringArrayList();
        this.mEntryValues = parcel.createStringArrayList();
        this.mEntrySummaries = parcel.createStringArrayList();
        this.mEntryLongPressTypes = parcel.createStringArrayList();
        this.mTitleResId = parcel.readInt();
        this.mPositiveResId = parcel.readInt();
        this.mNegativeResId = parcel.readInt();
        this.mChooseMode = parcel.readInt();
        this.mProductId = parcel.readString();
        this.mMinimumChooseCount = parcel.readInt();
        this.mAction = parcel.readInt();
    }
}
