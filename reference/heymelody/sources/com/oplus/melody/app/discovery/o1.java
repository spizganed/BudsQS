package com.oplus.melody.app.discovery;

import com.oplus.melody.ui.widget.MelodyCompatTextView;
import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p1 f19162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f19163c;

    public /* synthetic */ o1(p1 p1Var, int i10, int i11) {
        this.f19161a = i11;
        this.f19162b = p1Var;
        this.f19163c = i10;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i10 = this.f19163c;
        p1 p1Var = this.f19162b;
        switch (this.f19161a) {
            case 0:
                MelodyCompatTextView melodyCompatTextView = p1Var.f18933f;
                if (melodyCompatTextView == null) {
                    melodyCompatTextView = p1Var.f18931d;
                }
                return J6.d.f(i10, 8, melodyCompatTextView);
            default:
                return J6.d.f(i10, 0, p1Var.f18931d, p1Var.f18933f);
        }
    }
}
