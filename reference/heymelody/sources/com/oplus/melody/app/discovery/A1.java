package com.oplus.melody.app.discovery;

import android.os.Handler;
import android.view.ViewStub;
import com.heytap.headset.R;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import com.oplus.melody.ui.widget.MelodyCompatTextView;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import u8.C1557e;
import u8.C1558f;

/* JADX INFO: compiled from: DiscoveryViewStateShareSuccessImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class A1 extends I0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MelodyCompatButton f18816m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RunnableC0857i f18817n;

    public A1(DiscoveryDialogActivity discoveryDialogActivity, int i10) {
        super(discoveryDialogActivity, i10);
        DiscoveryDialogActivity discoveryDialogActivity2 = this.f18929b;
        Objects.requireNonNull(discoveryDialogActivity2);
        this.f18817n = new RunnableC0857i(discoveryDialogActivity2, 2);
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final C1557e a(C1558f c1558f) {
        return null;
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final CompletableFuture<Integer> g(int i10, C1 c12) {
        C1557e connectedState;
        this.f18936j.setOnClickListener(new J0(this, 2));
        DiscoveryDialogActivity discoveryDialogActivity = this.f18929b;
        int color = discoveryDialogActivity.getResources().getColor(R.color.melody_app_discovery_title_text_color, null);
        MelodyCompatTextView melodyCompatTextView = this.f18931d;
        melodyCompatTextView.setTextColor(color);
        melodyCompatTextView.setText(R.string.melody_common_audio_share_success);
        MelodyCompatButton melodyCompatButton = this.f18938l;
        this.f18816m = melodyCompatButton;
        melodyCompatButton.setText(R.string.melody_app_discovery_done);
        this.f18816m.setOnClickListener(new ViewOnClickListenerC0865k1(this, 3));
        C1558f discoveryStates = c12.getDiscoveryStates();
        long closeDelay = (discoveryStates == null || (connectedState = discoveryStates.getConnectedState()) == null || connectedState.getCloseDelay() <= 0) ? 5000L : connectedState.getCloseDelay();
        Handler handler = discoveryDialogActivity.f18850W;
        RunnableC0857i runnableC0857i = this.f18817n;
        handler.removeCallbacks(runnableC0857i);
        handler.postDelayed(runnableC0857i, closeDelay);
        return super.g(i10, c12).thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new C0894z0(this, i10, 5));
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final void m(C1 c12, boolean z2) {
        ((ViewStub) this.f18929b.f18865l0.findViewById(R.id.melody_app_discovery_share_audio_success)).inflate();
    }
}
