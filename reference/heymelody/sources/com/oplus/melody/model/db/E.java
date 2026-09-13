package com.oplus.melody.model.db;

import android.text.TextUtils;

/* JADX INFO: compiled from: MelodyEquipmentEntity.java */
/* JADX INFO: loaded from: classes3.dex */
public class E extends com.oplus.melody.common.data.a {
    private int mColorId;
    private String mName;
    private String mPopTheme;
    private String mProductId;
    private String mMacAddress = "00:00:00:00:00:00";
    private int mAutoOTASwitch = -1;
    private int mChannelSwitch = -1;
    private int mMultiConversationSwitch = -1;
    private int mReconnectPopupSwitch = -1;

    public int getAutoOTASwitch() {
        return this.mAutoOTASwitch;
    }

    public int getChannelSwitch() {
        return this.mChannelSwitch;
    }

    public int getColorId() {
        return this.mColorId;
    }

    public String getMacAddress() {
        String str = this.mMacAddress;
        return str == null ? "" : str;
    }

    public int getMultiConversationSwitch() {
        return this.mMultiConversationSwitch;
    }

    public String getName() {
        return this.mName;
    }

    public String getPopTheme() {
        return this.mPopTheme;
    }

    public String getProductId() {
        String str = this.mProductId;
        return str == null ? "" : str;
    }

    public int getReconnectPopupSwitch() {
        return this.mReconnectPopupSwitch;
    }

    public void setAutoOTASwitch(int i10) {
        this.mAutoOTASwitch = i10;
    }

    public void setChannelSwitch(int i10) {
        this.mChannelSwitch = i10;
    }

    public void setColorId(int i10) {
        this.mColorId = i10;
    }

    public void setMacAddress(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mMacAddress = str;
    }

    public void setMultiConversationSwitch(int i10) {
        this.mMultiConversationSwitch = i10;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setPopTheme(String str) {
        this.mPopTheme = str;
    }

    public void setProductId(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mProductId = str;
    }

    public void setReconnectPopupSwitch(int i10) {
        this.mReconnectPopupSwitch = i10;
    }
}
