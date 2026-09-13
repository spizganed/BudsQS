package com.oplus.melody.ui.component.detail.dress;

import Ea.ViewOnClickListenerC0405n;
import Wb.l;
import com.oplus.melody.ui.widget.MelodyErrorLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: PersonalDressActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class PersonalDressActivity$initViewModel$3 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Integer num) {
        int iIntValue = num.intValue();
        PersonalDressActivity personalDressActivity = (PersonalDressActivity) this.receiver;
        int i10 = PersonalDressActivity.f20664Y;
        if (iIntValue == 1) {
            personalDressActivity.K(true);
        } else if (iIntValue == 2) {
            personalDressActivity.K(false);
            MelodyErrorLayout melodyErrorLayout = personalDressActivity.f20666V;
            if (melodyErrorLayout == null) {
                h.i("mErrorLayout");
                throw null;
            }
            melodyErrorLayout.b();
        } else if (iIntValue != 3) {
            personalDressActivity.getClass();
        } else {
            personalDressActivity.K(false);
            MelodyErrorLayout melodyErrorLayout2 = personalDressActivity.f20666V;
            if (melodyErrorLayout2 == null) {
                h.i("mErrorLayout");
                throw null;
            }
            melodyErrorLayout2.a(new ViewOnClickListenerC0405n(personalDressActivity, 12));
        }
        return Jb.l.f2618a;
    }
}
