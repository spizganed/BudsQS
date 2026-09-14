package com.oplus.melody.ui.component.detail.dress;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.common.data.a;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: PersonalSeriesVO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007J\b\u0010,\u001a\u00020\tH\u0016J\u0018\u0010-\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\tH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001a\u0010\u001d\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR\u001c\u0010 \u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001c\u0010#\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001c\u0010&\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\u001c\u0010)\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013¨\u00061"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/PersonalSeriesVO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "getId", "()I", "setId", "(I)V", "identifyId", "", "getIdentifyId", "()Ljava/lang/String;", "setIdentifyId", "(Ljava/lang/String;)V", "seriesName", "getSeriesName", "setSeriesName", "summary", "getSummary", "setSummary", ClientDataEntity.COL_PRIORITY, "getPriority", "setPriority", "themeCount", "getThemeCount", "setThemeCount", "bannerImgUrl", "getBannerImgUrl", "setBannerImgUrl", "createTime", "getCreateTime", "setCreateTime", "updateTime", "getUpdateTime", "setUpdateTime", "bottomColor", "getBottomColor", "setBottomColor", "describeContents", "writeToParcel", "", "flags", "CREATOR", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PersonalSeriesVO extends a implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    private String bannerImgUrl;
    private String bottomColor;
    private String createTime;
    private int id;
    private String identifyId;
    private int priority;
    private String seriesName;
    private String summary;
    private int themeCount;
    private String updateTime;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.PersonalSeriesVO$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: PersonalSeriesVO.kt */
    public static final class Companion implements Parcelable.Creator<PersonalSeriesVO> {
        @Override // android.os.Parcelable.Creator
        public final PersonalSeriesVO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new PersonalSeriesVO(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final PersonalSeriesVO[] newArray(int i10) {
            return new PersonalSeriesVO[i10];
        }
    }

    public PersonalSeriesVO() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
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

    public final void setPriority(int i10) {
        this.priority = i10;
    }

    public final void setSeriesName(String str) {
        this.seriesName = str;
    }

    public final void setSummary(String str) {
        this.summary = str;
    }

    public final void setThemeCount(int i10) {
        this.themeCount = i10;
    }

    public final void setUpdateTime(String str) {
        this.updateTime = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        h.e(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.identifyId);
        parcel.writeString(this.seriesName);
        parcel.writeString(this.summary);
        parcel.writeInt(this.priority);
        parcel.writeInt(this.themeCount);
        parcel.writeString(this.bannerImgUrl);
        parcel.writeString(this.createTime);
        parcel.writeString(this.updateTime);
        parcel.writeString(this.bottomColor);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PersonalSeriesVO(Parcel parcel) {
        this();
        h.e(parcel, "parcel");
        this.id = parcel.readInt();
        this.identifyId = parcel.readString();
        this.seriesName = parcel.readString();
        this.summary = parcel.readString();
        this.priority = parcel.readInt();
        this.themeCount = parcel.readInt();
        this.bannerImgUrl = parcel.readString();
        this.createTime = parcel.readString();
        this.updateTime = parcel.readString();
        this.bottomColor = parcel.readString();
    }
}
