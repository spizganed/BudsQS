package com.oplus.melody.spy;

import D7.C0379m;
import D7.f0;
import E9.r;
import Ea.F;
import Kb.k;
import Wb.l;
import a9.C0531H;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUICheckBoxPreference;
import com.coui.appcompat.preference.COUIPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.coui.appcompat.tips.def.COUIDefaultTopTips;
import com.google.android.play.core.appupdate.c;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.app.discovery.L;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.S;
import com.oplus.melody.common.widget.MelodyCOUIButtonPreference;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.KeyFunctionInfoDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.spy.SpyTapFragment;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.widget.MelodyCOUIPreference;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import g0.C1064c;
import g0.C1065d;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import la.C1294g;
import q8.d;
import r9.C1479c;
import s8.AbstractC1508a;
import t8.q;
import t8.x;
import w8.C1603c;
import w8.C1604d;
import w8.e;
import w8.g;
import w8.i;
import w8.j;
import w8.m;
import w8.n;
import x3.C1656o;

/* JADX INFO: renamed from: com.oplus.melody.spy.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SpyTapFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 _2\u00020\u0001:\u0001_B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u00010%H\u0016J\b\u00103\u001a\u00020/H\u0002J\u0012\u00104\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00105\u001a\u00020/H\u0002J\u0018\u00106\u001a\u00020/2\u000e\u00107\u001a\n\u0012\u0004\u0012\u000209\u0018\u000108H\u0003J\b\u0010:\u001a\u00020/H\u0002J\u0010\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0016J\u001a\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020@2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u0010A\u001a\u00020/H\u0016J\u0010\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020/2\u0006\u0010F\u001a\u00020+H\u0002J\u0010\u0010G\u001a\u00020/2\u0006\u0010F\u001a\u00020+H\u0002J\u0010\u0010H\u001a\u00020/2\u0006\u0010F\u001a\u00020+H\u0002J\u0010\u0010I\u001a\u00020/2\u0006\u0010F\u001a\u00020+H\u0002J\u0010\u0010J\u001a\u00020/2\u0006\u0010F\u001a\u00020+H\u0002J\u0010\u0010K\u001a\u00020/2\u0006\u0010F\u001a\u00020+H\u0002J\u0010\u0010L\u001a\u00020/2\u0006\u0010F\u001a\u00020+H\u0002J\u0010\u0010M\u001a\u00020/2\u0006\u0010F\u001a\u00020+H\u0002J\u0010\u0010N\u001a\u00020/2\u0006\u0010F\u001a\u00020+H\u0002J\u0010\u0010O\u001a\u00020/2\u0006\u0010F\u001a\u00020+H\u0002J\u0010\u0010P\u001a\u00020/2\u0006\u0010F\u001a\u00020+H\u0002J\u0010\u0010Q\u001a\u00020/2\u0006\u0010F\u001a\u00020+H\u0002J\u0010\u0010R\u001a\u00020/2\u0006\u0010(\u001a\u00020)H\u0002J\u0012\u0010S\u001a\u00020/2\b\b\u0002\u0010T\u001a\u00020+H\u0002J0\u0010U\u001a\b\u0012\u0004\u0012\u000209082\u0006\u0010V\u001a\u00020+2\b\b\u0002\u0010W\u001a\u00020+2\u0006\u0010X\u001a\u00020)2\u0006\u0010F\u001a\u00020+H\u0002J \u0010Y\u001a\u00020/2\u0006\u0010Z\u001a\u00020)2\u0006\u0010[\u001a\u00020)2\u0006\u0010\\\u001a\u00020)H\u0002J\u0010\u0010]\u001a\u00020+2\u0006\u0010\\\u001a\u00020)H\u0002J\u0010\u0010^\u001a\u00020)2\u0006\u0010\\\u001a\u00020)H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/oplus/melody/spy/SpyTapFragment;", "Lcom/oplus/melody/ui/base/BaseCOUIPreferenceFragment;", "<init>", "()V", "doneBtn", "Lcom/oplus/melody/ui/widget/MelodyCompatButton;", "getDoneBtn", "()Lcom/oplus/melody/ui/widget/MelodyCompatButton;", "setDoneBtn", "(Lcom/oplus/melody/ui/widget/MelodyCompatButton;)V", "viewModel", "Lcom/oplus/melody/spy/SpyTapViewModel;", "spCategory", "Lcom/coui/appcompat/preference/COUIPreferenceCategory;", "spButton", "Lcom/oplus/melody/common/widget/MelodyCOUIButtonPreference;", "spTitle", "Lcom/coui/appcompat/preference/COUIPreference;", "spSingleClickSwitch", "Lcom/coui/appcompat/preference/COUISwitchPreference;", "spSingleClickLeftCheck", "Lcom/coui/appcompat/preference/COUICheckBoxPreference;", "spSingleClickRightCheck", "spDoubleClickSwitch", "spDoubleClickLeftCheck", "spDoubleClickRightCheck", "spTripleClickSwitch", "spTripleClickLeftCheck", "spTripleClickRightCheck", "spLongClickSwitch", "spLongClickLeftCheck", "spLongClickRightCheck", "topTips", "Lcom/coui/appcompat/tips/def/COUIDefaultTopTips;", "configFunction", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$Function;", "address", "", "productName", "from", "pkgInstallState", "", "isAlreadySet", "", "isSwitching", "isSupportPinch", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "initTopGuide", "onCreate", "initData", "onKeyFunctionInfoChanged", "list", "", "Lcom/oplus/melody/model/repository/earphone/KeyFunctionInfoDTO;", "checkAndInitFromSpy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onViewCreated", "view", "Landroid/view/View;", "onResume", "onPreferenceTreeClick", "preference", "Landroidx/preference/Preference;", "setSingleClickSwitch", "isChecked", "setSingleClickLeftCheck", "setSingleClickRightCheck", "setDoubleClickSwitch", "setDoubleClickLeftCheck", "setDoubleClickRightCheck", "setTripleClickSwitch", "setTripleClickLeftCheck", "setTripleClickRightCheck", "setLongClickSwitch", "setLongClickLeftCheck", "setLongClickRightCheck", "updateInstallBtn", "updateTitleAndSwitchVisible", "isVisible", "makeKeyFunctions", "both", "isLeft", "controlActionType", "trackFunControl", "keyFunction", "controlType", "actionType", "isControlSupportSpyTap", "getRealActionType", "Companion", "spy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SpyTapFragment extends F8.b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public SpyTapViewModel f20236A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public COUIPreferenceCategory f20237B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public MelodyCOUIButtonPreference f20238C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public COUIPreference f20239D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public COUISwitchPreference f20240E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public COUICheckBoxPreference f20241F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public COUICheckBoxPreference f20242G;
    public COUISwitchPreference H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public COUICheckBoxPreference f20243I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public COUICheckBoxPreference f20244J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public COUISwitchPreference f20245K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public COUICheckBoxPreference f20246L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public COUICheckBoxPreference f20247M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public COUISwitchPreference f20248N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public COUICheckBoxPreference f20249O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public COUICheckBoxPreference f20250P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public COUIDefaultTopTips f20251Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public WhitelistConfigDTO.Function f20252R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public String f20253S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public String f20254T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public String f20255U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public int f20256V = -1;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public boolean f20257W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public boolean f20258X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public boolean f20259Y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public MelodyCompatButton f20260z;

    /* JADX INFO: renamed from: com.oplus.melody.spy.a$a */
    /* JADX INFO: compiled from: SpyTapFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20261a;

        public a(l lVar) {
            this.f20261a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20261a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20261a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.spy.a$b */
    /* JADX INFO: compiled from: SpyTapFragment.kt */
    public static final class b implements MelodyCOUIButtonPreference.a {
        public b() {
        }

        @Override // com.oplus.melody.common.widget.MelodyCOUIButtonPreference.a
        public final void a(MelodyCOUIButtonPreference melodyCOUIButtonPreference) {
            J7.b.a().d();
            A.c("SpyTopHelper", new r(26, true));
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                h.i("context");
                throw null;
            }
            C0905k.a(heyMelodyApplication, "com.spotify.music", "com.android.vending");
            SpyTapFragment spyTapFragment = SpyTapFragment.this;
            if (spyTapFragment.f20236A != null) {
                EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(spyTapFragment.f20253S);
                if (earphoneDTOW != null) {
                    C1264t.t(AppConstant$FunctionType.SPY_TAP.getFunType(), earphoneDTOW.getProductId(), earphoneDTOW.getMacAddress(), N.t(earphoneDTOW), BaseHealthModule.TRACK_ACTIVE_DETECT);
                }
            }
        }
    }

    public static List u(int i10, boolean z2, boolean z4, boolean z10) {
        if (z2) {
            return c.e(new KeyFunctionInfoDTO[]{new KeyFunctionInfoDTO(1, 1, i10, z10 ? 32 : 33), new KeyFunctionInfoDTO(2, 1, i10, z10 ? 32 : 33)});
        }
        return k.b(new KeyFunctionInfoDTO(z4 ? 1 : 2, 1, i10, z10 ? 32 : 33));
    }

    public final void A(final int i10, final int i11, final int i12) {
        ForkJoinPool.commonPool().execute(new Runnable() { // from class: w8.l
            @Override // java.lang.Runnable
            public final void run() {
                SpyTapFragment spyTapFragment = this.f28623a;
                if (spyTapFragment.f20236A != null) {
                    EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(spyTapFragment.f20253S);
                    if (earphoneDTOW != null) {
                        int iB = N.b(i10, earphoneDTOW.getName());
                        C1264t.u(earphoneDTOW.getProductId(), spyTapFragment.f20253S, i11 + 1, spyTapFragment.s(i12), N.t(earphoneDTOW), String.valueOf(iB));
                    }
                }
            }
        });
    }

    public final void B(int i10) {
        A.c("SpyTapFragment", new w8.f(i10, this, 0));
        MelodyCOUIButtonPreference melodyCOUIButtonPreference = this.f20238C;
        if (melodyCOUIButtonPreference != null) {
            if (i10 > 0) {
                melodyCOUIButtonPreference.e(i10 == 1 ? getResources().getString(R.string.melody_common_firmware_find_new_version_dialog_update) : getResources().getString(R.string.melody_common_app_need_install));
                melodyCOUIButtonPreference.f(true);
                melodyCOUIButtonPreference.setSelectable(true);
                melodyCOUIButtonPreference.f19526u = new b();
            } else {
                melodyCOUIButtonPreference.f(false);
                melodyCOUIButtonPreference.setSelectable(false);
            }
        }
        boolean z2 = i10 == 0;
        MelodyCOUIButtonPreference melodyCOUIButtonPreference2 = this.f20238C;
        if (melodyCOUIButtonPreference2 != null) {
            melodyCOUIButtonPreference2.setVisible(!z2);
        }
        COUIPreference cOUIPreference = this.f20239D;
        if (cOUIPreference != null) {
            cOUIPreference.setVisible(z2);
        }
        if (t(1)) {
            COUISwitchPreference cOUISwitchPreference = this.f20240E;
            if (cOUISwitchPreference != null) {
                cOUISwitchPreference.setVisible(z2);
            }
            if (!z2) {
                COUICheckBoxPreference cOUICheckBoxPreference = this.f20241F;
                if (cOUICheckBoxPreference != null) {
                    cOUICheckBoxPreference.setVisible(false);
                }
                COUICheckBoxPreference cOUICheckBoxPreference2 = this.f20242G;
                if (cOUICheckBoxPreference2 != null) {
                    cOUICheckBoxPreference2.setVisible(false);
                }
            }
        }
        if (t(2)) {
            COUISwitchPreference cOUISwitchPreference2 = this.H;
            if (cOUISwitchPreference2 != null) {
                cOUISwitchPreference2.setVisible(z2);
            }
            if (!z2) {
                COUICheckBoxPreference cOUICheckBoxPreference3 = this.f20243I;
                if (cOUICheckBoxPreference3 != null) {
                    cOUICheckBoxPreference3.setVisible(false);
                }
                COUICheckBoxPreference cOUICheckBoxPreference4 = this.f20244J;
                if (cOUICheckBoxPreference4 != null) {
                    cOUICheckBoxPreference4.setVisible(false);
                }
            }
        }
        if (t(4)) {
            COUISwitchPreference cOUISwitchPreference3 = this.f20248N;
            if (cOUISwitchPreference3 != null) {
                cOUISwitchPreference3.setVisible(z2);
            }
            if (!z2) {
                COUICheckBoxPreference cOUICheckBoxPreference5 = this.f20249O;
                if (cOUICheckBoxPreference5 != null) {
                    cOUICheckBoxPreference5.setVisible(false);
                }
                COUICheckBoxPreference cOUICheckBoxPreference6 = this.f20250P;
                if (cOUICheckBoxPreference6 != null) {
                    cOUICheckBoxPreference6.setVisible(false);
                }
            }
        }
        if (t(3)) {
            COUISwitchPreference cOUISwitchPreference4 = this.f20245K;
            if (cOUISwitchPreference4 != null) {
                cOUISwitchPreference4.setVisible(z2);
            }
            if (!z2) {
                COUICheckBoxPreference cOUICheckBoxPreference7 = this.f20246L;
                if (cOUICheckBoxPreference7 != null) {
                    cOUICheckBoxPreference7.setVisible(false);
                }
                COUICheckBoxPreference cOUICheckBoxPreference8 = this.f20247M;
                if (cOUICheckBoxPreference8 != null) {
                    cOUICheckBoxPreference8.setVisible(false);
                }
            }
        }
        A.c("SpyTapFragment", new d(9, z2));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.preference.g, androidx.preference.k.b
    public final boolean f(Preference preference) {
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        COUISwitchPreference cOUISwitchPreference = preference instanceof COUISwitchPreference ? (COUISwitchPreference) preference : null;
        if (cOUISwitchPreference != null) {
            ref$BooleanRef.element = cOUISwitchPreference.isChecked();
        } else {
            COUICheckBoxPreference cOUICheckBoxPreference = preference instanceof COUICheckBoxPreference ? (COUICheckBoxPreference) preference : null;
            if (cOUICheckBoxPreference != null) {
                ref$BooleanRef.element = cOUICheckBoxPreference.isChecked();
            }
        }
        A.c("SpyTapFragment", new n(0, ref$BooleanRef, preference));
        String key = preference.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1742630560:
                    if (key.equals("key_sp_single_click_switch")) {
                        y(ref$BooleanRef.element);
                    }
                    break;
                case -1447273206:
                    if (key.equals("key_sp_triple_click_switch")) {
                        z(ref$BooleanRef.element);
                    }
                    break;
                case -1102132179:
                    if (key.equals("key_sp_long_click_right_check")) {
                        final boolean z2 = ref$BooleanRef.element;
                        final int i10 = 0;
                        A.c("SpyTapFragment", new Supplier() { // from class: w8.b
                            @Override // java.util.function.Supplier
                            public final Object get() {
                                switch (i10) {
                                    case 0:
                                        return C1656o.b(new StringBuilder("KEY_SP_LONG_CLICK_RIGHT_CHECK, isChecked: "), z2, ", isSwitching: ", this.f20258X);
                                    case 1:
                                        return C1656o.b(new StringBuilder("KEY_SP_DOUBLE_CLICK_LEFT_CHECK, isChecked: "), z2, ", isSwitching: ", this.f20258X);
                                    case 2:
                                        return C1656o.b(new StringBuilder("KEY_SP_SINGLE_CLICK_LEFT_CHECK, isChecked: "), z2, ", isSwitching: ", this.f20258X);
                                    case 3:
                                        return C1656o.b(new StringBuilder("KEY_SP_DOUBLE_CLICK_RIGHT_CHECK, isChecked: "), z2, ", isSwitching: ", this.f20258X);
                                    default:
                                        return C1656o.b(new StringBuilder("KEY_SP_LONG_CLICK_LEFT_CHECK, isChecked: "), z2, ", isSwitching: ", this.f20258X);
                                }
                            }
                        });
                        if (this.f20258X) {
                            COUICheckBoxPreference cOUICheckBoxPreference2 = this.f20250P;
                            if (cOUICheckBoxPreference2 != null) {
                                cOUICheckBoxPreference2.setChecked(!z2);
                            }
                        } else {
                            this.f20258X = true;
                            if (this.f20236A != null) {
                                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                                if (heyMelodyApplication == null) {
                                    h.i("context");
                                    throw null;
                                }
                                SpyTapViewModel.d(heyMelodyApplication, this.f20253S, u(4, false, false, z2), new C1603c(this, z2, 0));
                            }
                        }
                    }
                    break;
                case -705975508:
                    if (key.equals("key_sp_long_click_switch")) {
                        x(ref$BooleanRef.element);
                    }
                    break;
                case -417638765:
                    if (key.equals("key_sp_double_click_left_check")) {
                        final boolean z4 = ref$BooleanRef.element;
                        final int i11 = 1;
                        A.c("SpyTapFragment", new Supplier() { // from class: w8.b
                            @Override // java.util.function.Supplier
                            public final Object get() {
                                switch (i11) {
                                    case 0:
                                        return C1656o.b(new StringBuilder("KEY_SP_LONG_CLICK_RIGHT_CHECK, isChecked: "), z4, ", isSwitching: ", this.f20258X);
                                    case 1:
                                        return C1656o.b(new StringBuilder("KEY_SP_DOUBLE_CLICK_LEFT_CHECK, isChecked: "), z4, ", isSwitching: ", this.f20258X);
                                    case 2:
                                        return C1656o.b(new StringBuilder("KEY_SP_SINGLE_CLICK_LEFT_CHECK, isChecked: "), z4, ", isSwitching: ", this.f20258X);
                                    case 3:
                                        return C1656o.b(new StringBuilder("KEY_SP_DOUBLE_CLICK_RIGHT_CHECK, isChecked: "), z4, ", isSwitching: ", this.f20258X);
                                    default:
                                        return C1656o.b(new StringBuilder("KEY_SP_LONG_CLICK_LEFT_CHECK, isChecked: "), z4, ", isSwitching: ", this.f20258X);
                                }
                            }
                        });
                        if (this.f20258X) {
                            COUICheckBoxPreference cOUICheckBoxPreference3 = this.f20243I;
                            if (cOUICheckBoxPreference3 != null) {
                                cOUICheckBoxPreference3.setChecked(!z4);
                            }
                        } else {
                            this.f20258X = true;
                            if (this.f20236A != null) {
                                HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
                                if (heyMelodyApplication2 == null) {
                                    h.i("context");
                                    throw null;
                                }
                                SpyTapViewModel.d(heyMelodyApplication2, this.f20253S, u(2, false, true, z4), new C1603c(this, z4, 1));
                            }
                        }
                    }
                    break;
                case -392911239:
                    if (key.equals("key_sp_single_click_right_check")) {
                        boolean z10 = ref$BooleanRef.element;
                        A.c("SpyTapFragment", new C1604d(2, this, z10));
                        if (this.f20258X) {
                            COUICheckBoxPreference cOUICheckBoxPreference4 = this.f20242G;
                            if (cOUICheckBoxPreference4 != null) {
                                cOUICheckBoxPreference4.setChecked(!z10);
                            }
                        } else {
                            this.f20258X = true;
                            if (this.f20236A != null) {
                                HeyMelodyApplication heyMelodyApplication3 = C0906l.f19501a;
                                if (heyMelodyApplication3 == null) {
                                    h.i("context");
                                    throw null;
                                }
                                SpyTapViewModel.d(heyMelodyApplication3, this.f20253S, u(1, false, false, z10), new e(2, this, z10));
                            }
                        }
                    }
                    break;
                case -212017033:
                    if (key.equals("key_sp_double_click_switch")) {
                        w(ref$BooleanRef.element);
                    }
                    break;
                case -81019192:
                    if (key.equals("key_sp_long_click_left_check")) {
                        final boolean z11 = ref$BooleanRef.element;
                        final int i12 = 4;
                        A.c("SpyTapFragment", new Supplier() { // from class: w8.b
                            @Override // java.util.function.Supplier
                            public final Object get() {
                                switch (i12) {
                                    case 0:
                                        return C1656o.b(new StringBuilder("KEY_SP_LONG_CLICK_RIGHT_CHECK, isChecked: "), z11, ", isSwitching: ", this.f20258X);
                                    case 1:
                                        return C1656o.b(new StringBuilder("KEY_SP_DOUBLE_CLICK_LEFT_CHECK, isChecked: "), z11, ", isSwitching: ", this.f20258X);
                                    case 2:
                                        return C1656o.b(new StringBuilder("KEY_SP_SINGLE_CLICK_LEFT_CHECK, isChecked: "), z11, ", isSwitching: ", this.f20258X);
                                    case 3:
                                        return C1656o.b(new StringBuilder("KEY_SP_DOUBLE_CLICK_RIGHT_CHECK, isChecked: "), z11, ", isSwitching: ", this.f20258X);
                                    default:
                                        return C1656o.b(new StringBuilder("KEY_SP_LONG_CLICK_LEFT_CHECK, isChecked: "), z11, ", isSwitching: ", this.f20258X);
                                }
                            }
                        });
                        if (this.f20258X) {
                            COUICheckBoxPreference cOUICheckBoxPreference5 = this.f20249O;
                            if (cOUICheckBoxPreference5 != null) {
                                cOUICheckBoxPreference5.setChecked(!z11);
                            }
                        } else {
                            this.f20258X = true;
                            if (this.f20236A != null) {
                                HeyMelodyApplication heyMelodyApplication4 = C0906l.f19501a;
                                if (heyMelodyApplication4 == null) {
                                    h.i("context");
                                    throw null;
                                }
                                SpyTapViewModel.d(heyMelodyApplication4, this.f20253S, u(4, false, true, z11), new C1603c(this, z11, 3));
                            }
                        }
                    }
                    break;
                case 829706662:
                    if (key.equals("key_sp_triple_click_left_check")) {
                        boolean z12 = ref$BooleanRef.element;
                        A.c("SpyTapFragment", new j(0, this, z12));
                        if (this.f20258X) {
                            COUICheckBoxPreference cOUICheckBoxPreference6 = this.f20246L;
                            if (cOUICheckBoxPreference6 != null) {
                                cOUICheckBoxPreference6.setChecked(!z12);
                            }
                        } else {
                            this.f20258X = true;
                            if (this.f20236A != null) {
                                HeyMelodyApplication heyMelodyApplication5 = C0906l.f19501a;
                                if (heyMelodyApplication5 == null) {
                                    h.i("context");
                                    throw null;
                                }
                                SpyTapViewModel.d(heyMelodyApplication5, this.f20253S, u(3, false, true, z12), new g(1, this, z12));
                            }
                        }
                    }
                    break;
                case 1188784892:
                    if (key.equals("key_sp_single_click_left_check")) {
                        final boolean z13 = ref$BooleanRef.element;
                        final int i13 = 2;
                        A.c("SpyTapFragment", new Supplier() { // from class: w8.b
                            @Override // java.util.function.Supplier
                            public final Object get() {
                                switch (i13) {
                                    case 0:
                                        return C1656o.b(new StringBuilder("KEY_SP_LONG_CLICK_RIGHT_CHECK, isChecked: "), z13, ", isSwitching: ", this.f20258X);
                                    case 1:
                                        return C1656o.b(new StringBuilder("KEY_SP_DOUBLE_CLICK_LEFT_CHECK, isChecked: "), z13, ", isSwitching: ", this.f20258X);
                                    case 2:
                                        return C1656o.b(new StringBuilder("KEY_SP_SINGLE_CLICK_LEFT_CHECK, isChecked: "), z13, ", isSwitching: ", this.f20258X);
                                    case 3:
                                        return C1656o.b(new StringBuilder("KEY_SP_DOUBLE_CLICK_RIGHT_CHECK, isChecked: "), z13, ", isSwitching: ", this.f20258X);
                                    default:
                                        return C1656o.b(new StringBuilder("KEY_SP_LONG_CLICK_LEFT_CHECK, isChecked: "), z13, ", isSwitching: ", this.f20258X);
                                }
                            }
                        });
                        if (this.f20258X) {
                            COUICheckBoxPreference cOUICheckBoxPreference7 = this.f20241F;
                            if (cOUICheckBoxPreference7 != null) {
                                cOUICheckBoxPreference7.setChecked(!z13);
                            }
                        } else {
                            this.f20258X = true;
                            if (this.f20236A != null) {
                                HeyMelodyApplication heyMelodyApplication6 = C0906l.f19501a;
                                if (heyMelodyApplication6 == null) {
                                    h.i("context");
                                    throw null;
                                }
                                SpyTapViewModel.d(heyMelodyApplication6, this.f20253S, u(1, false, true, z13), new g(0, this, z13));
                            }
                        }
                    }
                    break;
                case 1347562946:
                    if (key.equals("key_sp_double_click_right_check")) {
                        final boolean z14 = ref$BooleanRef.element;
                        final int i14 = 3;
                        A.c("SpyTapFragment", new Supplier() { // from class: w8.b
                            @Override // java.util.function.Supplier
                            public final Object get() {
                                switch (i14) {
                                    case 0:
                                        return C1656o.b(new StringBuilder("KEY_SP_LONG_CLICK_RIGHT_CHECK, isChecked: "), z14, ", isSwitching: ", this.f20258X);
                                    case 1:
                                        return C1656o.b(new StringBuilder("KEY_SP_DOUBLE_CLICK_LEFT_CHECK, isChecked: "), z14, ", isSwitching: ", this.f20258X);
                                    case 2:
                                        return C1656o.b(new StringBuilder("KEY_SP_SINGLE_CLICK_LEFT_CHECK, isChecked: "), z14, ", isSwitching: ", this.f20258X);
                                    case 3:
                                        return C1656o.b(new StringBuilder("KEY_SP_DOUBLE_CLICK_RIGHT_CHECK, isChecked: "), z14, ", isSwitching: ", this.f20258X);
                                    default:
                                        return C1656o.b(new StringBuilder("KEY_SP_LONG_CLICK_LEFT_CHECK, isChecked: "), z14, ", isSwitching: ", this.f20258X);
                                }
                            }
                        });
                        if (this.f20258X) {
                            COUICheckBoxPreference cOUICheckBoxPreference8 = this.f20244J;
                            if (cOUICheckBoxPreference8 != null) {
                                cOUICheckBoxPreference8.setChecked(!z14);
                            }
                        } else {
                            this.f20258X = true;
                            if (this.f20236A != null) {
                                HeyMelodyApplication heyMelodyApplication7 = C0906l.f19501a;
                                if (heyMelodyApplication7 == null) {
                                    h.i("context");
                                    throw null;
                                }
                                SpyTapViewModel.d(heyMelodyApplication7, this.f20253S, u(2, false, false, z14), new C1603c(this, z14, 2));
                            }
                        }
                    }
                    break;
                case 1360565519:
                    if (key.equals("key_sp_triple_click_right_check")) {
                        boolean z15 = ref$BooleanRef.element;
                        A.c("SpyTapFragment", new w8.h(1, this, z15));
                        if (this.f20258X) {
                            COUICheckBoxPreference cOUICheckBoxPreference9 = this.f20247M;
                            if (cOUICheckBoxPreference9 != null) {
                                cOUICheckBoxPreference9.setChecked(!z15);
                            }
                        } else {
                            this.f20258X = true;
                            if (this.f20236A != null) {
                                HeyMelodyApplication heyMelodyApplication8 = C0906l.f19501a;
                                if (heyMelodyApplication8 == null) {
                                    h.i("context");
                                    throw null;
                                }
                                SpyTapViewModel.d(heyMelodyApplication8, this.f20253S, u(3, false, false, z15), new i(1, this, z15));
                            }
                        }
                    }
                    break;
            }
        }
        return super.f(preference);
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        SpyTapFragment spyTapFragment;
        List<WhitelistConfigDTO.Control> control;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.f20253S = arguments.getString("device_mac_info");
        this.f20254T = arguments.getString("device_name");
        this.f20255U = arguments.getString("route_from");
        if (!BluetoothAdapter.checkBluetoothAddress(this.f20253S) || TextUtils.isEmpty(this.f20254T)) {
            A.h("SpyTapFragment", "address is not match or productName is null, finish activity!");
            return;
        }
        A.b("SpyTapFragment", "onCreate start");
        setHasOptionsMenu(true);
        this.f20237B = (COUIPreferenceCategory) a("key_sp_category");
        this.f20238C = (MelodyCOUIButtonPreference) a("key_sp_button");
        this.f20239D = (COUIPreference) a("key_sp_title");
        this.f20240E = (COUISwitchPreference) a("key_sp_single_click_switch");
        this.f20241F = (COUICheckBoxPreference) a("key_sp_single_click_left_check");
        this.f20242G = (COUICheckBoxPreference) a("key_sp_single_click_right_check");
        this.H = (COUISwitchPreference) a("key_sp_double_click_switch");
        this.f20243I = (COUICheckBoxPreference) a("key_sp_double_click_left_check");
        this.f20244J = (COUICheckBoxPreference) a("key_sp_double_click_right_check");
        this.f20245K = (COUISwitchPreference) a("key_sp_triple_click_switch");
        this.f20246L = (COUICheckBoxPreference) a("key_sp_triple_click_left_check");
        this.f20247M = (COUICheckBoxPreference) a("key_sp_triple_click_right_check");
        this.f20248N = (COUISwitchPreference) a("key_sp_long_click_switch");
        this.f20249O = (COUICheckBoxPreference) a("key_sp_long_click_left_check");
        this.f20250P = (COUICheckBoxPreference) a("key_sp_long_click_right_check");
        A.b("SpyTapFragment", "initData start");
        O store = getViewModelStore();
        N.b factory = getDefaultViewModelProviderFactory();
        W.a defaultViewModelCreationExtras = getDefaultViewModelCreationExtras();
        h.e(store, "store");
        h.e(factory, "factory");
        X.d dVarB = A6.g.b(defaultViewModelCreationExtras, "defaultCreationExtras", store, factory, defaultViewModelCreationExtras);
        kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(SpyTapViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20236A = (SpyTapViewModel) dVarB.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        String str = this.f20253S;
        if (str != null) {
            EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(str);
            if (earphoneDTOW != null) {
                WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(earphoneDTOW.getProductId(), earphoneDTOW.getName());
                WhitelistConfigDTO.Function function = whitelistConfigDTOC != null ? whitelistConfigDTOC.getFunction() : null;
                this.f20252R = function;
                if (function != null && (control = function.getControl()) != null) {
                    for (WhitelistConfigDTO.Control control2 : control) {
                        if (control2.getAction() == 16 || control2.getAction() == 17 || control2.getAction() == 18) {
                            this.f20259Y = true;
                        }
                    }
                }
                A.c("SpyTapFragment", new m4.e(this, 9));
            }
            if (this.f20236A != null) {
                spyTapFragment = this;
                C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new C1065d(26))).e(this, new a(new SpyTapFragment$initData$1$2(1, spyTapFragment, SpyTapFragment.class, "onKeyFunctionInfoChanged", "onKeyFunctionInfoChanged(Ljava/util/List;)V", 0)));
            } else {
                spyTapFragment = this;
            }
            if (spyTapFragment.f20236A != null) {
                C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new C1064c(28))).e(this, new a(new C1479c(this, 4)));
            }
        } else {
            spyTapFragment = this;
        }
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        String strO = S.o(heyMelodyApplication, "com.spotify.music");
        int i10 = TextUtils.isEmpty(strO) ? 2 : S.c("9.1.14.864", strO) < 0 ? 1 : 0;
        A.f("SpyTopHelper", "pkgInstallState, result=" + i10 + ", SUPPORT_VER=9.1.14.864, versionName=" + strO);
        spyTapFragment.f20256V = i10;
        B(i10);
        A.c("SpyTapFragment", new C1294g(this, 22));
        if ("spy_tap".equals(spyTapFragment.f20255U)) {
            MelodyCompatButton melodyCompatButton = spyTapFragment.f20260z;
            if (melodyCompatButton != null) {
                melodyCompatButton.setVisibility(0);
                melodyCompatButton.setOnClickListener(new F(this, 16));
            }
            spyTapFragment.f20257W = q.c("melody-model-settings").getBoolean("is_already_set", false);
            A.c("SpyTapFragment", new m(this, 0));
            if (spyTapFragment.f20257W) {
                return;
            }
            if (t(1)) {
                y(true);
            } else if (t(2)) {
                w(true);
            } else if (t(3)) {
                z(true);
            } else if (t(4)) {
                x(true);
            }
            A.b("SpyTopHelper", "setAlreadySet");
            SharedPreferences sharedPreferencesC = q.c("melody-model-settings");
            h.d(sharedPreferencesC, "getSettings(...)");
            SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
            editorEdit.putBoolean("is_already_set", true);
            editorEdit.apply();
        }
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
    public final void onResume() {
        super.onResume();
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        List<KeyFunctionInfoDTO> keyFunctionInfoList = null;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        String strO = S.o(heyMelodyApplication, "com.spotify.music");
        int i10 = TextUtils.isEmpty(strO) ? 2 : S.c("9.1.14.864", strO) < 0 ? 1 : 0;
        A.f("SpyTopHelper", "pkgInstallState, result=" + i10 + ", SUPPORT_VER=9.1.14.864, versionName=" + strO);
        A.c("SpyTapFragment", new f0(this, i10, 14));
        if (this.f20256V != i10) {
            this.f20256V = i10;
            B(i10);
        }
        if (this.f20236A != null) {
            HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
            if (heyMelodyApplication2 == null) {
                h.i("context");
                throw null;
            }
            AbstractC0939b.E().F(heyMelodyApplication2, this.f20253S);
        }
        if (this.f20236A != null) {
            EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(this.f20253S);
            if (earphoneDTOW != null) {
                keyFunctionInfoList = earphoneDTOW.getKeyFunctionInfoList();
            }
        }
        v(keyFunctionInfoList);
    }

    @Override // F8.b, com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        F8.a aVar = activity instanceof F8.a ? (F8.a) activity : null;
        if (aVar != null) {
            aVar.y((Toolbar) view.findViewById(R.id.tool_bar));
            androidx.appcompat.app.a aVarX = aVar.x();
            if (aVarX != null) {
                aVarX.o();
                aVarX.n(true);
                aVarX.t(R.string.melody_spy_tap_title);
            }
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        A.b("SpyTapFragment", "onCreatePreferences start");
        o(R.xml.melody_spy_tap_preference);
        Preference preferenceA = a("key_sp_guide");
        MelodyCOUIPreference melodyCOUIPreference = preferenceA instanceof MelodyCOUIPreference ? (MelodyCOUIPreference) preferenceA : null;
        if (melodyCOUIPreference != null) {
            melodyCOUIPreference.f21776a = new C0531H(this, 21);
        }
    }

    public final int s(int i10) {
        if (i10 == 1) {
            if (this.f20259Y) {
                return 16;
            }
            return i10;
        }
        if (i10 == 2) {
            if (this.f20259Y) {
                return 17;
            }
            return i10;
        }
        if (i10 == 3 && this.f20259Y) {
            return 18;
        }
        return i10;
    }

    public final boolean t(int i10) {
        List<WhitelistConfigDTO.Control> control;
        boolean z2;
        int iS = s(i10);
        boolean z4 = false;
        if (iS == 4 || iS == 19) {
            WhitelistConfigDTO.Function function = this.f20252R;
            z4 = ((function != null ? function.getLongPressType() : 0) & 8388608) != 0;
        } else {
            WhitelistConfigDTO.Function function2 = this.f20252R;
            if (function2 != null && (control = function2.getControl()) != null) {
                loop0: while (true) {
                    z2 = false;
                    for (WhitelistConfigDTO.Control control2 : control) {
                        if (control2.getAction() == iS) {
                            if ((control2.getSupport() & 8388608) != 0) {
                                z2 = true;
                            }
                        }
                    }
                }
                z4 = z2;
            }
        }
        if (z4) {
            A.c("SpyTapFragment", new w8.f(iS, this, 1));
            return z4;
        }
        WhitelistConfigDTO.Function function3 = this.f20252R;
        A.x("SpyTapFragment", "isControlSupportSpyTap, not support, realActionType: " + iS + ", " + (function3 != null ? function3.getControl() : null));
        return z4;
    }

    @SuppressLint({"SwitchIntDef"})
    public final void v(List<KeyFunctionInfoDTO> list) {
        int i10 = this.f20256V;
        if (i10 > 0) {
            B(i10);
            A.x("SpyTapFragment", "onKeyFunctionInfoChanged return, pkgInstallState: " + this.f20256V);
            return;
        }
        if (list == null) {
            return;
        }
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
        Ref$BooleanRef ref$BooleanRef3 = new Ref$BooleanRef();
        Ref$BooleanRef ref$BooleanRef4 = new Ref$BooleanRef();
        StringBuilder sb2 = new StringBuilder();
        for (KeyFunctionInfoDTO keyFunctionInfoDTO : list) {
            if (keyFunctionInfoDTO.getDeviceButton() == 1) {
                sb2.append("\n");
                sb2.append(keyFunctionInfoDTO.toString());
                int buttonAction = keyFunctionInfoDTO.getButtonAction();
                if (buttonAction != 1) {
                    if (buttonAction != 2) {
                        if (buttonAction != 3) {
                            if (buttonAction != 4) {
                                switch (buttonAction) {
                                }
                            } else {
                                int deviceType = keyFunctionInfoDTO.getDeviceType();
                                if (deviceType != 1) {
                                    if (deviceType == 2) {
                                        if (keyFunctionInfoDTO.getFunction() == 32) {
                                            COUICheckBoxPreference cOUICheckBoxPreference = this.f20250P;
                                            if (cOUICheckBoxPreference != null) {
                                                cOUICheckBoxPreference.setChecked(true);
                                            }
                                            ref$BooleanRef4.element = true;
                                        } else {
                                            COUICheckBoxPreference cOUICheckBoxPreference2 = this.f20250P;
                                            if (cOUICheckBoxPreference2 != null) {
                                                cOUICheckBoxPreference2.setChecked(false);
                                            }
                                        }
                                    }
                                } else if (keyFunctionInfoDTO.getFunction() == 32) {
                                    COUICheckBoxPreference cOUICheckBoxPreference3 = this.f20249O;
                                    if (cOUICheckBoxPreference3 != null) {
                                        cOUICheckBoxPreference3.setChecked(true);
                                    }
                                    ref$BooleanRef4.element = true;
                                } else {
                                    COUICheckBoxPreference cOUICheckBoxPreference4 = this.f20249O;
                                    if (cOUICheckBoxPreference4 != null) {
                                        cOUICheckBoxPreference4.setChecked(false);
                                    }
                                }
                            }
                        }
                        int deviceType2 = keyFunctionInfoDTO.getDeviceType();
                        if (deviceType2 != 1) {
                            if (deviceType2 == 2) {
                                if (keyFunctionInfoDTO.getFunction() == 32) {
                                    COUICheckBoxPreference cOUICheckBoxPreference5 = this.f20247M;
                                    if (cOUICheckBoxPreference5 != null) {
                                        cOUICheckBoxPreference5.setChecked(true);
                                    }
                                    ref$BooleanRef3.element = true;
                                } else {
                                    COUICheckBoxPreference cOUICheckBoxPreference6 = this.f20247M;
                                    if (cOUICheckBoxPreference6 != null) {
                                        cOUICheckBoxPreference6.setChecked(false);
                                    }
                                }
                            }
                        } else if (keyFunctionInfoDTO.getFunction() == 32) {
                            COUICheckBoxPreference cOUICheckBoxPreference7 = this.f20246L;
                            if (cOUICheckBoxPreference7 != null) {
                                cOUICheckBoxPreference7.setChecked(true);
                            }
                            ref$BooleanRef3.element = true;
                        } else {
                            COUICheckBoxPreference cOUICheckBoxPreference8 = this.f20246L;
                            if (cOUICheckBoxPreference8 != null) {
                                cOUICheckBoxPreference8.setChecked(false);
                            }
                        }
                    }
                    int deviceType3 = keyFunctionInfoDTO.getDeviceType();
                    if (deviceType3 != 1) {
                        if (deviceType3 == 2) {
                            if (keyFunctionInfoDTO.getFunction() == 32) {
                                COUICheckBoxPreference cOUICheckBoxPreference9 = this.f20244J;
                                if (cOUICheckBoxPreference9 != null) {
                                    cOUICheckBoxPreference9.setChecked(true);
                                }
                                ref$BooleanRef2.element = true;
                            } else {
                                COUICheckBoxPreference cOUICheckBoxPreference10 = this.f20244J;
                                if (cOUICheckBoxPreference10 != null) {
                                    cOUICheckBoxPreference10.setChecked(false);
                                }
                            }
                        }
                    } else if (keyFunctionInfoDTO.getFunction() == 32) {
                        COUICheckBoxPreference cOUICheckBoxPreference11 = this.f20243I;
                        if (cOUICheckBoxPreference11 != null) {
                            cOUICheckBoxPreference11.setChecked(true);
                        }
                        ref$BooleanRef2.element = true;
                    } else {
                        COUICheckBoxPreference cOUICheckBoxPreference12 = this.f20243I;
                        if (cOUICheckBoxPreference12 != null) {
                            cOUICheckBoxPreference12.setChecked(false);
                        }
                    }
                }
                int deviceType4 = keyFunctionInfoDTO.getDeviceType();
                if (deviceType4 != 1) {
                    if (deviceType4 == 2) {
                        if (keyFunctionInfoDTO.getFunction() == 32) {
                            COUICheckBoxPreference cOUICheckBoxPreference13 = this.f20242G;
                            if (cOUICheckBoxPreference13 != null) {
                                cOUICheckBoxPreference13.setChecked(true);
                            }
                            ref$BooleanRef.element = true;
                        } else {
                            COUICheckBoxPreference cOUICheckBoxPreference14 = this.f20242G;
                            if (cOUICheckBoxPreference14 != null) {
                                cOUICheckBoxPreference14.setChecked(false);
                            }
                        }
                    }
                } else if (keyFunctionInfoDTO.getFunction() == 32) {
                    COUICheckBoxPreference cOUICheckBoxPreference15 = this.f20241F;
                    if (cOUICheckBoxPreference15 != null) {
                        cOUICheckBoxPreference15.setChecked(true);
                    }
                    ref$BooleanRef.element = true;
                } else {
                    COUICheckBoxPreference cOUICheckBoxPreference16 = this.f20241F;
                    if (cOUICheckBoxPreference16 != null) {
                        cOUICheckBoxPreference16.setChecked(false);
                    }
                }
            }
        }
        A.c("SpyTapFragment", new x(sb2, 5));
        COUISwitchPreference cOUISwitchPreference = this.f20240E;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setChecked(ref$BooleanRef.element);
        }
        COUICheckBoxPreference cOUICheckBoxPreference17 = this.f20241F;
        if (cOUICheckBoxPreference17 != null) {
            cOUICheckBoxPreference17.setVisible(ref$BooleanRef.element);
        }
        COUICheckBoxPreference cOUICheckBoxPreference18 = this.f20242G;
        if (cOUICheckBoxPreference18 != null) {
            cOUICheckBoxPreference18.setVisible(ref$BooleanRef.element);
        }
        COUISwitchPreference cOUISwitchPreference2 = this.H;
        if (cOUISwitchPreference2 != null) {
            cOUISwitchPreference2.setChecked(ref$BooleanRef2.element);
        }
        COUICheckBoxPreference cOUICheckBoxPreference19 = this.f20243I;
        if (cOUICheckBoxPreference19 != null) {
            cOUICheckBoxPreference19.setVisible(ref$BooleanRef2.element);
        }
        COUICheckBoxPreference cOUICheckBoxPreference20 = this.f20244J;
        if (cOUICheckBoxPreference20 != null) {
            cOUICheckBoxPreference20.setVisible(ref$BooleanRef2.element);
        }
        COUISwitchPreference cOUISwitchPreference3 = this.f20245K;
        if (cOUISwitchPreference3 != null) {
            cOUISwitchPreference3.setChecked(ref$BooleanRef3.element);
        }
        COUICheckBoxPreference cOUICheckBoxPreference21 = this.f20246L;
        if (cOUICheckBoxPreference21 != null) {
            cOUICheckBoxPreference21.setVisible(ref$BooleanRef3.element);
        }
        COUICheckBoxPreference cOUICheckBoxPreference22 = this.f20247M;
        if (cOUICheckBoxPreference22 != null) {
            cOUICheckBoxPreference22.setVisible(ref$BooleanRef3.element);
        }
        COUISwitchPreference cOUISwitchPreference4 = this.f20248N;
        if (cOUISwitchPreference4 != null) {
            cOUISwitchPreference4.setChecked(ref$BooleanRef4.element);
        }
        COUICheckBoxPreference cOUICheckBoxPreference23 = this.f20249O;
        if (cOUICheckBoxPreference23 != null) {
            cOUICheckBoxPreference23.setVisible(ref$BooleanRef4.element);
        }
        COUICheckBoxPreference cOUICheckBoxPreference24 = this.f20250P;
        if (cOUICheckBoxPreference24 != null) {
            cOUICheckBoxPreference24.setVisible(ref$BooleanRef4.element);
        }
        A.c("SpyTapFragment", new L(ref$BooleanRef, ref$BooleanRef2, ref$BooleanRef3, ref$BooleanRef4, 1));
        if (ref$BooleanRef.element || ref$BooleanRef2.element || ref$BooleanRef3.element || ref$BooleanRef4.element) {
            A.b("SpyTopHelper", "setAlreadySet");
            SharedPreferences sharedPreferencesC = q.c("melody-model-settings");
            h.d(sharedPreferencesC, "getSettings(...)");
            SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
            editorEdit.putBoolean("is_already_set", true);
            editorEdit.apply();
        }
        this.f20258X = false;
    }

    public final void w(boolean z2) {
        A.c("SpyTapFragment", new C1604d(0, this, z2));
        if (!this.f20258X) {
            this.f20258X = true;
            COUICheckBoxPreference cOUICheckBoxPreference = this.f20243I;
            if (cOUICheckBoxPreference != null) {
                cOUICheckBoxPreference.setVisible(z2);
            }
            COUICheckBoxPreference cOUICheckBoxPreference2 = this.f20244J;
            if (cOUICheckBoxPreference2 != null) {
                cOUICheckBoxPreference2.setVisible(z2);
            }
            if (this.f20236A != null) {
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                if (heyMelodyApplication != null) {
                    SpyTapViewModel.d(heyMelodyApplication, this.f20253S, u(2, true, true, z2), new e(0, this, z2));
                    return;
                } else {
                    h.i("context");
                    throw null;
                }
            }
            return;
        }
        COUICheckBoxPreference cOUICheckBoxPreference3 = this.f20243I;
        if (cOUICheckBoxPreference3 != null) {
            cOUICheckBoxPreference3.setVisible(!z2);
        }
        COUICheckBoxPreference cOUICheckBoxPreference4 = this.f20244J;
        if (cOUICheckBoxPreference4 != null) {
            cOUICheckBoxPreference4.setVisible(!z2);
        }
        COUISwitchPreference cOUISwitchPreference = this.H;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setChecked(!z2);
        }
        COUICheckBoxPreference cOUICheckBoxPreference5 = this.f20243I;
        if (cOUICheckBoxPreference5 != null) {
            cOUICheckBoxPreference5.setChecked(!z2);
        }
        COUICheckBoxPreference cOUICheckBoxPreference6 = this.f20244J;
        if (cOUICheckBoxPreference6 != null) {
            cOUICheckBoxPreference6.setChecked(!z2);
        }
    }

    public final void x(boolean z2) {
        A.c("SpyTapFragment", new C1604d(1, this, z2));
        if (!this.f20258X) {
            this.f20258X = true;
            COUICheckBoxPreference cOUICheckBoxPreference = this.f20249O;
            if (cOUICheckBoxPreference != null) {
                cOUICheckBoxPreference.setVisible(z2);
            }
            COUICheckBoxPreference cOUICheckBoxPreference2 = this.f20250P;
            if (cOUICheckBoxPreference2 != null) {
                cOUICheckBoxPreference2.setVisible(z2);
            }
            if (this.f20236A != null) {
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                if (heyMelodyApplication != null) {
                    SpyTapViewModel.d(heyMelodyApplication, this.f20253S, u(4, true, true, z2), new e(1, this, z2));
                    return;
                } else {
                    h.i("context");
                    throw null;
                }
            }
            return;
        }
        COUICheckBoxPreference cOUICheckBoxPreference3 = this.f20249O;
        if (cOUICheckBoxPreference3 != null) {
            cOUICheckBoxPreference3.setVisible(!z2);
        }
        COUICheckBoxPreference cOUICheckBoxPreference4 = this.f20250P;
        if (cOUICheckBoxPreference4 != null) {
            cOUICheckBoxPreference4.setVisible(!z2);
        }
        COUISwitchPreference cOUISwitchPreference = this.f20248N;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setChecked(!z2);
        }
        COUICheckBoxPreference cOUICheckBoxPreference5 = this.f20249O;
        if (cOUICheckBoxPreference5 != null) {
            cOUICheckBoxPreference5.setChecked(!z2);
        }
        COUICheckBoxPreference cOUICheckBoxPreference6 = this.f20250P;
        if (cOUICheckBoxPreference6 != null) {
            cOUICheckBoxPreference6.setChecked(!z2);
        }
    }

    public final void y(boolean z2) {
        A.c("SpyTapFragment", new j(1, this, z2));
        if (!this.f20258X) {
            this.f20258X = true;
            COUICheckBoxPreference cOUICheckBoxPreference = this.f20241F;
            if (cOUICheckBoxPreference != null) {
                cOUICheckBoxPreference.setVisible(z2);
            }
            COUICheckBoxPreference cOUICheckBoxPreference2 = this.f20242G;
            if (cOUICheckBoxPreference2 != null) {
                cOUICheckBoxPreference2.setVisible(z2);
            }
            if (this.f20236A != null) {
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                if (heyMelodyApplication != null) {
                    SpyTapViewModel.d(heyMelodyApplication, this.f20253S, u(1, true, true, z2), new g(2, this, z2));
                    return;
                } else {
                    h.i("context");
                    throw null;
                }
            }
            return;
        }
        COUICheckBoxPreference cOUICheckBoxPreference3 = this.f20241F;
        if (cOUICheckBoxPreference3 != null) {
            cOUICheckBoxPreference3.setVisible(!z2);
        }
        COUICheckBoxPreference cOUICheckBoxPreference4 = this.f20242G;
        if (cOUICheckBoxPreference4 != null) {
            cOUICheckBoxPreference4.setVisible(!z2);
        }
        COUISwitchPreference cOUISwitchPreference = this.f20240E;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setChecked(!z2);
        }
        COUICheckBoxPreference cOUICheckBoxPreference5 = this.f20241F;
        if (cOUICheckBoxPreference5 != null) {
            cOUICheckBoxPreference5.setChecked(!z2);
        }
        COUICheckBoxPreference cOUICheckBoxPreference6 = this.f20242G;
        if (cOUICheckBoxPreference6 != null) {
            cOUICheckBoxPreference6.setChecked(!z2);
        }
    }

    public final void z(boolean z2) {
        A.c("SpyTapFragment", new w8.h(0, this, z2));
        if (!this.f20258X) {
            this.f20258X = true;
            COUICheckBoxPreference cOUICheckBoxPreference = this.f20246L;
            if (cOUICheckBoxPreference != null) {
                cOUICheckBoxPreference.setVisible(z2);
            }
            COUICheckBoxPreference cOUICheckBoxPreference2 = this.f20247M;
            if (cOUICheckBoxPreference2 != null) {
                cOUICheckBoxPreference2.setVisible(z2);
            }
            if (this.f20236A != null) {
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                if (heyMelodyApplication != null) {
                    SpyTapViewModel.d(heyMelodyApplication, this.f20253S, u(3, true, true, z2), new i(0, this, z2));
                    return;
                } else {
                    h.i("context");
                    throw null;
                }
            }
            return;
        }
        COUICheckBoxPreference cOUICheckBoxPreference3 = this.f20246L;
        if (cOUICheckBoxPreference3 != null) {
            cOUICheckBoxPreference3.setVisible(!z2);
        }
        COUICheckBoxPreference cOUICheckBoxPreference4 = this.f20247M;
        if (cOUICheckBoxPreference4 != null) {
            cOUICheckBoxPreference4.setVisible(!z2);
        }
        COUISwitchPreference cOUISwitchPreference = this.f20245K;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setChecked(!z2);
        }
        COUICheckBoxPreference cOUICheckBoxPreference5 = this.f20246L;
        if (cOUICheckBoxPreference5 != null) {
            cOUICheckBoxPreference5.setChecked(!z2);
        }
        COUICheckBoxPreference cOUICheckBoxPreference6 = this.f20247M;
        if (cOUICheckBoxPreference6 != null) {
            cOUICheckBoxPreference6.setChecked(!z2);
        }
    }
}
