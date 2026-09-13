package com.oplus.melody.app.discovery;

import android.view.View;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.track.constant.AppConstant$UserAction;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.h1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0856h1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ I0 f19112b;

    public /* synthetic */ ViewOnClickListenerC0856h1(I0 i02, int i10) {
        this.f19111a = i10;
        this.f19112b = i02;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DiscoveryDialogViewModel discoveryDialogViewModel;
        switch (this.f19111a) {
            case 0:
                ((C0859i1) this.f19112b).f18929b.N("onCloseClick");
                DiscoveryDialogActivity.M(new RunnableC0860j(2));
                break;
            case 1:
                l1 l1Var = (l1) this.f19112b;
                E0 e0D = l1Var.d();
                if (e0D == null || (discoveryDialogViewModel = l1Var.f18930c) == null) {
                    com.oplus.melody.common.util.A.x("DiscoveryViewStateErrorImpl", "onRetryClick vo is null");
                } else {
                    com.oplus.melody.common.util.A.c("DiscoveryViewStateErrorImpl", new C0836b(e0D, 4));
                    if (e0D.getShareAudioState() <= 0) {
                        AbstractC0939b.E().f(e0D.getId());
                        l1Var.n(AppConstant$UserAction.ACTION_RETRY);
                    } else {
                        discoveryDialogViewModel.j(e0D.getId());
                    }
                }
                break;
            case 2:
                ((m1) this.f19112b).f18929b.N("onCloseClick");
                DiscoveryDialogActivity.M(new RunnableC0860j(3));
                break;
            default:
                z1 z1Var = (z1) this.f19112b;
                z1Var.getClass();
                com.oplus.melody.common.util.A.b("DiscoveryViewStateReadyImpl", "onClick doneBtn");
                z1Var.f18929b.O();
                z1Var.n(AppConstant$UserAction.ACTION_COMPLETE);
                break;
        }
    }
}
