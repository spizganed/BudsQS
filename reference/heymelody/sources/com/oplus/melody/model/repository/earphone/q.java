package com.oplus.melody.model.repository.earphone;

import androidx.media3.exoplayer.C0625v;
import com.oplus.melody.btsdk.api.data.DeviceInfo;
import com.oplus.melody.common.util.A;
import java.util.function.Supplier;
import z7.C1725a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class q implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DeviceInfo f19974b;

    public /* synthetic */ q(DeviceInfo deviceInfo, int i10) {
        this.f19973a = i10;
        this.f19974b = deviceInfo;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        DeviceInfo deviceInfo = this.f19974b;
        switch (this.f19973a) {
            case 0:
                return "EVENT_ID_BT_SN_INFO, boxSn: " + com.oplus.melody.common.util.A.v(deviceInfo.getBoxSn()) + ", addr: " + com.oplus.melody.common.util.A.r(deviceInfo.getDeviceAddress()) + ", name: " + com.oplus.melody.common.util.A.q(deviceInfo.getDeviceName());
            default:
                StringBuilder sb2 = new StringBuilder("enableDeviceConnection ");
                String deviceAddress = deviceInfo.getDeviceAddress();
                A.a aVar = C1725a.f29476a;
                return C0625v.i(deviceAddress, sb2);
        }
    }
}
