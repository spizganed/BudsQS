package com.oplus.melody.ui.component.detail.wearingvideotutorial;

import I8.D;
import Wb.l;
import com.oplus.melody.ui.widget.MelodyCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: WearingVideoTutorialFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class WearingVideoTutorialFragment$initView$4 extends FunctionReferenceImpl implements l<D, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(D d10) {
        MelodyCompatTextView melodyCompatTextView;
        MelodyCompatTextView melodyCompatTextView2;
        D p02 = d10;
        h.e(p02, "p0");
        WearingVideoTutorialFragment wearingVideoTutorialFragment = (WearingVideoTutorialFragment) this.receiver;
        wearingVideoTutorialFragment.getClass();
        String mSummary = p02.getMSummary();
        if (mSummary != null && (melodyCompatTextView2 = wearingVideoTutorialFragment.f21405x) != null) {
            melodyCompatTextView2.setText(mSummary);
        }
        String mSecondSummary = p02.getMSecondSummary();
        if (mSecondSummary != null && (melodyCompatTextView = wearingVideoTutorialFragment.f21404w) != null) {
            melodyCompatTextView.setText(mSecondSummary);
        }
        return Jb.l.f2618a;
    }
}
