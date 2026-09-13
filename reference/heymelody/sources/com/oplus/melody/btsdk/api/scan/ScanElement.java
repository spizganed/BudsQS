package com.oplus.melody.btsdk.api.scan;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ScanElement extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<ScanElement> CREATOR = new a();
    public BluetoothDevice mDevice;

    public class a implements Parcelable.Creator<ScanElement> {
        @Override // android.os.Parcelable.Creator
        public final ScanElement createFromParcel(Parcel parcel) {
            return new ScanElement(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ScanElement[] newArray(int i10) {
            return new ScanElement[i10];
        }
    }

    public ScanElement() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.mDevice, i10);
    }

    public ScanElement(Parcel parcel) {
        this.mDevice = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
    }
}
