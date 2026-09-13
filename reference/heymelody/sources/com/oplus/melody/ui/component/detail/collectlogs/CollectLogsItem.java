package com.oplus.melody.ui.component.detail.collectlogs;

import Aa.e;
import B9.d;
import D7.C0368b;
import D7.C0373g;
import D7.C0379m;
import D7.C0386u;
import D7.o0;
import E9.u;
import F8.i;
import F9.s;
import F9.x;
import Jb.a;
import W8.c;
import Wb.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.widget.CompoundButton;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyUiJumpSwitchPreference;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import l9.C1286a;

/* JADX INFO: compiled from: CollectLogsItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0017\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0016H\u0002R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/oplus/melody/ui/component/detail/collectlogs/CollectLogsItem;", "Lcom/oplus/melody/ui/widget/MelodyUiJumpSwitchPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "mViewModel", "mLifecycleOwner", "mSetCommandFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "earSupported", "", "doDetailFunction", "", "onSaveLogStatusChanged", ClientDataEntity.COL_STATUS, "", "(Ljava/lang/Integer;)V", "setSaveLogSwitchEnable", "checked", "onEarphoneConnectionChanged", "connectState", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SuppressLint({"InflateParams"})
public final class CollectLogsItem extends MelodyUiJumpSwitchPreference {
    public static final String ITEM_NAME = "collectLogs";
    public static final String TAG = "CollectLogsItem";
    private boolean earSupported;
    private InterfaceC0601m mLifecycleOwner;
    private CompletableFuture<SetCommandStateDTO> mSetCommandFuture;
    private DetailMainViewModel mViewModel;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.collectlogs.CollectLogsItem$6, reason: invalid class name */
    /* JADX INFO: compiled from: CollectLogsItem.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            ((CollectLogsItem) this.receiver).onSaveLogStatusChanged(num);
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: compiled from: CollectLogsItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20660a;

        public b(l lVar) {
            this.f20660a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f20660a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20660a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectLogsItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        this.earSupported = true;
        this.mViewModel = viewModel;
        this.mLifecycleOwner = lifecycleOwner;
        setSwitch(false);
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        setTitle(TextUtils.equals(heyMelodyApplication.getString(R.string.melody_common_lang), "zh-rCN") ? "耳机日志收集" : "Headset Log Collection");
        setOnPreferenceClickListener(new u(3, context, this));
        setOnSwitchChangeListener(new x(this, 2));
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        detailMainViewModel.d(detailMainViewModel.f20397b).e(this.mLifecycleOwner, new b(new d(this, 19)));
        DetailMainViewModel detailMainViewModel2 = this.mViewModel;
        detailMainViewModel2.n(detailMainViewModel2.f20397b).e(this.mLifecycleOwner, new b(new D9.a(this, 13)));
        C0379m.b(C0379m.g(AbstractC0939b.E().v(this.mViewModel.f20397b), new A6.b(18))).e(this.mLifecycleOwner, new b(new AnonymousClass6(1, this, CollectLogsItem.class, "onSaveLogStatusChanged", "onSaveLogStatusChanged(Ljava/lang/Integer;)V", 0)));
        if (C0373g.d()) {
            this.mViewModel.k().e(this.mLifecycleOwner, new b(new Aa.b(this, 23)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(Context context, CollectLogsItem collectLogsItem, Preference it) {
        h.e(it, "it");
        b.C0229b.f19632a.b(context, collectLogsItem.mViewModel.f20397b, LeFilterConstants.FunType.COLLECT_LOG.getFunType(), new s(collectLogsItem, 12));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(CollectLogsItem collectLogsItem, CompoundButton preference, boolean z2) {
        h.e(preference, "preference");
        collectLogsItem.setSaveLogSwitchEnable(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$3(CollectLogsItem collectLogsItem, Integer num) {
        h.b(num);
        collectLogsItem.onEarphoneConnectionChanged(num.intValue());
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$4(CollectLogsItem collectLogsItem, C1286a c1286a) {
        if (c1286a != null && c1286a.getDeviceVersionList() != null) {
            collectLogsItem.onEarphoneConnectionChanged(c1286a.isConnected() ? 2 : 3);
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$5(CollectLogsItem collectLogsItem, String str) {
        A.f(TAG, "getLeAudioSwitchStatusChanged, addr: " + str + ", vm.addr: " + collectLogsItem.mViewModel.f20397b);
        if (TextUtils.equals(str, collectLogsItem.mViewModel.f20397b)) {
            CompletableFuture.supplyAsync(new C0386u(11, collectLogsItem, str)).whenComplete((BiConsumer) new B9.b(new B9.a(collectLogsItem, 10), 18));
            return Jb.l.f2618a;
        }
        A.x(TAG, "getLeAudioSwitchStatusChanged addr not same");
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EarphoneDTO _init_$lambda$5$0(CollectLogsItem collectLogsItem, String str) {
        DetailMainViewModel detailMainViewModel = collectLogsItem.mViewModel;
        h.b(str);
        return detailMainViewModel.i(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$5$1(CollectLogsItem collectLogsItem, EarphoneDTO earphoneDTO, Throwable th) {
        if (earphoneDTO != null) {
            o0.c.f1144b.execute(new B6.b(12, collectLogsItem, earphoneDTO));
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5$1$0$0(CollectLogsItem collectLogsItem, EarphoneDTO earphoneDTO) {
        collectLogsItem.onEarphoneConnectionChanged(earphoneDTO.getConnectionState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doDetailFunction() {
        E8.a.w().getClass();
        Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/collect_logs/main");
        iVarA.f("device_mac_info", this.mViewModel.f20397b);
        iVarA.f("product_id", this.mViewModel.f20400e);
        iVarA.b(getContext());
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        EarphoneDTO earphoneDTOI = detailMainViewModel.i(detailMainViewModel.f20397b);
        if (earphoneDTOI != null) {
            DetailMainViewModel detailMainViewModel2 = this.mViewModel;
            String str = detailMainViewModel2.f20400e;
            String str2 = detailMainViewModel2.f20397b;
            C1264t.t(AppConstant$FunctionType.COLLECT_LOGS.getFunType(), str, str2, N.t(detailMainViewModel2.i(str2)), String.valueOf(earphoneDTOI.getSaveLogStatus()));
        }
    }

    private final void onEarphoneConnectionChanged(int connectState) {
        setDisabled(connectState != 2);
        b.C0229b.f19632a.a(this.mViewModel.f20397b, LeFilterConstants.FunType.COLLECT_LOG.getFunType(), new c(this, connectState, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onEarphoneConnectionChanged$lambda$0(CollectLogsItem collectLogsItem, int i10, boolean z2) {
        if (z2) {
            collectLogsItem.setDisabled(true);
            collectLogsItem.setAllowClickWhenDisabled(i10 == 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSaveLogStatusChanged(Integer status) {
        A.c(TAG, new C0386u(12, status, this));
        if (!this.earSupported) {
            o0.d(new e(this, 18));
            return;
        }
        if (status != null) {
            int iIntValue = status.intValue();
            if (iIntValue != -1) {
                setSwitch(true);
            } else {
                setSwitch(false);
            }
            setChecked(iIntValue == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onSaveLogStatusChanged$lambda$0(Integer num, CollectLogsItem collectLogsItem) {
        return "onSaveLogStatusChanged, status: " + num + ", earSupported: " + collectLogsItem.earSupported;
    }

    private final void setSaveLogSwitchEnable(boolean checked) {
        CompletableFuture<Void> completableFutureThenAccept;
        CompletableFuture<SetCommandStateDTO> completableFuture = this.mSetCommandFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        CompletableFuture<SetCommandStateDTO> completableFutureE0 = AbstractC0939b.E().E0(30, checked, this.mViewModel.f20397b);
        this.mSetCommandFuture = completableFutureE0;
        if (completableFutureE0 == null || (completableFutureThenAccept = completableFutureE0.thenAccept((Consumer<? super SetCommandStateDTO>) new C0368b(new W8.a(this, checked, 0), 9))) == null) {
            return;
        }
        completableFutureThenAccept.exceptionally((Function<Throwable, ? extends Void>) new W8.b(this, checked, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l setSaveLogSwitchEnable$lambda$0(CollectLogsItem collectLogsItem, boolean z2, SetCommandStateDTO setCommandStateDTO) {
        if (setCommandStateDTO == null || setCommandStateDTO.getSetCommandStatus() != 0) {
            collectLogsItem.earSupported = false;
            o0.d(new W8.d(collectLogsItem, 0, z2));
            A.b(TAG, "set save log switch failed ");
        } else {
            A.b(TAG, "set save log switch succeed");
            DetailMainViewModel detailMainViewModel = collectLogsItem.mViewModel;
            if (detailMainViewModel.i(detailMainViewModel.f20397b) != null) {
                DetailMainViewModel detailMainViewModel2 = collectLogsItem.mViewModel;
                String str = detailMainViewModel2.f20400e;
                String str2 = detailMainViewModel2.f20397b;
                C1264t.t(AppConstant$FunctionType.COLLECT_LOGS.getFunType(), str, str2, N.t(detailMainViewModel2.i(str2)), String.valueOf(z2 ? 1 : 0));
            }
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSaveLogSwitchEnable$lambda$0$1(CollectLogsItem collectLogsItem, boolean z2) {
        collectLogsItem.setChecked(!z2);
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        E8.a.T(collectLogsItem.getContext(), TextUtils.equals(heyMelodyApplication.getString(R.string.melody_common_lang), "zh-rCN") ? "耳机件版本不支持或异常" : "Headset not supported");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void setSaveLogSwitchEnable$lambda$2(CollectLogsItem collectLogsItem, boolean z2, Throwable th) {
        o0.d(new W8.d(collectLogsItem, 1, z2));
        A.i(TAG, "set save log switch", th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSaveLogSwitchEnable$lambda$2$0(CollectLogsItem collectLogsItem, boolean z2) {
        collectLogsItem.setChecked(!z2);
    }
}
