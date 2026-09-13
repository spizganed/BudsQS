package com.oplus.melody.app.discovery;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class J implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DiscoveryDialogActivity f18942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f18943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f18944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f18945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f18946f;

    public /* synthetic */ J(DiscoveryDialogActivity discoveryDialogActivity, int i10, int i11, int i12, int i13, int i14) {
        this.f18941a = i14;
        this.f18942b = discoveryDialogActivity;
        this.f18943c = i10;
        this.f18944d = i11;
        this.f18945e = i12;
        this.f18946f = i13;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        E0 e0S;
        int i10 = this.f18946f;
        DiscoveryDialogActivity discoveryDialogActivity = this.f18942b;
        switch (this.f18941a) {
            case 0:
                C1 c12 = (C1) obj;
                int size = discoveryDialogActivity.f18869p0.f18900d.size();
                int i11 = this.f18943c;
                int i12 = this.f18944d;
                int i13 = this.f18945e;
                com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new R8.l(i11, i12, size, i13, 2));
                discoveryDialogActivity.f18856c0 = discoveryDialogActivity.f18854a0;
                discoveryDialogActivity.f18854a0 = i12;
                discoveryDialogActivity.f18857d0 = null;
                if (i12 != 2) {
                    discoveryDialogActivity.e0(false, false);
                } else if (size > 1) {
                    discoveryDialogActivity.e0(true, false);
                }
                I0 i0J0 = discoveryDialogActivity.j0(i12);
                if (i0J0 != null && (e0S = discoveryDialogActivity.S()) != null) {
                    i0J0.f(e0S);
                }
                discoveryDialogActivity.h0(i12, c12);
                if (i0J0 == null) {
                    return CompletableFuture.completedFuture(Integer.valueOf(i12));
                }
                com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new com.oplus.melody.model.repository.earphone.x(i0J0, i10, i13, 3));
                return i0J0.g(i10, c12);
            default:
                int i14 = DiscoveryDialogActivity.f18836L0;
                return discoveryDialogActivity.W(this.f18943c, this.f18944d, this.f18945e, i10);
        }
    }
}
