package com.oplus.melody.model.db;

import D7.C0378l;
import java.util.ArrayList;
import java.util.List;
import q1.InterfaceC1431a;

/* JADX INFO: loaded from: classes3.dex */
public final class SpineHistoryDataDao_Impl extends SpineHistoryDataDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MelodyDatabase_Impl f19751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f19752b = new p(2);

    public SpineHistoryDataDao_Impl(MelodyDatabase_Impl melodyDatabase_Impl) {
        this.f19751a = melodyDatabase_Impl;
    }

    @Override // com.oplus.melody.model.db.w
    public final long[] b(List<M> list) {
        return (long[]) androidx.room.util.a.a(this.f19751a, false, true, new C0378l(9, this, list));
    }

    @Override // com.oplus.melody.model.db.SpineHistoryDataDao
    public final List<M> d(final int i10, final int i11) {
        return (List) androidx.room.util.a.a(this.f19751a, true, false, new Wb.l() { // from class: com.oplus.melody.model.db.L
            @Override // Wb.l
            public final Object d(Object obj) throws Exception {
                int i12 = i10;
                int i13 = i11;
                q1.c cVarV0 = ((InterfaceC1431a) obj).v0("SELECT * FROM spine_history_data WHERE utc_time >= ? AND utc_time < ? order by utc_time asc");
                try {
                    cVarV0.h(1, i12);
                    cVarV0.h(2, i13);
                    int iT = E8.a.t(cVarV0, "utc_time");
                    int iT2 = E8.a.t(cVarV0, "product_name");
                    int iT3 = E8.a.t(cVarV0, "product_id");
                    int iT4 = E8.a.t(cVarV0, "product_mac");
                    int iT5 = E8.a.t(cVarV0, "normal_times");
                    int iT6 = E8.a.t(cVarV0, "mild_times");
                    int iT7 = E8.a.t(cVarV0, "bad_times");
                    int iT8 = E8.a.t(cVarV0, "unknown_times");
                    ArrayList arrayList = new ArrayList();
                    while (cVarV0.l0()) {
                        M m9 = new M();
                        m9.setUtc((int) cVarV0.getLong(iT));
                        String strO = null;
                        m9.setProductName(cVarV0.isNull(iT2) ? null : cVarV0.o(iT2));
                        m9.setProductId(cVarV0.isNull(iT3) ? null : cVarV0.o(iT3));
                        if (!cVarV0.isNull(iT4)) {
                            strO = cVarV0.o(iT4);
                        }
                        m9.setMacAddress(strO);
                        m9.setNormalTimes((int) cVarV0.getLong(iT5));
                        m9.setMildTimes((int) cVarV0.getLong(iT6));
                        m9.setBadTimes((int) cVarV0.getLong(iT7));
                        m9.setUnKnowns((int) cVarV0.getLong(iT8));
                        arrayList.add(m9);
                    }
                    return arrayList;
                } finally {
                    cVarV0.close();
                }
            }
        });
    }

    @Override // com.oplus.melody.model.db.SpineHistoryDataDao
    public final M e() {
        return (M) androidx.room.util.a.a(this.f19751a, true, false, new A9.n(12));
    }
}
