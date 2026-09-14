package com.oplus.melody.app.discovery;

import android.view.View;
import com.heytap.headset.R;
import com.oplus.melody.ui.widget.MelodyCompatImageView;
import java.util.List;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DiscoveryBatteryGroupDefaultImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0851g extends G0.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C0833a f19096j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0833a f19097k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final C0833a f19098l;

    public C0851g(View rootView) {
        kotlin.jvm.internal.h.e(rootView, "rootView");
        this.f19096j = new C0833a(R.id.melody_app_discovery_connected_battery_neck, rootView);
        this.f19097k = new C0833a(R.id.melody_app_discovery_connected_battery_buds, rootView);
        this.f19098l = new C0833a(R.id.melody_app_discovery_connected_battery_box, rootView);
    }

    @Override // G0.c
    public final List<View> h() {
        return Kb.l.e(this.f19097k.f19029d, this.f19098l.f19029d, this.f19096j.f19029d);
    }

    @Override // G0.c
    public final void k() {
        MelodyCompatImageView melodyCompatImageView = this.f19097k.f19030e;
        if (melodyCompatImageView != null) {
            melodyCompatImageView.setVisibility(4);
        }
        MelodyCompatImageView melodyCompatImageView2 = this.f19098l.f19030e;
        if (melodyCompatImageView2 != null) {
            melodyCompatImageView2.setVisibility(4);
        }
        MelodyCompatImageView melodyCompatImageView3 = this.f19096j.f19030e;
        if (melodyCompatImageView3 != null) {
            melodyCompatImageView3.setVisibility(4);
        }
    }

    @Override // G0.c
    public final void l() {
        this.f19097k.b();
        this.f19098l.b();
        this.f19096j.b();
    }

    @Override // G0.c
    public final void v(boolean z2) {
        this.f19097k.f(z2);
        this.f19098l.f(z2);
        this.f19096j.f(z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x050a  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x052a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0533 A[RETURN] */
    @Override // G0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int x(android.content.Context r31, com.oplus.melody.app.discovery.E0 r32, com.oplus.melody.app.discovery.C1 r33, u8.C1557e r34, boolean r35) {
        /*
            Method dump skipped, instruction units count: 1332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.app.discovery.C0851g.x(android.content.Context, com.oplus.melody.app.discovery.E0, com.oplus.melody.app.discovery.C1, u8.e, boolean):int");
    }

    @Override // G0.c
    public final void y(String str) {
        J6.d.c(this.f19097k.f19030e, str);
        J6.d.c(this.f19098l.f19030e, str);
        J6.d.c(this.f19096j.f19030e, str);
    }

    @Override // G0.c
    public final void z() {
        this.f19097k.j();
        this.f19098l.j();
        this.f19096j.j();
    }
}
