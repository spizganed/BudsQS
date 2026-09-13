package com.oplus.melody.app.discovery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.heytap.headset.R;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import t8.C1532B;
import u8.C1557e;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DiscoveryBatteryGroupFlexibleImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0854h extends G0.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f19104j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f19105k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Fa.c f19106l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Fa.c f19107m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Fa.c f19108n;

    public C0854h(int i10, View mRootView) {
        kotlin.jvm.internal.h.e(mRootView, "mRootView");
        this.f19104j = mRootView;
        View viewInflate = ((ViewStub) mRootView.findViewById(i10)).inflate();
        viewInflate.setVisibility(4);
        this.f19105k = viewInflate;
        this.f19106l = A(R.id.melody_ui_battery_group_box, R.drawable.melody_ui_battery_device_box);
        this.f19107m = A(R.id.melody_ui_battery_group_left, R.drawable.melody_ui_battery_device_left);
        this.f19108n = A(R.id.melody_ui_battery_group_right, R.drawable.melody_ui_battery_device_right);
    }

    public final Fa.c A(int i10, int i11) {
        View viewFindViewById = this.f19105k.findViewById(i10);
        kotlin.jvm.internal.h.d(viewFindViewById, "findViewById(...)");
        Fa.c cVar = new Fa.c(viewFindViewById);
        cVar.g(i11);
        return cVar;
    }

    @Override // G0.c
    public final View g() {
        View mViewGroup = this.f19105k;
        kotlin.jvm.internal.h.d(mViewGroup, "mViewGroup");
        return mViewGroup;
    }

    @Override // G0.c
    public final List<View> h() {
        return Kb.l.e(this.f19107m.f1776a, this.f19108n.f1776a, this.f19106l.f1776a);
    }

    @Override // G0.c
    public final void l() {
        this.f19105k.setVisibility(4);
    }

    @Override // G0.c
    public final void v(boolean z2) {
        this.f19107m.d(z2);
        this.f19108n.d(z2);
        this.f19106l.d(z2);
        if (z2) {
            DiscoveryDialogActivity.Q(this.f19105k);
        }
    }

    @Override // G0.c
    public final int x(Context context, E0 earphone, C1 zipConfig, C1557e c1557e, boolean z2) {
        MelodyResourceDO batteriesRes;
        kotlin.jvm.internal.h.e(context, "context");
        kotlin.jvm.internal.h.e(earphone, "earphone");
        kotlin.jvm.internal.h.e(zipConfig, "zipConfig");
        boolean showBatteryRes = c1557e != null ? c1557e.getShowBatteryRes() : true;
        Fa.c cVar = this.f19108n;
        Fa.c cVar2 = this.f19107m;
        Fa.c cVar3 = this.f19106l;
        if (c1557e != null && (batteriesRes = c1557e.getBatteriesRes()) != null) {
            com.oplus.melody.common.util.A.c("DiscoveryBatteryGroupFlexibleImpl", new C0874p(batteriesRes, 2));
            ConcurrentHashMap concurrentHashMap = C1532B.f27917a;
            View view = this.f19105k;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (batteriesRes.getGravity() <= 0 || !(layoutParams instanceof FrameLayout.LayoutParams)) {
                C1532B.f(batteriesRes, view, this.f19104j);
            } else {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = batteriesRes.getGravity();
                layoutParams2.leftMargin = batteriesRes.getLeftMargin();
                layoutParams2.topMargin = batteriesRes.getTopMargin();
                layoutParams2.rightMargin = batteriesRes.getRightMargin();
                layoutParams2.bottomMargin = batteriesRes.getBottomMargin();
                view.setLayoutParams(layoutParams2);
            }
            Integer numC = C1532B.c(context, batteriesRes.getTextColor(), batteriesRes.getTextColorNight());
            if (numC != null) {
                int iIntValue = numC.intValue();
                cVar3.c(iIntValue);
                cVar2.c(iIntValue);
                cVar.c(iIntValue);
            }
            Integer numC2 = C1532B.c(context, batteriesRes.getBackgroundColor(), batteriesRes.getBackgroundColorNight());
            if (numC2 != null) {
                int iIntValue2 = numC2.intValue();
                cVar3.b(iIntValue2);
                cVar2.b(iIntValue2);
                cVar.b(iIntValue2);
            }
            Integer numC3 = C1532B.c(context, batteriesRes.getForegroundColor(), batteriesRes.getForegroundColorNight());
            if (numC3 != null) {
                int iIntValue3 = numC3.intValue();
                cVar3.e(iIntValue3);
                cVar2.e(iIntValue3);
                cVar.e(iIntValue3);
            }
            int iG = C1532B.g(context, 0, batteriesRes.getTextSize());
            if (iG > 0) {
                float f9 = iG;
                cVar3.f1780e.setTextSize(0, f9);
                cVar2.f1780e.setTextSize(0, f9);
                cVar.f1780e.setTextSize(0, f9);
            }
        }
        if (earphone.getLeftBattery() <= 0 || !showBatteryRes) {
            cVar2.i(8);
        } else {
            cVar2.h(earphone.getLeftBattery(), earphone.isLeftCharging());
            cVar2.i(0);
        }
        if (earphone.getRightBattery() <= 0 || !showBatteryRes) {
            cVar.i(8);
        } else {
            cVar.h(earphone.getRightBattery(), earphone.isRightCharging());
            cVar.i(0);
        }
        if (earphone.getBoxBattery() <= 0 || !showBatteryRes) {
            cVar3.i(8);
            return 8;
        }
        cVar3.h(earphone.getBoxBattery(), earphone.isBoxCharging());
        cVar3.i(0);
        return 8;
    }

    @Override // G0.c
    public final void z() {
        this.f19105k.setVisibility(0);
    }

    @Override // G0.c
    public final void k() {
    }

    @Override // G0.c
    public final void y(String str) {
    }
}
