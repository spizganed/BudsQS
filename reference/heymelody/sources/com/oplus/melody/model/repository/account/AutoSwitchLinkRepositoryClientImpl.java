package com.oplus.melody.model.repository.account;

import A6.c;
import A6.d;
import A6.i;
import D7.C0388w;
import D7.E;
import D7.S;
import D7.U;
import Kb.u;
import Q7.n;
import androidx.lifecycle.s;
import com.google.gson.reflect.TypeToken;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.util.C0906l;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.a;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: AutoSwitchLinkRepositoryClientImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoSwitchLinkRepositoryClientImpl extends n {
    @Override // Q7.n
    public final String a(String address) {
        h.e(address, "address");
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            return (String) S.f(heyMelodyApplication, 22009, u.a0(new Pair("arg1", address)), new C0388w(10));
        }
        h.i("context");
        throw null;
    }

    @Override // Q7.n
    public final s<List<String>> b() {
        Type type = new TypeToken<List<? extends String>>() { // from class: com.oplus.melody.model.repository.account.AutoSwitchLinkRepositoryClientImpl$getBondAccountDeviceListLivedata$1
        }.getType();
        h.d(type, "getType(...)");
        return new U(22019, null, type);
    }

    @Override // Q7.n
    public final int c() {
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Integer num = (Integer) S.f(heyMelodyApplication, 22015, null, new C0388w(9));
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // Q7.n
    public final boolean d(String address) {
        h.e(address, "address");
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Boolean bool = (Boolean) S.f(heyMelodyApplication, 22022, u.a0(new Pair("arg1", address)), new c(11));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // Q7.n
    public final boolean e(String address) {
        h.e(address, "address");
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Boolean bool = (Boolean) S.f(heyMelodyApplication, 22007, u.a0(new Pair("arg1", address)), new i(8));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // Q7.n
    public final boolean g(String address, String accountKeyFilter, String currentSsoid) {
        h.e(address, "address");
        h.e(accountKeyFilter, "accountKeyFilter");
        h.e(currentSsoid, "currentSsoid");
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Boolean bool = (Boolean) S.f(heyMelodyApplication, 22005, a.d0(new Pair("arg1", accountKeyFilter), new Pair("arg2", currentSsoid), new Pair("arg3", address)), new d(16));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // Q7.n
    public final boolean h(String address, String accountKey, String currentSsoid) {
        h.e(address, "address");
        h.e(accountKey, "accountKey");
        h.e(currentSsoid, "currentSsoid");
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Boolean bool = (Boolean) S.f(heyMelodyApplication, 22006, a.d0(new Pair("arg1", accountKey), new Pair("arg2", currentSsoid), new Pair("arg3", address)), new i(7));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // Q7.n
    public final boolean i(String address, String accountKeyFilter, String currentSsoid) {
        h.e(address, "address");
        h.e(accountKeyFilter, "accountKeyFilter");
        h.e(currentSsoid, "currentSsoid");
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Boolean bool = (Boolean) S.f(heyMelodyApplication, 22017, a.d0(new Pair("arg1", accountKeyFilter), new Pair("arg2", currentSsoid), new Pair("arg3", address)), new i(9));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // Q7.n
    public final boolean j(String str, String str2, String str3) {
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Boolean bool = (Boolean) S.f(heyMelodyApplication, 22018, a.d0(new Pair("arg1", str2), new Pair("arg2", str3), new Pair("arg3", str)), new c(13));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // Q7.n
    public final boolean k() {
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Boolean bool = (Boolean) S.f(heyMelodyApplication, 22016, null, new C0388w(11));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // Q7.n
    public final boolean l() {
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Boolean bool = (Boolean) S.f(heyMelodyApplication, 22013, null, new c(12));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // Q7.n
    public final boolean m(String str, String str2, String str3, boolean z2) {
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Boolean bool = (Boolean) S.f(heyMelodyApplication, 22011, a.d0(new Pair("arg1", str), new Pair("arg2", String.valueOf(z2)), new Pair("arg3", str2), new Pair("arg4", str3)), new d(15));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // Q7.n
    public final boolean n(String str, String str2, String str3, boolean z2) {
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Boolean bool = (Boolean) S.f(heyMelodyApplication, 22023, a.d0(new Pair("arg1", str), new Pair("arg2", String.valueOf(z2)), new Pair("arg3", str2), new Pair("arg4", str3)), new d(17));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // Q7.n
    public final void o(String address) {
        h.e(address, "address");
        E e10 = S.f1011a;
        S.d(22021, com.google.android.play.core.appupdate.c.f(new Pair("arg1", address)), null);
    }

    @Override // Q7.n
    public final void r(int i10, boolean z2) {
        E e10 = S.f1011a;
        S.d(22014, com.google.android.play.core.appupdate.c.f(new Pair("arg1", Integer.valueOf(i10)), new Pair("arg2", Boolean.TRUE)), null);
    }

    @Override // Q7.n
    public final void s(boolean z2) {
        E e10 = S.f1011a;
        S.d(22012, com.google.android.play.core.appupdate.c.f(new Pair("arg1", Boolean.valueOf(z2))), null);
    }
}
