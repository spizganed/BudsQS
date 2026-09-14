package com.oplus.melody.app.discovery;

import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0868m implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DiscoveryDialogActivity f19139b;

    public /* synthetic */ C0868m(DiscoveryDialogActivity discoveryDialogActivity, int i10) {
        this.f19138a = i10;
        this.f19139b = discoveryDialogActivity;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        DiscoveryDialogActivity discoveryDialogActivity = this.f19139b;
        switch (this.f19138a) {
            case 0:
                int i10 = DiscoveryDialogActivity.f18836L0;
                return "onResume seekTo:" + discoveryDialogActivity.f18877x0;
            default:
                int i11 = DiscoveryDialogActivity.f18836L0;
                return "getCurrentState:" + Math.abs(discoveryDialogActivity.f18854a0) + ",hasStrangeResPlayed:" + discoveryDialogActivity.f18843G0;
        }
    }
}
