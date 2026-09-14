package com.oplus.melody.model.net;

import androidx.media3.exoplayer.C0625v;
import com.oplus.melody.common.helper.MelodyException;
import java.net.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.logging.HttpLoggingInterceptor;
import uc.p;

/* JADX INFO: renamed from: com.oplus.melody.model.net.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: OkHttpClients.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C0938g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile uc.p f19822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f19823b = new ConcurrentHashMap();

    public C0938g() {
        throw MelodyException.e(501, "OkHttpClients cannot be instantiated");
    }

    public static uc.p a() {
        if (f19822a == null) {
            synchronized (C0938g.class) {
                try {
                    if (f19822a == null) {
                        p.a aVar = new p.a();
                        TimeUnit unit = TimeUnit.SECONDS;
                        kotlin.jvm.internal.h.e(unit, "unit");
                        aVar.f28222t = vc.i.b(10L);
                        kotlin.jvm.internal.h.e(unit, "unit");
                        aVar.f28223u = vc.i.b(20L);
                        kotlin.jvm.internal.h.e(unit, "unit");
                        aVar.f28224v = vc.i.b(20L);
                        aVar.f28209f = true;
                        aVar.f28207d.add(new C0936e());
                        aVar.f28206c.add(new C0937f());
                        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new C0625v(22));
                        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.f26741a;
                        if (com.oplus.melody.common.util.A.k() || com.oplus.melody.common.util.A.m()) {
                            level = HttpLoggingInterceptor.Level.f26743c;
                        }
                        httpLoggingInterceptor.f26740d = level;
                        aVar.f28206c.add(httpLoggingInterceptor);
                        Proxy proxy = Proxy.NO_PROXY;
                        kotlin.jvm.internal.h.a(proxy, aVar.f28215m);
                        aVar.f28215m = proxy;
                        aVar.f28205b = new P6.a(3, 30L, unit);
                        f19822a = new uc.p(aVar);
                    }
                } finally {
                }
            }
        }
        return f19822a;
    }
}
