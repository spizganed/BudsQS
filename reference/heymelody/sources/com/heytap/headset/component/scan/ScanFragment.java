package com.heytap.headset.component.scan;

import A6.g;
import A6.p;
import Ca.k;
import Ca.n;
import D7.C0373g;
import D7.C0379m;
import D7.RunnableC0380n;
import D7.o0;
import D7.q0;
import Ea.F;
import F8.c;
import F8.i;
import F9.s;
import Jb.b;
import Wb.l;
import X.d;
import X3.C0495c;
import X3.C0496d;
import X3.e;
import X3.f;
import X3.m;
import X3.o;
import X3.x;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.heytap.headset.component.scan.ScanViewModel;
import com.oplus.melody.app.discovery.C1;
import com.oplus.melody.btsdk.api.scan.BleScanElement;
import com.oplus.melody.btsdk.api.scan.BrScanElement;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import com.oplus.melody.ui.widget.MelodyLottieAnimationView;
import com.oplus.melody.ui.widget.MelodyVideoAnimationView;
import e4.C1008a;
import f4.C1043b;
import i4.C1139a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import o.InterfaceC1361a;
import u8.C1557e;
import u8.C1558f;

/* JADX INFO: compiled from: ScanFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 a2\u00020\u0001:\u0001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u001a\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010@\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020>H\u0016J\b\u0010D\u001a\u00020>H\u0016J\b\u0010E\u001a\u00020>H\u0016J\b\u0010F\u001a\u00020>H\u0002J\b\u0010G\u001a\u00020>H\u0002J\u0010\u0010H\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0016\u0010I\u001a\u00020>2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020!01H\u0002J\u0010\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u00020)H\u0002J\b\u0010M\u001a\u00020>H\u0002J\u0010\u0010N\u001a\u00020>2\u0006\u0010O\u001a\u00020!H\u0002J\b\u0010P\u001a\u00020>H\u0002J\b\u0010Q\u001a\u00020>H\u0002J\b\u0010R\u001a\u00020>H\u0002J\b\u0010S\u001a\u00020>H\u0002J\u0018\u0010T\u001a\u00020>2\u0006\u0010U\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020!H\u0002J\u001a\u0010V\u001a\u00020>2\u0006\u0010U\u001a\u00020\u000f2\b\u0010W\u001a\u0004\u0018\u00010XH\u0002J \u0010Y\u001a\b\u0012\u0004\u0012\u00020[0Z2\u0006\u0010W\u001a\u00020X2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0002J(\u0010^\u001a\u00020>2\u0006\u0010W\u001a\u00020X2\u0006\u0010\\\u001a\u00020]2\u0006\u0010_\u001a\u00020)2\u0006\u0010`\u001a\u00020)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/heytap/headset/component/scan/ScanFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "<init>", "()V", "mRootView", "Landroid/view/View;", "mScanLottieView", "Lcom/oplus/melody/ui/widget/MelodyLottieAnimationView;", "mScanLottieViewBg", "mScanningTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "mScanRemindTextView", "mTxtViews", "mLottieViews", "mNoDeviceScannedImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "mNoDeviceScannedTextView", "mGotoConnectGuideTextView", "mRescanButton", "Lcom/oplus/melody/ui/widget/MelodyCompatButton;", "mScanningTipViews", "Landroid/widget/LinearLayout;", "mScanningLottieSmall", "mControlTips", "mScanRecyclerView", "Landroidx/recyclerview/widget/COUIRecyclerView;", "mScanDeviceAdapter", "Lcom/heytap/headset/component/scan/ScanDeviceAdapter;", "mScanViewModel", "Lcom/heytap/headset/component/scan/ScanViewModel;", "isScanning", "", "connectingItem", "Lcom/heytap/headset/component/scan/ScanDeviceVO;", "lastClickDeviceAddress", "", "pairTipDialog", "Landroidx/appcompat/app/AlertDialog;", "pairingVideoView", "Lcom/oplus/melody/ui/widget/MelodyVideoAnimationView;", "seekEndTime", "", "contentView", "isConnectFailed", "fromStartPage", "handler", "Landroid/os/Handler;", "hasScanningResultAnimator", "backgroundLottieViews", "", "lastVideoEndRunnable", "Ljava/lang/Runnable;", "videoHandler", "shouldNavToDeviceList", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "onPause", "onDestroy", "startScan", "setToolbar", "initView", "onScanItemListChange", "itemList", "onBluetoothStateChange", "state", "initGoToConnectGuideTextView", "showPairTipDialog", "scanDeviceVO", "showScanningView", "showScanResultView", "showNoDeviceScannedView", "animateToConnectingState", "showVideoTip", "pairingImageView", "updateBackground", "config", "Lcom/oplus/melody/app/discovery/DiscoveryZipConfigVO;", "playBackgroundVideo", "Ljava/util/concurrent/CompletableFuture;", "Landroid/net/Uri;", "stateAnimation", "Lcom/oplus/melody/model/zipdata/DiscoveryAnimationDO;", "onVideoEndDelayed", "startMillis", "endMillis", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ScanFragment extends c {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public AppCompatTextView f17505A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public COUIRecyclerView f17506B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public e f17507C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public ScanViewModel f17508D;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public f f17510F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public String f17511G;
    public androidx.appcompat.app.f H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public MelodyVideoAnimationView f17512I;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public View f17514K;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public boolean f17516M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public List<MelodyLottieAnimationView> f17517N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public m f17518O;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public boolean f17520Q;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f17521p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MelodyLottieAnimationView f17522q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MelodyLottieAnimationView f17523r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f17524s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f17525t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AppCompatImageView f17526u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AppCompatTextView f17527v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AppCompatTextView f17528w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public MelodyCompatButton f17529x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public LinearLayout f17530y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public MelodyLottieAnimationView f17531z;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public boolean f17509E = true;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f17513J = -1;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public final Handler f17515L = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public final Handler f17519P = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: ScanFragment.kt */
    public static final class a implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctionReferenceImpl f17532a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(l lVar) {
            this.f17532a = (FunctionReferenceImpl) lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f17532a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [Wb.l, kotlin.jvm.internal.FunctionReferenceImpl] */
        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f17532a.d(obj);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        return inflater.inflate(R.layout.heymelody_app_fragment_scan, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.f17508D != null) {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                h.i("context");
                throw null;
            }
            C1139a.f24076c.getClass();
            int i10 = C1139a.f24083v;
            Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1055);
            intentU.putExtra("scan_flag", i10);
            com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
        }
        if (this.f17508D != null) {
            C1139a.f24076c.getClass();
            C1139a.f24078q.m(null);
            C1139a.f24080s.m(null);
        }
        if (this.f17508D != null) {
            C1139a.f24076c.getClass();
            C1139a.f24079r.m(null);
            C1139a.f24081t.m(null);
        }
        androidx.appcompat.app.f fVar = this.H;
        if (fVar != null && fVar.isShowing()) {
            fVar.dismiss();
        }
        androidx.appcompat.app.f fVar2 = k.f811a;
        if (fVar2 != null && fVar2.isShowing()) {
            fVar2.dismiss();
        }
        this.f17515L.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        requireActivity().finish();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        com.oplus.melody.model.scan.a.a().e(false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        androidx.appcompat.app.f fVar;
        super.onResume();
        A.b("ScanFragment", "onResume");
        com.oplus.melody.model.scan.a.a().e(true);
        if (this.f17513J > 0 && this.f17512I != null && (fVar = this.H) != null && fVar.isShowing()) {
            A.c("ScanFragment", new B6.a(this, 29));
            MelodyVideoAnimationView melodyVideoAnimationView = this.f17512I;
            if (melodyVideoAnimationView != null) {
                melodyVideoAnimationView.g(this.f17513J);
            }
        }
        if (this.f17520Q) {
            this.f17520Q = false;
            E8.a.w().getClass();
            b<List<l<String, Class<?>>>> bVar = i.f1668g;
            i iVarA = i.a.a("/heymelody_app/device_list_combine");
            iVarA.a(1);
            iVarA.f("route_from", "ScanFragment");
            iVarA.b(requireActivity());
            requireActivity().finishAffinity();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        androidx.appcompat.app.i iVar = (androidx.appcompat.app.i) getActivity();
        h.b(iVar);
        androidx.appcompat.app.a aVarX = iVar.x();
        h.b(aVarX);
        aVarX.n(true);
        aVarX.r(true);
        aVarX.q(R.drawable.coui_back_arrow);
        aVarX.t(R.string.melody_common_scanning2);
        O store = getViewModelStore();
        N.b factory = getDefaultViewModelProviderFactory();
        W.a defaultViewModelCreationExtras = getDefaultViewModelCreationExtras();
        h.e(store, "store");
        h.e(factory, "factory");
        d dVarB = g.b(defaultViewModelCreationExtras, "defaultCreationExtras", store, factory, defaultViewModelCreationExtras);
        kotlin.jvm.internal.b bVarA = j.a(ScanViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f17508D = (ScanViewModel) dVarB.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f17521p = view;
        View viewFindViewById = view.findViewById(R.id.scan_lottie_container);
        h.d(viewFindViewById, "findViewById(...)");
        this.f17525t = viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.iv_scan);
        h.d(viewFindViewById2, "findViewById(...)");
        this.f17522q = (MelodyLottieAnimationView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.iv_scan_bg);
        h.d(viewFindViewById3, "findViewById(...)");
        this.f17523r = (MelodyLottieAnimationView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.tv_scanning);
        h.d(viewFindViewById4, "findViewById(...)");
        View viewFindViewById5 = view.findViewById(R.id.tv_scan_remind);
        h.d(viewFindViewById5, "findViewById(...)");
        View viewFindViewById6 = view.findViewById(R.id.txt_views);
        h.d(viewFindViewById6, "findViewById(...)");
        this.f17524s = viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.no_device_scanned_img);
        h.d(viewFindViewById7, "findViewById(...)");
        this.f17526u = (AppCompatImageView) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.no_device_scanned_tv);
        h.d(viewFindViewById8, "findViewById(...)");
        this.f17527v = (AppCompatTextView) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.go_to_connect_guide);
        h.d(viewFindViewById9, "findViewById(...)");
        this.f17528w = (AppCompatTextView) viewFindViewById9;
        String string = requireContext().getString(R.string.melody_common_connect_guide);
        h.d(string, "getString(...)");
        String string2 = requireContext().getString(R.string.melody_common_pls_lookup_connect_guide, string);
        h.d(string2, "getString(...)");
        SpannableString spannableStringValueOf = SpannableString.valueOf(string2);
        h.d(spannableStringValueOf, "valueOf(...)");
        int iN = ec.m.N(string2, string, 0, false, 6);
        Context contextRequireContext = requireContext();
        C0495c c0495c = new C0495c();
        c0495c.f5895b = contextRequireContext.getColor(R.color.melody_common_heymelody_theme_blue_normal_text_bg);
        c0495c.f5898e = contextRequireContext;
        c0495c.f5897d = R.drawable.heymelody_app_guide_indicator;
        c0495c.h = contextRequireContext.getResources().getDimensionPixelSize(R.dimen.heymelody_app_guide_indicator_top_bottom_margin);
        c0495c.f5901i = contextRequireContext.getResources().getDimensionPixelSize(R.dimen.heymelody_app_guide_indicator_end_margin);
        c0495c.f5902j = contextRequireContext.getResources().getDimensionPixelSize(R.dimen.heymelody_app_guide_indicator_bg_start_end_margin);
        spannableStringValueOf.setSpan(c0495c, iN, string.length() + iN, 17);
        spannableStringValueOf.setSpan(new o(this), iN, string.length() + iN, 17);
        AppCompatTextView appCompatTextView = this.f17528w;
        if (appCompatTextView == null) {
            h.i("mGotoConnectGuideTextView");
            throw null;
        }
        appCompatTextView.setText(spannableStringValueOf);
        AppCompatTextView appCompatTextView2 = this.f17528w;
        if (appCompatTextView2 == null) {
            h.i("mGotoConnectGuideTextView");
            throw null;
        }
        appCompatTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        AppCompatTextView appCompatTextView3 = this.f17528w;
        if (appCompatTextView3 == null) {
            h.i("mGotoConnectGuideTextView");
            throw null;
        }
        appCompatTextView3.setHighlightColor(requireContext().getColor(R.color.coui_transparence));
        View viewFindViewById10 = view.findViewById(R.id.rescan);
        h.d(viewFindViewById10, "findViewById(...)");
        this.f17529x = (MelodyCompatButton) viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.scanning_tip_views);
        h.d(viewFindViewById11, "findViewById(...)");
        this.f17530y = (LinearLayout) viewFindViewById11;
        View viewFindViewById12 = view.findViewById(R.id.scanning_lottie);
        h.d(viewFindViewById12, "findViewById(...)");
        this.f17531z = (MelodyLottieAnimationView) viewFindViewById12;
        View viewFindViewById13 = view.findViewById(R.id.control_tips);
        h.d(viewFindViewById13, "findViewById(...)");
        this.f17505A = (AppCompatTextView) viewFindViewById13;
        View viewFindViewById14 = view.findViewById(R.id.rv_scan_device_list);
        h.d(viewFindViewById14, "findViewById(...)");
        COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) viewFindViewById14;
        this.f17506B = cOUIRecyclerView;
        requireContext();
        cOUIRecyclerView.setLayoutManager(new LinearLayoutManager(1));
        Context contextRequireContext2 = requireContext();
        e eVar = new e(new C0496d());
        eVar.f5903b = contextRequireContext2;
        eVar.f5904c = LayoutInflater.from(contextRequireContext2);
        this.f17507C = eVar;
        COUIRecyclerView cOUIRecyclerView2 = this.f17506B;
        if (cOUIRecyclerView2 == null) {
            h.i("mScanRecyclerView");
            throw null;
        }
        cOUIRecyclerView2.setAdapter(eVar);
        COUIRecyclerView cOUIRecyclerView3 = this.f17506B;
        if (cOUIRecyclerView3 == null) {
            h.i("mScanRecyclerView");
            throw null;
        }
        cOUIRecyclerView3.setItemAnimator(new x());
        e eVar2 = this.f17507C;
        if (eVar2 == null) {
            h.i("mScanDeviceAdapter");
            throw null;
        }
        eVar2.f5905d = new n(this, 10);
        MelodyCompatButton melodyCompatButton = this.f17529x;
        if (melodyCompatButton == null) {
            h.i("mRescanButton");
            throw null;
        }
        melodyCompatButton.setOnClickListener(new F(this, 9));
        s();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string3 = arguments.getString("route_from");
            A.c("ScanFragment", new D6.c(string3, 11));
            h.a(string3, "StartScanActivity");
        }
        final ScanViewModel scanViewModel = this.f17508D;
        if (scanViewModel != null) {
            InterfaceC0601m viewLifecycleOwner = getViewLifecycleOwner();
            h.d(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            C1139a.f24076c.getClass();
            final int i10 = 0;
            C0379m.b(C0379m.e(C1139a.f24078q, new InterfaceC1361a() { // from class: X3.v
                @Override // o.InterfaceC1361a, com.google.common.base.b
                public final Object apply(Object obj) {
                    BleScanElement bleScanElement = (BleScanElement) obj;
                    switch (i10) {
                        case 0:
                            if (bleScanElement != null) {
                                scanViewModel.getClass();
                            }
                            break;
                        default:
                            if (bleScanElement != null) {
                                scanViewModel.getClass();
                            }
                            break;
                    }
                    return ScanViewModel.e(bleScanElement);
                }
            })).e(viewLifecycleOwner, new ScanViewModel.a(new ScanViewModel$startObserve$1(1, scanViewModel, ScanViewModel.class, "onBleDeviceFound", "onBleDeviceFound(Lcom/heytap/headset/component/scan/ScanDeviceVO;)V", 0)));
            final int i11 = 1;
            t tVarB = C0379m.b(C0379m.e(C1139a.f24079r, new InterfaceC1361a() { // from class: X3.v
                @Override // o.InterfaceC1361a, com.google.common.base.b
                public final Object apply(Object obj) {
                    BleScanElement bleScanElement = (BleScanElement) obj;
                    switch (i11) {
                        case 0:
                            if (bleScanElement != null) {
                                scanViewModel.getClass();
                            }
                            break;
                        default:
                            if (bleScanElement != null) {
                                scanViewModel.getClass();
                            }
                            break;
                    }
                    return ScanViewModel.e(bleScanElement);
                }
            }));
            scanViewModel.f17534c = tVarB;
            tVarB.e(viewLifecycleOwner, new ScanViewModel.a(new ScanViewModel$startObserve$2(1, scanViewModel, ScanViewModel.class, "onBleDeviceRemove", "onBleDeviceRemove(Lcom/heytap/headset/component/scan/ScanDeviceVO;)V", 0)));
            final int i12 = 0;
            C0379m.b(C0379m.e(C1139a.f24080s, new InterfaceC1361a() { // from class: X3.t
                @Override // o.InterfaceC1361a, com.google.common.base.b
                public final Object apply(Object obj) {
                    switch (i12) {
                        case 0:
                            BrScanElement brScanElement = (BrScanElement) obj;
                            if (brScanElement == null) {
                                return null;
                            }
                            scanViewModel.getClass();
                            return ScanViewModel.f(brScanElement);
                        default:
                            List list = (List) obj;
                            kotlin.jvm.internal.h.b(list);
                            scanViewModel.getClass();
                            ArrayList arrayList = new ArrayList();
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(((BluetoothDevice) it.next()).getAddress());
                                Object obj2 = null;
                                if (earphoneDTOW != null) {
                                    f fVar = new f(null, null, null, null, false, null, 0, null, 0, 0, false, 2047, null);
                                    fVar.setDeviceName(earphoneDTOW.getName());
                                    fVar.setMacAddress(earphoneDTOW.getMacAddress());
                                    fVar.setType(earphoneDTOW.getProductType());
                                    fVar.setSpp(earphoneDTOW.isSupportSpp());
                                    fVar.setProductId(earphoneDTOW.getProductId());
                                    if (C0373g.f1086l) {
                                        fVar.setColorId(earphoneDTOW.getColorId());
                                        int mColorId = -1;
                                        if (fVar.getColorId() == -1) {
                                            e4.e eVar3 = e4.e.f22900c;
                                            String mac = earphoneDTOW.getMacAddress();
                                            eVar3.getClass();
                                            kotlin.jvm.internal.h.e(mac, "mac");
                                            List<C1008a> listD = e4.e.f22901p.d();
                                            if (listD != null && !listD.isEmpty()) {
                                                Iterator<T> it2 = listD.iterator();
                                                while (true) {
                                                    if (it2.hasNext()) {
                                                        Object next = it2.next();
                                                        if (kotlin.jvm.internal.h.a(((C1008a) next).getMMacAddress(), mac)) {
                                                            obj2 = next;
                                                        }
                                                    }
                                                }
                                                C1008a c1008a = (C1008a) obj2;
                                                if (c1008a != null) {
                                                    mColorId = c1008a.getMColorId();
                                                }
                                            }
                                            fVar.setColorId(mColorId);
                                        }
                                        com.oplus.melody.common.util.A.c("ScanViewModel", new T8.d(fVar, 3));
                                    } else {
                                        fVar.setColorId(earphoneDTOW.getColorId());
                                    }
                                    fVar.setViewType(2);
                                    fVar.setConnectionState(3);
                                    obj2 = fVar;
                                }
                                if (obj2 != null) {
                                    arrayList.add(obj2);
                                }
                            }
                            return arrayList;
                    }
                }
            })).e(viewLifecycleOwner, new ScanViewModel.a(new ScanViewModel$startObserve$3(1, scanViewModel, ScanViewModel.class, "onBrDeviceFound", "onBrDeviceFound(Lcom/heytap/headset/component/scan/ScanDeviceVO;)V", 0)));
            t tVarB2 = C0379m.b(C0379m.e(C1139a.f24081t, new s(scanViewModel, 14)));
            scanViewModel.f17535d = tVarB2;
            tVarB2.e(viewLifecycleOwner, new ScanViewModel.a(new ScanViewModel$startObserve$4(1, scanViewModel, ScanViewModel.class, "onBrDeviceRemove", "onBrDeviceRemove(Lcom/heytap/headset/component/scan/ScanDeviceVO;)V", 0)));
            final int i13 = 1;
            C0379m.b(C0379m.e(C1139a.f24082u, new InterfaceC1361a() { // from class: X3.t
                @Override // o.InterfaceC1361a, com.google.common.base.b
                public final Object apply(Object obj) {
                    switch (i13) {
                        case 0:
                            BrScanElement brScanElement = (BrScanElement) obj;
                            if (brScanElement == null) {
                                return null;
                            }
                            scanViewModel.getClass();
                            return ScanViewModel.f(brScanElement);
                        default:
                            List list = (List) obj;
                            kotlin.jvm.internal.h.b(list);
                            scanViewModel.getClass();
                            ArrayList arrayList = new ArrayList();
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(((BluetoothDevice) it.next()).getAddress());
                                Object obj2 = null;
                                if (earphoneDTOW != null) {
                                    f fVar = new f(null, null, null, null, false, null, 0, null, 0, 0, false, 2047, null);
                                    fVar.setDeviceName(earphoneDTOW.getName());
                                    fVar.setMacAddress(earphoneDTOW.getMacAddress());
                                    fVar.setType(earphoneDTOW.getProductType());
                                    fVar.setSpp(earphoneDTOW.isSupportSpp());
                                    fVar.setProductId(earphoneDTOW.getProductId());
                                    if (C0373g.f1086l) {
                                        fVar.setColorId(earphoneDTOW.getColorId());
                                        int mColorId = -1;
                                        if (fVar.getColorId() == -1) {
                                            e4.e eVar3 = e4.e.f22900c;
                                            String mac = earphoneDTOW.getMacAddress();
                                            eVar3.getClass();
                                            kotlin.jvm.internal.h.e(mac, "mac");
                                            List<C1008a> listD = e4.e.f22901p.d();
                                            if (listD != null && !listD.isEmpty()) {
                                                Iterator<T> it2 = listD.iterator();
                                                while (true) {
                                                    if (it2.hasNext()) {
                                                        Object next = it2.next();
                                                        if (kotlin.jvm.internal.h.a(((C1008a) next).getMMacAddress(), mac)) {
                                                            obj2 = next;
                                                        }
                                                    }
                                                }
                                                C1008a c1008a = (C1008a) obj2;
                                                if (c1008a != null) {
                                                    mColorId = c1008a.getMColorId();
                                                }
                                            }
                                            fVar.setColorId(mColorId);
                                        }
                                        com.oplus.melody.common.util.A.c("ScanViewModel", new T8.d(fVar, 3));
                                    } else {
                                        fVar.setColorId(earphoneDTOW.getColorId());
                                    }
                                    fVar.setViewType(2);
                                    fVar.setConnectionState(3);
                                    obj2 = fVar;
                                }
                                if (obj2 != null) {
                                    arrayList.add(obj2);
                                }
                            }
                            return arrayList;
                    }
                }
            })).e(viewLifecycleOwner, new ScanViewModel.a(new ScanViewModel$startObserve$5(1, scanViewModel, ScanViewModel.class, "onConnectedDeviceListFound", "onConnectedDeviceListFound(Ljava/util/List;)V", 0)));
            O7.l<Map<String, String>> lVar = C1043b.a.f23099a.f23098a;
            h.d(lVar, "getPicUrlsMapLiveData(...)");
            C0379m.b(lVar).e(viewLifecycleOwner, new ScanViewModel.a(new ScanViewModel$startObserve$6(1, scanViewModel, ScanViewModel.class, "onPicUrlsMapChange", "onPicUrlsMapChange(Ljava/util/Map;)V", 0)));
            C0379m.b(scanViewModel.f17533b).e(getViewLifecycleOwner(), new a(new ScanFragment$onViewCreated$2$1(1, this, ScanFragment.class, "onScanItemListChange", "onScanItemListChange(Ljava/util/List;)V", 0)));
            C0379m.b(C1139a.f24077p).e(getViewLifecycleOwner(), new a(new ScanFragment$onViewCreated$2$2(1, this, ScanFragment.class, "onBluetoothStateChange", "onBluetoothStateChange(I)V", 0)));
        }
        t();
    }

    public final void r(C1 c12, C1557e c1557e, int i10, int i11) {
        MelodyVideoAnimationView melodyVideoAnimationView;
        androidx.appcompat.app.f fVar = this.H;
        if (fVar == null || !fVar.isShowing()) {
            return;
        }
        MelodyVideoAnimationView melodyVideoAnimationView2 = this.f17512I;
        if ((melodyVideoAnimationView2 == null || !melodyVideoAnimationView2.isShown()) && ((melodyVideoAnimationView = this.f17512I) == null || !melodyVideoAnimationView.f21956t)) {
            A.x("ScanFragment", "onVideoEndDelayed return because video not show");
            return;
        }
        m mVar = this.f17518O;
        Handler handler = this.f17519P;
        if (mVar != null) {
            handler.removeCallbacks(mVar);
        }
        m mVar2 = new m(this, i11, c12, c1557e);
        this.f17518O = mVar2;
        if (this.f17512I != null) {
            handler.postDelayed(mVar2, i11 - i10);
        }
    }

    public final void s() {
        this.f17516M = false;
        androidx.appcompat.app.i iVar = (androidx.appcompat.app.i) getActivity();
        androidx.appcompat.app.a aVarX = iVar != null ? iVar.x() : null;
        if (aVarX != null) {
            aVarX.p(true);
        }
        AppCompatImageView appCompatImageView = this.f17526u;
        if (appCompatImageView == null) {
            h.i("mNoDeviceScannedImageView");
            throw null;
        }
        appCompatImageView.setVisibility(8);
        AppCompatTextView appCompatTextView = this.f17527v;
        if (appCompatTextView == null) {
            h.i("mNoDeviceScannedTextView");
            throw null;
        }
        appCompatTextView.setVisibility(8);
        AppCompatTextView appCompatTextView2 = this.f17528w;
        if (appCompatTextView2 == null) {
            h.i("mGotoConnectGuideTextView");
            throw null;
        }
        appCompatTextView2.setVisibility(8);
        MelodyCompatButton melodyCompatButton = this.f17529x;
        if (melodyCompatButton == null) {
            h.i("mRescanButton");
            throw null;
        }
        melodyCompatButton.setVisibility(8);
        View view = this.f17525t;
        if (view == null) {
            h.i("mLottieViews");
            throw null;
        }
        view.setVisibility(0);
        MelodyLottieAnimationView melodyLottieAnimationView = this.f17522q;
        if (melodyLottieAnimationView == null) {
            h.i("mScanLottieView");
            throw null;
        }
        melodyLottieAnimationView.setVisibility(0);
        MelodyLottieAnimationView melodyLottieAnimationView2 = this.f17523r;
        if (melodyLottieAnimationView2 == null) {
            h.i("mScanLottieViewBg");
            throw null;
        }
        melodyLottieAnimationView2.setVisibility(0);
        View view2 = this.f17524s;
        if (view2 == null) {
            h.i("mTxtViews");
            throw null;
        }
        view2.setVisibility(0);
        LinearLayout linearLayout = this.f17530y;
        if (linearLayout == null) {
            h.i("mScanningTipViews");
            throw null;
        }
        linearLayout.setVisibility(4);
        AppCompatTextView appCompatTextView3 = this.f17505A;
        if (appCompatTextView3 == null) {
            h.i("mControlTips");
            throw null;
        }
        appCompatTextView3.setVisibility(4);
        COUIRecyclerView cOUIRecyclerView = this.f17506B;
        if (cOUIRecyclerView != null) {
            cOUIRecyclerView.setVisibility(8);
        } else {
            h.i("mScanRecyclerView");
            throw null;
        }
    }

    public final void t() {
        A.b("ScanFragment", "startScan");
        if (this.f17508D != null) {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                h.i("context");
                throw null;
            }
            C1139a.f24076c.getClass();
            int i10 = C1139a.f24083v;
            Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1054);
            intentU.putExtra("scan_flag", i10);
            com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
        }
        this.f17515L.postDelayed(new RunnableC0380n(this, 29), 20000L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u(AppCompatImageView appCompatImageView, C1 c12) {
        C1 c13;
        CompletableFuture completableFutureB;
        Resources resources;
        C1558f discoveryStates;
        int dimensionPixelOffset = 0;
        if (((c12 == null || (discoveryStates = c12.getDiscoveryStates()) == null) ? null : discoveryStates.getPairingState()) == null) {
            A.x("ScanFragment", "updateBackground pairingState in config is null!");
            MelodyVideoAnimationView melodyVideoAnimationView = this.f17512I;
            if (melodyVideoAnimationView != null) {
                melodyVideoAnimationView.setVisibility(4);
            }
            appCompatImageView.setVisibility(0);
            J6.d.d(300, Kb.k.b(appCompatImageView));
            return;
        }
        C1557e pairingState = c12.getDiscoveryStates().getPairingState();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (pairingState != null) {
            MelodyResourceDO bgVideoRes = pairingState.getBgVideoRes();
            MelodyResourceDO videoRes = pairingState.getVideoRes();
            T videoRes2 = bgVideoRes;
            if (bgVideoRes == null) {
                videoRes2 = videoRes == null ? c12.getVideoRes() : videoRes;
            }
            ref$ObjectRef.element = videoRes2;
        }
        if (ref$ObjectRef.element == 0) {
            completableFutureB = q0.b(MelodyException.e(404, "videoRes is null"));
        } else if (pairingState != null && pairingState.getStartTime() == null) {
            completableFutureB = q0.b(MelodyException.e(415, "not support video"));
        } else if (pairingState == null || pairingState.getEndTime() != null) {
            File fileN = com.oplus.drs.core.d.n(getContext(), (MelodyResourceDO) ref$ObjectRef.element, c12.getRootPath());
            if (fileN != null) {
                androidx.appcompat.app.f fVar = this.H;
                if (fVar == null || !fVar.isShowing()) {
                    c13 = c12;
                    completableFutureB = q0.b(MelodyException.e(404, "dialog not showing"));
                } else {
                    MelodyVideoAnimationView melodyVideoAnimationView2 = this.f17512I;
                    if (melodyVideoAnimationView2 == null) {
                        completableFutureB = q0.b(MelodyException.e(404, "videoView not found"));
                    } else {
                        melodyVideoAnimationView2.setAutoCrop(true);
                        Integer videoOffsetX = c12.getVideoOffsetX() != null ? c12.getVideoOffsetX() : 0;
                        int iIntValue = (c12.getVideoOffsetY() != null ? c12.getVideoOffsetY() : 0).intValue();
                        Context context = getContext();
                        if (context != null && (resources = context.getResources()) != null) {
                            dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.heymelody_app_pairing_video_offset_y);
                        }
                        h.b(videoOffsetX);
                        melodyVideoAnimationView2.f21957u = videoOffsetX.intValue();
                        melodyVideoAnimationView2.f21958v = iIntValue + dimensionPixelOffset;
                        c13 = c12;
                        completableFutureB = melodyVideoAnimationView2.e(fileN).thenApplyAsync((Function<? super Uri, ? extends U>) new p(new X3.j(this, pairingState, c13, ref$ObjectRef, 0), 11), (Executor) o0.c.f1144b);
                        h.d(completableFutureB, "thenApplyAsync(...)");
                    }
                }
                completableFutureB.whenCompleteAsync((BiConsumer) new B9.b(new X3.i(this, c13, appCompatImageView, 0), 19), (Executor) o0.c.f1144b).exceptionally((Function) new A6.d(22));
            }
            completableFutureB = q0.b(MelodyException.e(404, "Video not found"));
        } else {
            completableFutureB = q0.b(MelodyException.e(415, "not support video"));
        }
        c13 = c12;
        completableFutureB.whenCompleteAsync((BiConsumer) new B9.b(new X3.i(this, c13, appCompatImageView, 0), 19), (Executor) o0.c.f1144b).exceptionally((Function) new A6.d(22));
    }
}
