package com.oplus.melody.ui.component.hearingenhance.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.flexbox.FlexItem;
import com.heytap.headset.R;
import p2.C1395b;

/* JADX INFO: loaded from: classes3.dex */
public class DetectingProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f21588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f21589c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f21590p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f21591q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f21592r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f21593s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Paint f21594t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Paint f21595u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Paint f21596v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Matrix f21597w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final LinearGradient f21598x;

    public DetectingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (Build.VERSION.SDK_INT >= 29) {
            setForceDarkAllowed(false);
        }
        Paint paint = new Paint();
        this.f21594t = paint;
        paint.setAntiAlias(true);
        this.f21594t.setColor(C1395b.a(getContext(), R.attr.couiColorPrimary));
        Paint paint2 = this.f21594t;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.f21595u = paint3;
        paint3.setAntiAlias(true);
        this.f21595u.setStyle(style);
        Paint paint4 = new Paint();
        this.f21596v = paint4;
        paint4.setAntiAlias(true);
        this.f21596v.setColor(getContext().getColor(R.color.melody_ui_hearing_enhancement_detecting_progress_bg));
        this.f21596v.setStyle(style);
        this.f21588b = getContext().getResources().getDimension(R.dimen.melody_ui_hearing_enhancement_progress_corner);
        this.f21589c = getContext().getResources().getDimension(R.dimen.melody_ui_hearing_enhancement_progress_item_width);
        this.f21590p = getContext().getResources().getDimension(R.dimen.melody_ui_hearing_enhancement_progress_item_height);
        this.f21591q = getContext().getResources().getDimension(R.dimen.melody_ui_hearing_enhancement_progress_space_width);
        this.f21592r = getContext().getResources().getDimension(R.dimen.melody_ui_hearing_enhancement_progress_center_space_width);
        this.f21597w = new Matrix();
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.f21589c, this.f21590p, new int[]{C1395b.a(getContext(), R.attr.couiColorPrimary), C1395b.a(getContext(), R.attr.couiColorPrimary) & FlexItem.MAX_SIZE}, (float[]) null, Shader.TileMode.MIRROR);
        this.f21598x = linearGradient;
        this.f21595u.setShader(linearGradient);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        float f9;
        float f10;
        super.onDraw(canvas);
        int i10 = 0;
        float f11 = this.f21593s;
        while (i10 < 12) {
            int i11 = this.f21587a;
            if (i10 == i11) {
                this.f21597w.setTranslate(f11, 0.0f);
                this.f21598x.setLocalMatrix(this.f21597w);
                float f12 = f11 + this.f21589c;
                float f13 = this.f21590p;
                float f14 = this.f21588b;
                canvas2 = canvas;
                canvas2.drawRoundRect(f11, 0.0f, f12, f13, f14, f14, this.f21595u);
            } else {
                canvas2 = canvas;
                if (i10 < i11) {
                    float f15 = f11 + this.f21589c;
                    float f16 = this.f21590p;
                    float f17 = this.f21588b;
                    canvas2.drawRoundRect(f11, 0.0f, f15, f16, f17, f17, this.f21594t);
                } else {
                    float f18 = f11 + this.f21589c;
                    float f19 = this.f21590p;
                    float f20 = this.f21588b;
                    canvas2.drawRoundRect(f11, 0.0f, f18, f19, f20, f20, this.f21596v);
                }
            }
            if (i10 == 5) {
                f9 = f11 + this.f21589c;
                f10 = this.f21592r;
            } else {
                f9 = f11 + this.f21589c;
                f10 = this.f21591q;
            }
            f11 = f9 + f10;
            i10++;
            canvas = canvas2;
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        this.f21593s = (((View.MeasureSpec.getSize(i10) - (this.f21589c * 12.0f)) - (this.f21591q * 10.0f)) - this.f21592r) / 2.0f;
        super.onMeasure(i10, i11);
    }

    public void setProgress(int i10) {
        this.f21587a = i10;
        invalidate();
    }
}
