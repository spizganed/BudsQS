package com.oplus.melody.model.net;

import java.util.Objects;
import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class u implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ E f19848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ androidx.collection.a f19849c;

    public /* synthetic */ u(E e10, androidx.collection.a aVar, int i10) {
        this.f19847a = i10;
        this.f19848b = e10;
        this.f19849c = aVar;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        G g3 = (G) obj;
        switch (this.f19847a) {
            case 0:
                E e10 = this.f19848b;
                e10.getClass();
                Objects.requireNonNull(g3);
                return e10.n(this.f19849c, new x(g3, 1));
            case 1:
                E e11 = this.f19848b;
                e11.getClass();
                Objects.requireNonNull(g3);
                return e11.n(this.f19849c, new y(g3, 1));
            default:
                E e12 = this.f19848b;
                e12.getClass();
                Objects.requireNonNull(g3);
                return e12.n(this.f19849c, new y(g3, 2));
        }
    }
}
