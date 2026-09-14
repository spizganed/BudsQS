package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class SetCommandStateInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<SetCommandStateInfo> CREATOR = new a();
    public String mAddress;
    public int mResponseCommand;
    public int mRspValue;
    public int mSetStatus;

    public class a implements Parcelable.Creator<SetCommandStateInfo> {
        @Override // android.os.Parcelable.Creator
        public final SetCommandStateInfo createFromParcel(Parcel parcel) {
            return new SetCommandStateInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final SetCommandStateInfo[] newArray(int i10) {
            return new SetCommandStateInfo[i10];
        }
    }

    public SetCommandStateInfo() {
        this.mRspValue = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getSetStatus() {
        return this.mSetStatus;
    }

    public boolean isCompactnessDetectRsp() {
        return this.mResponseCommand == 33797;
    }

    public boolean isEarRestoreInfoRsp() {
        return this.mResponseCommand == 33809;
    }

    public boolean isFindModeRsp() {
        return this.mResponseCommand == 33792;
    }

    public boolean isHearingEnhancementDetectionRsp() {
        return this.mResponseCommand == 33805;
    }

    public boolean isKeyFunctionRsp() {
        return this.mResponseCommand == 33793;
    }

    public boolean isNoiseReductionRsp() {
        return this.mResponseCommand == 33796;
    }

    public boolean isPersonalNoiseRsp() {
        return this.mResponseCommand == 33810;
    }

    public boolean isProcessHearingEnhancementDetectionRsp() {
        return this.mResponseCommand == 33806;
    }

    public boolean isSetAccountKeyRsp() {
        return this.mResponseCommand == 33820;
    }

    public boolean isSetEqInfoRsp() {
        return this.mResponseCommand == 33816;
    }

    public boolean isSetEqStatusRsp() {
        return this.mResponseCommand == 33798;
    }

    public boolean isSetFreeDialogRsp() {
        return this.mResponseCommand == 33812;
    }

    public boolean isSetOneshotRecordStartOrStopRsp() {
        return this.mResponseCommand == 33836;
    }

    public boolean isSetScreenOffBroadcastDelayTimeRsp() {
        return this.mResponseCommand == 33821;
    }

    public boolean isSetSpineRangeDetectionRsp() {
        return this.mResponseCommand == 33825;
    }

    public boolean isSuccess() {
        return this.mSetStatus == 0;
    }

    public boolean isSwitchDebugRsp() {
        return this.mResponseCommand == 36608;
    }

    public boolean isSwitchFeatureRsp() {
        return this.mResponseCommand == 33795;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mAddress);
        parcel.writeInt(this.mSetStatus);
        parcel.writeInt(this.mResponseCommand);
        parcel.writeInt(this.mRspValue);
    }

    public SetCommandStateInfo(Parcel parcel) {
        this.mRspValue = -1;
        this.mAddress = parcel.readString();
        this.mSetStatus = parcel.readInt();
        this.mResponseCommand = parcel.readInt();
        this.mRspValue = parcel.readInt();
    }
}
