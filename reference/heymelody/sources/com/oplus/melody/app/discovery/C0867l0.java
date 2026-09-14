package com.oplus.melody.app.discovery;

import java.util.function.Function;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.l0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0867l0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19135a;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        switch (this.f19135a) {
            case 0:
                com.oplus.melody.common.util.A.o(5, "DiscoveryDialogViewModel", "getZipConfig timeout or error, use empty config", th);
                return C1.EMPTY;
            case 1:
                return C1.EMPTY;
            case 2:
                com.oplus.melody.common.util.A.i("DiscoveryRecycleViewHolder", "bindView", th.getCause());
                return null;
            case 3:
                com.oplus.melody.common.util.A.i("DiscoveryViewState", "getAnimationTitleFuture", th);
                return null;
            case 4:
                com.oplus.melody.common.util.A.o(5, "DiscoveryViewStateBindingImpl", "onEnter bindOrUnbindAccount", th);
                return 2;
            default:
                com.oplus.melody.common.util.A.i("DiscoveryViewStateConnectedImpl", "onBindEarphone title", th);
                return null;
        }
    }
}
