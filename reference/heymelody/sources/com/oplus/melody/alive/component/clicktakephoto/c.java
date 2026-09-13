package com.oplus.melody.alive.component.clicktakephoto;

import com.oplus.melody.common.addon.MelodyAppEnterInfo;
import java.util.function.Supplier;
import x3.C1656o;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MelodyAppEnterInfo f18786b;

    public /* synthetic */ c(MelodyAppEnterInfo melodyAppEnterInfo, int i10) {
        this.f18785a = i10;
        this.f18786b = melodyAppEnterInfo;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f18785a) {
            case 0:
                return "OplusAppSwitchManager OnAppSwitchObserver: onActivityEnter , info = " + this.f18786b;
            case 1:
                return "onActivityEnter , info = " + this.f18786b;
            default:
                return C1656o.a("mAppObserver.onActivityEnter: ", this.f18786b.getTargetName());
        }
    }
}
