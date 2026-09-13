package com.oplus.melody.ui.component.detail.headmotion;

import D7.C0379m;
import D7.o0;
import E9.o;
import Ea.DialogInterfaceOnClickListenerC0412v;
import F8.c;
import G8.k;
import R1.e;
import Wb.l;
import X.d;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.f;
import androidx.appcompat.app.i;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.viewpager2.widget.ViewPager2;
import c.s;
import c.u;
import com.coui.appcompat.button.COUIButton;
import com.heytap.headset.R;
import com.oplus.melody.alive.component.health.module.HealthCalibrationModule;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.HeadMotionTryResultDTO;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import e9.C1017a;
import e9.DialogInterfaceOnClickListenerC1018b;
import g9.t;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import qa.RunnableC1448a;
import r9.C1481e;
import r9.C1482f;
import r9.C1483g;

/* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.headmotion.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: HeadMotionTryFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 M2\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J$\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010/\u001a\u00020$H\u0016J\b\u00100\u001a\u00020$H\u0016J\b\u00101\u001a\u00020$H\u0016J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020(H\u0002J\u0010\u00107\u001a\u00020$2\u0006\u00106\u001a\u00020(H\u0002J\u0010\u00108\u001a\u00020$2\u0006\u00106\u001a\u00020(H\u0002J\u0010\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0010\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\u0010H\u0002J\b\u0010=\u001a\u00020$H\u0002J\b\u0010>\u001a\u00020$H\u0002J\u0012\u0010?\u001a\u00020$2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0010\u0010B\u001a\u00020$2\u0006\u0010:\u001a\u00020\u0007H\u0002J\b\u0010C\u001a\u00020$H\u0002J\u0010\u0010D\u001a\u00020$2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0017\u0010E\u001a\u00020$2\b\u0010F\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020$H\u0002J\b\u0010I\u001a\u00020$H\u0002J\b\u0010J\u001a\u00020$H\u0002J\b\u0010K\u001a\u00020$H\u0002J\b\u0010L\u001a\u00020$H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/oplus/melody/ui/component/detail/headmotion/HeadMotionTryFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "<init>", "()V", "address", "", "currentHeadMotionType", "", "Ljava/lang/Integer;", "headMotionTryViewModel", "Lcom/oplus/melody/ui/component/detail/headmotion/HeadMotionTryViewModel;", "continueTryDialog", "Landroidx/appcompat/app/AlertDialog;", "exitTryDialog", "disconnectDialog", "needConfirmContinueTry", "", "isDeviceConnected", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "nextButton", "Lcom/coui/appcompat/button/COUIButton;", "pagerAdapter", "Lcom/oplus/melody/ui/component/detail/headmotion/HeadMotionTryPagerAdapter;", "pageSuccessStates", "", "pageSuccessTagVisibleStates", "hideSuccessTagRunnables", "", "Ljava/lang/Runnable;", "skipTryModeResetOnDestroy", "pageItems", "", "Lcom/oplus/melody/ui/component/detail/headmotion/HeadMotionTryPageItem;", "checkAliveRunnable", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "onDestroyView", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "initToolbar", "root", "initViewPager", "initButton", "updateButtonText", "pageIndex", "setHeadMotionTryMode", "isStart", "observeConnectionState", "observeHeadMotionTryResult", "onHeadMotionTryResultChanged", HealthCalibrationModule.KEY_RESULT, "Lcom/oplus/melody/model/repository/earphone/HeadMotionTryResultDTO;", "showSuccessTagTemporarily", "clearSuccessTagHideCallbacks", "updateButtonEnableState", "onConnectionStateChange", "connectState", "(Ljava/lang/Integer;)V", "handleDeviceConnected", "handleDeviceDisconnected", "showContinueTryDialog", "showExitTryDialog", "showDisconnectDialog", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HeadMotionTryFragment extends c {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f21062D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public List<C1481e> f21063E;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f21065p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f21066q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public HeadMotionTryViewModel f21067r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public f f21068s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public f f21069t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public f f21070u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f21071v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ViewPager2 f21073x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public COUIButton f21074y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public C1482f f21075z;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f21072w = true;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final boolean[] f21059A = new boolean[2];

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final boolean[] f21060B = new boolean[2];

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final LinkedHashMap f21061C = new LinkedHashMap();

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final RunnableC1448a f21064F = new RunnableC1448a(this, 1);

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.headmotion.a$a */
    /* JADX INFO: compiled from: HeadMotionTryFragment.kt */
    public static final class a extends s {
        public a() {
            super(true);
        }

        @Override // c.s
        public final void b() {
            A.j("HeadMotionTryFragment", "onBackPressed");
            HeadMotionTryFragment headMotionTryFragment = HeadMotionTryFragment.this;
            androidx.fragment.app.f activity = headMotionTryFragment.getActivity();
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            f fVar = headMotionTryFragment.f21069t;
            if (fVar == null || !fVar.isShowing()) {
                e eVar = new e(activity);
                eVar.n(R.string.melody_ui_head_motion_exit_try_dialog_title);
                eVar.h(R.string.melody_ui_common_exit, new U3.b(activity, 1));
                eVar.l(R.string.melody_common_continue, new k(3));
                headMotionTryFragment.f21069t = eVar.show();
            }
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.headmotion.a$b */
    /* JADX INFO: compiled from: HeadMotionTryFragment.kt */
    public static final class b implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21077a;

        public b(l lVar) {
            this.f21077a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21077a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21077a.d(obj);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        String stringExtra;
        Intent intent;
        Intent intent2;
        String stringExtra2;
        u onBackPressedDispatcher;
        String string;
        Integer numB;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        Integer numB2 = null;
        if (arguments == null || (stringExtra = arguments.getString("device_mac_info")) == null) {
            androidx.fragment.app.f activity = getActivity();
            stringExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra("device_mac_info");
        }
        this.f21065p = stringExtra;
        if (stringExtra == null || stringExtra.length() == 0) {
            androidx.fragment.app.f activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string = arguments2.getString("route_value")) == null || (numB = ec.k.B(string)) == null) {
            androidx.fragment.app.f activity3 = getActivity();
            if (activity3 != null && (intent2 = activity3.getIntent()) != null && (stringExtra2 = intent2.getStringExtra("route_value")) != null) {
                numB2 = ec.k.B(stringExtra2);
            }
        } else {
            numB2 = numB;
        }
        this.f21066q = numB2;
        if (numB2 == null) {
            androidx.fragment.app.f activity4 = getActivity();
            if (activity4 != null) {
                activity4.finish();
                return;
            }
            return;
        }
        setHasOptionsMenu(true);
        androidx.fragment.app.f activity5 = getActivity();
        h.b(activity5);
        O viewModelStore = activity5.getViewModelStore();
        N.b defaultViewModelProviderFactory = activity5.getDefaultViewModelProviderFactory();
        d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, activity5.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(HeadMotionTryViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        HeadMotionTryViewModel headMotionTryViewModel = (HeadMotionTryViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f21067r = headMotionTryViewModel;
        if (headMotionTryViewModel.f21055b == null) {
            A.x("HeadMotionTryFragment", "onCreate mHeadMotionTryZipConfig is null!");
            androidx.fragment.app.f activity6 = getActivity();
            if (activity6 != null) {
                activity6.finish();
                return;
            }
            return;
        }
        AbstractC0939b.E().Z();
        androidx.fragment.app.f activity7 = getActivity();
        if (activity7 == null || (onBackPressedDispatcher = activity7.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.a(this, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.melody_ui_fragment_head_motion_try, container, false);
        h.d(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        A.b("HeadMotionTryFragment", "onDestroyView ");
        o0.c.f1143a.removeCallbacks(this.f21064F);
        LinkedHashMap linkedHashMap = this.f21061C;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            o0.c.f1143a.removeCallbacks((Runnable) it.next());
        }
        linkedHashMap.clear();
        if (this.f21067r != null) {
            AbstractC0939b.E().Z();
        }
        f fVar = this.f21068s;
        if (fVar != null) {
            fVar.dismiss();
        }
        this.f21068s = null;
        f fVar2 = this.f21070u;
        if (fVar2 != null) {
            fVar2.dismiss();
        }
        this.f21070u = null;
        f fVar3 = this.f21069t;
        if (fVar3 != null) {
            fVar3.dismiss();
        }
        this.f21069t = null;
        if (!this.f21062D) {
            r(false);
        }
        this.f21073x = null;
        this.f21074y = null;
        this.f21075z = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        u onBackPressedDispatcher;
        h.e(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        androidx.fragment.app.f activity = getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return true;
        }
        onBackPressedDispatcher.c();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        A.b("HeadMotionTryFragment", "onPause");
        androidx.fragment.app.f activity = getActivity();
        if (activity != null) {
            S.b(activity);
        }
        o0.c.f1143a.removeCallbacks(this.f21064F);
        this.f21071v = true;
        if (this.f21062D) {
            return;
        }
        r(false);
        this.f21062D = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        A.b("HeadMotionTryFragment", "onResume");
        androidx.fragment.app.f activity = getActivity();
        if (activity == null) {
            return;
        }
        S.z(activity);
        Handler handler = o0.c.f1143a;
        RunnableC1448a runnableC1448a = this.f21064F;
        handler.removeCallbacks(runnableC1448a);
        handler.postDelayed(runnableC1448a, 120000L);
        if (!this.f21072w) {
            s();
            return;
        }
        if (!this.f21071v) {
            this.f21062D = false;
            r(true);
            return;
        }
        androidx.fragment.app.f activity2 = getActivity();
        if (activity2 == null || activity2.isFinishing() || activity2.isDestroyed()) {
            return;
        }
        f fVar = this.f21068s;
        if (fVar == null || !fVar.isShowing()) {
            e eVar = new e(activity2);
            eVar.n(R.string.melody_ui_head_motion_continue_try_dialog_title);
            eVar.h(R.string.melody_ui_common_exit, new DialogInterfaceOnClickListenerC0412v(activity2, 13));
            eVar.l(R.string.melody_common_continue, new H8.f(this, 13));
            this.f21068s = eVar.setCancelable(false).show();
        }
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        File file;
        HeadMotionTryFragment headMotionTryFragment;
        C1483g c1483g;
        String headMotionShakeWebp;
        C1483g c1483g2;
        C1483g c1483g3;
        String headMotionNodWebp;
        C1483g c1483g4;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MelodyCompatToolbar melodyCompatToolbar = (MelodyCompatToolbar) view.findViewById(R.id.toolbar);
        androidx.fragment.app.f activity = getActivity();
        File file2 = null;
        rootPath = null;
        String rootPath = null;
        file2 = null;
        file2 = null;
        i iVar = activity instanceof i ? (i) activity : null;
        if (iVar != null) {
            iVar.y(melodyCompatToolbar);
            androidx.appcompat.app.a aVarX = iVar.x();
            if (aVarX != null) {
                aVarX.n(true);
            }
            androidx.appcompat.app.a aVarX2 = iVar.x();
            if (aVarX2 != null) {
                aVarX2.r(true);
            }
            androidx.appcompat.app.a aVarX3 = iVar.x();
            if (aVarX3 != null) {
                aVarX3.t(R.string.melody_ui_head_motion_switch_title);
            }
        }
        this.f21073x = (ViewPager2) view.findViewById(R.id.head_motion_try_view_pager);
        HeadMotionTryViewModel headMotionTryViewModel = this.f21067r;
        if (headMotionTryViewModel == null || (c1483g3 = headMotionTryViewModel.f21055b) == null || (headMotionNodWebp = c1483g3.getHeadMotionNodWebp()) == null) {
            file = null;
        } else {
            HeadMotionTryViewModel headMotionTryViewModel2 = this.f21067r;
            file = new File((headMotionTryViewModel2 == null || (c1483g4 = headMotionTryViewModel2.f21055b) == null) ? null : c1483g4.getRootPath(), headMotionNodWebp);
        }
        HeadMotionTryViewModel headMotionTryViewModel3 = this.f21067r;
        if (headMotionTryViewModel3 != null && (c1483g = headMotionTryViewModel3.f21055b) != null && (headMotionShakeWebp = c1483g.getHeadMotionShakeWebp()) != null) {
            HeadMotionTryViewModel headMotionTryViewModel4 = this.f21067r;
            if (headMotionTryViewModel4 != null && (c1483g2 = headMotionTryViewModel4.f21055b) != null) {
                rootPath = c1483g2.getRootPath();
            }
            file2 = new File(rootPath, headMotionShakeWebp);
        }
        Integer num = this.f21066q;
        List<C1481e> listE = (num != null && num.intValue() == 0) ? com.google.android.play.core.appupdate.c.e(new C1481e[]{new C1481e(R.string.melody_ui_head_motion_try_nod_title, R.string.melody_ui_head_motion_try_nod_summary, file), new C1481e(R.string.melody_ui_head_motion_try_shake_title, R.string.melody_ui_head_motion_try_shake_summary, file2)}) : com.google.android.play.core.appupdate.c.e(new C1481e[]{new C1481e(R.string.melody_ui_head_motion_try_shake_title, R.string.melody_ui_head_motion_try_shake_summary2, file2), new C1481e(R.string.melody_ui_head_motion_try_nod_title, R.string.melody_ui_head_motion_try_nod_summary2, file)});
        this.f21063E = listE;
        C1482f c1482f = new C1482f(listE, this.f21060B);
        this.f21075z = c1482f;
        ViewPager2 viewPager2 = this.f21073x;
        if (viewPager2 != null) {
            viewPager2.setAdapter(c1482f);
        }
        ViewPager2 viewPager22 = this.f21073x;
        if (viewPager22 != null) {
            viewPager22.setUserInputEnabled(false);
        }
        COUIButton cOUIButton = (COUIButton) view.findViewById(R.id.head_motion_try_next_button);
        this.f21074y = cOUIButton;
        if (cOUIButton != null) {
            cOUIButton.setOnClickListener(new o(this, 21));
        }
        ViewPager2 viewPager23 = this.f21073x;
        int currentItem = viewPager23 != null ? viewPager23.getCurrentItem() : 0;
        u(currentItem);
        t(currentItem);
        String str = this.f21065p;
        if (str == null || this.f21067r == null) {
            headMotionTryFragment = this;
        } else {
            headMotionTryFragment = this;
            C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new t(new PropertyReference1Impl() { // from class: com.oplus.melody.ui.component.detail.headmotion.HeadMotionTryViewModel$getConnectionState$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, cc.e
                public final Object get(Object obj) {
                    return Integer.valueOf(((EarphoneDTO) obj).getConnectionState());
                }
            }, 7))).e(getViewLifecycleOwner(), new b(new HeadMotionTryFragment$observeConnectionState$1(1, headMotionTryFragment, HeadMotionTryFragment.class, "onConnectionStateChange", "onConnectionStateChange(Ljava/lang/Integer;)V", 0)));
        }
        if (headMotionTryFragment.f21067r != null) {
            androidx.lifecycle.s<HeadMotionTryResultDTO> sVarB = AbstractC0939b.E().B();
            h.d(sVarB, "getHeadMotionTryResultEvent(...)");
            sVarB.e(getViewLifecycleOwner(), new b(new C1017a(this, 6)));
        }
    }

    public final void r(boolean z2) {
        ViewPager2 viewPager2;
        String str = this.f21065p;
        if (str == null || (viewPager2 = this.f21073x) == null) {
            return;
        }
        int i10 = viewPager2.getCurrentItem() == 0 ? 1 : 2;
        A.b("HeadMotionTryFragment", "setHeadMotionTryMode tryType = " + i10);
        if (this.f21067r != null) {
            CompletableFuture completableFutureP0 = AbstractC0939b.E().p0(i10, z2, str);
            h.d(completableFutureP0, "setHeadMotionTryMode(...)");
            completableFutureP0.thenAcceptAsync((Consumer) new G8.h(new N8.a(z2, this), 20), (Executor) o0.c.f1144b);
        }
    }

    public final void s() {
        androidx.fragment.app.f activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        f fVar = this.f21070u;
        if (fVar == null || !fVar.isShowing()) {
            e eVar = new e(activity);
            eVar.n(R.string.melody_common_control_guide_device_disconnect_title);
            eVar.h(R.string.melody_ui_common_exit, new DialogInterfaceOnClickListenerC1018b(activity, 1));
            this.f21070u = eVar.setCancelable(false).show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void t(int r4) {
        /*
            r3 = this;
            com.coui.appcompat.button.COUIButton r0 = r3.f21074y
            if (r0 == 0) goto L12
            if (r4 < 0) goto Le
            boolean[] r1 = r3.f21059A
            int r2 = r1.length
            if (r4 >= r2) goto Le
            boolean r4 = r1[r4]
            goto Lf
        Le:
            r4 = 0
        Lf:
            r0.setEnabled(r4)
        L12:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.headmotion.HeadMotionTryFragment.t(int):void");
    }

    public final void u(int i10) {
        COUIButton cOUIButton = this.f21074y;
        if (cOUIButton != null) {
            List<C1481e> list = this.f21063E;
            if (list != null) {
                cOUIButton.setText(i10 < Kb.l.d(list) ? R.string.melody_common_gold_hearing_next_step : R.string.melody_common_control_guide_complete);
            } else {
                h.i("pageItems");
                throw null;
            }
        }
    }
}
