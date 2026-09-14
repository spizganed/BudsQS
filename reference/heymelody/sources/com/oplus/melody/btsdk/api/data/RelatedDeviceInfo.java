package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RelatedDeviceInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<RelatedDeviceInfo> CREATOR = new a();
    public static final int RELATED_INFO_HOST_MAC_LEN = 6;
    public static final int RELATED_INFO_HOST_TYPE_LEN = 1;
    private String mHostAddress;
    private int mHostType;
    private final List<RelatedDevice> mRelatedDevices;

    public class a implements Parcelable.Creator<RelatedDeviceInfo> {
        @Override // android.os.Parcelable.Creator
        public final RelatedDeviceInfo createFromParcel(Parcel parcel) {
            return new RelatedDeviceInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final RelatedDeviceInfo[] newArray(int i10) {
            return new RelatedDeviceInfo[i10];
        }
    }

    public RelatedDeviceInfo() {
        this.mRelatedDevices = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getHostAddress() {
        return this.mHostAddress;
    }

    public int getHostType() {
        return this.mHostType;
    }

    public List<RelatedDevice> getRelatedDevices() {
        return this.mRelatedDevices;
    }

    public void setHostAddress(String str) {
        this.mHostAddress = str;
    }

    public void setHostType(int i10) {
        this.mHostType = i10;
    }

    public void setRelatedDevices(List<RelatedDevice> list) {
        this.mRelatedDevices.clear();
        this.mRelatedDevices.addAll(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mHostAddress);
        parcel.writeInt(this.mHostType);
        parcel.writeTypedList(this.mRelatedDevices);
    }

    public RelatedDeviceInfo(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.mRelatedDevices = arrayList;
        this.mHostAddress = parcel.readString();
        this.mHostType = parcel.readInt();
        parcel.readTypedList(arrayList, RelatedDevice.CREATOR);
    }
}
