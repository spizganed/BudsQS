package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StatusInfo extends com.oplus.melody.common.data.a implements Parcelable {
    private static final int BIT_BOX_COVER_STATUS = 4;
    private static final int BIT_BOX_STATUS = 1;
    private static final int BIT_EAR_STATUS = 2;
    private static final int BIT_SAFE_REMIND_STATUS = 8;
    public static final Parcelable.Creator<StatusInfo> CREATOR = new a();
    private boolean mCoverClose;
    private int mDeviceType;
    private boolean mInBox;
    private boolean mInEar;
    private boolean mNeedSafeRemind;

    public class a implements Parcelable.Creator<StatusInfo> {
        @Override // android.os.Parcelable.Creator
        public final StatusInfo createFromParcel(Parcel parcel) {
            return new StatusInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final StatusInfo[] newArray(int i10) {
            return new StatusInfo[i10];
        }
    }

    public StatusInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public boolean isBoxCoverClosed() {
        return this.mCoverClose;
    }

    public boolean isInBox() {
        return this.mInBox;
    }

    public boolean isInEar() {
        return this.mInEar;
    }

    public boolean isNeedSafeRemind() {
        return this.mNeedSafeRemind;
    }

    public void setBoxCoverClosed(boolean z2) {
        this.mCoverClose = z2;
    }

    public void setDeviceType(int i10) {
        this.mDeviceType = i10;
    }

    public void setInBox(boolean z2) {
        this.mInBox = z2;
    }

    public void setInEar(boolean z2) {
        this.mInEar = z2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mDeviceType);
        parcel.writeByte(this.mInBox ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mInEar ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mCoverClose ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mNeedSafeRemind ? (byte) 1 : (byte) 0);
    }

    public StatusInfo(int i10, byte[] bArr) {
        this.mDeviceType = bArr[i10];
        byte b4 = bArr[i10 + 1];
        this.mInBox = (b4 & 1) == 0;
        this.mInEar = (b4 & 2) != 0;
        this.mCoverClose = (b4 & 4) == 0;
        this.mNeedSafeRemind = (b4 & 8) != 0;
    }

    public static boolean isInEar(List<StatusInfo> list) {
        if (list == null) {
            return false;
        }
        Iterator<StatusInfo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().isInEar()) {
                return true;
            }
        }
        return false;
    }

    public StatusInfo(Parcel parcel) {
        this.mDeviceType = parcel.readInt();
        this.mInBox = parcel.readByte() != 0;
        this.mInEar = parcel.readByte() != 0;
        this.mCoverClose = parcel.readByte() != 0;
        this.mNeedSafeRemind = parcel.readByte() != 0;
    }
}
