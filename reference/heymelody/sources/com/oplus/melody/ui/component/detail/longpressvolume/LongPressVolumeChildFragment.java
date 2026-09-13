package com.oplus.melody.ui.component.detail.longpressvolume;

import A6.g;
import A9.c;
import A9.e;
import D7.C0379m;
import D7.o0;
import F8.b;
import Wb.l;
import X.d;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.f;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.grid.COUIPercentWidthRecyclerView;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0897c;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.component.control.preference.ColorSingleSelectPreference;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.longpressvolume.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: LongPressVolumeChildFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 42\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0016J\u001a\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010'\u001a\u00020\u0018H\u0002J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u0018H\u0002J\u0016\u0010,\u001a\u00020\u00182\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002J\u0018\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u000203H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/oplus/melody/ui/component/detail/longpressvolume/LongPressVolumeChildFragment;", "Lcom/oplus/melody/ui/base/BaseCOUIPreferenceFragment;", "<init>", "()V", "mLongPressVolumeSwitchPreference", "Lcom/coui/appcompat/preference/COUISwitchPreference;", "mLongPressCategory", "Lcom/coui/appcompat/preference/COUIPreferenceCategory;", "mLongPressCallCategory", "mLongPressLeftPreference", "Lcom/oplus/melody/ui/component/control/preference/ColorSingleSelectPreference;", "mLongPressRightPreference", "mLongPressBothPreference", "mLongPressVolumeVM", "Lcom/oplus/melody/ui/component/detail/longpressvolume/LongPressVolumeViewModel;", "mAddress", "", "mProductId", "mProductColor", "mProductName", "mActionFrom", "mNoticeDialog", "Landroidx/appcompat/app/AlertDialog;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onCreate", "onPreferenceTreeClick", "preference", "Landroidx/preference/Preference;", "onViewCreated", "view", "Landroid/view/View;", "initDataObserver", "onLongPressVolumeStateChanged", "longPressVolumeSwitchInfoVO", "Lcom/oplus/melody/ui/component/detail/longpressvolume/LongPressVolumeSwitchInfoVO;", "showNoticeDialog", "onKeyFunctionInfoChanged", "functionList", "", "Lcom/oplus/melody/model/repository/earphone/KeyFunctionInfoDTO;", "trackFunEarControl", "value", "controlType", "", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LongPressVolumeChildFragment extends b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public COUIPreferenceCategory f21120A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public COUIPreferenceCategory f21121B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public ColorSingleSelectPreference f21122C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public ColorSingleSelectPreference f21123D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public LongPressVolumeViewModel f21124E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public String f21125F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public String f21126G;
    public String H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public String f21127I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public f f21128J;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public COUISwitchPreference f21129z;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.longpressvolume.a$a */
    /* JADX INFO: compiled from: LongPressVolumeChildFragment.kt */
    public static final class a implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctionReferenceImpl f21130a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(l lVar) {
            this.f21130a = (FunctionReferenceImpl) lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21130a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [Wb.l, kotlin.jvm.internal.FunctionReferenceImpl] */
        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21130a.d(obj);
        }
    }

    @Override // androidx.preference.g, androidx.preference.k.b
    public final boolean f(Preference preference) {
        if (h.a(preference.getKey(), "key_long_press_volume_switch")) {
            boolean zIsChecked = ((COUISwitchPreference) preference).isChecked();
            if (this.f21124E != null) {
                String str = this.f21125F;
                if (str == null) {
                    h.i("mAddress");
                    throw null;
                }
                CompletableFuture completableFutureE0 = AbstractC0939b.E().E0(53, zIsChecked, str);
                h.d(completableFutureE0, "setLongPressVolumeStatus(...)");
                completableFutureE0.whenCompleteAsync((BiConsumer) new c(new A9.a(this, zIsChecked, 0), 0), (Executor) o0.c.f1144b);
            }
        }
        return super.f(preference);
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        String strH = C0914u.h(activity != null ? activity.getIntent() : null, "device_mac_info");
        if (strH == null) {
            strH = "";
        }
        this.f21125F = strH;
        androidx.fragment.app.f activity2 = getActivity();
        String strH2 = C0914u.h(activity2 != null ? activity2.getIntent() : null, "product_id");
        if (strH2 == null) {
            strH2 = "";
        }
        this.f21126G = strH2;
        androidx.fragment.app.f activity3 = getActivity();
        String strH3 = C0914u.h(activity3 != null ? activity3.getIntent() : null, "product_color");
        if (strH3 == null) {
            strH3 = "";
        }
        this.H = strH3;
        androidx.fragment.app.f activity4 = getActivity();
        String strH4 = C0914u.h(activity4 != null ? activity4.getIntent() : null, "device_name");
        this.f21127I = strH4 != null ? strH4 : "";
        androidx.fragment.app.f activity5 = getActivity();
        C0914u.h(activity5 != null ? activity5.getIntent() : null, "route_from");
        String str = this.f21125F;
        if (str == null) {
            h.i("mAddress");
            throw null;
        }
        if (TextUtils.isEmpty(str)) {
            A.h("LongPressVolumeChildFragment", "onCreate mAddress is empty");
            requireActivity().finish();
            return;
        }
        String str2 = this.f21126G;
        if (str2 == null) {
            h.i("mProductId");
            throw null;
        }
        if (TextUtils.isEmpty(str2)) {
            A.h("LongPressVolumeChildFragment", "onCreate productId is empty");
            requireActivity().finish();
            return;
        }
        String str3 = this.H;
        if (str3 == null) {
            h.i("mProductColor");
            throw null;
        }
        if (TextUtils.isEmpty(str3)) {
            A.h("LongPressVolumeChildFragment", "onCreate mProductColor is empty");
            requireActivity().finish();
            return;
        }
        String str4 = this.f21127I;
        if (str4 == null) {
            h.i("mProductName");
            throw null;
        }
        if (TextUtils.isEmpty(str4)) {
            A.h("LongPressVolumeChildFragment", "onCreate productName is empty");
            requireActivity().finish();
            return;
        }
        O store = getViewModelStore();
        N.b factory = getDefaultViewModelProviderFactory();
        W.a defaultViewModelCreationExtras = getDefaultViewModelCreationExtras();
        h.e(store, "store");
        h.e(factory, "factory");
        d dVarB = g.b(defaultViewModelCreationExtras, "defaultCreationExtras", store, factory, defaultViewModelCreationExtras);
        kotlin.jvm.internal.b bVarA = j.a(LongPressVolumeViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f21124E = (LongPressVolumeViewModel) dVarB.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        Preference preferenceA = a("key_long_press_volume_switch");
        h.b(preferenceA);
        this.f21129z = (COUISwitchPreference) preferenceA;
        this.f21120A = (COUIPreferenceCategory) a("key_long_press_category");
        this.f21121B = (COUIPreferenceCategory) a("key_long_press_call_category");
        this.f21122C = (ColorSingleSelectPreference) a("key_long_press_left_click");
        this.f21123D = (ColorSingleSelectPreference) a("key_long_press_right_click");
        ColorSingleSelectPreference colorSingleSelectPreference = (ColorSingleSelectPreference) a("key_long_press_both_click");
        if (colorSingleSelectPreference != null) {
            if (!colorSingleSelectPreference.f20567M) {
                colorSingleSelectPreference.f20567M = true;
            }
            if (colorSingleSelectPreference.f14604y != null) {
                colorSingleSelectPreference.f14604y = null;
                colorSingleSelectPreference.notifyChanged();
            }
        }
        String[] strArr = {getResources().getString(R.string.melody_ui_earphone_function_control_none), getResources().getString(R.string.melody_ui_earphone_function_control_increace_volume), getResources().getString(R.string.melody_ui_earphone_function_control_decreace_volume)};
        ColorSingleSelectPreference colorSingleSelectPreference2 = this.f21122C;
        if (colorSingleSelectPreference2 != null) {
            colorSingleSelectPreference2.f11637a = getResources().getString(R.string.melody_ui_earphone_function_control_long_press_left);
            String[] strArr2 = strArr;
            colorSingleSelectPreference2.f11649s = strArr2;
            colorSingleSelectPreference2.f11650t = strArr2;
            colorSingleSelectPreference2.setAssignment(getResources().getString(R.string.melody_ui_earphone_function_control_decreace_volume));
            colorSingleSelectPreference2.h(getResources().getString(R.string.melody_ui_earphone_function_control_decreace_volume));
            colorSingleSelectPreference2.f11638b = getResources().getString(R.string.melody_ui_long_press_volume_dialog_message);
            colorSingleSelectPreference2.H = false;
            colorSingleSelectPreference2.setOnPreferenceChangeListener(new e(0, colorSingleSelectPreference2, this));
        }
        ColorSingleSelectPreference colorSingleSelectPreference3 = this.f21123D;
        if (colorSingleSelectPreference3 != null) {
            colorSingleSelectPreference3.f11637a = getResources().getString(R.string.melody_ui_earphone_function_control_long_press_right);
            String[] strArr3 = strArr;
            colorSingleSelectPreference3.f11649s = strArr3;
            colorSingleSelectPreference3.f11650t = strArr3;
            colorSingleSelectPreference3.setAssignment(getResources().getString(R.string.melody_ui_earphone_function_control_increace_volume));
            colorSingleSelectPreference3.h(getResources().getString(R.string.melody_ui_earphone_function_control_increace_volume));
            colorSingleSelectPreference3.f11638b = getResources().getString(R.string.melody_ui_long_press_volume_dialog_message);
            colorSingleSelectPreference3.H = false;
            colorSingleSelectPreference3.setOnPreferenceChangeListener(new A9.f(0, colorSingleSelectPreference3, this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        requireActivity().finish();
        return true;
    }

    @Override // F8.b, com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        if ((activity instanceof F8.a ? (F8.a) activity : null) != null) {
            COUIToolbar cOUIToolbar = (COUIToolbar) view.findViewById(R.id.tool_bar);
            if (cOUIToolbar != null) {
                cOUIToolbar.setVisibility(8);
            }
            RecyclerView recyclerView = this.f11714c;
            if (recyclerView != null) {
                recyclerView.setNestedScrollingEnabled(false);
            }
        }
        RecyclerView recyclerView2 = this.f11714c;
        if (recyclerView2 != null) {
            if (getParentFragment() != null && (recyclerView2 instanceof COUIPercentWidthRecyclerView)) {
                ((COUIPercentWidthRecyclerView) recyclerView2).setPercentIndentEnabled(false);
            }
            recyclerView2.setItemAnimator(null);
        }
        if (C0897c.b(requireActivity()) || C0897c.c(requireActivity())) {
            View viewFindViewById = view.findViewById(android.R.id.list_container);
            h.d(viewFindViewById, "findViewById(...)");
            ViewGroup.LayoutParams layoutParams = ((FrameLayout) viewFindViewById).getLayoutParams();
            h.c(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMarginStart((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
            marginLayoutParams.setMarginEnd((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
        }
        if (this.f21124E != null) {
            String str = this.f21125F;
            if (str == null) {
                h.i("mAddress");
                throw null;
            }
            C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new A6.e(1))).e(getViewLifecycleOwner(), new a(new LongPressVolumeChildFragment$initDataObserver$1(1, this, LongPressVolumeChildFragment.class, "onKeyFunctionInfoChanged", "onKeyFunctionInfoChanged(Ljava/util/List;)V", 0)));
        }
        if (this.f21124E != null) {
            Context contextRequireContext = requireContext();
            h.d(contextRequireContext, "requireContext(...)");
            String str2 = this.f21125F;
            if (str2 == null) {
                h.i("mAddress");
                throw null;
            }
            AbstractC0939b.E().F(contextRequireContext, str2);
        }
        if (this.f21124E != null) {
            String str3 = this.f21125F;
            if (str3 != null) {
                C0379m.b(C0379m.g(AbstractC0939b.E().v(str3), new A6.b(2))).e(getViewLifecycleOwner(), new a(new LongPressVolumeChildFragment$initDataObserver$2(1, this, LongPressVolumeChildFragment.class, "onLongPressVolumeStateChanged", "onLongPressVolumeStateChanged(Lcom/oplus/melody/ui/component/detail/longpressvolume/LongPressVolumeSwitchInfoVO;)V", 0)));
            } else {
                h.i("mAddress");
                throw null;
            }
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        o(R.xml.melody_ui_long_press_volume_preference);
    }

    public final void s(int i10, String str) {
        Context context = getContext();
        String str2 = this.f21127I;
        if (str2 == null) {
            h.i("mProductName");
            throw null;
        }
        int iB = (context == null || TextUtils.isEmpty(str)) ? -1 : com.oplus.melody.model.repository.earphone.N.b(K8.a.a(context, str, str2), str2);
        String str3 = this.f21126G;
        if (str3 == null) {
            h.i("mProductId");
            throw null;
        }
        String str4 = this.f21125F;
        if (str4 != null) {
            C1264t.u(str3, str4, i10 + 1, 4, com.oplus.melody.model.repository.earphone.N.t(this.f21124E != null ? AbstractC0939b.E().w(str4) : null), String.valueOf(iB));
        } else {
            h.i("mAddress");
            throw null;
        }
    }
}
