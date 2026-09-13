package com.oplus.melody.model.db;

import D7.C0374h;
import D7.C0378l;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class PersonalDressSeriesDao_Impl extends PersonalDressSeriesDao {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f19742f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MelodyDatabase_Impl f19743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0922d f19744b = new C0922d(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0923e f19745c = new C0923e(4);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0924f f19746d = new C0924f(3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final G f19747e = new G(0);

    public PersonalDressSeriesDao_Impl(MelodyDatabase_Impl melodyDatabase_Impl) {
        this.f19743a = melodyDatabase_Impl;
    }

    @Override // com.oplus.melody.model.db.w
    public final int a(List<PersonalDressSeriesEntity> list) {
        return ((Integer) androidx.room.util.a.a(this.f19743a, false, true, new I8.m(8, this, (ArrayList) list))).intValue();
    }

    @Override // com.oplus.melody.model.db.w
    public final long[] b(List<PersonalDressSeriesEntity> list) {
        return (long[]) androidx.room.util.a.a(this.f19743a, false, true, new J8.e(13, this, (ArrayList) list));
    }

    @Override // com.oplus.melody.model.db.w
    public final int c(List<PersonalDressSeriesEntity> list) {
        return ((Integer) androidx.room.util.a.a(this.f19743a, false, true, new C0374h(13, this, (ArrayList) list))).intValue();
    }

    @Override // com.oplus.melody.model.db.PersonalDressSeriesDao
    public final androidx.lifecycle.s<List<PersonalDressSeriesEntity>> d() {
        return this.f19743a.d().b(new String[]{"persnoal_dress_series"}, new F(1));
    }

    @Override // com.oplus.melody.model.db.PersonalDressSeriesDao
    public final int e(PersonalDressSeriesEntity personalDressSeriesEntity) {
        return ((Integer) androidx.room.util.a.a(this.f19743a, false, true, new C0378l(6, this, personalDressSeriesEntity))).intValue();
    }
}
