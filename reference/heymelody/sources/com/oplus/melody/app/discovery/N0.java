package com.oplus.melody.app.discovery;

import D7.o0;
import Q7.b;
import android.text.TextUtils;
import com.heytap.headset.R;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.track.constant.AppConstant$DialogType;
import com.oplus.melody.track.constant.AppConstant$UserAction;
import com.oplus.melody.ui.widget.MelodyCompatTextView;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import u8.C1557e;
import u8.C1558f;

/* JADX INFO: compiled from: DiscoveryViewStateBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class N0 extends I0 {
    @Override // com.oplus.melody.app.discovery.I0
    public final C1557e a(C1558f c1558f) {
        return c1558f.getConnectingState();
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final CompletableFuture<Integer> g(int i10, C1 c12) {
        com.oplus.melody.common.util.A.b("DiscoveryViewStateBindingImpl", "onEnter...");
        int i11 = 0;
        this.f18936j.setOnClickListener(new J0(this, i11));
        DiscoveryDialogViewModel discoveryDialogViewModel = this.f18930c;
        boolean zK = discoveryDialogViewModel.k();
        MelodyCompatTextView melodyCompatTextView = this.f18931d;
        if (zK || discoveryDialogViewModel.l()) {
            melodyCompatTextView.setText(R.string.melody_common_account_binding);
            this.h = AppConstant$DialogType.BACK_CONNECT_BY_ACCOUNT;
        } else {
            MelodyResourceDO now = c().getNow(null);
            melodyCompatTextView.setText((now == null || TextUtils.isEmpty(now.getText())) ? melodyCompatTextView.getResources().getString(R.string.melody_app_discovery_connecting) : now.getText());
            this.h = AppConstant$DialogType.CONNECT_BY_ACCOUNT;
        }
        final E0 e0D = d();
        int i12 = Q7.b.f4152c;
        final String str = (String) Optional.ofNullable(b.a.a()).map(new A6.i(3)).orElse(null);
        if (e0D == null || TextUtils.isEmpty(e0D.getId()) || TextUtils.isEmpty(str)) {
            D7.o0.d(new K0(this, 0));
            return J6.d.f(i10, 0, melodyCompatTextView);
        }
        this.f18929b.c0(2);
        CompletableFuture completableFuture = (CompletableFuture) Optional.ofNullable((Q7.a) D1.f.r(Q7.a.class)).map(new Function() { // from class: com.oplus.melody.app.discovery.L0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Q7.a) obj).b(e0D.getId(), str, true);
            }
        }).orElse(null);
        if (completableFuture != null) {
            completableFuture.exceptionally((Function) new C0867l0(4)).thenAcceptAsync((Consumer) new M0(this, i11), (Executor) o0.c.f1144b);
        } else {
            com.oplus.melody.common.util.A.x("DiscoveryViewStateBindingImpl", "onEnter bindOrUnbindAccount future is null!");
            D7.o0.d(new K0(this, 1));
        }
        return super.g(i10, c12).thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new C0894z0(this, i10, 1));
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final CompletableFuture<Integer> h(int i10) {
        return super.h(i10).thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new D7.X(this, i10, 1));
    }

    public final void q() {
        DiscoveryDialogActivity discoveryDialogActivity = this.f18929b;
        if (discoveryDialogActivity == null) {
            com.oplus.melody.common.util.A.h("DiscoveryViewStateBindingImpl", "handleBindFailed, mOwner is null!");
            return;
        }
        DiscoveryDialogViewModel discoveryDialogViewModel = this.f18930c;
        if (discoveryDialogViewModel == null) {
            com.oplus.melody.common.util.A.h("DiscoveryViewStateBindingImpl", "handleBindFailed, mDialogViewModel is null!");
            return;
        }
        if (discoveryDialogViewModel.k() || discoveryDialogViewModel.l()) {
            discoveryDialogActivity.O();
            n(AppConstant$UserAction.ACTION_COMPLETE);
        } else if (discoveryDialogViewModel.m()) {
            j(6);
        }
    }
}
