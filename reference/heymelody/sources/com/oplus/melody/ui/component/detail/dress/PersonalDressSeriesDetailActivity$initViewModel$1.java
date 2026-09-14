package com.oplus.melody.ui.component.detail.dress;

import D7.Y;
import Wb.l;
import com.oplus.melody.common.util.A;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: PersonalDressSeriesDetailActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class PersonalDressSeriesDetailActivity$initViewModel$1 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Integer num) {
        int iIntValue = num.intValue();
        PersonalDressSeriesDetailActivity personalDressSeriesDetailActivity = (PersonalDressSeriesDetailActivity) this.receiver;
        int i10 = PersonalDressSeriesDetailActivity.f20733W;
        personalDressSeriesDetailActivity.getClass();
        A.c("PersonalDressSeriesDetailActivity", new Y(iIntValue, 19));
        if (iIntValue == 3) {
            personalDressSeriesDetailActivity.finish();
        }
        return Jb.l.f2618a;
    }
}
