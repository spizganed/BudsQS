package com.oplus.melody.ui.component.detail.moresetting;

import A6.g;
import A9.d;
import D7.C0379m;
import D7.i0;
import D7.j0;
import D9.c;
import D9.e;
import E9.u;
import F8.b;
import Wb.l;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.i;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0897c;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.component.detail.moresetting.MoreSettingViewModel;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: MoreSettingFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0010\u001a\u00020\u00072\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingFragment;", "Lcom/oplus/melody/ui/base/BaseCOUIPreferenceFragment;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", "view", "Landroid/view/View;", "onCreate", "itemsChanged", "items", "", "Ljava/lang/Class;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MoreSettingFragment extends b {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public MoreSettingViewModel f21133z;

    /* JADX INFO: compiled from: MoreSettingFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21134a;

        public a(l lVar) {
            this.f21134a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21134a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21134a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.moresetting.MoreSettingFragment$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: MoreSettingFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements l<List<? extends Class<?>>, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(List<? extends Class<?>> list) {
            Object next;
            List<? extends Class<?>> p02 = list;
            h.e(p02, "p0");
            MoreSettingFragment moreSettingFragment = (MoreSettingFragment) this.receiver;
            moreSettingFragment.getClass();
            A.c("MoreSettingFragment", new D9.b(0, p02));
            Iterator<T> it = p02.iterator();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (!it.hasNext()) {
                    Preference preferenceF = moreSettingFragment.f11713b.f11752g.f("bottom_preference");
                    if (preferenceF == null) {
                        preferenceF = null;
                    }
                    if (preferenceF == null) {
                        preferenceF = new Preference(moreSettingFragment.requireContext());
                        preferenceF.setLayoutResource(R.layout.coui_preference_bottom);
                        preferenceF.setKey("bottom_preference");
                        preferenceF.setSelectable(false);
                        moreSettingFragment.f11713b.f11752g.e(preferenceF);
                    }
                    preferenceF.setOrder(p02.size() + 1);
                    ArrayList arrayList = new ArrayList();
                    int size = moreSettingFragment.f11713b.f11752g.f11662c.size();
                    for (int i12 = 1; i12 < size; i12++) {
                        Preference preferenceH = moreSettingFragment.f11713b.f11752g.h(i12);
                        h.d(preferenceH, "getPreference(...)");
                        if (preferenceH instanceof PreferenceCategory) {
                            Iterator<T> it2 = p02.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it2.next();
                                if (((Class) next).getSimpleName().equals(((PreferenceCategory) preferenceH).getKey())) {
                                    break;
                                }
                            }
                            if (next == null) {
                                arrayList.add(preferenceH);
                                A.c("MoreSettingFragment", new c(0, preferenceH));
                            }
                        }
                    }
                    int size2 = arrayList.size();
                    while (i10 < size2) {
                        Object obj = arrayList.get(i10);
                        i10++;
                        moreSettingFragment.f11713b.f11752g.j((Preference) obj);
                    }
                    return Jb.l.f2618a;
                }
                i11++;
                Class cls = (Class) it.next();
                A.c("MoreSettingFragment", new d(cls, 6));
                Preference preferenceF2 = moreSettingFragment.f11713b.f11752g.f(cls.getSimpleName());
                PreferenceCategory preferenceCategory = preferenceF2 instanceof PreferenceCategory ? (PreferenceCategory) preferenceF2 : null;
                if (preferenceCategory == null) {
                    COUIPreferenceCategory cOUIPreferenceCategory = new COUIPreferenceCategory(moreSettingFragment.requireActivity(), null);
                    j0 j0Var = new j0(cls);
                    i0 i0Var = new i0(Context.class, moreSettingFragment.getActivity());
                    MoreSettingViewModel moreSettingViewModel = moreSettingFragment.f21133z;
                    if (moreSettingViewModel == null) {
                        h.i("mViewModel");
                        throw null;
                    }
                    Object objE = j0Var.e(i0Var, new i0(MoreSettingViewModel.class, moreSettingViewModel), new i0(InterfaceC0601m.class, moreSettingFragment));
                    Preference preference = objE instanceof Preference ? (Preference) objE : null;
                    if (preference == null) {
                        A.h("MoreSettingFragment", cls.getSimpleName().concat(" newInstance error"));
                    } else {
                        preference.setPersistent(false);
                        cOUIPreferenceCategory.setPersistent(false);
                        cOUIPreferenceCategory.setKey(cls.getSimpleName());
                        cOUIPreferenceCategory.setOrder(i11);
                        moreSettingFragment.f11713b.f11752g.e(cOUIPreferenceCategory);
                        cOUIPreferenceCategory.e(preference);
                    }
                } else {
                    preferenceCategory.setOrder(i11);
                }
            }
        }
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        String string;
        String string2;
        String string3;
        String string4;
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Bundle arguments = getArguments();
        String str = "";
        if (arguments == null || (string = arguments.getString("device_mac_info")) == null) {
            string = "";
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string2 = arguments2.getString("product_id")) == null) {
            string2 = "";
        }
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (string3 = arguments3.getString("device_name")) == null) {
            string3 = "";
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null && (string4 = arguments4.getString("product_color")) != null) {
            str = string4;
        }
        androidx.fragment.app.f activity = getActivity();
        if (activity == null) {
            return;
        }
        X.d dVar = new X.d(activity.getViewModelStore(), new e(string, string2, string3, str), activity.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(MoreSettingViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        MoreSettingViewModel moreSettingViewModel = (MoreSettingViewModel) dVar.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f21133z = moreSettingViewModel;
        String productId = moreSettingViewModel.f21137c;
        h.e(productId, "productId");
        String productName = moreSettingViewModel.f21138d;
        h.e(productName, "productName");
        C0379m.b(C0379m.g(AbstractC1508a.f().i(), new u(19, productId, productName))).e(activity, new MoreSettingViewModel.a(new B9.d(moreSettingViewModel, 2)));
        String address = moreSettingViewModel.f21136b;
        h.e(address, "address");
        C0379m.b(C0379m.g(AbstractC0939b.E().v(address), new g(3))).e(activity, new MoreSettingViewModel.a(new D9.a(moreSettingViewModel, 1)));
        C0379m.b(moreSettingViewModel.h).e(activity, new a(new AnonymousClass1(1, this, MoreSettingFragment.class, "itemsChanged", "itemsChanged(Ljava/util/List;)V", 0)));
        MoreSettingViewModel moreSettingViewModel2 = this.f21133z;
        if (moreSettingViewModel2 != null) {
            moreSettingViewModel2.f(string).e(activity, new a(new D9.a(this, 0)));
        } else {
            h.i("mViewModel");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() == 16908332) {
            A.b("MoreSettingFragment", "onOptionsItemSelected home");
            requireActivity().finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // F8.b, com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        androidx.appcompat.app.a aVarX;
        androidx.appcompat.app.a aVarX2;
        androidx.appcompat.app.a aVarX3;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        i iVar = activity instanceof i ? (i) activity : null;
        View viewFindViewById = view.findViewById(R.id.tool_bar);
        h.d(viewFindViewById, "findViewById(...)");
        MelodyCompatToolbar melodyCompatToolbar = (MelodyCompatToolbar) viewFindViewById;
        if (iVar != null) {
            iVar.y(melodyCompatToolbar);
        }
        if (iVar != null && (aVarX3 = iVar.x()) != null) {
            aVarX3.t(R.string.melody_ui_more_setting_title);
        }
        if (iVar != null && (aVarX2 = iVar.x()) != null) {
            aVarX2.o();
        }
        if (iVar != null && (aVarX = iVar.x()) != null) {
            aVarX.n(true);
        }
        if (C0897c.b(requireActivity()) || C0897c.c(requireActivity())) {
            View viewFindViewById2 = view.findViewById(android.R.id.list_container);
            h.d(viewFindViewById2, "findViewById(...)");
            ViewGroup.LayoutParams layoutParams = ((FrameLayout) viewFindViewById2).getLayoutParams();
            h.c(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) layoutParams;
            fVar.setMarginStart((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
            fVar.setMarginEnd((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        o(R.xml.melody_ui_more_setting_preference);
    }
}
