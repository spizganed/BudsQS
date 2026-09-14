package com.oplus.melody.app.discovery;

import android.view.View;
import com.oplus.melody.track.constant.AppConstant$UserAction;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class W0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0850f1 f19015b;

    public /* synthetic */ W0(C0850f1 c0850f1, int i10) {
        this.f19014a = i10;
        this.f19015b = c0850f1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f19014a) {
            case 0:
                C0850f1 c0850f1 = this.f19015b;
                c0850f1.getClass();
                c0850f1.i(new RunnableC0871n0(1, c0850f1, view));
                break;
            case 1:
                C0850f1 c0850f12 = this.f19015b;
                c0850f12.getClass();
                c0850f12.i(new U0(c0850f12, 1));
                break;
            case 2:
                C0850f1 c0850f13 = this.f19015b;
                c0850f13.getClass();
                com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "onClick guideBtn 2");
                c0850f13.q(true);
                c0850f13.n(AppConstant$UserAction.ACTION_GO_GUIDE);
                break;
            default:
                C0850f1 c0850f14 = this.f19015b;
                c0850f14.getClass();
                c0850f14.i(new RunnableC0863k(c0850f14, view, 1));
                break;
        }
    }
}
