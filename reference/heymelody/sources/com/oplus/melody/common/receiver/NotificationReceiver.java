package com.oplus.melody.common.receiver;

import F7.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.P;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: NotificationReceiver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/oplus/melody/common/receiver/NotificationReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NotificationReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f19414a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        h.e(context, "context");
        h.e(intent, "intent");
        A.c("NotificationReceiver", new b(0, intent));
        if ("com.melody.notification.cancel".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("notification_id", 0);
            P p6 = P.f19456a;
            P.a(context, intExtra);
        }
    }
}
