package com.oplus.melody.ui.widget;

import A9.d;
import A9.s;
import Ca.r;
import D6.f;
import D7.C0386u;
import D7.o0;
import Ea.C0404m;
import O7.m;
import V7.g;
import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0911q;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyDetailModelView;
import com.oplusos.vfxmodelviewer.view.ModelViewer;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import s8.AbstractC1508a;

/* JADX INFO: loaded from: classes3.dex */
public class MelodyDetailModelView extends FrameLayout {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f21822u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f21823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f21824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f21825c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LottieAnimationView f21826p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f21827q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DetailMainViewModel f21828r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f21829s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f21830t;

    public class b implements RequestListener<Drawable> {
        public b() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z2) {
            A.i("MelodyDetailModelView", "onLoadFailed error: ", glideException);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z2) {
            Drawable drawable2 = drawable;
            if (drawable2 instanceof GifDrawable) {
                GifDrawable gifDrawable = (GifDrawable) drawable2;
                gifDrawable.setLoopCount(-1);
                gifDrawable.start();
                A.c("MelodyDetailModelView", new C0386u(4, drawable2, dataSource));
            } else {
                A.x("MelodyDetailModelView", "onResourceReady, resource: " + drawable2 + ", dataSource: " + dataSource);
            }
            MelodyDetailModelView melodyDetailModelView = MelodyDetailModelView.this;
            melodyDetailModelView.f21825c.setVisibility(0);
            melodyDetailModelView.f21825c.setBackgroundColor(0);
            melodyDetailModelView.f21825c.setBackgroundResource(R.color.transparent);
            melodyDetailModelView.f21826p.cancelAnimation();
            melodyDetailModelView.f21826p.setVisibility(8);
            a aVar = melodyDetailModelView.f21827q;
            if (aVar != null) {
                aVar.cancel();
            }
            return false;
        }
    }

    public MelodyDetailModelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21829s = true;
        this.f21830t = null;
    }

    public static boolean a() {
        J7.b.a().d();
        return false;
    }

    private void setWebpSource(String str) {
        A.c("MelodyDetailModelView", new f(str, 2));
        this.f21825c.setImageResource(0);
        Glide.with(this).load(new File(str)).addListener(new b()).into(this.f21825c);
    }

    public final void b(final g gVar) {
        if (gVar == null) {
            A.x("MelodyDetailModelView", "loadDetailSource, detailSource is null, network isConnected: " + m.b());
            if (m.b()) {
                return;
            }
            c();
            a aVar = this.f21827q;
            if (aVar != null) {
                aVar.cancel();
                return;
            }
            return;
        }
        a();
        final boolean z2 = false;
        A.c("MelodyDetailModelView", new Supplier() { // from class: Ea.q
            @Override // java.util.function.Supplier
            public final Object get() {
                int i10 = MelodyDetailModelView.f21822u;
                MelodyDetailModelView melodyDetailModelView = this.f1554a;
                melodyDetailModelView.getClass();
                return "loadDetailSource, supportModel: " + z2 + ", name: " + com.oplus.melody.common.util.A.q(melodyDetailModelView.f21828r.f20398c) + ", addr: " + com.oplus.melody.common.util.A.r(melodyDetailModelView.f21828r.f20397b) + ", pId: " + melodyDetailModelView.f21828r.f20400e + ", colorId: " + melodyDetailModelView.f21828r.f20401f + ", source: " + gVar;
            }
        });
        if (C0911q.g(gVar.getWebpFilePath())) {
            setWebpSource(gVar.getWebpFilePath());
            d();
            this.f21829s = false;
        } else if (C0911q.g(gVar.getPicFilePath())) {
            this.f21825c.setImageURI(Uri.fromFile(new File(gVar.getPicFilePath())));
            this.f21825c.setVisibility(0);
            this.f21826p.cancelAnimation();
            this.f21826p.setVisibility(8);
            d();
            this.f21829s = false;
        } else {
            c();
            d();
        }
        a aVar2 = this.f21827q;
        if (aVar2 != null) {
            aVar2.cancel();
        }
    }

    public final void c() {
        DetailMainViewModel detailMainViewModel = this.f21828r;
        int i10 = com.heytap.headset.R.drawable.melody_ui_detail_default_img;
        if (detailMainViewModel != null && !"OPPO O-Free".equals(detailMainViewModel.f20398c)) {
            AbstractC1508a abstractC1508aF = AbstractC1508a.f();
            DetailMainViewModel detailMainViewModel2 = this.f21828r;
            WhitelistConfigDTO whitelistConfigDTOC = abstractC1508aF.c(detailMainViewModel2.f20400e, detailMainViewModel2.f20398c);
            if (whitelistConfigDTOC != null && "N".equals(whitelistConfigDTOC.getType())) {
                i10 = com.heytap.headset.R.drawable.melody_ui_detail_default_img_neck;
            } else if (whitelistConfigDTOC != null && Y.i(whitelistConfigDTOC.getType())) {
                i10 = com.heytap.headset.R.drawable.melody_ui_detail_default_img_ows;
            }
        }
        this.f21825c.setVisibility(0);
        this.f21825c.setImageResource(i10);
        this.f21826p.cancelAnimation();
        this.f21826p.setVisibility(8);
    }

    public final void d() {
        A.c("MelodyDetailModelView", new r(this, 5));
        if (this.f21824b != null) {
            removeView(null);
            ((ModelViewer) this.f21824b).destroy();
            this.f21824b = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        A.c("MelodyDetailModelView", new C0404m(this, 1));
        a aVar = this.f21827q;
        if (aVar != null) {
            aVar.cancel();
            this.f21827q = null;
        }
        Glide.with(this).clear(this.f21825c);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        A.b("MelodyDetailModelView", "onFinishInflate");
        this.f21823a = findViewById(com.heytap.headset.R.id.model_view);
        this.f21825c = (ImageView) findViewById(com.heytap.headset.R.id.normal_image);
        this.f21826p = (LottieAnimationView) findViewById(com.heytap.headset.R.id.loading_view);
        this.f21825c.setVisibility(8);
        this.f21826p.setAnimation(com.heytap.headset.R.raw.melody_ui_lottie_loading);
        this.f21826p.playAnimation();
        a aVar = new a();
        this.f21827q = aVar;
        aVar.start();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setViewModel(DetailMainViewModel detailMainViewModel) {
        this.f21828r = detailMainViewModel;
    }

    public class a extends CountDownTimer {
        public a() {
            super(5000L, 5000L);
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            DetailMainViewModel detailMainViewModel;
            int i10;
            MelodyDetailModelView melodyDetailModelView = MelodyDetailModelView.this;
            if (melodyDetailModelView.f21828r == null || !melodyDetailModelView.f21829s || !m.c()) {
                if (melodyDetailModelView.f21828r != null) {
                    CompletableFuture.supplyAsync(new d(this, 9)).whenCompleteAsync((BiConsumer) new s(this, 6), (Executor) o0.c.f1144b);
                } else {
                    A.x("MelodyDetailModelView", "loading time out, show default image");
                }
                melodyDetailModelView.c();
                return;
            }
            A.x("MelodyDetailModelView", "loading time out, request source again.");
            melodyDetailModelView.f21827q.start();
            melodyDetailModelView.f21829s = false;
            if (TextUtils.isEmpty(melodyDetailModelView.f21828r.f20400e) || (i10 = (detailMainViewModel = melodyDetailModelView.f21828r).f20401f) == -1) {
                return;
            }
            detailMainViewModel.o(i10, detailMainViewModel.f20400e);
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j5) {
        }
    }
}
