package com.oplus.melody.alive.component.clicktakephoto;

import com.oplus.melody.common.addon.MelodyAppExitInfo;
import java.util.function.Supplier;
import x3.C1656o;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MelodyAppExitInfo f18788b;

    public /* synthetic */ d(MelodyAppExitInfo melodyAppExitInfo, int i10) {
        this.f18787a = i10;
        this.f18788b = melodyAppExitInfo;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f18787a) {
            case 0:
                return "OplusAppSwitchManager OnAppSwitchObserver: onActivityExit , info = " + this.f18788b;
            default:
                return C1656o.a("mAppObserver.onAppExit: ", this.f18788b.getTargetName());
        }
    }
}
