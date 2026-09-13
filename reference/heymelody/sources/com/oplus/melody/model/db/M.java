package com.oplus.melody.model.db;

import com.oplus.melody.btsdk.api.data.SpineHistoryDataInfo;

/* JADX INFO: compiled from: SpineHistoryDataEntity.java */
/* JADX INFO: loaded from: classes3.dex */
public class M extends com.oplus.melody.common.data.a {
    private int mBadTimes;
    private String mMacAddress;
    private int mMildTimes;
    private int mNormalTimes;
    private String mProductId;
    private String mProductName;
    private int mUnKnowns;
    private int mUtc;

    public M() {
        this.mUtc = 0;
        this.mProductName = "";
        this.mProductId = "";
        this.mMacAddress = "00:00:00:00:00:00";
    }

    public int getBadTimes() {
        return this.mBadTimes;
    }

    public String getMacAddress() {
        return this.mMacAddress;
    }

    public int getMildTimes() {
        return this.mMildTimes;
    }

    public int getNormalTimes() {
        return this.mNormalTimes;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public String getProductName() {
        return this.mProductName;
    }

    public int getUnKnowns() {
        return this.mUnKnowns;
    }

    public int getUtc() {
        return this.mUtc;
    }

    public void setBadTimes(int i10) {
        this.mBadTimes = i10;
    }

    public void setMacAddress(String str) {
        this.mMacAddress = str;
    }

    public void setMildTimes(int i10) {
        this.mMildTimes = i10;
    }

    public void setNormalTimes(int i10) {
        this.mNormalTimes = i10;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public void setProductName(String str) {
        this.mProductName = str;
    }

    public void setUnKnowns(int i10) {
        this.mUnKnowns = i10;
    }

    public void setUtc(int i10) {
        this.mUtc = i10;
    }

    public M(SpineHistoryDataInfo spineHistoryDataInfo) {
        this.mUtc = 0;
        this.mProductName = "";
        this.mProductId = "";
        this.mMacAddress = "00:00:00:00:00:00";
        this.mUtc = spineHistoryDataInfo.mUtcTime;
        this.mNormalTimes = spineHistoryDataInfo.mNormalTimes;
        this.mMildTimes = spineHistoryDataInfo.mMildTimes;
        this.mBadTimes = spineHistoryDataInfo.mBadTimes;
        this.mUnKnowns = spineHistoryDataInfo.mUnknowns;
    }
}
