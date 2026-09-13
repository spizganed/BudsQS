package com.oplus.melody.ui.component.detail.dress.custom;

import Wb.l;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: CustomDressActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class CustomDressActivity$initData$15 extends FunctionReferenceImpl implements l<Boolean, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Boolean bool) {
        Boolean bool2 = bool;
        CustomDressActivity customDressActivity = (CustomDressActivity) this.receiver;
        if (bool2 != null) {
            ImageView imageView = customDressActivity.f20884e0;
            if (imageView == null) {
                h.i("mBudsImg");
                throw null;
            }
            imageView.setVisibility(bool2.booleanValue() ? 0 : 4);
            ImageView imageView2 = customDressActivity.f20883d0;
            if (imageView2 == null) {
                h.i("mBoxImg");
                throw null;
            }
            imageView2.setVisibility(bool2.booleanValue() ? 0 : 4);
        } else {
            int i10 = CustomDressActivity.f20854T0;
            customDressActivity.getClass();
        }
        return Jb.l.f2618a;
    }
}
