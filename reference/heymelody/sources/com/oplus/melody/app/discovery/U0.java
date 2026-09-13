package com.oplus.melody.app.discovery;

import com.oplus.melody.track.constant.AppConstant$UserAction;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class U0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ I0 f19003b;

    public /* synthetic */ U0(I0 i02, int i10) {
        this.f19002a = i10;
        this.f19003b = i02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        I0 i02 = this.f19003b;
        switch (this.f19002a) {
            case 0:
                C0850f1 c0850f1 = (C0850f1) i02;
                J6.d.f(1, 0, c0850f1.f19087r, c0850f1.f19085p, c0850f1.f19086q);
                break;
            case 1:
                C0850f1 c0850f12 = (C0850f1) i02;
                c0850f12.getClass();
                com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "onClick doneBtn");
                c0850f12.f18929b.O();
                c0850f12.n(AppConstant$UserAction.ACTION_COMPLETE);
                break;
            default:
                z1 z1Var = (z1) i02;
                J6.d.f(1, 0, z1Var.f18931d, z1Var.f18932e);
                z1Var.f19246r = true;
                break;
        }
    }
}
