package com.oplus.melody.app.discovery;

import android.view.View;
import android.view.ViewGroup;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class O0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18980b;

    public /* synthetic */ O0(Object obj, int i10) {
        this.f18979a = i10;
        this.f18980b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f18979a) {
            case 0:
                ((C0850f1) this.f18980b).f18929b.N("onCloseClick");
                DiscoveryDialogActivity.M(new RunnableC0860j(1));
                break;
            default:
                final View view = (View) this.f18980b;
                Object parent = view.getParent();
                View view2 = parent instanceof View ? (View) parent : null;
                if (view2 != null && view2.getHeight() > 0 && view.getHeight() > 0) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                    final float height = (view2.getHeight() - (marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0)) - view.getHeight();
                    if (height < 0.0f) {
                        height = 0.0f;
                    }
                    if (view.getY() != height) {
                        com.oplus.melody.common.util.A.c("MelodyDialogWrapperImpl", new Supplier() { // from class: com.oplus.melody.app.discovery.I1
                            @Override // java.util.function.Supplier
                            public final Object get() {
                                return "pinBottomSheetToBottom y:" + view.getY() + "->" + height;
                            }
                        });
                        view.setY(height);
                        break;
                    }
                }
                break;
        }
    }
}
