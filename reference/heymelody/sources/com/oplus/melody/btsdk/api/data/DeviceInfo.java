package com.oplus.melody.btsdk.api.data;

import D1.f;
import D7.C0388w;
import D7.C0391z;
import S6.b;
import Y.r;
import Y6.a;
import a7.d;
import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.oplus.melody.btsdk.manager.support.SupportDeviceConfig;
import com.oplus.melody.btsdk.protocol.commands.UserInteractionEventInfo;
import com.oplus.melody.btsdk.protocol.commands.history.ConnectDevice;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.Y;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import x3.C1656o;
import z7.C1725a;

/* JADX INFO: loaded from: classes.dex */
public class DeviceInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new a();
    private static final String TAG = "DeviceInfo";
    private boolean mA2dpActive;
    private int mAISummaryType;
    private int mAITranslationAppStatus;
    private String mAccountKey;
    private BassEngineInfo mBassEngineValue;
    private List<BatteryInfo> mBatteryInfoList;
    private long mBatteryInfoMillis;
    private String mBoxSn;
    private List<Integer> mCapability;
    private int mCervicalSpineRemindTime;
    private List<Integer> mCodecList;
    private int mCodecType;
    private int mColorId;
    private List<CompactnessDetectionInfo> mCompactnessDetectionInfos;
    private List<ConnectDevice> mConnectDeviceList;
    private int mConnectErrorCode;
    private boolean mConnected;
    private long mConnectedChangedMillis;
    private CurrentNoiseModeInfo mCurrentNoiseModeInfo;
    private BluetoothDevice mDevice;
    private int mDeviceA2dpConnectState;
    private int mDeviceAclConnectState;
    private String mDeviceAddress;
    private int mDeviceBTType;
    private int mDeviceBinauralRecordConnectState;
    private int mDeviceBondState;
    private int mDeviceConnectState;
    private int mDeviceHeadsetConnectState;
    private String mDeviceName;
    private int mDeviceProtocol;
    private List<EarRestoreDataInfo> mEarRestoreDataInfos;
    private List<EarTone> mEarTones;
    private List<EqInfo> mEqInfoList;
    private EqualizerModeInfo mEqualizerModeInfo;
    private List<FeatureSwitchInfo> mFeatureSwitchInfos;
    private int mFreeDialogRecoveryTime;
    private int mGameMode;
    private GameSoundInfo mGameSoundInfo;
    private int mHeadMotionType;
    private boolean mHeadsetActive;
    private int mHeadsetSpatialType;
    private boolean mInitCmdCompleted;
    private IntelligentNoiseModeInfo mIntelligentNoiseModeInfo;
    private boolean mIsSupportSpp;
    private List<KeyFunctionInfo> mKeyFunctionList;
    private boolean mLeAudioActive;
    private final Map<String, Integer> mLeAudioConnectStateMap;
    private final Map<String, Long> mLeAudioConnectTimeMap;
    private boolean mLeBrSwitch;
    private int mMTU;
    private List<MultiConnectInformationElement> mMultiConnectionInfo;
    private NoiseReductionInfo mNoiseReductionInfo;
    private int mProductId;
    private int mProductType;
    private int mScreenOffBroadcastDelayTime;
    private List<Integer> mSpineCalibrationResult;
    private int mSpineCalibrationState;
    private int mSpineFatigueRemindTime;
    private List<SpineHistoryDataInfo> mSpineHistoryDatas;
    private List<Float> mSpineRangeDetectionResult;
    private int mSppOverGattConnectionState;
    private List<StatusInfo> mStatusInfoList;
    private long mStatusInfoTimeMillis;
    private boolean mSupportBindAccount;
    private boolean mSupportCustomEq;
    private boolean mSupportMultiDeviceConnect;
    private boolean mSupportRelated;
    private boolean mSupportSmartBluetooth;
    private boolean mSupportTriangle;
    private NoiseReductionInfo mSwitchLeftEarNoiseReductionInfo;
    private NoiseReductionInfo mSwitchNoiseReductionInfo;
    private NoiseReductionInfo mSwitchRightEarNoiseReductionInfo;
    private int mTapLevelDefaultValue;
    private int mTapLevelSettingValue;
    private TriangleInfo mTriangleInfo;
    private String mType;
    private List<d> mUpgradeInfoList;
    private int mUpgradeMTU;
    private UserInteractionEventInfo mUserInteractionEventInfo;
    private List<VersionInfo> mVersionInfoList;
    private int mVolumeValueInfo;
    private int mZenModeSwitchStatus;

    public class a implements Parcelable.Creator<DeviceInfo> {
        @Override // android.os.Parcelable.Creator
        public final DeviceInfo createFromParcel(Parcel parcel) {
            return new DeviceInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final DeviceInfo[] newArray(int i10) {
            return new DeviceInfo[i10];
        }
    }

    public DeviceInfo() {
        this.mLeAudioConnectStateMap = new ConcurrentHashMap();
        this.mLeAudioConnectTimeMap = new ConcurrentHashMap();
        this.mProductType = -1;
        this.mDeviceBTType = -1;
        this.mDeviceConnectState = 0;
        this.mDeviceBondState = 0;
        this.mDeviceA2dpConnectState = 0;
        this.mDeviceHeadsetConnectState = 0;
        this.mDeviceAclConnectState = 0;
        this.mDeviceBinauralRecordConnectState = 0;
        this.mConnectErrorCode = 0;
        this.mDeviceName = "";
        this.mDeviceAddress = "";
        this.mDeviceProtocol = -1;
        this.mColorId = -1;
        this.mType = "";
        this.mA2dpActive = false;
        this.mHeadsetActive = false;
        this.mLeAudioActive = false;
        this.mMTU = -1;
        this.mSppOverGattConnectionState = 0;
        this.mConnected = false;
        this.mInitCmdCompleted = false;
        this.mLeBrSwitch = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$setDeviceAclConnectState$1(int i10) {
        StringBuilder sbN = androidx.appcompat.widget.a.n(i10, "m_bt_le.setDeviceAclConnectState: newState=", " oldState=");
        sbN.append(this.mDeviceAclConnectState);
        return sbN.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$setKeyFunctions$2(List list) {
        return "setKeyFunctions: " + list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$updateConnected$0(boolean z2, String str) {
        return "updateConnected " + z2 + " from " + str;
    }

    private void updateConnected(String str) {
        boolean z2 = this.mDeviceHeadsetConnectState == 2 || this.mDeviceA2dpConnectState == 2 || this.mDeviceConnectState == 2 || isLeAudioProfileConnected();
        if (z2 != this.mConnected) {
            this.mConnected = z2;
            this.mConnectedChangedMillis = SystemClock.elapsedRealtime();
            C1725a.d(TAG, new b(z2, str, 0), this.mDeviceAddress);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAISummaryType() {
        return this.mAISummaryType;
    }

    public int getAITranslationAppStatus() {
        return this.mAITranslationAppStatus;
    }

    public String getAccountKey() {
        return this.mAccountKey;
    }

    public BassEngineInfo getBassEngineValue() {
        return this.mBassEngineValue;
    }

    public List<BatteryInfo> getBatteryInfo() {
        return this.mBatteryInfoList;
    }

    public long getBatteryInfoMillis() {
        return this.mBatteryInfoMillis;
    }

    public String getBoxSn() {
        return this.mBoxSn;
    }

    public List<Integer> getCapability() {
        return this.mCapability;
    }

    public int getCervicalSpineRemindTime() {
        return this.mCervicalSpineRemindTime;
    }

    public List<Integer> getCodecList() {
        return this.mCodecList;
    }

    public int getCodecType() {
        return this.mCodecType;
    }

    public int getColorId() {
        if (this.mColorId < 0) {
            Y6.a aVar = a.C0090a.f6690a;
            int i10 = this.mProductId;
            String str = this.mDeviceName;
            aVar.getClass();
            SupportDeviceConfig supportDeviceConfig = (SupportDeviceConfig) Optional.ofNullable(Y.a(aVar.b(), f.M(i10), str)).map(new C0388w(17)).orElse(null);
            if (supportDeviceConfig != null) {
                return supportDeviceConfig.getDefaultColor();
            }
        }
        return this.mColorId;
    }

    public List<CompactnessDetectionInfo> getCompactnessDetectionInfo() {
        return this.mCompactnessDetectionInfos;
    }

    public List<ConnectDevice> getConnectDeviceList() {
        return this.mConnectDeviceList;
    }

    public long getConnectedChangedMillis() {
        return this.mConnectedChangedMillis;
    }

    public CurrentNoiseModeInfo getCurrentNoiseModeInfo() {
        return this.mCurrentNoiseModeInfo;
    }

    public BluetoothDevice getDevice() {
        if (this.mDevice == null) {
            C0391z c0391z = C0391z.f1171d;
            String str = this.mDeviceAddress;
            c0391z.getClass();
            this.mDevice = C0391z.i(str);
        }
        return this.mDevice;
    }

    public int getDeviceA2dpConnectState() {
        return this.mDeviceA2dpConnectState;
    }

    public int getDeviceAclConnectState() {
        return this.mDeviceAclConnectState;
    }

    public String getDeviceAddress() {
        return this.mDeviceAddress;
    }

    public int getDeviceBinauralRecordConnectState() {
        return this.mDeviceBinauralRecordConnectState;
    }

    public int getDeviceBondState() {
        return this.mDeviceBondState;
    }

    public int getDeviceConnectState() {
        return this.mDeviceConnectState;
    }

    public int getDeviceErrorState() {
        return this.mConnectErrorCode;
    }

    public int getDeviceHeadsetConnectState() {
        return this.mDeviceHeadsetConnectState;
    }

    public int getDeviceLeAudioConnectState() {
        Integer num = this.mLeAudioConnectStateMap.get(this.mDeviceAddress);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public Map<String, Integer> getDeviceLeAudioConnectStateMap() {
        return this.mLeAudioConnectStateMap;
    }

    public String getDeviceName() {
        if (TextUtils.isEmpty(this.mDeviceName)) {
            this.mDeviceName = C0391z.f1171d.f(getDevice());
        }
        return this.mDeviceName;
    }

    public int getDeviceProtocol() {
        return this.mDeviceProtocol;
    }

    public List<EarRestoreDataInfo> getEarRestoreDataInfoList() {
        return this.mEarRestoreDataInfos;
    }

    public List<EarTone> getEarTone() {
        return this.mEarTones;
    }

    public List<EqInfo> getEqInfoList() {
        return this.mEqInfoList;
    }

    public EqualizerModeInfo getEqualizerModeInfo() {
        return this.mEqualizerModeInfo;
    }

    public List<FeatureSwitchInfo> getFeatureSwitchInfo() {
        return this.mFeatureSwitchInfos;
    }

    public int getFullDialogRecoveryTime() {
        return this.mFreeDialogRecoveryTime;
    }

    public int getGameMode() {
        return this.mGameMode;
    }

    public GameSoundInfo getGameSoundInfo() {
        return this.mGameSoundInfo;
    }

    public int getHeadMotionType() {
        return this.mHeadMotionType;
    }

    public int getHeadsetSpatialType() {
        return this.mHeadsetSpatialType;
    }

    public IntelligentNoiseModeInfo getIntelligentNoiseModeInfo() {
        return this.mIntelligentNoiseModeInfo;
    }

    public List<KeyFunctionInfo> getKeyFunctionInfo() {
        return this.mKeyFunctionList;
    }

    public Map<String, Long> getLeAudioConnectionTimeMap() {
        return this.mLeAudioConnectTimeMap;
    }

    public int getMTU() {
        return this.mMTU;
    }

    public List<MultiConnectInformationElement> getMultiConnectionInfo() {
        return this.mMultiConnectionInfo;
    }

    public NoiseReductionInfo getNoiseReductionInfo() {
        return this.mNoiseReductionInfo;
    }

    public int getProductId() {
        return this.mProductId;
    }

    public int getProductType() {
        return this.mProductType;
    }

    public int getScreenOffBroadcastDelayTime() {
        return this.mScreenOffBroadcastDelayTime;
    }

    public List<Integer> getSpineCalibrationResult() {
        return this.mSpineCalibrationResult;
    }

    public int getSpineCalibrationState() {
        return this.mSpineCalibrationState;
    }

    public int getSpineFatigueTime() {
        return this.mSpineFatigueRemindTime;
    }

    public List<SpineHistoryDataInfo> getSpineHistoryDatas() {
        return this.mSpineHistoryDatas;
    }

    public List<Float> getSpineRangeDetection() {
        return this.mSpineRangeDetectionResult;
    }

    public int getSppOverGattConnectionState() {
        return this.mSppOverGattConnectionState;
    }

    public List<StatusInfo> getStatusInfo() {
        return this.mStatusInfoList;
    }

    public long getStatusInfoTimeMillis() {
        return this.mStatusInfoTimeMillis;
    }

    public boolean getSupportCustomEq() {
        return this.mSupportCustomEq;
    }

    public boolean getSupportMultiDeviceConnect() {
        return this.mSupportMultiDeviceConnect;
    }

    public boolean getSupportRelated() {
        return this.mSupportRelated;
    }

    public boolean getSupportSmartBluetooth() {
        return this.mSupportSmartBluetooth;
    }

    public boolean getSupportTriangle() {
        return this.mSupportTriangle;
    }

    public NoiseReductionInfo getSwitchLeftEarNoiseReductionInfo() {
        return this.mSwitchLeftEarNoiseReductionInfo;
    }

    public NoiseReductionInfo getSwitchNoiseReductionInfo() {
        return this.mSwitchNoiseReductionInfo;
    }

    public NoiseReductionInfo getSwitchRightEarNoiseReductionInfo() {
        return this.mSwitchRightEarNoiseReductionInfo;
    }

    public int getTapLevelDefaultValue() {
        return this.mTapLevelDefaultValue;
    }

    public int getTapLevelSettingValue() {
        return this.mTapLevelSettingValue;
    }

    public TriangleInfo getTriangleInfo() {
        return this.mTriangleInfo;
    }

    public String getType() {
        return this.mType;
    }

    public List<d> getUpgradeInfo() {
        return this.mUpgradeInfoList;
    }

    public int getUpgradeMTU() {
        return this.mUpgradeMTU;
    }

    public UserInteractionEventInfo getUserInteractionEventInfo() {
        return this.mUserInteractionEventInfo;
    }

    public List<VersionInfo> getVersionInfo() {
        return this.mVersionInfoList;
    }

    public int getVolumeValueInfo() {
        return this.mVolumeValueInfo;
    }

    public int getZenModeSwitchStatus() {
        return this.mZenModeSwitchStatus;
    }

    public boolean isA2dpActive() {
        return this.mA2dpActive;
    }

    public boolean isBothLeAudioProfileConnected() {
        Iterator<Map.Entry<String, Integer>> it = this.mLeAudioConnectStateMap.entrySet().iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            if (it.next().getValue().intValue() != 2) {
                z2 = false;
            }
        }
        return z2;
    }

    public boolean isConnected() {
        return this.mConnected;
    }

    public boolean isHeadsetActive() {
        return this.mHeadsetActive;
    }

    public boolean isInitCmdCompleted() {
        return this.mInitCmdCompleted;
    }

    public boolean isLeAudioActive() {
        return this.mLeAudioActive;
    }

    public boolean isLeAudioProfileConnected() {
        Iterator<Map.Entry<String, Integer>> it = this.mLeAudioConnectStateMap.entrySet().iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (it.next().getValue().intValue() == 2) {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean isLeBrSwitch() {
        return this.mLeBrSwitch;
    }

    public boolean isSupportBindAccount() {
        return this.mSupportBindAccount;
    }

    public boolean isSupportSpp() {
        return this.mIsSupportSpp;
    }

    public void setA2dpActive(boolean z2) {
        this.mA2dpActive = z2;
    }

    public void setAISummaryType(int i10) {
        this.mAISummaryType = i10;
    }

    public void setAITranslationAppStatus(int i10) {
        this.mAITranslationAppStatus = i10;
    }

    public void setAccountKey(String str) {
        this.mAccountKey = str;
    }

    public void setBassEngineValue(BassEngineInfo bassEngineInfo) {
        this.mBassEngineValue = bassEngineInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setBatteryInfo(java.util.List<com.oplus.melody.btsdk.api.data.BatteryInfo> r13) {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.btsdk.api.data.DeviceInfo.setBatteryInfo(java.util.List):void");
    }

    public void setBatteryInfoMillisNow() {
        this.mBatteryInfoMillis = SystemClock.elapsedRealtime();
    }

    public void setBoxSn(String str) {
        this.mBoxSn = str;
    }

    public void setCapability(List<Integer> list) {
        this.mCapability = list;
    }

    public void setCervicalSpineRemindTime(int i10) {
        this.mCervicalSpineRemindTime = i10;
    }

    public void setCodecList(List<Integer> list) {
        this.mCodecList = list;
    }

    public void setCodecType(int i10) {
        this.mCodecType = i10;
    }

    public void setColorId(int i10) {
        int i11 = this.mColorId;
        if (i11 != -1 && i11 != i10) {
            StringBuilder sb2 = new StringBuilder("检测到异常颜色变化：");
            r.m(sb2, this.mColorId, "->", i10, ", ");
            sb2.append(this.mDeviceAddress);
            sb2.append('(');
            sb2.append(getDeviceName());
            sb2.append(')');
            String string = sb2.toString();
            A.a aVar = C1725a.f29476a;
            A.w(TAG, string, null);
        }
        this.mColorId = i10;
    }

    public void setCompactnessDetectionInfo(List<CompactnessDetectionInfo> list) {
        this.mCompactnessDetectionInfos = list;
    }

    public void setConnectDeviceList(List<ConnectDevice> list) {
        this.mConnectDeviceList = list;
    }

    public void setConnectErrorState(int i10) {
        this.mConnectErrorCode = i10;
    }

    public void setCurrentNoiseModeInfo(CurrentNoiseModeInfo currentNoiseModeInfo) {
        this.mCurrentNoiseModeInfo = currentNoiseModeInfo;
    }

    public void setDevice(BluetoothDevice bluetoothDevice) {
        this.mDevice = bluetoothDevice;
    }

    public void setDeviceA2dpConnectState(int i10) {
        this.mDeviceA2dpConnectState = i10;
        updateConnected("A2DP");
    }

    public void setDeviceAclConnectState(int i10) {
        if (this.mDeviceAclConnectState != i10) {
            C1725a.c(TAG, new Ga.a(this, i10, 2));
        }
        this.mDeviceAclConnectState = i10;
    }

    public void setDeviceAddress(String str) {
        this.mDeviceAddress = str;
    }

    public void setDeviceBinauralRecordConnectState(int i10) {
        this.mDeviceBinauralRecordConnectState = i10;
    }

    public void setDeviceBondState(int i10) {
        this.mDeviceBondState = i10;
    }

    public void setDeviceConnectState(int i10) {
        this.mDeviceConnectState = i10;
        updateConnected("SPP");
    }

    public void setDeviceHeadsetConnectState(int i10) {
        this.mDeviceHeadsetConnectState = i10;
        updateConnected("HFP");
    }

    public void setDeviceLeAudioConnectState(int i10) {
        this.mLeAudioConnectStateMap.put(this.mDeviceAddress, Integer.valueOf(i10));
        updateConnected("LE1");
    }

    public void setDeviceName(String str) {
        this.mDeviceName = str;
    }

    public void setDeviceProtocol(int i10) {
        this.mDeviceProtocol = i10;
    }

    public void setEarRestoreDataInfoList(List<EarRestoreDataInfo> list) {
        this.mEarRestoreDataInfos = list;
    }

    public void setEarTone(List<EarTone> list) {
        this.mEarTones = list;
    }

    public void setEqInfoList(List<EqInfo> list) {
        this.mEqInfoList = list;
    }

    public void setEqualizerModeInfo(EqualizerModeInfo equalizerModeInfo) {
        this.mEqualizerModeInfo = equalizerModeInfo;
    }

    public void setFeatureSwitchInfo(List<FeatureSwitchInfo> list) {
        this.mFeatureSwitchInfos = list;
    }

    public void setFullDialogRecoveryTime(int i10) {
        this.mFreeDialogRecoveryTime = i10;
    }

    public void setGameMode(int i10) {
        this.mGameMode = i10;
    }

    public void setGameSoundInfo(GameSoundInfo gameSoundInfo) {
        this.mGameSoundInfo = gameSoundInfo;
    }

    public void setHeadMotionType(int i10) {
        this.mHeadMotionType = i10;
    }

    public void setHeadsetActive(boolean z2) {
        this.mHeadsetActive = z2;
    }

    public void setHeadsetSpatialType(int i10) {
        this.mHeadsetSpatialType = i10;
    }

    public void setInitCmdCompleted(boolean z2) {
        if (this.mInitCmdCompleted != z2) {
            C1725a.m(TAG, C1656o.b(new StringBuilder("m_bt_le.setInitCmdCompleted, mInitCmdCompleted: "), this.mInitCmdCompleted, ", completed: ", z2), this.mDeviceAddress);
        }
        this.mInitCmdCompleted = z2;
    }

    public void setIntelligentNoiseModeInfo(IntelligentNoiseModeInfo intelligentNoiseModeInfo) {
        this.mIntelligentNoiseModeInfo = intelligentNoiseModeInfo;
    }

    public void setIsSupportSpp(boolean z2) {
        this.mIsSupportSpp = z2;
    }

    public void setKeyFunctions(List<KeyFunctionInfo> list) {
        C1725a.c(TAG, new D9.b(3, list));
        this.mKeyFunctionList = list;
    }

    public void setLeAudioActive(boolean z2) {
        this.mLeAudioActive = z2;
    }

    public void setLeAudioConnectionTime(String str, long j5) {
        this.mLeAudioConnectTimeMap.put(str, Long.valueOf(j5));
    }

    public void setLeBrSwitch(boolean z2) {
        this.mLeBrSwitch = z2;
    }

    public void setMTU(int i10) {
        this.mMTU = i10;
    }

    public void setMultiConnectionInfo(List<MultiConnectInformationElement> list) {
        this.mMultiConnectionInfo = list;
    }

    public void setNoiseReductionInfo(NoiseReductionInfo noiseReductionInfo) {
        this.mNoiseReductionInfo = noiseReductionInfo;
    }

    public void setProductId(int i10) {
        int i11 = this.mProductId;
        if (i11 == 0 || i11 == i10) {
            this.mProductId = i10;
            return;
        }
        String deviceName = getDeviceName();
        String strM = f.M(i10);
        String strM2 = f.M(this.mProductId);
        SupportDeviceConfig supportDeviceConfig = (SupportDeviceConfig) Optional.ofNullable(Y.a(a.C0090a.f6690a.b(), strM, deviceName)).map(new C0388w(17)).orElse(null);
        if (supportDeviceConfig == null || !TextUtils.equals(supportDeviceConfig.getId(), strM) || !TextUtils.equals(supportDeviceConfig.getName(), deviceName)) {
            StringBuilder sbI = r.i("检测到异常PID变化：", strM2, "->", strM, ", ");
            sbI.append(this.mDeviceAddress);
            sbI.append('(');
            sbI.append(deviceName);
            sbI.append(')');
            String string = sbI.toString();
            A.a aVar = C1725a.f29476a;
            A.w(TAG, string, null);
            return;
        }
        this.mProductId = i10;
        StringBuilder sbI2 = r.i("重置设备PID：", strM2, "->", strM, ", ");
        sbI2.append(this.mDeviceAddress);
        sbI2.append('(');
        sbI2.append(deviceName);
        sbI2.append(')');
        String string2 = sbI2.toString();
        A.a aVar2 = C1725a.f29476a;
        A.w(TAG, string2, null);
    }

    public void setProductType(int i10) {
        this.mProductType = i10;
    }

    public void setScreenOffBroadcastDelayTime(int i10) {
        this.mScreenOffBroadcastDelayTime = i10;
    }

    public void setSpineCalibrationResult(List<Integer> list) {
        this.mSpineCalibrationResult = list;
    }

    public void setSpineCalibrationState(int i10) {
        this.mSpineCalibrationState = i10;
    }

    public void setSpineFatigueTime(int i10) {
        this.mSpineFatigueRemindTime = i10;
    }

    public void setSpineHistoryDatas(List<SpineHistoryDataInfo> list) {
        this.mSpineHistoryDatas = list;
    }

    public void setSpineRangeDetection(List<Float> list) {
        this.mSpineRangeDetectionResult = list;
    }

    public void setSppOverGattConnectionState(int i10) {
        this.mSppOverGattConnectionState = i10;
    }

    public void setStatusInfo(List<StatusInfo> list) {
        this.mStatusInfoList = list;
        this.mStatusInfoTimeMillis = SystemClock.elapsedRealtime();
    }

    public void setSupportBindAccount(boolean z2) {
        this.mSupportBindAccount = z2;
    }

    public void setSupportCustomEq(boolean z2) {
        this.mSupportCustomEq = z2;
    }

    public void setSupportMultiDeviceConnect(boolean z2) {
        this.mSupportMultiDeviceConnect = z2;
    }

    public void setSupportRelated(boolean z2) {
        this.mSupportRelated = z2;
    }

    public void setSupportSmartBluetooth(boolean z2) {
        this.mSupportSmartBluetooth = z2;
    }

    public void setSupportTriangle(boolean z2) {
        this.mSupportTriangle = z2;
    }

    public void setSwitchLeftEarNoiseReductionInfo(NoiseReductionInfo noiseReductionInfo) {
        this.mSwitchLeftEarNoiseReductionInfo = noiseReductionInfo;
    }

    public void setSwitchNoiseReductionInfo(NoiseReductionInfo noiseReductionInfo) {
        this.mSwitchNoiseReductionInfo = noiseReductionInfo;
    }

    public void setSwitchRightEarNoiseReductionInfo(NoiseReductionInfo noiseReductionInfo) {
        this.mSwitchRightEarNoiseReductionInfo = noiseReductionInfo;
    }

    public void setTapLevelDefaultValue(int i10) {
        this.mTapLevelDefaultValue = i10;
    }

    public void setTapLevelSettingValue(int i10) {
        this.mTapLevelSettingValue = i10;
    }

    public void setTriangleInfo(TriangleInfo triangleInfo) {
        this.mTriangleInfo = triangleInfo;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setUpgradeInfo(List<d> list) {
        this.mUpgradeInfoList = list;
    }

    public void setUpgradeMTU(int i10) {
        this.mUpgradeMTU = i10;
    }

    public void setUserInteractionEventInfo(UserInteractionEventInfo userInteractionEventInfo) {
        this.mUserInteractionEventInfo = userInteractionEventInfo;
    }

    public void setVersionInfo(List<VersionInfo> list) {
        this.mVersionInfoList = list;
    }

    public void setVolumeValueInfo(int i10) {
        this.mVolumeValueInfo = i10;
    }

    public void setZenModeSwitchStatus(int i10) {
        this.mZenModeSwitchStatus = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mProductType);
        parcel.writeInt(this.mDeviceBTType);
        parcel.writeInt(this.mDeviceConnectState);
        parcel.writeInt(this.mDeviceBondState);
        parcel.writeInt(this.mDeviceA2dpConnectState);
        parcel.writeInt(this.mDeviceHeadsetConnectState);
        parcel.writeInt(this.mDeviceAclConnectState);
        parcel.writeInt(this.mDeviceBinauralRecordConnectState);
        parcel.writeMap(this.mLeAudioConnectStateMap);
        parcel.writeMap(this.mLeAudioConnectTimeMap);
        parcel.writeInt(this.mConnectErrorCode);
        parcel.writeString(this.mDeviceName);
        parcel.writeString(this.mDeviceAddress);
        parcel.writeInt(this.mDeviceProtocol);
        parcel.writeInt(this.mColorId);
        parcel.writeString(this.mType);
        parcel.writeByte(this.mHeadsetActive ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mA2dpActive ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mLeAudioActive ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mProductId);
        parcel.writeInt(this.mMTU);
        parcel.writeParcelable(this.mDevice, i10);
        parcel.writeLong(this.mBatteryInfoMillis);
        parcel.writeTypedList(this.mBatteryInfoList);
        parcel.writeTypedList(this.mKeyFunctionList);
        parcel.writeTypedList(this.mVersionInfoList);
        parcel.writeTypedList(this.mStatusInfoList);
        parcel.writeTypedList(this.mFeatureSwitchInfos);
        parcel.writeInt(this.mZenModeSwitchStatus);
        parcel.writeTypedList(this.mMultiConnectionInfo);
        parcel.writeParcelable(this.mNoiseReductionInfo, i10);
        parcel.writeParcelable(this.mSwitchNoiseReductionInfo, i10);
        parcel.writeParcelable(this.mSwitchLeftEarNoiseReductionInfo, i10);
        parcel.writeParcelable(this.mSwitchRightEarNoiseReductionInfo, i10);
        parcel.writeParcelable(this.mCurrentNoiseModeInfo, i10);
        parcel.writeParcelable(this.mIntelligentNoiseModeInfo, i10);
        parcel.writeParcelable(this.mEqualizerModeInfo, i10);
        parcel.writeParcelable(this.mUserInteractionEventInfo, i10);
        parcel.writeTypedList(this.mCompactnessDetectionInfos);
        parcel.writeTypedList(this.mConnectDeviceList);
        parcel.writeByte(this.mIsSupportSpp ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mSupportMultiDeviceConnect ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mFreeDialogRecoveryTime);
        parcel.writeByte(this.mSupportRelated ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mGameMode);
        parcel.writeTypedList(this.mEarRestoreDataInfos);
        parcel.writeList(this.mCapability);
        parcel.writeInt(this.mCodecType);
        parcel.writeTypedList(this.mEqInfoList);
        parcel.writeList(this.mEarTones);
        parcel.writeByte(this.mSupportCustomEq ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mSupportSmartBluetooth ? (byte) 1 : (byte) 0);
        parcel.writeList(this.mCodecList);
        parcel.writeParcelable(this.mBassEngineValue, i10);
        parcel.writeByte(this.mSupportTriangle ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.mTriangleInfo, i10);
        parcel.writeByte(this.mSupportBindAccount ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mAccountKey);
        parcel.writeInt(this.mScreenOffBroadcastDelayTime);
        parcel.writeList(this.mSpineCalibrationResult);
        parcel.writeList(this.mSpineRangeDetectionResult);
        parcel.writeList(this.mSpineHistoryDatas);
        parcel.writeInt(this.mSpineFatigueRemindTime);
        parcel.writeInt(this.mHeadsetSpatialType);
        parcel.writeInt(this.mAISummaryType);
        parcel.writeInt(this.mAITranslationAppStatus);
        parcel.writeInt(this.mVolumeValueInfo);
        parcel.writeInt(this.mTapLevelSettingValue);
        parcel.writeInt(this.mTapLevelDefaultValue);
        parcel.writeParcelable(this.mGameSoundInfo, i10);
        parcel.writeInt(this.mSppOverGattConnectionState);
        parcel.writeByte(this.mConnected ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.mConnectedChangedMillis);
        parcel.writeLong(this.mStatusInfoTimeMillis);
        parcel.writeByte(this.mInitCmdCompleted ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mLeBrSwitch ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mBoxSn);
        parcel.writeInt(this.mUpgradeMTU);
        parcel.writeInt(this.mHeadMotionType);
    }

    public void setDeviceLeAudioConnectState(String str, int i10) {
        Integer num = this.mLeAudioConnectStateMap.get(str);
        if (num == null || num.intValue() != i10) {
            setLeAudioConnectionTime(str, System.currentTimeMillis());
        }
        this.mLeAudioConnectStateMap.put(str, Integer.valueOf(i10));
        updateConnected("LE2");
    }

    public DeviceInfo(Parcel parcel) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.mLeAudioConnectStateMap = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        this.mLeAudioConnectTimeMap = concurrentHashMap2;
        this.mProductType = -1;
        this.mDeviceBTType = -1;
        this.mDeviceConnectState = 0;
        this.mDeviceBondState = 0;
        this.mDeviceA2dpConnectState = 0;
        this.mDeviceHeadsetConnectState = 0;
        this.mDeviceAclConnectState = 0;
        this.mDeviceBinauralRecordConnectState = 0;
        this.mConnectErrorCode = 0;
        this.mDeviceName = "";
        this.mDeviceAddress = "";
        this.mDeviceProtocol = -1;
        this.mColorId = -1;
        this.mType = "";
        this.mA2dpActive = false;
        this.mHeadsetActive = false;
        this.mLeAudioActive = false;
        this.mMTU = -1;
        this.mSppOverGattConnectionState = 0;
        this.mConnected = false;
        this.mInitCmdCompleted = false;
        this.mLeBrSwitch = false;
        this.mProductType = parcel.readInt();
        this.mDeviceBTType = parcel.readInt();
        this.mDeviceConnectState = parcel.readInt();
        this.mDeviceBondState = parcel.readInt();
        this.mDeviceA2dpConnectState = parcel.readInt();
        this.mDeviceHeadsetConnectState = parcel.readInt();
        this.mDeviceAclConnectState = parcel.readInt();
        this.mDeviceBinauralRecordConnectState = parcel.readInt();
        parcel.readMap(concurrentHashMap, concurrentHashMap.getClass().getClassLoader());
        parcel.readMap(concurrentHashMap2, concurrentHashMap2.getClass().getClassLoader());
        this.mConnectErrorCode = parcel.readInt();
        this.mDeviceName = parcel.readString();
        this.mDeviceAddress = parcel.readString();
        this.mDeviceProtocol = parcel.readInt();
        this.mColorId = parcel.readInt();
        this.mType = parcel.readString();
        this.mHeadsetActive = parcel.readByte() != 0;
        this.mA2dpActive = parcel.readByte() != 0;
        this.mLeAudioActive = parcel.readByte() != 0;
        this.mProductId = parcel.readInt();
        this.mMTU = parcel.readInt();
        this.mDevice = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.mBatteryInfoMillis = parcel.readLong();
        this.mBatteryInfoList = parcel.createTypedArrayList(BatteryInfo.CREATOR);
        this.mKeyFunctionList = parcel.createTypedArrayList(KeyFunctionInfo.CREATOR);
        this.mVersionInfoList = parcel.createTypedArrayList(VersionInfo.CREATOR);
        this.mStatusInfoList = parcel.createTypedArrayList(StatusInfo.CREATOR);
        this.mFeatureSwitchInfos = parcel.createTypedArrayList(FeatureSwitchInfo.CREATOR);
        this.mZenModeSwitchStatus = parcel.readInt();
        this.mMultiConnectionInfo = parcel.createTypedArrayList(MultiConnectInformationElement.CREATOR);
        this.mNoiseReductionInfo = (NoiseReductionInfo) parcel.readParcelable(NoiseReductionInfo.class.getClassLoader());
        this.mSwitchNoiseReductionInfo = (NoiseReductionInfo) parcel.readParcelable(NoiseReductionInfo.class.getClassLoader());
        this.mSwitchLeftEarNoiseReductionInfo = (NoiseReductionInfo) parcel.readParcelable(NoiseReductionInfo.class.getClassLoader());
        this.mSwitchRightEarNoiseReductionInfo = (NoiseReductionInfo) parcel.readParcelable(NoiseReductionInfo.class.getClassLoader());
        this.mCurrentNoiseModeInfo = (CurrentNoiseModeInfo) parcel.readParcelable(CurrentNoiseModeInfo.class.getClassLoader());
        this.mIntelligentNoiseModeInfo = (IntelligentNoiseModeInfo) parcel.readParcelable(IntelligentNoiseModeInfo.class.getClassLoader());
        this.mEqualizerModeInfo = (EqualizerModeInfo) parcel.readParcelable(EqualizerModeInfo.class.getClassLoader());
        this.mUserInteractionEventInfo = (UserInteractionEventInfo) parcel.readParcelable(UserInteractionEventInfo.class.getClassLoader());
        this.mCompactnessDetectionInfos = parcel.createTypedArrayList(CompactnessDetectionInfo.CREATOR);
        this.mConnectDeviceList = parcel.createTypedArrayList(ConnectDevice.CREATOR);
        this.mIsSupportSpp = parcel.readByte() != 0;
        this.mSupportMultiDeviceConnect = parcel.readByte() != 0;
        this.mFreeDialogRecoveryTime = parcel.readInt();
        this.mSupportRelated = parcel.readInt() != 0;
        this.mGameMode = parcel.readInt();
        this.mEarRestoreDataInfos = parcel.createTypedArrayList(EarRestoreDataInfo.CREATOR);
        Class cls = Integer.TYPE;
        this.mCapability = parcel.readArrayList(cls.getClassLoader());
        this.mCodecType = parcel.readInt();
        this.mEqInfoList = parcel.createTypedArrayList(EqInfo.CREATOR);
        this.mEarTones = parcel.readArrayList(EarTone.class.getClassLoader());
        this.mSupportCustomEq = parcel.readByte() != 0;
        this.mSupportSmartBluetooth = parcel.readByte() != 0;
        this.mCodecList = parcel.readArrayList(cls.getClassLoader());
        this.mBassEngineValue = (BassEngineInfo) parcel.readParcelable(BassEngineInfo.class.getClassLoader());
        this.mSupportTriangle = parcel.readInt() != 0;
        this.mTriangleInfo = (TriangleInfo) parcel.readParcelable(TriangleInfo.class.getClassLoader());
        this.mSupportBindAccount = parcel.readByte() != 0;
        this.mAccountKey = parcel.readString();
        this.mScreenOffBroadcastDelayTime = parcel.readInt();
        this.mSpineCalibrationResult = parcel.readArrayList(Integer.class.getClassLoader());
        this.mSpineRangeDetectionResult = parcel.readArrayList(Float.class.getClassLoader());
        this.mSpineHistoryDatas = parcel.readArrayList(SpineHistoryDataInfo.class.getClassLoader());
        this.mSpineFatigueRemindTime = parcel.readInt();
        this.mHeadsetSpatialType = parcel.readInt();
        this.mAISummaryType = parcel.readInt();
        this.mAITranslationAppStatus = parcel.readInt();
        this.mVolumeValueInfo = parcel.readInt();
        this.mTapLevelSettingValue = parcel.readInt();
        this.mTapLevelDefaultValue = parcel.readInt();
        this.mGameSoundInfo = (GameSoundInfo) parcel.readParcelable(GameSoundInfo.class.getClassLoader());
        this.mSppOverGattConnectionState = parcel.readInt();
        this.mConnected = parcel.readByte() != 0;
        this.mConnectedChangedMillis = parcel.readLong();
        this.mStatusInfoTimeMillis = parcel.readLong();
        this.mInitCmdCompleted = parcel.readByte() != 0;
        this.mLeBrSwitch = parcel.readByte() != 0;
        this.mBoxSn = parcel.readString();
        this.mUpgradeMTU = parcel.readInt();
        this.mHeadMotionType = parcel.readInt();
    }
}
