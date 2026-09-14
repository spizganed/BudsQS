package com.oplus.melody.btsdk.api.scan;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class BrScanElement extends ScanElement implements Parcelable {
    public static final Parcelable.Creator<BrScanElement> CREATOR = new a();
    public String mMacAddress;
    public int mProductId;
    public int mRssi;

    public class a implements Parcelable.Creator<BrScanElement> {
        @Override // android.os.Parcelable.Creator
        public final BrScanElement createFromParcel(Parcel parcel) {
            return new BrScanElement(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final BrScanElement[] newArray(int i10) {
            return new BrScanElement[i10];
        }
    }

    public BrScanElement() {
        this.mProductId = -1;
    }

    @Override // com.oplus.melody.btsdk.api.scan.ScanElement, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.oplus.melody.btsdk.api.scan.ScanElement, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.mProductId);
        parcel.writeInt(this.mRssi);
        parcel.writeString(this.mMacAddress);
    }

    public BrScanElement(Parcel parcel) {
        super(parcel);
        this.mProductId = -1;
        this.mProductId = parcel.readInt();
        this.mRssi = parcel.readInt();
        this.mMacAddress = parcel.readString();
    }
}
