package com.oplus.melody.common.util;

import android.content.Context;
import android.content.res.AssetManager;
import com.oplus.melody.common.helper.MelodyException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: RepackagingDetector.java */
/* JADX INFO: loaded from: classes.dex */
public final class T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile byte[] f19474a;

    public T() {
        throw MelodyException.e(501, "RepackagingDetector cannot be instantiated");
    }

    public static byte[] a(byte[] bArr) {
        try {
            if (bArr.length == 0) {
                A.h("RepackagingDetector", "Certificate bytes is null or empty");
                return null;
            }
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    byte[] encoded = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream)).getEncoded();
                    byteArrayInputStream.close();
                    bArr = encoded;
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (CertificateException unused) {
                A.x("RepackagingDetector", "Cannot parse as X.509 certificate, using raw bytes (may be PKCS#7). Hash may differ from PackageManager.");
            }
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (Throwable th3) {
            A.i("RepackagingDetector", "Error calculating signature hash", th3);
            return null;
        }
    }

    public static byte[] b(Context context) {
        byte[] bArr = f19474a;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        synchronized (T.class) {
            try {
                if (f19474a == null || f19474a.length == 0) {
                    byte[] bArrD = null;
                    if (context == null) {
                        A.h("RepackagingDetector", "Context is null in getCurrentSignatureHash");
                    } else {
                        try {
                            if (e(context)) {
                                A.h("RepackagingDetector", "LSPatch detected in assets directory!");
                            } else {
                                byte[] bArrC = c(context);
                                if (bArrC == null || bArrC.length <= 0) {
                                    A.x("RepackagingDetector", "Failed to read signature from APK file, fallback to PackageManager");
                                    bArrD = d(context);
                                } else {
                                    bArrD = bArrC;
                                }
                            }
                        } catch (Throwable th) {
                            A.i("RepackagingDetector", "Error getting signature hash", th);
                        }
                    }
                    f19474a = bArrD;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f19474a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0051 A[Catch: all -> 0x0047, TRY_LEAVE, TryCatch #1 {all -> 0x0047, blocks: (B:17:0x0029, B:20:0x0030, B:22:0x003b, B:25:0x0042, B:29:0x0049, B:30:0x0051, B:15:0x0021, B:3:0x0005, B:5:0x000b, B:9:0x0014, B:11:0x0018, B:13:0x001e), top: B:35:0x0005, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] c(android.content.Context r5) {
        /*
            java.lang.String r0 = "RepackagingDetector"
            java.lang.String r1 = "APK file not found: "
            r2 = 0
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo()     // Catch: java.lang.Throwable -> L12
            if (r5 != 0) goto L14
            java.lang.String r5 = "ApplicationInfo is null"
            com.oplus.melody.common.util.A.h(r0, r5)     // Catch: java.lang.Throwable -> L12
        L10:
            r3 = r2
            goto L27
        L12:
            r5 = move-exception
            goto L21
        L14:
            java.lang.String r3 = r5.publicSourceDir     // Catch: java.lang.Throwable -> L12
            if (r3 == 0) goto L1e
            boolean r4 = r3.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r4 == 0) goto L27
        L1e:
            java.lang.String r3 = r5.sourceDir     // Catch: java.lang.Throwable -> L12
            goto L27
        L21:
            java.lang.String r3 = "Error getting APK path"
            com.oplus.melody.common.util.A.i(r0, r3, r5)     // Catch: java.lang.Throwable -> L47
            goto L10
        L27:
            if (r3 == 0) goto L51
            boolean r5 = r3.isEmpty()     // Catch: java.lang.Throwable -> L47
            if (r5 == 0) goto L30
            goto L51
        L30:
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L47
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L47
            boolean r4 = r5.exists()     // Catch: java.lang.Throwable -> L47
            if (r4 == 0) goto L49
            boolean r4 = r5.isFile()     // Catch: java.lang.Throwable -> L47
            if (r4 != 0) goto L42
            goto L49
        L42:
            byte[] r5 = g(r5)     // Catch: java.lang.Throwable -> L47
            return r5
        L47:
            r5 = move-exception
            goto L57
        L49:
            java.lang.String r5 = r1.concat(r3)     // Catch: java.lang.Throwable -> L47
            com.oplus.melody.common.util.A.h(r0, r5)     // Catch: java.lang.Throwable -> L47
            goto L56
        L51:
            java.lang.String r5 = "Failed to get APK path"
            com.oplus.melody.common.util.A.h(r0, r5)     // Catch: java.lang.Throwable -> L47
        L56:
            return r2
        L57:
            java.lang.String r1 = "Error reading signature from APK file"
            com.oplus.melody.common.util.A.i(r0, r1, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.common.util.T.c(android.content.Context):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] d(android.content.Context r5) {
        /*
            java.lang.String r0 = "RepackagingDetector"
            r1 = 0
            java.lang.String r2 = r5.getPackageName()     // Catch: java.lang.Throwable -> L1c
            if (r2 == 0) goto L78
            boolean r3 = r2.isEmpty()     // Catch: java.lang.Throwable -> L1c
            if (r3 == 0) goto L10
            goto L78
        L10:
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L1c
            if (r5 != 0) goto L1e
            java.lang.String r5 = "PackageManager is null"
            com.oplus.melody.common.util.A.h(r0, r5)     // Catch: java.lang.Throwable -> L1c
            return r1
        L1c:
            r5 = move-exception
            goto L7e
        L1e:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1c
            r4 = 28
            if (r3 < r4) goto L4e
            r3 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r2, r3)     // Catch: java.lang.Throwable -> L1c
            if (r5 == 0) goto L59
            android.content.pm.SigningInfo r2 = K.d.d(r5)     // Catch: java.lang.Throwable -> L1c
            if (r2 == 0) goto L59
            android.content.pm.SigningInfo r2 = K.d.d(r5)     // Catch: java.lang.Throwable -> L1c
            boolean r2 = B.s.o(r2)     // Catch: java.lang.Throwable -> L1c
            if (r2 == 0) goto L45
            android.content.pm.SigningInfo r5 = K.d.d(r5)     // Catch: java.lang.Throwable -> L1c
            android.content.pm.Signature[] r5 = K.c.r(r5)     // Catch: java.lang.Throwable -> L1c
            goto L5a
        L45:
            android.content.pm.SigningInfo r5 = K.d.d(r5)     // Catch: java.lang.Throwable -> L1c
            android.content.pm.Signature[] r5 = B.v.p(r5)     // Catch: java.lang.Throwable -> L1c
            goto L5a
        L4e:
            r3 = 64
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r2, r3)     // Catch: java.lang.Throwable -> L1c
            if (r5 == 0) goto L59
            android.content.pm.Signature[] r5 = r5.signatures     // Catch: java.lang.Throwable -> L1c
            goto L5a
        L59:
            r5 = r1
        L5a:
            if (r5 == 0) goto L72
            int r2 = r5.length     // Catch: java.lang.Throwable -> L1c
            if (r2 != 0) goto L60
            goto L72
        L60:
            java.lang.String r2 = "SHA-256"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch: java.lang.Throwable -> L1c
            r3 = 0
            r5 = r5[r3]     // Catch: java.lang.Throwable -> L1c
            byte[] r5 = r5.toByteArray()     // Catch: java.lang.Throwable -> L1c
            byte[] r5 = r2.digest(r5)     // Catch: java.lang.Throwable -> L1c
            return r5
        L72:
            java.lang.String r5 = "No signatures found from PackageManager"
            com.oplus.melody.common.util.A.h(r0, r5)     // Catch: java.lang.Throwable -> L1c
            return r1
        L78:
            java.lang.String r5 = "Package name is null or empty"
            com.oplus.melody.common.util.A.h(r0, r5)     // Catch: java.lang.Throwable -> L1c
            return r1
        L7e:
            java.lang.String r2 = "Error getting signature from PackageManager"
            com.oplus.melody.common.util.A.i(r0, r2, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.common.util.T.d(android.content.Context):byte[]");
    }

    public static boolean e(Context context) throws IOException {
        AssetManager assets;
        try {
            assets = context.getAssets();
        } catch (Throwable unused) {
        }
        if (assets == null) {
            A.h("RepackagingDetector", "AssetManager is null");
            return false;
        }
        try {
            String[] list = assets.list("lspatch");
            if (list != null && list.length > 0) {
                A.h("RepackagingDetector", "Found lspatch directory in assets with " + list.length + " items");
                return true;
            }
        } catch (IOException unused2) {
        }
        String[] list2 = assets.list("");
        if (list2 != null) {
            for (String str : list2) {
                if (str.toLowerCase().contains("lspatch")) {
                    A.h("RepackagingDetector", "Found lspatch in assets root: " + str);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean f(String str) {
        if (str == null || str.isEmpty() || str.contains("../") || str.contains("..\\") || str.startsWith("/")) {
            return false;
        }
        try {
            return !new File(str).getCanonicalPath().contains("..");
        } catch (IOException e10) {
            A.o(5, "RepackagingDetector", "Failed to normalize zip entry name: ".concat(str), e10);
            return false;
        }
    }

    public static byte[] g(File file) {
        Enumeration<? extends ZipEntry> enumerationEntries;
        try {
            ZipFile zipFile = new ZipFile(file);
            try {
                enumerationEntries = zipFile.entries();
            } finally {
            }
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                String name = zipEntryNextElement.getName();
                if (!f(name)) {
                    A.h("RepackagingDetector", "Invalid zip entry name detected: " + name);
                } else if (name.startsWith("META-INF/") && (name.endsWith(".RSA") || name.endsWith(".DSA"))) {
                    InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                    try {
                        int i10 = C0911q.f19510a;
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        C0911q.d(inputStream, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (byteArray != null && byteArray.length > 0) {
                            byte[] bArrA = a(byteArray);
                            inputStream.close();
                            zipFile.close();
                            return bArrA;
                        }
                        inputStream.close();
                    } finally {
                    }
                }
            }
            A.h("RepackagingDetector", "No signature file found in APK");
            zipFile.close();
            return null;
        } catch (IOException e10) {
            A.i("RepackagingDetector", "Error reading APK file", e10);
            return null;
        } catch (Throwable th) {
            A.i("RepackagingDetector", "Error parsing signature from APK", th);
            return null;
        }
    }
}
