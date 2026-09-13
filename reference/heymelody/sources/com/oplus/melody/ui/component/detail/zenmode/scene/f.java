package com.oplus.melody.ui.component.detail.zenmode.scene;

import B.H;
import D7.o0;
import Ea.W;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.zenmode.ZenModeRepository;
import com.oplus.melody.ui.component.detail.zenmode.ZenModeViewModel;
import com.oplus.melody.ui.component.detail.zenmode.scene.b;
import com.oplus.melody.ui.component.detail.zenmode.scene.c;
import com.oplus.melody.ui.component.detail.zenmode.scene.g;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ZenModeReceiver.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        A.c("ZenModeReceiver", new D6.f(action, 18));
        if (TextUtils.equals(action, "com.oplus.melody.ui.zenmode.scene.NOTIFICATION_CLICKED")) {
            Bundle extras = intent.getExtras();
            EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(extras != null ? extras.getString("device_mac_info", "") : "");
            if (earphoneDTOW == null || earphoneDTOW.getConnectionState() != 2) {
                return;
            }
            new H(c.a.f21443a.f21442a).f199b.cancel(null, 4);
            Intent intent2 = new Intent(context, (Class<?>) ZenModeSceneActivity.class);
            intent2.addFlags(268435456);
            intent2.addFlags(67108864);
            if (extras != null) {
                intent2.putExtras(extras);
            }
            if (intent.getBooleanExtra("extra_zen_mode_notification_succeed", false)) {
                intent2.putExtra("extra_is_created_by_success", true);
            } else {
                intent2.putExtra("extra_is_created_by_failure", true);
            }
            intent2.putExtra("extra_zen_mode_notification_sending_music_id", intent.getStringExtra("extra_zen_mode_notification_sending_music_id"));
            kotlin.jvm.internal.h.e(context, "context");
            C0905k.j(context, intent2);
            return;
        }
        if (TextUtils.equals(action, "com.oplus.melody.btsdk.action.ZEN_MODE_OTA")) {
            int intExtra = intent.getIntExtra("stage", -1);
            int intExtra2 = intent.getIntExtra("progress", -1);
            b bVar = b.C0235b.f21441a;
            i iVar = bVar.f21440k;
            if (iVar != null) {
                g gVar = iVar.f21489c;
                if (intExtra == 0) {
                    gVar.f21460q.f21503j.edit().putBoolean("is_save_complete", false).apply();
                    return;
                }
                if (intExtra == 1) {
                    if (intExtra2 < 0 || intExtra2 > 100) {
                        return;
                    }
                    int i10 = (int) (((double) intExtra2) * 0.6d);
                    gVar.f21460q.getClass();
                    g.c cVar = gVar.f21462s;
                    cVar.getClass();
                    o0.d(new W(cVar, i10, 6));
                    if (bVar.h) {
                        return;
                    }
                    c.a.f21443a.b(i10);
                    return;
                }
                if (intExtra != 2) {
                    return;
                }
                int intExtra3 = intent.getIntExtra(ClientDataEntity.COL_STATUS, -10);
                if (iVar.f21487a) {
                    return;
                }
                iVar.f21487a = true;
                final o oVar = gVar.f21460q;
                oVar.f21503j.edit().putBoolean("is_save_complete", true).apply();
                o0.b.f1142a.schedule(new Callable<Object>() { // from class: com.oplus.melody.ui.component.detail.zenmode.scene.ZenModeScenePresenter$1
                    @Override // java.util.concurrent.Callable
                    public Object call() {
                        o oVar2 = oVar;
                        ZenModeViewModel zenModeViewModel = oVar2.f21504k;
                        String str = oVar2.f21495a;
                        zenModeViewModel.getClass();
                        return ZenModeRepository.j().i(str);
                    }
                }, 3000L, TimeUnit.MILLISECONDS);
                A.c("ZenModeScenePresenter", new n(oVar, 1));
                Boolean bool = oVar.f21501g;
                if (bool != null) {
                    if (bool.booleanValue()) {
                        oVar.e();
                    } else {
                        oVar.f();
                    }
                }
                oVar.f21501g = null;
                if (intExtra3 != 0) {
                    o0.d(new D.h(iVar, intExtra3, 6));
                } else {
                    iVar.f21488b = 0;
                    gVar.f21452C.postDelayed(new h(iVar, intExtra3), 100L);
                }
            }
        }
    }
}
