package com.oplus.melody.ui.component.detail.headmotion;

import A6.b;
import D7.G;
import D7.o0;
import F8.d;
import android.os.Bundle;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import c9.g;
import com.oplus.melody.common.util.A;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import r9.C1480d;
import r9.C1483g;

/* JADX INFO: compiled from: HeadMotionTryActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\nH\u0014J\b\u0010\u000e\u001a\u00020\nH\u0014J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002R\u0018\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/oplus/melody/ui/component/detail/headmotion/HeadMotionTryActivity;", "Lcom/oplus/melody/ui/base/BaseLoadingActivity;", "<init>", "()V", "mFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/ui/component/detail/headmotion/HeadMotionTryZipConfig;", "mViewModel", "Lcom/oplus/melody/ui/component/detail/headmotion/HeadMotionTryViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onRetryClick", "onDestroy", "fetchResource", "openFragment", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HeadMotionTryActivity extends d {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final /* synthetic */ int f21052c0 = 0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public CompletableFuture<C1483g> f21053a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public HeadMotionTryViewModel f21054b0;

    @Override // F8.d
    public final void J() {
        L();
    }

    public final void L() {
        CompletableFuture<C1483g> completableFuture = this.f21053a0;
        if (completableFuture == null || completableFuture.isDone()) {
            A.b("HeadMotionTryActivity", "fetchResource");
            this.f21053a0 = Z7.a.g().d(0, 15, "000000").thenApplyAsync((Function) new C1480d(new G(17), 0)).whenCompleteAsync((BiConsumer) new g(new F8.g(this, 15), 10), (Executor) o0.c.f1144b);
        }
    }

    @Override // F8.d, F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        X.d dVarC = b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(HeadMotionTryViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f21054b0 = (HeadMotionTryViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        L();
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onDestroy() {
        CompletableFuture<C1483g> completableFuture = this.f21053a0;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        this.f21053a0 = null;
        super.onDestroy();
    }
}
