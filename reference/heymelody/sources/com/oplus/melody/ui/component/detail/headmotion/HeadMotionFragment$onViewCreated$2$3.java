package com.oplus.melody.ui.component.detail.headmotion;

import Wb.l;
import com.oplus.melody.common.util.A;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: HeadMotionFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class HeadMotionFragment$onViewCreated$2$3 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Integer num) {
        Integer num2 = num;
        HeadMotionFragment headMotionFragment = (HeadMotionFragment) this.receiver;
        headMotionFragment.getClass();
        A.b("HeadMotionFragment", "onHeadMotionTypeChange headMotionType = " + num2);
        if (num2 != null) {
            int iIntValue = num2.intValue();
            headMotionFragment.H = num2;
            headMotionFragment.v();
            headMotionFragment.s(iIntValue);
        }
        return Jb.l.f2618a;
    }
}
