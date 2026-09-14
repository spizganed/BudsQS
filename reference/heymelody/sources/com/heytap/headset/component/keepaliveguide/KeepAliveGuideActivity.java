package com.heytap.headset.component.keepaliveguide;

import A6.p;
import B9.b;
import D7.o0;
import F8.d;
import a9.RunnableC0537c;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.db.C0928l;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: KeepAliveGuideActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\nH\u0014J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0012H\u0014J\b\u0010\u0015\u001a\u00020\nH\u0014J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/heytap/headset/component/keepaliveguide/KeepAliveGuideActivity;", "Lcom/oplus/melody/ui/base/BaseLoadingActivity;", "<init>", "()V", "mFuture", "Ljava/util/concurrent/CompletableFuture;", "", "viewModel", "Lcom/heytap/headset/component/keepaliveguide/KeepAliveGuideViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "getContentViewLayoutId", "", "setContainerViewMargin", "resId", "onRetryClick", "openFragment", "fragmentClassName", "", "fragmentTag", "fetchResource", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KeepAliveGuideActivity extends d {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final /* synthetic */ int f17393c0 = 0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public CompletableFuture<Boolean> f17394a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public KeepAliveGuideViewModel f17395b0;

    @Override // F8.d
    public final void J() {
        L();
    }

    public final void L() {
        A.c("KeepAliveGuideActivity", new B6.a(this, 26));
        CompletableFuture<Boolean> completableFuture = this.f17394a0;
        if (completableFuture == null || completableFuture.isDone()) {
            KeepAliveGuideViewModel keepAliveGuideViewModel = this.f17395b0;
            if (keepAliveGuideViewModel == null) {
                h.i("viewModel");
                throw null;
            }
            CompletableFuture completableFutureThenComposeAsync = Z7.a.g().d(0, 7, "000").thenComposeAsync((Function) new p(new D9.a(keepAliveGuideViewModel, 9), 9));
            h.d(completableFutureThenComposeAsync, "thenComposeAsync(...)");
            this.f17394a0 = completableFutureThenComposeAsync.whenCompleteAsync((BiConsumer) new b(new B9.a(this, 9), 16), (Executor) o0.c.f1144b);
        }
    }

    @Override // F8.d, F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        D(R.id.activity_standard_with_view_stub_layout, true);
        MelodyCompatToolbar melodyCompatToolbar = (MelodyCompatToolbar) findViewById(R.id.toolbar);
        if (melodyCompatToolbar != null) {
            y(melodyCompatToolbar);
            androidx.appcompat.app.a aVarX = x();
            if (aVarX != null) {
                aVarX.n(true);
                aVarX.r(true);
                aVarX.q(R.drawable.coui_back_arrow);
                aVarX.t(R.string.heymelody_app_lab_keep_alive_pref_title);
            }
        }
        O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(KeepAliveGuideViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f17395b0 = (KeepAliveGuideViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        L();
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }

    @Override // F8.a, androidx.fragment.app.f, android.app.Activity
    public final void onResume() {
        super.onResume();
        CompletableFuture.runAsync(new RunnableC0537c(this, 21), o0.c.f1145c).exceptionally((Function<Throwable, ? extends Void>) new C0928l(25));
    }

    @Override // F8.a
    public final int z() {
        return R.layout.melody_ui_activity_standard_with_view_stub;
    }

    @Override // F8.a
    public final void C() {
    }
}
