package com.oplus.melody.app.discovery;

import android.view.View;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.z0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0894z0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f19240c;

    public /* synthetic */ C0894z0(int i10, Serializable serializable, int i11) {
        this.f19238a = i11;
        this.f19239b = i10;
        this.f19240c = serializable;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i10 = this.f19239b;
        Object obj2 = this.f19240c;
        switch (this.f19238a) {
            case 0:
                E0 e02 = (E0) obj;
                String str = (String) obj2;
                if (e02 == null) {
                    Y.r.l(str, "DiscoveryDialogViewModel", androidx.appcompat.widget.a.n(i10, "setAccountBindingState ", " failed, earphone is null. macAddress="));
                    return null;
                }
                E0 e03 = (E0) com.oplus.melody.common.data.a.copyOf(e02, E0.class);
                e03.setAccountBindingState(i10);
                if (!com.oplus.melody.common.util.A.l()) {
                    return e03;
                }
                StringBuilder sbN = androidx.appcompat.widget.a.n(i10, "setAccountBindingState ", " macAddress=");
                sbN.append(com.oplus.melody.common.util.A.r(str));
                sbN.append(" hashCode=");
                sbN.append(e03.hashCode());
                com.oplus.melody.common.util.A.b("DiscoveryDialogViewModel", sbN.toString());
                return e03;
            case 1:
                return J6.d.f(i10, 0, ((N0) obj2).f18931d);
            case 2:
                return J6.d.f(i10, 8, (View[]) ((LinkedList) obj2).toArray(new View[0]));
            case 3:
                C0859i1 c0859i1 = (C0859i1) obj2;
                return J6.d.f(i10, 0, c0859i1.f18931d, c0859i1.f18933f, c0859i1.f18937k);
            case 4:
                p1 p1Var = (p1) obj2;
                return J6.d.f(i10, 8, p1Var.f18931d, p1Var.f18933f).thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new n1(p1Var, i10, 0));
            default:
                A1 a12 = (A1) obj2;
                return J6.d.f(i10, 0, a12.f18931d, a12.f18932e, a12.f18816m);
        }
    }

    public /* synthetic */ C0894z0(I0 i02, int i10, int i11) {
        this.f19238a = i11;
        this.f19240c = i02;
        this.f19239b = i10;
    }
}
