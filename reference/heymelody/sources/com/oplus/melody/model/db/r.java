package com.oplus.melody.model.db;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.oplus.melody.common.util.C0911q;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: DatabaseEncryptUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f19782a = Pattern.compile("^[A-Za-z0-9]{64}$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final O7.l<Map<String, String>> f19783b = new O7.l<>();

    public static androidx.lifecycle.t a(androidx.lifecycle.s sVar) {
        androidx.lifecycle.t tVar = new androidx.lifecycle.t();
        tVar.m(sVar, new A6.l(tVar, 16));
        tVar.m(f19783b, new C6.d(2, sVar, tVar));
        return tVar;
    }

    @SuppressLint({"ApplySharedPref"})
    public static String b(String str) {
        String key;
        if (TextUtils.isEmpty(str) || f(str)) {
            return str;
        }
        Iterator<Map.Entry<String, String>> it = d().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                key = null;
                break;
            }
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                key = next.getKey();
                break;
            }
        }
        if (f(key)) {
            return key;
        }
        String strJ = C0911q.j(str);
        androidx.collection.a aVar = new androidx.collection.a();
        aVar.putAll(d());
        aVar.put(strJ, str);
        if (f19783b.m(aVar)) {
            t8.q.c("melody-hash_data-map").edit().putString(strJ, str).apply();
        }
        Pattern pattern = com.oplus.melody.common.util.A.f19415a;
        return strJ;
    }

    public static String c(String str) {
        if (f(str)) {
            String str2 = d().get(str);
            if (!TextUtils.isEmpty(str2)) {
                Pattern pattern = com.oplus.melody.common.util.A.f19415a;
                return str2;
            }
        }
        return str;
    }

    public static Map<String, String> d() {
        O7.l<Map<String, String>> lVar = f19783b;
        if (lVar.d() == null) {
            synchronized (lVar) {
                try {
                    if (lVar.d() == null) {
                        androidx.collection.a aVar = new androidx.collection.a();
                        for (Map.Entry<String, ?> entry : t8.q.c("melody-hash_data-map").getAll().entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (key != null && value != null) {
                                aVar.put(key, value.toString());
                            }
                        }
                        f19783b.m(aVar);
                    }
                } finally {
                }
            }
        }
        return f19783b.d();
    }

    public static double e(String str) {
        if (!f(str)) {
            return 0.0d;
        }
        String str2 = d().get(str);
        if (TextUtils.isEmpty(str2)) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str2);
        } catch (NumberFormatException e10) {
            com.oplus.melody.common.util.A.g("DatabaseEncryptUtils", "getLocationByHashData, result: 0.0, hash: " + str, e10);
            return 0.0d;
        }
    }

    public static boolean f(String str) {
        return str != null && str.length() == 64 && f19782a.matcher(str).matches();
    }
}
