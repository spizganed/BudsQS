package com.oplus.melody.ui.component.tutorialguide.noise;

import F8.i;
import Jb.b;
import Wb.l;
import X.d;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIPagerFooterPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.g;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.detail.noisereduction.NoiseReductionItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import qa.c;

/* JADX INFO: compiled from: TutorialGuideNoisePreferenceFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0005J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/oplus/melody/ui/component/tutorialguide/noise/TutorialGuideNoisePreferenceFragment;", "Lcom/coui/appcompat/preference/COUIPreferenceFragment;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "mProductId", "", "mColorId", "mAddress", "mProductName", "mNoiseEarphoneSettingPreference", "Lcom/coui/appcompat/preference/COUIJumpPreference;", "mNoiseEarphoneIntroducePreference", "Lcom/coui/appcompat/preference/COUIPagerFooterPreference;", "mZipConfig", "Lcom/oplus/melody/ui/component/tutorialguide/TutorialGuideZipConfig;", "onCreateRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "", "rootKey", "onCreate", "onViewCreated", "view", "Landroid/view/View;", "onPreferenceTreeClick", "", "preference", "Landroidx/preference/Preference;", "setViewModel", "viewModel", "onConnectStateChanged", "connectState", "", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TutorialGuideNoisePreferenceFragment extends g {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public String f21696A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public COUIJumpPreference f21697B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public COUIPagerFooterPreference f21698C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public c f21699D;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public DetailMainViewModel f21700w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f21701x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f21702y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f21703z;

    /* JADX INFO: compiled from: TutorialGuideNoisePreferenceFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21704a;

        public a(l lVar) {
            this.f21704a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21704a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21704a.d(obj);
        }
    }

    @Override // androidx.preference.g, androidx.preference.k.b
    public final boolean f(Preference preference) {
        if (h.a(preference.getKey(), "key_guide_noise_earphone_setting_preference")) {
            E8.a.w().getClass();
            b<List<l<String, Class<?>>>> bVar = i.f1668g;
            i iVarA = i.a.a("/ui/ear_control");
            iVarA.f("device_mac_info", this.f21703z);
            iVarA.f("device_name", this.f21696A);
            iVarA.f("product_id", this.f21701x);
            iVarA.f("product_color", this.f21702y);
            iVarA.f("control_auto_show", "19");
            iVarA.e(this);
        }
        return super.f(preference);
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        A.b("TutorialGuideNoisePreferenceFragment", "onCreate");
        androidx.fragment.app.f activity = getActivity();
        if (activity != null) {
            O viewModelStore = activity.getViewModelStore();
            N.b defaultViewModelProviderFactory = activity.getDefaultViewModelProviderFactory();
            d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, activity.getDefaultViewModelCreationExtras());
            kotlin.jvm.internal.b bVarA = j.a(TutorialGuideNoiseViewModel.class);
            String strA = bVarA.a();
            if (strA == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            TutorialGuideNoiseViewModel tutorialGuideNoiseViewModel = (TutorialGuideNoiseViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
            this.f21703z = tutorialGuideNoiseViewModel.f21705b;
            this.f21701x = tutorialGuideNoiseViewModel.f21706c;
            this.f21696A = tutorialGuideNoiseViewModel.f21707d;
            this.f21702y = tutorialGuideNoiseViewModel.f21708e;
            this.f21699D = tutorialGuideNoiseViewModel.f21709f;
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        TutorialGuideNoisePreferenceFragment tutorialGuideNoisePreferenceFragment;
        COUIPagerFooterPreference cOUIPagerFooterPreference;
        DetailMainViewModel detailMainViewModel;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        A.b("TutorialGuideNoisePreferenceFragment", "onViewCreated");
        if (this.f21700w != null) {
            androidx.fragment.app.f activity = getActivity();
            DetailMainViewModel detailMainViewModel2 = this.f21700w;
            h.b(detailMainViewModel2);
            NoiseReductionItem noiseReductionItem = new NoiseReductionItem(activity, detailMainViewModel2, this);
            noiseReductionItem.setIsInTutorialGuide();
            COUIPreferenceCategory cOUIPreferenceCategory = (COUIPreferenceCategory) this.f11713b.f11752g.f("container_category");
            if (cOUIPreferenceCategory != null) {
                cOUIPreferenceCategory.e(noiseReductionItem);
            }
            String str = this.f21703z;
            if (str == null || (detailMainViewModel = this.f21700w) == null) {
                tutorialGuideNoisePreferenceFragment = this;
            } else {
                tutorialGuideNoisePreferenceFragment = this;
                detailMainViewModel.d(str).e(getViewLifecycleOwner(), new a(new TutorialGuideNoisePreferenceFragment$onViewCreated$1$1(1, tutorialGuideNoisePreferenceFragment, TutorialGuideNoisePreferenceFragment.class, "onConnectStateChanged", "onConnectStateChanged(I)V", 0)));
            }
            c cVar = tutorialGuideNoisePreferenceFragment.f21699D;
            if (cVar == null || cVar.getRealtimeNoiseFunctionIntroduce() == null || (cOUIPagerFooterPreference = tutorialGuideNoisePreferenceFragment.f21698C) == null) {
                return;
            }
            cOUIPagerFooterPreference.setVisible(true);
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        A.b("TutorialGuideNoisePreferenceFragment", "onCreatePreferences");
        o(R.xml.melody_ui_tutorial_guide_noise_preference);
        this.f21697B = (COUIJumpPreference) a("key_guide_noise_earphone_setting_preference");
        this.f21698C = (COUIPagerFooterPreference) a("key_guide_noise_earphone_introduce");
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final RecyclerView q(LayoutInflater layoutInflater, ViewGroup parent) {
        h.e(parent, "parent");
        A.b("TutorialGuideNoisePreferenceFragment", "onCreateRecyclerView");
        View viewInflate = layoutInflater.inflate(R.layout.melody_ui_preference_recyclerview, parent, false);
        h.c(viewInflate, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) viewInflate;
        requireContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        return recyclerView;
    }
}
