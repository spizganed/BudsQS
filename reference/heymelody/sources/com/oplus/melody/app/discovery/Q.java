package com.oplus.melody.app.discovery;

import F7.a;

/* JADX INFO: compiled from: DiscoveryDialogActivity.java */
/* JADX INFO: loaded from: classes.dex */
public final class Q implements a.InterfaceC0020a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiscoveryDialogActivity f18986a;

    public Q(DiscoveryDialogActivity discoveryDialogActivity) {
        this.f18986a = discoveryDialogActivity;
    }

    @Override // F7.a.InterfaceC0020a
    public final void b() {
        DiscoveryDialogActivity discoveryDialogActivity = this.f18986a;
        if (discoveryDialogActivity.f18859f0.isShowing()) {
            discoveryDialogActivity.N("onHomeClick");
        }
    }

    @Override // F7.a.InterfaceC0020a
    public final void a() {
    }
}
