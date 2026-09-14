package com.oplus.melody.model.net;

import D7.h0;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0911q;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.common.util.K;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.net.E;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SmartHomeIotCallHelperServerImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class E extends n {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f19807p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f19808q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f19809r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ConcurrentHashMap f19810s = new ConcurrentHashMap();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CompletableFuture<Long> f19811t;

    /* JADX INFO: compiled from: SmartHomeIotCallHelperServerImpl.java */
    public class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19812a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.oplus.melody.model.repository.zenmode.c f19813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f19814c;

        public a(com.oplus.melody.model.repository.zenmode.c cVar, String str, String str2) {
            this.f19813b = cVar;
            this.f19814c = str;
        }

        @Override // com.oplus.melody.model.net.h
        public final void a(long j5, long j9) {
            if (j9 <= 0 || j5 < 0 || j5 > j9) {
                return;
            }
            int i10 = (int) ((j5 * 100.0f) / j9);
            com.oplus.melody.model.repository.zenmode.c cVar = this.f19813b;
            if (cVar != null && i10 != this.f19812a) {
                cVar.d(i10, this.f19814c);
            }
            this.f19812a = i10;
        }
    }

    /* JADX INFO: compiled from: SmartHomeIotCallHelperServerImpl.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f19815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SecretKeySpec f19816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final G f19817c;

        public b(String str, SecretKeySpec secretKeySpec, G g3) {
            this.f19815a = str;
            this.f19816b = secretKeySpec;
            this.f19817c = g3;
        }
    }

    public E() {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        this.f19808q = Integer.toString(S.i(heyMelodyApplication));
        this.f19807p = S.s(heyMelodyApplication) ? BaseHealthModule.TRACK_CERVICAL_REMIND : BaseHealthModule.TRACK_FATIGUE_REMIND;
        this.f19809r = "pall";
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture<File> a(final String str, final String str2, final String str3, final com.oplus.melody.model.repository.zenmode.c cVar) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final String string = UUID.randomUUID().toString();
        return q().thenCompose(new Function() { // from class: com.oplus.melody.model.net.C
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                this.f19799a.getClass();
                com.oplus.melody.model.repository.zenmode.c cVar2 = cVar;
                String str4 = str;
                String str5 = string;
                C0938g.f19823b.put(str5, new E.a(cVar2, str4, str5));
                androidx.collection.a aVar = new androidx.collection.a();
                aVar.put("Melody-Download-Uuid", str5);
                return ((G) obj).l(str4, aVar);
            }
        }).thenApply((Function<? super U, ? extends U>) new Function() { // from class: com.oplus.melody.model.net.D
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                InputStream inputStreamW0;
                File file;
                String str4 = string;
                String str5 = str2;
                String str6 = str3;
                String str7 = str;
                try {
                    inputStreamW0 = ((uc.s) obj).d().w0();
                    try {
                        file = new File(C0906l.f19501a.getCacheDir(), str4);
                    } catch (Throwable th) {
                        try {
                            inputStreamW0.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e10) {
                    e = e10;
                    com.oplus.melody.common.util.A.i("SmartHomeIotCallHelper", "downloadResource", e);
                } catch (NoSuchAlgorithmException e11) {
                    e = e11;
                    com.oplus.melody.common.util.A.i("SmartHomeIotCallHelper", "downloadResource", e);
                }
                if (str5 == null || str5.isEmpty()) {
                    C0911q.u(file, inputStreamW0);
                } else {
                    MessageDigest messageDigest = MessageDigest.getInstance(str6);
                    C0911q.u(file, new DigestInputStream(inputStreamW0, messageDigest));
                    if (!str5.equalsIgnoreCase(K.c(messageDigest.digest()))) {
                        inputStreamW0.close();
                        throw MelodyException.e(0, "Failed to download " + str7);
                    }
                }
                inputStreamW0.close();
                return file;
            }
        }).whenComplete(new BiConsumer(string, jElapsedRealtime) { // from class: com.oplus.melody.model.net.q

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f19837a;

            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                C0938g.f19823b.remove(this.f19837a);
                Pattern pattern = com.oplus.melody.common.util.A.f19415a;
            }
        });
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture c(ArrayList arrayList) {
        androidx.collection.a aVarO = o();
        aVarO.put("productId", TextUtils.join(",", arrayList));
        return q().thenCompose((Function<? super G, ? extends CompletionStage<U>>) new p(this, aVarO, 0));
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture d(int i10, String str, String str2) {
        androidx.collection.a aVarO = o();
        aVarO.put("productId", str);
        aVarO.put("language", str2);
        aVarO.put("color", Integer.toString(i10));
        return q().thenCompose((Function<? super G, ? extends CompletionStage<U>>) new u(this, aVarO, 2));
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture e(int i10, String str, String str2) {
        androidx.collection.a aVarO = o();
        ArrayList arrayList = new ArrayList();
        androidx.collection.a aVar = new androidx.collection.a();
        if (!TextUtils.isEmpty(str)) {
            aVar.put("productId", str.toUpperCase());
        }
        aVar.put("language", str2);
        aVar.put("color", Integer.toString(i10));
        arrayList.add(aVar);
        aVarO.put("imageInfoList", arrayList);
        return q().thenCompose((Function<? super G, ? extends CompletionStage<U>>) new p(this, aVarO, 1));
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture<String> f(String str, String str2, String str3, String str4, String str5, String str6) {
        androidx.collection.a aVarO = o();
        aVarO.put("productId", str2);
        aVarO.put("language", str6);
        aVarO.put("softwareVersion", str4);
        aVarO.put("macAddress", C0911q.j(str));
        return q().thenCompose((Function<? super G, ? extends CompletionStage<U>>) new u(this, aVarO, 1));
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture<String> g(String str, String str2, int i10, int i11) {
        androidx.collection.a aVarO = o();
        aVarO.put("seriesId", Integer.valueOf(i11));
        aVarO.put("productId", str);
        aVarO.put("language", str2);
        aVarO.put("color", Integer.toString(i10));
        return q().thenCompose((Function<? super G, ? extends CompletionStage<U>>) new u(this, aVarO, 0));
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture h(int i10, String str, String str2) {
        androidx.collection.a aVarO = o();
        aVarO.put("productId", str);
        aVarO.put("language", str2);
        aVarO.put("color", Integer.toString(i10));
        return q().thenCompose((Function<? super G, ? extends CompletionStage<U>>) new s(this, aVarO, 1));
    }

    @Override // K7.b, android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Bundle data = message.getData();
        int i10 = 1;
        switch (message.what) {
            case 2001:
                D7.E e10 = h0.f1099c;
                h0.c(message, k(data.getInt("intColor", 0), data.getString(SpeechFindManager.TYPE), data.getString("productId")));
                return true;
            case 2002:
                D7.E e11 = h0.f1099c;
                h0.c(message, l(data.getString("arg1"), data.getString("arg2"), data.getString("arg3")));
                return true;
            case 2003:
                D7.E e12 = h0.f1099c;
                String string = data.getString("arg1");
                if (string == null) {
                    string = "";
                }
                String string2 = data.getString("arg2");
                if (string2 == null) {
                    string2 = "";
                }
                String string3 = data.getString("arg3");
                if (string3 == null) {
                    string3 = "";
                }
                String string4 = data.getString("arg4");
                if (string4 == null) {
                    string4 = "";
                }
                String string5 = data.getString("arg5");
                if (string5 == null) {
                    string5 = "";
                }
                String string6 = data.getString("arg6");
                if (string6 == null) {
                    str2 = string;
                    str3 = string2;
                    str4 = string4;
                    str5 = string5;
                    str = "";
                } else {
                    String str6 = string5;
                    str = string6;
                    str2 = string;
                    str3 = string2;
                    str4 = string4;
                    str5 = str6;
                }
                h0.c(message, f(str2, str3, string3, str4, str5, str));
                return true;
            case 2004:
                D7.E e13 = h0.f1099c;
                h0.c(message, h(data.getInt("intColor", 0), data.getString("productId"), data.getString("language")));
                return true;
            case 2005:
                D7.E e14 = h0.f1099c;
                h0.c(message, d(data.getInt("intColor", 0), data.getString("productId"), data.getString("language")));
                return true;
            case 2006:
                D7.E e15 = h0.f1099c;
                h0.c(message, c(data.getStringArrayList("productIds")));
                return true;
            case 2007:
                D7.E e16 = h0.f1099c;
                h0.c(message, e(data.getInt("intColor", 0), data.getString("productId"), data.getString("language")));
                return true;
            case 2008:
            default:
                return false;
            case 2009:
                String string7 = data.getString("fileUrl");
                String string8 = data.getString("checkCode");
                String string9 = data.getString("algorithm");
                D7.E e17 = h0.f1099c;
                h0.c(message, a(string7 != null ? string7 : "", string8, string9, new com.oplus.melody.model.repository.zenmode.a(message)));
                return true;
            case 2010:
                D7.E e18 = h0.f1099c;
                h0.c(message, i(data.getInt("intColor", 0), data.getString("productId"), data.getString("language")));
                return true;
            case 2011:
                D7.E e19 = h0.f1099c;
                h0.c(message, g(data.getString("productId"), data.getString("language"), data.getInt("intColor", 0), data.getInt("seriesId")));
                return true;
            case 2012:
                D7.E e20 = h0.f1099c;
                h0.c(message, q().thenCompose((Function<? super G, ? extends CompletionStage<U>>) new A(this, i10)));
                return true;
            case 2013:
                D7.E e21 = h0.f1099c;
                h0.c(message, j(data.getInt("arg2"), data.getInt("arg3"), data.getString("arg1")));
                return true;
            case 2014:
                D7.E e22 = h0.f1099c;
                int i11 = data.getInt("arg1");
                androidx.collection.a aVarO = o();
                aVarO.put("dictId", Integer.toString(i11));
                h0.c(message, q().thenCompose((Function<? super G, ? extends CompletionStage<U>>) new s(this, aVarO, 0)));
                return true;
        }
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture i(int i10, String str, String str2) {
        androidx.collection.a aVarO = o();
        aVarO.put("productId", str);
        aVarO.put("language", str2);
        aVarO.put("color", Integer.toString(i10));
        return q().thenCompose((Function<? super G, ? extends CompletionStage<U>>) new t(this, aVarO, 1));
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture j(int i10, int i11, String str) {
        androidx.collection.a aVarO = o();
        aVarO.put("productId", str);
        aVarO.put("color", Integer.toString(i10));
        aVarO.put("moduleId", Integer.toString(i11));
        J7.b.a().f();
        return q().thenCompose((Function<? super G, ? extends CompletionStage<U>>) new t(this, aVarO, 0));
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture k(int i10, final String str, String str2) {
        final androidx.collection.a aVarO = o();
        aVarO.put("productId", str2);
        aVarO.put("color", Integer.toString(i10));
        return q().thenCompose(new Function() { // from class: com.oplus.melody.model.net.r
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                final G g3 = (G) obj;
                E e10 = this.f19838a;
                e10.getClass();
                final String str3 = str;
                return e10.n(aVarO, new BiFunction() { // from class: com.oplus.melody.model.net.B
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj2, Object obj3) {
                        return g3.c(str3, (Map) obj2, (String) obj3);
                    }
                });
            }
        });
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture<String> l(String str, String str2, String str3) {
        androidx.collection.a aVarO = o();
        aVarO.put("language", str);
        aVarO.put("productId", str2);
        aVarO.put("color", str3);
        com.oplus.melody.common.util.A.c("SmartHomeIotCallHelper", new W6.e(str, str2, str3, 2));
        return q().thenCompose((Function<? super G, ? extends CompletionStage<U>>) new t(this, aVarO, 2));
    }

    public final CompletableFuture<String> n(Map<String, ?> map, BiFunction<Map<String, String>, String, CompletableFuture<String>> biFunction) {
        int iB;
        SecretKeySpec secretKeySpec = p(this.f19809r).f19816b;
        Object obj = map.get("color");
        String strC = null;
        if (obj != null && ((iB = K.b(-1, obj)) < 0 || iB > 16)) {
            StringBuilder sbN = androidx.appcompat.widget.a.n(iB, "检测到颜色错误：", " pid=");
            sbN.append(map.get("productId"));
            String string = sbN.toString();
            if (iB == -1) {
                throw MelodyException.e(0, string);
            }
            com.oplus.melody.common.util.A.w("SmartHomeIotCallHelper", string, null);
        }
        androidx.collection.a aVar = new androidx.collection.a();
        J7.b.a().c();
        aVar.put("Content-Type", "application/json");
        aVar.put("appid", "earphone");
        aVar.put("ts", String.valueOf(System.currentTimeMillis()));
        aVar.put("nonce", UUID.randomUUID().toString());
        aVar.put("sv", "v1");
        String strI = C0917x.i(map);
        byte[] bytes = strI.getBytes(StandardCharsets.UTF_8);
        try {
            Mac mac = Mac.getInstance("HmacSha1");
            mac.init(secretKeySpec);
            strC = K.c(mac.doFinal(bytes));
        } catch (InvalidKeyException | NoSuchAlgorithmException e10) {
            com.oplus.melody.common.util.A.i("SmartHomeIotCallHelper", "request data sign failure:", e10);
        }
        aVar.put("sign", strC);
        return biFunction.apply(aVar, strI);
    }

    public final androidx.collection.a o() {
        androidx.collection.a aVar = new androidx.collection.a();
        aVar.put("platform", "android");
        aVar.put("channel", this.f19807p);
        aVar.put("versionCode", this.f19808q);
        return aVar;
    }

    public final b p(String str) {
        ConcurrentHashMap concurrentHashMap = this.f19810s;
        b bVar = (b) concurrentHashMap.get(str);
        return bVar == null ? (b) concurrentHashMap.computeIfAbsent(str, new A(this, 0)) : bVar;
    }

    public final CompletableFuture<G> q() {
        return CompletableFuture.supplyAsync(new Supplier() { // from class: com.oplus.melody.model.net.z
            @Override // java.util.function.Supplier
            public final Object get() {
                E e10 = this.f19857a;
                return e10.p(e10.f19809r).f19817c;
            }
        });
    }
}
