package com.oplus.melody.btsdk.api.data;

import A6.g;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class KeyFunctionInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<KeyFunctionInfo> CREATOR = new a();
    public static final int LENGTH_KEY_FUNCTION_ITEM = 4;
    private static final int OFFSET_BUTTON = 1;
    private static final int OFFSET_BUTTON_ACTION = 2;
    private static final int OFFSET_DEVICE_TYPE = 0;
    private static final int OFFSET_FUNCTION = 3;
    private static final String TAG = "KeyFunctionInfo";
    private int mButton;
    private int mButtonAction;
    private int mDeviceType;
    private int mFunction;

    public class a implements Parcelable.Creator<KeyFunctionInfo> {
        @Override // android.os.Parcelable.Creator
        public final KeyFunctionInfo createFromParcel(Parcel parcel) {
            return new KeyFunctionInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final KeyFunctionInfo[] newArray(int i10) {
            return new KeyFunctionInfo[i10];
        }
    }

    public KeyFunctionInfo(int i10, byte[] bArr) {
        this.mDeviceType = bArr[i10];
        this.mButton = bArr[i10 + 1];
        this.mButtonAction = bArr[i10 + 2];
        this.mFunction = bArr[i10 + 3];
    }

    public byte[] convertToData() {
        return new byte[]{(byte) this.mDeviceType, (byte) this.mButton, (byte) this.mButtonAction, (byte) this.mFunction};
    }

    public boolean copyIntoData(byte[] bArr, int i10) {
        if (i10 + 4 > bArr.length) {
            g.j(androidx.appcompat.widget.a.n(i10, "The length of data is not valid. offset = ", ", len = "), bArr.length, TAG);
            return false;
        }
        bArr[i10] = (byte) this.mDeviceType;
        bArr[i10 + 1] = (byte) this.mButton;
        bArr[i10 + 2] = (byte) this.mButtonAction;
        bArr[i10 + 3] = (byte) this.mFunction;
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getButtonAction() {
        return this.mButtonAction;
    }

    public int getDeviceButton() {
        return this.mButton;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public int getFunction() {
        return this.mFunction;
    }

    public void setFunction(int i10) {
        this.mFunction = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mDeviceType);
        parcel.writeInt(this.mButton);
        parcel.writeInt(this.mButtonAction);
        parcel.writeInt(this.mFunction);
    }

    public KeyFunctionInfo(int i10, int i11, int i12, int i13) {
        this.mDeviceType = i10;
        this.mButton = i11;
        this.mButtonAction = i12;
        this.mFunction = i13;
    }

    public KeyFunctionInfo(Parcel parcel) {
        this.mDeviceType = parcel.readInt();
        this.mButton = parcel.readInt();
        this.mButtonAction = parcel.readInt();
        this.mFunction = parcel.readInt();
    }
}
