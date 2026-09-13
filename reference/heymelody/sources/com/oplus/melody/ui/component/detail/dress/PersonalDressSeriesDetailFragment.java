package com.oplus.melody.ui.component.detail.dress;

import A6.b;
import B9.d;
import Ca.m;
import D7.C0379m;
import Ea.E;
import Ea.M;
import F8.c;
import F8.i;
import Jb.l;
import Wb.p;
import a9.C0529F;
import a9.C0533J;
import a9.C0539e;
import a9.RunnableC0526C;
import a9.RunnableC0527D;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.i;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.e0;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.I;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0909o;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import com.oplus.melody.ui.component.detail.dress.PersonalDressSeriesDetailFragment;
import com.oplus.melody.ui.widget.MelodyCompatRotateView;
import com.oplus.melody.ui.widget.MelodyErrorLayout;
import g9.o;
import java.util.Collection;
import java.util.List;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: PersonalDressSeriesDetailFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\"\u001a\u0004\u0018\u00010\u00122\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u000e\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020 J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020(H\u0016J\u0010\u00100\u001a\u00020*2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u0019H\u0002J\u0018\u00104\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u00105\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0012J\u000e\u00106\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0012J\u0018\u00107\u001a\u00020*2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u0019J\u0006\u0010;\u001a\u00020*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/PersonalDressSeriesDetailFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "<init>", "()V", "mBannerIv", "Landroid/widget/ImageView;", "mNameTv", "Landroid/widget/TextView;", "mSummaryTv", "mRecyclerView", "Landroidx/recyclerview/widget/COUIRecyclerView;", "mAdapter", "Lcom/oplus/melody/ui/component/detail/dress/PersonalDressAdapter;", "mGridLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "mErrorLayout", "Lcom/oplus/melody/ui/widget/MelodyErrorLayout;", "mExpandContainer", "Landroid/view/View;", "mExpandIndicator", "Lcom/oplus/melody/ui/widget/MelodyCompatRotateView;", "mExpandTv", "mViewModel", "Lcom/oplus/melody/ui/component/detail/dress/PersonalDressViewModel;", "mActionBarHeight", "", "mTopViewHeight", "mSeries", "Lcom/oplus/melody/ui/component/detail/dress/PersonalSeriesVO;", "mTitleColor", "mToolBarColor", "mBannerWidthHeightRatio", "", "mSpanCount", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setToolBarBackground", "alpha", "onSaveInstanceState", "outState", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "calculateSpanCount", "initView", "initScrollView", "initDressRecyclerView", "onItemClick", "item", "Lcom/oplus/melody/ui/component/detail/dress/PersonalDressVO;", "position", "initData", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PersonalDressSeriesDetailFragment extends c {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f20737A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public PersonalSeriesVO f20738B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f20739C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f20740D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public float f20741E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int f20742F;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f20743p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f20744q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public COUIRecyclerView f20745r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public C0539e f20746s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public GridLayoutManager f20747t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public MelodyErrorLayout f20748u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f20749v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public MelodyCompatRotateView f20750w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f20751x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public PersonalDressViewModel f20752y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f20753z;

    /* JADX INFO: compiled from: PersonalDressSeriesDetailFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f20754a;

        public a(d dVar) {
            this.f20754a = dVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20754a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) throws Throwable {
            this.f20754a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.PersonalDressSeriesDetailFragment$onConfigurationChanged$2, reason: invalid class name */
    /* JADX INFO: compiled from: PersonalDressSeriesDetailFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements p<C0529F, Integer, l> {
        @Override // Wb.p
        public final l invoke(C0529F c0529f, Integer num) {
            num.intValue();
            ((PersonalDressSeriesDetailFragment) this.receiver).s(c0529f);
            return l.f2618a;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        h.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int iR = r();
        A.c("PersonalDressSeriesDetailFragment", new M(this, iR, 5));
        if (this.f20742F != iR) {
            this.f20742F = iR;
            GridLayoutManager gridLayoutManager = this.f20747t;
            if (gridLayoutManager == null) {
                h.i("mGridLayoutManager");
                throw null;
            }
            gridLayoutManager.N1(iR);
            COUIRecyclerView cOUIRecyclerView = this.f20745r;
            if (cOUIRecyclerView == null) {
                h.i("mRecyclerView");
                throw null;
            }
            int i10 = this.f20742F;
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.melody_ui_personal_dress_item_row_gap);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.melody_ui_personal_dress_item_column_gap);
            if (cOUIRecyclerView.getItemDecorationCount() > 0) {
                int itemDecorationCount = cOUIRecyclerView.getItemDecorationCount();
                for (int i11 = 0; i11 < itemDecorationCount; i11++) {
                    cOUIRecyclerView.removeItemDecorationAt(i11);
                }
            }
            cOUIRecyclerView.addItemDecoration(new m(dimensionPixelOffset, i10, dimensionPixelOffset2));
            C0539e c0539e = this.f20746s;
            if (c0539e == null) {
                h.i("mAdapter");
                throw null;
            }
            Collection collection = c0539e.f12264a.f12028f;
            h.d(collection, "getCurrentList(...)");
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(2, this, PersonalDressSeriesDetailFragment.class, "onItemClick", "onItemClick(Lcom/oplus/melody/ui/component/detail/dress/PersonalDressVO;I)V", 0);
            PersonalDressViewModel personalDressViewModel = this.f20752y;
            if (personalDressViewModel == null) {
                h.i("mViewModel");
                throw null;
            }
            C0539e c0539e2 = new C0539e(anonymousClass2, new P6.d(personalDressViewModel, 7));
            this.f20746s = c0539e2;
            c0539e2.d(collection);
            COUIRecyclerView cOUIRecyclerView2 = this.f20745r;
            if (cOUIRecyclerView2 == null) {
                h.i("mRecyclerView");
                throw null;
            }
            C0539e c0539e3 = this.f20746s;
            if (c0539e3 == null) {
                h.i("mAdapter");
                throw null;
            }
            cOUIRecyclerView2.setAdapter(c0539e3);
            ImageView imageView = this.f20743p;
            if (imageView == null) {
                h.i("mBannerIv");
                throw null;
            }
            imageView.post(new RunnableC0526C(this, 1));
            TextView textView = this.f20744q;
            if (textView == null) {
                h.i("mSummaryTv");
                throw null;
            }
            textView.post(new RunnableC0527D(this, 1));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.melody_ui_fragment_personal_dress_series_detail, container, false);
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.d(fVarRequireActivity, "requireActivity(...)");
        O viewModelStore = fVarRequireActivity.getViewModelStore();
        N.b defaultViewModelProviderFactory = fVarRequireActivity.getDefaultViewModelProviderFactory();
        X.d dVarC = b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, fVarRequireActivity.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(PersonalDressViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20752y = (PersonalDressViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f20738B = (PersonalSeriesVO) C0914u.g(getArguments(), "series_data", PersonalSeriesVO.class);
        this.f20739C = o.g(getContext(), R.attr.couiColorPrimaryNeutral);
        this.f20740D = getResources().getColor(R.color.melody_ui_common_window_background_color, null);
        h.b(viewInflate);
        View viewFindViewById = viewInflate.findViewById(R.id.melody_ui_error_layout);
        h.d(viewFindViewById, "findViewById(...)");
        MelodyErrorLayout melodyErrorLayout = (MelodyErrorLayout) viewFindViewById;
        this.f20748u = melodyErrorLayout;
        melodyErrorLayout.setVisibility(0);
        MelodyErrorLayout melodyErrorLayout2 = this.f20748u;
        if (melodyErrorLayout2 == null) {
            h.i("mErrorLayout");
            throw null;
        }
        melodyErrorLayout2.b();
        TypedValue typedValue = new TypedValue();
        getResources().getValue(R.dimen.melody_ui_personal_dress_series_item_width_height_ratio, typedValue, true);
        this.f20741E = typedValue.getFloat();
        View viewFindViewById2 = viewInflate.findViewById(R.id.detail_series_banner);
        h.d(viewFindViewById2, "findViewById(...)");
        this.f20743p = (ImageView) viewFindViewById2;
        if (savedInstanceState != null) {
            this.f20737A = savedInstanceState.getInt("state_banner_height");
            this.f20753z = savedInstanceState.getInt("state_action_bar_height");
        }
        ImageView imageView = this.f20743p;
        if (imageView == null) {
            h.i("mBannerIv");
            throw null;
        }
        imageView.post(new RunnableC0526C(this, 0));
        RequestManager requestManagerWith = Glide.with(this);
        PersonalSeriesVO personalSeriesVO = this.f20738B;
        RequestBuilder requestBuilderPlaceholder = requestManagerWith.load(personalSeriesVO != null ? personalSeriesVO.getBannerImgUrl() : null).placeholder(R.drawable.melody_ui_personal_dress_list_default);
        ImageView imageView2 = this.f20743p;
        if (imageView2 == null) {
            h.i("mBannerIv");
            throw null;
        }
        requestBuilderPlaceholder.into(imageView2);
        View viewFindViewById3 = viewInflate.findViewById(R.id.detail_series_name);
        h.d(viewFindViewById3, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById3;
        PersonalSeriesVO personalSeriesVO2 = this.f20738B;
        textView.setText(personalSeriesVO2 != null ? personalSeriesVO2.getSeriesName() : null);
        View viewFindViewById4 = viewInflate.findViewById(R.id.detail_series_summary);
        h.d(viewFindViewById4, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById4;
        this.f20744q = textView2;
        PersonalSeriesVO personalSeriesVO3 = this.f20738B;
        textView2.setText(personalSeriesVO3 != null ? personalSeriesVO3.getSummary() : null);
        if (savedInstanceState != null) {
            TextView textView3 = this.f20744q;
            if (textView3 == null) {
                h.i("mSummaryTv");
                throw null;
            }
            textView3.setMaxLines(savedInstanceState.getInt("state_summary_max_lines"));
        }
        View viewFindViewById5 = viewInflate.findViewById(R.id.detail_series_summary_fold);
        h.d(viewFindViewById5, "findViewById(...)");
        this.f20749v = viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.detail_series_summary_fold_indicator);
        h.d(viewFindViewById6, "findViewById(...)");
        this.f20750w = (MelodyCompatRotateView) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.detail_series_summary_fold_txt);
        h.d(viewFindViewById7, "findViewById(...)");
        this.f20751x = (TextView) viewFindViewById7;
        TextView textView4 = this.f20744q;
        if (textView4 == null) {
            h.i("mSummaryTv");
            throw null;
        }
        textView4.post(new RunnableC0527D(this, 0));
        View view = this.f20749v;
        if (view == null) {
            h.i("mExpandContainer");
            throw null;
        }
        view.setOnClickListener(new E(this, 11));
        View viewFindViewById8 = viewInflate.findViewById(R.id.detail_series_scroll);
        h.d(viewFindViewById8, "findViewById(...)");
        ((NestedScrollView) viewFindViewById8).setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: a9.E
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view2, int i10, int i11, int i12, int i13) {
                androidx.appcompat.app.a aVarX;
                kotlin.jvm.internal.h.e(view2, "view");
                PersonalDressSeriesDetailFragment personalDressSeriesDetailFragment = this.f7096a;
                if (personalDressSeriesDetailFragment.f20753z <= 0) {
                    androidx.fragment.app.f activity = personalDressSeriesDetailFragment.getActivity();
                    androidx.appcompat.app.i iVar = activity instanceof androidx.appcompat.app.i ? (androidx.appcompat.app.i) activity : null;
                    if (iVar != null && (aVarX = iVar.x()) != null) {
                        personalDressSeriesDetailFragment.f20753z = aVarX.e();
                    }
                }
                int i14 = personalDressSeriesDetailFragment.f20737A;
                int i15 = personalDressSeriesDetailFragment.f20753z;
                int i16 = i14 - i15;
                if (i11 >= i16 && i11 <= i14) {
                    personalDressSeriesDetailFragment.t((i11 - i16) / i15);
                } else if (i11 < i16) {
                    personalDressSeriesDetailFragment.t(0.0f);
                } else if (i11 > i14) {
                    personalDressSeriesDetailFragment.t(1.0f);
                }
            }
        });
        this.f20742F = r();
        getContext();
        this.f20747t = new GridLayoutManager(this.f20742F);
        View viewFindViewById9 = viewInflate.findViewById(R.id.detail_series_dress_list);
        h.d(viewFindViewById9, "findViewById(...)");
        COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) viewFindViewById9;
        this.f20745r = cOUIRecyclerView;
        cOUIRecyclerView.setVisibility(8);
        COUIRecyclerView cOUIRecyclerView2 = this.f20745r;
        if (cOUIRecyclerView2 == null) {
            h.i("mRecyclerView");
            throw null;
        }
        GridLayoutManager gridLayoutManager = this.f20747t;
        if (gridLayoutManager == null) {
            h.i("mGridLayoutManager");
            throw null;
        }
        cOUIRecyclerView2.setLayoutManager(gridLayoutManager);
        COUIRecyclerView cOUIRecyclerView3 = this.f20745r;
        if (cOUIRecyclerView3 == null) {
            h.i("mRecyclerView");
            throw null;
        }
        int i10 = this.f20742F;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.melody_ui_personal_dress_item_row_gap);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.melody_ui_personal_dress_item_column_gap);
        if (cOUIRecyclerView3.getItemDecorationCount() > 0) {
            int itemDecorationCount = cOUIRecyclerView3.getItemDecorationCount();
            for (int i11 = 0; i11 < itemDecorationCount; i11++) {
                cOUIRecyclerView3.removeItemDecorationAt(i11);
            }
        }
        cOUIRecyclerView3.addItemDecoration(new m(dimensionPixelOffset, i10, dimensionPixelOffset2));
        COUIRecyclerView cOUIRecyclerView4 = this.f20745r;
        if (cOUIRecyclerView4 == null) {
            h.i("mRecyclerView");
            throw null;
        }
        RecyclerView.m itemAnimator = cOUIRecyclerView4.getItemAnimator();
        if (itemAnimator != null ? itemAnimator instanceof I : true) {
            COUIRecyclerView cOUIRecyclerView5 = this.f20745r;
            if (cOUIRecyclerView5 == null) {
                h.i("mRecyclerView");
                throw null;
            }
            RecyclerView.m itemAnimator2 = cOUIRecyclerView5.getItemAnimator();
            h.c(itemAnimator2, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
            ((I) itemAnimator2).f11824g = false;
        }
        COUIRecyclerView cOUIRecyclerView6 = this.f20745r;
        if (cOUIRecyclerView6 == null) {
            h.i("mRecyclerView");
            throw null;
        }
        cOUIRecyclerView6.setItemAnimator(null);
        PersonalDressSeriesDetailFragment$initDressRecyclerView$1 personalDressSeriesDetailFragment$initDressRecyclerView$1 = new PersonalDressSeriesDetailFragment$initDressRecyclerView$1(2, this, PersonalDressSeriesDetailFragment.class, "onItemClick", "onItemClick(Lcom/oplus/melody/ui/component/detail/dress/PersonalDressVO;I)V", 0);
        PersonalDressViewModel personalDressViewModel = this.f20752y;
        if (personalDressViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        C0539e c0539e = new C0539e(personalDressSeriesDetailFragment$initDressRecyclerView$1, new P6.d(personalDressViewModel, 7));
        this.f20746s = c0539e;
        COUIRecyclerView cOUIRecyclerView7 = this.f20745r;
        if (cOUIRecyclerView7 == null) {
            h.i("mRecyclerView");
            throw null;
        }
        cOUIRecyclerView7.setAdapter(c0539e);
        PersonalSeriesVO personalSeriesVO4 = this.f20738B;
        if (personalSeriesVO4 == null) {
            return viewInflate;
        }
        int id = personalSeriesVO4.getId();
        PersonalDressViewModel personalDressViewModel2 = this.f20752y;
        if (personalDressViewModel2 != null) {
            C0379m.g((t) personalDressViewModel2.f20765m.getValue(), new C0533J(id, 0)).e(getViewLifecycleOwner(), new a(new d(this, 25)));
            return viewInflate;
        }
        h.i("mViewModel");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle outState) {
        h.e(outState, "outState");
        super.onSaveInstanceState(outState);
        TextView textView = this.f20744q;
        if (textView == null) {
            h.i("mSummaryTv");
            throw null;
        }
        outState.putInt("state_summary_max_lines", textView.getMaxLines());
        outState.putInt("state_banner_height", this.f20737A);
        outState.putInt("state_action_bar_height", this.f20753z);
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.c(fVarRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        androidx.appcompat.app.a aVarX = ((i) fVarRequireActivity).x();
        if (aVarX != null) {
            aVarX.n(true);
        }
        if (aVarX != null) {
            aVarX.r(true);
        }
        if (aVarX != null) {
            PersonalSeriesVO personalSeriesVO = this.f20738B;
            String string = null;
            if (TextUtils.isEmpty(personalSeriesVO != null ? personalSeriesVO.getSeriesName() : null)) {
                string = getString(R.string.melody_ui_peronalpress_title);
            } else {
                PersonalSeriesVO personalSeriesVO2 = this.f20738B;
                if (personalSeriesVO2 != null) {
                    string = personalSeriesVO2.getSeriesName();
                }
            }
            aVarX.u(string);
        }
        t(0.0f);
    }

    public final int r() {
        float fE = C0909o.e(getActivity()) / getResources().getDimensionPixelOffset(R.dimen.melody_ui_personal_dress_item_recommend_width);
        if (Float.isNaN(fE)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        int iRound = Math.round(fE);
        if (iRound < 2) {
            return 2;
        }
        return iRound;
    }

    public final void s(C0529F c0529f) {
        PersonalDressDTO.PersonalDressData dressData;
        if (c0529f == null || (dressData = c0529f.getDressData()) == null) {
            return;
        }
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.c(fVarRequireActivity, "null cannot be cast to non-null type com.oplus.melody.ui.component.detail.dress.PersonalDressSeriesDetailActivity");
        PersonalDressSeriesDetailActivity personalDressSeriesDetailActivity = (PersonalDressSeriesDetailActivity) fVarRequireActivity;
        E8.a.w().getClass();
        Jb.b<List<Wb.l<String, Class<?>>>> bVar = F8.i.f1668g;
        F8.i iVarA = i.a.a("/ui/dress/detail");
        iVarA.f1670b.putExtra("dress_data", dressData);
        PersonalDressViewModel personalDressViewModel = personalDressSeriesDetailActivity.f20735V;
        iVarA.f("device_mac_info", personalDressViewModel != null ? personalDressViewModel.f20755b : null);
        PersonalDressViewModel personalDressViewModel2 = personalDressSeriesDetailActivity.f20735V;
        iVarA.f("product_id", personalDressViewModel2 != null ? personalDressViewModel2.f20757d : null);
        PersonalDressViewModel personalDressViewModel3 = personalDressSeriesDetailActivity.f20735V;
        iVarA.f("device_name", personalDressViewModel3 != null ? personalDressViewModel3.f20756c : null);
        PersonalDressViewModel personalDressViewModel4 = personalDressSeriesDetailActivity.f20735V;
        iVarA.f("product_color", String.valueOf(personalDressViewModel4 != null ? Integer.valueOf(personalDressViewModel4.f20758e) : null));
        iVarA.b(personalDressSeriesDetailActivity);
        String themeId = c0529f.getThemeId();
        if (themeId != null) {
            PersonalDressViewModel personalDressViewModel5 = this.f20752y;
            if (personalDressViewModel5 != null) {
                C1264t.C(1, personalDressViewModel5.f20757d, personalDressViewModel5.f20755b, themeId);
            } else {
                h.i("mViewModel");
                throw null;
            }
        }
    }

    public final void t(float f9) {
        Window window;
        View decorView;
        e0 e0VarI;
        androidx.appcompat.app.a aVarX;
        androidx.fragment.app.f activity = getActivity();
        PersonalDressSeriesDetailActivity personalDressSeriesDetailActivity = activity instanceof PersonalDressSeriesDetailActivity ? (PersonalDressSeriesDetailActivity) activity : null;
        if (personalDressSeriesDetailActivity != null) {
            Toolbar toolbar = personalDressSeriesDetailActivity.f20734U;
            if (toolbar == null) {
                h.i("toolbar");
                throw null;
            }
            toolbar.setBackgroundColor(E.b.h(this.f20740D, (int) (255 * f9)));
        }
        if (personalDressSeriesDetailActivity != null) {
            Toolbar toolbar2 = personalDressSeriesDetailActivity.f20734U;
            if (toolbar2 == null) {
                h.i("toolbar");
                throw null;
            }
            toolbar2.setTitleTextColor(E.b.h(this.f20739C, (int) (255 * f9)));
        }
        if (personalDressSeriesDetailActivity != null && (aVarX = personalDressSeriesDetailActivity.x()) != null) {
            aVarX.q(((double) f9) > 0.5d ? R.drawable.coui_back_arrow_normal : R.drawable.melody_ui_dress_series_detail_toolbar_back_arrow_white);
        }
        if (personalDressSeriesDetailActivity == null || (window = personalDressSeriesDetailActivity.getWindow()) == null || (decorView = window.getDecorView()) == null || (e0VarI = androidx.core.view.M.i(decorView)) == null) {
            return;
        }
        e0VarI.a(((double) f9) > 0.5d);
    }
}
