package com.oplus.melody.app.discovery;

import java.util.function.Predicate;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.t0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0882t0 implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return ((DiscoveryRecycleItemVO) obj).isActive();
    }
}
