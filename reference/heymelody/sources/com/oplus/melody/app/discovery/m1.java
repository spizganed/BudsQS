package com.oplus.melody.app.discovery;

import D7.C0388w;
import D7.o0;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import u8.C1557e;
import u8.C1558f;

/* JADX INFO: compiled from: DiscoveryViewStateInitImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class m1 extends I0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f19143m;

    @Override // com.oplus.melody.app.discovery.I0
    public final C1557e a(C1558f c1558f) {
        C1557e initState = c1558f.getInitState();
        return initState == null ? c1558f.getReadyState() : initState;
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final void f(E0 e02) {
        super.f(e02);
        String name = e02.getName();
        this.f18931d.setMaxLines(3);
        c().thenAcceptAsync((Consumer<? super MelodyResourceDO>) new T0(this, name, 2), (Executor) o0.c.f1144b).exceptionally((Function<Throwable, ? extends Void>) new C0388w(29));
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final CompletableFuture<Integer> g(int i10, C1 c12) {
        this.f18936j.setOnClickListener(new ViewOnClickListenerC0856h1(this, 2));
        return super.g(i10, c12);
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final void m(C1 c12, boolean z2) {
        super.m(c12, z2);
        if (z2 && this.f19143m) {
            this.f19143m = false;
            j(2);
        }
    }
}
