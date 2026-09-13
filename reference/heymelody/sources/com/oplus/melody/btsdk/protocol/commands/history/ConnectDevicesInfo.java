package com.oplus.melody.btsdk.protocol.commands.history;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ConnectDevicesInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<ConnectDevicesInfo> CREATOR = new a();
    private String mAddress;
    private List<ConnectDevice> mConnectDeviceList;

    public class a implements Parcelable.Creator<ConnectDevicesInfo> {
        @Override // android.os.Parcelable.Creator
        public final ConnectDevicesInfo createFromParcel(Parcel parcel) {
            return new ConnectDevicesInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ConnectDevicesInfo[] newArray(int i10) {
            return new ConnectDevicesInfo[i10];
        }
    }

    public ConnectDevicesInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public List<ConnectDevice> getConnectDeviceList() {
        return this.mConnectDeviceList;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setList(List<ConnectDevice> list) {
        this.mConnectDeviceList = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mAddress);
        parcel.writeTypedList(this.mConnectDeviceList);
    }

    public ConnectDevicesInfo(Parcel parcel) {
        this.mAddress = parcel.readString();
        this.mConnectDeviceList = parcel.createTypedArrayList(ConnectDevice.CREATOR);
    }
}
