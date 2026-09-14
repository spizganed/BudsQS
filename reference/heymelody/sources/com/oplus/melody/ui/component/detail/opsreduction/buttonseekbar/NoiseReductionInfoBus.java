package com.oplus.melody.ui.component.detail.opsreduction.buttonseekbar;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class NoiseReductionInfoBus extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<NoiseReductionInfoBus> CREATOR = new a();
    private String address;
    private int title;

    public class a implements Parcelable.Creator<NoiseReductionInfoBus> {
        @Override // android.os.Parcelable.Creator
        public final NoiseReductionInfoBus createFromParcel(Parcel parcel) {
            return new NoiseReductionInfoBus(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final NoiseReductionInfoBus[] newArray(int i10) {
            return new NoiseReductionInfoBus[i10];
        }
    }

    public /* synthetic */ NoiseReductionInfoBus(int i10) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public int getTitle() {
        return this.title;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setTitle(int i10) {
        this.title = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.title);
        parcel.writeString(this.address);
    }

    private NoiseReductionInfoBus() {
    }

    public NoiseReductionInfoBus(Parcel parcel) {
        this.title = parcel.readInt();
        this.address = parcel.readString();
    }
}
