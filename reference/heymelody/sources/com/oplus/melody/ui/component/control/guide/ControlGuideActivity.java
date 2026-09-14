package com.oplus.melody.ui.component.control.guide;

import D7.o0;
import F8.d;
import G8.o;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.K;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes3.dex */
public class ControlGuideActivity extends d {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final /* synthetic */ int f20464c0 = 0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public CompletableFuture<Void> f20465a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public C0.a f20466b0;

    @Override // F8.d
    public final void J() {
        L(getIntent());
    }

    public final void L(Intent intent) {
        CompletableFuture<Void> completableFuture = this.f20465a0;
        if (completableFuture == null || completableFuture.isDone()) {
            String stringExtra = intent.getStringExtra("product_id");
            int iB = K.b(-1, intent.getStringExtra("product_color"));
            this.f20465a0 = CompletableFuture.allOf(Z7.a.g().e(iB, stringExtra), Z7.a.g().d(iB, 4, stringExtra)).whenCompleteAsync((BiConsumer<? super Void, ? super Throwable>) new o(2, this, intent), (Executor) o0.c.f1144b);
        }
    }

    @Override // F8.d, F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.melody_ui_activity_standard_with_view_stub);
        D(R.id.activity_standard_with_view_stub_layout, true);
        y((MelodyCompatToolbar) findViewById(R.id.toolbar));
        androidx.appcompat.app.a aVarX = x();
        if (aVarX != null) {
            aVarX.r(true);
            aVarX.n(true);
            aVarX.t(R.string.melody_common_control_guide_title);
        }
        L(getIntent());
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        C0.a aVar = this.f20466b0;
        if (aVar == null) {
            onBackPressed();
            return true;
        }
        A.b("ControlGuideFragment", "setCallBack");
        ControlGuideFragment controlGuideFragment = (ControlGuideFragment) aVar.f608b;
        controlGuideFragment.v();
        controlGuideFragment.f20473G = true;
        return true;
    }
}
