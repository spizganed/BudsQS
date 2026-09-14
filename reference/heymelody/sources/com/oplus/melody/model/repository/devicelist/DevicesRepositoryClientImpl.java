package com.oplus.melody.model.repository.devicelist;

import A6.d;
import D7.C0388w;
import D7.E;
import D7.S;
import D7.U;
import Kb.u;
import X7.b;
import androidx.lifecycle.s;
import com.google.android.play.core.appupdate.c;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.util.C0906l;
import java.util.List;
import kotlin.Pair;
import kotlin.a;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: DevicesRepositoryClientImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DevicesRepositoryClientImpl extends b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Jb.b f19858p = a.a(new A7.a(10));

    @Override // X7.b
    public final void a(String address) {
        h.e(address, "address");
        E e10 = S.f1011a;
        S.d(13005, c.f(new Pair("arg1", address)), null);
    }

    @Override // X7.b
    public final int b() {
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Integer num = (Integer) S.f(heyMelodyApplication, 13002, null, new C0388w(16));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // X7.b
    public final s<List<X7.a>> c() {
        return (U) this.f19858p.getValue();
    }

    @Override // X7.b
    public final void d(String address, String str, String str2, String str3) {
        h.e(address, "address");
        E e10 = S.f1011a;
        S.d(13006, c.f(new Pair("arg1", address), new Pair("arg2", str), new Pair("arg3", str2), new Pair("arg4", str3)), null);
    }

    @Override // X7.b
    public final boolean e(String macAddress) {
        h.e(macAddress, "macAddress");
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Boolean bool = (Boolean) S.f(heyMelodyApplication, 13004, u.a0(new Pair("arg1", macAddress)), new d(23));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // X7.b
    public final void f(String macAddress, long j5) {
        h.e(macAddress, "macAddress");
        E e10 = S.f1011a;
        S.d(13003, c.f(new Pair("arg1", macAddress), new Pair("arg2", Long.valueOf(j5))), null);
    }
}
