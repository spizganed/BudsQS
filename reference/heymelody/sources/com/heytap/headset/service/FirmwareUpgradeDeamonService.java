package com.heytap.headset.service;

import B.t;
import D7.C0379m;
import D7.C0381o;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import c8.AbstractC0763a;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.P;
import com.oplus.melody.model.repository.firmware.FirmwareUpgradeStateDTO;
import com.oplus.melody.ui.component.detail.automaticfirmwareupdate.FirmwareUpgradeActivity;
import ea.C1023b;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: FirmwareUpgradeDeamonService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010\u0014\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/heytap/headset/service/FirmwareUpgradeDeamonService;", "Landroid/app/Service;", "<init>", "()V", "mAddress", "", "mDeviceName", "mProductId", "mProductColorId", "firmwareUpgradeStateLiveDataRecord", "Lcom/oplus/melody/common/helper/LiveDataRecord;", "Lcom/oplus/melody/model/repository/firmware/FirmwareUpgradeStateDTO;", "isForegroundStarted", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onStartCommand", "", "flags", "startId", "onDestroy", "startForegroundSafely", "updateNotification", "getNotification", "Landroid/app/Notification;", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FirmwareUpgradeDeamonService extends Service {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f17584s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f17586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f17587c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f17588p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public C0381o<FirmwareUpgradeStateDTO> f17589q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f17590r;

    public final Notification a() {
        P p6 = P.f19456a;
        P.b(this, "headset_channel", null);
        t tVar = new t(this, "headset_channel");
        tVar.f314Q.icon = getApplicationInfo().icon;
        tVar.f323f = t.c(getString(R.string.melody_common_firmware_upgrade_keep_in_page));
        tVar.d(2, true);
        if (this.f17585a != null) {
            Intent intent = new Intent(this, (Class<?>) FirmwareUpgradeActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("device_mac_info", this.f17585a);
            intent.putExtra("product_id", this.f17587c);
            intent.putExtra("device_name", this.f17586b);
            intent.putExtra("product_color", this.f17588p);
            tVar.h = PendingIntent.getActivity(this, 0, intent, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
        }
        Notification notificationA = tVar.a();
        h.d(notificationA, "build(...)");
        return notificationA;
    }

    public final void b() {
        if (this.f17590r) {
            return;
        }
        try {
            Notification notificationA = a();
            if (Build.VERSION.SDK_INT >= 34) {
                startForeground(10102, notificationA, 16);
            } else {
                startForeground(10102, notificationA);
            }
            this.f17590r = true;
            A.b("FirmwareUpgradeDeamonService", "Foreground service started successfully");
        } catch (Exception e10) {
            A.i("FirmwareUpgradeDeamonService", "Failed to start foreground service", e10);
            this.f17590r = true;
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        h.e(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        A.b("FirmwareUpgradeDeamonService", "onCreate");
        b();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        A.b("FirmwareUpgradeDeamonService", "onDestroy");
        C0381o<FirmwareUpgradeStateDTO> c0381o = this.f17589q;
        if (c0381o != null) {
            c0381o.a();
        }
        this.f17590r = false;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int flags, int startId) {
        A.c("FirmwareUpgradeDeamonService", new com.oplus.melody.btsdk.protocol.commands.h(startId, 20));
        if (!this.f17590r) {
            b();
        }
        if (intent == null) {
            A.x("FirmwareUpgradeDeamonService", "Intent is null, stopping service");
            stopSelf();
            return super.onStartCommand(intent, flags, startId);
        }
        Bundle bundleExtra = intent.getBundleExtra("device_info");
        if (bundleExtra == null) {
            A.x("FirmwareUpgradeDeamonService", "Bundle is null, stopping service");
            stopSelf();
            return super.onStartCommand(intent, flags, startId);
        }
        this.f17585a = bundleExtra.getString("device_mac_info");
        this.f17586b = bundleExtra.getString("device_name");
        this.f17587c = bundleExtra.getString("product_id");
        this.f17588p = bundleExtra.getString("product_color");
        if (this.f17590r) {
            try {
                Notification notificationA = a();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
                if (notificationManager != null) {
                    notificationManager.notify(10102, notificationA);
                }
            } catch (Exception e10) {
                A.i("FirmwareUpgradeDeamonService", "Failed to update notification", e10);
            }
        }
        C0381o<FirmwareUpgradeStateDTO> c0381o = this.f17589q;
        if (c0381o != null) {
            c0381o.a();
        }
        this.f17589q = C0379m.i(AbstractC0763a.e().d(this.f17585a), new C1023b(this, 5), C0379m.f1127a);
        return super.onStartCommand(intent, flags, startId);
    }
}
