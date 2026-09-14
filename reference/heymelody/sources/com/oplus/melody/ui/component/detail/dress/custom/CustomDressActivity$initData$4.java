package com.oplus.melody.ui.component.detail.dress.custom;

import D7.L;
import Wb.l;
import com.oplus.melody.common.util.A;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: CustomDressActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class CustomDressActivity$initData$4 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Integer num) {
        int iIntValue = num.intValue();
        CustomDressActivity customDressActivity = (CustomDressActivity) this.receiver;
        int i10 = CustomDressActivity.f20854T0;
        customDressActivity.getClass();
        A.c("CustomDressActivity", new L(iIntValue, 22));
        if (iIntValue == 3) {
            customDressActivity.finish();
        }
        return Jb.l.f2618a;
    }
}
