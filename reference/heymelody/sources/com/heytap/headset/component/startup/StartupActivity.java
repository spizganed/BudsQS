package com.heytap.headset.component.startup;

import A6.b;
import A9.k;
import Aa.e;
import D7.C0373g;
import E9.t;
import S7.c;
import Wb.l;
import X.d;
import X3.w;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.view.WindowManager;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import com.heytap.headset.R;
import com.heytap.headset.component.mydevicelist.MyDeviceCardListViewModel;
import com.heytap.headset.component.mydevicelist.MyDeviceListViewModel;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0909o;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ForkJoinPool;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import m4.f;

/* JADX INFO: compiled from: StartupActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0014J\u001c\u0010\u0017\u001a\u00020\u00132\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J \u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0002J0\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0002J\b\u0010,\u001a\u00020!H\u0002J\b\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020\u0013H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/heytap/headset/component/startup/StartupActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "mainHandler", "Landroid/os/Handler;", "hasRouteAway", "", "mStatementDialog", "Lcom/coui/appcompat/panel/COUIBottomSheetDialog;", "mUseBasicFunctionsDialog", "deviceItemMap", "", "", "Lcom/heytap/headset/component/mydevicelist/MyDeviceItemVO;", "hasOplusDevice", "mRuntimePermissionAlert", "Lcom/heytap/headset/widget/RuntimePermissionAlert;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setCustomTheme", "onDeviceItemListChange", "itemMap", "checkConnectDevice", "delay", "", "goStartScanPage", "checkAgreeStatement", "showUseBasicFunctionsOnlyDialog", "hasPrivacyStatementAcceptedRecord", "getStatementInfo", "", "hasStatementAcceptedRecord", "isPrivacyStatementVersionChanged", "isUserAgreementStatementVersionChanged", "getStatementSpannableString", "Landroid/text/SpannableStringBuilder;", "statementContent", "privacyStatement", "userAgreement", "hasPrivacySpan", "hasUserAgreementSpan", "getUseBasicFunctionsOnlyInfo", "getFunctionLimitedInfo", "onDestroy", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StartupActivity extends F8.a {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final /* synthetic */ int f17555b0 = 0;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public boolean f17557V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public COUIBottomSheetDialog f17558W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public COUIBottomSheetDialog f17559X;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public boolean f17561Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public f f17562a0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final Handler f17556U = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public Map<String, V3.a> f17560Y = kotlin.collections.a.b0();

    /* JADX INFO: compiled from: StartupActivity.kt */
    public static final class a implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctionReferenceImpl f17563a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(l lVar) {
            this.f17563a = (FunctionReferenceImpl) lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f17563a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [Wb.l, kotlin.jvm.internal.FunctionReferenceImpl] */
        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f17563a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.heytap.headset.component.startup.StartupActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: StartupActivity.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements l<Map<String, ? extends V3.a>, Jb.l> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // Wb.l
        public final Jb.l d(Map<String, ? extends V3.a> map) {
            Map<String, ? extends V3.a> p02 = map;
            h.e(p02, "p0");
            StartupActivity startupActivity = (StartupActivity) this.receiver;
            int i10 = StartupActivity.f17555b0;
            startupActivity.getClass();
            A.c("StartupActivity", new c(p02, 7));
            startupActivity.f17560Y = p02;
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.heytap.headset.component.startup.StartupActivity$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: StartupActivity.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements l<Map<String, ? extends V3.a>, Jb.l> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // Wb.l
        public final Jb.l d(Map<String, ? extends V3.a> map) {
            Map<String, ? extends V3.a> p02 = map;
            h.e(p02, "p0");
            StartupActivity startupActivity = (StartupActivity) this.receiver;
            int i10 = StartupActivity.f17555b0;
            startupActivity.getClass();
            A.c("StartupActivity", new c(p02, 7));
            startupActivity.f17560Y = p02;
            return Jb.l.f2618a;
        }
    }

    @Override // F8.a
    public final void E() {
        if (C0373g.f1086l) {
            setTheme(R.style.combine_heymelody_app_start);
        }
    }

    public final void I() {
        if (C0373g.f1086l) {
            ForkJoinPool.commonPool().execute(new t(this, 21));
        }
        this.f17556U.postDelayed(new k(this, 29), 500L);
    }

    public final void J() {
        A.b("StartupActivity", "goStartScanPage");
        this.f17556U.postDelayed(new e(this, 22), 500L);
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 28) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        super.onCreate(savedInstanceState);
        C0909o.i(this, false, false);
        setContentView(R.layout.heymelody_app_activity_startup);
        D(R.id.startup_layout, true);
        if (C0373g.f1086l) {
            O viewModelStore = getViewModelStore();
            N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
            d dVarC = b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
            kotlin.jvm.internal.b bVarA = j.a(MyDeviceCardListViewModel.class);
            String strA = bVarA.a();
            if (strA == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            ((MyDeviceCardListViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA))).d(this).e(this, new a(new AnonymousClass1(1, this, StartupActivity.class, "onDeviceItemListChange", "onDeviceItemListChange(Ljava/util/Map;)V", 0)));
        } else {
            O viewModelStore2 = getViewModelStore();
            N.b defaultViewModelProviderFactory2 = getDefaultViewModelProviderFactory();
            d dVarC2 = b.c(defaultViewModelProviderFactory2, "factory", viewModelStore2, defaultViewModelProviderFactory2, getDefaultViewModelCreationExtras());
            kotlin.jvm.internal.b bVarA2 = j.a(MyDeviceListViewModel.class);
            String strA2 = bVarA2.a();
            if (strA2 == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            ((MyDeviceListViewModel) dVarC2.a(bVarA2, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA2))).d(this).e(this, new a(new AnonymousClass2(1, this, StartupActivity.class, "onDeviceItemListChange", "onDeviceItemListChange(Ljava/util/Map;)V", 0)));
        }
        WeakHashMap<Activity, f> weakHashMap = f.f26302s;
        this.f17562a0 = f.a.a(this);
        this.f17556U.postDelayed(new w(this, 1), 500L);
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onDestroy() {
        COUIBottomSheetDialog cOUIBottomSheetDialog;
        COUIBottomSheetDialog cOUIBottomSheetDialog2;
        super.onDestroy();
        COUIBottomSheetDialog cOUIBottomSheetDialog3 = this.f17558W;
        if (cOUIBottomSheetDialog3 != null && cOUIBottomSheetDialog3.isShowing() && (cOUIBottomSheetDialog2 = this.f17558W) != null) {
            cOUIBottomSheetDialog2.dismiss();
        }
        this.f17558W = null;
        COUIBottomSheetDialog cOUIBottomSheetDialog4 = this.f17559X;
        if (cOUIBottomSheetDialog4 != null && cOUIBottomSheetDialog4.isShowing() && (cOUIBottomSheetDialog = this.f17559X) != null) {
            cOUIBottomSheetDialog.dismiss();
        }
        this.f17559X = null;
    }
}
