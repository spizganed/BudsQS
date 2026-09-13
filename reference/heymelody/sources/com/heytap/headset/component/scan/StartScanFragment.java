package com.heytap.headset.component.scan;

import Aa.e;
import D7.C0373g;
import D7.C0379m;
import D7.C0384s;
import D7.o0;
import F8.c;
import F8.i;
import Wb.l;
import X.d;
import X3.C0494b;
import X3.D;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.i;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.heytap.headset.component.mydevicelist.MyDeviceCardListViewModel;
import com.heytap.headset.component.mydevicelist.MyDeviceListViewModel;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.Q;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import h4.C1088a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import m4.f;
import t8.q;
import t8.s;

/* JADX INFO: compiled from: StartScanFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u001aH\u0016J\b\u0010+\u001a\u00020\u001aH\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001eH\u0002J\u001c\u0010.\u001a\u00020\u001a2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0002J\u0012\u00100\u001a\u00020\u001a2\b\u00101\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u00102\u001a\u00020\u001aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/heytap/headset/component/scan/StartScanFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "mAddDeviceTv", "Landroidx/appcompat/widget/AppCompatTextView;", "mStartUseTv", "mAddImageButton", "Lcom/oplus/melody/ui/widget/MelodyCompatButton;", "mLocationServiceDialogFragment", "Lcom/heytap/headset/component/scan/LocationServiceDialogFragment;", "mIsButtonNotAddDevice", "", "mHistoryDevicesCount", "", "mHasRequestOpenBluetooth", "mRuntimePermissionAlert", "Lcom/heytap/headset/widget/RuntimePermissionAlert;", "deviceItemMap", "", "", "Lcom/heytap/headset/component/mydevicelist/MyDeviceItemVO;", "mPermissionResultListener", "Lcom/heytap/headset/widget/RuntimePermissionAlert$PermissionResultListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "setToolbar", "initView", "view", "onDeviceItemListChange", "itemMap", "onClick", "v", "onStartScan", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StartScanFragment extends c implements View.OnClickListener {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AppCompatTextView f17543p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AppCompatTextView f17544q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MelodyCompatButton f17545r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public C0494b f17546s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f17547t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f17548u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f17549v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public f f17550w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Map<String, V3.a> f17551x = kotlin.collections.a.b0();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a f17552y = new a();

    /* JADX INFO: compiled from: StartScanFragment.kt */
    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: compiled from: StartScanFragment.kt */
    public static final class b implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctionReferenceImpl f17554a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(l lVar) {
            this.f17554a = (FunctionReferenceImpl) lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f17554a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [Wb.l, kotlin.jvm.internal.FunctionReferenceImpl] */
        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f17554a.d(obj);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View v5) {
        Integer numValueOf = v5 != null ? Integer.valueOf(v5.getId()) : null;
        if (numValueOf == null || numValueOf.intValue() != R.id.bt_start_add || s.a(0)) {
            return;
        }
        r();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        Intent intent;
        super.onCreate(savedInstanceState);
        A.b("StartScanFragment", "onCreate");
        androidx.fragment.app.f activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && h.a(C0914u.h(intent, "route_value"), "true")) {
            String strH = C0914u.h(intent, "route_value2");
            this.f17548u = strH != null ? Integer.parseInt(strH) : 0;
            A.c("StartScanFragment", new S7.c(this, 4));
            boolean z2 = this.f17548u > 0;
            this.f17547t = z2;
            if (z2) {
                if (C0373g.f1086l) {
                    androidx.fragment.app.f fVarRequireActivity = requireActivity();
                    h.d(fVarRequireActivity, "requireActivity(...)");
                    O viewModelStore = fVarRequireActivity.getViewModelStore();
                    N.b defaultViewModelProviderFactory = fVarRequireActivity.getDefaultViewModelProviderFactory();
                    d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, fVarRequireActivity.getDefaultViewModelCreationExtras());
                    kotlin.jvm.internal.b bVarA = j.a(MyDeviceCardListViewModel.class);
                    String strA = bVarA.a();
                    if (strA == null) {
                        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                    }
                    MyDeviceCardListViewModel myDeviceCardListViewModel = (MyDeviceCardListViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
                    androidx.fragment.app.f fVarRequireActivity2 = requireActivity();
                    h.d(fVarRequireActivity2, "requireActivity(...)");
                    myDeviceCardListViewModel.d(fVarRequireActivity2).e(requireActivity(), new b(new StartScanFragment$onCreate$1$2(1, this, StartScanFragment.class, "onDeviceItemListChange", "onDeviceItemListChange(Ljava/util/Map;)V", 0)));
                } else {
                    androidx.fragment.app.f fVarRequireActivity3 = requireActivity();
                    h.d(fVarRequireActivity3, "requireActivity(...)");
                    O viewModelStore2 = fVarRequireActivity3.getViewModelStore();
                    N.b defaultViewModelProviderFactory2 = fVarRequireActivity3.getDefaultViewModelProviderFactory();
                    d dVarC2 = A6.b.c(defaultViewModelProviderFactory2, "factory", viewModelStore2, defaultViewModelProviderFactory2, fVarRequireActivity3.getDefaultViewModelCreationExtras());
                    kotlin.jvm.internal.b bVarA2 = j.a(MyDeviceListViewModel.class);
                    String strA2 = bVarA2.a();
                    if (strA2 == null) {
                        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                    }
                    MyDeviceListViewModel myDeviceListViewModel = (MyDeviceListViewModel) dVarC2.a(bVarA2, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA2));
                    androidx.fragment.app.f fVarRequireActivity4 = requireActivity();
                    h.d(fVarRequireActivity4, "requireActivity(...)");
                    myDeviceListViewModel.d(fVarRequireActivity4).e(requireActivity(), new b(new StartScanFragment$onCreate$1$3(1, this, StartScanFragment.class, "onDeviceItemListChange", "onDeviceItemListChange(Ljava/util/Map;)V", 0)));
                }
            }
        }
        androidx.fragment.app.f activity2 = getActivity();
        if (activity2 != null) {
            WeakHashMap<Activity, f> weakHashMap = f.f26302s;
            f fVarA = f.a.a(activity2);
            this.f17550w = fVarA;
            fVarA.f26312c = this.f17552y;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        h.e(menu, "menu");
        h.e(inflater, "inflater");
        inflater.inflate(R.menu.heymelody_app_menu_go_about, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.heymelody_app_fragment_start_scan, container, false);
        setHasOptionsMenu(true);
        i iVar = (i) getActivity();
        h.b(iVar);
        androidx.appcompat.app.a aVarX = iVar.x();
        h.b(aVarX);
        aVarX.r(false);
        aVarX.p(false);
        h.b(viewInflate);
        View viewFindViewById = viewInflate.findViewById(R.id.tv_scan_remind);
        h.d(viewFindViewById, "findViewById(...)");
        this.f17543p = (AppCompatTextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.tv_scan_remind2);
        h.d(viewFindViewById2, "findViewById(...)");
        this.f17544q = (AppCompatTextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.bt_start_add);
        h.d(viewFindViewById3, "findViewById(...)");
        MelodyCompatButton melodyCompatButton = (MelodyCompatButton) viewFindViewById3;
        this.f17545r = melodyCompatButton;
        melodyCompatButton.setOnClickListener(this);
        if (this.f17547t) {
            AppCompatTextView appCompatTextView = this.f17543p;
            if (appCompatTextView == null) {
                h.i("mAddDeviceTv");
                throw null;
            }
            appCompatTextView.setVisibility(8);
            AppCompatTextView appCompatTextView2 = this.f17544q;
            if (appCompatTextView2 == null) {
                h.i("mStartUseTv");
                throw null;
            }
            appCompatTextView2.setVisibility(8);
            MelodyCompatButton melodyCompatButton2 = this.f17545r;
            if (melodyCompatButton2 == null) {
                h.i("mAddImageButton");
                throw null;
            }
            melodyCompatButton2.setText(R.string.heymelody_app_start_use);
        }
        if (q.j()) {
            J7.b.a().d();
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() == R.id.go_about) {
            E8.a.w().getClass();
            Jb.b<List<l<String, Class<?>>>> bVar = F8.i.f1668g;
            i.a.a("/ui/about").b(requireActivity());
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (Q.a()) {
            C1088a.f23692c.getClass();
            C1088a.f23693p.m(Boolean.TRUE);
        }
        if (C0373g.f1086l) {
            o0.c.f1143a.postDelayed(new e(this, 20), 200L);
        }
    }

    public final void r() {
        Map<String, V3.a> map;
        boolean z2 = false;
        if (Q.a() && !com.oplus.drs.core.d.d(BluetoothAdapter.getDefaultAdapter())) {
            this.f17549v = true;
            androidx.fragment.app.f activity = getActivity();
            if (activity != null) {
                C0905k.k(activity, new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
                return;
            }
            return;
        }
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        V3.a value = null;
        if (C0373g.f1086l) {
            androidx.fragment.app.f activity2 = getActivity();
            if (!C0914u.b(activity2 != null ? activity2.getIntent() : null, "route_value3", false)) {
                e4.e.f22900c.getClass();
                ref$BooleanRef.element = e4.e.e();
            }
        }
        A.c("StartScanFragment", new C0384s(13, this, ref$BooleanRef));
        if ((!this.f17547t || (map = this.f17551x) == null || map.isEmpty()) && !ref$BooleanRef.element) {
            f fVar = this.f17550w;
            if (fVar == null || fVar.a(true, false)) {
                LocationManager locationManager = (LocationManager) requireContext().getApplicationContext().getSystemService("location");
                if (locationManager != null) {
                    boolean zIsProviderEnabled = locationManager.isProviderEnabled("gps");
                    boolean zIsProviderEnabled2 = locationManager.isProviderEnabled("network");
                    if (zIsProviderEnabled || zIsProviderEnabled2) {
                        if (!C0373g.f1086l) {
                            E8.a.w().getClass();
                            Jb.b<List<l<String, Class<?>>>> bVar = F8.i.f1668g;
                            F8.i iVarA = i.a.a("/heymelody_app/device_scan");
                            iVarA.f("route_from", "StartScanActivity");
                            iVarA.b(requireActivity());
                            return;
                        }
                        e4.e.f22900c.getClass();
                        Collection collection = (Collection) C0379m.b(e4.e.f22901p).d();
                        if (collection == null || collection.isEmpty()) {
                            E8.a.w().getClass();
                            Jb.b<List<l<String, Class<?>>>> bVar2 = F8.i.f1668g;
                            F8.i iVarA2 = i.a.a("/heymelody_app/device_scan");
                            iVarA2.f("route_from", "StartScanActivity");
                            iVarA2.b(requireActivity());
                            return;
                        }
                        E8.a.w().getClass();
                        Jb.b<List<l<String, Class<?>>>> bVar3 = F8.i.f1668g;
                        F8.i iVarA3 = i.a.a("/heymelody_app/device_list_combine");
                        iVarA3.a(1);
                        iVarA3.f("route_from", "StartupActivity");
                        iVarA3.b(requireActivity());
                        requireActivity().finish();
                        return;
                    }
                }
                C0494b c0494b = this.f17546s;
                if (c0494b != null) {
                    c0494b.dismiss();
                }
                C0494b c0494b2 = new C0494b();
                this.f17546s = c0494b2;
                c0494b2.show(requireActivity().u(), "location_service");
                return;
            }
            return;
        }
        WeakHashMap<Activity, f> weakHashMap = f.f26302s;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        if (!f.a.b(heyMelodyApplication)) {
            f fVar2 = this.f17550w;
            if (fVar2 != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (Build.VERSION.SDK_INT >= 31) {
                    androidx.fragment.app.f fVar3 = fVar2.f26310a;
                    if (C.a.a(fVar3, "android.permission.BLUETOOTH_SCAN") != 0) {
                        A.b("RuntimePermissionAlert", "checkBluetoothPermissions permissionList.add BLUETOOTH_SCAN");
                        arrayList.add("android.permission.BLUETOOTH_SCAN");
                        z2 = true;
                    }
                    if (C.a.a(fVar3, "android.permission.BLUETOOTH_CONNECT") != 0) {
                        A.b("RuntimePermissionAlert", "checkBluetoothPermissions permissionList.add BLUETOOTH_CONNECT");
                        arrayList.add("android.permission.BLUETOOTH_CONNECT");
                        z2 = true;
                    }
                }
                if (z2) {
                    fVar2.d(arrayList);
                    return;
                }
                return;
            }
            return;
        }
        if (C0373g.f1086l) {
            E8.a.w().getClass();
            Jb.b<List<l<String, Class<?>>>> bVar4 = F8.i.f1668g;
            F8.i iVarA4 = i.a.a("/heymelody_app/device_list_combine");
            iVarA4.a(1);
            iVarA4.f("route_from", "StartupActivity");
            iVarA4.b(requireActivity());
            requireActivity().finish();
            return;
        }
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        for (Map.Entry<String, V3.a> entry : this.f17551x.entrySet()) {
            if (entry != null && entry.getValue() != null && entry.getValue().isConnected()) {
                int i10 = ref$IntRef.element + 1;
                ref$IntRef.element = i10;
                if (i10 > 1) {
                    break;
                } else {
                    value = entry.getValue();
                }
            }
        }
        A.c("StartScanFragment", new D(ref$IntRef, 0));
        if (ref$IntRef.element != 1 || value == null) {
            E8.a.w().getClass();
            Jb.b<List<l<String, Class<?>>>> bVar5 = F8.i.f1668g;
            F8.i iVarA5 = i.a.a("/heymelody_app/device_list");
            iVarA5.a(1);
            iVarA5.f("route_from", "StartupActivity");
            iVarA5.e(this);
            return;
        }
        E8.a.w().getClass();
        Jb.b<List<l<String, Class<?>>>> bVar6 = F8.i.f1668g;
        F8.i iVarA6 = i.a.a("/ui/detail");
        iVarA6.f("device_mac_info", value.getAddress());
        iVarA6.f("device_name", value.getName());
        iVarA6.a(1);
        iVarA6.e(this);
    }
}
