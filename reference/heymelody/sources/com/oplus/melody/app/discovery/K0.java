package com.oplus.melody.app.discovery;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class K0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18956b;

    public /* synthetic */ K0(Object obj, int i10) {
        this.f18955a = i10;
        this.f18956b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f18955a) {
            case 0:
                N0 n02 = (N0) this.f18956b;
                DiscoveryDialogActivity discoveryDialogActivity = n02.f18929b;
                discoveryDialogActivity.b0(1);
                discoveryDialogActivity.c0(5);
                n02.q();
                break;
            case 1:
                N0 n03 = (N0) this.f18956b;
                DiscoveryDialogActivity discoveryDialogActivity2 = n03.f18929b;
                discoveryDialogActivity2.b0(1);
                discoveryDialogActivity2.c0(5);
                n03.q();
                break;
            default:
                DiscoveryDialogActivity.M(new RunnableC0885v((E0) this.f18956b, 1));
                break;
        }
    }
}
