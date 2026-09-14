package com.oplus.melody.ui.component.detail.dress.custom;

import Wb.l;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: CustomDressActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class CustomDressActivity$initData$13 extends FunctionReferenceImpl implements l<Boolean, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Boolean bool) {
        Boolean bool2 = bool;
        CustomDressActivity customDressActivity = (CustomDressActivity) this.receiver;
        CustomDressViewModel customDressViewModel = customDressActivity.f20892m0;
        if (customDressViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        Integer numD = customDressViewModel.f20938y.d();
        if ((numD != null ? numD.intValue() : 0) == 0) {
            customDressActivity.I(bool2);
        }
        return Jb.l.f2618a;
    }
}
