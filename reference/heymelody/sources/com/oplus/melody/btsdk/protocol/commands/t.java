package com.oplus.melody.btsdk.protocol.commands;

import android.os.Looper;
import android.os.Message;
import com.oplus.melody.btsdk.api.data.BatteryInfo;
import com.oplus.melody.btsdk.multidevice.HeadsetCoreService;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import y7.c;
import z7.C1725a;

/* JADX INFO: compiled from: UpgradePropertyProcessor.java */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Looper f19339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap<String, a> f19340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HeadsetCoreService f19341c;

    /* JADX INFO: compiled from: UpgradePropertyProcessor.java */
    public class a extends y7.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f19342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e f19343d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final C0224a f19344e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f19345f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f19346g;

        /* JADX INFO: renamed from: com.oplus.melody.btsdk.protocol.commands.t$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: UpgradePropertyProcessor.java */
        public class C0224a extends y7.b {
            public C0224a() {
            }

            @Override // y7.b
            public final void a() {
                a aVar = a.this;
                t.this.f19341c.D(aVar.f19346g);
                C1725a.b("UpgradeStage", "Enter BatteryState", aVar.f19346g);
            }

            @Override // y7.b
            public final boolean c(Message message) {
                if (message.what != 3) {
                    return false;
                }
                for (BatteryInfo batteryInfo : (List) message.obj) {
                    if (com.google.android.play.core.appupdate.c.C(batteryInfo.mDeviceType) == 1 && batteryInfo.mLevel == 0) {
                        batteryInfo.toString();
                        return true;
                    }
                }
                a aVar = a.this;
                aVar.g(aVar.f19343d);
                return true;
            }
        }

        /* JADX INFO: compiled from: UpgradePropertyProcessor.java */
        public class b extends y7.b {
            public b() {
            }

            @Override // y7.b
            public final void a() {
                C1725a.b("UpgradeStage", "Enter CompleteState", a.this.f19346g);
            }

            @Override // y7.b
            public final boolean c(Message message) {
                if (message.what != 4) {
                    return false;
                }
                a aVar = a.this;
                t.this.f19341c.o0(aVar.f19346g);
                return true;
            }
        }

        /* JADX INFO: compiled from: UpgradePropertyProcessor.java */
        public class c extends y7.b {
            public c() {
            }

            @Override // y7.b
            public final void a() {
                C1725a.b("UpgradeStage", "Enter state DefaultState", a.this.f19346g);
            }

            @Override // y7.b
            public final boolean c(Message message) {
                if (message.what != 0) {
                    C1725a.c("UpgradeStage", new u(0, message));
                    return true;
                }
                a aVar = a.this;
                aVar.g(aVar.f19342c);
                return true;
            }
        }

        /* JADX INFO: compiled from: UpgradePropertyProcessor.java */
        public class d extends y7.b {
            public d() {
            }

            @Override // y7.b
            public final void a() {
                a aVar = a.this;
                t.this.f19341c.J(aVar.f19346g);
                C1725a.b("UpgradeStage", "Enter state RemoteVersionState", aVar.f19346g);
            }

            @Override // y7.b
            public final boolean c(Message message) {
                if (message.what != 1) {
                    return false;
                }
                a aVar = a.this;
                aVar.g(aVar.f19344e);
                return true;
            }
        }

        /* JADX INFO: compiled from: UpgradePropertyProcessor.java */
        public class e extends y7.b {
            public e() {
            }

            @Override // y7.b
            public final void a() {
                a aVar = a.this;
                C1725a.b("UpgradeStage", "Enter upgradeCapabilityState", aVar.f19346g);
                t.this.f19341c.h0(aVar.f19346g);
            }

            @Override // y7.b
            public final boolean c(Message message) {
                if (message.what != 2) {
                    return false;
                }
                a aVar = a.this;
                aVar.d(4);
                aVar.g(aVar.f19345f);
                return true;
            }
        }

        public a(Looper looper, String str) {
            super("PropertyStateMachine", looper);
            y7.b cVar = new c();
            d dVar = new d();
            this.f19342c = dVar;
            e eVar = new e();
            this.f19343d = eVar;
            C0224a c0224a = new C0224a();
            this.f19344e = c0224a;
            b bVar = new b();
            this.f19345f = bVar;
            this.f19346g = str;
            c.HandlerC0346c handlerC0346c = this.f29200b;
            Object obj = c.HandlerC0346c.f29211p;
            handlerC0346c.a(cVar, null);
            a(dVar, cVar);
            a(eVar, cVar);
            a(c0224a, cVar);
            a(bVar, cVar);
            this.f29200b.f29223m = cVar;
            f();
        }
    }

    public final void a(String str, List<a7.d> list) {
        if (str == null) {
            C1725a.f("UpgradeStage", "Address is null when receive upgrade capability info.");
            return;
        }
        if (list == null) {
            C1725a.f("UpgradeStage", "Upgrade information list is null.");
            return;
        }
        a aVar = this.f19340b.get(str);
        if (aVar == null) {
            C1725a.f("UpgradeStage", "Can't find the state machine when receive upgrade capability info.");
            return;
        }
        c.HandlerC0346c handlerC0346c = aVar.f29200b;
        if (handlerC0346c == null) {
            return;
        }
        handlerC0346c.sendMessage(Message.obtain(handlerC0346c, 2, list));
    }

    public final void b(String str) {
        if (str == null) {
            C1725a.f("UpgradeStage", "Address is null when start record upgrade stage.");
            return;
        }
        ConcurrentHashMap<String, a> concurrentHashMap = this.f19340b;
        if (concurrentHashMap.get(str) != null) {
            C1725a.f("UpgradeStage", "The statemachine already exists.");
            return;
        }
        a aVar = new a(this.f19339a, str);
        concurrentHashMap.put(str, aVar);
        aVar.d(0);
    }
}
