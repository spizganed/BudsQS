package com.oplus.melody.ui.component.tutorialguide.noise;

import Wb.l;
import com.coui.appcompat.preference.COUIJumpPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: TutorialGuideNoisePreferenceFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class TutorialGuideNoisePreferenceFragment$onViewCreated$1$1 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Integer num) {
        int iIntValue = num.intValue();
        COUIJumpPreference cOUIJumpPreference = ((TutorialGuideNoisePreferenceFragment) this.receiver).f21697B;
        if (cOUIJumpPreference != null) {
            cOUIJumpPreference.setEnabled(iIntValue == 2);
        }
        return Jb.l.f2618a;
    }
}
