package com.oplus.melody.ui.component.hearingenhance.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class WebAreaView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f21635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21637c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f21638p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Paint f21639q;

    public WebAreaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21635a = new float[]{0.5f, 0.35f, 0.2f, 0.05f};
        this.f21636b = -526345;
        this.f21637c = 6;
        Paint paint = new Paint();
        this.f21639q = paint;
        paint.setColor(this.f21636b);
        this.f21639q.setAntiAlias(true);
        this.f21639q.setStyle(Paint.Style.STROKE);
        if (Build.VERSION.SDK_INT >= 29) {
            setForceDarkAllowed(false);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.save();
        float f9 = this.f21638p;
        canvas.translate(f9 / 2.0f, f9 / 2.0f);
        for (float f10 : this.f21635a) {
            canvas.drawCircle(0.0f, 0.0f, this.f21638p * f10, this.f21639q);
        }
        float f11 = 360.0f / this.f21637c;
        canvas.rotate(30.0f);
        for (int i10 = 0; i10 < this.f21637c; i10++) {
            canvas.drawLine(0.0f, 0.0f, 0.0f, this.f21638p / 2.0f, this.f21639q);
            canvas.rotate(f11);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        this.f21638p = View.MeasureSpec.getSize(i10);
        super.onMeasure(i10, i11);
    }

    public void setColor(int i10) {
        this.f21636b = i10;
        this.f21639q.setColor(i10);
        invalidate();
    }

    public void setWebLineWidth(float f9) {
        this.f21639q.setStrokeWidth(f9);
    }

    public void setXAxisCount(int i10) {
        this.f21637c = i10;
    }
}
