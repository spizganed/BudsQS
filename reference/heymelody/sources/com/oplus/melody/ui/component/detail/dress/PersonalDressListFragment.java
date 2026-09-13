package com.oplus.melody.ui.component.detail.dress;

import A9.j;
import F8.c;
import F8.i;
import Jb.b;
import Jb.l;
import Wb.p;
import X.d;
import a9.C0524A;
import a9.C0529F;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.heytap.headset.R;
import java.util.List;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: PersonalDressListFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0016\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u001c\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/PersonalDressListFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/dress/PersonalDressViewModel;", "mRecyclerView", "Landroidx/recyclerview/widget/COUIRecyclerView;", "mAdapter", "Lcom/oplus/melody/ui/component/detail/dress/PersonalDressGroupAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDressItemClick", "dressItem", "Lcom/oplus/melody/ui/component/detail/dress/PersonalDressVO;", "position", "", "onGroupItemClick", "series", "Lcom/oplus/melody/ui/component/detail/dress/PersonalSeriesVO;", "dresslist", "", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PersonalDressListFragment extends c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PersonalDressViewModel f20729p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public COUIRecyclerView f20730q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public C0524A f20731r;

    /* JADX INFO: compiled from: PersonalDressListFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f20732a;

        public a(j jVar) {
            this.f20732a = jVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20732a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20732a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.PersonalDressListFragment$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: PersonalDressListFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements p<C0529F, Integer, l> {
        @Override // Wb.p
        public final l invoke(C0529F c0529f, Integer num) {
            C0529F p02 = c0529f;
            num.intValue();
            h.e(p02, "p0");
            PersonalDressListFragment personalDressListFragment = (PersonalDressListFragment) this.receiver;
            personalDressListFragment.getClass();
            if (p02 instanceof c9.h) {
                androidx.fragment.app.f fVarRequireActivity = personalDressListFragment.requireActivity();
                h.c(fVarRequireActivity, "null cannot be cast to non-null type com.oplus.melody.ui.component.detail.dress.PersonalDressActivity");
                ((PersonalDressActivity) fVarRequireActivity).J(p02.getThemeId(), ((c9.h) p02).getMBgType());
            } else {
                E8.a.w().getClass();
                b<List<Wb.l<String, Class<?>>>> bVar = i.f1668g;
                i iVarA = i.a.a("/ui/dress/detail");
                iVarA.f1670b.putExtra("dress_data", p02.getDressData());
                PersonalDressViewModel personalDressViewModel = personalDressListFragment.f20729p;
                iVarA.f("device_mac_info", personalDressViewModel != null ? personalDressViewModel.f20755b : null);
                PersonalDressViewModel personalDressViewModel2 = personalDressListFragment.f20729p;
                iVarA.f("product_id", personalDressViewModel2 != null ? personalDressViewModel2.f20757d : null);
                PersonalDressViewModel personalDressViewModel3 = personalDressListFragment.f20729p;
                iVarA.f("device_name", personalDressViewModel3 != null ? personalDressViewModel3.f20756c : null);
                PersonalDressViewModel personalDressViewModel4 = personalDressListFragment.f20729p;
                iVarA.f("product_color", personalDressViewModel4 != null ? String.valueOf(personalDressViewModel4.f20758e) : null);
                iVarA.e(personalDressListFragment);
                String themeId = p02.getThemeId();
                if (themeId != null) {
                    PersonalDressViewModel personalDressViewModel5 = personalDressListFragment.f20729p;
                    C1264t.C(1, personalDressViewModel5 != null ? personalDressViewModel5.f20757d : null, personalDressViewModel5 != null ? personalDressViewModel5.f20755b : null, themeId);
                }
            }
            return l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.PersonalDressListFragment$onViewCreated$3, reason: invalid class name */
    /* JADX INFO: compiled from: PersonalDressListFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements p<PersonalSeriesVO, List<? extends C0529F>, l> {
        @Override // Wb.p
        public final l invoke(PersonalSeriesVO personalSeriesVO, List<? extends C0529F> list) {
            PersonalSeriesVO p02 = personalSeriesVO;
            List<? extends C0529F> p12 = list;
            h.e(p02, "p0");
            h.e(p12, "p1");
            PersonalDressListFragment personalDressListFragment = (PersonalDressListFragment) this.receiver;
            personalDressListFragment.getClass();
            Intent intent = new Intent(personalDressListFragment.getContext(), (Class<?>) PersonalDressSeriesDetailActivity.class);
            intent.putExtra("series_data", p02);
            PersonalDressViewModel personalDressViewModel = personalDressListFragment.f20729p;
            if (personalDressViewModel != null) {
                intent.putExtra("device_mac_info", personalDressViewModel.f20755b);
                intent.putExtra("product_id", personalDressViewModel.f20757d);
                intent.putExtra("device_name", personalDressViewModel.f20756c);
                intent.putExtra("product_color", String.valueOf(personalDressViewModel.f20758e));
            }
            personalDressListFragment.startActivity(intent);
            String identifyId = p02.getIdentifyId();
            if (identifyId != null) {
                PersonalDressViewModel personalDressViewModel2 = personalDressListFragment.f20729p;
                C1264t.C(11, personalDressViewModel2 != null ? personalDressViewModel2.f20757d : null, personalDressViewModel2 != null ? personalDressViewModel2.f20755b : null, identifyId);
            }
            return l.f2618a;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        return inflater.inflate(R.layout.melody_ui_dress_list_fragment, container, false);
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        t tVar;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        if (activity == null) {
            return;
        }
        COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) view.findViewById(R.id.dress_group_recycler_view);
        this.f20730q = cOUIRecyclerView;
        if (cOUIRecyclerView != null) {
            cOUIRecyclerView.setLayoutManager(new PersonalDressListFragment$onViewCreated$1$1(1));
            cOUIRecyclerView.setItemAnimator(null);
        }
        O viewModelStore = activity.getViewModelStore();
        N.b defaultViewModelProviderFactory = activity.getDefaultViewModelProviderFactory();
        d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, activity.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(PersonalDressViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20729p = (PersonalDressViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(2, this, PersonalDressListFragment.class, "onDressItemClick", "onDressItemClick(Lcom/oplus/melody/ui/component/detail/dress/PersonalDressVO;I)V", 0);
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(2, this, PersonalDressListFragment.class, "onGroupItemClick", "onGroupItemClick(Lcom/oplus/melody/ui/component/detail/dress/PersonalSeriesVO;Ljava/util/List;)V", 0);
        PersonalDressViewModel personalDressViewModel = this.f20729p;
        C0524A c0524a = new C0524A(anonymousClass2, anonymousClass3, personalDressViewModel != null ? new P6.d(personalDressViewModel, 7) : null);
        this.f20731r = c0524a;
        COUIRecyclerView cOUIRecyclerView2 = this.f20730q;
        if (cOUIRecyclerView2 != null) {
            cOUIRecyclerView2.setAdapter(c0524a);
        }
        PersonalDressViewModel personalDressViewModel2 = this.f20729p;
        if (personalDressViewModel2 == null || (tVar = (t) personalDressViewModel2.f20765m.getValue()) == null) {
            return;
        }
        tVar.e(getViewLifecycleOwner(), new a(new j(this, 22)));
    }
}
