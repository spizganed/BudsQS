package com.oplus.melody.model.db;

import D7.C0368b;
import D7.C0379m;
import D7.o0;
import android.bluetooth.BluetoothAdapter;
import com.oplus.melody.common.util.C0906l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class HearingEnhancementEncryptDao extends HearingEnhancementDao {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile HearingEnhancementEncryptDao f19692d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O7.l<List<HearingEnhancementEntity>> f19693a = new O7.l<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f19694b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HearingEnhancementDao f19695c;

    private HearingEnhancementEncryptDao() {
        this.f19695c = null;
        MelodyDatabase melodyDatabaseT = MelodyDatabase.t(C0906l.f19501a);
        if (melodyDatabaseT != null) {
            this.f19695c = melodyDatabaseT.u();
        }
        HearingEnhancementDao hearingEnhancementDao = this.f19695c;
        if (hearingEnhancementDao == null) {
            return;
        }
        C0379m.i(r.a(hearingEnhancementDao.f()), new C9.a(this, 14), o0.c.f1145c);
    }

    public static HearingEnhancementEncryptDao i() {
        if (f19692d == null) {
            synchronized (HearingEnhancementEncryptDao.class) {
                try {
                    if (f19692d == null) {
                        f19692d = new HearingEnhancementEncryptDao();
                    }
                } finally {
                }
            }
        }
        return f19692d;
    }

    public static HearingEnhancementEntity j(HearingEnhancementEntity hearingEnhancementEntity) {
        HearingEnhancementEntity hearingEnhancementEntity2 = (HearingEnhancementEntity) com.oplus.melody.common.data.a.copyOf(hearingEnhancementEntity, HearingEnhancementEntity.class);
        hearingEnhancementEntity2.setAddress(r.b(hearingEnhancementEntity.getAddress()));
        return hearingEnhancementEntity2;
    }

    @Override // com.oplus.melody.model.db.w
    public final int a(List<HearingEnhancementEntity> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            list.forEach(new c8.s(1, this, arrayList));
            O7.l lVar = (O7.l) this.f19694b.get(list.get(0).getAddress());
            if (lVar != null && lVar.d() != null) {
                list.forEach(new C0368b(lVar, 17));
            }
            if (this.f19693a.d() != null) {
                list.forEach(new D7.H(this, 22));
            }
            HearingEnhancementDao hearingEnhancementDao = this.f19695c;
            if (hearingEnhancementDao != null) {
                return hearingEnhancementDao.a(arrayList);
            }
        }
        return 0;
    }

    @Override // com.oplus.melody.model.db.w
    public final long[] b(List<HearingEnhancementEntity> list) {
        int i10 = 1;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return new long[]{0};
        }
        list.forEach(new k(i10, this, arrayList));
        HearingEnhancementDao hearingEnhancementDao = this.f19695c;
        return hearingEnhancementDao != null ? hearingEnhancementDao.b(arrayList) : new long[]{0};
    }

    @Override // com.oplus.melody.model.db.HearingEnhancementDao
    public final int d(HearingEnhancementEntity hearingEnhancementEntity) {
        HearingEnhancementEntity hearingEnhancementEntityFindMatchEntity;
        HearingEnhancementEntity hearingEnhancementEntityFindMatchEntity2;
        HearingEnhancementEntity hearingEnhancementEntityJ = j(hearingEnhancementEntity);
        O7.l lVar = (O7.l) this.f19694b.get(hearingEnhancementEntity.getAddress());
        if (lVar != null && lVar.d() != null && (hearingEnhancementEntityFindMatchEntity2 = HearingEnhancementEntity.findMatchEntity((List) lVar.d(), hearingEnhancementEntity)) != null) {
            ((List) lVar.d()).remove(hearingEnhancementEntityFindMatchEntity2);
        }
        O7.l<List<HearingEnhancementEntity>> lVar2 = this.f19693a;
        if (lVar2.d() != null && (hearingEnhancementEntityFindMatchEntity = HearingEnhancementEntity.findMatchEntity(lVar2.d(), hearingEnhancementEntity)) != null) {
            lVar2.d().remove(hearingEnhancementEntityFindMatchEntity);
        }
        HearingEnhancementDao hearingEnhancementDao = this.f19695c;
        if (hearingEnhancementDao != null) {
            return hearingEnhancementDao.d(hearingEnhancementEntityJ);
        }
        return 0;
    }

    @Override // com.oplus.melody.model.db.HearingEnhancementDao
    public final int e(HearingEnhancementEntity hearingEnhancementEntity) {
        if (hearingEnhancementEntity == null) {
            return 0;
        }
        HearingEnhancementEntity hearingEnhancementEntityJ = j(hearingEnhancementEntity);
        HearingEnhancementDao hearingEnhancementDao = this.f19695c;
        if (hearingEnhancementDao != null) {
            return hearingEnhancementDao.e(hearingEnhancementEntityJ);
        }
        return 0;
    }

    @Override // com.oplus.melody.model.db.HearingEnhancementDao
    public final androidx.lifecycle.s f() {
        return this.f19693a;
    }

    @Override // com.oplus.melody.model.db.HearingEnhancementDao
    public final List<HearingEnhancementEntity> g(String str) {
        O7.l lVar = (O7.l) this.f19694b.get(str);
        if (lVar != null && lVar.d() != null) {
            return new ArrayList((Collection) lVar.d());
        }
        String strB = r.b(str);
        HearingEnhancementDao hearingEnhancementDao = this.f19695c;
        List<HearingEnhancementEntity> listG = hearingEnhancementDao != null ? hearingEnhancementDao.g(strB) : null;
        if (listG == null || listG.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        listG.forEach(new D7.H(str, 21));
        return listG;
    }

    @Override // com.oplus.melody.model.db.HearingEnhancementDao
    public final int h(HearingEnhancementEntity hearingEnhancementEntity) {
        if (!BluetoothAdapter.checkBluetoothAddress(hearingEnhancementEntity.getAddress()) || r.f(hearingEnhancementEntity.getAddress())) {
            return 0;
        }
        HearingEnhancementEntity hearingEnhancementEntityJ = j(hearingEnhancementEntity);
        HearingEnhancementDao hearingEnhancementDao = this.f19695c;
        if (hearingEnhancementDao != null) {
            return hearingEnhancementDao.h(hearingEnhancementEntityJ);
        }
        return 0;
    }
}
