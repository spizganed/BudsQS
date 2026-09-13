package com.oplus.melody.app.discovery;

import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.s0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0880s0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ E0 f19189b;

    public /* synthetic */ C0880s0(E0 e02, int i10) {
        this.f19188a = i10;
        this.f19189b = e02;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19188a) {
            case 0:
                return "handleShareAudio pairingState:" + this.f19189b.getPairingState();
            default:
                return "has tipclean address:" + com.oplus.melody.common.util.A.r(this.f19189b.getId());
        }
    }
}
