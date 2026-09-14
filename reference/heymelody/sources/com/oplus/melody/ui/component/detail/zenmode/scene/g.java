package com.oplus.melody.ui.component.detail.zenmode.scene;

import B.H;
import D7.C0379m;
import D7.Q;
import D7.o0;
import Ea.L;
import L8.DialogInterfaceOnDismissListenerC0457d;
import X3.w;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.media3.session.N0;
import androidx.media3.session.q1;
import androidx.recyclerview.widget.C0704j;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.B;
import com.heytap.headset.R;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.common.helper.MelodyAlivePreferencesHelper;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.B;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.I;
import com.oplus.melody.model.repository.zenmode.ZenModeRepository;
import com.oplus.melody.model.repository.zenmode.t;
import com.oplus.melody.ui.component.detail.zenmode.ZenModeViewModel;
import com.oplus.melody.ui.component.detail.zenmode.scene.b;
import com.oplus.melody.ui.component.detail.zenmode.scene.c;
import com.oplus.melody.ui.component.detail.zenmode.scene.e;
import com.oplus.melody.ui.component.detail.zenmode.scene.recyclerview.ZenModeGridLayoutManager;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import da.C0975b;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: compiled from: ZenModeSceneFragment.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends F8.c implements b.a, View.OnClickListener {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public ZenModeViewModel f21450A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final L f21451B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final Handler f21452C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public TelephonyManager f21453D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f21454E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public String f21455F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public String f21456G;
    public String H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public String f21457I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final a f21458J;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public androidx.appcompat.app.i f21459p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final o f21460q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d f21461r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public c f21462s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public b f21463t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f21464u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public RecyclerView f21465v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Button f21466w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Guideline f21467x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Guideline f21468y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f21469z;

    /* JADX INFO: compiled from: ZenModeSceneFragment.java */
    public class a extends PhoneStateListener {
        public a() {
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCallStateChanged(int i10, String str) {
            if (i10 == 1 || i10 == 2) {
                ZenModeRepository.j().b(g.this.f21460q.f21495a);
            }
        }
    }

    /* JADX INFO: compiled from: ZenModeSceneFragment.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Activity f21471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f21472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.appcompat.app.f f21473c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public androidx.appcompat.app.f f21474d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public androidx.appcompat.app.f f21475e;

        public final void a() {
            Activity activity;
            androidx.appcompat.app.f fVar = this.f21474d;
            if ((fVar != null && fVar.isShowing()) || (activity = this.f21471a) == null || activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            G7.b bVar = new G7.b(activity);
            bVar.n(R.string.melody_ui_zen_mode_send_fail);
            bVar.l(R.string.melody_ui_zen_mode_send_fail_positive_button, new j(this, 0));
            bVar.h(R.string.melody_ui_common_cancel, null);
            this.f21474d = bVar.setCancelable(false).show();
        }

        public final void b() {
            Activity activity;
            androidx.appcompat.app.f fVar = this.f21473c;
            if ((fVar != null && fVar.isShowing()) || (activity = this.f21471a) == null || activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            G7.b bVar = new G7.b(activity);
            bVar.n(R.string.melody_ui_zen_mode_send_succeed);
            bVar.l(R.string.melody_ui_all_right, null);
            this.f21473c = bVar.setOnDismissListener(new DialogInterfaceOnDismissListenerC0457d(this, 1)).setCancelable(false).show();
        }
    }

    /* JADX INFO: compiled from: ZenModeSceneFragment.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f21476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.appcompat.app.f f21477b;

        public c(Activity context) {
            this.f21476a = context;
            k kVar = new k();
            kotlin.jvm.internal.h.e(context, "context");
            A.c("MelodyProgressSpinnerDialog", new Q(2));
            androidx.appcompat.app.f fVarCreate = new G7.b(context, R.style.COUIAlertDialog_Progress).setOnCancelListener(kVar).setCancelable(false).create();
            kotlin.jvm.internal.h.d(fVarCreate, "create(...)");
            this.f21477b = fVarCreate;
        }
    }

    /* JADX INFO: compiled from: ZenModeSceneFragment.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Activity f21478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f21479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList f21480c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public o f21481d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C0975b f21482e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public RecyclerView f21483f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f21484g;
        public String h;
    }

    public g() {
        o oVar = new o();
        oVar.f21495a = null;
        oVar.f21498d = null;
        oVar.f21500f = false;
        oVar.f21501g = null;
        Type type = MelodyAlivePreferencesHelper.f19403a;
        oVar.f21503j = MelodyAlivePreferencesHelper.d(C0906l.f19501a);
        this.f21460q = oVar;
        this.f21464u = new ArrayList();
        this.f21451B = new L(this, 1);
        this.f21452C = new Handler(Looper.getMainLooper());
        this.f21453D = null;
        this.f21454E = 0;
        this.f21458J = new a();
    }

    @Override // com.oplus.melody.ui.component.detail.zenmode.scene.b.a
    public final void d() {
        A.c("ZenModeSceneFragment", new I(this, 6));
        d dVar = this.f21461r;
        if (dVar != null) {
            o oVar = dVar.f21481d;
            ArrayList arrayList = dVar.f21480c;
            oVar.getClass();
            String strA = o.a(arrayList);
            int i10 = 0;
            oVar.d(arrayList, false);
            int size = arrayList.size();
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                da.d dVar2 = (da.d) obj;
                ZenModeInfoDO zenModeInfoDO = dVar2.f22301c;
                if (TextUtils.equals(strA, zenModeInfoDO != null ? zenModeInfoDO.getResId() : VersionInfo.VENDOR_CODE_ERROR_VERSION)) {
                    dVar2.h = true;
                }
            }
            Activity activity = dVar.f21478a;
            if (activity != null) {
                activity.runOnUiThread(new w(dVar, 21));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f21466w) {
            long j5 = this.f21469z;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f21469z = jElapsedRealtime;
            if (jElapsedRealtime - j5 < 300) {
                return;
            }
            b.C0229b.f19632a.b(getContext(), this.f21455F, LeFilterConstants.FunType.ZEN_MODE.getFunType(), new q1(this, 9));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            A.h("ZenModeSceneFragment", "onCreate args is null");
            getActivity().finish();
            return;
        }
        setHasOptionsMenu(true);
        this.f21459p = (androidx.appcompat.app.i) getActivity();
        t tVar = (t) C0917x.c(t.class, arguments.getString("resZipConfig"));
        this.f21455F = arguments.getString("device_mac_info");
        this.H = arguments.getString("product_id");
        this.f21456G = arguments.getString("device_name");
        this.f21457I = arguments.getString("product_color");
        O store = getViewModelStore();
        N.b factory = getDefaultViewModelProviderFactory();
        W.a defaultViewModelCreationExtras = getDefaultViewModelCreationExtras();
        kotlin.jvm.internal.h.e(store, "store");
        kotlin.jvm.internal.h.e(factory, "factory");
        X.d dVarB = A6.g.b(defaultViewModelCreationExtras, "defaultCreationExtras", store, factory, defaultViewModelCreationExtras);
        kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(ZenModeViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        ZenModeViewModel zenModeViewModel = (ZenModeViewModel) dVarB.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f21450A = zenModeViewModel;
        zenModeViewModel.f21410b = this.f21455F;
        zenModeViewModel.f21411c = this.H;
        zenModeViewModel.f21413e = this.f21456G;
        zenModeViewModel.f21414f = tVar;
        Bundle arguments2 = getArguments();
        ZenModeViewModel zenModeViewModel2 = this.f21450A;
        o oVar = this.f21460q;
        if (bundle != null) {
            oVar.getClass();
            oVar.f21498d = bundle.getString("chosen_id", null);
        }
        oVar.f21499e = arguments2;
        oVar.f21496b = arguments2.getString("product_id");
        oVar.f21497c = arguments2.getString("product_color");
        arguments2.getString("device_name");
        oVar.f21495a = arguments2.getString("device_mac_info");
        oVar.f21504k = zenModeViewModel2;
        o0.c.f1145c.execute(new B(oVar, 13));
        b.C0235b.f21441a.f21433c.add(this);
        this.f21453D = (TelephonyManager) getContext().getSystemService("phone");
        if (com.oplus.melody.common.util.Q.c("android.permission.READ_PHONE_STATE")) {
            this.f21453D.listen(this.f21458J, 32);
        }
        EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(oVar.f21495a);
        if (earphoneDTOW != null) {
            oVar.h = earphoneDTOW.getWearDetectionStatus();
            A.c("ZenModeSceneFragment", new X3.l(this, 18));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        g gVar;
        Button button;
        View viewInflate = layoutInflater.inflate(R.layout.melody_ui_fragment_zen_mode_scene, viewGroup, false);
        this.f21465v = (RecyclerView) viewInflate.findViewById(R.id.zen_mode_scene_recycler_view);
        this.f21466w = (Button) viewInflate.findViewById(R.id.zen_mode_scene_save_button);
        this.f21467x = (Guideline) viewInflate.findViewById(R.id.zen_mode_scene_save_button_top_guideline);
        this.f21468y = (Guideline) viewInflate.findViewById(R.id.zen_mode_scene_save_button_bottom_guideline);
        if (getContext().getResources().getBoolean(R.bool.melody_ui_is_w610dp)) {
            this.f21467x.setGuidelinePercent(0.8475f);
            this.f21468y.setGuidelinePercent(0.9325f);
        } else {
            this.f21467x.setGuidelinePercent(0.8775f);
            this.f21468y.setGuidelinePercent(0.9325f);
        }
        this.f21466w.setOnClickListener(this);
        this.f21462s = new c(this.f21459p);
        androidx.appcompat.app.i iVar = this.f21459p;
        o oVar = this.f21460q;
        b bVar = new b();
        bVar.f21471a = iVar;
        bVar.f21472b = this;
        this.f21463t = bVar;
        RecyclerView recyclerView = this.f21465v;
        String str = this.H;
        String str2 = this.f21457I;
        ArrayList arrayList = this.f21464u;
        d dVar = new d();
        dVar.f21478a = iVar;
        dVar.f21479b = this;
        dVar.f21483f = recyclerView;
        dVar.f21481d = oVar;
        dVar.h = str2;
        dVar.f21484g = str;
        dVar.f21480c = arrayList;
        this.f21461r = dVar;
        Bundle bundle2 = oVar.f21499e;
        if (bundle2 == null ? false : bundle2.getBoolean("extra_is_created_by_success", false)) {
            bVar.b();
        }
        b bVar2 = this.f21463t;
        o oVar2 = this.f21460q;
        bVar2.getClass();
        Bundle bundle3 = oVar2.f21499e;
        if (bundle3 == null ? false : bundle3.getBoolean("extra_is_created_by_failure", false)) {
            bVar2.a();
        }
        d dVar2 = this.f21461r;
        dVar2.getClass();
        com.oplus.melody.ui.component.detail.zenmode.scene.b bVar3 = b.C0235b.f21441a;
        boolean z2 = bVar3.f21439j != null;
        if (!z2 && !bVar3.f21438i) {
            bVar3.b(dVar2.f21479b.getContext(), dVar2.f21484g, dVar2.h);
        }
        dVar2.f21481d.d(dVar2.f21480c, !z2);
        C0975b c0975b = new C0975b(C0906l.f19501a, dVar2.f21480c, dVar2.f21484g, dVar2.h);
        dVar2.f21482e = c0975b;
        c0975b.h = new l(dVar2);
        ZenModeGridLayoutManager zenModeGridLayoutManager = new ZenModeGridLayoutManager(dVar2.f21478a.getResources().getInteger(R.integer.melody_ui_zen_mode_recycler_view_span_count), 0);
        dVar2.f21483f.setLayoutManager(zenModeGridLayoutManager);
        dVar2.f21483f.setAdapter(dVar2.f21482e);
        dVar2.f21483f.addItemDecoration(new m());
        dVar2.f21483f.setItemAnimator(new C0704j());
        zenModeGridLayoutManager.x1(1);
        int iB = o.b(dVar2.f21481d.c(), dVar2.f21480c);
        String str3 = dVar2.f21481d.f21498d;
        if (!TextUtils.isEmpty(str3)) {
            dVar2.f21482e.f(o.b(str3, dVar2.f21480c));
        } else if (iB >= 0) {
            dVar2.f21482e.f(iB);
        } else if (iB == -1 && (button = (gVar = dVar2.f21479b).f21466w) != null) {
            button.setEnabled(gVar.s());
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        com.oplus.melody.ui.component.detail.zenmode.scene.b bVar = b.C0235b.f21441a;
        bVar.f21433c.remove(this);
        bVar.f21440k = null;
        ZenModeRepository.j().D();
        if (com.oplus.melody.common.util.Q.c("android.permission.READ_PHONE_STATE")) {
            this.f21453D.listen(this.f21458J, 0);
        }
        if (bVar.f21437g) {
            new H(c.a.f21443a.f21442a).f199b.cancel(null, 4);
        }
        ZenModeRepository.j().b(this.f21460q.f21495a);
        bVar.f21437g = false;
        B.a.f19427a.a(this.f21451B, "ZenModeSceneFragment");
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        androidx.appcompat.app.f fVar = this.f21462s.f21477b;
        Ea.B.a(fVar, 0);
        fVar.dismiss();
        b bVar = this.f21463t;
        androidx.appcompat.app.f fVar2 = bVar.f21473c;
        if (fVar2 != null) {
            fVar2.cancel();
        }
        androidx.appcompat.app.f fVar3 = bVar.f21474d;
        if (fVar3 != null) {
            fVar3.cancel();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332) {
            A.b("ZenModeSceneFragment", "onOptionsItemSelected home");
            getActivity().finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        new H(c.a.f21443a.f21442a).f199b.cancel(null, 4);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ArrayList arrayList = this.f21464u;
        this.f21460q.getClass();
        bundle.putString("chosen_id", o.a(arrayList));
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        o oVar = this.f21460q;
        oVar.f();
        b.C0235b.f21441a.h = true;
        B.a.f19427a.b(this.f21451B, "ZenModeSceneFragment");
        if (oVar.h == 1 && !oVar.f21502i) {
            e.a.f21449a.f21448d = false;
            this.f21452C.postDelayed(new com.airbnb.lottie.B(this, 12), 2000L);
            return;
        }
        e.a.f21449a.f21448d = true;
        C0975b c0975b = this.f21461r.f21482e;
        if (c0975b != null) {
            c0975b.notifyDataSetChanged();
        }
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onStop() {
        MediaPlayer mediaPlayer;
        super.onStop();
        this.f21460q.e();
        b.C0235b.f21441a.h = false;
        e eVar = e.a.f21449a;
        if (eVar.f21448d && (mediaPlayer = eVar.f21446b) != null && eVar.f21447c == 2) {
            eVar.f21447c = 3;
            mediaPlayer.pause();
        }
        B.a.f19427a.a(this.f21451B, "ZenModeSceneFragment");
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        A.b("ZenModeSceneFragment", "onViewCreated");
        this.f21450A.getClass();
        AbstractC0939b.E().q().e(getViewLifecycleOwner(), new A6.l(this, 20));
        ZenModeViewModel zenModeViewModel = this.f21450A;
        String str = this.f21455F;
        zenModeViewModel.getClass();
        C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new A6.b(16))).e(getViewLifecycleOwner(), new C9.a(this, 17));
        ZenModeViewModel zenModeViewModel2 = this.f21450A;
        String str2 = this.f21455F;
        zenModeViewModel2.getClass();
        C0379m.b(C0379m.g(AbstractC0939b.E().v(str2), new A6.f(11))).e(getViewLifecycleOwner(), new C6.e(this, 29));
        MelodyCompatToolbar melodyCompatToolbar = (MelodyCompatToolbar) view.findViewById(R.id.toolbar);
        melodyCompatToolbar.setTitle(getString(R.string.melody_ui_zen_mode_sound_scene_title));
        this.f21459p.y(melodyCompatToolbar);
        melodyCompatToolbar.setNavigationOnClickListener(new E9.o(this, 15));
        setHasOptionsMenu(true);
        androidx.appcompat.app.a aVarX = this.f21459p.x();
        if (aVarX != null) {
            aVarX.n(true);
            aVarX.r(true);
        }
    }

    public final void r() {
        Activity activity;
        if (this.f21454E != 2) {
            this.f21459p.finish();
            return;
        }
        if (!s()) {
            this.f21459p.finish();
            return;
        }
        b bVar = this.f21463t;
        androidx.appcompat.app.f fVar = bVar.f21475e;
        if ((fVar != null && fVar.isShowing()) || (activity = bVar.f21471a) == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        G7.b bVar2 = new G7.b(activity);
        bVar2.n(R.string.melody_ui_zen_mode_if_save_current_modification);
        bVar2.l(R.string.melody_ui_save, new H8.f(bVar, 9));
        bVar2.h(R.string.melody_ui_abandon, new j(bVar, 1));
        bVar.f21475e = bVar2.setCancelable(false).show();
    }

    public final boolean s() {
        ArrayList arrayList = this.f21464u;
        this.f21460q.getClass();
        if (o.a(arrayList) == null) {
            return false;
        }
        return !TextUtils.equals(r0, b.C0235b.f21441a.f21434d != null ? String.valueOf(r2.getFileId()) : r1.c());
    }

    public final void t() {
        TextView textView;
        this.f21463t.getClass();
        com.oplus.melody.ui.component.detail.zenmode.scene.b bVar = b.C0235b.f21441a;
        bVar.getClass();
        if (this.f21454E != 2) {
            E8.a.S(C0906l.f19501a, R.string.melody_ui_fit_detection_break_toast);
            return;
        }
        e.a.f21449a.a();
        B.a.f19427a.b(this.f21451B, "ZenModeSceneFragment");
        c cVar = this.f21462s;
        Activity activity = cVar.f21476a;
        if (activity != null && !activity.isDestroyed() && !cVar.f21476a.isFinishing()) {
            cVar.f21477b.setCancelable(false);
            cVar.f21477b.setTitle(C0906l.f19501a.getString(R.string.melody_ui_zen_mode_sending_music_to_headset, String.valueOf(0)));
            cVar.f21477b.show();
            Window window = cVar.f21477b.getWindow();
            if (window != null && (textView = (TextView) window.findViewById(R.id.alertTitle)) != null) {
                textView.setFontFeatureSettings("tnum");
            }
        }
        i iVar = new i(this);
        bVar.f21437g = true;
        bVar.f21440k = iVar;
        ZenModeRepository.j().v();
        this.f21452C.postDelayed(new N0(this, 6), 1000L);
    }
}
