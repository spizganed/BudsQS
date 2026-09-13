package com.oplus.melody.model.repository.personaldress.carousel;

import A6.p;
import C7.d;
import D7.E;
import D7.G;
import D7.S;
import D7.U;
import E8.e;
import android.os.Bundle;
import android.os.Message;
import androidx.lifecycle.s;
import com.google.android.play.core.appupdate.c;
import com.google.gson.reflect.TypeToken;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.repository.earphone.C0940c;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.collections.a;
import kotlin.jvm.internal.h;
import n8.AbstractC1353a;
import n8.C1354b;

/* JADX INFO: compiled from: CarouselDressRepositoryClientImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CarouselDressRepositoryClientImpl extends AbstractC1353a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Type f20063p = new TypeToken<List<? extends CarouselDressDTO>>() { // from class: com.oplus.melody.model.repository.personaldress.carousel.CarouselDressRepositoryClientImpl$mCarouselDressListType$1
    }.getType();

    @Override // n8.AbstractC1353a
    public final CompletableFuture<Boolean> a(int i10) {
        E e10 = S.f1011a;
        CompletableFuture completableFutureThenApply = S.d(34004, c.f(new Pair("arg1", Integer.valueOf(i10))), null).thenApply((Function) new Aa.c(new d(7), 25));
        h.d(completableFutureThenApply, "thenApply(...)");
        return completableFutureThenApply;
    }

    @Override // n8.AbstractC1353a
    public final List b(int i10, String productId) {
        h.e(productId, "productId");
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            List list = (List) S.f(heyMelodyApplication, 34006, a.d0(new Pair("arg1", productId), new Pair("arg2", String.valueOf(i10))), new p(this, 27));
            return list == null ? EmptyList.f25350a : list;
        }
        h.i("context");
        throw null;
    }

    @Override // n8.AbstractC1353a
    public final s c(int i10, String productId) {
        h.e(productId, "productId");
        Bundle bundleF = c.f(new Pair("arg1", productId), new Pair("arg2", Integer.valueOf(i10)));
        Type mCarouselDressListType = this.f20063p;
        h.d(mCarouselDressListType, "mCarouselDressListType");
        return new U(34001, bundleF, mCarouselDressListType);
    }

    @Override // n8.AbstractC1353a
    public final CompletableFuture d(int i10, String productId, String themeId) {
        h.e(productId, "productId");
        h.e(themeId, "themeId");
        E e10 = S.f1011a;
        CompletableFuture<U> completableFutureThenApply = S.d(34007, c.f(new Pair("arg1", productId), new Pair("arg2", Integer.valueOf(i10)), new Pair("arg3", themeId)), null).thenApply((Function) new C0940c(new G(15)));
        h.d(completableFutureThenApply, "thenApply(...)");
        return completableFutureThenApply;
    }

    @Override // n8.AbstractC1353a
    public final CompletableFuture<Integer> e(String productId, int i10, String str, int i11, List<String> list) {
        h.e(productId, "productId");
        E e10 = S.f1011a;
        CompletableFuture completableFutureThenApply = S.d(34002, c.f(new Pair("arg1", productId), new Pair("arg2", Integer.valueOf(i10)), new Pair("arg3", str), new Pair("arg4", Integer.valueOf(i11)), new Pair("arg5", new ArrayList(list))), null).thenApply((Function) new C1354b(new e(12), 0));
        h.d(completableFutureThenApply, "thenApply(...)");
        return completableFutureThenApply;
    }

    @Override // K7.b, android.os.Handler.Callback
    public final boolean handleMessage(Message msg) {
        h.e(msg, "msg");
        return false;
    }
}
