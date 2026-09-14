package com.oplus.melody.ui.component.detail.personalnoise;

import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f21192b;

    public /* synthetic */ k(m mVar, int i10) {
        this.f21191a = i10;
        this.f21192b = mVar;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f21191a) {
            case 0:
                return "onCreateDialog: mPersonalizedNoiseReductionResult=" + this.f21192b.f21196b;
            default:
                return "PersonalNoiseItem: mBothInEar:" + this.f21192b.f21199q;
        }
    }
}
