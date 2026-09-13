package com.oplus.melody.common.util;

import B.C0365m;
import B.H;
import D7.o0;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.util.P;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: NotificationUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class P {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f19457b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final P f19456a = new P();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<Integer, a> f19458c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"MissingPermission"})
    public static final b f19459d = new b();

    /* JADX INFO: compiled from: NotificationUtils.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Wb.a<String> f19460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Wb.a<String> f19461b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Wb.a<String>[] f19462c;

        public a(Wb.a<String> aVar, Wb.a<String> aVar2, Wb.a<String>[] aVarArr) {
            this.f19460a = aVar;
            this.f19461b = aVar2;
            this.f19462c = aVarArr;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.h.a(this.f19460a, aVar.f19460a) && kotlin.jvm.internal.h.a(this.f19461b, aVar.f19461b) && kotlin.jvm.internal.h.a(this.f19462c, aVar.f19462c);
        }

        public final int hashCode() {
            int iHashCode = (this.f19461b.hashCode() + (this.f19460a.hashCode() * 31)) * 31;
            Wb.a<String>[] aVarArr = this.f19462c;
            return iHashCode + (aVarArr == null ? 0 : Arrays.hashCode(aVarArr));
        }

        public final String toString() {
            return "NotificationStr(title=" + this.f19460a + ", summary=" + this.f19461b + ", buttonTexts=" + Arrays.toString(this.f19462c) + ")";
        }
    }

    /* JADX INFO: compiled from: NotificationUtils.kt */
    public static final class b extends BroadcastReceiver {
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:117:0x0210  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x026a  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x026f  */
        /* JADX WARN: Removed duplicated region for block: B:130:0x027a  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x0293  */
        /* JADX WARN: Removed duplicated region for block: B:138:0x0295  */
        /* JADX WARN: Removed duplicated region for block: B:143:0x02a2  */
        /* JADX WARN: Removed duplicated region for block: B:151:0x02e4  */
        /* JADX WARN: Removed duplicated region for block: B:152:0x02e6  */
        /* JADX WARN: Removed duplicated region for block: B:155:0x02f1  */
        /* JADX WARN: Removed duplicated region for block: B:156:0x02f3  */
        /* JADX WARN: Removed duplicated region for block: B:159:0x02fd  */
        /* JADX WARN: Removed duplicated region for block: B:161:0x0301  */
        /* JADX WARN: Removed duplicated region for block: B:164:0x030c  */
        /* JADX WARN: Removed duplicated region for block: B:165:0x030e  */
        /* JADX WARN: Removed duplicated region for block: B:168:0x031a  */
        /* JADX WARN: Removed duplicated region for block: B:169:0x031f  */
        /* JADX WARN: Removed duplicated region for block: B:181:0x0343  */
        /* JADX WARN: Removed duplicated region for block: B:184:0x0365  */
        /* JADX WARN: Removed duplicated region for block: B:185:0x0367  */
        /* JADX WARN: Removed duplicated region for block: B:188:0x038d  */
        /* JADX WARN: Removed duplicated region for block: B:190:0x0399  */
        /* JADX WARN: Removed duplicated region for block: B:206:0x03bd  */
        /* JADX WARN: Removed duplicated region for block: B:217:0x03e7 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:219:0x03eb  */
        /* JADX WARN: Removed duplicated region for block: B:222:0x03fd  */
        /* JADX WARN: Removed duplicated region for block: B:225:0x041d  */
        /* JADX WARN: Removed duplicated region for block: B:227:0x0425  */
        /* JADX WARN: Removed duplicated region for block: B:230:0x042e  */
        /* JADX WARN: Removed duplicated region for block: B:231:0x0433  */
        /* JADX WARN: Removed duplicated region for block: B:234:0x0458  */
        /* JADX WARN: Removed duplicated region for block: B:235:0x045d  */
        /* JADX WARN: Removed duplicated region for block: B:238:0x0482  */
        /* JADX WARN: Removed duplicated region for block: B:239:0x0489  */
        /* JADX WARN: Removed duplicated region for block: B:249:0x0505  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:253:0x0517  */
        /* JADX WARN: Removed duplicated region for block: B:256:0x0525  */
        /* JADX WARN: Removed duplicated region for block: B:263:0x053a  */
        /* JADX WARN: Removed duplicated region for block: B:327:0x0682  */
        /* JADX WARN: Removed duplicated region for block: B:350:0x072d  */
        /* JADX WARN: Removed duplicated region for block: B:362:0x0755  */
        /* JADX WARN: Removed duplicated region for block: B:376:0x0784 A[LOOP:7: B:375:0x0782->B:376:0x0784, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:379:0x07a4  */
        /* JADX WARN: Removed duplicated region for block: B:386:0x07c5  */
        /* JADX WARN: Removed duplicated region for block: B:392:0x07d7  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x012d  */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onReceive(android.content.Context r43, android.content.Intent r44) {
            /*
                Method dump skipped, instruction units count: 2160
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.common.util.P.b.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    static {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            kotlin.jvm.internal.h.i("context");
            throw null;
        }
        List listE = com.google.android.play.core.appupdate.c.e(new String[]{"default_channel", "headset_channel"});
        B.H h = new B.H(heyMelodyApplication);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationManager notificationManager = h.f199b;
                Iterator<NotificationChannel> it = H.a.e(notificationManager).iterator();
                while (it.hasNext()) {
                    NotificationChannel notificationChannelC = B.G.c(it.next());
                    if (!listE.contains(H.a.c(notificationChannelC)) && (Build.VERSION.SDK_INT < 30 || !listE.contains(H.b.a(notificationChannelC)))) {
                        H.a.b(notificationManager, H.a.c(notificationChannelC));
                    }
                }
            }
        } catch (Exception e10) {
            A.i("NotificationUtils", "deleteUnlistedNotificationChannels, error: ", e10);
        }
        Iterator it2 = listE.iterator();
        while (it2.hasNext()) {
            b(heyMelodyApplication, (String) it2.next(), h);
        }
        C0905k.e(heyMelodyApplication, f19459d, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
    }

    public static void a(Context context, int i10) {
        kotlin.jvm.internal.h.e(context, "context");
        new B.H(context).f199b.cancel(null, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r9, java.lang.String r10, B.H r11) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.common.util.P.b(android.content.Context, java.lang.String, B.H):boolean");
    }

    public static boolean c(Context context, String str) {
        kotlin.jvm.internal.h.e(context, "context");
        B.H h = new B.H(context);
        return h.f199b.areNotificationsEnabled() && b(context, str, h);
    }

    @SuppressLint({"MissingPermission"})
    public static void e(HeyMelodyApplication context, final int i10, String str, int i11, final Wb.a aVar, final Wb.a aVar2, PendingIntent pendingIntent, int i12, final M[] mArr) {
        kotlin.jvm.internal.h.e(context, "context");
        final B.H h = new B.H(context);
        if (b(context, str, h)) {
            B.t tVar = new B.t(context, str);
            tVar.f314Q.icon = i11;
            tVar.f322e = B.t.c((CharSequence) aVar.invoke());
            tVar.f323f = B.t.c((CharSequence) aVar2.invoke());
            tVar.h = pendingIntent;
            tVar.d(8, true);
            if (mArr != null) {
                for (M m9 : mArr) {
                    m9.getClass();
                    tVar.f319b.add(new C0365m(null, m9.f19446a.invoke(), m9.f19447b));
                }
            }
            final Notification notificationA = tVar.a();
            kotlin.jvm.internal.h.d(notificationA, "build(...)");
            notificationA.flags |= i12;
            Runnable runnable = new Runnable() { // from class: com.oplus.melody.common.util.N
                @Override // java.lang.Runnable
                public final void run() {
                    Wb.a[] aVarArr;
                    B.H h5 = h;
                    int i13 = i10;
                    Notification notification = notificationA;
                    Wb.a aVar3 = aVar;
                    Wb.a aVar4 = aVar2;
                    try {
                        P.f19457b = SystemClock.elapsedRealtime();
                        A.c("NotificationUtils", new O(i13, 0));
                        h5.a(i13, notification);
                        HashMap<Integer, P.a> map = P.f19458c;
                        Integer numValueOf = Integer.valueOf(i13);
                        M[] mArr2 = mArr;
                        if (mArr2 != null) {
                            ArrayList arrayList = new ArrayList(mArr2.length);
                            for (M m10 : mArr2) {
                                arrayList.add(m10.f19446a);
                            }
                            aVarArr = (Wb.a[]) arrayList.toArray(new Wb.a[0]);
                        } else {
                            aVarArr = null;
                        }
                        map.put(numValueOf, new P.a(aVar3, aVar4, aVarArr));
                    } catch (Exception e10) {
                        A.i("NotificationUtils", "showNotification error " + i13, e10);
                    }
                }
            };
            long millis = (TimeUnit.SECONDS.toMillis(1L) + f19457b) - SystemClock.elapsedRealtime();
            if (millis <= 0) {
                runnable.run();
            } else {
                A.c("NotificationUtils", new com.oplus.melody.app.discovery.M(i10, 1, millis));
                o0.c.f1143a.postDelayed(runnable, millis);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void d(HeyMelodyApplication context, int i10, int i11, Wb.a aVar, Wb.a aVar2, PendingIntent pendingIntent) {
        kotlin.jvm.internal.h.e(context, "context");
        e(context, i10, "headset_channel", i11, aVar, aVar2, pendingIntent, 16, null);
    }
}
