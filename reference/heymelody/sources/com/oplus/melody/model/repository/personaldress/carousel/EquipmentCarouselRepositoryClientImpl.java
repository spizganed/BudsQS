package com.oplus.melody.model.repository.personaldress.carousel;

import A6.p;
import A9.n;
import D7.E;
import D7.S;
import D7.U;
import Kb.q;
import Kb.u;
import android.os.Bundle;
import android.os.Message;
import androidx.lifecycle.s;
import com.google.android.play.core.appupdate.c;
import com.google.gson.reflect.TypeToken;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.repository.earphone.C0941d;
import com.oplus.melody.model.repository.zenmode.e;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import n8.C1354b;
import n8.g;

/* JADX INFO: compiled from: EquipmentCarouselRepositoryClientImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EquipmentCarouselRepositoryClientImpl extends g {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Type f20064p = new TypeToken<EquipmentCarouselDTO>() { // from class: com.oplus.melody.model.repository.personaldress.carousel.EquipmentCarouselRepositoryClientImpl$mEquipmentCarouselType$1
    }.getType();

    @Override // n8.g
    public final CompletableFuture a(int i10, String macAddress) {
        h.e(macAddress, "macAddress");
        E e10 = S.f1011a;
        CompletableFuture<U> completableFutureThenApply = S.d(35003, c.f(new Pair("arg1", macAddress), new Pair("arg2", Integer.valueOf(i10))), null).thenApply((Function) new e(new n(16), 14));
        h.d(completableFutureThenApply, "thenApply(...)");
        return completableFutureThenApply;
    }

    @Override // n8.g
    public final ArrayList b(int i10) {
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            return q.s(S.g(heyMelodyApplication, 35005, u.a0(new Pair("arg1", String.valueOf(i10))), new C0941d(28)));
        }
        h.i("context");
        throw null;
    }

    @Override // n8.g
    public final EquipmentCarouselDTO c(String macAddress) {
        h.e(macAddress, "macAddress");
        E e10 = S.f1011a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            return (EquipmentCarouselDTO) S.f(heyMelodyApplication, 35004, u.a0(new Pair("arg1", macAddress)), new p(this, 29));
        }
        h.i("context");
        throw null;
    }

    @Override // n8.g
    public final s<EquipmentCarouselDTO> d(String macAddress) {
        h.e(macAddress, "macAddress");
        Bundle bundleF = c.f(new Pair("arg1", macAddress));
        Type mEquipmentCarouselType = this.f20064p;
        h.d(mEquipmentCarouselType, "mEquipmentCarouselType");
        return new U(35001, bundleF, mEquipmentCarouselType);
    }

    @Override // n8.g
    public final CompletableFuture e(int i10, long j5, int i11, String macAddress) {
        h.e(macAddress, "macAddress");
        E e10 = S.f1011a;
        CompletableFuture<U> completableFutureThenApply = S.d(35002, c.f(new Pair("arg1", macAddress), new Pair("arg2", Integer.valueOf(i10)), new Pair("arg3", Long.valueOf(j5)), new Pair("arg4", Integer.valueOf(i11))), null).thenApply((Function) new C1354b(new E8.e(13), 2));
        h.d(completableFutureThenApply, "thenApply(...)");
        return completableFutureThenApply;
    }

    @Override // K7.b, android.os.Handler.Callback
    public final boolean handleMessage(Message msg) {
        h.e(msg, "msg");
        return false;
    }
}
