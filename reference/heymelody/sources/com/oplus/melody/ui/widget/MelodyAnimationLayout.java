package com.oplus.melody.ui.widget;

import D7.o0;
import Ea.C0395d;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.heytap.headset.R;
import com.oplus.drs.core.d;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import t8.C1532B;
import u8.C1559g;

/* JADX INFO: loaded from: classes3.dex */
public final class MelodyAnimationLayout extends FrameLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f21740s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MelodyCompatImageView f21741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MelodyVideoAnimationView f21742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MelodyLottieAnimationView f21743c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f21744p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public C1559g f21745q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CompletableFuture<?> f21746r;

    public MelodyAnimationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(C1559g c1559g, String str) {
        MelodyResourceDO videoRes;
        if (c1559g == null || (videoRes = c1559g.getVideoRes()) == null) {
            MelodyVideoAnimationView melodyVideoAnimationView = this.f21742b;
            if (melodyVideoAnimationView != null) {
                melodyVideoAnimationView.setVisibility(8);
                return;
            }
            return;
        }
        MelodyVideoAnimationView videoView = getVideoView();
        videoView.setVisibility(0);
        C1532B.f(videoRes, videoView, this);
        this.f21746r = videoView.e(d.n(getContext(), videoRes, str)).whenCompleteAsync((BiConsumer<? super Uri, ? super Throwable>) new C0395d(0, videoView, c1559g), (Executor) o0.c.f1144b);
    }

    public final void b(C1559g c1559g, String str) {
        List<MelodyResourceDO> lottieResList;
        MelodyResourceDO imageRes;
        this.f21745q = c1559g;
        this.f21744p = str;
        if (c1559g == null || (imageRes = c1559g.getImageRes()) == null) {
            this.f21741a.setImageDrawable(null);
        } else {
            C1532B.f(imageRes, this.f21741a, this);
            this.f21741a.d(imageRes, str, 0, false);
        }
        if (c1559g == null || (lottieResList = c1559g.getLottieResList()) == null || lottieResList.isEmpty()) {
            MelodyLottieAnimationView melodyLottieAnimationView = this.f21743c;
            if (melodyLottieAnimationView != null) {
                melodyLottieAnimationView.setVisibility(8);
            }
        } else {
            MelodyLottieAnimationView lottieView = getLottieView();
            MelodyResourceDO melodyResourceDO = lottieResList.get(0);
            lottieView.getClass();
            C1532B.f(melodyResourceDO, lottieView, this);
            lottieView.e(melodyResourceDO, str, false);
            lottieView.setVisibility(0);
        }
        a(c1559g, str);
    }

    public MelodyCompatImageView getImageView() {
        return this.f21741a;
    }

    public MelodyLottieAnimationView getLottieView() {
        if (this.f21743c == null) {
            this.f21743c = (MelodyLottieAnimationView) ((ViewStub) findViewById(R.id.melody_ui_animation_stub_lottie)).inflate();
        }
        return this.f21743c;
    }

    public MelodyVideoAnimationView getVideoView() {
        if (this.f21742b == null) {
            this.f21742b = (MelodyVideoAnimationView) ((ViewStub) findViewById(R.id.melody_ui_animation_stub_video)).inflate();
        }
        return this.f21742b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f21746r == null) {
            a(this.f21745q, this.f21744p);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        CompletableFuture<?> completableFuture = this.f21746r;
        if (completableFuture != null) {
            completableFuture.cancel(true);
            this.f21746r = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f21741a = (MelodyCompatImageView) findViewById(R.id.melody_ui_animation_image);
    }
}
