package com.oplus.melody.ui.component.detail.voiceassist;

import A9.p;
import A9.q;
import D7.C0379m;
import D7.o0;
import E9.r;
import Ea.C0406o;
import F8.i;
import W.a;
import a9.C0531H;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.B;
import com.coui.appcompat.grid.COUIPercentWidthRecyclerView;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.heytap.speechassist.conversation.proxy.IBinderStatusCallback;
import com.heytap.speechassist.conversation.sdk.SpeechAssistAgentManager;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0897c;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.common.util.RunnableC0903i;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.db.D;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.component.detail.voiceassist.VoiceAssistItem;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import t8.w;

/* JADX INFO: compiled from: VoiceAssistFragmentV3.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 X2\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0002J\u001c\u00103\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00104\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020\u0005H\u0002J\u0010\u00107\u001a\u00020-2\u0006\u00106\u001a\u00020\u0005H\u0002J\u0010\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020:H\u0016J$\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020<2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020-H\u0016J\u001c\u0010G\u001a\u00020-2\b\b\u0002\u0010H\u001a\u00020\u00052\b\b\u0002\u0010I\u001a\u00020\u0005H\u0002J\b\u0010J\u001a\u00020-H\u0002J\b\u0010K\u001a\u00020-H\u0002J\b\u0010L\u001a\u00020\u0005H\u0002J\b\u0010M\u001a\u00020\u0005H\u0002J\b\u0010N\u001a\u00020\u0005H\u0002J\b\u0010O\u001a\u00020\u0005H\u0002J\b\u0010P\u001a\u00020\u0005H\u0002J\b\u0010Q\u001a\u00020\u0005H\u0002J\b\u0010R\u001a\u00020\u0005H\u0002J\b\u0010S\u001a\u00020\u0005H\u0002J\b\u0010T\u001a\u00020-H\u0002J\u001a\u0010U\u001a\u00020-2\b\b\u0002\u0010V\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/oplus/melody/ui/component/detail/voiceassist/VoiceAssistFragmentV3;", "Lcom/oplus/melody/ui/base/BaseCOUIPreferenceFragment;", "<init>", "()V", "isAssistInit", "", "address", "", "deviceName", "productId", "productColorId", "toolbar", "Lcom/oplus/melody/ui/widget/MelodyCompatToolbar;", "voiceWakeCategory", "Lcom/coui/appcompat/preference/COUIPreferenceCategory;", "voiceWakePreference", "Lcom/coui/appcompat/preference/COUISwitchPreference;", "voiceMultiConversationPreference", "voiceMultiConversationEntryPreferenceCategory", "voiceMultiConversationEntryPreference", "Lcom/coui/appcompat/preference/COUIJumpPreference;", "controlWakeCategory", "controlWakePreference", "voiceSettingCategory", "incomingCallControlPreference", "callMsgPreference", "moreVoiceSettingPreference", "voiceAssistDialog", "Landroidx/appcompat/app/AlertDialog;", "voiceWakeFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "incomingCallControlFuture", "mIsInTutorialGuide", "mZipConfig", "Lcom/oplus/melody/ui/component/tutorialguide/TutorialGuideZipConfig;", "viewModel", "Lcom/oplus/melody/ui/component/detail/voiceassist/VoiceViewModel;", "getViewModel", "()Lcom/oplus/melody/ui/component/detail/voiceassist/VoiceViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "assistStatusCallback", "Lcom/heytap/speechassist/conversation/proxy/IBinderStatusCallback;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onVoiceAssistStatusChanged", "vo", "Lcom/oplus/melody/ui/component/detail/voiceassist/VoiceAssistVO;", "onCreatePreferences", "rootKey", "setVoiceWakeEnable", "enable", "setIncomingCallControlEnable", "onPreferenceTreeClick", "preference", "Landroidx/preference/Preference;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onDestroy", "checkAndShowDialog", "assistOpened", "wakeOpened", "initVoiceAssist", "releaseVoiceAssist", "isBothSupportFullDuplex", "isPhoneFullDuplex", "isSupportVoiceAssist", "isSupportVoiceWake", "isSupportMultiConversation", "isSupportCallAndMsg", "isVoiceAssistOpen", "isVoiceWakeOpen", "gotoCallAndMsgSettings", "gotoVoiceAssistSettings", "needHighlight", "highLightItem", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class VoiceAssistFragmentV3 extends F8.b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public String f21316A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public String f21317B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public String f21318C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public String f21319D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public MelodyCompatToolbar f21320E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public COUIPreferenceCategory f21321F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public COUISwitchPreference f21322G;
    public COUISwitchPreference H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public COUIPreferenceCategory f21323I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public COUIJumpPreference f21324J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public COUIPreferenceCategory f21325K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public COUIJumpPreference f21326L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public COUIPreferenceCategory f21327M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public COUISwitchPreference f21328N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public COUIJumpPreference f21329O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public androidx.appcompat.app.f f21330P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f21331Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f21332R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public boolean f21333S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public final M f21334T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final IBinderStatusCallback f21335U;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f21336z;

    /* JADX INFO: compiled from: VoiceAssistFragmentV3.kt */
    public static final class a implements IBinderStatusCallback {
    }

    /* JADX INFO: compiled from: VoiceAssistFragmentV3.kt */
    public static final class b implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Wb.l f21337a;

        public b(Wb.l lVar) {
            this.f21337a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return kotlin.jvm.internal.h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21337a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21337a.d(obj);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.oplus.melody.ui.component.detail.voiceassist.VoiceAssistFragmentV3$special$$inlined$viewModels$default$1] */
    public VoiceAssistFragmentV3() {
        final ?? r02 = new Wb.a<Fragment>(this) { // from class: com.oplus.melody.ui.component.detail.voiceassist.VoiceAssistFragmentV3$special$$inlined$viewModels$default$1
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
        final Jb.b bVarB = kotlin.a.b(LazyThreadSafetyMode.f25347c, new Wb.a<P>() { // from class: com.oplus.melody.ui.component.detail.voiceassist.VoiceAssistFragmentV3$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Wb.a
            public final P invoke() {
                return (P) r02.invoke();
            }
        });
        this.f21334T = new M(kotlin.jvm.internal.j.a(VoiceViewModel.class), new Wb.a<O>() { // from class: com.oplus.melody.ui.component.detail.voiceassist.VoiceAssistFragmentV3$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            @Override // Wb.a
            public final O invoke() {
                return ((P) bVarB.getValue()).getViewModelStore();
            }
        }, new Wb.a<N.b>(this) { // from class: com.oplus.melody.ui.component.detail.voiceassist.VoiceAssistFragmentV3$special$$inlined$viewModels$default$5
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
        }, new Wb.a<W.a>() { // from class: com.oplus.melody.ui.component.detail.voiceassist.VoiceAssistFragmentV3$special$$inlined$viewModels$default$4
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
        this.f21335U = new a();
    }

    public static boolean A() {
        SpeechAssistAgentManager speechAssistAgentManager = SpeechAssistAgentManager.INSTANCE;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            kotlin.jvm.internal.h.i("context");
            throw null;
        }
        Bundle speechAssistStatus = speechAssistAgentManager.getSpeechAssistStatus(heyMelodyApplication, new String[]{"is_support_voice_wakeup"});
        boolean z2 = speechAssistStatus != null ? speechAssistStatus.getBoolean("is_support_voice_wakeup", false) : false;
        A.c("VoiceAssistFragmentV3", new r(9, z2));
        return z2;
    }

    public static final Jb.l v(VoiceAssistFragmentV3 voiceAssistFragmentV3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        SpeechAssistAgentManager speechAssistAgentManager = SpeechAssistAgentManager.INSTANCE;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            kotlin.jvm.internal.h.i("context");
            throw null;
        }
        voiceAssistFragmentV3.f21336z = speechAssistAgentManager.init(heyMelodyApplication, (Intent) null, voiceAssistFragmentV3.f21335U);
        A.c("VoiceAssistFragmentV3", new l(voiceAssistFragmentV3, jCurrentTimeMillis, 0));
        return Jb.l.f2618a;
    }

    public static boolean w() {
        SpeechAssistAgentManager speechAssistAgentManager = SpeechAssistAgentManager.INSTANCE;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            return speechAssistAgentManager.isSupportFullDuplexConversation(heyMelodyApplication);
        }
        kotlin.jvm.internal.h.i("context");
        throw null;
    }

    public static boolean x() {
        SpeechAssistAgentManager speechAssistAgentManager = SpeechAssistAgentManager.INSTANCE;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            kotlin.jvm.internal.h.i("context");
            throw null;
        }
        Bundle speechAssistStatus = speechAssistAgentManager.getSpeechAssistStatus(heyMelodyApplication, new String[]{"speech_assist_is_support_broadcast_msg", "speech_assist_is_support_broadcast_call"});
        boolean z2 = speechAssistStatus != null ? speechAssistStatus.getBoolean("speech_assist_is_support_broadcast_msg", false) : false;
        boolean z4 = speechAssistStatus != null ? speechAssistStatus.getBoolean("speech_assist_is_support_broadcast_call", false) : false;
        A.c("VoiceAssistFragmentV3", new U8.f(2, z2, z4));
        return z2 | z4;
    }

    public static boolean y() {
        boolean zW = w();
        SpeechAssistAgentManager speechAssistAgentManager = SpeechAssistAgentManager.INSTANCE;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            kotlin.jvm.internal.h.i("context");
            throw null;
        }
        boolean zIsSupportHalfDuplexConversation = speechAssistAgentManager.isSupportHalfDuplexConversation(heyMelodyApplication);
        A.c("VoiceAssistFragmentV3", new W9.b(2, zW, zIsSupportHalfDuplexConversation));
        return zW | zIsSupportHalfDuplexConversation;
    }

    public static boolean z() {
        SpeechAssistAgentManager speechAssistAgentManager = SpeechAssistAgentManager.INSTANCE;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            kotlin.jvm.internal.h.i("context");
            throw null;
        }
        boolean zIsSupportHeadsetOneShot = speechAssistAgentManager.isSupportHeadsetOneShot(heyMelodyApplication);
        HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
        if (heyMelodyApplication2 == null) {
            kotlin.jvm.internal.h.i("context");
            throw null;
        }
        Bundle bundleD = S.d(heyMelodyApplication2, "com.oplus.ovoicemanager.wakeup");
        boolean z2 = bundleD != null ? bundleD.getBoolean("com.oplus.ovoicemanager.wakeup:iot_recognize", false) : false;
        A.c("VoiceAssistFragmentV3", new W9.b(1, zIsSupportHeadsetOneShot, z2));
        return zIsSupportHeadsetOneShot && z2;
    }

    public final boolean B() {
        if (!this.f21336z) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            SpeechAssistAgentManager speechAssistAgentManager = SpeechAssistAgentManager.INSTANCE;
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                kotlin.jvm.internal.h.i("context");
                throw null;
            }
            this.f21336z = speechAssistAgentManager.init(heyMelodyApplication, (Intent) null, this.f21335U);
            A.c("VoiceAssistFragmentV3", new D(1, jCurrentTimeMillis, this));
        }
        SpeechAssistAgentManager speechAssistAgentManager2 = SpeechAssistAgentManager.INSTANCE;
        HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
        if (heyMelodyApplication2 == null) {
            kotlin.jvm.internal.h.i("context");
            throw null;
        }
        Bundle speechAssistStatus = speechAssistAgentManager2.getSpeechAssistStatus(heyMelodyApplication2, new String[]{"speech_assist_total_switch_status"});
        boolean z2 = speechAssistStatus != null ? speechAssistStatus.getBoolean("speech_assist_total_switch_status", false) : false;
        A.c("VoiceAssistFragmentV3", new A9.h(10, z2));
        return z2;
    }

    public final boolean C() {
        if (!this.f21336z) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            SpeechAssistAgentManager speechAssistAgentManager = SpeechAssistAgentManager.INSTANCE;
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                kotlin.jvm.internal.h.i("context");
                throw null;
            }
            this.f21336z = speechAssistAgentManager.init(heyMelodyApplication, (Intent) null, this.f21335U);
            A.c("VoiceAssistFragmentV3", new l(this, jCurrentTimeMillis, 1));
        }
        SpeechAssistAgentManager speechAssistAgentManager2 = SpeechAssistAgentManager.INSTANCE;
        HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
        if (heyMelodyApplication2 == null) {
            kotlin.jvm.internal.h.i("context");
            throw null;
        }
        Bundle speechAssistStatus = speechAssistAgentManager2.getSpeechAssistStatus(heyMelodyApplication2, new String[]{"voice_wakeup_switch_status"});
        boolean z2 = speechAssistStatus != null ? speechAssistStatus.getBoolean("voice_wakeup_switch_status", false) : false;
        A.c("VoiceAssistFragmentV3", new A9.i(20, z2));
        return z2;
    }

    public final void D() {
        if (this.f21336z) {
            SpeechAssistAgentManager speechAssistAgentManager = SpeechAssistAgentManager.INSTANCE;
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication != null) {
                SpeechAssistAgentManager.release$default(speechAssistAgentManager, heyMelodyApplication, this.f21335U, false, 4, (Object) null);
            } else {
                kotlin.jvm.internal.h.i("context");
                throw null;
            }
        }
    }

    @Override // androidx.preference.g, androidx.preference.k.b
    public final boolean f(Preference preference) {
        preference.getKey();
        String key = preference.getKey();
        if (key != null) {
            int iHashCode = key.hashCode();
            if (iHashCode != -2106106750) {
                if (iHashCode != -1900656548) {
                    if (iHashCode == 363632533 && key.equals("pref_more_voice_setting_key")) {
                        u("voice_wakeup", false);
                    }
                } else if (key.equals("pref_call_msg_key")) {
                    CompletableFuture.supplyAsync(new k(this, 0)).whenCompleteAsync((BiConsumer) new c9.g(new C0406o(this, 9), 4), (Executor) o0.c.f1144b);
                }
            } else if (key.equals("pref_control_wake_key")) {
                E8.a.w().getClass();
                Jb.b<List<Wb.l<String, Class<?>>>> bVar = F8.i.f1668g;
                F8.i iVarA = i.a.a("/ui/ear_control");
                iVarA.f("device_mac_info", this.f21316A);
                iVarA.f("device_name", this.f21317B);
                iVarA.f("product_id", this.f21318C);
                iVarA.f("product_color", this.f21319D);
                iVarA.f("control_high_light", "2,3");
                iVarA.e(this);
                ForkJoinPool.commonPool().execute(new B(this, 11));
            }
        }
        return super.f(preference);
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        androidx.fragment.app.f activity = getActivity();
        if (activity == null || activity.getIntent() == null) {
            A.h("VoiceAssistFragmentV3", "onCreate intent is null");
            androidx.fragment.app.f activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        androidx.fragment.app.f activity3 = getActivity();
        this.f21316A = C0914u.h(activity3 != null ? activity3.getIntent() : null, "device_mac_info");
        androidx.fragment.app.f activity4 = getActivity();
        this.f21317B = C0914u.h(activity4 != null ? activity4.getIntent() : null, "device_name");
        androidx.fragment.app.f activity5 = getActivity();
        this.f21318C = C0914u.h(activity5 != null ? activity5.getIntent() : null, "product_id");
        androidx.fragment.app.f activity6 = getActivity();
        this.f21319D = C0914u.h(activity6 != null ? activity6.getIntent() : null, "product_color");
        androidx.fragment.app.f activity7 = getActivity();
        this.f21333S = C0914u.b(activity7 != null ? activity7.getIntent() : null, "route_value", false);
        if (TextUtils.isEmpty(this.f21316A) || TextUtils.isEmpty(this.f21317B)) {
            A.h("VoiceAssistFragmentV3", "onCreate addr or name is empty");
            androidx.fragment.app.f activity8 = getActivity();
            if (activity8 != null) {
                activity8.finish();
                return;
            }
            return;
        }
        if (this.f21333S) {
            androidx.fragment.app.f activity9 = getActivity();
            if (((qa.c) C0917x.c(qa.c.class, C0914u.h(activity9 != null ? activity9.getIntent() : null, "resZipConfig"))) == null) {
                A.h("VoiceAssistFragmentV3", "onCreate zipConfig is null");
                androidx.fragment.app.f activity10 = getActivity();
                if (activity10 != null) {
                    activity10.finish();
                    return;
                }
                return;
            }
        }
        A.c("VoiceAssistFragmentV3", new g(this, 0));
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        CompletableFuture.supplyAsync(new h(this, 0)).whenCompleteAsync((BiConsumer) new c9.g(new i(this, 0), 3), (Executor) o0.c.f1144b);
        t();
        String str = this.f21316A;
        kotlin.jvm.internal.h.b(str);
        VoiceViewModel.d(str).e(this, new b(new D9.a(this, 26)));
        t();
        C0379m.b(C0379m.g(AbstractC0939b.E().v(this.f21316A), new Y.r(25))).e(this, new b(new C0531H(this, 8)));
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.h.e(inflater, "inflater");
        View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
        RecyclerView recyclerView = this.f11714c;
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(!this.f21333S);
        }
        this.f21320E = (MelodyCompatToolbar) viewOnCreateView.findViewById(R.id.tool_bar);
        RecyclerView recyclerView2 = this.f11714c;
        if (recyclerView2 != null && getParentFragment() != null && (recyclerView2 instanceof COUIPercentWidthRecyclerView)) {
            ((COUIPercentWidthRecyclerView) recyclerView2).setPercentIndentEnabled(false);
        }
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
    public final void onDestroy() {
        super.onDestroy();
        ForkJoinPool.commonPool().execute(new d(this, 0));
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        kotlin.jvm.internal.h.e(item, "item");
        if (item.getItemId() == 16908332) {
            A.b("VoiceAssistFragmentV3", "onOptionsItemSelected home");
            androidx.fragment.app.f activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // F8.b, com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        androidx.appcompat.app.i iVar = activity instanceof androidx.appcompat.app.i ? (androidx.appcompat.app.i) activity : null;
        if (iVar != null) {
            if (this.f21333S) {
                MelodyCompatToolbar melodyCompatToolbar = this.f21320E;
                if (melodyCompatToolbar != null) {
                    melodyCompatToolbar.setVisibility(8);
                    return;
                }
                return;
            }
            iVar.y(this.f21320E);
            androidx.appcompat.app.a aVarX = iVar.x();
            if (aVarX != null) {
                aVarX.t(R.string.melody_common_voice_assist_title);
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
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        COUIPreferenceCategory cOUIPreferenceCategory;
        PreferenceScreen preferenceScreen;
        COUIPreferenceCategory cOUIPreferenceCategory2;
        PreferenceScreen preferenceScreen2;
        COUIPreferenceCategory cOUIPreferenceCategory3;
        o(R.xml.melody_ui_voice_assist_v3_preference);
        this.f21321F = (COUIPreferenceCategory) a("voice_wake_category_key");
        COUISwitchPreference cOUISwitchPreference = (COUISwitchPreference) a("pref_voice_wake_key");
        this.f21322G = cOUISwitchPreference;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setOnPreferenceChangeListener(new Ca.n(this, 24));
        }
        this.H = (COUISwitchPreference) a("pref_voice_multi_conversation_key");
        this.f21323I = (COUIPreferenceCategory) a("pref_voice_multi_conversation_entry_category_key");
        this.f21324J = (COUIJumpPreference) a("pref_voice_multi_conversation_entry_key");
        if (w.b()) {
            COUISwitchPreference cOUISwitchPreference2 = this.H;
            if (cOUISwitchPreference2 != null && (cOUIPreferenceCategory3 = this.f21321F) != null) {
                cOUIPreferenceCategory3.j(cOUISwitchPreference2);
            }
            if (w.d()) {
                COUIJumpPreference cOUIJumpPreference = this.f21324J;
                if (cOUIJumpPreference != null) {
                    cOUIJumpPreference.setOnPreferenceClickListener(new q1(this, 7));
                }
            } else {
                COUIPreferenceCategory cOUIPreferenceCategory4 = this.f21323I;
                if (cOUIPreferenceCategory4 != null && (preferenceScreen2 = this.f11713b.f11752g) != null) {
                    preferenceScreen2.j(cOUIPreferenceCategory4);
                }
            }
        } else {
            COUIPreferenceCategory cOUIPreferenceCategory5 = this.f21323I;
            if (cOUIPreferenceCategory5 != null && (preferenceScreen = this.f11713b.f11752g) != null) {
                preferenceScreen.j(cOUIPreferenceCategory5);
            }
            if (y()) {
                COUISwitchPreference cOUISwitchPreference3 = this.H;
                if (cOUISwitchPreference3 != null) {
                    final int i10 = 1;
                    cOUISwitchPreference3.setOnPreferenceChangeListener(new Preference.c(this) { // from class: com.oplus.melody.ui.component.detail.voiceassist.e

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ VoiceAssistFragmentV3 f21370b;

                        {
                            this.f21370b = this;
                        }

                        @Override // androidx.preference.Preference.c
                        public final boolean e(Preference preference, Object obj) {
                            CompletableFuture<Void> completableFutureThenAcceptAsync;
                            switch (i10) {
                                case 0:
                                    kotlin.jvm.internal.h.e(preference, "<unused var>");
                                    kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
                                    final boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                    final VoiceAssistFragmentV3 voiceAssistFragmentV3 = this.f21370b;
                                    CompletableFuture<SetCommandStateDTO> completableFuture = voiceAssistFragmentV3.f21332R;
                                    if (completableFuture != null) {
                                        completableFuture.cancel(true);
                                    }
                                    voiceAssistFragmentV3.t();
                                    CompletableFuture<SetCommandStateDTO> completableFutureE0 = AbstractC0939b.E().E0(57, zBooleanValue, voiceAssistFragmentV3.f21316A);
                                    voiceAssistFragmentV3.f21332R = completableFutureE0;
                                    if (completableFutureE0 != null && (completableFutureThenAcceptAsync = completableFutureE0.thenAcceptAsync((Consumer<? super SetCommandStateDTO>) new G8.h(new N8.a(voiceAssistFragmentV3, zBooleanValue, 2), 10), (Executor) o0.c.f1144b)) != null) {
                                        completableFutureThenAcceptAsync.exceptionally(new Function() { // from class: com.oplus.melody.ui.component.detail.voiceassist.j
                                            @Override // java.util.function.Function
                                            public final Object apply(Object obj2) {
                                                VoiceAssistFragmentV3 voiceAssistFragmentV32 = voiceAssistFragmentV3;
                                                boolean z2 = zBooleanValue;
                                                o0.d(new T8.e(voiceAssistFragmentV32, z2, 5));
                                                A.i("VoiceAssistFragmentV3", "setIncomingCallControlEnable, enable: " + z2 + ", error: ", (Throwable) obj2);
                                                return null;
                                            }
                                        });
                                    }
                                    break;
                                default:
                                    kotlin.jvm.internal.h.e(preference, "<unused var>");
                                    VoiceAssistFragmentV3 voiceAssistFragmentV32 = this.f21370b;
                                    voiceAssistFragmentV32.getClass();
                                    boolean zW = VoiceAssistFragmentV3.w();
                                    A.c("VoiceAssistFragmentV3", new D6.b(obj, zW, 6));
                                    voiceAssistFragmentV32.t();
                                    String str = voiceAssistFragmentV32.f21316A;
                                    kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
                                    AbstractC0939b.E().w0(str, ((Boolean) obj).booleanValue() ? 1 : 0, zW, true);
                                    ForkJoinPool.commonPool().execute(new E9.k(24, voiceAssistFragmentV32, obj));
                                    break;
                            }
                            return true;
                        }
                    });
                }
                final int i11 = 1;
                CompletableFuture.supplyAsync(new Supplier(this) { // from class: com.oplus.melody.ui.component.detail.voiceassist.f

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ VoiceAssistFragmentV3 f21372b;

                    {
                        this.f21372b = this;
                    }

                    @Override // java.util.function.Supplier
                    public final Object get() {
                        switch (i11) {
                            case 0:
                                COUISwitchPreference cOUISwitchPreference4 = this.f21372b.H;
                                return "onCreatePreferences, isVoiceAssistEnabled: " + (cOUISwitchPreference4 != null ? Boolean.valueOf(cOUISwitchPreference4.isVisible()) : null);
                            default:
                                VoiceAssistFragmentV3 voiceAssistFragmentV3 = this.f21372b;
                                voiceAssistFragmentV3.getClass();
                                EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(voiceAssistFragmentV3.f21316A);
                                boolean z2 = false;
                                if (earphoneDTOW != null) {
                                    boolean zW = VoiceAssistFragmentV3.w();
                                    boolean zK = com.oplus.melody.model.repository.earphone.N.k(1070, earphoneDTOW.getEarCapability());
                                    A.c("VoiceAssistFragmentV3", new U8.f(1, zW, zK));
                                    if (zW && zK) {
                                        z2 = true;
                                    }
                                }
                                return Boolean.valueOf(z2);
                        }
                    }
                }).whenCompleteAsync((BiConsumer) new q(new p(this, 6), 15), (Executor) o0.c.f1144b);
            } else {
                COUISwitchPreference cOUISwitchPreference4 = this.H;
                if (cOUISwitchPreference4 != null && (cOUIPreferenceCategory = this.f21321F) != null) {
                    cOUIPreferenceCategory.j(cOUISwitchPreference4);
                }
            }
            COUISwitchPreference cOUISwitchPreference5 = this.H;
            if (cOUISwitchPreference5 != null) {
                t();
                EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(this.f21316A);
                cOUISwitchPreference5.setVisible(earphoneDTOW != null && earphoneDTOW.getVoiceAssistStatus() == 1);
            }
            COUISwitchPreference cOUISwitchPreference6 = this.H;
            if (cOUISwitchPreference6 != null) {
                t();
                EarphoneDTO earphoneDTOW2 = AbstractC0939b.E().w(this.f21316A);
                cOUISwitchPreference6.setChecked(earphoneDTOW2 != null && earphoneDTOW2.getMultiConversationSwitch() == 1);
            }
        }
        this.f21325K = (COUIPreferenceCategory) a("control_wake_category_key");
        this.f21326L = (COUIJumpPreference) a("pref_control_wake_key");
        this.f21327M = (COUIPreferenceCategory) a("voice_setting_category_key");
        this.f21328N = (COUISwitchPreference) a("pref_incoming_call_control");
        VoiceAssistItem.Companion companion = VoiceAssistItem.INSTANCE;
        String str = this.f21316A;
        companion.getClass();
        if (VoiceAssistItem.Companion.a(str)) {
            COUISwitchPreference cOUISwitchPreference7 = this.f21328N;
            if (cOUISwitchPreference7 != null) {
                cOUISwitchPreference7.setVisible(true);
            }
            COUISwitchPreference cOUISwitchPreference8 = this.f21328N;
            if (cOUISwitchPreference8 != null) {
                final int i12 = 0;
                cOUISwitchPreference8.setOnPreferenceChangeListener(new Preference.c(this) { // from class: com.oplus.melody.ui.component.detail.voiceassist.e

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ VoiceAssistFragmentV3 f21370b;

                    {
                        this.f21370b = this;
                    }

                    @Override // androidx.preference.Preference.c
                    public final boolean e(Preference preference, Object obj) {
                        CompletableFuture<Void> completableFutureThenAcceptAsync;
                        switch (i12) {
                            case 0:
                                kotlin.jvm.internal.h.e(preference, "<unused var>");
                                kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
                                final boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                final VoiceAssistFragmentV3 voiceAssistFragmentV3 = this.f21370b;
                                CompletableFuture<SetCommandStateDTO> completableFuture = voiceAssistFragmentV3.f21332R;
                                if (completableFuture != null) {
                                    completableFuture.cancel(true);
                                }
                                voiceAssistFragmentV3.t();
                                CompletableFuture<SetCommandStateDTO> completableFutureE0 = AbstractC0939b.E().E0(57, zBooleanValue, voiceAssistFragmentV3.f21316A);
                                voiceAssistFragmentV3.f21332R = completableFutureE0;
                                if (completableFutureE0 != null && (completableFutureThenAcceptAsync = completableFutureE0.thenAcceptAsync((Consumer<? super SetCommandStateDTO>) new G8.h(new N8.a(voiceAssistFragmentV3, zBooleanValue, 2), 10), (Executor) o0.c.f1144b)) != null) {
                                    completableFutureThenAcceptAsync.exceptionally(new Function() { // from class: com.oplus.melody.ui.component.detail.voiceassist.j
                                        @Override // java.util.function.Function
                                        public final Object apply(Object obj2) {
                                            VoiceAssistFragmentV3 voiceAssistFragmentV32 = voiceAssistFragmentV3;
                                            boolean z2 = zBooleanValue;
                                            o0.d(new T8.e(voiceAssistFragmentV32, z2, 5));
                                            A.i("VoiceAssistFragmentV3", "setIncomingCallControlEnable, enable: " + z2 + ", error: ", (Throwable) obj2);
                                            return null;
                                        }
                                    });
                                }
                                break;
                            default:
                                kotlin.jvm.internal.h.e(preference, "<unused var>");
                                VoiceAssistFragmentV3 voiceAssistFragmentV32 = this.f21370b;
                                voiceAssistFragmentV32.getClass();
                                boolean zW = VoiceAssistFragmentV3.w();
                                A.c("VoiceAssistFragmentV3", new D6.b(obj, zW, 6));
                                voiceAssistFragmentV32.t();
                                String str2 = voiceAssistFragmentV32.f21316A;
                                kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
                                AbstractC0939b.E().w0(str2, ((Boolean) obj).booleanValue() ? 1 : 0, zW, true);
                                ForkJoinPool.commonPool().execute(new E9.k(24, voiceAssistFragmentV32, obj));
                                break;
                        }
                        return true;
                    }
                });
            }
        }
        this.f21329O = (COUIJumpPreference) a("pref_call_msg_key");
        if (z()) {
            COUIPreferenceCategory cOUIPreferenceCategory6 = this.f21321F;
            if (cOUIPreferenceCategory6 != null) {
                cOUIPreferenceCategory6.setVisible(true);
            }
            if (!this.f21333S && (cOUIPreferenceCategory2 = this.f21321F) != null && cOUIPreferenceCategory2.H != 2) {
                cOUIPreferenceCategory2.H = 2;
                cOUIPreferenceCategory2.notifyChanged();
            }
        } else {
            COUIPreferenceCategory cOUIPreferenceCategory7 = this.f21325K;
            if (cOUIPreferenceCategory7 != null && cOUIPreferenceCategory7.H != 2) {
                cOUIPreferenceCategory7.H = 2;
                cOUIPreferenceCategory7.notifyChanged();
            }
        }
        final int i13 = 0;
        A.c("VoiceAssistFragmentV3", new Supplier(this) { // from class: com.oplus.melody.ui.component.detail.voiceassist.f

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ VoiceAssistFragmentV3 f21372b;

            {
                this.f21372b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        COUISwitchPreference cOUISwitchPreference42 = this.f21372b.H;
                        return "onCreatePreferences, isVoiceAssistEnabled: " + (cOUISwitchPreference42 != null ? Boolean.valueOf(cOUISwitchPreference42.isVisible()) : null);
                    default:
                        VoiceAssistFragmentV3 voiceAssistFragmentV3 = this.f21372b;
                        voiceAssistFragmentV3.getClass();
                        EarphoneDTO earphoneDTOW3 = AbstractC0939b.E().w(voiceAssistFragmentV3.f21316A);
                        boolean z2 = false;
                        if (earphoneDTOW3 != null) {
                            boolean zW = VoiceAssistFragmentV3.w();
                            boolean zK = com.oplus.melody.model.repository.earphone.N.k(1070, earphoneDTOW3.getEarCapability());
                            A.c("VoiceAssistFragmentV3", new U8.f(1, zW, zK));
                            if (zW && zK) {
                                z2 = true;
                            }
                        }
                        return Boolean.valueOf(z2);
                }
            }
        });
        if (this.f21333S) {
            Preference preferenceA = a("header_preference");
            if (preferenceA != null) {
                preferenceA.setVisible(false);
            }
            COUIPreferenceCategory cOUIPreferenceCategory8 = this.f21325K;
            if (cOUIPreferenceCategory8 != null) {
                cOUIPreferenceCategory8.setVisible(false);
            }
            COUIPreferenceCategory cOUIPreferenceCategory9 = this.f21327M;
            if (cOUIPreferenceCategory9 != null) {
                cOUIPreferenceCategory9.setVisible(false);
            }
        }
    }

    public final void s(boolean z2, boolean z4) {
        if (!isAdded()) {
            A.x("VoiceAssistFragmentV3", "checkAndShowDialog, isAdded is false, return");
            return;
        }
        A.c("VoiceAssistFragmentV3", new C6.c(this, z2, z4, 2));
        COUISwitchPreference cOUISwitchPreference = this.f21322G;
        if (cOUISwitchPreference == null || cOUISwitchPreference.isChecked()) {
            if (z2 && z4) {
                return;
            }
            androidx.appcompat.app.f fVar = this.f21330P;
            if (fVar == null || !fVar.isShowing()) {
                Context contextRequireContext = requireContext();
                kotlin.jvm.internal.h.d(contextRequireContext, "requireContext(...)");
                G7.b bVar = new G7.b(contextRequireContext, R.style.COUIAlertDialog_Bottom);
                bVar.n(R.string.melody_common_authorization_tip);
                bVar.g(getResources().getString(R.string.melody_common_voice_assist_dialog_info));
                bVar.l(R.string.melody_common_voice_assist_dialog_goto, new T9.a(this, z2, 2));
                bVar.h(R.string.melody_ui_common_cancel, null);
                this.f21330P = bVar.show();
            }
        }
    }

    public final VoiceViewModel t() {
        return (VoiceViewModel) this.f21334T.getValue();
    }

    public final void u(String str, boolean z2) {
        Intent intent = new Intent("heytap.intent.action.SPEECH_ASSIST_SETTINGS");
        intent.putExtra("enter_id", "melody");
        if (z2) {
            intent.putExtra(":settings:fragment_args_key", str);
        }
        androidx.fragment.app.f activity = getActivity();
        if (activity != null) {
            C0905k.j(activity, intent);
        }
        ForkJoinPool.commonPool().execute(new RunnableC0903i(4, this, str));
    }
}
