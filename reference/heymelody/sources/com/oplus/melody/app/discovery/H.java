package com.oplus.melody.app.discovery;

import java.util.function.Supplier;
import o7.C1376d;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class H implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f18921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f18922d;

    public /* synthetic */ H(Object obj, int i10, int i11, int i12) {
        this.f18919a = i12;
        this.f18922d = obj;
        this.f18920b = i10;
        this.f18921c = i11;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i10 = this.f18921c;
        int i11 = this.f18920b;
        Object obj = this.f18922d;
        switch (this.f18919a) {
            case 0:
                int i12 = DiscoveryDialogActivity.f18836L0;
                return "moveToStateAsync EXIT " + ((I0) obj).f18928a + " viewFlags=" + i11 + " traceHashCode:" + i10;
            default:
                C1376d c1376d = (C1376d) obj;
                c1376d.getClass();
                return "onConnectionStateChange, gattStatus = " + i11 + ", newState = " + i10 + c1376d;
        }
    }
}
