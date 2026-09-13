package com.oplus.melody.ui.component.detail.dress;

import A6.b;
import A9.j;
import D7.C0379m;
import X.d;
import Y.r;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.p;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import com.heytap.headset.R;
import com.oplus.melody.common.util.C0897c;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: PersonalDressDetailActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010\u0014\u001a\u00020\tJ2\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J(\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0007H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/PersonalDressDetailActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/dress/PersonalDressDetailViewModel;", "mIsInMagicWindow", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onConnectionStateChange", "state", "", "navigateToDetailFragment", "bundle", "resetDetailFragment", "openFragment", "fragmentClassName", "", "fragmentTag", "enterAnim", "exitAnim", "turnFragmentPage", "fragment", "Landroidx/fragment/app/Fragment;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "shouldExcludeNavigation", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PersonalDressDetailActivity extends F8.a {

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final /* synthetic */ int f20670W = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public PersonalDressDetailViewModel f20671U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public boolean f20672V;

    /* JADX INFO: compiled from: PersonalDressDetailActivity.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f20673a;

        public a(j jVar) {
            this.f20673a = jVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20673a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20673a.d(obj);
        }
    }

    @Override // F8.a
    public final boolean F() {
        return true;
    }

    public final void I(Bundle bundle) {
        String name = PersonalDressDetailFragment.class.getName();
        PersonalDressDetailViewModel personalDressDetailViewModel = this.f20671U;
        if (personalDressDetailViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        String str = personalDressDetailViewModel.f20712g;
        Fragment fragmentD = u().D(str);
        if (fragmentD == null) {
            androidx.fragment.app.j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(name);
        }
        fragmentD.setArguments(bundle);
        p pVarU = u();
        pVarU.getClass();
        C0585a c0585a = new C0585a(pVarU);
        c0585a.d(R.id.melody_ui_fragment_container, fragmentD, str);
        c0585a.j();
        p pVarU2 = u();
        pVarU2.z(true);
        pVarU2.E();
    }

    @Override // F8.a, androidx.appcompat.app.i, c.i, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        h.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        boolean zB = C0897c.b(this);
        if (this.f20672V != zB) {
            this.f20672V = zB;
            p pVarU = u();
            PersonalDressDetailViewModel personalDressDetailViewModel = this.f20671U;
            if (personalDressDetailViewModel == null) {
                h.i("mViewModel");
                throw null;
            }
            Fragment fragmentD = pVarU.D(personalDressDetailViewModel.f20712g);
            if (fragmentD != null) {
                p pVarU2 = u();
                pVarU2.getClass();
                C0585a c0585a = new C0585a(pVarU2);
                c0585a.m(fragmentD);
                c0585a.j();
                I(fragmentD.getArguments());
            }
        }
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.melody_ui_activity_standard);
        D(R.id.activity_standard_layout_main, true);
        y((MelodyCompatToolbar) findViewById(R.id.toolbar));
        O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        d dVarC = b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(PersonalDressDetailViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        PersonalDressDetailViewModel personalDressDetailViewModel = (PersonalDressDetailViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f20671U = personalDressDetailViewModel;
        Intent intent = getIntent();
        h.d(intent, "getIntent(...)");
        PersonalDressDTO.PersonalDressData personalDressData = (PersonalDressDTO.PersonalDressData) C0914u.f(intent, "dress_data", PersonalDressDTO.PersonalDressData.class);
        String strH = C0914u.h(intent, "device_mac_info");
        if (strH == null) {
            strH = "";
        }
        personalDressDetailViewModel.f20712g = strH;
        String strH2 = C0914u.h(intent, "device_name");
        if (strH2 == null) {
            strH2 = "";
        }
        personalDressDetailViewModel.h = strH2;
        String strH3 = C0914u.h(intent, "product_id");
        personalDressDetailViewModel.f20713i = strH3 != null ? strH3 : "";
        String strH4 = C0914u.h(intent, "product_color");
        personalDressDetailViewModel.f20714j = strH4 != null ? Integer.parseInt(strH4) : -1;
        if (personalDressData != null) {
            personalDressDetailViewModel.f20711f.l(personalDressData);
            personalDressDetailViewModel.d(personalDressData);
        }
        s<EarphoneDTO> sVarX = AbstractC0939b.E().x(personalDressDetailViewModel.f20712g);
        h.d(sVarX, "getEarphoneWithoutDistinct(...)");
        personalDressDetailViewModel.f20719o = C0379m.b(C0379m.g(sVarX, new r(2)));
        PersonalDressDetailViewModel personalDressDetailViewModel2 = this.f20671U;
        if (personalDressDetailViewModel2 == null) {
            h.i("mViewModel");
            throw null;
        }
        if (TextUtils.isEmpty(personalDressDetailViewModel2.f20712g)) {
            finish();
        } else {
            PersonalDressDetailViewModel personalDressDetailViewModel3 = this.f20671U;
            if (personalDressDetailViewModel3 == null) {
                h.i("mViewModel");
                throw null;
            }
            t tVar = personalDressDetailViewModel3.f20719o;
            if (tVar == null) {
                h.i("mEarphoneLiveData");
                throw null;
            }
            tVar.e(this, new a(new j(this, 20)));
            I(savedInstanceState);
        }
        this.f20672V = C0897c.b(this);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        onBackPressed();
        return true;
    }
}
