package com.oplus.melody.common.widget.transparentvideo;

import A6.c;
import A9.i;
import Ca.n;
import Ca.r;
import D7.RunnableC0380n;
import D7.o0;
import Ea.C0404m;
import H7.e;
import H7.f;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.widget.transparentvideo.AlphaMovieView;
import com.oplus.melody.common.widget.transparentvideo.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final class AlphaMovieView extends b {

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final /* synthetic */ int f19531K = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public volatile MediaPlayer f19532A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public volatile boolean f19533B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public volatile int f19534C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f19535D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f19536E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public volatile int f19537F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public volatile int f19538G;
    public boolean H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f19539I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Uri f19540J;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile float f19541x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f19542y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a f19543z;

    public AlphaMovieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19541x = 1.3333334f;
        this.f19542y = 0;
        this.f19534C = 0;
        this.H = true;
        this.f19539I = true;
        setEGLContextClientVersion(2);
        setEGLConfigChooser(new b.C0227b(8, 16));
        f(new e(this, 0));
        a aVar = new a();
        this.f19543z = aVar;
        aVar.f19559y = new n(this, 3);
        setRenderer(aVar);
        setPreserveEGLContextOnPause(true);
        setOpaque(false);
    }

    public static void f(Runnable runnable) {
        o0.c.f1145c.execute(new RunnableC0380n(runnable, 5));
    }

    public final void d() {
        if (this.f19532A != null) {
            return;
        }
        this.f19534C = 0;
        this.f19532A = new MediaPlayer();
        this.f19532A.setScreenOnWhilePlaying(this.H);
        this.f19532A.setLooping(this.f19539I);
        this.f19532A.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: H7.a
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
                this.f2037a.f19534C = 8;
                return false;
            }
        });
        this.f19532A.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: H7.b
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                this.f2038a.f19534C = 5;
            }
        });
    }

    public final CompletableFuture<Uri> e() {
        A.c("AlphaMovieView", new r(this, 12));
        MediaPlayer mediaPlayer = this.f19532A;
        final CompletableFuture<Uri> completableFuture = new CompletableFuture<>();
        if (mediaPlayer == null || !(this.f19534C == 1 || this.f19534C == 6)) {
            completableFuture.completeExceptionally(MelodyException.e(0, "prepareAsync " + this.f19534C));
            return completableFuture;
        }
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: H7.d
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer2) {
                AlphaMovieView alphaMovieView = this.f2041a;
                CompletableFuture completableFuture2 = completableFuture;
                alphaMovieView.f19534C = 3;
                completableFuture2.complete(alphaMovieView.f19540J);
            }
        });
        try {
            this.f19534C = 2;
            mediaPlayer.prepareAsync();
            return completableFuture;
        } catch (IllegalStateException e10) {
            A.i("AlphaMovieView", "prepareAsync, error: ", e10);
            completableFuture.completeExceptionally(e10);
            return completableFuture;
        }
    }

    public final void g() {
        MediaPlayer mediaPlayer = this.f19532A;
        if (mediaPlayer == null || !this.f19533B) {
            return;
        }
        A.j("AlphaMovieView", "start: mState=" + this.f19534C);
        try {
            int i10 = this.f19534C;
            if (i10 != 1) {
                if (i10 == 3 || i10 == 5) {
                    mediaPlayer.start();
                    this.f19534C = 4;
                    return;
                } else if (i10 != 6) {
                    A.x("AlphaMovieView", "start: unexpected state=" + this.f19534C);
                    return;
                }
            }
            e().thenRunAsync((Runnable) new RunnableC0380n(this, 6), (Executor) o0.c.f1145c).exceptionally((Function<Throwable, ? extends Void>) new c(5));
        } catch (IllegalStateException e10) {
            A.i("AlphaMovieView", "start, error: ", e10);
        }
    }

    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.f19532A;
        if (mediaPlayer == null) {
            return -1;
        }
        if (this.f19534C == 4 || this.f19534C == 5) {
            return mediaPlayer.getCurrentPosition();
        }
        return -1;
    }

    @Override // com.oplus.melody.common.widget.transparentvideo.b, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f(new e(this, 1));
        a aVar = this.f19543z;
        if (aVar != null) {
            aVar.f19559y = null;
            this.f19543z = null;
        }
        this.f19537F = 0;
        this.f19538G = 0;
    }

    @Override // android.view.View
    public final void onLayout(boolean z2, int i10, int i11, int i12, int i13) {
        super.onLayout(z2, i10, i11, i12, i13);
        A.c("AlphaMovieView", new C0404m(this, 8));
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        float f9;
        float f10;
        float f11;
        float f12;
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = this.f19535D;
        if (size <= 0) {
            size = View.MeasureSpec.getSize(i10);
        }
        int size2 = this.f19536E;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i11);
        }
        this.f19535D = size;
        this.f19536E = size2;
        double d10 = ((double) size) / ((double) size2);
        int i12 = this.f19542y;
        if (i12 == 0) {
            if (d10 > this.f19541x) {
                f9 = size2;
                f10 = this.f19541x;
                size = (int) (f9 * f10);
            } else if (d10 < this.f19541x) {
                f11 = size;
                f12 = this.f19541x;
                size2 = (int) (f11 / f12);
            }
        } else if (i12 == 1) {
            if (this.f19537F > 0 && this.f19538G > 0) {
                a aVar = this.f19543z;
                int i13 = this.f19537F;
                int i14 = this.f19538G;
                int i15 = this.f19535D;
                int i16 = this.f19536E;
                if (aVar.f19560z != i13 || aVar.f19544A != i14 || aVar.f19545B != i15 || aVar.f19546C != i16) {
                    aVar.f19560z = i13;
                    aVar.f19544A = i14;
                    aVar.f19545B = i15;
                    aVar.f19546C = i16;
                    FloatBuffer floatBuffer = aVar.f19548b;
                    float[] fArr = aVar.f19547a;
                    if (floatBuffer == null) {
                        aVar.f19548b = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                    }
                    aVar.f19548b.clear();
                    aVar.f19548b.put(fArr).position(0);
                    float f13 = i13;
                    float f14 = i14;
                    float f15 = i15;
                    float f16 = f15 * 1.0f;
                    float f17 = i16;
                    if ((f13 * 1.0f) / f14 > f16 / f17) {
                        FloatBuffer floatBuffer2 = aVar.f19548b;
                        float f18 = ((f13 - ((f16 * f14) / f17)) / f13) / 2.0f;
                        floatBuffer2.put(2, floatBuffer2.get(2) + f18);
                        floatBuffer2.put(6, floatBuffer2.get(6) - f18);
                        floatBuffer2.put(10, floatBuffer2.get(10) + f18);
                        floatBuffer2.put(14, floatBuffer2.get(14) - f18);
                    } else {
                        FloatBuffer floatBuffer3 = aVar.f19548b;
                        float f19 = ((f14 - (((f17 * 1.0f) * f13) / f15)) / f14) / 2.0f;
                        floatBuffer3.put(3, floatBuffer3.get(3) + f19);
                        floatBuffer3.put(7, floatBuffer3.get(7) + f19);
                        floatBuffer3.put(11, floatBuffer3.get(11) - f19);
                        floatBuffer3.put(15, floatBuffer3.get(15) - f19);
                    }
                }
                super.onMeasure(i10, i11);
                return;
            }
            if (d10 > this.f19541x) {
                f11 = size;
                f12 = this.f19541x;
                size2 = (int) (f11 / f12);
            } else if (d10 < this.f19541x) {
                f9 = size2;
                f10 = this.f19541x;
                size = (int) (f9 * f10);
            }
        }
        if (A.l()) {
            A.b("AlphaMovieView", "onMeasure: w=" + size + " h=" + size2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
    }

    public void setAutoCrop(boolean z2) {
        A.c("AlphaMovieView", new i(5, z2));
    }

    public void setDataSource(Uri uri) {
        if (Objects.equals(this.f19540J, uri)) {
            return;
        }
        this.f19540J = uri;
        f(new f(this, 0));
    }

    public void setLooping(boolean z2) {
        this.f19539I = z2;
        f(new f(this, 1));
    }

    public void setMute(boolean z2) {
        A.c("AlphaMovieView", new i(4, z2));
    }

    public void setScaleType(int i10) {
        this.f19542y = i10;
    }

    public void setScreenOnWhilePlaying(boolean z2) {
        this.H = z2;
        f(new H7.c(this, 1));
    }
}
