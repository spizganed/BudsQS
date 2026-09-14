package com.oplus.melody.model.db;

import D7.C0374h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class HearingEnhancementDao_Impl extends HearingEnhancementDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MelodyDatabase_Impl f19688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0922d f19689b = new C0922d(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0923e f19690c = new C0923e(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0924f f19691d = new C0924f(1);

    public HearingEnhancementDao_Impl(MelodyDatabase_Impl melodyDatabase_Impl) {
        this.f19688a = melodyDatabase_Impl;
    }

    @Override // com.oplus.melody.model.db.w
    public final int a(List<HearingEnhancementEntity> list) {
        return ((Integer) androidx.room.util.a.a(this.f19688a, false, true, new C0374h(11, this, (ArrayList) list))).intValue();
    }

    @Override // com.oplus.melody.model.db.w
    public final long[] b(List<HearingEnhancementEntity> list) {
        return (long[]) androidx.room.util.a.a(this.f19688a, false, true, new C0374h(10, this, list));
    }

    @Override // com.oplus.melody.model.db.HearingEnhancementDao
    public final int d(HearingEnhancementEntity hearingEnhancementEntity) {
        return ((Integer) androidx.room.util.a.a(this.f19688a, false, true, new t(this, hearingEnhancementEntity, 1))).intValue();
    }

    @Override // com.oplus.melody.model.db.HearingEnhancementDao
    public final int e(HearingEnhancementEntity hearingEnhancementEntity) {
        return ((Integer) androidx.room.util.a.a(this.f19688a, false, true, new t(this, hearingEnhancementEntity, 0))).intValue();
    }

    @Override // com.oplus.melody.model.db.HearingEnhancementDao
    public final androidx.lifecycle.s<List<HearingEnhancementEntity>> f() {
        return this.f19688a.d().b(new String[]{"hearing_enhancement"}, new D7.G(14));
    }

    @Override // com.oplus.melody.model.db.HearingEnhancementDao
    public final List<HearingEnhancementEntity> g(String str) {
        return (List) androidx.room.util.a.a(this.f19688a, true, false, new O9.i(str, 2));
    }

    @Override // com.oplus.melody.model.db.HearingEnhancementDao
    public final int h(HearingEnhancementEntity hearingEnhancementEntity) {
        return ((Integer) androidx.room.util.a.a(this.f19688a, false, true, new I8.m(5, this, hearingEnhancementEntity))).intValue();
    }
}
