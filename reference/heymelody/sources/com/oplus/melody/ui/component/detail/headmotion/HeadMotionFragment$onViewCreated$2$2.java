package com.oplus.melody.ui.component.detail.headmotion;

import Wb.l;
import com.oplus.melody.common.util.A;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: HeadMotionFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class HeadMotionFragment$onViewCreated$2$2 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Integer num) {
        HeadMotionSwitchWithTryPreference headMotionSwitchWithTryPreference;
        Integer num2 = num;
        HeadMotionFragment headMotionFragment = (HeadMotionFragment) this.receiver;
        headMotionFragment.getClass();
        A.b("HeadMotionFragment", "onHeadMotionStatusChange headMotionStatus = " + num2);
        Boolean bool = (num2 != null && num2.intValue() == 1) ? Boolean.TRUE : (num2 != null && num2.intValue() == 0) ? Boolean.FALSE : null;
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            HeadMotionSwitchWithTryPreference headMotionSwitchWithTryPreference2 = headMotionFragment.f21041B;
            if ((headMotionSwitchWithTryPreference2 == null || headMotionSwitchWithTryPreference2.isChecked() != zBooleanValue) && (headMotionSwitchWithTryPreference = headMotionFragment.f21041B) != null) {
                headMotionSwitchWithTryPreference.setChecked(zBooleanValue);
            }
            headMotionFragment.w(zBooleanValue);
        }
        return Jb.l.f2618a;
    }
}
