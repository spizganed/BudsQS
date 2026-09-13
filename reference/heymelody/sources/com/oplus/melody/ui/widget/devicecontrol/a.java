package com.oplus.melody.ui.widget.devicecontrol;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.oplus.iotui.model.ModeItem;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.widget.devicecontrol.DeviceControlWidget;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: DeviceControlWidget.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeviceControlWidget f21991a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(DeviceControlWidget deviceControlWidget, Looper looper) {
        super(looper);
        this.f21991a = deviceControlWidget;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        h.e(msg, "msg");
        if (msg.what == 1000) {
            Object obj = msg.obj;
            h.c(obj, "null cannot be cast to non-null type com.oplus.iotui.model.ModeItem");
            ModeItem modeItem = (ModeItem) obj;
            int i10 = msg.arg1;
            DeviceControlWidget deviceControlWidget = this.f21991a;
            DeviceControlWidget.a aVar = deviceControlWidget.f21988b;
            if (aVar != null) {
                aVar.b(modeItem);
            }
            String id = modeItem.getId();
            if (id != null) {
                deviceControlWidget.f21987a.put(id, Long.valueOf(System.currentTimeMillis()));
            }
            A.c("UDeviceActionContainer", new Ga.a(modeItem, i10, 0));
        }
    }
}
