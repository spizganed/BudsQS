package com.oplus.melody.common.util;

import D7.c0;
import D7.o0;
import android.app.OplusActivityManager;
import android.app.OplusWhiteListManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.oplus.app.IOplusProtectConnection;
import g0.C1065d;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ServiceUtils {
    public static final String EXTRA_BOOLEAN_RESTART = "restart";
    private static final int RETRY_ADD_STAGE_PROTECT_COUNT_ON_ERROR = 3;
    private static final int RETRY_ADD_STAGE_PROTECT_COUNT_ON_TIMEOUT = 15;
    private static final String TAG = "ServiceUtils";
    private static Object sOplusActivityManager;
    private static Object sOplusProtectConnection;
    private static Object sOplusWhiteListManager;
    public static final long SELF_PROTECT_TIMEOUT = TimeUnit.HOURS.toMillis(2);
    private static final AtomicInteger sAddStageProtectInfoErrorCount = new AtomicInteger(0);
    private static final AtomicInteger sAddStageProtectInfoTimeoutCount = new AtomicInteger(0);
    private static final Runnable sAddStageProtectRunnable = new c0(1);

    public static void addStageProtectInfo(Context context) {
        if (S.s(context)) {
            return;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (sOplusWhiteListManager == null) {
                sOplusWhiteListManager = new OplusWhiteListManager(context);
            }
            if (sOplusProtectConnection == null) {
                sOplusProtectConnection = new IOplusProtectConnection.Stub() { // from class: com.oplus.melody.common.util.ServiceUtils.1
                    public void onError(int i10) {
                        A.h(ServiceUtils.TAG, "addStageProtectInfo onError! errorCode = " + i10);
                        if (i10 != 1 || ServiceUtils.sAddStageProtectInfoErrorCount.incrementAndGet() > 3) {
                            return;
                        }
                        D7.E e10 = o0.c.f1145c;
                        e10.a().removeCallbacks(ServiceUtils.sAddStageProtectRunnable);
                        e10.a().postDelayed(ServiceUtils.sAddStageProtectRunnable, 15000L);
                    }

                    public void onSuccess() {
                        A.x(ServiceUtils.TAG, "addStageProtectInfo onSuccess!");
                        ServiceUtils.sAddStageProtectInfoErrorCount.set(0);
                    }

                    public void onTimeout() {
                        int iIncrementAndGet = ServiceUtils.sAddStageProtectInfoTimeoutCount.incrementAndGet();
                        A.h(ServiceUtils.TAG, "addStageProtectInfo onTimeout! count = " + iIncrementAndGet);
                        if (iIncrementAndGet <= 15) {
                            D7.E e10 = o0.c.f1145c;
                            e10.a().removeCallbacks(ServiceUtils.sAddStageProtectRunnable);
                            e10.a().post(ServiceUtils.sAddStageProtectRunnable);
                        }
                    }
                };
            }
            String packageName = context.getPackageName();
            ((OplusWhiteListManager) sOplusWhiteListManager).addStageProtectInfo(packageName, "legacy_call", SELF_PROTECT_TIMEOUT, (IOplusProtectConnection.Stub) sOplusProtectConnection);
            A.f(TAG, "addStageProtectInfo " + packageName + " time=" + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        } catch (Exception e10) {
            e = e10;
            A.i(TAG, "addStageProtectInfo", e);
        } catch (NoClassDefFoundError e11) {
            e = e11;
            A.i(TAG, "addStageProtectInfo", e);
        }
    }

    public static void enableBackgroundService(Context context) {
        if (S.s(context)) {
            return;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (sOplusActivityManager == null) {
                sOplusActivityManager = new OplusActivityManager();
            }
            ((OplusActivityManager) sOplusActivityManager).addBackgroundRestrictedInfo(context.getPackageName(), Collections.singletonList(context.getPackageName()));
            A.c(TAG, new com.oplus.melody.app.discovery.P(1, jElapsedRealtime));
        } catch (Exception e10) {
            e = e10;
            A.i(TAG, "enableBackgroundService:", e);
        } catch (NoClassDefFoundError e11) {
            e = e11;
            A.i(TAG, "enableBackgroundService:", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$enableBackgroundService$1(long j5) {
        return "enableBackgroundService time=" + (SystemClock.elapsedRealtime() - j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0() {
        addStageProtectInfo(C0906l.f19501a);
    }

    public static void removeStageProtectInfo(Context context) {
        o0.c.f1145c.a().removeCallbacks(sAddStageProtectRunnable);
        if (sOplusWhiteListManager != null) {
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                String packageName = context.getPackageName();
                ((OplusWhiteListManager) sOplusWhiteListManager).removeStageProtectInfo(packageName);
                A.f(TAG, "removeStageProtectInfo " + packageName + " time=" + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            } catch (Exception | NoClassDefFoundError e10) {
                A.i(TAG, "removeStageProtectInfo", e10);
            }
        }
    }

    public static void resetRetryAddStageProtectCount() {
        sAddStageProtectInfoErrorCount.set(0);
        sAddStageProtectInfoTimeoutCount.set(0);
    }

    public static void startBackgroundService(Context context, boolean z2) {
        String packageName = context.getPackageName();
        Intent intent = new Intent(C1065d.c(packageName, ".alive.action.SEND_COMMAND"));
        intent.putExtra(EXTRA_BOOLEAN_RESTART, z2);
        intent.setPackage(packageName);
        startService(context, intent);
    }

    public static void startForegroundService(Context context, Intent intent) {
        kotlin.jvm.internal.h.e(intent, "intent");
        if (context == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        } catch (Throwable th) {
            A.i("ContextExt", "startForegroundServiceCompat", th);
        }
    }

    public static void startService(Context context, Intent intent) {
        if (o0.c()) {
            C0905k.l(context, intent);
            return;
        }
        kotlin.jvm.internal.h.e(intent, "intent");
        if (context == null) {
            return;
        }
        try {
            context.startService(intent);
        } catch (Throwable th) {
            A.i("ContextExt", "startServiceCompat", th);
        }
    }

    public static void stopBackgroundService(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent(C1065d.c(packageName, ".alive.action.SEND_COMMAND"));
        intent.setPackage(packageName);
        stopService(context, intent);
    }

    public static void stopService(Context context, Intent intent) {
        if (o0.c()) {
            C0905k.m(context, intent);
            return;
        }
        kotlin.jvm.internal.h.e(intent, "intent");
        if (context == null) {
            return;
        }
        try {
            context.stopService(intent);
        } catch (Throwable th) {
            A.i("ContextExt", "stopServiceCompat", th);
        }
    }
}
