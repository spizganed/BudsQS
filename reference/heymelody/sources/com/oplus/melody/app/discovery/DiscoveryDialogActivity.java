package com.oplus.melody.app.discovery;

import D7.C0373g;
import D7.C0377k;
import D7.C0379m;
import D7.o0;
import Q7.b;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.b;
import androidx.lifecycle.N;
import androidx.media3.session.RunnableC0677t0;
import androidx.recyclerview.widget.C0696b;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.gson.reflect.TypeToken;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.app.discovery.DiscoveryDialogViewModel;
import com.oplus.melody.common.addon.MelodyAppSwitchManager;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0909o;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.common.util.RunnableC0903i;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarStatusDTO;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.HeadsetRssiDetectionDTO;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.track.constant.AppConstant$DiscoverOpType;
import com.oplus.melody.track.track.Track;
import com.oplus.melody.ui.widget.MelodyCompatImageView;
import com.oplus.melody.ui.widget.MelodyLottieAnimationView;
import com.oplus.melody.ui.widget.MelodyVideoAnimationView;
import g0.C1064c;
import g0.C1065d;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import o.InterfaceC1361a;
import org.json.JSONException;
import s8.AbstractC1508a;
import t8.C1532B;
import u8.C1557e;
import u8.C1558f;

/* JADX INFO: loaded from: classes.dex */
public final class DiscoveryDialogActivity extends F8.a {

    /* JADX INFO: renamed from: L0, reason: collision with root package name */
    public static final /* synthetic */ int f18836L0 = 0;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    public String f18838B0;

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    public CompletableFuture<Uri> f18839C0;

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    public CompletableFuture<Uri> f18840D0;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public boolean f18849V;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public DiscoveryDialogViewModel f18853Z;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public C1557e f18857d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public androidx.lifecycle.t f18858e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public E1 f18859f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public ViewPager2 f18860g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public MelodyCompatImageView f18861h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public ImageView f18862i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public ViewGroup f18863j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public MelodyVideoAnimationView f18864k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public View f18865l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public MelodyCompatImageView f18866m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public MelodyCompatImageView f18867n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public List<MelodyLottieAnimationView> f18868o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public DiscoveryRecycleAdapter f18869p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public CompletableFuture<?> f18870q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public RunnableC0677t0 f18871r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public F7.a f18872s0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public MelodyCompatImageView f18874u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public ImageView f18875v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public View f18876w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f18877x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f18878y0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final long f18848U = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public final Handler f18850W = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public final SparseArray<I0> f18851X = new SparseArray<>();

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public final RunnableC0857i f18852Y = new RunnableC0857i(this, 0);

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f18854a0 = 0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f18855b0 = 0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f18856c0 = 0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f18873t0 = 0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f18879z0 = true;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    public boolean f18837A0 = true;

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    public boolean f18841E0 = false;

    /* JADX INFO: renamed from: F0, reason: collision with root package name */
    public boolean f18842F0 = false;

    /* JADX INFO: renamed from: G0, reason: collision with root package name */
    public boolean f18843G0 = false;

    /* JADX INFO: renamed from: H0, reason: collision with root package name */
    public boolean f18844H0 = false;

    /* JADX INFO: renamed from: I0, reason: collision with root package name */
    public boolean f18845I0 = false;

    /* JADX INFO: renamed from: J0, reason: collision with root package name */
    public boolean f18846J0 = false;

    /* JADX INFO: renamed from: K0, reason: collision with root package name */
    public boolean f18847K0 = false;

    /* JADX INFO: renamed from: com.oplus.melody.app.discovery.DiscoveryDialogActivity$1, reason: invalid class name */
    public class AnonymousClass1 extends TypeToken<List<DiscoveryRecycleItemVO>> {
    }

    public class a implements RequestListener<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1 f18880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f18881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DiscoveryDialogActivity f18882c;

        public a(ImageView imageView, DiscoveryDialogActivity discoveryDialogActivity, C1 c12) {
            this.f18882c = discoveryDialogActivity;
            this.f18880a = c12;
            this.f18881b = imageView;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z2) {
            this.f18881b.setVisibility(4);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z2) {
            View view;
            Drawable drawable2 = drawable;
            int i10 = DiscoveryDialogActivity.f18836L0;
            DiscoveryDialogActivity discoveryDialogActivity = this.f18882c;
            if (discoveryDialogActivity.U()) {
                return true;
            }
            ImageView imageView = this.f18881b;
            C1 c12 = this.f18880a;
            DiscoveryDialogActivity.I(discoveryDialogActivity, c12, imageView, drawable2);
            imageView.setVisibility(0);
            if (c12 != null && c12.getEnterUpAnim() && !discoveryDialogActivity.f18847K0 && !discoveryDialogActivity.f18846J0 && imageView.getVisibility() == 0) {
                float height = imageView.getHeight();
                if (height <= 0.0f && (view = discoveryDialogActivity.f18865l0) != null) {
                    height = view.getHeight();
                }
                if (height <= 0.0f) {
                    height = discoveryDialogActivity.getResources().getDimensionPixelOffset(R.dimen.melody_app_discovery_dialog_height);
                }
                imageView.animate().cancel();
                imageView.setTranslationY(height);
                imageView.animate().translationY(0.0f).setDuration(300L).start();
                discoveryDialogActivity.f18847K0 = true;
            }
            if (drawable2 instanceof WebpDrawable) {
                WebpDrawable webpDrawable = (WebpDrawable) drawable2;
                webpDrawable.setLoopCount(1);
                webpDrawable.registerAnimationCallback(new T(this));
                webpDrawable.start();
            }
            return false;
        }
    }

    public static void I(DiscoveryDialogActivity discoveryDialogActivity, C1 c12, ImageView imageView, Drawable drawable) {
        C1558f discoveryStates;
        discoveryDialogActivity.getClass();
        if (c12 == null || (discoveryStates = c12.getDiscoveryStates()) == null || !Boolean.TRUE.equals(discoveryStates.getSkipWideFill())) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                return;
            }
            int iE = (C0909o.e(discoveryDialogActivity) * intrinsicHeight) / intrinsicWidth;
            if (iE > C0909o.d(discoveryDialogActivity)) {
                imageView.setAdjustViewBounds(false);
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.height = iE;
                imageView.setLayoutParams(layoutParams);
            }
        }
    }

    public static void M(Runnable runnable) {
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new D7.Q(11));
        if (!com.oplus.melody.common.util.S.t(C0906l.f19501a)) {
            runnable.run();
            return;
        }
        if (t8.q.n()) {
            runnable.run();
            return;
        }
        if (t8.q.r()) {
            return;
        }
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        boolean z2 = false;
        if (com.oplus.melody.common.util.S.w(heyMelodyApplication, 96)) {
            com.oplus.melody.common.util.A.x("StatementNavigationUtils", "jumpToStatementActivity rejected by isRejectDialog");
        } else if (t8.s.a(0)) {
            com.oplus.melody.common.util.A.x("StatementNavigationUtils", "jumpToStatementActivity rejected by isFastDoubleClick");
        } else {
            String packageName = heyMelodyApplication.getPackageName();
            Intent intent = new Intent(C1065d.c(packageName, ".intent.action.STATEMENT"));
            intent.setPackage(packageName);
            intent.addFlags(805306368);
            if (!TextUtils.isEmpty(null)) {
                intent.putExtra("product_id", (String) null);
                intent.putExtra("product_color", String.valueOf(0));
            }
            C0914u.a(0, intent);
            C0905k.j(heyMelodyApplication, intent);
            z2 = true;
        }
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new Ea.G(15, z2));
        if (z2) {
            t8.y.f27959a = runnable;
            MelodyAppSwitchManager.INSTANCE.registerAppSwitchObserver(C0906l.f19501a, t8.y.f27960b, Arrays.asList("com.oplus.melody.app.statement.StatementActivity"), Arrays.asList(com.oplus.melody.common.util.S.e(C0906l.f19501a)));
        }
    }

    public static void Q(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setTextColor(Q1.a.b(textView.getCurrentTextColor()));
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                Q(viewGroup.getChildAt(i10));
            }
        }
    }

    public static void g0(final String str, final String str2, AppConstant$DiscoverOpType appConstant$DiscoverOpType, final String str3, HeadsetRssiDetectionDTO headsetRssiDetectionDTO) {
        final int i10;
        final int i11;
        final int i12;
        final int gestureType;
        if (headsetRssiDetectionDTO != null) {
            int rssi = (int) headsetRssiDetectionDTO.getRssi();
            int adjustRssi = (int) headsetRssiDetectionDTO.getAdjustRssi();
            int averageRssi = (int) headsetRssiDetectionDTO.getAverageRssi();
            gestureType = headsetRssiDetectionDTO.getGestureType();
            i10 = rssi;
            i11 = adjustRssi;
            i12 = averageRssi;
        } else {
            i10 = 0;
            i11 = 0;
            i12 = 0;
            gestureType = 0;
        }
        if (com.oplus.melody.common.util.A.l()) {
            StringBuilder sbI = androidx.media3.session.D0.i("trackDiscoverDialog productId: ", str, ", addr: ");
            sbI.append(com.oplus.melody.common.util.A.r(str2));
            sbI.append(", rssi: ");
            sbI.append(i10);
            sbI.append(", adjRssi: ");
            Y.r.m(sbI, i11, ", avgRssi: ", i12, ", gestureType: ");
            sbI.append(gestureType);
            sbI.append(", gestureOffset: ");
            sbI.append(C0373g.f1077b);
            com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", sbI.toString());
        }
        final int opType = appConstant$DiscoverOpType.getOpType();
        final int i13 = C0373g.f1077b;
        if (TextUtils.isEmpty(str) || !B8.a.d(str, str2)) {
            A6.b.g("trackDiscoverDialog, someone is null, earbudsId: ", str, "AppTrackHelper");
            return;
        }
        ForkJoinPool.commonPool().execute(new RunnableC0903i(16, new Wb.l() { // from class: z8.d
            @Override // Wb.l
            public final Object d(Object obj) throws JSONException {
                Track it = (Track) obj;
                kotlin.jvm.internal.h.e(it, "it");
                it.a(Integer.valueOf(opType), "state_type");
                it.a(str3, "state_value");
                int i14 = i10;
                if (i14 > 0) {
                    it.a(Integer.valueOf(i14), "rssi");
                    it.a(Integer.valueOf(i11), "adjust_rssi");
                    it.a(Integer.valueOf(i12), "avg_rssi");
                    it.a(Integer.valueOf(gestureType), "gesture_type");
                    it.a(Integer.valueOf(i13), "gesture_offset");
                }
                it.a(str, "earbuds_id");
                it.a(B8.a.c(str2), "earbuds_addr_id");
                it.a(B8.a.a(), "device_id");
                it.a(S.k(), "os_version");
                it.a(B8.a.b(), "app_version");
                it.d();
                return Jb.l.f2618a;
            }
        }, new Track("melody_discover_dialog", "10610001")));
    }

    public final void J() {
        View view;
        ImageView imageView = this.f18862i0;
        if (imageView == null || this.f18846J0) {
            return;
        }
        imageView.animate().cancel();
        if (imageView.getVisibility() != 0) {
            this.f18846J0 = false;
            this.f18847K0 = false;
            imageView.setVisibility(4);
            imageView.setTranslationY(0.0f);
            return;
        }
        float height = imageView.getHeight();
        if (height <= 0.0f && (view = this.f18865l0) != null) {
            height = view.getHeight();
        }
        if (height <= 0.0f) {
            height = getResources().getDimensionPixelOffset(R.dimen.melody_app_discovery_dialog_height);
        }
        imageView.animate().translationY(height).setDuration(300L).withEndAction(new RunnableC0863k(this, imageView, 0)).start();
        this.f18846J0 = true;
    }

    public final void K() {
        E0 e0S = S();
        if (e0S != null && e0S.getDiscoveryState() < 6) {
            g0(e0S.getProductId(), e0S.getId(), AppConstant$DiscoverOpType.CANCEL, Integer.toString(e0S.getDiscoveryState()), AbstractC0939b.E().z(e0S.getId()));
        }
    }

    public final void L() {
        if (S() == null) {
            com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "checkShowBindFailToast getLastEarphone() is null!");
            return;
        }
        if (this.f18853Z == null) {
            com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "checkShowBindFailToast mDialogViewModel is null!");
            return;
        }
        if (S().getAccountBindingState() == 5) {
            if (this.f18853Z.k() || this.f18853Z.l() || this.f18853Z.m()) {
                int accountBindingResultCode = S().getAccountBindingResultCode();
                com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new Ea.D(accountBindingResultCode, 15));
                if (accountBindingResultCode == 6) {
                    E8.a.S(C0906l.f19501a, R.string.melody_common_try_after_login);
                    return;
                } else {
                    if (accountBindingResultCode == 7) {
                        return;
                    }
                    E8.a.S(C0906l.f19501a, R.string.melody_common_bind_account_failed);
                    return;
                }
            }
            return;
        }
        if (S().getAccountBindingState() == 3 && S().getAccountBindingResultCode() == 5) {
            if (this.f18853Z.k() || this.f18853Z.l()) {
                E8.a.S(C0906l.f19501a, R.string.melody_common_bind_account_later2);
            } else if (this.f18853Z.m()) {
                String name = S().getName();
                if (TextUtils.isEmpty(name)) {
                    name = "";
                }
                E8.a.T(C0906l.f19501a, C0906l.f19501a.getString(R.string.melody_common_bind_account_later, name));
            }
        }
    }

    public final void N(String str) {
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new C0845e(str, 2));
        this.f18853Z.getClass();
        AbstractC0939b.E().d(null, true);
        K();
        this.f18879z0 = false;
        P();
    }

    public final void O() {
        com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "dialogComplete");
        this.f18879z0 = false;
        P();
        o0.b.f1142a.schedule(new K0(S(), 2), 300L, TimeUnit.MILLISECONDS);
    }

    public final void P() {
        J();
        E1 e12 = this.f18859f0;
        if (e12 == null || !e12.isShowing()) {
            com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "dismissDialog finishWithoutTransition");
            R();
            return;
        }
        this.f18859f0.dismiss();
        com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "dismissDialog");
        Handler handler = this.f18850W;
        RunnableC0857i runnableC0857i = this.f18852Y;
        handler.removeCallbacks(runnableC0857i);
        handler.postDelayed(runnableC0857i, 300L);
    }

    public final void R() {
        finishAfterTransition();
        overridePendingTransition(0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final E0 S() {
        androidx.lifecycle.t tVar = this.f18858e0;
        if (tVar != null) {
            return (E0) tVar.d();
        }
        return null;
    }

    public final CompletableFuture<C1> T() {
        E0 e0S = S();
        if (e0S == null) {
            return CompletableFuture.completedFuture(C1.EMPTY);
        }
        return this.f18853Z.i(e0S.getProductColorId(), e0S.getProductId(), e0S.getId());
    }

    public final boolean U() {
        boolean z2 = this.f18841E0 || isFinishing() || isDestroyed();
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new Ea.G(14, z2));
        return z2;
    }

    public final void V(ImageView imageView, C1 c12, RunnableC0857i runnableC0857i) {
        MelodyResourceDO strangeRes;
        if (U() || imageView == null || c12 == null || (strangeRes = c12.getStrangeRes()) == null || strangeRes.getUrl() == null) {
            return;
        }
        File fileO = com.oplus.drs.core.d.o(this, c12.getRootPath(), strangeRes.getUrl());
        if (fileO != null) {
            Glide.with((androidx.fragment.app.f) this).load(fileO).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).dontAnimate().into(new V(this, c12, imageView, runnableC0857i));
            return;
        }
        com.oplus.melody.common.util.A.x("DiscoveryDialogActivity", "loadStrangeResStaticImage file not found: " + strangeRes.getUrl());
    }

    public final CompletableFuture<?> W(int i10, final int i11, int i12, final int i13) {
        CompletableFuture<Integer> completableFutureCompletedFuture;
        I0 i0J0 = j0(i10);
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new Ea.Q(i10, i13, 3));
        if (i0J0 != null) {
            com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new H(i0J0, i12, i13, 0));
            completableFutureCompletedFuture = i0J0.h(i12);
        } else {
            completableFutureCompletedFuture = CompletableFuture.completedFuture(Integer.valueOf(i10));
        }
        return completableFutureCompletedFuture.thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new I(this, 0)).thenComposeAsync((Function<? super U, ? extends CompletionStage<U>>) new J(this, i10, i11, i13, i12, 0), (Executor) o0.c.f1144b).whenComplete(new BiConsumer() { // from class: com.oplus.melody.app.discovery.K
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                int i14 = DiscoveryDialogActivity.f18836L0;
                com.oplus.melody.common.util.A.d("DiscoveryDialogActivity", new R7.b(i11, i13, 1), (Throwable) obj2);
            }
        });
    }

    public final void X(C1 c12, C1557e c1557e) {
        if (c1557e.equals(this.f18857d0)) {
            MelodyVideoAnimationView melodyVideoAnimationView = this.f18864k0;
            if (!melodyVideoAnimationView.isShown() && !melodyVideoAnimationView.f21956t) {
                com.oplus.melody.common.util.A.x("DiscoveryDialogActivity", "onVideoEnd because video no show");
                return;
            }
            Integer endTime = c1557e.getEndTime();
            Integer loopTime = c1557e.getLoopTime();
            com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new L(this, melodyVideoAnimationView, endTime, loopTime, 0));
            if (Math.abs(this.f18854a0) == 1) {
                E0 e0S = S();
                if (e0S == null) {
                    return;
                }
                DiscoveryDialogViewModel discoveryDialogViewModel = this.f18853Z;
                String id = e0S.getId();
                discoveryDialogViewModel.getClass();
                discoveryDialogViewModel.o(id, new C0869m0(2, id, 0));
                return;
            }
            if (loopTime == null) {
                melodyVideoAnimationView.g(endTime.intValue());
                this.f18877x0 = endTime.intValue();
                melodyVideoAnimationView.d();
            } else {
                melodyVideoAnimationView.g(loopTime.intValue());
                if (!melodyVideoAnimationView.c()) {
                    melodyVideoAnimationView.h();
                }
                Y(c12, c1557e, endTime.intValue());
            }
        }
    }

    public final void Y(C1 c12, C1557e c1557e, int i10) {
        if (c1557e.equals(this.f18857d0)) {
            RunnableC0677t0 runnableC0677t0 = this.f18871r0;
            Handler handler = this.f18850W;
            if (runnableC0677t0 != null) {
                handler.removeCallbacks(runnableC0677t0);
            }
            if (!this.f18864k0.isShown() && !this.f18864k0.f21956t) {
                com.oplus.melody.common.util.A.x("DiscoveryDialogActivity", "onVideoEndDelayed return because video not show");
                return;
            }
            RunnableC0677t0 runnableC0677t02 = new RunnableC0677t0(this, i10, c12, c1557e, 1);
            this.f18871r0 = runnableC0677t02;
            handler.postDelayed(runnableC0677t02, i10 - this.f18864k0.getCurrentPosition());
        }
    }

    public final CompletableFuture<?> Z(final int i10, int i11) {
        if ((i11 & 1) == 0 || this.f18853Z.k() || this.f18853Z.l() || "onForwardConnectedPopup".equals(this.f18853Z.f18890j)) {
            com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new D7.L(i10, 26));
            return this.f18864k0.g(i10);
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final List listSingletonList = Collections.singletonList(this.f18864k0);
        Ca.a aVarE = J6.d.e(listSingletonList);
        Function function = new Function() { // from class: com.oplus.melody.app.discovery.F
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int i12 = DiscoveryDialogActivity.f18836L0;
                DiscoveryDialogActivity discoveryDialogActivity = this.f18903a;
                discoveryDialogActivity.getClass();
                long j5 = jElapsedRealtime;
                int i13 = i10;
                com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new M(i13, 0, j5));
                return discoveryDialogActivity.f18864k0.g(i13);
            }
        };
        h0.l lVar = o0.c.f1144b;
        return aVarE.thenComposeAsync(function, (Executor) lVar).thenComposeAsync((Function<? super U, ? extends CompletionStage<U>>) new Function() { // from class: com.oplus.melody.app.discovery.G
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int i12 = DiscoveryDialogActivity.f18836L0;
                com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new D7.N(i10, 1, jElapsedRealtime));
                return J6.d.d(200, listSingletonList);
            }
        }, (Executor) lVar);
    }

    public final void a0(final Bundle bundle, final List<DiscoveryRecycleItemVO> list, final int i10, final int i11, final int i12) {
        if (U()) {
            com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "selectDialogType isInvalidForDialogInit");
            return;
        }
        if (this.f18842F0) {
            d0(i10, list);
            i0(i11, i12, list);
        } else {
            DiscoveryRecycleItemVO discoveryRecycleItemVO = list.get(i10);
            this.f18853Z.i(discoveryRecycleItemVO.getColorId(), discoveryRecycleItemVO.getProductId(), discoveryRecycleItemVO.getMacAddress()).thenAcceptAsync(new Consumer(bundle, list, i10, i11, i12) { // from class: com.oplus.melody.app.discovery.l

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ List f19131b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ int f19132c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ int f19133d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public final /* synthetic */ int f19134e;

                {
                    this.f19131b = list;
                    this.f19132c = i10;
                    this.f19133d = i11;
                    this.f19134e = i12;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:60:0x01c2  */
                /* JADX WARN: Type inference failed for: r3v1, types: [com.oplus.melody.app.discovery.t] */
                /* JADX WARN: Type inference failed for: r4v10, types: [com.oplus.melody.app.discovery.s] */
                /* JADX WARN: Type inference failed for: r4v9, types: [com.oplus.melody.app.discovery.r] */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // java.util.function.Consumer
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void accept(java.lang.Object r8) {
                    /*
                        Method dump skipped, instruction units count: 538
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.app.discovery.C0866l.accept(java.lang.Object):void");
                }
            }, (Executor) o0.c.f1144b);
        }
    }

    public final void b0(int i10) {
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new D7.Y(i10, 22));
        E0 e0S = S();
        if (e0S == null) {
            return;
        }
        DiscoveryDialogViewModel discoveryDialogViewModel = this.f18853Z;
        String id = e0S.getId();
        discoveryDialogViewModel.getClass();
        discoveryDialogViewModel.o(id, new C0861j0(i10, id));
    }

    public final void c0(int i10) {
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new Ba.b(i10, 23));
        E0 e0S = S();
        if (e0S == null) {
            return;
        }
        DiscoveryDialogViewModel discoveryDialogViewModel = this.f18853Z;
        String id = e0S.getId();
        discoveryDialogViewModel.getClass();
        discoveryDialogViewModel.o(id, new C0894z0(i10, id, 0));
    }

    public final void d0(int i10, List list) {
        int i11;
        String macAddress = ((DiscoveryRecycleItemVO) list.get(i10)).getMacAddress();
        androidx.lifecycle.t<E0> tVar = this.f18858e0;
        androidx.lifecycle.t<E0> tVar2 = this.f18853Z.h(macAddress).f18895a;
        this.f18858e0 = tVar2;
        if (tVar2 == tVar) {
            return;
        }
        if (tVar != null && this.f18855b0 > 2) {
            O();
            return;
        }
        int i12 = 0;
        if (tVar != null && (i11 = this.f18855b0) != 0) {
            DiscoveryDialogViewModel discoveryDialogViewModel = this.f18853Z;
            discoveryDialogViewModel.getClass();
            discoveryDialogViewModel.o(macAddress, new C0869m0(i11, macAddress, i12));
        }
        if (this.f18860g0.getCurrentItem() != i10) {
            this.f18860g0.d(i10, false);
        }
        J7.b.a().c();
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new C0845e(macAddress, 3));
        if (tVar != null) {
            tVar.k(this);
        }
        this.f18858e0.e(this, new X(this, 1));
    }

    public final void e0(boolean z2, boolean z4) {
        boolean z10 = this.f18878y0;
        this.f18878y0 = z2;
        if (z10 == z2) {
            return;
        }
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new B6.c(2, z2, z4));
        if (z2) {
            if (!this.f18845I0) {
                I0 i0J0 = j0(this.f18854a0);
                DiscoveryDialogActivity discoveryDialogActivity = i0J0.f18929b;
                i0J0.f18931d.setTextColor(discoveryDialogActivity.getColorStateList(R.color.melody_app_discovery_title_text_color));
                i0J0.f18932e.setTextColor(discoveryDialogActivity.getColorStateList(R.color.melody_ui_common_text_color_summary));
            }
            J6.d.b(this.f18860g0);
            J6.d.a(this.f18861h0);
            J6.d.a(this.f18864k0);
        } else {
            this.f18861h0.setImageDrawable(null);
            J6.d.a(this.f18860g0);
            J6.d.b(this.f18861h0);
        }
        if (z4) {
            T().thenAcceptAsync(new Consumer() { // from class: com.oplus.melody.app.discovery.n
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    DiscoveryDialogActivity discoveryDialogActivity2 = this.f19144a;
                    discoveryDialogActivity2.h0(Math.abs(discoveryDialogActivity2.f18854a0), (C1) obj);
                }
            }, (Executor) o0.c.f1144b);
        }
    }

    public final void f0(C1 c12, C1557e c1557e) {
        if (c1557e == null) {
            com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "showDressImage animState is null");
            return;
        }
        boolean zIsAutoCrop = c1557e.isAutoCrop();
        MelodyResourceDO backgroundDressImageRes = c1557e.getBackgroundDressImageRes();
        if (backgroundDressImageRes != null) {
            if (com.oplus.melody.common.util.A.l()) {
                com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "showDressImage BG " + backgroundDressImageRes);
            }
            MelodyCompatImageView melodyCompatImageView = this.f18867n0;
            melodyCompatImageView.getClass();
            melodyCompatImageView.d(backgroundDressImageRes, c12.getRootPath(), 0, false);
            this.f18867n0.setVisibility(0);
            if (zIsAutoCrop) {
                this.f18867n0.getLayoutParams().height = -1;
                this.f18867n0.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
        MelodyResourceDO foregroundDressImageRes = c1557e.getForegroundDressImageRes();
        if (foregroundDressImageRes != null) {
            if (com.oplus.melody.common.util.A.l()) {
                com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "showDressImage FG " + foregroundDressImageRes);
            }
            MelodyCompatImageView melodyCompatImageView2 = this.f18866m0;
            melodyCompatImageView2.getClass();
            melodyCompatImageView2.d(foregroundDressImageRes, c12.getRootPath(), 0, false);
            this.f18866m0.setVisibility(0);
            if (zIsAutoCrop) {
                this.f18866m0.getLayoutParams().height = -1;
                this.f18866m0.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    @Override // androidx.appcompat.app.i, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        if (configuration.fontScale == 1.0f) {
            return resources;
        }
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new C0836b(configuration, 1));
        configuration.fontScale = 1.0f;
        return createConfigurationContext(configuration).getResources();
    }

    public final void h0(final int i10, final C1 c12) {
        int iIntValue;
        CompletableFuture completableFutureB;
        E1 e12;
        ViewStub viewStub;
        ViewStub viewStub2;
        final ImageView imageView;
        E0 e0S;
        int i11 = 1;
        if (U()) {
            com.oplus.melody.common.util.A.x("DiscoveryDialogActivity", "updateBackground ignore because activity invalid");
            return;
        }
        if (this.f18854a0 != i10) {
            StringBuilder sbN = androidx.appcompat.widget.a.n(i10, "updateBackground except ", " but ");
            sbN.append(this.f18854a0);
            com.oplus.melody.common.util.A.h("DiscoveryDialogActivity", sbN.toString());
            return;
        }
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new Ea.D(i10, 16));
        final I0 i0J0 = j0(i10);
        C1557e c1557eB = i0J0.b(c12);
        int iIntValue2 = 0;
        final boolean z2 = (c1557eB == null || c1557eB.getBgVideoRes() == null || (c1557eB.getBudsImageRes() == null && c1557eB.getFgAnimRes() == null)) ? false : true;
        MelodyResourceDO bgVideoRes = null;
        final Boolean showImageRes = c1557eB != null ? c1557eB.getShowImageRes() : null;
        i0J0.k(c12);
        i0J0.l(c12);
        CompletableFuture<Uri> completableFuture = this.f18840D0;
        if (completableFuture != null && !completableFuture.isDone()) {
            this.f18840D0.cancel(true);
            com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "cancel previous future");
        }
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new C0868m(this, 1));
        int i12 = 2;
        if (c12 != null && c12.getStrangeRes() != null) {
            if (!this.f18845I0) {
                this.f18864k0.setVisibility(8);
                this.f18865l0.setBackground(null);
                i0J0.m(c12, true);
                if (this.f18862i0 == null && (viewStub = (ViewStub) findViewById(R.id.melody_app_discovery_background_stub)) != null) {
                    this.f18862i0 = (ImageView) viewStub.inflate();
                }
                V(this.f18862i0, c12, new RunnableC0857i(this, i11));
                return;
            }
            if (Math.abs(this.f18854a0) == 1 && (e0S = S()) != null) {
                DiscoveryDialogViewModel discoveryDialogViewModel = this.f18853Z;
                String id = e0S.getId();
                discoveryDialogViewModel.getClass();
                discoveryDialogViewModel.o(id, new C0869m0(i12, id, iIntValue2));
            }
            if (this.f18843G0) {
                if (i10 != 4 && i10 != 3) {
                    if (i10 == 6) {
                        i0J0.m(c12, false);
                        return;
                    }
                    return;
                } else {
                    if (!this.f18844H0 && (imageView = this.f18862i0) != null) {
                        imageView.animate().cancel();
                        imageView.animate().alpha(0.5f).setDuration(300L).withEndAction(new Runnable() { // from class: com.oplus.melody.app.discovery.w
                            @Override // java.lang.Runnable
                            public final void run() {
                                ImageView imageView2;
                                C1 c13;
                                MelodyResourceDO strangeRes;
                                int i13 = DiscoveryDialogActivity.f18836L0;
                                DiscoveryDialogActivity discoveryDialogActivity = this;
                                if (discoveryDialogActivity.U() || (imageView2 = imageView) == null || (c13 = c12) == null || (strangeRes = c13.getStrangeRes()) == null || strangeRes.getUrl() == null) {
                                    return;
                                }
                                File fileO = com.oplus.drs.core.d.o(discoveryDialogActivity, c13.getRootPath(), strangeRes.getUrl());
                                if (fileO != null) {
                                    Glide.with((androidx.fragment.app.f) discoveryDialogActivity).load(fileO).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).dontAnimate().into(new U(imageView2, discoveryDialogActivity, c13));
                                    return;
                                }
                                com.oplus.melody.common.util.A.x("DiscoveryDialogActivity", "loadStrangeResStaticImageAndFadeIn file not found: " + strangeRes.getUrl());
                            }
                        }).start();
                    }
                    i0J0.m(c12, true);
                    return;
                }
            }
            File fileN = com.oplus.drs.core.d.n(this, c12.getStrangeRes(), c12.getRootPath());
            if (fileN == null) {
                com.oplus.melody.common.util.A.x("DiscoveryDialogActivity", "updateBackground strangeRes path is null");
                return;
            }
            if (U()) {
                com.oplus.melody.common.util.A.x("DiscoveryDialogActivity", "updateBackground skip strangeRes because activity invalid");
                return;
            }
            if (this.f18862i0 == null && (viewStub2 = (ViewStub) findViewById(R.id.melody_app_discovery_background_stub)) != null) {
                this.f18862i0 = (ImageView) viewStub2.inflate();
            }
            ImageView imageView2 = this.f18862i0;
            if (imageView2 == null) {
                com.oplus.melody.common.util.A.x("DiscoveryDialogActivity", "updateBackground strangeRes host is null");
                return;
            }
            Glide.with((androidx.fragment.app.f) this).clear(imageView2);
            imageView2.setImageDrawable(null);
            imageView2.setVisibility(4);
            this.f18847K0 = false;
            Glide.with((androidx.fragment.app.f) this).load(fileN).placeholder(new ColorDrawable(0)).error((Drawable) new ColorDrawable(0)).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).dontAnimate().addListener(new a(imageView2, this, c12)).into(imageView2);
            this.f18843G0 = true;
            return;
        }
        if (this.f18845I0 && (e12 = this.f18859f0) != null) {
            e12.a();
        }
        if (this.f18878y0 && Math.abs(this.f18854a0) == 2) {
            completableFutureB = D7.q0.b(MelodyException.e(406, "Video disabled"));
        } else {
            if (c1557eB != null) {
                bgVideoRes = c1557eB.getBgVideoRes();
                MelodyResourceDO videoRes = c1557eB.getVideoRes();
                if (bgVideoRes == null) {
                    bgVideoRes = videoRes != null ? videoRes : c12.getVideoRes();
                }
            }
            if (bgVideoRes == null) {
                completableFutureB = D7.q0.b(MelodyException.e(404, "videoRes is null"));
            } else if (c1557eB == null || c1557eB.getStartTime() != null) {
                File fileN2 = com.oplus.drs.core.d.n(this, bgVideoRes, c12.getRootPath());
                if (fileN2 == null) {
                    completableFutureB = D7.q0.b(MelodyException.e(404, "Video not found"));
                } else {
                    f0(c12, c1557eB);
                    MelodyVideoAnimationView melodyVideoAnimationView = this.f18864k0;
                    com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new C0876q(this, 1));
                    if (this.f18837A0 && (c1557eB.getAnimation() & 1) != 0) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(melodyVideoAnimationView);
                        J6.d.d(600, arrayList);
                    }
                    this.f18837A0 = false;
                    melodyVideoAnimationView.setAutoCrop(true);
                    if (C0909o.f(this, getResources().getDimensionPixelOffset(R.dimen.melody_app_discovery_dialog_height)) <= 293) {
                        iIntValue = c12.getVideoLandOffsetX() != null ? c12.getVideoLandOffsetX().intValue() : 0;
                        if (c12.getVideoLandOffsetY() != null) {
                            iIntValue2 = c12.getVideoLandOffsetY().intValue();
                        }
                    } else {
                        iIntValue = c12.getVideoOffsetX() != null ? c12.getVideoOffsetX().intValue() : 0;
                        if (c12.getVideoOffsetY() != null) {
                            iIntValue2 = c12.getVideoOffsetY().intValue();
                        }
                    }
                    melodyVideoAnimationView.f21957u = iIntValue;
                    melodyVideoAnimationView.f21958v = iIntValue2;
                    ConcurrentHashMap concurrentHashMap = C1532B.f27917a;
                    Integer numC = C1532B.c(this, bgVideoRes.getBackgroundColor(), bgVideoRes.getBackgroundColorNight());
                    CompletableFuture<Uri> completableFuture2 = this.f18839C0;
                    if (completableFuture2 != null && !completableFuture2.isDone()) {
                        this.f18839C0.cancel(true);
                        com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "mPrepareVideoFileFuture cancel");
                    }
                    CompletableFuture completableFutureThenApplyAsync = melodyVideoAnimationView.e(fileN2).thenApplyAsync((Function<? super Uri, ? extends U>) new Z7.d(this, c12, c1557eB, numC), (Executor) o0.c.f1144b);
                    this.f18839C0 = completableFutureThenApplyAsync;
                    completableFutureB = completableFutureThenApplyAsync;
                }
            } else {
                completableFutureB = D7.q0.b(MelodyException.e(415, "not support video"));
            }
        }
        this.f18840D0 = completableFutureB;
        completableFutureB.whenCompleteAsync(new BiConsumer() { // from class: com.oplus.melody.app.discovery.o
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                final Uri uri = (Uri) obj;
                final Throwable th = (Throwable) obj2;
                int i13 = DiscoveryDialogActivity.f18836L0;
                final DiscoveryDialogActivity discoveryDialogActivity = this.f19151a;
                discoveryDialogActivity.getClass();
                final int i14 = i10;
                final boolean z4 = z2;
                final Boolean bool = showImageRes;
                com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new Supplier() { // from class: com.oplus.melody.app.discovery.x
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        int i15 = DiscoveryDialogActivity.f18836L0;
                        DiscoveryDialogActivity discoveryDialogActivity2 = discoveryDialogActivity;
                        discoveryDialogActivity2.getClass();
                        StringBuilder sb2 = new StringBuilder("updateBackground END, state:");
                        sb2.append(i14);
                        sb2.append(" showVideoAsBackground:");
                        sb2.append(z4);
                        sb2.append(" e==null:");
                        sb2.append(th == null);
                        sb2.append(" uri==null:");
                        sb2.append(uri == null);
                        sb2.append(" mMultiDeviceEnabled:");
                        sb2.append(discoveryDialogActivity2.f18878y0);
                        sb2.append(" showImageRes:");
                        sb2.append(bool);
                        return sb2.toString();
                    }
                });
                I0 i02 = i0J0;
                C1 c13 = c12;
                if (th != null || uri == null) {
                    if (!discoveryDialogActivity.f18878y0) {
                        discoveryDialogActivity.f18863j0.setVisibility(8);
                    }
                    discoveryDialogActivity.f18864k0.setVisibility(8);
                    discoveryDialogActivity.f18867n0.setVisibility(8);
                    discoveryDialogActivity.f18866m0.setVisibility(8);
                    i02.m(c13, true);
                } else {
                    if (!discoveryDialogActivity.f18878y0) {
                        Object tag = discoveryDialogActivity.f18864k0.getTag(R.id.melody_app_no_all_battery_hide_video);
                        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new C0836b(tag, 2));
                        if (!(tag instanceof Boolean) || !((Boolean) tag).booleanValue()) {
                            J6.d.c(discoveryDialogActivity.f18864k0, null);
                        }
                    }
                    if (z4 || (bool != null && bool.booleanValue())) {
                        i02.m(c13, true);
                        discoveryDialogActivity.f18867n0.setVisibility(8);
                        discoveryDialogActivity.f18866m0.setVisibility(8);
                    } else {
                        i02.m(c13, false);
                    }
                }
                int i15 = discoveryDialogActivity.f18864k0.getVisibility() == 0 ? 1 : 0;
                E0 e0S2 = discoveryDialogActivity.S();
                if (e0S2 != null && i14 == 2) {
                    DiscoveryDialogActivity.g0(e0S2.getProductId(), e0S2.getId(), AppConstant$DiscoverOpType.SHOW_RES, Integer.toString(i15), null);
                }
            }
        }, (Executor) o0.c.f1144b).exceptionally((Function) new b9.n(i10, 1));
    }

    public final void i0(int i10, int i11, List list) {
        DiscoveryRecycleAdapter discoveryRecycleAdapter = this.f18869p0;
        if (discoveryRecycleAdapter == null || this.f18860g0 == null) {
            com.oplus.melody.common.util.A.x("DiscoveryDialogActivity", "updateMultiDevices ignored because dialog not ready");
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        List<DiscoveryRecycleItemVO> list2 = discoveryRecycleAdapter.f18900d;
        discoveryRecycleAdapter.f18900d = arrayList;
        androidx.recyclerview.widget.p.a(new F0(list2, arrayList)).a(new C0696b(discoveryRecycleAdapter));
        if (!this.f18878y0 || i10 <= 0 || i10 == i11) {
            return;
        }
        Handler handler = this.f18850W;
        ViewPager2 viewPager2 = this.f18860g0;
        Objects.requireNonNull(viewPager2);
        handler.post(new RunnableC0885v(viewPager2, 0));
    }

    public final I0 j0(int i10) {
        SparseArray<I0> sparseArray = this.f18851X;
        I0 z1Var = sparseArray.get(i10);
        if (z1Var == null) {
            switch (i10) {
                case 0:
                    z1Var = null;
                    break;
                case 1:
                    m1 m1Var = new m1(this, i10);
                    m1Var.f19143m = true;
                    z1Var = m1Var;
                    break;
                case 2:
                    z1Var = new z1(this, i10);
                    break;
                case 3:
                    z1Var = new p1(this, i10);
                    break;
                case 4:
                    z1Var = new C0859i1(this, i10);
                    break;
                case 5:
                    z1Var = new N0(this, i10);
                    break;
                case 6:
                    z1Var = new C0850f1(this, i10);
                    break;
                case 7:
                    z1Var = new l1(this, i10);
                    break;
                case 8:
                    z1Var = new A1(this, i10);
                    break;
                default:
                    throw MelodyException.e(0, "unknown view state " + i10);
            }
            if (z1Var != null) {
                sparseArray.put(i10, z1Var);
            }
        }
        return z1Var;
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(final Bundle bundle) {
        List listSingletonList;
        if (t8.u.a() && Build.VERSION.SDK_INT >= 35) {
            setTheme(R.style.MelodyUiTheme_QuickDialog_LightNavigationBar);
        }
        super.onCreate(bundle);
        c.k.a(this);
        int i10 = Build.VERSION.SDK_INT;
        boolean z2 = false;
        if (i10 >= 29) {
            getWindow().setNavigationBarContrastEnforced(false);
        } else {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setNavigationBarColor(0);
        }
        if (com.oplus.melody.common.util.A.l()) {
            com.oplus.melody.common.util.A.f("DiscoveryDialogActivity", "onCreate start args=" + bundle);
        }
        if ("com.heytap.headset".equals(getPackageName()) && i10 >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            if (i10 >= 30) {
                attributes.layoutInDisplayCutoutMode = 3;
            } else {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            getWindow().setAttributes(attributes);
        }
        if (bundle != null) {
            listSingletonList = (List) C0917x.d(bundle.getString("melodyLastItems"), new AnonymousClass1().getType());
            this.f18854a0 = bundle.getInt("melodyCurrentState", this.f18854a0);
            this.f18873t0 = bundle.getInt("melodyEntryComplete", this.f18873t0);
        } else {
            listSingletonList = null;
        }
        Intent intent = getIntent();
        this.f18838B0 = C0914u.h(intent, "route_from");
        if (listSingletonList == null || listSingletonList.isEmpty()) {
            listSingletonList = Collections.singletonList(DiscoveryRecycleItemVO.create(C0914u.h(intent, "device_mac_info"), C0914u.h(intent, "device_name"), C0914u.h(intent, "product_id"), com.oplus.melody.common.util.K.b(-1, C0914u.h(intent, "product_color")), C0914u.h(intent, "product_type"), true));
        }
        List list = listSingletonList;
        String strH = C0914u.h(intent, "dress_id");
        androidx.lifecycle.O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(DiscoveryDialogViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        DiscoveryDialogViewModel discoveryDialogViewModel = (DiscoveryDialogViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f18853Z = discoveryDialogViewModel;
        String str = this.f18838B0;
        com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0845e(str, 5));
        discoveryDialogViewModel.f18890j = str;
        this.f18853Z.f18893m = strH;
        String strH2 = C0914u.h(getIntent(), "route_value2");
        if (!TextUtils.isEmpty(strH2)) {
            try {
                z2 = Boolean.parseBoolean(strH2);
            } catch (Exception e10) {
                com.oplus.melody.common.util.A.i("DiscoveryDialogActivity", "onCreate parseBoolean", e10);
            }
        }
        DiscoveryDialogViewModel discoveryDialogViewModel2 = this.f18853Z;
        discoveryDialogViewModel2.f18888g = z2;
        list.stream().filter(new C0882t0()).findFirst().ifPresent(new C0892y0(discoveryDialogViewModel2, 0));
        final E6.a aVar = new E6.a(2, SystemClock.elapsedRealtime(), this);
        this.f18850W.postDelayed(aVar, 2000L);
        final DiscoveryDialogViewModel discoveryDialogViewModel3 = this.f18853Z;
        discoveryDialogViewModel3.getClass();
        com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0888w0(discoveryDialogViewModel3, list, 1));
        final androidx.lifecycle.t tVar = new androidx.lifecycle.t();
        if (!C0901g.a(list)) {
            tVar.l(list);
        }
        if (C0901g.a(list) || "onNewDeviceDiscovery".equals(discoveryDialogViewModel3.f18890j)) {
            tVar.m(AbstractC0939b.E().g(), new androidx.lifecycle.v() { // from class: com.oplus.melody.app.discovery.Y
                @Override // androidx.lifecycle.v
                public final void onChanged(Object obj) {
                    List list2 = (List) obj;
                    DiscoveryDialogViewModel discoveryDialogViewModel4 = discoveryDialogViewModel3;
                    if (discoveryDialogViewModel4.f18894n) {
                        com.oplus.melody.common.util.A.b("DiscoveryDialogViewModel", "addSourceOnNewDeviceDiscovery mConnectedWithGuideButton return:");
                        return;
                    }
                    int size = list2.size();
                    String strF = DiscoveryDialogViewModel.f(list2, discoveryDialogViewModel4.f18883b.d(), new A6.d(0));
                    ArrayList arrayList = new ArrayList(size);
                    for (int i11 = 0; i11 < size; i11++) {
                        EarphoneDTO earphoneDTO = (EarphoneDTO) list2.get(i11);
                        DiscoveryRecycleItemVO discoveryRecycleItemVOCreate = DiscoveryRecycleItemVO.create(earphoneDTO.getMacAddress(), earphoneDTO.getName(), earphoneDTO.getProductId(), earphoneDTO.getColorId(), earphoneDTO.getProductType(), TextUtils.equals(strF, earphoneDTO.getMacAddress()));
                        com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0849f0(earphoneDTO, 0));
                        arrayList.add(i11, discoveryRecycleItemVOCreate);
                    }
                    androidx.lifecycle.t tVar2 = tVar;
                    List list3 = (List) tVar2.d();
                    if (list3 == null) {
                        list3 = Collections.EMPTY_LIST;
                    }
                    if (arrayList.equals(list3)) {
                        com.oplus.melody.common.util.A.b("DiscoveryDialogViewModel", "discoverGet: NOT_MODIFY");
                    } else {
                        com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0840c0(arrayList, 1));
                        tVar2.l(arrayList);
                    }
                }
            });
        }
        tVar.m(AbstractC0939b.E().K0(), new androidx.lifecycle.v() { // from class: com.oplus.melody.app.discovery.Z
            @Override // androidx.lifecycle.v
            public final void onChanged(Object obj) {
                final int i11 = 1;
                final EarphoneDTO earphoneDTO = (EarphoneDTO) obj;
                DiscoveryDialogViewModel discoveryDialogViewModel4 = discoveryDialogViewModel3;
                discoveryDialogViewModel4.getClass();
                if (earphoneDTO == null) {
                    com.oplus.melody.common.util.A.b("DiscoveryDialogViewModel", "sppCoverOpen: IGNORE null");
                    return;
                }
                EarStatusDTO earStatus = earphoneDTO.getEarStatus();
                if (earStatus == null) {
                    com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new Supplier() { // from class: com.oplus.melody.app.discovery.h0
                        @Override // java.util.function.Supplier
                        public final Object get() {
                            switch (i) {
                                case 0:
                                    return "sppCoverOpen: IGNORE earStatus=null " + com.oplus.melody.common.util.A.r(earphoneDTO.getMacAddress());
                                default:
                                    return "sppCoverOpen: IGNORE inactive " + com.oplus.melody.common.util.A.r(earphoneDTO.getMacAddress());
                            }
                        }
                    });
                    return;
                }
                int boxStatus = earStatus.getBoxStatus();
                Pattern pattern = com.oplus.melody.model.repository.earphone.N.f19941a;
                i = (boxStatus & 4) == 4 ? 1 : 0;
                if (i != 0 && discoveryDialogViewModel4.m()) {
                    com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0849f0(earphoneDTO, 1));
                    return;
                }
                androidx.lifecycle.t tVar2 = tVar;
                List list2 = (List) tVar2.d();
                if (!C0901g.a(list2)) {
                    if (i != 0) {
                        com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0840c0(earphoneDTO, 2));
                        return;
                    }
                    DiscoveryRecycleItemVO discoveryRecycleItemVO = (DiscoveryRecycleItemVO) list2.stream().filter(new Predicate() { // from class: com.oplus.melody.app.discovery.i0
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj2) {
                            return TextUtils.equals(((DiscoveryRecycleItemVO) obj2).getMacAddress(), earphoneDTO.getMacAddress());
                        }
                    }).findFirst().orElse(null);
                    if (discoveryRecycleItemVO == null || !discoveryRecycleItemVO.isActive()) {
                        com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new Supplier() { // from class: com.oplus.melody.app.discovery.h0
                            @Override // java.util.function.Supplier
                            public final Object get() {
                                switch (i11) {
                                    case 0:
                                        return "sppCoverOpen: IGNORE earStatus=null " + com.oplus.melody.common.util.A.r(earphoneDTO.getMacAddress());
                                    default:
                                        return "sppCoverOpen: IGNORE inactive " + com.oplus.melody.common.util.A.r(earphoneDTO.getMacAddress());
                                }
                            }
                        });
                        return;
                    }
                }
                if (i != 0) {
                    com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0849f0(earphoneDTO, 2));
                    tVar2.l(Collections.singletonList(DiscoveryRecycleItemVO.create(earphoneDTO.getMacAddress(), earphoneDTO.getName(), earphoneDTO.getProductId(), earphoneDTO.getColorId(), earphoneDTO.getProductType(), true)));
                } else {
                    com.oplus.melody.common.util.A.x("DiscoveryDialogViewModel", "sppCoverOpen set empty list, size is 0");
                    tVar2.l(Collections.EMPTY_LIST);
                }
            }
        });
        tVar.m(C0379m.g(AbstractC1508a.f().i(), new C1064c(23)), new X(tVar, 0));
        tVar.m(discoveryDialogViewModel3.f18883b, new androidx.lifecycle.v() { // from class: com.oplus.melody.app.discovery.a0
            @Override // androidx.lifecycle.v
            public final void onChanged(Object obj) {
                DiscoveryDialogViewModel.b bVar = (DiscoveryDialogViewModel.b) obj;
                discoveryDialogViewModel3.getClass();
                androidx.lifecycle.t tVar2 = tVar;
                List list2 = (List) tVar2.d();
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                int size = list2.size();
                ArrayList arrayList = new ArrayList(list2);
                String strF = DiscoveryDialogViewModel.f(list2, bVar, new C0837b0(0));
                boolean z4 = false;
                for (int i11 = 0; i11 < size; i11++) {
                    DiscoveryRecycleItemVO discoveryRecycleItemVO = (DiscoveryRecycleItemVO) arrayList.get(i11);
                    boolean zEquals = TextUtils.equals(discoveryRecycleItemVO.getMacAddress(), strF);
                    if (discoveryRecycleItemVO.isActive() != zEquals) {
                        DiscoveryRecycleItemVO discoveryRecycleItemVO2 = (DiscoveryRecycleItemVO) com.oplus.melody.common.data.a.copyOf(discoveryRecycleItemVO, DiscoveryRecycleItemVO.class);
                        com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0840c0(discoveryRecycleItemVO2, 0));
                        discoveryRecycleItemVO2.setActive(zEquals);
                        arrayList.set(i11, discoveryRecycleItemVO2);
                        z4 = true;
                    }
                }
                if (z4) {
                    com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0846e0(arrayList, 0));
                    tVar2.l(arrayList);
                }
            }
        });
        tVar.m(discoveryDialogViewModel3.f18887f, new androidx.lifecycle.v() { // from class: com.oplus.melody.app.discovery.A0
            @Override // androidx.lifecycle.v
            public final void onChanged(Object obj) {
                Map map = (Map) obj;
                if (map == null || map.isEmpty()) {
                    return;
                }
                androidx.lifecycle.t tVar2 = tVar;
                List<DiscoveryRecycleItemVO> list2 = (List) tVar2.d();
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (DiscoveryRecycleItemVO discoveryRecycleItemVO : list2) {
                    String macAddress = discoveryRecycleItemVO.getMacAddress();
                    Boolean bool = (Boolean) map.get(macAddress);
                    if (bool == null || bool.booleanValue()) {
                        arrayList.add(discoveryRecycleItemVO);
                    } else {
                        com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0845e(macAddress, 4));
                    }
                }
                if (arrayList.size() != list2.size()) {
                    tVar2.l(arrayList);
                }
            }
        });
        C0379m.g(tVar, new InterfaceC1361a() { // from class: com.oplus.melody.app.discovery.B0
            @Override // o.InterfaceC1361a, com.google.common.base.b
            public final Object apply(Object obj) {
                List list2 = (List) obj;
                ConcurrentHashMap concurrentHashMap = discoveryDialogViewModel3.f18884c;
                androidx.collection.b bVar = new androidx.collection.b(concurrentHashMap.keySet());
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    bVar.remove(((DiscoveryRecycleItemVO) it.next()).getMacAddress());
                }
                b.a aVar2 = new b.a();
                while (aVar2.hasNext()) {
                    concurrentHashMap.remove((String) aVar2.next());
                }
                return list2;
            }
        }).e(this, new androidx.lifecycle.v() { // from class: com.oplus.melody.app.discovery.O
            @Override // androidx.lifecycle.v
            public final void onChanged(Object obj) {
                int i11 = 0;
                List<DiscoveryRecycleItemVO> list2 = (List) obj;
                int i12 = DiscoveryDialogActivity.f18836L0;
                DiscoveryDialogActivity discoveryDialogActivity = this.f18976a;
                if (discoveryDialogActivity.U()) {
                    com.oplus.melody.common.util.A.x("DiscoveryDialogActivity", "ignore discovery update because activity invalid");
                    return;
                }
                discoveryDialogActivity.f18850W.removeCallbacks(aVar);
                int size = list2.size();
                DiscoveryRecycleAdapter discoveryRecycleAdapter = discoveryDialogActivity.f18869p0;
                int size2 = discoveryRecycleAdapter != null ? discoveryRecycleAdapter.f18900d.size() : 0;
                com.oplus.melody.common.util.A.x("DiscoveryDialogActivity", "Discovery item data changed, newSize=" + size + ", oldSize:" + size2);
                if (size > 0 && Math.abs(discoveryDialogActivity.f18854a0) == 6 && "onNewDeviceDiscovery".equals(discoveryDialogActivity.f18838B0) && discoveryDialogActivity.f18858e0 != null) {
                    com.oplus.melody.common.util.A.h("DiscoveryDialogActivity", "onNewDeviceDiscovery but current state is connected , return !!");
                    return;
                }
                if (size == 0) {
                    discoveryDialogActivity.P();
                    DiscoveryDialogActivity.M(new RunnableC0860j(i11));
                    return;
                }
                Bundle bundle2 = bundle;
                if (size == 1) {
                    discoveryDialogActivity.a0(bundle2, list2, 0, size, size2);
                    return;
                }
                discoveryDialogActivity.e0(Math.abs(discoveryDialogActivity.f18854a0) == 2, true);
                for (int i13 = 0; i13 < size; i13++) {
                    DiscoveryRecycleItemVO discoveryRecycleItemVO = list2.get(i13);
                    if (discoveryRecycleItemVO != null && discoveryRecycleItemVO.isActive()) {
                        discoveryDialogActivity.a0(bundle2, list2, i13, size, size2);
                        return;
                    }
                }
            }
        });
        String strH3 = C0914u.h(getIntent(), "device_mac_info");
        String strH4 = C0914u.h(getIntent(), "product_id");
        if ("onNewDeviceDiscovery".equals(this.f18838B0)) {
            g0(strH4, strH3, AppConstant$DiscoverOpType.SHOW_DIALOG, "", AbstractC0939b.E().z(strH3));
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f18848U;
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new P(0, jElapsedRealtime));
        if (!com.oplus.melody.common.util.A.k() || jElapsedRealtime <= 1000) {
            return;
        }
        com.oplus.melody.common.util.A.w("DiscoveryDialogActivity", "弹窗需要优化，创建耗时 " + jElapsedRealtime + " 毫秒", null);
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onDestroy() {
        com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "onDestroy");
        this.f18841E0 = true;
        this.f18843G0 = false;
        this.f18844H0 = false;
        if (S() != null && !TextUtils.isEmpty(S().getId()) && S().getAccountBindingState() != 0) {
            com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new C0874p(this, 0));
            if (S().getAccountBindingState() == 1) {
                DiscoveryDialogViewModel discoveryDialogViewModel = this.f18853Z;
                if (discoveryDialogViewModel != null && (discoveryDialogViewModel.l() || this.f18853Z.k())) {
                    String id = S().getId();
                    int i10 = t8.q.c("melody-model-settings").getInt("bind_account_count_" + id, 0);
                    com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new Ba.b(i10, 22));
                    String id2 = S().getId();
                    int i11 = i10 + 1;
                    t8.q.c("melody-model-settings").edit().putInt("bind_account_count_" + id2, i11).apply();
                    if (i11 >= 3) {
                        DiscoveryDialogViewModel discoveryDialogViewModel2 = this.f18853Z;
                        String id3 = S().getId();
                        discoveryDialogViewModel2.getClass();
                        String strT = com.oplus.melody.model.repository.earphone.N.t(AbstractC0939b.E().w(id3));
                        String productId = S().getProductId();
                        String id4 = S().getId();
                        if (TextUtils.isEmpty(productId) || !B8.a.d(productId, id4)) {
                            A6.b.g("trackCancelBindAccountThreeTime, someone is null, earbudsId: ", productId, "AppTrackHelper");
                        } else {
                            ForkJoinPool.commonPool().execute(new RunnableC0903i(16, new C0377k(productId, id4, strT, 1), new Track("melody_cancel_bind_account_three_time", "10610001")));
                        }
                    }
                }
            } else {
                com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "updateSpBindAccountCount reset count to 0!");
                String id5 = S().getId();
                t8.q.c("melody-model-settings").edit().putInt("bind_account_count_" + id5, 0).apply();
            }
            L();
        } else if (S() == null) {
            com.oplus.melody.common.util.A.h("DiscoveryDialogActivity", "updateSpBindAccountCount getLastEarphone() is null!");
        } else {
            com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new C0876q(this, 2));
        }
        CompletableFuture<?> completableFuture = this.f18870q0;
        if (completableFuture != null) {
            completableFuture.cancel(true);
            this.f18870q0 = null;
        }
        CompletableFuture<Uri> completableFuture2 = this.f18839C0;
        if (completableFuture2 != null) {
            completableFuture2.cancel(true);
            this.f18839C0 = null;
        }
        CompletableFuture<Uri> completableFuture3 = this.f18840D0;
        if (completableFuture3 != null) {
            completableFuture3.cancel(true);
            this.f18840D0 = null;
        }
        ImageView imageView = this.f18862i0;
        if (imageView != null) {
            imageView.animate().cancel();
            this.f18846J0 = false;
            this.f18847K0 = false;
            Glide.with(getApplicationContext()).clear(this.f18862i0);
            this.f18862i0.setImageDrawable(null);
            this.f18862i0.setVisibility(4);
        }
        if (this.f18853Z.k() || this.f18854a0 == 6) {
            this.f18853Z.getClass();
            AbstractC0939b.E().X();
            E0 e0S = S();
            if (e0S != null && this.f18853Z != null) {
                AbstractC0939b.E().V(e0S.getId());
            }
        }
        E0 e0S2 = S();
        if (e0S2 != null && this.f18854a0 == 7) {
            DiscoveryDialogViewModel discoveryDialogViewModel3 = this.f18853Z;
            String id6 = e0S2.getId();
            discoveryDialogViewModel3.getClass();
            AbstractC0939b.E().W(id6);
        }
        this.f18850W.removeCallbacksAndMessages(null);
        F7.a aVar = this.f18872s0;
        if (aVar != null) {
            aVar.f1641a = null;
            C0905k.o(this, aVar);
        }
        E1 e12 = this.f18859f0;
        if (e12 != null) {
            e12.i(this);
            this.f18859f0 = null;
        }
        super.onDestroy();
    }

    @Override // F8.a, androidx.fragment.app.f, android.app.Activity
    public final void onPause() {
        super.onPause();
        com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "onPause");
    }

    @Override // android.app.Activity
    public final void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        com.oplus.melody.common.util.A.f("DiscoveryDialogActivity", "onRestoreInstanceState " + bundle);
        int i10 = this.f18854a0;
        if (i10 == 0) {
            this.f18854a0 = bundle.getInt("melodyCurrentState", i10);
            this.f18873t0 = bundle.getInt("melodyEntryComplete", this.f18873t0);
        }
    }

    @Override // F8.a, androidx.fragment.app.f, android.app.Activity
    public final void onResume() {
        super.onResume();
        com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", "onResume");
        MelodyVideoAnimationView melodyVideoAnimationView = this.f18864k0;
        if (melodyVideoAnimationView == null || melodyVideoAnimationView.getVisibility() != 0 || melodyVideoAnimationView.c() || this.f18877x0 <= 0) {
            return;
        }
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new C0868m(this, 0));
        melodyVideoAnimationView.g(this.f18877x0);
    }

    @Override // c.i, B.ActivityC0360h, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("melodyCurrentState", this.f18854a0);
        int i10 = this.f18873t0;
        if (i10 == 1) {
            bundle.putInt("melodyEntryComplete", 2);
        } else {
            bundle.putInt("melodyEntryComplete", i10);
        }
        DiscoveryRecycleAdapter discoveryRecycleAdapter = this.f18869p0;
        if (discoveryRecycleAdapter != null && discoveryRecycleAdapter.f18900d.size() > 0) {
            DiscoveryRecycleAdapter discoveryRecycleAdapter2 = this.f18869p0;
            discoveryRecycleAdapter2.getClass();
            bundle.putString("melodyLastItems", C0917x.i(new ArrayList(discoveryRecycleAdapter2.f18900d)));
        }
        com.oplus.melody.common.util.A.f("DiscoveryDialogActivity", "onSaveInstanceState " + bundle);
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onStart() {
        super.onStart();
        com.oplus.melody.model.scan.a aVarA = com.oplus.melody.model.scan.a.a();
        int iIncrementAndGet = aVarA.f20224c.incrementAndGet();
        aVarA.c(iIncrementAndGet);
        if (this.f18842F0) {
            E1 e12 = this.f18859f0;
            Handler handler = this.f18850W;
            RunnableC0857i runnableC0857i = this.f18852Y;
            if (e12 != null && e12.isShowing()) {
                com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new Ea.D(iIncrementAndGet, 14));
                handler.removeCallbacks(runnableC0857i);
            } else {
                com.oplus.melody.common.util.A.x("DiscoveryDialogActivity", "onStart dismiss count=" + iIncrementAndGet);
                handler.postDelayed(runnableC0857i, 300L);
            }
        }
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onStop() {
        super.onStop();
        com.oplus.melody.model.scan.a aVarA = com.oplus.melody.model.scan.a.a();
        int iDecrementAndGet = aVarA.f20224c.decrementAndGet();
        aVarA.c(iDecrementAndGet);
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new D7.Y(iDecrementAndGet, 23));
        if (!isFinishing()) {
            N("onStop");
        }
        int i10 = Q7.b.f4152c;
        Optional.ofNullable(b.a.a()).ifPresent(new N());
    }

    @Override // F8.a
    public final int z() {
        return R.layout.melody_app_activity_discovery_host;
    }
}
