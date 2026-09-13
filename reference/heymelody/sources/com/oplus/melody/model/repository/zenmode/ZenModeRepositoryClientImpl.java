package com.oplus.melody.model.repository.zenmode;

import D7.E;
import D7.S;
import D7.U;
import android.os.Bundle;
import com.google.gson.reflect.TypeToken;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.db.C0928l;
import com.oplus.melody.model.db.N;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import com.oplus.melody.model.repository.earphone.C0940c;
import com.oplus.melody.model.repository.earphone.C0941d;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public final class ZenModeRepositoryClientImpl extends ZenModeRepository {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f20158s = 0;

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.zenmode.ZenModeRepositoryClientImpl$1, reason: invalid class name */
    public class AnonymousClass1 extends TypeToken<Map<String, Boolean>> {
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void A(String str, ZenModeInfoDO zenModeInfoDO, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("arg1", str);
        bundle.putParcelable("arg2", zenModeInfoDO);
        bundle.putString("arg3", str2);
        S.d(6013, bundle, null);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void B(int i10, String str, String str2, String str3) {
        Bundle bundleE = androidx.appcompat.widget.a.e("arg1", str, "arg2", str2);
        bundleE.putString("arg3", str3);
        bundleE.putInt("arg4", i10);
        S.d(6006, bundleE, null);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void C(String str, String str2) {
        S.d(6014, androidx.appcompat.widget.a.e("arg1", str, "arg2", str2), null);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void D() {
        S.d(6005, null, null);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final CompletableFuture a(c cVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("arg1", str);
        E e10 = S.f1011a;
        return S.d(6022, bundle, c.g(cVar)).thenApply((Function) new C0941d(15));
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("arg1", str);
        S.d(6007, bundle, null);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void c(String str, String str2, String str3) {
        Bundle bundleE = androidx.appcompat.widget.a.e("arg1", str, "arg2", str2);
        bundleE.putString("arg3", str3);
        S.d(6018, bundleE, null);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final CompletableFuture<ZenModeInfoDO> d(ZenModeInfoDO zenModeInfoDO, String str, c cVar) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg1", zenModeInfoDO);
        bundle.putString("arg2", str);
        E e10 = S.f1011a;
        return S.d(6010, bundle, c.g(cVar)).thenApply((Function) new C0940c(14));
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final CompletableFuture<?> e(ZenModeInfoDO zenModeInfoDO, c cVar) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg1", zenModeInfoDO);
        E e10 = S.f1011a;
        return S.d(6001, bundle, c.g(cVar));
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final androidx.lifecycle.s<ZenModeInfoDO> f(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("arg1", str);
        return new U(6011, bundle, ZenModeInfoDO.class);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final androidx.lifecycle.s<Map<String, Boolean>> h() {
        return new U(6020, null, new AnonymousClass1().getType());
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final androidx.lifecycle.s<d> i(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("arg1", str);
        return new U(6003, bundle, d.class);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final androidx.lifecycle.s<ZenModePlayStateDTO> k(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("arg1", str);
        return new U(6012, bundle, ZenModePlayStateDTO.class);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final CompletableFuture m(int i10, String str) {
        Bundle bundleD = A6.e.d(i10, "arg1", str, "arg2");
        E e10 = S.f1011a;
        return S.h(6009, bundleD, ZenModeRepository.f20156q);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final androidx.lifecycle.s<SoundCacheCleanEvent> q() {
        return new U(6017, null, SoundCacheCleanEvent.class);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final CompletableFuture<List<ZenModeInfoDO>> s(String str, String str2, String str3) {
        Bundle bundleE = androidx.appcompat.widget.a.e("arg1", str, "arg2", str2);
        bundleE.putString("arg3", str3);
        E e10 = S.f1011a;
        return S.h(6002, bundleE, ZenModeRepository.f20156q);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final List<N> u(String str, String str2) {
        androidx.collection.a aVar = new androidx.collection.a();
        aVar.put("arg1", str);
        aVar.put("arg2", str2);
        E e10 = S.f1011a;
        return S.g(C0906l.f19501a, 6008, aVar, new C0928l(22));
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void v() {
        S.d(6004, null, null);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void w(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("arg1", str);
        S.d(6023, bundle, null);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void x() {
        S.d(6019, null, null);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void y(String str, String str2) {
        S.d(6015, androidx.appcompat.widget.a.e("arg1", str, "arg2", str2), null);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void z(ZenModeInfoDO zenModeInfoDO, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg1", zenModeInfoDO);
        bundle.putString("arg2", "melody-model-sound");
        S.d(6021, bundle, null);
    }
}
