package com.oplus.melody.app.discovery;

import com.oplus.melody.track.constant.AppConstant$UserAction;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class X0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0850f1 f19019b;

    public /* synthetic */ X0(C0850f1 c0850f1, int i10) {
        this.f19018a = i10;
        this.f19019b = c0850f1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f19018a) {
            case 0:
                C0850f1 c0850f1 = this.f19019b;
                c0850f1.getClass();
                com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "onClick doneBtn");
                c0850f1.f18929b.O();
                c0850f1.n(AppConstant$UserAction.ACTION_COMPLETE);
                break;
            default:
                this.f19019b.f18929b.N("onCancelClick");
                DiscoveryDialogActivity.M(new L6.c(5));
                break;
        }
    }
}
