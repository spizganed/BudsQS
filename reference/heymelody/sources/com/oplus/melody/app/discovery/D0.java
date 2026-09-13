package com.oplus.melody.app.discovery;

import android.bluetooth.BluetoothDevice;
import com.oplus.bluetooth.OplusA2dpSharingStateCallback;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: DiscoveryDialogViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public final class D0 extends OplusA2dpSharingStateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiscoveryDialogViewModel f18833a;

    public D0(DiscoveryDialogViewModel discoveryDialogViewModel) {
        this.f18833a = discoveryDialogViewModel;
    }

    @Override // com.oplus.bluetooth.OplusA2dpSharingStateCallback
    public final void onSharingStarted(int i10, int i11, int i12, BluetoothDevice bluetoothDevice, BluetoothDevice bluetoothDevice2) {
        com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0(i10, i11, i12, bluetoothDevice2));
        if (bluetoothDevice2 != null) {
            String address = bluetoothDevice2.getAddress();
            DiscoveryDialogViewModel discoveryDialogViewModel = this.f18833a;
            if (i10 != 0) {
                discoveryDialogViewModel.getClass();
                discoveryDialogViewModel.o(address, new C0884u0(2, address));
                return;
            }
            Map<String, Boolean> mapD = discoveryDialogViewModel.f18887f.d();
            HashMap map = mapD != null ? new HashMap(mapD) : new HashMap();
            if (!map.containsKey(address)) {
                map.put(address, Boolean.FALSE);
            }
            discoveryDialogViewModel.f18887f.i(map);
            discoveryDialogViewModel.o(address, new C0884u0(3, address));
        }
    }

    @Override // com.oplus.bluetooth.OplusA2dpSharingStateCallback
    public final void onSharingStopped(int i10, int i11, int i12, BluetoothDevice bluetoothDevice, BluetoothDevice bluetoothDevice2) {
        com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new W6.c(i10, i11, i12, 1));
    }
}
