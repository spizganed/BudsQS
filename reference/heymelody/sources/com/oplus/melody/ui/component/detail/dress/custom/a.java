package com.oplus.melody.ui.component.detail.dress.custom;

import java.util.Locale;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import kotlin.text.Regex;

/* JADX INFO: compiled from: MimeTypeHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f20940a = kotlin.collections.a.d0(new Pair("image/png", ".png"), new Pair("image/jpeg", ".jpg"), new Pair("image/x-ms-bmp", ".bmp"), new Pair("image/gif", ".gif"), new Pair("video/mp4", ".mp4"));

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.custom.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MimeTypeHelper.kt */
    public static final class C0234a {
        public static String a(String type) {
            h.e(type, "type");
            String lowerCase = ((String[]) new Regex("/").g(type).toArray(new String[0]))[0].toLowerCase(Locale.ROOT);
            h.d(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
        public static String b(String str) {
            String str2 = (String) a.f20940a.get(str);
            return str2 == null ? ".temp" : str2;
        }
    }
}
