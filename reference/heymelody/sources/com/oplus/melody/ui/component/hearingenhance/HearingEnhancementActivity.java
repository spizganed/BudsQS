package com.oplus.melody.ui.component.hearingenhance;

import Ca.g;
import D7.C0368b;
import D7.C0373g;
import D7.H;
import D7.o0;
import D7.q0;
import Ea.C0395d;
import Ea.X;
import Ea.c0;
import F7.a;
import F8.d;
import G8.h;
import L8.D;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.Window;
import androidx.appcompat.app.f;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.media3.session.q1;
import com.airbnb.lottie.B;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.db.C0928l;
import com.oplus.melody.model.db.HearingEnhancementEntity;
import com.oplus.melody.model.db.k;
import com.oplus.melody.model.db.s;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.C0940c;
import com.oplus.melody.model.repository.earphone.C0941d;
import com.oplus.melody.model.repository.earphone.I;
import com.oplus.melody.model.repository.earphone.N;
import e.C0984e;
import ea.C1023b;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import k7.n;
import la.C1294g;
import la.C1304q;
import la.C1306t;
import la.C1307u;
import la.C1308v;
import la.C1310x;
import la.L;
import la.RunnableC1311y;
import la.d0;
import la.n0;
import la.u0;
import la.w0;
import la.y0;
import t8.q;
import t8.t;

/* JADX INFO: loaded from: classes3.dex */
public class HearingEnhancementActivity extends d {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final /* synthetic */ int f21566m0 = 0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f21567a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public Fragment f21568b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public f f21569c0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public HearingEnhancementViewModel f21571e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public F7.a f21572f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public c0 f21573g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public C1307u f21574h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public D f21575i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public c f21576j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public CompletableFuture<C1307u> f21577k0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f21570d0 = -1;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final C0984e f21578l0 = (C0984e) t(new f.d(), new q1(this, 16));

    public class a implements a.InterfaceC0020a {
        public a() {
        }

        @Override // F7.a.InterfaceC0020a
        public final void a() {
            A.c("HearingEnhancementActivity", new I(this, 18));
            o0.c.f1143a.postDelayed(new B(this, 20), 500L);
        }

        @Override // F7.a.InterfaceC0020a
        public final void b() {
            A.c("HearingEnhancementActivity", new s(this, 23));
            o0.c.f1143a.postDelayed(new n(this, 3), 500L);
        }
    }

    public class b extends c.s {
        public b() {
            super(true);
        }

        @Override // c.s
        public final void b() {
            A.c("HearingEnhancementActivity", new s(this, 24));
            int i10 = HearingEnhancementActivity.f21566m0;
            HearingEnhancementActivity hearingEnhancementActivity = HearingEnhancementActivity.this;
            if (!(hearingEnhancementActivity.f1660W >= 2)) {
                hearingEnhancementActivity.K(1);
                hearingEnhancementActivity.Y(hearingEnhancementActivity.f21568b0);
            } else if (hearingEnhancementActivity.f21567a0) {
                hearingEnhancementActivity.finish();
            } else {
                hearingEnhancementActivity.K(1);
                hearingEnhancementActivity.T(null, true);
            }
        }
    }

    public interface c {
        void f();
    }

    @Override // F8.d
    public final void J() {
        getIntent();
        N(this.f21576j0);
    }

    public final void L() {
        A.c("HearingEnhancementActivity", new C1308v(this, 1));
        Fragment fragment = this.f21568b0;
        if (!(fragment instanceof d0)) {
            if (!(fragment instanceof C1306t)) {
                return;
            }
            C1306t c1306t = (C1306t) fragment;
            c1306t.getClass();
            A.c("GoldHearingDetectFragmentV2", new C1304q(c1306t, 0));
            if (c1306t.f25946v instanceof y0) {
                return;
            }
        }
        if (this.f21567a0) {
            W(true);
        } else {
            T(null, true);
        }
    }

    public final void M() {
        if (this.f21567a0) {
            finish();
        } else {
            T(null, false);
        }
    }

    public final void N(c cVar) {
        CompletableFuture<C1307u> completableFuture = this.f21577k0;
        if (completableFuture == null || completableFuture.isDone()) {
            A.c("HearingEnhancementActivity", new I(this, 17));
            Z7.a aVarG = Z7.a.g();
            HearingEnhancementViewModel hearingEnhancementViewModel = this.f21571e0;
            this.f21577k0 = aVarG.d(hearingEnhancementViewModel.f21584e, 2, hearingEnhancementViewModel.f21583d).thenApplyAsync((Function) new C0941d(23)).whenCompleteAsync((BiConsumer) new C0395d(4, this, cVar), (Executor) o0.c.f1144b);
        }
    }

    public final String O() {
        return this.f21571e0.h() ? getString(R.string.melody_common_gold_hearing_title) : N.o(this.f21571e0.f21583d) ? getString(R.string.melody_ui_ops_hearing_enhancement_title) : getString(R.string.melody_ui_hearing_enhancement_title);
    }

    public final void P(Bundle bundle) {
        com.oplus.melody.model.repository.hearingenhance.a.o().l(this.f21571e0.f21582c).thenAcceptAsync((Consumer<? super List<HearingEnhancementEntity>>) new k(4, this, bundle), (Executor) o0.c.f1144b).exceptionally((Function<Throwable, ? extends Void>) new Aa.c(this, 20));
    }

    public final void Q() {
        if (this.f21568b0 != null) {
            p pVarU = u();
            pVarU.getClass();
            C0585a c0585a = new C0585a(pVarU);
            c0585a.m(this.f21568b0);
            c0585a.i();
            this.f21568b0 = null;
        }
    }

    public final void R() {
        if (this.f21569c0 == null) {
            int i10 = this.f21571e0.h() ? R.string.melody_common_gold_hearing_leave_will_cancel_test_tips : R.string.melody_ui_hearing_enhancement_leave_will_cancel_test_tips;
            G7.b bVar = new G7.b(this, R.style.COUIAlertDialog_Bottom);
            bVar.n(R.string.melody_common_is_confirm_leave_page);
            bVar.f(i10);
            bVar.j(R.string.melody_common_leave, new H8.f(this, 11));
            bVar.h(R.string.melody_common_gold_hearing_leave_cancel, null);
            this.f21569c0 = bVar.create();
        }
        if (this.f21569c0.isShowing()) {
            this.f21569c0.dismiss();
        } else {
            this.f21569c0.show();
        }
    }

    public final void S(int i10, HearingEnhancementEntity hearingEnhancementEntity, boolean z2) {
        if (hearingEnhancementEntity == null) {
            return;
        }
        getIntent().putExtra("detection_id", i10);
        getIntent().putExtra("detection_info", hearingEnhancementEntity);
        getIntent().putExtra("just_detecting", z2);
        if (this.f21574h0 == null) {
            K(2);
            Q();
            this.f21576j0 = new C1310x(this, 0);
            getIntent();
            N(this.f21576j0);
        } else {
            U(R.anim.coui_open_slide_enter, R.anim.coui_open_slide_exit, L.class.getName());
        }
        A.b("HearingEnhancementActivity", "switchToDetectCompleteFragment ok");
    }

    public final void T(List list, boolean z2) {
        if (list != null) {
            getIntent().putParcelableArrayListExtra("detection_list_data", C0901g.b(list));
        }
        if (z2) {
            V(u0.class.getName());
        } else {
            U(R.anim.coui_close_slide_enter, R.anim.coui_close_slide_exit, u0.class.getName());
        }
        A.b("HearingEnhancementActivity", "switchToDetectedListFragment ok");
    }

    public final void U(int i10, int i11, String str) {
        try {
            j jVarI = u().I();
            getClassLoader();
            Fragment fragmentA = jVarI.a(str);
            fragmentA.setArguments(getIntent().getExtras());
            Z(i10, i11, fragmentA);
        } catch (Exception e10) {
            A.i("HearingEnhancementActivity", "switchToFragment, error:", e10);
        }
    }

    public final void V(String str) {
        try {
            j jVarI = u().I();
            getClassLoader();
            Fragment fragmentA = jVarI.a(str);
            fragmentA.setArguments(getIntent().getExtras());
            Z(0, 0, fragmentA);
        } catch (Exception e10) {
            A.i("HearingEnhancementActivity", "switchToFragment, error:", e10);
        }
    }

    public final void W(boolean z2) {
        if (this.f21571e0.h()) {
            X(z2);
        } else {
            String name = w0.class.getName();
            if (z2) {
                V(name);
            } else {
                U(R.anim.coui_open_slide_enter, R.anim.coui_open_slide_exit, name);
            }
        }
        A.b("HearingEnhancementActivity", "switchToPrepareDetectFragment ok");
    }

    public final void X(boolean z2) {
        A.c("HearingEnhancementActivity", new X(this, z2, 8));
        String name = C1306t.class.getName();
        if (this.f21574h0 == null) {
            K(2);
            Q();
            this.f21576j0 = new Ha.c(9, this, name);
            getIntent();
            N(this.f21576j0);
        } else if (z2) {
            V(name);
        } else {
            U(R.anim.coui_open_slide_enter, R.anim.coui_open_slide_exit, name);
        }
        A.b("HearingEnhancementActivity", "switchToPrepareDetectFragmentV2 ok");
    }

    public final void Y(Fragment fragment) {
        A.c("HearingEnhancementActivity", new I(fragment, 16));
        if ((fragment instanceof d0) || (fragment instanceof n0) || (fragment instanceof EarScanFragmentV2)) {
            R();
            return;
        }
        if ((fragment instanceof w0) || (fragment instanceof y0)) {
            if (this.f21567a0) {
                finish();
                return;
            } else {
                T(null, false);
                return;
            }
        }
        if (fragment instanceof C1306t) {
            C1306t c1306t = (C1306t) fragment;
            c1306t.getClass();
            A.c("GoldHearingDetectFragmentV2", new com.oplus.melody.ui.component.detail.zenmode.scene.a(c1306t, 14));
            Y(c1306t.f25946v);
            return;
        }
        if (!(fragment instanceof u0)) {
            if (!(fragment instanceof L)) {
                finish();
                return;
            } else {
                ForkJoinPool.commonPool().execute(new RunnableC1311y((L) fragment, 0));
                T(null, false);
                return;
            }
        }
        u0 u0Var = (u0) fragment;
        if (!u0Var.v()) {
            finish();
        } else {
            u0Var.s(false);
            u0Var.C();
        }
    }

    public final void Z(int i10, int i11, Fragment fragment) throws Exception {
        p pVarU = u();
        pVarU.getClass();
        C0585a c0585a = new C0585a(pVarU);
        if (i10 != 0 || i11 != 0) {
            c0585a.f8827b = i10;
            c0585a.f8828c = i11;
            c0585a.f8829d = 0;
            c0585a.f8830e = 0;
        }
        c0585a.c(R.id.melody_ui_fragment_container, fragment, null, 1);
        Fragment fragment2 = this.f21568b0;
        if (fragment2 != null) {
            c0585a.m(fragment2);
        }
        c0585a.j();
        this.f21568b0 = fragment;
        a0(fragment);
    }

    public final void a0(Fragment fragment) throws Exception {
        D d10 = this.f21575i0;
        if (d10 != null) {
            d10.e();
        }
        if ((fragment instanceof d0) || (fragment instanceof n0) || (fragment instanceof EarScanFragmentV2)) {
            this.f21575i0 = new D(true, new C0368b(this, 23));
        } else if ((fragment instanceof w0) || (fragment instanceof y0)) {
            this.f21575i0 = new D(!this.f21567a0, new H(this, 26));
        } else if (fragment instanceof C1306t) {
            C1306t c1306t = (C1306t) fragment;
            c1306t.getClass();
            A.c("GoldHearingDetectFragmentV2", new com.oplus.melody.ui.component.detail.zenmode.scene.a(c1306t, 14));
            a0(c1306t.f25946v);
        } else if (fragment instanceof L) {
            this.f21575i0 = new D(true, new k(5, this, (L) fragment));
        } else {
            D d11 = this.f21575i0;
            if (d11 != null) {
                d11.f(false);
            }
        }
        if (this.f21575i0 != null) {
            getOnBackPressedDispatcher().a(this, this.f21575i0);
        }
    }

    @Override // F8.d, F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        int i10 = 0;
        int i11 = 1;
        super.onCreate(bundle);
        int color = getColor(R.color.melody_ui_hearing_enhancement_bg);
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setBackgroundColor(color);
        }
        O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(HearingEnhancementViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        HearingEnhancementViewModel hearingEnhancementViewModel = (HearingEnhancementViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f21571e0 = hearingEnhancementViewModel;
        hearingEnhancementViewModel.f21582c = C0914u.h(getIntent(), "device_mac_info");
        this.f21571e0.f21581b = C0914u.h(getIntent(), "device_name");
        this.f21571e0.f21583d = C0914u.h(getIntent(), "product_id");
        String strH = C0914u.h(getIntent(), "product_color");
        this.f21570d0 = R.string.melody_common_request_microphone_for_hearingenhance;
        try {
            this.f21571e0.f21584e = (TextUtils.isEmpty(strH) || !TextUtils.isDigitsOnly(strH)) ? -1 : Integer.parseInt(strH);
            Integer.parseInt(C0914u.h(getIntent(), "route_value"));
        } catch (Exception e10) {
            A.i("HearingEnhancementActivity", "onCreate VALUE", e10);
        }
        if (!BluetoothAdapter.checkBluetoothAddress(this.f21571e0.f21582c)) {
            finish();
            A.h("HearingEnhancementActivity", "onCreate, address is null, finish");
            return;
        }
        F7.a aVar = new F7.a();
        this.f21572f0 = aVar;
        aVar.f1641a = new a();
        C0905k.d(this, aVar, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), true);
        getOnBackPressedDispatcher().a(this, new b());
        this.f21567a0 = !C0914u.b(getIntent(), "route_value2", false);
        A.c("HearingEnhancementActivity", new C1308v(this, i10));
        if (this.f21567a0) {
            X(true);
        } else {
            K(1);
            this.f21571e0.getClass();
            HearingEnhancementEntity hearingEnhancementEntityD = com.oplus.melody.model.repository.hearingenhance.a.o().r().d();
            if (hearingEnhancementEntityD == null || !TextUtils.equals(hearingEnhancementEntityD.getAddress(), this.f21571e0.f21582c)) {
                A.b("HearingEnhancementActivity", "local have no usage enhance entity data, start load data");
                com.oplus.melody.model.repository.hearingenhance.a.o().s(this.f21571e0.f21582c).thenAcceptAsync((Consumer<? super HearingEnhancementEntity>) new com.oplus.melody.ui.component.detail.voiceassist.b(i11, this, bundle), (Executor) o0.c.f1144b).exceptionally((Function<Throwable, ? extends Void>) new Ea.N(5, this, bundle));
                if (this.f21571e0.h()) {
                    A.b("HearingEnhancementActivity", "start to getUsageEarScanFuture-- ");
                    com.oplus.melody.model.repository.hearingenhance.a.o().q(this.f21571e0.f21582c);
                }
            } else {
                A.b("HearingEnhancementActivity", "already have usage enhance entity");
                HearingEnhancementViewModel hearingEnhancementViewModel2 = this.f21571e0;
                String str = hearingEnhancementViewModel2.f21582c;
                com.oplus.melody.model.repository.hearingenhance.a.o().k(str);
                if (hearingEnhancementViewModel2.h()) {
                    com.oplus.melody.model.repository.hearingenhance.a.o().c(str);
                }
                P(bundle);
            }
            AbstractC0939b.E().y(this.f21571e0.f21582c);
            this.f21571e0.getClass();
            AbstractC0939b.E().q().e(this, new C1023b(this, 7));
            if (C.a.a(this, "android.permission.RECORD_AUDIO") != 0) {
                List<String> list = S.f19463a;
                if ("com.heytap.headset".equals(getPackageName())) {
                    E8.a.w().getClass();
                    E8.a.v();
                }
                if (!isFinishing() && !isDestroyed() && !shouldShowRequestPermissionRationale("android.permission.RECORD_AUDIO") && !q.c("melody-model-settings").getBoolean("is_record_audio_permission_requested", false)) {
                    q.c("melody-model-settings").edit().putBoolean("is_record_audio_permission_requested", true).apply();
                    if (t.d()) {
                        c0 c0Var = new c0(this);
                        this.f21573g0 = c0Var;
                        c0Var.f(getString(this.f21570d0, S.e(this)));
                    }
                    this.f21578l0.a("android.permission.RECORD_AUDIO");
                }
            } else {
                List<String> list2 = S.f19463a;
                if ("com.heytap.headset".equals(getPackageName())) {
                    E8.a.w().getClass();
                    E8.a.v();
                }
            }
        }
        Z7.a aVarG = Z7.a.g();
        HearingEnhancementViewModel hearingEnhancementViewModel3 = this.f21571e0;
        new q0(aVarG.d(hearingEnhancementViewModel3.f21584e, 2, hearingEnhancementViewModel3.f21583d), 100L, TimeUnit.MILLISECONDS).thenApplyAsync((Function) new C0928l(29)).whenComplete((BiConsumer<? super U, ? super Throwable>) new A9.c(this, 18));
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onDestroy() {
        A.b("HearingEnhancementActivity", "onDestroy ");
        super.onDestroy();
        this.f21571e0.getClass();
        com.oplus.melody.model.repository.hearingenhance.a.o().y();
        F7.a aVar = this.f21572f0;
        if (aVar != null) {
            aVar.f1641a = null;
            C0905k.o(this, aVar);
        }
        if (BluetoothAdapter.checkBluetoothAddress(this.f21571e0.f21582c)) {
            com.oplus.melody.model.repository.hearingenhance.a.o().l(this.f21571e0.f21582c).thenAccept((Consumer<? super List<HearingEnhancementEntity>>) new h(this, 15)).exceptionally((Function<Throwable, ? extends Void>) new C0940c(23));
        }
        String str = this.f21571e0.f21582c;
        if (C0373g.f()) {
            ForkJoinPool.commonPool().execute(new g(str, 1));
        } else {
            A6.b.g("directDisconnectSpp.isSppOverLeSupport=false, addr: ", A.r(str), "m_spp_le.LeAudioConnectSppManager");
        }
    }

    @Override // c.i, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        A.c("HearingEnhancementActivity", new C1294g(this, 2));
        CompletableFuture<C1307u> completableFuture = this.f21577k0;
        if (completableFuture == null || !completableFuture.isDone()) {
            return;
        }
        Fragment fragment = this.f21568b0;
        if ((fragment instanceof d0) || (fragment instanceof n0) || (fragment instanceof EarScanFragmentV2)) {
            return;
        }
        Q();
        P(null);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        A.b("HearingEnhancementActivity", "onOptionsItemSelected, home");
        Y(this.f21568b0);
        return true;
    }

    @Override // c.i, B.ActivityC0360h, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f21568b0 != null) {
            u().U(bundle, this.f21568b0, "current_fragment");
        }
        A.c("HearingEnhancementActivity", new C1308v(this, 2));
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onStop() {
        super.onStop();
        A.b("HearingEnhancementActivity", "onStop");
        f fVar = this.f21569c0;
        if (fVar != null) {
            fVar.dismiss();
        }
    }
}
