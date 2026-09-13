package com.heytap.headset.component.mydevicelist;

import A9.k;
import D7.C0373g;
import D7.o0;
import E9.e;
import Ea.E;
import Ea.ViewOnClickListenerC0405n;
import F8.i;
import L8.RunnableC0474v;
import V3.g;
import Wb.l;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.f;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.headset.R;
import com.heytap.headset.component.mydevicelist.a;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: MyDeviceListFragmentForCombine.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 Y2\u00020\u0001:\u0002YZB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020(H\u0016J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0018\u00103\u001a\u00020(2\u0006\u00104\u001a\u0002052\u0006\u0010/\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020.H\u0002J\u0010\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020\u001fH\u0002J\u0010\u0010>\u001a\u00020(2\u0006\u0010;\u001a\u00020.H\u0002J\u0010\u0010?\u001a\u00020(2\u0006\u0010;\u001a\u00020.H\u0002J\u001a\u0010@\u001a\u00020(2\u0006\u0010;\u001a\u00020.2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010A\u001a\u00020(2\b\u0010B\u001a\u0004\u0018\u00010CJ\b\u0010D\u001a\u00020(H\u0016J\u001c\u0010E\u001a\u00020(2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019H\u0002J\u0016\u0010G\u001a\u00020(2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001b0IH\u0002J\b\u0010J\u001a\u00020(H\u0002J\b\u0010K\u001a\u00020(H\u0002J\b\u0010L\u001a\u00020(H\u0002J\u0010\u0010M\u001a\u00020(2\u0006\u0010J\u001a\u00020\u001fH\u0002J\u0018\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020(H\u0002J\u0010\u0010S\u001a\u00020(2\u0006\u0010T\u001a\u00020QH\u0002J\u0010\u0010U\u001a\u00020\u001f2\u0006\u0010T\u001a\u00020QH\u0002J\u0010\u0010V\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020QH\u0002J\u001e\u0010W\u001a\u00020Q2\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/heytap/headset/component/mydevicelist/MyDeviceListFragmentForCombine;", "Lcom/oplus/melody/ui/base/BaseFragment;", "<init>", "()V", "deviceListRecyclerView", "Landroidx/recyclerview/widget/COUIRecyclerView;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLinearLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager$delegate", "Lkotlin/Lazy;", "addDeviceImg", "Landroid/widget/ImageView;", "deleteDeviceButton", "Landroid/widget/Button;", "deviceListAdapter", "Lcom/heytap/headset/component/mydevicelist/MyDeviceListAdapter;", "deviceListViewModel", "Lcom/heytap/headset/component/mydevicelist/MyDeviceCardListViewModel;", "toolbar", "Lcom/oplus/melody/ui/widget/MelodyCompatToolbar;", "deleteDeviceDialog", "Landroidx/appcompat/app/AlertDialog;", "newDeviceItemMap", "", "", "Lcom/heytap/headset/component/mydevicelist/MyDeviceItemVO;", "oldDeviceItemMap", "Ljava/util/concurrent/ConcurrentHashMap;", "isEditMode", "", "fromStartPage", "remindDialog", "openBluetoothDialog", "deleteDeviceTime", "", "submitListRunnable", "Ljava/lang/Runnable;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "initDeleteAndAddView", "view", "updateDeleteAndAddView", "enterEdit", "initToolbar", "initRecyclerView", "onViewCreated", "checkAndShowMelodyUpdateDialog", "callback", "Lcom/oplus/melody/ui/helper/AppUpdateRemindHelper$CheckAndShowDialogResultCallback;", "onDestroy", "onDeviceItemListChange", "deviceItemMap", "updateMenuState", "itemList", "", "enterEditMode", "exitEditMode", "updateToolbarContent", "checkboxAnimation", "showInstallMelodyDialog", "isMelodyInstalled", "melodyVersionCode", "", "showOpenBluetoothDialog", "setMelodyUpdateRemindShowed", "versionCode", "isMelodyUpdateRemindShowed", "makeMelodyUpdateRemindKey", "getConnectedDeviceCount", "deviceMap", "Companion", "DeviceItemComparator", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MyDeviceListFragmentForCombine extends F8.c {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public f f17445A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public f f17446B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public long f17447C;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public COUIRecyclerView f17449p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f17451r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Button f17452s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.heytap.headset.component.mydevicelist.a f17453t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public MyDeviceCardListViewModel f17454u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public MelodyCompatToolbar f17455v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public f f17456w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f17459z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Jb.b f17450q = kotlin.a.a(new e(this, 9));

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Map<String, V3.a> f17457x = kotlin.collections.a.b0();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ConcurrentHashMap<String, V3.a> f17458y = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final k f17448D = new k(this, 26);

    /* JADX INFO: compiled from: MyDeviceListFragmentForCombine.kt */
    public static final class a implements Comparator<V3.a> {
        @Override // java.util.Comparator
        public final int compare(V3.a aVar, V3.a aVar2) {
            V3.a o12 = aVar;
            V3.a o22 = aVar2;
            h.e(o12, "o1");
            h.e(o22, "o2");
            boolean zIsConnected = o12.isConnected();
            boolean zIsConnected2 = o22.isConnected();
            if (zIsConnected && !zIsConnected2) {
                return -1;
            }
            if (zIsConnected || !zIsConnected2) {
                return h.g(o22.getLastConnectTime(), o12.getLastConnectTime());
            }
            return 1;
        }
    }

    /* JADX INFO: compiled from: MyDeviceListFragmentForCombine.kt */
    public static final class b {
        public b() {
        }

        public final void a(boolean z2) {
            A.c("MyDeviceListFragmentForCombine", new A9.h(6, z2));
            if (z2) {
                return;
            }
            o0.c.f1143a.postDelayed(new V3.c(MyDeviceListFragmentForCombine.this, 1), 400L);
        }
    }

    /* JADX INFO: compiled from: MyDeviceListFragmentForCombine.kt */
    public static final class c implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f17461a;

        public c(l lVar) {
            this.f17461a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f17461a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f17461a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.heytap.headset.component.mydevicelist.MyDeviceListFragmentForCombine$onCreateView$1, reason: invalid class name */
    /* JADX INFO: compiled from: MyDeviceListFragmentForCombine.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements l<Map<String, ? extends V3.a>, Jb.l> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // Wb.l
        public final Jb.l d(Map<String, ? extends V3.a> map) {
            Map<String, ? extends V3.a> p02 = map;
            h.e(p02, "p0");
            MyDeviceListFragmentForCombine myDeviceListFragmentForCombine = (MyDeviceListFragmentForCombine) this.receiver;
            if (C0373g.f1086l) {
                myDeviceListFragmentForCombine.getClass();
                if (p02.isEmpty()) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - myDeviceListFragmentForCombine.f17447C;
                    A.c("MyDeviceListFragmentForCombine", new g(0, jElapsedRealtime));
                    if (jElapsedRealtime < 1600) {
                        E8.a.w().getClass();
                        Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
                        i iVarA = i.a.a("/heymelody_app/device_start_scan");
                        iVarA.a(1);
                        iVarA.f1670b.putExtra("route_value3", true);
                        iVarA.b(myDeviceListFragmentForCombine.requireActivity());
                        myDeviceListFragmentForCombine.requireActivity().finishAffinity();
                    }
                }
            }
            myDeviceListFragmentForCombine.f17457x = p02;
            Handler handler = o0.c.f1143a;
            k kVar = myDeviceListFragmentForCombine.f17448D;
            handler.removeCallbacksAndMessages(kVar);
            handler.postDelayed(kVar, 50L);
            return Jb.l.f2618a;
        }
    }

    public static int t(Map map) {
        int i10 = 0;
        if (map != null && !map.isEmpty()) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                if (((V3.a) it.next()).isConnected()) {
                    i10++;
                }
            }
        }
        return i10;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        A.b("MyDeviceListFragmentForCombine", "onCreate");
        setHasOptionsMenu(true);
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.d(fVarRequireActivity, "requireActivity(...)");
        O viewModelStore = fVarRequireActivity.getViewModelStore();
        N.b defaultViewModelProviderFactory = fVarRequireActivity.getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, fVarRequireActivity.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(MyDeviceCardListViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f17454u = (MyDeviceCardListViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        h.e(menu, "menu");
        h.e(inflater, "inflater");
        inflater.inflate(R.menu.heymelody_app_menu_devicelist_combine, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.heymelody_app_fragment_devicelist, container, false);
        h.b(viewInflate);
        View viewFindViewById = viewInflate.findViewById(R.id.delete_device);
        h.d(viewFindViewById, "findViewById(...)");
        Button button = (Button) viewFindViewById;
        this.f17452s = button;
        button.setOnClickListener(new ViewOnClickListenerC0405n(this, 10));
        View viewFindViewById2 = viewInflate.findViewById(R.id.add_device);
        h.d(viewFindViewById2, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById2;
        this.f17451r = imageView;
        imageView.setOnClickListener(new E(this, 9));
        u(false);
        setHasOptionsMenu(true);
        View viewFindViewById3 = viewInflate.findViewById(R.id.toolbar);
        h.d(viewFindViewById3, "findViewById(...)");
        this.f17455v = (MelodyCompatToolbar) viewFindViewById3;
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.c(fVarRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        androidx.appcompat.app.i iVar = (androidx.appcompat.app.i) fVarRequireActivity;
        MelodyCompatToolbar melodyCompatToolbar = this.f17455v;
        if (melodyCompatToolbar == null) {
            h.i("toolbar");
            throw null;
        }
        iVar.y(melodyCompatToolbar);
        View viewFindViewById4 = viewInflate.findViewById(R.id.device_list);
        h.d(viewFindViewById4, "findViewById(...)");
        COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) viewFindViewById4;
        this.f17449p = cOUIRecyclerView;
        cOUIRecyclerView.setLayoutManager((LinearLayoutManager) this.f17450q.getValue());
        COUIRecyclerView cOUIRecyclerView2 = this.f17449p;
        if (cOUIRecyclerView2 == null) {
            h.i("deviceListRecyclerView");
            throw null;
        }
        cOUIRecyclerView2.addItemDecoration(new V3.h(this));
        Context contextRequireContext = requireContext();
        h.d(contextRequireContext, "requireContext(...)");
        com.heytap.headset.component.mydevicelist.a aVar = new com.heytap.headset.component.mydevicelist.a(contextRequireContext);
        COUIRecyclerView cOUIRecyclerView3 = this.f17449p;
        if (cOUIRecyclerView3 == null) {
            h.i("deviceListRecyclerView");
            throw null;
        }
        aVar.f17474j = cOUIRecyclerView3.getLayoutDirection() == 1 ? -1 : 1;
        aVar.f17470e = new d(this, aVar);
        this.f17453t = aVar;
        COUIRecyclerView cOUIRecyclerView4 = this.f17449p;
        if (cOUIRecyclerView4 == null) {
            h.i("deviceListRecyclerView");
            throw null;
        }
        cOUIRecyclerView4.setAdapter(aVar);
        COUIRecyclerView cOUIRecyclerView5 = this.f17449p;
        if (cOUIRecyclerView5 == null) {
            h.i("deviceListRecyclerView");
            throw null;
        }
        RecyclerView.m itemAnimator = cOUIRecyclerView5.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.f11909f = 0L;
        }
        MyDeviceCardListViewModel myDeviceCardListViewModel = this.f17454u;
        if (myDeviceCardListViewModel == null) {
            h.i("deviceListViewModel");
            throw null;
        }
        InterfaceC0601m viewLifecycleOwner = getViewLifecycleOwner();
        h.d(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        myDeviceCardListViewModel.d(viewLifecycleOwner).e(getViewLifecycleOwner(), new c(new AnonymousClass1(1, this, MyDeviceListFragmentForCombine.class, "onDeviceItemListChange", "onDeviceItemListChange(Ljava/util/Map;)V", 0)));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        f fVar;
        f fVar2;
        f fVar3;
        super.onDestroy();
        f fVar4 = this.f17456w;
        if (fVar4 != null && fVar4.isShowing() && (fVar3 = this.f17456w) != null) {
            fVar3.dismiss();
        }
        f fVar5 = this.f17445A;
        if (fVar5 != null && fVar5.isShowing() && (fVar2 = this.f17445A) != null) {
            fVar2.dismiss();
        }
        f fVar6 = this.f17446B;
        if (fVar6 != null && fVar6.isShowing() && (fVar = this.f17446B) != null) {
            fVar.dismiss();
        }
        f fVar7 = Ca.i.f806a;
        if (fVar7 != null) {
            fVar7.dismiss();
        }
        Ca.i.f806a = null;
        o0.c.f1145c.a().post(new RunnableC0474v(2));
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() == 16908332) {
            requireActivity().onBackPressed();
        } else if (item.getItemId() == R.id.edit) {
            A.b("MyDeviceListFragmentForCombine", "enterEditMode");
            com.heytap.headset.component.mydevicelist.a aVar = this.f17453t;
            if (aVar == null) {
                h.i("deviceListAdapter");
                throw null;
            }
            aVar.f17471f = true;
            aVar.f17468c.clear();
            if (aVar.getItemCount() > 0) {
                r(true);
            }
            this.f17459z = true;
            v();
            u(true);
        } else if (item.getItemId() == R.id.about) {
            E8.a.w().getClass();
            Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
            i.a.a("/ui/about").b(requireActivity());
        } else if (item.getItemId() == R.id.exit_edit) {
            s();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        this.f17458y.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        A.b("MyDeviceListFragmentForCombine", "onResume");
        e4.e.f22900c.getClass();
        o0.c.f1145c.execute(new L6.c(7));
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.appcompat.app.i iVar = (androidx.appcompat.app.i) getActivity();
        h.b(iVar);
        MelodyCompatToolbar melodyCompatToolbar = this.f17455v;
        if (melodyCompatToolbar == null) {
            h.i("toolbar");
            throw null;
        }
        iVar.y(melodyCompatToolbar);
        androidx.appcompat.app.a aVarX = iVar.x();
        h.b(aVarX);
        aVarX.t(R.string.melody_common_my_devices);
        androidx.appcompat.app.a aVarX2 = iVar.x();
        h.b(aVarX2);
        aVarX2.o();
        androidx.appcompat.app.a aVarX3 = iVar.x();
        h.b(aVarX3);
        aVarX3.n(true);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("route_from");
            A.c("MyDeviceListFragmentForCombine", new Ca.b(string, 11));
            h.a(string, "StartupActivity");
        }
        Ca.i.a(iVar, new b(), null, null);
    }

    public final void r(boolean z2) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f17450q.getValue();
        int iG1 = linearLayoutManager.g1();
        int iH1 = linearLayoutManager.h1();
        com.heytap.headset.component.mydevicelist.a aVar = this.f17453t;
        if (aVar == null) {
            h.i("deviceListAdapter");
            throw null;
        }
        if (iG1 <= iH1) {
            int i10 = iG1;
            while (true) {
                COUIRecyclerView cOUIRecyclerView = this.f17449p;
                if (cOUIRecyclerView == null) {
                    h.i("deviceListRecyclerView");
                    throw null;
                }
                RecyclerView.E eFindViewHolderForLayoutPosition = cOUIRecyclerView.findViewHolderForLayoutPosition(i10);
                a.b bVar = eFindViewHolderForLayoutPosition instanceof a.b ? (a.b) eFindViewHolderForLayoutPosition : null;
                if (bVar != null) {
                    aVar.g(bVar, z2);
                    aVar.h(bVar, i10);
                }
                if (i10 == iH1) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        if (iG1 > 0) {
            aVar.notifyItemRangeChanged(0, iG1, 1);
        }
        if (aVar.getItemCount() > iH1) {
            aVar.notifyItemRangeChanged(iH1 + 1, (aVar.getItemCount() - iH1) - 1, 1);
        }
    }

    public final void s() {
        A.b("MyDeviceListFragmentForCombine", "exitEditMode");
        com.heytap.headset.component.mydevicelist.a aVar = this.f17453t;
        if (aVar == null) {
            h.i("deviceListAdapter");
            throw null;
        }
        aVar.f17471f = false;
        if (aVar == null) {
            h.i("deviceListAdapter");
            throw null;
        }
        if (aVar.getItemCount() > 0) {
            r(false);
        }
        this.f17459z = false;
        v();
        u(false);
    }

    public final void u(boolean z2) {
        Button button = this.f17452s;
        if (button == null) {
            h.i("deleteDeviceButton");
            throw null;
        }
        button.setVisibility(8);
        if (z2) {
            ImageView imageView = this.f17451r;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            } else {
                h.i("addDeviceImg");
                throw null;
            }
        }
        ImageView imageView2 = this.f17451r;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        } else {
            h.i("addDeviceImg");
            throw null;
        }
    }

    public final void v() {
        if (this.f17459z) {
            MelodyCompatToolbar melodyCompatToolbar = this.f17455v;
            if (melodyCompatToolbar == null) {
                h.i("toolbar");
                throw null;
            }
            melodyCompatToolbar.getMenu().clear();
            melodyCompatToolbar.setIsTitleCenterStyle(false);
            melodyCompatToolbar.inflateMenu(R.menu.heymelody_app_menu_edit_mode);
            return;
        }
        MelodyCompatToolbar melodyCompatToolbar2 = this.f17455v;
        if (melodyCompatToolbar2 == null) {
            h.i("toolbar");
            throw null;
        }
        melodyCompatToolbar2.getMenu().clear();
        melodyCompatToolbar2.setIsTitleCenterStyle(false);
        melodyCompatToolbar2.inflateMenu(R.menu.heymelody_app_menu_devicelist_combine);
    }
}
