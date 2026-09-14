package com.heytap.headset.service;

import U8.e;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.service.a;
import com.oplus.melody.btsdk.protocol.commands.r;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.Q;
import java.util.WeakHashMap;
import kotlin.jvm.internal.h;
import m4.f;

/* JADX INFO: compiled from: KeepAliveFgServiceManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.heytap.headset.service.a f17602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f17603b = new a();

    /* JADX INFO: compiled from: KeepAliveFgServiceManager.kt */
    public static final class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
            com.heytap.headset.service.a aVar;
            IBinder iBinderAsBinder;
            int i10 = a.AbstractBinderC0208a.f17600e;
            if (iBinder == null) {
                aVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.headset.service.IKeepAliveFgInterface");
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.heytap.headset.service.a)) {
                    a.AbstractBinderC0208a.C0209a c0209a = new a.AbstractBinderC0208a.C0209a();
                    c0209a.f17601e = iBinder;
                    aVar = c0209a;
                } else {
                    aVar = (com.heytap.headset.service.a) iInterfaceQueryLocalInterface;
                }
            }
            b.f17602a = aVar;
            A.c("KeepAliveFgServiceManager", new r(3));
            com.heytap.headset.service.a aVar2 = b.f17602a;
            if (aVar2 != null) {
                aVar2.E();
            }
            com.heytap.headset.service.a aVar3 = b.f17602a;
            if (aVar3 == null || (iBinderAsBinder = aVar3.asBinder()) == null) {
                return;
            }
            iBinderAsBinder.linkToDeath(new Wa.a(1), 0);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            A.b("KeepAliveFgServiceManager", "onServiceDisconnected");
            b.f17602a = null;
        }
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, (Class<?>) KeepAliveFgService.class);
        WeakHashMap<Activity, f> weakHashMap = f.f26302s;
        boolean zB = f.a.b(context);
        boolean zB2 = Q.b();
        A.c("KeepAliveFgServiceManager", new e(1, zB, zB2));
        if (zB && zB2 && f17602a == null) {
            try {
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                if (heyMelodyApplication != null) {
                    heyMelodyApplication.bindService(intent, f17603b, 1);
                } else {
                    h.i("context");
                    throw null;
                }
            } catch (Exception e10) {
                A.i("KeepAliveFgServiceManager", "startForegroundService", e10);
            }
        }
    }
}
