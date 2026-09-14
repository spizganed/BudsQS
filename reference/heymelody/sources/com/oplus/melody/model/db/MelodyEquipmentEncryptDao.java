package com.oplus.melody.model.db;

import D7.C0379m;
import D7.o0;
import Ea.C0401j;
import Ea.C0403l;
import android.bluetooth.BluetoothAdapter;
import android.os.SystemClock;
import com.oplus.melody.common.util.C0906l;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes3.dex */
public class MelodyEquipmentEncryptDao extends MelodyEquipmentDao {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile MelodyEquipmentEncryptDao f19734c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O7.l<List<E>> f19735a = new O7.l<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MelodyEquipmentDao f19736b;

    private MelodyEquipmentEncryptDao() {
        this.f19736b = null;
        MelodyDatabase melodyDatabaseT = MelodyDatabase.t(C0906l.f19501a);
        if (melodyDatabaseT != null) {
            this.f19736b = melodyDatabaseT.s();
        }
        MelodyEquipmentDao melodyEquipmentDao = this.f19736b;
        if (melodyEquipmentDao == null) {
            return;
        }
        C0379m.i(r.a(melodyEquipmentDao.e()), new A6.l(this, 17), o0.c.f1145c);
    }

    public static E m(E e10) {
        E e11 = (E) com.oplus.melody.common.data.a.copyOf(e10, E.class);
        e11.setMacAddress(r.b(e10.getMacAddress()));
        return e11;
    }

    public static MelodyEquipmentEncryptDao n() {
        if (f19734c == null) {
            synchronized (MelodyEquipmentEncryptDao.class) {
                try {
                    if (f19734c == null) {
                        f19734c = new MelodyEquipmentEncryptDao();
                    }
                } finally {
                }
            }
        }
        return f19734c;
    }

    @Override // com.oplus.melody.model.db.w
    public final int a(List<E> list) {
        MelodyEquipmentDao melodyEquipmentDao = this.f19736b;
        if (melodyEquipmentDao == null || list == null || list.isEmpty()) {
            return 0;
        }
        com.oplus.melody.common.util.A.c("MelodyEquipmentEncryptDao", new C0401j(2, list));
        return melodyEquipmentDao.a((List) list.stream().map(new C0403l(this, 17)).collect(Collectors.toList()));
    }

    @Override // com.oplus.melody.model.db.w
    public final long[] b(List<E> list) {
        MelodyEquipmentDao melodyEquipmentDao = this.f19736b;
        if (melodyEquipmentDao == null || list == null || list.isEmpty()) {
            return new long[0];
        }
        com.oplus.melody.common.util.A.c("MelodyEquipmentEncryptDao", new D9.b(6, list));
        return melodyEquipmentDao.b((List) list.stream().map(new C0403l(this, 17)).collect(Collectors.toList()));
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final void d(E e10) {
        MelodyEquipmentDao melodyEquipmentDao = this.f19736b;
        if (melodyEquipmentDao == null) {
            return;
        }
        com.oplus.melody.common.util.A.c("MelodyEquipmentEncryptDao", new S7.c(e10, 26));
        melodyEquipmentDao.d(m(e10));
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final androidx.lifecycle.s<List<E>> e() {
        return this.f19735a;
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final E f(String str) {
        MelodyEquipmentDao melodyEquipmentDao = this.f19736b;
        if (melodyEquipmentDao == null) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        E eF = melodyEquipmentDao.f(BluetoothAdapter.checkBluetoothAddress(str) ? r.b(str) : str);
        if (eF != null) {
            E e10 = (E) com.oplus.melody.common.data.a.copyOf(eF, E.class);
            e10.setMacAddress(r.c(eF.getMacAddress()));
            eF = e10;
        }
        com.oplus.melody.common.util.A.c("MelodyEquipmentEncryptDao", new D(0, jElapsedRealtime, str));
        return eF;
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final void g(int i10, String str) {
        MelodyEquipmentDao melodyEquipmentDao = this.f19736b;
        if (melodyEquipmentDao == null) {
            return;
        }
        com.oplus.melody.common.util.A.c("MelodyEquipmentEncryptDao", new Aa.a(i10, str, 10));
        if (BluetoothAdapter.checkBluetoothAddress(str)) {
            str = r.b(str);
        }
        melodyEquipmentDao.g(i10, str);
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final void h(int i10, String str) {
        MelodyEquipmentDao melodyEquipmentDao = this.f19736b;
        if (melodyEquipmentDao == null) {
            return;
        }
        com.oplus.melody.common.util.A.c("MelodyEquipmentEncryptDao", new I8.s(i10, str, 3));
        if (BluetoothAdapter.checkBluetoothAddress(str)) {
            str = r.b(str);
        }
        melodyEquipmentDao.h(i10, str);
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final void i(int i10, String str) {
        MelodyEquipmentDao melodyEquipmentDao = this.f19736b;
        if (melodyEquipmentDao == null) {
            return;
        }
        com.oplus.melody.common.util.A.c("MelodyEquipmentEncryptDao", new I8.s(i10, str, 4));
        if (BluetoothAdapter.checkBluetoothAddress(str)) {
            str = r.b(str);
        }
        melodyEquipmentDao.i(i10, str);
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final void j(String str, String str2) {
        MelodyEquipmentDao melodyEquipmentDao = this.f19736b;
        if (melodyEquipmentDao == null) {
            return;
        }
        com.oplus.melody.common.util.A.c("MelodyEquipmentEncryptDao", new C(str2, str, 0));
        if (BluetoothAdapter.checkBluetoothAddress(str)) {
            str = r.b(str);
        }
        melodyEquipmentDao.j(str, str2);
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final void k(int i10, String str) {
        MelodyEquipmentDao melodyEquipmentDao = this.f19736b;
        if (melodyEquipmentDao == null) {
            return;
        }
        com.oplus.melody.common.util.A.c("MelodyEquipmentEncryptDao", new Aa.a(i10, str, 11));
        if (BluetoothAdapter.checkBluetoothAddress(str)) {
            str = r.b(str);
        }
        melodyEquipmentDao.k(i10, str);
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final int l(int i10, String str, String str2, String str3) {
        MelodyEquipmentDao melodyEquipmentDao = this.f19736b;
        if (melodyEquipmentDao == null || !BluetoothAdapter.checkBluetoothAddress(str)) {
            return 0;
        }
        com.oplus.melody.common.util.A.c("MelodyEquipmentEncryptDao", new Ca.b(str, 19));
        return melodyEquipmentDao.l(i10, r.b(str), str2, str3);
    }
}
