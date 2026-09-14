package com.oplus.melody.model.db;

import D7.C0372f;
import android.content.Context;
import androidx.room.RoomDatabase;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.util.S;
import java.util.ArrayList;
import r1.InterfaceC1460b;

/* JADX INFO: compiled from: MelodyDatabase.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends RoomDatabase.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HeyMelodyApplication f19790a;

    public x(HeyMelodyApplication heyMelodyApplication) {
        this.f19790a = heyMelodyApplication;
    }

    @Override // androidx.room.RoomDatabase.b
    public final void a(InterfaceC1460b interfaceC1460b) {
        super.a(interfaceC1460b);
        com.oplus.melody.common.util.A.b("MelodyDatabase", "onCreate: db create");
        Context applicationContext = this.f19790a.getApplicationContext();
        ArrayList arrayList = M7.b.f3323a;
        boolean zS = S.s(applicationContext);
        ArrayList arrayList2 = M7.b.f3323a;
        if (zS) {
            com.oplus.melody.common.util.A.b("DataMigrateHelper", "startDataMigrate: isHeyMelody");
            arrayList2.add(new M7.c());
            arrayList2.add(new M7.d());
        } else {
            com.oplus.melody.common.util.A.b("DataMigrateHelper", "startDataMigrate: not hey melody ");
            arrayList2.add(new M7.f());
            arrayList2.add(new M7.h());
        }
        com.oplus.melody.common.util.A.c("DataMigrateHelper", new C0372f(3));
        arrayList2.forEach(new D7.H(applicationContext, 10));
    }
}
