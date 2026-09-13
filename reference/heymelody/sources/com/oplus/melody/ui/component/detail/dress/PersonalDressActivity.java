package com.oplus.melody.ui.component.detail.dress;

import D7.C0379m;
import Ea.F;
import F8.i;
import Jb.b;
import Wb.l;
import X.d;
import Y.r;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.core.view.InterfaceC0575p;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import com.coui.appcompat.tips.def.COUIDefaultTopTips;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.S;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.personaldress.a;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import com.oplus.melody.ui.widget.MelodyErrorLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import s8.AbstractC1508a;
import t8.q;

/* JADX INFO: compiled from: PersonalDressActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0015H\u0002J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0015H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/PersonalDressActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "Landroidx/core/view/MenuProvider;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/dress/PersonalDressViewModel;", "mErrorLayout", "Lcom/oplus/melody/ui/widget/MelodyErrorLayout;", "mContentLayout", "Landroid/view/View;", "mPopSwitchTip", "Lcom/coui/appcompat/tips/def/COUIDefaultTopTips;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "initViewModel", "onPopSwitchChanged", "isOpen", "", "navigateToActivity", "lab", "", "navigateToCustomActivity", "dressId", "bgType", "onConnectionStateChange", "state", "", "dealErrorState", "showContentView", "success", "onCreateMenu", "menu", "Landroid/view/Menu;", "menuInflater", "Landroid/view/MenuInflater;", "onMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "shouldExcludeNavigation", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PersonalDressActivity extends F8.a implements InterfaceC0575p {

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public static final /* synthetic */ int f20664Y = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public PersonalDressViewModel f20665U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public MelodyErrorLayout f20666V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public View f20667W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public COUIDefaultTopTips f20668X;

    /* JADX INFO: compiled from: PersonalDressActivity.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20669a;

        public a(l lVar) {
            this.f20669a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20669a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20669a.d(obj);
        }
    }

    public final void I(String str) {
        E8.a.w().getClass();
        b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a(str);
        PersonalDressViewModel personalDressViewModel = this.f20665U;
        iVarA.f("device_mac_info", personalDressViewModel != null ? personalDressViewModel.f20755b : null);
        PersonalDressViewModel personalDressViewModel2 = this.f20665U;
        iVarA.f("product_id", personalDressViewModel2 != null ? personalDressViewModel2.f20757d : null);
        PersonalDressViewModel personalDressViewModel3 = this.f20665U;
        iVarA.f("device_name", personalDressViewModel3 != null ? personalDressViewModel3.f20756c : null);
        PersonalDressViewModel personalDressViewModel4 = this.f20665U;
        iVarA.f("product_color", String.valueOf(personalDressViewModel4 != null ? Integer.valueOf(personalDressViewModel4.f20758e) : null));
        iVarA.b(this);
    }

    public final void J(String str, String str2) {
        E8.a.w().getClass();
        b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/dress/custom");
        iVarA.f("dress_id", str);
        iVarA.f("dress_background_type", str2 != null ? str2.toString() : null);
        PersonalDressViewModel personalDressViewModel = this.f20665U;
        iVarA.f("device_mac_info", personalDressViewModel != null ? personalDressViewModel.f20755b : null);
        PersonalDressViewModel personalDressViewModel2 = this.f20665U;
        iVarA.f("product_id", personalDressViewModel2 != null ? personalDressViewModel2.f20757d : null);
        PersonalDressViewModel personalDressViewModel3 = this.f20665U;
        iVarA.f("device_name", personalDressViewModel3 != null ? personalDressViewModel3.f20756c : null);
        PersonalDressViewModel personalDressViewModel4 = this.f20665U;
        iVarA.f("product_color", String.valueOf(personalDressViewModel4 != null ? Integer.valueOf(personalDressViewModel4.f20758e) : null));
        iVarA.b(this);
    }

    public final void K(boolean z2) {
        if (z2) {
            MelodyErrorLayout melodyErrorLayout = this.f20666V;
            if (melodyErrorLayout == null) {
                h.i("mErrorLayout");
                throw null;
            }
            melodyErrorLayout.setVisibility(8);
            View view = this.f20667W;
            if (view != null) {
                view.setVisibility(0);
                return;
            } else {
                h.i("mContentLayout");
                throw null;
            }
        }
        MelodyErrorLayout melodyErrorLayout2 = this.f20666V;
        if (melodyErrorLayout2 == null) {
            h.i("mErrorLayout");
            throw null;
        }
        melodyErrorLayout2.setVisibility(0);
        View view2 = this.f20667W;
        if (view2 != null) {
            view2.setVisibility(8);
        } else {
            h.i("mContentLayout");
            throw null;
        }
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
        u<Integer> uVar;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.melody_ui_activity_personal_dress);
        D(R.id.activity_standard_layout_main, true);
        y((MelodyCompatToolbar) findViewById(R.id.toolbar));
        androidx.appcompat.app.a aVarX = x();
        if (aVarX != null) {
            aVarX.n(true);
        }
        if (aVarX != null) {
            aVarX.r(true);
        }
        if (aVarX != null) {
            aVarX.t(R.string.melody_ui_peronalpress_title);
        }
        this.f13202c.a(this, this);
        View viewFindViewById = findViewById(R.id.melody_ui_error_layout);
        h.d(viewFindViewById, "findViewById(...)");
        this.f20666V = (MelodyErrorLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.content_layout);
        h.d(viewFindViewById2, "findViewById(...)");
        this.f20667W = viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.dress_pop_switch_tip);
        h.d(viewFindViewById3, "findViewById(...)");
        this.f20668X = (COUIDefaultTopTips) viewFindViewById3;
        O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(PersonalDressViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20665U = (PersonalDressViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        String strH = C0914u.h(getIntent(), "device_mac_info");
        if (strH == null) {
            strH = "";
        }
        String strH2 = C0914u.h(getIntent(), "product_id");
        String str = strH2 == null ? "" : strH2;
        String strH3 = C0914u.h(getIntent(), "device_name");
        String str2 = strH3 != null ? strH3 : "";
        String strH4 = C0914u.h(getIntent(), "product_color");
        int i10 = strH4 != null ? Integer.parseInt(strH4) : -1;
        boolean z2 = Boolean.parseBoolean(C0914u.h(getIntent(), "new_dress_mark"));
        PersonalDressViewModel personalDressViewModel = this.f20665U;
        if (personalDressViewModel != null) {
            personalDressViewModel.f20755b = strH;
        }
        if (personalDressViewModel != null) {
            personalDressViewModel.f20757d = str;
        }
        if (personalDressViewModel != null) {
            personalDressViewModel.f20756c = str2;
        }
        if (personalDressViewModel != null) {
            personalDressViewModel.f20758e = i10;
        }
        if (!TextUtils.isEmpty(strH)) {
            if (Y.j(AbstractC1508a.f().c(str, str2))) {
                if (this.f20665U != null) {
                    C0379m.b(C0379m.g(AbstractC0939b.E().v(strH), new r(3))).e(this, new a(new PersonalDressActivity$initViewModel$1(1, this, PersonalDressActivity.class, "onConnectionStateChange", "onConnectionStateChange(I)V", 0)));
                }
            } else if (this.f20665U != null) {
                C0379m.b(C0379m.g(AbstractC0939b.E().v(strH), new A6.f(28))).e(this, new a(new PersonalDressActivity$initViewModel$2(1, this, PersonalDressActivity.class, "onConnectionStateChange", "onConnectionStateChange(I)V", 0)));
            }
        }
        PersonalDressViewModel personalDressViewModel2 = this.f20665U;
        if (personalDressViewModel2 != null && (uVar = personalDressViewModel2.h) != null) {
            uVar.e(this, new a(new PersonalDressActivity$initViewModel$3(1, this, PersonalDressActivity.class, "dealErrorState", "dealErrorState(I)V", 0)));
        }
        PersonalDressViewModel personalDressViewModel3 = this.f20665U;
        if (personalDressViewModel3 != null) {
            personalDressViewModel3.e();
        }
        if (z2) {
            Object obj = com.oplus.melody.model.repository.personaldress.a.f20060c;
            a.C0231a.a().q(i10, false, str);
            a.C0231a.a().p(false);
        }
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        List<String> list = S.f19463a;
        if ("com.oplus.melody".equals(heyMelodyApplication.getPackageName())) {
            J7.b.a().d();
        }
    }

    @Override // F8.a, androidx.fragment.app.f, android.app.Activity
    public final void onResume() {
        super.onResume();
        List<String> list = S.f19463a;
        if ("com.heytap.headset".equals(getPackageName())) {
            if (q.l()) {
                COUIDefaultTopTips cOUIDefaultTopTips = this.f20668X;
                if (cOUIDefaultTopTips != null) {
                    cOUIDefaultTopTips.setVisibility(8);
                    return;
                } else {
                    h.i("mPopSwitchTip");
                    throw null;
                }
            }
            COUIDefaultTopTips cOUIDefaultTopTips2 = this.f20668X;
            if (cOUIDefaultTopTips2 == null) {
                h.i("mPopSwitchTip");
                throw null;
            }
            cOUIDefaultTopTips2.setTipsText(getString(R.string.melody_common_dress_switch_tip));
            COUIDefaultTopTips cOUIDefaultTopTips3 = this.f20668X;
            if (cOUIDefaultTopTips3 == null) {
                h.i("mPopSwitchTip");
                throw null;
            }
            cOUIDefaultTopTips3.setStartIcon(getDrawable(R.drawable.melody_ui_top_tip_start_icon));
            COUIDefaultTopTips cOUIDefaultTopTips4 = this.f20668X;
            if (cOUIDefaultTopTips4 == null) {
                h.i("mPopSwitchTip");
                throw null;
            }
            cOUIDefaultTopTips4.setNegativeButton("");
            COUIDefaultTopTips cOUIDefaultTopTips5 = this.f20668X;
            if (cOUIDefaultTopTips5 == null) {
                h.i("mPopSwitchTip");
                throw null;
            }
            cOUIDefaultTopTips5.setPositiveButton(getString(R.string.melody_common_dress_switch_go));
            COUIDefaultTopTips cOUIDefaultTopTips6 = this.f20668X;
            if (cOUIDefaultTopTips6 == null) {
                h.i("mPopSwitchTip");
                throw null;
            }
            cOUIDefaultTopTips6.setPositiveButtonListener(new F(this, 10));
            COUIDefaultTopTips cOUIDefaultTopTips7 = this.f20668X;
            if (cOUIDefaultTopTips7 != null) {
                cOUIDefaultTopTips7.setVisibility(0);
            } else {
                h.i("mPopSwitchTip");
                throw null;
            }
        }
    }
}
