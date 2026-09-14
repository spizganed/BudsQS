package com.oplus.melody.ui.widget.devicecontrol;

import Ea.X;
import com.oplus.iotui.model.ModeItem;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.widget.devicecontrol.DeviceControlWidget;
import com.oplus.melody.ui.widget.devicecontrol.c;

/* JADX INFO: compiled from: DeviceControlWidget.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeviceControlWidget f21992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ModeItem f21993b;

    public b(DeviceControlWidget deviceControlWidget, ModeItem modeItem) {
        this.f21992a = deviceControlWidget;
        this.f21993b = modeItem;
    }

    @Override // com.oplus.melody.ui.widget.devicecontrol.c.a
    public final void a(boolean z2) {
        ModeItem modeItem = this.f21993b;
        A.c("UDeviceActionContainer", new X(modeItem, z2, 1));
        DeviceControlWidget.a aVar = this.f21992a.f21988b;
        if (aVar != null) {
            modeItem.getClass();
            aVar.a(modeItem, z2);
        }
    }
}
