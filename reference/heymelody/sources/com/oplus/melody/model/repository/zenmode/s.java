package com.oplus.melody.model.repository.zenmode;

import D7.C0368b;
import D7.C0379m;
import D7.C0382p;
import D7.E;
import D7.f0;
import D7.h0;
import D7.o0;
import D7.q0;
import L7.a;
import L8.I;
import L8.O;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.lifecycle.u;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.app.discovery.C0852g0;
import com.oplus.melody.app.discovery.C0877q0;
import com.oplus.melody.btsdk.api.data.ZenModeFileVertifyInformation;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0911q;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.S;
import com.oplus.melody.common.util.W;
import com.oplus.melody.model.db.MelodyDatabase;
import com.oplus.melody.model.db.N;
import com.oplus.melody.model.db.ZenModeResourceDao;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import com.oplus.melody.model.repository.earphone.C0940c;
import com.oplus.melody.model.repository.earphone.C0949l;
import com.oplus.melody.model.repository.earphone.D;
import com.oplus.melody.model.repository.zenmode.s;
import g0.C1065d;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: compiled from: ZenModeRepositoryServerImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends ZenModeRepository {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final ZenModeResourceDao f20210D;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final u<ZenModePlayStateDTO> f20212s = new u<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final O7.l<d> f20213t = new O7.l<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final u<SoundCacheCleanEvent> f20214u = new u<>(new SoundCacheCleanEvent(0, 0));

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final O7.l<Map<String, Boolean>> f20215v = new O7.l<>();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ConcurrentHashMap<String, c> f20216w = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ConcurrentHashMap<String, CompletableFuture<Void>> f20217x = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f20218y = new Object();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ConcurrentHashMap f20219z = new ConcurrentHashMap();

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final ConcurrentHashMap f20207A = new ConcurrentHashMap();

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final ConcurrentHashMap f20208B = new ConcurrentHashMap();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public List<N> f20209C = new ArrayList();

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f20211E = 1;

    /* JADX INFO: compiled from: ZenModeRepositoryServerImpl.java */
    public class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ZenModeInfoDO f20220a;

        public a(ZenModeInfoDO zenModeInfoDO) {
            this.f20220a = zenModeInfoDO;
        }

        @Override // com.oplus.melody.model.repository.zenmode.c
        public final void d(final int i10, final String str) {
            Optional.ofNullable(s.this.f20216w.get(this.f20220a.getResId())).ifPresent(new Consumer() { // from class: com.oplus.melody.model.repository.zenmode.r
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    s.a aVar = this.f20204a;
                    aVar.getClass();
                    int i11 = i10;
                    A.c("ZenModeRepository", new f0(aVar, i11, 7));
                    ((c) obj).d(i11, str);
                }
            });
        }
    }

    /* JADX INFO: compiled from: ZenModeRepositoryServerImpl.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CompletableFuture<File> f20222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedList f20223b;

        public b(CompletableFuture completableFuture, LinkedList linkedList) {
            this.f20222a = completableFuture;
            this.f20223b = linkedList;
        }
    }

    public s() {
        this.f20210D = null;
        MelodyDatabase melodyDatabaseT = MelodyDatabase.t(C0906l.f19501a);
        if (melodyDatabaseT != null) {
            this.f20210D = melodyDatabaseT.z();
        }
        Object obj = L7.a.f3010c;
        C0379m.i(a.C0032a.a().a(), new C6.e(this, 22), o0.c.f1146d);
    }

    public static String F(String str, Object... objArr) {
        StringBuilder sb2 = new StringBuilder(str);
        for (Object obj : objArr) {
            sb2.append('_');
            sb2.append(obj);
        }
        return sb2.toString();
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void A(String str, ZenModeInfoDO zenModeInfoDO, String str2) {
        Intent intent = new Intent();
        intent.putExtra("arg1", str);
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        intent.putExtra("arg2", zenModeInfoDO);
        ComponentName componentNameG = S.g();
        if (componentNameG != null && TextUtils.equals(componentNameG.getPackageName(), heyMelodyApplication.getPackageName())) {
            A.c("ZenModeRepository", new I7.j(zenModeInfoDO, str, str2, 2));
            intent.setComponent(new ComponentName(heyMelodyApplication, "com.oplus.melody.service.ZenModeMediaPlayerService"));
            intent.putExtra("arg3", false);
            C0905k.l(heyMelodyApplication, intent);
            return;
        }
        A.c("ZenModeRepository", new I7.f(zenModeInfoDO, str, str2, 4));
        intent.setComponent(new ComponentName(heyMelodyApplication, "com.oplus.melody.service.ZenModePlayJumpActivity"));
        intent.addFlags(268435456);
        if (heyMelodyApplication == null) {
            q0.b(MelodyException.e(0, "startActivityAsync on null"));
        } else {
            kotlin.jvm.internal.h.d(CompletableFuture.supplyAsync(new Ca.s(13, heyMelodyApplication, intent)), "supplyAsync(...)");
        }
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void B(int i10, String str, String str2, String str3) {
        File file = new File(str2);
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        ZenModeFileVertifyInformation zenModeFileVertifyInformationPrepareOTAFileInformation = ZenModeFileVertifyInformation.prepareOTAFileInformation(file, str3, i10);
        Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1048);
        intentU.putExtra("param_zenmode_file_name", file.getAbsolutePath());
        intentU.putExtra("param_address", str);
        intentU.putExtra("param_zenmode_file_vertify", zenModeFileVertifyInformationPrepareOTAFileInformation);
        com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void C(String str, String str2) {
        if (A.l()) {
            A.b("ZenModeRepository", "stopPlayV2 mac=" + A.r(str) + " from=" + str2);
        }
        Intent intent = new Intent();
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        intent.putExtra("arg1", str);
        intent.setComponent(new ComponentName(heyMelodyApplication, "com.oplus.melody.service.ZenModeMediaPlayerService"));
        C0905k.m(heyMelodyApplication, intent);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void D() {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1051));
    }

    public final CompletableFuture<ZenModeInfoDO> E(String str) {
        return CompletableFuture.supplyAsync(new D(str, 3)).thenCompose((Function) new F9.h(3, this, str));
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final CompletableFuture a(c cVar, String str) {
        A.c("ZenModeRepository", new D6.c(str, 17));
        synchronized (this.f20218y) {
            Map<String, Boolean> mapD = this.f20215v.d();
            if (mapD != null && Boolean.TRUE.equals(mapD.get(str))) {
                this.f20216w.put(str, cVar);
                return this.f20217x.computeIfAbsent(str, new C0940c(15));
            }
            A.c("ZenModeRepository", new D(str, 2));
            return CompletableFuture.completedFuture(null);
        }
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void b(String str) {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        A6.g.i(heyMelodyApplication, 1049, "param_address", str, heyMelodyApplication);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void c(String str, String str2, String str3) {
        A.b("ZenModeRepository", "cleanSoundAudioCache...");
        u<SoundCacheCleanEvent> uVar = this.f20214u;
        int i10 = this.f20211E;
        this.f20211E = i10 + 1;
        C0379m.k(uVar, new SoundCacheCleanEvent(i10, 1));
        this.f20219z.clear();
        ForkJoinPool.commonPool().execute(new O(this, str2, str3, str, 4));
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final CompletableFuture<ZenModeInfoDO> d(final ZenModeInfoDO zenModeInfoDO, String str, final c cVar) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final File fileG = ZenModeRepository.g(zenModeInfoDO, str);
        return CompletableFuture.supplyAsync(new Q7.j(this, zenModeInfoDO, fileG, 2)).thenCompose(new Function() { // from class: com.oplus.melody.model.repository.zenmode.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                s sVar = this.f20179a;
                sVar.getClass();
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                final ZenModeInfoDO zenModeInfoDO2 = zenModeInfoDO;
                final long j5 = jElapsedRealtime;
                if (zBooleanValue) {
                    A.c("ZenModeRepository", new n(0, j5, zenModeInfoDO2));
                    return CompletableFuture.completedFuture(zenModeInfoDO2);
                }
                ConcurrentHashMap concurrentHashMap = sVar.f20207A;
                String audioSha256 = zenModeInfoDO2.getAudioSha256();
                final File file = fileG;
                final c cVar2 = cVar;
                return ((s.b) concurrentHashMap.compute(audioSha256, new BiFunction() { // from class: com.oplus.melody.model.repository.zenmode.o
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj2, Object obj3) {
                        s.b bVar = (s.b) obj3;
                        c cVar3 = cVar2;
                        if (bVar != null && !bVar.f20222a.isDone()) {
                            if (cVar3 != null) {
                                bVar.f20223b.add(cVar3);
                            }
                            return bVar;
                        }
                        LinkedList linkedList = new LinkedList();
                        if (cVar3 != null) {
                            linkedList.add(cVar3);
                        }
                        com.oplus.melody.model.net.n nVarB = com.oplus.melody.model.net.n.b();
                        final ZenModeInfoDO zenModeInfoDO3 = zenModeInfoDO2;
                        CompletableFuture<File> completableFutureA = nVarB.a(zenModeInfoDO3.getAudioUrl(), zenModeInfoDO3.getAudioSha256(), "SHA-256", new b(linkedList));
                        final File file2 = file;
                        final long j9 = j5;
                        return new s.b(completableFutureA.thenApply(new Function() { // from class: com.oplus.melody.model.repository.zenmode.q
                            @Override // java.util.function.Function
                            public final Object apply(Object obj4) {
                                File file3 = (File) obj4;
                                File file4 = file2;
                                if (C0911q.o(file3, file4)) {
                                    A.c("ZenModeRepository", new C0382p(4, j9, zenModeInfoDO3));
                                    return file4;
                                }
                                throw MelodyException.e(0, "Unable to move " + file3);
                            }
                        }), linkedList);
                    }
                })).f20222a.thenApply((Function<? super File, ? extends U>) new A6.p(zenModeInfoDO2, 21));
            }
        });
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final CompletableFuture<Void> e(ZenModeInfoDO zenModeInfoDO, final c cVar) {
        String audioUrl = zenModeInfoDO.getAudioUrl();
        String audioBinUrl = zenModeInfoDO.getAudioBinUrl();
        File file = new File(C0906l.f19501a.getFilesDir(), "zenmode");
        final String str = zenModeInfoDO.getProductId() + "_" + zenModeInfoDO.getColor() + "_" + zenModeInfoDO.getResId();
        String strC = C1065d.c(str, ".mp3");
        String strC2 = C1065d.c(str, ".bin");
        File file2 = new File(file, strC);
        final File file3 = new File(file, strC2);
        String md5 = zenModeInfoDO.getMd5();
        t8.q.c("zenmode").edit().remove(str).apply();
        com.oplus.melody.model.net.n nVarB = com.oplus.melody.model.net.n.b();
        nVarB.getClass();
        CompletableFuture completableFutureExceptionally = nVarB.a(audioUrl, null, null, new com.oplus.melody.model.net.m(cVar, str)).thenApply((Function<? super File, ? extends U>) new c8.i(file2, 1)).exceptionally((Function<Throwable, ? extends U>) new j(0, cVar, file2, str));
        com.oplus.melody.model.net.n nVarB2 = com.oplus.melody.model.net.n.b();
        nVarB2.getClass();
        return completableFutureExceptionally.runAfterBoth((CompletionStage<?>) nVarB2.a(audioBinUrl, null, null, new com.oplus.melody.model.net.m(null, str)).thenApply((Function<? super File, ? extends U>) new Aa.c(file3, 16)).exceptionally((Function<Throwable, ? extends U>) new Function() { // from class: com.oplus.melody.model.repository.zenmode.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                A.i("ZenModeRepository", "downloadZenModeAudioResource", (Throwable) obj);
                cVar.b(0, str, "Download zenmode audio file fail!");
                return file3;
            }
        }), (Runnable) new H1.b(str, md5, cVar, 8)).exceptionally((Function<Throwable, ? extends Void>) new Ea.N(2, cVar, str));
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final androidx.lifecycle.s<ZenModeInfoDO> f(String str) {
        u uVar = (u) this.f20208B.computeIfAbsent(str, new f(1));
        E(str).thenAccept((Consumer<? super ZenModeInfoDO>) new C0368b(uVar, 19));
        return uVar;
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final androidx.lifecycle.s<Map<String, Boolean>> h() {
        return this.f20215v;
    }

    @Override // K7.b, android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Bundle data = message.getData();
        switch (message.what) {
            case 6001:
                ZenModeInfoDO zenModeInfoDO = (ZenModeInfoDO) C0914u.g(data, "arg1", ZenModeInfoDO.class);
                if (zenModeInfoDO == null) {
                    h0.e(message, "400: Bad Request", 400);
                    return true;
                }
                E e10 = h0.f1099c;
                h0.c(message, e(zenModeInfoDO, new com.oplus.melody.model.repository.zenmode.a(message)));
                return true;
            case 6002:
                String string = data.getString("arg1");
                String string2 = data.getString("arg2");
                String string3 = data.getString("arg3");
                E e11 = h0.f1099c;
                h0.c(message, s(string, string2, string3));
                return true;
            case 6003:
                String string4 = data.getString("arg1");
                E e12 = h0.f1099c;
                h0.i(message, i(string4));
                return true;
            case 6004:
                v();
                h0.h(message, null);
                return true;
            case 6005:
                D();
                h0.h(message, null);
                return true;
            case 6006:
                B(data.getInt("arg4"), data.getString("arg1"), data.getString("arg2"), data.getString("arg3"));
                h0.h(message, null);
                return true;
            case 6007:
                b(data.getString("arg1"));
                h0.h(message, null);
                return true;
            case 6008:
            default:
                return false;
            case 6009:
                String string5 = data.getString("arg1");
                int i10 = data.getInt("arg2", -1);
                E e13 = h0.f1099c;
                h0.c(message, m(i10, string5));
                return true;
            case 6010:
                ZenModeInfoDO zenModeInfoDO2 = (ZenModeInfoDO) C0914u.g(data, "arg1", ZenModeInfoDO.class);
                if (zenModeInfoDO2 == null) {
                    h0.e(message, "400: Bad Request", 400);
                    return true;
                }
                String string6 = data.getString("arg2", null);
                if (string6 == null) {
                    h0.e(message, "400: Bad Request", 400);
                    return true;
                }
                E e14 = h0.f1099c;
                h0.c(message, d(zenModeInfoDO2, string6, new com.oplus.melody.model.repository.zenmode.a(message)));
                return true;
            case 6011:
                String string7 = data.getString("arg1");
                E e15 = h0.f1099c;
                h0.i(message, f(string7 != null ? string7 : ""));
                return true;
            case 6012:
                String string8 = data.getString("arg1");
                E e16 = h0.f1099c;
                h0.i(message, k(string8 != null ? string8 : ""));
                return true;
            case 6013:
                ZenModeInfoDO zenModeInfoDO3 = (ZenModeInfoDO) C0914u.g(data, "arg2", ZenModeInfoDO.class);
                if (zenModeInfoDO3 != null) {
                    A(data.getString("arg1", ""), zenModeInfoDO3, data.getString("arg3"));
                }
                h0.h(message, null);
                return true;
            case 6014:
                C(data.getString("arg1", ""), data.getString("arg2"));
                h0.h(message, null);
                return true;
            case 6015:
                String string9 = data.getString("arg1");
                String string10 = data.getString("arg2");
                if (string9 != null && string10 != null) {
                    y(string9, string10);
                }
                h0.h(message, null);
                return true;
            case 6016:
                String string11 = data.getString("arg1");
                String str = string11 != null ? string11 : "";
                E(str).thenAccept((Consumer<? super ZenModeInfoDO>) new G8.s(data.getInt("arg2", 0), 1, this, str));
                h0.h(message, null);
                return true;
            case 6017:
                E e17 = h0.f1099c;
                h0.i(message, this.f20214u);
                return true;
            case 6018:
                c(data.getString("arg1", null), data.getString("arg2", null), data.getString("arg3", null));
                h0.h(message, null);
                return true;
            case 6019:
                x();
                h0.h(message, null);
                return true;
            case 6020:
                E e18 = h0.f1099c;
                h0.i(message, this.f20215v);
                return true;
            case 6021:
                ZenModeInfoDO zenModeInfoDO4 = (ZenModeInfoDO) C0914u.g(data, "arg1", ZenModeInfoDO.class);
                String string12 = data.getString("arg2", null);
                if (zenModeInfoDO4 != null && string12 != null) {
                    z(zenModeInfoDO4, string12);
                }
                h0.h(message, null);
                return true;
            case 6022:
                String string13 = data.getString("arg1", null);
                if (string13 == null) {
                    h0.h(message, null);
                    return true;
                }
                E e19 = h0.f1099c;
                h0.c(message, a(new com.oplus.melody.model.repository.zenmode.a(message), string13));
                return true;
            case 6023:
                String string14 = data.getString("arg1", null);
                if (string14 != null) {
                    w(string14);
                }
                h0.h(message, null);
                return true;
        }
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final androidx.lifecycle.s<d> i(String str) {
        CompletableFuture.runAsync(new Ca.h(str, 2));
        return this.f20213t;
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final androidx.lifecycle.s<ZenModePlayStateDTO> k(String str) {
        return C0379m.c(this.f20212s, new W(str, 1));
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final CompletableFuture m(int i10, String str) {
        if (i10 == -1) {
            return q0.b(MelodyException.e(0, "getSceneListV2 unknown color"));
        }
        String string = C0906l.f19501a.getString(R.string.melody_common_language_tag);
        String strF = F("list", str, Integer.valueOf(i10));
        return CompletableFuture.supplyAsync(new C0877q0(strF, str, i10, string)).thenCompose((Function) new C0852g0(str, i10, string, strF));
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final androidx.lifecycle.s<SoundCacheCleanEvent> q() {
        return this.f20214u;
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final CompletableFuture<List<ZenModeInfoDO>> s(String str, String str2, String str3) {
        return CompletableFuture.supplyAsync(new Q7.j(this, str, str2, 3)).thenCompose((Function) new I(this, str3, str, str2));
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final List<N> u(String str, String str2) {
        ZenModeResourceDao zenModeResourceDao = this.f20210D;
        if (zenModeResourceDao != null) {
            return zenModeResourceDao.d(str, str2);
        }
        return null;
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void v() {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1050));
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void w(String str) {
        A.c("ZenModeRepository", new D(str, 5));
        this.f20216w.remove(str);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void x() {
        u<SoundCacheCleanEvent> uVar = this.f20214u;
        int i10 = this.f20211E;
        this.f20211E = i10 + 1;
        C0379m.k(uVar, new SoundCacheCleanEvent(i10, 0));
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void y(String str, String str2) {
        String strF = F("active", str);
        String string = t8.q.c("melody-model-zen2").getString(strF, null);
        if (TextUtils.equals(string, str2)) {
            return;
        }
        A.c("ZenModeRepository", new c8.k(str2, string, 1));
        t8.q.c("melody-model-zen2").edit().putString(strF, str2).apply();
        f(str);
    }

    @Override // com.oplus.melody.model.repository.zenmode.ZenModeRepository
    public final void z(ZenModeInfoDO zenModeInfoDO, String str) {
        synchronized (this.f20218y) {
            try {
                Map<String, Boolean> mapD = this.f20215v.d();
                if (mapD == null || !Boolean.TRUE.equals(mapD.get(zenModeInfoDO.getResId()))) {
                    androidx.collection.a aVarC = C0901g.c(mapD);
                    aVarC.put(zenModeInfoDO.getResId(), Boolean.TRUE);
                    this.f20215v.m(aVarC);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        d(zenModeInfoDO, str, new a(zenModeInfoDO)).whenCompleteAsync((BiConsumer<? super ZenModeInfoDO, ? super Throwable>) new C0949l(this, zenModeInfoDO, 2), (Executor) o0.c.f1144b);
    }
}
