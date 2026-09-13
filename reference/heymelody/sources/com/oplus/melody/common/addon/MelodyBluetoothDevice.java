package com.oplus.melody.common.addon;

import Kb.q;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.OplusBluetoothDevice;
import com.oplus.melody.common.util.A;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyBluetoothDevice.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/oplus/melody/common/addon/MelodyBluetoothDevice;", "", "mDevice", "Landroid/bluetooth/BluetoothDevice;", "<init>", "(Landroid/bluetooth/BluetoothDevice;)V", "mDelegate", "Landroid/bluetooth/OplusBluetoothDevice;", "setRemoteDelayReport", "", "keys", "", "", "values", "", "([Ljava/lang/String;[I)Z", "Companion", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyBluetoothDevice {
    private static final String TAG = "MelodyBluetoothDevice";
    private final OplusBluetoothDevice mDelegate;
    private final BluetoothDevice mDevice;

    public MelodyBluetoothDevice(BluetoothDevice mDevice) {
        h.e(mDevice, "mDevice");
        this.mDevice = mDevice;
        this.mDelegate = new OplusBluetoothDevice(mDevice);
    }

    public final boolean setRemoteDelayReport(String[] keys, int[] values) {
        h.e(keys, "keys");
        h.e(values, "values");
        boolean remoteDelayReport = this.mDelegate.setRemoteDelayReport(keys, values);
        if (A.l()) {
            String address = this.mDevice.getAddress();
            ArrayList arrayList = new ArrayList(keys.length);
            int length = keys.length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                int i12 = i11 + 1;
                arrayList.add(keys[i10] + "=" + values[i11]);
                i10++;
                i11 = i12;
            }
            A.f(TAG, "setRemoteDelayReport " + remoteDelayReport + " mac=" + address + " values=" + q.y(arrayList, ",", null, null, null, 62));
        }
        return remoteDelayReport;
    }
}
