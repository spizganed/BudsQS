package com.oplus.melody.ui.component.tutorialguide.spatialaudio;

import A9.o;
import Aa.a;
import Aa.b;
import Aa.c;
import F8.d;
import android.content.Intent;
import android.os.Bundle;
import com.oplus.melody.common.util.A;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: TutorialGuideSpatialAudioActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011R\u0018\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/oplus/melody/ui/component/tutorialguide/spatialaudio/TutorialGuideSpatialAudioActivity;", "Lcom/oplus/melody/ui/base/BaseLoadingActivity;", "<init>", "()V", "mSpatialAudioConfigFuture", "Ljava/util/concurrent/CompletableFuture;", "Ljava/io/File;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onRetryClick", "fetchResource", "intent", "Landroid/content/Intent;", "openFragment", "spatialAudioConfig", "Lcom/oplus/melody/ui/component/detail/spatialaudio/SpatialAudioZipConfig;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TutorialGuideSpatialAudioActivity extends d {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final /* synthetic */ int f21710b0 = 0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public CompletableFuture<File> f21711a0;

    @Override // F8.d
    public final void J() {
        Intent intent = getIntent();
        h.d(intent, "getIntent(...)");
        L(intent);
    }

    public final void L(Intent intent) {
        CompletableFuture<U> completableFutureThenApplyAsync;
        CompletableFuture<File> completableFuture = this.f21711a0;
        if (completableFuture == null || completableFuture.isDone()) {
            String stringExtra = intent.getStringExtra("product_id");
            String stringExtra2 = intent.getStringExtra("product_color");
            int i10 = stringExtra2 != null ? Integer.parseInt(stringExtra2) : 0;
            A.c("TutorialGuideSpatialAudioActivity", new a(stringExtra, i10, 0));
            CompletableFuture<File> completableFutureD = Z7.a.g().d(i10, 3, stringExtra);
            this.f21711a0 = completableFutureD;
            if (completableFutureD == null || (completableFutureThenApplyAsync = completableFutureD.thenApplyAsync((Function<? super File, ? extends U>) new o(new b(this, 0), 1))) == 0) {
                return;
            }
            completableFutureThenApplyAsync.exceptionally((Function<Throwable, ? extends U>) new c(this, 0));
        }
    }

    @Override // F8.d, F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        h.d(intent, "getIntent(...)");
        L(intent);
    }
}
