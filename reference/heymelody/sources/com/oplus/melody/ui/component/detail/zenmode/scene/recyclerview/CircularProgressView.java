package com.oplus.melody.ui.component.detail.zenmode.scene.recyclerview;

import E8.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class CircularProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f21505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f21506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f21507c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f21508p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f21509q;

    public CircularProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f1369g);
        Paint paint = new Paint();
        this.f21505a = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStrokeWidth(typedArrayObtainStyledAttributes.getDimension(1, 5.0f));
        paint.setColor(typedArrayObtainStyledAttributes.getColor(0, -3355444));
        Paint paint2 = new Paint();
        this.f21506b = paint2;
        paint2.setStyle(style);
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setStrokeWidth(typedArrayObtainStyledAttributes.getDimension(5, 10.0f));
        paint2.setColor(typedArrayObtainStyledAttributes.getColor(2, -16776961));
        int color = typedArrayObtainStyledAttributes.getColor(4, -1);
        int color2 = typedArrayObtainStyledAttributes.getColor(3, -1);
        if (color == -1 || color2 == -1) {
            this.f21508p = null;
        } else {
            this.f21508p = new int[]{color, color2};
        }
        this.f21509q = typedArrayObtainStyledAttributes.getInteger(6, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f21507c = new RectF();
    }

    public int getProgress() {
        return this.f21509q;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f21507c;
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.f21505a);
        canvas.drawArc(rectF, 275.0f, (this.f21509q * 360) / 100.0f, false, this.f21506b);
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        float f9 = measuredWidth > measuredHeight ? measuredHeight : measuredWidth;
        Paint paint = this.f21505a;
        float strokeWidth = paint.getStrokeWidth();
        Paint paint2 = this.f21506b;
        int strokeWidth2 = (int) (f9 - (strokeWidth > paint2.getStrokeWidth() ? paint.getStrokeWidth() : paint2.getStrokeWidth()));
        this.f21507c.set(((measuredWidth - strokeWidth2) / 2) + getPaddingLeft(), ((measuredHeight - strokeWidth2) / 2) + getPaddingTop(), r13 + strokeWidth2, r14 + strokeWidth2);
        int[] iArr = this.f21508p;
        if (iArr == null || iArr.length <= 1) {
            return;
        }
        paint2.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredWidth(), this.f21508p, (float[]) null, Shader.TileMode.MIRROR));
    }

    public void setBackColor(int i10) {
        this.f21505a.setColor(getContext().getColor(i10));
        invalidate();
    }

    public void setBackWidth(int i10) {
        this.f21505a.setStrokeWidth(i10);
        invalidate();
    }

    public void setProgColor(int i10) {
        Paint paint = this.f21506b;
        paint.setColor(getContext().getColor(i10));
        paint.setShader(null);
        invalidate();
    }

    public void setProgWidth(int i10) {
        this.f21506b.setStrokeWidth(i10);
        invalidate();
    }

    public void setProgress(int i10) {
        this.f21509q = i10;
        invalidate();
    }

    public void setProgColor(int[] iArr) {
        if (iArr == null || iArr.length < 2) {
            return;
        }
        this.f21508p = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            this.f21508p[i10] = getContext().getColor(iArr[i10]);
        }
        this.f21506b.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredWidth(), this.f21508p, (float[]) null, Shader.TileMode.MIRROR));
        invalidate();
    }
}
