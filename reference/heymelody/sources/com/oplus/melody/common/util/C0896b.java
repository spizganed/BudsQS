package com.oplus.melody.common.util;

import java.util.function.Supplier;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: renamed from: com.oplus.melody.common.util.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0896b implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref$BooleanRef f19485b;

    public /* synthetic */ C0896b(Ref$BooleanRef ref$BooleanRef, int i10) {
        this.f19484a = i10;
        this.f19485b = ref$BooleanRef;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19484a) {
            case 0:
                return A6.e.f("startAppPermissionDetailActivityForResult canNavigateToAppPermissions = ", this.f19485b.element);
            default:
                return A6.e.f("handlePermissionResult shouldGoAppSettings： ", this.f19485b.element);
        }
    }
}
