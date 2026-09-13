package com.oplus.melody.model.repository.earphone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: BoxCoverActionDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B_\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u000eHÆ\u0003Ja\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0006\u00100\u001a\u00020\u0007J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u001b\"\u0004\b\u001e\u0010\u001dR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00066"}, d2 = {"Lcom/oplus/melody/model/repository/earphone/BoxCoverActionDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "macAddress", "", "productId", "productColor", "", "isBoxOpen", "", "isSupportBindAccount", "accountKey", "deviceName", "actionTimeMillis", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZZLjava/lang/String;Ljava/lang/String;J)V", "getMacAddress", "()Ljava/lang/String;", "setMacAddress", "(Ljava/lang/String;)V", "getProductId", "setProductId", "getProductColor", "()I", "setProductColor", "(I)V", "()Z", "setBoxOpen", "(Z)V", "setSupportBindAccount", "getAccountKey", "setAccountKey", "getDeviceName", "setDeviceName", "getActionTimeMillis", "()J", "setActionTimeMillis", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class BoxCoverActionDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<BoxCoverActionDTO> CREATOR = new a();
    private String accountKey;
    private long actionTimeMillis;
    private String deviceName;
    private boolean isBoxOpen;
    private boolean isSupportBindAccount;
    private String macAddress;
    private int productColor;
    private String productId;

    /* JADX INFO: compiled from: BoxCoverActionDTO.kt */
    public static final class a implements Parcelable.Creator<BoxCoverActionDTO> {
        @Override // android.os.Parcelable.Creator
        public final BoxCoverActionDTO createFromParcel(Parcel parcel) {
            boolean z2;
            kotlin.jvm.internal.h.e(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i10 = parcel.readInt();
            boolean z4 = false;
            if (parcel.readInt() != 0) {
                z2 = false;
                z4 = true;
            } else {
                z2 = false;
            }
            return new BoxCoverActionDTO(string, string2, i10, z4, parcel.readInt() == 0 ? z2 : true, parcel.readString(), parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final BoxCoverActionDTO[] newArray(int i10) {
            return new BoxCoverActionDTO[i10];
        }
    }

    public BoxCoverActionDTO() {
        this(null, null, 0, false, false, null, null, 0L, 255, null);
    }

    public static /* synthetic */ BoxCoverActionDTO copy$default(BoxCoverActionDTO boxCoverActionDTO, String str, String str2, int i10, boolean z2, boolean z4, String str3, String str4, long j5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = boxCoverActionDTO.macAddress;
        }
        if ((i11 & 2) != 0) {
            str2 = boxCoverActionDTO.productId;
        }
        if ((i11 & 4) != 0) {
            i10 = boxCoverActionDTO.productColor;
        }
        if ((i11 & 8) != 0) {
            z2 = boxCoverActionDTO.isBoxOpen;
        }
        if ((i11 & 16) != 0) {
            z4 = boxCoverActionDTO.isSupportBindAccount;
        }
        if ((i11 & 32) != 0) {
            str3 = boxCoverActionDTO.accountKey;
        }
        if ((i11 & 64) != 0) {
            str4 = boxCoverActionDTO.deviceName;
        }
        if ((i11 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0) {
            j5 = boxCoverActionDTO.actionTimeMillis;
        }
        long j9 = j5;
        String str5 = str3;
        String str6 = str4;
        boolean z10 = z4;
        int i12 = i10;
        return boxCoverActionDTO.copy(str, str2, i12, z2, z10, str5, str6, j9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMacAddress() {
        return this.macAddress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getProductColor() {
        return this.productColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsBoxOpen() {
        return this.isBoxOpen;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsSupportBindAccount() {
        return this.isSupportBindAccount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAccountKey() {
        return this.accountKey;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getActionTimeMillis() {
        return this.actionTimeMillis;
    }

    public final BoxCoverActionDTO copy(String macAddress, String productId, int productColor, boolean isBoxOpen, boolean isSupportBindAccount, String accountKey, String deviceName, long actionTimeMillis) {
        return new BoxCoverActionDTO(macAddress, productId, productColor, isBoxOpen, isSupportBindAccount, accountKey, deviceName, actionTimeMillis);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAccountKey() {
        return this.accountKey;
    }

    public final long getActionTimeMillis() {
        return this.actionTimeMillis;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getMacAddress() {
        return this.macAddress;
    }

    public final int getProductColor() {
        return this.productColor;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final boolean isBoxOpen() {
        return this.isBoxOpen;
    }

    public final boolean isSupportBindAccount() {
        return this.isSupportBindAccount;
    }

    public final void setAccountKey(String str) {
        this.accountKey = str;
    }

    public final void setActionTimeMillis(long j5) {
        this.actionTimeMillis = j5;
    }

    public final void setBoxOpen(boolean z2) {
        this.isBoxOpen = z2;
    }

    public final void setDeviceName(String str) {
        this.deviceName = str;
    }

    public final void setMacAddress(String str) {
        this.macAddress = str;
    }

    public final void setProductColor(int i10) {
        this.productColor = i10;
    }

    public final void setProductId(String str) {
        this.productId = str;
    }

    public final void setSupportBindAccount(boolean z2) {
        this.isSupportBindAccount = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeString(this.macAddress);
        dest.writeString(this.productId);
        dest.writeInt(this.productColor);
        dest.writeInt(this.isBoxOpen ? 1 : 0);
        dest.writeInt(this.isSupportBindAccount ? 1 : 0);
        dest.writeString(this.accountKey);
        dest.writeString(this.deviceName);
        dest.writeLong(this.actionTimeMillis);
    }

    public BoxCoverActionDTO(String str, String str2, int i10, boolean z2, boolean z4, String str3, String str4, long j5) {
        this.macAddress = str;
        this.productId = str2;
        this.productColor = i10;
        this.isBoxOpen = z2;
        this.isSupportBindAccount = z4;
        this.accountKey = str3;
        this.deviceName = str4;
        this.actionTimeMillis = j5;
    }

    public /* synthetic */ BoxCoverActionDTO(String str, String str2, int i10, boolean z2, boolean z4, String str3, String str4, long j5, int i11, kotlin.jvm.internal.d dVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? false : z2, (i11 & 16) != 0 ? false : z4, (i11 & 32) != 0 ? null : str3, (i11 & 64) != 0 ? null : str4, (i11 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? SystemClock.elapsedRealtime() : j5);
    }
}
