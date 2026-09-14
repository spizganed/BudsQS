package com.oplus.melody.ui.component.detail.headmotion;

import Wb.l;
import androidx.fragment.app.f;
import com.oplus.melody.common.util.A;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: HeadMotionFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class HeadMotionFragment$onViewCreated$2$1 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Integer num) {
        f activity;
        Integer num2 = num;
        HeadMotionFragment headMotionFragment = (HeadMotionFragment) this.receiver;
        headMotionFragment.getClass();
        A.b("HeadMotionFragment", "onConnectStateChange connectState = " + num2);
        if ((num2 == null || num2.intValue() != 2) && (activity = headMotionFragment.getActivity()) != null) {
            activity.finish();
        }
        return Jb.l.f2618a;
    }
}
