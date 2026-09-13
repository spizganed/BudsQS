package com.oplus.melody.model.db;

import D7.C0374h;
import java.util.List;
import q1.InterfaceC1431a;

/* JADX INFO: loaded from: classes3.dex */
public final class CarouselDressDao_Impl extends CarouselDressDao {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f19667e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MelodyDatabase_Impl f19668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0922d f19669b = new C0922d(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0923e f19670c = new C0923e(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0924f f19671d = new C0924f(0);

    public CarouselDressDao_Impl(MelodyDatabase_Impl melodyDatabase_Impl) {
        this.f19668a = melodyDatabase_Impl;
    }

    @Override // com.oplus.melody.model.db.w
    public final long[] b(List<CarouselDressEntity> list) {
        return (long[]) androidx.room.util.a.a(this.f19668a, false, true, new J8.e(9, this, list));
    }

    @Override // com.oplus.melody.model.db.CarouselDressDao
    public final int d(CarouselDressEntity carouselDressEntity) {
        return ((Integer) androidx.room.util.a.a(this.f19668a, false, true, new J8.e(8, this, carouselDressEntity))).intValue();
    }

    @Override // com.oplus.melody.model.db.CarouselDressDao
    public final int e(int i10, String str) {
        return ((Integer) androidx.room.util.a.a(this.f19668a, false, true, new C0920b(str, i10, 1))).intValue();
    }

    @Override // com.oplus.melody.model.db.CarouselDressDao
    public final long f(CarouselDressEntity carouselDressEntity) {
        return ((Long) androidx.room.util.a.a(this.f19668a, false, true, new I8.m(4, this, carouselDressEntity))).longValue();
    }

    @Override // com.oplus.melody.model.db.CarouselDressDao
    public final androidx.lifecycle.s<List<CarouselDressEntity>> g() {
        return this.f19668a.d().b(new String[]{"carousel_dress"}, new D7.G(11));
    }

    @Override // com.oplus.melody.model.db.CarouselDressDao
    public final CarouselDressEntity h(final int i10) {
        return (CarouselDressEntity) androidx.room.util.a.a(this.f19668a, true, false, new Wb.l() { // from class: com.oplus.melody.model.db.c
            @Override // Wb.l
            public final Object d(Object obj) throws Exception {
                int i11 = i10;
                q1.c cVarV0 = ((InterfaceC1431a) obj).v0("SELECT * FROM carousel_dress WHERE carouselId = ?");
                try {
                    cVarV0.h(1, i11);
                    int iT = E8.a.t(cVarV0, "carouselId");
                    int iT2 = E8.a.t(cVarV0, "productId");
                    int iT3 = E8.a.t(cVarV0, "colorId");
                    int iT4 = E8.a.t(cVarV0, "name");
                    int iT5 = E8.a.t(cVarV0, "carouselType");
                    int iT6 = E8.a.t(cVarV0, "themeIdList");
                    CarouselDressEntity carouselDressEntity = null;
                    String strO = null;
                    if (cVarV0.l0()) {
                        int i12 = (int) cVarV0.getLong(iT);
                        String strO2 = cVarV0.isNull(iT2) ? null : cVarV0.o(iT2);
                        int i13 = (int) cVarV0.getLong(iT3);
                        String strO3 = cVarV0.isNull(iT4) ? null : cVarV0.o(iT4);
                        int i14 = (int) cVarV0.getLong(iT5);
                        if (!cVarV0.isNull(iT6)) {
                            strO = cVarV0.o(iT6);
                        }
                        carouselDressEntity = new CarouselDressEntity(i12, strO2, i13, strO3, i14, MelodyTypeConverters.a(strO));
                    }
                    return carouselDressEntity;
                } finally {
                    cVarV0.close();
                }
            }
        });
    }

    @Override // com.oplus.melody.model.db.CarouselDressDao
    public final List i(int i10, String str) {
        return (List) androidx.room.util.a.a(this.f19668a, true, false, new C0920b(str, i10, 0));
    }

    @Override // com.oplus.melody.model.db.CarouselDressDao
    public final int j(CarouselDressEntity carouselDressEntity) {
        return ((Integer) androidx.room.util.a.a(this.f19668a, false, true, new C0374h(7, this, carouselDressEntity))).intValue();
    }
}
