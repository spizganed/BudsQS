package com.oplus.melody.app.discovery;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import ec.C1030a;
import java.security.MessageDigest;

/* JADX INFO: compiled from: HalfBitmapTransformation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class D1 extends BitmapTransformation {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Paint f18834b = new Paint(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18835a;

    public D1(boolean z2) {
        this.f18835a = z2;
    }

    public final String toString() {
        return this.f18835a ? "HalfBitmapTransformation.left" : "HalfBitmapTransformation.right";
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public final Bitmap transform(BitmapPool pool, Bitmap inBitmap, int i10, int i11) {
        kotlin.jvm.internal.h.e(pool, "pool");
        kotlin.jvm.internal.h.e(inBitmap, "inBitmap");
        float f9 = i10;
        float f10 = 0.63076925f * f9;
        float f11 = i11;
        Bitmap.Config config = inBitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmap = pool.get((int) f10, (int) f11, config);
        kotlin.jvm.internal.h.d(bitmap, "get(...)");
        TransformationUtils.setAlpha(inBitmap, bitmap);
        Canvas canvas = new Canvas(bitmap);
        float f12 = f9 / 2.0f;
        boolean z2 = this.f18835a;
        Paint paint = f18834b;
        if (z2) {
            canvas.clipRect(0.0f, 0.0f, f12, f11);
            canvas.drawBitmap(inBitmap, 0.0f, 0.0f, paint);
        } else {
            canvas.clipRect(f10 - f12, 0.0f, f10, f11);
            canvas.drawBitmap(inBitmap, f10 - f9, 0.0f, paint);
        }
        canvas.setBitmap(null);
        return bitmap;
    }

    @Override // com.bumptech.glide.load.Key
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        kotlin.jvm.internal.h.e(messageDigest, "messageDigest");
        byte[] bytes = (this.f18835a ? "HalfBitmapTransformation.left" : "HalfBitmapTransformation.right").getBytes(C1030a.f22972b);
        kotlin.jvm.internal.h.d(bytes, "getBytes(...)");
        messageDigest.update(bytes);
    }
}
