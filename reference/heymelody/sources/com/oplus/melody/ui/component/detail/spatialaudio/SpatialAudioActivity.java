package com.oplus.melody.ui.component.detail.spatialaudio;

import D7.C0388w;
import D7.o0;
import D7.q0;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public class SpatialAudioActivity extends F8.a {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final /* synthetic */ int f21253U = 0;

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("product_id");
        String stringExtra2 = intent.getStringExtra("product_color");
        new q0(Z7.a.g().d(TextUtils.isEmpty(stringExtra2) ? 0 : Integer.parseInt(stringExtra2), 3, stringExtra), 100L, TimeUnit.MILLISECONDS).thenApplyAsync((Function) new C0388w(12)).whenCompleteAsync((BiConsumer<? super U, ? super Throwable>) new A9.c(this, 4), (Executor) o0.c.f1144b);
    }
}
