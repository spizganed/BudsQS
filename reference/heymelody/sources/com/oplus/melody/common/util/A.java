package com.oplus.melody.common.util;

import D7.o0;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseLongArray;
import b8.C0731a;
import com.oplus.drs.statistics.DataTypeConstants;
import com.oplus.melody.common.helper.MelodyException;
import g0.C1064c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: LogUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f19415a = Pattern.compile("((?<![a-z.])(oppo|oneplus|realme)(?![a-z])|一加|真我)|((?<=[0-9a-f]{8}-[0-9a-f]{4}-)[0-9a-f]{4}(?=-[0-9a-f]{4}-[0-9a-f]{12}))|((?<=(?:[0-9a-f]{2}:){2})[0-9a-f]{2}:[0-9a-f]{2}(?=(?::[0-9a-f]{2}){2}))|((?<=[0-9]{1,3}\\.)[0-9]{1,3}\\.[0-9]{1,3}(?=\\.[0-9]{1,3}))", 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f19416b = new AtomicInteger();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f19417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f19418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Boolean f19419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static androidx.collection.b<String> f19420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0731a f19421g;

    /* JADX INFO: compiled from: LogUtils.java */
    public static final class a extends androidx.collection.f<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f19422a;

        public a(String str) {
            super(64);
            this.f19422a = str;
        }

        @Override // androidx.collection.f
        public final String create(String str) {
            return (this.f19422a + str).intern();
        }
    }

    static {
        new SparseLongArray();
        f19417c = new a("Melody_");
        f19418d = "pall";
        f19419e = null;
        f19420f = null;
        f19421g = null;
    }

    public static List<String> a(String str, String str2) {
        if (k()) {
            List<String> list = S.f19463a;
            if (!"realme".equalsIgnoreCase(Build.BRAND) && f19415a.matcher(str2).find()) {
                w(str, "检测到敏感日志：" + str2, null);
            }
        }
        int length = str2.length();
        if (length <= 890) {
            return Collections.singletonList(str2);
        }
        int i10 = length / 840;
        if (i10 * 840 < length) {
            i10++;
        }
        int iIncrementAndGet = f19416b.incrementAndGet();
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        while (i11 < i10) {
            int i12 = i11 * 840;
            int iMin = Math.min(i12 + 840, length);
            StringBuilder sb2 = new StringBuilder("日志切片");
            sb2.append(iIncrementAndGet);
            sb2.append('/');
            sb2.append(i10);
            sb2.append('/');
            i11++;
            sb2.append(i11);
            sb2.append(": ");
            sb2.append(str2.substring(i12, iMin));
            arrayList.add(sb2.toString());
        }
        return arrayList;
    }

    public static void b(String str, String str2) {
        if (l()) {
            o(3, str, str2, null);
        }
    }

    public static void c(String str, Supplier<String> supplier) {
        if (l()) {
            o(3, str, t(str, supplier), null);
        }
    }

    public static void d(String str, Supplier<String> supplier, Throwable th) {
        if (l()) {
            o(3, str, t(str, supplier), th);
        }
    }

    public static String e(Object obj) {
        String strI = C0917x.i(obj);
        if (TextUtils.isEmpty(strI)) {
            return "";
        }
        Matcher matcher = f19415a.matcher(strI);
        if (!matcher.find()) {
            return strI;
        }
        StringBuilder sb2 = new StringBuilder(strI);
        do {
            int iEnd = matcher.end();
            for (int iStart = matcher.start(); iStart < iEnd; iStart++) {
                sb2.setCharAt(iStart, '*');
            }
        } while (matcher.find());
        return sb2.toString();
    }

    public static void f(String str, String str2) {
        o(4, str, e(str2), null);
    }

    public static void g(String str, String str2, Throwable th) {
        o(4, str, e(str2), th);
    }

    public static void h(String str, String str2) {
        o(6, str, str2, null);
    }

    public static void i(String str, String str2, Throwable th) {
        o(6, str, str2, th);
    }

    public static void j(String str, String str2) {
        o(4, str, str2, null);
    }

    public static boolean k() {
        return "beta".equals(f19418d);
    }

    public static boolean l() {
        return f19419e == null || f19419e.booleanValue();
    }

    public static boolean m() {
        return "rc".equals(f19418d) || "trail".equals(f19418d);
    }

    public static void n(String str) {
        Boolean bool = f19419e;
        try {
            f19419e = Boolean.valueOf(k() || m() || Log.isLoggable(f19417c.get("LogUtils"), 3) || B4.a.b("persist.sys.assert.panic"));
        } catch (Throwable th) {
            A7.b bVar = A7.b.f86a;
            String msg = e("loadLogLevel failed: " + th);
            bVar.getClass();
            kotlin.jvm.internal.h.e(msg, "msg");
            A7.b.a().f("LogUtils", msg);
            w("LogUtils", msg, null);
        }
        if (f19419e != bool) {
            x("LogUtils", "loadLogLevel d=" + f19419e + " from " + str);
            if (E7.a.d(C0906l.f19501a)) {
                return;
            }
            D7.S.d(DataTypeConstants.PAGE_VISIT, null, null);
        }
    }

    public static void o(final int i10, String str, String str2, Throwable th) {
        if (str2 != null) {
            int length = str2.length();
            int iCharCount = 0;
            while (iCharCount < length) {
                int iCodePointAt = str2.codePointAt(iCharCount);
                if (!Character.isWhitespace(iCodePointAt)) {
                    final String str3 = f19417c.get(str);
                    if (th == null) {
                        a(str, str2).forEach(new Consumer() { // from class: com.oplus.melody.common.util.z
                            @Override // java.util.function.Consumer
                            public final void accept(Object obj) {
                                A.s(i10, str3, (String) obj, null);
                            }
                        });
                        return;
                    }
                    if (!"pall".equals(f19418d)) {
                        List<String> listA = a(str, str2);
                        int size = listA.size() - 1;
                        for (int i11 = 0; i11 < size; i11++) {
                            s(i10, str3, listA.get(i11), null);
                        }
                        s(i10, str3, listA.get(size), th);
                        return;
                    }
                    StringBuilder sbE = C1064c.e(str2, " error=");
                    int i12 = MelodyException.f19407a;
                    Throwable cause = th;
                    while (true) {
                        if (cause == null) {
                            break;
                        }
                        if (!(cause instanceof CompletionException)) {
                            th = cause;
                            break;
                        }
                        cause = cause.getCause();
                    }
                    sbE.append(e(th));
                    a(str, sbE.toString()).forEach(new Consumer() { // from class: com.oplus.melody.common.util.y
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            A.s(i10, str3, (String) obj, null);
                        }
                    });
                    return;
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
        }
    }

    public static String p(String str) {
        if (TextUtils.isEmpty(str)) {
            return "empty";
        }
        if (str.length() != 32) {
            return "invalid : ".concat(str);
        }
        StringBuilder sb2 = new StringBuilder(str);
        sb2.replace(3, 29, "******");
        return sb2.toString();
    }

    public static String q(String str) {
        try {
            return TextUtils.isEmpty(str) ? "EMPTY" : v(str.trim());
        } catch (Exception unused) {
            return "INVALID";
        }
    }

    public static String r(String str) {
        return u(6, 11, str);
    }

    public static void s(int i10, String str, String str2, Throwable th) {
        if (th == null) {
            Log.println(i10, str, str2);
        } else if (i10 == 3) {
            Log.d(str, str2, th);
        } else if (i10 == 4) {
            Log.i(str, str2, th);
        } else if (i10 == 5) {
            Log.w(str, str2, th);
        } else if (i10 == 6) {
            Log.e(str, str2, th);
        }
        C0731a c0731a = f19421g;
        if (c0731a == null || i10 < 3) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Process.myPid());
        sb2.append('-');
        sb2.append(Thread.currentThread().getId());
        sb2.append(' ');
        sb2.append(str);
        sb2.append(": ");
        sb2.append(str2);
        if (th != null) {
            sb2.append(" error=");
            sb2.append(MelodyException.d(th));
        }
        I7.c cVar = new I7.c(c0731a, i10, sb2.toString(), 3);
        if (o0.c()) {
            o0.c.f1145c.execute(cVar);
        } else {
            cVar.run();
        }
    }

    public static String t(String str, Supplier supplier) {
        try {
            return (String) supplier.get();
        } catch (Throwable th) {
            i("LogUtils", "message supplier failed, tag=" + str, th);
            return "";
        }
    }

    public static String u(int i10, int i11, String str) {
        if (TextUtils.isEmpty(str)) {
            return "EMPTY";
        }
        int length = str.length();
        if (i10 < 0 || i10 >= i11 || i11 > length) {
            return "INVALID";
        }
        StringBuilder sb2 = new StringBuilder(str);
        while (i10 < i11) {
            sb2.setCharAt(i10, '*');
            i10++;
        }
        return sb2.toString();
    }

    public static String v(String str) {
        return TextUtils.isEmpty(str) ? "EMPTY" : u(0, Math.max(1, str.length() / 2), str);
    }

    public static void w(String str, String str2, Throwable th) {
        if (k()) {
            o0.d(new Ca.g(str2, 2));
            if (th == null) {
                th = new Exception("toast");
            }
        }
        i(str, e(str2), th);
    }

    public static void x(String str, String str2) {
        o(5, str, str2, null);
    }
}
