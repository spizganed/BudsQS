package com.oplus.melody.ui.component.detail.dress.custom;

import A9.p;
import A9.s;
import D7.C0379m;
import D7.o0;
import G8.k;
import I8.DialogInterfaceOnClickListenerC0428d;
import Kb.m;
import Kb.q;
import R1.e;
import Wb.l;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.f;
import androidx.appcompat.app.i;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.media3.session.N0;
import androidx.preference.Preference;
import c9.C0769a;
import c9.n;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.preference.COUIInputPreference;
import com.coui.appcompat.preference.COUIMenuPreference;
import com.coui.appcompat.preference.COUIPreference;
import com.coui.appcompat.preference.g;
import com.coui.appcompat.seekbar.COUISeekBar;
import com.heytap.headset.R;
import com.oplus.melody.ui.component.detail.dress.custom.BlurSeekBarPreference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000±\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\b\u0003\n\u0002\b\t*\u00032Y\\\u0018\u0000 c2\u00020\u00012\u00020\u0002:\u0001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u0002002\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0018\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J\u0012\u00109\u001a\u00020*2\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u0012\u0010<\u001a\u00020*2\b\u0010=\u001a\u0004\u0018\u00010 H\u0002J\u0017\u0010>\u001a\u00020*2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002¢\u0006\u0002\u0010AJ\u0017\u0010B\u001a\u00020*2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002¢\u0006\u0002\u0010AJ\u0017\u0010C\u001a\u00020*2\b\u0010D\u001a\u0004\u0018\u00010EH\u0002¢\u0006\u0002\u0010FJ\u0010\u0010G\u001a\u00020 2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020 H\u0002J\u0017\u0010J\u001a\u00020*2\b\u0010K\u001a\u0004\u0018\u00010EH\u0002¢\u0006\u0002\u0010FJ\u0012\u0010L\u001a\u00020*2\b\u0010M\u001a\u0004\u0018\u00010 H\u0002J\u0017\u0010N\u001a\u00020*2\b\u0010O\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0002\u0010PJ\b\u0010Q\u001a\u00020*H\u0002J\u0017\u0010R\u001a\u00020*2\b\u0010O\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0002\u0010PJ\u0017\u0010S\u001a\u00020*2\b\u0010O\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0002\u0010PJ\u0017\u0010T\u001a\u00020*2\b\u0010U\u001a\u0004\u0018\u00010EH\u0002¢\u0006\u0002\u0010FJ\b\u0010V\u001a\u00020*H\u0002J\b\u0010W\u001a\u00020*H\u0002J\u0010\u0010^\u001a\u00020@2\u0006\u0010_\u001a\u00020 H\u0002J\u0010\u0010`\u001a\u00020 2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010a\u001a\u00020@2\u0006\u0010_\u001a\u00020 H\u0002J\u0010\u0010b\u001a\u00020 2\u0006\u0010?\u001a\u00020@H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103R\u0010\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0004\n\u0002\u0010ZR\u0010\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0004\n\u0002\u0010]¨\u0006d"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/custom/CustomAdjustPreferenceFragment;", "Lcom/coui/appcompat/preference/COUIPreferenceFragment;", "Landroidx/preference/Preference$OnPreferenceChangeListener;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/dress/custom/CustomDressViewModel;", "mNamePreference", "Lcom/coui/appcompat/preference/COUIPreference;", "mNameInputPreference", "Lcom/coui/appcompat/preference/COUIInputPreference;", "mBlurPreference", "Lcom/oplus/melody/ui/component/detail/dress/custom/BlurSeekBarPreference;", "mDialogTimePreference", "Lcom/coui/appcompat/preference/COUIMenuPreference;", "mComponentTimePreference", "mComponentUiModePreference", "mPromptPreference", "mModelPreference", "mBatteryPreference", "mPromptDialog", "Landroid/app/Dialog;", "mPromptPositiveButton", "Landroid/widget/Button;", "mPromptEditText", "Landroid/widget/EditText;", "mComponentTimeEntryChangeFuture", "Ljava/util/concurrent/CompletableFuture;", "", "mBatteryEntryChangeFuture", "mComponentTimeEntryValues", "", "", "getMComponentTimeEntryValues", "()[Ljava/lang/String;", "mComponentTimeEntryValues$delegate", "Lkotlin/Lazy;", "mNameEditText", "Lcom/coui/appcompat/edittext/COUIEditText;", "mUpdateDressNameRunnable", "Ljava/lang/Runnable;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "onViewCreated", "view", "Landroid/view/View;", "blurPreferenceChangeListener", "com/oplus/melody/ui/component/detail/dress/custom/CustomAdjustPreferenceFragment$blurPreferenceChangeListener$1", "Lcom/oplus/melody/ui/component/detail/dress/custom/CustomAdjustPreferenceFragment$blurPreferenceChangeListener$1;", "onPreferenceChange", "preference", "Landroidx/preference/Preference;", "newValue", "", "onUiModelChanged", "uiModel", "Lcom/oplus/melody/ui/component/detail/dress/custom/UiModel;", "onNameChanged", "name", "onDialogTimeChanged", "value", "", "(Ljava/lang/Long;)V", "onComponentTimeChanged", "onComponentUiModeChanged", "mode", "", "(Ljava/lang/Integer;)V", "componentUiModeValueToLabel", "componentUiModeLabelToValue", "label", "onBlurProgressChanged", "progress", "onPromptChanged", "prompt", "onShowPromptChanged", "show", "(Ljava/lang/Boolean;)V", "updatePromptValue", "onModelChanged", "onShowBatteryChanged", "onBatteryStyleChanged", "style", "updateBatteryValue", "updateBatteryEntry", "mNameTextWatcher", "com/oplus/melody/ui/component/detail/dress/custom/CustomAdjustPreferenceFragment$mNameTextWatcher$1", "Lcom/oplus/melody/ui/component/detail/dress/custom/CustomAdjustPreferenceFragment$mNameTextWatcher$1;", "mPromptTextWatcher", "com/oplus/melody/ui/component/detail/dress/custom/CustomAdjustPreferenceFragment$mPromptTextWatcher$1", "Lcom/oplus/melody/ui/component/detail/dress/custom/CustomAdjustPreferenceFragment$mPromptTextWatcher$1;", "timeToValue", "time", "valueToTime", "secondToValue", "valueToSecond", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CustomAdjustPreferenceFragment extends g implements Preference.c {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public COUIMenuPreference f20830A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public COUIMenuPreference f20831B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public COUIMenuPreference f20832C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public COUIMenuPreference f20833D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public COUIMenuPreference f20834E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public COUIMenuPreference f20835F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public f f20836G;
    public Button H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public EditText f20837I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public CompletableFuture<Boolean> f20838J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public CompletableFuture<Boolean> f20839K;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public COUIEditText f20841M;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CustomDressViewModel f20846w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public COUIPreference f20847x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public COUIInputPreference f20848y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public BlurSeekBarPreference f20849z;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public final Jb.b f20840L = kotlin.a.a(new O9.d(this, 13));

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public final N0 f20842N = new N0(this, 1);

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public final a f20843O = new a();

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public final b f20844P = new b();

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public final c f20845Q = new c();

    /* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
    public static final class a implements BlurSeekBarPreference.a {
        public a() {
        }

        @Override // com.oplus.melody.ui.component.detail.dress.custom.BlurSeekBarPreference.a
        public final void a(int i10) {
            CustomDressViewModel customDressViewModel = CustomAdjustPreferenceFragment.this.f20846w;
            if (customDressViewModel == null) {
                h.i("mViewModel");
                throw null;
            }
            customDressViewModel.f20934u.m(Integer.valueOf(i10));
        }
    }

    /* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
    public static final class d implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctionReferenceImpl f20853a;

        /* JADX WARN: Multi-variable type inference failed */
        public d(l lVar) {
            this.f20853a = (FunctionReferenceImpl) lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20853a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [Wb.l, kotlin.jvm.internal.FunctionReferenceImpl] */
        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20853a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.custom.CustomAdjustPreferenceFragment$onViewCreated$10, reason: invalid class name */
    /* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass10 extends FunctionReferenceImpl implements l<Boolean, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Boolean bool) {
            Boolean bool2 = bool;
            CustomAdjustPreferenceFragment customAdjustPreferenceFragment = (CustomAdjustPreferenceFragment) this.receiver;
            if (bool2 != null) {
                COUIMenuPreference cOUIMenuPreference = customAdjustPreferenceFragment.f20834E;
                if (cOUIMenuPreference != null) {
                    cOUIMenuPreference.h(bool2.booleanValue() ? customAdjustPreferenceFragment.getString(R.string.melody_ui_custom_dress_select_default) : customAdjustPreferenceFragment.getString(R.string.melody_ui_custom_dress_select_no_show));
                }
                COUIMenuPreference cOUIMenuPreference2 = customAdjustPreferenceFragment.f20834E;
                if (cOUIMenuPreference2 != null) {
                    cOUIMenuPreference2.setAssignment(cOUIMenuPreference2.f14646q);
                }
                customAdjustPreferenceFragment.t();
            } else {
                customAdjustPreferenceFragment.getClass();
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.custom.CustomAdjustPreferenceFragment$onViewCreated$11, reason: invalid class name */
    /* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass11 extends FunctionReferenceImpl implements l<Boolean, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Boolean bool) {
            Boolean bool2 = bool;
            CustomAdjustPreferenceFragment customAdjustPreferenceFragment = (CustomAdjustPreferenceFragment) this.receiver;
            if (bool2 != null) {
                customAdjustPreferenceFragment.u();
            } else {
                customAdjustPreferenceFragment.getClass();
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.custom.CustomAdjustPreferenceFragment$onViewCreated$12, reason: invalid class name */
    /* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass12 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            Integer num2 = num;
            CustomAdjustPreferenceFragment customAdjustPreferenceFragment = (CustomAdjustPreferenceFragment) this.receiver;
            if (num2 != null) {
                customAdjustPreferenceFragment.u();
            } else {
                customAdjustPreferenceFragment.getClass();
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.custom.CustomAdjustPreferenceFragment$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements l<n, Jb.l> {
        /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
        @Override // Wb.l
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final Jb.l d(c9.n r7) {
            /*
                r6 = this;
                r0 = 1
                c9.n r7 = (c9.n) r7
                java.lang.Object r1 = r6.receiver
                com.oplus.melody.ui.component.detail.dress.custom.CustomAdjustPreferenceFragment r1 = (com.oplus.melody.ui.component.detail.dress.custom.CustomAdjustPreferenceFragment) r1
                if (r7 != 0) goto Ld
                r1.getClass()
                goto L6c
            Ld:
                com.coui.appcompat.preference.COUIPreference r2 = r1.f20847x
                boolean r3 = r7.f13537b
                if (r2 == 0) goto L18
                r4 = r3 ^ 1
                r2.setVisible(r4)
            L18:
                com.coui.appcompat.preference.COUIInputPreference r2 = r1.f20848y
                if (r2 == 0) goto L1f
                r2.setVisible(r3)
            L1f:
                com.oplus.melody.ui.component.detail.dress.custom.BlurSeekBarPreference r2 = r1.f20849z
                if (r2 == 0) goto L42
                if (r3 == 0) goto L3e
                java.lang.Object r4 = com.oplus.melody.ui.component.detail.dress.custom.a.f20940a
                java.lang.String r7 = r7.f13536a
                java.lang.String r4 = com.oplus.melody.ui.component.detail.dress.custom.a.C0234a.a(r7)
                java.lang.String r5 = "image"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L3e
                java.lang.String r4 = "image/gif"
                boolean r7 = r7.equals(r4)
                if (r7 != 0) goto L3e
                goto L3f
            L3e:
                r0 = 0
            L3f:
                r2.setVisible(r0)
            L42:
                com.coui.appcompat.preference.COUIMenuPreference r7 = r1.f20830A
                if (r7 == 0) goto L49
                r7.setVisible(r3)
            L49:
                com.coui.appcompat.preference.COUIMenuPreference r7 = r1.f20831B
                if (r7 == 0) goto L50
                r7.setVisible(r3)
            L50:
                com.coui.appcompat.preference.COUIMenuPreference r7 = r1.f20832C
                if (r7 == 0) goto L57
                r7.setVisible(r3)
            L57:
                com.coui.appcompat.preference.COUIMenuPreference r7 = r1.f20833D
                if (r7 == 0) goto L5e
                r7.setVisible(r3)
            L5e:
                com.coui.appcompat.preference.COUIMenuPreference r7 = r1.f20834E
                if (r7 == 0) goto L65
                r7.setVisible(r3)
            L65:
                com.coui.appcompat.preference.COUIMenuPreference r7 = r1.f20835F
                if (r7 == 0) goto L6c
                r7.setVisible(r3)
            L6c:
                Jb.l r7 = Jb.l.f2618a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.dress.custom.CustomAdjustPreferenceFragment.AnonymousClass2.d(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.custom.CustomAdjustPreferenceFragment$onViewCreated$3, reason: invalid class name */
    /* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements l<String, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(String str) {
            COUIEditText cOUIEditText;
            String str2 = str;
            CustomAdjustPreferenceFragment customAdjustPreferenceFragment = (CustomAdjustPreferenceFragment) this.receiver;
            COUIEditText cOUIEditText2 = customAdjustPreferenceFragment.f20841M;
            if (!h.a(str2, String.valueOf(cOUIEditText2 != null ? cOUIEditText2.getText() : null)) && (cOUIEditText = customAdjustPreferenceFragment.f20841M) != null) {
                cOUIEditText.setText(str2);
            }
            COUIPreference cOUIPreference = customAdjustPreferenceFragment.f20847x;
            if (cOUIPreference != null) {
                cOUIPreference.setSummary(str2);
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.custom.CustomAdjustPreferenceFragment$onViewCreated$4, reason: invalid class name */
    /* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements l<Long, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Long l4) {
            CompletableFuture<Boolean> completableFuture;
            String string;
            Long l10 = l4;
            CustomAdjustPreferenceFragment customAdjustPreferenceFragment = (CustomAdjustPreferenceFragment) this.receiver;
            if (l10 != null) {
                COUIMenuPreference cOUIMenuPreference = customAdjustPreferenceFragment.f20830A;
                if (cOUIMenuPreference != null) {
                    long jLongValue = l10.longValue();
                    if (jLongValue == 0) {
                        string = customAdjustPreferenceFragment.getString(R.string.melody_ui_custom_dress_select_duration0);
                        h.d(string, "getString(...)");
                    } else if (jLongValue == 1000) {
                        string = customAdjustPreferenceFragment.getString(R.string.melody_ui_custom_dress_select_duration1);
                        h.d(string, "getString(...)");
                    } else if (jLongValue == 2000) {
                        string = customAdjustPreferenceFragment.getString(R.string.melody_ui_custom_dress_select_duration2);
                        h.d(string, "getString(...)");
                    } else if (jLongValue == 3000) {
                        string = customAdjustPreferenceFragment.getString(R.string.melody_ui_custom_dress_select_duration3);
                        h.d(string, "getString(...)");
                    } else if (jLongValue == 4000) {
                        string = customAdjustPreferenceFragment.getString(R.string.melody_ui_custom_dress_select_duration4);
                        h.d(string, "getString(...)");
                    } else if (jLongValue == 5000) {
                        string = customAdjustPreferenceFragment.getString(R.string.melody_ui_custom_dress_select_duration5);
                        h.d(string, "getString(...)");
                    } else if (jLongValue == 6000) {
                        string = customAdjustPreferenceFragment.getString(R.string.melody_ui_custom_dress_select_duration6);
                        h.d(string, "getString(...)");
                    } else if (jLongValue == 7000) {
                        string = customAdjustPreferenceFragment.getString(R.string.melody_ui_custom_dress_select_duration7);
                        h.d(string, "getString(...)");
                    } else if (jLongValue == 8000) {
                        string = customAdjustPreferenceFragment.getString(R.string.melody_ui_custom_dress_select_duration8);
                        h.d(string, "getString(...)");
                    } else {
                        string = customAdjustPreferenceFragment.getString(R.string.melody_ui_custom_dress_select_duration0);
                        h.d(string, "getString(...)");
                    }
                    cOUIMenuPreference.h(string);
                }
                COUIMenuPreference cOUIMenuPreference2 = customAdjustPreferenceFragment.f20830A;
                if (cOUIMenuPreference2 != null) {
                    cOUIMenuPreference2.setAssignment(cOUIMenuPreference2.f14646q);
                }
                COUIMenuPreference cOUIMenuPreference3 = customAdjustPreferenceFragment.f20831B;
                if (cOUIMenuPreference3 != null) {
                    Object value = customAdjustPreferenceFragment.f20840L.getValue();
                    h.d(value, "getValue(...)");
                    String[] strArr = (String[]) value;
                    ArrayList arrayList = new ArrayList(strArr.length);
                    for (String str : strArr) {
                        arrayList.add(Long.valueOf(customAdjustPreferenceFragment.s(str)));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        i10++;
                        if (((Number) obj).longValue() < l10.longValue()) {
                            arrayList2.add(obj);
                        }
                    }
                    List listC = q.C(arrayList2);
                    ArrayList arrayList3 = new ArrayList(m.i(listC));
                    Iterator it = listC.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(customAdjustPreferenceFragment.w(((Number) it.next()).longValue()));
                    }
                    cOUIMenuPreference3.f((CharSequence[]) arrayList3.toArray(new String[0]));
                }
                CompletableFuture<Boolean> completableFuture2 = customAdjustPreferenceFragment.f20838J;
                if (completableFuture2 != null && !completableFuture2.isDone() && (completableFuture = customAdjustPreferenceFragment.f20838J) != null) {
                    completableFuture.complete(Boolean.TRUE);
                }
                COUIMenuPreference cOUIMenuPreference4 = customAdjustPreferenceFragment.f20831B;
                if (cOUIMenuPreference4 != null) {
                    cOUIMenuPreference4.h(cOUIMenuPreference4.f14646q);
                }
            } else {
                customAdjustPreferenceFragment.getClass();
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.custom.CustomAdjustPreferenceFragment$onViewCreated$5, reason: invalid class name */
    /* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements l<Long, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Long l4) {
            Long l10 = l4;
            CustomAdjustPreferenceFragment customAdjustPreferenceFragment = (CustomAdjustPreferenceFragment) this.receiver;
            if (l10 != null) {
                COUIMenuPreference cOUIMenuPreference = customAdjustPreferenceFragment.f20831B;
                if (cOUIMenuPreference != null) {
                    cOUIMenuPreference.h(customAdjustPreferenceFragment.w(l10.longValue()));
                }
                COUIMenuPreference cOUIMenuPreference2 = customAdjustPreferenceFragment.f20831B;
                if (cOUIMenuPreference2 != null) {
                    cOUIMenuPreference2.setAssignment(cOUIMenuPreference2.f14646q);
                }
            } else {
                customAdjustPreferenceFragment.getClass();
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.custom.CustomAdjustPreferenceFragment$onViewCreated$6, reason: invalid class name */
    /* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            int iIntValue;
            String string;
            Integer num2 = num;
            CustomAdjustPreferenceFragment customAdjustPreferenceFragment = (CustomAdjustPreferenceFragment) this.receiver;
            if (num2 != null) {
                customAdjustPreferenceFragment.getClass();
                iIntValue = num2.intValue();
            } else {
                iIntValue = 0;
            }
            if (iIntValue == 1) {
                string = customAdjustPreferenceFragment.getString(R.string.melody_ui_custom_dress_component_ui_mode_light);
                h.d(string, "getString(...)");
            } else if (iIntValue != 2) {
                string = customAdjustPreferenceFragment.getString(R.string.melody_ui_custom_dress_component_ui_mode_auto);
                h.d(string, "getString(...)");
            } else {
                string = customAdjustPreferenceFragment.getString(R.string.melody_ui_custom_dress_component_ui_mode_dark);
                h.d(string, "getString(...)");
            }
            COUIMenuPreference cOUIMenuPreference = customAdjustPreferenceFragment.f20832C;
            if (cOUIMenuPreference != null) {
                cOUIMenuPreference.h(string);
            }
            COUIMenuPreference cOUIMenuPreference2 = customAdjustPreferenceFragment.f20832C;
            if (cOUIMenuPreference2 != null) {
                cOUIMenuPreference2.setAssignment(string);
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.custom.CustomAdjustPreferenceFragment$onViewCreated$7, reason: invalid class name */
    /* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            Integer num2 = num;
            CustomAdjustPreferenceFragment customAdjustPreferenceFragment = (CustomAdjustPreferenceFragment) this.receiver;
            if (num2 != null) {
                BlurSeekBarPreference blurSeekBarPreference = customAdjustPreferenceFragment.f20849z;
                if (blurSeekBarPreference != null) {
                    int iIntValue = num2.intValue();
                    blurSeekBarPreference.f20829c = iIntValue;
                    COUISeekBar cOUISeekBar = blurSeekBarPreference.f20827a;
                    if (cOUISeekBar != null) {
                        cOUISeekBar.setProgress(iIntValue, true, false);
                    }
                }
            } else {
                customAdjustPreferenceFragment.getClass();
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.custom.CustomAdjustPreferenceFragment$onViewCreated$8, reason: invalid class name */
    /* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass8 extends FunctionReferenceImpl implements l<String, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(String str) {
            ((CustomAdjustPreferenceFragment) this.receiver).v();
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.custom.CustomAdjustPreferenceFragment$onViewCreated$9, reason: invalid class name */
    /* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass9 extends FunctionReferenceImpl implements l<Boolean, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Boolean bool) {
            Boolean bool2 = bool;
            CustomAdjustPreferenceFragment customAdjustPreferenceFragment = (CustomAdjustPreferenceFragment) this.receiver;
            if (bool2 != null) {
                customAdjustPreferenceFragment.v();
                customAdjustPreferenceFragment.t();
            } else {
                customAdjustPreferenceFragment.getClass();
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.preference.Preference.c
    public final boolean e(Preference preference, Object newValue) {
        EditText editText;
        h.e(preference, "preference");
        h.e(newValue, "newValue");
        if (preference instanceof COUIPreference) {
            COUIPreference cOUIPreference = (COUIPreference) preference;
            if (!h.a(cOUIPreference.getKey(), "custom_adjust_prompt")) {
                cOUIPreference.setAssignment(newValue.toString());
            }
        }
        String key = preference.getKey();
        if (key != null) {
            int i10 = 2;
            switch (key.hashCode()) {
                case -1102566265:
                    if (key.equals("custom_adjust_model")) {
                        CustomDressViewModel customDressViewModel = this.f20846w;
                        if (customDressViewModel == null) {
                            h.i("mViewModel");
                            throw null;
                        }
                        customDressViewModel.f20911B.m(Boolean.valueOf(!newValue.equals(getString(R.string.melody_ui_custom_dress_select_no_show))));
                        if (!newValue.equals(getString(R.string.melody_ui_custom_dress_select_no_show))) {
                            CompletableFuture<Boolean> completableFuture = new CompletableFuture<>();
                            this.f20839K = completableFuture;
                            completableFuture.whenComplete((BiConsumer<? super Boolean, ? super Throwable>) new A9.q(new p(this, 5), 13));
                            return true;
                        }
                    }
                    break;
                case -664842686:
                    if (key.equals("custom_adjust_dialog_time")) {
                        CustomDressViewModel customDressViewModel2 = this.f20846w;
                        if (customDressViewModel2 == null) {
                            h.i("mViewModel");
                            throw null;
                        }
                        String str = (String) newValue;
                        long j5 = 0;
                        if (!str.equals(getString(R.string.melody_ui_custom_dress_select_duration0))) {
                            if (str.equals(getString(R.string.melody_ui_custom_dress_select_duration1))) {
                                j5 = 1000;
                            } else if (str.equals(getString(R.string.melody_ui_custom_dress_select_duration2))) {
                                j5 = 2000;
                            } else if (str.equals(getString(R.string.melody_ui_custom_dress_select_duration3))) {
                                j5 = 3000;
                            } else if (str.equals(getString(R.string.melody_ui_custom_dress_select_duration4))) {
                                j5 = 4000;
                            } else if (str.equals(getString(R.string.melody_ui_custom_dress_select_duration5))) {
                                j5 = 5000;
                            } else if (str.equals(getString(R.string.melody_ui_custom_dress_select_duration6))) {
                                j5 = 6000;
                            } else if (str.equals(getString(R.string.melody_ui_custom_dress_select_duration7))) {
                                j5 = 7000;
                            } else if (str.equals(getString(R.string.melody_ui_custom_dress_select_duration8))) {
                                j5 = 8000;
                            }
                        }
                        customDressViewModel2.f20936w.m(Long.valueOf(j5));
                        CompletableFuture<Boolean> completableFuture2 = new CompletableFuture<>();
                        this.f20838J = completableFuture2;
                        completableFuture2.whenComplete((BiConsumer<? super Boolean, ? super Throwable>) new s(new F8.g(this, 8), 26));
                        return true;
                    }
                    break;
                case -267452437:
                    if (key.equals("custom_adjust_battery")) {
                        CustomDressViewModel customDressViewModel3 = this.f20846w;
                        if (customDressViewModel3 == null) {
                            h.i("mViewModel");
                            throw null;
                        }
                        customDressViewModel3.f20912C.m(Boolean.valueOf(!newValue.equals(getString(R.string.melody_ui_custom_dress_select_no_show))));
                        if (newValue.equals(getString(R.string.melody_ui_custom_dress_select_below))) {
                            CustomDressViewModel customDressViewModel4 = this.f20846w;
                            if (customDressViewModel4 != null) {
                                customDressViewModel4.f20913D.m(4);
                                return true;
                            }
                            h.i("mViewModel");
                            throw null;
                        }
                        if (newValue.equals(getString(R.string.melody_ui_custom_dress_select_upper_left_corner))) {
                            CustomDressViewModel customDressViewModel5 = this.f20846w;
                            if (customDressViewModel5 != null) {
                                customDressViewModel5.f20913D.m(2);
                                return true;
                            }
                            h.i("mViewModel");
                            throw null;
                        }
                        if (newValue.equals(getString(R.string.melody_ui_custom_dress_select_upper_right_corner))) {
                            CustomDressViewModel customDressViewModel6 = this.f20846w;
                            if (customDressViewModel6 != null) {
                                customDressViewModel6.f20913D.m(3);
                                return true;
                            }
                            h.i("mViewModel");
                            throw null;
                        }
                        CustomDressViewModel customDressViewModel7 = this.f20846w;
                        if (customDressViewModel7 != null) {
                            customDressViewModel7.f20913D.m(0);
                            return true;
                        }
                        h.i("mViewModel");
                        throw null;
                    }
                    break;
                case 103246730:
                    if (key.equals("custom_adjust_component_ui_mode")) {
                        CustomDressViewModel customDressViewModel8 = this.f20846w;
                        if (customDressViewModel8 == null) {
                            h.i("mViewModel");
                            throw null;
                        }
                        String str2 = (String) newValue;
                        if (str2.equals(getString(R.string.melody_ui_custom_dress_component_ui_mode_light))) {
                            i10 = 1;
                        } else if (!str2.equals(getString(R.string.melody_ui_custom_dress_component_ui_mode_dark))) {
                            i10 = 0;
                        }
                        customDressViewModel8.f20938y.m(Integer.valueOf(i10));
                        return true;
                    }
                    break;
                case 269177798:
                    if (key.equals("custom_adjust_prompt")) {
                        if (newValue.equals(getString(R.string.melody_ui_custom_dress_select_custom_prompt))) {
                            androidx.fragment.app.f activity = getActivity();
                            if (activity != null) {
                                e eVar = new e(activity, R.style.COUIAlertDialog_BottomAssignment);
                                eVar.setView(R.layout.melody_ui_custom_equalizer_edit_name);
                                eVar.n(R.string.melody_ui_custom_dress_select_custom_prompt);
                                eVar.f(R.string.melody_ui_custom_dress_adjust_prompt_dialog_summary);
                                eVar.h(R.string.melody_ui_common_cancel, new k(3));
                                eVar.l(R.string.melody_ui_save, new DialogInterfaceOnClickListenerC0428d(this, 7));
                                f fVarShow = eVar.show();
                                this.f20836G = fVarShow;
                                EditText editText2 = (EditText) fVarShow.findViewById(R.id.edit_custom_equalizer_name);
                                this.f20837I = editText2;
                                if (editText2 != null) {
                                    editText2.setHint(R.string.melody_ui_custom_dress_adjust_prompt_dialog_hint);
                                }
                                CustomDressViewModel customDressViewModel9 = this.f20846w;
                                if (customDressViewModel9 == null) {
                                    h.i("mViewModel");
                                    throw null;
                                }
                                String strD = customDressViewModel9.f20939z.d();
                                if (strD != null && !strD.equals("") && (editText = this.f20837I) != null) {
                                    editText.setText(strD);
                                }
                                f fVar = this.f20836G;
                                Button button = fVar != null ? (Button) fVar.findViewById(android.R.id.button1) : null;
                                this.H = button;
                                if (button != null) {
                                    if (strD == null) {
                                        strD = "";
                                    }
                                    button.setEnabled(strD.length() > 0);
                                }
                                EditText editText3 = this.f20837I;
                                if (editText3 != null) {
                                    editText3.addTextChangedListener(this.f20845Q);
                                }
                            }
                            return false;
                        }
                        if (newValue.equals(getString(R.string.melody_ui_custom_dress_select_no_show))) {
                            CustomDressViewModel customDressViewModel10 = this.f20846w;
                            if (customDressViewModel10 == null) {
                                h.i("mViewModel");
                                throw null;
                            }
                            customDressViewModel10.f20910A.m(Boolean.FALSE);
                            ((COUIPreference) preference).setAssignment(newValue.toString());
                            return true;
                        }
                        if (newValue.equals(getString(R.string.melody_ui_custom_dress_select_default_prompt))) {
                            CustomDressViewModel customDressViewModel11 = this.f20846w;
                            if (customDressViewModel11 == null) {
                                h.i("mViewModel");
                                throw null;
                            }
                            customDressViewModel11.f20939z.m(null);
                            CustomDressViewModel customDressViewModel12 = this.f20846w;
                            if (customDressViewModel12 == null) {
                                h.i("mViewModel");
                                throw null;
                            }
                            customDressViewModel12.f20910A.m(Boolean.TRUE);
                            ((COUIPreference) preference).setAssignment(newValue.toString());
                            CompletableFuture<Boolean> completableFuture3 = new CompletableFuture<>();
                            this.f20839K = completableFuture3;
                            completableFuture3.whenComplete((BiConsumer<? super Boolean, ? super Throwable>) new B9.b(new C0769a(this, 0), 21));
                            return true;
                        }
                    }
                    break;
                case 834141489:
                    if (key.equals("custom_adjust_component_time")) {
                        CustomDressViewModel customDressViewModel13 = this.f20846w;
                        if (customDressViewModel13 != null) {
                            customDressViewModel13.f20937x.m(Long.valueOf(s((String) newValue)));
                            return true;
                        }
                        h.i("mViewModel");
                        throw null;
                    }
                    break;
            }
        }
        return true;
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.f11714c.setNestedScrollingEnabled(false);
        this.f11714c.setItemAnimator(null);
        androidx.fragment.app.f activity = getActivity();
        h.c(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        i iVar = (i) activity;
        O viewModelStore = iVar.getViewModelStore();
        N.b defaultViewModelProviderFactory = iVar.getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, iVar.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(CustomDressViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20846w = (CustomDressViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        COUIInputPreference cOUIInputPreference = this.f20848y;
        COUIEditText cOUIEditText = cOUIInputPreference != null ? cOUIInputPreference.f14589a : null;
        this.f20841M = cOUIEditText;
        if (cOUIEditText != null) {
            cOUIEditText.setInputType(131072 | cOUIEditText.getInputType());
            cOUIEditText.addTextChangedListener(this.f20844P);
            cOUIEditText.setMaxLines(10000);
        }
        CustomDressViewModel customDressViewModel = this.f20846w;
        if (customDressViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel.f20930q).e(getViewLifecycleOwner(), new d(new AnonymousClass2(1, this, CustomAdjustPreferenceFragment.class, "onUiModelChanged", "onUiModelChanged(Lcom/oplus/melody/ui/component/detail/dress/custom/UiModel;)V", 0)));
        CustomDressViewModel customDressViewModel2 = this.f20846w;
        if (customDressViewModel2 == null) {
            h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel2.f20935v).e(getViewLifecycleOwner(), new d(new AnonymousClass3(1, this, CustomAdjustPreferenceFragment.class, "onNameChanged", "onNameChanged(Ljava/lang/String;)V", 0)));
        CustomDressViewModel customDressViewModel3 = this.f20846w;
        if (customDressViewModel3 == null) {
            h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel3.f20936w).e(getViewLifecycleOwner(), new d(new AnonymousClass4(1, this, CustomAdjustPreferenceFragment.class, "onDialogTimeChanged", "onDialogTimeChanged(Ljava/lang/Long;)V", 0)));
        CustomDressViewModel customDressViewModel4 = this.f20846w;
        if (customDressViewModel4 == null) {
            h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel4.f20937x).e(getViewLifecycleOwner(), new d(new AnonymousClass5(1, this, CustomAdjustPreferenceFragment.class, "onComponentTimeChanged", "onComponentTimeChanged(Ljava/lang/Long;)V", 0)));
        CustomDressViewModel customDressViewModel5 = this.f20846w;
        if (customDressViewModel5 == null) {
            h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel5.f20938y).e(getViewLifecycleOwner(), new d(new AnonymousClass6(1, this, CustomAdjustPreferenceFragment.class, "onComponentUiModeChanged", "onComponentUiModeChanged(Ljava/lang/Integer;)V", 0)));
        CustomDressViewModel customDressViewModel6 = this.f20846w;
        if (customDressViewModel6 == null) {
            h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel6.f20934u).e(getViewLifecycleOwner(), new d(new AnonymousClass7(1, this, CustomAdjustPreferenceFragment.class, "onBlurProgressChanged", "onBlurProgressChanged(Ljava/lang/Integer;)V", 0)));
        CustomDressViewModel customDressViewModel7 = this.f20846w;
        if (customDressViewModel7 == null) {
            h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel7.f20939z).e(getViewLifecycleOwner(), new d(new AnonymousClass8(1, this, CustomAdjustPreferenceFragment.class, "onPromptChanged", "onPromptChanged(Ljava/lang/String;)V", 0)));
        CustomDressViewModel customDressViewModel8 = this.f20846w;
        if (customDressViewModel8 == null) {
            h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel8.f20910A).e(getViewLifecycleOwner(), new d(new AnonymousClass9(1, this, CustomAdjustPreferenceFragment.class, "onShowPromptChanged", "onShowPromptChanged(Ljava/lang/Boolean;)V", 0)));
        CustomDressViewModel customDressViewModel9 = this.f20846w;
        if (customDressViewModel9 == null) {
            h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel9.f20911B).e(getViewLifecycleOwner(), new d(new AnonymousClass10(1, this, CustomAdjustPreferenceFragment.class, "onModelChanged", "onModelChanged(Ljava/lang/Boolean;)V", 0)));
        CustomDressViewModel customDressViewModel10 = this.f20846w;
        if (customDressViewModel10 == null) {
            h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel10.f20912C).e(getViewLifecycleOwner(), new d(new AnonymousClass11(1, this, CustomAdjustPreferenceFragment.class, "onShowBatteryChanged", "onShowBatteryChanged(Ljava/lang/Boolean;)V", 0)));
        CustomDressViewModel customDressViewModel11 = this.f20846w;
        if (customDressViewModel11 != null) {
            C0379m.b(customDressViewModel11.f20913D).e(getViewLifecycleOwner(), new d(new AnonymousClass12(1, this, CustomAdjustPreferenceFragment.class, "onBatteryStyleChanged", "onBatteryStyleChanged(Ljava/lang/Integer;)V", 0)));
        } else {
            h.i("mViewModel");
            throw null;
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        o(R.xml.melody_ui_custom_adjust_preference);
        COUIPreference cOUIPreference = (COUIPreference) a("custom_show_name");
        this.f20847x = cOUIPreference;
        if (cOUIPreference != null) {
            cOUIPreference.setBackgroundAnimationEnabled(false);
        }
        this.f20848y = (COUIInputPreference) a("custom_adjust_name");
        BlurSeekBarPreference blurSeekBarPreference = (BlurSeekBarPreference) a("custom_adjust_blur");
        this.f20849z = blurSeekBarPreference;
        if (blurSeekBarPreference != null) {
            a listener = this.f20843O;
            h.e(listener, "listener");
            blurSeekBarPreference.f20828b = listener;
        }
        COUIMenuPreference cOUIMenuPreference = (COUIMenuPreference) a("custom_adjust_dialog_time");
        this.f20830A = cOUIMenuPreference;
        if (cOUIMenuPreference != null) {
            cOUIMenuPreference.setOnPreferenceChangeListener(this);
        }
        COUIMenuPreference cOUIMenuPreference2 = (COUIMenuPreference) a("custom_adjust_component_time");
        this.f20831B = cOUIMenuPreference2;
        if (cOUIMenuPreference2 != null) {
            cOUIMenuPreference2.setOnPreferenceChangeListener(this);
        }
        COUIMenuPreference cOUIMenuPreference3 = (COUIMenuPreference) a("custom_adjust_component_ui_mode");
        this.f20832C = cOUIMenuPreference3;
        if (cOUIMenuPreference3 != null) {
            cOUIMenuPreference3.setOnPreferenceChangeListener(this);
        }
        COUIMenuPreference cOUIMenuPreference4 = (COUIMenuPreference) a("custom_adjust_prompt");
        this.f20833D = cOUIMenuPreference4;
        if (cOUIMenuPreference4 != null) {
            cOUIMenuPreference4.setOnPreferenceChangeListener(this);
        }
        COUIMenuPreference cOUIMenuPreference5 = (COUIMenuPreference) a("custom_adjust_model");
        this.f20834E = cOUIMenuPreference5;
        if (cOUIMenuPreference5 != null) {
            cOUIMenuPreference5.setOnPreferenceChangeListener(this);
        }
        COUIMenuPreference cOUIMenuPreference6 = (COUIMenuPreference) a("custom_adjust_battery");
        this.f20835F = cOUIMenuPreference6;
        if (cOUIMenuPreference6 != null) {
            cOUIMenuPreference6.setOnPreferenceChangeListener(this);
        }
    }

    public final long s(String str) {
        if (h.a(str, getString(R.string.melody_ui_custom_dress_select_display_time0))) {
            return 0L;
        }
        if (h.a(str, getString(R.string.melody_ui_custom_dress_select_display_time1))) {
            return 1000L;
        }
        if (h.a(str, getString(R.string.melody_ui_custom_dress_select_display_time2))) {
            return 2000L;
        }
        if (h.a(str, getString(R.string.melody_ui_custom_dress_select_display_time3))) {
            return 3000L;
        }
        if (h.a(str, getString(R.string.melody_ui_custom_dress_select_display_time4))) {
            return 4000L;
        }
        if (h.a(str, getString(R.string.melody_ui_custom_dress_select_display_time5))) {
            return 5000L;
        }
        if (h.a(str, getString(R.string.melody_ui_custom_dress_select_display_time6))) {
            return 6000L;
        }
        return h.a(str, getString(R.string.melody_ui_custom_dress_select_display_time7)) ? 7000L : 0L;
    }

    public final void t() {
        CompletableFuture<Boolean> completableFuture;
        CustomDressViewModel customDressViewModel = this.f20846w;
        if (customDressViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        Boolean boolD = customDressViewModel.f20911B.d();
        boolean zBooleanValue = boolD != null ? boolD.booleanValue() : true;
        CustomDressViewModel customDressViewModel2 = this.f20846w;
        if (customDressViewModel2 == null) {
            h.i("mViewModel");
            throw null;
        }
        Boolean boolD2 = customDressViewModel2.f20910A.d();
        boolean zBooleanValue2 = boolD2 != null ? boolD2.booleanValue() : true;
        if (!zBooleanValue && !zBooleanValue2) {
            COUIMenuPreference cOUIMenuPreference = this.f20835F;
            if (cOUIMenuPreference != null) {
                cOUIMenuPreference.f(cOUIMenuPreference.getContext().getResources().getTextArray(R.array.melody_ui_custom_adjust_battery_with_no_model_prompt_items));
            }
        } else if (zBooleanValue) {
            COUIMenuPreference cOUIMenuPreference2 = this.f20835F;
            if (cOUIMenuPreference2 != null) {
                cOUIMenuPreference2.f(cOUIMenuPreference2.getContext().getResources().getTextArray(R.array.melody_ui_custom_adjust_battery_items));
            }
        } else {
            COUIMenuPreference cOUIMenuPreference3 = this.f20835F;
            if (cOUIMenuPreference3 != null) {
                cOUIMenuPreference3.f(cOUIMenuPreference3.getContext().getResources().getTextArray(R.array.melody_ui_custom_adjust_battery_with_no_model_items));
            }
        }
        CompletableFuture<Boolean> completableFuture2 = this.f20839K;
        if (completableFuture2 != null && !completableFuture2.isDone() && (completableFuture = this.f20839K) != null) {
            completableFuture.complete(Boolean.TRUE);
        }
        COUIMenuPreference cOUIMenuPreference4 = this.f20835F;
        if (cOUIMenuPreference4 != null) {
            cOUIMenuPreference4.h(cOUIMenuPreference4.f14646q);
        }
    }

    public final void u() {
        CustomDressViewModel customDressViewModel = this.f20846w;
        if (customDressViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        Boolean boolD = customDressViewModel.f20912C.d();
        boolean zBooleanValue = boolD != null ? boolD.booleanValue() : true;
        CustomDressViewModel customDressViewModel2 = this.f20846w;
        if (customDressViewModel2 == null) {
            h.i("mViewModel");
            throw null;
        }
        Integer numD = customDressViewModel2.f20913D.d();
        int iIntValue = numD != null ? numD.intValue() : 0;
        if (zBooleanValue) {
            COUIMenuPreference cOUIMenuPreference = this.f20835F;
            if (cOUIMenuPreference != null) {
                cOUIMenuPreference.h(iIntValue != 2 ? iIntValue != 3 ? iIntValue != 4 ? getString(R.string.melody_ui_custom_dress_select_default) : getString(R.string.melody_ui_custom_dress_select_below) : getString(R.string.melody_ui_custom_dress_select_upper_right_corner) : getString(R.string.melody_ui_custom_dress_select_upper_left_corner));
            }
        } else {
            COUIMenuPreference cOUIMenuPreference2 = this.f20835F;
            if (cOUIMenuPreference2 != null) {
                cOUIMenuPreference2.h(getString(R.string.melody_ui_custom_dress_select_no_show));
            }
        }
        COUIMenuPreference cOUIMenuPreference3 = this.f20835F;
        if (cOUIMenuPreference3 != null) {
            cOUIMenuPreference3.setAssignment(cOUIMenuPreference3 != null ? cOUIMenuPreference3.f14646q : null);
        }
    }

    public final void v() {
        CustomDressViewModel customDressViewModel = this.f20846w;
        if (customDressViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        Boolean boolD = customDressViewModel.f20910A.d();
        boolean zBooleanValue = boolD != null ? boolD.booleanValue() : true;
        CustomDressViewModel customDressViewModel2 = this.f20846w;
        if (customDressViewModel2 == null) {
            h.i("mViewModel");
            throw null;
        }
        String strD = customDressViewModel2.f20939z.d();
        if (!zBooleanValue) {
            COUIMenuPreference cOUIMenuPreference = this.f20833D;
            if (cOUIMenuPreference != null) {
                cOUIMenuPreference.h(getString(R.string.melody_ui_custom_dress_select_no_show));
            }
            COUIMenuPreference cOUIMenuPreference2 = this.f20833D;
            if (cOUIMenuPreference2 != null) {
                cOUIMenuPreference2.setAssignment(cOUIMenuPreference2 != null ? cOUIMenuPreference2.f14646q : null);
                return;
            }
            return;
        }
        if (strD == null || strD.equals("")) {
            COUIMenuPreference cOUIMenuPreference3 = this.f20833D;
            if (cOUIMenuPreference3 != null) {
                cOUIMenuPreference3.h(getString(R.string.melody_ui_custom_dress_select_default_prompt));
            }
            COUIMenuPreference cOUIMenuPreference4 = this.f20833D;
            if (cOUIMenuPreference4 != null) {
                cOUIMenuPreference4.setAssignment(cOUIMenuPreference4 != null ? cOUIMenuPreference4.f14646q : null);
                return;
            }
            return;
        }
        COUIMenuPreference cOUIMenuPreference5 = this.f20833D;
        if (cOUIMenuPreference5 != null) {
            cOUIMenuPreference5.h(getString(R.string.melody_ui_custom_dress_select_custom_prompt));
        }
        COUIMenuPreference cOUIMenuPreference6 = this.f20833D;
        if (cOUIMenuPreference6 != null) {
            cOUIMenuPreference6.setAssignment(strD);
        }
    }

    public final String w(long j5) {
        if (j5 == 0) {
            String string = getString(R.string.melody_ui_custom_dress_select_display_time0);
            h.d(string, "getString(...)");
            return string;
        }
        if (j5 == 1000) {
            String string2 = getString(R.string.melody_ui_custom_dress_select_display_time1);
            h.d(string2, "getString(...)");
            return string2;
        }
        if (j5 == 2000) {
            String string3 = getString(R.string.melody_ui_custom_dress_select_display_time2);
            h.d(string3, "getString(...)");
            return string3;
        }
        if (j5 == 3000) {
            String string4 = getString(R.string.melody_ui_custom_dress_select_display_time3);
            h.d(string4, "getString(...)");
            return string4;
        }
        if (j5 == 4000) {
            String string5 = getString(R.string.melody_ui_custom_dress_select_display_time4);
            h.d(string5, "getString(...)");
            return string5;
        }
        if (j5 == 5000) {
            String string6 = getString(R.string.melody_ui_custom_dress_select_display_time5);
            h.d(string6, "getString(...)");
            return string6;
        }
        if (j5 == 6000) {
            String string7 = getString(R.string.melody_ui_custom_dress_select_display_time6);
            h.d(string7, "getString(...)");
            return string7;
        }
        if (j5 == 7000) {
            String string8 = getString(R.string.melody_ui_custom_dress_select_display_time7);
            h.d(string8, "getString(...)");
            return string8;
        }
        String string9 = getString(R.string.melody_ui_custom_dress_select_display_time0);
        h.d(string9, "getString(...)");
        return string9;
    }

    /* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            Handler handler = o0.c.f1143a;
            N0 n02 = CustomAdjustPreferenceFragment.this.f20842N;
            handler.removeCallbacks(n02);
            handler.postDelayed(n02, 500L);
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: compiled from: CustomAdjustPreferenceFragment.kt */
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            CustomAdjustPreferenceFragment customAdjustPreferenceFragment = CustomAdjustPreferenceFragment.this;
            EditText editText = customAdjustPreferenceFragment.f20837I;
            CharSequence text = editText != null ? editText.getText() : null;
            Button button = customAdjustPreferenceFragment.H;
            if (button != null) {
                if (text == null) {
                    text = "";
                }
                button.setEnabled(text.length() > 0);
            }
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if ((charSequence != null ? charSequence.length() : 0) > 20) {
                String strValueOf = String.valueOf(charSequence);
                CustomAdjustPreferenceFragment customAdjustPreferenceFragment = CustomAdjustPreferenceFragment.this;
                EditText editText = customAdjustPreferenceFragment.f20837I;
                if (editText != null) {
                    String strSubstring = strValueOf.substring(0, i10);
                    h.d(strSubstring, "substring(...)");
                    String strSubstring2 = strValueOf.substring(i10 + i12);
                    h.d(strSubstring2, "substring(...)");
                    editText.setText(strSubstring.concat(strSubstring2));
                }
                E8.a.S(customAdjustPreferenceFragment.getActivity(), R.string.melody_ui_equalizer_custom_name_len_limit_tip);
            }
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
