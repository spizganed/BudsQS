package com.oplus.melody.model.repository.earphone;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: DeviceVersionDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u0004J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006 "}, d2 = {"Lcom/oplus/melody/model/repository/earphone/DeviceVersionDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "deviceType", "", "hardware", "", "running", "backup", "vendorCode", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceType", "()I", "getHardware", "()Ljava/lang/String;", "getRunning", "getBackup", "getVendorCode", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DeviceVersionDTO extends com.oplus.melody.common.data.a implements Parcelable {
    private final String backup;
    private final int deviceType;
    private final String hardware;
    private final String running;
    private final String vendorCode;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Parcelable.Creator<DeviceVersionDTO> CREATOR = new b();

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.DeviceVersionDTO$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: DeviceVersionDTO.kt */
    public static final class Companion {
    }

    /* JADX INFO: compiled from: DeviceVersionDTO.kt */
    public static final class b implements Parcelable.Creator<DeviceVersionDTO> {
        @Override // android.os.Parcelable.Creator
        public final DeviceVersionDTO createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "parcel");
            return new DeviceVersionDTO(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final DeviceVersionDTO[] newArray(int i10) {
            return new DeviceVersionDTO[i10];
        }
    }

    public DeviceVersionDTO(int i10, String str, String str2, String str3, String str4) {
        this.deviceType = i10;
        this.hardware = str;
        this.running = str2;
        this.backup = str3;
        this.vendorCode = str4;
    }

    public static /* synthetic */ DeviceVersionDTO copy$default(DeviceVersionDTO deviceVersionDTO, int i10, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = deviceVersionDTO.deviceType;
        }
        if ((i11 & 2) != 0) {
            str = deviceVersionDTO.hardware;
        }
        if ((i11 & 4) != 0) {
            str2 = deviceVersionDTO.running;
        }
        if ((i11 & 8) != 0) {
            str3 = deviceVersionDTO.backup;
        }
        if ((i11 & 16) != 0) {
            str4 = deviceVersionDTO.vendorCode;
        }
        String str5 = str4;
        String str6 = str2;
        return deviceVersionDTO.copy(i10, str, str6, str3, str5);
    }

    public static final List<DeviceVersionDTO> fromVersionList(List<? extends VersionInfo> versionList) {
        INSTANCE.getClass();
        kotlin.jvm.internal.h.e(versionList, "versionList");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : versionList) {
            Integer numValueOf = Integer.valueOf(((VersionInfo) obj).getDeviceType());
            Object arrayList = linkedHashMap.get(numValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(numValueOf, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String version = null;
            String version2 = null;
            String version3 = null;
            String version4 = null;
            for (VersionInfo versionInfo : (List) entry.getValue()) {
                int versionType = versionInfo.getVersionType();
                if (versionType == 1) {
                    version = versionInfo.getVersion();
                } else if (versionType == 2) {
                    version2 = versionInfo.getVersion();
                } else if (versionType == 3) {
                    version3 = versionInfo.getVersion();
                } else if (versionType == 4) {
                    version4 = versionInfo.getVersion();
                }
            }
            arrayList2.add(new DeviceVersionDTO(((Number) entry.getKey()).intValue(), version, version2, version3, version4));
        }
        return arrayList2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHardware() {
        return this.hardware;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRunning() {
        return this.running;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBackup() {
        return this.backup;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getVendorCode() {
        return this.vendorCode;
    }

    public final DeviceVersionDTO copy(int deviceType, String hardware, String running, String backup, String vendorCode) {
        return new DeviceVersionDTO(deviceType, hardware, running, backup, vendorCode);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getBackup() {
        return this.backup;
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    public final String getHardware() {
        return this.hardware;
    }

    public final String getRunning() {
        return this.running;
    }

    public final String getVendorCode() {
        return this.vendorCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeInt(this.deviceType);
        dest.writeString(this.hardware);
        dest.writeString(this.running);
        dest.writeString(this.backup);
        dest.writeString(this.vendorCode);
    }
}
