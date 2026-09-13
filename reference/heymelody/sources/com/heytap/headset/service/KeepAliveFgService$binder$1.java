package com.heytap.headset.service;

import B.H;
import android.content.Intent;
import android.os.Build;
import androidx.lifecycle.t;
import com.heytap.headset.component.mydevicelist.MyDeviceListViewModel;
import com.heytap.headset.service.KeepAliveFgService;
import com.heytap.headset.service.a;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.ServiceUtils;
import t8.u;

/* JADX INFO: compiled from: KeepAliveFgService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class KeepAliveFgService$binder$1 extends a.AbstractBinderC0208a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ KeepAliveFgService f17598f;

    public KeepAliveFgService$binder$1(KeepAliveFgService keepAliveFgService) {
        this.f17598f = keepAliveFgService;
        attachInterface(this, "com.heytap.headset.service.IKeepAliveFgInterface");
    }

    @Override // com.heytap.headset.service.a
    public final void E() {
        t tVarD;
        KeepAliveFgService keepAliveFgService = this.f17598f;
        A.c("KeepAliveFgService", new com.oplus.melody.ui.component.detail.zenmode.scene.a(keepAliveFgService, 7));
        if (keepAliveFgService.f17594p) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 34) {
                keepAliveFgService.startForeground(1000, u.a() ? keepAliveFgService.c(true, null, 1000, false, false) : keepAliveFgService.b(true, null, 1000), 16);
            } else {
                keepAliveFgService.startForeground(1000, u.a() ? keepAliveFgService.c(true, null, 1000, false, false) : keepAliveFgService.b(true, null, 1000));
            }
            keepAliveFgService.f17594p = true;
            tVarD = new MyDeviceListViewModel().d(keepAliveFgService);
        } catch (Exception e10) {
            e = e10;
        }
        try {
            KeepAliveFgService$binder$1$forceForeground$2 keepAliveFgService$binder$1$forceForeground$2 = new KeepAliveFgService$binder$1$forceForeground$2(1, keepAliveFgService, KeepAliveFgService.class, "onDeviceItemListChange", "onDeviceItemListChange(Ljava/util/Map;)V", 0);
            keepAliveFgService = keepAliveFgService;
            tVarD.e(keepAliveFgService, new KeepAliveFgService.a(keepAliveFgService$binder$1$forceForeground$2));
        } catch (Exception e11) {
            e = e11;
            keepAliveFgService = keepAliveFgService;
            A.i("KeepAliveFgService", "forceForeground, stopService!", e);
            A.b("KeepAliveFgServiceManager", "stopService");
            new H(keepAliveFgService).f199b.cancelAll();
            ServiceUtils.stopService(keepAliveFgService, new Intent(keepAliveFgService, (Class<?>) KeepAliveFgService.class));
        }
    }
}
