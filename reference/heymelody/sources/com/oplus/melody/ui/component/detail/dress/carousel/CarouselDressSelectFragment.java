package com.oplus.melody.ui.component.detail.dress.carousel;

import A9.q;
import B9.d;
import D7.o0;
import F8.c;
import F8.i;
import Jb.b;
import Jb.l;
import Wb.p;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.p;
import b9.s;
import b9.t;
import b9.u;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import com.oplus.melody.model.repository.personaldress.a;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: CarouselDressSelectFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressSelectFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressEditViewModel;", "mRecyclerView", "Landroidx/recyclerview/widget/COUIRecyclerView;", "mAdapter", "Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressSelectGroupAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDressItemClick", "dressItem", "Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressSelectVO;", "position", "", "downloadTheme", "navigateToPreview", "onDressCheckChanged", "isChecked", "", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CarouselDressSelectFragment extends c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CarouselDressEditViewModel f20823p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public COUIRecyclerView f20824q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public t f20825r;

    /* JADX INFO: compiled from: CarouselDressSelectFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f20826a;

        public a(d dVar) {
            this.f20826a = dVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20826a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) throws Throwable {
            this.f20826a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.carousel.CarouselDressSelectFragment$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: CarouselDressSelectFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements p<b9.v, Integer, l> {
        @Override // Wb.p
        public final l invoke(b9.v vVar, Integer num) {
            b9.v p02 = vVar;
            num.intValue();
            h.e(p02, "p0");
            CarouselDressSelectFragment carouselDressSelectFragment = (CarouselDressSelectFragment) this.receiver;
            carouselDressSelectFragment.getClass();
            A.c("CarouselDressSelectFragment", new X3.l(p02, 7));
            boolean z2 = p02.f13140d;
            String themeId = p02.f13137a;
            if (z2) {
                CarouselDressEditViewModel carouselDressEditViewModel = carouselDressSelectFragment.f20823p;
                if (carouselDressEditViewModel != null) {
                    A.c("CarouselDressSelectFragment", new T8.d(p02, 10));
                    E8.a.w().getClass();
                    b<List<Wb.l<String, Class<?>>>> bVar = i.f1668g;
                    i iVarA = i.a.a("/app/discovery");
                    iVarA.f1674f = null;
                    iVarA.f("device_mac_info", carouselDressEditViewModel.f20785b);
                    iVarA.f("product_id", carouselDressEditViewModel.f20787d);
                    iVarA.f("device_name", carouselDressEditViewModel.f20786c);
                    iVarA.f("product_color", String.valueOf(carouselDressEditViewModel.f20788e));
                    iVarA.f("dress_id", themeId);
                    iVarA.f("route_from", "onPreviewPopup");
                    iVarA.a(1);
                    iVarA.e(carouselDressSelectFragment);
                }
            } else {
                CarouselDressEditViewModel carouselDressEditViewModel2 = carouselDressSelectFragment.f20823p;
                if (carouselDressEditViewModel2 != null) {
                    h.e(themeId, "themeId");
                    LinkedHashSet linkedHashSet = carouselDressEditViewModel2.f20800r;
                    if (linkedHashSet.contains(themeId)) {
                        A.c("CarouselDressSelectFragment", new S7.c(p02, 13));
                    } else {
                        A.c("CarouselDressSelectFragment", new P3.d(p02, 21));
                        D9.a aVar = new D9.a(p02, 24);
                        PersonalDressDTO.PersonalDressData personalDressData = p02.f13146k;
                        if (personalDressData != null) {
                            if (linkedHashSet.contains(themeId)) {
                                A.c("CarouselDressEditViewModel", new Ca.b(themeId, 15));
                            } else {
                                linkedHashSet.add(themeId);
                                carouselDressEditViewModel2.f20801s.put(themeId, 0);
                                carouselDressEditViewModel2.k(0, themeId);
                                A.c("CarouselDressEditViewModel", new D6.f(themeId, 12));
                                b9.i iVar = new b9.i(themeId, carouselDressEditViewModel2, aVar);
                                Object obj = com.oplus.melody.model.repository.personaldress.a.f20060c;
                                a.C0231a.a().j(personalDressData, carouselDressEditViewModel2.f20787d, carouselDressEditViewModel2.f20788e, iVar).whenCompleteAsync((BiConsumer<? super l, ? super Throwable>) new q(new Nb.a(4, carouselDressEditViewModel2, themeId), 11), (Executor) o0.c.f1144b);
                            }
                        }
                    }
                }
            }
            return l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.carousel.CarouselDressSelectFragment$onViewCreated$3, reason: invalid class name */
    /* JADX INFO: compiled from: CarouselDressSelectFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements p<b9.v, Boolean, l> {
        /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00ee  */
        @Override // Wb.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final Jb.l invoke(b9.v r11, java.lang.Boolean r12) {
            /*
                Method dump skipped, instruction units count: 327
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.dress.carousel.CarouselDressSelectFragment.AnonymousClass3.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        return inflater.inflate(R.layout.melody_ui_carousel_dress_select_fragment, container, false);
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        androidx.lifecycle.t<List<s>> tVarE;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        if (activity == null) {
            return;
        }
        COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) view.findViewById(R.id.carousel_dress_select_recycler_view);
        this.f20824q = cOUIRecyclerView;
        if (cOUIRecyclerView != null) {
            cOUIRecyclerView.setLayoutManager(new LinearLayoutManager(1));
            cOUIRecyclerView.setItemAnimator(null);
        }
        O viewModelStore = activity.getViewModelStore();
        N.b defaultViewModelProviderFactory = activity.getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, activity.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(CarouselDressEditViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20823p = (CarouselDressEditViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(2, this, CarouselDressSelectFragment.class, "onDressItemClick", "onDressItemClick(Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressSelectVO;I)V", 0);
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(2, this, CarouselDressSelectFragment.class, "onDressCheckChanged", "onDressCheckChanged(Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressSelectVO;Z)V", 0);
        CarouselDressEditViewModel carouselDressEditViewModel = this.f20823p;
        P6.d dVar = carouselDressEditViewModel != null ? new P6.d(carouselDressEditViewModel, 8) : null;
        LayoutInflater layoutInflater = getLayoutInflater();
        h.d(layoutInflater, "getLayoutInflater(...)");
        t tVar = new t(anonymousClass2, anonymousClass3, dVar, layoutInflater);
        this.f20825r = tVar;
        COUIRecyclerView cOUIRecyclerView2 = this.f20824q;
        if (cOUIRecyclerView2 != null) {
            cOUIRecyclerView2.setAdapter(tVar);
        }
        t tVar2 = this.f20825r;
        if (tVar2 != null) {
            EmptyList newList = EmptyList.f25350a;
            h.e(newList, "newList");
            p.d dVarA = androidx.recyclerview.widget.p.a(new u(tVar2, newList));
            tVar2.f13130e = newList;
            dVarA.a(new A5.i(tVar2, 6));
        }
        CarouselDressEditViewModel carouselDressEditViewModel2 = this.f20823p;
        if (carouselDressEditViewModel2 == null || (tVarE = carouselDressEditViewModel2.e()) == null) {
            return;
        }
        tVarE.e(getViewLifecycleOwner(), new a(new d(this, 28)));
    }
}
