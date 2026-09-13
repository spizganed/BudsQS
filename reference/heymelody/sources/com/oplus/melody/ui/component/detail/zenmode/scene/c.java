package com.oplus.melody.ui.component.detail.zenmode.scene;

import B.H;
import B.t;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.P;

/* JADX INFO: compiled from: ZenModeNotifier.java */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"MissingPermission"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HeyMelodyApplication f21442a = C0906l.f19501a;

    /* JADX INFO: compiled from: ZenModeNotifier.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        public static final c f21443a = new c();
    }

    public final void a(boolean z2, int i10, String str, Bundle bundle) {
        Intent intent = new Intent("com.oplus.melody.ui.zenmode.scene.NOTIFICATION_CLICKED");
        intent.setPackage(C0906l.f19501a.getPackageName());
        intent.putExtras(bundle);
        intent.putExtra("extra_zen_mode_notification_succeed", z2);
        intent.putExtra("extra_zen_mode_notification_sending_music_id", str);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f21442a, 3, intent, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
        H h = new H(this.f21442a);
        P p6 = P.f19456a;
        P.b(this.f21442a, "headset_channel", h);
        t tVar = new t(this.f21442a, "headset_channel");
        tVar.f322e = t.c(this.f21442a.getString(i10));
        tVar.f314Q.tickerText = t.c(this.f21442a.getString(i10));
        tVar.f303E = 1;
        tVar.f314Q.when = 0L;
        tVar.f330n = true;
        tVar.h = broadcast;
        tVar.d(16, false);
        tVar.f329m = 1;
        tVar.f314Q.icon = this.f21442a.getApplicationInfo().icon;
        h.a(4, tVar.a());
    }

    public final void b(int i10) {
        PendingIntent activity = PendingIntent.getActivity(this.f21442a, 3, new Intent(C0906l.f19501a, (Class<?>) ZenModeSceneActivity.class), Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
        H h = new H(this.f21442a);
        P p6 = P.f19456a;
        P.b(this.f21442a, "headset_channel", h);
        t tVar = new t(this.f21442a, "headset_channel");
        tVar.f322e = t.c(this.f21442a.getString(R.string.melody_ui_zen_mode_sending_music_to_headset, String.valueOf(i10)));
        tVar.d(2, true);
        tVar.f335s = 100;
        tVar.f336t = i10;
        tVar.f337u = false;
        tVar.h = activity;
        tVar.f314Q.icon = this.f21442a.getApplicationInfo().icon;
        h.a(4, tVar.a());
    }
}
