package com.oplus.melody.app.discovery;

import com.oplus.melody.model.zipdata.MelodyResourceDO;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0874p implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19165b;

    public /* synthetic */ C0874p(Object obj, int i10) {
        this.f19164a = i10;
        this.f19165b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        Object obj = this.f19165b;
        switch (this.f19164a) {
            case 0:
                int i10 = DiscoveryDialogActivity.f18836L0;
                return "updateSpBindAccountCount getAccountBindingState = " + ((DiscoveryDialogActivity) obj).S().getAccountBindingState();
            case 1:
                int i11 = DiscoveryDialogActivity.f18836L0;
                return g0.e.b(new StringBuilder("onVideoStart prevState "), ((DiscoveryDialogActivity) obj).f18856c0, " NOT_FOUND");
            default:
                return "showBatteryViews resize " + ((MelodyResourceDO) obj);
        }
    }
}
