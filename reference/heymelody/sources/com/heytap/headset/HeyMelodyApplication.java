package com.heytap.headset;

import A6.d;
import A9.j;
import A9.k;
import C6.e;
import D7.C0373g;
import D7.C0379m;
import D7.P;
import D7.o0;
import J7.b;
import L6.c;
import L7.a;
import S7.a;
import U6.b;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import androidx.collection.b;
import androidx.lifecycle.s;
import androidx.lifecycle.v;
import b8.C0731a;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.upgrade.util.Util;
import com.oplus.melody.btsdk.protocol.commands.p;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import h0.l;
import h4.C1088a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import java.util.function.Function;
import kotlin.jvm.internal.h;
import m4.f;
import org.koin.core.error.KoinApplicationAlreadyStartedException;
import p8.AbstractC1403a;
import t8.q;
import t8.t;
import v8.C1581a;
import y6.C1708a;

/* JADX INFO: loaded from: classes.dex */
public final class HeyMelodyApplication extends Application {
    private static final String TAG = "HeyMelodyApplication";
    private final BroadcastReceiver mBtStateReceiver = new a();
    private final v<Boolean> mMustPermissionObserver = new e(this, 10);

    public class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            A.c(HeyMelodyApplication.TAG, new C8.a(action, 10));
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                int iC = C0914u.c(intent, "android.bluetooth.adapter.extra.STATE", 0);
                Object obj = L7.a.f3010c;
                a.C0032a.a().n(iC);
            }
        }
    }

    private void init(Context context) {
        b.b(this);
        if (E8.a.f1359a == null) {
            synchronized (E8.a.class) {
                try {
                    if (E8.a.f1359a == null) {
                        E8.a.f1359a = new E8.a();
                    }
                } finally {
                }
            }
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        C0905k.e(context, this.mBtStateReceiver, intentFilter);
    }

    private void initBluetooth(final Context context) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        A.b(TAG, "initBluetooth start");
        CompletableFuture<Void> completableFutureRunAsync = CompletableFuture.runAsync(new N3.b(context, 0));
        BiConsumer<? super Void, ? super Throwable> biConsumer = new BiConsumer() { // from class: N3.c
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                HeyMelodyApplication.lambda$initBluetooth$6(context, jElapsedRealtime, (Void) obj, (Throwable) obj2);
            }
        };
        l lVar = o0.c.f1144b;
        completableFutureRunAsync.whenCompleteAsync(biConsumer, (Executor) lVar);
        if (C0373g.f1086l) {
            e4.e.f22900c.getClass();
            s<EarphoneDTO> sVarN = AbstractC0939b.E().n();
            h.d(lVar, "mainThread(...)");
            C0379m.i(sVarN, e4.e.f22899G, lVar);
            o0.c.f1145c.execute(new c(7));
        }
    }

    private void initTrackAdapter(Context context) {
        t.b();
        if (B8.a.f()) {
            k kVar = new k(context, 16);
            Object obj = q.f27949a;
            if (S.u()) {
                return;
            }
            CompletableFuture.supplyAsync(new p(15)).whenCompleteAsync((BiConsumer) new A9.c(kVar, 23), (Executor) o0.c.f1144b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$initBluetooth$5(Context context) {
        Object obj = L7.a.f3010c;
        a.C0032a.a().n(Integer.MIN_VALUE);
        b.a.f5178a.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$initBluetooth$6(Context context, long j5, Void r52, Throwable th) {
        C1708a.a().init(context);
        A.o(5, TAG, "initBluetooth complete timeMillis=" + (SystemClock.elapsedRealtime() - j5), th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$initTrackAdapter$7(Context context) {
        x8.a.f28979a = new C1581a(context);
        U7.b.f5189c.getClass();
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        List<String> list = S.f19463a;
        if ("com.heytap.headset".equals(heyMelodyApplication.getPackageName())) {
            J7.b.a().d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$0(Boolean bool) {
        return "mMustPermissionObserver result: " + bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Boolean bool) {
        A.c(TAG, new N3.a(bool, 0));
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        initBluetooth(this);
        try {
            if (q.l()) {
                com.heytap.headset.service.b.a(this);
            }
        } catch (IllegalStateException e10) {
            A.i(TAG, "mMustPermissionObserver result", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onCreate$2() {
        WeakHashMap<Activity, f> weakHashMap = f.f26302s;
        if (f.a.b(this)) {
            initBluetooth(this);
        } else {
            C1088a.f23692c.getClass();
            C0379m.i(C0379m.b(C1088a.f23693p), this.mMustPermissionObserver, o0.c.f1145c);
        }
        if (C0373g.f1086l) {
            Object obj = S7.a.f4936c;
            a.C0063a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3() {
        if (q.l()) {
            com.heytap.headset.service.b.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$onCreate$4(Throwable th) {
        A.i(TAG, "onCreate startForegroundService", th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$updateCollectData$8() {
        U7.b bVar = U7.b.f5189c;
        String systemLanguage = Util.getSystemLanguage();
        bVar.getClass();
        U7.b.a(10, 1, systemLanguage);
        U7.b.a(11, 1, Build.MODEL);
        if (S.f19469g == null) {
            S.q(C0906l.f19501a);
        }
        U7.b.a(12, 1, S.f19469g);
        U7.b.a(5, 1, Build.VERSION.RELEASE);
        ForkJoinPool.commonPool().execute(new P(6));
    }

    private void updateCollectData() {
        t.b();
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        C0906l.f19501a = this;
        Tc.a aVar = N3.e.f3406a;
        j jVar = new j(this, 7);
        synchronized (Pc.a.f4079a) {
            Nc.b bVar = new Nc.b();
            if (Pc.a.f4080b != null) {
                throw new KoinApplicationAlreadyStartedException("A Koin Application has already been started");
            }
            Pc.a.f4080b = bVar.f3518a;
            jVar.d(bVar);
            bVar.f3518a.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application
    public void onCreate() {
        int i10 = 12;
        int i11 = 1;
        super.onCreate();
        S.a(this);
        C0373g.c(this);
        if (!C0373g.f1086l && androidx.appcompat.app.k.f7432b != 1) {
            androidx.appcompat.app.k.f7432b = 1;
            synchronized (androidx.appcompat.app.k.f7438t) {
                try {
                    androidx.collection.b<WeakReference<androidx.appcompat.app.k>> bVar = androidx.appcompat.app.k.f7437s;
                    bVar.getClass();
                    b.a aVar = new b.a();
                    while (aVar.hasNext()) {
                        androidx.appcompat.app.k kVar = (androidx.appcompat.app.k) ((WeakReference) aVar.next()).get();
                        if (kVar != null) {
                            kVar.b();
                        }
                    }
                } finally {
                }
            }
        }
        Object obj = q.f27949a;
        if (!S.s(C0906l.f19501a)) {
            t.c();
            if (q.o()) {
                J7.b.a().d();
                if (A.l()) {
                    A.b("MelodyPreferences", "resetPrivacyStatementAndBasicFunctionsOnlyValue ver=".concat("v1.1"));
                }
                Object obj2 = AbstractC1403a.f26931c;
                AbstractC1403a.C0301a.a().a().putString("statement_version", "v1.1").putBoolean("statement_accepted", false).putBoolean("use_basic_functions_only_accepted", false).apply();
            }
        } else if (q.k() || q.m()) {
            if (A.l()) {
                A.b("MelodyPreferences", "resetPrivacyStatementAndBasicFunctionsOnlyValue");
            }
            Object obj3 = AbstractC1403a.f26931c;
            AbstractC1403a.C0301a.a().a().putBoolean("has_privacy_statement_accepted_record", q.n() || ((Boolean) q.f(Boolean.FALSE, "has_privacy_statement_accepted_record")).booleanValue()).putBoolean("has_agreement_statement_accepted_record", q.q() || ((Boolean) q.f(Boolean.FALSE, "has_agreement_statement_accepted_record")).booleanValue()).putBoolean("hey_melody_statement_accepted", false).putBoolean("use_basic_functions_only_accepted", false).apply();
        }
        init(this);
        q.s(new I6.c(this, i11));
        updateCollectData();
        initTrackAdapter(this);
        D7.S.a(this);
        C0731a.f13070c.getClass();
        ForkJoinPool.commonPool().execute(new P(7));
        CompletableFuture.runAsync(new E9.t(this, i10)).exceptionally((Function<Throwable, ? extends Void>) new d(i10));
    }
}
