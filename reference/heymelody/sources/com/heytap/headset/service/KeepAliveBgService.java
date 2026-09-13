package com.heytap.headset.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.oplus.melody.common.util.A;
import kotlin.Metadata;

/* JADX INFO: compiled from: KeepAliveBgService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, d2 = {"Lcom/heytap/headset/service/KeepAliveBgService;", "Landroid/app/Service;", "<init>", "()V", "onCreate", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "onDestroy", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KeepAliveBgService extends Service {
    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        A.b("KeepAliveBgService", "onCreate");
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        A.b("KeepAliveBgService", "onDestroy");
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int flags, int startId) {
        A.b("KeepAliveBgService", "onStartCommand");
        return 1;
    }
}
