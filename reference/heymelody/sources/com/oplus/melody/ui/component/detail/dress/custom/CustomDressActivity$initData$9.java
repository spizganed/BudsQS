package com.oplus.melody.ui.component.detail.dress.custom;

import D7.o0;
import Wb.l;
import android.os.Handler;
import com.oplus.melody.ui.component.detail.dress.custom.CustomDressActivity;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: CustomDressActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class CustomDressActivity$initData$9 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Integer num) {
        Handler handler;
        Integer num2 = num;
        CustomDressActivity customDressActivity = (CustomDressActivity) this.receiver;
        if (num2 != null) {
            if (customDressActivity.f20860F0 == null) {
                customDressActivity.f20860F0 = new Handler(o0.c.f1145c.b());
            }
            customDressActivity.f20863I0 = true;
            CustomDressActivity.a aVar = customDressActivity.f20861G0;
            if (aVar != null && (handler = customDressActivity.f20860F0) != null) {
                handler.removeCallbacks(aVar);
            }
            CustomDressActivity.a aVar2 = new CustomDressActivity.a(num2.intValue(), new WeakReference(customDressActivity));
            customDressActivity.f20861G0 = aVar2;
            Handler handler2 = customDressActivity.f20860F0;
            if (handler2 != null) {
                handler2.postDelayed(aVar2, 200L);
            }
        } else {
            int i10 = CustomDressActivity.f20854T0;
            customDressActivity.getClass();
        }
        return Jb.l.f2618a;
    }
}
