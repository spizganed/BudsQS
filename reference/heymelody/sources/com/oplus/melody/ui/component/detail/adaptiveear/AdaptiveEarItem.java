package com.oplus.melody.ui.component.detail.adaptiveear;

import A6.d;
import D7.C0379m;
import D7.o0;
import E9.i;
import Jb.a;
import Jb.l;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: AdaptiveEarItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/oplus/melody/ui/component/detail/adaptiveear/AdaptiveEarItem;", "Lcom/coui/appcompat/preference/COUISwitchPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "setCommandFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "onEarphoneChanged", "", "adaptiveEar", "Lcom/oplus/melody/ui/component/detail/adaptiveear/AdaptiveEarVO;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AdaptiveEarItem extends COUISwitchPreference {
    public static final String ITEM_NAME = "AdaptiveEarItem";
    private CompletableFuture<SetCommandStateDTO> setCommandFuture;
    private final DetailMainViewModel viewModel;

    /* JADX INFO: compiled from: AdaptiveEarItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Aa.b f20613a;

        public b(Aa.b bVar) {
            this.f20613a = bVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f20613a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20613a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdaptiveEarItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        this.viewModel = viewModel;
        setTitle(R.string.melody_ui_guide_adaptive_lr_ear_title);
        setSummary(R.string.melody_ui_guide_adaptive_lr_ear_intro);
        setOnPreferenceChangeListener(new C0.a(this, 10));
        C0379m.b(C0379m.g(AbstractC0939b.E().v(viewModel.f20397b), new A6.b(11))).e(lifecycleOwner, new b(new Aa.b(this, 9)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(AdaptiveEarItem adaptiveEarItem, Preference preference, Object newValue) {
        CompletableFuture<Void> completableFutureThenAccept;
        h.e(newValue, "newValue");
        boolean zBooleanValue = ((Boolean) newValue).booleanValue();
        CompletableFuture<SetCommandStateDTO> completableFuture = adaptiveEarItem.setCommandFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        CompletableFuture<SetCommandStateDTO> completableFutureE0 = AbstractC0939b.E().E0(49, zBooleanValue, adaptiveEarItem.viewModel.f20397b);
        adaptiveEarItem.setCommandFuture = completableFutureE0;
        if (completableFutureE0 != null && (completableFutureThenAccept = completableFutureE0.thenAccept((Consumer<? super SetCommandStateDTO>) new G8.h(new N8.a(adaptiveEarItem, zBooleanValue, 0), 4))) != null) {
            completableFutureThenAccept.exceptionally((Function<Throwable, ? extends Void>) new d(13));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l _init_$lambda$1(AdaptiveEarItem adaptiveEarItem, N8.b bVar) {
        adaptiveEarItem.onEarphoneChanged(bVar);
        return l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l lambda$0$0(AdaptiveEarItem adaptiveEarItem, boolean z2, SetCommandStateDTO result) {
        h.e(result, "result");
        if (result.getSetCommandStatus() == 0) {
            A.b(ITEM_NAME, "setAdaptiveEarStatus succeed");
            DetailMainViewModel detailMainViewModel = adaptiveEarItem.viewModel;
            String str = detailMainViewModel.f20400e;
            String str2 = detailMainViewModel.f20397b;
            C1264t.t(AppConstant$FunctionType.ADAPTIVE_EAR.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), String.valueOf(z2 ? 1 : 0));
        } else {
            A.b(ITEM_NAME, "setAdaptiveEarStatus failed");
            o0.c.f1143a.post(new i(adaptiveEarItem, z2, 1));
        }
        return l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$0$0$0(AdaptiveEarItem adaptiveEarItem, boolean z2) {
        adaptiveEarItem.setChecked(!z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void lambda$0$2(Throwable th) {
        A.i(ITEM_NAME, "setAdaptiveEarStatus, error: ", th);
        return null;
    }

    private final void onEarphoneChanged(N8.b bVar) {
        A.c(ITEM_NAME, new A9.d(bVar, 21));
        if (bVar == null) {
            return;
        }
        setEnabled(bVar.getConnectionState() == 2);
        setChecked(bVar.getStatus() == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onEarphoneChanged$lambda$0(N8.b bVar) {
        return "onEarphoneChanged adaptiveEar = " + bVar;
    }
}
