package com.oplus.melody.model.db;

import D7.C0374h;
import java.util.List;
import q1.InterfaceC1431a;

/* JADX INFO: loaded from: classes3.dex */
public final class ConnectedDeviceDao_Impl extends ConnectedDeviceDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MelodyDatabase_Impl f19672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0926i f19673b = new C0926i(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0927j f19674c = new C0927j(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0923e f19675d = new C0923e(1);

    public ConnectedDeviceDao_Impl(MelodyDatabase_Impl melodyDatabase_Impl) {
        this.f19672a = melodyDatabase_Impl;
    }

    @Override // com.oplus.melody.model.db.w
    public final long[] b(List<C0929m> list) {
        return (long[]) androidx.room.util.a.a(this.f19672a, false, true, new J8.e(10, this, list));
    }

    @Override // com.oplus.melody.model.db.ConnectedDeviceDao
    public final int d(C0929m c0929m) {
        return ((Integer) androidx.room.util.a.a(this.f19672a, false, true, new C0925g(this, c0929m, 1))).intValue();
    }

    @Override // com.oplus.melody.model.db.ConnectedDeviceDao
    public final int e() {
        return ((Integer) androidx.room.util.a.a(this.f19672a, true, false, new D7.G(13))).intValue();
    }

    @Override // com.oplus.melody.model.db.ConnectedDeviceDao
    public final int f(C0929m c0929m) {
        return ((Integer) androidx.room.util.a.a(this.f19672a, false, true, new C0925g(this, c0929m, 0))).intValue();
    }

    @Override // com.oplus.melody.model.db.ConnectedDeviceDao
    public final androidx.lifecycle.s<List<C0929m>> g() {
        return this.f19672a.d().b(new String[]{"connected_device"}, new D7.G(12));
    }

    @Override // com.oplus.melody.model.db.ConnectedDeviceDao
    public final int h(C0929m c0929m) {
        return ((Integer) androidx.room.util.a.a(this.f19672a, false, true, new C0374h(8, this, c0929m))).intValue();
    }

    @Override // com.oplus.melody.model.db.ConnectedDeviceDao
    public final void i(final String str, final long j5) {
        androidx.room.util.a.a(this.f19672a, false, true, new Wb.l() { // from class: com.oplus.melody.model.db.h
            @Override // Wb.l
            public final Object d(Object obj) throws Exception {
                long j9 = j5;
                q1.c cVarV0 = ((InterfaceC1431a) obj).v0("UPDATE connected_device SET time = ? WHERE mac_address = ?");
                try {
                    cVarV0.h(1, j9);
                    String str2 = str;
                    if (str2 == null) {
                        cVarV0.a(2);
                    } else {
                        cVarV0.V(2, str2);
                    }
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
}
