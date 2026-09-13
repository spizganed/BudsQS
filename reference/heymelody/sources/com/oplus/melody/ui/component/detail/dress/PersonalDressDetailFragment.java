package com.oplus.melody.ui.component.detail.dress;

import Aa.e;
import Ca.g;
import D7.C0373g;
import D7.C0379m;
import D7.H;
import D7.k0;
import D7.o0;
import E9.o;
import Ea.D;
import Ea.F;
import Ea.G;
import Ea.S;
import Wb.l;
import X3.w;
import a9.C0551q;
import a9.ViewOnClickListenerC0542h;
import a9.u;
import a9.x;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.i;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.p;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.coui.appcompat.progressbar.COUIInstallLoadProgress;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.drs.statistics.DataTypeConstants;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.B;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0909o;
import com.oplus.melody.common.util.J;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.a;
import com.oplus.melody.model.repository.earphone.EarToneDTO;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import com.oplus.melody.model.repository.personaldress.a;
import com.oplus.melody.ui.component.detail.dress.PersonalDressDetailFragment;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import com.oplus.melody.ui.widget.MelodyErrorLayout;
import com.oplus.melody.ui.widget.MelodyLottieAnimationView;
import com.oplus.melody.ui.widget.MelodyVideoAnimationView;
import d9.C0973a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import t8.q;

/* JADX INFO: compiled from: PersonalDressDetailFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000 d2\u00020\u0001:\u0002deB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u001e2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u00020?H\u0016J\u001a\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010B\u001a\u00020?2\u0006\u0010C\u001a\u00020DH\u0016J\u0006\u0010E\u001a\u000203J\u0010\u0010F\u001a\u00020?2\u0006\u0010G\u001a\u000203H\u0002J\u0010\u0010H\u001a\u00020?2\u0006\u0010I\u001a\u000205H\u0002J\u0010\u0010J\u001a\u00020?2\u0006\u0010A\u001a\u00020\u0007H\u0002J\b\u0010K\u001a\u00020?H\u0002J\b\u0010L\u001a\u00020?H\u0002J\b\u0010M\u001a\u00020?H\u0002J\b\u0010N\u001a\u00020?H\u0002J\u0010\u0010O\u001a\u00020?2\u0006\u0010P\u001a\u000205H\u0002J\b\u0010Q\u001a\u00020?H\u0002J\u0010\u0010R\u001a\u00020?2\u0006\u0010S\u001a\u000203H\u0002J\u0010\u0010T\u001a\u00020?2\u0006\u0010U\u001a\u00020/H\u0002J\b\u0010V\u001a\u00020?H\u0002J\b\u0010W\u001a\u00020?H\u0002J\u0014\u0010X\u001a\u00020?2\n\u0010Y\u001a\u0006\u0012\u0002\b\u00030&H\u0002J\u0010\u0010Z\u001a\u00020?2\u0006\u0010U\u001a\u00020/H\u0002J\u0010\u0010[\u001a\u00020?2\u0006\u0010U\u001a\u00020/H\u0002J\u0010\u0010\\\u001a\u00020?2\u0006\u0010U\u001a\u00020/H\u0002J\b\u0010]\u001a\u00020?H\u0016J\b\u0010^\u001a\u00020?H\u0016J\b\u0010_\u001a\u000205H\u0002J\b\u0010`\u001a\u000205H\u0002J\b\u0010a\u001a\u000205H\u0002J\b\u0010b\u001a\u000205H\u0002J\b\u0010c\u001a\u000205H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/PersonalDressDetailFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/dress/PersonalDressDetailViewModel;", "mRootView", "Landroid/view/View;", "mDividerLine", "mAnimPreviewView", "Lcom/oplus/melody/ui/widget/MelodyVideoAnimationView;", "mAnimPreviewImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "mAnimPreviewPlay", "mTonePreviewLinerLayout", "Landroid/widget/LinearLayout;", "mTonePreviewPlay", "mTonePreviewAnim", "Lcom/oplus/melody/ui/widget/MelodyLottieAnimationView;", "mTitleTv", "Landroidx/appcompat/widget/AppCompatTextView;", "mSummaryTv", "mTipTv", "mContentTv", "mInUseBtn", "Lcom/oplus/melody/ui/widget/MelodyCompatButton;", "mApplyBtn", "mApplyProgress", "Lcom/coui/appcompat/progressbar/COUIInstallLoadProgress;", "mContentLayout", "Landroid/view/ViewGroup;", "mScrollLayout", "mErrorLayout", "Lcom/oplus/melody/ui/widget/MelodyErrorLayout;", "mLoadingCountDownTimer", "Landroid/os/CountDownTimer;", "mAnimLoadingView", "mTonePreviewFuture", "Ljava/util/concurrent/CompletableFuture;", "Ljava/io/File;", "mMediaPlayer", "Lcom/oplus/melody/common/util/MelodyMediaPlayer;", "mAudioManager", "Lcom/oplus/melody/common/util/MelodyAudioManager;", "mEarphoneVO", "Lcom/oplus/melody/ui/component/detail/dress/PersonalDressEarphoneVO;", "mPersonalDressData", "Lcom/oplus/melody/model/repository/personaldress/PersonalDressDTO$PersonalDressData;", "mLastProgressMillis", "", "mLayoutId", "", "isVerticalLayout", "", "mAudioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onViewCreated", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "getLayoutId", "dealErrorState", "es", "showContentView", "success", "initView", "updateData", "startTonePreview", "stopTonePreview", "togglePreviewTone", "updatePreviewImage", "isPlay", "playPreviewAnim", "onApplyProgressChange", "percent", "onThemeDataChange", ClientDataEntity.COL_DATA, "updateApplyBtn", "applyTheme", "onSetThemeComplete", "future", "setThemePop", "setThemeTone", "setThemePopAndTone", "onStop", "onDestroy", "isPopSupport", "isToneSupport", "isPopSelect", "isToneSelect", "isToneInEarphone", "Companion", "ApplyBiConsumer", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PersonalDressDetailFragment extends F8.c {

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final /* synthetic */ int f20674R = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public AppCompatTextView f20675A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public MelodyCompatButton f20676B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public MelodyCompatButton f20677C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public COUIInstallLoadProgress f20678D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public ViewGroup f20679E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public MelodyErrorLayout f20680F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public b f20681G;
    public MelodyLottieAnimationView H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public CompletableFuture<File> f20682I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public J f20683J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final B f20684K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public x f20685L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public PersonalDressDTO.PersonalDressData f20686M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public long f20687N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public int f20688O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f20689P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public final S f20690Q;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PersonalDressDetailViewModel f20691p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f20692q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MelodyVideoAnimationView f20693r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AppCompatImageView f20694s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public AppCompatImageView f20695t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LinearLayout f20696u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AppCompatImageView f20697v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public MelodyLottieAnimationView f20698w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public AppCompatTextView f20699x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public AppCompatTextView f20700y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public AppCompatTextView f20701z;

    /* JADX INFO: compiled from: PersonalDressDetailFragment.kt */
    public static final class a implements BiConsumer<Object, Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<PersonalDressDetailFragment> f20702a;

        public a(WeakReference<PersonalDressDetailFragment> weakReference) {
            this.f20702a = weakReference;
        }

        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Throwable th) {
            int i10;
            Throwable th2 = th;
            WeakReference<PersonalDressDetailFragment> weakReference = this.f20702a;
            if (th2 != null) {
                A.i("PersonalDressDetailFragment", "onSetThemeComplete", th2);
                switch (MelodyException.a(th2)) {
                    case DataTypeConstants.USER_ACTION /* 1001 */:
                        i10 = R.string.melody_ui_personalpress_apply_fail_for_call;
                        break;
                    case DataTypeConstants.APP_LOG /* 1002 */:
                        i10 = R.string.melody_ui_personalpress_apply_fail_for_single;
                        break;
                    case DataTypeConstants.PAGE_VISIT /* 1003 */:
                        i10 = R.string.melody_ui_personal_dress_apply_tone_low_battery;
                        break;
                    default:
                        i10 = R.string.melody_ui_peronalpress_apply_fail;
                        break;
                }
                PersonalDressDetailFragment personalDressDetailFragment = weakReference.get();
                if (personalDressDetailFragment != null) {
                    Toast.makeText(personalDressDetailFragment.requireActivity(), i10, 0).show();
                }
            } else {
                A.c("PersonalDressDetailFragment", new k0(obj, 4));
            }
            PersonalDressDetailFragment personalDressDetailFragment2 = weakReference.get();
            String str = null;
            if (personalDressDetailFragment2 != null) {
                PersonalDressDetailViewModel personalDressDetailViewModel = personalDressDetailFragment2.f20691p;
                if (personalDressDetailViewModel == null) {
                    h.i("mViewModel");
                    throw null;
                }
                str = personalDressDetailViewModel.f20712g;
            }
            A.f("PersonalDressDetailFragment", "m_spp_le.onSetThemeComplete.directDisconnectSpp, addr: " + str);
            if (C0373g.f()) {
                ForkJoinPool.commonPool().execute(new g(str, 1));
            } else {
                A6.b.g("directDisconnectSpp.isSppOverLeSupport=false, addr: ", A.r(str), "m_spp_le.LeAudioConnectSppManager");
            }
            o0.c.f1143a.postDelayed(new w(this, 4), 100L);
        }
    }

    /* JADX INFO: compiled from: PersonalDressDetailFragment.kt */
    public static final class c implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20704a;

        public c(l lVar) {
            this.f20704a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20704a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20704a.d(obj);
        }
    }

    /* JADX INFO: compiled from: PersonalDressDetailFragment.kt */
    public static final class d implements a.InterfaceC0228a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PersonalDressDTO.PersonalDressData f20706b;

        public d(PersonalDressDTO.PersonalDressData personalDressData) {
            this.f20706b = personalDressData;
        }

        @Override // com.oplus.melody.leaudio.a.InterfaceC0228a
        public final void a(int i10, String str) {
            A.f("PersonalDressDetailFragment", "m_spp_le.setThemeTone.directConnectSpp.onConnectResult, addr: " + str + ", status: " + i10);
            PersonalDressDetailViewModel personalDressDetailViewModel = PersonalDressDetailFragment.this.f20691p;
            if (personalDressDetailViewModel == null) {
                h.i("mViewModel");
                throw null;
            }
            if (!TextUtils.equals(str, personalDressDetailViewModel.f20712g) || i10 != 0) {
                PersonalDressDetailFragment.this.A();
                if (i10 == 8 || i10 == 9 || i10 == 18) {
                    HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                    if (heyMelodyApplication != null) {
                        E8.a.T(heyMelodyApplication, heyMelodyApplication.getString(R.string.melody_ui_personalpress_apply_fail_for_call));
                        return;
                    } else {
                        h.i("context");
                        throw null;
                    }
                }
                return;
            }
            PersonalDressDetailFragment personalDressDetailFragment = PersonalDressDetailFragment.this;
            PersonalDressDetailViewModel personalDressDetailViewModel2 = personalDressDetailFragment.f20691p;
            if (personalDressDetailViewModel2 == null) {
                h.i("mViewModel");
                throw null;
            }
            PersonalDressDTO.PersonalDressData data = this.f20706b;
            boolean zR = PersonalDressDetailFragment.r(personalDressDetailFragment);
            h.e(data, "data");
            CompletableFuture<?> completableFutureH = personalDressDetailViewModel2.h(data, zR, 0, 10);
            CompletableFuture<?> completableFuture = personalDressDetailViewModel2.f20718n;
            if (completableFuture != null) {
                completableFuture.cancel(true);
            }
            personalDressDetailViewModel2.f20718n = completableFutureH;
            personalDressDetailFragment.v(completableFutureH);
        }

        @Override // com.oplus.melody.leaudio.a.InterfaceC0228a
        public final void b() {
            PersonalDressDetailFragment personalDressDetailFragment = PersonalDressDetailFragment.this;
            COUIInstallLoadProgress cOUIInstallLoadProgress = personalDressDetailFragment.f20678D;
            if (cOUIInstallLoadProgress == null) {
                h.i("mApplyProgress");
                throw null;
            }
            cOUIInstallLoadProgress.setVisibility(0);
            MelodyCompatButton melodyCompatButton = personalDressDetailFragment.f20677C;
            if (melodyCompatButton == null) {
                h.i("mApplyBtn");
                throw null;
            }
            melodyCompatButton.setVisibility(8);
            MelodyCompatButton melodyCompatButton2 = personalDressDetailFragment.f20676B;
            if (melodyCompatButton2 == null) {
                h.i("mInUseBtn");
                throw null;
            }
            melodyCompatButton2.setVisibility(8);
            cOUIInstallLoadProgress.setProgress(0);
            cOUIInstallLoadProgress.setText("0%");
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.PersonalDressDetailFragment$onViewCreated$4, reason: invalid class name */
    /* JADX INFO: compiled from: PersonalDressDetailFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            int i10 = 0;
            int iIntValue = num.intValue();
            PersonalDressDetailFragment personalDressDetailFragment = (PersonalDressDetailFragment) this.receiver;
            int i11 = PersonalDressDetailFragment.f20674R;
            personalDressDetailFragment.getClass();
            A.c("PersonalDressDetailFragment", new Ba.b(iIntValue, 19));
            b bVar = personalDressDetailFragment.f20681G;
            if (bVar == null) {
                h.i("mLoadingCountDownTimer");
                throw null;
            }
            bVar.cancel();
            if (iIntValue == 1) {
                personalDressDetailFragment.y(true);
            } else if (iIntValue == 2) {
                personalDressDetailFragment.y(false);
                MelodyErrorLayout melodyErrorLayout = personalDressDetailFragment.f20680F;
                if (melodyErrorLayout == null) {
                    h.i("mErrorLayout");
                    throw null;
                }
                melodyErrorLayout.b();
            } else if (iIntValue == 3) {
                personalDressDetailFragment.y(false);
                MelodyErrorLayout melodyErrorLayout2 = personalDressDetailFragment.f20680F;
                if (melodyErrorLayout2 == null) {
                    h.i("mErrorLayout");
                    throw null;
                }
                melodyErrorLayout2.a(new ViewOnClickListenerC0542h(personalDressDetailFragment, i10));
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.PersonalDressDetailFragment$onViewCreated$5, reason: invalid class name */
    /* JADX INFO: compiled from: PersonalDressDetailFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            int iIntValue = num.intValue();
            PersonalDressDetailFragment personalDressDetailFragment = (PersonalDressDetailFragment) this.receiver;
            int i10 = PersonalDressDetailFragment.f20674R;
            personalDressDetailFragment.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime >= personalDressDetailFragment.f20687N + 16 && iIntValue != 100) {
                personalDressDetailFragment.f20687N = jElapsedRealtime;
                COUIInstallLoadProgress cOUIInstallLoadProgress = personalDressDetailFragment.f20678D;
                if (cOUIInstallLoadProgress == null) {
                    h.i("mApplyProgress");
                    throw null;
                }
                cOUIInstallLoadProgress.setProgress(iIntValue);
                COUIInstallLoadProgress cOUIInstallLoadProgress2 = personalDressDetailFragment.f20678D;
                if (cOUIInstallLoadProgress2 == null) {
                    h.i("mApplyProgress");
                    throw null;
                }
                cOUIInstallLoadProgress2.setText(iIntValue + "%");
                A.c("PersonalDressDetailFragment", new D(iIntValue, 11));
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.PersonalDressDetailFragment$onViewCreated$6, reason: invalid class name */
    /* JADX INFO: compiled from: PersonalDressDetailFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements l<PersonalDressDTO.PersonalDressData, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(PersonalDressDTO.PersonalDressData personalDressData) {
            PersonalDressDTO.PersonalDressData p02 = personalDressData;
            h.e(p02, "p0");
            PersonalDressDetailFragment personalDressDetailFragment = (PersonalDressDetailFragment) this.receiver;
            int i10 = PersonalDressDetailFragment.f20674R;
            personalDressDetailFragment.getClass();
            A.f("PersonalDressDetailFragment", "onThemeDataChange themeId:" + p02.getThemeId() + " title:" + p02.getTitle());
            personalDressDetailFragment.f20686M = p02;
            personalDressDetailFragment.B();
            return Jb.l.f2618a;
        }
    }

    static {
        h.d(RequestOptions.bitmapTransform(new RoundedCorners(55)), "bitmapTransform(...)");
    }

    public PersonalDressDetailFragment() {
        B b4 = B.a.f19427a;
        h.d(b4, "getInstance(...)");
        this.f20684K = b4;
        this.f20689P = true;
        this.f20690Q = new S(this, 2);
    }

    public static final boolean r(PersonalDressDetailFragment personalDressDetailFragment) {
        List<EarToneDTO> earTones;
        PersonalDressDTO.PersonalDressData personalDressData = personalDressDetailFragment.f20686M;
        Object obj = null;
        String themeId = personalDressData != null ? personalDressData.getThemeId() : null;
        x xVar = personalDressDetailFragment.f20685L;
        if (xVar != null && (earTones = xVar.getEarTones()) != null) {
            Iterator<T> it = earTones.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (h.a(String.valueOf(((EarToneDTO) next).getId()), themeId)) {
                    obj = next;
                    break;
                }
            }
            obj = (EarToneDTO) obj;
        }
        A.c("PersonalDressDetailFragment", new P3.d(obj, 20));
        return obj != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A() {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.dress.PersonalDressDetailFragment.A():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B() {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.dress.PersonalDressDetailFragment.B():void");
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        int i10;
        h.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (C0909o.e(getActivity()) > getResources().getDimensionPixelOffset(R.dimen.melody_ui_personal_dress_horizontal_layout_mini_width)) {
            this.f20689P = false;
            i10 = R.layout.melody_ui_personal_dress_detail_fragment_tablet;
        } else {
            i10 = R.layout.melody_ui_personal_dress_detail_fragment;
        }
        if (this.f20688O != i10) {
            A.b("PersonalDressDetailFragment", "onConfigurationChanged mLayoutId changed");
            this.f20688O = i10;
            androidx.fragment.app.f activity = getActivity();
            PersonalDressDetailActivity personalDressDetailActivity = activity instanceof PersonalDressDetailActivity ? (PersonalDressDetailActivity) activity : null;
            if (personalDressDetailActivity != null) {
                p pVarU = personalDressDetailActivity.u();
                PersonalDressDetailViewModel personalDressDetailViewModel = personalDressDetailActivity.f20671U;
                if (personalDressDetailViewModel == null) {
                    h.i("mViewModel");
                    throw null;
                }
                Fragment fragmentD = pVarU.D(personalDressDetailViewModel.f20712g);
                if (fragmentD != null) {
                    p pVarU2 = personalDressDetailActivity.u();
                    pVarU2.getClass();
                    C0585a c0585a = new C0585a(pVarU2);
                    c0585a.m(fragmentD);
                    c0585a.j();
                    personalDressDetailActivity.I(fragmentD.getArguments());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int i10;
        h.e(inflater, "inflater");
        if (C0909o.e(getActivity()) > getResources().getDimensionPixelOffset(R.dimen.melody_ui_personal_dress_horizontal_layout_mini_width)) {
            this.f20689P = false;
            i10 = R.layout.melody_ui_personal_dress_detail_fragment_tablet;
        } else {
            i10 = R.layout.melody_ui_personal_dress_detail_fragment;
        }
        this.f20688O = i10;
        View viewInflate = inflater.inflate(i10, container, false);
        h.d(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        PersonalDressDetailViewModel personalDressDetailViewModel = this.f20691p;
        if (personalDressDetailViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        A.f("PersonalDressDetailFragment", "m_spp_le.onDestroy.directDisconnectSpp, addr: " + personalDressDetailViewModel.f20712g);
        PersonalDressDetailViewModel personalDressDetailViewModel2 = this.f20691p;
        if (personalDressDetailViewModel2 == null) {
            h.i("mViewModel");
            throw null;
        }
        String str = personalDressDetailViewModel2.f20712g;
        if (C0373g.f()) {
            ForkJoinPool.commonPool().execute(new g(str, 1));
        } else {
            A6.b.g("directDisconnectSpp.isSppOverLeSupport=false, addr: ", A.r(str), "m_spp_le.LeAudioConnectSppManager");
        }
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f20683J = J.a.f19444a;
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        z();
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        int i10 = 1;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.rl_melody_personal_dress_preview);
        float dimension = viewFindViewById.getResources().getDimension(R.dimen.melody_ui_personal_dress_preview_video_radius);
        C0973a c0973a = new C0973a();
        c0973a.f22282a = dimension;
        viewFindViewById.setOutlineProvider(c0973a);
        viewFindViewById.setClipToOutline(true);
        View viewFindViewById2 = view.findViewById(R.id.melody_personal_dress_preview);
        if (this.f20689P) {
            int iE = C0909o.e(getActivity());
            int dimensionPixelOffset = view.getResources().getDimensionPixelOffset(R.dimen.melody_ui_personal_dress_detail_banner_width);
            int dimensionPixelOffset2 = view.getResources().getDimensionPixelOffset(R.dimen.melody_ui_personal_dress_detail_banner_height);
            int dimensionPixelOffset3 = view.getResources().getDimensionPixelOffset(R.dimen.melody_ui_personal_dress_detail_banner_min_horizontal_margin);
            A.c("PersonalDressDetailFragment", new R8.l(iE, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3, 1));
            if ((dimensionPixelOffset3 * 2) + dimensionPixelOffset > iE) {
                final float f9 = iE - (dimensionPixelOffset3 * 2.0f);
                final float f10 = f9 / (dimensionPixelOffset / dimensionPixelOffset2);
                viewFindViewById.getLayoutParams().width = (int) f9;
                viewFindViewById2.getLayoutParams().height = (int) f10;
                viewFindViewById2.requestLayout();
                A.c("PersonalDressDetailFragment", new Supplier() { // from class: a9.n
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        int i11 = PersonalDressDetailFragment.f20674R;
                        return "adjust banner after width:" + f9 + " height:" + f10;
                    }
                });
            }
        }
        View viewFindViewById3 = view.findViewById(R.id.melody_personal_dress_video_view);
        h.d(viewFindViewById3, "findViewById(...)");
        this.f20693r = (MelodyVideoAnimationView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.melody_personal_dress_detail_img_view);
        h.d(viewFindViewById4, "findViewById(...)");
        this.f20694s = (AppCompatImageView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.melody_personal_dress_detail_start_view);
        h.d(viewFindViewById5, "findViewById(...)");
        this.f20695t = (AppCompatImageView) viewFindViewById5;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        List<String> list = com.oplus.melody.common.util.S.f19463a;
        if ("com.heytap.headset".equals(heyMelodyApplication.getPackageName()) && !q.l()) {
            AppCompatImageView appCompatImageView = this.f20695t;
            if (appCompatImageView == null) {
                h.i("mAnimPreviewPlay");
                throw null;
            }
            appCompatImageView.setVisibility(8);
        }
        View viewFindViewById6 = view.findViewById(R.id.melody_personal_dress_tone_preview);
        h.d(viewFindViewById6, "findViewById(...)");
        this.f20696u = (LinearLayout) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.melody_personal_dress_tone_preview_play);
        h.d(viewFindViewById7, "findViewById(...)");
        this.f20697v = (AppCompatImageView) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.melody_personal_dress_tone_preview_anim);
        h.d(viewFindViewById8, "findViewById(...)");
        MelodyLottieAnimationView melodyLottieAnimationView = (MelodyLottieAnimationView) viewFindViewById8;
        this.f20698w = melodyLottieAnimationView;
        melodyLottieAnimationView.setAnimation(R.raw.melody_ui_personal_dress_tone_playing);
        View viewFindViewById9 = view.findViewById(R.id.tv_personal_dress_detail_title);
        h.d(viewFindViewById9, "findViewById(...)");
        this.f20699x = (AppCompatTextView) viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.tv_personal_dress_detail_summary);
        h.d(viewFindViewById10, "findViewById(...)");
        this.f20700y = (AppCompatTextView) viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.tv_personal_dress_detail_tip);
        h.d(viewFindViewById11, "findViewById(...)");
        this.f20701z = (AppCompatTextView) viewFindViewById11;
        View viewFindViewById12 = view.findViewById(R.id.tv_personal_dress_detail_content);
        h.d(viewFindViewById12, "findViewById(...)");
        this.f20675A = (AppCompatTextView) viewFindViewById12;
        View viewFindViewById13 = view.findViewById(R.id.btn_personal_dress_item_applying);
        h.d(viewFindViewById13, "findViewById(...)");
        this.f20676B = (MelodyCompatButton) viewFindViewById13;
        View viewFindViewById14 = view.findViewById(R.id.btn_personal_dress_item_apply);
        h.d(viewFindViewById14, "findViewById(...)");
        this.f20677C = (MelodyCompatButton) viewFindViewById14;
        View viewFindViewById15 = view.findViewById(R.id.btn_personal_dress_item_apply_progress);
        h.d(viewFindViewById15, "findViewById(...)");
        this.f20678D = (COUIInstallLoadProgress) viewFindViewById15;
        View viewFindViewById16 = view.findViewById(R.id.melody_ui_error_layout);
        h.d(viewFindViewById16, "findViewById(...)");
        this.f20680F = (MelodyErrorLayout) viewFindViewById16;
        View viewFindViewById17 = view.findViewById(R.id.personal_dress_list_content);
        h.d(viewFindViewById17, "findViewById(...)");
        this.f20679E = (ViewGroup) viewFindViewById17;
        View viewFindViewById18 = view.findViewById(R.id.personal_dress_list_scroll);
        h.d(viewFindViewById18, "findViewById(...)");
        View viewFindViewById19 = view.findViewById(R.id.melody_ui_detail_anim_preview_lottie_loading);
        h.d(viewFindViewById19, "findViewById(...)");
        this.H = (MelodyLottieAnimationView) viewFindViewById19;
        this.f20692q = view;
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.c(fVarRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        i iVar = (i) fVarRequireActivity;
        androidx.appcompat.app.a aVarX = iVar.x();
        if (aVarX != null) {
            aVarX.n(true);
        }
        if (aVarX != null) {
            aVarX.r(true);
        }
        if (aVarX != null) {
            aVarX.t(R.string.melody_ui_peronalpress_detail_title);
        }
        O viewModelStore = iVar.getViewModelStore();
        N.b defaultViewModelProviderFactory = iVar.getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, iVar.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(PersonalDressDetailViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20691p = (PersonalDressDetailViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        AppCompatImageView appCompatImageView2 = this.f20695t;
        if (appCompatImageView2 == null) {
            h.i("mAnimPreviewPlay");
            throw null;
        }
        appCompatImageView2.setOnClickListener(new F(this, 11));
        AppCompatImageView appCompatImageView3 = this.f20697v;
        if (appCompatImageView3 == null) {
            h.i("mTonePreviewPlay");
            throw null;
        }
        appCompatImageView3.setOnClickListener(new o(this, 10));
        MelodyCompatButton melodyCompatButton = this.f20677C;
        if (melodyCompatButton == null) {
            h.i("mApplyBtn");
            throw null;
        }
        melodyCompatButton.setOnClickListener(new ViewOnClickListenerC0542h(this, i10));
        y(false);
        PersonalDressDetailViewModel personalDressDetailViewModel = this.f20691p;
        if (personalDressDetailViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        CompletableFuture<?> completableFuture = personalDressDetailViewModel.f20718n;
        if (completableFuture != null && !completableFuture.isDone()) {
            PersonalDressDetailViewModel personalDressDetailViewModel2 = this.f20691p;
            if (personalDressDetailViewModel2 == null) {
                h.i("mViewModel");
                throw null;
            }
            Integer numD = personalDressDetailViewModel2.f20709d.d();
            int iIntValue = numD != null ? numD.intValue() : 0;
            COUIInstallLoadProgress cOUIInstallLoadProgress = this.f20678D;
            if (cOUIInstallLoadProgress == null) {
                h.i("mApplyProgress");
                throw null;
            }
            cOUIInstallLoadProgress.setVisibility(0);
            MelodyCompatButton melodyCompatButton2 = this.f20677C;
            if (melodyCompatButton2 == null) {
                h.i("mApplyBtn");
                throw null;
            }
            melodyCompatButton2.setVisibility(8);
            MelodyCompatButton melodyCompatButton3 = this.f20676B;
            if (melodyCompatButton3 == null) {
                h.i("mInUseBtn");
                throw null;
            }
            melodyCompatButton3.setVisibility(8);
            COUIInstallLoadProgress cOUIInstallLoadProgress2 = this.f20678D;
            if (cOUIInstallLoadProgress2 == null) {
                h.i("mApplyProgress");
                throw null;
            }
            cOUIInstallLoadProgress2.setProgress(iIntValue);
            COUIInstallLoadProgress cOUIInstallLoadProgress3 = this.f20678D;
            if (cOUIInstallLoadProgress3 == null) {
                h.i("mApplyProgress");
                throw null;
            }
            cOUIInstallLoadProgress3.setText(iIntValue + "%");
            completableFuture.whenCompleteAsync((BiConsumer<? super Object, ? super Throwable>) new a(new WeakReference(this)), (Executor) o0.c.f1144b);
        }
        PersonalDressDetailViewModel personalDressDetailViewModel3 = this.f20691p;
        if (personalDressDetailViewModel3 == null) {
            h.i("mViewModel");
            throw null;
        }
        personalDressDetailViewModel3.f20710e.e(getViewLifecycleOwner(), new c(new AnonymousClass4(1, this, PersonalDressDetailFragment.class, "dealErrorState", "dealErrorState(I)V", 0)));
        PersonalDressDetailViewModel personalDressDetailViewModel4 = this.f20691p;
        if (personalDressDetailViewModel4 == null) {
            h.i("mViewModel");
            throw null;
        }
        personalDressDetailViewModel4.f20709d.e(getViewLifecycleOwner(), new c(new AnonymousClass5(1, this, PersonalDressDetailFragment.class, "onApplyProgressChange", "onApplyProgressChange(I)V", 0)));
        PersonalDressDetailViewModel personalDressDetailViewModel5 = this.f20691p;
        if (personalDressDetailViewModel5 == null) {
            h.i("mViewModel");
            throw null;
        }
        personalDressDetailViewModel5.f20711f.e(getViewLifecycleOwner(), new c(new AnonymousClass6(1, this, PersonalDressDetailFragment.class, "onThemeDataChange", "onThemeDataChange(Lcom/oplus/melody/model/repository/personaldress/PersonalDressDTO$PersonalDressData;)V", 0)));
        PersonalDressDetailViewModel personalDressDetailViewModel6 = this.f20691p;
        if (personalDressDetailViewModel6 == null) {
            h.i("mViewModel");
            throw null;
        }
        t tVar = personalDressDetailViewModel6.f20719o;
        if (tVar == null) {
            h.i("mEarphoneLiveData");
            throw null;
        }
        tVar.e(getViewLifecycleOwner(), new c(new D9.a(this, 19)));
        this.f20681G = new b();
    }

    public final boolean s() {
        PersonalDressDTO.PersonalDressData personalDressData = this.f20686M;
        if (TextUtils.isEmpty(personalDressData != null ? personalDressData.getAnimUrl() : null)) {
            return false;
        }
        PersonalDressDTO.PersonalDressData personalDressData2 = this.f20686M;
        if (personalDressData2 != null && personalDressData2.getMaterialType() == 0) {
            return true;
        }
        PersonalDressDTO.PersonalDressData personalDressData3 = this.f20686M;
        return personalDressData3 != null && personalDressData3.getMaterialType() == 2;
    }

    public final boolean t() {
        EarToneDTO earToneDTO;
        List<EarToneDTO> earTones;
        Object next;
        x xVar = this.f20685L;
        if (xVar == null || (earTones = xVar.getEarTones()) == null) {
            earToneDTO = null;
        } else {
            Iterator<T> it = earTones.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((EarToneDTO) next).isSelect() == 1) {
                    break;
                }
            }
            earToneDTO = (EarToneDTO) next;
        }
        String strValueOf = String.valueOf(earToneDTO != null ? Integer.valueOf(earToneDTO.getId()) : null);
        PersonalDressDTO.PersonalDressData personalDressData = this.f20686M;
        return strValueOf.equals(personalDressData != null ? personalDressData.getThemeId() : null);
    }

    public final boolean u() {
        PersonalDressDTO.PersonalDressData personalDressData;
        x xVar = this.f20685L;
        if (xVar == null || !xVar.getHasToneCapability()) {
            return false;
        }
        PersonalDressDTO.PersonalDressData personalDressData2 = this.f20686M;
        if (TextUtils.isEmpty(personalDressData2 != null ? personalDressData2.getToneUrl() : null)) {
            PersonalDressDTO.PersonalDressData personalDressData3 = this.f20686M;
            if (!h.a(personalDressData3 != null ? personalDressData3.getThemeId() : null, BaseHealthModule.TRACK_FATIGUE_REMIND)) {
                return false;
            }
        }
        PersonalDressDTO.PersonalDressData personalDressData4 = this.f20686M;
        return (personalDressData4 != null && personalDressData4.getMaterialType() == 1) || ((personalDressData = this.f20686M) != null && personalDressData.getMaterialType() == 2);
    }

    public final void v(CompletableFuture<?> completableFuture) {
        A.b("PersonalDressDetailFragment", "onSetThemeComplete");
        o0.c.f1143a.postDelayed(new e(this, 24), 50L);
        completableFuture.whenCompleteAsync((BiConsumer<? super Object, ? super Throwable>) new a(new WeakReference(this)), (Executor) o0.c.f1144b);
    }

    public final void w(PersonalDressDTO.PersonalDressData data) {
        int i10 = 0;
        PersonalDressDetailViewModel personalDressDetailViewModel = this.f20691p;
        if (personalDressDetailViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        h.e(data, "data");
        C0379m.k(personalDressDetailViewModel.f20709d, 0);
        Object obj = com.oplus.melody.model.repository.personaldress.a.f20060c;
        CompletableFuture<Void> completableFutureThenAccept = a.C0231a.a().j(data, personalDressDetailViewModel.f20713i, personalDressDetailViewModel.f20714j, new u(personalDressDetailViewModel, 100)).thenAccept((Consumer<? super Jb.l>) new H(new C0551q(personalDressDetailViewModel, data, i10), 15));
        h.d(completableFutureThenAccept, "thenAccept(...)");
        CompletableFuture<?> completableFuture = personalDressDetailViewModel.f20718n;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        personalDressDetailViewModel.f20718n = completableFutureThenAccept;
        v(completableFutureThenAccept);
    }

    public final void x(PersonalDressDTO.PersonalDressData personalDressData) {
        PersonalDressDetailViewModel personalDressDetailViewModel = this.f20691p;
        if (personalDressDetailViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        A.f("PersonalDressDetailFragment", "m_spp_le.setThemeTone.directConnectSpp, addr: " + personalDressDetailViewModel.f20712g);
        PersonalDressDetailViewModel personalDressDetailViewModel2 = this.f20691p;
        if (personalDressDetailViewModel2 != null) {
            com.oplus.melody.leaudio.a.a(personalDressDetailViewModel2.f20712g, LeFilterConstants.FunType.PERSONAL_TONE, true, true, new d(personalDressData));
        } else {
            h.i("mViewModel");
            throw null;
        }
    }

    public final void y(boolean z2) {
        A.c("PersonalDressDetailFragment", new G(13, z2));
        if (z2) {
            MelodyErrorLayout melodyErrorLayout = this.f20680F;
            if (melodyErrorLayout == null) {
                h.i("mErrorLayout");
                throw null;
            }
            melodyErrorLayout.setVisibility(8);
            ViewGroup viewGroup = this.f20679E;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
                return;
            } else {
                h.i("mContentLayout");
                throw null;
            }
        }
        MelodyErrorLayout melodyErrorLayout2 = this.f20680F;
        if (melodyErrorLayout2 == null) {
            h.i("mErrorLayout");
            throw null;
        }
        melodyErrorLayout2.setVisibility(0);
        ViewGroup viewGroup2 = this.f20679E;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        } else {
            h.i("mContentLayout");
            throw null;
        }
    }

    public final void z() {
        MediaPlayer mediaPlayer;
        A.b("PersonalDressDetailFragment", "stopTonePreview");
        J j5 = this.f20683J;
        if (j5 != null && (mediaPlayer = j5.f19442a) != null && j5.f19443b == 2) {
            j5.f19443b = 3;
            try {
                mediaPlayer.pause();
            } catch (Exception e10) {
                A.i("MelodyMediaPlayer", "pauseMediaPlayer", e10);
            }
        }
        J j9 = this.f20683J;
        if (j9 != null) {
            j9.a();
        }
        o0.d(new T8.e(true, (Object) this, 1));
        MelodyLottieAnimationView melodyLottieAnimationView = this.f20698w;
        if (melodyLottieAnimationView == null) {
            h.i("mTonePreviewAnim");
            throw null;
        }
        melodyLottieAnimationView.pauseAnimation();
        this.f20684K.a(this.f20690Q, "PersonalDressDetailFragment");
        CompletableFuture<File> completableFuture = this.f20682I;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
    }

    /* JADX INFO: compiled from: PersonalDressDetailFragment.kt */
    public static final class b extends CountDownTimer {
        public b() {
            super(500L, 500L);
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            PersonalDressDetailViewModel personalDressDetailViewModel = PersonalDressDetailFragment.this.f20691p;
            if (personalDressDetailViewModel != null) {
                personalDressDetailViewModel.f20710e.m(2);
            } else {
                h.i("mViewModel");
                throw null;
            }
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j5) {
        }
    }
}
