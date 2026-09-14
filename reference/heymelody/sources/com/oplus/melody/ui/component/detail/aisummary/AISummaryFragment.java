package com.oplus.melody.ui.component.detail.aisummary;

import A6.e;
import A9.s;
import D7.C0379m;
import D7.o0;
import E9.u;
import F8.b;
import F8.g;
import Wb.l;
import X.d;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.f;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUIPreference;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.heytap.headset.R;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.common.util.C0897c;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import s8.AbstractC1508a;

/* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.aisummary.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: AISummaryFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0002J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0014H\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0012H\u0002J\u0018\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\tH\u0002J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u000200H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/oplus/melody/ui/component/detail/aisummary/AISummaryFragment;", "Lcom/oplus/melody/ui/base/BaseCOUIPreferenceFragment;", "<init>", "()V", "mAISummarySwitchPreference", "Lcom/coui/appcompat/preference/COUISwitchPreference;", "mMoreSettingPreference", "Lcom/coui/appcompat/preference/COUIPreference;", "mAddress", "", "mProductId", "mProductName", "mAISummaryVM", "Lcom/oplus/melody/ui/component/detail/aisummary/AISummaryViewModel;", "mActionFrom", "switchAISummaryDialog", "Landroidx/appcompat/app/AlertDialog;", "mIsInTutorialGuide", "", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onCreate", "onViewCreated", "view", "Landroid/view/View;", "onResume", "initDataObserver", "onAISummaryStateChanged", "aiSummaryVO", "Lcom/oplus/melody/ui/component/detail/aisummary/AISummaryVO;", "onPreferenceTreeClick", "preference", "Landroidx/preference/Preference;", "setMoreSetting", "setAISummaryEnable", "checked", "dealSwitchAISummaryDialog", "context", "Landroid/content/Context;", "address", "jumpAccessibilityAssistantSettings", SpeechFindManager.TYPE, "", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AISummaryFragment extends b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public COUIPreference f20616A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public String f20617B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public String f20618C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public String f20619D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public AISummaryViewModel f20620E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public String f20621F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public f f20622G;
    public boolean H;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public COUISwitchPreference f20623z;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.aisummary.a$a */
    /* JADX INFO: compiled from: AISummaryFragment.kt */
    public static final class a implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20624a;

        public a(l lVar) {
            this.f20624a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20624a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20624a.d(obj);
        }
    }

    @Override // androidx.preference.g, androidx.preference.k.b
    public final boolean f(Preference preference) {
        String key = preference.getKey();
        if (h.a(key, "key_ai_summary_switch")) {
            if (((COUISwitchPreference) preference).isChecked()) {
                CompletableFuture.supplyAsync(new P8.a(this, 0)).whenCompleteAsync((BiConsumer) new s(new g(this, 4), 15), (Executor) o0.c.f1144b);
            } else {
                AISummaryViewModel aISummaryViewModel = this.f20620E;
                if (aISummaryViewModel == null) {
                    h.i("mAISummaryVM");
                    throw null;
                }
                String str = this.f20617B;
                if (str == null) {
                    h.i("mAddress");
                    throw null;
                }
                AISummaryViewModel.d(aISummaryViewModel, str, 0);
            }
        } else if (h.a(key, "key_ai_summary_more_setting")) {
            s(1);
        }
        return super.f(preference);
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Preference preferenceA = a("key_ai_summary_switch");
        h.b(preferenceA);
        this.f20623z = (COUISwitchPreference) preferenceA;
        Preference preferenceA2 = a("key_ai_summary_more_setting");
        h.b(preferenceA2);
        this.f20616A = (COUIPreference) preferenceA2;
        androidx.fragment.app.f activity = getActivity();
        String strH = C0914u.h(activity != null ? activity.getIntent() : null, "device_mac_info");
        if (strH == null) {
            strH = "";
        }
        this.f20617B = strH;
        androidx.fragment.app.f activity2 = getActivity();
        String strH2 = C0914u.h(activity2 != null ? activity2.getIntent() : null, "product_id");
        if (strH2 == null) {
            strH2 = "";
        }
        this.f20618C = strH2;
        androidx.fragment.app.f activity3 = getActivity();
        String strH3 = C0914u.h(activity3 != null ? activity3.getIntent() : null, "device_name");
        if (strH3 == null) {
            strH3 = "";
        }
        this.f20619D = strH3;
        androidx.fragment.app.f activity4 = getActivity();
        this.H = C0914u.b(activity4 != null ? activity4.getIntent() : null, "route_value", false);
        androidx.fragment.app.f activity5 = getActivity();
        String strH4 = C0914u.h(activity5 != null ? activity5.getIntent() : null, "route_from");
        this.f20621F = strH4 != null ? strH4 : "";
        setHasOptionsMenu(!this.H);
        if (this.H) {
            Preference preferenceA3 = a("header_preference");
            if (preferenceA3 == null) {
                preferenceA3 = null;
            }
            if (preferenceA3 != null) {
                preferenceA3.setVisible(false);
            }
        }
        O store = getViewModelStore();
        N.b factory = getDefaultViewModelProviderFactory();
        W.a defaultViewModelCreationExtras = getDefaultViewModelCreationExtras();
        h.e(store, "store");
        h.e(factory, "factory");
        d dVarB = A6.g.b(defaultViewModelCreationExtras, "defaultCreationExtras", store, factory, defaultViewModelCreationExtras);
        kotlin.jvm.internal.b bVarA = j.a(AISummaryViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20620E = (AISummaryViewModel) dVarB.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        String str = this.f20618C;
        if (str == null) {
            h.i("mProductId");
            throw null;
        }
        String str2 = this.f20619D;
        if (str2 != null) {
            C0379m.g(C0379m.g(AbstractC1508a.f().i(), new u(19, str, str2)), new C0.a(this, 12));
        } else {
            h.i("mProductName");
            throw null;
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

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f20620E == null) {
            h.i("mAISummaryVM");
            throw null;
        }
        String str = this.f20617B;
        if (str != null) {
            AbstractC0939b.E().k(str);
        } else {
            h.i("mAddress");
            throw null;
        }
    }

    @Override // F8.b, com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        TextView cOUITitleTextView;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        F8.a aVar = activity instanceof F8.a ? (F8.a) activity : null;
        if (aVar != null) {
            COUIToolbar cOUIToolbar = (COUIToolbar) view.findViewById(R.id.tool_bar);
            if (this.H) {
                if (cOUIToolbar != null) {
                    cOUIToolbar.setVisibility(8);
                }
                this.f11714c.setNestedScrollingEnabled(false);
            } else {
                if (cOUIToolbar != null && (cOUITitleTextView = cOUIToolbar.getCOUITitleTextView()) != null) {
                    cOUITitleTextView.setTextDirection(2);
                }
                aVar.y(cOUIToolbar);
                androidx.appcompat.app.a aVarX = aVar.x();
                if (aVarX != null) {
                    aVarX.o();
                    aVarX.n(true);
                    aVarX.t(R.string.melody_ui_ai_summary_title);
                }
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
        if (this.f20620E == null) {
            h.i("mAISummaryVM");
            throw null;
        }
        String str = this.f20617B;
        if (str == null) {
            h.i("mAddress");
            throw null;
        }
        androidx.lifecycle.s<EarphoneDTO> sVarX = AbstractC0939b.E().x(str);
        h.d(sVarX, "getEarphoneWithoutDistinct(...)");
        C0379m.g(sVarX, new e(20)).e(getViewLifecycleOwner(), new a(new AISummaryFragment$initDataObserver$1(1, this, AISummaryFragment.class, "onAISummaryStateChanged", "onAISummaryStateChanged(Lcom/oplus/melody/ui/component/detail/aisummary/AISummaryVO;)V", 0)));
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        o(R.xml.melody_ui_ai_summary_preference);
    }

    public final void s(int i10) {
        Intent intent = new Intent("action.oplus.accessibilityassistant.global.settings");
        intent.setPackage("com.coloros.accessibilityassistant");
        intent.putExtra("fromEar", true);
        if (i10 == 0) {
            intent.putExtra("routingType", 1);
        }
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.d(fVarRequireActivity, "requireActivity(...)");
        C0905k.j(fVarRequireActivity, intent);
    }
}
