package com.oplus.melody.ui.component.control;

import O7.l;
import X.d;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.f;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.grid.COUIPercentWidthRecyclerView;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.heytap.headset.R;
import com.oplus.melody.ui.component.control.dialog.MultiSelectVO;
import com.oplus.melody.ui.widget.MelodyRadioPreference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: CustomLongPressPreferenceFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/oplus/melody/ui/component/control/CustomLongPressPreferenceFragment;", "Lcom/oplus/melody/ui/base/BaseCOUIPreferenceFragment;", "<init>", "()V", "mLongPressCategory", "Lcom/coui/appcompat/preference/COUIPreferenceCategory;", "multiSelectVO", "Lcom/oplus/melody/ui/component/control/dialog/MultiSelectVO;", "mViewModel", "Lcom/oplus/melody/ui/component/control/EarControlViewModel;", "mRadioPreferenceChangeListener", "Landroidx/preference/Preference$OnPreferenceChangeListener;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", "view", "Landroid/view/View;", "getRadioCheckData", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CustomLongPressPreferenceFragment extends F8.b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public MultiSelectVO f20403A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public EarControlViewModel f20404B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final C0.a f20405C = new C0.a(this, 3);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public COUIPreferenceCategory f20406z;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.control.CustomLongPressPreferenceFragment$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: CustomLongPressPreferenceFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/oplus/melody/ui/component/control/CustomLongPressPreferenceFragment$onViewCreated$1", "Landroidx/recyclerview/widget/LinearLayoutManager;", "canScrollVertically", "", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends LinearLayoutManager {
        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
        public final boolean q() {
            return false;
        }
    }

    @Override // F8.b, com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = this.f11714c;
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(false);
        }
        if (recyclerView != null) {
            getActivity();
            recyclerView.setLayoutManager(new AnonymousClass1(1));
        }
        if (getParentFragment() == null || !(recyclerView instanceof COUIPercentWidthRecyclerView)) {
            return;
        }
        ((COUIPercentWidthRecyclerView) recyclerView).setPercentIndentEnabled(false);
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        l<Boolean> lVar;
        List<String> entryLongPressTypes;
        EarControlViewModel earControlViewModel;
        o(R.xml.melody_ui_custom_long_press_preference);
        Bundle arguments = getArguments();
        MultiSelectVO multiSelectVO = arguments != null ? (MultiSelectVO) arguments.getParcelable("route_value") : null;
        if (multiSelectVO == null) {
            multiSelectVO = null;
        }
        this.f20403A = multiSelectVO;
        this.f20406z = (COUIPreferenceCategory) a("key_category_long_press");
        f fVarRequireActivity = requireActivity();
        h.d(fVarRequireActivity, "requireActivity(...)");
        O viewModelStore = fVarRequireActivity.getViewModelStore();
        N.b defaultViewModelProviderFactory = fVarRequireActivity.getDefaultViewModelProviderFactory();
        d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, fVarRequireActivity.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(EarControlViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        EarControlViewModel earControlViewModel2 = (EarControlViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f20404B = earControlViewModel2;
        String str = earControlViewModel2.f20415d;
        if (str != null && str.length() == 0 && (earControlViewModel = this.f20404B) != null) {
            MultiSelectVO multiSelectVO2 = this.f20403A;
            earControlViewModel.f20415d = multiSelectVO2 != null ? multiSelectVO2.getChooseValue() : null;
        }
        MultiSelectVO multiSelectVO3 = this.f20403A;
        if (multiSelectVO3 != null && (entryLongPressTypes = multiSelectVO3.getEntryLongPressTypes()) != null) {
            int i10 = 0;
            for (Object obj : entryLongPressTypes) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    Kb.l.h();
                    throw null;
                }
                String str2 = (String) obj;
                Context contextRequireContext = requireContext();
                h.d(contextRequireContext, "requireContext(...)");
                MelodyRadioPreference melodyRadioPreference = new MelodyRadioPreference(contextRequireContext, null);
                melodyRadioPreference.setTitle(str2);
                EarControlViewModel earControlViewModel3 = this.f20404B;
                melodyRadioPreference.setChecked(h.a(earControlViewModel3 != null ? earControlViewModel3.f20415d : null, str2));
                melodyRadioPreference.setKey(str2);
                melodyRadioPreference.setOrder(i10);
                melodyRadioPreference.setPersistent(false);
                melodyRadioPreference.setOnPreferenceChangeListener(this.f20405C);
                String strF = K8.a.f(melodyRadioPreference.getContext(), melodyRadioPreference.getTitle(), null, null, false);
                if (strF != null) {
                    melodyRadioPreference.setSummary(strF);
                }
                COUIPreferenceCategory cOUIPreferenceCategory = this.f20406z;
                if (cOUIPreferenceCategory != null) {
                    cOUIPreferenceCategory.e(melodyRadioPreference);
                }
                i10 = i11;
            }
        }
        EarControlViewModel earControlViewModel4 = this.f20404B;
        if (earControlViewModel4 == null || (lVar = earControlViewModel4.f20417f) == null) {
            return;
        }
        lVar.m(Boolean.valueOf(h.a(earControlViewModel4.f20415d, getString(R.string.melody_common_detail_main_set_noise_reduction))));
    }
}
