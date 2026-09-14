package com.oplus.melody.app.discovery;

import android.view.View;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class J0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ I0 f18948b;

    public /* synthetic */ J0(I0 i02, int i10) {
        this.f18947a = i10;
        this.f18948b = i02;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f18947a) {
            case 0:
                ((N0) this.f18948b).f18929b.N("onCloseClick");
                DiscoveryDialogActivity.M(new L6.c(4));
                break;
            case 1:
                ((p1) this.f18948b).f18929b.N("onCloseClick");
                DiscoveryDialogActivity.M(new RunnableC0860j(4));
                break;
            default:
                A1 a12 = (A1) this.f18948b;
                DiscoveryDialogActivity discoveryDialogActivity = a12.f18929b;
                discoveryDialogActivity.N("onCloseClick");
                discoveryDialogActivity.f18850W.removeCallbacks(a12.f18817n);
                DiscoveryDialogActivity.M(new RunnableC0860j(6));
                break;
        }
    }
}
