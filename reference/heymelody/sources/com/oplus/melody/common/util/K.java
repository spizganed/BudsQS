package com.oplus.melody.common.util;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: MelodyTextUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f19445a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static byte[] a(int i10, String str) {
        byte[] bytes = TextUtils.isEmpty(str) ? new byte[0] : str.getBytes(StandardCharsets.UTF_8);
        return (bytes == null || bytes.length == 0) ? new byte[i10] : bytes.length == i10 ? bytes : Arrays.copyOf(bytes, i10);
    }

    public static int b(int i10, Object obj) {
        String string = obj == null ? "" : obj.toString();
        if (TextUtils.isEmpty(string)) {
            return i10;
        }
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException unused) {
            A.h("MelodyTextUtils", "parseInt failed '" + string + '\'');
            int length = string.length();
            int i11 = 0;
            while (i11 < length && !Character.isDigit(string.charAt(i11))) {
                i11++;
            }
            int i12 = i11 + 1;
            while (i12 < length && Character.isDigit(string.charAt(i12))) {
                i12++;
            }
            return (i11 < 0 || i12 > length) ? i10 : Integer.parseInt(string.subSequence(i11, i12).toString(), 10);
        }
    }

    public static String c(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? "" : d(bArr, 0, bArr.length, false, "");
    }

    public static String d(byte[] bArr, int i10, int i11, boolean z2, String str) {
        if (bArr == null || i10 < 0 || i11 <= 0 || i10 + i11 > bArr.length) {
            return "";
        }
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(((length + 2) * i11) - length);
        char[] cArr = f19445a;
        if (z2) {
            for (int i12 = i11; i12 > 0; i12--) {
                if (length > 0 && i12 < i11) {
                    sb2.append((CharSequence) str);
                }
                byte b4 = bArr[(i10 + i12) - 1];
                sb2.append(cArr[((b4 & 255) >>> 4) & 15]);
                sb2.append(cArr[b4 & 15]);
            }
        } else {
            for (int i13 = 0; i13 < i11; i13++) {
                if (length > 0 && i13 > 0) {
                    sb2.append((CharSequence) str);
                }
                byte b5 = bArr[i10 + i13];
                sb2.append(cArr[((b5 & 255) >>> 4) & 15]);
                sb2.append(cArr[b5 & 15]);
            }
        }
        return sb2.toString();
    }

    public static String e(long j5) {
        double d10 = (j5 * 1.0d) / 1024.0d;
        if (d10 < 1024.0d) {
            return String.format(Locale.ENGLISH, "%.1f KB", Double.valueOf(d10));
        }
        double d11 = d10 / 1024.0d;
        return d11 < 1024.0d ? String.format(Locale.ENGLISH, "%.1f MB", Double.valueOf(d11)) : String.format(Locale.ENGLISH, "%.1f GB", Double.valueOf(d11 / 1024.0d));
    }

    public static String f(Object obj) {
        return obj == null ? "null" : Integer.toHexString(System.identityHashCode(obj));
    }
}
