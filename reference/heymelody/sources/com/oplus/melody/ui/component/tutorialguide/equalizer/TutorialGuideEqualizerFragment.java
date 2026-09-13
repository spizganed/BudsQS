package com.oplus.melody.ui.component.tutorialguide.equalizer;

import A6.b;
import D7.C0379m;
import Ea.C0394c;
import F8.c;
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
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.ui.component.tutorialguide.AuditionPreviewView;
import g0.e;
import g9.o;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: TutorialGuideEqualizerFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0007H\u0002J\u0017\u0010,\u001a\u00020\u00162\b\u0010-\u001a\u0004\u0018\u00010.H\u0002¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/oplus/melody/ui/component/tutorialguide/equalizer/TutorialGuideEqualizerFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/tutorialguide/equalizer/TutorialGuideEqualizerViewModel;", "mDividerLine", "Landroid/view/View;", "mProductId", "", "mColorId", "mAddress", "mProductName", "mZipConfig", "Lcom/oplus/melody/ui/component/tutorialguide/TutorialGuideZipConfig;", "linearContainer", "Landroid/widget/LinearLayout;", "mAudioPreviewLayout", "Lcom/oplus/melody/ui/component/tutorialguide/AuditionPreviewView;", "posterRequestOptions", "Lcom/bumptech/glide/request/RequestOptions;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "initToolBar", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "initView", "contentView", "onConnectStateChanged", "connectState", "", "(Ljava/lang/Integer;)V", "onStop", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TutorialGuideEqualizerFragment extends c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TutorialGuideEqualizerViewModel f21675p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f21676q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f21677r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f21678s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f21679t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public qa.c f21680u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LinearLayout f21681v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AuditionPreviewView f21682w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final RequestOptions f21683x;

    /* JADX INFO: compiled from: TutorialGuideEqualizerFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21684a;

        public a(l lVar) {
            this.f21684a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21684a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21684a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.tutorialguide.equalizer.TutorialGuideEqualizerFragment$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: TutorialGuideEqualizerFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            Integer num2 = num;
            TutorialGuideEqualizerFragment tutorialGuideEqualizerFragment = (TutorialGuideEqualizerFragment) this.receiver;
            if (num2 != null) {
                AuditionPreviewView auditionPreviewView = tutorialGuideEqualizerFragment.f21682w;
                if (auditionPreviewView == null) {
                    h.i("mAudioPreviewLayout");
                    throw null;
                }
                auditionPreviewView.setConnectState(num2.intValue());
            } else {
                tutorialGuideEqualizerFragment.getClass();
            }
            return Jb.l.f2618a;
        }
    }

    public TutorialGuideEqualizerFragment() {
        RequestOptions requestOptionsDontTransform = new RequestOptions().dontTransform();
        h.d(requestOptionsDontTransform, "dontTransform(...)");
        this.f21683x = requestOptionsDontTransform;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        h.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        o(this.f21681v);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        Intent intent;
        super.onCreate(savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        String stringExtra = null;
        Intent intent2 = activity != null ? activity.getIntent() : null;
        this.f21678s = intent2 != null ? intent2.getStringExtra("device_mac_info") : null;
        this.f21679t = intent2 != null ? intent2.getStringExtra("device_name") : null;
        this.f21677r = intent2 != null ? intent2.getStringExtra("product_id") : null;
        if (intent2 != null) {
            intent2.getStringExtra("product_color");
        }
        if (TextUtils.isEmpty(this.f21678s)) {
            A.h("TutorialGuideEqualizerFragment", "onCreate mAddress is empty");
            requireActivity().finish();
            return;
        }
        if (TextUtils.isEmpty(this.f21677r)) {
            A.h("TutorialGuideEqualizerFragment", "onCreate productId is empty");
            requireActivity().finish();
            return;
        }
        if (TextUtils.isEmpty(this.f21679t)) {
            A.h("TutorialGuideEqualizerFragment", "onCreate productName is empty");
            requireActivity().finish();
            return;
        }
        androidx.fragment.app.f activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            stringExtra = intent.getStringExtra("resZipConfig");
        }
        qa.c cVar = (qa.c) C0917x.c(qa.c.class, stringExtra);
        this.f21680u = cVar;
        if (cVar == null) {
            A.h("TutorialGuideEqualizerFragment", "onCreate zipConfig is null");
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
            this.f21675p = (TutorialGuideEqualizerViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        return inflater.inflate(R.layout.melody_ui_tutorial_guide_equalizer_fragment, container, false);
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
        AuditionPreviewView auditionPreviewView = this.f21682w;
        if (auditionPreviewView != null) {
            auditionPreviewView.a();
        } else {
            h.i("mAudioPreviewLayout");
            throw null;
        }
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        String equalizerPosterImage;
        File fileO;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.c(fVarRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        i iVar = (i) fVarRequireActivity;
        setHasOptionsMenu(true);
        androidx.appcompat.app.a aVarX = iVar.x();
        if (aVarX != null) {
            aVarX.n(true);
            aVarX.r(true);
            aVarX.u(o.a(iVar, this.f21677r, this.f21679t));
        }
        if (getActivity() != null) {
            Fragment fragmentD = getChildFragmentManager().D("CustomEqFragment");
            if (!(fragmentD instanceof g9.j)) {
                fragmentD = new g9.j();
            }
            FragmentManager childFragmentManager = getChildFragmentManager();
            childFragmentManager.getClass();
            C0585a c0585a = new C0585a(childFragmentManager);
            c0585a.d(R.id.eq_container, fragmentD, "CustomEqFragment");
            c0585a.h(true, true);
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear_container);
        this.f21681v = linearLayout;
        p(linearLayout);
        if (C0897c.b(requireActivity()) || C0897c.c(requireActivity())) {
            LinearLayout linearLayout2 = this.f21681v;
            ViewGroup.LayoutParams layoutParams = linearLayout2 != null ? linearLayout2.getLayoutParams() : null;
            h.c(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMarginStart((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
            marginLayoutParams.setMarginEnd((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
        }
        View viewFindViewById = view.getRootView().findViewById(R.id.divider_line);
        h.d(viewFindViewById, "findViewById(...)");
        this.f21676q = viewFindViewById;
        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.scroll_view);
        h.b(nestedScrollView);
        C0394c c0394c = new C0394c(nestedScrollView);
        View view2 = this.f21676q;
        if (view2 == null) {
            h.i("mDividerLine");
            throw null;
        }
        c0394c.a(view2);
        qa.c cVar = this.f21680u;
        if (cVar != null && (equalizerPosterImage = cVar.getEqualizerPosterImage()) != null && (fileO = com.oplus.drs.core.d.o(getContext(), cVar.getRootPath(), equalizerPosterImage)) != null) {
            Glide.with(this).load(fileO).apply((BaseRequestOptions<?>) this.f21683x).into((ImageView) view.findViewById(R.id.poster_image));
        }
        View viewFindViewById2 = view.findViewById(R.id.audio_preview);
        h.d(viewFindViewById2, "findViewById(...)");
        AuditionPreviewView auditionPreviewView = (AuditionPreviewView) viewFindViewById2;
        this.f21682w = auditionPreviewView;
        auditionPreviewView.setFragment(this);
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        qa.c cVar2 = this.f21680u;
        MelodyResourceDO equalizerAuditionMusic = cVar2 != null ? cVar2.getEqualizerAuditionMusic() : null;
        qa.c cVar3 = this.f21680u;
        File fileN = com.oplus.drs.core.d.n(heyMelodyApplication, equalizerAuditionMusic, cVar3 != null ? cVar3.getRootPath() : null);
        if (fileN != null && fileN.exists()) {
            AuditionPreviewView auditionPreviewView2 = this.f21682w;
            if (auditionPreviewView2 == null) {
                h.i("mAudioPreviewLayout");
                throw null;
            }
            auditionPreviewView2.setAudioFile(fileN);
        }
        AuditionPreviewView auditionPreviewView3 = this.f21682w;
        if (auditionPreviewView3 == null) {
            h.i("mAudioPreviewLayout");
            throw null;
        }
        qa.c cVar4 = this.f21680u;
        auditionPreviewView3.setAudioName(cVar4 != null ? cVar4.getEqualizerAuditionMusicName() : null);
        if (this.f21675p != null) {
            C0379m.b(C0379m.g(AbstractC0939b.E().v(this.f21678s), new e(25))).e(getViewLifecycleOwner(), new a(new AnonymousClass2(1, this, TutorialGuideEqualizerFragment.class, "onConnectStateChanged", "onConnectStateChanged(Ljava/lang/Integer;)V", 0)));
        } else {
            h.i("mViewModel");
            throw null;
        }
    }
}
