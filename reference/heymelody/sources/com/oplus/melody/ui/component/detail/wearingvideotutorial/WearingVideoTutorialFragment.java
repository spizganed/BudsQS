package com.oplus.melody.ui.component.detail.wearingvideotutorial;

import A9.s;
import D7.o0;
import E9.t;
import Ea.C0394c;
import Ea.C0403l;
import Ea.E;
import Ea.ViewOnClickListenerC0405n;
import F8.c;
import F8.g;
import I8.D;
import I8.r;
import Wb.l;
import X.d;
import X3.w;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.i;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0897c;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.model.net.data.ResourceFetchDO;
import com.oplus.melody.model.net.n;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.widget.MelodyCompatTextView;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import com.oplus.melody.ui.widget.MelodyVideoView;
import ec.k;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Function;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.wearingvideotutorial.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: WearingVideoTutorialFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J&\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u0002022\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0010\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u0005H\u0002J\u0010\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020\u001fH\u0002J\b\u00109\u001a\u00020\u001fH\u0002J\b\u0010:\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/oplus/melody/ui/component/detail/wearingvideotutorial/WearingVideoTutorialFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "<init>", "()V", "mDividerLine", "Landroid/view/View;", "mProductId", "", "mColorId", "", "mAddress", "mProductName", "linearContainer", "Landroid/widget/LinearLayout;", "mWearingVideoView", "Lcom/oplus/melody/ui/widget/MelodyVideoView;", "mEarphoneControlTxt", "Lcom/oplus/melody/ui/widget/MelodyCompatTextView;", "mWearingVideoTxt", "mPlayBtn", "Landroid/widget/ImageView;", "mCoverImage", "mVideoLayout", "Landroid/widget/FrameLayout;", "mLoadingView", "Lcom/airbnb/lottie/LottieAnimationView;", "mCountDownTimer", "Landroid/os/CountDownTimer;", "mViewModel", "Lcom/oplus/melody/ui/component/detail/wearingvideotutorial/WearingVideoTutorialViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "initToolBar", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "initView", "contentView", "onWearGuideChanged", "vo", "Lcom/oplus/melody/ui/component/control/guide/TextImageGuideVO;", "fetchUrlResource", "changePlayBtnVisible", "showLoadingAnimation", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WearingVideoTutorialFragment extends c {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public FrameLayout f21393A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public LottieAnimationView f21394B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public a f21395C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public WearingVideoTutorialViewModel f21396D;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f21397p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f21398q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f21399r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f21400s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f21401t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LinearLayout f21402u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public MelodyVideoView f21403v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public MelodyCompatTextView f21404w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public MelodyCompatTextView f21405x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ImageView f21406y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ImageView f21407z;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.wearingvideotutorial.a$b */
    /* JADX INFO: compiled from: WearingVideoTutorialFragment.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21409a;

        public b(l lVar) {
            this.f21409a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21409a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21409a.d(obj);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        h.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        LinearLayout linearLayout = this.f21402u;
        ViewGroup.LayoutParams layoutParams = linearLayout != null ? linearLayout.getLayoutParams() : null;
        h.c(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int dimension = (int) ((C0897c.b(requireActivity()) || C0897c.c(requireActivity())) ? getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic) : getResources().getDimension(R.dimen.melody_ui_finddevice_layout_margin_left));
        marginLayoutParams.setMarginStart(dimension);
        marginLayoutParams.setMarginEnd(dimension);
        LinearLayout linearLayout2 = this.f21402u;
        if (linearLayout2 != null) {
            linearLayout2.setLayoutParams(marginLayoutParams);
        }
        MelodyVideoView melodyVideoView = this.f21403v;
        if (melodyVideoView != null) {
            melodyVideoView.post(new w(melodyVideoView, 3));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        Integer numB;
        super.onCreate(savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        this.f21400s = C0914u.h(intent, "device_mac_info");
        this.f21401t = C0914u.h(intent, "device_name");
        this.f21398q = C0914u.h(intent, "product_id");
        String strH = C0914u.h(intent, "product_color");
        this.f21399r = (strH == null || (numB = k.B(strH)) == null) ? -1 : numB.intValue();
        if (TextUtils.isEmpty(this.f21400s)) {
            A.h("WearingVideoTutorialFragment", "onCreate mAddress is empty");
            requireActivity().finish();
            return;
        }
        if (TextUtils.isEmpty(this.f21398q)) {
            A.h("WearingVideoTutorialFragment", "onCreate productId is empty");
            requireActivity().finish();
            return;
        }
        if (TextUtils.isEmpty(this.f21401t)) {
            A.h("WearingVideoTutorialFragment", "onCreate productName is empty");
            requireActivity().finish();
            return;
        }
        this.f21395C = new a();
        androidx.fragment.app.f activity2 = getActivity();
        if (activity2 != null) {
            O viewModelStore = activity2.getViewModelStore();
            N.b defaultViewModelProviderFactory = activity2.getDefaultViewModelProviderFactory();
            d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, activity2.getDefaultViewModelCreationExtras());
            kotlin.jvm.internal.b bVarA = j.a(WearingVideoTutorialViewModel.class);
            String strA = bVarA.a();
            if (strA == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            this.f21396D = (WearingVideoTutorialViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        }
        String str = this.f21398q;
        String str2 = this.f21400s;
        C1264t.t(AppConstant$FunctionType.WEARING_VIDEO_TUTORIAL.getFunType(), str, str2, com.oplus.melody.model.repository.earphone.N.t(this.f21396D != null ? AbstractC0939b.E().w(str2) : null), "");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        return inflater.inflate(R.layout.melody_ui_wearing_video_tutorial_fragment, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        androidx.fragment.app.f activity;
        h.e(item, "item");
        if (item.getItemId() == 16908332 && (activity = getActivity()) != null) {
            activity.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        WearingVideoTutorialFragment wearingVideoTutorialFragment;
        O7.l<D> lVar;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.c(fVarRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        i iVar = (i) fVarRequireActivity;
        MelodyCompatToolbar melodyCompatToolbar = (MelodyCompatToolbar) view.findViewById(R.id.toolbar);
        melodyCompatToolbar.setTitle(getString(R.string.melody_ui_video_tutorial));
        iVar.y(melodyCompatToolbar);
        setHasOptionsMenu(true);
        androidx.appcompat.app.a aVarX = iVar.x();
        if (aVarX != null) {
            aVarX.n(true);
            aVarX.r(true);
        }
        this.f21402u = (LinearLayout) view.findViewById(R.id.linear_container);
        if (C0897c.b(requireActivity()) || C0897c.c(requireActivity())) {
            LinearLayout linearLayout = this.f21402u;
            ViewGroup.LayoutParams layoutParams = linearLayout != null ? linearLayout.getLayoutParams() : null;
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.setMarginStart((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.setMarginEnd((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
            }
        }
        this.f21394B = (LottieAnimationView) view.findViewById(R.id.loading_view);
        View viewFindViewById = view.getRootView().findViewById(R.id.divider_line);
        h.d(viewFindViewById, "findViewById(...)");
        this.f21397p = viewFindViewById;
        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.scroll_view);
        h.b(nestedScrollView);
        C0394c c0394c = new C0394c(nestedScrollView);
        View view2 = this.f21397p;
        if (view2 == null) {
            h.i("mDividerLine");
            throw null;
        }
        c0394c.a(view2);
        this.f21393A = (FrameLayout) view.findViewById(R.id.video_layout);
        this.f21406y = (ImageView) view.findViewById(R.id.play_btn);
        this.f21407z = (ImageView) view.findViewById(R.id.cover_image);
        this.f21403v = (MelodyVideoView) view.findViewById(R.id.wearing_video_tutorial_view);
        this.f21404w = (MelodyCompatTextView) view.findViewById(R.id.earphone_control_summary_txt);
        this.f21405x = (MelodyCompatTextView) view.findViewById(R.id.wearing_video_tutorial_summary);
        FrameLayout frameLayout = this.f21393A;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new ViewOnClickListenerC0405n(this, 11));
        }
        ImageView imageView = this.f21406y;
        if (imageView != null) {
            imageView.setOnClickListener(new E(this, 10));
        }
        MelodyVideoView melodyVideoView = this.f21403v;
        if (melodyVideoView != null) {
            melodyVideoView.setStatusChangeCallback(new Z9.a(this));
        }
        LottieAnimationView lottieAnimationView = this.f21394B;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation(R.raw.melody_ui_lottie_loading);
        }
        LottieAnimationView lottieAnimationView2 = this.f21394B;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.playAnimation();
        }
        WearingVideoTutorialViewModel wearingVideoTutorialViewModel = this.f21396D;
        if (wearingVideoTutorialViewModel == null || (lVar = wearingVideoTutorialViewModel.f21392c) == null) {
            wearingVideoTutorialFragment = this;
        } else {
            wearingVideoTutorialFragment = this;
            lVar.e(getViewLifecycleOwner(), new b(new WearingVideoTutorialFragment$initView$4(1, wearingVideoTutorialFragment, WearingVideoTutorialFragment.class, "onWearGuideChanged", "onWearGuideChanged(Lcom/oplus/melody/ui/component/control/guide/TextImageGuideVO;)V", 0)));
        }
        WearingVideoTutorialViewModel wearingVideoTutorialViewModel2 = wearingVideoTutorialFragment.f21396D;
        if (wearingVideoTutorialViewModel2 != null) {
            String str = wearingVideoTutorialFragment.f21398q;
            int i10 = wearingVideoTutorialFragment.f21399r;
            Z7.a.g().e(i10, str).thenApplyAsync((Function) new C0403l(new r(i10, 1, wearingVideoTutorialViewModel2, str), 9)).exceptionally((Function) new A6.i(13));
        }
        WearingVideoTutorialViewModel wearingVideoTutorialViewModel3 = wearingVideoTutorialFragment.f21396D;
        if (wearingVideoTutorialViewModel3 != null) {
            String str2 = wearingVideoTutorialFragment.f21398q;
            int i11 = wearingVideoTutorialFragment.f21399r;
            Aa.b bVar = new Aa.b(this, 28);
            CompletableFuture<ResourceFetchDO> completableFuture = wearingVideoTutorialViewModel3.f21391b;
            if (completableFuture == null || completableFuture.isDone()) {
                n nVarB = n.b();
                wearingVideoTutorialViewModel3.f21391b = nVarB.j(i11, 13, str2).thenApply((Function) new com.oplus.melody.model.net.l(nVarB)).whenCompleteAsync((BiConsumer) new s(new g(bVar, 7), 21), (Executor) o0.c.f1144b);
            }
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.wearingvideotutorial.a$a */
    /* JADX INFO: compiled from: WearingVideoTutorialFragment.kt */
    public static final class a extends CountDownTimer {
        public a() {
            super(300L, 300L);
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            o0.d(new t(WearingVideoTutorialFragment.this, 23));
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j5) {
        }
    }
}
