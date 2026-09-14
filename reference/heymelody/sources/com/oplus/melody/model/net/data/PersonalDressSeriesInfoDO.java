package com.oplus.melody.model.net.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: PersonalDressSeriesInfoDO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bs\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003Jz\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010*J\u0006\u0010+\u001a\u00020\u0004J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0004R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015¨\u00061"}, d2 = {"Lcom/oplus/melody/model/net/data/PersonalDressSeriesInfoDO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "id", "", "identifyId", "", "seriesName", "summary", ClientDataEntity.COL_PRIORITY, "themeCount", "bannerImgUrl", "createTime", "updateTime", "bottomColor", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIdentifyId", "()Ljava/lang/String;", "getSeriesName", "getSummary", "getPriority", "()I", "getThemeCount", "getBannerImgUrl", "getCreateTime", "getUpdateTime", "getBottomColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/oplus/melody/model/net/data/PersonalDressSeriesInfoDO;", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PersonalDressSeriesInfoDO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<PersonalDressSeriesInfoDO> CREATOR = new a();
    private final String bannerImgUrl;
    private final String bottomColor;
    private final String createTime;
    private final Integer id;
    private final String identifyId;
    private final int priority;
    private final String seriesName;
    private final String summary;
    private final int themeCount;
    private final String updateTime;

    /* JADX INFO: compiled from: PersonalDressSeriesInfoDO.kt */
    public static final class a implements Parcelable.Creator<PersonalDressSeriesInfoDO> {
        @Override // android.os.Parcelable.Creator
        public final PersonalDressSeriesInfoDO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new PersonalDressSeriesInfoDO(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PersonalDressSeriesInfoDO[] newArray(int i10) {
            return new PersonalDressSeriesInfoDO[i10];
        }
    }

    public PersonalDressSeriesInfoDO() {
        this(null, null, null, null, 0, 0, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ PersonalDressSeriesInfoDO copy$default(PersonalDressSeriesInfoDO personalDressSeriesInfoDO, Integer num, String str, String str2, String str3, int i10, int i11, String str4, String str5, String str6, String str7, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            num = personalDressSeriesInfoDO.id;
        }
        if ((i12 & 2) != 0) {
            str = personalDressSeriesInfoDO.identifyId;
        }
        if ((i12 & 4) != 0) {
            str2 = personalDressSeriesInfoDO.seriesName;
        }
        if ((i12 & 8) != 0) {
            str3 = personalDressSeriesInfoDO.summary;
        }
        if ((i12 & 16) != 0) {
            i10 = personalDressSeriesInfoDO.priority;
        }
        if ((i12 & 32) != 0) {
            i11 = personalDressSeriesInfoDO.themeCount;
        }
        if ((i12 & 64) != 0) {
            str4 = personalDressSeriesInfoDO.bannerImgUrl;
        }
        if ((i12 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0) {
            str5 = personalDressSeriesInfoDO.createTime;
        }
        if ((i12 & 256) != 0) {
            str6 = personalDressSeriesInfoDO.updateTime;
        }
        if ((i12 & 512) != 0) {
            str7 = personalDressSeriesInfoDO.bottomColor;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str4;
        String str11 = str5;
        int i13 = i10;
        int i14 = i11;
        return personalDressSeriesInfoDO.copy(num, str, str2, str3, i13, i14, str10, str11, str8, str9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getBottomColor() {
        return this.bottomColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIdentifyId() {
        return this.identifyId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSeriesName() {
        return this.seriesName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getThemeCount() {
        return this.themeCount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getBannerImgUrl() {
        return this.bannerImgUrl;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCreateTime() {
        return this.createTime;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final PersonalDressSeriesInfoDO copy(Integer id, String identifyId, String seriesName, String summary, int priority, int themeCount, String bannerImgUrl, String createTime, String updateTime, String bottomColor) {
        h.e(bannerImgUrl, "bannerImgUrl");
        h.e(createTime, "createTime");
        h.e(updateTime, "updateTime");
        h.e(bottomColor, "bottomColor");
        return new PersonalDressSeriesInfoDO(id, identifyId, seriesName, summary, priority, themeCount, bannerImgUrl, createTime, updateTime, bottomColor);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getBannerImgUrl() {
        return this.bannerImgUrl;
    }

    public final String getBottomColor() {
        return this.bottomColor;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getIdentifyId() {
        return this.identifyId;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getSeriesName() {
        return this.seriesName;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final int getThemeCount() {
        return this.themeCount;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        int iIntValue;
        h.e(dest, "dest");
        Integer num = this.id;
        if (num == null) {
            iIntValue = 0;
        } else {
            dest.writeInt(1);
            iIntValue = num.intValue();
        }
        dest.writeInt(iIntValue);
        dest.writeString(this.identifyId);
        dest.writeString(this.seriesName);
        dest.writeString(this.summary);
        dest.writeInt(this.priority);
        dest.writeInt(this.themeCount);
        dest.writeString(this.bannerImgUrl);
        dest.writeString(this.createTime);
        dest.writeString(this.updateTime);
        dest.writeString(this.bottomColor);
    }

    public PersonalDressSeriesInfoDO(Integer num, String str, String str2, String str3, int i10, int i11, String bannerImgUrl, String createTime, String updateTime, String bottomColor) {
        h.e(bannerImgUrl, "bannerImgUrl");
        h.e(createTime, "createTime");
        h.e(updateTime, "updateTime");
        h.e(bottomColor, "bottomColor");
        this.id = num;
        this.identifyId = str;
        this.seriesName = str2;
        this.summary = str3;
        this.priority = i10;
        this.themeCount = i11;
        this.bannerImgUrl = bannerImgUrl;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.bottomColor = bottomColor;
    }

    public /* synthetic */ PersonalDressSeriesInfoDO(Integer num, String str, String str2, String str3, int i10, int i11, String str4, String str5, String str6, String str7, int i12, d dVar) {
        this((i12 & 1) != 0 ? null : num, (i12 & 2) != 0 ? null : str, (i12 & 4) != 0 ? null : str2, (i12 & 8) != 0 ? null : str3, (i12 & 16) != 0 ? 0 : i10, (i12 & 32) != 0 ? 0 : i11, (i12 & 64) != 0 ? "" : str4, (i12 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? "" : str5, (i12 & 256) != 0 ? "" : str6, (i12 & 512) != 0 ? "" : str7);
    }
}
