package com.oplus.melody.btsdk.protocol.commands;

import android.os.Build;
import android.os.ParcelUuid;
import com.oplus.melody.common.addon.MelodyBluetoothAdapter;
import com.oplus.melody.common.util.J;
import com.oplus.melody.ui.component.tutorialguide.AuditionPreviewView;
import i7.C1147b;
import java.util.function.Supplier;
import s8.AbstractC1508a;
import x3.C1656o;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19330a;

    public /* synthetic */ p(int i10) {
        this.f19330a = i10;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19330a) {
            case 0:
                return A6.g.d(1029, new StringBuilder("switchCompactnessDetectionStatus UNSUPPORTED cmd=0x"));
            case 1:
                return MelodyBluetoothAdapter.unregisterOplusBluetoothRssiDetectCallback$lambda$1$0();
            case 2:
                return "getLocalCompatibleType: is not support brand:" + Build.BRAND;
            case 3:
                return "onChange. isMelodyBtPermission = " + e4.e.f22909x;
            case 4:
                return C1656o.a("startCollectMultiSppCmd UNSUPPORTED cmd=0x", Integer.toHexString(303));
            case 5:
                int i10 = C1147b.f24095a;
                return "m_bt_le.m_bt_bat.handleConnectionStateChanged.getBatteryInfo ";
            case 6:
                ParcelUuid[] parcelUuidArr = k7.d.f25144e;
                return "getConnectionStatus: A2DPProfile mService == null: return BluetoothProfile.STATE_DISCONNECTED";
            case 7:
                return "handlePermissionResult mScanPreShouldShowRationale：" + m4.f.f26305v + ", mScanPostShouldShowRationale: " + m4.f.f26306w;
            case 8:
                return "handlePermissionResult mNotificationPreShouldShowRationale：" + m4.f.f26309z + ", mNotificationPostShouldShowRationale: " + m4.f.f26301A;
            case 9:
                return "requestPermissions mScanPreShouldShowRationale = " + m4.f.f26305v + ", mScanPostShouldShowRationale = " + m4.f.f26306w;
            case 10:
                return "sendRetryMsg isNeedDelay false";
            case 11:
                return "stopConnectGattTimeout, timeoutTime = 30000";
            case 12:
                return "m_spp_le.prepareSocketConnect(), device is not bonded, abort to connect";
            case 13:
                return "m_spp_le.startSocketConnect, mSocket.connect success!";
            case 14:
                int i11 = AuditionPreviewView.f21644B;
                return A6.b.d(J.a.f19444a.f19443b, "playPreviewAudio, MediaPlayer start, playState = ");
            case 15:
                return Boolean.valueOf(t8.q.n());
            case 16:
                return AbstractC1508a.f().g();
            default:
                return "setLeAudioHintDialogShowed: true";
        }
    }
}
