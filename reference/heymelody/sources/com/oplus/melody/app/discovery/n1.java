package com.oplus.melody.app.discovery;

import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p1 f19149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f19150c;

    public /* synthetic */ n1(p1 p1Var, int i10, int i11) {
        this.f19148a = i11;
        this.f19149b = p1Var;
        this.f19150c = i10;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i10 = this.f19150c;
        p1 p1Var = this.f19149b;
        switch (this.f19148a) {
            case 0:
                return J6.d.f(i10, 8, p1Var.f18937k);
            default:
                return J6.d.f(i10, 0, p1Var.f18937k);
        }
    }
}
