package com.oplus.melody.ui.widget.sound;

import D1.f;
import E8.b;
import F9.n;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.PathInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyOverlayImageView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000  2\u00020\u0001:\u0002\u001f B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/oplus/melody/ui/widget/sound/MelodyOverlayImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIsInit", "", "mRealAlpha", "", "mBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "mCurrentScale", "mPressAnimator", "Landroid/animation/ValueAnimator;", "mNormalAnimator", "setAlpha", "", "alpha", "updateDrawableAlpha", "getAlpha", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "getAnimator", "end", "cancelAnimator", "OverlayBlendDrawable", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SuppressLint({"CustomViewStyleable"})
public final class MelodyOverlayImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f22103s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f22105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f22106c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f22107p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ValueAnimator f22108q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ValueAnimator f22109r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyOverlayImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        h.e(context, "context");
        this.f22107p = 1.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f1371j, 0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            this.f22106c = new a(drawable);
        }
        typedArrayObtainStyledAttributes.recycle();
        setBackground(this.f22106c);
        this.f22105b = super.getAlpha();
        super.setAlpha(1.0f);
        int i10 = (int) (this.f22105b * 255);
        a aVar = this.f22106c;
        if (aVar != null) {
            aVar.setAlpha(i10);
        }
        Drawable drawable2 = getDrawable();
        if (drawable2 != null) {
            drawable2.setAlpha(i10);
        }
        this.f22104a = true;
    }

    public final ValueAnimator a(float f9) {
        int i10 = 2;
        ValueAnimator valueAnimator = this.f22108q;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f22109r;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            valueAnimator2.cancel();
        }
        float fJ = f.j(this.f22107p, 0.95f, 1.0f);
        this.f22107p = fJ;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fJ, f9);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f));
        valueAnimatorOfFloat.addUpdateListener(new n(this, i10));
        return valueAnimatorOfFloat;
    }

    @Override // android.view.View
    public float getAlpha() {
        return this.f22104a ? this.f22105b : super.getAlpha();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent event) {
        if (event == null) {
            return false;
        }
        int action = event.getAction() & 255;
        if (action == 0) {
            ValueAnimator valueAnimatorA = a(0.95f);
            this.f22108q = valueAnimatorA;
            valueAnimatorA.start();
        } else if (action == 1) {
            ValueAnimator valueAnimatorA2 = a(1.0f);
            this.f22109r = valueAnimatorA2;
            valueAnimatorA2.start();
        }
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    public void setAlpha(float alpha) {
        if (!this.f22104a) {
            super.setAlpha(alpha);
            return;
        }
        if (this.f22105b == alpha) {
            return;
        }
        this.f22105b = alpha;
        int i10 = (int) (alpha * 255);
        a aVar = this.f22106c;
        if (aVar != null) {
            aVar.setAlpha(i10);
        }
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setAlpha(i10);
        }
        invalidate();
    }

    /* JADX INFO: compiled from: MelodyOverlayImageView.kt */
    public static final class a extends Drawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f22110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f22111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bitmap f22112c;

        public a(Drawable drawable) {
            this.f22110a = drawable;
            Paint paint = new Paint(1);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.OVERLAY));
            this.f22111b = paint;
        }

        public final void a(Rect rect) {
            Bitmap bitmap;
            if (rect.width() <= 0 || rect.height() <= 0) {
                return;
            }
            int iWidth = rect.width();
            int iHeight = rect.height();
            Drawable drawable = this.f22110a;
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                if (bitmapDrawable.getBitmap() == null) {
                    throw new IllegalArgumentException("bitmap is null");
                }
                bitmap = (iWidth == bitmapDrawable.getBitmap().getWidth() && iHeight == bitmapDrawable.getBitmap().getHeight()) ? bitmapDrawable.getBitmap() : Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), iWidth, iHeight, true);
            } else {
                Rect bounds = drawable.getBounds();
                int i10 = bounds.left;
                int i11 = bounds.top;
                int i12 = bounds.right;
                int i13 = bounds.bottom;
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iWidth, iHeight, Bitmap.Config.ARGB_8888);
                drawable.setBounds(0, 0, iWidth, iHeight);
                drawable.draw(new Canvas(bitmapCreateBitmap));
                drawable.setBounds(i10, i11, i12, i13);
                bitmap = bitmapCreateBitmap;
            }
            this.f22112c = bitmap;
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            h.e(canvas, "canvas");
            Bitmap bitmap = this.f22112c;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f22111b);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public final void onBoundsChange(Rect bounds) {
            h.e(bounds, "bounds");
            a(bounds);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i10) {
            Drawable drawable = this.f22110a;
            if (i10 != drawable.getAlpha()) {
                drawable.setAlpha(i10);
                Rect bounds = getBounds();
                h.d(bounds, "getBounds(...)");
                a(bounds);
                invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
        }
    }
}
