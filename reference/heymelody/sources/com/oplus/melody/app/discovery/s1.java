package com.oplus.melody.app.discovery;

import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ E0 f19191b;

    public /* synthetic */ s1(E0 e02, int i10) {
        this.f19190a = i10;
        this.f19191b = e02;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19190a) {
            case 0:
                return "click audio share:" + com.oplus.melody.common.util.A.r(this.f19191b.getId());
            default:
                return "mBtnConnect click, vo.getConnectState() = " + this.f19191b.getConnectState();
        }
    }
}
