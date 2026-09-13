package com.oplus.melody.model.net;

import java.io.IOException;

/* JADX INFO: compiled from: ProgressResponseBody.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends Kc.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f19824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f19825c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, Kc.d dVar) {
        super(dVar);
        this.f19825c = jVar;
        this.f19824b = 0L;
    }

    @Override // Kc.f, Kc.t
    public final long k0(Kc.b bVar, long j5) throws IOException {
        long jK0 = super.k0(bVar, 8192L);
        long jMax = Math.max(0L, jK0) + this.f19824b;
        this.f19824b = jMax;
        j jVar = this.f19825c;
        jVar.f19827p.a(jMax, jVar.f19826c.b());
        return jK0;
    }
}
