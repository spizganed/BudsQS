package com.oplus.melody.ui.component.detail.dress;

import A6.b;
import A6.g;
import D7.C0379m;
import Wb.l;
import X.d;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.InterfaceC0575p;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.p;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import com.heytap.headset.R;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: PersonalDressSeriesDetailActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0002J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\fH\u0002J\u0006\u0010\u0014\u001a\u00020\bJ\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/PersonalDressSeriesDetailActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "Landroidx/core/view/MenuProvider;", "<init>", "()V", "mAppBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "mViewModel", "Lcom/oplus/melody/ui/component/detail/dress/PersonalDressViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initViewModel", "navigateToDressDetail", ClientDataEntity.COL_DATA, "Lcom/oplus/melody/model/repository/personaldress/PersonalDressDTO$PersonalDressData;", "openSeriesDetailFragment", "getAppToolBar", "onConnectionStateChange", "state", "", "shouldExcludeNavigation", "", "onCreateMenu", "menu", "Landroid/view/Menu;", "menuInflater", "Landroid/view/MenuInflater;", "onMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PersonalDressSeriesDetailActivity extends F8.a implements InterfaceC0575p {

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final /* synthetic */ int f20733W = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public Toolbar f20734U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public PersonalDressViewModel f20735V;

    /* JADX INFO: compiled from: PersonalDressSeriesDetailActivity.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20736a;

        public a(l lVar) {
            this.f20736a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20736a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20736a.d(obj);
        }
    }

    @Override // F8.a
    public final boolean F() {
        return true;
    }

    @Override // androidx.core.view.InterfaceC0575p
    public final boolean g(MenuItem menuItem) {
        h.e(menuItem, "menuItem");
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        getOnBackPressedDispatcher().c();
        return true;
    }

    @Override // androidx.core.view.InterfaceC0575p
    public final void j(Menu menu, MenuInflater menuInflater) {
        h.e(menu, "menu");
        h.e(menuInflater, "menuInflater");
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.melody_ui_activity_personal_dress_series_detail);
        D(R.id.melody_ui_fragment_container, false);
        View viewFindViewById = findViewById(R.id.appbar_layout);
        h.d(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = findViewById(R.id.toolbar);
        h.d(viewFindViewById2, "findViewById(...)");
        this.f20734U = (Toolbar) viewFindViewById2;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.toolbar_top_padding);
        Toolbar toolbar = this.f20734U;
        if (toolbar == null) {
            h.i("toolbar");
            throw null;
        }
        toolbar.setPadding(0, Ja.a.a(this) + dimensionPixelOffset, 0, 0);
        Toolbar toolbar2 = this.f20734U;
        if (toolbar2 == null) {
            h.i("toolbar");
            throw null;
        }
        y(toolbar2);
        this.f13202c.a(this, this);
        O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        d dVarC = b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(PersonalDressViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        PersonalDressViewModel personalDressViewModel = (PersonalDressViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f20735V = personalDressViewModel;
        String strH = C0914u.h(getIntent(), "device_mac_info");
        if (strH == null) {
            strH = "";
        }
        personalDressViewModel.f20755b = strH;
        PersonalDressViewModel personalDressViewModel2 = this.f20735V;
        if (personalDressViewModel2 != null) {
            String strH2 = C0914u.h(getIntent(), "device_name");
            if (strH2 == null) {
                strH2 = "";
            }
            personalDressViewModel2.f20756c = strH2;
        }
        PersonalDressViewModel personalDressViewModel3 = this.f20735V;
        if (personalDressViewModel3 != null) {
            String strH3 = C0914u.h(getIntent(), "product_id");
            if (strH3 == null) {
                strH3 = "";
            }
            personalDressViewModel3.f20757d = strH3;
        }
        PersonalDressViewModel personalDressViewModel4 = this.f20735V;
        if (personalDressViewModel4 != null) {
            String strH4 = C0914u.h(getIntent(), "product_color");
            personalDressViewModel4.f20758e = strH4 != null ? Integer.parseInt(strH4) : -1;
        }
        PersonalDressViewModel personalDressViewModel5 = this.f20735V;
        if (personalDressViewModel5 != null) {
            personalDressViewModel5.e();
        }
        PersonalDressViewModel personalDressViewModel6 = this.f20735V;
        if (personalDressViewModel6 != null) {
            String str = personalDressViewModel6.f20755b;
            C0379m.b(C0379m.g(AbstractC0939b.E().v(str != null ? str : ""), new A6.f(28))).e(this, new a(new PersonalDressSeriesDetailActivity$initViewModel$1(1, this, PersonalDressSeriesDetailActivity.class, "onConnectionStateChange", "onConnectionStateChange(I)V", 0)));
        }
        Fragment fragmentD = u().D("PersonalDressSeriesDetailFragment");
        if (fragmentD == null) {
            androidx.fragment.app.j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(PersonalDressSeriesDetailFragment.class.getName());
        }
        fragmentD.setArguments(getIntent().getExtras());
        p pVarU = u();
        pVarU.getClass();
        g.c(pVarU, R.id.melody_ui_fragment_container, fragmentD, "PersonalDressSeriesDetailFragment").h(true, true);
    }
}
