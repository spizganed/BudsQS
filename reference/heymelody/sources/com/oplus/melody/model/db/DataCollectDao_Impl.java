package com.oplus.melody.model.db;

import D7.C0374h;
import com.oplus.drs.core.provider.DcsCompatEventConverter;
import java.util.ArrayList;
import java.util.List;
import q1.InterfaceC1431a;

/* JADX INFO: loaded from: classes3.dex */
public final class DataCollectDao_Impl extends DataCollectDao {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f19683c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MelodyDatabase_Impl f19684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f19685b = new p(0);

    public DataCollectDao_Impl(MelodyDatabase_Impl melodyDatabase_Impl) {
        this.f19684a = melodyDatabase_Impl;
    }

    @Override // com.oplus.melody.model.db.w
    public final long[] b(List<DataCollectEntity> list) {
        return (long[]) androidx.room.util.a.a(this.f19684a, false, true, new C0374h(9, this, list));
    }

    @Override // com.oplus.melody.model.db.DataCollectDao
    public final void d(final long j5) {
        androidx.room.util.a.a(this.f19684a, false, true, new Wb.l() { // from class: com.oplus.melody.model.db.o
            @Override // Wb.l
            public final Object d(Object obj) throws Exception {
                long j9 = j5;
                q1.c cVarV0 = ((InterfaceC1431a) obj).v0("DELETE FROM data_collect WHERE time < ?");
                try {
                    cVarV0.h(1, j9);
                    cVarV0.l0();
                    cVarV0.close();
                    return null;
                } catch (Throwable th) {
                    cVarV0.close();
                    throw th;
                }
            }
        });
    }

    @Override // com.oplus.melody.model.db.DataCollectDao
    public final List<DataCollectEntity> e(final int i10, final long j5, final long j9) {
        return (List) androidx.room.util.a.a(this.f19684a, true, false, new Wb.l() { // from class: com.oplus.melody.model.db.n
            @Override // Wb.l
            public final Object d(Object obj) throws Exception {
                int i11 = i10;
                long j10 = j5;
                long j11 = j9;
                q1.c cVarV0 = ((InterfaceC1431a) obj).v0("SELECT * FROM data_collect WHERE dataType = ? AND time > ? AND time < ? ORDER BY time ASC");
                try {
                    cVarV0.h(1, i11);
                    cVarV0.h(2, j10);
                    cVarV0.h(3, j11);
                    int iT = E8.a.t(cVarV0, "id");
                    int iT2 = E8.a.t(cVarV0, DcsCompatEventConverter.KEY_DATA_TYPE);
                    int iT3 = E8.a.t(cVarV0, "time");
                    int iT4 = E8.a.t(cVarV0, "dataContentType");
                    int iT5 = E8.a.t(cVarV0, "dataContent");
                    ArrayList arrayList = new ArrayList();
                    while (cVarV0.l0()) {
                        DataCollectEntity dataCollectEntity = new DataCollectEntity();
                        dataCollectEntity.setId((int) cVarV0.getLong(iT));
                        dataCollectEntity.setMDataType((int) cVarV0.getLong(iT2));
                        dataCollectEntity.setMTime(cVarV0.getLong(iT3));
                        dataCollectEntity.setMDataContentType((int) cVarV0.getLong(iT4));
                        dataCollectEntity.setMDataContent(cVarV0.isNull(iT5) ? null : cVarV0.o(iT5));
                        arrayList.add(dataCollectEntity);
                    }
                    return arrayList;
                } finally {
                    cVarV0.close();
                }
            }
        });
    }
}
