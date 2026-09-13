package com.oplus.melody.app.discovery;

/* JADX INFO: compiled from: DiscoveryEarphoneVO.java */
/* JADX INFO: loaded from: classes.dex */
public final class E0 extends com.oplus.melody.common.data.a {
    private int mAccountBindingResultCode;
    private int mAccountBindingState;
    private boolean mAutoOtaOn;
    private int mBoxBattery;
    private boolean mBoxCharging;
    private int mConnectState;
    private boolean mDeviceBonded;
    private int mDiscoveryState;
    private String mId;
    private int mLeftBattery;
    private boolean mLeftCharging;
    private int mMultiConnectSwitchStatus;
    private String mName;
    private boolean mOtaEnabled;
    private int mPairingState;
    private int mProductColorId;
    private String mProductId;
    private int mRightBattery;
    private boolean mRightCharging;
    private int mShareAudioState;
    private String mSoftwareVersion;
    private boolean mSupportBindAccount;

    public int getAccountBindingResultCode() {
        return this.mAccountBindingResultCode;
    }

    public int getAccountBindingState() {
        return this.mAccountBindingState;
    }

    public int getBoxBattery() {
        return this.mBoxBattery;
    }

    public int getConnectState() {
        return this.mConnectState;
    }

    public int getDiscoveryState() {
        return this.mDiscoveryState;
    }

    public String getId() {
        String str = this.mId;
        return str == null ? "" : str;
    }

    public int getLeftBattery() {
        return this.mLeftBattery;
    }

    public int getMultiConnectSwitchStatus() {
        return this.mMultiConnectSwitchStatus;
    }

    public String getName() {
        return this.mName;
    }

    public int getPairingState() {
        return this.mPairingState;
    }

    public int getProductColorId() {
        return this.mProductColorId;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public int getRightBattery() {
        return this.mRightBattery;
    }

    public int getShareAudioState() {
        return this.mShareAudioState;
    }

    public String getSoftwareVersion() {
        return this.mSoftwareVersion;
    }

    public boolean isAutoOtaOn() {
        return this.mAutoOtaOn;
    }

    public boolean isBatteryEquals(E0 e02) {
        return e02 != null && this.mLeftBattery == e02.mLeftBattery && this.mLeftCharging == e02.mLeftCharging && this.mRightBattery == e02.mRightBattery && this.mRightCharging == e02.mRightCharging && this.mBoxBattery == e02.mBoxBattery && this.mBoxCharging == e02.mBoxCharging;
    }

    public boolean isBoxCharging() {
        return this.mBoxCharging;
    }

    public boolean isDeviceBonded() {
        return this.mDeviceBonded;
    }

    public boolean isLeftCharging() {
        return this.mLeftCharging;
    }

    public boolean isOtaEnabled() {
        return this.mOtaEnabled;
    }

    public boolean isRightCharging() {
        return this.mRightCharging;
    }

    public boolean isSupportBindAccount() {
        return this.mSupportBindAccount;
    }

    public void setAccountBindingResultCode(int i10) {
        this.mAccountBindingResultCode = i10;
    }

    public void setAccountBindingState(int i10) {
        this.mAccountBindingState = i10;
    }

    public void setAutoOtaOn(boolean z2) {
        this.mAutoOtaOn = z2;
    }

    public void setBoxBattery(int i10) {
        this.mBoxBattery = i10;
    }

    public void setBoxCharging(boolean z2) {
        this.mBoxCharging = z2;
    }

    public void setConnectState(int i10) {
        this.mConnectState = i10;
    }

    public void setDeviceBonded(boolean z2) {
        this.mDeviceBonded = z2;
    }

    public void setDiscoveryState(int i10) {
        this.mDiscoveryState = i10;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setLeftBattery(int i10) {
        this.mLeftBattery = i10;
    }

    public void setLeftCharging(boolean z2) {
        this.mLeftCharging = z2;
    }

    public void setMultiConnectSwitchStatus(int i10) {
        this.mMultiConnectSwitchStatus = i10;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setOtaEnabled(boolean z2) {
        this.mOtaEnabled = z2;
    }

    public void setPairingState(int i10) {
        this.mPairingState = i10;
    }

    public void setProductColorId(int i10) {
        this.mProductColorId = i10;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public void setRightBattery(int i10) {
        this.mRightBattery = i10;
    }

    public void setRightCharging(boolean z2) {
        this.mRightCharging = z2;
    }

    public void setShareAudioState(int i10) {
        this.mShareAudioState = i10;
    }

    public void setSoftwareVersion(String str) {
        this.mSoftwareVersion = str;
    }

    public void setSupportBindAccount(boolean z2) {
        this.mSupportBindAccount = z2;
    }
}
