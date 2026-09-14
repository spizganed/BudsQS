package com.oplus.melody.btsdk.api.manager;

import D1.f;
import D7.C0388w;
import D7.C0391z;
import D7.L;
import W6.b;
import Y6.a;
import android.bluetooth.BluetoothDevice;
import android.os.SystemClock;
import android.text.TextUtils;
import com.oplus.melody.btsdk.api.data.DeviceInfo;
import com.oplus.melody.btsdk.manager.support.SupportDeviceConfig;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.Y;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import z7.C1725a;

/* JADX INFO: loaded from: classes.dex */
public class DeviceInfoManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, DeviceInfo> f19279a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DeviceInfoManager f19280a = new DeviceInfoManager(0);
    }

    public /* synthetic */ DeviceInfoManager(int i10) {
        this();
    }

    public static void d(DeviceInfo deviceInfo) {
        if (deviceInfo == null) {
            C1725a.l("DeviceInfoManager", "checkUpdateConnectionState deviceInfo is null!");
            return;
        }
        if (deviceInfo.getDeviceA2dpConnectState() == 2 || deviceInfo.getDeviceHeadsetConnectState() == 2 || deviceInfo.getDeviceLeAudioConnectState() == 2) {
            return;
        }
        BluetoothDevice device = deviceInfo.getDevice();
        if (device == null) {
            C1725a.m("DeviceInfoManager", "checkUpdateConnectionState bluetoothDevice is null", deviceInfo.getDeviceAddress());
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        U6.a aVarB = U6.a.b(C0906l.f19501a);
        final int iA = aVarB.a(1, device);
        deviceInfo.setDeviceHeadsetConnectState(iA);
        final int iA2 = aVarB.a(2, device);
        deviceInfo.setDeviceA2dpConnectState(iA2);
        final int iA3 = aVarB.a(22, device);
        deviceInfo.setDeviceLeAudioConnectState(iA3);
        C1725a.d("DeviceInfoManager", new Supplier() { // from class: U6.e
            @Override // java.util.function.Supplier
            public final Object get() {
                return "checkUpdateConnectionState hfp=" + iA + " a2dp=" + iA2 + " lea=" + iA3 + " time=" + (SystemClock.elapsedRealtime() - jElapsedRealtime);
            }
        }, deviceInfo.getDeviceAddress());
    }

    public static DeviceInfo e(BluetoothDevice bluetoothDevice, String str, int i10, String str2) {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setProductType(101);
        deviceInfo.setDeviceAddress(str);
        deviceInfo.setDeviceName(str2);
        deviceInfo.setDevice(bluetoothDevice);
        deviceInfo.setProductId(i10);
        deviceInfo.setMTU(6000);
        deviceInfo.setDeviceConnectState(3);
        deviceInfo.setDeviceBondState(C0391z.f1171d.c(bluetoothDevice));
        Y6.a aVar = a.C0090a.f6690a;
        aVar.getClass();
        SupportDeviceConfig supportDeviceConfig = (SupportDeviceConfig) Optional.ofNullable(Y.a(aVar.b(), f.M(i10), str2)).map(new C0388w(17)).orElse(null);
        if (supportDeviceConfig == null) {
            StringBuilder sb2 = new StringBuilder("createDeviceInfo FAILURE by ");
            sb2.append(f.M(i10));
            sb2.append('(');
            A.a aVar2 = C1725a.f29476a;
            sb2.append(A.q(str2));
            sb2.append(')');
            C1725a.g("DeviceInfoManager", sb2.toString(), str);
            return deviceInfo;
        }
        if (TextUtils.isEmpty(str2)) {
            deviceInfo.setDeviceName(supportDeviceConfig.getName());
        }
        deviceInfo.setType(supportDeviceConfig.getType());
        deviceInfo.setIsSupportSpp(supportDeviceConfig.isSupportSpp());
        StringBuilder sb3 = new StringBuilder("createDeviceInfo SUCCESS by ");
        sb3.append(f.M(i10));
        sb3.append('(');
        String deviceName = deviceInfo.getDeviceName();
        A.a aVar3 = C1725a.f29476a;
        sb3.append(A.q(deviceName));
        sb3.append(')');
        C1725a.m("DeviceInfoManager", sb3.toString(), str);
        return deviceInfo;
    }

    public final void a(int i10, BluetoothDevice bluetoothDevice) {
        String address = bluetoothDevice.getAddress();
        if (i10 <= 0) {
            C1725a.d("DeviceInfoManager", new L(i10, 15), address);
            return;
        }
        if (b.k(address)) {
            C1725a.g("DeviceInfoManager", "addBluetoothDeviceWithProductId isLeOnlyDevice" + i10, address);
        } else if (this.f19279a.containsKey(address)) {
            C1725a.b("DeviceInfoManager", "addBluetoothDeviceWithProductId: The device is already exists", address);
        } else {
            b(e(bluetoothDevice, address, i10, C0391z.f1171d.f(bluetoothDevice)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(com.oplus.melody.btsdk.api.data.DeviceInfo r9) {
        /*
            r8 = this;
            java.lang.String r0 = "DeviceInfoManager"
            if (r9 == 0) goto L99
            int r1 = r9.getProductId()
            if (r1 > 0) goto Lc
            goto L99
        Lc:
            long r6 = android.os.SystemClock.elapsedRealtime()
            android.bluetooth.BluetoothDevice r1 = r9.getDevice()
            if (r1 != 0) goto L32
            D7.z r1 = D7.C0391z.f1171d
            java.lang.String r2 = r9.getDeviceAddress()
            r1.getClass()
            android.bluetooth.BluetoothDevice r1 = D7.C0391z.i(r2)
            if (r1 != 0) goto L2f
            java.lang.String r1 = "updateConnectionState bluetoothDevice is null"
            java.lang.String r2 = r9.getDeviceAddress()
            z7.C1725a.m(r0, r1, r2)
            goto L73
        L2f:
            r9.setDevice(r1)
        L32:
            int r2 = r9.getDeviceBondState()
            r3 = 12
            if (r2 != r3) goto L66
            com.heytap.headset.HeyMelodyApplication r2 = com.oplus.melody.common.util.C0906l.f19501a
            U6.a r2 = U6.a.b(r2)
            r3 = 1
            int r3 = r2.a(r3, r1)
            r9.setDeviceHeadsetConnectState(r3)
            r4 = 2
            int r4 = r2.a(r4, r1)
            r9.setDeviceA2dpConnectState(r4)
            r5 = 22
            int r5 = r2.a(r5, r1)
            r9.setDeviceLeAudioConnectState(r5)
            U6.f r2 = new U6.f
            r2.<init>()
            java.lang.String r1 = r9.getDeviceAddress()
            z7.C1725a.d(r0, r2, r1)
            goto L73
        L66:
            U6.g r1 = new U6.g
            r2 = 0
            r1.<init>(r9, r2)
            java.lang.String r2 = r9.getDeviceAddress()
            z7.C1725a.d(r0, r1, r2)
        L73:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.oplus.melody.btsdk.api.data.DeviceInfo> r1 = r8.f19279a
            java.lang.String r2 = r9.getDeviceAddress()
            r1.put(r2, r9)
            boolean r1 = D7.C0373g.d()
            if (r1 == 0) goto L8e
            D7.E r0 = D7.o0.c.f1145c
            A6.m r1 = new A6.m
            r2 = 1
            r1.<init>(r9, r2)
            r0.execute(r1)
            return
        L8e:
            P3.d r1 = new P3.d
            r2 = 12
            r1.<init>(r9, r2)
            z7.C1725a.c(r0, r1)
            return
        L99:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "addDeviceInfo IGNORE "
            r1.<init>(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            z7.C1725a.e(r0, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.btsdk.api.manager.DeviceInfoManager.b(com.oplus.melody.btsdk.api.data.DeviceInfo):void");
    }

    public final DeviceInfo c(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            C1725a.f("DeviceInfoManager", "checkGetDeviceInfo device is null!");
            return null;
        }
        DeviceInfo deviceInfoF = f(bluetoothDevice.getAddress());
        if (deviceInfoF != null) {
            return deviceInfoF;
        }
        WhitelistConfigDTO whitelistConfigDTOB = Y.b(bluetoothDevice, a.C0090a.f6690a.b());
        a(whitelistConfigDTOB != null ? f.m(whitelistConfigDTOB.getId()) : 0, bluetoothDevice);
        return f(bluetoothDevice.getAddress());
    }

    public final DeviceInfo f(String str) {
        ConcurrentHashMap<String, DeviceInfo> concurrentHashMap = this.f19279a;
        if (str == null) {
            str = "";
        }
        return concurrentHashMap.get(str);
    }

    public final void g(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            new DeviceInfo();
            return;
        }
        if (b.k(bluetoothDevice.getAddress())) {
            StringBuilder sb2 = new StringBuilder("getOrGenerateDeviceInfo isLeOnlyDevice ");
            String address = bluetoothDevice.getAddress();
            A.a aVar = C1725a.f29476a;
            sb2.append(A.r(address));
            C1725a.f("DeviceInfoManager", sb2.toString());
            new DeviceInfo();
            return;
        }
        String address2 = bluetoothDevice.getAddress();
        if (f(address2) == null) {
            WhitelistConfigDTO whitelistConfigDTOB = Y.b(bluetoothDevice, a.C0090a.f6690a.b());
            DeviceInfo deviceInfoE = e(bluetoothDevice, address2, whitelistConfigDTOB != null ? f.m(whitelistConfigDTOB.getId()) : 0, C0391z.f1171d.f(bluetoothDevice));
            if (deviceInfoE.getProductId() > 0) {
                b(deviceInfoE);
            }
        }
    }

    public final void h(int i10, String str) {
        DeviceInfo deviceInfoF = f(str);
        if (deviceInfoF != null) {
            deviceInfoF.setProductId(i10);
        }
    }

    private DeviceInfoManager() {
        this.f19279a = new ConcurrentHashMap<>();
    }
}
