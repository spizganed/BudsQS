package com.oplus.melody.btsdk.protocol.commands;

import Q7.b;
import com.oplus.melody.common.addon.MelodyBluetoothAdapter;
import com.oplus.melody.common.util.J;
import com.oplus.melody.ui.component.tutorialguide.AuditionPreviewView;
import e4.C1008a;
import java.util.List;
import java.util.function.Supplier;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19333a;

    public /* synthetic */ r(int i10) {
        this.f19333a = i10;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19333a) {
            case 0:
                return A6.g.d(1058, new StringBuilder("setHeadsetSpatialType UNSUPPORTED cmd=0x"));
            case 1:
                return MelodyBluetoothAdapter.registerOplusBluetoothRssiDetectCallback$lambda$1$0();
            case 2:
                List<C1008a> listD = e4.e.f22901p.d();
                return "deleteDevice current count = " + (listD != null ? Integer.valueOf(listD.size()) : null);
            case 3:
                return "onServiceConnected mService = " + com.heytap.headset.service.b.f17602a;
            case 4:
                return "requestPermissions mConnectPreShouldShowRationale = " + m4.f.f26307x + ", mConnectPostShouldShowRationale = " + m4.f.f26308y;
            case 5:
                return "handlePermissionResult mLocationPreShouldShowRationale：" + m4.f.f26303t + ", mLocationPostShouldShowRationale: " + m4.f.f26304u;
            case 6:
                return "startConnectGattTimeout, timeoutTime: 30000";
            case 7:
                return "m_spp_le.startSocketConnect, mSocketConState is not success";
            case 8:
                return "m_spp_le.prepareSocketConnect(), state connected, ignore";
            case 9:
                return "m_spp_le.startSocketConnect, mSocket == null";
            case 10:
                return "m_spp_le.closeSocket, socketClose success";
            case 11:
                int i10 = AuditionPreviewView.f21644B;
                return A6.b.d(J.a.f19444a.f19443b, "onStop, MediaPlayer stop, playState = ");
            case 12:
                return AbstractC1508a.f().g();
            default:
                int i11 = Q7.b.f4152c;
                Q7.b bVarA = b.a.a();
                boolean z2 = false;
                if (bVarA != null && bVarA.c()) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
        }
    }
}
