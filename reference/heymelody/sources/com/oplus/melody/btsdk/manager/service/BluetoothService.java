package com.oplus.melody.btsdk.manager.service;

import A5.i;
import D7.C0373g;
import D7.C0391z;
import D7.Y;
import Ea.G;
import I7.j;
import P3.d;
import S7.c;
import U6.b;
import V6.f;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.oplus.drs.statistics.DataTypeConstants;
import com.oplus.melody.btsdk.api.data.BatteryInfo;
import com.oplus.melody.btsdk.api.data.BluetoothReceiveData;
import com.oplus.melody.btsdk.api.data.CurrentNoiseModeInfo;
import com.oplus.melody.btsdk.api.data.DebugFeatureInfo;
import com.oplus.melody.btsdk.api.data.DeviceInfo;
import com.oplus.melody.btsdk.api.data.EarRestoreDataInfo;
import com.oplus.melody.btsdk.api.data.EqInfo;
import com.oplus.melody.btsdk.api.data.EqualizerModeInfo;
import com.oplus.melody.btsdk.api.data.HearingDetectingInfo;
import com.oplus.melody.btsdk.api.data.KeyFunctionInfo;
import com.oplus.melody.btsdk.api.data.NoiseReductionInfo;
import com.oplus.melody.btsdk.api.data.RelatedDeviceInfo;
import com.oplus.melody.btsdk.api.data.ToneFileVertifyInformation;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.btsdk.api.data.ZenModeFileVertifyInformation;
import com.oplus.melody.btsdk.api.manager.DeviceInfoManager;
import com.oplus.melody.btsdk.manager.ZenModeTransferManager;
import com.oplus.melody.btsdk.manager.ZenModeUpgradeListener;
import com.oplus.melody.btsdk.multidevice.HeadsetCoreService;
import com.oplus.melody.common.helper.MelodyAlivePreferencesHelper;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.Q;
import j7.C1212a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import k7.h;
import k7.o;
import z7.C1725a;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f19283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerThread f19284b;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<BluetoothService> f19285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ZenModeUpgradeListener f19286b;

        public a(BluetoothService bluetoothService, Looper looper) {
            super(looper);
            this.f19285a = new WeakReference<>(bluetoothService);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i10;
            boolean zL0;
            byte[] byteArrayExtra;
            byte[] byteArrayExtra2;
            Bundle bundleExtra;
            Intent intent = (Intent) message.obj;
            BluetoothService bluetoothService = this.f19285a.get();
            if (bluetoothService == null) {
                C1725a.f("BluetoothService", "handleMessage: 0x" + Integer.toHexString(message.what) + ", service is null");
                return;
            }
            A.a aVar = C1725a.f29476a;
            if (A.l()) {
                C1725a.a("BluetoothService", "handleMessage: 0x" + Integer.toHexString(message.what));
            }
            if (message.what == 1000) {
                b.a.f5178a.a(bluetoothService);
                return;
            }
            X6.a aVar2 = b.a.f5178a.f5175b;
            if (aVar2 == null) {
                C1725a.a("BluetoothService", "handleMessage: btOperate is null ,please check ...");
                return;
            }
            switch (message.what) {
                case DataTypeConstants.USER_ACTION /* 1001 */:
                    aVar2.f5989a.t();
                    return;
                case DataTypeConstants.APP_LOG /* 1002 */:
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) C0914u.f(intent, "param_bluetooth_device", BluetoothDevice.class);
                    aVar2.f5990b.getClass();
                    if (bluetoothDevice == null) {
                        C1725a.f("ConnectManager", "connect bt device is null");
                        return;
                    } else {
                        C1725a.a("ConnectManager", "connect bt");
                        h.e.f25190a.d(bluetoothDevice);
                        return;
                    }
                case DataTypeConstants.PAGE_VISIT /* 1003 */:
                    aVar2.f5990b.q((BluetoothDevice) C0914u.f(intent, "param_bluetooth_device", BluetoothDevice.class));
                    return;
                case DataTypeConstants.EXCEPTION /* 1004 */:
                    String strH = C0914u.h(intent, "param_address");
                    aVar2.f5990b.getClass();
                    if (TextUtils.isEmpty(strH)) {
                        C1725a.f("ConnectManager", "connect bt address is empty");
                        return;
                    }
                    C1725a.b("ConnectManager", "connect bt address", strH);
                    C0391z.f1171d.getClass();
                    BluetoothDevice bluetoothDeviceI = C0391z.i(strH);
                    if (bluetoothDeviceI == null) {
                        C1725a.a("ConnectManager", "not find this device, connect fail");
                        return;
                    } else {
                        C1725a.a("ConnectManager", "connect bt");
                        h.e.f25190a.d(bluetoothDeviceI);
                        return;
                    }
                case DataTypeConstants.SPECIAL_APP_START /* 1005 */:
                    String strH2 = C0914u.h(intent, "param_address");
                    i iVar = aVar2.f5990b;
                    iVar.getClass();
                    if (TextUtils.isEmpty(strH2)) {
                        C1725a.f("ConnectManager", "disconnect bt address is empty");
                        return;
                    }
                    C1725a.a("ConnectManager", "disconnect bt");
                    C0391z.f1171d.getClass();
                    BluetoothDevice bluetoothDeviceI2 = C0391z.i(strH2);
                    if (bluetoothDeviceI2 == null) {
                        C1725a.a("ConnectManager", "not find this device, disconnect fail");
                        return;
                    } else {
                        iVar.q(bluetoothDeviceI2);
                        return;
                    }
                case DataTypeConstants.COMMON /* 1006 */:
                    String strH3 = C0914u.h(intent, "param_address");
                    i iVar2 = aVar2.f5990b;
                    iVar2.getClass();
                    if (TextUtils.isEmpty(strH3)) {
                        C1725a.f("ConnectManager", "connect spp address is null");
                        return;
                    }
                    C1725a.a("ConnectManager", "command connect spp");
                    HeadsetCoreService headsetCoreService = (HeadsetCoreService) iVar2.f58b;
                    if (headsetCoreService != null) {
                        headsetCoreService.u(strH3);
                        return;
                    }
                    return;
                case DataTypeConstants.DYNAMIC_EVENT_TYPE /* 1007 */:
                    String strH4 = C0914u.h(intent, "param_address");
                    i iVar3 = aVar2.f5990b;
                    iVar3.getClass();
                    if (TextUtils.isEmpty(strH4)) {
                        C1725a.f("ConnectManager", "disconnectSpp spp address is empty");
                        return;
                    }
                    C1725a.a("ConnectManager", "command disconnect spp");
                    HeadsetCoreService headsetCoreService2 = (HeadsetCoreService) iVar3.f58b;
                    if (headsetCoreService2 != null) {
                        headsetCoreService2.x(strH4);
                        return;
                    }
                    return;
                case DataTypeConstants.STATIC_EVENT_TYPE /* 1008 */:
                    aVar2.f5989a.i1(C0914u.h(intent, "param_address"), C0914u.h(intent, "param_file_path"), C0914u.c(intent, "param_upgrade_type", 255), C0914u.c(intent, "param_upgrade_device_type", 1));
                    return;
                case DataTypeConstants.DEBUG_TYPE /* 1009 */:
                    aVar2.f5989a.r(C0914u.h(intent, "param_address"));
                    return;
                case DataTypeConstants.COMMON_BATCH /* 1010 */:
                    aVar2.f5989a.n1(C0914u.c(intent, "param_upgrade_type", 255), C0914u.h(intent, "param_address"));
                    return;
                case 1011:
                    String strH5 = C0914u.h(intent, "param_address");
                    boolean zB = C0914u.b(intent, "param_in_find_mode", false);
                    X6.b bVar = aVar2.f5993e;
                    bVar.getClass();
                    if (TextUtils.isEmpty(strH5)) {
                        C1725a.f("SetManager", "set find mode address is empty");
                        return;
                    } else {
                        C1725a.c("SetManager", new G(11, zB));
                        bVar.f5995a.I0(strH5, zB);
                        return;
                    }
                case 1012:
                    String strH6 = C0914u.h(intent, "param_address");
                    int iC = C0914u.c(intent, "param_feature_id", -1);
                    boolean zB2 = C0914u.b(intent, "param_feature_status", false);
                    boolean zB3 = C0914u.b(intent, "param_need_get_state", true);
                    X6.b bVar2 = aVar2.f5993e;
                    bVar2.getClass();
                    if (TextUtils.isEmpty(strH6)) {
                        C1725a.f("SetManager", "setSwitchFeature address is empty");
                        return;
                    } else {
                        C1725a.c("SetManager", new Y(iC, 16));
                        bVar2.f5995a.a1(strH6, iC, zB2, zB3);
                        return;
                    }
                case 1013:
                    NoiseReductionInfo noiseReductionInfo = (NoiseReductionInfo) C0914u.f(intent, "param_noise_reduction_info", NoiseReductionInfo.class);
                    String strH7 = C0914u.h(intent, "param_address");
                    X6.b bVar3 = aVar2.f5993e;
                    bVar3.getClass();
                    if (TextUtils.isEmpty(strH7)) {
                        C1725a.f("SetManager", "setSupportNoiseReduction address is empty");
                        return;
                    } else if (noiseReductionInfo == null) {
                        C1725a.f("SetManager", "setSupportNoiseReduction reduction is null");
                        return;
                    } else {
                        C1725a.c("SetManager", new c(noiseReductionInfo, 5));
                        bVar3.f5995a.Z0(strH7, noiseReductionInfo);
                        return;
                    }
                case 1014:
                    CurrentNoiseModeInfo currentNoiseModeInfo = (CurrentNoiseModeInfo) C0914u.f(intent, "param_current_noise_mode_info", CurrentNoiseModeInfo.class);
                    String strH8 = C0914u.h(intent, "param_address");
                    X6.b bVar4 = aVar2.f5993e;
                    bVar4.getClass();
                    if (TextUtils.isEmpty(strH8)) {
                        C1725a.f("SetManager", "setCurrentNoiseReduction address is empty");
                        return;
                    } else if (currentNoiseModeInfo == null) {
                        C1725a.f("SetManager", "setCurrentNoiseReduction reduction is null");
                        return;
                    } else {
                        C1725a.c("SetManager", new d(currentNoiseModeInfo, 16));
                        bVar4.f5995a.D0(strH8, currentNoiseModeInfo);
                        return;
                    }
                case 1015:
                    EqualizerModeInfo equalizerModeInfo = (EqualizerModeInfo) C0914u.f(intent, "param_equalizer_mode_info", EqualizerModeInfo.class);
                    String strH9 = C0914u.h(intent, "param_address");
                    X6.b bVar5 = aVar2.f5993e;
                    bVar5.getClass();
                    if (TextUtils.isEmpty(strH9)) {
                        C1725a.a("SetManager", "setEqMode: address is empty...");
                        return;
                    } else if (equalizerModeInfo == null) {
                        C1725a.a("SetManager", "setEqMode: equalizerModeInfo is null");
                        return;
                    } else {
                        C1725a.c("SetManager", new T8.d(equalizerModeInfo, 5));
                        bVar5.f5995a.H0(strH9, equalizerModeInfo);
                        return;
                    }
                case 1016:
                    String strH10 = C0914u.h(intent, "param_address");
                    X6.b bVar6 = aVar2.f5993e;
                    bVar6.getClass();
                    if (TextUtils.isEmpty(strH10)) {
                        C1725a.a("SetManager", "getEqMode: address is empty...");
                        return;
                    } else {
                        C1725a.a("SetManager", "getEqMode");
                        bVar6.f5995a.P(strH10);
                        return;
                    }
                case 1017:
                    String strH11 = C0914u.h(intent, "param_address");
                    X6.b bVar7 = aVar2.f5993e;
                    bVar7.getClass();
                    if (TextUtils.isEmpty(strH11)) {
                        C1725a.a("SetManager", "getAllEqInfo: address is empty...");
                        return;
                    } else {
                        C1725a.a("SetManager", "getAllEqInfo");
                        bVar7.f5995a.B(strH11);
                        return;
                    }
                case 1018:
                    EqInfo eqInfo = (EqInfo) C0914u.f(intent, "param_eq_info", EqInfo.class);
                    String strH12 = C0914u.h(intent, "param_address");
                    int iC2 = C0914u.c(intent, "param_set_eq_action", 0);
                    X6.b bVar8 = aVar2.f5993e;
                    bVar8.getClass();
                    if (TextUtils.isEmpty(strH12)) {
                        C1725a.a("SetManager", "setEqInfo: address is empty...");
                        return;
                    }
                    if (iC2 == 0) {
                        C1725a.a("SetManager", "setEqInfo: action is NONE");
                        return;
                    } else if (eqInfo == null) {
                        C1725a.a("SetManager", "setEqInfo: eqInfo is null");
                        return;
                    } else {
                        C1725a.c("SetManager", new T8.d(eqInfo, 4));
                        bVar8.f5995a.G0(strH12, eqInfo, iC2);
                        return;
                    }
                case DataTypeConstants.PERIOD_DATA /* 1019 */:
                    String strH13 = C0914u.h(intent, "param_address");
                    X6.b bVar9 = aVar2.f5993e;
                    bVar9.getClass();
                    if (TextUtils.isEmpty(strH13)) {
                        C1725a.a("SetManager", "switchCompactnessDetectionStatus: address is empty...");
                        return;
                    } else {
                        bVar9.f5995a.k1(1, strH13);
                        return;
                    }
                case DataTypeConstants.SETTING_KEY /* 1020 */:
                    String strH14 = C0914u.h(intent, "param_address");
                    X6.b bVar10 = aVar2.f5993e;
                    bVar10.getClass();
                    if (TextUtils.isEmpty(strH14)) {
                        C1725a.a("SetManager", "switchCompactnessDetectionStatus: address is empty...");
                        return;
                    } else {
                        bVar10.f5995a.k1(0, strH14);
                        return;
                    }
                case 1021:
                    ArrayList arrayListD = C0914u.d(intent, "param_key_function_info", KeyFunctionInfo.class);
                    int iC3 = C0914u.c(intent, "param_protocol", 1025);
                    String strH15 = C0914u.h(intent, "param_address");
                    X6.b bVar11 = aVar2.f5993e;
                    bVar11.getClass();
                    if (TextUtils.isEmpty(strH15)) {
                        C1725a.a("SetManager", "setKeyFunctions: address is empty...");
                        return;
                    } else if (C0901g.a(arrayListD)) {
                        C1725a.a("SetManager", "setKeyFunctions: infoList is empty...");
                        return;
                    } else {
                        bVar11.f5995a.Q0(iC3, strH15, arrayListD);
                        return;
                    }
                case 1022:
                    aVar2.f5989a.I(C0914u.h(intent, "param_address"));
                    return;
                case 1023:
                    aVar2.f5989a.b0(C0914u.h(intent, "param_address"));
                    return;
                case 1024:
                    aVar2.f5989a.G(C0914u.h(intent, "param_address"));
                    return;
                case 1025:
                    aVar2.f5989a.f0(C0914u.h(intent, "param_address"));
                    return;
                case 1026:
                    aVar2.f5989a.O(C0914u.h(intent, "param_address"));
                    return;
                case 1027:
                    aVar2.f5989a.q0(C0914u.c(intent, "param_hearing_type", -1), C0914u.c(intent, "param_detect_status", -1), C0914u.h(intent, "param_address"), C0914u.c(intent, "param_hearing_uid", -1), C0914u.c(intent, "param_detect_value", -1));
                    return;
                case 1028:
                    aVar2.f5989a.m1(C0914u.h(intent, "param_address"), (HearingDetectingInfo) C0914u.f(intent, "param_detecting_info", HearingDetectingInfo.class));
                    return;
                case 1029:
                    aVar2.f5989a.w0(C0914u.h(intent, "param_address"), C0914u.c(intent, "param_hearing_action_type", -1), C0914u.c(intent, "param_hearing_uid", -1), C0914u.h(intent, "param_hearing_name"), C0914u.d(intent, "param_detecting_info_list", HearingDetectingInfo.class));
                    return;
                case 1030:
                    aVar2.f5989a.W(C0914u.c(intent, "param_hearing_uid", -1), C0914u.h(intent, "param_address"), C0914u.d(intent, "param_detecting_info_list", HearingDetectingInfo.class));
                    return;
                case 1031:
                    aVar2.f5989a.V(C0914u.h(intent, "param_address"));
                    return;
                case 1032:
                    aVar2.f5989a.F0(C0914u.h(intent, "param_address"), C0914u.d(intent, "param_ear_restore_data_list", EarRestoreDataInfo.class));
                    return;
                case 1033:
                    aVar2.f5989a.c0(C0914u.h(intent, "param_address"));
                    return;
                case 1034:
                    aVar2.f5989a.T0(C0914u.c(intent, "param_noise_action", -1), C0914u.h(intent, "param_address"));
                    return;
                case 1035:
                    aVar2.f5989a.Q(C0914u.h(intent, "param_address"));
                    return;
                case 1036:
                    aVar2.f5989a.C0(C0914u.c(intent, "param_camera_status", 1), C0914u.h(intent, "param_address"));
                    return;
                case 1037:
                    String strH16 = C0914u.h(intent, "param_address");
                    byte bC = (byte) C0914u.c(intent, "dialog_recovery_time", -1);
                    X6.b bVar12 = aVar2.f5993e;
                    bVar12.getClass();
                    if (TextUtils.isEmpty(strH16)) {
                        C1725a.a("SetManager", "setFreeDialogRecoveryTime: address is empty...");
                        return;
                    } else {
                        C1725a.a("SetManager", "setFreeDialogRecoveryTime: type:");
                        bVar12.f5995a.J0(strH16, bC);
                        return;
                    }
                case 1038:
                    String strH17 = C0914u.h(intent, "param_address");
                    X6.b bVar13 = aVar2.f5993e;
                    bVar13.getClass();
                    if (TextUtils.isEmpty(strH17)) {
                        C1725a.a("SetManager", "getFreeDialogRecoveryTime: address is empty...");
                        return;
                    } else {
                        C1725a.a("SetManager", "getFreeDialogRecoveryTime");
                        bVar13.f5995a.R(strH17);
                        return;
                    }
                case 1039:
                    aVar2.f5989a.E(C0914u.h(intent, "param_address"));
                    return;
                case 1040:
                    aVar2.f5989a.Y0(C0914u.c(intent, "param_spine_range_status", 0), C0914u.c(intent, "param_spine_range_step", 0), C0914u.h(intent, "param_address"));
                    return;
                case 1041:
                    aVar2.f5989a.e0(C0914u.c(intent, "param_spine_related_start_time", 0), C0914u.c(intent, "param_spine_related_end_time", 0), C0914u.h(intent, "param_address"));
                    return;
                case 1042:
                    aVar2.f5989a.N0(C0914u.c(intent, "param_headset_spatial_type", 0), C0914u.h(intent, "param_address"));
                    return;
                case 1043:
                    String strH18 = C0914u.h(intent, "param_address");
                    int iC4 = C0914u.c(intent, "param_product_id", -1);
                    aVar2.f5989a.getClass();
                    if (TextUtils.isEmpty(strH18)) {
                        C1725a.l("HeadsetCoreService", "getVersionByAT address is empty!");
                        return;
                    }
                    DeviceInfoManager deviceInfoManager = DeviceInfoManager.a.f19280a;
                    DeviceInfo deviceInfoF = deviceInfoManager.f(strH18);
                    if (deviceInfoF == null && iC4 > 0) {
                        C1725a.l("HeadsetCoreService", "getVersionByAT deviceInfo is null, addDevice!!");
                        C0391z.f1171d.getClass();
                        BluetoothDevice bluetoothDeviceI3 = C0391z.i(strH18);
                        if (bluetoothDeviceI3 == null) {
                            C1725a.g("DeviceInfoManager", "addDeviceAddressWithProductId, The device is null", strH18);
                        } else {
                            deviceInfoManager.a(iC4, bluetoothDeviceI3);
                        }
                        deviceInfoF = deviceInfoManager.f(strH18);
                    }
                    if (deviceInfoF == null) {
                        C1725a.l("HeadsetCoreService", "getVersionByAT deviceInfo is null!");
                        return;
                    }
                    String string = MelodyAlivePreferencesHelper.e().getString(MelodyAlivePreferencesHelper.g(4, strH18), null);
                    String string2 = MelodyAlivePreferencesHelper.e().getString(MelodyAlivePreferencesHelper.g(5, strH18), null);
                    String string3 = MelodyAlivePreferencesHelper.e().getString(MelodyAlivePreferencesHelper.g(6, strH18), null);
                    C1725a.d("HeadsetCoreService", new j(string, string2, string3), strH18);
                    ArrayList arrayList = new ArrayList();
                    if (TextUtils.isEmpty(string)) {
                        i10 = 2;
                    } else {
                        i10 = 2;
                        arrayList.add(new VersionInfo(3, 2, string));
                    }
                    if (!TextUtils.isEmpty(string2)) {
                        arrayList.add(new VersionInfo(1, i10, string2));
                    }
                    if (!TextUtils.isEmpty(string3)) {
                        arrayList.add(new VersionInfo(i10, i10, string3));
                    }
                    if (arrayList.isEmpty()) {
                        C1725a.l("HeadsetCoreService", "getVersionByAT infoList.isEmpty()!");
                        return;
                    }
                    deviceInfoF.setVersionInfo(arrayList);
                    HeadsetCoreService headsetCoreService3 = HeadsetCoreService.d.f19289a;
                    BluetoothReceiveData bluetoothReceiveData = new BluetoothReceiveData(1048600, deviceInfoF);
                    headsetCoreService3.getClass();
                    HeadsetCoreService.m0(bluetoothReceiveData);
                    return;
                case 1044:
                    aVar2.f5989a.J(C0914u.h(intent, "param_address"));
                    return;
                case 1045:
                    aVar2.f5989a.Y(C0914u.c(intent, "param_protocol", 264), C0914u.h(intent, "param_address"));
                    return;
                case 1046:
                    String strH19 = C0914u.h(intent, "param_address");
                    int iC5 = C0914u.c(intent, "param_product_id", -1);
                    aVar2.f5989a.getClass();
                    if (TextUtils.isEmpty(strH19)) {
                        C1725a.l("HeadsetCoreService", "requestHeadsetBatteryInfo address is empty!");
                        return;
                    }
                    DeviceInfoManager deviceInfoManager2 = DeviceInfoManager.a.f19280a;
                    DeviceInfo deviceInfoF2 = deviceInfoManager2.f(strH19);
                    if (deviceInfoF2 == null && iC5 > 0) {
                        C0391z.f1171d.getClass();
                        BluetoothDevice bluetoothDeviceI4 = C0391z.i(strH19);
                        if (bluetoothDeviceI4 == null) {
                            C1725a.g("DeviceInfoManager", "addDeviceAddressWithProductId, The device is null", strH19);
                        } else {
                            deviceInfoManager2.a(iC5, bluetoothDeviceI4);
                        }
                        deviceInfoF2 = deviceInfoManager2.f(strH19);
                    }
                    if (deviceInfoF2 == null) {
                        C1725a.m("HeadsetCoreService", "requestHeadsetBatteryInfo deviceInfo is null", strH19);
                        return;
                    }
                    int i11 = MelodyAlivePreferencesHelper.e().getInt(MelodyAlivePreferencesHelper.g(1, strH19), 0);
                    int i12 = MelodyAlivePreferencesHelper.e().getInt(MelodyAlivePreferencesHelper.g(2, strH19), 0);
                    int i13 = MelodyAlivePreferencesHelper.e().getInt(MelodyAlivePreferencesHelper.g(3, strH19), 0);
                    C1725a.d("HeadsetCoreService", new Z6.c(i11, i12, i13, 0), strH19);
                    if (i12 <= 0 && i13 <= 0) {
                        C1725a.m("HeadsetCoreService", "requestHeadsetBatteryInfo battery is 0", strH19);
                        return;
                    }
                    deviceInfoF2.setBatteryInfo(Arrays.asList(new BatteryInfo(1, i12), new BatteryInfo(2, i13), new BatteryInfo(3, i11)));
                    HeadsetCoreService headsetCoreService4 = HeadsetCoreService.d.f19289a;
                    BluetoothReceiveData bluetoothReceiveData2 = new BluetoothReceiveData(1048589, deviceInfoF2);
                    headsetCoreService4.getClass();
                    HeadsetCoreService.m0(bluetoothReceiveData2);
                    return;
                case 1047:
                    aVar2.f5989a.a0(C0914u.h(intent, "param_address"));
                    return;
                case 1048:
                    ZenModeFileVertifyInformation zenModeFileVertifyInformation = (ZenModeFileVertifyInformation) C0914u.f(intent, "param_zenmode_file_vertify", ZenModeFileVertifyInformation.class);
                    String strH20 = C0914u.h(intent, "param_address");
                    String strH21 = C0914u.h(intent, "param_zenmode_file_name");
                    if (strH20 == null || strH21 == null) {
                        return;
                    }
                    aVar2.f5992d.a(strH20, new File(strH21), zenModeFileVertifyInformation);
                    return;
                case 1049:
                    String strH22 = C0914u.h(intent, "param_address");
                    if (strH22 != null) {
                        ZenModeTransferManager zenModeTransferManager = aVar2.f5992d;
                        zenModeTransferManager.getClass();
                        if (TextUtils.isEmpty(strH22)) {
                            C1725a.l("ZenModeTransferManager", "isZenModeFileOTAing: address is empty");
                            zL0 = false;
                        } else {
                            zL0 = zenModeTransferManager.f19281a.l0(strH22);
                            C1725a.d("ZenModeTransferManager", new A9.i(14, zL0), strH22);
                        }
                        if (zL0) {
                            ZenModeTransferManager zenModeTransferManager2 = aVar2.f5992d;
                            zenModeTransferManager2.getClass();
                            if (TextUtils.isEmpty(strH22)) {
                                C1725a.l("ZenModeTransferManager", "cancle ZenMode transfer address is empty");
                                return;
                            } else {
                                C1725a.b("ZenModeTransferManager", "cancle ZenMode transfer", strH22);
                                zenModeTransferManager2.f19281a.s(strH22);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                case 1050:
                    ZenModeUpgradeListener zenModeUpgradeListener = new ZenModeUpgradeListener();
                    this.f19286b = zenModeUpgradeListener;
                    ZenModeTransferManager zenModeTransferManager3 = aVar2.f5992d;
                    zenModeTransferManager3.getClass();
                    C1725a.a("ZenModeTransferManager", "add ZenMode transfer listener");
                    zenModeTransferManager3.f19281a.q(zenModeUpgradeListener);
                    return;
                case 1051:
                    ZenModeUpgradeListener zenModeUpgradeListener2 = this.f19286b;
                    ZenModeTransferManager zenModeTransferManager4 = aVar2.f5992d;
                    zenModeTransferManager4.getClass();
                    if (zenModeUpgradeListener2 == null) {
                        C1725a.l("ZenModeTransferManager", "removeZenModeOTAListener: listener is null");
                        return;
                    } else {
                        C1725a.a("ZenModeTransferManager", "remove ZenMode transfer listener");
                        zenModeTransferManager4.f19281a.s0(zenModeUpgradeListener2);
                        return;
                    }
                case 1052:
                    ZenModeFileVertifyInformation zenModeFileVertifyInformation2 = (ZenModeFileVertifyInformation) C0914u.f(intent, "param_zenmode_file_vertify", ZenModeFileVertifyInformation.class);
                    String strH23 = C0914u.h(intent, "param_address");
                    X6.b bVar14 = aVar2.f5993e;
                    bVar14.getClass();
                    if (TextUtils.isEmpty(strH23) || zenModeFileVertifyInformation2 == null) {
                        C1725a.f("SetManager", "setZenModeCheckInformation: address or info is empty...");
                        return;
                    } else {
                        bVar14.f5995a.f1(strH23, zenModeFileVertifyInformation2);
                        return;
                    }
                case 1053:
                    String strH24 = C0914u.h(intent, "param_address");
                    X6.b bVar15 = aVar2.f5993e;
                    bVar15.getClass();
                    if (TextUtils.isEmpty(strH24)) {
                        C1725a.f("SetManager", "getEarBudsZenModeInformation: address or info is empty...");
                        return;
                    } else {
                        bVar15.f5995a.K(strH24);
                        return;
                    }
                case 1054:
                    int iC6 = C0914u.c(intent, "scan_flag", 1);
                    aVar2.f5991c.getClass();
                    C1725a.a("ScanManager", "startScan");
                    f fVar = f.e.f5393a;
                    fVar.f5379b.f5366b = iC6;
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null && !fVar.f5381d) {
                        V6.b bVar16 = fVar.f5379b;
                        int i14 = bVar16.f5366b;
                        if ((i14 & 1) != 0) {
                            C1725a.a("Scanner", "startScan startBleScan");
                            C1725a.a("Scanner", "startBleScan");
                            BluetoothAdapter defaultAdapter2 = BluetoothAdapter.getDefaultAdapter();
                            if (defaultAdapter2 == null) {
                                C1725a.f("Scanner", "startBleScan, bluetoothAdapter is null");
                            } else {
                                BluetoothLeScanner bluetoothLeScanner = defaultAdapter2.getBluetoothLeScanner();
                                if (bluetoothLeScanner == null) {
                                    C1725a.f("Scanner", "startBleScan, leScanner is null");
                                } else {
                                    try {
                                        List<ScanFilter> list = bVar16.f5365a;
                                        ScanSettings.Builder builder = new ScanSettings.Builder();
                                        if (Build.VERSION.SDK_INT >= 26) {
                                            builder.setLegacy(false);
                                            builder.setPhy(1);
                                        }
                                        if ((bVar16.f5366b & 8) != 0) {
                                            builder.setScanMode(2);
                                        } else {
                                            builder.setScanMode(1);
                                        }
                                        bluetoothLeScanner.startScan(list, builder.build(), fVar.f5388l);
                                    } catch (Exception e10) {
                                        C1725a.h("Scanner", "startBleScan, error: ", e10);
                                    }
                                }
                            }
                        }
                        if ((i14 & 2) != 0) {
                            C1725a.a("Scanner", "startScan startDiscovery");
                            defaultAdapter.startDiscovery();
                        }
                        fVar.f5381d = true;
                    }
                    break;
                case 1055:
                    int iC7 = C0914u.c(intent, "scan_flag", 1);
                    aVar2.f5991c.getClass();
                    C1725a.a("ScanManager", "stopScan");
                    f fVar2 = f.e.f5393a;
                    fVar2.f5379b.f5366b = iC7;
                    if (!fVar2.f5381d) {
                        C1725a.a("Scanner", "stopScan: !mIsScanning return...");
                    } else {
                        fVar2.f5386j.removeCallbacks(fVar2.f5387k);
                        BluetoothAdapter defaultAdapter3 = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter3 != null) {
                            int i15 = fVar2.f5379b.f5366b;
                            if ((i15 & 1) != 0) {
                                C1725a.a("Scanner", "stopBleScan...");
                                BluetoothAdapter defaultAdapter4 = BluetoothAdapter.getDefaultAdapter();
                                if (defaultAdapter4 == null) {
                                    C1725a.f("Scanner", "stopBleScan, bluetoothAdapter is null");
                                } else {
                                    BluetoothLeScanner bluetoothLeScanner2 = defaultAdapter4.getBluetoothLeScanner();
                                    if (bluetoothLeScanner2 == null) {
                                        C1725a.f("Scanner", "stopBleScan: leScanner is null");
                                    } else {
                                        try {
                                            bluetoothLeScanner2.stopScan(fVar2.f5388l);
                                        } catch (Exception e11) {
                                            C1725a.h("Scanner", "stopBleScan, error: ", e11);
                                        }
                                    }
                                }
                            }
                            if ((i15 & 2) != 0) {
                                defaultAdapter3.cancelDiscovery();
                            }
                            fVar2.f5381d = false;
                        } else {
                            C1725a.a("Scanner", "stopScan: bluetoothAdapter == null return...");
                        }
                    }
                    break;
                case 1056:
                    RelatedDeviceInfo relatedDeviceInfo = (RelatedDeviceInfo) C0914u.f(intent, "param_related_device_info", RelatedDeviceInfo.class);
                    String strH25 = C0914u.h(intent, "param_address");
                    X6.b bVar17 = aVar2.f5993e;
                    bVar17.getClass();
                    if (TextUtils.isEmpty(strH25)) {
                        C1725a.f("SetManager", "setRelatedDeviceInfo: address is empty...");
                        return;
                    } else if (relatedDeviceInfo == null) {
                        C1725a.f("SetManager", "setRelatedDeviceInfo: relatedDeviceInfo is null...");
                        return;
                    } else {
                        bVar17.f5995a.U0(strH25, relatedDeviceInfo);
                        return;
                    }
                case 1057:
                    aVar2.f5989a.l1(C0914u.c(intent, "param_device_type", 255), C0914u.c(intent, "param_debug_level", 0), C0914u.c(intent, "param_debug_module", 255), C0914u.h(intent, "param_address"));
                    return;
                case 1058:
                    aVar2.f5989a.L(C0914u.h(intent, "param_address"));
                    return;
                case 1059:
                    String strH26 = C0914u.h(intent, "param_address");
                    int iC8 = C0914u.c(intent, "param_hearing_uid", -1);
                    if (intent != null) {
                        try {
                            byteArrayExtra = intent.getByteArrayExtra("param_ear_scan_data");
                        } catch (Exception e12) {
                            A.o(5, "IntentUtils", "getByteArrayExtra", e12);
                            byteArrayExtra = null;
                        }
                        break;
                    } else {
                        byteArrayExtra = null;
                    }
                    aVar2.f5989a.M(strH26, iC8, byteArrayExtra);
                    return;
                case 1060:
                    String strH27 = C0914u.h(intent, "param_address");
                    int iC9 = C0914u.c(intent, "param_hearing_action_type", -1);
                    int iC10 = C0914u.c(intent, "param_hearing_uid", -1);
                    if (intent != null) {
                        try {
                            byteArrayExtra2 = intent.getByteArrayExtra("param_ear_scan_data");
                        } catch (Exception e13) {
                            A.o(5, "IntentUtils", "getByteArrayExtra", e13);
                            byteArrayExtra2 = null;
                        }
                        break;
                    } else {
                        byteArrayExtra2 = null;
                    }
                    aVar2.f5989a.v0(strH27, iC9, iC10, byteArrayExtra2);
                    return;
                case 1061:
                    aVar2.f5989a.t0(C0914u.h(intent, "param_address"), C0914u.h(intent, "param_diagnostic_cmd"));
                    return;
                case 1062:
                    aVar2.f5989a.N(C0914u.h(intent, "param_address"));
                    return;
                case 1063:
                    ToneFileVertifyInformation toneFileVertifyInformation = (ToneFileVertifyInformation) C0914u.f(intent, "param_tone_file_vertify", ToneFileVertifyInformation.class);
                    String strH28 = C0914u.h(intent, "param_address");
                    X6.b bVar18 = aVar2.f5993e;
                    bVar18.getClass();
                    if (TextUtils.isEmpty(strH28) || toneFileVertifyInformation == null) {
                        C1725a.f("SetManager", "setToneCheckInformation: address or info is empty...");
                        return;
                    } else {
                        bVar18.f5995a.c1(strH28, toneFileVertifyInformation);
                        return;
                    }
                case 1064:
                    aVar2.f5989a.O0(C0914u.c(intent, "param_high_audio_codec_type", 0), C0914u.c(intent, "param_hires_switch_status", 0), C0914u.c(intent, "param_all_capability", 0), C0914u.h(intent, "param_address"));
                    return;
                case 1065:
                    aVar2.f5989a.X(C0914u.h(intent, "param_address"));
                    return;
                case 1066:
                    aVar2.f5989a.A0(C0914u.c(intent, "param_bass_engine_min_value", -1), C0914u.c(intent, "param_bass_engine_max_value", -1), C0914u.c(intent, "param_bass_engine_current_value", -1), C0914u.h(intent, "param_address"));
                    return;
                case 1067:
                    aVar2.f5989a.C(C0914u.h(intent, "param_address"));
                    return;
                case 1068:
                    aVar2.f5989a.W0(C0914u.c(intent, "param_spatial_audio_status", 0), C0914u.h(intent, "param_address"));
                    return;
                case 1069:
                    String strH29 = C0914u.h(intent, "param_address");
                    if (intent != null) {
                        try {
                            bundleExtra = intent.getBundleExtra("param_host_triangle_info");
                        } catch (Exception e14) {
                            A.o(5, "IntentUtils", "getBundleExtra", e14);
                            bundleExtra = null;
                        }
                    } else {
                        bundleExtra = null;
                    }
                    X6.b bVar19 = aVar2.f5993e;
                    bVar19.getClass();
                    if (TextUtils.isEmpty(strH29)) {
                        C1725a.f("SetManager", "setHostTriangleInfo: address is empty...");
                        return;
                    } else {
                        bVar19.f5995a.P0(strH29, bundleExtra);
                        return;
                    }
                case 1070:
                    aVar2.f5989a.z0(C0914u.c(intent, "param_set_account_action", 0), C0914u.h(intent, "param_address"), C0914u.h(intent, "param_account_key"));
                    return;
                case 1071:
                    aVar2.f5989a.A(C0914u.h(intent, "param_address"));
                    return;
                case 1072:
                    String strH30 = C0914u.h(intent, "param_address");
                    int iC11 = C0914u.c(intent, "screen_off_broadcast_delay_time", -1);
                    if (iC11 != -1) {
                        aVar2.f5989a.V0(iC11, strH30);
                        return;
                    }
                    break;
                case 1073:
                    aVar2.f5989a.d0(C0914u.h(intent, "param_address"));
                    return;
                case 1074:
                    aVar2.f5989a.L0(C0914u.c(intent, "param_game_type", 0), C0914u.c(intent, "param_game_status", 0), C0914u.h(intent, "param_address"));
                    return;
                case 1075:
                    aVar2.f5989a.E0((DebugFeatureInfo) C0914u.f(intent, "param_info", DebugFeatureInfo.class));
                    return;
                case 1076:
                    aVar2.f5989a.T(C0914u.h(intent, "param_address"));
                    return;
                case 1077:
                    aVar2.f5989a.K0(C0914u.c(intent, "param_game_sound_type", 0), C0914u.b(intent, "param_game_sound_type_enable", false), C0914u.h(intent, "param_address"));
                    return;
                case 1078:
                    aVar2.f5989a.w(C0914u.h(intent, "param_address"), C0914u.b(intent, "param_connect_state", false));
                    return;
                case 1079:
                    aVar2.f5989a.B0(C0914u.b(intent, "param_bt_enabled", false));
                    return;
                case 1080:
                    aVar2.f5989a.R0(C0914u.c(intent, "param_type", 0), C0914u.c(intent, "param_value", 0), C0914u.h(intent, "param_address"));
                    return;
                case 1081:
                    aVar2.f5989a.y(C0914u.h(intent, "param_address"));
                    return;
                case 1082:
                    aVar2.f5989a.y0(C0914u.c(intent, "param_ai_summary_type", 0), C0914u.h(intent, "param_address"));
                    return;
                case 1083:
                    aVar2.f5989a.o1(C0914u.c(intent, "param_sync_ai_prompt_sound", 0), C0914u.h(intent, "param_address"));
                    return;
                case 1084:
                    aVar2.f5989a.i0(C0914u.h(intent, "param_address"));
                    return;
                case 1085:
                    aVar2.f5989a.e1(C0914u.c(intent, "param_volume_value_info", 0), C0914u.h(intent, "param_address"));
                    return;
                case 1086:
                    aVar2.f5989a.x0(C0914u.c(intent, "param_translation_app_status", 0), C0914u.c(intent, "param_translation_app_type", -1), C0914u.h(intent, "param_address"));
                    return;
                case 1087:
                    aVar2.f5989a.Z(C0914u.h(intent, "param_address"), C0914u.b(intent, "param_value", false));
                    return;
                case 1088:
                    aVar2.f5989a.p0(C0914u.h(intent, "param_address"), C0914u.c(intent, "param_arg_3", 0), C0914u.h(intent, "param_arg_2"), C0914u.b(intent, "param_arg_1", false));
                    return;
                case 1089:
                    aVar2.f5989a.S0(C0914u.c(intent, "param_type", 0), C0914u.c(intent, "param_value", 0), C0914u.h(intent, "param_address"));
                    return;
                case 1090:
                    aVar2.f5989a.g1(C0914u.h(intent, "param_address"), C0914u.b(intent, "param_value", false));
                    return;
                case 1091:
                    aVar2.f5989a.z(C0914u.h(intent, "param_address"));
                    return;
                case 1092:
                    aVar2.f5989a.g0(C0914u.h(intent, "param_address"));
                    return;
                case 1093:
                    aVar2.f5989a.b1(C0914u.c(intent, "param_tap_level_setting_value", 0), C0914u.h(intent, "param_address"));
                    return;
                case 1094:
                    aVar2.f5989a.d1(C0914u.c(intent, "param_value", 0), C0914u.h(intent, "param_address"));
                    return;
                case 1095:
                    String strH31 = C0914u.h(intent, "param_arg_1");
                    C0391z c0391z = C0391z.f1171d;
                    c0391z.getClass();
                    BluetoothDevice bluetoothDeviceI5 = C0391z.i(strH31);
                    if (c0391z.c(bluetoothDeviceI5) == 11) {
                        try {
                            Boolean bool = (Boolean) C1212a.a(bluetoothDeviceI5, "cancelBondProcess");
                            if (bool != null) {
                                bool.booleanValue();
                            }
                        } catch (Exception e15) {
                            C1725a.f("BluetoothDeviceNative", e15.toString());
                        }
                    }
                    try {
                    } catch (Exception e16) {
                        C1725a.f("BluetoothDeviceNative", e16.toString());
                    }
                    break;
                case 1096:
                    o.b.f25224a.h(C0914u.h(intent, "param_arg_1"));
                    return;
                case 1097:
                    String strH32 = C0914u.h(intent, "param_arg_1");
                    boolean zB4 = C0914u.b(intent, "param_arg_2", false);
                    o.b.f25224a.getClass();
                    if (C0373g.d()) {
                        if (!Q.a()) {
                            C1725a.l("m_bt_le.LeAudioDeviceManager", "changeLeAudioModeBroadcast: no bt permissions!");
                            return;
                        }
                        if (!BluetoothAdapter.checkBluetoothAddress(strH32)) {
                            C1725a.b("m_bt_le.LeAudioDeviceManager", "changeLeAudioModeBroadcast, addr is invalid", strH32);
                            return;
                        }
                        C0391z.f1171d.getClass();
                        BluetoothDevice bluetoothDeviceI6 = C0391z.i(strH32);
                        if (!W6.b.i(bluetoothDeviceI6)) {
                            C1725a.b("m_bt_le.LeAudioDeviceManager", "changeLeAudioModeBroadcast, device is not lea", strH32);
                            return;
                        }
                        if (W6.b.f(bluetoothDeviceI6.getAddress())) {
                            C1725a.m("m_bt_le.LeAudioDeviceManager", "changeLeAudioModeBroadcast isBrLeCoexistMode=true", bluetoothDeviceI6.getAddress());
                            return;
                        }
                        Intent intent2 = new Intent("oplus.bluetooth.device.action.CHANGE_LEA_MODE");
                        intent2.setPackage("com.android.bluetooth");
                        intent2.putExtra("android.bluetooth.device.extra.DEVICE", bluetoothDeviceI6);
                        intent2.putExtra("android.bluetooth.device.csip_mode", zB4 ? "LEA" : "BR");
                        if (A.l()) {
                            C1725a.a("m_bt_le.LeAudioDeviceManager", "changeLeAudioModeBroadcast, addr = " + A.r(strH32) + ", switchOpen = " + zB4);
                        }
                        C0905k.i(C0906l.f19501a, intent2, "oplus.permission.OPLUS_COMPONENT_SAFE");
                        return;
                    }
                    break;
                case 1098:
                    String strH33 = C0914u.h(intent, "param_arg_1");
                    String strH34 = C0914u.h(intent, "param_arg_2");
                    C0391z.f1171d.getClass();
                    try {
                    } catch (Exception e17) {
                        C1725a.f("BluetoothDeviceNative", e17.toString());
                    }
                    break;
                case 1099:
                    aVar2.f5989a.X0(C0914u.c(intent, "param_value", 0), C0914u.h(intent, "param_address"));
                    return;
                case 1100:
                    aVar2.f5989a.M0(C0914u.c(intent, "param_value", 0), C0914u.h(intent, "param_address"));
                    return;
                case 1101:
                    aVar2.f5989a.U(C0914u.h(intent, "param_address"));
                    return;
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        C1725a.a("BluetoothService", "onCreate: ");
        HandlerThread handlerThread = new HandlerThread("BluetoothService", 10);
        this.f19284b = handlerThread;
        handlerThread.start();
        a aVar = new a(this, this.f19284b.getLooper());
        this.f19283a = aVar;
        aVar.sendEmptyMessage(1000);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        if (this.f19284b != null) {
            this.f19283a.removeCallbacksAndMessages(null);
            this.f19284b.quit();
            this.f19284b = null;
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (intent == null) {
            C1725a.l("BluetoothService", "onStartCommand: intent is null");
            return 2;
        }
        Message messageObtainMessage = this.f19283a.obtainMessage();
        messageObtainMessage.what = C0914u.c(intent, "param_id", -1);
        messageObtainMessage.arg1 = i11;
        messageObtainMessage.obj = intent;
        messageObtainMessage.sendToTarget();
        return 2;
    }
}
