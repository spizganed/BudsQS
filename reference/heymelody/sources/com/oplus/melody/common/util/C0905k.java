package com.oplus.melody.common.util;

import D7.C0384s;
import D7.o0;
import D7.q0;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.helper.MelodyException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.common.util.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContextExt.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0905k {
    public static final boolean a(Context context, String targetName, String str) {
        kotlin.jvm.internal.h.e(targetName, "targetName");
        if (context == null) {
            return false;
        }
        A.f("ContextExt", "enterAppMarket id=" + targetName + " market=" + str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + targetName + "&caller=" + context.getPackageName()));
        intent.addFlags(268435456);
        if (str != null && str.length() != 0) {
            intent.setPackage(str);
        }
        return j(context, intent);
    }

    public static final void b(HeyMelodyApplication heyMelodyApplication, Uri uri, ContentObserver observer) {
        kotlin.jvm.internal.h.e(uri, "uri");
        kotlin.jvm.internal.h.e(observer, "observer");
        if (heyMelodyApplication != null) {
            try {
                ContentResolver contentResolver = heyMelodyApplication.getContentResolver();
                if (contentResolver != null) {
                    contentResolver.registerContentObserver(uri, true, observer);
                }
            } catch (Throwable th) {
                A.i("ContextExt", "registerContentObserverCompat", th);
            }
        }
    }

    public static final CompletableFuture c(final Context context, final BroadcastReceiver receiver, final IntentFilter filter, final String str, final Handler handler) {
        kotlin.jvm.internal.h.e(receiver, "receiver");
        kotlin.jvm.internal.h.e(filter, "filter");
        if (context == null) {
            return q0.b(MelodyException.e(0, "registerReceiverAsync on null"));
        }
        CompletableFuture completableFutureSupplyAsync = CompletableFuture.supplyAsync(new Supplier() { // from class: com.oplus.melody.common.util.j
            @Override // java.util.function.Supplier
            public final Object get() {
                return C0905k.g(context, receiver, filter, str, handler, true);
            }
        });
        kotlin.jvm.internal.h.d(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }

    public static final CompletableFuture<Intent> d(final Context context, final BroadcastReceiver receiver, final IntentFilter intentFilter, final boolean z2) {
        kotlin.jvm.internal.h.e(receiver, "receiver");
        if (context == null) {
            return q0.b(MelodyException.e(0, "registerReceiverAsync on null"));
        }
        CompletableFuture<Intent> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new Supplier() { // from class: com.oplus.melody.common.util.h
            @Override // java.util.function.Supplier
            public final Object get() {
                BroadcastReceiver receiver2 = receiver;
                kotlin.jvm.internal.h.e(receiver2, "receiver");
                return C0905k.g(context, receiver2, intentFilter, null, o0.c.f1143a, z2);
            }
        });
        kotlin.jvm.internal.h.d(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }

    public static final void e(Context context, BroadcastReceiver receiver, IntentFilter intentFilter) {
        kotlin.jvm.internal.h.e(receiver, "receiver");
        d(context, receiver, intentFilter, true);
    }

    public static final void f(Context context, BroadcastReceiver receiver, IntentFilter filter, String str, Handler handler) {
        kotlin.jvm.internal.h.e(receiver, "receiver");
        kotlin.jvm.internal.h.e(filter, "filter");
        c(context, receiver, filter, str, handler);
    }

    public static final Intent g(Context context, BroadcastReceiver receiver, IntentFilter filter, String str, Handler handler, boolean z2) {
        kotlin.jvm.internal.h.e(receiver, "receiver");
        kotlin.jvm.internal.h.e(filter, "filter");
        if (context == null) {
            return null;
        }
        try {
            if (Build.VERSION.SDK_INT >= 34) {
                return context.registerReceiver(receiver, filter, str, handler, z2 ? 2 : 4);
            }
            return context.registerReceiver(receiver, filter, str, handler);
        } catch (Throwable th) {
            A.i("ContextExt", "registerReceiverCompat", th);
            return null;
        }
    }

    public static final ComponentName h(Context context, Intent intent) {
        kotlin.jvm.internal.h.e(intent, "<this>");
        kotlin.jvm.internal.h.e(context, "context");
        if (intent.getComponent() == null) {
            intent.setComponent(intent.resolveActivity(context.getPackageManager()));
        }
        return intent.getComponent();
    }

    public static final void i(Context context, Intent intent, String str) {
        if (context == null) {
            q0.b(MelodyException.e(0, "sendBroadcastAsync on null"));
        } else {
            kotlin.jvm.internal.h.d(CompletableFuture.runAsync(new D7.I(context, intent, str, 10)), "runAsync(...)");
        }
    }

    public static final boolean j(Context context, Intent intent) {
        kotlin.jvm.internal.h.e(intent, "intent");
        if (context == null) {
            return false;
        }
        try {
            ComponentName componentNameH = h(context, intent);
            if (componentNameH != null && A.l()) {
                A.f("ContextExt", "startActivityCompat " + componentNameH);
            }
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            A.i("ContextExt", "startActivityCompat", th);
            return false;
        }
    }

    public static final boolean k(Activity activity, Intent intent, int i10) {
        kotlin.jvm.internal.h.e(intent, "intent");
        if (activity == null) {
            return false;
        }
        try {
            ComponentName componentNameH = h(activity, intent);
            if (componentNameH != null && A.l()) {
                A.f("ContextExt", "startActivityForResultCompat " + componentNameH);
            }
            activity.startActivityForResult(intent, i10);
            return true;
        } catch (Throwable th) {
            A.i("ContextExt", "startActivityForResultCompat", th);
            return false;
        }
    }

    public static final void l(Context context, Intent intent) {
        kotlin.jvm.internal.h.e(intent, "intent");
        if (context == null) {
            q0.b(MelodyException.e(0, "startServiceAsync on null"));
        } else {
            kotlin.jvm.internal.h.d(CompletableFuture.supplyAsync(new C0384s(20, context, intent)), "supplyAsync(...)");
        }
    }

    public static final void m(Context context, Intent intent) {
        kotlin.jvm.internal.h.e(intent, "intent");
        if (context == null) {
            q0.b(MelodyException.e(0, "stopServiceAsync on null"));
        } else {
            kotlin.jvm.internal.h.d(CompletableFuture.supplyAsync(new Ca.s(12, context, intent)), "supplyAsync(...)");
        }
    }

    public static final void n(HeyMelodyApplication heyMelodyApplication, ContentObserver observer) {
        kotlin.jvm.internal.h.e(observer, "observer");
        if (heyMelodyApplication != null) {
            try {
                ContentResolver contentResolver = heyMelodyApplication.getContentResolver();
                if (contentResolver != null) {
                    contentResolver.unregisterContentObserver(observer);
                }
            } catch (Throwable th) {
                A.i("ContextExt", "unregisterContentObserverCompat", th);
            }
        }
    }

    public static final void o(Context context, BroadcastReceiver receiver) {
        kotlin.jvm.internal.h.e(receiver, "receiver");
        if (context == null) {
            q0.b(MelodyException.e(0, "unregisterReceiverAsync on null"));
        } else {
            kotlin.jvm.internal.h.d(CompletableFuture.runAsync(new RunnableC0903i(0, context, receiver)), "runAsync(...)");
        }
    }
}
