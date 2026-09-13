package com.oplus.melody.app.discovery;

import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.headset.R;
import com.oplus.melody.alive.component.health.module.HealthCalibrationModule;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.RunnableC0903i;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.track.constant.AppConstant$ConnectResult;
import com.oplus.melody.track.constant.AppConstant$DialogType;
import com.oplus.melody.track.constant.AppConstant$UserAction;
import com.oplus.melody.track.track.Track;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import com.oplus.melody.ui.widget.MelodyCompatTextView;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import org.json.JSONException;
import s8.AbstractC1508a;
import t8.C1532B;
import u8.C1557e;
import u8.C1558f;

/* JADX INFO: compiled from: DiscoveryViewStateBase.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class I0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DiscoveryDialogActivity f18929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DiscoveryDialogViewModel f18930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MelodyCompatTextView f18931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MelodyCompatTextView f18932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MelodyCompatTextView f18933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public E0 f18934g;
    public AppConstant$DialogType h = AppConstant$DialogType.NORMAL_CONNECT;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AppConstant$ConnectResult f18935i = AppConstant$ConnectResult.SUCCESS;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f18936j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MelodyCompatButton f18937k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MelodyCompatButton f18938l;

    public I0(DiscoveryDialogActivity discoveryDialogActivity, int i10) {
        this.f18929b = discoveryDialogActivity;
        this.f18928a = i10;
        DiscoveryDialogViewModel discoveryDialogViewModel = discoveryDialogActivity.f18853Z;
        this.f18930c = discoveryDialogViewModel;
        View view = discoveryDialogActivity.f18865l0;
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.melody_app_close_dialog);
        this.f18936j = appCompatTextView;
        this.f18937k = (MelodyCompatButton) view.findViewById(R.id.melody_app_discovery_btn_left);
        this.f18938l = (MelodyCompatButton) view.findViewById(R.id.melody_app_discovery_btn_right);
        this.f18931d = (MelodyCompatTextView) view.findViewById(R.id.melody_app_discovery_tv_title);
        this.f18932e = (MelodyCompatTextView) view.findViewById(R.id.melody_app_discovery_tv_tips);
        this.f18933f = (MelodyCompatTextView) view.findViewById(R.id.melody_app_discovery_text_intro);
        appCompatTextView.setVisibility(discoveryDialogViewModel.m() ? 0 : 8);
    }

    public static WhitelistConfigDTO e(E0 e02) {
        if (e02 == null) {
            return null;
        }
        return AbstractC1508a.f().c(e02.getProductId(), e02.getName());
    }

    public static void p(TextView textView) {
        int i10 = textView.getLineCount() > 1 ? 8388659 : 49;
        textView.setGravity(i10);
        if (com.oplus.melody.common.util.A.l()) {
            com.oplus.melody.common.util.A.b("DiscoveryViewState", "updateTipsGravity " + i10);
        }
    }

    public abstract C1557e a(C1558f c1558f);

    public final C1557e b(C1 c12) {
        C1558f discoveryStates;
        if (c12 == null || (discoveryStates = c12.getDiscoveryStates()) == null) {
            return null;
        }
        return a(discoveryStates);
    }

    public final CompletableFuture<MelodyResourceDO> c() {
        return this.f18929b.T().thenApply((Function<? super C1, ? extends U>) new C0886v0(this, 1)).exceptionally((Function<Throwable, ? extends U>) new C0867l0(3));
    }

    public final E0 d() {
        E0 e02 = this.f18934g;
        return e02 == null ? this.f18929b.S() : e02;
    }

    public void f(E0 e02) {
        if (com.oplus.melody.common.util.A.l()) {
            com.oplus.melody.common.util.A.b("DiscoveryViewState", getClass().getSimpleName() + ".onBindEarphone " + e02);
        }
        this.f18934g = e02;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public CompletableFuture<Integer> g(int i10, C1 c12) {
        Boolean forceDarkAllowed;
        C1558f discoveryStates = c12.getDiscoveryStates();
        AppCompatTextView appCompatTextView = this.f18936j;
        if (discoveryStates == null || !Boolean.TRUE.equals(discoveryStates.getHideCloseButton())) {
            appCompatTextView.setVisibility(this.f18930c.m() ? 0 : 8);
        } else {
            appCompatTextView.setVisibility(8);
        }
        C1558f discoveryStates2 = c12.getDiscoveryStates();
        int i11 = Build.VERSION.SDK_INT;
        DiscoveryDialogActivity discoveryDialogActivity = this.f18929b;
        if (i11 >= 29 && discoveryStates2 != null && (forceDarkAllowed = discoveryStates2.getForceDarkAllowed()) != null) {
            com.oplus.melody.common.util.A.c("DiscoveryViewState", new D(2, forceDarkAllowed, discoveryStates2));
            discoveryDialogActivity.f18865l0.setForceDarkAllowed(forceDarkAllowed.booleanValue());
        }
        boolean z2 = c12.getStrangeRes() != null;
        boolean z4 = discoveryDialogActivity.f18845I0 && !z2;
        MelodyCompatTextView melodyCompatTextView = this.f18932e;
        MelodyCompatTextView melodyCompatTextView2 = this.f18931d;
        if (z4) {
            melodyCompatTextView2.setTextColor(discoveryDialogActivity.getColorStateList(R.color.melody_app_discovery_title_text_color));
            melodyCompatTextView.setTextColor(discoveryDialogActivity.getColorStateList(R.color.melody_ui_common_text_color_summary));
        }
        CompletableFuture<Integer> completableFutureCompletedFuture = CompletableFuture.completedFuture(0);
        C1557e c1557eB = b(c12);
        if (c1557eB != null && !z4 && (!discoveryDialogActivity.f18878y0 || z2)) {
            MelodyResourceDO titleRes = c1557eB.getTitleRes();
            if (titleRes != null) {
                ConcurrentHashMap concurrentHashMap = C1532B.f27917a;
                Integer numC = C1532B.c(discoveryDialogActivity, titleRes.getTextColor(), titleRes.getTextColorNight());
                if (numC != null) {
                    melodyCompatTextView2.setTextColor(numC.intValue());
                    int iAlpha = Color.alpha(melodyCompatTextView.getCurrentTextColor());
                    int iAlpha2 = Color.alpha(melodyCompatTextView2.getCurrentTextColor());
                    if (iAlpha2 > 0) {
                        iAlpha = (Color.alpha(numC.intValue()) * iAlpha) / iAlpha2;
                    }
                    melodyCompatTextView.setTextColor(Color.argb(iAlpha, Color.red(numC.intValue()), Color.green(numC.intValue()), Color.blue(numC.intValue())));
                }
                if (titleRes.getTextSize() != null) {
                    melodyCompatTextView2.setTextSize(0, C1532B.g(discoveryDialogActivity, 0, titleRes.getTextSize()));
                }
                if (titleRes.getTop() != null) {
                    ConstraintLayout.a aVar = (ConstraintLayout.a) melodyCompatTextView2.getLayoutParams();
                    if (aVar.topToTop != 0 || aVar.topToBottom != -1) {
                        aVar.topToTop = 0;
                        aVar.topToBottom = -1;
                        melodyCompatTextView2.setLayoutParams(aVar);
                    }
                    ConstraintLayout.a aVar2 = (ConstraintLayout.a) melodyCompatTextView.getLayoutParams();
                    if (aVar2.bottomToBottom != -1 || aVar2.topToBottom != -1) {
                        aVar2.bottomToTop = -1;
                        aVar2.bottomToBottom = -1;
                        melodyCompatTextView.setLayoutParams(aVar2);
                    }
                    C1532B.f(titleRes, melodyCompatTextView2, discoveryDialogActivity.f18865l0);
                }
            }
            MelodyResourceDO btnPrimaryRes = c1557eB.getBtnPrimaryRes();
            if (btnPrimaryRes != null) {
                String textSize = btnPrimaryRes.getTextSize();
                MelodyCompatButton melodyCompatButton = this.f18938l;
                if (textSize != null) {
                    melodyCompatButton.setTextSize(0, C1532B.g(discoveryDialogActivity, 0, btnPrimaryRes.getTextSize()));
                }
                ConcurrentHashMap concurrentHashMap2 = C1532B.f27917a;
                Integer numC2 = C1532B.c(discoveryDialogActivity, btnPrimaryRes.getTextColor(), btnPrimaryRes.getTextColorNight());
                if (numC2 != null) {
                    melodyCompatButton.setTextColor(numC2.intValue());
                }
                Integer numC3 = C1532B.c(discoveryDialogActivity, btnPrimaryRes.getForegroundColor(), btnPrimaryRes.getForegroundColorNight());
                if (numC3 != null) {
                    melodyCompatButton.setDrawableColor(numC3.intValue());
                }
            }
            MelodyResourceDO btnSecondaryRes = c1557eB.getBtnSecondaryRes();
            if (btnSecondaryRes != null) {
                String textSize2 = btnSecondaryRes.getTextSize();
                MelodyCompatButton melodyCompatButton2 = this.f18937k;
                if (textSize2 != null) {
                    melodyCompatButton2.setTextSize(0, C1532B.g(discoveryDialogActivity, 0, btnSecondaryRes.getTextSize()));
                }
                ConcurrentHashMap concurrentHashMap3 = C1532B.f27917a;
                Integer numC4 = C1532B.c(discoveryDialogActivity, btnSecondaryRes.getTextColor(), btnSecondaryRes.getTextColorNight());
                if (numC4 != null) {
                    melodyCompatButton2.setTextColor(numC4.intValue());
                }
                Integer numC5 = C1532B.c(discoveryDialogActivity, btnSecondaryRes.getForegroundColor(), btnSecondaryRes.getForegroundColorNight());
                if (numC5 != null) {
                    melodyCompatButton2.setDrawableColor(numC5.intValue());
                }
            }
        }
        return completableFutureCompletedFuture;
    }

    public CompletableFuture<Integer> h(int i10) {
        return CompletableFuture.completedFuture(8);
    }

    public final void i(Runnable runnable) {
        DiscoveryDialogActivity discoveryDialogActivity = this.f18929b;
        if ("onPreviewPopup".equals(discoveryDialogActivity.f18838B0)) {
            discoveryDialogActivity.N("preview");
        } else {
            runnable.run();
        }
    }

    public final void j(int i10) {
        DiscoveryDialogActivity discoveryDialogActivity = this.f18929b;
        E0 e0S = discoveryDialogActivity.S();
        if (e0S == null) {
            return;
        }
        DiscoveryDialogViewModel discoveryDialogViewModel = discoveryDialogActivity.f18853Z;
        String id = e0S.getId();
        discoveryDialogViewModel.getClass();
        discoveryDialogViewModel.o(id, new C0869m0(i10, id, this.f18928a));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m(com.oplus.melody.app.discovery.C1 r17, boolean r18) {
        /*
            Method dump skipped, instruction units count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.app.discovery.I0.m(com.oplus.melody.app.discovery.C1, boolean):void");
    }

    public final void n(final AppConstant$UserAction appConstant$UserAction) {
        if (this.h == null || this.f18935i == null) {
            com.oplus.melody.common.util.A.x("DiscoveryViewState", "trackConnectResult mDialogType = " + this.h + ", mConnectResult = " + this.f18935i);
            return;
        }
        E0 e0D = d();
        if (e0D == null || TextUtils.isEmpty(e0D.getId()) || this.f18929b == null || this.f18930c == null) {
            return;
        }
        final String productId = e0D.getProductId();
        final String id = e0D.getId();
        final String strT = com.oplus.melody.model.repository.earphone.N.t(AbstractC0939b.E().w(e0D.getId()));
        final AppConstant$DialogType dialogType = this.h;
        final AppConstant$ConnectResult result = this.f18935i;
        kotlin.jvm.internal.h.e(dialogType, "dialogType");
        kotlin.jvm.internal.h.e(result, "result");
        if (TextUtils.isEmpty(productId) || !B8.a.d(productId, id)) {
            A6.b.g("trackDiscoveryDialogConnectResult, someone is null, earbudsId: ", productId, "AppTrackHelper");
            return;
        }
        ForkJoinPool.commonPool().execute(new RunnableC0903i(16, new Wb.l() { // from class: z8.n
            @Override // Wb.l
            public final Object d(Object obj) throws JSONException {
                Track it = (Track) obj;
                kotlin.jvm.internal.h.e(it, "it");
                it.a(Integer.valueOf(dialogType.getDialogType()), "dialog_type");
                it.a(Integer.valueOf(appConstant$UserAction.getUserAction()), "user_action");
                it.a(Integer.valueOf(result.getResult()), HealthCalibrationModule.KEY_RESULT);
                it.a(productId, "earbuds_id");
                it.a(B8.a.c(id), "earbuds_addr_id");
                it.a(g0.f.a(it, "earbuds_version", strT, "device_id", "os_version"), "app_version");
                it.d();
                return Jb.l.f2618a;
            }
        }, new Track("melody_discovery_dialog_connect_result", "10610001")));
    }

    public final void o(View... viewArr) {
        MelodyCompatButton melodyCompatButton;
        MelodyCompatButton melodyCompatButton2;
        int length = viewArr.length;
        int i10 = 0;
        boolean z2 = false;
        boolean z4 = false;
        while (true) {
            melodyCompatButton = this.f18938l;
            melodyCompatButton2 = this.f18937k;
            if (i10 >= length) {
                break;
            }
            View view = viewArr[i10];
            if (view == melodyCompatButton2) {
                z2 = true;
            } else if (view == melodyCompatButton) {
                z4 = true;
            }
            i10++;
        }
        DiscoveryDialogActivity discoveryDialogActivity = this.f18929b;
        if (z2 && z4) {
            int dimensionPixelOffset = discoveryDialogActivity.getResources().getDimensionPixelOffset(R.dimen.melody_ui_horizontal_multi_btn_outside_margin);
            int dimensionPixelOffset2 = discoveryDialogActivity.getResources().getDimensionPixelOffset(R.dimen.melody_ui_horizontal_multi_btn_inside_margin);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) melodyCompatButton2.getLayoutParams();
            marginLayoutParams.setMarginStart(dimensionPixelOffset);
            marginLayoutParams.setMarginEnd(0);
            melodyCompatButton2.setLayoutParams(marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) melodyCompatButton.getLayoutParams();
            marginLayoutParams2.setMarginStart(dimensionPixelOffset2);
            marginLayoutParams2.setMarginEnd(dimensionPixelOffset);
            melodyCompatButton.setLayoutParams(marginLayoutParams2);
            return;
        }
        if (z2) {
            int dimensionPixelOffset3 = discoveryDialogActivity.getResources().getDimensionPixelOffset(R.dimen.melody_ui_horizontal_single_btn_margin);
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) melodyCompatButton2.getLayoutParams();
            marginLayoutParams3.setMarginStart(dimensionPixelOffset3);
            marginLayoutParams3.setMarginEnd(dimensionPixelOffset3);
            melodyCompatButton2.setLayoutParams(marginLayoutParams3);
            return;
        }
        if (z4) {
            int dimensionPixelOffset4 = discoveryDialogActivity.getResources().getDimensionPixelOffset(R.dimen.melody_ui_horizontal_single_btn_margin);
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) melodyCompatButton.getLayoutParams();
            marginLayoutParams4.setMarginStart(dimensionPixelOffset4);
            marginLayoutParams4.setMarginEnd(dimensionPixelOffset4);
            melodyCompatButton.setLayoutParams(marginLayoutParams4);
        }
    }

    public final String toString() {
        return "DiscoveryViewState-" + this.f18928a;
    }

    public void k(C1 c12) {
    }

    public void l(C1 c12) {
    }
}
