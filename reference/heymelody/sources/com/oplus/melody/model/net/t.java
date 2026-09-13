package com.oplus.melody.model.net;

import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class t implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ E f19845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ androidx.collection.a f19846c;

    public /* synthetic */ t(E e10, androidx.collection.a aVar, int i10) {
        this.f19844a = i10;
        this.f19845b = e10;
        this.f19846c = aVar;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        final G g3 = (G) obj;
        switch (this.f19844a) {
            case 0:
                E e10 = this.f19845b;
                e10.getClass();
                Objects.requireNonNull(g3);
                final int i10 = 2;
                return e10.n(this.f19846c, new BiFunction() { // from class: com.oplus.melody.model.net.w
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj2, Object obj3) {
                        Map<String, String> map = (Map) obj2;
                        String str = (String) obj3;
                        switch (i10) {
                            case 0:
                                return g3.b(map, str);
                            case 1:
                                return g3.d(map, str);
                            default:
                                return g3.a(map, str);
                        }
                    }
                });
            case 1:
                E e11 = this.f19845b;
                e11.getClass();
                Objects.requireNonNull(g3);
                final int i11 = 0;
                return e11.n(this.f19846c, new BiFunction() { // from class: com.oplus.melody.model.net.w
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj2, Object obj3) {
                        Map<String, String> map = (Map) obj2;
                        String str = (String) obj3;
                        switch (i11) {
                            case 0:
                                return g3.b(map, str);
                            case 1:
                                return g3.d(map, str);
                            default:
                                return g3.a(map, str);
                        }
                    }
                });
            default:
                E e12 = this.f19845b;
                e12.getClass();
                Objects.requireNonNull(g3);
                final int i12 = 1;
                return e12.n(this.f19846c, new BiFunction() { // from class: com.oplus.melody.model.net.w
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj2, Object obj3) {
                        Map<String, String> map = (Map) obj2;
                        String str = (String) obj3;
                        switch (i12) {
                            case 0:
                                return g3.b(map, str);
                            case 1:
                                return g3.d(map, str);
                            default:
                                return g3.a(map, str);
                        }
                    }
                });
        }
    }
}
