package com.oplus.melody.ui.component.detail.voiceassist;

import D7.C0379m;
import D7.C0386u;
import D7.o0;
import Ea.N;
import F8.i;
import Y.r;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.grid.COUIPercentWidthRecyclerView;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0897c;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.component.detail.voiceassist.VoiceAssistItem;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: VoiceAssistFragment.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends F8.b implements Preference.c {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public String f21355A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public String f21356B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public String f21357C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f21358D;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public COUISwitchPreference f21360F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public COUIPreferenceCategory f21361G;
    public COUIJumpPreference H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public COUISwitchPreference f21362I;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public VoiceViewModel f21365L;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f21366z;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public MelodyCompatToolbar f21359E = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f21363J = null;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f21364K = null;

    @Override // androidx.preference.Preference.c
    public final boolean e(Preference preference, Object obj) {
        String key = preference.getKey();
        A.c("VoiceAssistFragment", new C0386u(23, key, obj));
        key.getClass();
        if (!key.equals("pref_voice_wake_key")) {
            return true;
        }
        Boolean bool = (Boolean) obj;
        CompletableFuture<SetCommandStateDTO> completableFuture = this.f21363J;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        VoiceViewModel voiceViewModel = this.f21365L;
        String str = this.f21366z;
        boolean zBooleanValue = bool.booleanValue();
        voiceViewModel.getClass();
        CompletableFuture<SetCommandStateDTO> completableFutureE0 = AbstractC0939b.E().E0(20, zBooleanValue, str);
        this.f21363J = completableFutureE0;
        completableFutureE0.thenAcceptAsync((Consumer<? super SetCommandStateDTO>) new b(0, this, bool), (Executor) o0.c.f1144b).exceptionally((Function<Throwable, ? extends Void>) new N(4, this, bool));
        return true;
    }

    @Override // androidx.preference.g, androidx.preference.k.b
    public final boolean f(Preference preference) {
        A.c("VoiceAssistFragment", new G8.l(3, preference));
        if (preference.getKey().equals("key_guide_voice_assist_setting_preference")) {
            E8.a.w().getClass();
            Jb.b<List<Wb.l<String, Class<?>>>> bVar = F8.i.f1668g;
            F8.i iVarA = i.a.a("/ui/ear_control");
            iVarA.f("device_mac_info", this.f21366z);
            iVarA.f("device_name", this.f21355A);
            iVarA.f("product_id", this.f21356B);
            iVarA.f("product_color", this.f21357C);
            iVarA.f("control_high_light", "2,3");
            iVarA.e(this);
        }
        return super.f(preference);
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            A.h("VoiceAssistFragment", "onCreate intent is null");
            getActivity().finish();
            return;
        }
        this.f21366z = intent.getStringExtra("device_mac_info");
        this.f21355A = intent.getStringExtra("device_name");
        this.f21356B = intent.getStringExtra("product_id");
        this.f21357C = intent.getStringExtra("product_color");
        boolean booleanExtra = intent.getBooleanExtra("route_value", false);
        this.f21358D = booleanExtra;
        if (booleanExtra && ((qa.c) C0917x.c(qa.c.class, intent.getStringExtra("resZipConfig"))) == null) {
            A.h("VoiceAssistFragment", "onCreate zipConfig is null");
            getActivity().finish();
            return;
        }
        if (TextUtils.isEmpty(this.f21366z)) {
            A.h("VoiceAssistFragment", "onCreate mAddress is empty");
            getActivity().finish();
            return;
        }
        if (TextUtils.isEmpty(this.f21355A)) {
            A.h("VoiceAssistFragment", "onCreate mDeviceName is empty");
            getActivity().finish();
            return;
        }
        super.onCreate(bundle);
        setHasOptionsMenu(!this.f21358D);
        O store = getViewModelStore();
        N.b factory = getDefaultViewModelProviderFactory();
        W.a defaultViewModelCreationExtras = getDefaultViewModelCreationExtras();
        kotlin.jvm.internal.h.e(store, "store");
        kotlin.jvm.internal.h.e(factory, "factory");
        X.d dVarB = A6.g.b(defaultViewModelCreationExtras, "defaultCreationExtras", store, factory, defaultViewModelCreationExtras);
        kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(VoiceViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f21365L = (VoiceViewModel) dVarB.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        VoiceViewModel.d(this.f21366z).e(this, new C9.a(this, 16));
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        RecyclerView recyclerView = this.f11714c;
        if (recyclerView != null) {
            if (this.f21358D) {
                recyclerView.setNestedScrollingEnabled(false);
            } else {
                recyclerView.setNestedScrollingEnabled(true);
            }
            if (getParentFragment() != null && (recyclerView instanceof COUIPercentWidthRecyclerView)) {
                ((COUIPercentWidthRecyclerView) recyclerView).setPercentIndentEnabled(false);
            }
        }
        this.f21359E = (MelodyCompatToolbar) viewOnCreateView.findViewById(R.id.tool_bar);
        if (!C0897c.b(requireActivity()) && !C0897c.c(requireActivity())) {
            return viewOnCreateView;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((FrameLayout) viewOnCreateView.findViewById(android.R.id.list_container)).getLayoutParams();
        marginLayoutParams.setMarginStart((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
        marginLayoutParams.setMarginEnd((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
        return viewOnCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332) {
            A.b("VoiceAssistFragment", "onOptionsItemSelected home");
            getActivity().finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // F8.b, com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        MelodyCompatToolbar melodyCompatToolbar;
        super.onViewCreated(view, bundle);
        androidx.appcompat.app.i iVar = (androidx.appcompat.app.i) getActivity();
        VoiceViewModel voiceViewModel = this.f21365L;
        String str = this.f21366z;
        voiceViewModel.getClass();
        C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new r(25))).e(getViewLifecycleOwner(), new C6.e(this, 28));
        if (iVar == null || (melodyCompatToolbar = this.f21359E) == null) {
            return;
        }
        if (this.f21358D) {
            melodyCompatToolbar.setVisibility(8);
            return;
        }
        iVar.y(melodyCompatToolbar);
        iVar.x().t(R.string.melody_common_voice_assist_title);
        iVar.x().o();
        iVar.x().n(true);
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        o(R.xml.melody_ui_voice_assist_preference);
        this.f21360F = (COUISwitchPreference) a("pref_voice_wake_key");
        this.f21361G = (COUIPreferenceCategory) a("key_guide_voice_assist_setting_category");
        this.H = (COUIJumpPreference) a("key_guide_voice_assist_setting_preference");
        if (this.f21358D) {
            a("header_preference").setVisible(false);
            this.f21360F.setVisible(false);
            this.f21361G.setVisible(true);
        }
        if (S.s(C0906l.f19501a)) {
            this.f21360F.setVisible(false);
            this.f21361G.setVisible(true);
            this.H.setTitle(R.string.melody_common_control_wake_pref_title);
            this.H.setSummary(R.string.melody_common_control_wake_pref_title_summary);
            COUIPreferenceCategory cOUIPreferenceCategory = (COUIPreferenceCategory) a("pref_incoming_call_control_category");
            VoiceAssistItem.Companion companion = VoiceAssistItem.INSTANCE;
            String str = this.f21366z;
            companion.getClass();
            if (VoiceAssistItem.Companion.a(str)) {
                cOUIPreferenceCategory.setVisible(true);
                COUISwitchPreference cOUISwitchPreference = (COUISwitchPreference) a("pref_incoming_call_control");
                this.f21362I = cOUISwitchPreference;
                cOUISwitchPreference.setOnPreferenceChangeListener(new Ca.n(this, 23));
            } else {
                this.f11713b.f11752g.j(cOUIPreferenceCategory);
            }
        }
        this.f21360F.setOnPreferenceChangeListener(this);
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(null, this.f21355A);
        if (whitelistConfigDTOC == null || whitelistConfigDTOC.getFunction() == null) {
            A.b("VoiceAssistFragment", "not a normal headset");
            getActivity().finish();
            return;
        }
        int voiceWake = whitelistConfigDTOC.getFunction().getVoiceWake();
        if (voiceWake == 1 || voiceWake == 3) {
            return;
        }
        A.b("VoiceAssistFragment", "voice wake not support");
        this.f11713b.f11752g.j(this.f21360F);
    }
}
