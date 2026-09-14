package com.oplus.melody.model.db;

import java.util.Arrays;
import java.util.function.Supplier;
import x3.C1656o;

/* JADX INFO: renamed from: com.oplus.melody.model.db.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0919a implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long[] f19758b;

    public /* synthetic */ C0919a(long[] jArr, int i10) {
        this.f19757a = i10;
        this.f19758b = jArr;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19757a) {
            case 0:
                return C1656o.a("insertSource, ids: ", Arrays.toString(this.f19758b));
            default:
                return "insertSource, ids: " + Arrays.toString(this.f19758b);
        }
    }
}
