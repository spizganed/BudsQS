package com.oplus.melody.common.util;

import com.oplus.melody.common.util.FirmwareFileDO;
import ec.C1030a;
import g0.C1065d;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Properties;
import kotlin.Result;

/* JADX INFO: renamed from: com.oplus.melody.common.util.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FirmwareUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0912s {
    public static void a(int i10, int i11, StringBuilder sb2, byte[] bArr) {
        if (i10 < 0 || i11 < i10 + 10) {
            return;
        }
        if (sb2.length() > 0) {
            sb2.append('\n');
        }
        sb2.append(new String(bArr, i10, i11 - i10, C1030a.f22972b));
    }

    public static final int b(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int iMax = (int) Math.max(str.length(), str2.length());
        return c(iMax, str).compareTo(c(iMax, str2));
    }

    public static String c(int i10, String str) {
        int length = i10 - str.length();
        if (length <= 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(i10);
        for (int i11 = 0; i11 < length; i11++) {
            sb2.append('0');
        }
        sb2.append(str);
        String string = sb2.toString();
        kotlin.jvm.internal.h.d(string, "toString(...)");
        return string;
    }

    public static void d(FirmwareFileDO firmwareFileDO, File file) throws IOException {
        String property;
        String property2;
        Object objA;
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            int length = (int) file.length();
            int i10 = 0;
            if (l(fileInputStream, 4) == 1196118095) {
                firmwareFileDO.setProtocolVersion(l(fileInputStream, 1));
                if (firmwareFileDO.getProtocolVersion() == 1) {
                    firmwareFileDO.setHeaderInfo(k(fileInputStream));
                    FirmwareFileDO.a headerInfo = firmwareFileDO.getHeaderInfo();
                    int sectionCount = headerInfo != null ? headerInfo.getSectionCount() : 0;
                    ArrayList arrayList = new ArrayList(sectionCount);
                    while (i10 < sectionCount) {
                        arrayList.add(m(fileInputStream));
                        i10++;
                    }
                    firmwareFileDO.setSectionList(arrayList);
                }
            } else {
                String str = null;
                try {
                    int iMax = Math.max(length - 1024, 4);
                    int i11 = iMax - 4;
                    if (i11 > 0) {
                        fileInputStream.skip(i11);
                    }
                    byte[] bArrJ = j(fileInputStream, length - iMax);
                    StringBuilder sb2 = new StringBuilder(bArrJ.length);
                    int length2 = bArrJ.length;
                    int i12 = -1;
                    int i13 = -1;
                    for (int i14 = 0; i14 < length2; i14++) {
                        int i15 = bArrJ[i14] & 255;
                        if (i15 == 9 || i15 == 10 || i15 == 13 || (32 <= i15 && i15 < 127)) {
                            if (i12 < 0 && (i15 == 95 || Character.isLetter(i15))) {
                                i12 = i14;
                            }
                            i13 = i14 + 1;
                        } else {
                            a(i12, i13, sb2, bArrJ);
                            i12 = -1;
                            i13 = -1;
                        }
                    }
                    a(i12, i13, sb2, bArrJ);
                    String string = sb2.toString();
                    kotlin.jvm.internal.h.d(string, "toString(...)");
                    Properties properties = new Properties();
                    properties.load(new StringReader(string));
                    property = properties.getProperty("HW_VER");
                    try {
                        property2 = properties.getProperty("SW_VER");
                        try {
                            String property3 = properties.getProperty("PID");
                            if (property3 == null) {
                                property3 = properties.getProperty("PRODUCT_ID");
                            }
                            str = property3;
                            if (str != null && ec.l.H(str, "0x", true)) {
                                String strSubstring = str.substring(2);
                                kotlin.jvm.internal.h.d(strSubstring, "substring(...)");
                                str = strSubstring;
                            }
                            objA = Jb.l.f2618a;
                        } catch (Throwable th) {
                            th = th;
                            objA = kotlin.b.a(th);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        property2 = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    property = null;
                    property2 = null;
                }
                String str2 = property;
                String str3 = property2;
                Throwable thA = Result.a(objA);
                if (thA != null) {
                    A.i("FirmwareUtils", "load trailing text failed", thA);
                }
                firmwareFileDO.setProtocolVersion(0);
                if (str != null) {
                    D1.f.i(16);
                    i10 = Integer.parseInt(str, 16);
                }
                firmwareFileDO.setHeaderInfo(new FirmwareFileDO.a(0, null, length, 0, i10, 0, str2, 1, 43, null));
                firmwareFileDO.setSectionList(Kb.k.b(new FirmwareFileDO.b(0, null, str3, null, length, length, null, 0, null, 459, null)));
            }
            Jb.l lVar = Jb.l.f2618a;
            fileInputStream.close();
        } finally {
        }
    }

    public static final FirmwareFileDO e(File file) {
        Object objA;
        kotlin.jvm.internal.h.e(file, "file");
        FirmwareFileDO firmwareFileDO = new FirmwareFileDO(0, null, null, 7, null);
        try {
            d(firmwareFileDO, file);
            objA = Jb.l.f2618a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (!(objA instanceof Result.Failure)) {
            A.f("FirmwareUtils", "loadFileInfo: success " + file);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            A.g("FirmwareUtils", "loadFileInfo: failure " + file, thA);
        }
        return firmwareFileDO;
    }

    public static byte[] f(int i10, ByteBuffer byteBuffer) {
        if (i10 > byteBuffer.remaining()) {
            return new byte[0];
        }
        byte[] bArr = new byte[i10];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static int g(ByteBuffer byteBuffer) {
        return byteBuffer.get() & 255;
    }

    public static String h(int i10, ByteBuffer byteBuffer) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b4 : f(i10, byteBuffer)) {
            int i11 = b4 & 255;
            if (i11 < 10) {
                i11 += 48;
            }
            sb2.appendCodePoint(i11);
        }
        return sb2.toString();
    }

    public static String i(int i10, ByteBuffer byteBuffer) {
        byte[] bArrF = f(i10, byteBuffer);
        Charset charset = StandardCharsets.UTF_8;
        if (bArrF.length == 0) {
            return "";
        }
        int i11 = 0;
        while (i11 < bArrF.length && bArrF[i11] != 0) {
            i11++;
        }
        return new String(bArrF, 0, i11, charset);
    }

    public static byte[] j(FileInputStream fileInputStream, int i10) throws IOException {
        byte[] bArr = new byte[i10];
        int i11 = fileInputStream.read(bArr);
        if (i10 == i11) {
            return bArr;
        }
        throw new EOFException(C1065d.e("readByteArray expect ", " but ", i10, i11));
    }

    public static FirmwareFileDO.a k(FileInputStream fileInputStream) throws IOException {
        int iL = l(fileInputStream, 4);
        if (iL < 46) {
            throw new EOFException(A6.b.d(iL, "readHeaderInfo expect 46 but "));
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(j(fileInputStream, iL)).order(ByteOrder.LITTLE_ENDIAN);
        kotlin.jvm.internal.h.d(byteBufferOrder, "order(...)");
        return new FirmwareFileDO.a(g(byteBufferOrder), f(32, byteBufferOrder), byteBufferOrder.getInt(), g(byteBufferOrder), byteBufferOrder.getInt(), g(byteBufferOrder), h(2, byteBufferOrder), g(byteBufferOrder));
    }

    public static int l(FileInputStream fileInputStream, int i10) throws IOException {
        byte[] bArrJ = j(fileInputStream, i10);
        int length = bArrJ.length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < length) {
            i12 += (bArrJ[i11] & 255) << (i13 * 8);
            i11++;
            i13++;
        }
        return i12;
    }

    public static FirmwareFileDO.b m(FileInputStream fileInputStream) throws IOException {
        int iL = l(fileInputStream, 4);
        if (iL < 104) {
            throw new EOFException(A6.b.d(iL, "readSectionInfo expect 104 but "));
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(j(fileInputStream, iL)).order(ByteOrder.LITTLE_ENDIAN);
        kotlin.jvm.internal.h.d(byteBufferOrder, "order(...)");
        return new FirmwareFileDO.b(g(byteBufferOrder), i(32, byteBufferOrder), h(3, byteBufferOrder), i(24, byteBufferOrder), byteBufferOrder.getInt(), byteBufferOrder.getInt(), f(32, byteBufferOrder), byteBufferOrder.getInt(), f(32, byteBufferOrder));
    }
}
