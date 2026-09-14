package com.oplus.melody.ui.component.detail.aitranslation;

import A6.g;
import D7.C0379m;
import D7.Y;
import F8.b;
import F8.i;
import Wb.l;
import X.d;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.grid.COUIPercentWidthRecyclerView;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.heytap.headset.R;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0897c;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.widget.MelodyViewPagerGuidePreference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import s8.AbstractC1508a;
import t8.C1535c;

/* JADX INFO: compiled from: AITranslationFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u001a\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020+H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/oplus/melody/ui/component/detail/aitranslation/AITranslationFragment;", "Lcom/oplus/melody/ui/base/BaseCOUIPreferenceFragment;", "<init>", "()V", "mAddress", "", "mProductId", "mProductName", "mProductColorId", "mActionFrom", "mAITranslationVM", "Lcom/oplus/melody/ui/component/detail/aitranslation/AITranslationViewModel;", "mAITranslationGuidePreference", "Lcom/oplus/melody/ui/widget/MelodyViewPagerGuidePreference;", "mAITranslationGuideSettingPreference", "Lcom/coui/appcompat/preference/COUIJumpPreference;", "mAITranslationGuideSettingCategory", "Lcom/coui/appcompat/preference/COUIPreferenceCategory;", "mAITranslationGuideFunctionCategory", "mAITranslationGuideEarPhoneSettingCategory", "mIsInTutorialGuide", "", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onCreate", "initViewPagerData", "", "Lcom/oplus/melody/ui/component/detail/aitranslation/GuideViewPagerDataVO;", "isPinchAction", "onViewCreated", "view", "Landroid/view/View;", "onPreferenceTreeClick", "preference", "Landroidx/preference/Preference;", "trackAITranslation", SpeechFindManager.TYPE, "", "onConnectionStateChanged", "state", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AITranslationFragment extends b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public String f20625A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public String f20626B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public String f20627C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public String f20628D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public AITranslationViewModel f20629E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public MelodyViewPagerGuidePreference f20630F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public COUIJumpPreference f20631G;
    public COUIPreferenceCategory H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public COUIPreferenceCategory f20632I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public COUIPreferenceCategory f20633J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public boolean f20634K;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f20635z;

    /* JADX INFO: compiled from: AITranslationFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20636a;

        public a(l lVar) {
            this.f20636a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20636a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20636a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.aitranslation.AITranslationFragment$onViewCreated$3, reason: invalid class name */
    /* JADX INFO: compiled from: AITranslationFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            androidx.fragment.app.f activity;
            int iIntValue = num.intValue();
            AITranslationFragment aITranslationFragment = (AITranslationFragment) this.receiver;
            aITranslationFragment.getClass();
            A.c("AISummaryFragment", new Y(iIntValue, 13));
            COUIJumpPreference cOUIJumpPreference = aITranslationFragment.f20631G;
            if (cOUIJumpPreference != null) {
                cOUIJumpPreference.setEnabled(iIntValue == 2);
            }
            if (iIntValue != 2) {
                A.x("AISummaryFragment", "onConnectionStateChanged not connected finish");
                String str = aITranslationFragment.f20628D;
                if (str == null) {
                    h.i("mActionFrom");
                    throw null;
                }
                if (str.equals("DetailMainFragment") && (activity = aITranslationFragment.getActivity()) != null) {
                    activity.finish();
                }
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.preference.g, androidx.preference.k.b
    public final boolean f(Preference preference) {
        String key = preference.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1455761975:
                    if (key.equals("key_ai_translation_real_time")) {
                        Context context = getContext();
                        if (context != null) {
                            C1535c.c(context, 27, null);
                        }
                        s(AppConstant$FunctionType.AI_REAL_TIME_TRANSLATION.getFunType());
                        A.b("AITranslationFragment", "start activity to translation app of real time");
                    }
                    break;
                case -1443139868:
                    if (key.equals("key_ai_translation_face_to_face")) {
                        Context context2 = getContext();
                        if (context2 != null) {
                            C1535c.c(context2, 26, null);
                        }
                        s(AppConstant$FunctionType.AI_FACE_TO_FACE_TRANSLATION.getFunType());
                        A.b("AITranslationFragment", "start activity to translation app of face to face");
                    }
                    break;
                case 452387339:
                    if (key.equals("key_ai_translation_setting")) {
                        E8.a.w().getClass();
                        Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
                        i iVarA = i.a.a("/ui/ear_control");
                        String str = this.f20635z;
                        if (str == null) {
                            h.i("mAddress");
                            throw null;
                        }
                        iVarA.f("device_mac_info", str);
                        String str2 = this.f20626B;
                        if (str2 == null) {
                            h.i("mProductName");
                            throw null;
                        }
                        iVarA.f("device_name", str2);
                        String str3 = this.f20625A;
                        if (str3 == null) {
                            h.i("mProductId");
                            throw null;
                        }
                        iVarA.f("product_id", str3);
                        String str4 = this.f20627C;
                        if (str4 == null) {
                            h.i("mProductColorId");
                            throw null;
                        }
                        iVarA.f("product_color", str4);
                        iVarA.f("control_auto_show", "18");
                        iVarA.e(this);
                    }
                    break;
                case 1967683407:
                    if (key.equals("key_guide_ai_translation_earphone_setting_preference")) {
                        E8.a.w().getClass();
                        Jb.b<List<l<String, Class<?>>>> bVar2 = i.f1668g;
                        i iVarA2 = i.a.a("/ui/ear_control");
                        String str5 = this.f20635z;
                        if (str5 == null) {
                            h.i("mAddress");
                            throw null;
                        }
                        iVarA2.f("device_mac_info", str5);
                        String str6 = this.f20626B;
                        if (str6 == null) {
                            h.i("mProductName");
                            throw null;
                        }
                        iVarA2.f("device_name", str6);
                        String str7 = this.f20625A;
                        if (str7 == null) {
                            h.i("mProductId");
                            throw null;
                        }
                        iVarA2.f("product_id", str7);
                        String str8 = this.f20627C;
                        if (str8 == null) {
                            h.i("mProductColorId");
                            throw null;
                        }
                        iVarA2.f("product_color", str8);
                        iVarA2.f("control_high_light", "18");
                        iVarA2.e(this);
                    }
                    break;
            }
        }
        return super.f(preference);
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        WhitelistConfigDTO.Function function;
        List<WhitelistConfigDTO.Control> control;
        super.onCreate(savedInstanceState);
        this.f20630F = (MelodyViewPagerGuidePreference) a("key_ai_translation_guide_preference");
        this.f20631G = (COUIJumpPreference) a("key_guide_ai_translation_earphone_setting_preference");
        this.f20633J = (COUIPreferenceCategory) a("key_guide_ai_translation_earphone_setting_category");
        this.H = (COUIPreferenceCategory) a("key_ai_translation_setting_category");
        this.f20632I = (COUIPreferenceCategory) a("key_ai_translation_function_category");
        androidx.fragment.app.f activity = getActivity();
        String strH = C0914u.h(activity != null ? activity.getIntent() : null, "device_mac_info");
        if (strH == null) {
            strH = "";
        }
        this.f20635z = strH;
        androidx.fragment.app.f activity2 = getActivity();
        String strH2 = C0914u.h(activity2 != null ? activity2.getIntent() : null, "product_id");
        if (strH2 == null) {
            strH2 = "";
        }
        this.f20625A = strH2;
        androidx.fragment.app.f activity3 = getActivity();
        String strH3 = C0914u.h(activity3 != null ? activity3.getIntent() : null, "device_name");
        if (strH3 == null) {
            strH3 = "";
        }
        this.f20626B = strH3;
        androidx.fragment.app.f activity4 = getActivity();
        String strH4 = C0914u.h(activity4 != null ? activity4.getIntent() : null, "product_color");
        if (strH4 == null) {
            strH4 = "";
        }
        this.f20627C = strH4;
        androidx.fragment.app.f activity5 = getActivity();
        String strH5 = C0914u.h(activity5 != null ? activity5.getIntent() : null, "route_from");
        this.f20628D = strH5 != null ? strH5 : "";
        androidx.fragment.app.f activity6 = getActivity();
        boolean z2 = false;
        boolean zB = C0914u.b(activity6 != null ? activity6.getIntent() : null, "route_value", false);
        this.f20634K = zB;
        setHasOptionsMenu(!zB);
        if (this.f20634K) {
            Preference preferenceA = a("header_preference");
            if (preferenceA == null) {
                preferenceA = null;
            }
            if (preferenceA != null) {
                preferenceA.setVisible(false);
            }
            COUIPreferenceCategory cOUIPreferenceCategory = this.H;
            if (cOUIPreferenceCategory != null) {
                cOUIPreferenceCategory.setVisible(false);
            }
            COUIPreferenceCategory cOUIPreferenceCategory2 = this.f20632I;
            if (cOUIPreferenceCategory2 != null) {
                cOUIPreferenceCategory2.setVisible(false);
            }
            COUIPreferenceCategory cOUIPreferenceCategory3 = this.f20633J;
            if (cOUIPreferenceCategory3 != null) {
                cOUIPreferenceCategory3.setVisible(true);
            }
        }
        O store = getViewModelStore();
        N.b factory = getDefaultViewModelProviderFactory();
        W.a defaultViewModelCreationExtras = getDefaultViewModelCreationExtras();
        h.e(store, "store");
        h.e(factory, "factory");
        d dVarB = g.b(defaultViewModelCreationExtras, "defaultCreationExtras", store, factory, defaultViewModelCreationExtras);
        kotlin.jvm.internal.b bVarA = j.a(AITranslationViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20629E = (AITranslationViewModel) dVarB.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        String str = this.f20625A;
        if (str == null) {
            h.i("mProductId");
            throw null;
        }
        String str2 = this.f20626B;
        if (str2 == null) {
            h.i("mProductName");
            throw null;
        }
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(str, str2);
        if (whitelistConfigDTOC != null && (function = whitelistConfigDTOC.getFunction()) != null && (control = function.getControl()) != null && !control.isEmpty()) {
            Iterator<T> it = control.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (AITranslationViewModel.f20638b.contains(Integer.valueOf(((WhitelistConfigDTO.Control) it.next()).getAction()))) {
                    z2 = true;
                    break;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            String string = getString(R.string.melody_ui_ai_translation_face_to_face_desc_single_pinch);
            h.d(string, "getString(...)");
            arrayList.add(new Q8.b(R.drawable.melody_ui_ai_translation_face_to_face_img, null, -1, string));
            String string2 = getString(R.string.melody_ui_ai_translation_real_time_desc_single_pinch);
            h.d(string2, "getString(...)");
            arrayList.add(new Q8.b(R.drawable.melody_ui_ai_translation_real_time_img, null, -1, string2));
        } else {
            String string3 = getString(R.string.melody_ui_ai_translation_face_to_face_desc_double_click);
            h.d(string3, "getString(...)");
            arrayList.add(new Q8.b(R.drawable.melody_ui_ai_translation_face_to_face_img, null, -1, string3));
            String string4 = getString(R.string.melody_ui_ai_translation_real_time_desc_double_click);
            h.d(string4, "getString(...)");
            arrayList.add(new Q8.b(R.drawable.melody_ui_ai_translation_real_time_img, null, -1, string4));
        }
        MelodyViewPagerGuidePreference melodyViewPagerGuidePreference = this.f20630F;
        if (melodyViewPagerGuidePreference != null) {
            ArrayList arrayList2 = melodyViewPagerGuidePreference.f21977p;
            arrayList2.clear();
            arrayList2.addAll(arrayList);
            MelodyViewPagerGuidePreference.a aVar = melodyViewPagerGuidePreference.f21978q;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
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

    @Override // F8.b, com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        TextView cOUITitleTextView;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        F8.a aVar = activity instanceof F8.a ? (F8.a) activity : null;
        if (aVar != null) {
            COUIToolbar cOUIToolbar = (COUIToolbar) view.findViewById(R.id.tool_bar);
            if (this.f20634K) {
                if (cOUIToolbar != null) {
                    cOUIToolbar.setVisibility(8);
                }
                this.f11714c.setNestedScrollingEnabled(false);
            } else {
                if (cOUIToolbar != null && (cOUITitleTextView = cOUIToolbar.getCOUITitleTextView()) != null) {
                    cOUITitleTextView.setTextDirection(2);
                }
                aVar.y(cOUIToolbar);
                androidx.appcompat.app.a aVarX = aVar.x();
                if (aVarX != null) {
                    aVarX.o();
                    aVarX.n(true);
                    aVarX.t(R.string.melody_ui_ai_translation_title);
                }
            }
        }
        RecyclerView recyclerView = this.f11714c;
        if (recyclerView != null && getParentFragment() != null && (recyclerView instanceof COUIPercentWidthRecyclerView)) {
            ((COUIPercentWidthRecyclerView) recyclerView).setPercentIndentEnabled(false);
        }
        if (C0897c.b(requireActivity()) || C0897c.c(requireActivity())) {
            View viewFindViewById = view.findViewById(android.R.id.list_container);
            h.d(viewFindViewById, "findViewById(...)");
            ViewGroup.LayoutParams layoutParams = ((FrameLayout) viewFindViewById).getLayoutParams();
            h.c(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMarginStart((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
            marginLayoutParams.setMarginEnd((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
        }
        if (this.f20629E == null) {
            h.i("mAITranslationVM");
            throw null;
        }
        String str = this.f20635z;
        if (str != null) {
            C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new g(18))).e(getViewLifecycleOwner(), new a(new AnonymousClass3(1, this, AITranslationFragment.class, "onConnectionStateChanged", "onConnectionStateChanged(I)V", 0)));
        } else {
            h.i("mAddress");
            throw null;
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        o(R.xml.melody_ui_ai_translation_preference);
    }

    public final void s(int i10) {
        String str = this.f20625A;
        if (str == null) {
            h.i("mProductId");
            throw null;
        }
        String str2 = this.f20635z;
        if (str2 == null) {
            h.i("mAddress");
            throw null;
        }
        if (this.f20629E != null) {
            C1264t.t(i10, str, str2, com.oplus.melody.model.repository.earphone.N.t(AbstractC0939b.E().w(str2)), "");
        } else {
            h.i("mAITranslationVM");
            throw null;
        }
    }
}
