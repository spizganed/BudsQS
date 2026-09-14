package com.oplus.melody.model.util;

import D1.f;
import D7.o0;
import Jb.b;
import L8.RunnableC0474v;
import c9.l;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import ec.m;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.format.DateTimeFormatter;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.a;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: ExceptionCatchHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/oplus/melody/model/util/ExceptionCatchHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "<init>", "()V", "defaultHandler", "uncaughtException", "", "thread", "Ljava/lang/Thread;", "ex", "", "handleException", "", "throwable", "Companion", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExceptionCatchHandler implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b<ExceptionCatchHandler> f20233b = a.a(new A9.b(9));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f20234a = Thread.getDefaultUncaughtExceptionHandler();

    public ExceptionCatchHandler() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable ex) {
        String strL;
        boolean zI;
        boolean zI2;
        boolean zI3;
        HeyMelodyApplication heyMelodyApplication;
        h.e(thread, "thread");
        h.e(ex, "ex");
        boolean z2 = false;
        try {
            strL = f.L(ex);
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault()));
            String message = ex.getMessage();
            boolean zI4 = message != null ? m.I(message, "Exception while computing database live data", false) : false;
            String message2 = ex.getMessage();
            zI = zI4 | (message2 != null ? m.I(message2, "database or disk is full", false) : false);
            zI2 = m.I(strL, "code 4874 SQLITE_IOERR_SHMSIZE", false);
            zI3 = m.I(strL, "SharedPreferences in credential encrypted storage are not available", false);
            heyMelodyApplication = C0906l.f19501a;
        } catch (Exception e10) {
            A.i("ExceptionCatchHandler", "handleException", e10);
        }
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        long jB = t8.m.b(heyMelodyApplication);
        boolean z4 = zI | zI2;
        if (z4 || zI3) {
            A.e(ex.getMessage());
            B8.a.e();
        } else {
            if (strL.length() > 2048) {
                strL = strL.substring(0, 2048);
                h.d(strL, "substring(...)");
            }
            A.e(ex.getMessage());
            A.e(strL);
            B8.a.e();
        }
        if (zI2) {
            long j5 = 2000000000;
            if (jB <= 2000000000) {
                j5 = jB;
            }
            A.c("LowStorageHelper", new l(1, j5, t8.m.f27942a.edit().putLong("storage_low_size", j5).commit()));
        }
        A.x("ExceptionCatchHandler", "handleException, dbCrash = " + zI + ", storageLowCrash = " + zI2 + ", isSpNotAvailable = " + zI3 + ", freeSpace = " + (jB / 1000000));
        z2 = z4 | zI3;
        if (z2) {
            o0.b.f1142a.schedule(new RunnableC0474v(8), 1L, TimeUnit.SECONDS);
            return;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f20234a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, ex);
        }
    }
}
