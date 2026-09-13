package com.oplus.melody.app.discovery;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import com.heytap.headset.R;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.track.constant.AppConstant$ConnectResult;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import com.oplus.melody.ui.widget.MelodyCompatTextView;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import u8.C1557e;
import u8.C1558f;

/* JADX INFO: compiled from: DiscoveryViewStateErrorImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class l1 extends I0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ViewOnClickListenerC0856h1 f19136m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MelodyCompatButton f19137n;

    public l1(DiscoveryDialogActivity discoveryDialogActivity, int i10) {
        super(discoveryDialogActivity, i10);
        this.f19136m = new ViewOnClickListenerC0856h1(this, 1);
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final C1557e a(C1558f c1558f) {
        return c1558f.getErrorState();
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final CompletableFuture<Integer> g(int i10, C1 c12) {
        MelodyCompatButton melodyCompatButton = this.f18938l;
        this.f19137n = melodyCompatButton;
        melodyCompatButton.setText(R.string.melody_app_discovery_retry);
        this.f19137n.setOnClickListener(this.f19136m);
        this.f18936j.setOnClickListener(new ViewOnClickListenerC0865k1(this, 0));
        MelodyResourceDO now = c().getNow(null);
        MelodyCompatTextView melodyCompatTextView = this.f18931d;
        if (now == null || TextUtils.isEmpty(now.getText())) {
            melodyCompatTextView.setText(R.string.melody_app_discovery_failed_to_connect);
        } else {
            melodyCompatTextView.setText(now.getText());
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(melodyCompatTextView, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, 0.0f, 25.0f, 24.0f, -7.0f, 4.0f, -4.0f, 3.0f, 0.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(230L);
        objectAnimatorOfPropertyValuesHolder.start();
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) this.f18929b.getSystemService("vibrator")).vibrate(VibrationEffect.createOneShot(230L, -1));
        }
        this.f18935i = AppConstant$ConnectResult.FAIL_BY_BLUETOOTH_CONNECT;
        return super.g(i10, c12).thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new C0886v0(this, 2));
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final CompletableFuture<Integer> h(int i10) {
        return super.h(i10).thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new C0884u0(this, i10, 1));
    }
}
