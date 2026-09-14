package com.oplus.melody.model.repository.earphone;

import D7.C0368b;
import D7.o0;
import android.content.Intent;
import android.os.Build;
import androidx.media3.session.N0;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.util.C0906l;
import d8.AbstractC0972a;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import x6.C1672b;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f19967c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ boolean f19968p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f19969q;

    public /* synthetic */ o(Object obj, String str, int i10, boolean z2, int i11) {
        this.f19965a = i11;
        this.f19969q = obj;
        this.f19966b = str;
        this.f19967c = i10;
        this.f19968p = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f19965a) {
            case 0:
                L l4 = (L) this.f19969q;
                String str = this.f19966b;
                int i10 = this.f19967c;
                boolean z2 = this.f19968p;
                l4.f19932u.i(i10, str);
                if (z2) {
                    HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                    Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1094);
                    intentU.putExtra("param_address", str);
                    intentU.putExtra("param_value", i10);
                    com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
                }
                break;
            default:
                String str2 = this.f19966b;
                int i11 = this.f19967c;
                boolean z4 = this.f19968p;
                com.oplus.melody.common.util.A.c("GameSoundManager", new I6.j(str2, i11, z4));
                C1672b c1672b = (C1672b) this.f19969q;
                CompletableFuture<SetCommandStateDTO> completableFuture = c1672b.f28969g;
                if (completableFuture != null) {
                    completableFuture.cancel(true);
                }
                CompletableFuture<SetCommandStateDTO> completableFutureD = AbstractC0972a.c().d(i11, z4, str2);
                c1672b.f28969g = completableFutureD;
                if (completableFutureD != null) {
                    completableFutureD.thenAccept((Consumer<? super SetCommandStateDTO>) new C0368b(new E8.e(16), 27));
                }
                if (c1672b.c(str2)) {
                    if (!z4) {
                        o0.c.f1145c.execute(new k7.n(c1672b, 13));
                    } else if (Build.VERSION.SDK_INT >= 32) {
                        o0.c.f1145c.execute(new N0(c1672b, 25));
                    }
                }
                break;
        }
    }
}
