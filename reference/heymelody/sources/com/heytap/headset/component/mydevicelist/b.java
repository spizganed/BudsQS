package com.heytap.headset.component.mydevicelist;

import com.coui.appcompat.checkbox.COUICheckBox;
import com.heytap.headset.component.mydevicelist.a;

/* JADX INFO: compiled from: MyDeviceListAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b implements COUICheckBox.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f17493a;

    public b(a aVar) {
        this.f17493a = aVar;
    }

    @Override // com.coui.appcompat.checkbox.COUICheckBox.c
    public final void m(int i10) {
        a.c cVar = this.f17493a.f17470e;
        if (cVar != null) {
            cVar.c();
        }
    }
}
