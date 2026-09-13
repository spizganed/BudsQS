package com.oplus.melody.common.util;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Trace;
import android.text.TextUtils;
import com.airbnb.lottie.CallableC0777e;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.reflect.TypeToken;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.oplus.melody.common.util.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: JsonUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0917x {

    /* JADX INFO: renamed from: com.oplus.melody.common.util.x$a */
    /* JADX INFO: compiled from: JsonUtils.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Pattern f19516a = Pattern.compile("^m[A-Z]\\w*$");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Set<Class<?>> f19517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Gson f19518c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Gson f19519d;

        /* JADX INFO: renamed from: com.oplus.melody.common.util.x$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: JsonUtils.java */
        public class C0226a implements com.google.gson.a {
            @Override // com.google.gson.a
            public final boolean a(Class<?> cls) {
                return a.f19517b.contains(cls);
            }
        }

        /* JADX INFO: renamed from: com.oplus.melody.common.util.x$a$b */
        /* JADX INFO: compiled from: JsonUtils.java */
        public class b implements com.google.gson.a {
            @Override // com.google.gson.a
            public final boolean a(Class<?> cls) {
                return a.f19517b.contains(cls);
            }
        }

        static {
            HashSet hashSet = new HashSet(1);
            Object obj = new Object[]{BluetoothDevice.class}[0];
            Objects.requireNonNull(obj);
            if (!hashSet.add(obj)) {
                throw new IllegalArgumentException("duplicate element: " + obj);
            }
            f19517b = Collections.unmodifiableSet(hashSet);
            com.google.gson.d dVar = new com.google.gson.d();
            dVar.b(8, DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE);
            dVar.f17135j = false;
            dVar.f17129c = new androidx.appcompat.widget.a(23);
            C0226a c0226a = new C0226a();
            Excluder excluder = dVar.f17127a;
            Excluder excluderB = excluder.clone();
            ArrayList arrayList = new ArrayList(excluder.f17146b);
            excluderB.f17146b = arrayList;
            arrayList.add(c0226a);
            dVar.f17127a = excluderB;
            f19518c = new Gson(dVar);
            com.google.gson.d dVar2 = new com.google.gson.d();
            dVar2.b(8, DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE);
            dVar2.f17135j = false;
            b bVar = new b();
            Excluder excluder2 = dVar2.f17127a;
            Excluder excluderB2 = excluder2.clone();
            ArrayList arrayList2 = new ArrayList(excluder2.f17146b);
            excluderB2.f17146b = arrayList2;
            arrayList2.add(bVar);
            dVar2.f17127a = excluderB2;
            f19519d = new Gson(dVar2);
        }
    }

    public static <T> TypeAdapter<T> a(Type type, Gson gson) {
        TypeAdapter<T> typeAdapterC;
        synchronized (gson) {
            typeAdapterC = gson.c(TypeToken.get(type));
        }
        return typeAdapterC;
    }

    public static Bundle b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (Bundle) j("parseBundle", new CallableC0916w(str, 1));
    }

    public static com.oplus.melody.common.data.a c(Class cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (com.oplus.melody.common.data.a) d(str, cls);
    }

    public static <T> T d(String str, Type type) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (T) j("parseObject", new CallableC0777e(3, str, type));
    }

    public static <T> T e(byte[] bArr, Class<T> cls) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return (T) d(new String(bArr, StandardCharsets.UTF_8), cls);
    }

    public static <T> T f(InputStream inputStream, Type type) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        try {
            T t10 = (T) j("readCharStream", new com.oplus.anim.s(1, type, inputStreamReader));
            inputStreamReader.close();
            return t10;
        } catch (Throwable th) {
            try {
                inputStreamReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static byte[] g(Object obj) {
        return (obj == null || (obj instanceof byte[])) ? (byte[]) obj : (byte[]) j("toJsonBlob", new com.oplus.anim.t(obj, 1));
    }

    public static String h(Bundle bundle) {
        return (String) j("toJsonString", new com.oplus.anim.t(bundle, 2));
    }

    public static String i(Object obj) {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                return obj.toString();
            }
            String str = (String) j("toJsonString", new CallableC0916w(obj, 0));
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    public static <T> T j(String str, Callable<T> callable) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Trace.beginSection("JsonUtils#".concat(str));
        try {
            try {
                T tCall = callable.call();
                Trace.endSection();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                if (jElapsedRealtime2 > 3 && A.k()) {
                    String str2 = str + " time=" + jElapsedRealtime2 + "ms";
                    if (jElapsedRealtime2 >= 16) {
                        A.o(5, "JsonUtils", str2, new Throwable("Stack trace for slow JSON operation"));
                        return tCall;
                    }
                    A.b("JsonUtils", str2);
                }
                return tCall;
            } catch (Exception e10) {
                A.i("JsonUtils", "JSON operation failed: ".concat(str), e10);
                Trace.endSection();
                long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                if (jElapsedRealtime3 <= 3 || !A.k()) {
                    return null;
                }
                String str3 = str + " time=" + jElapsedRealtime3 + "ms";
                if (jElapsedRealtime3 >= 16) {
                    A.o(5, "JsonUtils", str3, new Throwable("Stack trace for slow JSON operation"));
                    return null;
                }
                A.b("JsonUtils", str3);
                return null;
            }
        } catch (Throwable th) {
            Trace.endSection();
            long jElapsedRealtime4 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (jElapsedRealtime4 > 3 && A.k()) {
                String str4 = str + " time=" + jElapsedRealtime4 + "ms";
                if (jElapsedRealtime4 >= 16) {
                    A.o(5, "JsonUtils", str4, new Throwable("Stack trace for slow JSON operation"));
                } else {
                    A.b("JsonUtils", str4);
                }
            }
            throw th;
        }
    }

    public static void k(OutputStream outputStream, Object obj) throws IOException {
        TypeAdapter typeAdapterA = a(obj.getClass(), a.f19518c);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        try {
            typeAdapterA.c(new L3.b(outputStreamWriter), obj);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
