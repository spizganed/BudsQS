package com.oplus.melody.model.repository.multidevicesconnect;

import A6.g;
import D7.B;
import D7.C0379m;
import D7.E;
import D7.h0;
import D7.o0;
import D7.q0;
import L7.a;
import O7.l;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import androidx.lifecycle.s;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.btsdk.api.data.HandheldDeviceInfo;
import com.oplus.melody.common.helper.MelodyAlivePreferencesHelper;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.model.repository.earphone.C0940c;
import com.oplus.melody.model.repository.earphone.C0941d;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.model.repository.zenmode.f;
import g0.C1065d;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import k8.AbstractC1239a;
import k8.c;

/* JADX INFO: compiled from: MultiDevicesConnectRepositoryServerImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends AbstractC1239a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ConcurrentHashMap f20051p = new ConcurrentHashMap();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConcurrentHashMap f20052q = new ConcurrentHashMap();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ConcurrentHashMap f20053r = new ConcurrentHashMap();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ConcurrentHashMap f20054s = new ConcurrentHashMap();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final HashMap f20055t = new HashMap();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final HashMap f20056u = new HashMap();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f20057v;

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.multidevicesconnect.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MultiDevicesConnectRepositoryServerImpl.java */
    public class RunnableC0230a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f20058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MultiConnectStateDTO f20059b;

        @Override // java.lang.Runnable
        public final void run() {
            MelodyAlivePreferencesHelper.e().edit().putString(MelodyAlivePreferencesHelper.g(20, this.f20058a), C0917x.i(this.f20059b)).apply();
        }
    }

    public a() {
        Object obj = L7.a.f3010c;
        C0379m.i(a.C0032a.a().a(), new C9.a(this, 24), o0.c.f1146d);
    }

    @Override // k8.AbstractC1239a
    public final s<MultiConnectStateDTO> b(String str) {
        return (s) this.f20052q.computeIfAbsent(str, new f(8));
    }

    @Override // k8.AbstractC1239a
    public final MultiConnectStateDTO c(String str) {
        ConcurrentHashMap concurrentHashMap = this.f20052q;
        if (concurrentHashMap.get(str) != null) {
            return (MultiConnectStateDTO) ((l) concurrentHashMap.get(str)).d();
        }
        return null;
    }

    @Override // k8.AbstractC1239a
    public final CompletableFuture e(String str, int i10, String str2, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            c cVar = new c(str, i10, str2, z2);
            return (CompletableFuture) this.f20051p.compute(C1065d.c(str, "_1065"), new B(cVar, 6));
        }
        A.h("MultiDevicesConnectRepository", "operateMultiConnectHandheldDevice earphoneAddress is null!");
        if (this.f20057v == null) {
            this.f20057v = q0.b(MelodyException.e(0, "Invalid address"));
        }
        return this.f20057v;
    }

    @Override // k8.AbstractC1239a
    public final void f(String str) {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        g.i(heyMelodyApplication, 1047, "param_address", str, heyMelodyApplication);
    }

    @Override // k8.AbstractC1239a
    public final void g(String str, boolean z2) {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1087);
        intentU.putExtra("param_address", str);
        intentU.putExtra("param_value", z2);
        com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
    }

    @Override // k8.AbstractC1239a
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final l<HandheldDeviceInfo> d(String str, boolean z2) {
        return z2 ? (l) this.f20054s.computeIfAbsent(str, new C0940c(21)) : (l) this.f20053r.computeIfAbsent(str, new C0941d(20));
    }

    @Override // K7.b, android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Bundle data = message.getData();
        switch (message.what) {
            case 12001:
                E e10 = h0.f1099c;
                h0.i(message, b(data.getString("macAddress")));
                break;
            case 12002:
                f(data.getString("arg1"));
                h0.h(message, null);
                break;
            case 12003:
                E e11 = h0.f1099c;
                h0.i(message, d(data.getString("macAddress"), data.getBoolean("value")));
                break;
            case 12004:
                g(data.getString("macAddress"), data.getBoolean("value"));
                h0.h(message, null);
                break;
            case 12005:
                E e12 = h0.f1099c;
                int i10 = data.getInt("arg3");
                h0.c(message, e(data.getString("macAddress"), i10, data.getString("arg2"), data.getBoolean("arg1")));
                break;
        }
        return true;
    }
}
