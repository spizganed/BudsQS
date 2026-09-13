package com.oplus.melody.app.discovery;

import android.graphics.Color;
import android.view.View;

/* JADX INFO: compiled from: IDiscoveryDialogWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
public interface E1 {
    void b(View view);

    void c(F8.a aVar);

    void dismiss();

    void e(r rVar);

    void f();

    void i(DiscoveryDialogActivity discoveryDialogActivity);

    boolean isShowing();

    default int j() {
        return Color.argb(138, 0, 0, 0);
    }

    <T extends View> T k(int i10);

    void l(DialogInterfaceOnDismissListenerC0879s dialogInterfaceOnDismissListenerC0879s);

    void show();

    default void a() {
    }

    default void g() {
    }

    default void d(boolean z2) {
    }

    default void h(ViewOnTouchListenerC0881t viewOnTouchListenerC0881t) {
    }

    default void m(boolean z2) {
    }
}
