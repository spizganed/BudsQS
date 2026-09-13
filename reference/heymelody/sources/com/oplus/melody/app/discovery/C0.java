package com.oplus.melody.app.discovery;

import android.bluetooth.BluetoothDevice;
import com.oplus.melody.common.util.A;
import java.util.function.Supplier;
import z7.C1725a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18825a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f18827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f18828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f18829e;

    public /* synthetic */ C0(int i10, int i11, int i12, BluetoothDevice bluetoothDevice) {
        this.f18826b = i10;
        this.f18827c = i11;
        this.f18828d = i12;
        this.f18829e = bluetoothDevice;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i10 = this.f18828d;
        int i11 = this.f18827c;
        int i12 = this.f18826b;
        Object obj = this.f18829e;
        switch (this.f18825a) {
            case 0:
                StringBuilder sb2 = new StringBuilder("onSharingStarted status:");
                sb2.append(i12);
                sb2.append(" errCode:");
                sb2.append(i11);
                sb2.append(" sharingType:");
                sb2.append(i10);
                sb2.append(" secondary:");
                BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
                sb2.append(com.oplus.melody.common.util.A.q(bluetoothDevice != null ? bluetoothDevice.getAddress() : "null"));
                return sb2.toString();
            default:
                StringBuilder sb3 = new StringBuilder("m_bt_le.handleBondStateChanged, addr: ");
                A.a aVar = C1725a.f29476a;
                sb3.append(com.oplus.melody.common.util.A.r((String) obj));
                sb3.append(", preBondState: ");
                sb3.append(i12);
                sb3.append(", bondState: ");
                sb3.append(i11);
                sb3.append(", bondReason: ");
                sb3.append(i10);
                return sb3.toString();
        }
    }

    public /* synthetic */ C0(int i10, int i11, int i12, String str) {
        this.f18829e = str;
        this.f18826b = i10;
        this.f18827c = i11;
        this.f18828d = i12;
    }
}
