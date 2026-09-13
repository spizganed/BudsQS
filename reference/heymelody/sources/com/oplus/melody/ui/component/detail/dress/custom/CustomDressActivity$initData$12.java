package com.oplus.melody.ui.component.detail.dress.custom;

import Wb.l;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: CustomDressActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class CustomDressActivity$initData$12 extends FunctionReferenceImpl implements l<Boolean, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Boolean bool) {
        Boolean bool2 = bool;
        CustomDressActivity customDressActivity = (CustomDressActivity) this.receiver;
        if (bool2 != null) {
            TextView textView = customDressActivity.f20895p0;
            if (textView == null) {
                h.i("mModelPromptTv");
                throw null;
            }
            textView.setVisibility(bool2.booleanValue() ? 0 : 4);
        } else {
            int i10 = CustomDressActivity.f20854T0;
            customDressActivity.getClass();
        }
        return Jb.l.f2618a;
    }
}
