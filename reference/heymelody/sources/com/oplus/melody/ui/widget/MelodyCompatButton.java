package com.oplus.melody.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.coui.appcompat.button.COUIButton;
import com.heytap.headset.R;

/* JADX INFO: loaded from: classes3.dex */
public class MelodyCompatButton extends COUIButton {

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public final int f21777S;

    public MelodyCompatButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21777S = getResources().getDimensionPixelOffset(R.dimen.melody_ui_horizontal_single_btn_width_max);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, Ia.a.f2371a);
            this.f21777S = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, this.f21777S);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // com.coui.appcompat.button.COUIButton, android.widget.TextView, android.view.View
    public final void onMeasure(int i10, int i11) {
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            int size = View.MeasureSpec.getSize(i10);
            int i12 = this.f21777S;
            if (size > i12) {
                i10 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            }
        }
        super.onMeasure(i10, i11);
    }
}
