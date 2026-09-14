package com.heytap.headset.component.mydevicelist;

import Ca.k;
import D7.C0379m;
import D7.RunnableC0380n;
import D7.o0;
import Ea.F;
import Ea.ViewOnClickListenerC0405n;
import Wb.l;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.i;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.s;
import c.u;
import com.heytap.headset.R;
import com.heytap.headset.component.mydevicelist.MyDeviceListViewModel;
import com.heytap.headset.component.mydevicelist.a;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.S;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import f4.C1043b;
import i8.AbstractC1148a;
import java.util.Comparator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import m4.f;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: MyDeviceListFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 Q2\u00020\u0001:\u0002QRB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020+H\u0016J&\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0018\u00105\u001a\u00020+2\u0006\u00106\u001a\u0002072\u0006\u00101\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u000200H\u0002J\u0010\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020\u001bH\u0002J\u0010\u0010@\u001a\u00020+2\u0006\u0010=\u001a\u000200H\u0002J\u0010\u0010A\u001a\u00020+2\u0006\u0010=\u001a\u000200H\u0002J\u001a\u0010B\u001a\u00020+2\u0006\u0010=\u001a\u0002002\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010C\u001a\u00020+H\u0016J\u0012\u0010D\u001a\u00020\u001b2\b\u0010E\u001a\u0004\u0018\u00010\u0019H\u0002J\u001c\u0010F\u001a\u00020+2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00190\u001fH\u0002J0\u0010H\u001a\u00020+2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00190\u001f2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00190\u001fH\u0002J\u0016\u0010I\u001a\u00020+2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00190KH\u0002J\u0016\u0010L\u001a\u00020+2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00190KH\u0002J\u0006\u0010M\u001a\u00020+J\u0006\u0010N\u001a\u00020+J\u0006\u0010O\u001a\u00020+J\u0010\u0010P\u001a\u00020+2\u0006\u0010M\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00190\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00190!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/heytap/headset/component/mydevicelist/MyDeviceListFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "<init>", "()V", "deviceListRecyclerView", "Landroidx/recyclerview/widget/COUIRecyclerView;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLinearLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager$delegate", "Lkotlin/Lazy;", "addDeviceImg", "Landroid/widget/ImageView;", "deleteDeviceButton", "Landroid/widget/Button;", "deviceListAdapter", "Lcom/heytap/headset/component/mydevicelist/MyDeviceListAdapter;", "deviceListViewModel", "Lcom/heytap/headset/component/mydevicelist/MyDeviceListViewModel;", "toolbar", "Lcom/oplus/melody/ui/widget/MelodyCompatToolbar;", "deleteDeviceDialog", "Landroidx/appcompat/app/AlertDialog;", "clickConnectItem", "Lcom/heytap/headset/component/mydevicelist/MyDeviceItemVO;", "hasClickReconnectButton", "", "connectFailedAddress", "", "newDeviceItemMap", "", "oldDeviceItemMap", "Ljava/util/concurrent/ConcurrentHashMap;", "jumpToDetailActivityFuture", "Ljava/util/concurrent/ScheduledFuture;", "isEditMode", "fromStartPage", "mRuntimePermissionAlert", "Lcom/heytap/headset/widget/RuntimePermissionAlert;", "submitListRunnable", "Ljava/lang/Runnable;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "initDeleteAndAddView", "view", "updateDeleteAndAddView", "enterEdit", "initToolbar", "initRecyclerView", "onViewCreated", "onDestroy", "checkShowCompatibleDialog", "deviceItem", "onDeviceItemListChange", "deviceItemMap", "checkAutoJumpToDeviceDetailActivity", "updateMenuState", "itemList", "", "checkConnectStateForConnectFailed", "enterEditMode", "exitEditMode", "updateToolbarContent", "checkboxAnimation", "Companion", "DeviceItemComparator", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MyDeviceListFragment extends F8.c {

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public ScheduledFuture<?> f17426C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f17427D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public boolean f17428E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public f f17429F;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public COUIRecyclerView f17431p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f17433r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Button f17434s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.heytap.headset.component.mydevicelist.a f17435t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public MyDeviceListViewModel f17436u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public MelodyCompatToolbar f17437v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public androidx.appcompat.app.f f17438w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public V3.a f17439x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f17440y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f17441z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Jb.b f17432q = kotlin.a.a(new O9.d(this, 3));

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public Map<String, V3.a> f17424A = kotlin.collections.a.b0();

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final ConcurrentHashMap<String, V3.a> f17425B = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final RunnableC0380n f17430G = new RunnableC0380n(this, 28);

    /* JADX INFO: compiled from: MyDeviceListFragment.kt */
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

    /* JADX INFO: compiled from: MyDeviceListFragment.kt */
    public static final class b extends s {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ i f17443e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i iVar) {
            super(true);
            this.f17443e = iVar;
        }

        @Override // c.s
        public final void b() {
            MyDeviceListFragment myDeviceListFragment = MyDeviceListFragment.this;
            if (myDeviceListFragment.f17427D) {
                myDeviceListFragment.t();
            } else {
                f(false);
                this.f17443e.getOnBackPressedDispatcher().c();
            }
        }
    }

    /* JADX INFO: compiled from: MyDeviceListFragment.kt */
    public static final class c implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f17444a;

        public c(l lVar) {
            this.f17444a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f17444a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f17444a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.heytap.headset.component.mydevicelist.MyDeviceListFragment$onCreateView$1, reason: invalid class name */
    /* JADX INFO: compiled from: MyDeviceListFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements l<Map<String, ? extends V3.a>, Jb.l> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // Wb.l
        public final Jb.l d(Map<String, ? extends V3.a> map) {
            Map<String, ? extends V3.a> p02 = map;
            h.e(p02, "p0");
            MyDeviceListFragment myDeviceListFragment = (MyDeviceListFragment) this.receiver;
            myDeviceListFragment.f17424A = p02;
            Handler handler = o0.c.f1143a;
            RunnableC0380n runnableC0380n = myDeviceListFragment.f17430G;
            handler.removeCallbacksAndMessages(runnableC0380n);
            handler.postDelayed(runnableC0380n, 50L);
            return Jb.l.f2618a;
        }
    }

    public static final boolean r(MyDeviceListFragment myDeviceListFragment, V3.a aVar) {
        String address = aVar.getAddress();
        if (address == null || address.length() == 0) {
            return false;
        }
        int iH = S.h(aVar.getName(), AbstractC1508a.f().g());
        if (iH == -1) {
            int i10 = AbstractC1148a.f24096c;
            AbstractC1148a abstractC1148aA = AbstractC1148a.C0266a.a();
            if (abstractC1148aA == null || !abstractC1148aA.d(aVar.getAddress())) {
                return false;
            }
        }
        androidx.fragment.app.f fVarRequireActivity = myDeviceListFragment.requireActivity();
        h.d(fVarRequireActivity, "requireActivity(...)");
        String address2 = aVar.getAddress();
        h.b(address2);
        k.a(fVarRequireActivity, iH, address2);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        if (activity != null) {
            WeakHashMap<Activity, f> weakHashMap = f.f26302s;
            this.f17429F = f.a.a(activity);
        }
        setHasOptionsMenu(true);
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.d(fVarRequireActivity, "requireActivity(...)");
        O viewModelStore = fVarRequireActivity.getViewModelStore();
        N.b defaultViewModelProviderFactory = fVarRequireActivity.getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, fVarRequireActivity.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(MyDeviceListViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f17436u = (MyDeviceListViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        h.e(menu, "menu");
        h.e(inflater, "inflater");
        inflater.inflate(R.menu.heymelody_app_menu_devicelist, menu);
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
        this.f17434s = button;
        button.setOnClickListener(new F(this, 5));
        View viewFindViewById2 = viewInflate.findViewById(R.id.add_device);
        h.d(viewFindViewById2, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById2;
        this.f17433r = imageView;
        imageView.setOnClickListener(new ViewOnClickListenerC0405n(this, 9));
        u(false);
        setHasOptionsMenu(true);
        View viewFindViewById3 = viewInflate.findViewById(R.id.toolbar);
        h.d(viewFindViewById3, "findViewById(...)");
        this.f17437v = (MelodyCompatToolbar) viewFindViewById3;
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.c(fVarRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        i iVar = (i) fVarRequireActivity;
        MelodyCompatToolbar melodyCompatToolbar = this.f17437v;
        if (melodyCompatToolbar == null) {
            h.i("toolbar");
            throw null;
        }
        iVar.y(melodyCompatToolbar);
        View viewFindViewById4 = viewInflate.findViewById(R.id.device_list);
        h.d(viewFindViewById4, "findViewById(...)");
        COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) viewFindViewById4;
        this.f17431p = cOUIRecyclerView;
        cOUIRecyclerView.setLayoutManager((LinearLayoutManager) this.f17432q.getValue());
        COUIRecyclerView cOUIRecyclerView2 = this.f17431p;
        if (cOUIRecyclerView2 == null) {
            h.i("deviceListRecyclerView");
            throw null;
        }
        cOUIRecyclerView2.addItemDecoration(new V3.b(this));
        Context contextRequireContext = requireContext();
        h.d(contextRequireContext, "requireContext(...)");
        com.heytap.headset.component.mydevicelist.a aVar = new com.heytap.headset.component.mydevicelist.a(contextRequireContext);
        COUIRecyclerView cOUIRecyclerView3 = this.f17431p;
        if (cOUIRecyclerView3 == null) {
            h.i("deviceListRecyclerView");
            throw null;
        }
        aVar.f17474j = cOUIRecyclerView3.getLayoutDirection() == 1 ? -1 : 1;
        aVar.f17470e = new com.heytap.headset.component.mydevicelist.c(this, aVar);
        this.f17435t = aVar;
        COUIRecyclerView cOUIRecyclerView4 = this.f17431p;
        if (cOUIRecyclerView4 == null) {
            h.i("deviceListRecyclerView");
            throw null;
        }
        cOUIRecyclerView4.setAdapter(aVar);
        COUIRecyclerView cOUIRecyclerView5 = this.f17431p;
        if (cOUIRecyclerView5 == null) {
            h.i("deviceListRecyclerView");
            throw null;
        }
        RecyclerView.m itemAnimator = cOUIRecyclerView5.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.f11909f = 0L;
        }
        MyDeviceListViewModel myDeviceListViewModel = this.f17436u;
        if (myDeviceListViewModel == null) {
            h.i("deviceListViewModel");
            throw null;
        }
        InterfaceC0601m viewLifecycleOwner = getViewLifecycleOwner();
        h.d(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        O7.l<Map<String, String>> lVar = C1043b.a.f23099a.f23098a;
        h.d(lVar, "getPicUrlsMapLiveData(...)");
        C0379m.b(lVar).e(viewLifecycleOwner, new MyDeviceListViewModel.a(new MyDeviceListViewModel$startObserve$1(1, myDeviceListViewModel, MyDeviceListViewModel.class, "onPicUrlsMapChange", "onPicUrlsMapChange(Ljava/util/Map;)V", 0)));
        MyDeviceListViewModel myDeviceListViewModel2 = this.f17436u;
        if (myDeviceListViewModel2 == null) {
            h.i("deviceListViewModel");
            throw null;
        }
        InterfaceC0601m viewLifecycleOwner2 = getViewLifecycleOwner();
        h.d(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        myDeviceListViewModel2.d(viewLifecycleOwner2).e(getViewLifecycleOwner(), new c(new AnonymousClass1(1, this, MyDeviceListFragment.class, "onDeviceItemListChange", "onDeviceItemListChange(Ljava/util/Map;)V", 0)));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        androidx.appcompat.app.f fVar;
        super.onDestroy();
        androidx.appcompat.app.f fVar2 = this.f17438w;
        if (fVar2 != null && fVar2.isShowing() && (fVar = this.f17438w) != null) {
            fVar.hide();
        }
        androidx.appcompat.app.f fVar3 = k.f811a;
        if (fVar3 == null || !fVar3.isShowing()) {
            return;
        }
        fVar3.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() == 16908332) {
            requireActivity().onBackPressed();
        } else if (item.getItemId() == R.id.edit) {
            A.b("MyDeviceListFragment", "enterEditMode");
            com.heytap.headset.component.mydevicelist.a aVar = this.f17435t;
            if (aVar == null) {
                h.i("deviceListAdapter");
                throw null;
            }
            aVar.f17471f = true;
            aVar.f17468c.clear();
            if (aVar.getItemCount() > 0) {
                s(true);
            }
            this.f17427D = true;
            v();
            u(true);
        } else if (item.getItemId() == R.id.exit_edit) {
            t();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        this.f17425B.clear();
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        i iVar = (i) getActivity();
        h.b(iVar);
        MelodyCompatToolbar melodyCompatToolbar = this.f17437v;
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
        u onBackPressedDispatcher = iVar.getOnBackPressedDispatcher();
        InterfaceC0601m viewLifecycleOwner = getViewLifecycleOwner();
        h.d(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.a(viewLifecycleOwner, new b(iVar));
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("route_from");
            A.c("MyDeviceListFragment", new C8.a(string, 15));
            if (h.a(string, "StartupActivity")) {
                this.f17428E = true;
            }
        }
    }

    public final void s(boolean z2) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f17432q.getValue();
        int iG1 = linearLayoutManager.g1();
        int iH1 = linearLayoutManager.h1();
        com.heytap.headset.component.mydevicelist.a aVar = this.f17435t;
        if (aVar == null) {
            h.i("deviceListAdapter");
            throw null;
        }
        if (iG1 <= iH1) {
            int i10 = iG1;
            while (true) {
                COUIRecyclerView cOUIRecyclerView = this.f17431p;
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

    public final void t() {
        A.b("MyDeviceListFragment", "exitEditMode");
        com.heytap.headset.component.mydevicelist.a aVar = this.f17435t;
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
            s(false);
        }
        this.f17427D = false;
        v();
        u(false);
    }

    public final void u(boolean z2) {
        Button button = this.f17434s;
        if (button == null) {
            h.i("deleteDeviceButton");
            throw null;
        }
        button.setVisibility(8);
        if (z2) {
            ImageView imageView = this.f17433r;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            } else {
                h.i("addDeviceImg");
                throw null;
            }
        }
        ImageView imageView2 = this.f17433r;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        } else {
            h.i("addDeviceImg");
            throw null;
        }
    }

    public final void v() {
        if (this.f17427D) {
            MelodyCompatToolbar melodyCompatToolbar = this.f17437v;
            if (melodyCompatToolbar == null) {
                h.i("toolbar");
                throw null;
            }
            melodyCompatToolbar.getMenu().clear();
            melodyCompatToolbar.setIsTitleCenterStyle(false);
            melodyCompatToolbar.inflateMenu(R.menu.heymelody_app_menu_edit_mode);
            return;
        }
        MelodyCompatToolbar melodyCompatToolbar2 = this.f17437v;
        if (melodyCompatToolbar2 == null) {
            h.i("toolbar");
            throw null;
        }
        melodyCompatToolbar2.getMenu().clear();
        melodyCompatToolbar2.setIsTitleCenterStyle(false);
        melodyCompatToolbar2.inflateMenu(R.menu.heymelody_app_menu_devicelist);
    }
}
