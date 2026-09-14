package com.oplus.melody.btsdk.protocol.upgrade;

import X3.l;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import androidx.collection.b;
import androidx.media3.session.D0;
import com.google.android.play.core.appupdate.f;
import com.oplus.melody.btsdk.multidevice.HeadsetCoreService;
import com.oplus.melody.btsdk.ota.IUpgradeListener;
import h7.C1090a;
import h7.C1093d;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import z7.C1725a;

/* JADX INFO: loaded from: classes.dex */
public final class UpgradeManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f19359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HeadsetCoreService f19360g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HandlerThread f19361i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile b f19362j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f19354a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f19355b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f19356c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.collection.b f19357d = new androidx.collection.b(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.collection.b f19358e = new androidx.collection.b(0);
    public final IUpgradeListener h = new Listener(this);

    public static final class Listener implements IUpgradeListener {
        private final WeakReference<UpgradeManager> mUpgradeManagerRef;

        public Listener(UpgradeManager upgradeManager) {
            this.mUpgradeManagerRef = new WeakReference<>(upgradeManager);
        }

        @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
        public final void S(int i10, String str) {
            UpgradeManager upgradeManager = this.mUpgradeManagerRef.get();
            if (upgradeManager == null) {
                C1725a.f("UpgradeManager", "Instance is null when upgrade finished.");
            } else {
                upgradeManager.f(0, i10, str);
                upgradeManager.a(i10, str);
            }
        }

        @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
        public final void b(int i10, String str) {
            UpgradeManager upgradeManager = this.mUpgradeManagerRef.get();
            if (upgradeManager == null) {
                C1725a.f("UpgradeManager", "Instance is null when process going");
                return;
            }
            a aVarC = upgradeManager.c(str);
            if (aVarC == null) {
                C1725a.b("UpgradeManager", "Item is null when process going for device", str);
                return;
            }
            aVarC.f19364b.b(i10, str);
            synchronized (upgradeManager.f19357d) {
                try {
                    androidx.collection.b bVar = upgradeManager.f19357d;
                    bVar.getClass();
                    b.a aVar = new b.a();
                    while (aVar.hasNext()) {
                        ((IUpgradeListener) aVar.next()).b(i10, str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
        public final void c(String str) {
            UpgradeManager upgradeManager = this.mUpgradeManagerRef.get();
            if (upgradeManager == null) {
                C1725a.f("UpgradeManager", "Instance is null when upgrade started.");
                return;
            }
            a aVarC = upgradeManager.c(str);
            if (aVarC == null) {
                C1725a.a("UpgradeManager", "Item is null when upgrade started for device ");
                return;
            }
            aVarC.f19364b.c(str);
            synchronized (upgradeManager.f19357d) {
                try {
                    androidx.collection.b bVar = upgradeManager.f19357d;
                    bVar.getClass();
                    b.a aVar = new b.a();
                    while (aVar.hasNext()) {
                        ((IUpgradeListener) aVar.next()).c(str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C1090a f19363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IUpgradeListener f19364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Set<Integer> f19365c = Collections.EMPTY_SET;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19366d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f19367e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f19368f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public H1.b f19369g;
        public f h;
    }

    public static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<UpgradeManager> f19370a;

        public b(Looper looper, UpgradeManager upgradeManager) {
            super(looper);
            this.f19370a = new WeakReference<>(upgradeManager);
        }

        /* JADX WARN: Removed duplicated region for block: B:182:0x040d  */
        /* JADX WARN: Removed duplicated region for block: B:186:0x041e  */
        /* JADX WARN: Removed duplicated region for block: B:187:0x0421  */
        /* JADX WARN: Removed duplicated region for block: B:210:0x04af  */
        /* JADX WARN: Removed duplicated region for block: B:212:0x04b8  */
        /* JADX WARN: Removed duplicated region for block: B:237:0x0541  */
        /* JADX WARN: Removed duplicated region for block: B:275:0x062d  */
        /* JADX WARN: Removed duplicated region for block: B:276:0x0631  */
        /* JADX WARN: Removed duplicated region for block: B:335:0x0410 A[SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void handleMessage(android.os.Message r35) {
            /*
                Method dump skipped, instruction units count: 1854
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.btsdk.protocol.upgrade.UpgradeManager.b.handleMessage(android.os.Message):void");
        }
    }

    public UpgradeManager(Context context, HeadsetCoreService headsetCoreService) {
        this.f19359f = context;
        this.f19360g = headsetCoreService;
    }

    public final void a(int i10, String str) {
        synchronized (this.f19357d) {
            try {
                androidx.collection.b bVar = this.f19357d;
                bVar.getClass();
                b.a aVar = new b.a();
                while (aVar.hasNext()) {
                    ((IUpgradeListener) aVar.next()).S(i10, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(String str) {
        if (str == null) {
            C1725a.f("UpgradeManager", "Address is not valid when cancel upgrade.");
        } else {
            f(7, -1, str);
        }
    }

    public final a c(String str) {
        return (a) this.f19355b.get(str);
    }

    public final b d() {
        if (this.f19362j == null) {
            synchronized (this.f19354a) {
                try {
                    if (this.f19362j == null) {
                        HandlerThread handlerThread = new HandlerThread("UpgradeManager", 10);
                        this.f19361i = handlerThread;
                        handlerThread.start();
                        this.f19362j = new b(this.f19361i.getLooper(), this);
                    }
                } finally {
                }
            }
        }
        return this.f19362j;
    }

    public final void e(String str, List<a7.c> list) {
        androidx.collection.b bVar = this.f19358e;
        if (list != null && !list.isEmpty()) {
            bVar.remove(str);
            f(6, -1, Pair.create(str, list));
        } else {
            C1725a.g("UpgradeManager", "File information list is empty.", str);
            f(0, 258, str);
            bVar.add(str);
            a(258, str);
        }
    }

    public final void f(int i10, int i11, Object obj) {
        b bVarD = d();
        if (bVarD != null) {
            bVarD.obtainMessage(i10, i11, -1, obj).sendToTarget();
        } else {
            A6.f.g(i10, "sendMessage handler is null, what=", "UpgradeManager");
        }
    }

    public final void g(String str, a aVar) {
        StringBuilder sbI = D0.i("startUpgradeLocked ", str, " upgradeType=0x");
        sbI.append(Integer.toHexString(aVar.f19366d));
        sbI.append(" deviceType=0x");
        sbI.append(Integer.toHexString(aVar.f19367e));
        sbI.append(" file=");
        sbI.append(aVar.f19368f);
        C1725a.e("UpgradeManager", sbI.toString());
        C1090a c1090a = aVar.f19363a;
        if (c1090a != null) {
            int i10 = aVar.f19366d;
            synchronized (c1090a.f23697b) {
                try {
                    c1090a.f23703i = i10;
                    C1093d c1093d = c1090a.f23698c;
                    if (c1093d != null) {
                        c1093d.m(i10);
                    }
                } finally {
                }
            }
        }
        int i11 = aVar.f19367e;
        ConcurrentHashMap concurrentHashMap = this.f19355b;
        if (i11 != 4) {
            concurrentHashMap.put(str, aVar);
            b bVarD = d();
            if (bVarD != null) {
                bVarD.obtainMessage(1, aVar.f19363a).sendToTarget();
                return;
            } else {
                C1725a.g("UpgradeManager", "startUpgradeLocked handler is null", str);
                return;
            }
        }
        File file = new File(aVar.f19368f);
        if (!file.exists()) {
            C1725a.d("UpgradeManager", new l(aVar, 25), str);
            return;
        }
        concurrentHashMap.put(str, aVar);
        int i12 = aVar.f19367e;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new a7.c(file, i12));
        e(str, arrayList);
    }
}
