package com.oplus.melody.model.db;

import android.text.TextUtils;
import com.heytap.headset.R;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import java.util.Locale;

/* JADX INFO: compiled from: ZenModeInformationEntity.java */
/* JADX INFO: loaded from: classes3.dex */
public class N extends com.oplus.melody.common.data.a {
    public String mAudioBinUrl;
    public int mAudioExist;
    public String mAudioUrl;
    public String mColor;
    public String mCreateTime;
    public String mImgUrl;
    public String mMD5;
    public String mNameCN;
    public String mNameEN;
    public String mProductId;
    public String mRandomId;
    public String mResId;
    public String mUpdateTime;

    public N(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i10, String str11, String str12) {
        this.mRandomId = str;
        this.mResId = str2;
        this.mNameCN = str3;
        this.mNameEN = str4;
        this.mImgUrl = str5;
        this.mAudioUrl = str6;
        this.mAudioBinUrl = str7;
        this.mMD5 = str8;
        this.mCreateTime = str9;
        this.mUpdateTime = str10;
        this.mAudioExist = i10;
        this.mProductId = str11;
        this.mColor = str12;
    }

    public static ZenModeInfoDO covertToZenModeInfoDO(N n10) {
        if (n10 == null) {
            return null;
        }
        String randomId = n10.getRandomId();
        String resId = n10.getResId();
        String imgUrl = n10.getImgUrl();
        String audioUrl = n10.getAudioUrl();
        String audioBinUrl = n10.getAudioBinUrl();
        String md5 = n10.getMD5();
        String createTime = n10.getCreateTime();
        String updateTime = n10.getUpdateTime();
        String productId = n10.getProductId();
        String color = n10.getColor();
        String nameCN = TextUtils.isEmpty(n10.getNameCN()) ? n10.getNameEN() : (TextUtils.isEmpty(n10.getNameEN()) || C0906l.f19501a.getString(R.string.melody_common_language_tag).startsWith(Locale.CHINESE.getLanguage())) ? n10.getNameCN() : n10.getNameEN();
        return new ZenModeInfoDO(randomId, resId, nameCN, null, imgUrl, null, audioUrl, null, 0L, audioBinUrl, null, 0L, createTime, updateTime, md5, productId, color);
    }

    public static N covertToZenModeInformationEntity(ZenModeInfoDO zenModeInfoDO, N n10) {
        boolean zEquals;
        String name;
        String name2 = null;
        if (zenModeInfoDO == null) {
            return null;
        }
        String randomId = zenModeInfoDO.getRandomId();
        String resId = zenModeInfoDO.getResId();
        String imgUrl = zenModeInfoDO.getImgUrl();
        String audioUrl = zenModeInfoDO.getAudioUrl();
        String audioBinUrl = zenModeInfoDO.getAudioBinUrl();
        String md5 = zenModeInfoDO.getMd5();
        String createTime = zenModeInfoDO.getCreateTime();
        String updateTime = zenModeInfoDO.getUpdateTime();
        String productId = zenModeInfoDO.getProductId();
        String color = zenModeInfoDO.getColor();
        if (n10 != null) {
            name2 = n10.getNameCN();
            name = n10.getNameEN();
            zEquals = md5.equals(n10.getMD5());
        } else {
            zEquals = false;
            name = null;
        }
        boolean z2 = zEquals;
        String string = C0906l.f19501a.getString(R.string.melody_common_language_tag);
        if (string.startsWith(Locale.ENGLISH.getLanguage())) {
            name = zenModeInfoDO.getName();
        } else if (string.startsWith(Locale.CHINESE.getLanguage())) {
            name2 = zenModeInfoDO.getName();
        }
        return new N(randomId, resId, name2, name, imgUrl, audioUrl, audioBinUrl, md5, createTime, updateTime, z2 ? 1 : 0, productId, color);
    }

    public String getAudioBinUrl() {
        return this.mAudioBinUrl;
    }

    public int getAudioExist() {
        return this.mAudioExist;
    }

    public String getAudioUrl() {
        return this.mAudioUrl;
    }

    public String getColor() {
        return this.mColor;
    }

    public String getCreateTime() {
        return this.mCreateTime;
    }

    public String getImgUrl() {
        return this.mImgUrl;
    }

    public String getMD5() {
        return this.mMD5;
    }

    public String getNameCN() {
        return this.mNameCN;
    }

    public String getNameEN() {
        return this.mNameEN;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public String getRandomId() {
        return this.mRandomId;
    }

    public String getResId() {
        return this.mResId;
    }

    public String getUpdateTime() {
        return this.mUpdateTime;
    }

    public void setAudioBinUrl(String str) {
        this.mAudioBinUrl = str;
    }

    public void setAudioExist(int i10) {
        this.mAudioExist = i10;
    }

    public void setAudioUrl(String str) {
        this.mAudioUrl = str;
    }

    public void setColor(String str) {
        this.mColor = str;
    }

    public void setCreateTime(String str) {
        this.mCreateTime = str;
    }

    public void setImgUrl(String str) {
        this.mImgUrl = str;
    }

    public void setMD5(String str) {
        this.mMD5 = str;
    }

    public void setNameCN(String str) {
        this.mNameCN = str;
    }

    public void setNameEN(String str) {
        this.mNameEN = str;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public void setRandomId(String str) {
        this.mRandomId = str;
    }

    public void setResId(String str) {
        this.mResId = str;
    }

    public void setUpdateTime(String str) {
        this.mUpdateTime = str;
    }
}
