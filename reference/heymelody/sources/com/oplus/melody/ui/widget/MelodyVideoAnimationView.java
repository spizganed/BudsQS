package com.oplus.melody.ui.widget;

import A9.d;
import Ca.s;
import D7.f0;
import D7.o0;
import D7.q0;
import Ea.C0402k;
import Ea.G;
import Ea.H;
import Ea.K;
import Ea.L;
import Ea.M;
import Ea.N;
import Ea.O;
import Ea.Q;
import Y.r;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.B;
import com.oplus.melody.ui.widget.MelodyVideoAnimationView;
import h0.l;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public final class MelodyVideoAnimationView extends TextureView {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f21948y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L f21949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Uri f21950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Surface f21951c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.oplus.melody.common.util.L f21952p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CompletableFuture<Uri> f21953q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CompletableFuture<SurfaceTexture> f21954r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f21955s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f21956t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f21957u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f21958v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AudioAttributes f21959w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final a f21960x;

    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, final int i10, final int i11, final int i12, final int i13, int i14, int i15, int i16, int i17) {
            MelodyVideoAnimationView melodyVideoAnimationView;
            com.oplus.melody.common.util.L l4;
            final int i18 = i12 - i10;
            final int i19 = i13 - i11;
            final int i20 = i16 - i14;
            final int i21 = i17 - i15;
            A.c("MelodyVideoAnimationView", new Supplier() { // from class: Ea.P
                @Override // java.util.function.Supplier
                public final Object get() {
                    MelodyVideoAnimationView.a aVar = this.f1467a;
                    aVar.getClass();
                    StringBuilder sb2 = new StringBuilder("onLayoutChange left:");
                    sb2.append(i10);
                    sb2.append("top:");
                    sb2.append(i11);
                    sb2.append(" right:");
                    sb2.append(i12);
                    sb2.append(" bottom:");
                    sb2.append(i13);
                    sb2.append(" width:");
                    sb2.append(i18);
                    sb2.append(" height:");
                    sb2.append(i19);
                    sb2.append(" oldWidth:");
                    sb2.append(i20);
                    sb2.append(" oldHeight:");
                    sb2.append(i21);
                    sb2.append(" mMediaPlayer==null:");
                    sb2.append(MelodyVideoAnimationView.this.f21952p == null);
                    return sb2.toString();
                }
            });
            if ((i18 == i20 && i19 == i21) || (l4 = (melodyVideoAnimationView = MelodyVideoAnimationView.this).f21952p) == null) {
                return;
            }
            int videoWidth = l4.f19435b.getVideoWidth();
            int videoHeight = melodyVideoAnimationView.f21952p.f19435b.getVideoHeight();
            A.c("MelodyVideoAnimationView", new Q(videoWidth, videoHeight, 0));
            if (videoWidth <= 0 || videoHeight <= 0) {
                return;
            }
            melodyVideoAnimationView.b(videoWidth, videoHeight);
        }
    }

    public MelodyVideoAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f21949a = new L(this, 0);
        this.f21956t = false;
        this.f21960x = new a();
        setOpaque(false);
        setSurfaceTextureListener(new O(this));
    }

    public static /* synthetic */ CompletableFuture a(MelodyVideoAnimationView melodyVideoAnimationView, Uri uri, com.oplus.melody.common.util.L l4) {
        melodyVideoAnimationView.f21952p = l4;
        A.b("MelodyVideoAnimationView", "tryPrepare prepared");
        return melodyVideoAnimationView.getSurfaceTextureFuture().thenApply((Function<? super SurfaceTexture, ? extends U>) new C0402k(1, melodyVideoAnimationView, uri));
    }

    private CompletableFuture<SurfaceTexture> getSurfaceTextureFuture() {
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            return CompletableFuture.completedFuture(surfaceTexture);
        }
        CompletableFuture<SurfaceTexture> completableFuture = this.f21954r;
        if (completableFuture == null || completableFuture.isDone()) {
            this.f21954r = new CompletableFuture<>();
        }
        return this.f21954r;
    }

    public final void b(int i10, int i11) {
        int width;
        int height;
        if (this.f21955s) {
            height = getHeight();
            width = (height * i10) / i11;
        } else {
            width = getWidth();
            height = (width * i11) / i10;
        }
        if (A.l()) {
            StringBuilder sbM = androidx.appcompat.widget.a.m(i10, i11, "onVideoSizeChanged video=(", ", ", ") view=(");
            r.m(sbM, width, ", ", height, ") mAutoCrop=");
            sbM.append(this.f21955s);
            A.b("MelodyVideoAnimationView", sbM.toString());
        }
        if (this.f21955s) {
            int width2 = getWidth();
            int height2 = getHeight();
            if (width2 == 0 || height2 == 0) {
                A.b("MelodyVideoAnimationView", "transformVideo, width or height is not valid");
                return;
            }
            float f9 = width2;
            float f10 = i10;
            float f11 = height2;
            float f12 = i11;
            float fMax = Math.max(f9 / f10, f11 / f12);
            Matrix matrix = new Matrix();
            matrix.preTranslate((width2 - i10) / 2.0f, (height2 - i11) / 2.0f);
            matrix.preScale(f10 / f9, f12 / f11);
            matrix.postScale(fMax, fMax, f9 / 2.0f, f11 / 2.0f);
            float fAbs = this.f21957u;
            float fAbs2 = this.f21958v;
            if (fAbs != 0.0f) {
                float f13 = ((f10 * fMax) - f9) / 2.0f;
                if (Math.abs(fAbs) > Math.abs(f13)) {
                    fAbs = fAbs < 0.0f ? -Math.abs(f13) : Math.abs(f13);
                }
            }
            if (fAbs2 != 0.0f) {
                float f14 = ((f12 * fMax) - f11) / 2.0f;
                if (Math.abs(fAbs2) > Math.abs(f14)) {
                    fAbs2 = fAbs2 < 0.0f ? -Math.abs(f14) : Math.abs(f14);
                }
            }
            if (fAbs != 0.0f || fAbs2 != 0.0f) {
                matrix.postTranslate(fAbs, fAbs2);
            }
            if (A.l()) {
                A.b("MelodyVideoAnimationView", "transformVideo, maxScale=" + fMax + " mOffsetX=" + this.f21957u + " mOffsetY=" + this.f21958v + " offsetX=" + fAbs + " offsetY=" + fAbs2 + " width=" + width2 + " height=" + height2);
            }
            setTransform(matrix);
            postInvalidate();
        }
    }

    public final boolean c() {
        com.oplus.melody.common.util.L l4 = this.f21952p;
        if (l4 != null) {
            return l4.f19436c == 3 || l4.f19435b.isPlaying();
        }
        return false;
    }

    public final void d() {
        com.oplus.melody.common.util.L l4 = this.f21952p;
        if (l4 == null || !l4.a()) {
            A.x("MelodyVideoAnimationView", "pause failed because NOT_PLAYING");
        } else {
            A.c("MelodyVideoAnimationView", new d(this, 11));
        }
    }

    public final CompletableFuture<Uri> e(File file) {
        if (file != null) {
            return i(Uri.fromFile(file), 0);
        }
        f(0);
        return q0.b(MelodyException.e(0, "prepareFile null"));
    }

    public final void f(int i10) {
        if (this.f21959w != null) {
            A.b("MelodyVideoAnimationView", "abandonAudioFocus");
            B.a.f19427a.a(this.f21949a, "MelodyVideoAnimationView");
        }
        CompletableFuture<Uri> completableFuture = this.f21953q;
        this.f21953q = null;
        if (completableFuture != null && !completableFuture.isDone()) {
            A.b("MelodyVideoAnimationView", "releaseMediaPlayer future");
            completableFuture.cancel(true);
        }
        com.oplus.melody.common.util.L l4 = this.f21952p;
        this.f21952p = null;
        if (l4 != null) {
            A.b("MelodyVideoAnimationView", "releaseMediaPlayer player");
            l4.f();
            l4.c();
        }
        if ((i10 & 1) != 0) {
            A.b("MelodyVideoAnimationView", "releaseMediaPlayer surface");
            Surface surface = this.f21951c;
            this.f21951c = null;
            if (surface != null) {
                surface.release();
            }
        }
    }

    public final CompletableFuture<Integer> g(final int i10) {
        final com.oplus.melody.common.util.L l4 = this.f21952p;
        if (l4 == null) {
            return q0.b(MelodyException.e(0, "prepare first!!!"));
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final q0 q0Var = new q0(2L, TimeUnit.SECONDS);
        MediaPlayer mediaPlayer = l4.f19435b;
        mediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.oplus.melody.common.util.C
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public final void onSeekComplete(MediaPlayer mediaPlayer2) {
                l4.getClass();
                A.c("MelodyVideoPlayer", new C0910p(1, jElapsedRealtime));
                q0Var.complete(Integer.valueOf(i10));
            }
        });
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                mediaPlayer.seekTo(i10, 3);
                return q0Var;
            }
            mediaPlayer.seekTo(i10);
            return q0Var;
        } catch (Exception e10) {
            A.i("MelodyVideoPlayer", "seekTo", e10);
            q0Var.completeExceptionally(e10);
            return q0Var;
        }
    }

    public int getCurrentPosition() {
        com.oplus.melody.common.util.L l4 = this.f21952p;
        if (l4 != null) {
            return l4.f19435b.getCurrentPosition();
        }
        return -1;
    }

    public int getDuration() {
        com.oplus.melody.common.util.L l4 = this.f21952p;
        if (l4 != null) {
            return l4.f19435b.getDuration();
        }
        return -1;
    }

    public final void h() {
        com.oplus.melody.common.util.L l4 = this.f21952p;
        if (l4 == null || !l4.e()) {
            A.x("MelodyVideoAnimationView", "start failed because NOT_PREPARED");
            return;
        }
        A.c("MelodyVideoAnimationView", new Ca.r(this, 6));
        if (this.f21959w != null) {
            A.b("MelodyVideoAnimationView", "requestAudioFocus");
            B.a.f19427a.b(this.f21949a, "MelodyVideoAnimationView");
        }
    }

    public final CompletableFuture<Uri> i(Uri uri, int i10) {
        CompletableFuture<Uri> completableFuture;
        A.c("MelodyVideoAnimationView", new M(i10, uri, 0));
        if (i10 >= 2) {
            return q0.b(MelodyException.e(0, "prepare retryMax=2"));
        }
        if (uri.equals(this.f21950b) && (completableFuture = this.f21953q) != null && !completableFuture.isCompletedExceptionally()) {
            return this.f21953q;
        }
        Surface surface = this.f21951c;
        if (surface != null) {
            Canvas canvasLockCanvas = null;
            try {
                try {
                    A.b("MelodyVideoAnimationView", "clearSurface lock");
                    canvasLockCanvas = surface.lockCanvas(null);
                    if (canvasLockCanvas != null) {
                        canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    }
                    if (canvasLockCanvas != null) {
                        A.b("MelodyVideoAnimationView", "clearSurface unlock");
                        surface.unlockCanvasAndPost(canvasLockCanvas);
                    }
                } catch (Throwable th) {
                    A.i("MelodyVideoAnimationView", "clearSurface unlock", th);
                }
            } catch (Throwable th2) {
                try {
                    A.i("MelodyVideoAnimationView", "clearSurface lock", th2);
                    if (canvasLockCanvas != null) {
                        A.b("MelodyVideoAnimationView", "clearSurface unlock");
                        surface.unlockCanvasAndPost(canvasLockCanvas);
                    }
                } catch (Throwable th3) {
                    if (canvasLockCanvas != null) {
                        try {
                            A.b("MelodyVideoAnimationView", "clearSurface unlock");
                            surface.unlockCanvasAndPost(canvasLockCanvas);
                        } catch (Throwable th4) {
                            A.i("MelodyVideoAnimationView", "clearSurface unlock", th4);
                        }
                    }
                    throw th3;
                }
            }
        }
        f(1);
        this.f21950b = uri;
        CompletableFuture completableFutureSupplyAsync = CompletableFuture.supplyAsync(new s(2, this, uri));
        N n10 = new N(0, this, uri);
        l lVar = o0.c.f1144b;
        this.f21953q = completableFutureSupplyAsync.thenComposeAsync((Function) n10, (Executor) lVar);
        return new q0(this.f21953q.exceptionally((Function<Throwable, ? extends Uri>) new A6.d(2)), 2L, TimeUnit.SECONDS).thenComposeAsync((Function) new H(this, uri, i10, 0), (Executor) lVar);
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        addOnLayoutChangeListener(this.f21960x);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        f(1);
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.f21960x);
    }

    @Override // android.view.TextureView, android.view.View
    public final void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        A.c("MelodyVideoAnimationView", new f0(this, i10, 3));
        if (i10 == 0 || this.f21956t) {
            return;
        }
        f(0);
    }

    public void setAutoCrop(boolean z2) {
        A.c("MelodyVideoAnimationView", new G(0, z2));
        this.f21955s = z2;
    }

    public void setHoldMode(boolean z2) {
        this.f21956t = z2;
    }

    public void setLooping(boolean z2) {
        com.oplus.melody.common.util.L l4 = this.f21952p;
        if (l4 != null) {
            l4.getClass();
            try {
                l4.f19435b.setLooping(z2);
            } catch (Exception e10) {
                A.i("MelodyVideoPlayer", "setLooping", e10);
            }
        }
    }

    public void setMute(boolean z2) {
        A.c("MelodyVideoAnimationView", new K(this, z2, 0));
        if (z2) {
            this.f21959w = null;
        } else {
            this.f21959w = new AudioAttributes.Builder().setContentType(2).setUsage(1).build();
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        com.oplus.melody.common.util.L l4 = this.f21952p;
        if (l4 != null) {
            l4.f19435b.setOnCompletionListener(onCompletionListener);
        }
    }
}
