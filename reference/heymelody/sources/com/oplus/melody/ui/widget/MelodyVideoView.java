package com.oplus.melody.ui.widget;

import A9.d;
import D7.C0384s;
import D7.o0;
import Ea.C0404m;
import Ea.S;
import Ea.U;
import Ea.X;
import Ea.a0;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.AudioAttributes;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.B;
import com.oplus.melody.common.util.L;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public class MelodyVideoView extends TextureView {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f21962x = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f21965c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final S f21966p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Uri f21967q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Surface f21968r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public L f21969s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CompletableFuture<Uri> f21970t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CompletableFuture<SurfaceTexture> f21971u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AudioAttributes f21972v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Bitmap f21973w;

    public interface a {
        void a();

        void b(int i10);

        void c(int i10, int i11);

        void d(int i10);
    }

    public MelodyVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f21963a = 0;
        this.f21964b = 0;
        this.f21966p = new S(this, 0);
        setOpaque(false);
        setSurfaceTextureListener(new a0(this));
    }

    public static /* synthetic */ CompletableFuture a(MelodyVideoView melodyVideoView, Uri uri, L l4) {
        melodyVideoView.f21969s = l4;
        A.b("MelodyVideoView", "initMediaPlayer prepared");
        return melodyVideoView.getSurfaceTextureFuture().thenApply((Function<? super SurfaceTexture, ? extends U>) new U(melodyVideoView, uri, 0));
    }

    private CompletableFuture<SurfaceTexture> getSurfaceTextureFuture() {
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            return CompletableFuture.completedFuture(surfaceTexture);
        }
        CompletableFuture<SurfaceTexture> completableFuture = this.f21971u;
        if (completableFuture == null || completableFuture.isDone()) {
            this.f21971u = new CompletableFuture<>();
        }
        return this.f21971u;
    }

    public final void b() {
        if (this.f21972v != null) {
            A.b("MelodyVideoView", "abandonAudioFocus");
            B.a.f19427a.a(this.f21966p, "MelodyVideoView");
        }
    }

    public final void c(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return;
        }
        int width = getWidth();
        int i12 = (width * i11) / i10;
        if (A.l()) {
            StringBuilder sbM = androidx.appcompat.widget.a.m(i10, i11, "onVideoSizeChanged video=(", ", ", ") view=(");
            sbM.append(width);
            sbM.append(", ");
            sbM.append(i12);
            sbM.append(')');
            A.b("MelodyVideoView", sbM.toString());
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i12;
        setLayoutParams(layoutParams);
        a aVar = this.f21965c;
        if (aVar != null) {
            aVar.c(width, i12);
        }
    }

    public final void d() {
        L l4;
        int currentState = getCurrentState();
        if (currentState == -1) {
            Uri uri = this.f21967q;
            if (uri != null) {
                e(uri);
                return;
            }
            return;
        }
        if (currentState != 2) {
            if (currentState == 3) {
                L l10 = this.f21969s;
                if (l10 == null || !l10.a()) {
                    A.x("MelodyVideoView", "pause failed because NOT_PLAYING");
                    return;
                } else {
                    A.c("MelodyVideoView", new C0404m(this, 2));
                    return;
                }
            }
            if (currentState != 4) {
                if (currentState == 5 && (l4 = this.f21969s) != null && l4.b()) {
                    g();
                    return;
                }
                return;
            }
        }
        g();
    }

    public final void e(Uri uri) {
        if (A.l()) {
            A.b("MelodyVideoView", "initMediaPlayerpath=" + uri);
        }
        this.f21967q = uri;
        this.f21970t = CompletableFuture.supplyAsync(new C0384s(3, this, uri)).thenComposeAsync((Function) new U(this, uri, 1), (Executor) o0.c.f1144b);
    }

    public final void f() {
        b();
        CompletableFuture<Uri> completableFuture = this.f21970t;
        this.f21970t = null;
        if (completableFuture != null && !completableFuture.isDone()) {
            A.b("MelodyVideoView", "releaseMediaPlayer future");
            completableFuture.cancel(true);
        }
        L l4 = this.f21969s;
        this.f21969s = null;
        if (l4 != null) {
            A.b("MelodyVideoView", "releaseMediaPlayer player");
            l4.f();
            l4.c();
        }
        A.b("MelodyVideoView", "releaseMediaPlayer surface");
        Surface surface = this.f21968r;
        this.f21968r = null;
        if (surface != null) {
            surface.release();
        }
    }

    public final void g() {
        L l4 = this.f21969s;
        if (l4 == null || !l4.e()) {
            A.x("MelodyVideoView", "start failed because NOT_PREPARED");
            return;
        }
        A.c("MelodyVideoView", new d(this, 12));
        if (this.f21972v != null) {
            A.b("MelodyVideoView", "requestAudioFocus");
            B.a.f19427a.b(this.f21966p, "MelodyVideoView");
        }
    }

    public int getCurrentPosition() {
        L l4 = this.f21969s;
        if (l4 != null) {
            return l4.f19435b.getCurrentPosition();
        }
        return -1;
    }

    public int getCurrentState() {
        L l4 = this.f21969s;
        if (l4 != null) {
            return l4.f19436c;
        }
        return 0;
    }

    public Bitmap getFirstFrameBitmap() {
        return this.f21973w;
    }

    public int getVideoHeight() {
        return this.f21964b;
    }

    public int getVideoWidth() {
        return this.f21963a;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        f();
        super.onDetachedFromWindow();
    }

    @Override // android.view.TextureView, android.view.View
    public final void onVisibilityChanged(View view, int i10) {
        L l4;
        super.onVisibilityChanged(view, i10);
        A.c("MelodyVideoView", new D7.L(i10, 4));
        if (i10 == 0 || (l4 = this.f21969s) == null) {
            return;
        }
        if (l4.f19436c == 3 || l4.f19435b.isPlaying()) {
            L l10 = this.f21969s;
            if (l10 == null || !l10.a()) {
                A.x("MelodyVideoView", "pause failed because NOT_PLAYING");
            } else {
                A.c("MelodyVideoView", new C0404m(this, 2));
            }
        }
    }

    public void setMute(boolean z2) {
        A.c("MelodyVideoView", new X(this, z2, 0));
        if (z2) {
            this.f21972v = null;
        } else {
            this.f21972v = new AudioAttributes.Builder().setContentType(2).setUsage(1).build();
        }
    }

    public void setStatusChangeCallback(a aVar) {
        this.f21965c = aVar;
    }
}
