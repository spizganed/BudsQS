package com.oplus.melody.ui.widget;

import E8.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.coui.appcompat.seekbar.FixCOUISectionSeekBar;
import com.heytap.headset.R;

/* JADX INFO: loaded from: classes3.dex */
public class MelodyMarkSeekBar extends FixCOUISectionSeekBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f21880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f21881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21882c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f21883p;

    /* JADX WARN: Illegal instructions before constructor call */
    public MelodyMarkSeekBar(Context context, AttributeSet attributeSet) {
        int i10 = P1.a.g(context) ? R.style.COUISeekBar_Dark : R.style.COUISeekBar;
        super(context, attributeSet, R.attr.couiSeekBarStyle, i10);
        Paint paint = new Paint();
        this.f21880a = paint;
        this.f21881b = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f1365c, R.attr.couiSeekBarStyle, i10);
        paint.setColor(typedArrayObtainStyledAttributes.getColor(0, -16777216));
        paint.setTextSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 54));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String strValueOf = String.valueOf(this.f21883p + this.f21882c);
        Paint paint = this.f21880a;
        int length = strValueOf.length();
        Rect rect = this.f21881b;
        paint.getTextBounds(strValueOf, 0, length, rect);
        float f9 = this.mThumbPosition;
        int i10 = rect.right;
        canvas.drawText(strValueOf, f9 - (((i10 - r5) / 2.0f) + rect.left), rect.bottom - rect.top, paint);
    }
}
