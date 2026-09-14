package com.oplus.melody.model.db;

import D7.C0378l;
import b9.C0737f;
import java.util.List;
import q1.InterfaceC1431a;

/* JADX INFO: loaded from: classes3.dex */
public final class MelodyEquipmentDao_Impl extends MelodyEquipmentDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MelodyDatabase_Impl f19731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0926i f19732b = new C0926i(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0927j f19733c = new C0927j(1);

    public MelodyEquipmentDao_Impl(MelodyDatabase_Impl melodyDatabase_Impl) {
        this.f19731a = melodyDatabase_Impl;
    }

    public static /* synthetic */ Jb.l m(MelodyEquipmentDao_Impl melodyEquipmentDao_Impl, E e10) {
        super.d(e10);
        return Jb.l.f2618a;
    }

    @Override // com.oplus.melody.model.db.w
    public final int a(List<E> list) {
        return ((Integer) androidx.room.util.a.a(this.f19731a, false, true, new J8.e(11, this, list))).intValue();
    }

    @Override // com.oplus.melody.model.db.w
    public final long[] b(List<E> list) {
        return (long[]) androidx.room.util.a.a(this.f19731a, false, true, new C0378l(4, this, list));
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final void d(E e10) {
        androidx.room.util.a.a(this.f19731a, false, true, new I8.m(6, this, e10));
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final androidx.lifecycle.s<List<E>> e() {
        return this.f19731a.d().b(new String[]{"melody_equipment"}, new E8.e(7));
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final E f(String str) {
        return (E) androidx.room.util.a.a(this.f19731a, true, false, new C0737f(str, 1));
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final void g(int i10, String str) {
        androidx.room.util.a.a(this.f19731a, false, true, new I8.q(i10, str, 1));
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final void h(int i10, String str) {
        androidx.room.util.a.a(this.f19731a, false, true, new I8.q(i10, str, 2));
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final void i(int i10, String str) {
        androidx.room.util.a.a(this.f19731a, false, true, new C0920b(i10, str));
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final void j(String str, String str2) {
        androidx.room.util.a.a(this.f19731a, false, true, new z(str2, str, 0));
    }

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final void k(final int i10, final String str) {
        androidx.room.util.a.a(this.f19731a, false, true, new Wb.l() { // from class: com.oplus.melody.model.db.A
            @Override // Wb.l
            public final Object d(Object obj) throws Exception {
                int i11 = i10;
                q1.c cVarV0 = ((InterfaceC1431a) obj).v0("UPDATE melody_equipment SET reconnectPopupSwitch = ? WHERE macAddress = ?");
                try {
                    cVarV0.h(1, i11);
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

    @Override // com.oplus.melody.model.db.MelodyEquipmentDao
    public final int l(int i10, String str, String str2, String str3) {
        return ((Integer) androidx.room.util.a.a(this.f19731a, false, true, new B(str2, str3, i10, str))).intValue();
    }
}
