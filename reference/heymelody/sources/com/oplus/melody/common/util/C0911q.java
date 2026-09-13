package com.oplus.melody.common.util;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.helper.MelodyException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: renamed from: com.oplus.melody.common.util.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FileUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0911q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f19510a = 0;

    static {
        String str = File.separator;
    }

    public static /* synthetic */ String a(long j5) {
        return "hashFile time=" + (SystemClock.elapsedRealtime() - j5);
    }

    public static boolean b(File file, File file2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                boolean zC = c(file2, fileInputStream);
                fileInputStream.close();
                return zC;
            } finally {
            }
        } catch (Exception e10) {
            A.o(5, "FileUtils", "copyFile: " + file2, e10);
            return false;
        }
    }

    public static boolean c(File file, InputStream inputStream) {
        n(file.getParentFile());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                d(inputStream, fileOutputStream);
                fileOutputStream.close();
                return true;
            } finally {
            }
        } catch (Exception e10) {
            A.o(5, "FileUtils", "copyFile: " + file, e10);
            return false;
        }
    }

    public static void d(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                outputStream.flush();
                return;
            }
            outputStream.write(bArr, 0, i10);
        }
    }

    public static boolean e(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (!e(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean f(File file, File... fileArr) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (!f(file2, fileArr)) {
                    return false;
                }
            }
        }
        if (fileArr != null) {
            for (File file3 : fileArr) {
                if (!TextUtils.isEmpty(file3.getPath()) && file3.getPath().contains(file.getPath())) {
                    return true;
                }
            }
        }
        return file.delete();
    }

    public static boolean g(String str) {
        return str != null && new File(str).exists();
    }

    public static long h(File file) throws Exception {
        File[] fileArrListFiles = file.listFiles();
        long jH = 0;
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                jH = (file2.isDirectory() ? h(file2) : file2.length()) + jH;
            }
        }
        return jH;
    }

    public static long i(File file, File... fileArr) throws Exception {
        int i10;
        File[] fileArrListFiles = file.listFiles();
        long length = 0;
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    length += i(file2, fileArr);
                } else {
                    int length2 = fileArr.length;
                    while (true) {
                        if (i10 >= length2) {
                            length = file2.length() + length;
                            break;
                        }
                        File file3 = fileArr[i10];
                        i10 = (file3 != null && file3.exists() && file3.getPath().equals(file2.getPath())) ? 0 : i10 + 1;
                    }
                }
            }
        }
        return length;
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            return K.c(messageDigest.digest());
        } catch (NoSuchAlgorithmException e10) {
            A.g("FileUtils", "hashData: $data", e10);
            return null;
        }
    }

    public static void k(File file, MessageDigest messageDigest, byte[] bArr) {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                A.h("FileUtils", "have no File");
                return;
            }
            Arrays.sort(fileArrListFiles);
            for (File file2 : fileArrListFiles) {
                k(file2, messageDigest, bArr);
            }
            return;
        }
        if (!file.isFile()) {
            A.h("FileUtils", "hashFile: IGNORE " + file);
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    int i10 = fileInputStream.read(bArr);
                    if (i10 == -1) {
                        fileInputStream.close();
                        return;
                    }
                    messageDigest.update(bArr, 0, i10);
                } finally {
                }
            }
        } catch (Exception e10) {
            A.i("FileUtils", "hashFile: " + file, e10);
        }
    }

    public static byte[] l(File file, String str) {
        if (file == null || !file.exists()) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            k(file, messageDigest, new byte[8192]);
            return messageDigest.digest();
        } catch (Exception e10) {
            A.i("FileUtils", "hashFile: " + file, e10);
            return null;
        } finally {
            A.c("FileUtils", new C0910p(0, jElapsedRealtime));
        }
    }

    public static String m(File file) {
        return K.c(l(file, "SHA-256"));
    }

    public static boolean n(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return true;
        }
        if (!file.exists() || e(file)) {
            return file.mkdirs();
        }
        return false;
    }

    public static boolean o(File file, File file2) {
        if (!file.exists() || !e(file2)) {
            return false;
        }
        n(file2.getParentFile());
        return file.renameTo(file2);
    }

    public static byte[] p(File file) {
        if (file != null && file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    d(fileInputStream, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    fileInputStream.close();
                    return byteArray;
                } finally {
                }
            } catch (Exception e10) {
                A.i("FileUtils", "readFile: " + file, e10);
            }
        }
        return new byte[0];
    }

    public static <T> T q(File file, Class<T> cls) {
        if (!file.isFile()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                T t10 = (T) C0917x.f(fileInputStream, cls);
                fileInputStream.close();
                return t10;
            } finally {
            }
        } catch (Exception e10) {
            A.i("FileUtils", "readJsonFile: " + file, e10);
            return null;
        }
    }

    public static String r(HeyMelodyApplication heyMelodyApplication, int i10) {
        try {
            InputStream inputStreamOpenRawResource = heyMelodyApplication.getResources().openRawResource(i10);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                d(inputStreamOpenRawResource, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                inputStreamOpenRawResource.close();
                return new String(byteArray, StandardCharsets.UTF_8);
            } finally {
            }
        } catch (Exception e10) {
            A.i("FileUtils", "readRawFile: " + i10, e10);
            throw MelodyException.e(0, "fail to reader raw " + i10);
        }
    }

    public static boolean s(FileInputStream fileInputStream, File file) {
        ZipInputStream zipInputStream;
        e(file);
        if (!file.mkdirs()) {
            return false;
        }
        try {
            zipInputStream = new ZipInputStream(fileInputStream);
        } catch (Exception e10) {
            A.i("FileUtils", "unzip " + file, e10);
            return false;
        }
        try {
            byte[] bArr = new byte[8192];
            String canonicalPath = file.getCanonicalPath();
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return true;
                }
                if (!nextEntry.isDirectory()) {
                    File file2 = new File(file, nextEntry.getName());
                    if (!file2.getCanonicalPath().startsWith(canonicalPath)) {
                        throw MelodyException.e(0, "canonical name check of " + nextEntry.getName());
                    }
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && (parentFile.exists() || parentFile.mkdirs())) {
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
                            while (true) {
                                try {
                                    int i10 = zipInputStream.read(bArr);
                                    if (i10 <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, i10);
                                } catch (Throwable th) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                    throw th;
                                }
                            }
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (Exception e11) {
                            A.i("FileUtils", "unzipFile", e11);
                        }
                    }
                }
                zipInputStream.closeEntry();
                A.i("FileUtils", "unzip " + file, e10);
                return false;
            }
        } finally {
        }
    }

    public static boolean t(File file, Bitmap bitmap) {
        if (!n(file.getParentFile())) {
            return false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                fileOutputStream.close();
                return true;
            } finally {
            }
        } catch (Exception e10) {
            A.i("FileUtils", "writeFile Bitmap:" + file, e10);
            return false;
        }
    }

    public static void u(File file, InputStream inputStream) {
        if (n(file.getParentFile())) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    d(inputStream, fileOutputStream);
                    fileOutputStream.close();
                } finally {
                }
            } catch (Exception e10) {
                A.i("FileUtils", "writeFile: " + file, e10);
            }
        }
    }

    public static boolean v(File file, com.oplus.melody.common.data.a aVar) {
        if (!n(file.getParentFile())) {
            return false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                C0917x.k(fileOutputStream, aVar);
                fileOutputStream.close();
                return true;
            } finally {
            }
        } catch (Exception e10) {
            A.i("FileUtils", "writeJsonFile: " + file, e10);
            return false;
        }
    }
}
