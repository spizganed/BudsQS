package com.oplus.melody.ui.component.detail.dress.custom;

import Wb.l;
import androidx.appcompat.app.f;
import com.heytap.headset.R;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: CustomDressActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class CustomDressActivity$initData$7 extends FunctionReferenceImpl implements l<Boolean, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Boolean bool) {
        Boolean bool2 = bool;
        CustomDressActivity customDressActivity = (CustomDressActivity) this.receiver;
        if (bool2 != null) {
            f fVar = customDressActivity.f20859E0;
            if (fVar != null && fVar.isShowing()) {
                fVar.dismiss();
            }
            if (bool2.booleanValue()) {
                customDressActivity.f20859E0 = new R1.l(customDressActivity, customDressActivity.getString(R.string.melody_ui_custom_dress_saving)).a();
            }
        } else {
            int i10 = CustomDressActivity.f20854T0;
            customDressActivity.getClass();
        }
        return Jb.l.f2618a;
    }
}
