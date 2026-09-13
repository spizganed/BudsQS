package com.oplus.melody.btsdk.protocol.commands.history;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class ConnectDevice extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<ConnectDevice> CREATOR = new a();
    public static final int LENGTH_ADDRESS = 6;
    public static final int LENGTH_CONNECT_TIMES = 2;
    public static final int LENGTH_NAME = -1;
    public static final int LENGTH_NAME_LENGTH = 1;
    private static final String TAG = "ConnectDevice";
    private String mAddress;
    private int mConnectTimes;
    private String mDeviceName;
    private int mNameLen;

    public class a implements Parcelable.Creator<ConnectDevice> {
        @Override // android.os.Parcelable.Creator
        public final ConnectDevice createFromParcel(Parcel parcel) {
            return new ConnectDevice(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ConnectDevice[] newArray(int i10) {
            return new ConnectDevice[i10];
        }
    }

    public ConnectDevice(String str, int i10, byte[] bArr, int i11) {
        this.mAddress = str;
        this.mConnectTimes = i10;
        this.mNameLen = i11;
        this.mDeviceName = new String(bArr, StandardCharsets.UTF_8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getConnectTimes() {
        return this.mConnectTimes;
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public int getNameLen() {
        return this.mNameLen;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setConnectTimes(int i10) {
        this.mConnectTimes = i10;
    }

    public void setDeviceName(String str) {
        this.mDeviceName = str;
    }

    public void setNameLen(int i10) {
        this.mNameLen = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mAddress);
        parcel.writeInt(this.mConnectTimes);
        parcel.writeInt(this.mNameLen);
        parcel.writeString(this.mDeviceName);
    }

    public ConnectDevice(Parcel parcel) {
        this.mAddress = parcel.readString();
        this.mConnectTimes = parcel.readInt();
        this.mNameLen = parcel.readInt();
        this.mDeviceName = parcel.readString();
    }
}
