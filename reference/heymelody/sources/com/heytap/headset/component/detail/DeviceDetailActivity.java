package com.heytap.headset.component.detail;

import D7.o0;
import E9.k;
import F8.i;
import G8.z;
import R3.c;
import Wb.l;
import X.d;
import a9.RunnableC0537c;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import b8.C0731a;
import c.s;
import com.coui.appcompat.material.navigation.NavigationBarView;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.db.C0928l;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyCompatNavigationView;
import i8.AbstractC1148a;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import m4.f;
import s8.AbstractC1508a;
import t8.t;
import x3.C1656o;

/* JADX INFO: compiled from: DeviceDetailActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0014J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0017H\u0014J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\tH\u0002J\u0017\u0010%\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\u0015H\u0002J\b\u0010*\u001a\u00020\u0015H\u0002J\b\u0010+\u001a\u00020\u0015H\u0002J\"\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u00101\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u0011H\u0002J\u0010\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/heytap/headset/component/detail/DeviceDetailActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "Lcom/coui/appcompat/material/navigation/NavigationBarView$OnItemSelectedListener;", "Lcom/coui/appcompat/material/navigation/NavigationBarView$OnItemReselectedListener;", "<init>", "()V", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "connectionState", "", "supportEarControl", "", "navigationView", "Lcom/oplus/melody/ui/widget/MelodyCompatNavigationView;", "hasCheckNavigationView", "selectedNavItemId", "deviceDetailFragment", "Landroidx/fragment/app/Fragment;", "earControlFragment", "aboutFragment", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onStart", "onResume", "onSaveInstanceState", "outState", "onNavigationItemReselected", "menuItem", "Landroid/view/MenuItem;", "onNavigationItemSelected", "onConnectionStateChange", "state", "updateFeedbackUnreadRedDot", "num", "(Ljava/lang/Integer;)V", "updateDeviceInfo", "navigateToAboutFragment", "navigateToEarControlFragment", "navigateToDeviceDetailFragment", "openFragment", "fragment", "fragmentTag", "", "bundle", "rebindVisibleFragmentToolbar", "navigateTargetFragment", "targetId", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DeviceDetailActivity extends F8.a implements NavigationBarView.c, NavigationBarView.b {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final /* synthetic */ int f17380c0 = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public DetailMainViewModel f17381U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public boolean f17382V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public MelodyCompatNavigationView f17383W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public boolean f17384X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public int f17385Y = R.id.device_infos;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public Fragment f17386Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public Fragment f17387a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public Fragment f17388b0;

    /* JADX INFO: compiled from: DeviceDetailActivity.kt */
    public static final class a extends s {
        public a() {
            super(true);
        }

        @Override // c.s
        public final void b() {
            DeviceDetailActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: DeviceDetailActivity.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctionReferenceImpl f17390a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(l lVar) {
            this.f17390a = (FunctionReferenceImpl) lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f17390a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [Wb.l, kotlin.jvm.internal.FunctionReferenceImpl] */
        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f17390a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.heytap.headset.component.detail.DeviceDetailActivity$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: DeviceDetailActivity.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            num.intValue();
            DeviceDetailActivity deviceDetailActivity = (DeviceDetailActivity) this.receiver;
            int i10 = DeviceDetailActivity.f17380c0;
            deviceDetailActivity.getClass();
            return Jb.l.f2618a;
        }
    }

    public final void I(int i10) {
        Bundle arguments;
        String strA;
        String name;
        Bundle bundle;
        Bundle arguments2;
        if (i10 == R.id.device_infos) {
            J();
            return;
        }
        if (i10 == R.id.more) {
            Bundle bundle2 = new Bundle();
            DetailMainViewModel detailMainViewModel = this.f17381U;
            if (detailMainViewModel == null) {
                h.i("viewModel");
                throw null;
            }
            bundle2.putString("device_mac_info", detailMainViewModel.f20397b);
            DetailMainViewModel detailMainViewModel2 = this.f17381U;
            if (detailMainViewModel2 == null) {
                h.i("viewModel");
                throw null;
            }
            bundle2.putString("device_name", detailMainViewModel2.f20398c);
            DetailMainViewModel detailMainViewModel3 = this.f17381U;
            if (detailMainViewModel3 == null) {
                h.i("viewModel");
                throw null;
            }
            bundle2.putString("product_id", detailMainViewModel3.f20400e);
            DetailMainViewModel detailMainViewModel4 = this.f17381U;
            if (detailMainViewModel4 == null) {
                h.i("viewModel");
                throw null;
            }
            String strA2 = C1656o.a("AboutFragmentWithToolbar", detailMainViewModel4.f20397b);
            Fragment fragmentD = u().D(strA2);
            if (fragmentD == null) {
                Fragment fragment = this.f17388b0;
                String string = (fragment == null || (arguments = fragment.getArguments()) == null) ? null : arguments.getString("device_mac_info");
                DetailMainViewModel detailMainViewModel5 = this.f17381U;
                if (detailMainViewModel5 == null) {
                    h.i("viewModel");
                    throw null;
                }
                if (h.a(string, detailMainViewModel5.f20397b)) {
                    fragmentD = this.f17388b0;
                }
                if (fragmentD == null) {
                    j jVarI = u().I();
                    getClassLoader();
                    fragmentD = jVarI.a(P3.f.class.getName());
                    this.f17388b0 = fragmentD;
                }
            }
            if (fragmentD == null) {
                throw MelodyException.e(0, "unable to create AboutFragmentWithToolbar");
            }
            K(bundle2, fragmentD, strA2);
            return;
        }
        if (i10 != R.id.support_device_list) {
            return;
        }
        if (this.f17382V) {
            bundle = new Bundle();
            DetailMainViewModel detailMainViewModel6 = this.f17381U;
            if (detailMainViewModel6 == null) {
                h.i("viewModel");
                throw null;
            }
            bundle.putString("device_mac_info", detailMainViewModel6.f20397b);
            DetailMainViewModel detailMainViewModel7 = this.f17381U;
            if (detailMainViewModel7 == null) {
                h.i("viewModel");
                throw null;
            }
            bundle.putString("device_name", detailMainViewModel7.f20398c);
            DetailMainViewModel detailMainViewModel8 = this.f17381U;
            if (detailMainViewModel8 == null) {
                h.i("viewModel");
                throw null;
            }
            bundle.putString("product_id", detailMainViewModel8.f20400e);
            DetailMainViewModel detailMainViewModel9 = this.f17381U;
            if (detailMainViewModel9 == null) {
                h.i("viewModel");
                throw null;
            }
            bundle.putString("product_color", String.valueOf(detailMainViewModel9.f20401f));
            AbstractC1508a abstractC1508aF = AbstractC1508a.f();
            DetailMainViewModel detailMainViewModel10 = this.f17381U;
            if (detailMainViewModel10 == null) {
                h.i("viewModel");
                throw null;
            }
            WhitelistConfigDTO whitelistConfigDTOC = abstractC1508aF.c(detailMainViewModel10.f20400e, detailMainViewModel10.f20398c);
            if (whitelistConfigDTOC == null || !"N".equals(whitelistConfigDTOC.getType())) {
                DetailMainViewModel detailMainViewModel11 = this.f17381U;
                if (detailMainViewModel11 == null) {
                    h.i("viewModel");
                    throw null;
                }
                strA = C1656o.a("EarControlFragmentWithToolbar", detailMainViewModel11.f20397b);
                name = Q3.a.class.getName();
            } else {
                DetailMainViewModel detailMainViewModel12 = this.f17381U;
                if (detailMainViewModel12 == null) {
                    h.i("viewModel");
                    throw null;
                }
                strA = C1656o.a("NeckEarControlFragmentWithToolbar", detailMainViewModel12.f20397b);
                name = Q3.b.class.getName();
            }
            DetailMainViewModel detailMainViewModel13 = this.f17381U;
            if (detailMainViewModel13 == null) {
                h.i("viewModel");
                throw null;
            }
            String str = detailMainViewModel13.f20400e;
            String str2 = detailMainViewModel13.f20397b;
            C1264t.t(AppConstant$FunctionType.EARPHONE_CONTROL.getFunType(), str, str2, N.t(detailMainViewModel13.i(str2)), "");
        } else {
            DetailMainViewModel detailMainViewModel14 = this.f17381U;
            if (detailMainViewModel14 == null) {
                h.i("viewModel");
                throw null;
            }
            strA = C1656o.a("NotSupportEarControlFragment", detailMainViewModel14.f20397b);
            name = z.class.getName();
            bundle = null;
        }
        Fragment fragmentD2 = u().D(strA);
        if (fragmentD2 == null) {
            Fragment fragment2 = this.f17387a0;
            String string2 = (fragment2 == null || (arguments2 = fragment2.getArguments()) == null) ? null : arguments2.getString("device_mac_info");
            DetailMainViewModel detailMainViewModel15 = this.f17381U;
            if (detailMainViewModel15 == null) {
                h.i("viewModel");
                throw null;
            }
            if (h.a(string2, detailMainViewModel15.f20397b)) {
                fragmentD2 = this.f17387a0;
            }
            if (fragmentD2 == null) {
                j jVarI2 = u().I();
                getClassLoader();
                fragmentD2 = jVarI2.a(name);
                this.f17387a0 = fragmentD2;
            }
        }
        if (fragmentD2 == null) {
            throw MelodyException.e(0, "unable to create earControlFragment");
        }
        K(bundle, fragmentD2, strA);
    }

    public final void J() {
        Bundle arguments;
        DetailMainViewModel detailMainViewModel = this.f17381U;
        if (detailMainViewModel == null) {
            h.i("viewModel");
            throw null;
        }
        if (TextUtils.isEmpty(detailMainViewModel.f20397b)) {
            finish();
            return;
        }
        Bundle bundle = new Bundle();
        DetailMainViewModel detailMainViewModel2 = this.f17381U;
        if (detailMainViewModel2 == null) {
            h.i("viewModel");
            throw null;
        }
        bundle.putString("device_mac_info", detailMainViewModel2.f20397b);
        DetailMainViewModel detailMainViewModel3 = this.f17381U;
        if (detailMainViewModel3 == null) {
            h.i("viewModel");
            throw null;
        }
        bundle.putString("device_name", detailMainViewModel3.f20398c);
        DetailMainViewModel detailMainViewModel4 = this.f17381U;
        if (detailMainViewModel4 == null) {
            h.i("viewModel");
            throw null;
        }
        String strA = C1656o.a("DeviceDetailFragmentWithToolbar", detailMainViewModel4.f20397b);
        Fragment fragmentD = u().D(strA);
        if (fragmentD == null) {
            Fragment fragment = this.f17386Z;
            String string = (fragment == null || (arguments = fragment.getArguments()) == null) ? null : arguments.getString("device_mac_info");
            DetailMainViewModel detailMainViewModel5 = this.f17381U;
            if (detailMainViewModel5 == null) {
                h.i("viewModel");
                throw null;
            }
            if (h.a(string, detailMainViewModel5.f20397b)) {
                fragmentD = this.f17386Z;
            }
            if (fragmentD == null) {
                j jVarI = u().I();
                getClassLoader();
                fragmentD = jVarI.a(c.class.getName());
                this.f17386Z = fragmentD;
            }
        }
        if (fragmentD == null) {
            throw MelodyException.e(0, "unable to create DeviceDetailFragmentWithToolbar");
        }
        K(bundle, fragmentD, strA);
    }

    public final void K(Bundle bundle, Fragment fragment, String str) {
        fragment.setArguments(bundle);
        p pVarU = u();
        pVarU.getClass();
        C0585a c0585a = new C0585a(pVarU);
        List<Fragment> listF = u().f8696c.f();
        h.d(listF, "getFragments(...)");
        for (Fragment fragment2 : listF) {
            if (!h.a(str, fragment2.getTag()) && (fragment instanceof c) && (fragment2 instanceof c)) {
                c0585a.m(fragment2);
            } else if (fragment2.isAdded() && !fragment2.equals(fragment)) {
                c0585a.l(fragment2);
            }
        }
        if (fragment.isAdded()) {
            c0585a.o(fragment);
        } else {
            c0585a.c(R.id.heymelody_app_nav_host_fragment, fragment, str, 1);
        }
        k kVar = new k(3, this, fragment);
        if (c0585a.f8832g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        c0585a.h = false;
        if (c0585a.f8841q == null) {
            c0585a.f8841q = new ArrayList<>();
        }
        c0585a.f8841q.add(kVar);
        c0585a.h(true, true);
    }

    public final void L(Intent intent, DetailMainViewModel detailMainViewModel) {
        WhitelistConfigDTO.Function function;
        String stringExtra = intent.getStringExtra("device_mac_info");
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        if (stringExtra != null) {
            detailMainViewModel.e(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("device_name");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        detailMainViewModel.getClass();
        detailMainViewModel.f20398c = stringExtra2;
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(null, detailMainViewModel.f20398c);
        if (whitelistConfigDTOC == null || (function = whitelistConfigDTOC.getFunction()) == null) {
            return;
        }
        List<WhitelistConfigDTO.Control> control = function.getControl();
        if ((control == null || control.isEmpty()) && !Y.e(function.getControlGuideSupport(), false)) {
            return;
        }
        this.f17382V = true;
    }

    @Override // com.coui.appcompat.material.navigation.NavigationBarView.c
    public final boolean b(MenuItem menuItem) {
        h.e(menuItem, "menuItem");
        this.f17385Y = menuItem.getItemId();
        I(menuItem.getItemId());
        return true;
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeakHashMap<Activity, m4.f> weakHashMap = m4.f.f26302s;
        if (!f.a.b(this)) {
            A.h("DeviceDetailActivity", "onCreate has no must Permission, go startup page!");
            E8.a.w().getClass();
            Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
            i iVarA = i.a.a("/heymelody_app/start_up");
            iVarA.a(1);
            iVarA.b(this);
            finishAffinity();
            return;
        }
        setContentView(R.layout.heymelody_app_activity_detail_main);
        D(R.id.heymelody_app_detail_main, true);
        O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(DetailMainViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f17381U = (DetailMainViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        Intent intent = getIntent();
        h.d(intent, "getIntent(...)");
        DetailMainViewModel detailMainViewModel = this.f17381U;
        if (detailMainViewModel == null) {
            h.i("viewModel");
            throw null;
        }
        L(intent, detailMainViewModel);
        View viewFindViewById = findViewById(R.id.heymelody_app_navigation_label);
        MelodyCompatNavigationView melodyCompatNavigationView = (MelodyCompatNavigationView) viewFindViewById;
        melodyCompatNavigationView.setOnItemSelectedListener(this);
        melodyCompatNavigationView.setOnItemReselectedListener(this);
        melodyCompatNavigationView.setNeedTextAnim(true);
        h.d(viewFindViewById, "apply(...)");
        MelodyCompatNavigationView melodyCompatNavigationView2 = (MelodyCompatNavigationView) viewFindViewById;
        this.f17383W = melodyCompatNavigationView2;
        melodyCompatNavigationView2.setItemIconTintList(null);
        if (savedInstanceState != null) {
            this.f17385Y = savedInstanceState.getInt("key_selected_nav_item", R.id.device_infos);
            MelodyCompatNavigationView melodyCompatNavigationView3 = this.f17383W;
            if (melodyCompatNavigationView3 == null) {
                h.i("navigationView");
                throw null;
            }
            MenuItem menuItemFindItem = melodyCompatNavigationView3.getMenu().findItem(this.f17385Y);
            if (menuItemFindItem != null) {
                menuItemFindItem.setChecked(true);
            }
            this.f17384X = true;
            I(this.f17385Y);
        } else {
            this.f17384X = false;
            J();
        }
        DetailMainViewModel detailMainViewModel2 = this.f17381U;
        if (detailMainViewModel2 == null) {
            h.i("viewModel");
            throw null;
        }
        detailMainViewModel2.d(detailMainViewModel2.f20397b).e(this, new b(new AnonymousClass2(1, this, DeviceDetailActivity.class, "onConnectionStateChange", "onConnectionStateChange(I)V", 0)));
        if (this.f17381U == null) {
            h.i("viewModel");
            throw null;
        }
        C0731a c0731a = C0731a.f13070c;
        t.a();
        getOnBackPressedDispatcher().a(this, new a());
    }

    @Override // c.i, android.app.Activity
    public final void onNewIntent(Intent intent) {
        h.e(intent, "intent");
        super.onNewIntent(intent);
        DetailMainViewModel detailMainViewModel = this.f17381U;
        if (detailMainViewModel == null) {
            h.i("viewModel");
            throw null;
        }
        L(intent, detailMainViewModel);
        this.f17385Y = R.id.device_infos;
        J();
        MelodyCompatNavigationView melodyCompatNavigationView = this.f17383W;
        if (melodyCompatNavigationView == null) {
            h.i("navigationView");
            throw null;
        }
        MenuItem menuItemFindItem = melodyCompatNavigationView.getMenu().findItem(R.id.device_infos);
        if (menuItemFindItem != null) {
            menuItemFindItem.setChecked(true);
        }
        this.f17384X = true;
    }

    @Override // F8.a, androidx.fragment.app.f, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (!this.f17384X) {
            this.f17384X = true;
            MelodyCompatNavigationView melodyCompatNavigationView = this.f17383W;
            if (melodyCompatNavigationView == null) {
                h.i("navigationView");
                throw null;
            }
            MenuItem menuItemFindItem = melodyCompatNavigationView.getMenu().findItem(this.f17385Y);
            if (menuItemFindItem != null) {
                menuItemFindItem.setChecked(true);
            }
        }
        CompletableFuture.runAsync(new RunnableC0537c(this, 21), o0.c.f1145c).exceptionally((Function<Throwable, ? extends Void>) new C0928l(25));
    }

    @Override // c.i, B.ActivityC0360h, android.app.Activity
    public final void onSaveInstanceState(Bundle outState) {
        h.e(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt("key_selected_nav_item", this.f17385Y);
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onStart() {
        super.onStart();
        int i10 = AbstractC1148a.f24096c;
        AbstractC1148a abstractC1148aA = AbstractC1148a.C0266a.a();
        if (abstractC1148aA != null) {
            DetailMainViewModel detailMainViewModel = this.f17381U;
            if (detailMainViewModel == null) {
                h.i("viewModel");
                throw null;
            }
            if (abstractC1148aA.d(detailMainViewModel.f20397b)) {
                DetailMainViewModel detailMainViewModel2 = this.f17381U;
                if (detailMainViewModel2 == null) {
                    h.i("viewModel");
                    throw null;
                }
                A.f("DeviceDetailActivity", "onStart, addr = " + detailMainViewModel2.f20397b + ", isLeAudioOpen: true");
                o0.d(new E9.t(this, 18));
            }
        }
    }

    @Override // com.coui.appcompat.material.navigation.NavigationBarView.b
    public final void i(MenuItem menuItem) {
    }
}
