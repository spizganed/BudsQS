package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DebugFeatureInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<DebugFeatureInfo> CREATOR = new a();
    public static final int DEBUG_FEATURE_MIN_LENGTH = 2;
    private String mAddress;
    private List<DebugModuleInfo> mModuleList;
    private int mStatus;
    private int mType;

    public class a implements Parcelable.Creator<DebugFeatureInfo> {
        @Override // android.os.Parcelable.Creator
        public final DebugFeatureInfo createFromParcel(Parcel parcel) {
            return new DebugFeatureInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final DebugFeatureInfo[] newArray(int i10) {
            return new DebugFeatureInfo[i10];
        }
    }

    public DebugFeatureInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public List<DebugModuleInfo> getDebugModuleList() {
        return this.mModuleList;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int getType() {
        return this.mType;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setDebugModuleList(List<DebugModuleInfo> list) {
        this.mModuleList = list;
    }

    public void setStatus(int i10) {
        this.mStatus = i10;
    }

    public void setType(int i10) {
        this.mType = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mAddress);
        parcel.writeInt(this.mStatus);
        parcel.writeInt(this.mType);
        parcel.writeTypedList(this.mModuleList);
    }

    public DebugFeatureInfo(Parcel parcel) {
        this.mAddress = parcel.readString();
        this.mStatus = parcel.readInt();
        this.mType = parcel.readInt();
        this.mModuleList = parcel.createTypedArrayList(DebugModuleInfo.CREATOR);
    }
}
