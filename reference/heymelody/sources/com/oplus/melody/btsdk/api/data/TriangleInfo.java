package com.oplus.melody.btsdk.api.data;

import A6.g;
import D5.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.common.util.A;
import java.nio.charset.Charset;
import z7.C1725a;

/* JADX INFO: loaded from: classes.dex */
public class TriangleInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<TriangleInfo> CREATOR = new a();
    public static final int NO_REPLY = -1;
    public static final String TAG = "TriangleInfo";

    /* JADX INFO: renamed from: V1, reason: collision with root package name */
    public static final int f19277V1 = 1;

    /* JADX INFO: renamed from: V2, reason: collision with root package name */
    public static final int f19278V2 = 2;
    private int mCapability;
    private int mIsAnotherDeviceAutoSwitchLinkOpen;
    private int mIsConnectedByRelativeDeviceForUseOperateState;
    private int mIsEarphoneA2dpIdleState;
    private int mIsEarphoneHfpIdleState;
    private boolean mIsEarphoneStatusReply;
    private boolean mIsRelativeDeviceNameReply;
    private int mIsSetPhoneNoActiveCommandState;
    private String mRelativeDeviceName;
    private int mRelativeDeviceNameLength;
    private int mVersion;
    private int mWear;

    public class a implements Parcelable.Creator<TriangleInfo> {
        @Override // android.os.Parcelable.Creator
        public final TriangleInfo createFromParcel(Parcel parcel) {
            return new TriangleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final TriangleInfo[] newArray(int i10) {
            return new TriangleInfo[i10];
        }
    }

    public TriangleInfo() {
        this.mCapability = -1;
        this.mVersion = -1;
        this.mWear = -1;
        this.mIsSetPhoneNoActiveCommandState = -1;
        this.mIsConnectedByRelativeDeviceForUseOperateState = -1;
        this.mIsEarphoneStatusReply = false;
        this.mIsEarphoneHfpIdleState = -1;
        this.mIsEarphoneA2dpIdleState = -1;
        this.mIsAnotherDeviceAutoSwitchLinkOpen = -1;
        this.mIsRelativeDeviceNameReply = false;
        this.mRelativeDeviceNameLength = 0;
        this.mRelativeDeviceName = null;
    }

    public TriangleInfo copyFrom(TriangleInfo triangleInfo) {
        int i10 = triangleInfo.mCapability;
        if (i10 != -1) {
            this.mCapability = i10;
        }
        int i11 = triangleInfo.mVersion;
        if (i11 != -1) {
            this.mVersion = i11;
        }
        int i12 = triangleInfo.mWear;
        if (i12 != -1) {
            this.mWear = i12;
        }
        boolean z2 = triangleInfo.mIsEarphoneStatusReply;
        this.mIsEarphoneStatusReply = z2;
        if (z2) {
            this.mIsSetPhoneNoActiveCommandState = triangleInfo.mIsSetPhoneNoActiveCommandState;
            this.mIsConnectedByRelativeDeviceForUseOperateState = triangleInfo.mIsConnectedByRelativeDeviceForUseOperateState;
            this.mIsEarphoneHfpIdleState = triangleInfo.mIsEarphoneHfpIdleState;
            this.mIsEarphoneA2dpIdleState = triangleInfo.mIsEarphoneA2dpIdleState;
            this.mIsAnotherDeviceAutoSwitchLinkOpen = triangleInfo.mIsAnotherDeviceAutoSwitchLinkOpen;
        }
        boolean z4 = triangleInfo.mIsRelativeDeviceNameReply;
        this.mIsRelativeDeviceNameReply = z4;
        if (z4 || z2) {
            this.mRelativeDeviceName = triangleInfo.mRelativeDeviceName;
        }
        TriangleInfo triangleInfo2 = new TriangleInfo();
        triangleInfo2.mCapability = this.mCapability;
        triangleInfo2.mVersion = this.mVersion;
        triangleInfo2.mWear = this.mWear;
        triangleInfo2.mIsEarphoneStatusReply = this.mIsEarphoneStatusReply;
        triangleInfo2.mIsConnectedByRelativeDeviceForUseOperateState = this.mIsConnectedByRelativeDeviceForUseOperateState;
        triangleInfo2.mIsSetPhoneNoActiveCommandState = this.mIsSetPhoneNoActiveCommandState;
        triangleInfo2.mIsEarphoneHfpIdleState = this.mIsEarphoneHfpIdleState;
        triangleInfo2.mIsEarphoneA2dpIdleState = this.mIsEarphoneA2dpIdleState;
        triangleInfo2.mIsAnotherDeviceAutoSwitchLinkOpen = this.mIsAnotherDeviceAutoSwitchLinkOpen;
        triangleInfo2.mIsRelativeDeviceNameReply = this.mIsRelativeDeviceNameReply;
        triangleInfo2.mRelativeDeviceName = this.mRelativeDeviceName;
        return triangleInfo2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCapability() {
        return this.mCapability;
    }

    public String getRelativeDeviceName() {
        return this.mRelativeDeviceName;
    }

    public int getRelativeDeviceNameLength() {
        return this.mRelativeDeviceNameLength;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public int getWear() {
        return this.mWear;
    }

    public int isAnotherDeviceAutoSwitchLinkOpenState() {
        return this.mIsAnotherDeviceAutoSwitchLinkOpen;
    }

    public int isConnectedByRelativeDeviceForUseOperateState() {
        return this.mIsConnectedByRelativeDeviceForUseOperateState;
    }

    public int isEarphoneA2dpIdleState() {
        return this.mIsEarphoneA2dpIdleState;
    }

    public int isEarphoneHfpIdleState() {
        return this.mIsEarphoneHfpIdleState;
    }

    public boolean isEarphoneStatusReply() {
        return this.mIsEarphoneStatusReply;
    }

    public boolean isRelativeDeviceNameReply() {
        return this.mIsRelativeDeviceNameReply;
    }

    public int isSetPhoneNoActiveCommandState() {
        return this.mIsSetPhoneNoActiveCommandState;
    }

    public void setAnotherDeviceAutoSwitchLinkOpenState(int i10) {
        this.mIsAnotherDeviceAutoSwitchLinkOpen = i10;
    }

    public void setCapability(int i10) {
        this.mCapability = i10;
    }

    public void setConnectedByRelativeDeviceForUseOperateState(int i10) {
        this.mIsConnectedByRelativeDeviceForUseOperateState = i10;
    }

    public void setEarphoneA2dpIdleState(int i10) {
        this.mIsEarphoneA2dpIdleState = i10;
    }

    public void setEarphoneHfpIdleState(int i10) {
        this.mIsEarphoneHfpIdleState = i10;
    }

    public void setEarphoneStatusReply(boolean z2) {
        this.mIsEarphoneStatusReply = z2;
    }

    public void setPhoneNoActiveCommandState(int i10) {
        this.mIsSetPhoneNoActiveCommandState = i10;
    }

    public void setRelativeDeviceName(String str) {
        this.mRelativeDeviceName = str;
    }

    public void setRelativeDeviceNameLength(int i10) {
        this.mRelativeDeviceNameLength = i10;
    }

    public void setRelativeDeviceNameReply(boolean z2) {
        this.mIsRelativeDeviceNameReply = z2;
    }

    public void setVersion(int i10) {
        this.mVersion = i10;
    }

    public void setWear(int i10) {
        this.mWear = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mCapability);
        parcel.writeInt(this.mVersion);
        parcel.writeInt(this.mWear);
        parcel.writeByte(this.mIsEarphoneStatusReply ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mIsConnectedByRelativeDeviceForUseOperateState);
        parcel.writeInt(this.mIsSetPhoneNoActiveCommandState);
        parcel.writeInt(this.mIsEarphoneHfpIdleState);
        parcel.writeInt(this.mIsEarphoneA2dpIdleState);
        parcel.writeInt(this.mIsAnotherDeviceAutoSwitchLinkOpen);
        parcel.writeByte(this.mIsRelativeDeviceNameReply ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mRelativeDeviceName);
    }

    public TriangleInfo(int i10, byte[] bArr) {
        this.mCapability = -1;
        this.mVersion = -1;
        this.mWear = -1;
        this.mIsSetPhoneNoActiveCommandState = -1;
        this.mIsConnectedByRelativeDeviceForUseOperateState = -1;
        this.mIsEarphoneStatusReply = false;
        this.mIsEarphoneHfpIdleState = -1;
        this.mIsEarphoneA2dpIdleState = -1;
        this.mIsAnotherDeviceAutoSwitchLinkOpen = -1;
        this.mIsRelativeDeviceNameReply = false;
        this.mRelativeDeviceNameLength = 0;
        this.mRelativeDeviceName = null;
        if (i10 >= bArr.length) {
            g.j(androidx.appcompat.widget.a.n(i10, "TriangleInfo offset not vaild, offset = ", ", data.length"), bArr.length, TAG);
            return;
        }
        A.a aVar = C1725a.f29476a;
        if (A.l()) {
            StringBuilder sbN = androidx.appcompat.widget.a.n(i10, "TriangleInfo  offset = ", ", data = ");
            sbN.append(E8.a.e(bArr));
            C1725a.a(TAG, sbN.toString());
        }
        int iP = c.p(bArr, i10, 2, true);
        boolean z2 = (iP & 1) != 0;
        boolean z4 = (iP & 2) != 0;
        boolean z10 = (iP & 4) != 0;
        boolean z11 = (iP & 8) != 0;
        boolean z12 = (iP & 16) != 0;
        if (A.l()) {
            C1725a.a(TAG, "TriangleInfo isReplyCapability = " + z2 + ", isReplyVersion = " + z4 + ", isReplyWear = " + z10 + ", isReplyStatus = " + z11 + ", isReplyRelativeDeviceName = " + z12);
        }
        int i11 = i10 + 2;
        if (i11 >= bArr.length) {
            StringBuilder sbN2 = androidx.appcompat.widget.a.n(i11, "TriangleInfo offset not vaild, offset = ", ", data = ");
            sbN2.append(E8.a.e(bArr));
            C1725a.f(TAG, sbN2.toString());
            return;
        }
        if (z2) {
            setCapability(c.p(bArr, i11, 1, true));
            i11 = i10 + 3;
        }
        if (z4) {
            if (i11 >= bArr.length) {
                StringBuilder sbN3 = androidx.appcompat.widget.a.n(i11, "TriangleInfo offset not vaild when parse version, offset = ", ", data = ");
                sbN3.append(E8.a.e(bArr));
                C1725a.f(TAG, sbN3.toString());
                return;
            }
            setVersion(c.p(bArr, i11, 1, true));
            i11++;
        }
        if (z10) {
            if (i11 >= bArr.length) {
                StringBuilder sbN4 = androidx.appcompat.widget.a.n(i11, "TriangleInfo offset not vaild when parse wear, offset = ", ", data = ");
                sbN4.append(E8.a.e(bArr));
                C1725a.f(TAG, sbN4.toString());
                return;
            }
            setWear(c.p(bArr, i11, 1, true));
            i11++;
        }
        if (z11) {
            if (i11 >= bArr.length) {
                StringBuilder sbN5 = androidx.appcompat.widget.a.n(i11, "TriangleInfo offset not vaild when parse status, offset = ", ", data = ");
                sbN5.append(E8.a.e(bArr));
                C1725a.f(TAG, sbN5.toString());
                return;
            }
            int iP2 = c.p(bArr, i11, 1, true);
            setEarphoneStatusReply(true);
            setPhoneNoActiveCommandState((iP2 & 1) == 0 ? 0 : 1);
            setConnectedByRelativeDeviceForUseOperateState((iP2 & 2) != 0 ? 1 : 0);
            setEarphoneHfpIdleState((iP2 & 4) != 0 ? 0 : 1);
            setEarphoneA2dpIdleState((iP2 & 8) != 0 ? 0 : 1);
            setAnotherDeviceAutoSwitchLinkOpenState((iP2 & 16) != 0 ? 0 : 1);
            i11++;
        } else {
            setEarphoneStatusReply(false);
        }
        if (z12) {
            if (i11 >= bArr.length) {
                StringBuilder sbN6 = androidx.appcompat.widget.a.n(i11, "TriangleInfo offset not vaild when parse namelength, offset = ", ", data = ");
                sbN6.append(E8.a.e(bArr));
                C1725a.f(TAG, sbN6.toString());
                return;
            }
            setRelativeDeviceNameReply(true);
            setRelativeDeviceNameLength(c.p(bArr, i11, 1, true));
            int i12 = i11 + 1;
            if (getRelativeDeviceNameLength() > 0) {
                if (i12 >= bArr.length) {
                    StringBuilder sbN7 = androidx.appcompat.widget.a.n(i12, "TriangleInfo offset not vaild when parse name, offset = ", ", data = ");
                    sbN7.append(E8.a.e(bArr));
                    C1725a.f(TAG, sbN7.toString());
                    return;
                }
                int relativeDeviceNameLength = getRelativeDeviceNameLength();
                byte[] bArr2 = new byte[relativeDeviceNameLength];
                try {
                    System.arraycopy(bArr, i12, bArr2, 0, relativeDeviceNameLength);
                    setRelativeDeviceName(new String(bArr2, Charset.defaultCharset()));
                    return;
                } catch (Exception e10) {
                    StringBuilder sbN8 = androidx.appcompat.widget.a.n(relativeDeviceNameLength, "TriangleInfo nameBytes.length = ", ", data = ");
                    sbN8.append(E8.a.e(bArr));
                    sbN8.append(", e = ");
                    sbN8.append(e10.getMessage());
                    C1725a.f(TAG, sbN8.toString());
                    return;
                }
            }
            C1725a.l(TAG, "TriangleInfo nameLength error, nameLength = " + getRelativeDeviceNameLength() + ", data = " + E8.a.e(bArr));
            return;
        }
        if (z11 && isSetPhoneNoActiveCommandState() == 1) {
            setRelativeDeviceName(null);
        }
    }

    public TriangleInfo(Parcel parcel) {
        this.mCapability = -1;
        this.mVersion = -1;
        this.mWear = -1;
        this.mIsSetPhoneNoActiveCommandState = -1;
        this.mIsConnectedByRelativeDeviceForUseOperateState = -1;
        this.mIsEarphoneStatusReply = false;
        this.mIsEarphoneHfpIdleState = -1;
        this.mIsEarphoneA2dpIdleState = -1;
        this.mIsAnotherDeviceAutoSwitchLinkOpen = -1;
        this.mIsRelativeDeviceNameReply = false;
        this.mRelativeDeviceNameLength = 0;
        this.mRelativeDeviceName = null;
        this.mCapability = parcel.readInt();
        this.mVersion = parcel.readInt();
        this.mWear = parcel.readInt();
        this.mIsEarphoneStatusReply = parcel.readByte() != 0;
        this.mIsConnectedByRelativeDeviceForUseOperateState = parcel.readInt();
        this.mIsSetPhoneNoActiveCommandState = parcel.readInt();
        this.mIsEarphoneHfpIdleState = parcel.readInt();
        this.mIsEarphoneA2dpIdleState = parcel.readInt();
        this.mIsAnotherDeviceAutoSwitchLinkOpen = parcel.readInt();
        this.mIsRelativeDeviceNameReply = parcel.readByte() != 0;
        this.mRelativeDeviceName = parcel.readString();
    }
}
