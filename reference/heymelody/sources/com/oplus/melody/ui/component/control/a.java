package com.oplus.melody.ui.component.control;

import C6.e;
import Ca.r;
import D7.C0370d;
import D7.C0379m;
import D7.C0384s;
import D7.o0;
import E9.u;
import Ea.C0404m;
import Ea.C0414x;
import F9.s;
import G8.h;
import G8.l;
import G8.n;
import Ha.c;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.f;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0586b;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.t;
import androidx.preference.DialogPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUIActivityDialogPreference;
import com.coui.appcompat.preference.COUIEditTextPreference;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIMultiSelectListPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.d;
import com.coui.appcompat.preference.g;
import com.heytap.headset.R;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.K;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.component.control.b;
import com.oplus.melody.ui.component.control.dialog.MultiSelectVO;
import com.oplus.melody.ui.component.control.preference.ColorSingleSelectPreference;
import com.oplus.melody.ui.component.control.preference.CustomMultiSelectPreference;
import com.oplus.melody.ui.component.control.preference.MelodyTipsPreference;
import com.oplus.melody.ui.widget.MelodyRecommendedPreference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import kotlin.jvm.internal.j;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: BaseEarControlFragment.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends g implements Preference.c, Preference.d {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public ColorSingleSelectPreference f20419A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public ColorSingleSelectPreference f20420B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public ColorSingleSelectPreference f20421C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public ColorSingleSelectPreference f20422D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public ColorSingleSelectPreference f20423E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public ColorSingleSelectPreference f20424F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public ColorSingleSelectPreference f20425G;
    public ColorSingleSelectPreference H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public ColorSingleSelectPreference f20426I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ColorSingleSelectPreference f20427J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public ColorSingleSelectPreference f20428K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public CustomMultiSelectPreference f20429L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public ColorSingleSelectPreference f20430M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public ColorSingleSelectPreference f20431N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public ColorSingleSelectPreference f20432O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public COUIPreferenceCategory f20433P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public COUIPreferenceCategory f20434Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public MelodyTipsPreference f20435R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public COUIJumpPreference f20436S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public COUIPreferenceCategory f20437T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public COUIPreferenceCategory f20438U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public COUIPreferenceCategory f20439V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public COUIJumpPreference f20440W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public COUIJumpPreference f20441X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public COUIJumpPreference f20442Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public COUIJumpPreference f20443Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public String f20444a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public String f20445b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public String f20446c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public String f20447d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public List<WhitelistConfigDTO.NoiseReductionMode> f20448e0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public Handler f20450g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public t f20451h0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public String[] f20453j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f20454k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public Drawable f20455l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public WhitelistConfigDTO.Function f20456m0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public EarControlViewModel f20458w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ColorSingleSelectPreference f20459x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ColorSingleSelectPreference f20460y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ColorSingleSelectPreference f20461z;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public f f20449f0 = null;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f20452i0 = false;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final h f20457n0 = new h(this, 0);

    public static void v(ColorSingleSelectPreference colorSingleSelectPreference, String str) {
        colorSingleSelectPreference.h(str);
        A.c("BaseEarControlFragment", new C0384s(5, str, colorSingleSelectPreference));
        colorSingleSelectPreference.setAssignment(colorSingleSelectPreference.f());
    }

    @Override // androidx.preference.Preference.c
    public final boolean e(Preference preference, Object obj) {
        A.c("BaseEarControlFragment", new A9.g(obj, preference, 2));
        if (!(preference instanceof ColorSingleSelectPreference)) {
            return false;
        }
        final ColorSingleSelectPreference colorSingleSelectPreference = (ColorSingleSelectPreference) preference;
        final String str = (String) obj;
        final String str2 = colorSingleSelectPreference.f11651u;
        if (TextUtils.equals(str2, str)) {
            return false;
        }
        preference.setSummary((CharSequence) null);
        if (TextUtils.equals(str, getString(R.string.melody_ui_ai_summary_title))) {
            CompletableFuture.supplyAsync(new r(this, 10)).whenCompleteAsync(new BiConsumer() { // from class: G8.e
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj2, Object obj3) {
                    Boolean bool = (Boolean) obj2;
                    Throwable th = (Throwable) obj3;
                    com.oplus.melody.ui.component.control.a aVar = this.f1920a;
                    aVar.getClass();
                    if (th != null) {
                        com.oplus.melody.common.util.A.i("BaseEarControlFragment", "needSwitchAISummaryStatus isPhoneAISummaryOpened error", th);
                        return;
                    }
                    boolean zBooleanValue = bool.booleanValue();
                    ColorSingleSelectPreference colorSingleSelectPreference2 = colorSingleSelectPreference;
                    if (zBooleanValue) {
                        String str3 = str;
                        com.oplus.melody.ui.component.control.a.v(colorSingleSelectPreference2, str3);
                        aVar.u(colorSingleSelectPreference2, str3);
                        return;
                    }
                    com.oplus.melody.ui.component.control.a.v(colorSingleSelectPreference2, str2);
                    G7.b bVar = new G7.b(aVar.requireActivity());
                    bVar.n(R.string.melody_ui_open_ai_summary_confirm);
                    bVar.f(R.string.melody_ui_open_ai_summary_content);
                    bVar.l(R.string.melody_ui_open_ai_summary_dialog_open, new j(aVar, 0));
                    bVar.h(R.string.melody_ui_common_cancel, new k(0));
                    bVar.setCancelable(false).create().show();
                }
            }, (Executor) o0.c.f1144b);
        } else {
            v(colorSingleSelectPreference, str);
            u(colorSingleSelectPreference, str);
        }
        if (!TextUtils.equals(str, getString(R.string.melody_common_earphone_function_control_collect_music))) {
            return true;
        }
        if (this.f20450g0 == null) {
            this.f20450g0 = new Handler(Looper.getMainLooper());
        }
        this.f20450g0.postDelayed(new E9.t(this, 4), 100L);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.preference.Preference.d
    public final boolean i(Preference preference) {
        A.c("BaseEarControlFragment", new l(0, preference));
        if (preference instanceof K8.b) {
            b.a aVar = (b.a) ((K8.b) preference).getTag();
            int button = aVar != null ? aVar.getButton() : 0;
            int action = aVar != null ? aVar.getAction() : 0;
            C0379m.k(this.f20458w.f20414c, new n(button, action));
        }
        return false;
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g, androidx.preference.k.a
    public final void l(DialogPreference dialogPreference) {
        DialogInterfaceOnCancelListenerC0586b c0414x;
        if (getFragmentManager().D("androidx.preference.PreferenceFragment.DIALOG") == null) {
            if (dialogPreference instanceof COUIActivityDialogPreference) {
                String key = dialogPreference.getKey();
                c0414x = new com.coui.appcompat.preference.a();
                Bundle bundle = new Bundle(1);
                bundle.putString("key", key);
                c0414x.setArguments(bundle);
            } else if (dialogPreference instanceof COUIEditTextPreference) {
                String key2 = dialogPreference.getKey();
                c0414x = new d();
                Bundle bundle2 = new Bundle(1);
                bundle2.putString("key", key2);
                c0414x.setArguments(bundle2);
            } else if (dialogPreference instanceof COUIMultiSelectListPreference) {
                String key3 = dialogPreference.getKey();
                c0414x = new com.coui.appcompat.preference.f();
                Bundle bundle3 = new Bundle(1);
                bundle3.putString("key", key3);
                c0414x.setArguments(bundle3);
            } else {
                if (!(dialogPreference instanceof ListPreference)) {
                    super.l(dialogPreference);
                    return;
                }
                String key4 = dialogPreference.getKey();
                c0414x = new C0414x();
                Bundle bundle4 = new Bundle(1);
                bundle4.putString("key", key4);
                c0414x.setArguments(bundle4);
            }
            c0414x.setTargetFragment(this, 0);
            c0414x.show(getFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        Bundle arguments;
        WhitelistConfigDTO.Function function;
        super.onActivityCreated(bundle);
        if (getActivity() == null || (arguments = getArguments()) == null) {
            return;
        }
        this.f20444a0 = arguments.getString("product_id");
        this.f20446c0 = arguments.getString("device_name");
        this.f20445b0 = arguments.getString("device_mac_info");
        this.f20447d0 = arguments.getString("product_color");
        this.f20453j0 = arguments.getString("control_high_light", VersionInfo.VENDOR_CODE_DEFAULT_VERSION).split(",");
        this.f20454k0 = arguments.getString("control_auto_show", VersionInfo.VENDOR_CODE_DEFAULT_VERSION);
        androidx.fragment.app.f owner = getActivity();
        kotlin.jvm.internal.h.e(owner, "owner");
        O viewModelStore = owner.getViewModelStore();
        N.b defaultViewModelProviderFactory = owner.getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, owner.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(EarControlViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20458w = (EarControlViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(this.f20444a0, this.f20446c0);
        if (whitelistConfigDTOC != null) {
            this.f20456m0 = whitelistConfigDTOC.getFunction();
        }
        this.f20429L.f20571c = getChildFragmentManager();
        EarControlViewModel earControlViewModel = this.f20458w;
        String str = this.f20444a0;
        String str2 = this.f20445b0;
        String str3 = this.f20446c0;
        earControlViewModel.getClass();
        t tVarG = null;
        if (!TextUtils.isEmpty(str2)) {
            t tVar = new t();
            t tVarG2 = C0379m.g(C0379m.g(AbstractC1508a.f().i(), new u(19, str, str3)), new G8.u(earControlViewModel, tVar, str2, 0));
            t tVarV = TextUtils.isEmpty(str2) ? null : AbstractC0939b.E().v(str2);
            A.c("EarControlViewModel", new B6.a(tVarV, 11));
            if (tVarV != null) {
                A.c("EarControlViewModel", new C0404m(tVarV, 7));
                tVarG = C0379m.g(tVarV, new s(tVar, 4));
            }
            tVar.m(tVarG2, new e(tVar, 5));
            if (tVarG != null) {
                tVar.m(tVarG, new E9.a(tVar, 2));
            }
            tVarG = tVar;
        }
        this.f20451h0 = tVarG;
        if (tVarG != null) {
            tVarG.e(getViewLifecycleOwner(), new e(this, 3));
        }
        MelodyTipsPreference melodyTipsPreference = this.f20435R;
        String str4 = this.f20445b0;
        String str5 = this.f20446c0;
        String str6 = this.f20444a0;
        String str7 = this.f20447d0;
        melodyTipsPreference.getClass();
        if (str4 == null) {
            str4 = "";
        }
        melodyTipsPreference.f20581r = str4;
        if (str5 == null) {
            str5 = "";
        }
        melodyTipsPreference.f20582s = str5;
        if (str6 == null) {
            str6 = "";
        }
        melodyTipsPreference.f20583t = str6;
        if (str7 == null) {
            str7 = "";
        }
        melodyTipsPreference.f20584u = str7;
        Context context = melodyTipsPreference.f20580q;
        String string = context.getString(R.string.melody_common_control_guide_category_title);
        melodyTipsPreference.setVisible(true);
        if (!TextUtils.equals(melodyTipsPreference.f21901p, string)) {
            melodyTipsPreference.f21901p = string;
            melodyTipsPreference.notifyChanged();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MelodyRecommendedPreference.a(context.getString(R.string.melody_common_control_guide_title), new A9.f(2, melodyTipsPreference, context)));
        WhitelistConfigDTO whitelistConfigDTOC2 = AbstractC1508a.f().c(melodyTipsPreference.f20583t, melodyTipsPreference.f20582s);
        if (Y.e((whitelistConfigDTOC2 == null || (function = whitelistConfigDTOC2.getFunction()) == null) ? 0 : function.getWearingVideoTutorial(), false)) {
            arrayList.add(new MelodyRecommendedPreference.a(context.getString(R.string.melody_ui_view_video_tutorial), new c(1, melodyTipsPreference, context)));
        }
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((MelodyRecommendedPreference.a) obj).f21904c = melodyTipsPreference.isEnabled();
        }
        melodyTipsPreference.f20585v = arrayList;
        if (arrayList.isEmpty()) {
            melodyTipsPreference.setVisible(false);
        } else {
            melodyTipsPreference.setVisible(true);
            melodyTipsPreference.f21898a = arrayList;
            melodyTipsPreference.notifyChanged();
        }
        HashMap<Integer, HashMap<String, Boolean>> map = this.f20458w.f20418g;
        map.put(0, new HashMap<>());
        map.put(1, new HashMap<>());
        map.put(2, new HashMap<>());
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(null);
        C0370d.c(H8.d.class, this.f20457n0);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        C0370d.d(this.f20457n0);
        Handler handler = this.f20450g0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f20429L.f20571c = null;
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        View viewFindViewById;
        super.onViewCreated(view, bundle);
        if ((view instanceof ViewGroup) && (viewFindViewById = view.findViewById(R.id.appbar_layout)) != null) {
            ((ViewGroup) view).removeView(viewFindViewById);
        }
        this.f11714c.setVerticalScrollBarEnabled(false);
        this.f11714c.setNestedScrollingEnabled(false);
        this.f11714c.setItemAnimator(null);
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        o(R.xml.melody_ui_setting_earphone_control);
        this.f20459x = (ColorSingleSelectPreference) a("key_single_click");
        this.f20460y = (ColorSingleSelectPreference) a("key_double_click");
        this.f20461z = (ColorSingleSelectPreference) a("key_triple_click");
        this.f20419A = (ColorSingleSelectPreference) a("key_single_click_for_call");
        this.f20420B = (ColorSingleSelectPreference) a("key_double_click_for_call");
        this.f20421C = (ColorSingleSelectPreference) a("key_triple_click_for_call");
        this.f20422D = (ColorSingleSelectPreference) a("key_single_click_for_call_or_music_p1");
        this.f20423E = (ColorSingleSelectPreference) a("key_single_click_for_call_or_music_p2");
        this.f20424F = (ColorSingleSelectPreference) a("key_long_press_for_call_or_music_p1");
        this.f20425G = (ColorSingleSelectPreference) a("key_long_press_for_call_or_music_p2");
        this.H = (ColorSingleSelectPreference) a("key_click_function_for_call");
        this.f20426I = (ColorSingleSelectPreference) a("key_long_click_middle_for_call");
        this.f20427J = (ColorSingleSelectPreference) a("key_scroll");
        this.f20428K = (ColorSingleSelectPreference) a("key_long_click");
        this.f20429L = (CustomMultiSelectPreference) a("key_long_click_noise");
        this.f20430M = (ColorSingleSelectPreference) a("key_long_click_volume");
        this.f20431N = (ColorSingleSelectPreference) a("key_super_long_click");
        this.f20432O = (ColorSingleSelectPreference) a("key_super_long_click_for_call");
        this.f20433P = (COUIPreferenceCategory) a("key_category_remind");
        this.f20434Q = (COUIPreferenceCategory) a("key_control_guide_category");
        this.f20435R = (MelodyTipsPreference) a("key_pref_control_guide");
        this.f20436S = (COUIJumpPreference) a("key_enter_pair");
        this.f20437T = (COUIPreferenceCategory) a("key_category_no_call");
        this.f20438U = (COUIPreferenceCategory) a("key_category_merge_for_call");
        this.f20439V = (COUIPreferenceCategory) a("key_category_for_call_or_music");
        this.f20440W = (COUIJumpPreference) a("key_touch_up");
        this.f20441X = (COUIJumpPreference) a("key_touch_down");
        this.f20442Y = (COUIJumpPreference) a("key_single_click_custom");
        this.f20443Z = (COUIJumpPreference) a("key_double_click_custom");
        this.f20459x.setOnPreferenceChangeListener(this);
        this.f20459x.setOnPreferenceClickListener(this);
        this.f20460y.setOnPreferenceChangeListener(this);
        this.f20460y.setOnPreferenceClickListener(this);
        this.f20461z.setOnPreferenceChangeListener(this);
        this.f20461z.setOnPreferenceClickListener(this);
        this.f20419A.setOnPreferenceChangeListener(this);
        this.f20419A.setOnPreferenceClickListener(this);
        this.f20420B.setOnPreferenceChangeListener(this);
        this.f20420B.setOnPreferenceClickListener(this);
        this.f20421C.setOnPreferenceChangeListener(this);
        this.f20421C.setOnPreferenceClickListener(this);
        this.H.setOnPreferenceChangeListener(this);
        this.H.setOnPreferenceClickListener(this);
        this.f20426I.setOnPreferenceChangeListener(this);
        this.f20426I.setOnPreferenceClickListener(this);
        this.f20422D.setOnPreferenceChangeListener(this);
        this.f20422D.setOnPreferenceClickListener(this);
        this.f20423E.setOnPreferenceChangeListener(this);
        this.f20423E.setOnPreferenceClickListener(this);
        this.f20424F.setOnPreferenceChangeListener(this);
        this.f20424F.setOnPreferenceClickListener(this);
        this.f20425G.setOnPreferenceChangeListener(this);
        this.f20425G.setOnPreferenceClickListener(this);
        this.f20427J.setOnPreferenceChangeListener(this);
        this.f20427J.setOnPreferenceClickListener(this);
        this.f20428K.setOnPreferenceChangeListener(this);
        this.f20428K.setOnPreferenceClickListener(this);
        CustomMultiSelectPreference customMultiSelectPreference = this.f20429L;
        getContext();
        customMultiSelectPreference.setLayoutResource(R.layout.coui_preference);
        customMultiSelectPreference.setIconSpaceReserved(false);
        customMultiSelectPreference.f20570b = new MultiSelectVO();
        this.f20431N.setOnPreferenceChangeListener(this);
        this.f20431N.setOnPreferenceClickListener(this);
        this.f20430M.setOnPreferenceChangeListener(this);
        this.f20430M.setOnPreferenceClickListener(this);
        this.f20432O.setOnPreferenceChangeListener(this);
        this.f20432O.setOnPreferenceClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s(androidx.preference.Preference r19, java.util.List<java.lang.String> r20) {
        /*
            Method dump skipped, instruction units count: 807
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.control.a.s(androidx.preference.Preference, java.util.List):void");
    }

    public abstract int t();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u(androidx.preference.Preference r21, java.lang.String r22) {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.control.a.u(androidx.preference.Preference, java.lang.String):void");
    }

    public final void w() {
        WhitelistConfigDTO.Function function = this.f20456m0;
        if (function == null || !Y.e(function.getControlGuideSupport(), false)) {
            this.f20434Q.setVisible(false);
            return;
        }
        int iB = K.b(-1, this.f20447d0);
        CompletableFuture.allOf(Z7.a.g().e(iB, this.f20444a0), Z7.a.g().d(iB, 4, this.f20444a0)).whenCompleteAsync((BiConsumer<? super Void, ? super Throwable>) new A9.s(new WeakReference(this), 8), (Executor) o0.c.f1144b);
    }
}
