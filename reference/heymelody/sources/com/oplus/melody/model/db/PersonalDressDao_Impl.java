package com.oplus.melody.model.db;

import D7.C0374h;
import D7.C0378l;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class PersonalDressDao_Impl extends PersonalDressDao {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f19737e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MelodyDatabase_Impl f19738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0922d f19739b = new C0922d(2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0923e f19740c = new C0923e(3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0924f f19741d = new C0924f(2);

    public PersonalDressDao_Impl(MelodyDatabase_Impl melodyDatabase_Impl) {
        this.f19738a = melodyDatabase_Impl;
    }

    @Override // com.oplus.melody.model.db.w
    public final long[] b(List<PersonalDressEntity> list) {
        return (long[]) androidx.room.util.a.a(this.f19738a, false, true, new J8.e(12, this, list));
    }

    @Override // com.oplus.melody.model.db.PersonalDressDao
    public final int d(PersonalDressEntity personalDressEntity) {
        return ((Integer) androidx.room.util.a.a(this.f19738a, false, true, new C0378l(5, this, personalDressEntity))).intValue();
    }

    @Override // com.oplus.melody.model.db.PersonalDressDao
    public final int e(PersonalDressEntity personalDressEntity) {
        return ((Integer) androidx.room.util.a.a(this.f19738a, false, true, new C0374h(12, this, personalDressEntity))).intValue();
    }

    @Override // com.oplus.melody.model.db.PersonalDressDao
    public final androidx.lifecycle.s<List<PersonalDressEntity>> f() {
        return this.f19738a.d().b(new String[]{"persnoal_dress"}, new F(0));
    }

    @Override // com.oplus.melody.model.db.PersonalDressDao
    public final int g(PersonalDressEntity personalDressEntity) {
        return ((Integer) androidx.room.util.a.a(this.f19738a, false, true, new I8.m(7, this, personalDressEntity))).intValue();
    }
}
