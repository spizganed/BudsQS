package com.oplus.melody.ui.component.detail.zenmode.scene;

import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f21494b;

    public /* synthetic */ n(o oVar, int i10) {
        this.f21493a = i10;
        this.f21494b = oVar;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f21493a) {
            case 0:
                return "turnOffWearCheck, mWasWearCheckEnabled = " + this.f21494b.f21500f;
            default:
                return "onUpgradeFinish, mPendingWearStatus: " + this.f21494b.f21501g;
        }
    }
}
