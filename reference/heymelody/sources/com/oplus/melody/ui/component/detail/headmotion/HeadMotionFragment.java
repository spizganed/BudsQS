package com.oplus.melody.ui.component.detail.headmotion;

import A6.g;
import D7.C0379m;
import F8.b;
import F9.u;
import Kb.j;
import V7.c;
import Wb.l;
import X.d;
import X1.o;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.i;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.media3.session.q1;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUIMenuPreference;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import g0.C1065d;
import g9.s;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: HeadMotionFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u000bH\u0002J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020%H\u0002J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020%H\u0002J\u0017\u0010.\u001a\u00020\u00172\b\u0010/\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u00100J\u0017\u00101\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u00100J\b\u00103\u001a\u00020\u0017H\u0002J\u0017\u00104\u001a\u00020\u00172\b\u00105\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u00100J\b\u00106\u001a\u00020%H\u0002J\u0018\u00107\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u0005H\u0002J\u0018\u00109\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u0005H\u0002J\u0010\u0010;\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0014H\u0002J\u0010\u0010<\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0014H\u0002J\u0018\u0010=\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006?"}, d2 = {"Lcom/oplus/melody/ui/component/detail/headmotion/HeadMotionFragment;", "Lcom/oplus/melody/ui/base/BaseCOUIPreferenceFragment;", "<init>", "()V", "address", "", "toolbar", "Lcom/oplus/melody/ui/widget/MelodyCompatToolbar;", "headMotionSwitch", "Lcom/oplus/melody/ui/component/detail/headmotion/HeadMotionSwitchWithTryPreference;", "answerCallPref", "Lcom/coui/appcompat/preference/COUIMenuPreference;", "rejectCallPref", "headMotionViewModel", "Lcom/oplus/melody/ui/component/detail/headmotion/HeadMotionViewModel;", "setHeadMotionFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "setHeadMotionTypeFuture", "currentHeadMotionType", "", "Ljava/lang/Integer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "initMenuPreference", "preference", "updateMenuVisibleState", "isVisible", "handleHeadMotionSwitchChanged", "isOpen", "onHeadMotionStatusChange", "headMotionStatus", "(Ljava/lang/Integer;)V", "onHeadMotionTypeChange", "headMotionType", "syncMenuVisibleStateWithSwitch", "onConnectStateChange", "connectState", "checkLeastOneInEar", "updateMenuAssignment", "value", "updateSingleMenu", "selectedValue", "applyMenuSelectionByHeadMotionType", "setHeadMotionType", "updatePopupList", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HeadMotionFragment extends b {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final String[] f21039I = {"nod", "shake"};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public MelodyCompatToolbar f21040A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public HeadMotionSwitchWithTryPreference f21041B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public COUIMenuPreference f21042C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public COUIMenuPreference f21043D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public HeadMotionViewModel f21044E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f21045F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f21046G;
    public Integer H;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f21047z;

    /* JADX INFO: compiled from: HeadMotionFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctionReferenceImpl f21048a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(l lVar) {
            this.f21048a = (FunctionReferenceImpl) lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21048a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [Wb.l, kotlin.jvm.internal.FunctionReferenceImpl] */
        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21048a.d(obj);
        }
    }

    public static void x(COUIMenuPreference cOUIMenuPreference, String str) {
        String string;
        CharSequence charSequence;
        CharSequence charSequence2;
        if (!h.a(cOUIMenuPreference.f14646q, str)) {
            cOUIMenuPreference.h(str);
        }
        boolean zEquals = "shake".equals(str);
        CharSequence[] charSequenceArr = cOUIMenuPreference.f14644c;
        if (charSequenceArr != null && (charSequence2 = (CharSequence) j.b0(zEquals ? 1 : 0, charSequenceArr)) != null) {
            cOUIMenuPreference.setAssignment(charSequence2);
        }
        CharSequence[] charSequenceArr2 = cOUIMenuPreference.f14644c;
        ArrayList arrayList = new ArrayList();
        String[] strArr = f21039I;
        int i10 = 0;
        int i11 = 0;
        while (i10 < 2) {
            String str2 = strArr[i10];
            int i12 = i11 + 1;
            if (charSequenceArr2 == null || (charSequence = (CharSequence) j.b0(i11, charSequenceArr2)) == null || (string = charSequence.toString()) == null) {
                string = "";
            }
            boolean zEquals2 = TextUtils.equals(strArr[i11], str);
            o oVar = new o();
            oVar.f5848e = null;
            oVar.h = true;
            oVar.f5849f = string;
            oVar.f5850g = zEquals2;
            oVar.f5845b = -1;
            oVar.f5847d = -1;
            oVar.f5844a = 0;
            arrayList.add(oVar);
            i10++;
            i11 = i12;
        }
        ArrayList<o> arrayList2 = cOUIMenuPreference.f14649t;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        androidx.fragment.app.f activity = getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent == null) {
            A.h("HeadMotionFragment", "onCreate intent is null");
            androidx.fragment.app.f activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra("device_mac_info");
        this.f21047z = stringExtra;
        if (stringExtra == null || stringExtra.length() == 0) {
            A.h("HeadMotionFragment", "onCreate address is null or empty");
            androidx.fragment.app.f activity3 = getActivity();
            if (activity3 != null) {
                activity3.finish();
                return;
            }
            return;
        }
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        O store = getViewModelStore();
        N.b factory = getDefaultViewModelProviderFactory();
        W.a defaultViewModelCreationExtras = getDefaultViewModelCreationExtras();
        h.e(store, "store");
        h.e(factory, "factory");
        d dVarB = g.b(defaultViewModelCreationExtras, "defaultCreationExtras", store, factory, defaultViewModelCreationExtras);
        kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(HeadMotionViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f21044E = (HeadMotionViewModel) dVarB.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
        this.f21040A = (MelodyCompatToolbar) viewOnCreateView.findViewById(R.id.tool_bar);
        return viewOnCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        androidx.fragment.app.f activity;
        h.e(item, "item");
        if (item.getItemId() == 16908332 && (activity = getActivity()) != null) {
            activity.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // F8.b, com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        MelodyCompatToolbar melodyCompatToolbar;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.f activity = getActivity();
        i iVar = activity instanceof i ? (i) activity : null;
        if (iVar == null || (melodyCompatToolbar = this.f21040A) == null) {
            return;
        }
        iVar.y(melodyCompatToolbar);
        androidx.appcompat.app.a aVarX = iVar.x();
        if (aVarX != null) {
            aVarX.t(R.string.melody_ui_head_motion_title);
            aVarX.o();
            aVarX.n(true);
        }
        String str = this.f21047z;
        if (str != null) {
            if (this.f21044E != null) {
                C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new s(new PropertyReference1Impl() { // from class: com.oplus.melody.ui.component.detail.headmotion.HeadMotionViewModel$getConnectionState$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, cc.e
                    public final Object get(Object obj) {
                        return Integer.valueOf(((EarphoneDTO) obj).getConnectionState());
                    }
                }, 5))).e(getViewLifecycleOwner(), new a(new HeadMotionFragment$onViewCreated$2$1(1, this, HeadMotionFragment.class, "onConnectStateChange", "onConnectStateChange(Ljava/lang/Integer;)V", 0)));
            }
            if (this.f21044E != null) {
                C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new C1065d(23))).e(getViewLifecycleOwner(), new a(new HeadMotionFragment$onViewCreated$2$2(1, this, HeadMotionFragment.class, "onHeadMotionStatusChange", "onHeadMotionStatusChange(Ljava/lang/Integer;)V", 0)));
            }
            if (this.f21044E != null) {
                C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new F8.f(new PropertyReference1Impl() { // from class: com.oplus.melody.ui.component.detail.headmotion.HeadMotionViewModel$getHeadMotionType$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, cc.e
                    public final Object get(Object obj) {
                        return Integer.valueOf(((EarphoneDTO) obj).getHeadMotionType());
                    }
                }, 1))).e(getViewLifecycleOwner(), new a(new HeadMotionFragment$onViewCreated$2$3(1, this, HeadMotionFragment.class, "onHeadMotionTypeChange", "onHeadMotionTypeChange(Ljava/lang/Integer;)V", 0)));
            }
            if (this.f21044E != null) {
                AbstractC0939b.E().C(str);
            }
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        o(R.xml.melody_ui_head_motion_preference);
        Preference preferenceA = a("pref_head_motion_switch");
        this.f21041B = preferenceA instanceof HeadMotionSwitchWithTryPreference ? (HeadMotionSwitchWithTryPreference) preferenceA : null;
        Preference preferenceA2 = a("pref_head_motion_answer_call");
        this.f21042C = preferenceA2 instanceof COUIMenuPreference ? (COUIMenuPreference) preferenceA2 : null;
        Preference preferenceA3 = a("pref_head_motion_reject_call");
        COUIMenuPreference cOUIMenuPreference = preferenceA3 instanceof COUIMenuPreference ? (COUIMenuPreference) preferenceA3 : null;
        this.f21043D = cOUIMenuPreference;
        HeadMotionSwitchWithTryPreference headMotionSwitchWithTryPreference = this.f21041B;
        if (headMotionSwitchWithTryPreference == null || this.f21042C == null || cOUIMenuPreference == null) {
            A.h("HeadMotionFragment", "onCreatePreferences preferences are null");
            return;
        }
        headMotionSwitchWithTryPreference.f21051b = new E9.o(this, 20);
        headMotionSwitchWithTryPreference.setOnPreferenceChangeListener(new q1(this, 23));
        COUIMenuPreference cOUIMenuPreference2 = this.f21042C;
        if (cOUIMenuPreference2 != null) {
            t(cOUIMenuPreference2);
        }
        COUIMenuPreference cOUIMenuPreference3 = this.f21043D;
        if (cOUIMenuPreference3 != null) {
            t(cOUIMenuPreference3);
        }
        v();
    }

    public final void s(int i10) {
        A.b("HeadMotionFragment", "applyMenuSelectionByHeadMotionType headMotionType = " + i10);
        if (i10 != 0 && i10 != 1) {
            A.x("HeadMotionFragment", "applyMenuSelectionByHeadMotionType headMotionType = " + i10);
            return;
        }
        String str = i10 == 0 ? "nod" : "shake";
        String str2 = "nod".equals(str) ? "shake" : "nod";
        COUIMenuPreference cOUIMenuPreference = this.f21042C;
        if (cOUIMenuPreference != null) {
            x(cOUIMenuPreference, str);
        }
        COUIMenuPreference cOUIMenuPreference2 = this.f21043D;
        if (cOUIMenuPreference2 != null) {
            x(cOUIMenuPreference2, str2);
        }
    }

    public final void t(COUIMenuPreference cOUIMenuPreference) {
        String string = getString(R.string.melody_ui_head_motion_option_nod);
        h.d(string, "getString(...)");
        String string2 = getString(R.string.melody_ui_head_motion_option_shake);
        h.d(string2, "getString(...)");
        cOUIMenuPreference.e(new CharSequence[]{string, string2});
        cOUIMenuPreference.f(f21039I);
        cOUIMenuPreference.setOnPreferenceChangeListener(new s(this, 4));
    }

    public final void u(int i10) {
        String str = this.f21047z;
        if (str == null || str.length() == 0) {
            A.h("HeadMotionFragment", "setHeadMotionType address is null or empty");
            return;
        }
        if (this.f21044E == null) {
            return;
        }
        CompletableFuture<SetCommandStateDTO> completableFuture = this.f21046G;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        CompletableFuture<SetCommandStateDTO> completableFutureQ0 = AbstractC0939b.E().q0(i10, str);
        h.d(completableFutureQ0, "setHeadMotionType(...)");
        this.f21046G = completableFutureQ0;
        CompletableFuture<Void> completableFutureThenAccept = completableFutureQ0.thenAccept((Consumer<? super SetCommandStateDTO>) new G8.h(new c(i10, this, str), 19));
        if (completableFutureThenAccept != null) {
            completableFutureThenAccept.exceptionally((Function<Throwable, ? extends Void>) new u(2, this, str));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void v() {
        /*
            r2 = this;
            com.oplus.melody.ui.component.detail.headmotion.HeadMotionSwitchWithTryPreference r0 = r2.f21041B
            if (r0 == 0) goto L22
            boolean r0 = r0.isChecked()
            r1 = 1
            if (r0 != r1) goto L22
            java.lang.Integer r0 = r2.H
            if (r0 != 0) goto L10
            goto L16
        L10:
            int r0 = r0.intValue()
            if (r0 == 0) goto L23
        L16:
            java.lang.Integer r0 = r2.H
            if (r0 != 0) goto L1b
            goto L22
        L1b:
            int r0 = r0.intValue()
            if (r0 != r1) goto L22
            goto L23
        L22:
            r1 = 0
        L23:
            r2.w(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.headmotion.HeadMotionFragment.v():void");
    }

    public final void w(boolean z2) {
        COUIMenuPreference cOUIMenuPreference = this.f21042C;
        if (cOUIMenuPreference != null) {
            cOUIMenuPreference.setVisible(z2);
        }
        COUIMenuPreference cOUIMenuPreference2 = this.f21043D;
        if (cOUIMenuPreference2 != null) {
            cOUIMenuPreference2.setVisible(z2);
        }
    }
}
