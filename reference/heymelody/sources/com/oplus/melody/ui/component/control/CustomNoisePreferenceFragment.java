package com.oplus.melody.ui.component.control;

import F9.s;
import Kb.l;
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
import com.coui.appcompat.preference.COUICheckBoxPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.heytap.headset.R;
import com.oplus.melody.ui.component.control.dialog.MultiSelectVO;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: CustomNoisePreferenceFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/oplus/melody/ui/component/control/CustomNoisePreferenceFragment;", "Lcom/oplus/melody/ui/base/BaseCOUIPreferenceFragment;", "<init>", "()V", "mNoiseTypeCategory", "Lcom/coui/appcompat/preference/COUIPreferenceCategory;", "multiSelectVO", "Lcom/oplus/melody/ui/component/control/dialog/MultiSelectVO;", "mViewModel", "Lcom/oplus/melody/ui/component/control/EarControlViewModel;", "mRadioPreferenceChangeListener", "Landroidx/preference/Preference$OnPreferenceChangeListener;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", "view", "Landroid/view/View;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CustomNoisePreferenceFragment extends F8.b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public MultiSelectVO f20407A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public EarControlViewModel f20408B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final s f20409C = new s(this, 3);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public COUIPreferenceCategory f20410z;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.control.CustomNoisePreferenceFragment$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: CustomNoisePreferenceFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/oplus/melody/ui/component/control/CustomNoisePreferenceFragment$onViewCreated$1", "Landroidx/recyclerview/widget/LinearLayoutManager;", "canScrollVertically", "", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
        o(R.xml.melody_ui_custom_noise_preference);
        Bundle arguments = getArguments();
        MultiSelectVO multiSelectVO = arguments != null ? (MultiSelectVO) arguments.getParcelable("route_value") : null;
        if (multiSelectVO == null) {
            multiSelectVO = null;
        }
        this.f20407A = multiSelectVO;
        this.f20410z = (COUIPreferenceCategory) a("key_category_noise_type");
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
        EarControlViewModel earControlViewModel = (EarControlViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f20408B = earControlViewModel;
        MultiSelectVO multiSelectVO2 = this.f20407A;
        if (multiSelectVO2 != null) {
            if (earControlViewModel.f20416e.isEmpty() && multiSelectVO2.getChooseValueList() != null) {
                EarControlViewModel earControlViewModel2 = this.f20408B;
                if (earControlViewModel2 == null) {
                    h.i("mViewModel");
                    throw null;
                }
                ArrayList arrayList = earControlViewModel2.f20416e;
                List<String> chooseValueList = multiSelectVO2.getChooseValueList();
                h.d(chooseValueList, "getChooseValueList(...)");
                arrayList.addAll(chooseValueList);
            }
            List<String> entries = multiSelectVO2.getEntries();
            h.d(entries, "getEntries(...)");
            int i10 = 0;
            for (Object obj : entries) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    l.h();
                    throw null;
                }
                String str = (String) obj;
                COUICheckBoxPreference cOUICheckBoxPreference = new COUICheckBoxPreference(requireContext());
                cOUICheckBoxPreference.setTitle(str);
                EarControlViewModel earControlViewModel3 = this.f20408B;
                if (earControlViewModel3 == null) {
                    h.i("mViewModel");
                    throw null;
                }
                cOUICheckBoxPreference.setChecked(earControlViewModel3.f20416e.contains(str));
                cOUICheckBoxPreference.setKey(str);
                cOUICheckBoxPreference.setOrder(i10);
                cOUICheckBoxPreference.setSummary(multiSelectVO2.getEntrySummaries().get(i10));
                cOUICheckBoxPreference.setPersistent(false);
                cOUICheckBoxPreference.setOnPreferenceChangeListener(this.f20409C);
                COUIPreferenceCategory cOUIPreferenceCategory = this.f20410z;
                if (cOUIPreferenceCategory != null) {
                    cOUIPreferenceCategory.e(cOUICheckBoxPreference);
                }
                i10 = i11;
            }
        }
        COUIPreferenceCategory cOUIPreferenceCategory2 = this.f20410z;
        if (cOUIPreferenceCategory2 != null) {
            Context contextRequireContext = requireContext();
            EarControlViewModel earControlViewModel4 = this.f20408B;
            if (earControlViewModel4 == null) {
                h.i("mViewModel");
                throw null;
            }
            cOUIPreferenceCategory2.setTitle(K8.a.c(contextRequireContext, earControlViewModel4.f20416e.size()));
        }
    }
}
