package com.oplus.melody.app.discovery;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import u8.C1557e;
import u8.C1558f;

/* JADX INFO: compiled from: DiscoveryViewStatePairingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class p1 extends I0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f19169m;

    @Override // com.oplus.melody.app.discovery.I0
    public final C1557e a(C1558f c1558f) {
        return c1558f.getPairingState();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0144  */
    @Override // com.oplus.melody.app.discovery.I0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.concurrent.CompletableFuture<java.lang.Integer> g(int r17, com.oplus.melody.app.discovery.C1 r18) {
        /*
            Method dump skipped, instruction units count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.app.discovery.p1.g(int, com.oplus.melody.app.discovery.C1):java.util.concurrent.CompletableFuture");
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final CompletableFuture<Integer> h(int i10) {
        return this.f19169m ? super.h(i10).thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new C0894z0(this, i10, 4)) : super.h(i10).thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new o1(this, i10, 0));
    }
}
