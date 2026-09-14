package com.oplus.melody.app.discovery;

import D7.o0;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import com.heytap.headset.R;
import com.oplus.bluetooth.OplusA2dpSharingStateCallback;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.track.constant.AppConstant$DialogType;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import com.oplus.melody.ui.widget.MelodyCompatTextView;
import g0.C1064c;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import u8.C1557e;
import u8.C1558f;

/* JADX INFO: compiled from: DiscoveryViewStateReadyImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class z1 extends I0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RunnableC0857i f19241m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MelodyCompatButton f19242n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public MelodyCompatButton f19243o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MelodyCompatButton f19244p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f19245q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f19246r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ViewOnClickListenerC0865k1 f19247s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public RunnableC0885v f19248t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public U0 f19249u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public RunnableC0878r0 f19250v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f19251w;

    public z1(DiscoveryDialogActivity discoveryDialogActivity, int i10) {
        super(discoveryDialogActivity, i10);
        this.f19245q = true;
        this.f19246r = false;
        DiscoveryDialogActivity discoveryDialogActivity2 = this.f18929b;
        Objects.requireNonNull(discoveryDialogActivity2);
        this.f19241m = new RunnableC0857i(discoveryDialogActivity2, 2);
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final C1557e a(C1558f c1558f) {
        return c1558f.getReadyState();
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final void f(final E0 e02) {
        super.f(e02);
        CompletableFuture completableFutureSupplyAsync = CompletableFuture.supplyAsync(new C0843d0(1, e02, this), o0.c.f1145c);
        CompletableFuture<MelodyResourceDO> completableFutureC = c();
        BiFunction biFunction = new BiFunction() { // from class: com.oplus.melody.app.discovery.x1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                List list = (List) obj;
                MelodyResourceDO melodyResourceDO = (MelodyResourceDO) obj2;
                z1 z1Var = this.f19223a;
                z1Var.getClass();
                final E0 e03 = e02;
                final String name = e03.getName();
                final boolean zBooleanValue = ((Boolean) list.get(0)).booleanValue();
                final boolean zBooleanValue2 = ((Boolean) list.get(1)).booleanValue();
                com.oplus.melody.common.util.A.c("DiscoveryViewStateReadyImpl", new Supplier() { // from class: com.oplus.melody.app.discovery.q1
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return "onBindEarphone '" + com.oplus.melody.common.util.A.q(name) + "', shouldBindAccount=" + zBooleanValue + ", hasBindToOtherAccount=" + zBooleanValue2 + ", accountBindingState=" + e03.getAccountBindingState();
                    }
                });
                z1Var.f19245q = !zBooleanValue2;
                MelodyCompatTextView melodyCompatTextView = z1Var.f18931d;
                DiscoveryDialogActivity discoveryDialogActivity = z1Var.f18929b;
                DiscoveryDialogViewModel discoveryDialogViewModel = z1Var.f18930c;
                if (zBooleanValue && (discoveryDialogViewModel.k() || discoveryDialogViewModel.l())) {
                    if (zBooleanValue2) {
                        melodyCompatTextView.setText(discoveryDialogActivity.getString(R.string.melody_common_has_bind_other_account, name));
                    } else {
                        melodyCompatTextView.setText(discoveryDialogActivity.getString(R.string.melody_common_can_bind_account, name));
                    }
                } else if (zBooleanValue && zBooleanValue2 && discoveryDialogViewModel.m()) {
                    melodyCompatTextView.setMaxLines(1);
                    melodyCompatTextView.setText(discoveryDialogActivity.getString(R.string.melody_common_has_bind_other_account, name));
                } else {
                    if (melodyResourceDO != null && !TextUtils.isEmpty(melodyResourceDO.getText())) {
                        name = String.format(Locale.getDefault(), melodyResourceDO.getText(), name);
                    }
                    melodyCompatTextView.setText(name);
                }
                MelodyCompatTextView melodyCompatTextView2 = z1Var.f18932e;
                if (zBooleanValue) {
                    discoveryDialogActivity.c0(1);
                    if (discoveryDialogViewModel.m()) {
                        melodyCompatTextView2.setText(R.string.melody_common_binding_account_tips);
                        if (z1Var.f19246r) {
                            melodyCompatTextView2.setVisibility(0);
                        }
                        I0.p(melodyCompatTextView2);
                        z1Var.f19242n.setText(R.string.melody_app_discovery_connect);
                        z1Var.h = AppConstant$DialogType.CONNECT_BY_ACCOUNT;
                    } else if (discoveryDialogViewModel.k() || discoveryDialogViewModel.l()) {
                        melodyCompatTextView2.setVisibility(8);
                        z1Var.f19242n.setText(R.string.melody_common_bind_account_action);
                        z1Var.h = AppConstant$DialogType.BACK_CONNECT_BY_ACCOUNT;
                        Handler handler = discoveryDialogActivity.f18850W;
                        RunnableC0857i runnableC0857i = z1Var.f19241m;
                        handler.removeCallbacks(runnableC0857i);
                        handler.postDelayed(runnableC0857i, 5000L);
                    }
                } else {
                    melodyCompatTextView2.setVisibility(8);
                    z1Var.f19242n.setText(R.string.melody_app_discovery_connect);
                    z1Var.h = AppConstant$DialogType.NORMAL_CONNECT;
                }
                if (e03.getAccountBindingState() != 5) {
                    return null;
                }
                if (!discoveryDialogViewModel.l() && !discoveryDialogViewModel.k()) {
                    return null;
                }
                discoveryDialogActivity.O();
                return null;
            }
        };
        h0.l lVar = o0.c.f1144b;
        completableFutureSupplyAsync.thenCombineAsync((CompletionStage) completableFutureC, biFunction, (Executor) lVar).exceptionally((Function) new C0837b0(2));
        if (this.f18930c.m()) {
            CompletableFuture.supplyAsync(new D7.Q(12)).thenAcceptAsync(new Consumer() { // from class: com.oplus.melody.app.discovery.y1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Boolean bool = (Boolean) obj;
                    final z1 z1Var = this.f19232a;
                    DiscoveryDialogViewModel discoveryDialogViewModel = z1Var.f18930c;
                    discoveryDialogViewModel.getClass();
                    if (D7.m0.b() && discoveryDialogViewModel.f18892l == null) {
                        D0 d02 = new D0(discoveryDialogViewModel);
                        discoveryDialogViewModel.f18892l = d02;
                        Object value = D7.m0.f1129a.getValue();
                        if (value != null) {
                            D7.j0 j0VarF = D7.j0.f(value);
                            D7.i0[] i0VarArrA = D7.i0.a(new Class[]{Executor.class, OplusA2dpSharingStateCallback.class}, new Object[]{ForkJoinPool.commonPool(), d02});
                            com.oplus.melody.common.util.A.c("ShareAudioHelper", new D7.k0(j0VarF.d("registerStateCallback", (D7.i0[]) Arrays.copyOf(i0VarArrA, i0VarArrA.length)), 1));
                        }
                    }
                    boolean zBooleanValue = bool.booleanValue();
                    MelodyCompatButton melodyCompatButton = z1Var.f18938l;
                    if (!zBooleanValue) {
                        if (z1Var.f19244p != null) {
                            CharSequence text = z1Var.f19242n.getText();
                            z1Var.f19242n.setVisibility(8);
                            z1Var.f19242n = melodyCompatButton;
                            melodyCompatButton.setVisibility(0);
                            z1Var.f19242n.setText(text);
                            z1Var.f19242n.setOnClickListener(z1Var.f19247s);
                            z1Var.f19244p = null;
                            z1Var.o(z1Var.f19242n);
                            return;
                        }
                        return;
                    }
                    CharSequence text2 = z1Var.f19242n.getText();
                    MelodyCompatButton melodyCompatButton2 = z1Var.f18937k;
                    z1Var.f19242n = melodyCompatButton2;
                    melodyCompatButton2.setText(text2);
                    z1Var.f19242n.setOnClickListener(z1Var.f19247s);
                    z1Var.f19244p = melodyCompatButton;
                    melodyCompatButton.setText(R.string.melody_common_audio_share_btn_text);
                    MelodyCompatButton melodyCompatButton3 = z1Var.f19244p;
                    final E0 e03 = e02;
                    melodyCompatButton3.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.melody.app.discovery.r1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            z1 z1Var2 = z1Var;
                            z1Var2.getClass();
                            E0 e04 = e03;
                            com.oplus.melody.common.util.A.c("DiscoveryViewStateReadyImpl", new s1(e04, 0));
                            String id = e04.getId();
                            DiscoveryDialogViewModel discoveryDialogViewModel2 = z1Var2.f18930c;
                            discoveryDialogViewModel2.getClass();
                            AbstractC0939b.E().e(id);
                            if (com.oplus.melody.common.util.Y.k(I0.e(z1Var2.f18934g)) || e04.getPairingState() == 1) {
                                z1Var2.j(4);
                            } else {
                                z1Var2.j(3);
                            }
                            discoveryDialogViewModel2.j(e04.getId());
                        }
                    });
                    z1Var.f19242n.setVisibility(0);
                    z1Var.f19244p.setVisibility(0);
                    z1Var.o(z1Var.f19242n, z1Var.f19244p);
                }
            }, (Executor) lVar).exceptionally((Function<Throwable, ? extends Void>) new A6.i(26));
        }
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final CompletableFuture<Integer> g(int i10, C1 c12) {
        int i11 = 1;
        int i12 = 0;
        this.f19251w = false;
        this.f18936j.setOnClickListener(new u1(this, i12));
        MelodyCompatButton melodyCompatButton = this.f18938l;
        this.f19242n = melodyCompatButton;
        ViewOnClickListenerC0865k1 viewOnClickListenerC0865k1 = new ViewOnClickListenerC0865k1(this, 2);
        this.f19247s = viewOnClickListenerC0865k1;
        melodyCompatButton.setOnClickListener(viewOnClickListenerC0865k1);
        DiscoveryDialogViewModel discoveryDialogViewModel = this.f18930c;
        boolean zM = discoveryDialogViewModel.m();
        MelodyCompatButton melodyCompatButton2 = this.f18937k;
        if (!zM) {
            this.f19243o = melodyCompatButton2;
            melodyCompatButton2.setText(R.string.melody_app_discovery_done);
            this.f19243o.setOnClickListener(new ViewOnClickListenerC0856h1(this, 3));
        }
        C1557e c1557eB = b(c12);
        boolean z2 = c1557eB != null && Boolean.TRUE.equals(c1557eB.getShowCancelBesidePrimary()) && discoveryDialogViewModel.m();
        this.f19251w = z2;
        if (z2) {
            melodyCompatButton2.setText(R.string.melody_ui_common_cancel);
            melodyCompatButton2.setOnClickListener(new u1(this, i11));
            melodyCompatButton2.setVisibility(0);
            o(melodyCompatButton2, this.f19242n);
        } else {
            o(this.f19243o, this.f19242n);
        }
        long infoFadeInDelay = (c1557eB == null || c1557eB.getInfoFadeInDelay() <= 0) ? 0L : c1557eB.getInfoFadeInDelay();
        long titleFadeInDelay = infoFadeInDelay;
        if (c1557eB != null && c1557eB.getBtnFadeInDelay() > 0) {
            infoFadeInDelay = c1557eB.getBtnFadeInDelay();
        }
        if (c1557eB != null && c1557eB.getTitleFadeInDelay() > 0) {
            titleFadeInDelay = c1557eB.getTitleFadeInDelay();
        }
        long imageFadeInDelay = (c1557eB == null || c1557eB.getImageFadeInDelay() <= 0) ? 0L : c1557eB.getImageFadeInDelay();
        DiscoveryDialogActivity discoveryDialogActivity = this.f18929b;
        if (infoFadeInDelay <= 0 && titleFadeInDelay <= 0 && imageFadeInDelay <= 0) {
            if (discoveryDialogActivity.f18845I0) {
                m(c12, true);
            }
            return this.f19251w ? super.g(i10, c12).thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new C0884u0(this, i10, 2)).whenComplete((BiConsumer<? super U, ? super Throwable>) new w1(this, i12)) : super.g(i10, c12).thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new t1(this, i10, 1)).whenComplete((BiConsumer<? super U, ? super Throwable>) new v1(this, i12));
        }
        RunnableC0885v runnableC0885v = this.f19248t;
        if (runnableC0885v != null) {
            discoveryDialogActivity.f18850W.removeCallbacks(runnableC0885v);
        }
        RunnableC0885v runnableC0885v2 = new RunnableC0885v(this, 2);
        this.f19248t = runnableC0885v2;
        if (infoFadeInDelay > 0) {
            if (this.f19251w) {
                J6.d.f(0, 4, melodyCompatButton2, this.f19242n, this.f19243o);
            } else {
                J6.d.f(0, 4, this.f19242n, this.f19243o);
            }
            discoveryDialogActivity.f18850W.postDelayed(this.f19248t, infoFadeInDelay);
        } else {
            runnableC0885v2.run();
        }
        U0 u02 = this.f19249u;
        if (u02 != null) {
            discoveryDialogActivity.f18850W.removeCallbacks(u02);
        }
        U0 u03 = new U0(this, 2);
        this.f19249u = u03;
        if (titleFadeInDelay > 0) {
            J6.d.f(0, 8, this.f18931d, this.f18932e);
            discoveryDialogActivity.f18850W.postDelayed(this.f19249u, titleFadeInDelay);
        } else {
            u03.run();
        }
        RunnableC0878r0 runnableC0878r0 = this.f19250v;
        if (runnableC0878r0 != null) {
            discoveryDialogActivity.f18850W.removeCallbacks(runnableC0878r0);
        }
        RunnableC0878r0 runnableC0878r02 = new RunnableC0878r0(2, this, c12);
        this.f19250v = runnableC0878r02;
        if (imageFadeInDelay > 0) {
            discoveryDialogActivity.f18850W.postDelayed(runnableC0878r02, imageFadeInDelay);
        } else if (discoveryDialogActivity.f18845I0) {
            m(c12, true);
        }
        if (com.oplus.melody.common.util.A.l()) {
            StringBuilder sbC = C1064c.c("onEnter with delay btnDelayMillis:", infoFadeInDelay, " titleDelayMillis:");
            sbC.append(titleFadeInDelay);
            sbC.append(" imageFadeInDelayMillis:");
            sbC.append(imageFadeInDelay);
            com.oplus.melody.common.util.A.b("DiscoveryViewStateReadyImpl", sbC.toString());
        }
        return super.g(i10, c12);
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final CompletableFuture<Integer> h(int i10) {
        Handler handler = this.f18929b.f18850W;
        RunnableC0885v runnableC0885v = this.f19248t;
        if (runnableC0885v != null) {
            handler.removeCallbacks(runnableC0885v);
        }
        U0 u02 = this.f19249u;
        if (u02 != null) {
            handler.removeCallbacks(u02);
        }
        RunnableC0878r0 runnableC0878r0 = this.f19250v;
        if (runnableC0878r0 != null) {
            handler.removeCallbacks(runnableC0878r0);
        }
        return super.h(i10).thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new t1(this, i10, 0));
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final void m(C1 c12, boolean z2) {
        int i10 = 1;
        super.m(c12, z2);
        if (z2) {
            DiscoveryDialogActivity discoveryDialogActivity = this.f18929b;
            if (discoveryDialogActivity.f18873t0 == 0) {
                discoveryDialogActivity.f18873t0 = 1;
                discoveryDialogActivity.f18863j0.setVisibility(0);
                if (discoveryDialogActivity.f18878y0) {
                    J6.d.d(267, Collections.singletonList(discoveryDialogActivity.f18863j0)).whenComplete((BiConsumer) new v1(this, i10));
                    return;
                }
                ViewGroup viewGroup = discoveryDialogActivity.f18863j0;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroup, (Property<ViewGroup, Float>) View.SCALE_X, 0.8f, 1.0f);
                objectAnimatorOfFloat.setInterpolator(new PathInterpolator(0.4f, 0.01f, 0.2f, 1.01f));
                long j5 = 267;
                objectAnimatorOfFloat.setDuration(j5);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewGroup, (Property<ViewGroup, Float>) View.SCALE_Y, 0.8f, 1.0f);
                objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.4f, 0.01f, 0.2f, 1.01f));
                objectAnimatorOfFloat2.setDuration(j5);
                ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(viewGroup, (Property<ViewGroup, Float>) View.ALPHA, 0.0f, 1.0f);
                objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.0f, 1.0f));
                objectAnimatorOfFloat3.setDuration(j5);
                viewGroup.setVisibility(4);
                AnimatorSet animatorSet = new AnimatorSet();
                Ca.a aVar = new Ca.a(animatorSet);
                objectAnimatorOfFloat3.addListener(new J6.g(viewGroup, aVar));
                animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
                animatorSet.setStartDelay(j5);
                animatorSet.start();
                aVar.whenComplete((BiConsumer) new w1(this, i10));
            }
        }
    }
}
