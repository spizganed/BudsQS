package com.oplus.melody.ui.component.hearingenhance.widget;

import F9.n;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.media3.session.q1;
import com.heytap.headset.R;
import p2.C1395b;

/* JADX INFO: loaded from: classes3.dex */
public class VoiceWaveView extends View {

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final /* synthetic */ int f21608E = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final float f21609A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f21610B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public float f21611C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final a f21612D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<b> f21613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<Integer> f21614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray<Animator> f21615c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ValueAnimator f21616p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ValueAnimator f21617q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final PathInterpolator f21618r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f21619s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Paint f21620t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Paint f21621u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f21622v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f21623w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f21624x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f21625y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f21626z;

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SparseArray<c> f21630c = new SparseArray<>();

        public b(int i10, c... cVarArr) {
            this.f21628a = i10;
            if (cVarArr.length == 0) {
                return;
            }
            for (c cVar : cVarArr) {
                this.f21630c.put(this.f21629b, cVar);
                this.f21629b++;
            }
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f21633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f21634d;
    }

    public VoiceWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21619s = null;
        this.f21620t = null;
        this.f21621u = null;
        this.f21622v = false;
        this.f21611C = 0.9f;
        this.f21612D = new a();
        this.f21626z = getContext().getResources().getDimension(R.dimen.melody_ui_hearing_enhancement_voice_wave_single_line_width);
        this.f21609A = getContext().getResources().getDimension(R.dimen.melody_ui_hearing_enhancement_wave_view_base_height);
        this.f21618r = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f21613a = new SparseArray<>();
        this.f21614b = new SparseArray<>();
        this.f21615c = new SparseArray<>();
        Paint paint = new Paint();
        this.f21619s = paint;
        paint.setAntiAlias(true);
        Paint paint2 = this.f21619s;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        this.f21619s.setStrokeWidth(this.f21626z);
        this.f21619s.setColor(getContext().getColor(R.color.melody_ui_normal_grey));
        Paint paint3 = new Paint();
        this.f21620t = paint3;
        paint3.setAntiAlias(true);
        this.f21620t.setStyle(style);
        this.f21620t.setStrokeWidth(this.f21626z);
        this.f21620t.setColor(C1395b.a(getContext(), R.attr.couiColorPrimary));
        Paint paint4 = new Paint();
        this.f21621u = paint4;
        paint4.setAntiAlias(true);
        this.f21621u.setStyle(style);
        this.f21621u.setStrokeWidth(this.f21626z);
        this.f21621u.setColor(getContext().getColor(R.color.melody_ui_normal_grey));
        for (int i10 = 0; i10 < 8; i10++) {
            this.f21613a.put(this.f21610B, null);
            this.f21610B++;
        }
        int i11 = this.f21610B;
        Float fValueOf = Float.valueOf(1.81f);
        Float fValueOf2 = Float.valueOf(1.02f);
        Float fValueOf3 = Float.valueOf(3.27f);
        a(new b(i11, b(0, 233, fValueOf, fValueOf2, 0, 411, fValueOf2, fValueOf3, 0, 356, fValueOf3, fValueOf)));
        int i12 = this.f21610B;
        Float fValueOf4 = Float.valueOf(1.17f);
        Float fValueOf5 = Float.valueOf(2.86f);
        Float fValueOf6 = Float.valueOf(0.611f);
        a(new b(i12, b(0, 500, fValueOf4, fValueOf5, 0, 256, fValueOf5, fValueOf6, 0, 244, fValueOf6, fValueOf4)));
        int i13 = this.f21610B;
        Float fValueOf7 = Float.valueOf(1.71f);
        a(new b(i13, b(0, 467, fValueOf7, Float.valueOf(3.42f), 0, 533, Float.valueOf(3.42f), fValueOf7)));
        a(new b(this.f21610B, b(0, 467, Float.valueOf(2.25f), Float.valueOf(4.44f), 0, 533, Float.valueOf(4.44f), Float.valueOf(2.25f))));
        a(new b(this.f21610B, b(0, 322, Float.valueOf(4.01f), Float.valueOf(7.74f), 0, 450, Float.valueOf(7.74f), Float.valueOf(2.14f), 0, 228, Float.valueOf(2.14f), Float.valueOf(4.01f))));
        a(new b(this.f21610B, b(0, 300, Float.valueOf(4.08f), Float.valueOf(8.84f), 0, 700, Float.valueOf(8.84f), Float.valueOf(4.08f))));
        a(new b(this.f21610B, b(0, 300, Float.valueOf(6.35f), Float.valueOf(11.22f), 0, 550, Float.valueOf(11.22f), Float.valueOf(4.79f), 0, 150, Float.valueOf(4.79f), Float.valueOf(6.35f))));
        a(new b(this.f21610B, b(0, 467, Float.valueOf(9.18f), Float.valueOf(12.29f), 0, 553, Float.valueOf(12.29f), Float.valueOf(9.18f))));
        a(new b(this.f21610B, b(0, 200, Float.valueOf(7.81f), Float.valueOf(9.82f), 0, 444, Float.valueOf(9.82f), Float.valueOf(5.68f), 0, 356, Float.valueOf(5.68f), Float.valueOf(7.81f))));
        a(new b(this.f21610B, b(0, 678, Float.valueOf(6.67f), Float.valueOf(4.71f), 0, 322, Float.valueOf(4.71f), Float.valueOf(6.67f))));
        a(new b(this.f21610B, b(0, 340, Float.valueOf(4.55f), Float.valueOf(2.69f), 0, 660, Float.valueOf(2.69f), Float.valueOf(4.55f))));
        int i14 = this.f21610B;
        Float fValueOf8 = Float.valueOf(3.15f);
        a(new b(i14, b(0, 678, fValueOf8, Float.valueOf(1.73f), 0, 322, Float.valueOf(1.73f), fValueOf8)));
        int i15 = this.f21610B;
        Float fValueOf9 = Float.valueOf(1.41f);
        a(new b(i15, b(0, 433, fValueOf9, fValueOf8, 0, 567, fValueOf8, fValueOf9)));
        int i16 = this.f21610B;
        Float fValueOf10 = Float.valueOf(2.58f);
        a(new b(i16, b(0, 356, fValueOf10, Float.valueOf(4.73f), 0, 644, Float.valueOf(4.73f), fValueOf10)));
        a(new b(this.f21610B, b(0, 400, Float.valueOf(5.61f), Float.valueOf(4.95f), 0, 600, Float.valueOf(4.95f), Float.valueOf(5.61f))));
        a(new b(this.f21610B, b(0, 500, fValueOf10, Float.valueOf(3.95f), 0, 500, Float.valueOf(3.95f), fValueOf10)));
        a(new b(this.f21610B, b(0, 667, fValueOf9, fValueOf8, 0, 333, fValueOf8, fValueOf9)));
        a(new b(this.f21610B, b(0, 233, fValueOf, fValueOf2, 0, 411, fValueOf2, fValueOf3, 0, 356, fValueOf3, fValueOf)));
        a(new b(this.f21610B, b(0, 500, fValueOf4, fValueOf5, 0, 256, fValueOf5, fValueOf6, 0, 244, fValueOf6, fValueOf4)));
        a(new b(this.f21610B, b(0, 467, fValueOf7, Float.valueOf(3.42f), 0, 533, Float.valueOf(3.42f), fValueOf7)));
        a(new b(this.f21610B, b(0, 467, Float.valueOf(2.25f), Float.valueOf(4.44f), 0, 533, Float.valueOf(4.44f), Float.valueOf(2.25f))));
        a(new b(this.f21610B, b(0, 322, Float.valueOf(4.01f), Float.valueOf(7.74f), 0, 450, Float.valueOf(7.74f), Float.valueOf(2.14f), 0, 228, Float.valueOf(2.14f), Float.valueOf(4.01f))));
        a(new b(this.f21610B, b(0, 300, Float.valueOf(4.08f), Float.valueOf(8.84f), 0, 700, Float.valueOf(8.84f), Float.valueOf(4.08f))));
        a(new b(this.f21610B, b(0, 300, Float.valueOf(6.35f), Float.valueOf(11.22f), 0, 550, Float.valueOf(11.22f), Float.valueOf(4.79f), 0, 150, Float.valueOf(4.79f), Float.valueOf(6.35f))));
        a(new b(this.f21610B, b(0, 467, Float.valueOf(9.18f), Float.valueOf(12.29f), 0, 553, Float.valueOf(12.29f), Float.valueOf(9.18f))));
        a(new b(this.f21610B, b(0, 200, Float.valueOf(7.81f), Float.valueOf(9.82f), 0, 444, Float.valueOf(9.82f), Float.valueOf(5.68f), 0, 356, Float.valueOf(5.68f), Float.valueOf(7.81f))));
        a(new b(this.f21610B, b(0, 678, Float.valueOf(6.67f), Float.valueOf(4.71f), 0, 322, Float.valueOf(4.71f), Float.valueOf(6.67f))));
        a(new b(this.f21610B, b(0, 340, Float.valueOf(4.55f), Float.valueOf(2.69f), 0, 660, Float.valueOf(2.69f), Float.valueOf(4.55f))));
        a(new b(this.f21610B, b(0, 678, fValueOf8, Float.valueOf(1.73f), 0, 322, Float.valueOf(1.73f), fValueOf8)));
        a(new b(this.f21610B, b(0, 433, fValueOf9, fValueOf8, 0, 567, fValueOf8, fValueOf9)));
        a(new b(this.f21610B, b(0, 356, fValueOf10, Float.valueOf(4.73f), 0, 644, Float.valueOf(4.73f), fValueOf10)));
        a(new b(this.f21610B, b(0, 400, Float.valueOf(5.61f), Float.valueOf(4.95f), 0, 600, Float.valueOf(4.95f), Float.valueOf(5.61f))));
        a(new b(this.f21610B, b(0, 500, fValueOf10, Float.valueOf(3.95f), 0, 500, Float.valueOf(3.95f), fValueOf10)));
        a(new b(this.f21610B, b(0, 667, fValueOf9, fValueOf8, 0, 333, fValueOf8, fValueOf9)));
        a(new b(this.f21610B, b(0, 200, Float.valueOf(7.81f), Float.valueOf(9.82f), 0, 444, Float.valueOf(9.82f), Float.valueOf(5.68f), 0, 356, Float.valueOf(5.68f), Float.valueOf(7.81f))));
        a(new b(this.f21610B, b(0, 467, Float.valueOf(9.18f), Float.valueOf(12.29f), 0, 553, Float.valueOf(12.29f), Float.valueOf(9.18f))));
        a(new b(this.f21610B, b(0, 300, Float.valueOf(6.35f), Float.valueOf(11.22f), 0, 550, Float.valueOf(11.22f), Float.valueOf(4.79f), 0, 150, Float.valueOf(4.79f), Float.valueOf(6.35f))));
        a(new b(this.f21610B, b(0, 300, Float.valueOf(4.08f), Float.valueOf(8.84f), 0, 700, Float.valueOf(8.84f), Float.valueOf(4.08f))));
        a(new b(this.f21610B, b(0, 322, Float.valueOf(4.01f), Float.valueOf(7.74f), 0, 450, Float.valueOf(7.74f), Float.valueOf(2.14f), 0, 228, Float.valueOf(2.14f), Float.valueOf(4.01f))));
        a(new b(this.f21610B, b(0, 467, Float.valueOf(2.25f), Float.valueOf(4.44f), 0, 533, Float.valueOf(4.44f), Float.valueOf(2.25f))));
        a(new b(this.f21610B, b(0, 467, fValueOf7, Float.valueOf(3.42f), 0, 533, Float.valueOf(3.42f), fValueOf7)));
        a(new b(this.f21610B, b(0, 500, fValueOf4, fValueOf5, 0, 256, fValueOf5, fValueOf6, 0, 244, fValueOf6, fValueOf4)));
        a(new b(this.f21610B, b(0, 233, fValueOf, fValueOf2, 0, 411, fValueOf2, fValueOf3, 0, 356, fValueOf3, fValueOf)));
        a(new b(this.f21610B, b(0, 667, fValueOf9, fValueOf8, 0, 333, fValueOf8, fValueOf9)));
        a(new b(this.f21610B, b(0, 500, fValueOf10, Float.valueOf(3.95f), 0, 500, Float.valueOf(3.95f), fValueOf10)));
        a(new b(this.f21610B, b(0, 400, Float.valueOf(5.61f), Float.valueOf(4.95f), 0, 600, Float.valueOf(4.95f), Float.valueOf(5.61f))));
        a(new b(this.f21610B, b(0, 356, fValueOf10, Float.valueOf(4.73f), 0, 644, Float.valueOf(4.73f), fValueOf10)));
        a(new b(this.f21610B, b(0, 433, fValueOf9, fValueOf8, 0, 567, fValueOf8, fValueOf9)));
        a(new b(this.f21610B, b(0, 678, fValueOf8, Float.valueOf(1.73f), 0, 322, Float.valueOf(1.73f), fValueOf8)));
        a(new b(this.f21610B, b(0, 340, Float.valueOf(4.55f), Float.valueOf(2.69f), 0, 660, Float.valueOf(2.69f), Float.valueOf(4.55f))));
        a(new b(this.f21610B, b(0, 678, Float.valueOf(6.67f), Float.valueOf(4.71f), 0, 322, Float.valueOf(4.71f), Float.valueOf(6.67f))));
        a(new b(this.f21610B, b(0, 200, Float.valueOf(7.81f), Float.valueOf(9.82f), 0, 444, Float.valueOf(9.82f), Float.valueOf(5.68f), 0, 356, Float.valueOf(5.68f), Float.valueOf(7.81f))));
        a(new b(this.f21610B, b(0, 467, Float.valueOf(9.18f), Float.valueOf(12.29f), 0, 553, Float.valueOf(12.29f), Float.valueOf(9.18f))));
        a(new b(this.f21610B, b(0, 300, Float.valueOf(6.35f), Float.valueOf(11.22f), 0, 550, Float.valueOf(11.22f), Float.valueOf(4.79f), 0, 150, Float.valueOf(4.79f), Float.valueOf(6.35f))));
        a(new b(this.f21610B, b(0, 300, Float.valueOf(4.08f), Float.valueOf(8.84f), 0, 700, Float.valueOf(8.84f), Float.valueOf(4.08f))));
        a(new b(this.f21610B, b(0, 322, Float.valueOf(4.01f), Float.valueOf(7.74f), 0, 450, Float.valueOf(7.74f), Float.valueOf(2.14f), 0, 228, Float.valueOf(2.14f), Float.valueOf(4.01f))));
        a(new b(this.f21610B, b(0, 467, Float.valueOf(2.25f), Float.valueOf(4.44f), 0, 533, Float.valueOf(4.44f), Float.valueOf(2.25f))));
        a(new b(this.f21610B, b(0, 467, fValueOf7, Float.valueOf(3.42f), 0, 533, Float.valueOf(3.42f), fValueOf7)));
        a(new b(this.f21610B, b(0, 500, fValueOf4, fValueOf5, 0, 256, fValueOf5, fValueOf6, 0, 244, fValueOf6, fValueOf4)));
        a(new b(this.f21610B, b(0, 233, fValueOf, fValueOf2, 0, 411, fValueOf2, fValueOf3, 0, 356, fValueOf3, fValueOf)));
        for (int i17 = 0; i17 < 8; i17++) {
            this.f21613a.put(this.f21610B, null);
            this.f21610B++;
        }
    }

    public static c[] b(Object... objArr) {
        if (objArr.length == 0) {
            return new c[0];
        }
        int length = objArr.length / 4;
        c[] cVarArr = new c[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 4;
            int iIntValue = ((Integer) objArr[i11]).intValue();
            int iIntValue2 = ((Integer) objArr[i11 + 1]).intValue();
            float fFloatValue = ((Float) objArr[i11 + 2]).floatValue();
            float fFloatValue2 = ((Float) objArr[i11 + 3]).floatValue();
            c cVar = new c();
            cVar.f21631a = iIntValue;
            cVar.f21632b = iIntValue2;
            cVar.f21633c = fFloatValue;
            cVar.f21634d = fFloatValue2;
            cVarArr[i10] = cVar;
        }
        return cVarArr;
    }

    public final void a(b bVar) {
        this.f21613a.put(this.f21610B, bVar);
        this.f21610B++;
    }

    public final void c() {
        SparseArray<Integer> sparseArray = this.f21614b;
        if (this.f21622v) {
            return;
        }
        int size = this.f21613a.size();
        sparseArray.clear();
        for (int i10 = 0; i10 < size; i10++) {
            sparseArray.put(i10, Integer.valueOf(this.f21623w));
        }
        this.f21622v = true;
        q1 q1Var = new q1(this, 19);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f21617q = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(250L);
        this.f21617q.setInterpolator(this.f21618r);
        this.f21617q.setRepeatCount(0);
        this.f21617q.addUpdateListener(new n(this, 8));
        this.f21617q.addListener(new na.c(this, q1Var));
        this.f21617q.start();
    }

    public final void d() {
        this.f21622v = false;
        if (this.f21615c != null) {
            for (int i10 = 0; i10 < this.f21615c.size(); i10++) {
                Animator animator = this.f21615c.get(this.f21615c.keyAt(i10));
                if (animator != null) {
                    animator.cancel();
                    animator.removeAllListeners();
                }
            }
            this.f21615c.clear();
        }
        ValueAnimator valueAnimator = this.f21616p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f21616p.removeAllListeners();
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i10 = 0;
        for (int i11 = 0; i11 < this.f21614b.size(); i11++) {
            int iIntValue = (int) ((this.f21624x - this.f21614b.get(this.f21614b.keyAt(i11)).intValue()) / 2.0f);
            if (i11 < 8) {
                float f9 = i10;
                canvas.drawLine(f9, iIntValue, f9, iIntValue + r3, this.f21619s);
            } else if (i11 >= this.f21613a.size() - 8) {
                float f10 = i10;
                canvas.drawLine(f10, iIntValue, f10, iIntValue + r3, this.f21621u);
            } else {
                float f11 = i10;
                canvas.drawLine(f11, iIntValue, f11, iIntValue + r3, this.f21620t);
            }
            i10 = (int) (this.f21626z + this.f21625y + i10);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        this.f21625y = (View.MeasureSpec.getSize(i10) - (this.f21613a.size() * this.f21626z)) / (r0 - 1);
        super.onMeasure(i10, i11);
    }

    public void setAmplitude(float f9) {
        this.f21611C = f9;
    }

    public void setMaxHeight(int i10) {
        this.f21624x = i10;
    }

    public void setMinHeight(int i10) {
        this.f21623w = i10;
    }

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (VoiceWaveView.this.f21622v) {
                animator.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
        }
    }
}
