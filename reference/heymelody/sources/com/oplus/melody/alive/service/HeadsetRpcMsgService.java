package com.oplus.melody.alive.service;

import D7.C0371e;
import D7.C0372f;
import D7.Q;
import android.content.Intent;
import android.os.IBinder;
import com.oplus.melody.common.util.A;
import o4.AbstractServiceC1366a;

/* JADX INFO: loaded from: classes.dex */
public class HeadsetRpcMsgService extends AbstractServiceC1366a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f18807b = 0;

    @Override // com.heytap.health.rpc.a, android.app.Service
    public final IBinder onBind(Intent intent) {
        A.c("HeadsetRpcMsgService", new C0371e(1));
        return this.f17604a;
    }

    @Override // android.app.Service
    public final void onCreate() {
        A.c("HeadsetRpcMsgService", new Q(3));
        super.onCreate();
    }

    @Override // com.heytap.health.rpc.a, android.app.Service
    public final int onStartCommand(Intent intent, int i10, int i11) {
        A.c("HeadsetRpcMsgService", new C0372f(2));
        super.onStartCommand(intent, i10, i11);
        return 2;
    }
}
