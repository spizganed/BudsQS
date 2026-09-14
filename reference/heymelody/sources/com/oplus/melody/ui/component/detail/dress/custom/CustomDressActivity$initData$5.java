package com.oplus.melody.ui.component.detail.dress.custom;

import B9.e;
import Wb.l;
import android.view.View;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.widget.MelodyLottieAnimationView;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: CustomDressActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class CustomDressActivity$initData$5 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Integer num) {
        Integer num2 = num;
        CustomDressActivity customDressActivity = (CustomDressActivity) this.receiver;
        int i10 = CustomDressActivity.f20854T0;
        customDressActivity.getClass();
        A.c("CustomDressActivity", new e(4, num2));
        if (num2 != null) {
            MelodyLottieAnimationView melodyLottieAnimationView = customDressActivity.f20885f0;
            if (melodyLottieAnimationView == null) {
                h.i("mResLoadingView");
                throw null;
            }
            melodyLottieAnimationView.setVisibility(num2.intValue() == 2 ? 0 : 8);
            View view = customDressActivity.f20886g0;
            if (view == null) {
                h.i("mErrorLayout");
                throw null;
            }
            view.setVisibility(num2.intValue() == 3 ? 0 : 8);
            View view2 = customDressActivity.f20874U;
            if (view2 == null) {
                h.i("mPickResLayout");
                throw null;
            }
            view2.setVisibility(num2.intValue() == 1 ? 0 : 8);
        }
        return Jb.l.f2618a;
    }
}
