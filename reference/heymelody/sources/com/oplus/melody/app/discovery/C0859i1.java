package com.oplus.melody.app.discovery;

import D7.C0388w;
import D7.o0;
import android.text.TextUtils;
import com.heytap.headset.R;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import com.oplus.melody.ui.widget.MelodyCompatTextView;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import u8.C1557e;
import u8.C1558f;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.i1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DiscoveryViewStateConnectingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0859i1 extends I0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f19116m;

    @Override // com.oplus.melody.app.discovery.I0
    public final C1557e a(C1558f c1558f) {
        return c1558f.getConnectingState();
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final CompletableFuture<Integer> g(int i10, C1 c12) {
        int i11 = 2;
        this.f19116m = false;
        this.f18936j.setOnClickListener(new ViewOnClickListenerC0856h1(this, 0));
        C1557e c1557eB = b(c12);
        int i12 = 1;
        if (c1557eB != null && Boolean.TRUE.equals(c1557eB.getShowCancelBesidePrimary())) {
            this.f19116m = true;
            MelodyCompatButton melodyCompatButton = this.f18937k;
            melodyCompatButton.setText(R.string.melody_ui_common_cancel);
            melodyCompatButton.setOnClickListener(new u1(this, i11));
            melodyCompatButton.setVisibility(0);
            o(melodyCompatButton);
        }
        MelodyResourceDO now = c().getNow(null);
        MelodyCompatTextView melodyCompatTextView = this.f18931d;
        String string = (now == null || TextUtils.isEmpty(now.getText())) ? melodyCompatTextView.getResources().getString(R.string.melody_app_discovery_connecting) : now.getText();
        E0 e0D = d();
        DiscoveryDialogViewModel discoveryDialogViewModel = this.f18930c;
        if (e0D != null && e0D.getAccountBindingState() == 1 && (discoveryDialogViewModel.l() || discoveryDialogViewModel.k())) {
            melodyCompatTextView.setText(R.string.melody_common_account_binding);
        } else {
            MelodyCompatTextView melodyCompatTextView2 = this.f18933f;
            if (melodyCompatTextView2 == null || e0D == null) {
                melodyCompatTextView.setText(string);
            } else {
                CompletableFuture<String> completableFutureG = discoveryDialogViewModel.g(e0D);
                Objects.requireNonNull(melodyCompatTextView);
                completableFutureG.thenAcceptAsync((Consumer<? super String>) new M0(melodyCompatTextView, i12), (Executor) o0.c.f1144b).exceptionally((Function<Throwable, ? extends Void>) new C0388w(28));
                melodyCompatTextView2.setText(string);
            }
        }
        return this.f19116m ? super.g(i10, c12).thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new C0894z0(this, i10, 3)) : super.g(i10, c12).thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new D7.X(this, i10, 2));
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final CompletableFuture<Integer> h(int i10) {
        return super.h(i10).thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new C0861j0(this, i10, 1));
    }
}
