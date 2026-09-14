package com.oplus.melody.common.util;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: com.oplus.melody.common.util.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CountryCodeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0907m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f19502a = Arrays.asList("AT", "BE", "BG", "CH", "CY", "CZ", "DE", "DK", "EE", "ES", "EUEX", "FI", "FR", "GB", "GR", "HR", "HU", "IE", "IS", "IT", "LI", "LT", "LU", "LV", "MT", "NL", "NO", "PL", "PT", "RO", "SE", "SI", "SK", "TR");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f19503b = Arrays.asList("CA", "US");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f19504c = Collections.singletonList("IN");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f19505d = null;

    public static String a() {
        String country;
        if (f19505d == null) {
            synchronized (C0907m.class) {
                try {
                    if (f19505d == null) {
                        String[] strArr = {"ro.oplus.pipeline.region", "ro.vendor.oplus.regionmark", "ro.vendor.oppo.regionmark", "ro.build.region"};
                        int i10 = 0;
                        while (true) {
                            if (i10 >= 4) {
                                country = null;
                                break;
                            }
                            String str = strArr[i10];
                            try {
                                country = B4.a.a(str);
                            } catch (Exception e10) {
                                A.i("CountryCodeUtils", "getSystemProperty " + str, e10);
                            }
                            if (country != null && !country.isEmpty()) {
                                break;
                            }
                            i10++;
                        }
                        if (TextUtils.isEmpty(country)) {
                            country = Locale.getDefault().getCountry();
                            if (TextUtils.isEmpty(country)) {
                                country = "SG";
                                A.x("CountryCodeUtils", "getCountryCode [SG] from default");
                            } else {
                                A.x("CountryCodeUtils", "getCountryCode [" + country + "] from locale");
                            }
                        } else {
                            A.x("CountryCodeUtils", "getCountryCode [" + country + "] from mark region");
                        }
                        f19505d = country.trim().toUpperCase();
                    }
                } finally {
                }
            }
        }
        return f19505d;
    }
}
