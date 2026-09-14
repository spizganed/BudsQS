package com.oplus.melody.model.db;

import D7.C0378l;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ProvisionalWhitelistDao_Impl extends ProvisionalWhitelistDao {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f19748c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MelodyDatabase_Impl f19749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f19750b = new p(1);

    public ProvisionalWhitelistDao_Impl(MelodyDatabase_Impl melodyDatabase_Impl) {
        this.f19749a = melodyDatabase_Impl;
    }

    public static /* synthetic */ Jb.l l(ProvisionalWhitelistDao_Impl provisionalWhitelistDao_Impl, ProvisionalWhitelistEntity provisionalWhitelistEntity) {
        super.e(provisionalWhitelistEntity);
        return Jb.l.f2618a;
    }

    @Override // com.oplus.melody.model.db.w
    public final long[] b(List<ProvisionalWhitelistEntity> list) {
        return (long[]) androidx.room.util.a.a(this.f19749a, false, true, new I8.m(9, this, list));
    }

    @Override // com.oplus.melody.model.db.ProvisionalWhitelistDao
    public final void d(LinkedHashSet linkedHashSet) {
        StringBuilder sb2 = new StringBuilder("DELETE FROM provisional_whitelist WHERE pid IN (");
        int size = linkedHashSet.size();
        for (int i10 = 0; i10 < size; i10++) {
            sb2.append("?");
            if (i10 < size - 1) {
                sb2.append(",");
            }
        }
        sb2.append(")");
        androidx.room.util.a.a(this.f19749a, false, true, new C0378l(8, sb2.toString(), linkedHashSet));
    }

    @Override // com.oplus.melody.model.db.ProvisionalWhitelistDao
    public final void e(ProvisionalWhitelistEntity provisionalWhitelistEntity) {
        androidx.room.util.a.a(this.f19749a, false, true, new C0378l(7, this, provisionalWhitelistEntity));
    }

    @Override // com.oplus.melody.model.db.ProvisionalWhitelistDao
    public final androidx.lifecycle.s<List<ProvisionalWhitelistEntity>> f() {
        return this.f19749a.d().b(new String[]{"provisional_whitelist"}, new E8.e(8));
    }

    @Override // com.oplus.melody.model.db.ProvisionalWhitelistDao
    public final void g(String str, String str2) {
        androidx.room.util.a.a(this.f19749a, false, true, new I(str2, str, 1));
    }

    @Override // com.oplus.melody.model.db.ProvisionalWhitelistDao
    public final void h(int i10, String str) {
        androidx.room.util.a.a(this.f19749a, false, true, new I8.q(i10, str, 3));
    }

    @Override // com.oplus.melody.model.db.ProvisionalWhitelistDao
    public final void i(String str, String str2) {
        androidx.room.util.a.a(this.f19749a, false, true, new J(str2, str, 0));
    }

    @Override // com.oplus.melody.model.db.ProvisionalWhitelistDao
    public final void j(String str, String str2) {
        androidx.room.util.a.a(this.f19749a, false, true, new I(str2, str, 0));
    }

    @Override // com.oplus.melody.model.db.ProvisionalWhitelistDao
    public final void k(String str, String str2) {
        androidx.room.util.a.a(this.f19749a, false, true, new z(str2, str, 1));
    }
}
