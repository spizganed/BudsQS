package com.oplus.melody.model.db;

import D7.C0379m;
import D7.o0;
import android.bluetooth.BluetoothAdapter;
import com.oplus.melody.common.util.C0906l;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectedDeviceEncryptDao extends ConnectedDeviceDao {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile ConnectedDeviceEncryptDao f19676d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O7.l<List<C0929m>> f19677a = new O7.l<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f19678b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConnectedDeviceDao f19679c;

    private ConnectedDeviceEncryptDao() {
        this.f19679c = null;
        MelodyDatabase melodyDatabaseT = MelodyDatabase.t(C0906l.f19501a);
        if (melodyDatabaseT != null) {
            this.f19679c = melodyDatabaseT.p();
        }
        ConnectedDeviceDao connectedDeviceDao = this.f19679c;
        if (connectedDeviceDao == null) {
            return;
        }
        C0379m.i(r.a(connectedDeviceDao.g()), new A6.l(this, 15), o0.c.f1145c);
    }

    public static ConnectedDeviceEncryptDao j() {
        if (f19676d == null) {
            synchronized (ConnectedDeviceEncryptDao.class) {
                try {
                    if (f19676d == null) {
                        f19676d = new ConnectedDeviceEncryptDao();
                    }
                } finally {
                }
            }
        }
        return f19676d;
    }

    public static C0929m k(C0929m c0929m) {
        C0929m c0929m2 = (C0929m) c0929m.clone();
        c0929m2.setMacAddress(r.b(c0929m.getMacAddress()));
        return c0929m2;
    }

    @Override // com.oplus.melody.model.db.w
    public final long[] b(List<C0929m> list) {
        int i10 = 0;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return new long[]{0};
        }
        list.forEach(new k(i10, this, arrayList));
        ConnectedDeviceDao connectedDeviceDao = this.f19679c;
        return connectedDeviceDao != null ? connectedDeviceDao.b(arrayList) : new long[]{0};
    }

    @Override // com.oplus.melody.model.db.ConnectedDeviceDao
    public final int d(C0929m c0929m) {
        C0929m c0929mK = k(c0929m);
        ConnectedDeviceDao connectedDeviceDao = this.f19679c;
        if (connectedDeviceDao != null) {
            return connectedDeviceDao.d(c0929mK);
        }
        return 0;
    }

    @Override // com.oplus.melody.model.db.ConnectedDeviceDao
    public final int e() {
        ConnectedDeviceDao connectedDeviceDao = this.f19679c;
        if (connectedDeviceDao != null) {
            return connectedDeviceDao.e();
        }
        return 0;
    }

    @Override // com.oplus.melody.model.db.ConnectedDeviceDao
    public final int f(C0929m c0929m) {
        C0929m c0929mK = k(c0929m);
        ConnectedDeviceDao connectedDeviceDao = this.f19679c;
        if (connectedDeviceDao != null) {
            return connectedDeviceDao.f(c0929mK);
        }
        return 0;
    }

    @Override // com.oplus.melody.model.db.ConnectedDeviceDao
    public final androidx.lifecycle.s<List<C0929m>> g() {
        return this.f19677a;
    }

    @Override // com.oplus.melody.model.db.ConnectedDeviceDao
    public final int h(C0929m c0929m) {
        if (!BluetoothAdapter.checkBluetoothAddress(c0929m.getMacAddress())) {
            return 0;
        }
        C0929m c0929mK = k(c0929m);
        ConnectedDeviceDao connectedDeviceDao = this.f19679c;
        if (connectedDeviceDao != null) {
            return connectedDeviceDao.h(c0929mK);
        }
        return 0;
    }

    @Override // com.oplus.melody.model.db.ConnectedDeviceDao
    public final void i(String str, long j5) {
        if (!BluetoothAdapter.checkBluetoothAddress(str) || r.f(str)) {
            return;
        }
        String strB = r.b(str);
        ConnectedDeviceDao connectedDeviceDao = this.f19679c;
        if (connectedDeviceDao != null) {
            connectedDeviceDao.i(strB, j5);
        }
    }
}
