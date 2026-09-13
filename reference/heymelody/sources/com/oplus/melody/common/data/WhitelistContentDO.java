package com.oplus.melody.common.data;

import A6.b;
import A6.e;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: WhitelistContentDO.kt */
/* JADX INFO: loaded from: classes.dex */
@Parcelize
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BÏ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u00104\u001a\u000205J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÂ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0007HÂ\u0003¢\u0006\u0002\u0010:J\u0017\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nHÆ\u0003J\u0017\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nHÂ\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u0011\u0010>\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÂ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rHÆ\u0003J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\rHÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0004HÆ\u0003JÖ\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010EJ\u0006\u0010F\u001a\u00020\u0007J\u0016\u0010G\u001a\u0002052\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001e\"\u0004\b1\u0010 R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001c¨\u0006K"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistContentDO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "caseNumSite", "", "compatCaseNumSite", "versionCode", "", "compatVersionCode", "appMarket", "", "compatAppMarket", "whiteList", "", "Lcom/oplus/melody/common/data/WhitelistConfigDTO;", "compatWhiteList", "transferEncoding", "diagnosisList", "Lcom/oplus/melody/common/data/DiagnosisConfigDTO;", "leAllFilterFunctions", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$LeFilterFunction;", "appUpdateRemindVersion", "txMusicCollectUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ILjava/lang/String;)V", "getCaseNumSite", "()Ljava/lang/String;", "setCaseNumSite", "(Ljava/lang/String;)V", "getVersionCode", "()I", "setVersionCode", "(I)V", "Ljava/lang/Integer;", "getAppMarket", "()Ljava/util/Map;", "setAppMarket", "(Ljava/util/Map;)V", "getWhiteList", "()Ljava/util/List;", "setWhiteList", "(Ljava/util/List;)V", "getTransferEncoding", "setTransferEncoding", "getDiagnosisList", "setDiagnosisList", "getLeAllFilterFunctions", "setLeAllFilterFunctions", "getAppUpdateRemindVersion", "setAppUpdateRemindVersion", "getTxMusicCollectUrl", "setTxMusicCollectUrl", "compatToContent", "", "component1", "component2", "component3", "component4", "()Ljava/lang/Integer;", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ILjava/lang/String;)Lcom/oplus/melody/common/data/WhitelistContentDO;", "describeContents", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class WhitelistContentDO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<WhitelistContentDO> CREATOR = new a();
    private Map<String, String> appMarket;
    private int appUpdateRemindVersion;
    private String caseNumSite;
    private Map<String, String> compatAppMarket;
    private String compatCaseNumSite;
    private Integer compatVersionCode;
    private List<WhitelistConfigDTO> compatWhiteList;
    private List<DiagnosisConfigDTO> diagnosisList;
    private List<WhitelistConfigDTO.LeFilterFunction> leAllFilterFunctions;
    private String transferEncoding;
    private String txMusicCollectUrl;
    private int versionCode;
    private List<WhitelistConfigDTO> whiteList;

    /* JADX INFO: compiled from: WhitelistContentDO.kt */
    public static final class a implements Parcelable.Creator<WhitelistContentDO> {
        @Override // android.os.Parcelable.Creator
        public final WhitelistContentDO createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            LinkedHashMap linkedHashMap2;
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            ArrayList arrayList4;
            h.e(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i10 = parcel.readInt();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            int iB = 0;
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int i11 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
            }
            if (parcel.readInt() == 0) {
                linkedHashMap2 = null;
            } else {
                int i13 = parcel.readInt();
                linkedHashMap2 = new LinkedHashMap(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    linkedHashMap2.put(parcel.readString(), parcel.readString());
                }
            }
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i15 = parcel.readInt();
                arrayList = new ArrayList(i15);
                int iB2 = 0;
                while (iB2 != i15) {
                    iB2 = b.b(WhitelistConfigDTO.CREATOR, parcel, arrayList, iB2, 1);
                }
            }
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int i16 = parcel.readInt();
                arrayList2 = new ArrayList(i16);
                int iB3 = 0;
                while (iB3 != i16) {
                    iB3 = b.b(WhitelistConfigDTO.CREATOR, parcel, arrayList2, iB3, 1);
                }
            }
            String string3 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList3 = null;
            } else {
                int i17 = parcel.readInt();
                ArrayList arrayList5 = new ArrayList(i17);
                int iB4 = 0;
                while (iB4 != i17) {
                    iB4 = b.b(DiagnosisConfigDTO.CREATOR, parcel, arrayList5, iB4, 1);
                }
                arrayList3 = arrayList5;
            }
            if (parcel.readInt() == 0) {
                arrayList4 = null;
            } else {
                int i18 = parcel.readInt();
                arrayList4 = new ArrayList(i18);
                while (iB != i18) {
                    iB = b.b(WhitelistConfigDTO.LeFilterFunction.CREATOR, parcel, arrayList4, iB, 1);
                }
            }
            return new WhitelistContentDO(string, string2, i10, numValueOf, linkedHashMap, linkedHashMap2, arrayList, arrayList2, string3, arrayList3, arrayList4, parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final WhitelistContentDO[] newArray(int i10) {
            return new WhitelistContentDO[i10];
        }
    }

    public WhitelistContentDO() {
        this(null, null, 0, null, null, null, null, null, null, null, null, 0, null, 8191, null);
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final String getCompatCaseNumSite() {
        return this.compatCaseNumSite;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final Integer getCompatVersionCode() {
        return this.compatVersionCode;
    }

    private final Map<String, String> component6() {
        return this.compatAppMarket;
    }

    private final List<WhitelistConfigDTO> component8() {
        return this.compatWhiteList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WhitelistContentDO copy$default(WhitelistContentDO whitelistContentDO, String str, String str2, int i10, Integer num, Map map, Map map2, List list, List list2, String str3, List list3, List list4, int i11, String str4, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = whitelistContentDO.caseNumSite;
        }
        return whitelistContentDO.copy(str, (i12 & 2) != 0 ? whitelistContentDO.compatCaseNumSite : str2, (i12 & 4) != 0 ? whitelistContentDO.versionCode : i10, (i12 & 8) != 0 ? whitelistContentDO.compatVersionCode : num, (i12 & 16) != 0 ? whitelistContentDO.appMarket : map, (i12 & 32) != 0 ? whitelistContentDO.compatAppMarket : map2, (i12 & 64) != 0 ? whitelistContentDO.whiteList : list, (i12 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? whitelistContentDO.compatWhiteList : list2, (i12 & 256) != 0 ? whitelistContentDO.transferEncoding : str3, (i12 & 512) != 0 ? whitelistContentDO.diagnosisList : list3, (i12 & 1024) != 0 ? whitelistContentDO.leAllFilterFunctions : list4, (i12 & 2048) != 0 ? whitelistContentDO.appUpdateRemindVersion : i11, (i12 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? whitelistContentDO.txMusicCollectUrl : str4);
    }

    public final void compatToContent() {
        Integer num = this.compatVersionCode;
        if (num != null) {
            this.versionCode = num.intValue();
            this.compatVersionCode = null;
        }
        String str = this.compatCaseNumSite;
        if (str != null) {
            this.caseNumSite = str;
            this.compatCaseNumSite = null;
        }
        List<WhitelistConfigDTO> list = this.compatWhiteList;
        if (list != null) {
            this.whiteList = list;
            this.compatWhiteList = null;
        }
        Map<String, String> map = this.compatAppMarket;
        if (map != null) {
            this.appMarket = map;
            this.compatAppMarket = null;
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCaseNumSite() {
        return this.caseNumSite;
    }

    public final List<DiagnosisConfigDTO> component10() {
        return this.diagnosisList;
    }

    public final List<WhitelistConfigDTO.LeFilterFunction> component11() {
        return this.leAllFilterFunctions;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getAppUpdateRemindVersion() {
        return this.appUpdateRemindVersion;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getTxMusicCollectUrl() {
        return this.txMusicCollectUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    public final Map<String, String> component5() {
        return this.appMarket;
    }

    public final List<WhitelistConfigDTO> component7() {
        return this.whiteList;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTransferEncoding() {
        return this.transferEncoding;
    }

    public final WhitelistContentDO copy(String caseNumSite, String compatCaseNumSite, int versionCode, Integer compatVersionCode, Map<String, String> appMarket, Map<String, String> compatAppMarket, List<WhitelistConfigDTO> whiteList, List<WhitelistConfigDTO> compatWhiteList, String transferEncoding, List<DiagnosisConfigDTO> diagnosisList, List<WhitelistConfigDTO.LeFilterFunction> leAllFilterFunctions, int appUpdateRemindVersion, String txMusicCollectUrl) {
        return new WhitelistContentDO(caseNumSite, compatCaseNumSite, versionCode, compatVersionCode, appMarket, compatAppMarket, whiteList, compatWhiteList, transferEncoding, diagnosisList, leAllFilterFunctions, appUpdateRemindVersion, txMusicCollectUrl);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final Map<String, String> getAppMarket() {
        return this.appMarket;
    }

    public final int getAppUpdateRemindVersion() {
        return this.appUpdateRemindVersion;
    }

    public final String getCaseNumSite() {
        return this.caseNumSite;
    }

    public final List<DiagnosisConfigDTO> getDiagnosisList() {
        return this.diagnosisList;
    }

    public final List<WhitelistConfigDTO.LeFilterFunction> getLeAllFilterFunctions() {
        return this.leAllFilterFunctions;
    }

    public final String getTransferEncoding() {
        return this.transferEncoding;
    }

    public final String getTxMusicCollectUrl() {
        return this.txMusicCollectUrl;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final List<WhitelistConfigDTO> getWhiteList() {
        return this.whiteList;
    }

    public final void setAppMarket(Map<String, String> map) {
        this.appMarket = map;
    }

    public final void setAppUpdateRemindVersion(int i10) {
        this.appUpdateRemindVersion = i10;
    }

    public final void setCaseNumSite(String str) {
        this.caseNumSite = str;
    }

    public final void setDiagnosisList(List<DiagnosisConfigDTO> list) {
        this.diagnosisList = list;
    }

    public final void setLeAllFilterFunctions(List<WhitelistConfigDTO.LeFilterFunction> list) {
        this.leAllFilterFunctions = list;
    }

    public final void setTransferEncoding(String str) {
        this.transferEncoding = str;
    }

    public final void setTxMusicCollectUrl(String str) {
        this.txMusicCollectUrl = str;
    }

    public final void setVersionCode(int i10) {
        this.versionCode = i10;
    }

    public final void setWhiteList(List<WhitelistConfigDTO> list) {
        this.whiteList = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.caseNumSite);
        dest.writeString(this.compatCaseNumSite);
        dest.writeInt(this.versionCode);
        Integer num = this.compatVersionCode;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Map<String, String> map = this.appMarket;
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
        Map<String, String> map2 = this.compatAppMarket;
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
        List<WhitelistConfigDTO> list = this.whiteList;
        if (list == null) {
            dest.writeInt(0);
        } else {
            Iterator itG = e.g(dest, 1, list);
            while (itG.hasNext()) {
                ((WhitelistConfigDTO) itG.next()).writeToParcel(dest, flags);
            }
        }
        List<WhitelistConfigDTO> list2 = this.compatWhiteList;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            Iterator itG2 = e.g(dest, 1, list2);
            while (itG2.hasNext()) {
                ((WhitelistConfigDTO) itG2.next()).writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.transferEncoding);
        List<DiagnosisConfigDTO> list3 = this.diagnosisList;
        if (list3 == null) {
            dest.writeInt(0);
        } else {
            Iterator itG3 = e.g(dest, 1, list3);
            while (itG3.hasNext()) {
                ((DiagnosisConfigDTO) itG3.next()).writeToParcel(dest, flags);
            }
        }
        List<WhitelistConfigDTO.LeFilterFunction> list4 = this.leAllFilterFunctions;
        if (list4 == null) {
            dest.writeInt(0);
        } else {
            Iterator itG4 = e.g(dest, 1, list4);
            while (itG4.hasNext()) {
                ((WhitelistConfigDTO.LeFilterFunction) itG4.next()).writeToParcel(dest, flags);
            }
        }
        dest.writeInt(this.appUpdateRemindVersion);
        dest.writeString(this.txMusicCollectUrl);
    }

    public WhitelistContentDO(String str, String str2, int i10, Integer num, Map<String, String> map, Map<String, String> map2, List<WhitelistConfigDTO> list, List<WhitelistConfigDTO> list2, String str3, List<DiagnosisConfigDTO> list3, List<WhitelistConfigDTO.LeFilterFunction> list4, int i11, String str4) {
        this.caseNumSite = str;
        this.compatCaseNumSite = str2;
        this.versionCode = i10;
        this.compatVersionCode = num;
        this.appMarket = map;
        this.compatAppMarket = map2;
        this.whiteList = list;
        this.compatWhiteList = list2;
        this.transferEncoding = str3;
        this.diagnosisList = list3;
        this.leAllFilterFunctions = list4;
        this.appUpdateRemindVersion = i11;
        this.txMusicCollectUrl = str4;
    }

    public /* synthetic */ WhitelistContentDO(String str, String str2, int i10, Integer num, Map map, Map map2, List list, List list2, String str3, List list3, List list4, int i11, String str4, int i12, d dVar) {
        this((i12 & 1) != 0 ? null : str, (i12 & 2) != 0 ? null : str2, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? null : num, (i12 & 16) != 0 ? null : map, (i12 & 32) != 0 ? null : map2, (i12 & 64) != 0 ? null : list, (i12 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? null : list2, (i12 & 256) != 0 ? null : str3, (i12 & 512) != 0 ? null : list3, (i12 & 1024) != 0 ? null : list4, (i12 & 2048) == 0 ? i11 : 0, (i12 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? null : str4);
    }
}
