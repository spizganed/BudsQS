package com.oplus.melody.ui.component.control.guide;

import E9.o;
import Ea.E;
import I8.D;
import Wb.l;
import X.d;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.i;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: GuideEarWearFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/oplus/melody/ui/component/control/guide/GuideEarWearFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/control/guide/EarDetectViewModel;", "mImageView", "Landroid/widget/ImageView;", "mTitleTv", "Landroid/widget/TextView;", "mSummaryTv", "mVideoBtn", "mNextBtn", "Landroid/widget/Button;", "mAddress", "", "mDeviceName", "mProductId", "mColorId", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onWearGuideChanged", "vo", "Lcom/oplus/melody/ui/component/control/guide/TextImageGuideVO;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GuideEarWearFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EarDetectViewModel f20534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f20535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f20536c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f20537p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f20538q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Button f20539r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f20540s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f20541t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f20542u = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f20543v = "";

    /* JADX INFO: compiled from: GuideEarWearFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20544a;

        public a(l lVar) {
            this.f20544a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20544a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20544a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.control.guide.GuideEarWearFragment$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuideEarWearFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements l<D, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(D d10) {
            D p02 = d10;
            h.e(p02, "p0");
            GuideEarWearFragment guideEarWearFragment = (GuideEarWearFragment) this.receiver;
            TextView textView = guideEarWearFragment.f20536c;
            if (textView == null) {
                h.i("mTitleTv");
                throw null;
            }
            textView.setText(p02.getMTitle());
            TextView textView2 = guideEarWearFragment.f20537p;
            if (textView2 == null) {
                h.i("mSummaryTv");
                throw null;
            }
            textView2.setText(p02.getMSummary());
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                h.i("context");
                throw null;
            }
            RequestBuilder requestBuilderSkipMemoryCache = Glide.with(heyMelodyApplication).load(p02.getMImage()).skipMemoryCache(true);
            ImageView imageView = guideEarWearFragment.f20535b;
            if (imageView != null) {
                requestBuilderSkipMemoryCache.into(imageView);
                return Jb.l.f2618a;
            }
            h.i("mImageView");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        return inflater.inflate(R.layout.melody_ui_control_guide_ear_wear, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        String string2;
        String string3;
        WhitelistConfigDTO.Function function;
        String string4;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        Bundle arguments = getArguments();
        String str = "";
        if (arguments == null || (string = arguments.getString("device_mac_info")) == null) {
            string = "";
        }
        this.f20540s = string;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string2 = arguments2.getString("device_name")) == null) {
            string2 = "";
        }
        this.f20541t = string2;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (string3 = arguments3.getString("product_id")) == null) {
            string3 = "";
        }
        this.f20542u = string3;
        Bundle arguments4 = getArguments();
        if (arguments4 != null && (string4 = arguments4.getString("product_color")) != null) {
            str = string4;
        }
        this.f20543v = str;
        View viewFindViewById = view.findViewById(R.id.wear_guide_image);
        h.d(viewFindViewById, "findViewById(...)");
        this.f20535b = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.wear_guide_title);
        h.d(viewFindViewById2, "findViewById(...)");
        this.f20536c = (TextView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.wear_guide_summary);
        h.d(viewFindViewById3, "findViewById(...)");
        this.f20537p = (TextView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.wear_guide_next);
        h.d(viewFindViewById4, "findViewById(...)");
        this.f20539r = (Button) viewFindViewById4;
        androidx.fragment.app.f activity = getActivity();
        h.c(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        i iVar = (i) activity;
        O viewModelStore = iVar.getViewModelStore();
        N.b defaultViewModelProviderFactory = iVar.getDefaultViewModelProviderFactory();
        d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, iVar.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(EarDetectViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        EarDetectViewModel earDetectViewModel = (EarDetectViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f20534a = earDetectViewModel;
        earDetectViewModel.f20504c.e(getViewLifecycleOwner(), new a(new AnonymousClass1(1, this, GuideEarWearFragment.class, "onWearGuideChanged", "onWearGuideChanged(Lcom/oplus/melody/ui/component/control/guide/TextImageGuideVO;)V", 0)));
        Button button = this.f20539r;
        if (button == null) {
            h.i("mNextBtn");
            throw null;
        }
        button.setOnClickListener(new E(this, 2));
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(this.f20542u, this.f20541t);
        if (!Y.e((whitelistConfigDTOC == null || (function = whitelistConfigDTOC.getFunction()) == null) ? 0 : function.getWearingVideoTutorial(), false)) {
            TextView textView = this.f20538q;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            } else {
                h.i("mVideoBtn");
                throw null;
            }
        }
        View viewFindViewById5 = view.findViewById(R.id.video_tutorial_title);
        h.d(viewFindViewById5, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById5;
        this.f20538q = textView2;
        textView2.setVisibility(0);
        TextView textView3 = this.f20538q;
        if (textView3 != null) {
            textView3.setOnClickListener(new o(this, 4));
        } else {
            h.i("mVideoBtn");
            throw null;
        }
    }
}
