package com.oplus.melody.model.repository.earphone;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: CapsuleCardDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011BS\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\r\u0010\u0011J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003JU\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0006\u0010+\u001a\u00020\bJ\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001e\"\u0004\b!\u0010 R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u001e\"\u0004\b\"\u0010 ¨\u00062"}, d2 = {"Lcom/oplus/melody/model/repository/earphone/CapsuleCardDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "address", "", "productName", "productId", "colorId", "", "isInEar", "", "isConnected", "isLowBattery", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZZ)V", "deviceInfo", "Lcom/oplus/melody/btsdk/api/data/DeviceInfo;", "(Lcom/oplus/melody/btsdk/api/data/DeviceInfo;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getProductName", "setProductName", "getProductId", "setProductId", "getColorId", "()I", "setColorId", "(I)V", "()Z", "setInEar", "(Z)V", "setConnected", "setLowBattery", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CapsuleCardDTO extends com.oplus.melody.common.data.a implements Parcelable {
    private static final int LOW_BATTERY_THRESHOLD = 20;
    private static final String TAG = "CapsuleCardDTO";
    private String address;
    private int colorId;
    private boolean isConnected;
    private boolean isInEar;
    private boolean isLowBattery;
    private String productId;
    private String productName;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Parcelable.Creator<CapsuleCardDTO> CREATOR = new b();

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.CapsuleCardDTO$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: CapsuleCardDTO.kt */
    public static final class Companion {
    }

    /* JADX INFO: compiled from: CapsuleCardDTO.kt */
    public static final class b implements Parcelable.Creator<CapsuleCardDTO> {
        @Override // android.os.Parcelable.Creator
        public final CapsuleCardDTO createFromParcel(Parcel parcel) {
            boolean z2;
            boolean z4;
            kotlin.jvm.internal.h.e(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            int i10 = parcel.readInt();
            boolean z10 = false;
            boolean z11 = true;
            if (parcel.readInt() != 0) {
                z2 = false;
                z10 = true;
            } else {
                z2 = false;
            }
            if (parcel.readInt() != 0) {
                z4 = true;
            } else {
                z4 = true;
                z11 = z2;
            }
            if (parcel.readInt() == 0) {
                z4 = z2;
            }
            return new CapsuleCardDTO(string, string2, string3, i10, z10, z11, z4);
        }

        @Override // android.os.Parcelable.Creator
        public final CapsuleCardDTO[] newArray(int i10) {
            return new CapsuleCardDTO[i10];
        }
    }

    public CapsuleCardDTO() {
        this(null, null, null, 0, false, false, false, 127, null);
    }

    public static /* synthetic */ CapsuleCardDTO copy$default(CapsuleCardDTO capsuleCardDTO, String str, String str2, String str3, int i10, boolean z2, boolean z4, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = capsuleCardDTO.address;
        }
        if ((i11 & 2) != 0) {
            str2 = capsuleCardDTO.productName;
        }
        if ((i11 & 4) != 0) {
            str3 = capsuleCardDTO.productId;
        }
        if ((i11 & 8) != 0) {
            i10 = capsuleCardDTO.colorId;
        }
        if ((i11 & 16) != 0) {
            z2 = capsuleCardDTO.isInEar;
        }
        if ((i11 & 32) != 0) {
            z4 = capsuleCardDTO.isConnected;
        }
        if ((i11 & 64) != 0) {
            z10 = capsuleCardDTO.isLowBattery;
        }
        boolean z11 = z4;
        boolean z12 = z10;
        boolean z13 = z2;
        String str4 = str3;
        return capsuleCardDTO.copy(str, str2, str4, i10, z13, z11, z12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProductName() {
        return this.productName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getColorId() {
        return this.colorId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsInEar() {
        return this.isInEar;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsConnected() {
        return this.isConnected;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsLowBattery() {
        return this.isLowBattery;
    }

    public final CapsuleCardDTO copy(String address, String productName, String productId, int colorId, boolean isInEar, boolean isConnected, boolean isLowBattery) {
        return new CapsuleCardDTO(address, productName, productId, colorId, isInEar, isConnected, isLowBattery);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getColorId() {
        return this.colorId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isInEar() {
        return this.isInEar;
    }

    public final boolean isLowBattery() {
        return this.isLowBattery;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setColorId(int i10) {
        this.colorId = i10;
    }

    public final void setConnected(boolean z2) {
        this.isConnected = z2;
    }

    public final void setInEar(boolean z2) {
        this.isInEar = z2;
    }

    public final void setLowBattery(boolean z2) {
        this.isLowBattery = z2;
    }

    public final void setProductId(String str) {
        this.productId = str;
    }

    public final void setProductName(String str) {
        this.productName = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeString(this.address);
        dest.writeString(this.productName);
        dest.writeString(this.productId);
        dest.writeInt(this.colorId);
        dest.writeInt(this.isInEar ? 1 : 0);
        dest.writeInt(this.isConnected ? 1 : 0);
        dest.writeInt(this.isLowBattery ? 1 : 0);
    }

    public CapsuleCardDTO(String str, String str2, String str3, int i10, boolean z2, boolean z4, boolean z10) {
        this.address = str;
        this.productName = str2;
        this.productId = str3;
        this.colorId = i10;
        this.isInEar = z2;
        this.isConnected = z4;
        this.isLowBattery = z10;
    }

    public /* synthetic */ CapsuleCardDTO(String str, String str2, String str3, int i10, boolean z2, boolean z4, boolean z10, int i11, kotlin.jvm.internal.d dVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? 0 : i10, (i11 & 16) != 0 ? false : z2, (i11 & 32) != 0 ? false : z4, (i11 & 64) != 0 ? false : z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CapsuleCardDTO(com.oplus.melody.btsdk.api.data.DeviceInfo r17) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.model.repository.earphone.CapsuleCardDTO.<init>(com.oplus.melody.btsdk.api.data.DeviceInfo):void");
    }
}
