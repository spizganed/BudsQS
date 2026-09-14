package com.oplus.melody.app.discovery;

import android.text.TextUtils;
import androidx.viewpager2.widget.ViewPager2;
import com.oplus.melody.common.util.C0906l;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0885v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19202b;

    public /* synthetic */ RunnableC0885v(Object obj, int i10) {
        this.f19201a = i10;
        this.f19202b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f19201a) {
            case 0:
                ((ViewPager2) this.f19202b).b();
                break;
            case 1:
                E0 e02 = (E0) this.f19202b;
                int i10 = DiscoveryDialogActivity.f18836L0;
                if (com.oplus.melody.common.util.S.t(C0906l.f19501a)) {
                    J7.b.a().d();
                }
                if (e02 != null && !TextUtils.isEmpty(e02.getId())) {
                    ka.h.b(e02.getId());
                    break;
                }
                break;
            default:
                z1 z1Var = (z1) this.f19202b;
                if (!z1Var.f19251w) {
                    J6.d.f(1, 0, z1Var.f19242n, z1Var.f19243o);
                } else {
                    J6.d.f(1, 0, z1Var.f18937k, z1Var.f19242n, z1Var.f19243o);
                }
                break;
        }
    }
}
