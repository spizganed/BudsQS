package com.oplus.melody.ui.component.detail.spatialaudio;

import A6.g;
import D7.C0371e;
import D7.C0372f;
import D7.C0373g;
import D7.C0379m;
import D7.RunnableC0380n;
import D7.o0;
import E9.e;
import E9.o;
import Ea.C0394c;
import Ea.D;
import Kb.k;
import Kb.q;
import R9.n;
import R9.p;
import Wb.l;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.i;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import com.google.android.material.appbar.AppBarLayout;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.iotui.model.ModeItem;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.B;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0908n;
import com.oplus.melody.common.util.C0909o;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.common.util.J;
import com.oplus.melody.common.util.S;
import com.oplus.melody.common.widget.transparentvideo.AlphaMovieView;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.ui.component.control.preference.MelodyTipsView;
import com.oplus.melody.ui.component.detail.gamemode.GameSetViewModel;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import com.oplus.melody.ui.widget.MelodyJumpPreference;
import com.oplus.melody.ui.widget.MelodyLottieAnimationView;
import com.oplus.melody.ui.widget.devicecontrol.DeviceControlWidget;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import s8.AbstractC1508a;
import t2.C1518c;
import t8.s;

/* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.spatialaudio.c, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SpatialAudioContentFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 i2\u00020\u0001:\u0001iB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J&\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u001a\u0010F\u001a\u00020=2\u0006\u0010G\u001a\u00020A2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020=2\u0006\u0010L\u001a\u00020AH\u0002J\b\u0010M\u001a\u00020=H\u0002J\u0012\u0010N\u001a\u00020=2\b\b\u0002\u0010O\u001a\u00020\u001bH\u0002J\b\u0010P\u001a\u00020=H\u0002J\b\u0010Q\u001a\u00020=H\u0002J\u0018\u0010R\u001a\u00020=2\u0006\u0010S\u001a\u00020T2\u0006\u0010G\u001a\u00020AH\u0002J\b\u0010U\u001a\u00020=H\u0002J\b\u0010V\u001a\u00020=H\u0002J\u0017\u0010W\u001a\u00020=2\b\u0010X\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010YJ\u0017\u0010Z\u001a\u00020=2\b\u0010X\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010YJ\b\u0010[\u001a\u00020=H\u0003J\u0010\u0010\\\u001a\u00020=2\u0006\u0010]\u001a\u00020\u001bH\u0002J0\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u001b2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020 2\u0006\u0010d\u001a\u00020\u001d2\u0006\u0010e\u001a\u00020\u001dH\u0002J\b\u0010f\u001a\u00020=H\u0016J\b\u0010g\u001a\u00020=H\u0016J\b\u0010h\u001a\u00020=H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b/\u00100R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/oplus/melody/ui/component/detail/spatialaudio/SpatialAudioContentFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "<init>", "()V", "mActiveVideoView", "Lcom/oplus/melody/common/widget/transparentvideo/AlphaMovieView;", "mControlView", "Lcom/oplus/melody/ui/widget/devicecontrol/DeviceControlWidget;", "mAudioPreviewLottie", "Lcom/oplus/melody/ui/widget/MelodyLottieAnimationView;", "mAudioPreviewTv", "Landroid/widget/TextView;", "mAudioPreviewLayout", "Landroid/widget/LinearLayout;", "mToolbar", "Lcom/oplus/melody/ui/widget/MelodyCompatToolbar;", "mJumpMusicView", "Lcom/oplus/melody/ui/widget/MelodyJumpPreference;", "mCOUIToolTips", "Lcom/coui/appcompat/tooltips/COUIToolTips;", "mSpatialAudioDes", "mSpatialAudioHint", "mScrollView", "Landroidx/core/widget/NestedScrollView;", "mSpatialTipsView", "Lcom/oplus/melody/ui/component/control/preference/MelodyTipsView;", "mConnectState", "", "mIsDisableByLeaModeInTutorialGuide", "", "mCurrentSpatialType", "mProductId", "", "mColorId", "mAddress", "mProductName", "mSpatialNewVersion", "mIsTutorialGuide", "mSpatialSwitching", "mSpatialVM", "Lcom/oplus/melody/ui/component/detail/spatialaudio/BaseSpatialAudioVM;", "getMSpatialVM", "()Lcom/oplus/melody/ui/component/detail/spatialaudio/BaseSpatialAudioVM;", "mSpatialVM$delegate", "Lkotlin/Lazy;", "mAudioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "getMAudioFocusChangeListener", "()Landroid/media/AudioManager$OnAudioFocusChangeListener;", "mAudioFocusChangeListener$delegate", "toolTipsRunnable", "Ljava/lang/Runnable;", "mGameSetVM", "Lcom/oplus/melody/ui/component/detail/gamemode/GameSetViewModel;", "mGameModeMainEnable", "mIsSelectGameSound", "mLowLatencyDisabled", "hasZipConfig", "mControlCallBack", "Lcom/oplus/melody/ui/widget/devicecontrol/DeviceControlWidget$OnActionListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "initView", "contentView", "initSpatialTipsView", "checkAndUpdateHeadTracker", "retryCnt", "initDataObserver", "initSpatialExperienceEntry", "initToolBar", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "initAudioPreview", "updatePreviewView", "playPreviewAudio", "spatialType", "(Ljava/lang/Integer;)V", "playPreviewVideo", "initControlItems", "onConnectionOrLeaStateChange", "connectState", "createModeItem", "Lcom/oplus/iotui/model/ModeItem;", "position", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "name", "selected", "needLoading", "onStop", "onDestroyView", "onDestroy", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SpatialAudioContentFragment extends F8.c {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public MelodyTipsView f21260A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f21261B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f21262C;
    public boolean H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f21267I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f21268J;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public GameSetViewModel f21272N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public boolean f21273O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f21274P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public boolean f21275Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public boolean f21276R;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AlphaMovieView f21278p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public DeviceControlWidget f21279q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MelodyLottieAnimationView f21280r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f21281s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LinearLayout f21282t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public MelodyCompatToolbar f21283u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public MelodyJumpPreference f21284v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public C1518c f21285w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f21286x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextView f21287y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public NestedScrollView f21288z;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f21263D = -1;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public String f21264E = "";

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public String f21265F = "";

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public String f21266G = "";

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final Jb.b f21269K = kotlin.a.a(new e(this, 7));

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public final Jb.b f21270L = kotlin.a.a(new J8.d(this, 4));

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public final RunnableC0380n f21271M = new RunnableC0380n(this, 24);

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public final a f21277S = new a();

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.spatialaudio.c$b */
    /* JADX INFO: compiled from: SpatialAudioContentFragment.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21290a;

        public b(l lVar) {
            this.f21290a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21290a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21290a.d(obj);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        WhitelistConfigDTO.Function function;
        String stringExtra;
        super.onCreate(savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        this.f21265F = intent != null ? intent.getStringExtra("device_mac_info") : null;
        this.f21266G = intent != null ? intent.getStringExtra("device_name") : null;
        this.f21264E = intent != null ? intent.getStringExtra("product_id") : null;
        if (intent != null && (stringExtra = intent.getStringExtra("product_color")) != null) {
            Integer.parseInt(stringExtra);
        }
        this.f21267I = intent != null && intent.getBooleanExtra("route_value", false);
        this.f21262C = intent != null && intent.getBooleanExtra("route_value2", false);
        h.b(intent);
        this.H = intent.getBooleanExtra("support_new_headset_spatial", false);
        if (TextUtils.isEmpty(this.f21265F)) {
            A.h("SpatialAudioContentFragment", "onCreate mAddress is empty");
            requireActivity().finish();
            return;
        }
        if (TextUtils.isEmpty(this.f21264E)) {
            A.h("SpatialAudioContentFragment", "onCreate productId is empty");
            requireActivity().finish();
            return;
        }
        if (TextUtils.isEmpty(this.f21266G)) {
            A.h("SpatialAudioContentFragment", "onCreate productName is empty");
            requireActivity().finish();
            return;
        }
        if (S.s(getActivity())) {
            WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(this.f21264E, this.f21266G);
            if (!C0901g.a((whitelistConfigDTOC == null || (function = whitelistConfigDTOC.getFunction()) == null) ? null : function.getGameSoundList())) {
                O store = getViewModelStore();
                N.b factory = getDefaultViewModelProviderFactory();
                W.a defaultViewModelCreationExtras = getDefaultViewModelCreationExtras();
                h.e(store, "store");
                h.e(factory, "factory");
                X.d dVarB = g.b(defaultViewModelCreationExtras, "defaultCreationExtras", store, factory, defaultViewModelCreationExtras);
                kotlin.jvm.internal.b bVarA = j.a(GameSetViewModel.class);
                String strA = bVarA.a();
                if (strA == null) {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
                this.f21272N = (GameSetViewModel) dVarB.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
                String str = this.f21265F;
                h.b(str);
                GameSetViewModel.e(str).e(this, new b(new Aa.b(this, 19)));
                if (this.f21272N != null) {
                    String str2 = this.f21265F;
                    h.b(str2);
                    GameSetViewModel.g(str2).e(this, new b(new A9.j(this, 14)));
                }
                if (this.f21272N != null) {
                    String str3 = this.f21265F;
                    h.b(str3);
                    GameSetViewModel.f(str3).e(this, new b(new B9.d(this, 16)));
                }
            }
        }
        Bundle arguments = getArguments();
        p pVar = (p) C0917x.c(p.class, arguments != null ? arguments.getString("resZipConfig") : null);
        this.f21276R = pVar != null;
        A.c("SpatialAudioContentFragment", new P3.d(this, 10));
        C1518c c1518c = new C1518c(requireContext(), 0);
        c1518c.n(false);
        this.f21285w = c1518c;
        BaseSpatialAudioVM baseSpatialAudioVMT = t();
        Context contextRequireContext = requireContext();
        h.d(contextRequireContext, "requireContext(...)");
        String str4 = this.f21265F;
        h.b(str4);
        baseSpatialAudioVMT.f(contextRequireContext, str4, pVar);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        return inflater.inflate(R.layout.melody_ui_spatial_audio_content_view, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        t().h();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        C1518c c1518c = this.f21285w;
        if (c1518c == null) {
            h.i("mCOUIToolTips");
            throw null;
        }
        if (c1518c.isShowing()) {
            C1518c c1518c2 = this.f21285w;
            if (c1518c2 == null) {
                h.i("mCOUIToolTips");
                throw null;
            }
            c1518c2.dismiss();
        }
        DeviceControlWidget deviceControlWidget = this.f21279q;
        if (deviceControlWidget != null) {
            deviceControlWidget.removeCallbacks(this.f21271M);
        } else {
            h.i("mControlView");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() == 16908332) {
            A.b("SpatialAudioContentFragment", "onOptionsItemSelected home");
            requireActivity().finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        try {
            A.c("SpatialAudioContentFragment", new C0372f(6));
            J.a.f19444a.e();
        } catch (Exception e10) {
            A.i("SpatialAudioContentFragment", "onStop, stop MediaPlayer, error: ", e10);
        }
        B.a.f19427a.a((AudioManager.OnAudioFocusChangeListener) this.f21270L.getValue(), "SpatialAudioContentFragment");
        LinearLayout linearLayout = this.f21282t;
        if (linearLayout == null) {
            h.i("mAudioPreviewLayout");
            throw null;
        }
        linearLayout.setSelected(false);
        v();
        C1518c c1518c = this.f21285w;
        if (c1518c == null) {
            h.i("mCOUIToolTips");
            throw null;
        }
        if (c1518c.isShowing()) {
            C1518c c1518c2 = this.f21285w;
            if (c1518c2 != null) {
                c1518c2.dismiss();
            } else {
                h.i("mCOUIToolTips");
                throw null;
            }
        }
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        boolean z2;
        WhitelistConfigDTO.Function function;
        List<Integer> spatialTypes;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (this.f21267I) {
            ((AppBarLayout) view.findViewById(R.id.appbar_layout)).setVisibility(8);
        } else {
            C0909o.h(requireActivity(), getResources().getColor(R.color.coui_color_background_with_card));
            androidx.fragment.app.f fVarRequireActivity = requireActivity();
            h.c(fVarRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            i iVar = (i) fVarRequireActivity;
            View viewFindViewById = view.findViewById(R.id.toolbar);
            h.d(viewFindViewById, "findViewById(...)");
            MelodyCompatToolbar melodyCompatToolbar = (MelodyCompatToolbar) viewFindViewById;
            this.f21283u = melodyCompatToolbar;
            melodyCompatToolbar.setBackgroundColor(iVar.getColor(R.color.coui_color_background_with_card));
            MelodyCompatToolbar melodyCompatToolbar2 = this.f21283u;
            if (melodyCompatToolbar2 == null) {
                h.i("mToolbar");
                throw null;
            }
            String str = this.f21264E;
            h.b(str);
            String str2 = this.f21266G;
            h.b(str2);
            melodyCompatToolbar2.setTitle(n.b(str, str2));
            MelodyCompatToolbar melodyCompatToolbar3 = this.f21283u;
            if (melodyCompatToolbar3 == null) {
                h.i("mToolbar");
                throw null;
            }
            iVar.y(melodyCompatToolbar3);
            androidx.appcompat.app.a aVarX = iVar.x();
            setHasOptionsMenu(true);
            if (aVarX != null) {
                aVarX.n(true);
                aVarX.r(true);
            }
        }
        View viewFindViewById2 = view.findViewById(R.id.modeActionView);
        h.d(viewFindViewById2, "findViewById(...)");
        this.f21279q = (DeviceControlWidget) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.spatial_audio_jump_music);
        h.d(viewFindViewById3, "findViewById(...)");
        this.f21284v = (MelodyJumpPreference) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.spatial_video);
        h.d(viewFindViewById4, "findViewById(...)");
        this.f21278p = (AlphaMovieView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.tvTips);
        h.d(viewFindViewById5, "findViewById(...)");
        this.f21286x = (TextView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.spatial_hint);
        h.d(viewFindViewById6, "findViewById(...)");
        this.f21287y = (TextView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.spatial_audio_preview);
        h.d(viewFindViewById7, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById7;
        this.f21282t = linearLayout;
        View viewFindViewById8 = linearLayout.findViewById(R.id.lottie_music_preview);
        h.d(viewFindViewById8, "findViewById(...)");
        this.f21280r = (MelodyLottieAnimationView) viewFindViewById8;
        LinearLayout linearLayout2 = this.f21282t;
        if (linearLayout2 == null) {
            h.i("mAudioPreviewLayout");
            throw null;
        }
        View viewFindViewById9 = linearLayout2.findViewById(R.id.tv_music_preview);
        h.d(viewFindViewById9, "findViewById(...)");
        this.f21281s = (TextView) viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.scroll_view);
        h.d(viewFindViewById10, "findViewById(...)");
        this.f21288z = (NestedScrollView) viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.divider_line);
        if (viewFindViewById11 != null) {
            NestedScrollView nestedScrollView = this.f21288z;
            if (nestedScrollView == null) {
                h.i("mScrollView");
                throw null;
            }
            new C0394c(nestedScrollView).a(viewFindViewById11);
        }
        DeviceControlWidget deviceControlWidget = this.f21279q;
        if (deviceControlWidget == null) {
            h.i("mControlView");
            throw null;
        }
        deviceControlWidget.setOnActionListener(this.f21277S);
        View viewFindViewById12 = view.findViewById(R.id.spatial_audio_tips);
        h.d(viewFindViewById12, "findViewById(...)");
        this.f21260A = (MelodyTipsView) viewFindViewById12;
        if (!this.f21276R) {
            AlphaMovieView alphaMovieView = this.f21278p;
            if (alphaMovieView == null) {
                h.i("mActiveVideoView");
                throw null;
            }
            alphaMovieView.setVisibility(8);
            LinearLayout linearLayout3 = this.f21282t;
            if (linearLayout3 == null) {
                h.i("mAudioPreviewLayout");
                throw null;
            }
            linearLayout3.setVisibility(8);
        }
        if (this.f21267I) {
            view.setBackground(null);
            ((RelativeLayout) view.findViewById(R.id.video_and_mode)).setBackground(null);
            LinearLayout linearLayout4 = this.f21282t;
            if (linearLayout4 == null) {
                h.i("mAudioPreviewLayout");
                throw null;
            }
            linearLayout4.setVisibility(8);
            AlphaMovieView alphaMovieView2 = this.f21278p;
            if (alphaMovieView2 == null) {
                h.i("mActiveVideoView");
                throw null;
            }
            alphaMovieView2.setVisibility(8);
            MelodyJumpPreference melodyJumpPreference = this.f21284v;
            if (melodyJumpPreference == null) {
                h.i("mJumpMusicView");
                throw null;
            }
            melodyJumpPreference.setVisibility(8);
            MelodyTipsView melodyTipsView = this.f21260A;
            if (melodyTipsView == null) {
                h.i("mSpatialTipsView");
                throw null;
            }
            melodyTipsView.setVisibility(8);
            NestedScrollView nestedScrollView2 = this.f21288z;
            if (nestedScrollView2 == null) {
                h.i("mScrollView");
                throw null;
            }
            nestedScrollView2.setNestedScrollingEnabled(false);
            NestedScrollView nestedScrollView3 = this.f21288z;
            if (nestedScrollView3 == null) {
                h.i("mScrollView");
                throw null;
            }
            ViewGroup.LayoutParams layoutParams = nestedScrollView3.getLayoutParams();
            h.c(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) layoutParams)).topMargin = getResources().getDimensionPixelOffset(R.dimen.melody_ui_tutorial_guide_spatial_margin_top);
        } else {
            if (!S.s(requireContext())) {
                J7.b.a().d();
            }
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                h.i("context");
                throw null;
            }
            if ("com.heytap.headset".equals(heyMelodyApplication.getPackageName())) {
                A.b("SpatialAudioContentFragment", "initSpatialTipsView is HeyMelody");
            } else if (C0373g.h) {
                Intent intent = new Intent("oplus.intent.action.settings.HOLO_AUDIO");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setPackage("com.android.settings");
                HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
                if (heyMelodyApplication2 == null) {
                    h.i("context");
                    throw null;
                }
                if (intent.resolveActivity(heyMelodyApplication2.getPackageManager()) != null) {
                    MelodyTipsView melodyTipsView2 = this.f21260A;
                    if (melodyTipsView2 == null) {
                        h.i("mSpatialTipsView");
                        throw null;
                    }
                    melodyTipsView2.setVisibility(0);
                    MelodyTipsView melodyTipsView3 = this.f21260A;
                    if (melodyTipsView3 == null) {
                        h.i("mSpatialTipsView");
                        throw null;
                    }
                    melodyTipsView3.setTipItems(k.b(getString(R.string.melody_ui_holographic_audio_title_v2)));
                    MelodyTipsView melodyTipsView4 = this.f21260A;
                    if (melodyTipsView4 == null) {
                        h.i("mSpatialTipsView");
                        throw null;
                    }
                    melodyTipsView4.setItemClickListener(new R9.l(this, intent));
                } else {
                    A.b("SpatialAudioContentFragment", "meta audio activity not exist");
                }
            } else {
                A.b("SpatialAudioContentFragment", "meta audio not support");
            }
        }
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(this.f21264E, this.f21266G);
        ArrayList arrayList = new ArrayList();
        if (whitelistConfigDTOC == null || (function = whitelistConfigDTOC.getFunction()) == null || (spatialTypes = function.getSpatialTypes()) == null) {
            z2 = false;
        } else {
            Iterator<T> it = spatialTypes.iterator();
            z2 = false;
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (iIntValue == 0) {
                    Drawable drawableM = com.oplus.drs.core.d.m(requireContext(), R.drawable.melody_ui_spatial_audio_closed);
                    h.b(drawableM);
                    String string = requireContext().getString(R.string.melody_ui_switch_spatial_audio_close);
                    h.d(string, "getString(...)");
                    arrayList.add(s(0, drawableM, string));
                } else if (iIntValue == 1) {
                    Drawable drawableM2 = com.oplus.drs.core.d.m(requireContext(), R.drawable.melody_ui_spatial_audio_fixed);
                    h.b(drawableM2);
                    String string2 = (t8.v.b(this.f21265F) || this.H) ? requireContext().getString(R.string.melody_ui_switch_spatial_audio_fixed) : requireContext().getString(R.string.melody_ui_switch_spatial_audio_open);
                    h.b(string2);
                    arrayList.add(s(1, drawableM2, string2));
                } else if (iIntValue == 2) {
                    Drawable drawableM3 = com.oplus.drs.core.d.m(requireContext(), R.drawable.melody_ui_spatial_audio_header);
                    h.b(drawableM3);
                    String string3 = requireContext().getString(R.string.melody_ui_switch_spatial_audio_follow_head);
                    h.d(string3, "getString(...)");
                    arrayList.add(s(2, drawableM3, string3));
                    z2 = true;
                }
            }
        }
        DeviceControlWidget deviceControlWidget2 = this.f21279q;
        if (deviceControlWidget2 == null) {
            h.i("mControlView");
            throw null;
        }
        deviceControlWidget2.b(arrayList);
        TextView textView = this.f21287y;
        if (textView == null) {
            h.i("mSpatialAudioHint");
            throw null;
        }
        String str3 = this.f21264E;
        h.b(str3);
        String str4 = this.f21266G;
        h.b(str4);
        HeyMelodyApplication heyMelodyApplication3 = C0906l.f19501a;
        if (heyMelodyApplication3 == null) {
            h.i("context");
            throw null;
        }
        String string4 = heyMelodyApplication3.getString(R.string.melody_ui_spatial_audio_options_title_new, n.a(str3, str4));
        h.d(string4, "getString(...)");
        textView.setText(string4);
        if (!z2) {
            TextView textView2 = this.f21286x;
            if (textView2 == null) {
                h.i("mSpatialAudioDes");
                throw null;
            }
            textView2.setText(getString(R.string.melody_ui_spatial_audio_description_not_headtracker));
        }
        HeyMelodyApplication heyMelodyApplication4 = C0906l.f19501a;
        if (heyMelodyApplication4 == null) {
            h.i("context");
            throw null;
        }
        if (!C0908n.b(heyMelodyApplication4).getBoolean("spatial_audio_tip_showed", false)) {
            DeviceControlWidget deviceControlWidget3 = this.f21279q;
            if (deviceControlWidget3 == null) {
                h.i("mControlView");
                throw null;
            }
            deviceControlWidget3.postDelayed(this.f21271M, 500L);
        }
        NestedScrollView nestedScrollView4 = this.f21288z;
        if (nestedScrollView4 == null) {
            h.i("mScrollView");
            throw null;
        }
        nestedScrollView4.setOnTouchListener(new R9.j());
        if (!this.f21267I) {
            LinearLayout linearLayout5 = this.f21282t;
            if (linearLayout5 == null) {
                h.i("mAudioPreviewLayout");
                throw null;
            }
            linearLayout5.setSelected(false);
            MelodyLottieAnimationView melodyLottieAnimationView = this.f21280r;
            if (melodyLottieAnimationView == null) {
                h.i("mAudioPreviewLottie");
                throw null;
            }
            melodyLottieAnimationView.setImageDrawable(com.oplus.drs.core.d.m(requireContext(), R.drawable.melody_ui_spatial_audio_preview_icon));
            LinearLayout linearLayout6 = this.f21282t;
            if (linearLayout6 == null) {
                h.i("mAudioPreviewLayout");
                throw null;
            }
            linearLayout6.setOnClickListener(new o(this, 8));
        }
        String str5 = this.f21265F;
        if (str5 == null) {
            return;
        }
        t().getClass();
        C0379m.b(C0379m.g(AbstractC0939b.E().v(str5), new g(19))).e(requireActivity(), new b(new SpatialAudioContentFragment$initDataObserver$1(1, this, SpatialAudioContentFragment.class, "onConnectionOrLeaStateChange", "onConnectionOrLeaStateChange(I)V", 0)));
        t().d(str5).e(requireActivity(), new R9.k(this));
    }

    public final void r(int i10) {
        A.c("SpatialAudioContentFragment", new D(i10, 8));
        DeviceControlWidget deviceControlWidget = this.f21279q;
        Object obj = null;
        if (deviceControlWidget == null) {
            h.i("mControlView");
            throw null;
        }
        ArrayList arrayListG = q.G(deviceControlWidget.getModeList());
        int size = arrayListG.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            Object obj2 = arrayListG.get(i11);
            i11++;
            if (TextUtils.equals(BaseHealthModule.TRACK_CERVICAL_REMIND, ((ModeItem) obj2).getId())) {
                obj = obj2;
                break;
            }
        }
        ModeItem modeItem = (ModeItem) obj;
        if (modeItem != null) {
            o0.b.f1142a.schedule(new R9.h(this, i10, modeItem, 0), i10 > 0 ? 1L : 0L, TimeUnit.SECONDS);
        }
    }

    public final ModeItem s(int i10, Drawable drawable, String str) {
        ModeItem modeItem = new ModeItem();
        modeItem.p(drawable);
        modeItem.q(String.valueOf(i10));
        modeItem.s(str);
        modeItem.u(false);
        modeItem.t(true);
        modeItem.w(true);
        modeItem.v();
        modeItem.n(Integer.valueOf(P1.a.b(getContext(), R.attr.couiColorLabelTheme, 0)));
        return modeItem;
    }

    public final BaseSpatialAudioVM t() {
        return (BaseSpatialAudioVM) this.f21269K.getValue();
    }

    public final void u(Integer num) {
        if (this.f21267I) {
            return;
        }
        BaseSpatialAudioVM baseSpatialAudioVMT = t();
        h.b(num);
        int iIntValue = num.intValue();
        p pVar = baseSpatialAudioVMT.f21247c;
        File fileN = null;
        if (pVar != null) {
            MelodyResourceDO m4aHeaderV2 = iIntValue != 0 ? iIntValue != 1 ? iIntValue != 2 ? null : pVar.getM4aHeaderV2() : pVar.getM4aFixedV2() : pVar.getM4aClosed();
            if (m4aHeaderV2 != null) {
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                if (heyMelodyApplication == null) {
                    h.i("context");
                    throw null;
                }
                fileN = com.oplus.drs.core.d.n(heyMelodyApplication, m4aHeaderV2, pVar.getRootPath());
            }
        }
        if (fileN == null) {
            A.h("SpatialAudioContentFragment", "playPreviewAudio, file is null");
        } else {
            B.a.f19427a.b((AudioManager.OnAudioFocusChangeListener) this.f21270L.getValue(), "SpatialAudioContentFragment");
            o0.c.f1145c.execute(new RunnableC0380n(fileN, 23));
        }
    }

    public final void v() {
        if (this.f21267I) {
            return;
        }
        LinearLayout linearLayout = this.f21282t;
        if (linearLayout == null) {
            h.i("mAudioPreviewLayout");
            throw null;
        }
        if (!linearLayout.isSelected()) {
            try {
                A.c("SpatialAudioContentFragment", new C0371e(4));
                J.a.f19444a.e();
            } catch (Exception e10) {
                A.i("SpatialAudioContentFragment", "updatePreviewView, stop MediaPlayer, error: ", e10);
            }
            B.a.f19427a.a((AudioManager.OnAudioFocusChangeListener) this.f21270L.getValue(), "SpatialAudioContentFragment");
            MelodyLottieAnimationView melodyLottieAnimationView = this.f21280r;
            if (melodyLottieAnimationView == null) {
                h.i("mAudioPreviewLottie");
                throw null;
            }
            melodyLottieAnimationView.setImageDrawable(com.oplus.drs.core.d.m(requireContext(), R.drawable.melody_ui_spatial_audio_preview_icon));
            TextView textView = this.f21281s;
            if (textView == null) {
                h.i("mAudioPreviewTv");
                throw null;
            }
            textView.setText(getString(R.string.melody_ui_spatial_audio_preview));
            TextView textView2 = this.f21281s;
            if (textView2 != null) {
                textView2.setTextColor(requireContext().getColor(R.color.melody_ui_spatial_audio_preview_tv_color_unselected));
                return;
            } else {
                h.i("mAudioPreviewTv");
                throw null;
            }
        }
        u(Integer.valueOf(this.f21263D));
        MelodyLottieAnimationView melodyLottieAnimationView2 = this.f21280r;
        if (melodyLottieAnimationView2 == null) {
            h.i("mAudioPreviewLottie");
            throw null;
        }
        melodyLottieAnimationView2.setImageDrawable(null);
        MelodyLottieAnimationView melodyLottieAnimationView3 = this.f21280r;
        if (melodyLottieAnimationView3 == null) {
            h.i("mAudioPreviewLottie");
            throw null;
        }
        melodyLottieAnimationView3.setAnimation(R.raw.melody_ui_spatial_audio_preview_anim);
        MelodyLottieAnimationView melodyLottieAnimationView4 = this.f21280r;
        if (melodyLottieAnimationView4 == null) {
            h.i("mAudioPreviewLottie");
            throw null;
        }
        melodyLottieAnimationView4.playAnimation();
        TextView textView3 = this.f21281s;
        if (textView3 == null) {
            h.i("mAudioPreviewTv");
            throw null;
        }
        textView3.setText(getString(R.string.melody_ui_spatial_audio_preview_stop));
        TextView textView4 = this.f21281s;
        if (textView4 != null) {
            textView4.setTextColor(requireContext().getColor(R.color.melody_ui_spatial_audio_preview_tv_color_selected));
        } else {
            h.i("mAudioPreviewTv");
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.spatialaudio.c$a */
    /* JADX INFO: compiled from: SpatialAudioContentFragment.kt */
    public static final class a implements DeviceControlWidget.a {
        public a() {
        }

        @Override // com.oplus.melody.ui.widget.devicecontrol.DeviceControlWidget.a
        public final void a(final ModeItem modeItem, final boolean z2) {
            Boolean bool;
            h.e(modeItem, "modeItem");
            DeviceControlWidget deviceControlWidget = SpatialAudioContentFragment.this.f21279q;
            if (deviceControlWidget == null) {
                h.i("mControlView");
                throw null;
            }
            if (s.a(deviceControlWidget.getId())) {
                A.h("SpatialAudioContentFragment", "onButtonClick item click too frequently, return");
                return;
            }
            if (modeItem.getSelected()) {
                A.b("SpatialAudioContentFragment", "onButtonClick already selected");
                return;
            }
            String id = modeItem.getId();
            if (id != null) {
                SpatialAudioContentFragment spatialAudioContentFragment = SpatialAudioContentFragment.this;
                d dVar = d.f21291a;
                String str = spatialAudioContentFragment.f21265F;
                dVar.getClass();
                final boolean zC = d.c(str);
                A.c("SpatialAudioContentFragment", new Supplier() { // from class: R9.m
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return "onButtonClick, selected: " + z2 + ", isHiResOpen: " + zC + ", modeItem: " + modeItem;
                    }
                });
                if (!t8.v.b(spatialAudioContentFragment.f21265F) && zC && Integer.parseInt(id) > 0) {
                    Context contextRequireContext = spatialAudioContentFragment.requireContext();
                    h.d(contextRequireContext, "requireContext(...)");
                    String str2 = spatialAudioContentFragment.f21265F;
                    h.b(str2);
                    d.a(contextRequireContext, str2, true, new com.oplus.melody.ui.component.detail.spatialaudio.a(modeItem, this, spatialAudioContentFragment));
                    return;
                }
                if (spatialAudioContentFragment.f21272N != null && spatialAudioContentFragment.f21273O && spatialAudioContentFragment.f21274P) {
                    ConcurrentHashMap<String, Boolean> concurrentHashMap = q9.n.f27216a;
                    String str3 = spatialAudioContentFragment.f21265F;
                    h.b(str3);
                    HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                    if (heyMelodyApplication == null) {
                        h.i("context");
                        throw null;
                    }
                    List<String> list = S.f19463a;
                    boolean zBooleanValue = false;
                    if ("com.heytap.headset".equals(heyMelodyApplication.getPackageName()) && (bool = q9.n.f27216a.get(str3)) != null) {
                        zBooleanValue = bool.booleanValue();
                    }
                    if (zBooleanValue) {
                        Context contextRequireContext2 = spatialAudioContentFragment.requireContext();
                        h.d(contextRequireContext2, "requireContext(...)");
                        GameSetViewModel gameSetViewModel = spatialAudioContentFragment.f21272N;
                        h.b(gameSetViewModel);
                        String str4 = spatialAudioContentFragment.f21265F;
                        h.b(str4);
                        q9.n.b(contextRequireContext2, gameSetViewModel, str4, spatialAudioContentFragment.f21275Q, 2, new com.oplus.melody.ui.component.detail.spatialaudio.b(modeItem, this, spatialAudioContentFragment));
                        return;
                    }
                }
            }
            c(modeItem);
        }

        public final CompletableFuture<SetCommandStateDTO> c(ModeItem modeItem) {
            DeviceControlWidget deviceControlWidget = SpatialAudioContentFragment.this.f21279q;
            if (deviceControlWidget == null) {
                h.i("mControlView");
                throw null;
            }
            Iterator<T> it = deviceControlWidget.getModeList().iterator();
            while (it.hasNext()) {
                ((ModeItem) it.next()).u(false);
            }
            modeItem.u(true);
            SpatialAudioContentFragment spatialAudioContentFragment = SpatialAudioContentFragment.this;
            String str = spatialAudioContentFragment.f21265F;
            if (str == null) {
                return null;
            }
            C1518c c1518c = spatialAudioContentFragment.f21285w;
            if (c1518c == null) {
                h.i("mCOUIToolTips");
                throw null;
            }
            if (c1518c.isShowing()) {
                C1518c c1518c2 = SpatialAudioContentFragment.this.f21285w;
                if (c1518c2 == null) {
                    h.i("mCOUIToolTips");
                    throw null;
                }
                c1518c2.dismiss();
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                if (heyMelodyApplication == null) {
                    h.i("context");
                    throw null;
                }
                SharedPreferences sharedPreferencesB = C0908n.b(heyMelodyApplication);
                h.d(sharedPreferencesB, "getInstance(...)");
                SharedPreferences.Editor editorEdit = sharedPreferencesB.edit();
                editorEdit.putBoolean("spatial_audio_tip_showed", true);
                editorEdit.apply();
                LinearLayout linearLayout = SpatialAudioContentFragment.this.f21282t;
                if (linearLayout == null) {
                    h.i("mAudioPreviewLayout");
                    throw null;
                }
                linearLayout.setSelected(true);
                SpatialAudioContentFragment.this.v();
            }
            BaseSpatialAudioVM baseSpatialAudioVMT = SpatialAudioContentFragment.this.t();
            String id = modeItem.getId();
            h.b(id);
            return baseSpatialAudioVMT.g(Integer.parseInt(id), str);
        }

        @Override // com.oplus.melody.ui.widget.devicecontrol.DeviceControlWidget.a
        public final void b(ModeItem modeItem) {
        }
    }
}
