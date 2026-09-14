package com.oplus.melody.model.repository.personaldress;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: DressSeriesDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\"B/\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0006\u0010\u001c\u001a\u00020\u0006J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/oplus/melody/model/repository/personaldress/DressSeriesDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "productId", "", "color", "", "seriesList", "", "Lcom/oplus/melody/model/repository/personaldress/DressSeriesDTO$SeriesData;", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "getColor", "()I", "setColor", "(I)V", "getSeriesList", "()Ljava/util/List;", "setSeriesList", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "SeriesData", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DressSeriesDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<DressSeriesDTO> CREATOR = new a();
    private int color;
    private String productId;
    private List<SeriesData> seriesList;

    /* JADX INFO: compiled from: DressSeriesDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010 \n\u0002\b1\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u00ad\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u00105\u001a\u00020\u0004HÆ\u0003J\t\u00106\u001a\u00020\u0004HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003J\u0017\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003J\t\u0010:\u001a\u00020\u0004HÆ\u0003J\t\u0010;\u001a\u00020\u0004HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012HÆ\u0003J¯\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012HÆ\u0001J\u0006\u0010B\u001a\u00020\u0004J\u0016\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006H"}, d2 = {"Lcom/oplus/melody/model/repository/personaldress/DressSeriesDTO$SeriesData;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "primaryId", "", "id", "identifyId", "", "seriesName", "", "summary", ClientDataEntity.COL_PRIORITY, "themeCount", "bannerImgUrl", "createTime", "updateTime", "bottomColor", "themeIdList", "", "<init>", "(IILjava/lang/String;Ljava/util/Map;Ljava/util/Map;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getPrimaryId", "()I", "setPrimaryId", "(I)V", "getId", "setId", "getIdentifyId", "()Ljava/lang/String;", "setIdentifyId", "(Ljava/lang/String;)V", "getSeriesName", "()Ljava/util/Map;", "setSeriesName", "(Ljava/util/Map;)V", "getSummary", "setSummary", "getPriority", "setPriority", "getThemeCount", "setThemeCount", "getBannerImgUrl", "setBannerImgUrl", "getCreateTime", "setCreateTime", "getUpdateTime", "setUpdateTime", "getBottomColor", "setBottomColor", "getThemeIdList", "()Ljava/util/List;", "setThemeIdList", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SeriesData extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<SeriesData> CREATOR = new a();
        private String bannerImgUrl;
        private String bottomColor;
        private String createTime;
        private int id;
        private String identifyId;
        private int primaryId;
        private int priority;
        private Map<String, String> seriesName;
        private Map<String, String> summary;
        private int themeCount;
        private List<String> themeIdList;
        private String updateTime;

        /* JADX INFO: compiled from: DressSeriesDTO.kt */
        public static final class a implements Parcelable.Creator<SeriesData> {
            @Override // android.os.Parcelable.Creator
            public final SeriesData createFromParcel(Parcel parcel) {
                LinkedHashMap linkedHashMap;
                h.e(parcel, "parcel");
                int i10 = parcel.readInt();
                int i11 = parcel.readInt();
                String string = parcel.readString();
                LinkedHashMap linkedHashMap2 = null;
                if (parcel.readInt() == 0) {
                    linkedHashMap = null;
                } else {
                    int i12 = parcel.readInt();
                    linkedHashMap = new LinkedHashMap(i12);
                    for (int i13 = 0; i13 != i12; i13++) {
                        linkedHashMap.put(parcel.readString(), parcel.readString());
                    }
                }
                if (parcel.readInt() != 0) {
                    int i14 = parcel.readInt();
                    linkedHashMap2 = new LinkedHashMap(i14);
                    for (int i15 = 0; i15 != i14; i15++) {
                        linkedHashMap2.put(parcel.readString(), parcel.readString());
                    }
                }
                return new SeriesData(i10, i11, string, linkedHashMap, linkedHashMap2, parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            public final SeriesData[] newArray(int i10) {
                return new SeriesData[i10];
            }
        }

        public SeriesData() {
            this(0, 0, null, null, null, 0, 0, null, null, null, null, null, 4095, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SeriesData copy$default(SeriesData seriesData, int i10, int i11, String str, Map map, Map map2, int i12, int i13, String str2, String str3, String str4, String str5, List list, int i14, Object obj) {
            if ((i14 & 1) != 0) {
                i10 = seriesData.primaryId;
            }
            if ((i14 & 2) != 0) {
                i11 = seriesData.id;
            }
            if ((i14 & 4) != 0) {
                str = seriesData.identifyId;
            }
            if ((i14 & 8) != 0) {
                map = seriesData.seriesName;
            }
            if ((i14 & 16) != 0) {
                map2 = seriesData.summary;
            }
            if ((i14 & 32) != 0) {
                i12 = seriesData.priority;
            }
            if ((i14 & 64) != 0) {
                i13 = seriesData.themeCount;
            }
            if ((i14 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0) {
                str2 = seriesData.bannerImgUrl;
            }
            if ((i14 & 256) != 0) {
                str3 = seriesData.createTime;
            }
            if ((i14 & 512) != 0) {
                str4 = seriesData.updateTime;
            }
            if ((i14 & 1024) != 0) {
                str5 = seriesData.bottomColor;
            }
            if ((i14 & 2048) != 0) {
                list = seriesData.themeIdList;
            }
            String str6 = str5;
            List list2 = list;
            String str7 = str3;
            String str8 = str4;
            int i15 = i13;
            String str9 = str2;
            Map map3 = map2;
            int i16 = i12;
            return seriesData.copy(i10, i11, str, map, map3, i16, i15, str9, str7, str8, str6, list2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPrimaryId() {
            return this.primaryId;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getUpdateTime() {
            return this.updateTime;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getBottomColor() {
            return this.bottomColor;
        }

        public final List<String> component12() {
            return this.themeIdList;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getIdentifyId() {
            return this.identifyId;
        }

        public final Map<String, String> component4() {
            return this.seriesName;
        }

        public final Map<String, String> component5() {
            return this.summary;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getPriority() {
            return this.priority;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getThemeCount() {
            return this.themeCount;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getBannerImgUrl() {
            return this.bannerImgUrl;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getCreateTime() {
            return this.createTime;
        }

        public final SeriesData copy(int primaryId, int id, String identifyId, Map<String, String> seriesName, Map<String, String> summary, int priority, int themeCount, String bannerImgUrl, String createTime, String updateTime, String bottomColor, List<String> themeIdList) {
            return new SeriesData(primaryId, id, identifyId, seriesName, summary, priority, themeCount, bannerImgUrl, createTime, updateTime, bottomColor, themeIdList);
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

        public final int getId() {
            return this.id;
        }

        public final String getIdentifyId() {
            return this.identifyId;
        }

        public final int getPrimaryId() {
            return this.primaryId;
        }

        public final int getPriority() {
            return this.priority;
        }

        public final Map<String, String> getSeriesName() {
            return this.seriesName;
        }

        public final Map<String, String> getSummary() {
            return this.summary;
        }

        public final int getThemeCount() {
            return this.themeCount;
        }

        public final List<String> getThemeIdList() {
            return this.themeIdList;
        }

        public final String getUpdateTime() {
            return this.updateTime;
        }

        public final void setBannerImgUrl(String str) {
            this.bannerImgUrl = str;
        }

        public final void setBottomColor(String str) {
            this.bottomColor = str;
        }

        public final void setCreateTime(String str) {
            this.createTime = str;
        }

        public final void setId(int i10) {
            this.id = i10;
        }

        public final void setIdentifyId(String str) {
            this.identifyId = str;
        }

        public final void setPrimaryId(int i10) {
            this.primaryId = i10;
        }

        public final void setPriority(int i10) {
            this.priority = i10;
        }

        public final void setSeriesName(Map<String, String> map) {
            this.seriesName = map;
        }

        public final void setSummary(Map<String, String> map) {
            this.summary = map;
        }

        public final void setThemeCount(int i10) {
            this.themeCount = i10;
        }

        public final void setThemeIdList(List<String> list) {
            this.themeIdList = list;
        }

        public final void setUpdateTime(String str) {
            this.updateTime = str;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.primaryId);
            dest.writeInt(this.id);
            dest.writeString(this.identifyId);
            Map<String, String> map = this.seriesName;
            if (map == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                dest.writeInt(map.size());
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    dest.writeString(entry.getKey());
                    dest.writeString(entry.getValue());
                }
            }
            Map<String, String> map2 = this.summary;
            if (map2 == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                dest.writeInt(map2.size());
                for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                    dest.writeString(entry2.getKey());
                    dest.writeString(entry2.getValue());
                }
            }
            dest.writeInt(this.priority);
            dest.writeInt(this.themeCount);
            dest.writeString(this.bannerImgUrl);
            dest.writeString(this.createTime);
            dest.writeString(this.updateTime);
            dest.writeString(this.bottomColor);
            dest.writeStringList(this.themeIdList);
        }

        public SeriesData(int i10, int i11, String str, Map<String, String> map, Map<String, String> map2, int i12, int i13, String str2, String str3, String str4, String str5, List<String> list) {
            this.primaryId = i10;
            this.id = i11;
            this.identifyId = str;
            this.seriesName = map;
            this.summary = map2;
            this.priority = i12;
            this.themeCount = i13;
            this.bannerImgUrl = str2;
            this.createTime = str3;
            this.updateTime = str4;
            this.bottomColor = str5;
            this.themeIdList = list;
        }

        public /* synthetic */ SeriesData(int i10, int i11, String str, Map map, Map map2, int i12, int i13, String str2, String str3, String str4, String str5, List list, int i14, kotlin.jvm.internal.d dVar) {
            this((i14 & 1) != 0 ? 0 : i10, (i14 & 2) != 0 ? 0 : i11, (i14 & 4) != 0 ? null : str, (i14 & 8) != 0 ? null : map, (i14 & 16) != 0 ? null : map2, (i14 & 32) != 0 ? 0 : i12, (i14 & 64) == 0 ? i13 : 0, (i14 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? null : str2, (i14 & 256) != 0 ? null : str3, (i14 & 512) != 0 ? null : str4, (i14 & 1024) != 0 ? null : str5, (i14 & 2048) != 0 ? null : list);
        }
    }

    /* JADX INFO: compiled from: DressSeriesDTO.kt */
    public static final class a implements Parcelable.Creator<DressSeriesDTO> {
        @Override // android.os.Parcelable.Creator
        public final DressSeriesDTO createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            h.e(parcel, "parcel");
            String string = parcel.readString();
            int i10 = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                int iB = 0;
                while (iB != i11) {
                    iB = A6.b.b(SeriesData.CREATOR, parcel, arrayList2, iB, 1);
                }
                arrayList = arrayList2;
            }
            return new DressSeriesDTO(string, i10, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final DressSeriesDTO[] newArray(int i10) {
            return new DressSeriesDTO[i10];
        }
    }

    public DressSeriesDTO() {
        this(null, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DressSeriesDTO copy$default(DressSeriesDTO dressSeriesDTO, String str, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = dressSeriesDTO.productId;
        }
        if ((i11 & 2) != 0) {
            i10 = dressSeriesDTO.color;
        }
        if ((i11 & 4) != 0) {
            list = dressSeriesDTO.seriesList;
        }
        return dressSeriesDTO.copy(str, i10, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    public final List<SeriesData> component3() {
        return this.seriesList;
    }

    public final DressSeriesDTO copy(String productId, int color, List<SeriesData> seriesList) {
        return new DressSeriesDTO(productId, color, seriesList);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getColor() {
        return this.color;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final List<SeriesData> getSeriesList() {
        return this.seriesList;
    }

    public final void setColor(int i10) {
        this.color = i10;
    }

    public final void setProductId(String str) {
        this.productId = str;
    }

    public final void setSeriesList(List<SeriesData> list) {
        this.seriesList = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.productId);
        dest.writeInt(this.color);
        List<SeriesData> list = this.seriesList;
        if (list == null) {
            dest.writeInt(0);
            return;
        }
        Iterator itG = A6.e.g(dest, 1, list);
        while (itG.hasNext()) {
            ((SeriesData) itG.next()).writeToParcel(dest, flags);
        }
    }

    public DressSeriesDTO(String str, int i10, List<SeriesData> list) {
        this.productId = str;
        this.color = i10;
        this.seriesList = list;
    }

    public /* synthetic */ DressSeriesDTO(String str, int i10, List list, int i11, kotlin.jvm.internal.d dVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? null : list);
    }
}
