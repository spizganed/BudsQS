package com.oplus.melody.btsdk.api.data;

import A6.f;
import A6.g;
import Ea.C0404m;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.oplus.melody.common.util.A;
import z7.C1725a;

/* JADX INFO: loaded from: classes.dex */
public class HandheldDeviceInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final int ADDRESS_LENGTH = 6;
    public static final Parcelable.Creator<HandheldDeviceInfo> CREATOR = new a();
    public static final int HIGH_LEVEL_DEVICE = 2;
    public static final int LOW_LEVEL_DEVICE = 1;
    public static final String TAG = "HandheldDeviceInfo";
    private long mCreateTime;
    private String mEarphoneAddress;
    private String mHandheldAddress;
    private boolean mHasLowLevelDevice;
    private boolean mIsAutoMode;
    private boolean mIsHighLevel;

    public class a implements Parcelable.Creator<HandheldDeviceInfo> {
        @Override // android.os.Parcelable.Creator
        public final HandheldDeviceInfo createFromParcel(Parcel parcel) {
            return new HandheldDeviceInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final HandheldDeviceInfo[] newArray(int i10) {
            return new HandheldDeviceInfo[i10];
        }
    }

    public HandheldDeviceInfo() {
        this.mIsHighLevel = false;
        this.mIsAutoMode = false;
        this.mEarphoneAddress = null;
        this.mHandheldAddress = null;
        this.mCreateTime = 0L;
        this.mHasLowLevelDevice = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$parseData$0() {
        return "parseData mIsAutoMode = " + this.mIsAutoMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$parseData$1() {
        return "parseData mHasLowLevelDevice = " + this.mHasLowLevelDevice;
    }

    private String parseAddress(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        String strE = E8.a.e(bArr);
        if (TextUtils.isEmpty(strE)) {
            C1725a.f(TAG, "parseAddress hexStr is empty!");
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        if (strE.length() % 2 != 0) {
            C1725a.f(TAG, "parseAddress hexStr.length() is odd num!, hexStr.length() = " + strE.length());
            return null;
        }
        int length = strE.length() / 2;
        for (int i10 = 0; i10 < length; i10++) {
            if (sb2.length() != 0) {
                sb2.append(":");
            }
            sb2.append(strE.substring(((length - 1) - i10) * 2, (length - i10) * 2));
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public String getEarphoneAddress() {
        return this.mEarphoneAddress;
    }

    public String getHandheldAddress() {
        return this.mHandheldAddress;
    }

    public boolean hasLowLevelDevice() {
        return this.mHasLowLevelDevice;
    }

    public boolean isAutoMode() {
        return this.mIsAutoMode;
    }

    public boolean isHighLevel() {
        return this.mIsHighLevel;
    }

    public void parseData(String str, int i10, byte[] bArr, boolean z2) {
        if (i10 >= bArr.length) {
            g.j(androidx.appcompat.widget.a.n(i10, "parseData offset not valid, offset = ", ", data.length"), bArr.length, TAG);
            return;
        }
        this.mEarphoneAddress = str;
        this.mCreateTime = SystemClock.elapsedRealtime();
        this.mIsHighLevel = z2;
        A.a aVar = C1725a.f29476a;
        if (A.l()) {
            C1725a.a(TAG, "parseData data = " + E8.a.e(bArr) + ", offset = " + i10);
        }
        if (this.mIsHighLevel) {
            this.mIsAutoMode = bArr[i10] == 0;
            int i11 = 1 + i10;
            C1725a.c(TAG, new B6.a(this, 24));
            if (this.mIsAutoMode) {
                return;
            }
            if (i10 + 6 >= bArr.length) {
                g.j(androidx.appcompat.widget.a.n(i11, "parseData high parse address, offset not valid, offset = ", ", data.length"), bArr.length, TAG);
                return;
            }
            byte[] bArr2 = new byte[6];
            try {
                System.arraycopy(bArr, i11, bArr2, 0, 6);
                this.mHandheldAddress = parseAddress(bArr2);
                C1725a.e(TAG, "parseData high mHandheldAddress = " + this.mHandheldAddress);
                return;
            } catch (Exception e10) {
                C1725a.f(TAG, "parseData high parse address data = " + E8.a.e(bArr) + ", e = " + e10.getMessage());
                return;
            }
        }
        this.mHasLowLevelDevice = bArr[i10] != 0;
        int i12 = 1 + i10;
        C1725a.c(TAG, new C0404m(this, 28));
        if (this.mHasLowLevelDevice) {
            if (i10 + 6 >= bArr.length) {
                g.j(androidx.appcompat.widget.a.n(i12, "parseData low parse address, offset not valid, offset = ", ", data.length"), bArr.length, TAG);
                return;
            }
            byte[] bArr3 = new byte[6];
            try {
                System.arraycopy(bArr, i12, bArr3, 0, 6);
                this.mHandheldAddress = parseAddress(bArr3);
                C1725a.e(TAG, "parseData heldDeviceAddressBytes mHandheldAddress = " + this.mHandheldAddress);
            } catch (Exception e11) {
                C1725a.f(TAG, "parseData low parse address data = " + E8.a.e(bArr) + ", e = " + e11.getMessage());
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mIsHighLevel ? 1 : 0);
        parcel.writeInt(this.mIsAutoMode ? 1 : 0);
        parcel.writeInt(this.mHasLowLevelDevice ? 1 : 0);
        parcel.writeString(this.mHandheldAddress);
        parcel.writeString(this.mEarphoneAddress);
        parcel.writeLong(this.mCreateTime);
    }

    public HandheldDeviceInfo(String str, int i10, byte[] bArr) {
        boolean z2 = false;
        this.mIsHighLevel = false;
        this.mIsAutoMode = false;
        this.mEarphoneAddress = null;
        this.mHandheldAddress = null;
        this.mCreateTime = 0L;
        this.mHasLowLevelDevice = false;
        if (i10 >= bArr.length) {
            g.j(androidx.appcompat.widget.a.n(i10, "HandheldDeviceInfo offset not valid, offset = ", ", data.length"), bArr.length, TAG);
            return;
        }
        byte b4 = bArr[i10];
        int i11 = i10 + 1;
        if (b4 != 1) {
            if (b4 != 2) {
                f.g(b4, "HandheldDeviceInfo level not valid, level = ", TAG);
                return;
            }
            z2 = true;
        }
        parseData(str, i11, bArr, z2);
    }

    public HandheldDeviceInfo(String str, int i10, byte[] bArr, boolean z2) {
        this.mIsHighLevel = false;
        this.mIsAutoMode = false;
        this.mEarphoneAddress = null;
        this.mHandheldAddress = null;
        this.mCreateTime = 0L;
        this.mHasLowLevelDevice = false;
        parseData(str, i10, bArr, z2);
    }

    public HandheldDeviceInfo(Parcel parcel) {
        this.mIsHighLevel = false;
        this.mIsAutoMode = false;
        this.mEarphoneAddress = null;
        this.mHandheldAddress = null;
        this.mCreateTime = 0L;
        this.mHasLowLevelDevice = false;
        this.mIsHighLevel = parcel.readInt() == 1;
        this.mIsAutoMode = parcel.readInt() == 1;
        this.mHasLowLevelDevice = parcel.readInt() == 1;
        this.mHandheldAddress = parcel.readString();
        this.mEarphoneAddress = parcel.readString();
        this.mCreateTime = parcel.readLong();
    }
}
