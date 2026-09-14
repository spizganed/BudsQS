package com.oplus.melody.ui.component.finddevice;

import O7.l;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.base.BaseViewModel;
import ia.b;
import ia.g;

/* JADX INFO: loaded from: classes3.dex */
public class FindDeviceViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f21524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f21525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l<Integer> f21526f = new l<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21527g = false;
    public boolean h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f21528i = null;

    @Override // androidx.lifecycle.L
    public final void c() {
        g.c cVar;
        A.b("FindDeviceViewModel", "onCleared");
        b bVar = this.f21528i;
        if (bVar != null) {
            bVar.f24133q = true;
            if (bVar.f() && (cVar = bVar.f24158b) != null) {
                cVar.sendMessageAtFrontOfQueue(cVar.obtainMessage(-1, g.c.f24170p));
            }
            bVar.g(6);
        }
    }

    public final void d(int i10) {
        this.f21526f.m(Integer.valueOf(i10));
        if (i10 == 4) {
            this.f21527g = true;
        } else if (i10 == 5) {
            this.f21527g = false;
        }
    }
}
