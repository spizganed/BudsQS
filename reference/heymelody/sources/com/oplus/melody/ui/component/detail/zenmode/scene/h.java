package com.oplus.melody.ui.component.detail.zenmode.scene;

import D7.o0;
import Ea.W;
import com.oplus.melody.ui.component.detail.zenmode.scene.b;
import com.oplus.melody.ui.component.detail.zenmode.scene.c;
import com.oplus.melody.ui.component.detail.zenmode.scene.g;

/* JADX INFO: compiled from: ZenModeSceneFragment.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f21486b;

    public h(i iVar, int i10) {
        this.f21486b = iVar;
        this.f21485a = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar = this.f21486b;
        int i10 = ((iVar.f21488b * 40) / 70) + 60;
        if (!b.C0235b.f21441a.h) {
            c.a.f21443a.b(i10);
        }
        g gVar = iVar.f21489c;
        g.c cVar = gVar.f21462s;
        cVar.getClass();
        o0.d(new W(cVar, i10, 6));
        int i11 = iVar.f21488b + 1;
        iVar.f21488b = i11;
        if (i11 <= 70) {
            gVar.f21452C.postDelayed(this, 100L);
        } else {
            gVar.f21452C.postDelayed(new W(this, this.f21485a, 5), 100L);
        }
    }
}
