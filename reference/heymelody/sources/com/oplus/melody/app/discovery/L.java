package com.oplus.melody.app.discovery;

import com.oplus.melody.ui.widget.MelodyVideoAnimationView;
import java.io.Serializable;
import java.util.function.Supplier;
import kotlin.jvm.internal.Ref$BooleanRef;
import x3.C1656o;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class L implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f18966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Serializable f18967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Serializable f18968e;

    public /* synthetic */ L(Object obj, Object obj2, Serializable serializable, Serializable serializable2, int i10) {
        this.f18964a = i10;
        this.f18965b = obj;
        this.f18966c = obj2;
        this.f18967d = serializable;
        this.f18968e = serializable2;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        Serializable serializable = this.f18968e;
        Serializable serializable2 = this.f18967d;
        Object obj = this.f18966c;
        Object obj2 = this.f18965b;
        switch (this.f18964a) {
            case 0:
                int i10 = DiscoveryDialogActivity.f18836L0;
                DiscoveryDialogActivity discoveryDialogActivity = (DiscoveryDialogActivity) obj2;
                discoveryDialogActivity.getClass();
                return "onVideoEnd cur=" + ((MelodyVideoAnimationView) obj).getCurrentPosition() + " end=" + ((Integer) serializable2) + " loop=" + ((Integer) serializable) + ", getCurrentState() = " + Math.abs(discoveryDialogActivity.f18854a0);
            default:
                boolean z2 = ((Ref$BooleanRef) obj2).element;
                boolean z4 = ((Ref$BooleanRef) obj).element;
                boolean z10 = ((Ref$BooleanRef) serializable2).element;
                boolean z11 = ((Ref$BooleanRef) serializable).element;
                StringBuilder sb2 = new StringBuilder("onKeyFunctionInfoChanged, open status, single:");
                sb2.append(z2);
                sb2.append(", double:");
                sb2.append(z4);
                sb2.append(", triple:");
                return C1656o.b(sb2, z10, ", long:", z11);
        }
    }
}
