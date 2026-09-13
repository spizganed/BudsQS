package com.oplus.melody.model.repository.eq;

import A6.i;
import D7.E;
import D7.S;
import D7.U;
import Kb.u;
import a8.C0523a;
import a8.b;
import a8.c;
import android.os.Bundle;
import androidx.lifecycle.s;
import com.google.gson.reflect.TypeToken;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0917x;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: EqRepositoryClientImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EqRepositoryClientImpl extends c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Type f20014p = new TypeToken<List<? extends b>>() { // from class: com.oplus.melody.model.repository.eq.EqRepositoryClientImpl$mEqInfoListType$1
    }.getType();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Type f20015q = new TypeToken<C0523a>() { // from class: com.oplus.melody.model.repository.eq.EqRepositoryClientImpl$mBassEngineInfoType$1
    }.getType();

    @Override // a8.c
    public final s<C0523a> a(String address) {
        h.e(address, "address");
        Bundle bundleF = com.google.android.play.core.appupdate.c.f(new Pair("arg1", address));
        Type mBassEngineInfoType = this.f20015q;
        h.d(mBassEngineInfoType, "mBassEngineInfoType");
        return new U(10007, bundleF, mBassEngineInfoType);
    }

    @Override // a8.c
    public final List<b> b(String address) {
        h.e(address, "address");
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            return S.g(heyMelodyApplication, 10001, u.a0(new Pair("arg1", address)), new i(14));
        }
        h.i("context");
        throw null;
    }

    @Override // a8.c
    public final s<List<b>> c(String macAddress) {
        h.e(macAddress, "macAddress");
        Bundle bundleF = com.google.android.play.core.appupdate.c.f(new Pair("arg1", macAddress));
        Type mEqInfoListType = this.f20014p;
        h.d(mEqInfoListType, "mEqInfoListType");
        return new U(10006, bundleF, mEqInfoListType);
    }

    @Override // a8.c
    public final int d(String address) {
        h.e(address, "address");
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Integer num = (Integer) S.f(heyMelodyApplication, 10005, u.a0(new Pair("arg1", address)), new A6.c(19));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // a8.c
    public final void f(String address) {
        h.e(address, "address");
        E e10 = S.f1011a;
        S.d(10002, com.google.android.play.core.appupdate.c.f(new Pair("arg1", address)), null);
    }

    @Override // a8.c
    public final void g(String address) {
        h.e(address, "address");
        E e10 = S.f1011a;
        S.d(10008, com.google.android.play.core.appupdate.c.f(new Pair("arg1", address)), null);
    }

    @Override // a8.c
    public final void h(String address) {
        h.e(address, "address");
        E e10 = S.f1011a;
        S.d(10004, com.google.android.play.core.appupdate.c.f(new Pair("arg1", address)), null);
    }

    @Override // a8.c
    public final void i(int i10, b eqInfo, String address) {
        h.e(address, "address");
        h.e(eqInfo, "eqInfo");
        E e10 = S.f1011a;
        S.d(10003, com.google.android.play.core.appupdate.c.f(new Pair("arg1", address), new Pair("arg2", C0917x.i(eqInfo)), new Pair("arg3", Integer.valueOf(i10))), null);
    }
}
