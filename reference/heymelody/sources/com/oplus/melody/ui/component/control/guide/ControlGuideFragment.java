package com.oplus.melody.ui.component.control.guide;

import A9.k;
import D7.C0379m;
import D7.o0;
import E9.o;
import E9.t;
import Ea.C0404m;
import Ea.K;
import F8.i;
import G7.e;
import I8.A;
import I8.C0425a;
import I8.DialogInterfaceOnClickListenerC0428d;
import J8.g;
import Wb.l;
import X.d;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.app.i;
import androidx.fragment.app.f;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.viewpager2.widget.ViewPager2;
import c.s;
import com.heytap.headset.R;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.S;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.UserInteractionDTO;
import com.oplus.melody.ui.component.control.guide.ControlGuideFragment;
import com.oplus.melody.ui.component.control.guide.ControlGuideViewModel;
import com.oplus.melody.ui.widget.MelodyAnimationLayout;
import com.oplus.melody.ui.widget.MelodyCompatTextView;
import h8.AbstractC1094a;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: ControlGuideFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 b2\u00020\u0001:\u0002bcB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005H\u0016J\u0012\u0010/\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0018\u00102\u001a\u00020-2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020-H\u0002J\u0012\u0010;\u001a\u00020-2\b\u0010<\u001a\u0004\u0018\u00010\u000fH\u0002J\u0016\u0010=\u001a\u00020-2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?H\u0002J\u0010\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020CH\u0002J(\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020E2\u0006\u0010H\u001a\u00020E2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020EH\u0002J&\u0010K\u001a\u0004\u0018\u00010L2\u0006\u00105\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010O2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001a\u0010P\u001a\u00020-2\u0006\u0010Q\u001a\u00020L2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u0010R\u001a\u00020-H\u0016J\b\u0010S\u001a\u00020-H\u0016J\b\u0010T\u001a\u00020-H\u0002J\b\u0010U\u001a\u00020-H\u0002J\b\u0010V\u001a\u00020-H\u0016J\u0006\u0010W\u001a\u00020-J\u001a\u0010X\u001a\u0004\u0018\u00010$2\u0006\u0010Y\u001a\u00020E2\b\b\u0002\u0010Z\u001a\u00020[J\u0010\u0010\\\u001a\u00020E2\u0006\u0010Q\u001a\u00020LH\u0002J\b\u0010]\u001a\u00020-H\u0002J\b\u0010^\u001a\u00020-H\u0002J\u0006\u0010_\u001a\u00020-R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tR\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/oplus/melody/ui/component/control/guide/ControlGuideFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "<init>", "()V", "mContext", "Landroid/content/Context;", "mViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "mPageAdapter", "Lcom/oplus/melody/ui/component/control/guide/ControlGuideFragment$PageAdapter;", "mPageIndicator", "Lcom/oplus/melody/ui/widget/MelodyCompatTextView;", "mControlGuideVM", "Lcom/oplus/melody/ui/component/control/guide/ControlGuideViewModel;", "mControlGuideConfigVO", "Lcom/oplus/melody/ui/component/control/guide/ControlGuideConfigVO;", "mControlGuideSoundStatus", "Lcom/oplus/melody/ui/component/control/guide/state/ControlGuideSoundStatus;", "mGuidePageStatus", "Lcom/oplus/melody/ui/component/control/guide/state/ControlGuidePageStatus;", "mDisconnectDialog", "Landroidx/appcompat/app/AlertDialog;", "mContinueDialog", "mExitDialog", "mDeviceName", "", "mAddress", "mColorId", "mProductId", "mFrom", "mIsFromGuideEntranceFragment", "", "mIsTutorialGuide", "mIsBackPressed", "mIsConnected", "mLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getMLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "mIsGuideMode", "mWhitelistConfig", "Lcom/oplus/melody/common/data/WhitelistConfigDTO;", "mWaitingRetry", "mHasPairDeviceGuide", "onAttach", "", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "navigateAfterControlGuideFinished", "onConfigChanged", "controlGuideConfigVO", "setDefaultKeyFunction", "guidePageVO", "", "Lcom/oplus/melody/ui/component/control/guide/ControlGuidePageVO;", "onCommandInvoked", "command", "Lcom/oplus/melody/model/repository/earphone/UserInteractionDTO;", "isCommandRight", "", "requiredCommand", "requiredDeviceType", "requiredButton", "onConnectionStatusChange", ClientDataEntity.COL_STATUS, "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "enterControlMode", "exitControlMode", "onDestroy", "initView", "recalculate", "position", "positionOffset", "", "getMeasuredViewHeightFor", "showContinueDialog", "showGuideExitDialog", "setToolBar", "mCheckAliveRunnable", "Ljava/lang/Runnable;", "Companion", "PageAdapter", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ControlGuideFragment extends F8.c {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public String f20467A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public String f20468B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public String f20469C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public String f20470D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public boolean f20471E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public boolean f20472F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f20473G;
    public boolean H;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public WhitelistConfigDTO f20475J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public boolean f20476K;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public f f20478p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewPager2 f20479q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a f20480r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public MelodyCompatTextView f20481s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ControlGuideViewModel f20482t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public g f20483u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public J8.c f20484v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public androidx.appcompat.app.f f20485w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public androidx.appcompat.app.f f20486x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public androidx.appcompat.app.f f20487y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f20488z;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f20474I = true;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public final t f20477L = new t(this, 7);

    /* JADX INFO: compiled from: ControlGuideFragment.kt */
    public final class a extends e<A> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f20489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ControlGuideFragment f20490c;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(ControlGuideFragment controlGuideFragment) {
            List items = Collections.EMPTY_LIST;
            h.e(items, "items");
            this.f20490c = controlGuideFragment;
            super(items);
        }

        @Override // G7.e
        public final void c(e.a aVar, A a3, int i10) {
            WhitelistConfigDTO.Function function;
            A a10 = a3;
            MelodyAnimationLayout melodyAnimationLayout = aVar != null ? (MelodyAnimationLayout) aVar.a(R.id.guide_control_device) : null;
            h.b(melodyAnimationLayout);
            TextView textView = aVar != null ? (TextView) aVar.a(R.id.control_guide_des_title) : null;
            TextView textView2 = aVar != null ? (TextView) aVar.a(R.id.control_guide_des_content) : null;
            TextView textView3 = aVar != null ? (TextView) aVar.a(R.id.video_tutorial_title) : null;
            View viewA = aVar != null ? aVar.a(R.id.melody_ui_control_guide_success_view) : null;
            ControlGuideFragment controlGuideFragment = this.f20490c;
            WhitelistConfigDTO whitelistConfigDTO = controlGuideFragment.f20475J;
            if (Y.e((whitelistConfigDTO == null || (function = whitelistConfigDTO.getFunction()) == null) ? 0 : function.getWearingVideoTutorial(), false)) {
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                if (textView3 != null) {
                    textView3.setOnClickListener(new o(controlGuideFragment, 3));
                }
            } else if (textView3 != null) {
                textView3.setVisibility(8);
            }
            if (a10 != null) {
                String str = this.f20489b;
                if (str == null) {
                    h.i("mResPath");
                    throw null;
                }
                melodyAnimationLayout.b(a10.f2281a, str);
                if (textView != null) {
                    textView.setText(a10.f2283c);
                }
                if (textView2 != null) {
                    textView2.setText(a10.f2284d);
                }
                if (textView2 != null) {
                    textView2.setVisibility(a10.f2286f == 1 ? 8 : 0);
                }
                if (viewA != null) {
                    viewA.setVisibility(a10.f2286f != 1 ? 8 : 0);
                }
                if (a10.f2286f != 1 || textView3 == null) {
                    return;
                }
                textView3.setVisibility(8);
            }
        }

        @Override // G7.e
        public final int d() {
            return R.layout.melody_ui_control_guide_page_item;
        }
    }

    /* JADX INFO: compiled from: ControlGuideFragment.kt */
    public static final class b extends s {
        public b() {
            super(true);
        }

        @Override // c.s
        public final void b() {
            com.oplus.melody.common.util.A.b("ControlGuideFragment", "handleOnBackPressed");
            ControlGuideFragment controlGuideFragment = ControlGuideFragment.this;
            controlGuideFragment.v();
            controlGuideFragment.f20473G = true;
        }
    }

    /* JADX INFO: compiled from: ControlGuideFragment.kt */
    public static final class c implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20492a;

        public c(l lVar) {
            this.f20492a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20492a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20492a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.control.guide.ControlGuideFragment$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: ControlGuideFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            int iIntValue = num.intValue();
            ControlGuideFragment controlGuideFragment = (ControlGuideFragment) this.receiver;
            if (iIntValue == 3) {
                f fVar = controlGuideFragment.f20478p;
                h.b(fVar);
                DialogInterfaceOnClickListenerC0428d dialogInterfaceOnClickListenerC0428d = new DialogInterfaceOnClickListenerC0428d(controlGuideFragment, 0);
                G7.b bVar = new G7.b(fVar);
                bVar.n(R.string.melody_common_control_guide_device_disconnect_title);
                bVar.l(R.string.melody_common_control_guide_dialog_option_exit, dialogInterfaceOnClickListenerC0428d);
                bVar.setCancelable(false);
                controlGuideFragment.f20485w = bVar.show();
                ControlGuideViewModel controlGuideViewModel = controlGuideFragment.f20482t;
                if (controlGuideViewModel == null) {
                    h.i("mControlGuideVM");
                    throw null;
                }
                controlGuideViewModel.h.l(0);
                controlGuideFragment.H = false;
            } else {
                androidx.appcompat.app.f fVar2 = controlGuideFragment.f20485w;
                if (fVar2 != null) {
                    fVar2.dismiss();
                }
                controlGuideFragment.H = true;
            }
            return Jb.l.f2618a;
        }
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        h.e(context, "context");
        super.onAttach(context);
        requireActivity().getOnBackPressedDispatcher().a(this, new b());
        f fVarRequireActivity = requireActivity();
        ControlGuideActivity controlGuideActivity = fVarRequireActivity instanceof ControlGuideActivity ? (ControlGuideActivity) fVarRequireActivity : null;
        if (controlGuideActivity != null) {
            controlGuideActivity.f20466b0 = new C0.a(this, 6);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        this.f1654a = true;
        super.onCreate(savedInstanceState);
        this.f20478p = getActivity();
        f activity = getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        f activity2 = getActivity();
        if ((activity2 != null ? activity2.getIntent() : null) == null) {
            com.oplus.melody.common.util.A.h("ControlGuideFragment", "onCreate intent is null");
            f activity3 = getActivity();
            if (activity3 != null) {
                activity3.finish();
                return;
            }
            return;
        }
        setHasOptionsMenu(true);
        this.f20467A = intent != null ? intent.getStringExtra("device_mac_info") : null;
        this.f20488z = intent != null ? intent.getStringExtra("device_name") : null;
        this.f20468B = intent != null ? intent.getStringExtra("product_color") : null;
        this.f20469C = intent != null ? intent.getStringExtra("product_id") : null;
        this.f20470D = intent != null ? intent.getStringExtra("route_from") : null;
        this.f20472F = intent != null && intent.getBooleanExtra("route_value2", false);
        this.f20471E = intent != null && intent.getBooleanExtra("route_value3", false);
        f fVarRequireActivity = requireActivity();
        h.d(fVarRequireActivity, "requireActivity(...)");
        O viewModelStore = fVarRequireActivity.getViewModelStore();
        N.b defaultViewModelProviderFactory = fVarRequireActivity.getDefaultViewModelProviderFactory();
        d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, fVarRequireActivity.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(ControlGuideViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20482t = (ControlGuideViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        String str = this.f20467A;
        h.b(str);
        C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new A6.b(8))).e(this, new c(new AnonymousClass1(1, this, ControlGuideFragment.class, "onConnectionStatusChange", "onConnectionStatusChange(I)V", 0)));
        if (this.f20482t == null) {
            h.i("mControlGuideVM");
            throw null;
        }
        AbstractC0939b.E().b0();
        o0.c.f1143a.post(new Runnable() { // from class: com.oplus.melody.ui.component.control.guide.a
            @Override // java.lang.Runnable
            public final void run() {
                ControlGuideFragment controlGuideFragment = this.f20563a;
                if (controlGuideFragment.f20482t == null) {
                    h.i("mControlGuideVM");
                    throw null;
                }
                androidx.lifecycle.s<UserInteractionDTO> sVarM = AbstractC0939b.E().M();
                h.d(sVarM, "getUserInteractionEvent(...)");
                sVarM.e(controlGuideFragment, new ControlGuideFragment.c(new ControlGuideFragment$onCreate$2$1(1, controlGuideFragment, ControlGuideFragment.class, "onCommandInvoked", "onCommandInvoked(Lcom/oplus/melody/model/repository/earphone/UserInteractionDTO;)V", 0)));
            }
        });
        if (this.f20482t != null) {
            return;
        }
        h.i("mControlGuideVM");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        h.e(menu, "menu");
        h.e(inflater, "inflater");
        if (this.f20472F) {
            inflater.inflate(R.menu.melody_ui_tutorial_guide_menu, menu);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        return inflater.inflate(R.layout.melody_ui_control_guide_page_layout, container, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008d  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDestroy() {
        /*
            r8 = this;
            super.onDestroy()
            J8.c r0 = r8.f20484v
            r1 = 0
            if (r0 == 0) goto La8
            android.os.Handler r2 = r0.f2602k
            if (r2 == 0) goto La2
            r2.removeCallbacksAndMessages(r1)
            r0.h = r1
            I8.j r0 = new I8.j
            r2 = 1
            r0.<init>(r8, r2)
            java.util.concurrent.CompletableFuture r0 = java.util.concurrent.CompletableFuture.runAsync(r0)
            A6.i r2 = new A6.i
            r3 = 4
            r2.<init>(r3)
            r0.exceptionally(r2)
            com.oplus.melody.ui.component.control.guide.ControlGuideViewModel r0 = r8.f20482t
            java.lang.String r2 = "mControlGuideVM"
            if (r0 == 0) goto L9e
            com.oplus.melody.model.repository.earphone.b r0 = com.oplus.melody.model.repository.earphone.AbstractC0939b.E()
            r0.b0()
            com.oplus.melody.ui.component.control.guide.ControlGuideViewModel r0 = r8.f20482t
            if (r0 == 0) goto L9a
            java.lang.String r2 = r8.f20467A
            kotlin.jvm.internal.h.b(r2)
            r3 = 0
            r0.d(r2, r3)
            androidx.appcompat.app.f r0 = r8.f20486x
            if (r0 == 0) goto L4b
            boolean r2 = r0.isShowing()
            if (r2 == 0) goto L4b
            r0.dismiss()
        L4b:
            r8.f20486x = r1
            java.lang.String r0 = r8.f20469C
            java.lang.String r2 = r8.f20467A
            J8.g r4 = r8.f20483u
            if (r4 == 0) goto L94
            int r1 = r4.f2612b
            java.lang.String r4 = r8.f20470D
            if (r4 == 0) goto L93
            int r5 = r4.hashCode()
            r6 = -1335224239(0xffffffffb06a1851, float:-8.516326E-10)
            r7 = -1
            if (r5 == r6) goto L84
            r6 = 273184745(0x104877e9, float:3.953542E-29)
            if (r5 == r6) goto L7b
            r3 = 951543133(0x38b7655d, float:8.7450004E-5)
            if (r5 == r3) goto L70
            goto L8d
        L70:
            java.lang.String r3 = "control"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L79
            goto L8d
        L79:
            r3 = 1
            goto L8e
        L7b:
            java.lang.String r5 = "discover"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L8e
            goto L8d
        L84:
            java.lang.String r5 = "detail"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L8d
            goto L8e
        L8d:
            r3 = r7
        L8e:
            if (r3 == r7) goto L93
            kc.C1264t.p(r0, r2, r3, r1)
        L93:
            return
        L94:
            java.lang.String r0 = "mControlGuideSoundStatus"
            kotlin.jvm.internal.h.i(r0)
            throw r1
        L9a:
            kotlin.jvm.internal.h.i(r2)
            throw r1
        L9e:
            kotlin.jvm.internal.h.i(r2)
            throw r1
        La2:
            java.lang.String r0 = "mMainHandler"
            kotlin.jvm.internal.h.i(r0)
            throw r1
        La8:
            java.lang.String r0 = "mGuidePageStatus"
            kotlin.jvm.internal.h.i(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.control.guide.ControlGuideFragment.onDestroy():void");
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() != R.id.go_next) {
            return super.onOptionsItemSelected(item);
        }
        ForkJoinPool.commonPool().execute(new I8.j(this, 0));
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        com.oplus.melody.common.util.A.c("ControlGuideFragment", new C0404m(getActivity(), 11));
        S.b(getActivity());
        o0.c.f1143a.removeCallbacks(this.f20477L);
        s();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        com.oplus.melody.common.util.A.b("ControlGuideFragment", "onResume");
        S.z(getActivity());
        o0.c.f1143a.postDelayed(this.f20477L, 120000L);
        if (this.f20474I) {
            return;
        }
        androidx.appcompat.app.f fVar = this.f20486x;
        androidx.appcompat.app.f fVar2 = this.f20487y;
        if (fVar2 == null || !fVar2.isShowing()) {
            if (fVar == null || !fVar.isShowing()) {
                u();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r8v18, types: [Jb.b, java.lang.Object] */
    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.control_guide_view_page);
        h.d(viewFindViewById, "findViewById(...)");
        this.f20479q = (ViewPager2) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.melody_ui_control_guide_page_indicator);
        h.d(viewFindViewById2, "findViewById(...)");
        this.f20481s = (MelodyCompatTextView) viewFindViewById2;
        ControlGuideViewModel controlGuideViewModel = this.f20482t;
        if (controlGuideViewModel == null) {
            h.i("mControlGuideVM");
            throw null;
        }
        String str = this.f20469C;
        h.b(str);
        String str2 = this.f20468B;
        h.b(str2);
        controlGuideViewModel.e(str, str2);
        view.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: I8.k
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z2) {
                ControlGuideFragment controlGuideFragment = this.f2320a;
                com.oplus.melody.common.util.A.c("ControlGuideFragment", new K(z2, controlGuideFragment, 1));
                if (z2) {
                    if (controlGuideFragment.f20474I) {
                        return;
                    }
                    androidx.appcompat.app.f fVar = controlGuideFragment.f20486x;
                    if (fVar == null || !fVar.isShowing()) {
                        controlGuideFragment.u();
                        return;
                    }
                    return;
                }
                if (controlGuideFragment.f20474I) {
                    ControlGuideViewModel controlGuideViewModel2 = controlGuideFragment.f20482t;
                    if (controlGuideViewModel2 == null) {
                        kotlin.jvm.internal.h.i("mControlGuideVM");
                        throw null;
                    }
                    controlGuideViewModel2.h.l(0);
                    controlGuideFragment.s();
                }
            }
        });
        i iVar = (i) getActivity();
        androidx.appcompat.app.a aVarX = iVar != null ? iVar.x() : null;
        if (aVarX != null) {
            aVarX.n(true);
            aVarX.r(true);
            aVarX.t(R.string.melody_common_control_guide_title);
        }
        this.f20475J = AbstractC1508a.f().c(this.f20469C, this.f20488z);
        h.d(Collections.EMPTY_LIST, "emptyList(...)");
        a aVar = new a(this);
        this.f20480r = aVar;
        ViewPager2 viewPager2 = this.f20479q;
        if (viewPager2 == null) {
            h.i("mViewPager");
            throw null;
        }
        viewPager2.setAdapter(aVar);
        ViewPager2 viewPager22 = this.f20479q;
        if (viewPager22 == null) {
            h.i("mViewPager");
            throw null;
        }
        viewPager22.setUserInputEnabled(false);
        ViewPager2 viewPager23 = this.f20479q;
        if (viewPager23 == null) {
            h.i("mViewPager");
            throw null;
        }
        viewPager23.a(new com.oplus.melody.ui.component.control.guide.b(this));
        ControlGuideViewModel controlGuideViewModel2 = this.f20482t;
        if (controlGuideViewModel2 == null) {
            h.i("mControlGuideVM");
            throw null;
        }
        g gVar = new g(controlGuideViewModel2);
        this.f20483u = gVar;
        ControlGuideViewModel controlViewModel = this.f20482t;
        if (controlViewModel == null) {
            h.i("mControlGuideVM");
            throw null;
        }
        h.e(controlViewModel, "controlViewModel");
        controlViewModel.f20498g.e(this, new A6.l(gVar, 6));
        controlViewModel.h.e(this, new C9.a(gVar, 7));
        controlViewModel.f20496e.e(this, new g.a(new J8.e(0, gVar, controlViewModel)));
        ControlGuideViewModel controlGuideViewModel3 = this.f20482t;
        if (controlGuideViewModel3 == null) {
            h.i("mControlGuideVM");
            throw null;
        }
        ViewPager2 viewPager24 = this.f20479q;
        if (viewPager24 == null) {
            h.i("mViewPager");
            throw null;
        }
        J8.c cVar = new J8.c(controlGuideViewModel3, viewPager24);
        this.f20484v = cVar;
        ControlGuideViewModel controlGuideViewModel4 = this.f20482t;
        if (controlGuideViewModel4 == null) {
            h.i("mControlGuideVM");
            throw null;
        }
        controlGuideViewModel4.f20498g.e(this, new A6.l(cVar, 6));
        controlGuideViewModel4.h.e(this, new C9.a(cVar, 7));
        if (this.f20484v == null) {
            h.i("mGuidePageStatus");
            throw null;
        }
        getActivity();
        J8.c cVar2 = this.f20484v;
        if (cVar2 == null) {
            h.i("mGuidePageStatus");
            throw null;
        }
        cVar2.h = new k(this, 11);
        ControlGuideViewModel controlGuideViewModel5 = this.f20482t;
        if (controlGuideViewModel5 == null) {
            h.i("mControlGuideVM");
            throw null;
        }
        controlGuideViewModel5.f20495d.e(getViewLifecycleOwner(), new c(new ControlGuideFragment$initView$3(1, this, ControlGuideFragment.class, "onConfigChanged", "onConfigChanged(Lcom/oplus/melody/ui/component/control/guide/ControlGuideConfigVO;)V", 0)));
        C0379m.b(((AbstractC1094a) AbstractC1094a.f23750c.getValue()).b()).e(getViewLifecycleOwner(), new c(new B9.d(this, 6)));
    }

    public final void r() {
        com.oplus.melody.common.util.A.b("ControlGuideFragment", "enterControlMode");
        ControlGuideViewModel controlGuideViewModel = this.f20482t;
        if (controlGuideViewModel == null) {
            h.i("mControlGuideVM");
            throw null;
        }
        if (controlGuideViewModel == null) {
            h.i("mControlGuideVM");
            throw null;
        }
        int i10 = controlGuideViewModel.f20500j;
        J8.c cVar = this.f20484v;
        if (cVar == null) {
            h.i("mGuidePageStatus");
            throw null;
        }
        controlGuideViewModel.f20498g.m(new C0425a(i10, cVar.f2597e, 2));
        String str = this.f20467A;
        if (str != null) {
            ControlGuideViewModel controlGuideViewModel2 = this.f20482t;
            if (controlGuideViewModel2 == null) {
                h.i("mControlGuideVM");
                throw null;
            }
            controlGuideViewModel2.d(str, true);
        }
        this.f20474I = true;
    }

    public final void s() {
        com.oplus.melody.common.util.A.b("ControlGuideFragment", "exitControlMode");
        this.f20474I = false;
        String str = this.f20467A;
        if (str != null) {
            ControlGuideViewModel controlGuideViewModel = this.f20482t;
            if (controlGuideViewModel == null) {
                h.i("mControlGuideVM");
                throw null;
            }
            controlGuideViewModel.d(str, false);
        }
        if (this.f20483u != null) {
            g.c();
        } else {
            h.i("mControlGuideSoundStatus");
            throw null;
        }
    }

    public final void t() {
        f activity = getActivity();
        if (activity == null && (activity = this.f20478p) == null) {
            return;
        }
        if (!this.f20476K) {
            E8.a.w().getClass();
            Jb.b<List<l<String, Class<?>>>> bVar = F8.i.f1668g;
            F8.i iVarA = i.a.a("/ui/control_guide/finish");
            iVarA.f("device_mac_info", this.f20467A);
            iVarA.f("product_id", this.f20469C);
            iVarA.f("device_name", this.f20488z);
            iVarA.f("product_color", this.f20468B);
            iVarA.f1670b.putExtra("route_value2", this.f20472F);
            iVarA.f1670b.putExtra("route_value3", this.f20471E);
            iVarA.b(activity);
            return;
        }
        E8.a.w().getClass();
        Jb.b<List<l<String, Class<?>>>> bVar2 = F8.i.f1668g;
        F8.i iVarA2 = i.a.a("/ui/control_guide/pair_device");
        iVarA2.f("device_mac_info", this.f20467A);
        iVarA2.f("product_id", this.f20469C);
        iVarA2.f("device_name", this.f20488z);
        iVarA2.f("product_color", this.f20468B);
        iVarA2.f1670b.putExtra("route_value2", this.f20472F);
        iVarA2.f1670b.putExtra("route_value3", this.f20471E);
        iVarA2.f("route_from", this.f20470D);
        iVarA2.b(activity);
    }

    public final void u() {
        if (this.H) {
            androidx.appcompat.app.f fVar = this.f20486x;
            if (fVar == null || !fVar.isShowing()) {
                f fVar2 = this.f20478p;
                h.b(fVar2);
                I8.e eVar = new I8.e(this, 1);
                I8.f fVar3 = new I8.f(this, 1);
                G7.b bVar = new G7.b(fVar2);
                bVar.n(R.string.melody_common_control_guide_dialog_process_resume_title);
                bVar.l(R.string.melody_common_control_guide_dialog_option_continue, eVar);
                bVar.h(R.string.melody_common_control_guide_dialog_option_exit, fVar3);
                bVar.setCancelable(false);
                this.f20486x = bVar.show();
            }
        }
    }

    public final void v() {
        s();
        f fVar = this.f20478p;
        h.b(fVar);
        I8.e eVar = new I8.e(this, 0);
        I8.f fVar2 = new I8.f(this, 0);
        G7.b bVar = new G7.b(fVar);
        bVar.n(R.string.melody_common_control_guide_dialog_exit_title);
        bVar.l(R.string.melody_common_control_guide_dialog_option_continue, eVar);
        bVar.h(R.string.melody_common_control_guide_dialog_option_exit, fVar2);
        bVar.setCancelable(false);
        this.f20487y = bVar.show();
    }
}
