package com.oplus.melody.app.discovery;

import D7.o0;
import android.text.TextUtils;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.bluetooth.OplusA2dpSharingStateCallback;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.ui.base.BaseViewModel;
import f8.AbstractC1048a;
import g0.C1065d;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import kc.C1264t;

/* JADX INFO: loaded from: classes.dex */
public final class DiscoveryDialogViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.u<b> f18883b = new androidx.lifecycle.u<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f18884c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f18885d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap f18886e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.lifecycle.u<Map<String, Boolean>> f18887f = new androidx.lifecycle.u<>(new HashMap());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18888g = false;
    public boolean h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f18889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f18890j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f18891k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public D0 f18892l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f18893m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f18894n;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.lifecycle.t<E0> f18895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference<E0> f18896b;

        public a(androidx.lifecycle.t<E0> tVar) {
            this.f18895a = tVar;
            this.f18896b = new AtomicReference<>(tVar.d());
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        
            com.oplus.melody.common.util.A.x("DiscoveryDialogViewModel", "computeAndSetValue retryCount=" + r0);
            r0 = r0 + 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(java.util.function.Function<com.oplus.melody.app.discovery.E0, com.oplus.melody.app.discovery.E0> r7) {
            /*
                r6 = this;
                r0 = 0
            L1:
                r1 = 2
                java.lang.String r2 = "DiscoveryDialogViewModel"
                if (r0 >= r1) goto L40
                java.util.concurrent.atomic.AtomicReference<com.oplus.melody.app.discovery.E0> r1 = r6.f18896b
                java.lang.Object r3 = r1.get()
                com.oplus.melody.app.discovery.E0 r3 = (com.oplus.melody.app.discovery.E0) r3
                java.lang.Object r4 = r7.apply(r3)
                com.oplus.melody.app.discovery.E0 r4 = (com.oplus.melody.app.discovery.E0) r4
            L14:
                boolean r5 = r1.compareAndSet(r3, r4)
                if (r5 == 0) goto L26
                boolean r7 = java.util.Objects.equals(r3, r4)
                if (r7 != 0) goto L25
                androidx.lifecycle.t<com.oplus.melody.app.discovery.E0> r7 = r6.f18895a
                D7.C0379m.l(r7, r4)
            L25:
                return
            L26:
                java.lang.Object r5 = r1.get()
                if (r5 == r3) goto L14
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r3 = "computeAndSetValue retryCount="
                r1.<init>(r3)
                r1.append(r0)
                java.lang.String r1 = r1.toString()
                com.oplus.melody.common.util.A.x(r2, r1)
                int r0 = r0 + 1
                goto L1
            L40:
                java.lang.String r7 = "computeAndSetValue failed MAX_RETRY=2"
                com.oplus.melody.common.util.A.h(r2, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.app.discovery.DiscoveryDialogViewModel.a.a(java.util.function.Function):void");
        }
    }

    public static final class b extends com.oplus.melody.common.data.a {
        private int mIndex;
        private String mMacAddress;

        public int getIndex() {
            return this.mIndex;
        }

        public String getMacAddress() {
            return this.mMacAddress;
        }

        public void setIndex(int i10) {
            this.mIndex = i10;
        }

        public void setMacAddress(String str) {
            this.mMacAddress = str;
        }
    }

    public static CompletableFuture e(int i10, String str) {
        CompletableFuture completableFutureP = p(Z7.a.g().f(i10, true, str));
        Locale locale = Locale.ENGLISH;
        CompletableFuture[] completableFutureArr = {completableFutureP, p(CompletableFuture.completedFuture(Z7.a.k("popup_" + str + "_" + i10))), p(Z7.a.g().e(i10, str))};
        return CompletableFuture.allOf(completableFutureArr).thenApply((Function<? super Void, ? extends U>) new C0873o0(completableFutureArr, str, i10));
    }

    public static String f(List list, b bVar, Function function) {
        int iMin;
        int size = list.size();
        String macAddress = null;
        if (bVar != null) {
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                if (TextUtils.equals(bVar.getMacAddress(), (CharSequence) function.apply((com.oplus.melody.common.data.a) list.get(i10)))) {
                    macAddress = bVar.getMacAddress();
                    break;
                }
                i10++;
            }
            if (macAddress == null && (iMin = Math.min(bVar.getIndex(), size - 1)) >= 0 && iMin < size) {
                macAddress = (String) function.apply((com.oplus.melody.common.data.a) list.get(iMin));
            }
        }
        return (macAddress != null || size <= 0) ? macAddress : (String) function.apply((com.oplus.melody.common.data.a) list.get(0));
    }

    public static CompletableFuture p(CompletableFuture completableFuture) {
        return new D7.q0(completableFuture, 800L, TimeUnit.MILLISECONDS).thenApplyAsync((Function) new A6.i(24)).exceptionally((Function<Throwable, ? extends U>) new C0867l0(1));
    }

    @Override // androidx.lifecycle.L
    public final void c() {
        com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0836b(this, 3));
        if (this.f18889i != null) {
            Object obj = AbstractC1048a.f23118c;
            AbstractC1048a.C0250a.a().a(this.f18889i);
            EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(this.f18889i);
            if (earphoneDTOW != null) {
                C1264t.A(2, earphoneDTOW.getProductId(), earphoneDTOW.getMacAddress(), com.oplus.melody.model.repository.earphone.N.t(earphoneDTOW));
            }
        }
        D0 d02 = this.f18892l;
        if (d02 != null) {
            Object value = D7.m0.f1129a.getValue();
            if (value != null) {
                D7.j0 j0VarF = D7.j0.f(value);
                D7.i0[] i0VarArrA = D7.i0.a(new Class[]{OplusA2dpSharingStateCallback.class}, new Object[]{d02});
                com.oplus.melody.common.util.A.c("ShareAudioHelper", new D7.k0(j0VarF.d("unregisterStateCallback", (D7.i0[]) Arrays.copyOf(i0VarArrA, i0VarArrA.length)), 0));
            }
            this.f18892l = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x024e A[PHI: r8
      0x024e: PHI (r8v5 int) = (r8v4 int), (r8v4 int), (r8v15 int) binds: [B:132:0x027b, B:136:0x0287, B:85:0x01ec] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.oplus.melody.app.discovery.E0 d(java.lang.String r17, com.oplus.melody.model.repository.earphone.EarphoneDTO r18, com.oplus.melody.app.discovery.E0 r19) {
        /*
            Method dump skipped, instruction units count: 955
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.app.discovery.DiscoveryDialogViewModel.d(java.lang.String, com.oplus.melody.model.repository.earphone.EarphoneDTO, com.oplus.melody.app.discovery.E0):com.oplus.melody.app.discovery.E0");
    }

    public final CompletableFuture<String> g(E0 e02) {
        String id = e02.getId();
        if (id == null) {
            id = "";
        }
        ConcurrentHashMap concurrentHashMap = this.f18886e;
        CompletableFuture<String> completableFuture = (CompletableFuture) concurrentHashMap.get(id);
        return completableFuture == null ? (CompletableFuture) concurrentHashMap.computeIfAbsent(id, new C0886v0(e02, 0)) : completableFuture;
    }

    public final a h(String str) {
        ConcurrentHashMap concurrentHashMap = this.f18884c;
        if (str == null) {
            str = "";
        }
        return (a) concurrentHashMap.computeIfAbsent(str, new I(this, 1));
    }

    public final CompletableFuture i(int i10, String str, String str2) {
        if (!"onPreviewPopup".equals(this.f18890j) || this.f18893m != null) {
            return (CompletableFuture) this.f18885d.computeIfAbsent(C1065d.c(str2, com.oplus.drs.core.d.v(C0906l.f19501a) ? "night" : "normal"), new C0852g0(this, str, i10, str2, 0));
        }
        this.f18891k = true;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            kotlin.jvm.internal.h.i("context");
            throw null;
        }
        File file = new File(new File(heyMelodyApplication.getCacheDir(), "custom_dress"), "preview");
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return file.isDirectory() ? p(CompletableFuture.completedFuture(file)) : e(i10, str);
    }

    public final void j(String str) {
        o(str, new C0884u0(1, str));
        E0 e0D = h(str).f18895a.d();
        if (e0D == null) {
            com.oplus.melody.common.util.A.h("DiscoveryDialogViewModel", "handleShareAudio earphoneVOLiveData==null:false");
        } else {
            com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0880s0(e0D, 0));
            if (e0D.getPairingState() == 1) {
                n(str);
            }
        }
    }

    public final boolean k() {
        return "onBoxCoverStateChange".equals(this.f18890j);
    }

    public final boolean l() {
        return "onEarphoneConnected".equals(this.f18890j);
    }

    public final boolean m() {
        return "onNewDeviceDiscovery".equals(this.f18890j);
    }

    public final void n(String str) {
        com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0839c(str, 3));
        androidx.lifecycle.u<Map<String, Boolean>> uVar = this.f18887f;
        Map<String, Boolean> mapD = uVar.d();
        HashMap map = mapD != null ? new HashMap(mapD) : new HashMap();
        map.put(str, Boolean.TRUE);
        uVar.i(map);
        o0.c.f1145c.execute(new RunnableC0871n0(0, this, str));
    }

    public final void o(String str, Function<E0, E0> function) {
        o0.c.f1145c.execute(new RunnableC0878r0(0, h(str), function));
    }
}
