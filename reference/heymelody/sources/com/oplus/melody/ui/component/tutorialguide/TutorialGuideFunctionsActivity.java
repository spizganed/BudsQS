package com.oplus.melody.ui.component.tutorialguide;

import A6.b;
import A9.p;
import A9.q;
import D7.o0;
import F8.d;
import a9.C0531H;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.zenmode.e;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import qa.c;

/* JADX INFO: compiled from: TutorialGuideFunctionsActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0014J\b\u0010\u0017\u001a\u00020\fH\u0002J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aR\u0018\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/oplus/melody/ui/component/tutorialguide/TutorialGuideFunctionsActivity;", "Lcom/oplus/melody/ui/base/BaseLoadingActivity;", "<init>", "()V", "mFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/ui/component/tutorialguide/TutorialGuideZipConfig;", "mViewModel", "Lcom/oplus/melody/ui/component/tutorialguide/TutorialGuideFunctionsViewModel;", "mCurLocale", "Ljava/util/Locale;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onRetryClick", "openFragment", "fetchResource", "intent", "Landroid/content/Intent;", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class TutorialGuideFunctionsActivity extends d {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final /* synthetic */ int f21665d0 = 0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public CompletableFuture<c> f21666a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public TutorialGuideFunctionsViewModel f21667b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public Locale f21668c0;

    @Override // F8.d
    public final void J() {
        Intent intent = getIntent();
        h.d(intent, "getIntent(...)");
        L(intent);
    }

    public final void L(Intent intent) {
        CompletableFuture<c> completableFuture = this.f21666a0;
        if (completableFuture == null || completableFuture.isDone()) {
            String stringExtra = intent.getStringExtra("product_id");
            String stringExtra2 = intent.getStringExtra("product_color");
            int i10 = stringExtra2 != null ? Integer.parseInt(stringExtra2) : 0;
            A.c(this.f1646Q, new Aa.a(stringExtra, i10, 17));
            WeakReference weakReference = new WeakReference(this);
            this.f21666a0 = Z7.a.g().d(i10, 10, stringExtra).thenApplyAsync((Function) new e(new C0531H(weakReference, 17), 16)).whenCompleteAsync((BiConsumer) new q(new p(weakReference, 12), 23), (Executor) o0.c.f1144b);
        }
    }

    @Override // F8.a, androidx.appcompat.app.i, c.i, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        h.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (h.a(this.f21668c0, newConfig.locale)) {
            return;
        }
        this.f21668c0 = newConfig.locale;
        recreate();
    }

    @Override // F8.d, F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f21668c0 = getResources().getConfiguration().locale;
        O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        X.d dVarC = b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(TutorialGuideFunctionsViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f21667b0 = (TutorialGuideFunctionsViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        Intent intent = getIntent();
        h.d(intent, "getIntent(...)");
        L(intent);
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
