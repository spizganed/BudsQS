package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.play.core.appupdate.c;
import com.oplus.melody.common.util.C0912s;
import java.util.List;
import z7.C1725a;

/* JADX INFO: loaded from: classes.dex */
public class VersionInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<VersionInfo> CREATOR = new a();
    public static final String HARDWARE_CODE_DEFAULT_VERSION = "all";
    private static final String PREFIX = "Version_";
    private static final String TAG = "Version_Info";
    public static final String VENDOR_CODE_DEFAULT_VERSION = "0";
    public static final String VENDOR_CODE_ERROR_VERSION = "-1";
    private int mDeviceType;
    private String mVersion;
    private int mVersionType;

    public class a implements Parcelable.Creator<VersionInfo> {
        @Override // android.os.Parcelable.Creator
        public final VersionInfo createFromParcel(Parcel parcel) {
            return new VersionInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final VersionInfo[] newArray(int i10) {
            return new VersionInfo[i10];
        }
    }

    public VersionInfo(int i10, int i11, String str) {
        this.mDeviceType = i10;
        this.mVersionType = i11;
        this.mVersion = trimVersion(str);
    }

    public static String getDeviceVersion(List<VersionInfo> list) {
        String version = null;
        if (list != null && !list.isEmpty()) {
            for (VersionInfo versionInfo : list) {
                int versionType = versionInfo.getVersionType();
                if (versionType == 2 || versionType == 3) {
                    if (c.C(versionInfo.getDeviceType()) == 1) {
                        if (version == null) {
                            version = versionInfo.getVersion();
                        } else {
                            String version2 = versionInfo.getVersion();
                            if (C0912s.b(version, version2) > 0) {
                                version = version2;
                            }
                        }
                    }
                }
            }
        }
        return version;
    }

    private String trimVersion(String str) {
        return TextUtils.isEmpty(str) ? str : str.trim();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public int getVersionType() {
        return this.mVersionType;
    }

    public void update(VersionInfo versionInfo) {
        this.mDeviceType = versionInfo.mDeviceType;
        this.mVersionType = versionInfo.mVersionType;
        this.mVersion = versionInfo.mVersion;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mDeviceType);
        parcel.writeInt(this.mVersionType);
        parcel.writeString(this.mVersion);
    }

    public VersionInfo(Parcel parcel) {
        this.mDeviceType = parcel.readInt();
        this.mVersionType = parcel.readInt();
        this.mVersion = parcel.readString();
    }

    public VersionInfo(String str, String str2, String str3) {
        str.getClass();
        switch (str) {
            case "1":
                this.mDeviceType = 1;
                break;
            case "2":
                this.mDeviceType = 2;
                break;
            case "3":
                this.mDeviceType = 3;
                break;
            default:
                this.mDeviceType = 255;
                break;
        }
        try {
            this.mVersionType = Integer.parseInt(str2);
        } catch (NumberFormatException e10) {
            C1725a.h(TAG, "VersionInfo throws NumberFormatException:", e10);
        }
        this.mVersion = trimVersion(str3);
    }
}
