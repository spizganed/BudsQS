package com.oplus.melody.model.net;

import java.util.Map;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class x implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ G f19854b;

    public /* synthetic */ x(G g3, int i10) {
        this.f19853a = i10;
        this.f19854b = g3;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        Map<String, String> map = (Map) obj;
        String str = (String) obj2;
        switch (this.f19853a) {
            case 0:
                return this.f19854b.g(map, str);
            case 1:
                return this.f19854b.h(map, str);
            default:
                return this.f19854b.j(map, str);
        }
    }
}
