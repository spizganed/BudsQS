package com.heytap.headset.component.supporteddevices;

import D7.C0379m;
import F8.c;
import Wb.l;
import a4.C0516a;
import a4.b;
import a4.d;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.app.i;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.headset.R;
import com.heytap.headset.component.supporteddevices.SupportedDevicesViewModel;
import g0.C1064c;
import j4.C1205a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: SupportedDevicesFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u0014H\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\u0016\u0010*\u001a\u00020\u001b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00170,H\u0002J\u0016\u0010-\u001a\u00020\u001b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00170,H\u0002J\u0014\u0010.\u001a\u00020\u001b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00170,J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u000201H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/heytap/headset/component/supporteddevices/SupportedDevicesFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "Lcom/heytap/headset/component/supporteddevices/IOnBrandClickListener;", "<init>", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "titleView", "Landroidx/appcompat/widget/AppCompatTextView;", "recyclerViewAdapter", "Lcom/heytap/headset/component/supporteddevices/SupportedDevicesAdapter;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "brandAll", "Lcom/heytap/headset/component/supporteddevices/SupportedDevicesBtnTextView;", "brandOpo", "brandOps", "supportedDevicesViewModel", "Lcom/heytap/headset/component/supporteddevices/SupportedDevicesViewModel;", "currentBrand", "Landroid/view/View;", "allDeviceList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/heytap/headset/component/supporteddevices/DeviceItemVO;", "opoDeviceList", "opsDeviceList", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "initView", "rootView", "setToolbar", "onAllDeviceItemListChange", "itemList", "", "onOPODeviceItemListChange", "onOPSDeviceItemListChange", "onBrandClickListener", "layout", "Landroid/widget/RelativeLayout;", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SupportedDevicesFragment extends c implements b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RecyclerView f17567p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f17568q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public SupportedDevicesBtnTextView f17569r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SupportedDevicesBtnTextView f17570s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SupportedDevicesBtnTextView f17571t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public SupportedDevicesViewModel f17572u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public RelativeLayout f17573v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CopyOnWriteArrayList<C0516a> f17574w = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CopyOnWriteArrayList<C0516a> f17575x = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CopyOnWriteArrayList<C0516a> f17576y = new CopyOnWriteArrayList<>();

    /* JADX INFO: compiled from: SupportedDevicesFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctionReferenceImpl f17577a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(l lVar) {
            this.f17577a = (FunctionReferenceImpl) lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f17577a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [Wb.l, kotlin.jvm.internal.FunctionReferenceImpl] */
        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f17577a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.heytap.headset.component.supporteddevices.SupportedDevicesFragment$onCreateView$1, reason: invalid class name */
    /* JADX INFO: compiled from: SupportedDevicesFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements l<List<? extends C0516a>, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(List<? extends C0516a> list) {
            List<? extends C0516a> p02 = list;
            h.e(p02, "p0");
            SupportedDevicesFragment supportedDevicesFragment = (SupportedDevicesFragment) this.receiver;
            supportedDevicesFragment.getClass();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(p02);
            C0516a c0516a = new C0516a(null, null, null, null, null, 31, null);
            c0516a.setProductId("end_item_id");
            arrayList.add(c0516a);
            CopyOnWriteArrayList<C0516a> copyOnWriteArrayList = supportedDevicesFragment.f17574w;
            copyOnWriteArrayList.clear();
            copyOnWriteArrayList.addAll(arrayList);
            RelativeLayout relativeLayout = supportedDevicesFragment.f17573v;
            SupportedDevicesBtnTextView supportedDevicesBtnTextView = supportedDevicesFragment.f17569r;
            if (supportedDevicesBtnTextView == null) {
                h.i("brandAll");
                throw null;
            }
            if (h.a(relativeLayout, supportedDevicesBtnTextView)) {
                d dVar = supportedDevicesFragment.f17568q;
                if (dVar == null) {
                    h.i("recyclerViewAdapter");
                    throw null;
                }
                dVar.d(arrayList);
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.heytap.headset.component.supporteddevices.SupportedDevicesFragment$onCreateView$2, reason: invalid class name */
    /* JADX INFO: compiled from: SupportedDevicesFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements l<List<? extends C0516a>, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(List<? extends C0516a> list) {
            List<? extends C0516a> p02 = list;
            h.e(p02, "p0");
            SupportedDevicesFragment supportedDevicesFragment = (SupportedDevicesFragment) this.receiver;
            supportedDevicesFragment.getClass();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(p02);
            C0516a c0516a = new C0516a(null, null, null, null, null, 31, null);
            c0516a.setProductId("end_item_id");
            arrayList.add(c0516a);
            CopyOnWriteArrayList<C0516a> copyOnWriteArrayList = supportedDevicesFragment.f17575x;
            copyOnWriteArrayList.clear();
            copyOnWriteArrayList.addAll(arrayList);
            RelativeLayout relativeLayout = supportedDevicesFragment.f17573v;
            SupportedDevicesBtnTextView supportedDevicesBtnTextView = supportedDevicesFragment.f17570s;
            if (supportedDevicesBtnTextView == null) {
                h.i("brandOpo");
                throw null;
            }
            if (h.a(relativeLayout, supportedDevicesBtnTextView)) {
                d dVar = supportedDevicesFragment.f17568q;
                if (dVar == null) {
                    h.i("recyclerViewAdapter");
                    throw null;
                }
                dVar.d(arrayList);
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.heytap.headset.component.supporteddevices.SupportedDevicesFragment$onCreateView$3, reason: invalid class name */
    /* JADX INFO: compiled from: SupportedDevicesFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements l<List<? extends C0516a>, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(List<? extends C0516a> list) {
            List<? extends C0516a> p02 = list;
            h.e(p02, "p0");
            SupportedDevicesFragment supportedDevicesFragment = (SupportedDevicesFragment) this.receiver;
            supportedDevicesFragment.getClass();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(p02);
            C0516a c0516a = new C0516a(null, null, null, null, null, 31, null);
            c0516a.setProductId("end_item_id");
            arrayList.add(c0516a);
            CopyOnWriteArrayList<C0516a> copyOnWriteArrayList = supportedDevicesFragment.f17576y;
            copyOnWriteArrayList.clear();
            copyOnWriteArrayList.addAll(arrayList);
            RelativeLayout relativeLayout = supportedDevicesFragment.f17573v;
            SupportedDevicesBtnTextView supportedDevicesBtnTextView = supportedDevicesFragment.f17571t;
            if (supportedDevicesBtnTextView == null) {
                h.i("brandOps");
                throw null;
            }
            if (h.a(relativeLayout, supportedDevicesBtnTextView)) {
                d dVar = supportedDevicesFragment.f17568q;
                if (dVar == null) {
                    h.i("recyclerViewAdapter");
                    throw null;
                }
                dVar.d(arrayList);
            }
            return Jb.l.f2618a;
        }
    }

    @Override // a4.b
    public final void k(RelativeLayout layout) {
        h.e(layout, "layout");
        this.f17573v = layout;
        SupportedDevicesBtnTextView supportedDevicesBtnTextView = this.f17569r;
        if (supportedDevicesBtnTextView == null) {
            h.i("brandAll");
            throw null;
        }
        if (layout == supportedDevicesBtnTextView) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f17574w);
            d dVar = this.f17568q;
            if (dVar != null) {
                dVar.d(arrayList);
                return;
            } else {
                h.i("recyclerViewAdapter");
                throw null;
            }
        }
        SupportedDevicesBtnTextView supportedDevicesBtnTextView2 = this.f17570s;
        if (supportedDevicesBtnTextView2 == null) {
            h.i("brandOpo");
            throw null;
        }
        if (layout == supportedDevicesBtnTextView2) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.f17575x);
            d dVar2 = this.f17568q;
            if (dVar2 != null) {
                dVar2.d(arrayList2);
                return;
            } else {
                h.i("recyclerViewAdapter");
                throw null;
            }
        }
        SupportedDevicesBtnTextView supportedDevicesBtnTextView3 = this.f17571t;
        if (supportedDevicesBtnTextView3 == null) {
            h.i("brandOps");
            throw null;
        }
        if (layout == supportedDevicesBtnTextView3) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(this.f17576y);
            d dVar3 = this.f17568q;
            if (dVar3 != null) {
                dVar3.d(arrayList3);
            } else {
                h.i("recyclerViewAdapter");
                throw null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.d(fVarRequireActivity, "requireActivity(...)");
        O viewModelStore = fVarRequireActivity.getViewModelStore();
        N.b defaultViewModelProviderFactory = fVarRequireActivity.getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, fVarRequireActivity.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(SupportedDevicesViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f17572u = (SupportedDevicesViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.heymelody_app_fragment_supported_devices, container, false);
        setHasOptionsMenu(true);
        androidx.fragment.app.f activity = getActivity();
        h.c(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        androidx.appcompat.app.a aVarX = ((i) activity).x();
        if (aVarX != null) {
            aVarX.n(true);
        }
        if (aVarX != null) {
            aVarX.p(false);
        }
        h.b(viewInflate);
        View viewFindViewById = viewInflate.findViewById(R.id.rv_devices);
        h.d(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        this.f17567p = recyclerView;
        recyclerView.setItemAnimator(null);
        View viewFindViewById2 = viewInflate.findViewById(R.id.tv_title);
        h.d(viewFindViewById2, "findViewById(...)");
        View viewFindViewById3 = viewInflate.findViewById(R.id.btn_all);
        h.d(viewFindViewById3, "findViewById(...)");
        this.f17569r = (SupportedDevicesBtnTextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.btn_opo);
        h.d(viewFindViewById4, "findViewById(...)");
        this.f17570s = (SupportedDevicesBtnTextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.btn_ops);
        h.d(viewFindViewById5, "findViewById(...)");
        this.f17571t = (SupportedDevicesBtnTextView) viewFindViewById5;
        SupportedDevicesBtnTextView supportedDevicesBtnTextView = this.f17569r;
        if (supportedDevicesBtnTextView == null) {
            h.i("brandAll");
            throw null;
        }
        supportedDevicesBtnTextView.setItemListener(this);
        SupportedDevicesBtnTextView supportedDevicesBtnTextView2 = this.f17570s;
        if (supportedDevicesBtnTextView2 == null) {
            h.i("brandOpo");
            throw null;
        }
        supportedDevicesBtnTextView2.setItemListener(this);
        SupportedDevicesBtnTextView supportedDevicesBtnTextView3 = this.f17571t;
        if (supportedDevicesBtnTextView3 == null) {
            h.i("brandOps");
            throw null;
        }
        supportedDevicesBtnTextView3.setItemListener(this);
        SupportedDevicesBtnTextView supportedDevicesBtnTextView4 = this.f17569r;
        if (supportedDevicesBtnTextView4 == null) {
            h.i("brandAll");
            throw null;
        }
        supportedDevicesBtnTextView4.setText(getResources().getString(R.string.melody_common_all));
        SupportedDevicesBtnTextView supportedDevicesBtnTextView5 = this.f17570s;
        if (supportedDevicesBtnTextView5 == null) {
            h.i("brandOpo");
            throw null;
        }
        supportedDevicesBtnTextView5.setText(getResources().getString(R.string.heymelody_app_opo));
        SupportedDevicesBtnTextView supportedDevicesBtnTextView6 = this.f17571t;
        if (supportedDevicesBtnTextView6 == null) {
            h.i("brandOps");
            throw null;
        }
        supportedDevicesBtnTextView6.setText(getResources().getString(R.string.heymelody_app_ops));
        SupportedDevicesBtnTextView supportedDevicesBtnTextView7 = this.f17569r;
        if (supportedDevicesBtnTextView7 == null) {
            h.i("brandAll");
            throw null;
        }
        this.f17573v = supportedDevicesBtnTextView7;
        Context contextRequireContext = requireContext();
        h.d(contextRequireContext, "requireContext(...)");
        this.f17568q = new d(contextRequireContext);
        requireContext().getApplicationContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        RecyclerView recyclerView2 = this.f17567p;
        if (recyclerView2 == null) {
            h.i("recyclerView");
            throw null;
        }
        recyclerView2.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView3 = this.f17567p;
        if (recyclerView3 == null) {
            h.i("recyclerView");
            throw null;
        }
        d dVar = this.f17568q;
        if (dVar == null) {
            h.i("recyclerViewAdapter");
            throw null;
        }
        recyclerView3.setAdapter(dVar);
        SupportedDevicesBtnTextView supportedDevicesBtnTextView8 = this.f17569r;
        if (supportedDevicesBtnTextView8 == null) {
            h.i("brandAll");
            throw null;
        }
        supportedDevicesBtnTextView8.requestFocus();
        SupportedDevicesViewModel supportedDevicesViewModel = this.f17572u;
        if (supportedDevicesViewModel == null) {
            h.i("supportedDevicesViewModel");
            throw null;
        }
        InterfaceC0601m viewLifecycleOwner = getViewLifecycleOwner();
        h.d(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C0379m.g(AbstractC1508a.f().i(), new C1064c(23)).e(viewLifecycleOwner, new SupportedDevicesViewModel.a(new SupportedDevicesViewModel$observeData$1(1, supportedDevicesViewModel, SupportedDevicesViewModel.class, "onWhiteListChange", "onWhiteListChange(Ljava/util/List;)V", 0)));
        C1205a.C0275a.f25026a.f25025a.e(viewLifecycleOwner, new SupportedDevicesViewModel.a(new SupportedDevicesViewModel$observeData$2(1, supportedDevicesViewModel, SupportedDevicesViewModel.class, "onImageUrlsChange", "onImageUrlsChange(Ljava/util/Map;)V", 0)));
        SupportedDevicesViewModel supportedDevicesViewModel2 = this.f17572u;
        if (supportedDevicesViewModel2 == null) {
            h.i("supportedDevicesViewModel");
            throw null;
        }
        supportedDevicesViewModel2.f17578b.e(getViewLifecycleOwner(), new a(new AnonymousClass1(1, this, SupportedDevicesFragment.class, "onAllDeviceItemListChange", "onAllDeviceItemListChange(Ljava/util/List;)V", 0)));
        SupportedDevicesViewModel supportedDevicesViewModel3 = this.f17572u;
        if (supportedDevicesViewModel3 == null) {
            h.i("supportedDevicesViewModel");
            throw null;
        }
        supportedDevicesViewModel3.f17579c.e(getViewLifecycleOwner(), new a(new AnonymousClass2(1, this, SupportedDevicesFragment.class, "onOPODeviceItemListChange", "onOPODeviceItemListChange(Ljava/util/List;)V", 0)));
        SupportedDevicesViewModel supportedDevicesViewModel4 = this.f17572u;
        if (supportedDevicesViewModel4 == null) {
            h.i("supportedDevicesViewModel");
            throw null;
        }
        supportedDevicesViewModel4.f17580d.e(getViewLifecycleOwner(), new a(new AnonymousClass3(1, this, SupportedDevicesFragment.class, "onOPSDeviceItemListChange", "onOPSDeviceItemListChange(Ljava/util/List;)V", 0)));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        requireActivity().finish();
        return true;
    }
}
