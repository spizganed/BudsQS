package com.oplus.melody.ui.component.detail;

import A6.c;
import A6.e;
import A6.f;
import A6.i;
import A6.j;
import D7.C0379m;
import D7.q0;
import L8.X;
import O7.l;
import O7.m;
import Q7.b;
import V7.a;
import V7.g;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.media3.session.D0;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import com.oplus.melody.ui.base.DetailBaseViewModel;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import i8.AbstractC1148a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import l9.C1286a;
import s8.AbstractC1508a;

/* JADX INFO: loaded from: classes3.dex */
public final class DetailMainViewModel extends DetailBaseViewModel {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WeakReference<FragmentManager> f20596k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f20597l;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l<g> f20593g = new l<>();
    public final l<PersonalDressDTO> h = new l<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l<String> f20594i = new l<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l<Integer> f20595j = new l<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f20598m = false;

    public static t g(String str) {
        return C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new e(13)));
    }

    public static String l() {
        int i10 = b.f4152c;
        return (String) Optional.ofNullable(b.a.a()).map(new i(3)).orElse(null);
    }

    public static void p(String str, String str2, String str3) {
        WhitelistConfigDTO.Function function;
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(str2, str3);
        if (whitelistConfigDTOC == null || (function = whitelistConfigDTOC.getFunction()) == null) {
            return;
        }
        int highToneQuality = function.getHighToneQuality();
        if (highToneQuality == 1 || highToneQuality == 2 || Y.e(function.getHighAudio(), false)) {
            AbstractC0939b.E().t(str);
        }
    }

    public final s<List<Integer>> f(String str) {
        return C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new A6.b(10)));
    }

    public final int h() {
        Integer numD = this.f20595j.d();
        if (numD == null) {
            return 0;
        }
        return numD.intValue();
    }

    public final EarphoneDTO i(String str) {
        return AbstractC0939b.E().w(str);
    }

    public final FragmentManager j() {
        WeakReference<FragmentManager> weakReference = this.f20596k;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final s<String> k() {
        int i10 = AbstractC1148a.f24096c;
        return (s) Optional.ofNullable(AbstractC1148a.C0266a.a()).map(new c(9)).orElseGet(new j(0));
    }

    public final t m(String str) {
        return C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new f(11)));
    }

    public final s<C1286a> n(String str) {
        return C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new A6.g(11)));
    }

    public final void o(final int i10, final String str) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (A.l()) {
            StringBuilder sbG = D0.g(i10, "requestAllSource, productId: ", str, ", colorId: ", ", network isConnected: ");
            sbG.append(m.b());
            A.b("DetailMainViewModel", sbG.toString());
        }
        CompletableFuture.runAsync(new Runnable() { // from class: L8.W
            @Override // java.lang.Runnable
            public final void run() {
                final DetailMainViewModel detailMainViewModel = this.f3105a;
                detailMainViewModel.getClass();
                Object obj = V7.a.f5396c;
                V7.a aVarA = a.C0074a.a();
                final String str2 = str;
                final int i11 = i10;
                V7.g gVarC = aVarA.c(i11, str2);
                com.oplus.melody.common.util.A.c("DetailMainViewModel", new Z(i11, 0, gVarC, str2));
                if (gVarC != null) {
                    detailMainViewModel.f20593g.m(gVarC);
                }
                final long j5 = jCurrentTimeMillis;
                if (gVarC == null || (TextUtils.isEmpty(gVarC.getModelFilePath()) && TextUtils.isEmpty(gVarC.getWebpFilePath()))) {
                    new q0(a.C0074a.a().b(i11, str2).whenComplete(new BiConsumer() { // from class: L8.a0
                        @Override // java.util.function.BiConsumer
                        public final void accept(Object obj2, Object obj3) {
                            final V7.g gVar = (V7.g) obj2;
                            DetailMainViewModel detailMainViewModel2 = detailMainViewModel;
                            detailMainViewModel2.getClass();
                            final int i12 = i11;
                            final long j9 = j5;
                            final String str3 = str2;
                            com.oplus.melody.common.util.A.c("DetailMainViewModel", new Supplier() { // from class: L8.e0
                                @Override // java.util.function.Supplier
                                public final Object get() {
                                    return "requestAllSource.downloadSource ok, productId: " + str3 + ", colorId: " + i12 + ", time: " + (System.currentTimeMillis() - j9) + ", source: " + gVar;
                                }
                            });
                            detailMainViewModel2.f20593g.m(gVar);
                        }
                    }), 1L, TimeUnit.SECONDS).whenComplete(new BiConsumer() { // from class: L8.b0
                        @Override // java.util.function.BiConsumer
                        public final void accept(Object obj2, Object obj3) {
                            V7.g gVar = (V7.g) obj2;
                            final DetailMainViewModel detailMainViewModel2 = detailMainViewModel;
                            detailMainViewModel2.getClass();
                            com.oplus.melody.common.util.A.x("DetailMainViewModel", "requestAllSource.whenComplete source: " + gVar + ", error: " + ((Throwable) obj3));
                            if (gVar != null) {
                                return;
                            }
                            Object obj4 = V7.a.f5396c;
                            V7.a aVarA2 = a.C0074a.a();
                            final String str3 = str2;
                            final int i12 = i11;
                            CompletableFuture completableFutureA = aVarA2.a(i12, str3);
                            final long j9 = j5;
                            completableFutureA.whenComplete(new BiConsumer() { // from class: L8.f0
                                @Override // java.util.function.BiConsumer
                                public final void accept(Object obj5, Object obj6) {
                                    V7.g gVar2 = (V7.g) obj5;
                                    DetailMainViewModel detailMainViewModel3 = detailMainViewModel2;
                                    detailMainViewModel3.getClass();
                                    com.oplus.melody.common.util.A.c("DetailMainViewModel", new d0(str3, i12, j9, gVar2, 1));
                                    detailMainViewModel3.f20593g.m(gVar2);
                                }
                            });
                        }
                    });
                } else if (TextUtils.isEmpty(gVarC.getPicFilePath())) {
                    a.C0074a.a().a(i11, str2).whenComplete(new BiConsumer() { // from class: L8.c0
                        @Override // java.util.function.BiConsumer
                        public final void accept(Object obj2, Object obj3) {
                            V7.g gVar = (V7.g) obj2;
                            DetailMainViewModel detailMainViewModel2 = detailMainViewModel;
                            detailMainViewModel2.getClass();
                            com.oplus.melody.common.util.A.c("DetailMainViewModel", new d0(str2, i11, j5, gVar, 0));
                            detailMainViewModel2.f20593g.m(gVar);
                        }
                    });
                }
            }
        });
        CompletableFuture.runAsync(new X(this, str, i10, jCurrentTimeMillis));
    }

    public final void q(int i10, int i11) {
        l<Integer> lVar = this.f20595j;
        Integer numD = lVar.d();
        if (numD == null) {
            numD = 0;
        }
        int iIntValue = (i10 & i11) | (numD.intValue() & (~i10));
        A.c("DetailMainViewModel", new D7.Y(iIntValue, 8));
        lVar.m(Integer.valueOf(iIntValue));
    }
}
