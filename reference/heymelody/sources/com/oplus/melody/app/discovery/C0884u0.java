package com.oplus.melody.app.discovery;

import com.oplus.melody.ui.widget.MelodyCompatButton;
import java.util.function.Function;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.u0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0884u0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f19198c;

    public /* synthetic */ C0884u0(int i10, String str) {
        this.f19196a = 0;
        this.f19197b = i10;
        this.f19198c = str;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i10 = this.f19197b;
        Object obj2 = this.f19198c;
        switch (this.f19196a) {
            case 0:
                E0 e02 = (E0) obj;
                String str = (String) obj2;
                if (e02 == null) {
                    Y.r.l(str, "DiscoveryDialogViewModel", androidx.appcompat.widget.a.n(i10, "setShareAudioState ", " failed, earphone is null. macAddress="));
                    return null;
                }
                E0 e03 = (E0) com.oplus.melody.common.data.a.copyOf(e02, E0.class);
                e03.setShareAudioState(i10);
                if (!com.oplus.melody.common.util.A.l()) {
                    return e03;
                }
                StringBuilder sbN = androidx.appcompat.widget.a.n(i10, "setShareAudioState ", " macAddress=");
                sbN.append(com.oplus.melody.common.util.A.r(str));
                sbN.append(" hashCode=");
                sbN.append(e03.hashCode());
                com.oplus.melody.common.util.A.b("DiscoveryDialogViewModel", sbN.toString());
                return e03;
            case 1:
                l1 l1Var = (l1) obj2;
                return J6.d.f(i10, 8, l1Var.f19137n, l1Var.f18931d);
            default:
                z1 z1Var = (z1) obj2;
                MelodyCompatButton melodyCompatButton = z1Var.f19242n;
                MelodyCompatButton melodyCompatButton2 = z1Var.f19243o;
                return J6.d.f(i10, 0, z1Var.f18931d, z1Var.f18932e, z1Var.f18937k, melodyCompatButton, melodyCompatButton2);
        }
    }

    public /* synthetic */ C0884u0(I0 i02, int i10, int i11) {
        this.f19196a = i11;
        this.f19198c = i02;
        this.f19197b = i10;
    }
}
