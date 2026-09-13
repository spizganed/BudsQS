package com.oplus.melody.ui.component.detail.taplevelsetting;

import A6.e;
import A6.g;
import D7.C0379m;
import D7.o0;
import Wb.l;
import X.d;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import com.coui.appcompat.preference.COUIPagerFooterPreference;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0897c;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.widget.MelodyTapLevelSettingGuidePreference;
import com.oplus.melody.ui.widget.MelodyTapLevelSettingSeekBarPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.taplevelsetting.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: TapLevelSettingFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010 \u001a\u00020\u0014H\u0002J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/oplus/melody/ui/component/detail/taplevelsetting/TapLevelSettingFragment;", "Lcom/oplus/melody/ui/base/BaseCOUIPreferenceFragment;", "<init>", "()V", "mTapLevelSettingVM", "Lcom/oplus/melody/ui/component/detail/taplevelsetting/TapLevelSettingViewModel;", "mTapLevelSettingSeekBarPreference", "Lcom/oplus/melody/ui/widget/MelodyTapLevelSettingSeekBarPreference;", "mTapLevelSettingGuidePreference", "Lcom/oplus/melody/ui/widget/MelodyTapLevelSettingGuidePreference;", "mFooterPreference", "Lcom/coui/appcompat/preference/COUIPagerFooterPreference;", "mAddress", "", "mProductId", "mProductColor", "mProductName", "mLoadingCountDownTimer", "Landroid/os/CountDownTimer;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onCreate", "onViewCreated", "view", "Landroid/view/View;", "initDataObserver", "onTapLevelSettingValueStateChanged", "tapLevelSettingInfoVO", "Lcom/oplus/melody/ui/component/detail/taplevelsetting/TapLevelSettingInfoVO;", "onDestroy", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TapLevelSettingFragment extends F8.b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public MelodyTapLevelSettingSeekBarPreference f21301A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public MelodyTapLevelSettingGuidePreference f21302B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public COUIPagerFooterPreference f21303C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public String f21304D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public String f21305E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public String f21306F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public String f21307G;
    public a H;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TapLevelSettingViewModel f21308z;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.taplevelsetting.a$b */
    /* JADX INFO: compiled from: TapLevelSettingFragment.kt */
    public static final class b {
        public b() {
        }

        public final void a(boolean z2) {
            COUIPagerFooterPreference cOUIPagerFooterPreference = TapLevelSettingFragment.this.f21303C;
            if (cOUIPagerFooterPreference != null) {
                cOUIPagerFooterPreference.setVisible(z2);
            }
        }

        public final void b(int i10) {
            if (i10 > 0) {
                TapLevelSettingFragment tapLevelSettingFragment = TapLevelSettingFragment.this;
                if (tapLevelSettingFragment.f21308z != null) {
                    AbstractC0939b.E().G0(i10, tapLevelSettingFragment.f21304D);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.taplevelsetting.a$c */
    /* JADX INFO: compiled from: TapLevelSettingFragment.kt */
    public static final class c implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21311a;

        public c(l lVar) {
            this.f21311a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21311a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21311a.d(obj);
        }
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        MelodyTapLevelSettingGuidePreference melodyTapLevelSettingGuidePreference = null;
        String strH = C0914u.h(activity != null ? activity.getIntent() : null, "device_mac_info");
        if (strH == null) {
            strH = "";
        }
        this.f21304D = strH;
        androidx.fragment.app.f activity2 = getActivity();
        String strH2 = C0914u.h(activity2 != null ? activity2.getIntent() : null, "product_id");
        if (strH2 == null) {
            strH2 = "";
        }
        this.f21305E = strH2;
        androidx.fragment.app.f activity3 = getActivity();
        String strH3 = C0914u.h(activity3 != null ? activity3.getIntent() : null, "product_color");
        if (strH3 == null) {
            strH3 = "";
        }
        this.f21306F = strH3;
        androidx.fragment.app.f activity4 = getActivity();
        String strH4 = C0914u.h(activity4 != null ? activity4.getIntent() : null, "device_name");
        this.f21307G = strH4 != null ? strH4 : "";
        if (TextUtils.isEmpty(this.f21304D)) {
            A.h("TapLevelSettingFragment", "onCreate mAddress is empty");
            requireActivity().finish();
            return;
        }
        if (TextUtils.isEmpty(this.f21305E)) {
            A.h("TapLevelSettingFragment", "onCreate productId is empty");
            requireActivity().finish();
            return;
        }
        if (TextUtils.isEmpty(this.f21306F)) {
            A.h("TapLevelSettingFragment", "onCreate mProductColor is empty");
            requireActivity().finish();
            return;
        }
        if (TextUtils.isEmpty(this.f21307G)) {
            A.h("TapLevelSettingFragment", "onCreate productName is empty");
            requireActivity().finish();
            return;
        }
        this.H = new a();
        O store = getViewModelStore();
        N.b factory = getDefaultViewModelProviderFactory();
        W.a defaultViewModelCreationExtras = getDefaultViewModelCreationExtras();
        h.e(store, "store");
        h.e(factory, "factory");
        d dVarB = g.b(defaultViewModelCreationExtras, "defaultCreationExtras", store, factory, defaultViewModelCreationExtras);
        kotlin.jvm.internal.b bVarA = j.a(TapLevelSettingViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f21308z = (TapLevelSettingViewModel) dVarB.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f21301A = (MelodyTapLevelSettingSeekBarPreference) a("key_tap_level_setting_switch");
        this.f21303C = (COUIPagerFooterPreference) a("key_tap_level_setting_footer");
        MelodyTapLevelSettingGuidePreference melodyTapLevelSettingGuidePreference2 = (MelodyTapLevelSettingGuidePreference) a("key_tap_level_setting_guide_preference");
        if (melodyTapLevelSettingGuidePreference2 != null) {
            melodyTapLevelSettingGuidePreference2.f21935c = this.f21305E;
            melodyTapLevelSettingGuidePreference2.f21936p = new O9.d(this, 4);
            melodyTapLevelSettingGuidePreference = melodyTapLevelSettingGuidePreference2;
        }
        this.f21302B = melodyTapLevelSettingGuidePreference;
        MelodyTapLevelSettingSeekBarPreference melodyTapLevelSettingSeekBarPreference = this.f21301A;
        if (melodyTapLevelSettingSeekBarPreference != null) {
            melodyTapLevelSettingSeekBarPreference.f21940p = new b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        A.x("LongPressVolumeFragment", "onDestroy");
        a aVar = this.H;
        if (aVar != null) {
            aVar.cancel();
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
        TapLevelSettingFragment tapLevelSettingFragment;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        F8.a aVar = activity instanceof F8.a ? (F8.a) activity : null;
        if (aVar != null) {
            aVar.y((COUIToolbar) view.findViewById(R.id.tool_bar));
            androidx.appcompat.app.a aVarX = aVar.x();
            if (aVarX != null) {
                aVarX.o();
                aVarX.n(true);
                aVarX.t(R.string.melody_ui_tap_level_setting_title);
            }
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
        if (this.f21308z != null) {
            tapLevelSettingFragment = this;
            C0379m.b(C0379m.g(AbstractC0939b.E().v(this.f21304D), new e(28))).e(getViewLifecycleOwner(), new c(new TapLevelSettingFragment$initDataObserver$1(1, tapLevelSettingFragment, TapLevelSettingFragment.class, "onTapLevelSettingValueStateChanged", "onTapLevelSettingValueStateChanged(Lcom/oplus/melody/ui/component/detail/taplevelsetting/TapLevelSettingInfoVO;)V", 0)));
        } else {
            tapLevelSettingFragment = this;
        }
        if (tapLevelSettingFragment.f21308z != null) {
            AbstractC0939b.E().K(tapLevelSettingFragment.f21304D);
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        o(R.xml.melody_ui_tap_level_setting_preference);
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.taplevelsetting.a$a */
    /* JADX INFO: compiled from: TapLevelSettingFragment.kt */
    public static final class a extends CountDownTimer {
        public a() {
            super(500L, 500L);
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            o0.d(new Aa.e(TapLevelSettingFragment.this, 17));
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j5) {
        }
    }
}
