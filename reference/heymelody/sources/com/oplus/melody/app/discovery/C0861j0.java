package com.oplus.melody.app.discovery;

import a9.C0525B;
import android.view.View;
import com.oplus.melody.ui.widget.MelodyCompatTextView;
import java.util.function.Function;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.j0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0861j0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f19120c;

    public /* synthetic */ C0861j0(int i10, String str) {
        this.f19118a = 0;
        this.f19119b = i10;
        this.f19120c = str;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i10 = this.f19119b;
        Object obj2 = this.f19120c;
        switch (this.f19118a) {
            case 0:
                E0 e02 = (E0) com.oplus.melody.common.data.a.copyOf((E0) obj, E0.class);
                e02.setAccountBindingResultCode(i10);
                com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0525B(i10, (String) obj2, e02, 1));
                return e02;
            case 1:
                C0859i1 c0859i1 = (C0859i1) obj2;
                E0 e0D = c0859i1.d();
                if (e0D != null && e0D.getAccountBindingState() == 1) {
                    return J6.d.f(i10, 8, new View[0]);
                }
                boolean z2 = c0859i1.f19116m;
                MelodyCompatTextView melodyCompatTextView = c0859i1.f18933f;
                MelodyCompatTextView melodyCompatTextView2 = c0859i1.f18931d;
                return z2 ? J6.d.f(i10, 8, melodyCompatTextView2, melodyCompatTextView, c0859i1.f18937k) : J6.d.f(i10, 8, melodyCompatTextView2, melodyCompatTextView);
            default:
                p1 p1Var = (p1) obj2;
                return J6.d.f(i10, 0, p1Var.f18931d, p1Var.f18933f);
        }
    }

    public /* synthetic */ C0861j0(I0 i02, int i10, int i11) {
        this.f19118a = i11;
        this.f19120c = i02;
        this.f19119b = i10;
    }
}
