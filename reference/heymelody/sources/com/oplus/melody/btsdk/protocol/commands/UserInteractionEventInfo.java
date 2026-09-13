package com.oplus.melody.btsdk.protocol.commands;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.common.util.A;
import java.util.Arrays;
import z7.C1725a;

/* JADX INFO: loaded from: classes.dex */
public class UserInteractionEventInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<UserInteractionEventInfo> CREATOR = new a();
    protected static final int LENGTH_USER_INTERACTION_EVENT_INFO = 5;
    private static final int OFFSET_BUTTON = 1;
    private static final int OFFSET_BUTTON_ACTION = 2;
    private static final int OFFSET_DEVICE_TYPE = 0;
    private static final int OFFSET_FUNCTION = 3;
    private static final int OFFSET_OPTION = 5;
    private static final int OFFSET_SCENE = 4;
    private static final int OPTION_ONE_LENGTH = 2;
    private static final String TAG = "UserInteractionEventInfo";
    private int mButton;
    private int mButtonAction;
    private int mDeviceType;
    private int mFunction;
    private int[] mOptions;
    private int mScene;

    public class a implements Parcelable.Creator<UserInteractionEventInfo> {
        @Override // android.os.Parcelable.Creator
        public final UserInteractionEventInfo createFromParcel(Parcel parcel) {
            return new UserInteractionEventInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final UserInteractionEventInfo[] newArray(int i10) {
            return new UserInteractionEventInfo[i10];
        }
    }

    public UserInteractionEventInfo(int i10, byte[] bArr) {
        this.mDeviceType = bArr[i10];
        this.mButton = bArr[i10 + 1];
        this.mButtonAction = bArr[i10 + 2];
        this.mFunction = bArr[i10 + 3];
        this.mScene = bArr[i10 + 4];
        try {
            int length = bArr.length - 5;
            if (length >= 2) {
                int i11 = length / 2;
                this.mOptions = new int[i11];
                for (int i12 = 0; i12 < i11; i12++) {
                    this.mOptions[i12] = D5.c.p(bArr, (i12 * 2) + i10 + 5, 2, true);
                }
            }
        } catch (Exception e10) {
            A.o(5, C1725a.j(TAG), "UserInteractionEventInfo, data: " + Arrays.toString(bArr), e10);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getButton() {
        return this.mButton;
    }

    public int getButtonAction() {
        return this.mButtonAction;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public int getFunction() {
        return this.mFunction;
    }

    public int[] getOptions() {
        return this.mOptions;
    }

    public int getScene() {
        return this.mScene;
    }

    public void setButton(int i10) {
        this.mButton = i10;
    }

    public void setButtonAction(int i10) {
        this.mButtonAction = i10;
    }

    public void setDeviceType(int i10) {
        this.mDeviceType = i10;
    }

    public void setFunction(int i10) {
        this.mFunction = i10;
    }

    public void setOptions(int[] iArr) {
        this.mOptions = iArr;
    }

    public void setScene(int i10) {
        this.mScene = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mDeviceType);
        parcel.writeInt(this.mButton);
        parcel.writeInt(this.mButtonAction);
        parcel.writeInt(this.mFunction);
        parcel.writeInt(this.mScene);
        parcel.writeIntArray(this.mOptions);
    }

    public UserInteractionEventInfo(Parcel parcel) {
        this.mDeviceType = parcel.readInt();
        this.mButton = parcel.readInt();
        this.mButtonAction = parcel.readInt();
        this.mFunction = parcel.readInt();
        this.mScene = parcel.readInt();
        this.mOptions = parcel.createIntArray();
    }
}
