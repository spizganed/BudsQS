package com.oplus.melody.alive.service;

import D7.E;
import D7.RunnableC0369c;
import D7.RunnableC0380n;
import D7.o0;
import Jb.b;
import O7.m;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.os.SystemClock;
import android.text.TextUtils;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.S;
import com.oplus.melody.common.util.ServiceUtils;
import kotlin.Metadata;
import kotlin.a;
import t8.q;
import u6.C1551a;

/* JADX INFO: compiled from: MelodyAliveService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\"\u0010\u0015\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/oplus/melody/alive/service/MelodyAliveService;", "Landroid/app/Service;", "<init>", "()V", "mMessenger", "Landroid/os/Messenger;", "getMMessenger", "()Landroid/os/Messenger;", "mMessenger$delegate", "Lkotlin/Lazy;", "mBusinessCenter", "Lcom/oplus/melody/alive/component/BusinessCenter;", "onCreate", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onUnbind", "", "onDestroy", "onStartCommand", "", "flags", "startId", "Companion", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyAliveService extends Service {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f18808c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f18809a = a.a(new G6.a(0));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1551a f18810b = new C1551a();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        A.f("MelodyAliveService", "m_event_start.onBind " + intent);
        return ((Messenger) this.f18809a.getValue()).getBinder();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        J7.b.b(this);
        E6.b.f1355a.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        E e10 = o0.c.f1145c;
        e10.execute(new E6.a("MelodyAliveService", jElapsedRealtime));
        q.s(new RunnableC0380n(this, 3));
        Context applicationContext = getApplicationContext();
        m.d(applicationContext);
        e10.a().post(new RunnableC0369c(3, applicationContext, this));
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        A.b("MelodyAliveService", "onDestroy");
        Context applicationContext = getApplicationContext();
        m.e(applicationContext);
        o0.c.f1145c.a().post(new B6.b(5, this, applicationContext));
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int flags, int startId) {
        if (S.f19467e == null) {
            String strL = S.l("ro.oplus.os_type");
            S.f19467e = Boolean.valueOf(TextUtils.equals(strL, "light_base") || !S.v(C0906l.f19501a, "com.heytap.accessory"));
            A.j("PhoneUtils", "isOplusOsLight " + S.f19467e + " osType=" + strL);
        }
        boolean zBooleanValue = S.f19467e.booleanValue();
        boolean zB = C0914u.b(intent, ServiceUtils.EXTRA_BOOLEAN_RESTART, false);
        A.f("MelodyAliveService", "m_event_start.onStartCommand action=" + (intent != null ? intent.getAction() : null) + " restartExtra=" + zB + " osLight=" + zBooleanValue);
        int iOnStartCommand = super.onStartCommand(intent, flags, startId);
        if (!zB || zBooleanValue) {
            return 2;
        }
        return iOnStartCommand;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        A.f("MelodyAliveService", "onUnbind " + intent);
        return super.onUnbind(intent);
    }
}
