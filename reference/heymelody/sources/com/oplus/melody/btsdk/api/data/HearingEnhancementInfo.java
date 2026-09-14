package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HearingEnhancementInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<HearingEnhancementInfo> CREATOR = new a();
    private String mAddress;
    private long mCreateTime;
    private List<HearingDetectingInfo> mInfoList;
    private String mName;
    private String mUid;

    public class a implements Parcelable.Creator<HearingEnhancementInfo> {
        @Override // android.os.Parcelable.Creator
        public final HearingEnhancementInfo createFromParcel(Parcel parcel) {
            return new HearingEnhancementInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final HearingEnhancementInfo[] newArray(int i10) {
            return new HearingEnhancementInfo[i10];
        }
    }

    public HearingEnhancementInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public List<HearingDetectingInfo> getHearingDetectingInfoList() {
        return this.mInfoList;
    }

    public String getName() {
        return this.mName;
    }

    public String getUid() {
        return this.mUid;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setCreateTime(long j5) {
        this.mCreateTime = j5;
    }

    public void setHearingDetectingInfoList(List<HearingDetectingInfo> list) {
        this.mInfoList = list;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setUid(String str) {
        this.mUid = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mUid);
        parcel.writeString(this.mName);
        parcel.writeString(this.mAddress);
        parcel.writeLong(this.mCreateTime);
        parcel.writeTypedList(this.mInfoList);
    }

    public HearingEnhancementInfo(Parcel parcel) {
        this.mUid = parcel.readString();
        this.mName = parcel.readString();
        this.mAddress = parcel.readString();
        this.mCreateTime = parcel.readLong();
        this.mInfoList = parcel.createTypedArrayList(HearingDetectingInfo.CREATOR);
    }
}
