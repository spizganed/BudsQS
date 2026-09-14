package com.oplus.melody.ui.component.detail.equalizer.customv2;

import P1.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.headset.R;

/* JADX INFO: loaded from: classes3.dex */
public class FrequencyViewV2 extends View {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final Paint f20990A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public float f20991B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public float f20992C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f20993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f20994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f20995c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f20996p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f20997q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f20998r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f20999s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final DashPathEffect f21000t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f21001u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f21002v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f21003w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public PointF[] f21004x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f21005y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float[] f21006z;

    public FrequencyViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        this.f21000t = null;
        Resources resources = getResources();
        this.f20993a = resources.getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_seekbar_bg_width);
        this.f20994b = resources.getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_seekbar_bg_max_width);
        this.f20995c = resources.getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_seekbar_fg_width);
        this.f20996p = resources.getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_seekbar_fg_max_width);
        this.f20999s = resources.getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_midline_width);
        this.f20997q = resources.getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_thumb_radius);
        this.f20998r = resources.getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_thumb_border);
        this.f21001u = a.b(context, R.attr.couiColorLabelQuaternary, 0);
        this.f21002v = a.b(context, R.attr.couiColorLabelTheme, 0);
        this.f21003w = a.b(context, R.attr.couiColorLabelOnColor, 0);
        this.f20990A = new Paint();
        this.f21000t = new DashPathEffect(new float[]{5.0f, 2.0f}, 0.0f);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        PointF[] pointFArr = this.f21004x;
        if (pointFArr == null || pointFArr.length <= 0) {
            return;
        }
        float f9 = (this.f20991B + this.f20992C) / 2.0f;
        int length = pointFArr.length;
        float f10 = this.f20994b;
        float f11 = this.f20993a;
        int i10 = this.f21001u;
        if (length > 1) {
            this.f20990A.reset();
            this.f20990A.setAntiAlias(true);
            this.f20990A.setStyle(Paint.Style.FILL);
            this.f20990A.setStrokeWidth(this.f20999s);
            this.f20990A.setColor(i10);
            this.f20990A.setPathEffect(this.f21000t);
            PointF[] pointFArr2 = this.f21004x;
            int length2 = pointFArr2.length - 1;
            PointF pointF = pointFArr2[0];
            PointF pointF2 = pointFArr2[length2];
            float[] fArr = this.f21006z;
            canvas.drawLine(pointF.x - ((((f10 - f11) * fArr[0]) + f11) / 2.0f), f9, ((((f10 - f11) * fArr[length2]) + f11) / 2.0f) + pointF2.x, f9, this.f20990A);
        }
        this.f20990A.reset();
        this.f20990A.setAntiAlias(true);
        this.f20990A.setStyle(Paint.Style.FILL);
        for (int i11 = 0; i11 < this.f21004x.length; i11++) {
            this.f20990A.setColor(i10);
            float f12 = (((f10 - f11) * this.f21006z[i11]) + f11) / 2.0f;
            float f13 = this.f21004x[i11].x;
            canvas.drawRoundRect(f13 - f12, this.f20991B - f12, f13 + f12, this.f20992C + f12, f12, f12, this.f20990A);
            Paint paint = this.f20990A;
            int i12 = this.f21002v;
            paint.setColor(i12);
            float f14 = this.f20996p;
            float f15 = this.f20995c;
            float f16 = (((f14 - f15) * this.f21006z[i11]) + f15) / 2.0f;
            PointF pointF3 = this.f21004x[i11];
            float f17 = pointF3.y;
            float f18 = f17 - f16;
            if (f18 > f9) {
                f18 = f9;
            }
            float f19 = f17 + f16;
            float f20 = f19 < f9 ? f9 : f19;
            float f21 = pointF3.x;
            canvas.drawRoundRect(f21 - f16, f18, f21 + f16, f20, f16, f16, this.f20990A);
            this.f20990A.setColor(i12);
            PointF pointF4 = this.f21004x[i11];
            float f22 = pointF4.x;
            float f23 = pointF4.y;
            float f24 = this.f20998r;
            float f25 = this.f20997q;
            canvas.drawCircle(f22, f23, f24 + f25, this.f20990A);
            this.f20990A.setColor(this.f21003w);
            PointF pointF5 = this.f21004x[i11];
            canvas.drawCircle(pointF5.x, pointF5.y, f25, this.f20990A);
        }
    }

    public void setFrequencyNum(int i10) {
        this.f21004x = new PointF[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.f21004x[i11] = new PointF();
        }
        this.f21005y = new int[i10];
        this.f21006z = new float[i10];
    }
}
