package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MultiConnectInformations extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<MultiConnectInformations> CREATOR = new a();
    private String mAddress;
    private List<MultiConnectInformationElement> mMultiConnectInformationList;

    public class a implements Parcelable.Creator<MultiConnectInformations> {
        @Override // android.os.Parcelable.Creator
        public final MultiConnectInformations createFromParcel(Parcel parcel) {
            return new MultiConnectInformations(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final MultiConnectInformations[] newArray(int i10) {
            return new MultiConnectInformations[i10];
        }
    }

    public MultiConnectInformations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public List<MultiConnectInformationElement> getMultiConnectInformationList() {
        return this.mMultiConnectInformationList;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setList(List<MultiConnectInformationElement> list) {
        this.mMultiConnectInformationList = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mAddress);
        parcel.writeTypedList(this.mMultiConnectInformationList);
    }

    public MultiConnectInformations(Parcel parcel) {
        this.mAddress = parcel.readString();
        this.mMultiConnectInformationList = parcel.createTypedArrayList(MultiConnectInformationElement.CREATOR);
    }
}
