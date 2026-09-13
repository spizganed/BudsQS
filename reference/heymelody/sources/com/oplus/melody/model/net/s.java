package com.oplus.melody.model.net;

import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ E f19842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ androidx.collection.a f19843c;

    public /* synthetic */ s(E e10, androidx.collection.a aVar, int i10) {
        this.f19841a = i10;
        this.f19842b = e10;
        this.f19843c = aVar;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        final G g3 = (G) obj;
        switch (this.f19841a) {
            case 0:
                E e10 = this.f19842b;
                Objects.requireNonNull(g3);
                return e10.n(this.f19843c, new BiFunction() { // from class: com.oplus.melody.model.net.v
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj2, Object obj3) {
                        return g3.e((Map) obj2, (String) obj3);
                    }
                });
            default:
                E e11 = this.f19842b;
                e11.getClass();
                Objects.requireNonNull(g3);
                return e11.n(this.f19843c, new y(g3, 0));
        }
    }
}
