package com.oplus.melody.ui.component.detail.dress.carousel;

import E9.u;
import F8.b;
import Ha.c;
import Kb.q;
import R8.w;
import Wb.l;
import X.d;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.f;
import androidx.appcompat.app.i;
import androidx.core.view.InterfaceC0575p;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.K;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import b9.m;
import b9.n;
import com.coui.appcompat.preference.COUIPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.heytap.headset.R;
import com.oplus.melody.model.repository.personaldress.carousel.CarouselDressDTO;
import com.oplus.melody.ui.component.detail.dress.carousel.CarouselDressListViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import n8.AbstractC1353a;
import n8.g;

/* JADX INFO: compiled from: CarouselDressListFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0016\u0010\u001a\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0016\u0010\u001e\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0002J\u0012\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\"H\u0002J\u0018\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\fH\u0016J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\nH\u0002J\b\u0010/\u001a\u00020\u0012H\u0002J\b\u00100\u001a\u00020\u0012H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressListFragment;", "Lcom/oplus/melody/ui/base/BaseCOUIPreferenceFragment;", "Landroidx/core/view/MenuProvider;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressListViewModel;", "mListCategory", "Lcom/coui/appcompat/preference/COUIPreferenceCategory;", "mIsEditMode", "", "mMenuEdit", "Landroid/view/MenuItem;", "mMenuDone", "mDeleteConfirmDialog", "Landroidx/appcompat/app/AlertDialog;", "mInvalidThemesTipDialog", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", "view", "Landroid/view/View;", "onCarouselDressChanged", "list", "", "Lcom/oplus/melody/model/repository/personaldress/carousel/CarouselDressDTO;", "showInvalidThemesDialog", "invalidCarousels", "showDeleteConfirmDialog", "id", "", "deleteCarouselDress", "navigateToEditActivity", "carouselId", "onCreateMenu", "menu", "Landroid/view/Menu;", "menuInflater", "Landroid/view/MenuInflater;", "onMenuItemSelected", "menuItem", "setEditMode", "isEdit", "updateMenuVisibility", "updatePreferenceVisibility", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CarouselDressListFragment extends b implements InterfaceC0575p {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public COUIPreferenceCategory f20807A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f20808B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public MenuItem f20809C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public MenuItem f20810D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public f f20811E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public f f20812F;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CarouselDressListViewModel f20813z;

    /* JADX INFO: compiled from: CarouselDressListFragment.kt */
    public static final class a implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20814a;

        public a(l lVar) {
            this.f20814a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20814a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20814a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.carousel.CarouselDressListFragment$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: CarouselDressListFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements l<List<? extends CarouselDressDTO>, Jb.l> {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [androidx.fragment.app.Fragment, com.oplus.melody.ui.component.detail.dress.carousel.CarouselDressListFragment, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.collections.EmptyList] */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Collection, java.util.List] */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.util.ArrayList] */
        @Override // Wb.l
        public final Jb.l d(List<? extends CarouselDressDTO> list) {
            ?? arrayList;
            List<? extends CarouselDressDTO> p02 = list;
            h.e(p02, "p0");
            ?? r02 = (CarouselDressListFragment) this.receiver;
            r02.getClass();
            if (p02.isEmpty()) {
                if (r02.f20808B) {
                    r02.t(false);
                }
                MenuItem menuItem = r02.f20809C;
                if (menuItem != null) {
                    menuItem.setVisible(false);
                }
                MenuItem menuItem2 = r02.f20810D;
                if (menuItem2 != null) {
                    menuItem2.setVisible(false);
                }
            } else {
                r02.v();
            }
            COUIPreferenceCategory cOUIPreferenceCategory = r02.f20807A;
            if (cOUIPreferenceCategory != null) {
                cOUIPreferenceCategory.i();
            }
            CarouselDressListViewModel carouselDressListViewModel = r02.f20813z;
            if (carouselDressListViewModel != null) {
                arrayList = new ArrayList();
                for (Object obj : p02) {
                    List<String> themeIdList = ((CarouselDressDTO) obj).getThemeIdList();
                    if (themeIdList == null || !themeIdList.isEmpty()) {
                        Iterator it = themeIdList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (!carouselDressListViewModel.d((String) it.next())) {
                                arrayList.add(obj);
                                break;
                            }
                        }
                    }
                }
            } else {
                arrayList = EmptyList.f25350a;
            }
            if (!arrayList.isEmpty()) {
                r02.u(arrayList);
            }
            if (p02.isEmpty()) {
                COUIPreference cOUIPreference = new COUIPreference(r02.getActivity());
                cOUIPreference.setTitle(r02.getString(R.string.melody_common_carousel_dress_empty_hint));
                cOUIPreference.setSelectable(false);
                cOUIPreference.setVisible(true);
                cOUIPreference.setPersistent(false);
                COUIPreferenceCategory cOUIPreferenceCategory2 = r02.f20807A;
                if (cOUIPreferenceCategory2 != null) {
                    cOUIPreferenceCategory2.e(cOUIPreference);
                }
            } else {
                for (CarouselDressDTO carouselDressDTO : p02) {
                    androidx.fragment.app.f fVarRequireActivity = r02.requireActivity();
                    h.d(fVarRequireActivity, "requireActivity(...)");
                    CarouselDressSwitchPreference carouselDressSwitchPreference = new CarouselDressSwitchPreference(fVarRequireActivity, null);
                    carouselDressSwitchPreference.setKey("carousel_dress_" + carouselDressDTO.getCarouselId());
                    carouselDressSwitchPreference.setTitle(carouselDressDTO.getName());
                    carouselDressSwitchPreference.setChecked(carouselDressDTO.isApplied());
                    carouselDressSwitchPreference.setVisible(!r02.f20808B);
                    carouselDressSwitchPreference.setPersistent(false);
                    carouselDressSwitchPreference.f14730c = new A9.f(11, r02, carouselDressDTO);
                    carouselDressSwitchPreference.setOnPreferenceChangeListener(new c(7, r02, carouselDressDTO));
                    COUIPreferenceCategory cOUIPreferenceCategory3 = r02.f20807A;
                    if (cOUIPreferenceCategory3 != null) {
                        cOUIPreferenceCategory3.e(carouselDressSwitchPreference);
                    }
                    androidx.fragment.app.f fVarRequireActivity2 = r02.requireActivity();
                    h.d(fVarRequireActivity2, "requireActivity(...)");
                    CarouselDressButtonPreference carouselDressButtonPreference = new CarouselDressButtonPreference(fVarRequireActivity2);
                    carouselDressButtonPreference.setKey("carousel_dress_edit_" + carouselDressDTO.getCarouselId());
                    carouselDressButtonPreference.setTitle(carouselDressDTO.getName());
                    carouselDressButtonPreference.e(r02.getString(R.string.melody_common_multi_connect_remove));
                    carouselDressButtonPreference.setVisible(r02.f20808B);
                    carouselDressButtonPreference.setPersistent(false);
                    carouselDressButtonPreference.f14538r = new u(14, r02, carouselDressDTO);
                    COUIPreferenceCategory cOUIPreferenceCategory4 = r02.f20807A;
                    if (cOUIPreferenceCategory4 != null) {
                        cOUIPreferenceCategory4.e(carouselDressButtonPreference);
                    }
                }
            }
            return Jb.l.f2618a;
        }
    }

    @Override // androidx.core.view.InterfaceC0575p
    public final boolean g(MenuItem menuItem) {
        h.e(menuItem, "menuItem");
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_edit) {
            t(true);
            return true;
        }
        if (itemId != R.id.menu_done) {
            return false;
        }
        t(false);
        return true;
    }

    @Override // androidx.core.view.InterfaceC0575p
    public final void j(Menu menu, MenuInflater menuInflater) {
        h.e(menu, "menu");
        h.e(menuInflater, "menuInflater");
        menuInflater.inflate(R.menu.melody_ui_carousel_dress_list_edit_menu, menu);
        this.f20809C = menu.findItem(R.id.menu_edit);
        this.f20810D = menu.findItem(R.id.menu_done);
        v();
    }

    @Override // F8.b, com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.f11714c.setNestedScrollingEnabled(false);
        this.f11714c.setItemAnimator(null);
        androidx.fragment.app.f activity = getActivity();
        if (activity != null) {
            InterfaceC0601m viewLifecycleOwner = getViewLifecycleOwner();
            h.d(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            activity.f13202c.b(this, viewLifecycleOwner, Lifecycle.State.f8900p);
        }
        androidx.fragment.app.f activity2 = getActivity();
        h.c(activity2, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        i iVar = (i) activity2;
        O viewModelStore = iVar.getViewModelStore();
        N.b defaultViewModelProviderFactory = iVar.getDefaultViewModelProviderFactory();
        d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, iVar.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(CarouselDressListViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        CarouselDressListViewModel carouselDressListViewModel = (CarouselDressListViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f20813z = carouselDressListViewModel;
        boolean z2 = carouselDressListViewModel.f20820g;
        t<List<CarouselDressDTO>> tVar = carouselDressListViewModel.f20819f;
        if (!z2) {
            carouselDressListViewModel.f20820g = true;
            Object obj = AbstractC1353a.f26467c;
            AbstractC1353a abstractC1353aA = AbstractC1353a.C0292a.a();
            Object obj2 = g.f26485c;
            g gVarA = g.a.a();
            tVar.m(abstractC1353aA.c(carouselDressListViewModel.f20818e, carouselDressListViewModel.f20817d), new CarouselDressListViewModel.b(new D9.a(carouselDressListViewModel, 23)));
            tVar.m(gVarA.d(carouselDressListViewModel.f20815b), new CarouselDressListViewModel.b(new B9.d(carouselDressListViewModel, 27)));
        }
        if (tVar != null) {
            K.a(tVar).e(getViewLifecycleOwner(), new a(new AnonymousClass1(1, this, CarouselDressListFragment.class, "onCarouselDressChanged", "onCarouselDressChanged(Ljava/util/List;)V", 0)));
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        o(R.xml.melody_ui_carousel_dress_list_preference);
        this.f20807A = (COUIPreferenceCategory) a("carousel_dress_list");
    }

    public final void s(int i10) {
        if (this.f20813z != null) {
            Object obj = AbstractC1353a.f26467c;
            AbstractC1353a.C0292a.a().a(i10).thenApply((Function<? super Boolean, ? extends U>) new Aa.c(new m(i10), 13)).exceptionally((Function<Throwable, ? extends U>) new n(i10, 0));
        }
    }

    public final void t(boolean z2) {
        this.f20808B = z2;
        CarouselDressListViewModel carouselDressListViewModel = this.f20813z;
        if (carouselDressListViewModel != null) {
            androidx.lifecycle.u<Boolean> uVar = carouselDressListViewModel.f20821i;
            if (!h.a(uVar.d(), Boolean.valueOf(z2))) {
                uVar.l(Boolean.valueOf(z2));
            }
        }
        v();
        COUIPreferenceCategory cOUIPreferenceCategory = this.f20807A;
        if (cOUIPreferenceCategory == null) {
            return;
        }
        int size = cOUIPreferenceCategory.f11662c.size();
        for (int i10 = 0; i10 < size; i10++) {
            Preference preferenceH = cOUIPreferenceCategory.h(i10);
            h.d(preferenceH, "getPreference(...)");
            String key = preferenceH.getKey();
            if (key != null) {
                preferenceH.setVisible(ec.l.H(key, "carousel_dress_edit_", false) ? this.f20808B : (ec.l.H(key, "carousel_dress_", false) && this.f20808B) ? false : true);
            }
        }
    }

    public final void u(List<CarouselDressDTO> list) {
        List<CarouselDressDTO> list2;
        String string;
        androidx.fragment.app.f activity = getActivity();
        if (activity == null) {
            return;
        }
        if (list.size() == 1) {
            string = getString(R.string.melody_common_carousel_dress_invalid_themes_dialog_message, ((CarouselDressDTO) q.t(list)).getName());
            list2 = list;
        } else {
            list2 = list;
            string = getString(R.string.melody_common_carousel_dress_invalid_themes_dialog_message, q.y(list2, "、", null, null, new C7.d(4), 30));
        }
        h.b(string);
        f fVar = this.f20812F;
        if (fVar != null) {
            fVar.dismiss();
        }
        f fVarShow = new G7.b(activity).setCancelable(false).setTitle(R.string.melody_common_authorization_tip).setMessage(string).setPositiveButton(R.string.melody_common_carousel_dress_invalid_themes_dialog_btn, new w(1, list2, this)).show();
        this.f20812F = fVarShow;
        if (fVarShow != null) {
            fVarShow.setCanceledOnTouchOutside(false);
        }
    }

    public final void v() {
        MenuItem menuItem = this.f20809C;
        if (menuItem != null) {
            menuItem.setVisible(!this.f20808B);
        }
        MenuItem menuItem2 = this.f20810D;
        if (menuItem2 != null) {
            menuItem2.setVisible(this.f20808B);
        }
    }
}
