package com.oplus.melody.ui.component.control.dialog;

import B9.d;
import D1.f;
import D7.C0370d;
import Jb.l;
import Kb.q;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.widget.e;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.coui.appcompat.panel.COUIBottomSheetDialogFragment;
import com.coui.appcompat.panel.COUIPanelFragment;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.heytap.headset.R;
import com.oplus.melody.ui.component.control.CustomLongPressPreferenceFragment;
import com.oplus.melody.ui.component.control.CustomNoisePreferenceFragment;
import com.oplus.melody.ui.component.control.EarControlViewModel;
import com.oplus.melody.ui.component.control.dialog.CustomLongPressPanelFragment;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import com.oplus.melody.ui.widget.MelodyRadioPreference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: CustomLongPressPanelFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/oplus/melody/ui/component/control/dialog/CustomLongPressPanelFragment;", "Lcom/coui/appcompat/panel/COUIPanelFragment;", "<init>", "()V", "multiSelectVO", "Lcom/oplus/melody/ui/component/control/dialog/MultiSelectVO;", "mCustomLongPressPreferenceFragment", "Lcom/oplus/melody/ui/component/control/CustomLongPressPreferenceFragment;", "mCustomNoisePreferenceFragment", "Lcom/oplus/melody/ui/component/control/CustomNoisePreferenceFragment;", "preferenceNoiseContainer", "Landroid/widget/FrameLayout;", "mViewModel", "Lcom/oplus/melody/ui/component/control/EarControlViewModel;", "onStart", "", "initView", "panelView", "Landroid/view/View;", "finish", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CustomLongPressPanelFragment extends COUIPanelFragment {
    private CustomLongPressPreferenceFragment mCustomLongPressPreferenceFragment;
    private CustomNoisePreferenceFragment mCustomNoisePreferenceFragment;
    private EarControlViewModel mViewModel;
    private MultiSelectVO multiSelectVO;
    private FrameLayout preferenceNoiseContainer;

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f20462a;

        public a(List list) {
            this.f20462a = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            List list = this.f20462a;
            return f.l(Integer.valueOf(list.indexOf((String) t10)), Integer.valueOf(list.indexOf((String) t11)));
        }
    }

    /* JADX INFO: compiled from: CustomLongPressPanelFragment.kt */
    public static final class b implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f20463a;

        public b(d dVar) {
            this.f20463a = dVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20463a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) throws Throwable {
            this.f20463a.d(obj);
        }
    }

    public static l o(CustomLongPressPanelFragment customLongPressPanelFragment, Boolean bool) {
        FrameLayout frameLayout = customLongPressPanelFragment.preferenceNoiseContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(bool.booleanValue() ? 0 : 4);
        }
        return l.f2618a;
    }

    public static void p(CustomLongPressPanelFragment customLongPressPanelFragment, Integer num, MenuItem it) {
        String key;
        List<String> entries;
        COUIPreferenceCategory cOUIPreferenceCategory;
        h.e(it, "it");
        CustomLongPressPreferenceFragment customLongPressPreferenceFragment = customLongPressPanelFragment.mCustomLongPressPreferenceFragment;
        if (customLongPressPreferenceFragment == null || (cOUIPreferenceCategory = customLongPressPreferenceFragment.f20406z) == null) {
            key = null;
        } else {
            int size = cOUIPreferenceCategory.f11662c.size();
            for (int i10 = 0; i10 < size; i10++) {
                Preference preferenceH = cOUIPreferenceCategory.h(i10);
                h.c(preferenceH, "null cannot be cast to non-null type com.oplus.melody.ui.widget.MelodyRadioPreference");
                MelodyRadioPreference melodyRadioPreference = (MelodyRadioPreference) preferenceH;
                if (melodyRadioPreference.isChecked()) {
                    key = melodyRadioPreference.getKey();
                    break;
                }
            }
            key = null;
        }
        MultiSelectVO multiSelectVO = customLongPressPanelFragment.multiSelectVO;
        if (multiSelectVO != null && (entries = multiSelectVO.getEntries()) != null) {
            EarControlViewModel earControlViewModel = customLongPressPanelFragment.mViewModel;
            if (earControlViewModel == null) {
                h.i("mViewModel");
                throw null;
            }
            ArrayList arrayList = earControlViewModel.f20416e;
            h.d(arrayList, "getCurrentNoiseList(...)");
            C0370d.a(new H8.d(q.D(arrayList, new a(entries)), new Pair(num, key)));
        }
        EarControlViewModel earControlViewModel2 = customLongPressPanelFragment.mViewModel;
        if (earControlViewModel2 == null) {
            h.i("mViewModel");
            throw null;
        }
        earControlViewModel2.f20415d = "";
        earControlViewModel2.f20416e.clear();
        Fragment parentFragment = customLongPressPanelFragment.getParentFragment();
        if (parentFragment instanceof COUIBottomSheetDialogFragment) {
            ((COUIBottomSheetDialogFragment) parentFragment).dismiss();
        }
        customLongPressPanelFragment.onDestroy();
    }

    public static void q(CustomLongPressPanelFragment customLongPressPanelFragment, MenuItem it) {
        h.e(it, "it");
        EarControlViewModel earControlViewModel = customLongPressPanelFragment.mViewModel;
        if (earControlViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        earControlViewModel.f20415d = "";
        earControlViewModel.f20416e.clear();
        Fragment parentFragment = customLongPressPanelFragment.getParentFragment();
        if (parentFragment instanceof COUIBottomSheetDialogFragment) {
            ((COUIBottomSheetDialogFragment) parentFragment).dismiss();
        }
        customLongPressPanelFragment.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coui.appcompat.panel.COUIPanelFragment
    public final void initView(View panelView) {
        super.initView(panelView);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        View contentView = getContentView();
        h.c(contentView, "null cannot be cast to non-null type android.view.ViewGroup");
        View viewInflate = layoutInflaterFrom.inflate(R.layout.melody_ui_custom_long_press_dialog, (ViewGroup) contentView, true);
        getDragView().setVisibility(4);
        this.preferenceNoiseContainer = (FrameLayout) viewInflate.findViewById(R.id.preference_noise_container);
        Bundle arguments = getArguments();
        MultiSelectVO multiSelectVO = arguments != null ? (MultiSelectVO) arguments.getParcelable("route_value") : null;
        if (multiSelectVO == null) {
            multiSelectVO = null;
        }
        this.multiSelectVO = multiSelectVO;
        Bundle arguments2 = getArguments();
        final Integer numValueOf = arguments2 != null ? Integer.valueOf(arguments2.getInt("route_value2")) : null;
        Bundle bundle = new Bundle();
        bundle.putParcelable("route_value", this.multiSelectVO);
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.d(fVarRequireActivity, "requireActivity(...)");
        O viewModelStore = fVarRequireActivity.getViewModelStore();
        N.b defaultViewModelProviderFactory = fVarRequireActivity.getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, fVarRequireActivity.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(EarControlViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        EarControlViewModel earControlViewModel = (EarControlViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.mViewModel = earControlViewModel;
        earControlViewModel.f20417f.e(requireActivity(), new b(new d(this, 4)));
        CustomLongPressPreferenceFragment customLongPressPreferenceFragment = new CustomLongPressPreferenceFragment();
        customLongPressPreferenceFragment.setArguments(bundle);
        this.mCustomLongPressPreferenceFragment = customLongPressPreferenceFragment;
        FragmentManager childFragmentManager = getChildFragmentManager();
        childFragmentManager.getClass();
        C0585a c0585a = new C0585a(childFragmentManager);
        c0585a.d(R.id.preferences_container, customLongPressPreferenceFragment, null);
        c0585a.g();
        CustomNoisePreferenceFragment customNoisePreferenceFragment = new CustomNoisePreferenceFragment();
        customNoisePreferenceFragment.setArguments(bundle);
        this.mCustomNoisePreferenceFragment = customNoisePreferenceFragment;
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        childFragmentManager2.getClass();
        C0585a c0585a2 = new C0585a(childFragmentManager2);
        c0585a2.d(R.id.preference_noise_container, customNoisePreferenceFragment, null);
        c0585a2.g();
        MelodyCompatToolbar melodyCompatToolbar = (MelodyCompatToolbar) viewInflate.findViewById(R.id.toolbar);
        Context contextRequireContext = requireContext();
        MultiSelectVO multiSelectVO2 = this.multiSelectVO;
        melodyCompatToolbar.setTitle(contextRequireContext.getString(multiSelectVO2 != null ? multiSelectVO2.getTitleResId() : 0));
        melodyCompatToolbar.setIsTitleCenterStyle(true);
        melodyCompatToolbar.inflateMenu(R.menu.melody_ui_menu_long_press_cancel_done);
        Menu menu = melodyCompatToolbar.getMenu();
        menu.findItem(R.id.done).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: H8.b
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CustomLongPressPanelFragment.p(this.f2055a, numValueOf, menuItem);
                return false;
            }
        });
        menu.findItem(R.id.cancel).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: H8.c
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CustomLongPressPanelFragment.q(this.f2057a, menuItem);
                return false;
            }
        });
        melodyCompatToolbar.setPadding(melodyCompatToolbar.getPaddingLeft(), 0, melodyCompatToolbar.getPaddingRight(), 0);
        View titleView = melodyCompatToolbar.getTitleView();
        TextView textView = titleView instanceof TextView ? (TextView) titleView : 0;
        if (textView != 0) {
            textView.setSingleLine(true);
            if (Build.VERSION.SDK_INT >= 27) {
                e.a.b(textView);
            } else if (textView instanceof androidx.core.widget.b) {
                ((androidx.core.widget.b) textView).setAutoSizeTextTypeWithDefaults(1);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        View view;
        super.onStart();
        androidx.fragment.app.f activity = getActivity();
        if (activity == null || (view = getView()) == null) {
            return;
        }
        view.setBackgroundColor(activity.getColor(R.color.coui_color_background_with_card));
    }
}
