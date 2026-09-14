package com.oplus.melody.app.discovery;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0860j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19117a;

    public /* synthetic */ RunnableC0860j(int i10) {
        this.f19117a = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f19117a) {
            case 0:
                int i10 = DiscoveryDialogActivity.f18836L0;
                com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "onCreate newSize is 0 callback!");
                break;
            case 1:
                com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "onClick closeBtn");
                break;
            case 2:
                com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectingImpl", "onClick closeBtn");
                break;
            case 3:
                com.oplus.melody.common.util.A.b("DiscoveryViewStateInitImpl", "onClick closeBtn");
                break;
            case 4:
                com.oplus.melody.common.util.A.b("DiscoveryViewStatePairingImpl", "click closeBtn");
                break;
            case 5:
                com.oplus.melody.common.util.A.b("DiscoveryViewStateReadyImpl", "onClick cancelBtn");
                break;
            default:
                com.oplus.melody.common.util.A.b("DiscoveryViewStateShareSuccessImpl", "onClick closeBtn");
                break;
        }
    }
}
