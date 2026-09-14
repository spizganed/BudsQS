package com.oplus.melody.ui.component.detail.dress.custom;

import Wb.l;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.headset.R;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: CustomDressActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class CustomDressActivity$initData$17 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Integer num) {
        Integer num2 = num;
        CustomDressActivity customDressActivity = (CustomDressActivity) this.receiver;
        int i10 = CustomDressActivity.f20854T0;
        customDressActivity.getClass();
        if (num2 != null) {
            if (num2.intValue() == 2 || num2.intValue() == 3) {
                View view = customDressActivity.f20880a0;
                if (view == null) {
                    h.i("mDefaultBatteryLayout");
                    throw null;
                }
                view.setVisibility(8);
                View view2 = customDressActivity.f20882c0;
                if (view2 == null) {
                    h.i("mBelowBatteryLayout");
                    throw null;
                }
                view2.setVisibility(8);
                View view3 = customDressActivity.f20881b0;
                if (view3 == null) {
                    h.i("mVerticalBatteryLayout");
                    throw null;
                }
                view3.setVisibility(0);
                View view4 = customDressActivity.f20881b0;
                if (view4 == null) {
                    h.i("mVerticalBatteryLayout");
                    throw null;
                }
                ViewGroup.LayoutParams layoutParams = view4.getLayoutParams();
                h.c(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                int dimensionPixelOffset = customDressActivity.getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_dress_vertical_group_battery_horizontal_margin);
                if (num2.intValue() == 2) {
                    layoutParams2.gravity = 51;
                    layoutParams2.leftMargin = dimensionPixelOffset;
                } else {
                    layoutParams2.gravity = 53;
                    layoutParams2.rightMargin = dimensionPixelOffset;
                }
                View view5 = customDressActivity.f20881b0;
                if (view5 == null) {
                    h.i("mVerticalBatteryLayout");
                    throw null;
                }
                view5.setLayoutParams(layoutParams2);
            } else if (num2.intValue() == 4) {
                View view6 = customDressActivity.f20880a0;
                if (view6 == null) {
                    h.i("mDefaultBatteryLayout");
                    throw null;
                }
                view6.setVisibility(8);
                View view7 = customDressActivity.f20881b0;
                if (view7 == null) {
                    h.i("mVerticalBatteryLayout");
                    throw null;
                }
                view7.setVisibility(8);
                View view8 = customDressActivity.f20882c0;
                if (view8 == null) {
                    h.i("mBelowBatteryLayout");
                    throw null;
                }
                view8.setVisibility(0);
            } else {
                View view9 = customDressActivity.f20881b0;
                if (view9 == null) {
                    h.i("mVerticalBatteryLayout");
                    throw null;
                }
                view9.setVisibility(8);
                View view10 = customDressActivity.f20882c0;
                if (view10 == null) {
                    h.i("mBelowBatteryLayout");
                    throw null;
                }
                view10.setVisibility(8);
                View view11 = customDressActivity.f20880a0;
                if (view11 == null) {
                    h.i("mDefaultBatteryLayout");
                    throw null;
                }
                view11.setVisibility(0);
            }
            CustomDressViewModel customDressViewModel = customDressActivity.f20892m0;
            if (customDressViewModel == null) {
                h.i("mViewModel");
                throw null;
            }
            customDressActivity.J(customDressViewModel.f20938y.d());
        }
        return Jb.l.f2618a;
    }
}
