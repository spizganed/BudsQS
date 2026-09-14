package com.oplus.melody.ui.component.detail.highaudio;

import Ca.s;
import D7.C0373g;
import D7.o0;
import E9.u;
import F8.i;
import Jb.a;
import W9.c;
import Wb.l;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import c9.g;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import e9.C1017a;
import e9.C1020d;
import g0.i;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import l9.C1286a;
import la.C1310x;

/* JADX INFO: compiled from: HighAudioItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/oplus/melody/ui/component/detail/highaudio/HighAudioItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "mViewModel", "mLifecycleOwner", "doDetailFunction", "", "onConnectionChange", "state", "", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HighAudioItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "HighAudioItem";
    public static final String TAG = "HighAudioItem";
    private InterfaceC0601m mLifecycleOwner;
    private DetailMainViewModel mViewModel;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.highaudio.HighAudioItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: HighAudioItem.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            ((HighAudioItem) this.receiver).onConnectionChange(num.intValue());
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: compiled from: HighAudioItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21083a;

        public b(l lVar) {
            this.f21083a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f21083a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21083a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HighAudioItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        this.mLifecycleOwner = lifecycleOwner;
        this.mViewModel = viewModel;
        setTitle(R.string.melody_common_high_audio_title);
        setOnPreferenceClickListener(new u(20, context, this));
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        detailMainViewModel.d(detailMainViewModel.f20397b).e(this.mLifecycleOwner, new b(new AnonymousClass2(1, this, HighAudioItem.class, "onConnectionChange", "onConnectionChange(I)V", 0)));
        DetailMainViewModel detailMainViewModel2 = this.mViewModel;
        detailMainViewModel2.n(detailMainViewModel2.f20397b).e(this.mLifecycleOwner, new b(new C1020d(this, 7)));
        if (C0373g.d()) {
            this.mViewModel.k().e(this.mLifecycleOwner, new b(new C1017a(this, 8)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(Context context, HighAudioItem highAudioItem, Preference it) {
        h.e(it, "it");
        b.C0229b.f19632a.b(context, highAudioItem.mViewModel.f20397b, LeFilterConstants.FunType.HIGH_AUDIO.getFunType(), new C1310x(highAudioItem, 7));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(HighAudioItem highAudioItem, C1286a c1286a) {
        if (c1286a != null && c1286a.getDeviceVersionList() != null) {
            highAudioItem.onConnectionChange(c1286a.isConnected() ? 2 : 3);
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$2(HighAudioItem highAudioItem, String str) {
        A.f("HighAudioItem", "getLeAudioSwitchStatusChanged, addr: " + str + ", vm.addr: " + highAudioItem.mViewModel.f20397b);
        if (TextUtils.equals(str, highAudioItem.mViewModel.f20397b)) {
            CompletableFuture.supplyAsync(new s(24, highAudioItem, str)).whenComplete((BiConsumer) new g(new F8.g(highAudioItem, 17), 13));
            return Jb.l.f2618a;
        }
        A.x("HighAudioItem", "getLeAudioSwitchStatusChanged addr not same");
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EarphoneDTO _init_$lambda$2$0(HighAudioItem highAudioItem, String str) {
        DetailMainViewModel detailMainViewModel = highAudioItem.mViewModel;
        h.b(str);
        return detailMainViewModel.i(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$2$1(HighAudioItem highAudioItem, EarphoneDTO earphoneDTO, Throwable th) {
        if (earphoneDTO != null) {
            o0.c.f1144b.execute(new i(20, highAudioItem, earphoneDTO));
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2$1$0$0(HighAudioItem highAudioItem, EarphoneDTO earphoneDTO) {
        highAudioItem.onConnectionChange(earphoneDTO.getConnectionState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doDetailFunction() {
        E8.a.w().getClass();
        Jb.b<List<l<String, Class<?>>>> bVar = F8.i.f1668g;
        F8.i iVarA = i.a.a("/ui/high_audio");
        iVarA.f("device_mac_info", this.mViewModel.f20397b);
        iVarA.f("device_name", this.mViewModel.f20398c);
        iVarA.f("product_id", this.mViewModel.f20400e);
        iVarA.f("product_color", String.valueOf(this.mViewModel.f20401f));
        iVarA.b(getContext());
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.HIGH_AUDIO.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onConnectionChange(int state) {
        setDisabled(state != 2);
        b.C0229b.f19632a.a(this.mViewModel.f20397b, LeFilterConstants.FunType.HIGH_AUDIO.getFunType(), new c(this, state, 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConnectionChange$lambda$0(HighAudioItem highAudioItem, int i10, boolean z2) {
        if (z2) {
            highAudioItem.setDisabled(true);
            highAudioItem.setAllowClickWhenDisabled(i10 == 2);
        }
    }
}
