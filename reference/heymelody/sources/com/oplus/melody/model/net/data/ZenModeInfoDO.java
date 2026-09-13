package com.oplus.melody.model.net.data;

import I3.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: ZenModeInfoDO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b0\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BÍ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00103\u001a\u00020\rHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00106\u001a\u00020\rHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003JÏ\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010=\u001a\u00020>J\u0016\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020>R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0016\u0010\u0010\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019¨\u0006D"}, d2 = {"Lcom/oplus/melody/model/net/data/ZenModeInfoDO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "randomId", "", "resId", "name", "description", "imgUrl", "backgroundUrl", "audioUrl", "audioSha256", "audioDownloadSize", "", "audioBinUrl", "audioBinSha256", "audioBinDownloadSize", "createTime", "updateTime", "md5", "productId", "color", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRandomId", "()Ljava/lang/String;", "getResId", "getName", "getDescription", "getImgUrl", "getBackgroundUrl", "getAudioUrl", "getAudioSha256", "getAudioDownloadSize", "()J", "getAudioBinUrl", "getAudioBinSha256", "getAudioBinDownloadSize", "getCreateTime", "getUpdateTime", "getMd5", "getProductId", "getColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ZenModeInfoDO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<ZenModeInfoDO> CREATOR = new a();

    @b("audioBinDownloadSize")
    private final long audioBinDownloadSize;

    @b("audioBinSha256")
    private final String audioBinSha256;

    @b("audioBinUrl")
    private final String audioBinUrl;

    @b("audioDownloadSize")
    private final long audioDownloadSize;

    @b("audioSha256")
    private final String audioSha256;

    @b("audioUrl")
    private final String audioUrl;

    @b("backgroundUrl")
    private final String backgroundUrl;

    @b("color")
    private final String color;

    @b("createTime")
    private final String createTime;

    @b("description")
    private final String description;

    @b("imgUrl")
    private final String imgUrl;

    @b("md5")
    private final String md5;

    @b("name")
    private final String name;

    @b("productId")
    private final String productId;

    @b("id")
    private final String randomId;

    @b("resourceId")
    private final String resId;

    @b("updateTime")
    private final String updateTime;

    /* JADX INFO: compiled from: ZenModeInfoDO.kt */
    public static final class a implements Parcelable.Creator<ZenModeInfoDO> {
        @Override // android.os.Parcelable.Creator
        public final ZenModeInfoDO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new ZenModeInfoDO(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ZenModeInfoDO[] newArray(int i10) {
            return new ZenModeInfoDO[i10];
        }
    }

    public ZenModeInfoDO() {
        this(null, null, null, null, null, null, null, null, 0L, null, null, 0L, null, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ ZenModeInfoDO copy$default(ZenModeInfoDO zenModeInfoDO, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, long j5, String str9, String str10, long j9, String str11, String str12, String str13, String str14, String str15, int i10, Object obj) {
        String str16;
        String str17;
        String str18 = (i10 & 1) != 0 ? zenModeInfoDO.randomId : str;
        String str19 = (i10 & 2) != 0 ? zenModeInfoDO.resId : str2;
        String str20 = (i10 & 4) != 0 ? zenModeInfoDO.name : str3;
        String str21 = (i10 & 8) != 0 ? zenModeInfoDO.description : str4;
        String str22 = (i10 & 16) != 0 ? zenModeInfoDO.imgUrl : str5;
        String str23 = (i10 & 32) != 0 ? zenModeInfoDO.backgroundUrl : str6;
        String str24 = (i10 & 64) != 0 ? zenModeInfoDO.audioUrl : str7;
        String str25 = (i10 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? zenModeInfoDO.audioSha256 : str8;
        long j10 = (i10 & 256) != 0 ? zenModeInfoDO.audioDownloadSize : j5;
        String str26 = (i10 & 512) != 0 ? zenModeInfoDO.audioBinUrl : str9;
        String str27 = (i10 & 1024) != 0 ? zenModeInfoDO.audioBinSha256 : str10;
        long j11 = (i10 & 2048) != 0 ? zenModeInfoDO.audioBinDownloadSize : j9;
        String str28 = str18;
        String str29 = (i10 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? zenModeInfoDO.createTime : str11;
        String str30 = (i10 & 8192) != 0 ? zenModeInfoDO.updateTime : str12;
        String str31 = (i10 & 16384) != 0 ? zenModeInfoDO.md5 : str13;
        String str32 = (i10 & 32768) != 0 ? zenModeInfoDO.productId : str14;
        if ((i10 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0) {
            str17 = str32;
            str16 = zenModeInfoDO.color;
        } else {
            str16 = str15;
            str17 = str32;
        }
        return zenModeInfoDO.copy(str28, str19, str20, str21, str22, str23, str24, str25, j10, str26, str27, j11, str29, str30, str31, str17, str16);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRandomId() {
        return this.randomId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getAudioBinUrl() {
        return this.audioBinUrl;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getAudioBinSha256() {
        return this.audioBinSha256;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getAudioBinDownloadSize() {
        return this.audioBinDownloadSize;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getCreateTime() {
        return this.createTime;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getUpdateTime() {
        return this.updateTime;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getResId() {
        return this.resId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getImgUrl() {
        return this.imgUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAudioUrl() {
        return this.audioUrl;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAudioSha256() {
        return this.audioSha256;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getAudioDownloadSize() {
        return this.audioDownloadSize;
    }

    public final ZenModeInfoDO copy(String randomId, String resId, String name, String description, String imgUrl, String backgroundUrl, String audioUrl, String audioSha256, long audioDownloadSize, String audioBinUrl, String audioBinSha256, long audioBinDownloadSize, String createTime, String updateTime, String md5, String productId, String color) {
        h.e(resId, "resId");
        return new ZenModeInfoDO(randomId, resId, name, description, imgUrl, backgroundUrl, audioUrl, audioSha256, audioDownloadSize, audioBinUrl, audioBinSha256, audioBinDownloadSize, createTime, updateTime, md5, productId, color);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final long getAudioBinDownloadSize() {
        return this.audioBinDownloadSize;
    }

    public final String getAudioBinSha256() {
        return this.audioBinSha256;
    }

    public final String getAudioBinUrl() {
        return this.audioBinUrl;
    }

    public final long getAudioDownloadSize() {
        return this.audioDownloadSize;
    }

    public final String getAudioSha256() {
        return this.audioSha256;
    }

    public final String getAudioUrl() {
        return this.audioUrl;
    }

    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getImgUrl() {
        return this.imgUrl;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getName() {
        return this.name;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getRandomId() {
        return this.randomId;
    }

    public final String getResId() {
        return this.resId;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.randomId);
        dest.writeString(this.resId);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.imgUrl);
        dest.writeString(this.backgroundUrl);
        dest.writeString(this.audioUrl);
        dest.writeString(this.audioSha256);
        dest.writeLong(this.audioDownloadSize);
        dest.writeString(this.audioBinUrl);
        dest.writeString(this.audioBinSha256);
        dest.writeLong(this.audioBinDownloadSize);
        dest.writeString(this.createTime);
        dest.writeString(this.updateTime);
        dest.writeString(this.md5);
        dest.writeString(this.productId);
        dest.writeString(this.color);
    }

    public ZenModeInfoDO(String str, String resId, String str2, String str3, String str4, String str5, String str6, String str7, long j5, String str8, String str9, long j9, String str10, String str11, String str12, String str13, String str14) {
        h.e(resId, "resId");
        this.randomId = str;
        this.resId = resId;
        this.name = str2;
        this.description = str3;
        this.imgUrl = str4;
        this.backgroundUrl = str5;
        this.audioUrl = str6;
        this.audioSha256 = str7;
        this.audioDownloadSize = j5;
        this.audioBinUrl = str8;
        this.audioBinSha256 = str9;
        this.audioBinDownloadSize = j9;
        this.createTime = str10;
        this.updateTime = str11;
        this.md5 = str12;
        this.productId = str13;
        this.color = str14;
    }

    public /* synthetic */ ZenModeInfoDO(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, long j5, String str9, String str10, long j9, String str11, String str12, String str13, String str14, String str15, int i10, d dVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : str7, (i10 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? null : str8, (i10 & 256) != 0 ? 0L : j5, (i10 & 512) != 0 ? null : str9, (i10 & 1024) != 0 ? null : str10, (i10 & 2048) == 0 ? j9 : 0L, (i10 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? null : str11, (i10 & 8192) != 0 ? null : str12, (i10 & 16384) != 0 ? null : str13, (i10 & 32768) != 0 ? null : str14, (i10 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? null : str15);
    }
}
