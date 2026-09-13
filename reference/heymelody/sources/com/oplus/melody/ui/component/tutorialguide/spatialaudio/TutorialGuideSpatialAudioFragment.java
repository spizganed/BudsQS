package com.oplus.melody.ui.component.tutorialguide.spatialaudio;

import A6.b;
import D7.C0379m;
import Ea.C0394c;
import F8.c;
import R9.n;
import Wb.l;
import X.d;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.i;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0897c;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.ui.component.detail.spatialaudio.SpatialAudioContentFragment;
import com.oplus.melody.ui.component.tutorialguide.AuditionPreviewView;
import com.oplus.melody.ui.component.tutorialguide.equalizer.TutorialGuideEqualizerViewModel;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import g0.e;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: TutorialGuideSpatialAudioFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+2\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u0005H\u0002J\u0017\u0010.\u001a\u00020\u00182\b\u0010/\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u0018H\u0016J\b\u00103\u001a\u00020\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/oplus/melody/ui/component/tutorialguide/spatialaudio/TutorialGuideSpatialAudioFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "<init>", "()V", "mDividerLine", "Landroid/view/View;", "mProductId", "", "mColorId", "mAddress", "mProductName", "mZipConfig", "Lcom/oplus/melody/ui/component/tutorialguide/TutorialGuideZipConfig;", "linearContainer", "Landroid/widget/LinearLayout;", "mViewModel", "Lcom/oplus/melody/ui/component/tutorialguide/equalizer/TutorialGuideEqualizerViewModel;", "mAudioPreviewLayout", "Lcom/oplus/melody/ui/component/tutorialguide/AuditionPreviewView;", "mScrollView", "Landroidx/core/widget/NestedScrollView;", "posterRequestOptions", "Lcom/bumptech/glide/request/RequestOptions;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "initToolBar", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "initView", "contentView", "onConnectStateChanged", "connectState", "", "(Ljava/lang/Integer;)V", "onStop", "onDestroy", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TutorialGuideSpatialAudioFragment extends c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f21712p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f21713q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f21714r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f21715s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public qa.c f21716t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LinearLayout f21717u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TutorialGuideEqualizerViewModel f21718v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AuditionPreviewView f21719w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final RequestOptions f21720x;

    /* JADX INFO: compiled from: TutorialGuideSpatialAudioFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21721a;

        public a(l lVar) {
            this.f21721a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21721a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21721a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.tutorialguide.spatialaudio.TutorialGuideSpatialAudioFragment$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: TutorialGuideSpatialAudioFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            Integer num2 = num;
            TutorialGuideSpatialAudioFragment tutorialGuideSpatialAudioFragment = (TutorialGuideSpatialAudioFragment) this.receiver;
            if (num2 != null) {
                AuditionPreviewView auditionPreviewView = tutorialGuideSpatialAudioFragment.f21719w;
                if (auditionPreviewView == null) {
                    h.i("mAudioPreviewLayout");
                    throw null;
                }
                auditionPreviewView.setConnectState(num2.intValue());
            } else {
                tutorialGuideSpatialAudioFragment.getClass();
            }
            return Jb.l.f2618a;
        }
    }

    public TutorialGuideSpatialAudioFragment() {
        RequestOptions requestOptionsDontTransform = new RequestOptions().dontTransform();
        h.d(requestOptionsDontTransform, "dontTransform(...)");
        this.f21720x = requestOptionsDontTransform;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        h.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        o(this.f21717u);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        Intent intent;
        super.onCreate(savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        String stringExtra = null;
        Intent intent2 = activity != null ? activity.getIntent() : null;
        this.f21714r = C0914u.h(intent2, "device_mac_info");
        this.f21715s = C0914u.h(intent2, "device_name");
        this.f21713q = C0914u.h(intent2, "product_id");
        C0914u.h(intent2, "product_color");
        if (TextUtils.isEmpty(this.f21714r)) {
            A.h("TutorialGuideSpatialAudioFragment", "onCreate mAddress is empty");
            requireActivity().finish();
            return;
        }
        if (TextUtils.isEmpty(this.f21713q)) {
            A.h("TutorialGuideSpatialAudioFragment", "onCreate productId is empty");
            requireActivity().finish();
            return;
        }
        if (TextUtils.isEmpty(this.f21715s)) {
            A.h("TutorialGuideSpatialAudioFragment", "onCreate productName is empty");
            requireActivity().finish();
            return;
        }
        androidx.fragment.app.f activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            stringExtra = intent.getStringExtra("resZipConfig");
        }
        qa.c cVar = (qa.c) C0917x.c(qa.c.class, stringExtra);
        this.f21716t = cVar;
        if (cVar == null) {
            A.h("TutorialGuideSpatialAudioFragment", "onCreate zipConfig is null");
            androidx.fragment.app.f activity3 = getActivity();
            if (activity3 != null) {
                activity3.finish();
                return;
            }
            return;
        }
        androidx.fragment.app.f activity4 = getActivity();
        if (activity4 != null) {
            O viewModelStore = activity4.getViewModelStore();
            N.b defaultViewModelProviderFactory = activity4.getDefaultViewModelProviderFactory();
            d dVarC = b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, activity4.getDefaultViewModelCreationExtras());
            kotlin.jvm.internal.b bVarA = j.a(TutorialGuideEqualizerViewModel.class);
            String strA = bVarA.a();
            if (strA == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            this.f21718v = (TutorialGuideEqualizerViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        return inflater.inflate(R.layout.melody_ui_tutorial_guide_spatial_audio_fragment, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        androidx.appcompat.app.f fVar;
        super.onDestroy();
        AuditionPreviewView auditionPreviewView = this.f21719w;
        if (auditionPreviewView == null) {
            h.i("mAudioPreviewLayout");
            throw null;
        }
        androidx.appcompat.app.f fVar2 = auditionPreviewView.f21654u;
        if (fVar2 == null || !fVar2.isShowing() || (fVar = auditionPreviewView.f21654u) == null) {
            return;
        }
        fVar.dismiss();
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
    public final void onStop() {
        super.onStop();
        AuditionPreviewView auditionPreviewView = this.f21719w;
        if (auditionPreviewView != null) {
            auditionPreviewView.a();
        } else {
            h.i("mAudioPreviewLayout");
            throw null;
        }
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        String spatialAudioPosterImage;
        File fileO;
        String str;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.c(fVarRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        i iVar = (i) fVarRequireActivity;
        MelodyCompatToolbar melodyCompatToolbar = (MelodyCompatToolbar) view.findViewById(R.id.toolbar);
        String str2 = this.f21713q;
        if (str2 != null && (str = this.f21715s) != null) {
            h.b(str);
            melodyCompatToolbar.setTitle(n.b(str2, str));
        }
        iVar.y(melodyCompatToolbar);
        androidx.appcompat.app.a aVarX = iVar.x();
        setHasOptionsMenu(true);
        if (aVarX != null) {
            aVarX.n(true);
            aVarX.r(true);
        }
        if (getActivity() != null) {
            Fragment fragmentD = getChildFragmentManager().D("SpatialAudioContentFragment");
            if (!(fragmentD instanceof SpatialAudioContentFragment)) {
                fragmentD = new SpatialAudioContentFragment();
            }
            ((SpatialAudioContentFragment) fragmentD).setArguments(getArguments());
            FragmentManager childFragmentManager = getChildFragmentManager();
            childFragmentManager.getClass();
            C0585a c0585a = new C0585a(childFragmentManager);
            c0585a.d(R.id.function_container, fragmentD, "SpatialAudioContentFragment");
            c0585a.g();
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear_container);
        this.f21717u = linearLayout;
        p(linearLayout);
        if (C0897c.b(requireActivity()) || C0897c.c(requireActivity())) {
            LinearLayout linearLayout2 = this.f21717u;
            ViewGroup.LayoutParams layoutParams = linearLayout2 != null ? linearLayout2.getLayoutParams() : null;
            h.c(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMarginStart((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
            marginLayoutParams.setMarginEnd((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
        }
        View viewFindViewById = view.getRootView().findViewById(R.id.divider_line);
        h.d(viewFindViewById, "findViewById(...)");
        this.f21712p = viewFindViewById;
        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.scroll_view);
        h.b(nestedScrollView);
        C0394c c0394c = new C0394c(nestedScrollView);
        View view2 = this.f21712p;
        if (view2 == null) {
            h.i("mDividerLine");
            throw null;
        }
        c0394c.a(view2);
        qa.c cVar = this.f21716t;
        if (cVar != null && (spatialAudioPosterImage = cVar.getSpatialAudioPosterImage()) != null && (fileO = com.oplus.drs.core.d.o(getContext(), cVar.getRootPath(), spatialAudioPosterImage)) != null) {
            Glide.with(this).load(fileO).apply((BaseRequestOptions<?>) this.f21720x).into((ImageView) view.findViewById(R.id.poster_image));
        }
        View viewFindViewById2 = view.findViewById(R.id.scroll_view);
        h.d(viewFindViewById2, "findViewById(...)");
        ((NestedScrollView) viewFindViewById2).setOnTouchListener(new Aa.f());
        View viewFindViewById3 = view.findViewById(R.id.audio_preview);
        h.d(viewFindViewById3, "findViewById(...)");
        AuditionPreviewView auditionPreviewView = (AuditionPreviewView) viewFindViewById3;
        this.f21719w = auditionPreviewView;
        auditionPreviewView.setAddress(this.f21714r);
        AuditionPreviewView auditionPreviewView2 = this.f21719w;
        if (auditionPreviewView2 == null) {
            h.i("mAudioPreviewLayout");
            throw null;
        }
        auditionPreviewView2.setFragment(this);
        AuditionPreviewView auditionPreviewView3 = this.f21719w;
        if (auditionPreviewView3 == null) {
            h.i("mAudioPreviewLayout");
            throw null;
        }
        androidx.fragment.app.f activity = getActivity();
        auditionPreviewView3.setIsDisableByLeaMode(C0914u.b(activity != null ? activity.getIntent() : null, "route_value2", false));
        AuditionPreviewView auditionPreviewView4 = this.f21719w;
        if (auditionPreviewView4 == null) {
            h.i("mAudioPreviewLayout");
            throw null;
        }
        auditionPreviewView4.setAutoPlay(true);
        AuditionPreviewView auditionPreviewView5 = this.f21719w;
        if (auditionPreviewView5 == null) {
            h.i("mAudioPreviewLayout");
            throw null;
        }
        auditionPreviewView5.setInLeaModeTipStrResId(R.string.melody_common_dialog_close_le_summary_spatial_audio);
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        qa.c cVar2 = this.f21716t;
        MelodyResourceDO spatialAuditionMusic = cVar2 != null ? cVar2.getSpatialAuditionMusic() : null;
        qa.c cVar3 = this.f21716t;
        File fileN = com.oplus.drs.core.d.n(heyMelodyApplication, spatialAuditionMusic, cVar3 != null ? cVar3.getRootPath() : null);
        if (fileN != null && fileN.exists()) {
            AuditionPreviewView auditionPreviewView6 = this.f21719w;
            if (auditionPreviewView6 == null) {
                h.i("mAudioPreviewLayout");
                throw null;
            }
            auditionPreviewView6.setAudioFile(fileN);
        }
        AuditionPreviewView auditionPreviewView7 = this.f21719w;
        if (auditionPreviewView7 == null) {
            h.i("mAudioPreviewLayout");
            throw null;
        }
        qa.c cVar4 = this.f21716t;
        auditionPreviewView7.setAudioName(cVar4 != null ? cVar4.getSpatialAuditionMusicName() : null);
        if (this.f21718v != null) {
            C0379m.b(C0379m.g(AbstractC0939b.E().v(this.f21714r), new e(25))).e(getViewLifecycleOwner(), new a(new AnonymousClass2(1, this, TutorialGuideSpatialAudioFragment.class, "onConnectStateChanged", "onConnectStateChanged(Ljava/lang/Integer;)V", 0)));
        } else {
            h.i("mViewModel");
            throw null;
        }
    }
}
