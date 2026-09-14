package com.oplus.melody.model.repository.zenmode;

import D7.q0;
import android.os.SystemClock;
import com.google.gson.reflect.TypeToken;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.db.N;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import com.oplus.melody.model.repository.earphone.C0940c;
import com.oplus.melody.model.repository.earphone.C0941d;
import java.io.File;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ZenModeRepository extends K7.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20154c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f20155p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Type f20156q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile ZenModeRepository f20157r;

    static {
        StringBuilder sb2 = new StringBuilder("melody-model-sound");
        String str = File.separator;
        String strB = g0.f.b(str, "audio", sb2);
        f20154c = strB;
        f20155p = strB + str + "video";
        f20156q = new TypeToken<List<ZenModeInfoDO>>() { // from class: com.oplus.melody.model.repository.zenmode.ZenModeRepository.1
        }.getType();
    }

    public ZenModeRepository() {
        super(6000);
    }

    public static File g(ZenModeInfoDO zenModeInfoDO, String str) {
        if ("melody-model-zen2".equals(str)) {
            return l(zenModeInfoDO);
        }
        if ("melody-model-sound".equals(str)) {
            return o(zenModeInfoDO);
        }
        A.h("ZenModeRepository", "getAudioFilePath filePathTag is null!");
        return null;
    }

    public static ZenModeRepository j() {
        if (f20157r == null) {
            synchronized (ZenModeRepository.class) {
                try {
                    if (f20157r == null) {
                        if (E7.a.d(C0906l.f19501a)) {
                            f20157r = new s();
                        } else {
                            f20157r = new ZenModeRepositoryClientImpl();
                        }
                    }
                } finally {
                }
            }
        }
        return f20157r;
    }

    public static File l(ZenModeInfoDO zenModeInfoDO) {
        String audioUrl = zenModeInfoDO.getAudioUrl();
        String audioSha256 = zenModeInfoDO.getAudioSha256();
        int iLastIndexOf = audioUrl.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            StringBuilder sbE = g0.f.e(audioSha256);
            sbE.append(audioUrl.substring(iLastIndexOf));
            audioSha256 = sbE.toString();
        }
        return new File(new File(C0906l.f19501a.getFilesDir(), "melody-model-zen2"), audioSha256);
    }

    public static File n() {
        return new File(C0906l.f19501a.getFilesDir(), f20154c);
    }

    public static File o(ZenModeInfoDO zenModeInfoDO) {
        return p(zenModeInfoDO.getAudioUrl(), zenModeInfoDO.getAudioSha256());
    }

    public static File p(String str, String str2) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            StringBuilder sbE = g0.f.e(str2);
            sbE.append(str.substring(iLastIndexOf));
            str2 = sbE.toString();
        }
        return new File(n(), str2);
    }

    public static File r(String str) {
        File fileN = n();
        if (!fileN.exists()) {
            fileN.mkdirs();
        }
        return new File(fileN, str);
    }

    public abstract void A(String str, ZenModeInfoDO zenModeInfoDO, String str2);

    public abstract void B(int i10, String str, String str2, String str3);

    public abstract void C(String str, String str2);

    public abstract void D();

    public abstract CompletableFuture a(c cVar, String str);

    public abstract void b(String str);

    public abstract void c(String str, String str2, String str3);

    public abstract CompletableFuture<ZenModeInfoDO> d(ZenModeInfoDO zenModeInfoDO, String str, c cVar);

    public abstract CompletableFuture<?> e(ZenModeInfoDO zenModeInfoDO, c cVar);

    public abstract androidx.lifecycle.s<ZenModeInfoDO> f(String str);

    public abstract androidx.lifecycle.s<Map<String, Boolean>> h();

    public abstract androidx.lifecycle.s<d> i(String str);

    public abstract androidx.lifecycle.s<ZenModePlayStateDTO> k(String str);

    public abstract CompletableFuture m(int i10, String str);

    public abstract androidx.lifecycle.s<SoundCacheCleanEvent> q();

    public abstract CompletableFuture<List<ZenModeInfoDO>> s(String str, String str2, String str3);

    public final CompletableFuture t(int i10, String str, String str2, String str3) {
        if (i10 == -1) {
            return q0.b(MelodyException.e(0, "getZipConfigV2 unknown color"));
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        CompletableFuture completableFutureThenApplyAsync = Z7.a.g().d(i10, 5, str2).thenApplyAsync((Function) new C0940c(13));
        CompletableFuture completableFutureThenCompose = m(i10, str2).thenCompose((Function) new A6.p(this, 20));
        CompletableFuture completableFutureThenApplyAsync2 = Z7.a.g().e(i10, str2).thenApplyAsync((Function) new C0941d(14));
        return CompletableFuture.allOf(completableFutureThenApplyAsync, completableFutureThenCompose, completableFutureThenApplyAsync2).thenApply((Function<? super Void, ? extends U>) new Z7.c(completableFutureThenApplyAsync, completableFutureThenCompose, completableFutureThenApplyAsync2, 2)).whenComplete((BiConsumer<? super U, ? super Throwable>) new g(1, jElapsedRealtime, str3, str));
    }

    public abstract List<N> u(String str, String str2);

    public abstract void v();

    public abstract void w(String str);

    public abstract void x();

    public abstract void y(String str, String str2);

    public abstract void z(ZenModeInfoDO zenModeInfoDO, String str);
}
