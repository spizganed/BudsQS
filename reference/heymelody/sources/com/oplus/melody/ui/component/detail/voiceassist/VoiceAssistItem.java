package com.oplus.melody.ui.component.detail.voiceassist;

import A9.p;
import A9.q;
import D7.C0373g;
import D7.RunnableC0369c;
import D7.o0;
import F8.i;
import a9.C0531H;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import kc.C1264t;
import kotlin.Metadata;
import l9.C1286a;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: VoiceAssistItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/oplus/melody/ui/component/detail/voiceassist/VoiceAssistItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "voiceWake", "", "Ljava/lang/Integer;", "doDetailFunction", "", "onConnectionChange", "state", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class VoiceAssistItem extends MelodyUiCOUIJumpPreference {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final String ITEM_NAME = "VoiceAssistItem";
    public static final String TAG = "VoiceAssistItem";
    private InterfaceC0601m lifecycleOwner;
    private DetailMainViewModel viewModel;
    private Integer voiceWake;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.voiceassist.VoiceAssistItem$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: VoiceAssistItem.kt */
    public static final class Companion {
        public static boolean a(String str) {
            WhitelistConfigDTO.Function function;
            WhitelistConfigDTO whitelistConfigDTOA = AbstractC1508a.f().a(str);
            if (whitelistConfigDTOA == null || (function = whitelistConfigDTOA.getFunction()) == null) {
                return false;
            }
            return Y.e(function.getIncomingCallControl(), false);
        }
    }

    /* JADX INFO: compiled from: VoiceAssistItem.kt */
    public static final class b implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Wb.l f21338a;

        public b(Wb.l lVar) {
            this.f21338a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return kotlin.jvm.internal.h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21338a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21338a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceAssistItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        WhitelistConfigDTO.Function function;
        super(context);
        kotlin.jvm.internal.h.e(context, "context");
        kotlin.jvm.internal.h.e(viewModel, "viewModel");
        kotlin.jvm.internal.h.e(lifecycleOwner, "lifecycleOwner");
        this.voiceWake = -1;
        this.lifecycleOwner = lifecycleOwner;
        this.viewModel = viewModel;
        AbstractC1508a abstractC1508aF = AbstractC1508a.f();
        DetailMainViewModel detailMainViewModel = this.viewModel;
        WhitelistConfigDTO whitelistConfigDTOC = abstractC1508aF.c(detailMainViewModel.f20400e, detailMainViewModel.f20398c);
        this.voiceWake = (whitelistConfigDTOC == null || (function = whitelistConfigDTOC.getFunction()) == null) ? null : Integer.valueOf(function.getVoiceWake());
        setTitle(R.string.melody_common_voice_assist_title);
        Integer num = this.voiceWake;
        if (num == null || num.intValue() != 3) {
            setSummary(R.string.melody_common_voice_assist_summary);
        }
        viewModel.d(viewModel.f20397b).e(this.lifecycleOwner, new b(new C0531H(this, 9)));
        DetailMainViewModel detailMainViewModel2 = this.viewModel;
        detailMainViewModel2.n(detailMainViewModel2.f20397b).e(this.lifecycleOwner, new b(new A9.j(this, 26)));
        setOnPreferenceClickListener(new A9.e(11, context, this));
        if (C0373g.d()) {
            this.viewModel.k().e(this.lifecycleOwner, new b(new D9.a(this, 27)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$0(VoiceAssistItem voiceAssistItem, Integer num) {
        kotlin.jvm.internal.h.b(num);
        voiceAssistItem.onConnectionChange(num.intValue());
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(VoiceAssistItem voiceAssistItem, C1286a c1286a) {
        if (c1286a != null && c1286a.getDeviceVersionList() != null) {
            voiceAssistItem.onConnectionChange(c1286a.isConnected() ? 2 : 3);
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$2(Context context, VoiceAssistItem voiceAssistItem, Preference it) {
        kotlin.jvm.internal.h.e(it, "it");
        b.C0229b.f19632a.b(context, voiceAssistItem.viewModel.f20397b, LeFilterConstants.FunType.VOICE_WAKE.getFunType(), new E9.h(voiceAssistItem, 26));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$3(VoiceAssistItem voiceAssistItem, String str) {
        A.f("VoiceAssistItem", "getLeAudioSwitchStatusChanged, addr: " + str + ", vm.addr: " + voiceAssistItem.viewModel.f20397b);
        if (TextUtils.equals(str, voiceAssistItem.viewModel.f20397b)) {
            CompletableFuture.supplyAsync(new B9.f(19, voiceAssistItem, str)).whenComplete((BiConsumer) new q(new p(voiceAssistItem, 7), 16));
            return Jb.l.f2618a;
        }
        A.x("VoiceAssistItem", "getLeAudioSwitchStatusChanged addr not same");
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EarphoneDTO _init_$lambda$3$0(VoiceAssistItem voiceAssistItem, String str) {
        DetailMainViewModel detailMainViewModel = voiceAssistItem.viewModel;
        kotlin.jvm.internal.h.b(str);
        return detailMainViewModel.i(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$3$1(VoiceAssistItem voiceAssistItem, EarphoneDTO earphoneDTO, Throwable th) {
        if (earphoneDTO != null) {
            o0.c.f1144b.execute(new RunnableC0369c(28, voiceAssistItem, earphoneDTO));
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3$1$0$0(VoiceAssistItem voiceAssistItem, EarphoneDTO earphoneDTO) {
        voiceAssistItem.onConnectionChange(earphoneDTO.getConnectionState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doDetailFunction() {
        E8.a.w().getClass();
        Jb.b<List<Wb.l<String, Class<?>>>> bVar = F8.i.f1668g;
        F8.i iVarA = i.a.a("/ui/voice_assist");
        iVarA.f("device_mac_info", this.viewModel.f20397b);
        iVarA.f("device_name", this.viewModel.f20398c);
        iVarA.f("product_id", this.viewModel.f20400e);
        iVarA.f("product_color", String.valueOf(this.viewModel.f20401f));
        iVarA.b(getContext());
        DetailMainViewModel detailMainViewModel = this.viewModel;
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.VOICE_ASSIST.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
    }

    public static final boolean isSupportIncomingCallControl(String str) {
        INSTANCE.getClass();
        return Companion.a(str);
    }

    private final void onConnectionChange(int state) {
        setDisabled(state != 2);
        b.C0229b.f19632a.a(this.viewModel.f20397b, LeFilterConstants.FunType.VOICE_WAKE.getFunType(), new W9.c(this, state, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConnectionChange$lambda$0(VoiceAssistItem voiceAssistItem, int i10, boolean z2) {
        if (z2) {
            voiceAssistItem.setDisabled(true);
            voiceAssistItem.setAllowClickWhenDisabled(i10 == 2);
        }
    }
}
