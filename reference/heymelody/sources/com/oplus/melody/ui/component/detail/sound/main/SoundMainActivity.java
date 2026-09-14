package com.oplus.melody.ui.component.detail.sound.main;

import A6.b;
import A9.o;
import A9.q;
import D7.o0;
import D7.q0;
import F8.d;
import M9.b;
import N9.j;
import N9.k;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MenuItem;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.media3.session.C0676t;
import androidx.media3.session.r;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.K;
import com.oplus.melody.model.repository.zenmode.ZenModeRepository;
import com.oplus.melody.model.repository.zenmode.e;
import com.oplus.melody.model.repository.zenmode.f;
import com.oplus.melody.model.repository.zenmode.g;
import com.oplus.melody.model.repository.zenmode.t;
import java.lang.ref.WeakReference;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: SoundMainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0014J\b\u0010\u0012\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0014R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/oplus/melody/ui/component/detail/sound/main/SoundMainActivity;", "Lcom/oplus/melody/ui/base/BaseLoadingActivity;", "<init>", "()V", "mFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/zenmode/ZenZipConfigDO;", "mViewModel", "Lcom/oplus/melody/ui/component/detail/sound/main/SoundMainViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onRetryClick", "fetchResource", "openFragment", "args", "onDestroy", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SoundMainActivity extends d {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final /* synthetic */ int f21218b0 = 0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public CompletableFuture<t> f21219a0;

    @Override // F8.d
    public final void J() {
        L();
    }

    public final void L() {
        CompletableFuture completableFutureWhenComplete;
        CompletableFuture<t> completableFuture = this.f21219a0;
        if (completableFuture == null || completableFuture.isDone()) {
            String strH = C0914u.h(getIntent(), "device_mac_info");
            String strH2 = C0914u.h(getIntent(), "product_id");
            String strH3 = C0914u.h(getIntent(), "product_color");
            WeakReference weakReference = new WeakReference(this);
            ZenModeRepository zenModeRepositoryJ = ZenModeRepository.j();
            int iB = K.b(-1, strH3);
            zenModeRepositoryJ.getClass();
            String str = this.f1646Q;
            if (iB == -1) {
                completableFutureWhenComplete = q0.b(MelodyException.e(0, "getSoundZipConfig unknown color"));
            } else {
                completableFutureWhenComplete = zenModeRepositoryJ.m(iB, strH2).thenCompose((Function) new e(zenModeRepositoryJ, 0)).thenApply((Function) new f(0)).whenComplete((BiConsumer) new g(0, SystemClock.elapsedRealtime(), str, strH));
            }
            this.f21219a0 = completableFutureWhenComplete.thenCompose((Function) new o(new j(str, 0), 8)).whenCompleteAsync((BiConsumer) new q(new k(weakReference, str, strH2, strH), 3), (Executor) o0.c.f1144b);
        }
    }

    @Override // F8.d, F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        X.d dVarC = b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(SoundMainViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        if (savedInstanceState != null) {
            K(1);
        }
        L();
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        CompletableFuture<t> completableFuture = this.f21219a0;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        this.f21219a0 = null;
        Object obj = M9.b.h;
        M9.b bVarA = b.a.a();
        C0676t c0676t = bVarA.f3342a;
        if (c0676t != null) {
            c0676t.cancel(true);
        }
        bVarA.f3342a = null;
        r rVar = bVarA.f3343b;
        if (rVar != null) {
            rVar.L();
        }
        bVarA.f3343b = null;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        getOnBackPressedDispatcher().c();
        return true;
    }
}
