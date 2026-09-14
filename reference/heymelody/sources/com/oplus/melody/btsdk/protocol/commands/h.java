package com.oplus.melody.btsdk.protocol.commands;

import com.heytap.headset.service.FirmwareUpgradeDeamonService;
import com.heytap.headset.service.KeepAliveFgService;
import com.oplus.melody.ui.component.finddevice.preference.FindDevicePreference;
import java.util.function.Supplier;
import la.L;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19310b;

    public /* synthetic */ h(int i10, int i11) {
        this.f19309a = i11;
        this.f19310b = i10;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i10 = this.f19310b;
        switch (this.f19309a) {
            case 0:
                return A6.g.d(i10, new StringBuilder("getKeyFunction UNSUPPORTED cmd=0x"));
            case 1:
                return "handleRecvCalibratedState state = " + i10;
            case 2:
                return "handleRecvHeadSetSpatialType type = " + i10;
            case 3:
                return "handleReceiveVolumeValueInfo type = " + i10;
            case 4:
                return "onReceiveOneshotEncodeState ,encodeState =" + i10;
            case 5:
                return "sendSystemCameraStatus  complete, status = " + i10;
            case 6:
                return "Receive CMD_SET_EAR_TONE_INFO_RSP response status = " + i10;
            case 7:
                return "Receive set free dialog time status = " + i10;
            case 8:
                return "Receive switch Command response status = " + i10;
            case 9:
                return "put: error !! startState is illegal " + i10;
            case 10:
                return "resolutionId:" + i10;
            case 11:
                return "getLocalCompatibleType: opoPods exist version=" + i10;
            case 12:
                return "filterBluetoothData: receive adapter state:" + i10;
            case 13:
                return "onConnectionStateChanged, state: " + i10;
            case 14:
                return "deleteDevice: bondState = " + i10;
            case 15:
                return "Can't find the item when finish status = " + i10;
            case 16:
                return "setBassEngineValue " + i10;
            case 17:
                FindDevicePreference.a aVar = FindDevicePreference.f21529u;
                return "setViewState newState = " + FindDevicePreference.f21529u.get(i10);
            case 18:
                FindDevicePreference.a aVar2 = FindDevicePreference.f21529u;
                return "onViewStateChange viewState = " + FindDevicePreference.f21529u.get(i10);
            case 19:
                return g0.e.b(new StringBuilder("updateConnectedDevice "), i10, " disconnected");
            case 20:
                int i11 = FirmwareUpgradeDeamonService.f17584s;
                return "onStartCommand startId = " + i10;
            case 21:
                int i12 = KeepAliveFgService.f17591s;
                return "handleDeviceItemListChangeVV notificationManager.cancel unUsedId = " + i10;
            case 22:
                int i13 = KeepAliveFgService.f17591s;
                return "onStartCommand startId:" + i10;
            case 23:
                int i14 = KeepAliveFgService.f17591s;
                return "handleDeviceItemListChange notificationManager.cancel unUsedId = " + i10;
            case 24:
                return "onServiceConnected " + i10;
            case 25:
                return "onBluetoothStateChanged bluetoothState = " + i10;
            case 26:
                return "onServiceDisconnected " + i10;
            case 27:
                return "onServiceDisconnected " + i10;
            case 28:
                float[] fArr = L.f25669Q0;
                return "initVisualizer audioSessionId= " + i10;
            default:
                return g0.e.b(new StringBuilder("closeConnect(), mState = "), i10, ", ignore");
        }
    }
}
