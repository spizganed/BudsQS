package com.oplus.melody.model.db;

import D7.C0378l;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ZenModeResourceDao_Impl extends ZenModeResourceDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MelodyDatabase_Impl f19753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final O f19754b = new O();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final G f19755c = new G(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0927j f19756d = new C0927j(2);

    public ZenModeResourceDao_Impl(MelodyDatabase_Impl melodyDatabase_Impl) {
        this.f19753a = melodyDatabase_Impl;
    }

    @Override // com.oplus.melody.model.db.w
    public final int a(List<N> list) {
        return ((Integer) androidx.room.util.a.a(this.f19753a, false, true, new I8.m(10, this, list))).intValue();
    }

    @Override // com.oplus.melody.model.db.w
    public final long[] b(List<N> list) {
        return (long[]) androidx.room.util.a.a(this.f19753a, false, true, new C0378l(10, this, list));
    }

    @Override // com.oplus.melody.model.db.w
    public final int c(List<N> list) {
        return ((Integer) androidx.room.util.a.a(this.f19753a, false, true, new J8.e(14, this, list))).intValue();
    }

    @Override // com.oplus.melody.model.db.ZenModeResourceDao
    public final List<N> d(String str, String str2) {
        return (List) androidx.room.util.a.a(this.f19753a, true, false, new J(str, str2, 1));
    }
}
