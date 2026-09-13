package com.oplus.melody.ui.component.tutorialguide.noise;

import A6.b;
import D7.C0379m;
import Ea.C0394c;
import F8.c;
import Wb.l;
import X.d;
import android.content.Context;
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
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0897c;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.tutorialguide.AuditionPreviewView;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: TutorialGuideNoiseFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\tH\u0002J\u0017\u0010,\u001a\u00020\u00162\b\u0010-\u001a\u0004\u0018\u00010.H\u0002¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/oplus/melody/ui/component/tutorialguide/noise/TutorialGuideNoiseFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/tutorialguide/noise/TutorialGuideNoiseViewModel;", "mPreferenceViewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "mDividerLine", "Landroid/view/View;", "mProductId", "", "mColorId", "mAddress", "mProductName", "mZipConfig", "Lcom/oplus/melody/ui/component/tutorialguide/TutorialGuideZipConfig;", "linearContainer", "Landroid/widget/LinearLayout;", "mAudioPreviewLayout", "Lcom/oplus/melody/ui/component/tutorialguide/AuditionPreviewView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "initToolBar", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "initView", "contentView", "onConnectStateChanged", "connectState", "", "(Ljava/lang/Integer;)V", "onStop", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TutorialGuideNoiseFragment extends c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TutorialGuideNoiseViewModel f21685p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public DetailMainViewModel f21686q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f21687r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f21688s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f21689t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f21690u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f21691v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public qa.c f21692w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public LinearLayout f21693x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public AuditionPreviewView f21694y;

    /* JADX INFO: compiled from: TutorialGuideNoiseFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21695a;

        public a(l lVar) {
            this.f21695a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21695a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21695a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.tutorialguide.noise.TutorialGuideNoiseFragment$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: TutorialGuideNoiseFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            Integer num2 = num;
            TutorialGuideNoiseFragment tutorialGuideNoiseFragment = (TutorialGuideNoiseFragment) this.receiver;
            if (num2 != null) {
                AuditionPreviewView auditionPreviewView = tutorialGuideNoiseFragment.f21694y;
                if (auditionPreviewView == null) {
                    h.i("mAudioPreviewLayout");
                    throw null;
                }
                auditionPreviewView.setConnectState(num2.intValue());
            } else {
                tutorialGuideNoiseFragment.getClass();
            }
            return Jb.l.f2618a;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        h.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        o(this.f21693x);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        Intent intent;
        super.onCreate(savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        Intent intent2 = activity != null ? activity.getIntent() : null;
        this.f21690u = intent2 != null ? intent2.getStringExtra("device_mac_info") : null;
        this.f21691v = intent2 != null ? intent2.getStringExtra("device_name") : null;
        this.f21688s = intent2 != null ? intent2.getStringExtra("product_id") : null;
        this.f21689t = intent2 != null ? intent2.getStringExtra("product_color") : null;
        if (TextUtils.isEmpty(this.f21690u)) {
            A.h("TutorialGuideNoiseFragment", "onCreate mAddress is empty");
            requireActivity().finish();
            return;
        }
        if (TextUtils.isEmpty(this.f21688s)) {
            A.h("TutorialGuideNoiseFragment", "onCreate productId is empty");
            requireActivity().finish();
            return;
        }
        if (TextUtils.isEmpty(this.f21691v)) {
            A.h("TutorialGuideNoiseFragment", "onCreate productName is empty");
            requireActivity().finish();
            return;
        }
        androidx.fragment.app.f activity2 = getActivity();
        qa.c cVar = (qa.c) C0917x.c(qa.c.class, (activity2 == null || (intent = activity2.getIntent()) == null) ? null : intent.getStringExtra("resZipConfig"));
        this.f21692w = cVar;
        if (cVar == null) {
            A.h("TutorialGuideNoiseFragment", "onCreate zipConfig is null");
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
            kotlin.jvm.internal.b bVarA = j.a(TutorialGuideNoiseViewModel.class);
            String strA = bVarA.a();
            if (strA == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            TutorialGuideNoiseViewModel tutorialGuideNoiseViewModel = (TutorialGuideNoiseViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
            this.f21685p = tutorialGuideNoiseViewModel;
            tutorialGuideNoiseViewModel.f21705b = this.f21690u;
            tutorialGuideNoiseViewModel.f21706c = this.f21688s;
            tutorialGuideNoiseViewModel.f21707d = this.f21691v;
            tutorialGuideNoiseViewModel.f21708e = this.f21689t;
            tutorialGuideNoiseViewModel.f21709f = this.f21692w;
            O viewModelStore2 = activity4.getViewModelStore();
            N.b defaultViewModelProviderFactory2 = activity4.getDefaultViewModelProviderFactory();
            d dVarC2 = b.c(defaultViewModelProviderFactory2, "factory", viewModelStore2, defaultViewModelProviderFactory2, activity4.getDefaultViewModelCreationExtras());
            kotlin.jvm.internal.b bVarA2 = j.a(DetailMainViewModel.class);
            String strA2 = bVarA2.a();
            if (strA2 == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            DetailMainViewModel detailMainViewModel = (DetailMainViewModel) dVarC2.a(bVarA2, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA2));
            this.f21686q = detailMainViewModel;
            String str = this.f21690u;
            h.b(str);
            detailMainViewModel.e(str);
            DetailMainViewModel detailMainViewModel2 = this.f21686q;
            if (detailMainViewModel2 == null) {
                h.i("mPreferenceViewModel");
                throw null;
            }
            String str2 = this.f21688s;
            h.b(str2);
            detailMainViewModel2.f20400e = str2;
            DetailMainViewModel detailMainViewModel3 = this.f21686q;
            if (detailMainViewModel3 == null) {
                h.i("mPreferenceViewModel");
                throw null;
            }
            String str3 = this.f21691v;
            h.b(str3);
            detailMainViewModel3.f20398c = str3;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        return inflater.inflate(R.layout.melody_ui_tutorial_guide_noise_fragment, container, false);
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
        AuditionPreviewView auditionPreviewView = this.f21694y;
        if (auditionPreviewView != null) {
            auditionPreviewView.a();
        } else {
            h.i("mAudioPreviewLayout");
            throw null;
        }
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        String realtimeNoisePosterImage;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.c(fVarRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        setHasOptionsMenu(true);
        androidx.appcompat.app.a aVarX = ((i) fVarRequireActivity).x();
        if (aVarX != null) {
            aVarX.n(true);
            aVarX.r(true);
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                h.i("context");
                throw null;
            }
            aVarX.u(heyMelodyApplication.getString(R.string.melody_common_detail_main_set_noise_reduction));
        }
        if (getActivity() != null) {
            Fragment fragmentD = getChildFragmentManager().D("TutorialGuideNoisePreferenceFragment");
            if (!(fragmentD instanceof TutorialGuideNoisePreferenceFragment)) {
                fragmentD = new TutorialGuideNoisePreferenceFragment();
            }
            TutorialGuideNoisePreferenceFragment tutorialGuideNoisePreferenceFragment = (TutorialGuideNoisePreferenceFragment) fragmentD;
            DetailMainViewModel detailMainViewModel = this.f21686q;
            if (detailMainViewModel == null) {
                h.i("mPreferenceViewModel");
                throw null;
            }
            tutorialGuideNoisePreferenceFragment.getClass();
            tutorialGuideNoisePreferenceFragment.f21700w = detailMainViewModel;
            FragmentManager childFragmentManager = getChildFragmentManager();
            childFragmentManager.getClass();
            C0585a c0585a = new C0585a(childFragmentManager);
            c0585a.d(R.id.function_container, fragmentD, "TutorialGuideNoisePreferenceFragment");
            c0585a.g();
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear_container);
        this.f21693x = linearLayout;
        p(linearLayout);
        if (C0897c.b(requireActivity()) || C0897c.c(requireActivity())) {
            LinearLayout linearLayout2 = this.f21693x;
            ViewGroup.LayoutParams layoutParams = linearLayout2 != null ? linearLayout2.getLayoutParams() : null;
            h.c(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMarginStart((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
            marginLayoutParams.setMarginEnd((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
        }
        View viewFindViewById = view.getRootView().findViewById(R.id.divider_line);
        h.d(viewFindViewById, "findViewById(...)");
        this.f21687r = viewFindViewById;
        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.scroll_view);
        h.b(nestedScrollView);
        C0394c c0394c = new C0394c(nestedScrollView);
        View view2 = this.f21687r;
        if (view2 == null) {
            h.i("mDividerLine");
            throw null;
        }
        c0394c.a(view2);
        qa.c cVar = this.f21692w;
        if (cVar != null && (realtimeNoisePosterImage = cVar.getRealtimeNoisePosterImage()) != null) {
            Context context = getContext();
            qa.c cVar2 = this.f21692w;
            h.b(cVar2);
            File fileO = com.oplus.drs.core.d.o(context, cVar2.getRootPath(), realtimeNoisePosterImage);
            if (fileO != null) {
                Glide.with(this).load(fileO).into((ImageView) view.findViewById(R.id.poster_image));
            }
        }
        View viewFindViewById2 = view.findViewById(R.id.audio_preview);
        h.d(viewFindViewById2, "findViewById(...)");
        AuditionPreviewView auditionPreviewView = (AuditionPreviewView) viewFindViewById2;
        this.f21694y = auditionPreviewView;
        auditionPreviewView.setFragment(this);
        HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
        if (heyMelodyApplication2 == null) {
            h.i("context");
            throw null;
        }
        qa.c cVar3 = this.f21692w;
        MelodyResourceDO realtimeNoiseAuditionMusic = cVar3 != null ? cVar3.getRealtimeNoiseAuditionMusic() : null;
        qa.c cVar4 = this.f21692w;
        File fileN = com.oplus.drs.core.d.n(heyMelodyApplication2, realtimeNoiseAuditionMusic, cVar4 != null ? cVar4.getRootPath() : null);
        if (fileN != null && fileN.exists()) {
            AuditionPreviewView auditionPreviewView2 = this.f21694y;
            if (auditionPreviewView2 == null) {
                h.i("mAudioPreviewLayout");
                throw null;
            }
            auditionPreviewView2.setAudioFile(fileN);
        }
        AuditionPreviewView auditionPreviewView3 = this.f21694y;
        if (auditionPreviewView3 == null) {
            h.i("mAudioPreviewLayout");
            throw null;
        }
        qa.c cVar5 = this.f21692w;
        auditionPreviewView3.setAudioName(cVar5 != null ? cVar5.getRealtimeNoiseAuditionMusicName() : null);
        if (this.f21685p != null) {
            C0379m.b(C0379m.g(AbstractC0939b.E().v(this.f21690u), new g0.f(15))).e(getViewLifecycleOwner(), new a(new AnonymousClass2(1, this, TutorialGuideNoiseFragment.class, "onConnectStateChanged", "onConnectStateChanged(Ljava/lang/Integer;)V", 0)));
        } else {
            h.i("mViewModel");
            throw null;
        }
    }
}
