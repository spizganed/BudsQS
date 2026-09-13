package com.oplus.melody.app.discovery;

import D7.C0391z;
import android.bluetooth.BluetoothDevice;
import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.n0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0871n0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f19147c;

    public /* synthetic */ RunnableC0871n0(int i10, Object obj, Object obj2) {
        this.f19145a = i10;
        this.f19146b = obj;
        this.f19147c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zA;
        switch (this.f19145a) {
            case 0:
                DiscoveryDialogViewModel discoveryDialogViewModel = (DiscoveryDialogViewModel) this.f19146b;
                discoveryDialogViewModel.getClass();
                C0391z.f1171d.getClass();
                String str = (String) this.f19147c;
                BluetoothDevice bluetoothDeviceI = C0391z.i(str);
                int i10 = 2;
                if (bluetoothDeviceI != null) {
                    com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0839c(str, 4));
                    Object value = D7.m0.f1129a.getValue();
                    if (value != null) {
                        D7.j0 j0VarF = D7.j0.f(value);
                        D7.i0[] i0VarArrA = D7.i0.a(new Class[]{BluetoothDevice.class, Integer.TYPE}, new Object[]{bluetoothDeviceI, 2});
                        Object objD = j0VarF.d("startSharing", (D7.i0[]) Arrays.copyOf(i0VarArrA, i0VarArrA.length));
                        com.oplus.melody.common.util.A.c("ShareAudioHelper", new A9.d(objD, 5));
                        zA = kotlin.jvm.internal.h.a(objD, Boolean.TRUE);
                    } else {
                        zA = false;
                    }
                    if (!zA) {
                        discoveryDialogViewModel.o(str, new C0884u0(i10, str));
                    }
                } else {
                    com.oplus.melody.common.util.A.h("DiscoveryDialogViewModel", "performShareAudio bluetoothDevice null");
                    discoveryDialogViewModel.o(str, new C0884u0(i10, str));
                }
                break;
            case 1:
                ((C0850f1) this.f19146b).f19072G.onClick((View) this.f19147c);
                break;
            default:
                ((View.OnClickListener) this.f19146b).onClick((View) this.f19147c);
                break;
        }
    }
}
