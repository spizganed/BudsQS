package com.oplus.melody.ui.component.detail.headmotion;

import D7.o0;
import Wb.l;
import android.os.Handler;
import androidx.appcompat.app.f;
import com.oplus.melody.common.util.S;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import qa.RunnableC1448a;

/* JADX INFO: compiled from: HeadMotionTryFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class HeadMotionTryFragment$observeConnectionState$1 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Integer num) {
        f fVar;
        Integer num2 = num;
        HeadMotionTryFragment headMotionTryFragment = (HeadMotionTryFragment) this.receiver;
        boolean z2 = headMotionTryFragment.f21072w;
        boolean z4 = num2 != null && num2.intValue() == 2;
        headMotionTryFragment.f21072w = z4;
        RunnableC1448a runnableC1448a = headMotionTryFragment.f21064F;
        if (z4) {
            androidx.fragment.app.f activity = headMotionTryFragment.getActivity();
            if (activity != null && (fVar = headMotionTryFragment.f21070u) != null && fVar.isShowing() && !activity.isFinishing() && !activity.isDestroyed()) {
                f fVar2 = headMotionTryFragment.f21070u;
                if (fVar2 != null) {
                    fVar2.dismiss();
                }
                headMotionTryFragment.f21070u = null;
                headMotionTryFragment.f21071v = false;
                S.z(activity);
                Handler handler = o0.c.f1143a;
                handler.removeCallbacks(runnableC1448a);
                handler.postDelayed(runnableC1448a, 120000L);
                headMotionTryFragment.r(true);
            }
        } else {
            androidx.fragment.app.f activity2 = headMotionTryFragment.getActivity();
            if (activity2 != null) {
                S.b(activity2);
            }
            o0.c.f1143a.removeCallbacks(runnableC1448a);
            if (z2) {
                f fVar3 = headMotionTryFragment.f21069t;
                if (fVar3 != null) {
                    fVar3.dismiss();
                }
                headMotionTryFragment.f21069t = null;
                f fVar4 = headMotionTryFragment.f21068s;
                if (fVar4 != null) {
                    fVar4.dismiss();
                }
                headMotionTryFragment.f21068s = null;
                headMotionTryFragment.s();
            }
        }
        return Jb.l.f2618a;
    }
}
