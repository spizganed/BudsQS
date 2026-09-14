package com.oplus.melody.model.net.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: DevicePictureInfoDO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b5\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002BÅ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003JÇ\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010:\u001a\u00020\u0006J\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0006R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018¨\u0006@"}, d2 = {"Lcom/oplus/melody/model/net/data/DevicePictureInfoDO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "productId", "", "color", "", "boxImage", "boxImageInfo", "connectedImage", "connectedImageInfo", "leftEarImage", "leftEarImageInfo", "listImage", "listImageInfo", "rightEarImage", "rightEarImageInfo", "unconnectedImage", "unconnectedImageInfo", "upgradeImage", "upgradeImageInfo", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "getColor", "()I", "getBoxImage", "getBoxImageInfo", "getConnectedImage", "getConnectedImageInfo", "getLeftEarImage", "getLeftEarImageInfo", "getListImage", "getListImageInfo", "getRightEarImage", "getRightEarImageInfo", "getUnconnectedImage", "getUnconnectedImageInfo", "getUpgradeImage", "getUpgradeImageInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DevicePictureInfoDO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<DevicePictureInfoDO> CREATOR = new a();
    private final String boxImage;
    private final String boxImageInfo;
    private final int color;
    private final String connectedImage;
    private final String connectedImageInfo;
    private final String leftEarImage;
    private final String leftEarImageInfo;
    private final String listImage;
    private final String listImageInfo;
    private final String productId;
    private final String rightEarImage;
    private final String rightEarImageInfo;
    private final String unconnectedImage;
    private final String unconnectedImageInfo;
    private final String upgradeImage;
    private final String upgradeImageInfo;

    /* JADX INFO: compiled from: DevicePictureInfoDO.kt */
    public static final class a implements Parcelable.Creator<DevicePictureInfoDO> {
        @Override // android.os.Parcelable.Creator
        public final DevicePictureInfoDO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new DevicePictureInfoDO(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final DevicePictureInfoDO[] newArray(int i10) {
            return new DevicePictureInfoDO[i10];
        }
    }

    public DevicePictureInfoDO() {
        this(null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getListImageInfo() {
        return this.listImageInfo;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getRightEarImage() {
        return this.rightEarImage;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getRightEarImageInfo() {
        return this.rightEarImageInfo;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getUnconnectedImage() {
        return this.unconnectedImage;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getUnconnectedImageInfo() {
        return this.unconnectedImageInfo;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getUpgradeImage() {
        return this.upgradeImage;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getUpgradeImageInfo() {
        return this.upgradeImageInfo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBoxImage() {
        return this.boxImage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBoxImageInfo() {
        return this.boxImageInfo;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getConnectedImage() {
        return this.connectedImage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getConnectedImageInfo() {
        return this.connectedImageInfo;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLeftEarImage() {
        return this.leftEarImage;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLeftEarImageInfo() {
        return this.leftEarImageInfo;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getListImage() {
        return this.listImage;
    }

    public final DevicePictureInfoDO copy(String productId, int color, String boxImage, String boxImageInfo, String connectedImage, String connectedImageInfo, String leftEarImage, String leftEarImageInfo, String listImage, String listImageInfo, String rightEarImage, String rightEarImageInfo, String unconnectedImage, String unconnectedImageInfo, String upgradeImage, String upgradeImageInfo) {
        return new DevicePictureInfoDO(productId, color, boxImage, boxImageInfo, connectedImage, connectedImageInfo, leftEarImage, leftEarImageInfo, listImage, listImageInfo, rightEarImage, rightEarImageInfo, unconnectedImage, unconnectedImageInfo, upgradeImage, upgradeImageInfo);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getBoxImage() {
        return this.boxImage;
    }

    public final String getBoxImageInfo() {
        return this.boxImageInfo;
    }

    public final int getColor() {
        return this.color;
    }

    public final String getConnectedImage() {
        return this.connectedImage;
    }

    public final String getConnectedImageInfo() {
        return this.connectedImageInfo;
    }

    public final String getLeftEarImage() {
        return this.leftEarImage;
    }

    public final String getLeftEarImageInfo() {
        return this.leftEarImageInfo;
    }

    public final String getListImage() {
        return this.listImage;
    }

    public final String getListImageInfo() {
        return this.listImageInfo;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getRightEarImage() {
        return this.rightEarImage;
    }

    public final String getRightEarImageInfo() {
        return this.rightEarImageInfo;
    }

    public final String getUnconnectedImage() {
        return this.unconnectedImage;
    }

    public final String getUnconnectedImageInfo() {
        return this.unconnectedImageInfo;
    }

    public final String getUpgradeImage() {
        return this.upgradeImage;
    }

    public final String getUpgradeImageInfo() {
        return this.upgradeImageInfo;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.productId);
        dest.writeInt(this.color);
        dest.writeString(this.boxImage);
        dest.writeString(this.boxImageInfo);
        dest.writeString(this.connectedImage);
        dest.writeString(this.connectedImageInfo);
        dest.writeString(this.leftEarImage);
        dest.writeString(this.leftEarImageInfo);
        dest.writeString(this.listImage);
        dest.writeString(this.listImageInfo);
        dest.writeString(this.rightEarImage);
        dest.writeString(this.rightEarImageInfo);
        dest.writeString(this.unconnectedImage);
        dest.writeString(this.unconnectedImageInfo);
        dest.writeString(this.upgradeImage);
        dest.writeString(this.upgradeImageInfo);
    }

    public DevicePictureInfoDO(String str, int i10, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        this.productId = str;
        this.color = i10;
        this.boxImage = str2;
        this.boxImageInfo = str3;
        this.connectedImage = str4;
        this.connectedImageInfo = str5;
        this.leftEarImage = str6;
        this.leftEarImageInfo = str7;
        this.listImage = str8;
        this.listImageInfo = str9;
        this.rightEarImage = str10;
        this.rightEarImageInfo = str11;
        this.unconnectedImage = str12;
        this.unconnectedImageInfo = str13;
        this.upgradeImage = str14;
        this.upgradeImageInfo = str15;
    }

    public /* synthetic */ DevicePictureInfoDO(String str, int i10, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i11, d dVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? -1 : i10, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : str5, (i11 & 64) != 0 ? null : str6, (i11 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? null : str7, (i11 & 256) != 0 ? null : str8, (i11 & 512) != 0 ? null : str9, (i11 & 1024) != 0 ? null : str10, (i11 & 2048) != 0 ? null : str11, (i11 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? null : str12, (i11 & 8192) != 0 ? null : str13, (i11 & 16384) != 0 ? null : str14, (i11 & 32768) != 0 ? null : str15);
    }
}
