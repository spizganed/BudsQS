package com.oplus.melody.app.discovery;

import L8.RunnableC0474v;
import android.view.View;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.track.constant.AppConstant$UserAction;
import kc.C1264t;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ I0 f19200b;

    public /* synthetic */ u1(I0 i02, int i10) {
        this.f19199a = i10;
        this.f19200b = i02;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f19199a) {
            case 0:
                z1 z1Var = (z1) this.f19200b;
                DiscoveryDialogActivity discoveryDialogActivity = z1Var.f18929b;
                discoveryDialogActivity.N("onCloseClick");
                DiscoveryDialogActivity.M(new RunnableC0474v(4));
                discoveryDialogActivity.f18850W.removeCallbacks(z1Var.f19241m);
                E0 e0D = z1Var.d();
                if (e0D != null && z1Var.f18930c != null) {
                    C1264t.r(z1Var.h, AppConstant$UserAction.ACTION_CANCEL, e0D.getProductId(), e0D.getId(), com.oplus.melody.model.repository.earphone.N.t(AbstractC0939b.E().w(e0D.getId())), z1Var.f19245q);
                    break;
                }
                break;
            case 1:
                z1 z1Var2 = (z1) this.f19200b;
                DiscoveryDialogActivity discoveryDialogActivity2 = z1Var2.f18929b;
                discoveryDialogActivity2.f18850W.removeCallbacks(z1Var2.f19241m);
                discoveryDialogActivity2.N("onCancelClick");
                DiscoveryDialogActivity.M(new RunnableC0860j(5));
                break;
            default:
                ((C0859i1) this.f19200b).f18929b.N("onCancelClick");
                DiscoveryDialogActivity.M(new RunnableC0853g1());
                break;
        }
    }
}
