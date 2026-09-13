package com.oplus.melody.ui.component.detail.honorwall;

import A6.b;
import Wb.l;
import X.d;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.i;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.C;
import androidx.core.view.e0;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import com.heytap.headset.R;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.common.util.C0909o;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import w9.C1606b;

/* JADX INFO: compiled from: HonorWallFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/oplus/melody/ui/component/detail/honorwall/HonorWallFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/honorwall/HonorWallViewModel;", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "mNightToolbar", "mContainer", "Landroid/view/View;", "mBannerTv", "Landroid/widget/TextView;", "mBannerSummaryTv", "mProductIv", "Landroid/widget/ImageView;", "mProductNameTv", "mContributorsDivide", "mContributorsTv", "mShowToolbar", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showToolbar", "toolbar", "onHonorWallDataChanged", ClientDataEntity.COL_DATA, "Lcom/oplus/melody/ui/component/detail/honorwall/HonorWallDataVO;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HonorWallFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Toolbar f21100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Toolbar f21101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f21102c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f21103p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f21104q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f21105r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f21106s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f21107t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f21108u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Toolbar f21109v;

    /* JADX INFO: compiled from: HonorWallFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21110a;

        public a(l lVar) {
            this.f21110a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21110a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21110a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.honorwall.HonorWallFragment$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorWallFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements l<C1606b, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(C1606b c1606b) {
            C1606b p02 = c1606b;
            h.e(p02, "p0");
            HonorWallFragment honorWallFragment = (HonorWallFragment) this.receiver;
            View view = honorWallFragment.f21102c;
            if (view == null) {
                h.i("mContainer");
                throw null;
            }
            view.setVisibility(0);
            androidx.fragment.app.f activity = honorWallFragment.getActivity();
            Window window = activity != null ? activity.getWindow() : null;
            if (window != null) {
                window.setBackgroundDrawable(Drawable.createFromPath(p02.f28637f));
            }
            if (p02.f28638g) {
                if (window != null) {
                    C c6 = new C(window.getDecorView());
                    int i10 = Build.VERSION.SDK_INT;
                    (i10 >= 35 ? new e0.f(window, c6) : i10 >= 30 ? new e0.d(window, c6) : i10 >= 26 ? new e0.c(window, c6) : new e0.b(window, c6)).d(false);
                }
                Toolbar toolbar = honorWallFragment.f21101b;
                if (toolbar == null) {
                    h.i("mNightToolbar");
                    throw null;
                }
                honorWallFragment.o(toolbar);
                androidx.fragment.app.f activity2 = honorWallFragment.getActivity();
                if (activity2 != null) {
                    int color = activity2.getColor(R.color.coui_color_primary_neutral_dark);
                    TextView textView = honorWallFragment.f21103p;
                    if (textView == null) {
                        h.i("mBannerTv");
                        throw null;
                    }
                    textView.setTextColor(color);
                    TextView textView2 = honorWallFragment.f21104q;
                    if (textView2 == null) {
                        h.i("mBannerSummaryTv");
                        throw null;
                    }
                    textView2.setTextColor(color);
                    TextView textView3 = honorWallFragment.f21106s;
                    if (textView3 == null) {
                        h.i("mProductNameTv");
                        throw null;
                    }
                    textView3.setTextColor(color);
                    TextView textView4 = honorWallFragment.f21108u;
                    if (textView4 == null) {
                        h.i("mContributorsTv");
                        throw null;
                    }
                    textView4.setTextColor(color);
                }
            }
            TextView textView5 = honorWallFragment.f21103p;
            if (textView5 == null) {
                h.i("mBannerTv");
                throw null;
            }
            textView5.setText(p02.f28632a);
            TextView textView6 = honorWallFragment.f21104q;
            if (textView6 == null) {
                h.i("mBannerSummaryTv");
                throw null;
            }
            textView6.setText(p02.f28633b);
            ImageView imageView = honorWallFragment.f21105r;
            if (imageView == null) {
                h.i("mProductIv");
                throw null;
            }
            imageView.setImageDrawable(Drawable.createFromPath(p02.f28635d));
            TextView textView7 = honorWallFragment.f21106s;
            if (textView7 == null) {
                h.i("mProductNameTv");
                throw null;
            }
            textView7.setText(p02.f28634c);
            View view2 = honorWallFragment.f21107t;
            if (view2 == null) {
                h.i("mContributorsDivide");
                throw null;
            }
            view2.setBackground(Drawable.createFromPath(p02.f28636e));
            TextView textView8 = honorWallFragment.f21108u;
            if (textView8 != null) {
                textView8.setText(p02.h);
                return Jb.l.f2618a;
            }
            h.i("mContributorsTv");
            throw null;
        }
    }

    public final void o(Toolbar toolbar) {
        if (h.a(toolbar, this.f21109v)) {
            return;
        }
        Toolbar toolbar2 = this.f21109v;
        if (toolbar2 != null) {
            toolbar2.setVisibility(8);
        }
        toolbar.setVisibility(0);
        this.f21109v = toolbar;
        androidx.fragment.app.f activity = getActivity();
        h.c(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        i iVar = (i) activity;
        iVar.y(toolbar);
        androidx.appcompat.app.a aVarX = iVar.x();
        if (aVarX != null) {
            aVarX.n(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        return inflater.inflate(R.layout.melody_ui_fragment_honor_wall, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        androidx.fragment.app.f activity = getActivity();
        if (activity == null) {
            return true;
        }
        activity.finish();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        View viewFindViewById = view.findViewById(R.id.toolbar);
        h.d(viewFindViewById, "findViewById(...)");
        Toolbar toolbar = (Toolbar) viewFindViewById;
        this.f21100a = toolbar;
        toolbar.setTitle(R.string.melody_ui_honor_wall_title);
        View viewFindViewById2 = view.findViewById(R.id.night_toolbar);
        h.d(viewFindViewById2, "findViewById(...)");
        Toolbar toolbar2 = (Toolbar) viewFindViewById2;
        this.f21101b = toolbar2;
        toolbar2.setTitle(R.string.melody_ui_honor_wall_title);
        Toolbar toolbar3 = this.f21100a;
        if (toolbar3 == null) {
            h.i("mToolbar");
            throw null;
        }
        o(toolbar3);
        View viewFindViewById3 = view.findViewById(R.id.honor_wall_data_container);
        h.d(viewFindViewById3, "findViewById(...)");
        this.f21102c = viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.honor_wall_banner);
        h.d(viewFindViewById4, "findViewById(...)");
        this.f21103p = (TextView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.honor_wall_banner_summary);
        h.d(viewFindViewById5, "findViewById(...)");
        this.f21104q = (TextView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.honor_wall_product_img);
        h.d(viewFindViewById6, "findViewById(...)");
        this.f21105r = (ImageView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.honor_wall_product_name);
        h.d(viewFindViewById7, "findViewById(...)");
        this.f21106s = (TextView) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.honor_wall_contributors_divide);
        h.d(viewFindViewById8, "findViewById(...)");
        this.f21107t = viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.honor_wall_contributors);
        h.d(viewFindViewById9, "findViewById(...)");
        this.f21108u = (TextView) viewFindViewById9;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.melody_ui_honor_wall_content_max_width);
        if (C0909o.e(getActivity()) > dimensionPixelOffset) {
            View view2 = this.f21102c;
            if (view2 == null) {
                h.i("mContainer");
                throw null;
            }
            view2.getLayoutParams().width = dimensionPixelOffset;
        }
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.d(fVarRequireActivity, "requireActivity(...)");
        O viewModelStore = fVarRequireActivity.getViewModelStore();
        N.b defaultViewModelProviderFactory = fVarRequireActivity.getDefaultViewModelProviderFactory();
        d dVarC = b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, fVarRequireActivity.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(HonorWallViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        HonorWallViewModel honorWallViewModel = (HonorWallViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        honorWallViewModel.f21112c.e(getViewLifecycleOwner(), new a(new AnonymousClass1(1, this, HonorWallFragment.class, "onHonorWallDataChanged", "onHonorWallDataChanged(Lcom/oplus/melody/ui/component/detail/honorwall/HonorWallDataVO;)V", 0)));
    }
}
