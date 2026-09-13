package com.oplus.melody.btsdk.api.data;

import Y.r;
import Y6.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.S;
import java.util.Collection;
import z7.C1725a;

/* JADX INFO: loaded from: classes.dex */
public class BatteryInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<BatteryInfo> CREATOR = new a();
    public static final int LENGTH_REMOTE_BATTERY_LEVEL = 2;
    private static final int MASK_BATTERY_LEVEL = 127;
    private static final int MASK_CHARGING_STATE = 128;
    public static final int MAX_BATTERY_LEVEL = 100;
    public static final int MIN_BATTERY_LEVEL = 1;
    private static final String TAG = "BatteryInfo";
    public int mCharging;
    public int mDeviceType;
    public int mLevel;

    public class a implements Parcelable.Creator<BatteryInfo> {
        @Override // android.os.Parcelable.Creator
        public final BatteryInfo createFromParcel(Parcel parcel) {
            return new BatteryInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final BatteryInfo[] newArray(int i10) {
            return new BatteryInfo[i10];
        }
    }

    public BatteryInfo(int i10, int i11, int i12) {
        this.mDeviceType = i10;
        this.mLevel = i11;
        this.mCharging = i12;
    }

    public static void fixBatteries(Collection<BatteryInfo> collection, String str) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        WhitelistConfigDTO whitelistConfigDTOA = a.C0090a.f6690a.a(str);
        int batteryRadix = 10;
        if (whitelistConfigDTOA != null && whitelistConfigDTOA.getFunction() != null && S.s(C0906l.f19501a)) {
            batteryRadix = whitelistConfigDTOA.getFunction().getBatteryRadix();
        }
        for (BatteryInfo batteryInfo : collection) {
            if (batteryInfo != null) {
                int i10 = batteryInfo.mLevel;
                int iFixBattery = fixBattery(i10, batteryRadix, batteryInfo.mDeviceType);
                batteryInfo.mLevel = iFixBattery;
                if (i10 != iFixBattery) {
                    A.a aVar = C1725a.f29476a;
                    if (A.l()) {
                        StringBuilder sbN = androidx.appcompat.widget.a.n(i10, "fixBatteries ", " -> ");
                        sbN.append(batteryInfo.mLevel);
                        sbN.append(", type=");
                        r.m(sbN, batteryInfo.mDeviceType, ", radix=", batteryRadix, ", mac=");
                        sbN.append(A.r(str));
                        C1725a.a(TAG, sbN.toString());
                    }
                }
            }
        }
    }

    public static int fixBattery(int i10, int i11, int i12) {
        if (i10 < 1) {
            return 0;
        }
        if (i10 >= 100) {
            return 100;
        }
        if (i11 <= 1 || i10 % i11 == 0) {
            return i10;
        }
        if (i10 == 1 && i12 == 3) {
            return 1;
        }
        return Math.min(((i10 / i11) + 1) * i11, 100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mDeviceType);
        parcel.writeInt(this.mLevel);
        parcel.writeInt(this.mCharging);
    }

    public BatteryInfo(int i10, int i11) {
        this(i10, i11, -1);
    }

    public BatteryInfo(int i10, byte[] bArr) {
        this.mDeviceType = bArr[i10];
        byte b4 = bArr[i10 + 1];
        this.mLevel = b4 & 127;
        this.mCharging = (b4 & 128) == 0 ? 0 : 1;
    }

    public BatteryInfo(Parcel parcel) {
        this.mDeviceType = parcel.readInt();
        this.mLevel = parcel.readInt();
        this.mCharging = parcel.readInt();
    }

    public BatteryInfo() {
    }
}
