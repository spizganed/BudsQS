package com.oplus.melody.app.discovery;

import android.view.View;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.track.constant.AppConstant$UserAction;
import kc.C1264t;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.k1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0865k1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ I0 f19129b;

    public /* synthetic */ ViewOnClickListenerC0865k1(I0 i02, int i10) {
        this.f19128a = i10;
        this.f19129b = i02;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DiscoveryDialogViewModel discoveryDialogViewModel;
        switch (this.f19128a) {
            case 0:
                l1 l1Var = (l1) this.f19129b;
                l1Var.getClass();
                com.oplus.melody.common.util.A.b("DiscoveryViewStateErrorImpl", "onClick mCloseBtn");
                l1Var.f18929b.O();
                l1Var.n(AppConstant$UserAction.ACTION_COMPLETE);
                break;
            case 1:
                ((p1) this.f19129b).f18929b.N("onCancelClick");
                DiscoveryDialogActivity.M(new L6.c(6));
                break;
            case 2:
                z1 z1Var = (z1) this.f19129b;
                z1Var.f18929b.f18850W.removeCallbacks(z1Var.f19241m);
                E0 e0D = z1Var.d();
                if (e0D == null || (discoveryDialogViewModel = z1Var.f18930c) == null) {
                    StringBuilder sb2 = new StringBuilder("mBtnConnect click (vo == null):");
                    sb2.append(e0D == null);
                    com.oplus.melody.common.util.A.h("DiscoveryViewStateReadyImpl", sb2.toString());
                } else {
                    com.oplus.melody.common.util.A.f("DiscoveryViewStateReadyImpl", "mBtnConnect click, lastEarphoneVO = " + e0D);
                    AbstractC0939b.E().e(e0D.getId());
                    if (e0D.getAccountBindingState() == 1 && (discoveryDialogViewModel.l() || discoveryDialogViewModel.k())) {
                        com.oplus.melody.common.util.A.c("DiscoveryViewStateReadyImpl", new s1(e0D, 1));
                        if (e0D.getConnectState() == 2) {
                            z1Var.j(5);
                        } else {
                            z1Var.j(4);
                        }
                    } else if (com.oplus.melody.common.util.Y.k(I0.e(z1Var.f18934g)) || e0D.getPairingState() == 1) {
                        AbstractC0939b.E().f(e0D.getId());
                    } else {
                        z1Var.j(3);
                    }
                    C1264t.r(z1Var.h, AppConstant$UserAction.ACTION_CONFIRM, e0D.getProductId(), e0D.getId(), com.oplus.melody.model.repository.earphone.N.t(AbstractC0939b.E().w(e0D.getId())), z1Var.f19245q);
                }
                break;
            default:
                A1 a12 = (A1) this.f19129b;
                a12.getClass();
                com.oplus.melody.common.util.A.b("DiscoveryViewStateShareSuccessImpl", "onClick doneBtn");
                a12.f18929b.O();
                break;
        }
    }
}
