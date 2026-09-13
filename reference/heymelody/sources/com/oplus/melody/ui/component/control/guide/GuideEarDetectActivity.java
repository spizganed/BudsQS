package com.oplus.melody.ui.component.control.guide;

import A6.g;
import A6.i;
import A9.j;
import A9.o;
import D7.RunnableC0380n;
import D7.o0;
import Ea.C0403l;
import I8.q;
import I8.r;
import I8.t;
import X.d;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.p;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import com.oplus.melody.ui.widget.MelodyErrorLayout;
import ec.k;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: GuideEarDetectActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\u0006\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u000fJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/oplus/melody/ui/component/control/guide/GuideEarDetectActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "TAG", "", "mViewModel", "Lcom/oplus/melody/ui/component/control/guide/EarDetectViewModel;", "mAddress", "mProductId", "mColorId", "mFrom", "mErrorLayout", "Lcom/oplus/melody/ui/widget/MelodyErrorLayout;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "requestControlSource", "getErrorLayout", "mShowLoadingRunnable", "Ljava/lang/Runnable;", "showDetectFragment", "showWearFragment", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "finish", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GuideEarDetectActivity extends F8.a {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final /* synthetic */ int f20506c0 = 0;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public EarDetectViewModel f20508V;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public MelodyErrorLayout f20513a0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final String f20507U = "GuideEarDetectActivity";

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public String f20509W = "";

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public String f20510X = "";

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public String f20511Y = "";

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public String f20512Z = "";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final RunnableC0380n f20514b0 = new RunnableC0380n(this, 8);

    public final MelodyErrorLayout I() {
        MelodyErrorLayout melodyErrorLayout = this.f20513a0;
        if (melodyErrorLayout != null) {
            return melodyErrorLayout;
        }
        View viewInflate = ((ViewStub) findViewById(R.id.melody_ui_error_view_stub)).inflate();
        h.c(viewInflate, "null cannot be cast to non-null type com.oplus.melody.ui.widget.MelodyErrorLayout");
        MelodyErrorLayout melodyErrorLayout2 = (MelodyErrorLayout) viewInflate;
        melodyErrorLayout2.setVisibility(0);
        this.f20513a0 = melodyErrorLayout2;
        return melodyErrorLayout2;
    }

    public final void J() {
        A.c(this.f20507U, new t(this, 0));
        Integer numB = k.B(this.f20511Y);
        int iIntValue = numB != null ? numB.intValue() : -1;
        EarDetectViewModel earDetectViewModel = this.f20508V;
        if (earDetectViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        String productId = this.f20510X;
        h.e(productId, "productId");
        A.c("EarDetectViewModel", new Aa.a(productId, iIntValue, 2));
        CompletableFuture completableFutureExceptionally = Z7.a.g().d(iIntValue, 4, productId).thenCompose((Function) new o(new q(productId, iIntValue), 5)).thenApplyAsync((Function) new C0403l(new r(iIntValue, 0, earDetectViewModel, productId), 2)).exceptionally((Function) new i(5));
        h.d(completableFutureExceptionally, "exceptionally(...)");
        completableFutureExceptionally.thenAcceptAsync((Consumer) new E9.q(new j(this, 3), 1), (Executor) o0.c.f1144b);
    }

    public final void K() {
        Fragment fragmentD = u().D("GuideEarDetectFragment");
        if (fragmentD == null) {
            androidx.fragment.app.j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(GuideEarDetectFragment.class.getName());
        }
        fragmentD.setArguments(getIntent().getExtras());
        p pVarU = u();
        pVarU.getClass();
        C0585a c0585aC = g.c(pVarU, R.id.melody_ui_fragment_container, fragmentD, "GuideEarDetectFragment");
        c0585aC.f8831f = 4099;
        c0585aC.h(true, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void finish() {
        /*
            r6 = this;
            super.finish()
            java.lang.String r0 = r6.f20510X
            java.lang.String r1 = r6.f20509W
            java.lang.String r2 = r6.f20512Z
            if (r2 == 0) goto L44
            int r3 = r2.hashCode()
            r4 = -1335224239(0xffffffffb06a1851, float:-8.516326E-10)
            r5 = -1
            if (r3 == r4) goto L34
            r4 = 273184745(0x104877e9, float:3.953542E-29)
            if (r3 == r4) goto L2b
            r4 = 951543133(0x38b7655d, float:8.7450004E-5)
            if (r3 == r4) goto L20
            goto L3e
        L20:
            java.lang.String r3 = "control"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L29
            goto L3e
        L29:
            r2 = 1
            goto L3f
        L2b:
            java.lang.String r3 = "discover"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L3c
            goto L3e
        L34:
            java.lang.String r3 = "detail"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L3e
        L3c:
            r2 = 0
            goto L3f
        L3e:
            r2 = r5
        L3f:
            if (r2 == r5) goto L44
            kc.C1264t.p(r0, r1, r2, r5)
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.control.guide.GuideEarDetectActivity.finish():void");
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        String stringExtra;
        String stringExtra2;
        String stringExtra3;
        String stringExtra4;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.melody_ui_activity_standard_with_view_stub);
        y((MelodyCompatToolbar) findViewById(R.id.toolbar));
        androidx.appcompat.app.a aVarX = x();
        if (aVarX != null) {
            aVarX.o();
        }
        androidx.appcompat.app.a aVarX2 = x();
        if (aVarX2 != null) {
            aVarX2.n(true);
        }
        androidx.appcompat.app.a aVarX3 = x();
        if (aVarX3 != null) {
            aVarX3.t(R.string.melody_common_control_guide_title);
        }
        D(R.id.activity_standard_with_view_stub_layout, true);
        Intent intent = getIntent();
        String str = "";
        if (intent == null || (stringExtra = intent.getStringExtra("device_mac_info")) == null) {
            stringExtra = "";
        }
        this.f20509W = stringExtra;
        Intent intent2 = getIntent();
        if (intent2 == null || (stringExtra2 = intent2.getStringExtra("product_id")) == null) {
            stringExtra2 = "";
        }
        this.f20510X = stringExtra2;
        Intent intent3 = getIntent();
        if (intent3 == null || (stringExtra3 = intent3.getStringExtra("product_color")) == null) {
            stringExtra3 = "";
        }
        this.f20511Y = stringExtra3;
        Intent intent4 = getIntent();
        if (intent4 != null && (stringExtra4 = intent4.getStringExtra("route_from")) != null) {
            str = stringExtra4;
        }
        this.f20512Z = str;
        O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(EarDetectViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20508V = (EarDetectViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        o0.c.f1143a.postDelayed(this.f20514b0, 500L);
        J();
        t8.q.w(this.f20509W, true);
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
}
