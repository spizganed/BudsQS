package com.heytap.headset.receiver;

import F7.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.heytap.headset.service.KeepAliveBgService;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.ServiceUtils;
import kotlin.Metadata;
import t8.q;

/* JADX INFO: compiled from: KeepAliveReceiver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/heytap/headset/receiver/KeepAliveReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KeepAliveReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f17583a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        A.c("KeepAliveReceiver", new b(1, intent));
        if (context == null) {
            return;
        }
        ServiceUtils.startService(context, new Intent(context, (Class<?>) KeepAliveBgService.class));
        try {
            if (q.l()) {
                com.heytap.headset.service.b.a(context);
            }
        } catch (IllegalStateException e10) {
            A.i("KeepAliveReceiver", "onReceive startForegroundService", e10);
        }
    }
}
