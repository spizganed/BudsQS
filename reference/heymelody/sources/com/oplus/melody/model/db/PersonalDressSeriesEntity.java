package com.oplus.melody.model.db;

import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.oplus.melody.model.db.H, reason: from Kotlin metadata */
/* JADX INFO: compiled from: PersonalDressSeriesEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R,\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR,\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001e\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001e\u0010%\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR \u0010(\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R \u0010+\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R \u0010.\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R \u00101\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R&\u00104\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/oplus/melody/model/db/PersonalDressSeriesEntity;", "Lcom/oplus/melody/common/data/BaseBean;", "<init>", "()V", "primaryId", "", "getPrimaryId", "()I", "setPrimaryId", "(I)V", "id", "getId", "setId", "mProductId", "", "getMProductId", "()Ljava/lang/String;", "setMProductId", "(Ljava/lang/String;)V", "mColorId", "getMColorId", "setMColorId", "identifyId", "getIdentifyId", "setIdentifyId", "seriesName", "", "getSeriesName", "()Ljava/util/Map;", "setSeriesName", "(Ljava/util/Map;)V", "summary", "getSummary", "setSummary", ClientDataEntity.COL_PRIORITY, "getPriority", "setPriority", "themeCount", "getThemeCount", "setThemeCount", "bannerImgUrl", "getBannerImgUrl", "setBannerImgUrl", "createTime", "getCreateTime", "setCreateTime", "updateTime", "getUpdateTime", "setUpdateTime", "bottomColor", "getBottomColor", "setBottomColor", "themeIdList", "", "getThemeIdList", "()Ljava/util/List;", "setThemeIdList", "(Ljava/util/List;)V", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PersonalDressSeriesEntity extends com.oplus.melody.common.data.a {
    private String bannerImgUrl;
    private String bottomColor;
    private String createTime;
    private int id;
    private String identifyId;
    private int mColorId;
    private String mProductId = VersionInfo.VENDOR_CODE_DEFAULT_VERSION;
    private int primaryId;
    private int priority;
    private Map<String, String> seriesName;
    private Map<String, String> summary;
    private int themeCount;
    private List<String> themeIdList;
    private String updateTime;

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

    public final int getMColorId() {
        return this.mColorId;
    }

    public final String getMProductId() {
        return this.mProductId;
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

    public final void setMColorId(int i10) {
        this.mColorId = i10;
    }

    public final void setMProductId(String str) {
        kotlin.jvm.internal.h.e(str, "<set-?>");
        this.mProductId = str;
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
}
