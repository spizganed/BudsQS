package com.oplus.melody.app.discovery;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.headset.R;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0883u implements ViewPager2.g {
    @Override // androidx.viewpager2.widget.ViewPager2.g
    public final void h(View view, float f9) {
        int i10 = DiscoveryDialogActivity.f18836L0;
        if (f9 < -1.0f) {
            f9 = -1.0f;
        } else if (f9 > 1.0f) {
            f9 = 1.0f;
        }
        int iMax = Math.max(1, view.getResources().getDimensionPixelSize(R.dimen.melody_app_discovery_recycle_item_size_min));
        float fMax = (iMax * 1.0f) / Math.max(1, view.getResources().getDimensionPixelSize(R.dimen.melody_app_discovery_recycle_item_size));
        float fAbs = ((1.0f - fMax) * (1.0f - Math.abs(f9))) + fMax;
        view.setScaleX(fAbs);
        view.setScaleY(fAbs);
        view.setTranslationX((-f9) * (view.getWidth() - ((r1 + iMax) / 2)));
        view.setAlpha(1.0f - (Math.abs(f9) * 0.19999999f));
    }
}
