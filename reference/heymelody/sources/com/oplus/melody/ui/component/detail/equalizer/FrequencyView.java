package com.oplus.melody.ui.component.detail.equalizer;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.headset.R;
import g9.o;

/* JADX INFO: loaded from: classes3.dex */
public class FrequencyView extends View {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int[] f20967A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public PointF[] f20968B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public float[] f20969C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final Paint f20970D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final Path f20971E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public LinearGradient f20972F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public RectF[] f20973G;
    public float H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public float f20974I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Rect f20975J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f20976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f20977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f20978c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f20979p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f20980q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f20981r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f20982s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f20983t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float f20984u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f20985v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f20986w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f20987x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f20988y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PointF[] f20989z;

    public FrequencyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        this.f20972F = null;
        this.f20976a = getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_thumb_in_radius);
        this.f20977b = getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_thumb_out_radius);
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_stroke_width);
        this.f20978c = dimensionPixelOffset;
        this.f20979p = getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_stroke_width_bold);
        this.f20980q = getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_label_diff_y);
        this.f20981r = getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_label_width);
        this.f20982s = getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_label_height);
        this.f20983t = getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_label_corner_radius);
        this.f20984u = getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_label_arrow_width);
        this.f20985v = getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_label_arrow_height);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_label_text_size);
        this.f20986w = context.getColor(R.color.melody_ui_custom_eq_seek_bar_bg);
        int iG = o.g(context, R.attr.couiColorPrimary);
        this.f20987x = iG;
        this.f20988y = context.getColor(R.color.melody_ui_custom_eq_label_bg);
        this.f20971E = new Path();
        Paint paint = new Paint();
        this.f20970D = paint;
        paint.setAntiAlias(true);
        this.f20970D.setStyle(Paint.Style.STROKE);
        this.f20970D.setStrokeWidth(dimensionPixelOffset);
        this.f20970D.setColor(iG);
        this.f20970D.setTextSize(dimensionPixelOffset2);
        this.f20975J = new Rect();
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00eb A[SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDraw(android.graphics.Canvas r26) {
        /*
            Method dump skipped, instruction units count: 1252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.equalizer.FrequencyView.onDraw(android.graphics.Canvas):void");
    }

    public void setFrequencyNum(int i10) {
        this.f20989z = new PointF[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            this.f20989z[i12] = new PointF();
        }
        this.f20967A = new int[i10];
        this.f20969C = new float[i10];
        this.f20968B = new PointF[(i10 - 1) * 2];
        int i13 = 0;
        while (true) {
            PointF[] pointFArr = this.f20968B;
            if (i13 >= pointFArr.length) {
                break;
            }
            pointFArr[i13] = new PointF();
            i13++;
        }
        this.f20973G = new RectF[i10];
        while (true) {
            RectF[] rectFArr = this.f20973G;
            if (i11 >= rectFArr.length) {
                return;
            }
            rectFArr[i11] = new RectF();
            i11++;
        }
    }
}
