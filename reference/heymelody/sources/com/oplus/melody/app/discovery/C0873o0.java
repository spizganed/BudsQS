package com.oplus.melody.app.discovery;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.o0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0873o0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19157a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f19159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f19160d;

    public /* synthetic */ C0873o0(com.oplus.melody.model.repository.personaldress.e eVar, int i10, String str) {
        this.f19160d = eVar;
        this.f19158b = i10;
        this.f19159c = str;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f19157a) {
            case 0:
                CompletableFuture[] completableFutureArr = (CompletableFuture[]) this.f19160d;
                C1 c12 = (C1) completableFutureArr[0].join();
                String str = this.f19159c;
                int i10 = this.f19158b;
                if (c12 != null && c12.getDiscoveryStates() != null) {
                    com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new Aa.a(str, i10, 8));
                    return c12;
                }
                C1 c13 = (C1) completableFutureArr[1].join();
                if (c13 == null || c13.getDiscoveryStates() == null) {
                    com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new I8.s(str, i10, 2));
                    return (C1) completableFutureArr[2].join();
                }
                com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new D6.a(str, i10, 2));
                return c13;
            default:
                return ((com.oplus.melody.model.repository.personaldress.e) this.f19160d).F(this.f19158b, this.f19159c);
        }
    }

    public /* synthetic */ C0873o0(CompletableFuture[] completableFutureArr, String str, int i10) {
        this.f19160d = completableFutureArr;
        this.f19159c = str;
        this.f19158b = i10;
    }
}
