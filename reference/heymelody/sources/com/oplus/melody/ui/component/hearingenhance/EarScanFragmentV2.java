package com.oplus.melody.ui.component.hearingenhance;

import D7.o0;
import E9.q;
import Ea.DialogInterfaceOnClickListenerC0412v;
import Ea.F;
import F8.c;
import L8.DialogInterfaceOnDismissListenerC0457d;
import Wb.l;
import X.d;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.f;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import com.coui.appcompat.tips.def.COUIDefaultTopTips;
import com.heytap.headset.R;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0909o;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.U;
import com.oplus.melody.model.db.C0928l;
import com.oplus.melody.model.repository.earphone.C0940c;
import com.oplus.melody.model.repository.earphone.C0941d;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.model.repository.hearingenhance.EarScanResultDTO;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import ea.C1023b;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import la.C1288a;
import la.C1296i;
import la.DialogInterfaceOnClickListenerC1289b;
import o8.AbstractC1382a;

/* JADX INFO: compiled from: EarScanFragmentV2.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001]B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010(\u001a\u0004\u0018\u00010\u00172\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001a\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u00102\u001a\u0002002\u0006\u00101\u001a\u00020\u0017H\u0002J\u0010\u00103\u001a\u0002002\u0006\u00101\u001a\u00020\u0017H\u0002J\b\u00104\u001a\u000200H\u0002J\u0006\u00105\u001a\u000200J\b\u00106\u001a\u000200H\u0002J\b\u00109\u001a\u000200H\u0002J\u0010\u0010:\u001a\u0002002\u0006\u0010;\u001a\u00020\bH\u0002J\b\u0010<\u001a\u000200H\u0002J\b\u0010=\u001a\u000200H\u0002J\u0010\u0010>\u001a\u0002002\u0006\u0010?\u001a\u00020\bH\u0002J\b\u0010@\u001a\u000200H\u0002J\b\u0010A\u001a\u000200H\u0002J\u0010\u0010B\u001a\u0002002\u0006\u0010C\u001a\u00020\u000bH\u0002J\u0012\u0010D\u001a\u0002002\b\u0010E\u001a\u0004\u0018\u00010FH\u0002J\u0012\u0010G\u001a\u0002002\b\u0010H\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010I\u001a\u0002002\u0006\u0010J\u001a\u00020\bH\u0002J\b\u0010K\u001a\u000200H\u0002J\u0010\u0010L\u001a\u0002002\u0006\u0010C\u001a\u00020\u000bH\u0002J\u0010\u0010M\u001a\u0002002\u0006\u0010N\u001a\u00020\bH\u0002J\u0010\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010T\u001a\u0002002\u0006\u0010U\u001a\u00020\u0019H\u0002J\b\u0010V\u001a\u000200H\u0002J\u0006\u0010W\u001a\u000200J\u0006\u0010X\u001a\u000200J\b\u0010Y\u001a\u000200H\u0016J\b\u0010Z\u001a\u000200H\u0016J\u0012\u0010[\u001a\u0002002\b\u0010\\\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0SX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/oplus/melody/ui/component/hearingenhance/EarScanFragmentV2;", "Lcom/oplus/melody/ui/base/BaseFragment;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "mActivity", "Lcom/oplus/melody/ui/component/hearingenhance/HearingEnhancementActivity;", "mDetectionId", "", "mSetCommandFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "mViewModel", "Lcom/oplus/melody/ui/component/hearingenhance/HearingEnhancementViewModel;", "mContinueBtn", "Landroid/widget/Button;", "mScanTitle", "Landroid/widget/TextView;", "mScanTips", "mTvTip", "Lcom/coui/appcompat/tips/def/COUIDefaultTopTips;", "mEarStatusTips", "mTopPanel", "Landroid/view/View;", "mClickable", "", "mPrecessAlertDialog", "Landroidx/appcompat/app/AlertDialog;", "mEarScanResultDTO", "Lcom/oplus/melody/model/repository/hearingenhance/EarScanResultDTO;", "mStatusInfoLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/oplus/melody/model/repository/earphone/EarStatusDTO;", "mPositiveButton", "mWearPositiveButton", "mConfirmDialog", "mConfirmDialogBuilder", "Lcom/oplus/melody/common/widget/MelodyAlertDialogBuilder;", "mWearStateDialog", "mWearStateDialogBuilder", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "initToolBar", "initData", "startEarScan", "stopEarScan", "mCountDownTimer", "Landroid/os/CountDownTimer;", "earScanComplete", "earScanStatus", "errorCode", "detectOverTime", "detectCustomError", "showConfirmDialog", "titleId", "musicOrCallInterrupt", "wearStatusInterrupt", "earScanCallback", "setCommandState", "onEarScanStatus", "earScanStatusDTO", "Lcom/oplus/melody/model/repository/hearingenhance/EarScanStatusDTO;", "onEarScanResult", "earScanResultDTO", "onConnectStateChanged", "connectState", "startHearingEnhancementDetection", "startHearingEnhancementDetectionCallback", "dealProcessError", ClientDataEntity.COL_STATUS, "showErrorAlert", "title", "", "mStatusInfoObserver", "Landroidx/lifecycle/Observer;", "showNoisyTips", "show", "resumeScan", "exitScan", "cancel", "onResume", "onDestroy", "onClick", "v", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EarScanFragmentV2 extends c implements View.OnClickListener {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public f f21544A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public EarScanResultDTO f21545B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public t f21546C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public Button f21547D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public Button f21548E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public f f21549F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public G7.b f21550G;
    public f H;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HearingEnhancementActivity f21553p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f21555r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public HearingEnhancementViewModel f21556s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Button f21557t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f21558u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f21559v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public COUIDefaultTopTips f21560w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f21561x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f21562y;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f21554q = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f21563z = true;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final a f21551I = new a();

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final C1023b f21552J = new C1023b(this, 6);

    /* JADX INFO: compiled from: EarScanFragmentV2.kt */
    public static final class b implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctionReferenceImpl f21565a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(l lVar) {
            this.f21565a = (FunctionReferenceImpl) lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21565a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [Wb.l, kotlin.jvm.internal.FunctionReferenceImpl] */
        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21565a.d(obj);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View v5) {
        CompletableFuture<Void> completableFutureThenAccept;
        Integer numValueOf = v5 != null ? Integer.valueOf(v5.getId()) : null;
        if (numValueOf != null && numValueOf.intValue() == R.id.button_continue) {
            A.c("EarScanFragmentV2", new com.oplus.melody.ui.component.detail.zenmode.scene.a(this, 13));
            if (this.f21563z) {
                this.f21563z = false;
                CompletableFuture<SetCommandStateDTO> completableFuture = this.f21555r;
                if (completableFuture != null) {
                    completableFuture.cancel(true);
                }
                HearingEnhancementViewModel hearingEnhancementViewModel = this.f21556s;
                if (hearingEnhancementViewModel == null) {
                    h.i("mViewModel");
                    throw null;
                }
                CompletableFuture<SetCommandStateDTO> completableFutureB = com.oplus.melody.model.repository.hearingenhance.a.o().b(0, this.f21554q, hearingEnhancementViewModel.f21582c);
                this.f21555r = completableFutureB;
                if (completableFutureB == null || (completableFutureThenAccept = completableFutureB.thenAccept(new Consumer() { // from class: com.oplus.melody.ui.component.hearingenhance.a
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        CompletableFuture<Void> completableFutureThenAcceptAsync;
                        SetCommandStateDTO setCommandState = (SetCommandStateDTO) obj;
                        h.e(setCommandState, "setCommandState");
                        if (setCommandState.getSetCommandStatus() != 0) {
                            A.h("EarScanFragmentV2", "stopEarScan send, setCommandState:" + A.e(setCommandState));
                            return;
                        }
                        A.b("EarScanFragmentV2", "stopEarScan success，startHearingEnhancementDetection");
                        EarScanFragmentV2 earScanFragmentV2 = this.f21585a;
                        HearingEnhancementViewModel hearingEnhancementViewModel2 = earScanFragmentV2.f21556s;
                        if (hearingEnhancementViewModel2 == null) {
                            h.i("mViewModel");
                            throw null;
                        }
                        CompletableFuture completableFutureG = HearingEnhancementViewModel.g(1, hearingEnhancementViewModel2.f21582c);
                        if (completableFutureG == null || (completableFutureThenAcceptAsync = completableFutureG.thenAcceptAsync((Consumer) new G8.h(new EarScanFragmentV2$startHearingEnhancementDetection$1$1(1, earScanFragmentV2, EarScanFragmentV2.class, "startHearingEnhancementDetectionCallback", "startHearingEnhancementDetectionCallback(Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;)V", 0), 14), (Executor) o0.c.f1144b)) == null) {
                            return;
                        }
                        completableFutureThenAcceptAsync.exceptionally((Function<Throwable, ? extends Void>) new Aa.c(earScanFragmentV2, 19));
                    }
                })) == null) {
                    return;
                }
                completableFutureThenAccept.exceptionally((Function<Throwable, ? extends Void>) new C0941d(22));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.melody_ui_fragment_hearing_enhancement_ear_scan_v2, container, false);
        h.d(viewInflate, "inflate(...)");
        A.b("EarScanFragmentV2", "onCreateView");
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.f21556s == null) {
            h.i("mViewModel");
            throw null;
        }
        com.oplus.melody.model.repository.hearingenhance.a.o().z();
        r();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f21563z = true;
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (this.f21553p == null) {
            androidx.fragment.app.f activity = getActivity();
            h.c(activity, "null cannot be cast to non-null type com.oplus.melody.ui.component.hearingenhance.HearingEnhancementActivity");
            this.f21553p = (HearingEnhancementActivity) activity;
        }
        HearingEnhancementActivity hearingEnhancementActivity = this.f21553p;
        h.b(hearingEnhancementActivity);
        C0909o.h(hearingEnhancementActivity, hearingEnhancementActivity.getColor(R.color.melody_ui_hearing_enhancement_bg));
        HearingEnhancementActivity hearingEnhancementActivity2 = this.f21553p;
        h.b(hearingEnhancementActivity2);
        C0909o.g(hearingEnhancementActivity2, hearingEnhancementActivity2.getColor(R.color.melody_ui_hearing_enhancement_bg));
        View viewFindViewById = view.findViewById(R.id.toolbar);
        h.d(viewFindViewById, "findViewById(...)");
        MelodyCompatToolbar melodyCompatToolbar = (MelodyCompatToolbar) viewFindViewById;
        HearingEnhancementActivity hearingEnhancementActivity3 = this.f21553p;
        h.c(hearingEnhancementActivity3, "null cannot be cast to non-null type com.oplus.melody.ui.component.hearingenhance.HearingEnhancementActivity");
        melodyCompatToolbar.setTitle(hearingEnhancementActivity3.O());
        HearingEnhancementActivity hearingEnhancementActivity4 = this.f21553p;
        h.b(hearingEnhancementActivity4);
        melodyCompatToolbar.setBackgroundColor(hearingEnhancementActivity4.getColor(R.color.melody_ui_hearing_enhancement_bg));
        HearingEnhancementActivity hearingEnhancementActivity5 = this.f21553p;
        h.c(hearingEnhancementActivity5, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        hearingEnhancementActivity5.y(melodyCompatToolbar);
        HearingEnhancementActivity hearingEnhancementActivity6 = this.f21553p;
        h.c(hearingEnhancementActivity6, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        androidx.appcompat.app.a aVarX = hearingEnhancementActivity6.x();
        if (aVarX != null) {
            aVarX.n(true);
            aVarX.r(true);
        }
        View viewFindViewById2 = view.findViewById(R.id.button_continue);
        h.d(viewFindViewById2, "findViewById(...)");
        Button button = (Button) viewFindViewById2;
        this.f21557t = button;
        button.setOnClickListener(this);
        View viewFindViewById3 = view.findViewById(R.id.scan_title);
        h.d(viewFindViewById3, "findViewById(...)");
        this.f21558u = (TextView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.scan_tips);
        h.d(viewFindViewById4, "findViewById(...)");
        this.f21559v = (TextView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.top_tips);
        h.d(viewFindViewById5, "findViewById(...)");
        COUIDefaultTopTips cOUIDefaultTopTips = (COUIDefaultTopTips) viewFindViewById5;
        this.f21560w = cOUIDefaultTopTips;
        cOUIDefaultTopTips.setTipsText(getResources().getString(R.string.melody_ui_hearing_enhancement_noisy_tips));
        COUIDefaultTopTips cOUIDefaultTopTips2 = this.f21560w;
        if (cOUIDefaultTopTips2 == null) {
            h.i("mTvTip");
            throw null;
        }
        cOUIDefaultTopTips2.setTipsTextColor(cOUIDefaultTopTips2.getContext().getColor(R.color.coui_color_label_theme_red));
        COUIDefaultTopTips cOUIDefaultTopTips3 = this.f21560w;
        if (cOUIDefaultTopTips3 == null) {
            h.i("mTvTip");
            throw null;
        }
        cOUIDefaultTopTips3.setStartIcon(cOUIDefaultTopTips3.getContext().getDrawable(R.drawable.melody_ui_ic_information_grey));
        COUIDefaultTopTips cOUIDefaultTopTips4 = this.f21560w;
        if (cOUIDefaultTopTips4 == null) {
            h.i("mTvTip");
            throw null;
        }
        cOUIDefaultTopTips4.setCloseDrawable(cOUIDefaultTopTips4.getContext().getDrawable(R.drawable.coui_ic_toptips_close));
        COUIDefaultTopTips cOUIDefaultTopTips5 = this.f21560w;
        if (cOUIDefaultTopTips5 == null) {
            h.i("mTvTip");
            throw null;
        }
        cOUIDefaultTopTips5.setCloseBtnListener(new F(this, 14));
        View viewFindViewById6 = view.findViewById(R.id.top_panel);
        h.d(viewFindViewById6, "findViewById(...)");
        this.f21562y = viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.ear_status_tips);
        h.d(viewFindViewById7, "findViewById(...)");
        this.f21561x = (TextView) viewFindViewById7;
        ImageView imageView = (ImageView) view.findViewById(R.id.ear_tag);
        if (imageView != null) {
            imageView.setImageResource(R.drawable.melody_ui_gold_hearing_detect_ear_tag);
        }
        TextView textView = (TextView) view.findViewById(R.id.ear_tag_text);
        if (textView != null) {
            Resources resources = getResources();
            Context context = getContext();
            textView.setTextColor(resources.getColor(R.color.melody_ui_iot_color_black, context != null ? context.getTheme() : null));
        }
        ImageView imageView2 = (ImageView) view.findViewById(R.id.tag_running);
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.melody_ui_gold_hearing_detect_ear_tag_running);
        }
        ImageView imageView3 = (ImageView) view.findViewById(R.id.hearing_tag);
        if (imageView3 != null) {
            imageView3.setImageResource(R.drawable.melody_ui_gold_hearing_detect_hearing_tag_grey);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.hearing_tag_text);
        if (textView2 != null) {
            Resources resources2 = getResources();
            Context context2 = getContext();
            textView2.setTextColor(resources2.getColor(R.color.melody_ui_common_text_color_summary, context2 != null ? context2.getTheme() : null));
        }
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.d(fVarRequireActivity, "requireActivity(...)");
        O viewModelStore = fVarRequireActivity.getViewModelStore();
        N.b defaultViewModelProviderFactory = fVarRequireActivity.getDefaultViewModelProviderFactory();
        d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, fVarRequireActivity.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(HearingEnhancementViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f21556s = (HearingEnhancementViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        HearingEnhancementActivity hearingEnhancementActivity7 = this.f21553p;
        h.b(hearingEnhancementActivity7);
        this.f21554q = C0914u.c(hearingEnhancementActivity7.getIntent(), "detection_id", 0);
        if (this.f21556s == null) {
            h.i("mViewModel");
            throw null;
        }
        com.oplus.melody.model.repository.hearingenhance.a.o().z();
        if (this.f21556s == null) {
            h.i("mViewModel");
            throw null;
        }
        com.oplus.melody.model.repository.hearingenhance.a.o().g().e(getViewLifecycleOwner(), new b(new EarScanFragmentV2$initData$1(1, this, EarScanFragmentV2.class, "onEarScanStatus", "onEarScanStatus(Lcom/oplus/melody/model/repository/hearingenhance/EarScanStatusDTO;)V", 0)));
        if (this.f21556s == null) {
            h.i("mViewModel");
            throw null;
        }
        com.oplus.melody.model.repository.hearingenhance.a.o().f().e(getViewLifecycleOwner(), new b(new EarScanFragmentV2$initData$2(1, this, EarScanFragmentV2.class, "onEarScanResult", "onEarScanResult(Lcom/oplus/melody/model/repository/hearingenhance/EarScanResultDTO;)V", 0)));
        HearingEnhancementViewModel hearingEnhancementViewModel = this.f21556s;
        if (hearingEnhancementViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        hearingEnhancementViewModel.d(hearingEnhancementViewModel.f21582c).e(getViewLifecycleOwner(), new b(new EarScanFragmentV2$initData$3(1, this, EarScanFragmentV2.class, "onConnectStateChanged", "onConnectStateChanged(I)V", 0)));
        this.f21551I.start();
    }

    public final void r() {
        CompletableFuture<Void> completableFutureThenAccept;
        f fVar = this.f21549F;
        if (fVar != null) {
            fVar.dismiss();
        }
        this.f21549F = null;
        f fVar2 = this.H;
        if (fVar2 != null) {
            fVar2.dismiss();
        }
        this.H = null;
        f fVar3 = this.f21544A;
        if (fVar3 != null) {
            fVar3.dismiss();
        }
        this.f21544A = null;
        this.f21551I.cancel();
        CompletableFuture<SetCommandStateDTO> completableFuture = this.f21555r;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        HearingEnhancementViewModel hearingEnhancementViewModel = this.f21556s;
        if (hearingEnhancementViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        CompletableFuture<SetCommandStateDTO> completableFutureB = com.oplus.melody.model.repository.hearingenhance.a.o().b(0, this.f21554q, hearingEnhancementViewModel.f21582c);
        this.f21555r = completableFutureB;
        if (completableFutureB == null || (completableFutureThenAccept = completableFutureB.thenAccept((Consumer<? super SetCommandStateDTO>) new C1288a())) == null) {
            return;
        }
        completableFutureThenAccept.exceptionally((Function<Throwable, ? extends Void>) new C0940c(22));
    }

    public final void s(int i10) {
        if (i10 == 8 || i10 == 9) {
            String string = getString(R.string.melody_ui_hearing_enhancement_audio_output_interrupt_tips);
            h.d(string, "getString(...)");
            w(string);
        } else if (i10 == 15) {
            String string2 = getString(R.string.melody_ui_voice_enhancing_multi_device_interrupt_tips);
            h.d(string2, "getString(...)");
            w(string2);
        } else {
            if (i10 != 16) {
                return;
            }
            String string3 = getString(R.string.melody_ui_notify_new_ear, "20");
            h.d(string3, "getString(...)");
            w(string3);
        }
    }

    public final void t(int i10) {
        Button button;
        A.x("EarScanFragmentV2", "earScanStatus, errorCode: " + i10);
        this.f21551I.cancel();
        switch (i10) {
            case -1:
            case 10:
                v(R.string.melody_common_gold_hearing_scan_custom_fail);
                break;
            case 1:
            case 3:
                if (this.f21549F == null) {
                    v(R.string.melody_ui_hearing_enhancement_audio_output_interrupt_tips);
                    f fVar = this.f21549F;
                    Button buttonD = fVar != null ? fVar.d(-1) : null;
                    this.f21547D = buttonD;
                    if (buttonD != null) {
                        buttonD.setEnabled(false);
                    }
                } else {
                    Button button2 = this.f21547D;
                    if (button2 != null) {
                        button2.setEnabled(false);
                    }
                }
                break;
            case 2:
            case 4:
                if (this.f21549F != null && (button = this.f21547D) != null) {
                    button.setEnabled(true);
                    break;
                }
                break;
            case 5:
                if (this.H == null) {
                    androidx.fragment.app.f fVarRequireActivity = requireActivity();
                    h.d(fVarRequireActivity, "requireActivity(...)");
                    G7.b bVar = new G7.b(fVarRequireActivity);
                    bVar.n(R.string.melody_ui_hearing_enhancement_wear_interrupt_title);
                    bVar.l(R.string.melody_ui_hearing_enhancement_detection_continue, new H8.f(this, 10));
                    bVar.h(R.string.melody_ui_common_cancel, new DialogInterfaceOnClickListenerC1289b(this, 0));
                    f.a cancelable = bVar.setOnDismissListener(new DialogInterfaceOnDismissListenerC0457d(this, 2)).setCancelable(false);
                    h.c(cancelable, "null cannot be cast to non-null type com.oplus.melody.common.widget.MelodyAlertDialogBuilder");
                    f fVarShow = ((G7.b) cancelable).show();
                    this.H = fVarShow;
                    Button buttonD2 = fVarShow.d(-1);
                    this.f21548E = buttonD2;
                    if (buttonD2 != null) {
                        buttonD2.setEnabled(false);
                    }
                } else {
                    Button button3 = this.f21548E;
                    if (button3 != null) {
                        button3.setEnabled(false);
                    }
                }
                break;
            case 6:
                Button button4 = this.f21548E;
                if (button4 != null) {
                    button4.setEnabled(true);
                }
                break;
            case 7:
                u();
                break;
            case 8:
                x(true);
                break;
            case 9:
                x(false);
                break;
        }
    }

    public final void u() {
        r();
        HearingEnhancementActivity hearingEnhancementActivity = this.f21553p;
        if (hearingEnhancementActivity != null) {
            hearingEnhancementActivity.M();
        }
    }

    public final void v(int i10) {
        f fVar = this.f21549F;
        if (fVar == null || !fVar.isShowing()) {
            if (this.f21550G == null) {
                androidx.fragment.app.f fVarRequireActivity = requireActivity();
                h.d(fVarRequireActivity, "requireActivity(...)");
                G7.b bVar = new G7.b(fVarRequireActivity);
                bVar.n(i10);
                bVar.l(R.string.melody_common_retry, new DialogInterfaceOnClickListenerC1289b(this, 1));
                bVar.h(R.string.melody_ui_common_exit, new G8.j(this, 12));
                f.a cancelable = bVar.setOnDismissListener(new Ca.f(this, 8)).setCancelable(false);
                h.c(cancelable, "null cannot be cast to non-null type com.oplus.melody.common.widget.MelodyAlertDialogBuilder");
                this.f21550G = (G7.b) cancelable;
            }
            G7.b bVar2 = this.f21550G;
            this.f21549F = bVar2 != null ? bVar2.show() : null;
        }
    }

    public final void w(String str) {
        f fVar = this.f21544A;
        if (fVar != null) {
            fVar.dismiss();
        }
        if (this.f21544A == null) {
            androidx.fragment.app.f fVarRequireActivity = requireActivity();
            h.d(fVarRequireActivity, "requireActivity(...)");
            G7.b bVar = new G7.b(fVarRequireActivity);
            bVar.o(str);
            bVar.h(R.string.melody_ui_got_it, new DialogInterfaceOnClickListenerC0412v(this, 9));
            this.f21544A = bVar.setCancelable(false).create();
        }
        f fVar2 = this.f21544A;
        if (fVar2 != null) {
            fVar2.show();
        }
    }

    public final void x(boolean z2) {
        COUIDefaultTopTips cOUIDefaultTopTips = this.f21560w;
        if (cOUIDefaultTopTips == null) {
            h.i("mTvTip");
            throw null;
        }
        cOUIDefaultTopTips.setVisibility(z2 ? 0 : 8);
        View view = this.f21562y;
        if (view != null) {
            view.setVisibility(z2 ? 8 : 0);
        } else {
            h.i("mTopPanel");
            throw null;
        }
    }

    public final void y() {
        CompletableFuture<Void> completableFutureThenAcceptAsync;
        CompletableFuture<SetCommandStateDTO> completableFuture = this.f21555r;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        if (this.f21554q <= 0) {
            List<Integer> list = C1296i.f25838a;
            this.f21554q = Math.abs(U.f19475a.nextInt());
        }
        this.f21551I.start();
        HearingEnhancementViewModel hearingEnhancementViewModel = this.f21556s;
        if (hearingEnhancementViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        CompletableFuture<SetCommandStateDTO> completableFutureB = com.oplus.melody.model.repository.hearingenhance.a.o().b(1, this.f21554q, hearingEnhancementViewModel.f21582c);
        this.f21555r = completableFutureB;
        if (completableFutureB == null || (completableFutureThenAcceptAsync = completableFutureB.thenAcceptAsync((Consumer<? super SetCommandStateDTO>) new q(new EarScanFragmentV2$startEarScan$1(1, this, EarScanFragmentV2.class, "earScanCallback", "earScanCallback(Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;)V", 0), 12), (Executor) o0.c.f1144b)) == null) {
            return;
        }
        completableFutureThenAcceptAsync.exceptionally((Function<Throwable, ? extends Void>) new C0928l(28));
    }

    /* JADX INFO: compiled from: EarScanFragmentV2.kt */
    public static final class a extends CountDownTimer {
        public a() {
            super(15000L, 15000L);
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            EarScanFragmentV2 earScanFragmentV2 = EarScanFragmentV2.this;
            if (earScanFragmentV2.isAdded()) {
                A.b("EarScanFragmentV2", "CountDownTimer ear scan overtime, ear scan Fail.");
                Object obj = AbstractC1382a.f26570c;
                if (AbstractC1382a.C0294a.a().c()) {
                    A.x("EarScanFragmentV2", "earScanStatus, isScreenLocked: true");
                } else {
                    earScanFragmentV2.t(7);
                }
            }
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j5) {
        }
    }
}
