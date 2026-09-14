package com.oplus.melody.app.discovery;

import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0876q implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DiscoveryDialogActivity f19171b;

    public /* synthetic */ C0876q(DiscoveryDialogActivity discoveryDialogActivity, int i10) {
        this.f19170a = i10;
        this.f19171b = discoveryDialogActivity;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        DiscoveryDialogActivity discoveryDialogActivity = this.f19171b;
        switch (this.f19170a) {
            case 0:
                int i10 = DiscoveryDialogActivity.f18836L0;
                return "isStrangeDialog:" + discoveryDialogActivity.f18845I0;
            case 1:
                int i11 = DiscoveryDialogActivity.f18836L0;
                return "playBackgroundVideo  mFirstPlayBackgroundVideo=" + discoveryDialogActivity.f18837A0;
            default:
                int i12 = DiscoveryDialogActivity.f18836L0;
                return "updateSpBindAccountCount getAccountBindingState() = " + discoveryDialogActivity.S().getAccountBindingState();
        }
    }
}
