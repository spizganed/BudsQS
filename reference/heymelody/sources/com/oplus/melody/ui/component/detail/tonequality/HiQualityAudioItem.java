package com.oplus.melody.ui.component.detail.tonequality;

import A9.j;
import A9.p;
import Ca.n;
import Ca.s;
import D7.C0373g;
import D7.C0379m;
import D7.C0381o;
import D7.C0391z;
import D7.o0;
import Ea.F;
import Ea.G;
import Jb.a;
import W9.e;
import W9.g;
import Wb.l;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.f;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.heytap.headset.R;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.app.discovery.Z0;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.S;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.detail.spatialaudio.d;
import com.oplus.melody.ui.widget.MelodyUiTipsSwitchPreference;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import l9.C1286a;
import s8.AbstractC1508a;
import t2.C1518c;

/* JADX INFO: compiled from: HiQualityAudioItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\u0012\u0010!\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020\u001dH\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001dH\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0012H\u0002J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001dH\u0002J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u001fH\u0002J\u0010\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u000201H\u0002R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/oplus/melody/ui/component/detail/tonequality/HiQualityAudioItem;", "Lcom/oplus/melody/ui/widget/MelodyUiTipsSwitchPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "mViewModel", "mLifecycleOwner", "setCommandFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "hiResSoundStatusLiveDataRecord", "Lcom/oplus/melody/common/helper/LiveDataRecord;", "Lcom/oplus/melody/ui/component/detail/tonequality/HiQualityAudioVO;", "alertDialog", "Landroidx/appcompat/app/AlertDialog;", "toolTips", "Lcom/coui/appcompat/tooltips/COUIToolTips;", "config", "Lcom/oplus/melody/common/data/WhitelistConfigDTO;", "codecType", "", "connectionState", "supportTips", "", "setPreferenceListener", "", "initObserve", "onSwitchChanged", "isChecked", "showConfirmDialog", "checked", "onHiResSoundChanged", "vo", "setHiResSoundEnable", "enable", "onConnectionChange", "state", "updateTipsView", "popupDetails", "view", "Landroid/view/View;", "gotoWirelessSettings", "address", "", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HiQualityAudioItem extends MelodyUiTipsSwitchPreference {
    private static final String ACTION_BLUETOOTH_DEVICE_PROFILES_SETTINGS = "wireless.settings.DEVICE_PROFILES_SETTINGS";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    private static final String EXTRA_DEVICE = "device";
    private static final String EXTRA_HIGHLIGHT_ARG_KEY = "highlight_args_key";
    private static final String EXTRA_HIGHLIGHT_VALUE = "MEDIA_AUDIO";
    private static final String EXTRA_SHOW_FRAGMENT_ARGUMENTS = ":settings:show_fragment_args";
    public static final String ITEM_NAME = "HiQualityAudioItem";
    private static final String TAG = "HiQualityAudioItem";
    private f alertDialog;
    private int codecType;
    private WhitelistConfigDTO config;
    private int connectionState;
    private C0381o<g> hiResSoundStatusLiveDataRecord;
    private InterfaceC0601m mLifecycleOwner;
    private DetailMainViewModel mViewModel;
    private CompletableFuture<SetCommandStateDTO> setCommandFuture;
    private boolean supportTips;
    private C1518c toolTips;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.tonequality.HiQualityAudioItem$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: HiQualityAudioItem.kt */
    public static final class Companion {
        public static boolean a(WhitelistConfigDTO.Function function) {
            boolean z2 = function != null && function.getHighToneQuality() == 2;
            boolean z4 = S.j() >= 34;
            boolean zP = S.p();
            A.c("HiQualityAudioItem", new e(0, z2, z4, zP));
            return z2 && z4 && zP;
        }
    }

    /* JADX INFO: compiled from: HiQualityAudioItem.kt */
    public static final /* synthetic */ class b implements v, kotlin.jvm.internal.f {
        public b() {
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, HiQualityAudioItem.this, HiQualityAudioItem.class, "onHiResSoundChanged", "onHiResSoundChanged(Lcom/oplus/melody/ui/component/detail/tonequality/HiQualityAudioVO;)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final void onChanged(Object obj) {
            g p02 = (g) obj;
            h.e(p02, "p0");
            HiQualityAudioItem.this.onHiResSoundChanged(p02);
        }
    }

    /* JADX INFO: compiled from: HiQualityAudioItem.kt */
    public static final class c implements d.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f21314b;

        public c(boolean z2) {
            this.f21314b = z2;
        }

        @Override // com.oplus.melody.ui.component.detail.spatialaudio.d.a
        public final void a() {
            HiQualityAudioItem hiQualityAudioItem = HiQualityAudioItem.this;
            o0.d(new W9.f(hiQualityAudioItem, this.f21314b, 0));
            C1264t.t(AppConstant$FunctionType.SPATIAL_HIRES_SWITCH_DIALOG.getFunType(), hiQualityAudioItem.mViewModel.f20400e, hiQualityAudioItem.mViewModel.f20397b, N.t(hiQualityAudioItem.mViewModel.i(hiQualityAudioItem.mViewModel.f20397b)), BaseHealthModule.TRACK_CERVICAL_REMIND);
        }

        @Override // com.oplus.melody.ui.component.detail.spatialaudio.d.a
        public final void b() {
            HiQualityAudioItem hiQualityAudioItem = HiQualityAudioItem.this;
            hiQualityAudioItem.setHiResSoundEnable(this.f21314b);
            C1264t.t(AppConstant$FunctionType.SPATIAL_HIRES_SWITCH_DIALOG.getFunType(), hiQualityAudioItem.mViewModel.f20400e, hiQualityAudioItem.mViewModel.f20397b, N.t(hiQualityAudioItem.mViewModel.i(hiQualityAudioItem.mViewModel.f20397b)), BaseHealthModule.TRACK_FATIGUE_REMIND);
        }
    }

    /* JADX INFO: compiled from: HiQualityAudioItem.kt */
    public static final class d implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21315a;

        public d(l lVar) {
            this.f21315a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f21315a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21315a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.tonequality.HiQualityAudioItem$initObserve$1, reason: invalid class name */
    /* JADX INFO: compiled from: HiQualityAudioItem.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            ((HiQualityAudioItem) this.receiver).onConnectionChange(num.intValue());
            return Jb.l.f2618a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiQualityAudioItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        WhitelistConfigDTO.Function function;
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        this.mLifecycleOwner = lifecycleOwner;
        this.mViewModel = viewModel;
        setTitle(R.string.melody_common_high_tone_quality_title);
        setSummary(R.string.melody_common_high_tone_quality_summary);
        AbstractC1508a abstractC1508aF = AbstractC1508a.f();
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        WhitelistConfigDTO whitelistConfigDTOC = abstractC1508aF.c(detailMainViewModel.f20400e, detailMainViewModel.f20398c);
        this.config = whitelistConfigDTOC;
        List<Integer> dialogTags = (whitelistConfigDTOC == null || (function = whitelistConfigDTOC.getFunction()) == null) ? null : function.getDialogTags();
        if (dialogTags != null && (dialogTags.contains(1) || dialogTags.contains(2))) {
            setTagIcon(R.drawable.melody_ui_hi_res_audio_icon);
        }
        setPreferenceListener();
        CompletableFuture.supplyAsync(new W9.a(this, 0)).whenCompleteAsync((BiConsumer) new A9.c(new p(this, 3), 8), (Executor) o0.c.f1144b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$0(HiQualityAudioItem hiQualityAudioItem) {
        Companion companion = INSTANCE;
        WhitelistConfigDTO whitelistConfigDTO = hiQualityAudioItem.config;
        WhitelistConfigDTO.Function function = whitelistConfigDTO != null ? whitelistConfigDTO.getFunction() : null;
        companion.getClass();
        hiQualityAudioItem.supportTips = Companion.a(function);
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(HiQualityAudioItem hiQualityAudioItem, Jb.l lVar, Throwable th) {
        hiQualityAudioItem.initObserve();
        return Jb.l.f2618a;
    }

    private final void gotoWirelessSettings(String address) {
        try {
            C0391z.f1171d.getClass();
            BluetoothDevice bluetoothDeviceI = C0391z.i(address);
            if (bluetoothDeviceI == null) {
                A.x("HiQualityAudioItem", "gotoWirelessSettings error, address: " + A.r(address));
                return;
            }
            Intent intent = new Intent(ACTION_BLUETOOTH_DEVICE_PROFILES_SETTINGS);
            Bundle bundle = new Bundle();
            bundle.putParcelable(EXTRA_DEVICE, bluetoothDeviceI);
            Jb.l lVar = Jb.l.f2618a;
            intent.putExtra(EXTRA_SHOW_FRAGMENT_ARGUMENTS, bundle);
            intent.putExtra(EXTRA_HIGHLIGHT_ARG_KEY, EXTRA_HIGHLIGHT_VALUE);
            intent.addFlags(343932928);
            Context context = getContext();
            h.d(context, "getContext(...)");
            C0905k.j(context, intent);
            A.f("HiQualityAudioItem", "gotoWirelessSettings, device: " + bluetoothDeviceI + ", getExtras: " + intent.getExtras());
            C1518c c1518c = this.toolTips;
            if (c1518c != null) {
                c1518c.dismiss();
            }
        } catch (Exception e10) {
            A.i("HiQualityAudioItem", "gotoWirelessSettings: ", e10);
        }
    }

    public static final boolean hasHiQualityV2(WhitelistConfigDTO.Function function) {
        INSTANCE.getClass();
        return Companion.a(function);
    }

    private final void initObserve() {
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        detailMainViewModel.d(detailMainViewModel.f20397b).e(this.mLifecycleOwner, new d(new AnonymousClass1(1, this, HiQualityAudioItem.class, "onConnectionChange", "onConnectionChange(I)V", 0)));
        DetailMainViewModel detailMainViewModel2 = this.mViewModel;
        detailMainViewModel2.n(detailMainViewModel2.f20397b).e(this.mLifecycleOwner, new d(new Aa.b(this, 24)));
        if (C0373g.d()) {
            this.mViewModel.k().e(this.mLifecycleOwner, new d(new j(this, 19)));
        }
        if (this.supportTips) {
            setInitDoneCallback(new O9.d(this, 5));
            C0379m.b(C0379m.g(AbstractC0939b.E().v(this.mViewModel.f20397b), new A6.e(17))).e(this.mLifecycleOwner, new d(new D9.a(this, 14)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l initObserve$lambda$0(HiQualityAudioItem hiQualityAudioItem, C1286a c1286a) {
        if (c1286a != null && c1286a.getDeviceVersionList() != null) {
            hiQualityAudioItem.onConnectionChange(c1286a.isConnected() ? 2 : 3);
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l initObserve$lambda$1(HiQualityAudioItem hiQualityAudioItem, String str) {
        A.f("HiQualityAudioItem", "getLeAudioSwitchStatusChanged, addr: " + str + ", vm.addr: " + hiQualityAudioItem.mViewModel.f20397b);
        if (TextUtils.equals(str, hiQualityAudioItem.mViewModel.f20397b)) {
            CompletableFuture.supplyAsync(new s(8, hiQualityAudioItem, str)).whenComplete((BiConsumer) new A9.s(new F8.g(hiQualityAudioItem, 5), 19));
            return Jb.l.f2618a;
        }
        A.x("HiQualityAudioItem", "getLeAudioSwitchStatusChanged addr not same");
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EarphoneDTO initObserve$lambda$1$0(HiQualityAudioItem hiQualityAudioItem, String str) {
        DetailMainViewModel detailMainViewModel = hiQualityAudioItem.mViewModel;
        h.b(str);
        return detailMainViewModel.i(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l initObserve$lambda$1$1(HiQualityAudioItem hiQualityAudioItem, EarphoneDTO earphoneDTO, Throwable th) {
        if (earphoneDTO != null) {
            o0.c.f1144b.execute(new B6.b(13, hiQualityAudioItem, earphoneDTO));
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initObserve$lambda$1$1$0$0(HiQualityAudioItem hiQualityAudioItem, EarphoneDTO earphoneDTO) {
        hiQualityAudioItem.setPreferenceListener();
        hiQualityAudioItem.onConnectionChange(earphoneDTO.getConnectionState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l initObserve$lambda$2(HiQualityAudioItem hiQualityAudioItem) {
        A.b("HiQualityAudioItem", "initDoneCallback");
        DetailMainViewModel detailMainViewModel = hiQualityAudioItem.mViewModel;
        EarphoneDTO earphoneDTOI = detailMainViewModel.i(detailMainViewModel.f20397b);
        hiQualityAudioItem.codecType = earphoneDTOI != null ? earphoneDTOI.getCodecType() : 0;
        hiQualityAudioItem.updateTipsView();
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l initObserve$lambda$3(HiQualityAudioItem hiQualityAudioItem, Integer num) {
        h.b(num);
        hiQualityAudioItem.codecType = num.intValue();
        A.c("HiQualityAudioItem", new P3.d(hiQualityAudioItem, 15));
        DetailMainViewModel detailMainViewModel = hiQualityAudioItem.mViewModel;
        EarphoneDTO earphoneDTOI = detailMainViewModel.i(detailMainViewModel.f20397b);
        hiQualityAudioItem.onConnectionChange(earphoneDTOI != null ? earphoneDTOI.getConnectionState() : 0);
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String initObserve$lambda$3$0(HiQualityAudioItem hiQualityAudioItem) {
        return A6.b.d(hiQualityAudioItem.codecType, "getCodecType, codecType: ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onConnectionChange(int state) {
        if (this.supportTips) {
            this.connectionState = state;
            DetailMainViewModel detailMainViewModel = this.mViewModel;
            EarphoneDTO earphoneDTOI = detailMainViewModel.i(detailMainViewModel.f20397b);
            this.codecType = earphoneDTOI != null ? earphoneDTOI.getCodecType() : 0;
            updateTipsView();
            if (state == 2 && this.codecType == 8) {
                z = false;
            }
            setDisabled(z);
        } else {
            setDisabled(state != 2);
        }
        b.C0229b.f19632a.a(this.mViewModel.f20397b, LeFilterConstants.FunType.HI_QUALITY_AUDIO.getFunType(), new W9.c(this, state, 0));
        C0381o<g> c0381o = this.hiResSoundStatusLiveDataRecord;
        if (c0381o != null) {
            c0381o.a();
        }
        this.hiResSoundStatusLiveDataRecord = state == 2 ? C0379m.j(C0379m.b(C0379m.g(AbstractC0939b.E().v(this.mViewModel.f20397b), new Z0())), this.mLifecycleOwner, new b()) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConnectionChange$lambda$0(HiQualityAudioItem hiQualityAudioItem, int i10, boolean z2) {
        if (z2) {
            hiQualityAudioItem.setDisabled(true);
            hiQualityAudioItem.setAllowClickWhenDisabled(i10 == 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onHiResSoundChanged(g gVar) {
        A.c("HiQualityAudioItem", new B6.a(gVar, 28));
        setChecked(gVar.isHighToneQualityOn());
        b.C0229b.f19632a.a(this.mViewModel.f20397b, LeFilterConstants.FunType.HI_QUALITY_AUDIO.getFunType(), new E9.h(this, 9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onHiResSoundChanged$lambda$0(g gVar) {
        return A6.e.f("onHiResSoundChanged: ", gVar.isHighToneQualityOn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onHiResSoundChanged$lambda$1(HiQualityAudioItem hiQualityAudioItem, boolean z2) {
        if (z2) {
            hiQualityAudioItem.setChecked(false);
        }
    }

    private final void onSwitchChanged(boolean isChecked) {
        com.oplus.melody.ui.component.detail.spatialaudio.d dVar = com.oplus.melody.ui.component.detail.spatialaudio.d.f21291a;
        String str = this.mViewModel.f20397b;
        dVar.getClass();
        boolean zB = com.oplus.melody.ui.component.detail.spatialaudio.d.b(str);
        A.c("HiQualityAudioItem", new W9.b(0, isChecked, zB));
        if (isChecked && zB) {
            Context context = getContext();
            h.d(context, "getContext(...)");
            com.oplus.melody.ui.component.detail.spatialaudio.d.a(context, this.mViewModel.f20397b, false, new c(isChecked));
        } else {
            f fVar = com.oplus.melody.ui.component.detail.spatialaudio.d.f21295e;
            if (fVar != null ? fVar.isShowing() : false) {
                return;
            }
            showConfirmDialog(isChecked);
        }
    }

    public static /* synthetic */ void onSwitchChanged$default(HiQualityAudioItem hiQualityAudioItem, boolean z2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z2 = false;
        }
        hiQualityAudioItem.onSwitchChanged(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onSwitchChanged$lambda$0(boolean z2, boolean z4) {
        return "isChecked: " + z2 + ", isSpatialOpen: " + z4;
    }

    private final void popupDetails(View view) {
        String string = getContext().getString(R.string.melody_common_hi_res_tips_go_text);
        h.d(string, "getString(...)");
        String string2 = getContext().getString(R.string.melody_common_hi_res_tips_text);
        h.d(string2, "getString(...)");
        String str = String.format(string2, Arrays.copyOf(new Object[]{string}, 1));
        this.toolTips = new C1518c(getContext(), 1);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(P1.a.b(getContext(), R.attr.couiColorLink, 0));
        O1.a aVar = new O1.a(getContext());
        aVar.f3562a = new W9.d(this);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(aVar, spannableString.length() - string.length(), spannableString.length(), 34);
        spannableString.setSpan(foregroundColorSpan, spannableString.length() - string.length(), spannableString.length(), 34);
        C1518c c1518c = this.toolTips;
        if (c1518c != null) {
            c1518c.m(spannableString);
        }
        C1518c c1518c2 = this.toolTips;
        if (c1518c2 != null) {
            c1518c2.n(true);
            c1518c2.p(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void popupDetails$lambda$0(HiQualityAudioItem hiQualityAudioItem) {
        hiQualityAudioItem.gotoWirelessSettings(hiQualityAudioItem.mViewModel.f20397b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHiResSoundEnable(boolean enable) {
        CompletableFuture<Void> completableFutureThenAccept;
        A.x("HiQualityAudioItem", "setHiResSoundEnable.setHiQualityAudioStatus, enable: " + enable + ", isChecked: " + isChecked());
        CompletableFuture<SetCommandStateDTO> completableFuture = this.setCommandFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        CompletableFuture<SetCommandStateDTO> completableFutureE0 = AbstractC0939b.E().E0(24, enable, this.mViewModel.f20397b);
        this.setCommandFuture = completableFutureE0;
        if (completableFutureE0 == null || (completableFutureThenAccept = completableFutureE0.thenAccept((Consumer<? super SetCommandStateDTO>) new G8.h(new N8.a(this, enable, 1), 8))) == null) {
            return;
        }
        completableFutureThenAccept.exceptionally((Function<Throwable, ? extends Void>) new A6.d(21));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l setHiResSoundEnable$lambda$0(HiQualityAudioItem hiQualityAudioItem, boolean z2, SetCommandStateDTO setCommandStateDTO) {
        if (setCommandStateDTO == null || setCommandStateDTO.getSetCommandStatus() != 0) {
            A.b("HiQualityAudioItem", "setHiQualityAudioStatus failed");
        } else {
            A.b("HiQualityAudioItem", "setHiQualityAudioStatus succeed");
            DetailMainViewModel detailMainViewModel = hiQualityAudioItem.mViewModel;
            String str = detailMainViewModel.f20400e;
            String str2 = detailMainViewModel.f20397b;
            C1264t.t(AppConstant$FunctionType.HIGH_QUALITY_AUDIO.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), String.valueOf(z2 ? 1 : 0));
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void setHiResSoundEnable$lambda$2(Throwable th) {
        A.i("HiQualityAudioItem", "setHiQualityAudioStatus", th);
        return null;
    }

    private final void setPreferenceListener() {
        b.C0229b.f19632a.a(this.mViewModel.f20397b, LeFilterConstants.FunType.HI_QUALITY_AUDIO.getFunType(), new F9.s(this, 13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPreferenceListener$lambda$0(HiQualityAudioItem hiQualityAudioItem, boolean z2) {
        A.c("HiQualityAudioItem", new G(10, z2));
        if (z2) {
            hiQualityAudioItem.setOnPreferenceClickListener(new n(hiQualityAudioItem, 9));
        } else {
            hiQualityAudioItem.setOnPreferenceChangeListener(new W9.d(hiQualityAudioItem));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setPreferenceListener$lambda$0$0(boolean z2) {
        return A6.e.f("canDisabled:", z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setPreferenceListener$lambda$0$1(HiQualityAudioItem hiQualityAudioItem, Preference it) {
        h.e(it, "it");
        b.C0229b.f19632a.b(hiQualityAudioItem.getContext(), hiQualityAudioItem.mViewModel.f20397b, LeFilterConstants.FunType.HI_QUALITY_AUDIO.getFunType(), null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setPreferenceListener$lambda$0$2(HiQualityAudioItem hiQualityAudioItem, Preference preference, Object obj) {
        h.e(preference, "<unused var>");
        h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
        hiQualityAudioItem.onSwitchChanged(((Boolean) obj).booleanValue());
        return true;
    }

    private final void showConfirmDialog(boolean checked) {
        f fVar = this.alertDialog;
        if (fVar != null && fVar.isShowing()) {
            A.c("HiQualityAudioItem", new T8.d(this, 1));
            return;
        }
        int i10 = checked ? R.string.melody_common_dialog_high_res_open_title : R.string.melody_common_dialog_high_res_close_title;
        int i11 = checked ? R.string.melody_common_open_high_tone_quality_dialog_title : R.string.melody_common_close_high_tone_quality_dialog_title;
        int i12 = checked ? R.string.melody_ui_multi_devices_dialog_open : R.string.melody_ui_multi_devices_dialog_close;
        Context context = getContext();
        h.d(context, "getContext(...)");
        G7.b bVar = new G7.b(context);
        bVar.n(i10);
        bVar.f(i11);
        bVar.h(R.string.melody_ui_common_cancel, new T9.a(this, checked, 1));
        bVar.l(i12, new P3.b(this, checked));
        f fVarCreate = bVar.setCancelable(false).create();
        this.alertDialog = fVarCreate;
        if (fVarCreate != null) {
            fVarCreate.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String showConfirmDialog$lambda$0(HiQualityAudioItem hiQualityAudioItem) {
        return "showConfirmDialog, checked: " + hiQualityAudioItem.isChecked() + ", is dialog showing. return";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirmDialog$lambda$1(HiQualityAudioItem hiQualityAudioItem, boolean z2, DialogInterface dialogInterface, int i10) {
        hiQualityAudioItem.setChecked(!z2);
        dialogInterface.dismiss();
    }

    private final void updateTipsView() {
        A.c("HiQualityAudioItem", new W9.a(this, 1));
        if (this.codecType != 8) {
            ImageView tipsView = getTipsView();
            if (tipsView != null) {
                tipsView.setVisibility(0);
            }
            ImageView tipsView2 = getTipsView();
            if (tipsView2 != null) {
                tipsView2.setAlpha(this.connectionState == 2 ? 1.0f : 0.3f);
            }
            setTipsViewClickListener(new F(this, 6));
            return;
        }
        ImageView tipsView3 = getTipsView();
        if (tipsView3 != null) {
            tipsView3.setVisibility(8);
        }
        setTipsViewClickListener(null);
        C1518c c1518c = this.toolTips;
        if (c1518c != null) {
            c1518c.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String updateTipsView$lambda$0(HiQualityAudioItem hiQualityAudioItem) {
        return A6.b.d(hiQualityAudioItem.codecType, "updateTipsView, codecType: ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateTipsView$lambda$1(HiQualityAudioItem hiQualityAudioItem, View view) {
        try {
            h.b(view);
            hiQualityAudioItem.popupDetails(view);
        } catch (Exception e10) {
            A.i("HiQualityAudioItem", "setTipsViewClickListener.onClick error: ", e10);
        }
    }
}
