package com.oplus.melody.ui.component.detail.cleandirty;

import Ca.n;
import D7.C0379m;
import D7.L;
import Ea.C0400i;
import P3.d;
import V8.c;
import V8.e;
import Wb.l;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.i;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.viewpager2.widget.ViewPager2;
import com.coui.appcompat.indicator.COUIPageIndicator;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: CleanDirtyFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0016\u0010 \u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0012H\u0002J\u0006\u0010&\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/oplus/melody/ui/component/detail/cleandirty/CleanDirtyFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/cleandirty/CleanDirtyViewModel;", "mCardView", "Landroid/view/View;", "mViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "mPagerAdapter", "Lcom/oplus/melody/ui/component/detail/cleandirty/CleanDirtyGuidePagesAdapter;", "mPagerIndicator", "Lcom/coui/appcompat/indicator/COUIPageIndicator;", "mAddress", "", "mProduceId", "mColorId", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onProductChanged", "productVO", "Lcom/oplus/melody/ui/component/detail/cleandirty/ProductVO;", "onGuidePagesChanged", "list", "", "Lcom/oplus/melody/ui/component/detail/cleandirty/CleanDirtyGuidePageVO;", "onLoadingStateChanged", "state", "onRetryClick", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CleanDirtyFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CleanDirtyViewModel f20648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f20649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewPager2 f20650c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f20651p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public COUIPageIndicator f20652q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f20653r = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f20654s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f20655t;

    /* JADX INFO: compiled from: CleanDirtyFragment.kt */
    public static final class a extends ViewPager2.e {
        public a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public final void a(int i10) {
            if (CleanDirtyFragment.this.f20652q != null) {
                return;
            }
            h.i("mPagerIndicator");
            throw null;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public final void b(float f9, int i10, int i11) {
            COUIPageIndicator cOUIPageIndicator = CleanDirtyFragment.this.f20652q;
            if (cOUIPageIndicator != null) {
                cOUIPageIndicator.a(f9, i10);
            } else {
                h.i("mPagerIndicator");
                throw null;
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public final void c(int i10) {
            COUIPageIndicator cOUIPageIndicator = CleanDirtyFragment.this.f20652q;
            if (cOUIPageIndicator != null) {
                cOUIPageIndicator.f14199b.f14241x = i10;
            } else {
                h.i("mPagerIndicator");
                throw null;
            }
        }
    }

    /* JADX INFO: compiled from: CleanDirtyFragment.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctionReferenceImpl f20657a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(l lVar) {
            this.f20657a = (FunctionReferenceImpl) lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20657a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [Wb.l, kotlin.jvm.internal.FunctionReferenceImpl] */
        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20657a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.cleandirty.CleanDirtyFragment$onViewCreated$5, reason: invalid class name */
    /* JADX INFO: compiled from: CleanDirtyFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements l<e, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(e eVar) {
            e p02 = eVar;
            h.e(p02, "p0");
            CleanDirtyFragment cleanDirtyFragment = (CleanDirtyFragment) this.receiver;
            cleanDirtyFragment.getClass();
            cleanDirtyFragment.f20654s = p02.getProductId();
            cleanDirtyFragment.f20655t = p02.getColorId();
            A.c("CleanDirtyFragment", new d(cleanDirtyFragment, 13));
            CleanDirtyViewModel cleanDirtyViewModel = cleanDirtyFragment.f20648a;
            if (cleanDirtyViewModel == null) {
                h.i("mViewModel");
                throw null;
            }
            cleanDirtyViewModel.d(cleanDirtyFragment.f20655t, cleanDirtyFragment.f20654s);
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.cleandirty.CleanDirtyFragment$onViewCreated$6, reason: invalid class name */
    /* JADX INFO: compiled from: CleanDirtyFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements l<List<? extends V8.b>, Jb.l> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // Wb.l
        public final Jb.l d(List<? extends V8.b> list) {
            List<? extends V8.b> p02 = list;
            h.e(p02, "p0");
            CleanDirtyFragment cleanDirtyFragment = (CleanDirtyFragment) this.receiver;
            cleanDirtyFragment.getClass();
            A.c("CleanDirtyFragment", new C0400i(2, p02));
            View view = cleanDirtyFragment.f20649b;
            if (view == null) {
                h.i("mCardView");
                throw null;
            }
            view.setVisibility(0);
            ViewPager2 viewPager2 = cleanDirtyFragment.f20650c;
            if (viewPager2 == null) {
                h.i("mViewPager");
                throw null;
            }
            viewPager2.setOffscreenPageLimit(p02.size());
            c cVar = cleanDirtyFragment.f20651p;
            if (cVar == null) {
                h.i("mPagerAdapter");
                throw null;
            }
            cVar.f5411a = p02;
            cVar.notifyDataSetChanged();
            COUIPageIndicator cOUIPageIndicator = cleanDirtyFragment.f20652q;
            if (cOUIPageIndicator != null) {
                cOUIPageIndicator.setDotsCount(p02.size());
                return Jb.l.f2618a;
            }
            h.i("mPagerIndicator");
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.cleandirty.CleanDirtyFragment$onViewCreated$7, reason: invalid class name */
    /* JADX INFO: compiled from: CleanDirtyFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            int iIntValue = num.intValue();
            CleanDirtyFragment cleanDirtyFragment = (CleanDirtyFragment) this.receiver;
            cleanDirtyFragment.getClass();
            A.c("CleanDirtyFragment", new L(iIntValue, 17));
            androidx.fragment.app.f activity = cleanDirtyFragment.getActivity();
            h.c(activity, "null cannot be cast to non-null type com.oplus.melody.ui.component.detail.cleandirty.CleanDirtyActivity");
            ((CleanDirtyActivity) activity).K(iIntValue);
            return Jb.l.f2618a;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        return inflater.inflate(R.layout.melody_ui_fragment_clean_dirty, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        h.c(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        i iVar = (i) activity;
        iVar.y((MelodyCompatToolbar) view.findViewById(R.id.toolbar));
        androidx.appcompat.app.a aVarX = iVar.x();
        if (aVarX != null) {
            aVarX.u(getString(R.string.melody_common_guide_clean_title));
        }
        androidx.appcompat.app.a aVarX2 = iVar.x();
        if (aVarX2 != null) {
            aVarX2.n(true);
        }
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.d(fVarRequireActivity, "requireActivity(...)");
        O viewModelStore = fVarRequireActivity.getViewModelStore();
        N.b defaultViewModelProviderFactory = fVarRequireActivity.getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, fVarRequireActivity.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(CleanDirtyViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20648a = (CleanDirtyViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("device_mac_info")) == null) {
            string = "";
        }
        this.f20653r = string;
        A.c("CleanDirtyFragment", new S7.c(this, 2));
        View viewFindViewById = view.findViewById(R.id.clean_dirty_guide_card);
        h.d(viewFindViewById, "findViewById(...)");
        this.f20649b = viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.clean_dirty_guide_viewpager);
        h.d(viewFindViewById2, "findViewById(...)");
        this.f20650c = (ViewPager2) viewFindViewById2;
        c cVar = new c();
        this.f20651p = cVar;
        ViewPager2 viewPager2 = this.f20650c;
        if (viewPager2 == null) {
            h.i("mViewPager");
            throw null;
        }
        viewPager2.setAdapter(cVar);
        View viewFindViewById3 = view.findViewById(R.id.clean_dirty_guide_page_indicator);
        h.d(viewFindViewById3, "findViewById(...)");
        this.f20652q = (COUIPageIndicator) viewFindViewById3;
        ViewPager2 viewPager22 = this.f20650c;
        if (viewPager22 == null) {
            h.i("mViewPager");
            throw null;
        }
        viewPager22.a(new a());
        COUIPageIndicator cOUIPageIndicator = this.f20652q;
        if (cOUIPageIndicator == null) {
            h.i("mPagerIndicator");
            throw null;
        }
        cOUIPageIndicator.setOnDotClickListener(new n(this, 8));
        C0379m.b(C0379m.g(AbstractC0939b.E().v(this.f20653r), new A6.e(27))).e(getViewLifecycleOwner(), new b(new AnonymousClass5(1, this, CleanDirtyFragment.class, "onProductChanged", "onProductChanged(Lcom/oplus/melody/ui/component/detail/cleandirty/ProductVO;)V", 0)));
        CleanDirtyViewModel cleanDirtyViewModel = this.f20648a;
        if (cleanDirtyViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        cleanDirtyViewModel.f20658b.e(getViewLifecycleOwner(), new b(new AnonymousClass6(1, this, CleanDirtyFragment.class, "onGuidePagesChanged", "onGuidePagesChanged(Ljava/util/List;)V", 0)));
        CleanDirtyViewModel cleanDirtyViewModel2 = this.f20648a;
        if (cleanDirtyViewModel2 != null) {
            cleanDirtyViewModel2.f20659c.e(getViewLifecycleOwner(), new b(new AnonymousClass7(1, this, CleanDirtyFragment.class, "onLoadingStateChanged", "onLoadingStateChanged(I)V", 0)));
        } else {
            h.i("mViewModel");
            throw null;
        }
    }
}
