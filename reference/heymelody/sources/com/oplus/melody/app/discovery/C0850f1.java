package com.oplus.melody.app.discovery;

import D7.C0379m;
import D7.C0381o;
import D7.C0388w;
import D7.o0;
import F8.i;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import c8.AbstractC0763a;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.signature.ObjectKey;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.repository.firmware.FirmwareDTO;
import com.oplus.melody.model.repository.headsettip.HeadsetTipCleanDTO;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.track.constant.AppConstant$ConnectResult;
import com.oplus.melody.track.constant.AppConstant$DialogType;
import com.oplus.melody.track.constant.AppConstant$UserAction;
import com.oplus.melody.ui.component.control.guide.GuideEntranceFragment;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import com.oplus.melody.ui.widget.MelodyCompatTextView;
import com.oplus.melody.ui.widget.MelodyVideoAnimationView;
import f8.AbstractC1048a;
import hb.C1098a;
import i2.C1136c;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import t8.C1532B;
import u8.C1557e;
import u8.C1558f;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.f1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DiscoveryViewStateConnectedImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0850f1 extends I0 {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public b0.J f19066A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public E0 f19067B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public C0381o<FirmwareDTO> f19068C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public long f19069D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public String f19070E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public SpannableStringBuilder f19071F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public P0 f19072G;
    public boolean H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f19073I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f19074J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public int f19075K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public int f19076L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public int f19077M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public final ImageView f19078N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public final View f19079O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public C0381o<ArrayList<HeadsetTipCleanDTO>> f19080P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public G0.c f19081Q;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MelodyVideoAnimationView f19082m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RunnableC0857i f19083n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final androidx.collection.b<String> f19084o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MelodyCompatButton f19085p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MelodyCompatButton f19086q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MelodyCompatButton f19087r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f19088s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f19089t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f19090u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f19091v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final View f19092w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public V0 f19093x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public RunnableC0878r0 f19094y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public U0 f19095z;

    @SuppressLint({"WrongConstant"})
    public C0850f1(DiscoveryDialogActivity discoveryDialogActivity, int i10) {
        super(discoveryDialogActivity, i10);
        this.f19084o = new androidx.collection.b<>(0);
        this.f19070E = null;
        this.f19071F = null;
        this.f19072G = null;
        this.H = false;
        this.f19074J = true;
        this.f19075K = -1;
        this.f19076L = 0;
        this.f19077M = -1;
        View view = discoveryDialogActivity.f18865l0;
        this.f19082m = (MelodyVideoAnimationView) view.findViewById(R.id.melody_app_discovery_video_view);
        this.f19092w = view.findViewById(R.id.melody_app_discovery_iv_tags);
        this.f19078N = (ImageView) view.findViewById(R.id.melody_app_discovery_strange_logo);
        this.f19079O = view.findViewById(R.id.melody_app_discovery_strange_logo_container);
        this.f19088s = this.f18938l.getDrawableColor();
        DiscoveryDialogActivity discoveryDialogActivity2 = this.f18929b;
        Objects.requireNonNull(discoveryDialogActivity2);
        this.f19083n = new RunnableC0857i(discoveryDialogActivity2, 2);
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final C1557e a(C1558f c1558f) {
        C1557e backConnectedState;
        return (this.f18930c.m() || (backConnectedState = c1558f.getBackConnectedState()) == null) ? c1558f.getConnectedState() : backConnectedState;
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final void f(final E0 e02) {
        super.f(e02);
        this.f18931d.setMaxLines(2);
        DiscoveryDialogViewModel discoveryDialogViewModel = this.f18930c;
        CompletableFuture<String> completableFutureG = discoveryDialogViewModel.g(e02);
        CompletableFuture<MelodyResourceDO> completableFutureC = c();
        BiFunction<? super String, ? super U, ? extends V> biFunction = new BiFunction() { // from class: com.oplus.melody.app.discovery.R0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                String string;
                String str = (String) obj;
                MelodyResourceDO melodyResourceDO = (MelodyResourceDO) obj2;
                C0850f1 c0850f1 = this.f18989a;
                DiscoveryDialogActivity discoveryDialogActivity = c0850f1.f18929b;
                DiscoveryDialogViewModel discoveryDialogViewModel2 = c0850f1.f18930c;
                if (melodyResourceDO != null && !TextUtils.isEmpty(melodyResourceDO.getText())) {
                    string = discoveryDialogViewModel2.f18891k ? melodyResourceDO.getText() : String.format(Locale.getDefault(), melodyResourceDO.getText(), str);
                } else if (TextUtils.isEmpty(str)) {
                    string = discoveryDialogActivity.getString(R.string.melody_app_discovery_connected);
                } else {
                    string = discoveryDialogActivity.getString(R.string.melody_app_discovery_connected) + ' ' + str;
                }
                MelodyCompatTextView melodyCompatTextView = c0850f1.f18931d;
                melodyCompatTextView.setText(string);
                if (!discoveryDialogViewModel2.l() && !discoveryDialogViewModel2.k()) {
                    return null;
                }
                E0 e03 = e02;
                if (e03.getAccountBindingState() != 3 || e03.getAccountBindingResultCode() != 4) {
                    return null;
                }
                melodyCompatTextView.setText(discoveryDialogActivity.getString(R.string.melody_common_earphone_account_binded, str));
                return null;
            }
        };
        h0.l lVar = o0.c.f1144b;
        completableFutureG.thenCombineAsync((CompletionStage) completableFutureC, biFunction, (Executor) lVar).exceptionally((Function<Throwable, ? extends V>) new C0867l0(5));
        DiscoveryDialogActivity discoveryDialogActivity = this.f18929b;
        discoveryDialogActivity.T().thenAcceptAsync((Consumer<? super C1>) new T0(this, e02, 0), (Executor) lVar).exceptionally((Function<Throwable, ? extends Void>) new C0388w(27));
        if (!discoveryDialogViewModel.f18894n || e02.getConnectState() == 2 || e02.getConnectState() == 1) {
            return;
        }
        com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "isConnectedWithGuideButton earphone disconnected");
        discoveryDialogActivity.O();
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final CompletableFuture<Integer> g(int i10, C1 c12) {
        String string;
        final View.OnClickListener w02;
        C1557e c1557eA;
        AppConstant$ConnectResult appConstant$ConnectResult;
        WhitelistConfigDTO.Function function;
        WhitelistConfigDTO.Function function2;
        WhitelistConfigDTO.Function function3;
        WhitelistConfigDTO.Function function4;
        int i11 = 3;
        final int i12 = 2;
        final int i13 = 1;
        s();
        final int i14 = 0;
        this.f19076L = 0;
        C1557e c1557eB = b(c12);
        if (c1557eB != null) {
            this.f19076L = c1557eB.getBatteryGroupStyle();
            this.f19074J = c1557eB.getShowTitleRes();
        }
        if (!this.f19074J) {
            this.f18931d.setVisibility(8);
        }
        int i15 = this.f19076L;
        View rootView = this.f18929b.f18865l0;
        kotlin.jvm.internal.h.e(rootView, "rootView");
        com.oplus.melody.common.util.A.c("DiscoveryBatteryGroup", new D7.L(i15, 25));
        G0.c c0854h = (i15 == 1 || i15 == 2 || i15 == 3) ? new C0854h(R.id.melody_app_discovery_connected_batteries_vertical, rootView) : i15 != 4 ? new C0851g(rootView) : new C0854h(R.id.melody_app_discovery_connected_batteries_horizontal, rootView);
        this.f19081Q = c0854h;
        c0854h.v(this.f19073I);
        this.f18936j.setOnClickListener(new View.OnClickListener(this) { // from class: com.oplus.melody.app.discovery.b1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C0850f1 f19043b;

            {
                this.f19043b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i16 = 0;
                switch (i14) {
                    case 0:
                        C0850f1 c0850f1 = this.f19043b;
                        c0850f1.getClass();
                        c0850f1.i(new O0(c0850f1, i16));
                        break;
                    case 1:
                        C0850f1 c0850f12 = this.f19043b;
                        c0850f12.getClass();
                        com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "onClick guideBtn 1");
                        E0 e0D = c0850f12.d();
                        if (e0D != null) {
                            c0850f12.f18929b.L();
                            E8.a.w().getClass();
                            Jb.b<List<Wb.l<String, Class<?>>>> bVar = F8.i.f1668g;
                            F8.i iVarA = i.a.a("/ui/guide");
                            iVarA.f("device_mac_info", e0D.getId());
                            iVarA.f("product_id", e0D.getProductId());
                            iVarA.f("product_color", String.valueOf(e0D.getProductColorId()));
                            iVarA.a(1);
                            iVarA.b(C0906l.f19501a);
                            c0850f12.f18929b.R();
                        }
                        c0850f12.n(AppConstant$UserAction.ACTION_GO_GUIDE);
                        break;
                    default:
                        C0850f1 c0850f13 = this.f19043b;
                        c0850f13.getClass();
                        c0850f13.i(new X0(c0850f13, i16));
                        break;
                }
            }
        });
        this.f19069D = SystemClock.elapsedRealtime();
        WhitelistConfigDTO whitelistConfigDTOE = I0.e(this.f18934g);
        if (whitelistConfigDTOE == null || (function4 = whitelistConfigDTOE.getFunction()) == null || !com.oplus.melody.common.util.Y.e(function4.getFunctionGuide(), false) || !this.f18930c.m()) {
            string = null;
            w02 = null;
        } else {
            string = this.f18929b.getString(R.string.melody_common_new_fun_guide);
            w02 = new View.OnClickListener(this) { // from class: com.oplus.melody.app.discovery.b1

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ C0850f1 f19043b;

                {
                    this.f19043b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i16 = 0;
                    switch (i13) {
                        case 0:
                            C0850f1 c0850f1 = this.f19043b;
                            c0850f1.getClass();
                            c0850f1.i(new O0(c0850f1, i16));
                            break;
                        case 1:
                            C0850f1 c0850f12 = this.f19043b;
                            c0850f12.getClass();
                            com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "onClick guideBtn 1");
                            E0 e0D = c0850f12.d();
                            if (e0D != null) {
                                c0850f12.f18929b.L();
                                E8.a.w().getClass();
                                Jb.b<List<Wb.l<String, Class<?>>>> bVar = F8.i.f1668g;
                                F8.i iVarA = i.a.a("/ui/guide");
                                iVarA.f("device_mac_info", e0D.getId());
                                iVarA.f("product_id", e0D.getProductId());
                                iVarA.f("product_color", String.valueOf(e0D.getProductColorId()));
                                iVarA.a(1);
                                iVarA.b(C0906l.f19501a);
                                c0850f12.f18929b.R();
                            }
                            c0850f12.n(AppConstant$UserAction.ACTION_GO_GUIDE);
                            break;
                        default:
                            C0850f1 c0850f13 = this.f19043b;
                            c0850f13.getClass();
                            c0850f13.i(new X0(c0850f13, i16));
                            break;
                    }
                }
            };
        }
        E0 e0D = d();
        String id = e0D != null ? e0D.getId() : "";
        com.oplus.melody.common.util.P p6 = com.oplus.melody.common.util.P.f19456a;
        boolean zC = com.oplus.melody.common.util.P.c(this.f18929b, "headset_channel");
        com.oplus.melody.common.util.A.c("DiscoveryViewStateConnectedImpl", new A9.i(16, zC));
        if (!zC && !"onForwardConnectedPopup".equals(this.f18930c.f18890j) && !this.f18930c.m()) {
            C0381o<ArrayList<HeadsetTipCleanDTO>> c0381o = this.f19080P;
            if (c0381o != null) {
                c0381o.a();
            }
            Object obj = AbstractC1048a.f23118c;
            this.f19080P = C0379m.j(C0379m.b(AbstractC1048a.C0250a.a().b()), this.f18929b, new androidx.lifecycle.v() { // from class: com.oplus.melody.app.discovery.d1
                @Override // androidx.lifecycle.v
                public final void onChanged(Object obj2) {
                    ArrayList arrayList = (ArrayList) obj2;
                    C0850f1 c0850f1 = this.f19055a;
                    c0850f1.getClass();
                    com.oplus.melody.common.util.A.c("DiscoveryViewStateConnectedImpl", new C0846e0(arrayList, 1));
                    E0 e0S = c0850f1.f18929b.S();
                    if (e0S == null) {
                        com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "mTipObserver earphone is null");
                    } else {
                        arrayList.forEach(new T0(c0850f1, e0S, 1));
                    }
                }
            });
            C0381o<FirmwareDTO> c0381o2 = this.f19068C;
            if (c0381o2 != null) {
                c0381o2.a();
            }
            this.f19068C = C0379m.j(AbstractC0763a.e().c(id), this.f18929b, new Y0(this, i13));
        }
        if (e0D != null) {
            boolean z2 = e0D.getAccountBindingState() == 3 || e0D.getAccountBindingState() == 5;
            int accountBindingResultCode = e0D.getAccountBindingResultCode();
            if (z2) {
                switch (accountBindingResultCode) {
                    case 1:
                    case 7:
                    case 8:
                        appConstant$ConnectResult = AppConstant$ConnectResult.FAIL;
                        break;
                    case 2:
                        appConstant$ConnectResult = AppConstant$ConnectResult.FAIL_BIND_ACCOUNT_BY_FIRMWARE;
                        break;
                    case 3:
                        appConstant$ConnectResult = AppConstant$ConnectResult.FAIL_BIND_ACCOUNT_BY_MY_DEVICE;
                        break;
                    case 4:
                    default:
                        appConstant$ConnectResult = AppConstant$ConnectResult.SUCCESS;
                        break;
                    case 5:
                        appConstant$ConnectResult = AppConstant$ConnectResult.SUCCESS_SYNC_LATER;
                        break;
                    case 6:
                        appConstant$ConnectResult = AppConstant$ConnectResult.FAIL_BIND_ACCOUNT_BY_LOGIN_EXPIRED;
                        break;
                }
            } else {
                appConstant$ConnectResult = AppConstant$ConnectResult.SUCCESS;
            }
            this.f18935i = appConstant$ConnectResult;
            if (com.oplus.melody.common.util.S.t(C0906l.f19501a)) {
                if (this.f18930c.m()) {
                    this.h = AppConstant$DialogType.NORMAL_CONNECT;
                    int i16 = R.string.melody_common_control_guide_title;
                    if (z2) {
                        this.h = AppConstant$DialogType.CONNECT_BY_ACCOUNT;
                        int i17 = (whitelistConfigDTOE == null || (function3 = whitelistConfigDTOE.getFunction()) == null || !com.oplus.melody.common.util.Y.e(function3.getNewFunctionGuide(), false)) ? -1 : R.string.melody_common_new_fun_guide;
                        if (whitelistConfigDTOE == null || (function2 = whitelistConfigDTOE.getFunction()) == null || (!com.oplus.melody.common.util.Y.e(function2.getTutorialGuide(), false) && !com.oplus.melody.common.util.Y.e(function2.getFunctionIntroductionGuide(), false))) {
                            i16 = i17;
                        }
                        if (i16 != -1) {
                            string = this.f18929b.getString(i16);
                            w02 = new W0(this, i12);
                        }
                    } else if (whitelistConfigDTOE != null && (function = whitelistConfigDTOE.getFunction()) != null && ((com.oplus.melody.common.util.Y.e(function.getControlGuideSupport(), false) || com.oplus.melody.common.util.Y.e(function.getTutorialGuide(), false) || com.oplus.melody.common.util.Y.e(function.getFunctionIntroductionGuide(), false)) && !t8.q.c("melody-model-settings").getBoolean(String.valueOf(id.hashCode()), false))) {
                        string = this.f18929b.getString(R.string.melody_common_control_guide_title);
                        w02 = new View.OnClickListener(this) { // from class: com.oplus.melody.app.discovery.c1

                            /* JADX INFO: renamed from: b, reason: collision with root package name */
                            public final /* synthetic */ C0850f1 f19049b;

                            {
                                this.f19049b = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                switch (i13) {
                                    case 0:
                                        C0850f1 c0850f1 = this.f19049b;
                                        c0850f1.getClass();
                                        c0850f1.i(new X0(c0850f1, 1));
                                        break;
                                    default:
                                        C0850f1 c0850f12 = this.f19049b;
                                        c0850f12.getClass();
                                        com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "onClick guideBtn 3");
                                        c0850f12.q(false);
                                        c0850f12.n(AppConstant$UserAction.ACTION_GO_GUIDE);
                                        break;
                                }
                            }
                        };
                    }
                } else {
                    if (com.oplus.melody.common.util.A.l()) {
                        com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "onEnter not new discovery multiConnectSwitchStatus=" + e0D.getMultiConnectSwitchStatus());
                    }
                    this.h = AppConstant$DialogType.NORMAL_BACK_CONNECT;
                    if (z2) {
                        this.h = AppConstant$DialogType.BACK_CONNECT_BY_ACCOUNT;
                    }
                }
            }
        }
        C1558f discoveryStates = c12.getDiscoveryStates();
        long closeDelay = (discoveryStates == null || (c1557eA = a(discoveryStates)) == null || c1557eA.getCloseDelay() <= 0) ? 5000L : c1557eA.getCloseDelay();
        Handler handler = this.f18929b.f18850W;
        handler.removeCallbacks(this.f19083n);
        if (!this.f18930c.m() || string == null) {
            this.f18930c.f18894n = false;
            handler.postDelayed(this.f19083n, closeDelay);
        } else {
            this.f18930c.f18894n = true;
        }
        if (string != null) {
            MelodyCompatButton melodyCompatButton = this.f18938l;
            this.f19085p = melodyCompatButton;
            melodyCompatButton.setText(string);
            this.f19085p.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.melody.app.discovery.e1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C0850f1 c0850f1 = this.f19060a;
                    c0850f1.getClass();
                    c0850f1.i(new RunnableC0871n0(2, w02, view));
                }
            });
            if (!this.f18930c.m()) {
                MelodyCompatButton melodyCompatButton2 = this.f18937k;
                this.f19087r = melodyCompatButton2;
                melodyCompatButton2.setText(R.string.melody_app_discovery_done);
                this.f19087r.setOnClickListener(new View.OnClickListener(this) { // from class: com.oplus.melody.app.discovery.b1

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ C0850f1 f19043b;

                    {
                        this.f19043b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i162 = 0;
                        switch (i12) {
                            case 0:
                                C0850f1 c0850f1 = this.f19043b;
                                c0850f1.getClass();
                                c0850f1.i(new O0(c0850f1, i162));
                                break;
                            case 1:
                                C0850f1 c0850f12 = this.f19043b;
                                c0850f12.getClass();
                                com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "onClick guideBtn 1");
                                E0 e0D2 = c0850f12.d();
                                if (e0D2 != null) {
                                    c0850f12.f18929b.L();
                                    E8.a.w().getClass();
                                    Jb.b<List<Wb.l<String, Class<?>>>> bVar = F8.i.f1668g;
                                    F8.i iVarA = i.a.a("/ui/guide");
                                    iVarA.f("device_mac_info", e0D2.getId());
                                    iVarA.f("product_id", e0D2.getProductId());
                                    iVarA.f("product_color", String.valueOf(e0D2.getProductColorId()));
                                    iVarA.a(1);
                                    iVarA.b(C0906l.f19501a);
                                    c0850f12.f18929b.R();
                                }
                                c0850f12.n(AppConstant$UserAction.ACTION_GO_GUIDE);
                                break;
                            default:
                                C0850f1 c0850f13 = this.f19043b;
                                c0850f13.getClass();
                                c0850f13.i(new X0(c0850f13, i162));
                                break;
                        }
                    }
                });
            }
        } else {
            MelodyCompatButton melodyCompatButton3 = this.f18937k;
            this.f19086q = melodyCompatButton3;
            melodyCompatButton3.setText(R.string.melody_app_discovery_settings);
            this.f19086q.setOnClickListener(new W0(this, i11));
            if (!this.f18930c.m()) {
                MelodyResourceDO btnPrimaryRes = c1557eB != null ? c1557eB.getBtnPrimaryRes() : null;
                DiscoveryDialogActivity discoveryDialogActivity = this.f18929b;
                ConcurrentHashMap concurrentHashMap = C1532B.f27917a;
                Integer numC = btnPrimaryRes == null ? null : C1532B.c(discoveryDialogActivity, btnPrimaryRes.getGradientStartColor(), btnPrimaryRes.getGradientStartColorNight());
                Integer numC2 = btnPrimaryRes == null ? null : C1532B.c(this.f18929b, btnPrimaryRes.getGradientEndColor(), btnPrimaryRes.getGradientEndColorNight());
                if (numC != null && numC2 != null) {
                    this.f19089t = true;
                    this.f19090u = numC.intValue();
                    this.f19091v = numC2.intValue();
                }
                MelodyCompatButton melodyCompatButton4 = this.f18938l;
                this.f19087r = melodyCompatButton4;
                melodyCompatButton4.setText(R.string.melody_app_discovery_done);
                this.f19087r.setOnClickListener(new W0(this, i13));
            }
        }
        boolean z4 = this.f18930c.m() && string != null && c1557eB != null && Boolean.TRUE.equals(c1557eB.getShowCancelBesidePrimary());
        if (z4) {
            this.f18937k.setVisibility(0);
            this.f18937k.setText(R.string.melody_app_discovery_done);
            this.f18937k.setOnClickListener(new View.OnClickListener(this) { // from class: com.oplus.melody.app.discovery.c1

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ C0850f1 f19049b;

                {
                    this.f19049b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i14) {
                        case 0:
                            C0850f1 c0850f1 = this.f19049b;
                            c0850f1.getClass();
                            c0850f1.i(new X0(c0850f1, 1));
                            break;
                        default:
                            C0850f1 c0850f12 = this.f19049b;
                            c0850f12.getClass();
                            com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "onClick guideBtn 3");
                            c0850f12.q(false);
                            c0850f12.n(AppConstant$UserAction.ACTION_GO_GUIDE);
                            break;
                    }
                }
            });
        }
        this.f18931d.setOnVisibilityChangedConsumer(new C0892y0(this, 1));
        if (com.oplus.melody.common.util.A.l()) {
            StringBuilder sbI = androidx.media3.session.D0.i("onEnter guideBtnText:", string, " isFromNewDiscovery:");
            sbI.append(this.f18930c.m());
            com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", sbI.toString());
        }
        if (z4) {
            o(this.f18937k, this.f19085p);
        } else {
            o(this.f19086q, this.f19085p, this.f19087r);
        }
        if (this.f19089t) {
            MelodyCompatButton melodyCompatButton5 = this.f18938l;
            melodyCompatButton5.setDrawableColor(0);
            float dimension = this.f18929b.getResources().getDimension(R.dimen.melody_app_discovery_button_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{this.f19090u, this.f19091v});
            gradientDrawable.setCornerRadius(dimension);
            melodyCompatButton5.setBackground(gradientDrawable);
        }
        t(c12, false);
        return super.g(i10, c12);
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final CompletableFuture<Integer> h(int i10) {
        int i11 = 2;
        MelodyCompatTextView melodyCompatTextView = this.f18932e;
        MelodyCompatTextView melodyCompatTextView2 = this.f18931d;
        C0381o<FirmwareDTO> c0381o = this.f19068C;
        if (c0381o != null) {
            c0381o.a();
            this.f19068C = null;
        }
        C0381o<ArrayList<HeadsetTipCleanDTO>> c0381o2 = this.f19080P;
        if (c0381o2 != null) {
            c0381o2.a();
            this.f19080P = null;
        }
        melodyCompatTextView2.setOnVisibilityChangedConsumer(null);
        melodyCompatTextView.setOnClickListener(null);
        this.f18930c.f18894n = false;
        s();
        Handler handler = this.f18929b.f18850W;
        handler.removeCallbacks(this.f19083n);
        handler.removeCallbacks(this.f19093x);
        handler.removeCallbacks(this.f19094y);
        handler.removeCallbacks(this.f19095z);
        handler.removeCallbacks(this.f19066A);
        LinkedList linkedList = new LinkedList();
        G0.c cVar = this.f19081Q;
        if (cVar != null) {
            linkedList.addAll(cVar.h());
        } else {
            com.oplus.melody.common.util.A.x("DiscoveryViewStateConnectedImpl", "onExit mBatteryGroup is null");
        }
        linkedList.addAll(Arrays.asList(this.f18937k, this.f18938l, this.f19085p, this.f19086q, this.f19087r, melodyCompatTextView2, melodyCompatTextView, this.f19092w, this.f19078N));
        return super.h(i10).thenCompose((Function<? super Integer, ? extends CompletionStage<U>>) new C0894z0(i10, linkedList, i11));
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final void k(C1 c12) {
        C1557e c1557eB = b(c12);
        String maskColor = c1557eB != null ? c1557eB.getMaskColor() : null;
        int componentUiMode = c1557eB != null ? c1557eB.getComponentUiMode() : 0;
        DiscoveryDialogActivity discoveryDialogActivity = this.f18929b;
        if ((componentUiMode == 2 || (componentUiMode == 0 && com.oplus.drs.core.d.v(discoveryDialogActivity))) && maskColor != null) {
            try {
                com.oplus.melody.common.util.A.c("DiscoveryViewStateConnectedImpl", new C0839c(maskColor, 5));
                discoveryDialogActivity.f18876w0.setBackgroundColor(Color.parseColor(maskColor));
            } catch (Exception e10) {
                com.oplus.melody.common.util.A.i("DiscoveryViewStateConnectedImpl", "showBackgroundMask maskColor", e10);
            }
        }
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final void l(C1 c12) {
        MelodyResourceDO bgImageRes;
        C1557e c1557eB = b(c12);
        if (c1557eB == null || (bgImageRes = c1557eB.getBgImageRes()) == null) {
            return;
        }
        r(this.f18929b.f18875v0, com.oplus.drs.core.d.n(C0906l.f19501a, bgImageRes, c12.getRootPath()), true);
        final double luminance = bgImageRes.getLuminance();
        final int componentUiMode = c1557eB.getComponentUiMode();
        com.oplus.melody.common.util.A.c("DiscoveryViewStateConnectedImpl", new Supplier() { // from class: com.oplus.melody.app.discovery.Q0
            @Override // java.util.function.Supplier
            public final Object get() {
                return "showFullBackground luminance:" + luminance + " colorMode:" + componentUiMode;
            }
        });
        if (Q1.a.a(this.f18929b) || luminance >= 0.3d || componentUiMode != 0) {
            return;
        }
        this.f19073I = true;
        G0.c cVar = this.f19081Q;
        if (cVar != null) {
            cVar.v(true);
        } else {
            com.oplus.melody.common.util.A.x("DiscoveryViewStateConnectedImpl", "setLight mBatteryGroup is null");
        }
        DiscoveryDialogActivity.Q(this.f18929b.f18865l0);
    }

    @Override // com.oplus.melody.app.discovery.I0
    public final void m(C1 c12, boolean z2) {
        this.f18929b.f18863j0.setVisibility(8);
    }

    public final void q(boolean z2) {
        String str;
        E0 e0D = d();
        if (e0D == null) {
            return;
        }
        DiscoveryDialogActivity discoveryDialogActivity = this.f18929b;
        discoveryDialogActivity.L();
        WhitelistConfigDTO whitelistConfigDTOE = I0.e(e0D);
        if (whitelistConfigDTOE != null && whitelistConfigDTOE.getFunction() != null && (com.oplus.melody.common.util.Y.e(whitelistConfigDTOE.getFunction().getTutorialGuide(), false) || com.oplus.melody.common.util.Y.e(whitelistConfigDTOE.getFunction().getFunctionIntroductionGuide(), false))) {
            GuideEntranceFragment.GuideEntranceMode guideEntranceMode = GuideEntranceFragment.GuideEntranceMode.f20547a;
            str = "TUTORIAL_GUIDE";
        } else if (z2) {
            GuideEntranceFragment.GuideEntranceMode guideEntranceMode2 = GuideEntranceFragment.GuideEntranceMode.f20547a;
            str = "INTRO_TRIANGLE_AND_CONTROL_GUIDE";
        } else {
            GuideEntranceFragment.GuideEntranceMode guideEntranceMode3 = GuideEntranceFragment.GuideEntranceMode.f20547a;
            str = "INTRO_CONTROL_GUIDE";
        }
        DiscoveryDialogActivity.M(new V0(1, e0D, str));
        discoveryDialogActivity.R();
    }

    public final void r(ImageView imageView, File file, boolean z2) {
        String str = (String) imageView.getTag(R.id.melody_ui_image_path_tag);
        String str2 = file + "&transformation=null";
        if (TextUtils.equals(str, str2)) {
            com.oplus.melody.common.util.A.f("DiscoveryViewStateConnectedImpl", "loadImageView ignore " + str2);
            return;
        }
        imageView.setTag(R.id.melody_ui_image_path_tag, str2);
        DiscoveryDialogActivity discoveryDialogActivity = this.f18929b;
        if (str != null) {
            Glide.with((androidx.fragment.app.f) discoveryDialogActivity).clear(imageView);
        }
        RequestBuilder<Drawable> requestBuilderLoad = Glide.with((androidx.fragment.app.f) discoveryDialogActivity).load(file);
        if (z2) {
            requestBuilderLoad.signature(new ObjectKey(Long.valueOf(file.lastModified())));
        }
        requestBuilderLoad.into(imageView);
    }

    public final void s() {
        this.f19089t = false;
        int i10 = this.f19088s;
        MelodyCompatButton melodyCompatButton = this.f18938l;
        melodyCompatButton.setDrawableColor(i10);
        TypedArray typedArrayObtainStyledAttributes = null;
        melodyCompatButton.setBackground(null);
        melodyCompatButton.setScaleX(1.0f);
        melodyCompatButton.setScaleY(1.0f);
        Resources resources = melodyCompatButton.getResources();
        int i11 = melodyCompatButton.f13674D;
        String resourceTypeName = resources.getResourceTypeName(i11);
        boolean zEquals = "attr".equals(resourceTypeName);
        int[] iArr = C1098a.f23804a;
        if (zEquals) {
            typedArrayObtainStyledAttributes = melodyCompatButton.getContext().obtainStyledAttributes(null, iArr, i11, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArrayObtainStyledAttributes = melodyCompatButton.getContext().obtainStyledAttributes(null, iArr, 0, i11);
        }
        if (typedArrayObtainStyledAttributes != null) {
            melodyCompatButton.b(typedArrayObtainStyledAttributes);
            melodyCompatButton.f13699x = typedArrayObtainStyledAttributes.getColor(9, 0);
            melodyCompatButton.f13673C = typedArrayObtainStyledAttributes.getColor(19, 0);
            melodyCompatButton.setTextColor(typedArrayObtainStyledAttributes.getColorStateList(0));
            typedArrayObtainStyledAttributes.recycle();
        }
        C1136c c1136c = melodyCompatButton.f13691p;
        if (c1136c != null) {
            c1136c.a(melodyCompatButton.getContext());
        }
    }

    public final void t(C1 c12, boolean z2) {
        ImageView imageView = this.f19078N;
        if (imageView == null) {
            return;
        }
        C1557e c1557eB = b(c12);
        MelodyResourceDO logoRes = c1557eB != null ? c1557eB.getLogoRes() : null;
        String path = logoRes != null ? logoRes.getPath() : null;
        DiscoveryDialogActivity discoveryDialogActivity = this.f18929b;
        if (!discoveryDialogActivity.f18845I0 || TextUtils.isEmpty(path)) {
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        File fileO = com.oplus.drs.core.d.o(discoveryDialogActivity, c12.getRootPath(), path);
        if (fileO == null) {
            A6.b.g("updateStrangeLogo logo file missing: ", path, "DiscoveryViewStateConnectedImpl");
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        int iG = C1532B.g(discoveryDialogActivity, 0, TextUtils.isEmpty(logoRes.getBottom()) ? "90dp" : logoRes.getBottom());
        if (this.f19071F != null) {
            iG += (int) ((discoveryDialogActivity.getResources().getDisplayMetrics().density * 30.0f) + 0.5f);
        }
        View view = this.f19079O;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.bottomMargin != iG) {
                marginLayoutParams.bottomMargin = iG;
                view.setLayoutParams(marginLayoutParams);
            }
        }
        boolean zIsEmpty = TextUtils.isEmpty(logoRes.getWidth());
        boolean z4 = !zIsEmpty;
        boolean zIsEmpty2 = TextUtils.isEmpty(logoRes.getHeight());
        boolean z10 = !zIsEmpty2;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = !zIsEmpty ? C1532B.g(discoveryDialogActivity, 0, logoRes.getWidth()) : -2;
        layoutParams.height = zIsEmpty2 ? -2 : C1532B.g(discoveryDialogActivity, 0, logoRes.getHeight());
        imageView.setLayoutParams(layoutParams);
        imageView.setAdjustViewBounds(z4 != z10);
        imageView.setScaleType((zIsEmpty || zIsEmpty2) ? ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_XY);
        r(imageView, fileO, false);
        if (z2) {
            J6.d.c(imageView, null);
        } else {
            imageView.setVisibility(4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<android.view.View> u() {
        /*
            r6 = this;
            java.lang.String r0 = r6.f19070E
            com.oplus.melody.ui.widget.MelodyCompatTextView r1 = r6.f18932e
            if (r0 == 0) goto L1e
            r1.setText(r0)
            r0 = 0
            r1.setOnClickListener(r0)
            com.oplus.melody.app.discovery.DiscoveryDialogActivity r0 = r6.f18929b
            com.oplus.melody.app.discovery.E0 r0 = r0.S()
            if (r0 == 0) goto L2e
            java.lang.String r0 = r0.getId()
            com.oplus.melody.app.discovery.DiscoveryDialogViewModel r2 = r6.f18930c
            r2.f18889i = r0
            goto L2e
        L1e:
            android.text.SpannableStringBuilder r0 = r6.f19071F
            if (r0 == 0) goto L30
            r1.setText(r0)
            com.oplus.melody.app.discovery.W0 r0 = new com.oplus.melody.app.discovery.W0
            r2 = 0
            r0.<init>(r6, r2)
            r1.setOnClickListener(r0)
        L2e:
            r0 = 1
            goto L31
        L30:
            r0 = 0
        L31:
            java.util.List r2 = java.util.Collections.EMPTY_LIST
            com.oplus.melody.ui.widget.MelodyCompatTextView r3 = r6.f18931d
            int r3 = r3.getVisibility()
            r4 = 8
            android.view.View r5 = r6.f19092w
            if (r0 == 0) goto L4d
            java.util.List r2 = java.util.Collections.singletonList(r1)
            r1.setVisibility(r3)
            r5.setVisibility(r4)
            com.oplus.melody.app.discovery.I0.p(r1)
            goto L5f
        L4d:
            r1.setVisibility(r4)
            boolean r0 = r6.H
            if (r0 == 0) goto L5c
            java.util.List r2 = java.util.Collections.singletonList(r5)
            r5.setVisibility(r3)
            goto L5f
        L5c:
            r5.setVisibility(r4)
        L5f:
            D7.f0 r0 = new D7.f0
            r1 = 6
            r0.<init>(r6, r3, r1)
            java.lang.String r1 = "DiscoveryViewStateConnectedImpl"
            com.oplus.melody.common.util.A.c(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.app.discovery.C0850f1.u():java.util.List");
    }
}
