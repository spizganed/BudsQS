package com.oplus.melody.btsdk.manager.support;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: SupportDeviceConfig.kt */
/* JADX INFO: loaded from: classes.dex */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BQ\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u000e\u0010\u0012J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003Jc\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001J\u0006\u0010&\u001a\u00020\tJ\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\tR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001bR\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019¨\u0006,"}, d2 = {"Lcom/oplus/melody/btsdk/manager/support/SupportDeviceConfig;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "id", "", "name", "brand", SpeechFindManager.TYPE, "minRssi", "", "uuid", "isSupportSpp", "", "defaultColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZI)V", "config", "Lcom/oplus/melody/common/data/WhitelistConfigDTO;", "(Lcom/oplus/melody/common/data/WhitelistConfigDTO;)V", "getId", "()Ljava/lang/String;", "getName", "getBrand", "getType", "getMinRssi", "()I", "getUuid", "()Z", "getDefaultColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SupportDeviceConfig extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<SupportDeviceConfig> CREATOR = new a();
    private final String brand;
    private final int defaultColor;
    private final String id;
    private final boolean isSupportSpp;
    private final int minRssi;
    private final String name;
    private final String type;
    private final String uuid;

    /* JADX INFO: compiled from: SupportDeviceConfig.kt */
    public static final class a implements Parcelable.Creator<SupportDeviceConfig> {
        @Override // android.os.Parcelable.Creator
        public final SupportDeviceConfig createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new SupportDeviceConfig(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final SupportDeviceConfig[] newArray(int i10) {
            return new SupportDeviceConfig[i10];
        }
    }

    public SupportDeviceConfig(String str, String str2, String str3, String str4, int i10, String str5, boolean z2, int i11) {
        this.id = str;
        this.name = str2;
        this.brand = str3;
        this.type = str4;
        this.minRssi = i10;
        this.uuid = str5;
        this.isSupportSpp = z2;
        this.defaultColor = i11;
    }

    public static /* synthetic */ SupportDeviceConfig copy$default(SupportDeviceConfig supportDeviceConfig, String str, String str2, String str3, String str4, int i10, String str5, boolean z2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = supportDeviceConfig.id;
        }
        if ((i12 & 2) != 0) {
            str2 = supportDeviceConfig.name;
        }
        if ((i12 & 4) != 0) {
            str3 = supportDeviceConfig.brand;
        }
        if ((i12 & 8) != 0) {
            str4 = supportDeviceConfig.type;
        }
        if ((i12 & 16) != 0) {
            i10 = supportDeviceConfig.minRssi;
        }
        if ((i12 & 32) != 0) {
            str5 = supportDeviceConfig.uuid;
        }
        if ((i12 & 64) != 0) {
            z2 = supportDeviceConfig.isSupportSpp;
        }
        if ((i12 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0) {
            i11 = supportDeviceConfig.defaultColor;
        }
        boolean z4 = z2;
        int i13 = i11;
        int i14 = i10;
        String str6 = str5;
        return supportDeviceConfig.copy(str, str2, str3, str4, i14, str6, z4, i13);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBrand() {
        return this.brand;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getMinRssi() {
        return this.minRssi;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsSupportSpp() {
        return this.isSupportSpp;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getDefaultColor() {
        return this.defaultColor;
    }

    public final SupportDeviceConfig copy(String id, String name, String brand, String type, int minRssi, String uuid, boolean isSupportSpp, int defaultColor) {
        return new SupportDeviceConfig(id, name, brand, type, minRssi, uuid, isSupportSpp, defaultColor);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final int getDefaultColor() {
        return this.defaultColor;
    }

    public final String getId() {
        return this.id;
    }

    public final int getMinRssi() {
        return this.minRssi;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final boolean isSupportSpp() {
        return this.isSupportSpp;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.brand);
        dest.writeString(this.type);
        dest.writeInt(this.minRssi);
        dest.writeString(this.uuid);
        dest.writeInt(this.isSupportSpp ? 1 : 0);
        dest.writeInt(this.defaultColor);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SupportDeviceConfig(WhitelistConfigDTO config) {
        this(config.getId(), config.getName(), config.getBrand(), config.getType(), config.getMinRssi(), config.getUuid(), config.getSupportSpp(), config.getDefaultColor());
        h.e(config, "config");
    }
}
