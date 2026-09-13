package com.oplus.melody.ui.component.detail.dress.carousel;

import Ea.F;
import Wb.l;
import com.oplus.melody.ui.widget.MelodyErrorLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: CarouselDressEditActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class CarouselDressEditActivity$initViewModel$3 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Integer num) {
        int iIntValue = num.intValue();
        CarouselDressEditActivity carouselDressEditActivity = (CarouselDressEditActivity) this.receiver;
        int i10 = CarouselDressEditActivity.f20767Y;
        if (iIntValue == 1) {
            carouselDressEditActivity.I(true);
        } else if (iIntValue == 2) {
            carouselDressEditActivity.I(false);
            MelodyErrorLayout melodyErrorLayout = carouselDressEditActivity.f20769V;
            if (melodyErrorLayout != null) {
                melodyErrorLayout.b();
            }
        } else if (iIntValue != 3) {
            carouselDressEditActivity.getClass();
        } else {
            carouselDressEditActivity.I(false);
            MelodyErrorLayout melodyErrorLayout2 = carouselDressEditActivity.f20769V;
            if (melodyErrorLayout2 != null) {
                melodyErrorLayout2.a(new F(carouselDressEditActivity, 12));
            }
        }
        return Jb.l.f2618a;
    }
}
