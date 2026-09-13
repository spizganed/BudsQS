package com.oplus.melody.btsdk.protocol.upgrade;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.collection.b;
import com.oplus.melody.btsdk.api.data.ZenModeFileVertifyInformation;
import com.oplus.melody.btsdk.multidevice.HeadsetCoreService;
import com.oplus.melody.btsdk.ota.IUpgradeListener;
import com.oplus.melody.btsdk.protocol.commands.h;
import com.oplus.melody.common.util.O;
import f7.C1046a;
import h7.C1090a;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import z7.C1725a;

/* JADX INFO: loaded from: classes.dex */
public final class ZenModeOTAManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Listener f19371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f19372b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HeadsetCoreService f19373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.collection.b f19374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f19375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f19376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HandlerThread f19377g;
    public a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f19378i;

    public static class Listener implements IUpgradeListener {
        private Context context;
        private final ZenModeOTAManager zenModeOTAManager;

        public Listener(ZenModeOTAManager zenModeOTAManager, Context context) {
            this.zenModeOTAManager = zenModeOTAManager;
            this.context = context;
        }

        @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
        public final void S(int i10, String str) {
            ZenModeFileVertifyInformation zenModeFileVertifyInformation = this.zenModeOTAManager.f19375e.get(str).f19381b;
            this.zenModeOTAManager.a(3, i10, str);
            if (i10 == 0) {
                Context context = this.context;
                Intent intentU = com.google.android.play.core.appupdate.c.u(context, 1052);
                intentU.putExtra("param_address", str);
                intentU.putExtra("param_zenmode_file_vertify", zenModeFileVertifyInformation);
                com.google.android.play.core.appupdate.c.Q(context, intentU);
            }
        }

        @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
        public final void b(int i10, String str) {
            androidx.collection.b bVar;
            ZenModeOTAManager zenModeOTAManager = this.zenModeOTAManager;
            synchronized (zenModeOTAManager.f19372b) {
                bVar = new androidx.collection.b((Collection) zenModeOTAManager.f19374d);
            }
            b.a aVar = new b.a();
            while (aVar.hasNext()) {
                ((IUpgradeListener) aVar.next()).b(i10, str);
            }
        }

        @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
        public final void c(String str) {
            androidx.collection.b bVar;
            ZenModeOTAManager zenModeOTAManager = this.zenModeOTAManager;
            synchronized (zenModeOTAManager.f19372b) {
                bVar = new androidx.collection.b((Collection) zenModeOTAManager.f19374d);
            }
            b.a aVar = new b.a();
            while (aVar.hasNext()) {
                ((IUpgradeListener) aVar.next()).c(str);
            }
        }
    }

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ZenModeOTAManager f19379a;

        public a(Looper looper, ZenModeOTAManager zenModeOTAManager) {
            super(looper);
            this.f19379a = zenModeOTAManager;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            androidx.collection.b bVar;
            ZenModeOTAManager zenModeOTAManager = this.f19379a;
            if (zenModeOTAManager == null) {
                return;
            }
            int i10 = message.what;
            if (i10 == 1) {
                Pair pair = (Pair) message.obj;
                String str = (String) pair.first;
                b bVar2 = zenModeOTAManager.f19375e.get(str);
                if (bVar2 == null) {
                    C1725a.f("ZenModeOTAManager", "Can't find the item when receive check result.");
                    zenModeOTAManager.a(3, 257, str);
                    return;
                } else {
                    if (zenModeOTAManager.f19378i != null) {
                        C1725a.b("ZenModeOTAManager", "zenmode processor is running for device", str);
                        return;
                    }
                    zenModeOTAManager.f19378i = bVar2;
                    if (bVar2.f19380a.f((List) pair.second, zenModeOTAManager.f19371a)) {
                        return;
                    }
                    C1725a.f("ZenModeOTAManager", "Failed when start zenmode file OTA.");
                    zenModeOTAManager.a(3, 257, str);
                    return;
                }
            }
            if (i10 == 2) {
                b bVar3 = zenModeOTAManager.f19375e.get((String) message.obj);
                if (bVar3 == null) {
                    C1725a.b("ZenModeOTAManager", "Can't find the item when cancel", (String) message.obj);
                    return;
                }
                removeMessages(1, bVar3.f19380a);
                bVar3.f19380a.b();
                zenModeOTAManager.f19378i = null;
                return;
            }
            if (i10 != 3) {
                if (i10 != 4) {
                    return;
                }
                Pair pair2 = (Pair) message.obj;
                b bVar4 = zenModeOTAManager.f19375e.get(pair2.first);
                if (bVar4 != null) {
                    C1090a c1090a = bVar4.f19380a;
                    c1090a.a((C1046a) pair2.second);
                    return;
                }
                return;
            }
            String str2 = (String) message.obj;
            int i11 = message.arg1;
            b bVarRemove = zenModeOTAManager.f19375e.remove(str2);
            if (bVarRemove == null) {
                C1725a.d("ZenModeOTAManager", new h(i11, 15), str2);
                return;
            }
            synchronized (zenModeOTAManager.f19376f) {
                try {
                    if (zenModeOTAManager.f19375e.isEmpty() && zenModeOTAManager.f19377g != null) {
                        zenModeOTAManager.h.removeCallbacksAndMessages(null);
                        zenModeOTAManager.h = null;
                        zenModeOTAManager.f19377g.quit();
                        zenModeOTAManager.f19377g = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            zenModeOTAManager.f19378i = null;
            C1725a.d("ZenModeOTAManager", new O(i11, 6), str2);
            synchronized (zenModeOTAManager.f19372b) {
                bVar = new androidx.collection.b((Collection) zenModeOTAManager.f19374d);
            }
            b.a aVar = new b.a();
            while (aVar.hasNext()) {
                ((IUpgradeListener) aVar.next()).S(i11, str2);
            }
            IUpgradeListener iUpgradeListener = bVarRemove.f19382c.get();
            if (iUpgradeListener != null) {
                iUpgradeListener.S(i11, str2);
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C1090a f19380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ZenModeFileVertifyInformation f19381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference<IUpgradeListener> f19382c;

        public b(C1090a c1090a, ZenModeFileVertifyInformation zenModeFileVertifyInformation, HeadsetCoreService headsetCoreService) {
            this.f19380a = c1090a;
            this.f19381b = zenModeFileVertifyInformation;
            this.f19382c = new WeakReference<>(headsetCoreService);
        }
    }

    public ZenModeOTAManager(Context context, HeadsetCoreService headsetCoreService) {
        androidx.collection.b bVar = new androidx.collection.b(0);
        this.f19374d = bVar;
        this.f19376f = new Object();
        this.f19373c = headsetCoreService;
        this.f19375e = new ConcurrentHashMap<>();
        this.f19371a = new Listener(this, context);
        bVar.clear();
    }

    public final void a(int i10, int i11, Object obj) {
        synchronized (this.f19376f) {
            try {
                a aVar = this.h;
                if (aVar != null) {
                    aVar.obtainMessage(i10, i11, -1, obj).sendToTarget();
                    return;
                }
                C1725a.f("ZenModeOTAManager", "Handler is null when send message " + i10);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
