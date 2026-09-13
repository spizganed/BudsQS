package com.oplus.melody.ui.component.detail.voiceassist;

import W.a;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.InterfaceC0594f;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.P;
import androidx.lifecycle.v;
import androidx.media3.session.q1;
import com.coui.appcompat.preference.COUIPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0897c;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: VoiceCommandFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010 \u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010)\u001a\u00020\u001cH\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\"H\u0002J\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020+0\u000f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0002J\u0010\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020+H\u0002J\u001c\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013072\u0006\u0010,\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u00069"}, d2 = {"Lcom/oplus/melody/ui/component/detail/voiceassist/VoiceCommandFragment;", "Lcom/oplus/melody/ui/base/BaseCOUIPreferenceFragment;", "<init>", "()V", "address", "", "toolbar", "Lcom/oplus/melody/ui/widget/MelodyCompatToolbar;", "voiceCommandGuidePreference", "Lcom/oplus/melody/ui/widget/MelodyCOUIPreference;", "voiceCommandSwitchPreference", "Lcom/coui/appcompat/preference/COUISwitchPreference;", "voiceCommandListCategory", "Lcom/coui/appcompat/preference/COUIPreferenceCategory;", "voiceCommandFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "voiceCommandItems", "", "", "voiceCommandMutexFunctions", "viewModel", "Lcom/oplus/melody/ui/component/detail/voiceassist/VoiceViewModel;", "getViewModel", "()Lcom/oplus/melody/ui/component/detail/voiceassist/VoiceViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initToolBar", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onVoiceCommandStatusChanged", "vo", "Lcom/oplus/melody/ui/component/detail/voiceassist/VoiceAssistVO;", "initView", "showMutexDialog", "mutexFunctions", "setVoiceCommandEnable", "enable", "getVoiceCommandStrings", "Lkotlin/Pair;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class VoiceCommandFragment extends F8.b {
    public static final List<Integer> H = Kb.l.e(3, 4, 5, 6, 7, 8, 1, 2);

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public MelodyCompatToolbar f21339A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public COUISwitchPreference f21340B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public COUIPreferenceCategory f21341C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f21342D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public Object f21343E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public List<String> f21344F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final M f21345G;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f21346z;

    /* JADX INFO: compiled from: VoiceCommandFragment.kt */
    public static final class a implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ A9.j f21347a;

        public a(A9.j jVar) {
            this.f21347a = jVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return kotlin.jvm.internal.h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21347a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21347a.d(obj);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.oplus.melody.ui.component.detail.voiceassist.VoiceCommandFragment$special$$inlined$viewModels$default$1] */
    public VoiceCommandFragment() {
        EmptyList emptyList = EmptyList.f25350a;
        this.f21343E = emptyList;
        this.f21344F = emptyList;
        final ?? r02 = new Wb.a<Fragment>(this) { // from class: com.oplus.melody.ui.component.detail.voiceassist.VoiceCommandFragment$special$$inlined$viewModels$default$1
            final /* synthetic */ Fragment $this_viewModels;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$this_viewModels = this;
            }

            @Override // Wb.a
            public final Fragment invoke() {
                return this.$this_viewModels;
            }
        };
        final Jb.b bVarB = kotlin.a.b(LazyThreadSafetyMode.f25347c, new Wb.a<P>() { // from class: com.oplus.melody.ui.component.detail.voiceassist.VoiceCommandFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Wb.a
            public final P invoke() {
                return (P) r02.invoke();
            }
        });
        this.f21345G = new M(kotlin.jvm.internal.j.a(VoiceViewModel.class), new Wb.a<O>() { // from class: com.oplus.melody.ui.component.detail.voiceassist.VoiceCommandFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            @Override // Wb.a
            public final O invoke() {
                return ((P) bVarB.getValue()).getViewModelStore();
            }
        }, new Wb.a<N.b>(this) { // from class: com.oplus.melody.ui.component.detail.voiceassist.VoiceCommandFragment$special$$inlined$viewModels$default$5
            final /* synthetic */ Fragment $this_viewModels;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$this_viewModels = this;
            }

            @Override // Wb.a
            public final N.b invoke() {
                N.b defaultViewModelProviderFactory;
                P p6 = (P) bVarB.getValue();
                InterfaceC0594f interfaceC0594f = p6 instanceof InterfaceC0594f ? (InterfaceC0594f) p6 : null;
                return (interfaceC0594f == null || (defaultViewModelProviderFactory = interfaceC0594f.getDefaultViewModelProviderFactory()) == null) ? this.$this_viewModels.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
            }
        }, new Wb.a<W.a>() { // from class: com.oplus.melody.ui.component.detail.voiceassist.VoiceCommandFragment$special$$inlined$viewModels$default$4
            final /* synthetic */ Wb.a $extrasProducer = null;

            {
                super(0);
            }

            @Override // Wb.a
            public final W.a invoke() {
                W.a aVar;
                Wb.a aVar2 = this.$extrasProducer;
                if (aVar2 != null && (aVar = (W.a) aVar2.invoke()) != null) {
                    return aVar;
                }
                P p6 = (P) bVarB.getValue();
                InterfaceC0594f interfaceC0594f = p6 instanceof InterfaceC0594f ? (InterfaceC0594f) p6 : null;
                return interfaceC0594f != null ? interfaceC0594f.getDefaultViewModelCreationExtras() : a.C0078a.f5426b;
            }
        });
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        WhitelistConfigDTO.Function function;
        WhitelistConfigDTO.Function function2;
        androidx.fragment.app.f activity = getActivity();
        if (activity == null || activity.getIntent() == null) {
            A.h("VoiceCommandFragment", "onCreate intent is null");
            androidx.fragment.app.f activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        this.f1651w = false;
        androidx.fragment.app.f activity3 = getActivity();
        String strH = C0914u.h(activity3 != null ? activity3.getIntent() : null, "device_mac_info");
        this.f21346z = strH;
        if (strH == null) {
            A.h("VoiceCommandFragment", "onCreate mAddress is empty");
            androidx.fragment.app.f activity4 = getActivity();
            if (activity4 != null) {
                activity4.finish();
                return;
            }
            return;
        }
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        AbstractC1508a abstractC1508aF = AbstractC1508a.f();
        androidx.fragment.app.f activity5 = getActivity();
        WhitelistConfigDTO whitelistConfigDTOC = abstractC1508aF.c(C0914u.h(activity5 != null ? activity5.getIntent() : null, "product_id"), null);
        List<Integer> voiceCommandItems = (whitelistConfigDTOC == null || (function2 = whitelistConfigDTOC.getFunction()) == null) ? null : function2.getVoiceCommandItems();
        if (voiceCommandItems == null || voiceCommandItems.isEmpty()) {
            voiceCommandItems = H;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : voiceCommandItems) {
            int iIntValue = ((Number) obj).intValue();
            if (iIntValue <= 10) {
                if (iIntValue == 7 || iIntValue == 8) {
                    List<WhitelistConfigDTO.NoiseReductionMode> noiseReductionMode = (whitelistConfigDTOC == null || (function = whitelistConfigDTOC.getFunction()) == null) ? null : function.getNoiseReductionMode();
                    if (noiseReductionMode == null || noiseReductionMode.isEmpty()) {
                    }
                }
                arrayList.add(obj);
            }
        }
        this.f21343E = arrayList;
        List<String> listC = Y.c("voiceCommand", whitelistConfigDTOC);
        kotlin.jvm.internal.h.d(listC, "getMutexFunctions(...)");
        this.f21344F = listC;
        String str = this.f21346z;
        kotlin.jvm.internal.h.b(str);
        VoiceViewModel.d(str).e(this, new a(new A9.j(this, 27)));
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.h.e(inflater, "inflater");
        View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
        this.f21339A = (MelodyCompatToolbar) viewOnCreateView.findViewById(R.id.tool_bar);
        if (C0897c.b(requireActivity()) || C0897c.c(requireActivity())) {
            FrameLayout frameLayout = (FrameLayout) viewOnCreateView.findViewById(android.R.id.list_container);
            ViewGroup.LayoutParams layoutParams = frameLayout != null ? frameLayout.getLayoutParams() : null;
            CoordinatorLayout.f fVar = layoutParams instanceof CoordinatorLayout.f ? (CoordinatorLayout.f) layoutParams : null;
            if (fVar != null) {
                fVar.setMarginStart((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
                fVar.setMarginEnd((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
            }
        }
        return viewOnCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        kotlin.jvm.internal.h.e(item, "item");
        if (item.getItemId() == 16908332) {
            A.b("VoiceCommandFragment", "onOptionsItemSelected home");
            androidx.fragment.app.f activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Iterable, java.lang.Object] */
    @Override // F8.b, com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        Pair pair;
        kotlin.jvm.internal.h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.appcompat.app.i iVar = (androidx.appcompat.app.i) getActivity();
        if (iVar != null) {
            iVar.y(this.f21339A);
            androidx.appcompat.app.a aVarX = iVar.x();
            if (aVarX != null) {
                aVarX.t(R.string.melody_common_voice_wake_pref_order_title);
            }
            androidx.appcompat.app.a aVarX2 = iVar.x();
            if (aVarX2 != null) {
                aVarX2.o();
            }
            androidx.appcompat.app.a aVarX3 = iVar.x();
            if (aVarX3 != null) {
                aVarX3.n(true);
            }
        }
        COUIPreferenceCategory cOUIPreferenceCategory = this.f21341C;
        if (cOUIPreferenceCategory == null) {
            return;
        }
        int i10 = 0;
        for (Object obj : this.f21343E) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                Kb.l.h();
                throw null;
            }
            int iIntValue = ((Number) obj).intValue();
            switch (iIntValue) {
                case 1:
                    pair = new Pair(Integer.valueOf(R.string.melody_ui_voice_command_tip_resume_song), Integer.valueOf(R.string.melody_ui_voice_command_tip_resume_song_summary));
                    break;
                case 2:
                    pair = new Pair(Integer.valueOf(R.string.melody_ui_voice_command_tip_pause_song), Integer.valueOf(R.string.melody_ui_voice_command_tip_pause_song_summary));
                    break;
                case 3:
                    pair = new Pair(Integer.valueOf(R.string.melody_ui_voice_command_tip_last_song), Integer.valueOf(R.string.melody_ui_voice_command_tip_previous_song_summary2));
                    break;
                case 4:
                    pair = new Pair(Integer.valueOf(R.string.melody_ui_voice_command_tip_next_song), Integer.valueOf(R.string.melody_ui_voice_command_tip_next_song_summary2));
                    break;
                case 5:
                    pair = new Pair(Integer.valueOf(R.string.melody_ui_voice_command_tip_decrease_volume), Integer.valueOf(R.string.melody_ui_voice_command_tip_decrease_volume_summary2));
                    break;
                case 6:
                    pair = new Pair(Integer.valueOf(R.string.melody_ui_voice_command_tip_increase_volume), Integer.valueOf(R.string.melody_ui_voice_command_tip_increase_volume_summary2));
                    break;
                case 7:
                    pair = new Pair(Integer.valueOf(R.string.melody_ui_voice_command_tip_open_voice_noise), Integer.valueOf(R.string.melody_ui_voice_command_tip_open_voice_noise_summary));
                    break;
                case 8:
                    pair = new Pair(Integer.valueOf(R.string.melody_ui_voice_command_tip_open_voice_transparent), Integer.valueOf(R.string.melody_ui_voice_command_tip_open_voice_transparent_summary));
                    break;
                case 9:
                    pair = new Pair(Integer.valueOf(R.string.melody_ui_voice_command_tip_call_answer), Integer.valueOf(R.string.melody_ui_voice_command_tip_answer_call_summary));
                    break;
                case 10:
                    pair = new Pair(Integer.valueOf(R.string.melody_ui_voice_command_tip_call_hangup), Integer.valueOf(R.string.melody_ui_voice_command_tip_hangup_call_summary));
                    break;
                default:
                    throw MelodyException.e(0, "Unknown voice command item: " + iIntValue);
            }
            COUIPreference cOUIPreference = new COUIPreference(getContext());
            cOUIPreference.setOrder(i10);
            cOUIPreference.setKey(String.valueOf(iIntValue));
            cOUIPreference.setTitle("\"" + getString(((Number) pair.e()).intValue()) + "\"");
            cOUIPreference.setSummary(getString(((Number) pair.f()).intValue()));
            cOUIPreference.setPersistent(false);
            cOUIPreference.setBackgroundAnimationEnabled(false);
            cOUIPreferenceCategory.e(cOUIPreference);
            i10 = i11;
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        o(R.xml.melody_ui_void_command_preference);
        COUISwitchPreference cOUISwitchPreference = (COUISwitchPreference) a("pref_voice_command_switch_key");
        this.f21340B = cOUISwitchPreference;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setOnPreferenceChangeListener(new q1(this, 8));
        }
        this.f21341C = (COUIPreferenceCategory) a("pref_voice_command_list_category_ley");
    }
}
