package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HearingEnhanceFreqPacketInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<HearingEnhanceFreqPacketInfo> CREATOR = new a();
    private String mAddress;
    private List<HearingEnhanceFreqPacket> mFreqPackets;

    public class a implements Parcelable.Creator<HearingEnhanceFreqPacketInfo> {
        @Override // android.os.Parcelable.Creator
        public final HearingEnhanceFreqPacketInfo createFromParcel(Parcel parcel) {
            return new HearingEnhanceFreqPacketInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final HearingEnhanceFreqPacketInfo[] newArray(int i10) {
            return new HearingEnhanceFreqPacketInfo[i10];
        }
    }

    public HearingEnhanceFreqPacketInfo() {
        this.mFreqPackets = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public List<HearingEnhanceFreqPacket> getFreqPackets() {
        return this.mFreqPackets;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setFreqPackets(List<HearingEnhanceFreqPacket> list) {
        if (list != null) {
            this.mFreqPackets.addAll(list);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mAddress);
        parcel.writeTypedList(this.mFreqPackets);
    }

    public HearingEnhanceFreqPacketInfo(Parcel parcel) {
        this.mFreqPackets = new ArrayList();
        this.mAddress = parcel.readString();
        this.mFreqPackets = parcel.createTypedArrayList(HearingEnhanceFreqPacket.CREATOR);
    }
}
