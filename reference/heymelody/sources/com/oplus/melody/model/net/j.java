package com.oplus.melody.model.net;

import okhttp3.MediaType;

/* JADX INFO: compiled from: ProgressResponseBody.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends uc.s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final uc.s f19826c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final h f19827p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Kc.o f19828q;

    public j(uc.s sVar, h hVar) {
        this.f19826c = sVar;
        this.f19827p = hVar;
    }

    @Override // uc.s
    public final long b() {
        return this.f19826c.b();
    }

    @Override // uc.s
    public final MediaType c() {
        return this.f19826c.c();
    }

    @Override // uc.s
    public final Kc.d d() {
        if (this.f19828q == null) {
            this.f19828q = D1.f.d(new i(this, this.f19826c.d()));
        }
        return this.f19828q;
    }
}
