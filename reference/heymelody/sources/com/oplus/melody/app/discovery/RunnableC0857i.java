package com.oplus.melody.app.discovery;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0857i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DiscoveryDialogActivity f19114b;

    public /* synthetic */ RunnableC0857i(DiscoveryDialogActivity discoveryDialogActivity, int i10) {
        this.f19113a = i10;
        this.f19114b = discoveryDialogActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DiscoveryDialogActivity discoveryDialogActivity = this.f19114b;
        switch (this.f19113a) {
            case 0:
                int i10 = DiscoveryDialogActivity.f18836L0;
                discoveryDialogActivity.getClass();
                com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "mDismissRunnable run");
                discoveryDialogActivity.R();
                break;
            case 1:
                E1 e12 = discoveryDialogActivity.f18859f0;
                if (e12 != null) {
                    e12.g();
                }
                break;
            default:
                discoveryDialogActivity.O();
                break;
        }
    }
}
