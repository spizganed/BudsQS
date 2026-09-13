package com.oplus.melody.app.discovery;

import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z1 f19194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f19195c;

    public /* synthetic */ t1(z1 z1Var, int i10, int i11) {
        this.f19193a = i11;
        this.f19194b = z1Var;
        this.f19195c = i10;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i10 = this.f19195c;
        z1 z1Var = this.f19194b;
        switch (this.f19193a) {
            case 0:
                return J6.d.f(i10, 8, z1Var.f18931d, z1Var.f18932e, z1Var.f18937k, z1Var.f18938l, z1Var.f19242n, z1Var.f19243o, z1Var.f19244p);
            default:
                return J6.d.f(i10, 0, z1Var.f18931d, z1Var.f18932e, z1Var.f19242n, z1Var.f19243o);
        }
    }
}
