package com.heytap.headset.component.discovery;

import D7.RunnableC0380n;
import D7.o0;
import Ea.C0404m;
import F8.a;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: HeyDiscoveryJumpActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0014J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/heytap/headset/component/discovery/HeyDiscoveryJumpActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "hasPaused", "", "getHasPaused", "()Z", "setHasPaused", "(Z)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "onPause", "finish", "onDestroy", "jumpToDiscoveryDialog", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HeyDiscoveryJumpActivity extends a {

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final /* synthetic */ int f17391V = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public boolean f17392U;

    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.melody_ui_fade_out);
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            if (i10 >= 30) {
                attributes.layoutInDisplayCutoutMode = 3;
            } else {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            getWindow().setAttributes(attributes);
        }
        A.b("HeyDiscoveryJumpActivity", "onCreate");
        o0.c.f1143a.postDelayed(new RunnableC0380n(this, 25), i10 <= 25 ? 60L : 30L);
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        A.b("HeyDiscoveryJumpActivity", "onDestroy");
    }

    @Override // c.i, android.app.Activity
    public final void onNewIntent(Intent intent) {
        h.e(intent, "intent");
        super.onNewIntent(intent);
        A.b("HeyDiscoveryJumpActivity", "onNewIntent");
        this.f17392U = false;
        o0.c.f1143a.postDelayed(new RunnableC0380n(this, 25), Build.VERSION.SDK_INT <= 25 ? 60L : 30L);
    }

    @Override // F8.a, androidx.fragment.app.f, android.app.Activity
    public final void onPause() {
        super.onPause();
        this.f17392U = true;
    }

    @Override // F8.a, androidx.fragment.app.f, android.app.Activity
    public final void onResume() {
        super.onResume();
        A.c("HeyDiscoveryJumpActivity", new C0404m(this, 27));
        if (this.f17392U) {
            finish();
        } else {
            overridePendingTransition(R.anim.melody_ui_fade_in, 0);
        }
    }
}
