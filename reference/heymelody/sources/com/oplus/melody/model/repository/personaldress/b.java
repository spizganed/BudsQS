package com.oplus.melody.model.repository.personaldress;

import A6.p;
import A9.n;
import D7.E;
import D7.S;
import D7.U;
import Ea.C0403l;
import Jb.l;
import Kb.u;
import a9.C0531H;
import android.os.Bundle;
import androidx.lifecycle.s;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.btsdk.api.data.UpgradeStateInfo;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.db.PersonalDressEntity;
import com.oplus.melody.model.repository.earphone.C0940c;
import com.oplus.melody.model.repository.earphone.C0941d;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import com.oplus.melody.model.repository.zenmode.f;
import e9.C1017a;
import e9.C1020d;
import java.io.File;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import la.D;

/* JADX INFO: compiled from: PersonalDressRepositoryClientImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Jb.b f20061p = kotlin.a.a(new A7.a(14));

    public b() {
        new ConcurrentHashMap();
    }

    public static File B(Bundle bundle) {
        Serializable serializable = bundle != null ? bundle.getSerializable("value") : null;
        if (serializable instanceof File) {
            return (File) serializable;
        }
        return null;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void A() {
        S.d(17001, null, null);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void a() {
        S.d(17017, null, null);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final PersonalDressEntity b(String address) {
        h.e(address, "address");
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            return (PersonalDressEntity) S.f(heyMelodyApplication, 17003, u.a0(new Pair("arg1", address)), new f(11));
        }
        h.i("context");
        throw null;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final String c(String address) {
        h.e(address, "address");
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            String str = (String) S.f(heyMelodyApplication, 17005, u.a0(new Pair("arg1", address)), new C0940c(27));
            return str == null ? "" : str;
        }
        h.i("context");
        throw null;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final s<String> d(String address) {
        h.e(address, "address");
        return new U(17022, com.google.android.play.core.appupdate.c.f(new Pair("arg1", address)));
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final String e(int i10, String productId, String address) {
        h.e(productId, "productId");
        h.e(address, "address");
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            String str = (String) S.f(heyMelodyApplication, 17031, kotlin.collections.a.d0(new Pair("arg1", productId), new Pair("arg2", String.valueOf(i10)), new Pair("arg3", address)), new D(3));
            return str == null ? "" : str;
        }
        h.i("context");
        throw null;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final s<CustomDressDTO> f(String productId, String colorId) {
        h.e(productId, "productId");
        h.e(colorId, "colorId");
        return new U(17027, com.google.android.play.core.appupdate.c.f(new Pair("arg1", productId), new Pair("arg2", colorId)), CustomDressDTO.class);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final s<Boolean> g() {
        return new U(17029, null);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void h(String address) {
        h.e(address, "address");
        E e10 = S.f1011a;
        S.d(17008, com.google.android.play.core.appupdate.c.f(new Pair("arg1", address)), null);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final s i(int i10, String productId) {
        h.e(productId, "productId");
        return new U(17025, com.google.android.play.core.appupdate.c.f(new Pair("arg1", productId), new Pair("arg2", Integer.valueOf(i10))));
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final CompletableFuture<l> j(PersonalDressDTO.PersonalDressData data, String productId, int i10, com.oplus.melody.model.repository.zenmode.c cVar) {
        h.e(data, "data");
        h.e(productId, "productId");
        E e10 = S.f1011a;
        CompletableFuture completableFutureThenApply = S.d(17009, com.google.android.play.core.appupdate.c.f(new Pair("arg1", data), new Pair("arg2", productId), new Pair("arg3", Integer.valueOf(i10))), com.oplus.melody.model.repository.zenmode.c.g(cVar)).thenApply((Function) new com.oplus.melody.model.repository.zenmode.e(new n(13), 8));
        h.d(completableFutureThenApply, "thenApply(...)");
        return completableFutureThenApply;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final CompletableFuture k(String productId, String str, int i10, int i11, String str2, String str3) {
        h.e(productId, "productId");
        E e10 = S.f1011a;
        CompletableFuture<U> completableFutureThenApply = S.d(17010, com.google.android.play.core.appupdate.c.f(new Pair("arg1", productId), new Pair("arg2", Integer.valueOf(i10)), new Pair("arg3", str), new Pair("arg4", str2), new Pair("arg5", str3), new Pair("arg6", 0)), null).thenApply((Function) new C0403l(new C1020d(this, 2), 27));
        h.d(completableFutureThenApply, "thenApply(...)");
        return completableFutureThenApply;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final CompletableFuture<File> l(String productId, String str, String str2, String str3) {
        h.e(productId, "productId");
        E e10 = S.f1011a;
        CompletableFuture completableFutureThenApply = S.d(17011, com.google.android.play.core.appupdate.c.f(new Pair("arg1", productId), new Pair("arg2", str), new Pair("arg3", str2), new Pair("arg4", str3)), null).thenApply((Function) new com.oplus.melody.model.repository.zenmode.e(new C0531H(this, 13), 7));
        h.d(completableFutureThenApply, "thenApply(...)");
        return completableFutureThenApply;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final CompletableFuture<File> m(String productId, String str, String str2, String str3, com.oplus.melody.model.repository.zenmode.c cVar) {
        h.e(productId, "productId");
        E e10 = S.f1011a;
        CompletableFuture completableFutureThenApply = S.d(17012, com.google.android.play.core.appupdate.c.f(new Pair("arg1", productId), new Pair("arg2", str), new Pair("arg3", str2), new Pair("arg4", str3)), com.oplus.melody.model.repository.zenmode.c.g(cVar)).thenApply((Function) new p(new C1017a(this, 2), 25));
        h.d(completableFutureThenApply, "thenApply(...)");
        return completableFutureThenApply;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final s<ToneStateInfoDTO> n() {
        return (U) this.f20061p.getValue();
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final boolean o(String address, String topic, boolean z2, boolean z4) {
        h.e(address, "address");
        h.e(topic, "topic");
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Boolean bool = (Boolean) S.f(heyMelodyApplication, 17004, kotlin.collections.a.d0(new Pair("arg1", address), new Pair("arg2", topic), new Pair("arg3", String.valueOf(z2)), new Pair("arg4", String.valueOf(z4))), new C0941d(27));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void p(boolean z2) {
        E e10 = S.f1011a;
        S.d(17030, com.google.android.play.core.appupdate.c.f(new Pair("arg1", Boolean.FALSE)), null);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void q(int i10, boolean z2, String str) {
        E e10 = S.f1011a;
        S.d(17026, com.google.android.play.core.appupdate.c.f(new Pair("arg1", str), new Pair("arg2", Integer.valueOf(i10)), new Pair("arg3", Boolean.FALSE)), null);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final CompletableFuture r(boolean z2, String productId, int i10, int i11) {
        h.e(productId, "productId");
        E e10 = S.f1011a;
        CompletableFuture<U> completableFutureThenApply = S.d(17021, com.google.android.play.core.appupdate.c.f(new Pair("arg1", productId), new Pair("arg2", Integer.valueOf(i10)), new Pair("arg3", Integer.valueOf(i11)), new Pair("arg4", Boolean.FALSE)), null).thenApply((Function) new com.oplus.melody.model.repository.zenmode.e(new n(14), 9));
        h.d(completableFutureThenApply, "thenApply(...)");
        return completableFutureThenApply;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final CompletableFuture s(String address, int i10, String productId, boolean z2) {
        h.e(address, "address");
        h.e(productId, "productId");
        E e10 = S.f1011a;
        CompletableFuture<U> completableFutureThenApply = S.d(17007, com.google.android.play.core.appupdate.c.f(new Pair("arg1", address), new Pair("arg2", productId), new Pair("arg3", Integer.valueOf(i10)), new Pair("arg4", Boolean.FALSE)), null).thenApply((Function) new C0403l(new E8.e(9), 28));
        h.d(completableFutureThenApply, "thenApply(...)");
        return completableFutureThenApply;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final CompletableFuture t(int i10, boolean z2, String productId) {
        h.e(productId, "productId");
        E e10 = S.f1011a;
        CompletableFuture<U> completableFutureThenApply = S.d(17020, com.google.android.play.core.appupdate.c.f(new Pair("arg1", productId), new Pair("arg2", Integer.valueOf(i10)), new Pair("arg3", Boolean.FALSE)), null).thenApply((Function) new C0403l(new E8.e(10), 29));
        h.d(completableFutureThenApply, "thenApply(...)");
        return completableFutureThenApply;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void u(String str, String address) {
        h.e(address, "address");
        E e10 = S.f1011a;
        S.d(17006, com.google.android.play.core.appupdate.c.f(new Pair("arg1", str), new Pair("arg2", address)), null);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void v(String address) {
        h.e(address, "address");
        E e10 = S.f1011a;
        S.d(17024, com.google.android.play.core.appupdate.c.f(new Pair("arg1", address)), null);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void w(UpgradeStateInfo transferInfo) {
        h.e(transferInfo, "transferInfo");
        E e10 = S.f1011a;
        S.d(17016, com.google.android.play.core.appupdate.c.f(new Pair("arg1", transferInfo)), null);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void x(UpgradeStateInfo transferInfo) {
        h.e(transferInfo, "transferInfo");
        E e10 = S.f1011a;
        S.d(17015, com.google.android.play.core.appupdate.c.f(new Pair("arg1", transferInfo)), null);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void y(UpgradeStateInfo transferInfo) {
        h.e(transferInfo, "transferInfo");
        E e10 = S.f1011a;
        S.d(17014, com.google.android.play.core.appupdate.c.f(new Pair("arg1", transferInfo)), null);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void z(String productId, String colorId) {
        h.e(productId, "productId");
        h.e(colorId, "colorId");
        E e10 = S.f1011a;
        S.d(17028, com.google.android.play.core.appupdate.c.f(new Pair("arg1", productId), new Pair("arg2", colorId)), null);
    }
}
