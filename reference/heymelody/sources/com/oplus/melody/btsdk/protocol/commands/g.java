package com.oplus.melody.btsdk.protocol.commands;

import D7.C0371e;
import D7.C0372f;
import D7.Q;
import android.os.Handler;
import b7.d;
import com.oplus.melody.app.discovery.J1;
import com.oplus.melody.btsdk.api.data.DeviceInfo;
import com.oplus.melody.btsdk.api.manager.DeviceInfoManager;
import com.oplus.melody.btsdk.multidevice.HeadsetCoreService;
import com.oplus.melody.common.util.A;
import f7.C1046a;
import f7.C1047b;
import g0.C1065d;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import z7.C1725a;

/* JADX INFO: compiled from: NotificationCommandManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f19303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HeadsetCoreService f19304b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f19308f = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1047b f19305c = C1047b.a.f23117a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b7.d f19306d = d.a.f13069a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, Set<Integer>> f19307e = new ConcurrentHashMap<>();

    public g(HeadsetCoreService headsetCoreService, Handler handler) {
        this.f19304b = headsetCoreService;
        this.f19303a = handler;
    }

    public final void a(String str) {
        this.f19304b.u0(str, this.f19305c.a(str, 512, C1047b.f23115b));
        this.f19308f = System.currentTimeMillis();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:206|(5:208|278|209|210|(2:282|212)(5:269|218|219|220|(2:283|222)(2:223|(2:279|225)(7:226|227|267|228|(3:280|230|202)(4:233|234|274|235)|(1:247)(1:248)|249))))|281|240|264|241|242|(0)(0)|249) */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x057f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0580, code lost:
    
        r11 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x05d4  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012b  */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.oplus.melody.btsdk.protocol.commands.g] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    @android.annotation.SuppressLint({"SwitchIntDef"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.lang.String r20, int r21, byte[] r22, f7.C1046a r23) {
        /*
            Method dump skipped, instruction units count: 1584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.btsdk.protocol.commands.g.b(java.lang.String, int, byte[], f7.a):void");
    }

    public final void c(String str, C1046a c1046a) {
        byte b4 = 0;
        if (str == null) {
            return;
        }
        A.a aVar = C1725a.f29476a;
        if (A.l()) {
            C1725a.a("NotificationCommandManager", "onReceivePacket key=0x" + Integer.toHexString(c1046a.a()));
        }
        int i10 = c1046a.f23110a;
        byte[] bArr = c1046a.f23113d;
        if (i10 == 516) {
            if (bArr.length == 0) {
                C1725a.f("NotificationCommandManager", "The length of data is 0 when receive notification event");
                return;
            } else {
                b(str, 0, bArr, c1046a);
                return;
            }
        }
        if (i10 == 33285) {
            C1725a.m("NotificationCommandManager", "onReceivePacket.CMD_REGISTER_NOTIFICATION_MULTI_RSP ok, init cost time: " + (System.currentTimeMillis() - this.f19308f), str);
            this.f19308f = System.currentTimeMillis();
            DeviceInfo deviceInfoF = DeviceInfoManager.a.f19280a.f(str);
            if (deviceInfoF == null || !W6.b.j(str)) {
                return;
            }
            deviceInfoF.setInitCmdCompleted(true);
            this.f19303a.obtainMessage(76, str).sendToTarget();
            return;
        }
        switch (i10) {
            case 33280:
                C1725a.m("NotificationCommandManager", "onReceivePacket.CMD_GET_NOTIFICATION_CAPABILITY_RSP", str);
                int iJ = c.j(bArr);
                ConcurrentHashMap<String, Set<Integer>> concurrentHashMap = this.f19307e;
                if (iJ != 0) {
                    A6.f.g(iJ, "handleReceiveNotificationCapabilities error. status = ", "NotificationCommandManager");
                } else if (bArr.length <= 1) {
                    C1725a.f("NotificationCommandManager", "handleReceiveNotificationCapabilities error, the length of data is less than 1");
                } else {
                    int i11 = bArr[1] & 255;
                    if (bArr.length < 2 + i11) {
                        C1725a.f("NotificationCommandManager", "handleReceiveNotificationCapabilities error, the length of data is less than ");
                    } else {
                        androidx.collection.b bVar = new androidx.collection.b(i11);
                        for (int i12 = 0; i12 < i11; i12++) {
                            bVar.add(Integer.valueOf(bArr[i12 + 2]));
                        }
                        concurrentHashMap.put(str, bVar);
                        A.a aVar2 = C1725a.f29476a;
                        if (A.l()) {
                            C1725a.a("NotificationCommandManager", "handleReceiveNotificationCapabilities: capability=" + c.a(bVar) + ", mac=" + A.r(str));
                        }
                    }
                }
                Set<Integer> set = concurrentHashMap.get(str);
                if (set == null) {
                    C1725a.d("NotificationCommandManager", new C0371e(10), str);
                } else {
                    Integer.toHexString(i10);
                    set.toString();
                    b7.d dVar = this.f19306d;
                    boolean zC = dVar.c(517, str);
                    HeadsetCoreService headsetCoreService = this.f19304b;
                    C1047b c1047b = this.f19305c;
                    if (!zC) {
                        Iterator<Integer> it = set.iterator();
                        while (it.hasNext()) {
                            headsetCoreService.u0(str, c1047b.a(str, 513, new byte[]{(byte) it.next().intValue()}));
                        }
                    } else if (!dVar.c(517, str)) {
                        C1725a.d("NotificationCommandManager", new Q(13), str);
                    } else if (set.isEmpty()) {
                        C1725a.g("NotificationCommandManager", "registerMultiNotification support event set is null, cmd: 0x" + Integer.toHexString(517), str);
                    } else {
                        int size = set.size();
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1 + size);
                        byteBufferAllocate.put((byte) size);
                        for (Integer num : set) {
                            if (num != null) {
                                byteBufferAllocate.put((byte) num.intValue());
                            }
                        }
                        Integer.toHexString(517);
                        E8.a.e(byteBufferAllocate.array());
                        headsetCoreService.u0(str, c1047b.a(str, 517, byteBufferAllocate.array()));
                    }
                    if (dVar.c(265, str)) {
                        headsetCoreService.u0(str, c1047b.a(str, 265, C1047b.f23115b));
                    } else {
                        C1725a.d("NotificationCommandManager", new C0372f(8), str);
                    }
                }
                break;
            case 33281:
                int iJ2 = c.j(bArr);
                if (bArr != null && 1 < bArr.length) {
                    b4 = bArr[1];
                }
                if (iJ2 != 0) {
                    C1725a.g("NotificationCommandManager", C1065d.e("Failed when receive register notification event response status=", " event=", iJ2, b4), str);
                } else if (A.l()) {
                    StringBuilder sbN = androidx.appcompat.widget.a.n(b4, "handleReceiveRegisterEventRsp SUCCESS event=", ", mac=");
                    sbN.append(A.r(str));
                    C1725a.a("NotificationCommandManager", sbN.toString());
                }
                break;
            case 33282:
                int iJ3 = c.j(bArr);
                if (iJ3 != 0) {
                    A6.f.g(iJ3, "Failed when receive registered notification. ", "NotificationCommandManager");
                } else {
                    b(str, 1, bArr, c1046a);
                }
                break;
            case 33283:
                int iJ4 = c.j(bArr);
                if (iJ4 != 0) {
                    A6.f.g(iJ4, "Failed when receive cancel registered notification status = ", "NotificationCommandManager");
                } else if (bArr.length <= 1) {
                    C1725a.f("NotificationCommandManager", "Error, the length of canceling registered notification is not valid");
                } else {
                    C1725a.c("NotificationCommandManager", new t8.r(bArr[1], 1));
                }
                break;
            default:
                C1725a.f("NotificationCommandManager", "Error, Receive unsupported packet " + Integer.toHexString(i10));
                break;
        }
    }

    public final void d(int i10, int i11, byte[] bArr, String str, C1046a c1046a) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr != null ? 2 + bArr.length : 2);
        byteBufferAllocate.put((byte) i10);
        byteBufferAllocate.put((byte) i11);
        if (bArr != null) {
            byteBufferAllocate.put(bArr);
        }
        C1725a.c("NotificationCommandManager", new J1(bArr, i10, i11, 1));
        byte[] bArrArray = byteBufferAllocate.array();
        this.f19305c.getClass();
        this.f19304b.u0(str, C1047b.b(c1046a, bArrArray));
    }
}
