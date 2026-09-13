package com.oplus.melody.ui.widget;

import A9.d;
import D.h;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;

/* JADX INFO: loaded from: classes3.dex */
public class MelodyCropImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final /* synthetic */ int f21793J = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f21794A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f21795B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f21796C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public float f21797D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public float f21798E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public boolean f21799F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public Matrix f21800G;
    public PointF H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public View f21801I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f21803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21804c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f21805p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Paint f21806q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Path f21807r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Matrix f21808s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RectF f21809t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final PointF f21810u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final PointF f21811v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final PointF f21812w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f21813x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f21814y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f21815z;

    public MelodyCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f21802a = -1358954496;
        this.f21803b = 1.0f;
        this.f21806q = new Paint();
        this.f21807r = new Path();
        this.f21808s = new Matrix();
        this.f21809t = new RectF();
        this.f21810u = new PointF();
        this.f21811v = new PointF();
        this.f21812w = new PointF();
        this.f21795B = 0;
        this.f21796C = 0;
        this.f21797D = 1.0f;
        this.f21798E = 4.0f;
        this.f21799F = false;
        this.f21800G = new Matrix();
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private RectF getImageMatrixRect() {
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        this.f21800G.mapRect(rectF);
        return rectF;
    }

    public final void a() {
        float[] fArr = new float[9];
        this.f21800G.getValues(fArr);
        float fAbs = Math.abs(fArr[1]) + Math.abs(fArr[0]);
        float fMax = Math.max(this.f21804c / this.f21815z, this.f21805p / this.f21794A);
        float f9 = 4.0f * fMax;
        this.f21798E = f9;
        if (fAbs < fMax) {
            float f10 = fMax / fAbs;
            this.f21800G.postScale(f10, f10);
        } else if (fAbs > f9) {
            float f11 = f9 / fAbs;
            this.f21800G.postScale(f11, f11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x001b A[PHI: r1 r4
      0x001b: PHI (r1v7 float) = (r1v3 float), (r1v4 float) binds: [B:3:0x0019, B:6:0x0024] A[DONT_GENERATE, DONT_INLINE]
      0x001b: PHI (r4v4 float) = (r4v0 float), (r4v1 float) binds: [B:3:0x0019, B:6:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b() {
        /*
            r7 = this;
            android.graphics.RectF r0 = new android.graphics.RectF
            int r1 = r7.f21813x
            float r1 = (float) r1
            int r2 = r7.f21814y
            float r2 = (float) r2
            r3 = 0
            r0.<init>(r3, r3, r1, r2)
            android.graphics.Matrix r1 = r7.f21800G
            r1.mapRect(r0)
            float r1 = r0.left
            android.graphics.RectF r2 = r7.f21809t
            float r4 = r2.left
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 <= 0) goto L1e
        L1b:
            float r1 = -r1
            float r1 = r1 + r4
            goto L28
        L1e:
            float r1 = r0.right
            float r4 = r2.right
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 >= 0) goto L27
            goto L1b
        L27:
            r1 = r3
        L28:
            float r4 = r0.top
            float r5 = r2.top
            int r6 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r6 <= 0) goto L34
            float r0 = -r4
            float r3 = r0 + r5
            goto L3f
        L34:
            float r0 = r0.bottom
            float r2 = r2.bottom
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L3f
            float r0 = -r0
            float r3 = r0 + r2
        L3f:
            android.graphics.Matrix r0 = r7.f21800G
            r0.postTranslate(r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.widget.MelodyCropImageView.b():void");
    }

    public final Bitmap c(int i10, int i11) {
        Bitmap bitmapCreateBitmap;
        if (i10 <= 0 || i11 < 0) {
            return null;
        }
        Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
        int i12 = this.f21795B * 90;
        if (i12 != 0 && bitmap != null) {
            Matrix matrix = new Matrix();
            matrix.setRotate(i12, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
            try {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (bitmap != bitmapCreateBitmap2) {
                    bitmap = bitmapCreateBitmap2;
                }
            } catch (OutOfMemoryError e10) {
                A.i("MelodyCropImageView", "rotate", e10);
            }
        }
        RectF rectF = this.f21809t;
        RectF imageMatrixRect = getImageMatrixRect();
        if (imageMatrixRect == null || bitmap == null) {
            return null;
        }
        float fWidth = imageMatrixRect.width() / bitmap.getWidth();
        int i13 = (int) ((rectF.left - imageMatrixRect.left) / fWidth);
        int i14 = (int) ((rectF.top - imageMatrixRect.top) / fWidth);
        int iWidth = (int) (rectF.width() / fWidth);
        int iHeight = (int) (rectF.height() / fWidth);
        if (i13 < 0) {
            i13 = 0;
        }
        if (i14 < 0) {
            i14 = 0;
        }
        if (i13 + iWidth > bitmap.getWidth()) {
            iWidth = bitmap.getWidth() - i13;
        }
        if (i14 + iHeight > bitmap.getHeight()) {
            iHeight = bitmap.getHeight() - i14;
        }
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i13, i14, iWidth, iHeight);
            if (i10 == iWidth && i11 == iHeight) {
                return bitmapCreateBitmap;
            }
            try {
                return Bitmap.createScaledBitmap(bitmapCreateBitmap, i10, i11, true);
            } catch (OutOfMemoryError e11) {
                e = e11;
                A.i("MelodyCropImageView", "makeCropBitmap", e);
                return bitmapCreateBitmap;
            }
        } catch (OutOfMemoryError e12) {
            e = e12;
            bitmapCreateBitmap = bitmap;
        }
    }

    public final void d() {
        Drawable drawable = getDrawable();
        if (!this.f21799F || drawable == null) {
            return;
        }
        this.f21796C = 0;
        this.f21800G = getImageMatrix();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        this.f21815z = intrinsicWidth;
        this.f21813x = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f21794A = intrinsicHeight;
        this.f21814y = intrinsicHeight;
        PointF pointF = new PointF(getWidth() / 2.0f, getHeight() / 2.0f);
        RectF rectF = this.f21809t;
        float f9 = pointF.x;
        float f10 = this.f21804c;
        float f11 = f10 / 2.0f;
        rectF.left = f9 - f11;
        rectF.right = f11 + f9;
        float f12 = pointF.y;
        float f13 = this.f21805p;
        float f14 = f13 / 2.0f;
        rectF.top = f12 - f14;
        rectF.bottom = f14 + f12;
        float fMax = Math.max(f10 / this.f21813x, f13 / this.f21814y);
        this.f21798E = 4.0f * fMax;
        this.f21800G.setScale(fMax, fMax, this.f21813x / 2.0f, this.f21814y / 2.0f);
        float[] fArr = new float[9];
        this.f21800G.getValues(fArr);
        this.f21800G.postTranslate(pointF.x - (((this.f21813x * fArr[0]) / 2.0f) + fArr[2]), pointF.y - (((this.f21814y * fArr[4]) / 2.0f) + fArr[5]));
        setImageMatrix(this.f21800G);
        this.f21808s.set(this.f21800G);
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.f21807r;
        path.addRect(this.f21809t, Path.Direction.CCW);
        canvas.save();
        canvas.clipRect(0, 0, getWidth(), getHeight());
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        canvas.drawColor(this.f21802a);
        canvas.restore();
        Paint paint = this.f21806q;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(0.0f);
        paint.setAntiAlias(true);
        canvas.drawPath(path, paint);
        path.reset();
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        int iMin = Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.melody_ui_crop_image_focus_width), i10);
        this.f21804c = iMin;
        this.f21805p = (int) (iMin / this.f21803b);
        View view = this.f21801I;
        if (view != null) {
            view.post(new h(this, i11, 1));
            return;
        }
        A.c("MelodyCropImageView", new d(this, 8));
        this.f21799F = true;
        d();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (getDrawable() == null) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        Matrix matrix = this.f21808s;
        PointF pointF = this.f21811v;
        PointF pointF2 = this.f21810u;
        if (actionMasked == 0) {
            matrix.set(this.f21800G);
            pointF2.set(motionEvent.getX(), motionEvent.getY());
            pointF.set(motionEvent.getX(), motionEvent.getY());
            this.H = pointF2;
            this.f21796C = 1;
            return true;
        }
        if (actionMasked == 1) {
            this.f21796C = 0;
            return true;
        }
        PointF pointF3 = this.f21812w;
        if (actionMasked == 2) {
            int i10 = this.f21796C;
            if (i10 == 1) {
                this.f21800G.set(matrix);
                this.f21800G.postTranslate(motionEvent.getX() - this.H.x, motionEvent.getY() - this.H.y);
                b();
                setImageMatrix(this.f21800G);
                return true;
            }
            if (i10 == 2) {
                float x10 = motionEvent.getX(0);
                float y5 = motionEvent.getY(0);
                float x11 = x10 - motionEvent.getX(1);
                float y8 = y5 - motionEvent.getY(1);
                float fSqrt = (float) Math.sqrt((y8 * y8) + (x11 * x11));
                this.f21800G.set(matrix);
                float f9 = fSqrt / this.f21797D;
                float[] fArr = new float[9];
                this.f21800G.getValues(fArr);
                float fMin = Math.min(f9, this.f21798E / (Math.abs(fArr[1]) + Math.abs(fArr[0])));
                if (fMin != 0.0f) {
                    this.f21800G.postScale(fMin, fMin, pointF3.x, pointF3.y);
                    a();
                    b();
                    setImageMatrix(this.f21800G);
                }
            }
        } else if (actionMasked != 5) {
            if (actionMasked == 6) {
                pointF2.set(motionEvent.getX(0), motionEvent.getY(0));
                pointF.set(motionEvent.getX(1), motionEvent.getY(1));
                if (motionEvent.getActionIndex() != 0) {
                    pointF = pointF2;
                }
                this.H = pointF;
                matrix.set(this.f21800G);
                this.f21796C = 1;
                return true;
            }
        } else if (motionEvent.getActionIndex() <= 1) {
            pointF2.set(motionEvent.getX(0), motionEvent.getY(0));
            pointF.set(motionEvent.getX(1), motionEvent.getY(1));
            pointF3.set((pointF2.x + pointF.x) / 2.0f, (pointF2.y + pointF.y) / 2.0f);
            float f10 = pointF2.x;
            float f11 = pointF2.y;
            float f12 = f10 - pointF.x;
            float f13 = f11 - pointF.y;
            this.f21797D = (float) Math.sqrt((f13 * f13) + (f12 * f12));
            matrix.set(this.f21800G);
            this.f21796C = 2;
            return true;
        }
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        d();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        d();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) {
        super.setImageResource(i10);
        d();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        d();
    }

    public void setRotateBtn(View view) {
        this.f21801I = view;
    }

    public void setWhRatio(float f9) {
        this.f21803b = f9;
    }
}
