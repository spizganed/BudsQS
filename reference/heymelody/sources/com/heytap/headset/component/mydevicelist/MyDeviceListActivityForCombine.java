package com.heytap.headset.component.mydevicelist;

import A6.g;
import D7.RunnableC0380n;
import D7.o0;
import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import com.heytap.headset.R;
import com.oplus.melody.common.helper.MelodyException;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import m4.f;

/* JADX INFO: compiled from: MyDeviceListActivityForCombine.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0014J\"\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/heytap/headset/component/mydevicelist/MyDeviceListActivityForCombine;", "Lcom/oplus/melody/ui/base/BaseLoadingActivity;", "<init>", "()V", "deviceListViewModel", "Lcom/heytap/headset/component/mydevicelist/MyDeviceCardListViewModel;", "loadedDeviceCount", "", "loadDataTimeoutRunnable", "Ljava/lang/Runnable;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "onRetryClick", "openFragment", "fragmentClassName", "", "fragmentTag", "bundle", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MyDeviceListActivityForCombine extends F8.d {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final /* synthetic */ int f17419d0 = 0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public MyDeviceCardListViewModel f17420a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f17421b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final RunnableC0380n f17422c0 = new RunnableC0380n(this, 27);

    /* JADX INFO: compiled from: MyDeviceListActivityForCombine.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ B9.d f17423a;

        public a(B9.d dVar) {
            this.f17423a = dVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f17423a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) throws Throwable {
            this.f17423a.d(obj);
        }
    }

    public final void L(String str, Bundle bundle) {
        Fragment fragmentD = u().D("MyDeviceListFragmentForCombine");
        if (fragmentD == null) {
            j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(str);
        }
        if (fragmentD == null) {
            throw MelodyException.e(0, "unable to create ".concat(str));
        }
        fragmentD.setArguments(bundle);
        p pVarU = u();
        pVarU.getClass();
        g.c(pVarU, R.id.melody_ui_fragment_container, fragmentD, "MyDeviceListFragmentForCombine").h(true, true);
    }

    @Override // c.i, android.app.Activity
    public final void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // F8.d, F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(MyDeviceCardListViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        MyDeviceCardListViewModel myDeviceCardListViewModel = (MyDeviceCardListViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f17420a0 = myDeviceCardListViewModel;
        WeakHashMap<Activity, m4.f> weakHashMap = m4.f.f26302s;
        myDeviceCardListViewModel.f17415c = f.a.a(this);
        if (!getIntent().getBooleanExtra("route_value", false)) {
            K(1);
            L(MyDeviceListFragmentForCombine.class.getName(), getIntent().getExtras());
            return;
        }
        o0.c.f1143a.postDelayed(this.f17422c0, 5000L);
        MyDeviceCardListViewModel myDeviceCardListViewModel2 = this.f17420a0;
        if (myDeviceCardListViewModel2 != null) {
            myDeviceCardListViewModel2.d(this).e(this, new a(new B9.d(this, 17)));
        }
    }

    @Override // F8.d
    public final void J() {
    }
}
