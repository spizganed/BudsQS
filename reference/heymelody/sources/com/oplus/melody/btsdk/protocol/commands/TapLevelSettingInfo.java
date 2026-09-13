package com.oplus.melody.btsdk.protocol.commands;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class TapLevelSettingInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<TapLevelSettingInfo> CREATOR = new a();
    public static final String TAG = "TapLevelSettingInfo";
    private boolean mIsNotificationInfo;
    private int mTapLevelDefaultValue;
    private int mTapLevelSettingValue;

    public class a implements Parcelable.Creator<TapLevelSettingInfo> {
        @Override // android.os.Parcelable.Creator
        public final TapLevelSettingInfo createFromParcel(Parcel parcel) {
            return new TapLevelSettingInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final TapLevelSettingInfo[] newArray(int i10) {
            return new TapLevelSettingInfo[i10];
        }
    }

    public TapLevelSettingInfo(int i10, byte[] bArr, boolean z2) {
        this.mIsNotificationInfo = false;
        int i11 = (!z2 ? 1 : 0) + i10;
        if (i11 >= bArr.length) {
            A6.g.j(androidx.appcompat.widget.a.n(i10, "TapLevelSettingInfo offset not valid, offset = ", ", data.length"), bArr.length, TAG);
            return;
        }
        this.mTapLevelSettingValue = bArr[i10];
        this.mTapLevelDefaultValue = bArr[i11];
        this.mIsNotificationInfo = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getTapLevelDefaultValue() {
        return this.mTapLevelDefaultValue;
    }

    public int getTapLevelSettingValue() {
        return this.mTapLevelSettingValue;
    }

    public boolean isNotificationInfo() {
        return this.mIsNotificationInfo;
    }

    public void setTapLevelDefaultValue(int i10) {
        this.mTapLevelDefaultValue = i10;
    }

    public void setTapLevelSettingValue(int i10) {
        this.mTapLevelSettingValue = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mTapLevelSettingValue);
        parcel.writeInt(this.mTapLevelDefaultValue);
        parcel.writeInt(this.mIsNotificationInfo ? 1 : 0);
    }

    public TapLevelSettingInfo(Parcel parcel) {
        this.mIsNotificationInfo = false;
        this.mTapLevelSettingValue = parcel.readInt();
        this.mTapLevelDefaultValue = parcel.readInt();
        this.mIsNotificationInfo = parcel.readInt() == 1;
    }
}
