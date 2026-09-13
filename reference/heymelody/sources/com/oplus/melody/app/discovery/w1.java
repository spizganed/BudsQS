package com.oplus.melody.app.discovery;

import java.util.function.BiConsumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w1 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z1 f19214b;

    public /* synthetic */ w1(z1 z1Var, int i10) {
        this.f19213a = i10;
        this.f19214b = z1Var;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f19213a) {
            case 0:
                this.f19214b.f19246r = true;
                break;
            default:
                this.f19214b.f18929b.f18873t0 = 2;
                break;
        }
    }
}
