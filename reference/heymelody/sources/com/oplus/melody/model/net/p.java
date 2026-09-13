package com.oplus.melody.model.net;

import java.util.Objects;
import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ E f19835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ androidx.collection.a f19836c;

    public /* synthetic */ p(E e10, androidx.collection.a aVar, int i10) {
        this.f19834a = i10;
        this.f19835b = e10;
        this.f19836c = aVar;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        G g3 = (G) obj;
        switch (this.f19834a) {
            case 0:
                E e10 = this.f19835b;
                e10.getClass();
                Objects.requireNonNull(g3);
                return e10.n(this.f19836c, new x(g3, 0));
            default:
                E e11 = this.f19835b;
                e11.getClass();
                Objects.requireNonNull(g3);
                return e11.n(this.f19836c, new x(g3, 2));
        }
    }
}
