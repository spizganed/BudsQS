package com.oplus.melody.ui.component.detail.diagnostic;

import B9.d;
import Ca.n;
import D7.C0373g;
import D7.C0386u;
import D7.o0;
import E9.u;
import F8.i;
import Jb.a;
import Wb.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import l9.C1286a;

/* JADX INFO: compiled from: DiagnosticItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/oplus/melody/ui/component/detail/diagnostic/DiagnosticItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "mViewModel", "doDetailFunction", "", "onEarphoneConnectionChanged", "connectState", "", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SuppressLint({"InflateParams"})
public final class DiagnosticItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "diagnostic";
    public static final String TAG = "DiagnosticItem";
    private DetailMainViewModel mViewModel;

    /* JADX INFO: compiled from: DiagnosticItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20663a;

        public b(l lVar) {
            this.f20663a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f20663a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20663a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        this.mViewModel = viewModel;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        setTitle(TextUtils.equals(heyMelodyApplication.getString(R.string.melody_common_lang), "zh-rCN") ? "耳机诊断" : "Headset diagnostics");
        setOnPreferenceClickListener(new u(4, context, this));
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        detailMainViewModel.d(detailMainViewModel.f20397b).e(lifecycleOwner, new b(new d(this, 21)));
        DetailMainViewModel detailMainViewModel2 = this.mViewModel;
        detailMainViewModel2.n(detailMainViewModel2.f20397b).e(lifecycleOwner, new b(new D9.a(this, 17)));
        if (C0373g.d()) {
            this.mViewModel.k().e(lifecycleOwner, new b(new Aa.b(this, 27)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(Context context, DiagnosticItem diagnosticItem, Preference it) {
        h.e(it, "it");
        b.C0229b.f19632a.b(context, diagnosticItem.mViewModel.f20397b, LeFilterConstants.FunType.DIAGNOSTIC.getFunType(), new n(diagnosticItem, 11));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$2(DiagnosticItem diagnosticItem, Integer num) {
        h.b(num);
        diagnosticItem.onEarphoneConnectionChanged(num.intValue());
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$3(DiagnosticItem diagnosticItem, C1286a c1286a) {
        if (c1286a != null && c1286a.getDeviceVersionList() != null) {
            diagnosticItem.onEarphoneConnectionChanged(c1286a.isConnected() ? 2 : 3);
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$4(DiagnosticItem diagnosticItem, String str) {
        A.f(TAG, "getLeAudioSwitchStatusChanged, addr: " + str + ", vm.addr: " + diagnosticItem.mViewModel.f20397b);
        if (TextUtils.equals(str, diagnosticItem.mViewModel.f20397b)) {
            CompletableFuture.supplyAsync(new C0386u(14, diagnosticItem, str)).whenComplete((BiConsumer) new B9.b(new B9.a(diagnosticItem, 11), 20));
            return Jb.l.f2618a;
        }
        A.x(TAG, "getLeAudioSwitchStatusChanged addr not same");
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EarphoneDTO _init_$lambda$4$0(DiagnosticItem diagnosticItem, String str) {
        DetailMainViewModel detailMainViewModel = diagnosticItem.mViewModel;
        h.b(str);
        return detailMainViewModel.i(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$4$1(DiagnosticItem diagnosticItem, EarphoneDTO earphoneDTO, Throwable th) {
        if (earphoneDTO != null) {
            o0.c.f1144b.execute(new Aa.d(14, diagnosticItem, earphoneDTO));
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4$1$0$0(DiagnosticItem diagnosticItem, EarphoneDTO earphoneDTO) {
        diagnosticItem.onEarphoneConnectionChanged(earphoneDTO.getConnectionState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doDetailFunction() {
        E8.a.w().getClass();
        Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/demo_rc/diagnosis");
        iVarA.f("device_mac_info", this.mViewModel.f20397b);
        iVarA.f("product_id", this.mViewModel.f20400e);
        iVarA.b(getContext());
    }

    private final void onEarphoneConnectionChanged(int connectState) {
        setDisabled(connectState != 2);
        b.C0229b.f19632a.a(this.mViewModel.f20397b, LeFilterConstants.FunType.DIAGNOSTIC.getFunType(), new Z8.a(this, connectState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onEarphoneConnectionChanged$lambda$0(DiagnosticItem diagnosticItem, int i10, boolean z2) {
        if (z2) {
            diagnosticItem.setDisabled(true);
            diagnosticItem.setAllowClickWhenDisabled(i10 == 2);
        }
    }
}
