package com.oplus.melody.model.scan;

import android.bluetooth.BluetoothDevice;
import android.os.SystemClock;
import java.util.Arrays;

/* JADX INFO: compiled from: ScanDeviceDTO.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.oplus.melody.common.data.a {
    static final String ADDR_INIT_0 = "00:00:00:00:00:00";
    static final String ADDR_INIT_1 = "00:00:00:00:00:01";
    static final String ADDR_INIT_2 = "00:00:00:00:00:02";
    private static final int MASK_CRC16 = 65535;
    private static final int MAX_PHONE_CRC16_COUNT = 3;
    private String mAccountKeyFilter;
    private BluetoothDevice mBluetoothDevice;
    private int mBoxBatteryLevel;
    private boolean mBoxOpen;
    private String mBrand;
    private int mColor;
    private int mFastPairingId;
    private boolean mIsAnotherDeviceAutoSwitchLinkOn;
    private boolean mIsEarPhoneSupportBindAccount;
    private boolean mIsFreemanMode;
    private boolean mIsInBusy;
    private boolean mIsInCalling;
    private boolean mIsMultiConnectionOpened;
    private boolean mIsScreenOn;
    private int mLeftBatteryLevel;
    private int mLeftEarBudsStatus;
    private String mName;
    private int[] mPhoneConnectCrc16Values;
    private int mRightBatteryLevel;
    private int mRightEarBudsStatus;
    private int mRssi;
    private boolean mSupportEarAccessBox;
    private boolean mSupportEarBudsStatus;
    private boolean mSupportLeAudio;
    private int mPairingState = 0;
    private String mAddress = ADDR_INIT_0;
    private String mAnotherAddress = ADDR_INIT_1;
    private int mProductId = 0;
    private long mCreateTime = SystemClock.elapsedRealtime();

    public String getAccountKeyFilter() {
        return this.mAccountKeyFilter;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public String getAnotherAddress() {
        return this.mAnotherAddress;
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.mBluetoothDevice;
    }

    public int getBoxBatteryLevel() {
        return this.mBoxBatteryLevel;
    }

    public String getBrand() {
        return this.mBrand;
    }

    public int getColor() {
        return this.mColor;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public int getFastPairingId() {
        return this.mFastPairingId;
    }

    public int getLeftBatteryLevel() {
        return this.mLeftBatteryLevel;
    }

    public int getLeftEarBudsStatus() {
        return this.mLeftEarBudsStatus;
    }

    public String getName() {
        return this.mName;
    }

    public int getPairingState() {
        return this.mPairingState;
    }

    public int getPhoneCrc16IndexOf(int i10) {
        int[] iArr;
        if ((MASK_CRC16 & i10) != i10 || (iArr = this.mPhoneConnectCrc16Values) == null) {
            return -1;
        }
        int length = iArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (this.mPhoneConnectCrc16Values[i11] == i10) {
                return i11;
            }
        }
        return -1;
    }

    public int getProductId() {
        return this.mProductId;
    }

    public int getRightBatteryLevel() {
        return this.mRightBatteryLevel;
    }

    public int getRightEarBudsStatus() {
        return this.mRightEarBudsStatus;
    }

    public int getRssi() {
        return this.mRssi;
    }

    public boolean isAnotherDeviceAutoSwitchLinkOn() {
        return this.mIsAnotherDeviceAutoSwitchLinkOn;
    }

    public boolean isBoxOpen() {
        return this.mBoxOpen;
    }

    public boolean isEarphoneSupportBindAccount() {
        return this.mIsEarPhoneSupportBindAccount;
    }

    public boolean isFreemanMode() {
        return this.mIsFreemanMode;
    }

    public boolean isInBusy() {
        return this.mIsInBusy;
    }

    public boolean isInCalling() {
        return this.mIsInCalling;
    }

    public boolean isMultiConnectionOpened() {
        return this.mIsMultiConnectionOpened;
    }

    public boolean isPhoneCrc16Supported() {
        return this.mPhoneConnectCrc16Values != null;
    }

    public boolean isScreenOn() {
        return this.mIsScreenOn;
    }

    public boolean isSupportEarAccessBox() {
        return this.mSupportEarAccessBox;
    }

    public boolean isSupportEarBudsStatus() {
        return this.mSupportEarBudsStatus;
    }

    public boolean isSupportLeAudio() {
        return this.mSupportLeAudio;
    }

    public void setAccountKeyFilter(String str) {
        this.mAccountKeyFilter = str;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setAnotherAddress(String str) {
        this.mAnotherAddress = str;
    }

    public void setBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.mBluetoothDevice = bluetoothDevice;
    }

    public void setBoxBatteryLevel(int i10) {
        this.mBoxBatteryLevel = i10;
    }

    public void setBoxOpen(boolean z2) {
        this.mBoxOpen = z2;
    }

    public void setBrand(String str) {
        this.mBrand = str;
    }

    public void setColor(int i10) {
        this.mColor = i10;
    }

    public void setCreateTime(long j5) {
        this.mCreateTime = j5;
    }

    public void setEarphoneSupportBindAccount(boolean z2) {
        this.mIsEarPhoneSupportBindAccount = z2;
    }

    public void setFastPairingId(int i10) {
        this.mFastPairingId = i10;
    }

    public void setFreemanMode(boolean z2) {
        this.mIsFreemanMode = z2;
    }

    public void setIsAnotherDeviceAutoSwitchLinkOn(boolean z2) {
        this.mIsAnotherDeviceAutoSwitchLinkOn = z2;
    }

    public void setIsInBusy(boolean z2) {
        this.mIsInBusy = z2;
    }

    public void setIsInCalling(boolean z2) {
        this.mIsInCalling = z2;
    }

    public void setIsMultiConnectionOpened(boolean z2) {
        this.mIsMultiConnectionOpened = z2;
    }

    public void setLeftBatteryLevel(int i10) {
        this.mLeftBatteryLevel = i10;
    }

    public void setLeftEarBudsStatus(int i10) {
        this.mLeftEarBudsStatus = i10;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setPairingState(int i10) {
        this.mPairingState = i10;
    }

    public void setPhoneCrc16ValueAt(int i10, int i11) {
        if ((MASK_CRC16 & i11) != i11 || i10 < 0 || i10 >= 3) {
            return;
        }
        if (this.mPhoneConnectCrc16Values == null) {
            int[] iArr = new int[3];
            this.mPhoneConnectCrc16Values = iArr;
            Arrays.fill(iArr, -1);
        }
        this.mPhoneConnectCrc16Values[i10] = i11;
    }

    public void setProductId(int i10) {
        this.mProductId = i10;
    }

    public void setRightBatteryLevel(int i10) {
        this.mRightBatteryLevel = i10;
    }

    public void setRightEarBudsStatus(int i10) {
        this.mRightEarBudsStatus = i10;
    }

    public void setRssi(int i10) {
        this.mRssi = i10;
    }

    public void setScreenOn(boolean z2) {
        this.mIsScreenOn = z2;
    }

    public void setSupportEarAccessBox(boolean z2) {
        this.mSupportEarAccessBox = z2;
    }

    public void setSupportEarBudsStatus(boolean z2) {
        this.mSupportEarBudsStatus = z2;
        this.mSupportEarAccessBox = z2;
    }

    public void setSupportLeAudio(boolean z2) {
        this.mSupportLeAudio = z2;
    }
}
