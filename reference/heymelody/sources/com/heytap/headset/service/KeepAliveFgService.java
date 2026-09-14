package com.heytap.headset.service;

import B.H;
import B.t;
import D7.o0;
import Wb.l;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.widget.RemoteViews;
import androidx.lifecycle.q;
import androidx.lifecycle.v;
import androidx.media3.session.N0;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.heytap.headset.component.detail.DeviceDetailActivity;
import com.heytap.headset.component.mydevicelist.MyDeviceListActivity;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.P;
import com.oplus.melody.common.util.S;
import com.oplus.melody.common.util.ServiceUtils;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.db.s;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import m4.f;

/* JADX INFO: compiled from: KeepAliveFgService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\"\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\u001c\u0010!\u001a\u00020\u001b2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002J\u001c\u0010#\u001a\u00020\u001b2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002J\u001c\u0010$\u001a\u00020\u001b2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002J\b\u0010%\u001a\u00020&H\u0002J\"\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010*\u001a\u00020\u001dH\u0002J2\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0011H\u0002J\u0018\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/2\u0006\u0010)\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/heytap/headset/service/KeepAliveFgService;", "Landroidx/lifecycle/LifecycleService;", "<init>", "()V", "deviceListViewModel", "Lcom/heytap/headset/component/mydevicelist/MyDeviceListViewModel;", "newDeviceItemMap", "", "", "Lcom/heytap/headset/component/mydevicelist/MyDeviceItemVO;", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "notificationManager$delegate", "Lkotlin/Lazy;", "hasStartForeground", "", "binder", "Lcom/heytap/headset/service/IKeepAliveFgInterface$Stub;", "handleDeviceItemListChangeRunnable", "Ljava/lang/Runnable;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onStartCommand", "", "flags", "startId", "onDestroy", "onDeviceItemListChange", "deviceItemMap", "handleDeviceItemListChange", "handleDeviceItemListChangeVV", "getNotification", "Landroid/app/Notification;", "getNotifications", "noDeviceConnected", "item", "notificationId", "isGroupNotification", "twoOrMoreDeviceConnected", "updateRemoteViews", "remoteViews", "Landroid/widget/RemoteViews;", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KeepAliveFgService extends q {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f17591s = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f17594p;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, V3.a> f17592b = kotlin.collections.a.b0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Jb.b f17593c = kotlin.a.a(new A9.b(5));

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final KeepAliveFgService$binder$1 f17595q = new KeepAliveFgService$binder$1(this);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final N0 f17596r = new N0(this, 13);

    /* JADX INFO: compiled from: KeepAliveFgService.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f17597a;

        public a(l lVar) {
            this.f17597a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f17597a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f17597a.d(obj);
        }
    }

    public static void d(RemoteViews remoteViews, V3.a aVar) {
        int headsetLeftBattery;
        int headsetRightBattery;
        int headsetBoxBattery;
        boolean zIsLeftCharging;
        boolean zIsRightCharging;
        boolean zIsBoxCharging;
        remoteViews.setTextViewText(R.id.tv_name, aVar.getName());
        if (aVar.getIsSpp()) {
            headsetLeftBattery = aVar.getLeftBattery();
            headsetRightBattery = aVar.getRightBattery();
            headsetBoxBattery = aVar.getBoxBattery();
            zIsLeftCharging = aVar.getIsLeftCharging();
            zIsRightCharging = aVar.getIsRightCharging();
            zIsBoxCharging = aVar.getIsBoxCharging();
        } else {
            headsetLeftBattery = aVar.getHeadsetLeftBattery();
            headsetRightBattery = aVar.getHeadsetRightBattery();
            headsetBoxBattery = aVar.getHeadsetBoxBattery();
            zIsLeftCharging = false;
            zIsRightCharging = false;
            zIsBoxCharging = false;
        }
        if (Y.l(aVar.getType())) {
            remoteViews.setViewVisibility(R.id.box_battery, 8);
            remoteViews.setViewVisibility(R.id.right_battery, 8);
            remoteViews.setViewVisibility(R.id.left_icon_which, 8);
            if (headsetLeftBattery == 0) {
                remoteViews.setViewVisibility(R.id.left_battery, 8);
                return;
            }
            remoteViews.setViewVisibility(R.id.left_battery, 0);
            remoteViews.setTextViewText(R.id.left_battery_level_inside, String.valueOf(headsetLeftBattery));
            if (headsetLeftBattery <= 20) {
                remoteViews.setProgressBar(R.id.left_battery_progress_low, 100, headsetLeftBattery, false);
                remoteViews.setViewVisibility(R.id.left_battery_progress_low, 0);
                remoteViews.setViewVisibility(R.id.left_battery_progress, 4);
                remoteViews.setViewVisibility(R.id.left_battery_progress_charging, 4);
            } else if (zIsLeftCharging) {
                remoteViews.setProgressBar(R.id.left_battery_progress_charging, 100, headsetLeftBattery, false);
                remoteViews.setViewVisibility(R.id.left_battery_progress_charging, 0);
                remoteViews.setViewVisibility(R.id.left_battery_progress_low, 4);
                remoteViews.setViewVisibility(R.id.left_battery_progress, 4);
            } else {
                remoteViews.setProgressBar(R.id.left_battery_progress, 100, headsetLeftBattery, false);
                remoteViews.setViewVisibility(R.id.left_battery_progress, 0);
                remoteViews.setViewVisibility(R.id.left_battery_progress_low, 4);
                remoteViews.setViewVisibility(R.id.left_battery_progress_charging, 4);
            }
            if (zIsLeftCharging) {
                remoteViews.setViewVisibility(R.id.left_batter_charging, 0);
                return;
            } else {
                remoteViews.setViewVisibility(R.id.left_batter_charging, 8);
                return;
            }
        }
        if (headsetLeftBattery == 0) {
            remoteViews.setViewVisibility(R.id.left_battery, 8);
        } else {
            remoteViews.setViewVisibility(R.id.left_battery, 0);
            remoteViews.setTextViewText(R.id.left_battery_level_inside, String.valueOf(headsetLeftBattery));
            if (headsetLeftBattery <= 20) {
                remoteViews.setProgressBar(R.id.left_battery_progress_low, 100, headsetLeftBattery, false);
                remoteViews.setViewVisibility(R.id.left_battery_progress_low, 0);
                remoteViews.setViewVisibility(R.id.left_battery_progress, 4);
                remoteViews.setViewVisibility(R.id.left_battery_progress_charging, 4);
            } else if (zIsLeftCharging) {
                remoteViews.setProgressBar(R.id.left_battery_progress_charging, 100, headsetLeftBattery, false);
                remoteViews.setViewVisibility(R.id.left_battery_progress_charging, 0);
                remoteViews.setViewVisibility(R.id.left_battery_progress_low, 4);
                remoteViews.setViewVisibility(R.id.left_battery_progress, 4);
            } else {
                remoteViews.setProgressBar(R.id.left_battery_progress, 100, headsetLeftBattery, false);
                remoteViews.setViewVisibility(R.id.left_battery_progress, 0);
                remoteViews.setViewVisibility(R.id.left_battery_progress_low, 4);
                remoteViews.setViewVisibility(R.id.left_battery_progress_charging, 4);
            }
            if (zIsLeftCharging) {
                remoteViews.setViewVisibility(R.id.left_batter_charging, 0);
            } else {
                remoteViews.setViewVisibility(R.id.left_batter_charging, 8);
            }
        }
        if (headsetRightBattery == 0) {
            remoteViews.setViewVisibility(R.id.right_battery, 8);
        } else {
            remoteViews.setViewVisibility(R.id.right_battery, 0);
            remoteViews.setTextViewText(R.id.right_battery_level_inside, String.valueOf(headsetRightBattery));
            if (headsetRightBattery <= 20) {
                remoteViews.setProgressBar(R.id.right_battery_progress_low, 100, headsetRightBattery, false);
                remoteViews.setViewVisibility(R.id.right_battery_progress_low, 0);
                remoteViews.setViewVisibility(R.id.right_battery_progress, 4);
                remoteViews.setViewVisibility(R.id.right_battery_progress_charging, 4);
            } else if (zIsRightCharging) {
                remoteViews.setProgressBar(R.id.right_battery_progress_charging, 100, headsetRightBattery, false);
                remoteViews.setViewVisibility(R.id.right_battery_progress_charging, 0);
                remoteViews.setViewVisibility(R.id.right_battery_progress_low, 4);
                remoteViews.setViewVisibility(R.id.right_battery_progress, 4);
            } else {
                remoteViews.setProgressBar(R.id.right_battery_progress, 100, headsetRightBattery, false);
                remoteViews.setViewVisibility(R.id.right_battery_progress, 0);
                remoteViews.setViewVisibility(R.id.right_battery_progress_low, 4);
                remoteViews.setViewVisibility(R.id.right_battery_progress_charging, 4);
            }
            if (zIsRightCharging) {
                remoteViews.setViewVisibility(R.id.right_batter_charging, 0);
            } else {
                remoteViews.setViewVisibility(R.id.right_batter_charging, 8);
            }
        }
        if (headsetBoxBattery == 0) {
            remoteViews.setViewVisibility(R.id.box_battery, 8);
            return;
        }
        remoteViews.setViewVisibility(R.id.box_battery, 0);
        remoteViews.setTextViewText(R.id.box_battery_level_inside, String.valueOf(headsetBoxBattery));
        if (headsetBoxBattery <= 20) {
            remoteViews.setProgressBar(R.id.box_battery_progress_low, 100, headsetBoxBattery, false);
            remoteViews.setViewVisibility(R.id.box_battery_progress_low, 0);
            remoteViews.setViewVisibility(R.id.box_battery_progress, 4);
            remoteViews.setViewVisibility(R.id.box_battery_progress_charging, 4);
        } else if (zIsBoxCharging) {
            remoteViews.setProgressBar(R.id.box_battery_progress_charging, 100, headsetBoxBattery, false);
            remoteViews.setViewVisibility(R.id.box_battery_progress_charging, 0);
            remoteViews.setViewVisibility(R.id.box_battery_progress_low, 4);
            remoteViews.setViewVisibility(R.id.box_battery_progress, 4);
        } else {
            remoteViews.setProgressBar(R.id.box_battery_progress, 100, headsetBoxBattery, false);
            remoteViews.setViewVisibility(R.id.box_battery_progress, 0);
            remoteViews.setViewVisibility(R.id.box_battery_progress_low, 4);
            remoteViews.setViewVisibility(R.id.box_battery_progress_charging, 4);
        }
        if (zIsBoxCharging) {
            remoteViews.setViewVisibility(R.id.box_batter_charging, 0);
        } else {
            remoteViews.setViewVisibility(R.id.box_batter_charging, 8);
        }
    }

    public final NotificationManager a() {
        return (NotificationManager) this.f17593c.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0172 A[DONT_GENERATE, PHI: r4
      0x0172: PHI (r4v2 java.io.InputStream) = (r4v1 java.io.InputStream), (r4v3 java.io.InputStream) binds: [B:37:0x017e, B:33:0x0170] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.app.Notification b(boolean r12, V3.a r13, int r14) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.headset.service.KeepAliveFgService.b(boolean, V3.a, int):android.app.Notification");
    }

    public final Notification c(boolean z2, V3.a aVar, int i10, boolean z4, boolean z10) {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        String strE = S.e(heyMelodyApplication);
        h.d(strE, "getAppName(...)");
        H h = new H(heyMelodyApplication);
        P p6 = P.f19456a;
        P.b(heyMelodyApplication, "headset_channel", h);
        t tVar = new t(heyMelodyApplication, "headset_channel");
        tVar.d(16, false);
        if (z10) {
            tVar.f338v = "battery_group";
        }
        Notification notification = tVar.f314Q;
        notification.icon = R.mipmap.heymelody_app_icon_launcher;
        notification.tickerText = t.c(strE);
        tVar.d(2, true);
        tVar.f315R = true;
        tVar.f303E = -1;
        Intent intent = new Intent(heyMelodyApplication, (Class<?>) MyDeviceListActivity.class);
        if (z4) {
            tVar.f339w = true;
        } else if (z2) {
            tVar.f323f = t.c(getString(R.string.heymelody_app_lab_keep_alive_no_device_connected));
        } else {
            h.b(aVar);
            tVar.f322e = t.c(aVar.getName());
            RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.heymelody_app_notification_battery_info);
            d(remoteViews, aVar);
            tVar.f305G = remoteViews;
            intent = new Intent(heyMelodyApplication, (Class<?>) DeviceDetailActivity.class);
            intent.putExtra("device_mac_info", aVar.getAddress());
            intent.putExtra("device_name", aVar.getName());
            intent.setFlags(268435456);
        }
        if (!z4) {
            tVar.h = PendingIntent.getActivity(heyMelodyApplication, i10, intent, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
        }
        Notification notificationA = tVar.a();
        h.d(notificationA, "build(...)");
        return notificationA;
    }

    @Override // androidx.lifecycle.q, android.app.Service
    public final IBinder onBind(Intent intent) {
        h.e(intent, "intent");
        super.onBind(intent);
        A.b("KeepAliveFgService", "onBind");
        return this.f17595q;
    }

    @Override // androidx.lifecycle.q, android.app.Service
    public final void onCreate() {
        super.onCreate();
        A.b("KeepAliveFgService", "onCreate");
        WeakHashMap<Activity, m4.f> weakHashMap = m4.f.f26302s;
        if (f.a.b(this)) {
            return;
        }
        A.b("KeepAliveFgServiceManager", "stopService");
        new H(this).f199b.cancelAll();
        ServiceUtils.stopService(this, new Intent(this, (Class<?>) KeepAliveFgService.class));
    }

    @Override // androidx.lifecycle.q, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        A.b("KeepAliveFgService", "onDestroy");
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int flags, int startId) {
        Bundle extras;
        super.onStartCommand(intent, flags, startId);
        A.c("KeepAliveFgService", new com.oplus.melody.btsdk.protocol.commands.h(startId, 22));
        if (!h.a((intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString("service_command"), "force_update_notification")) {
            return 1;
        }
        A.c("KeepAliveFgService", new s(this, 19));
        if (!this.f17594p) {
            return 1;
        }
        Map<String, V3.a> map = this.f17592b;
        if (!t8.q.l()) {
            return 1;
        }
        this.f17592b = map;
        Handler handler = o0.c.f1143a;
        N0 n02 = this.f17596r;
        handler.removeCallbacks(n02);
        handler.postDelayed(n02, 50L);
        return 1;
    }
}
