package com.oplus.melody.ui.component.detail.highaudio;

import D7.C0379m;
import F8.b;
import Wb.l;
import X.d;
import a9.C0531H;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.i;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.media3.session.q1;
import androidx.preference.PreferenceCategory;
import androidx.preference.SwitchPreference;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.RunnableC0903i;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.component.detail.highaudio.HighAudioPreferenceFragment;
import com.oplus.melody.ui.component.detail.highaudio.HighAudioViewModel;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import e9.C1017a;
import g0.C1064c;
import g0.e;
import g9.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import r9.C1479c;
import v9.C1582a;
import v9.c;
import v9.g;

/* JADX INFO: compiled from: HighAudioPreferenceFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0016\u0010 \u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0018H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/oplus/melody/ui/component/detail/highaudio/HighAudioPreferenceFragment;", "Lcom/oplus/melody/ui/base/BaseCOUIPreferenceFragment;", "<init>", "()V", "mCodecCategory", "Landroidx/preference/PreferenceCategory;", "mHiresSwitchCategory", "mHiresSwitchPreference", "Landroidx/preference/SwitchPreference;", "mCodecListViewModel", "Lcom/oplus/melody/ui/component/detail/highaudio/HighAudioViewModel;", "address", "", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "onCreate", "onViewCreated", "view", "Landroid/view/View;", "onCheckCodecTypeChanged", "codecType", "", "onHiResStatusChanged", "hiResVO", "Lcom/oplus/melody/ui/component/detail/highaudio/HiResVO;", "refreshHiResSwitch", "onCodecListChanged", "codecVO", "Lcom/oplus/melody/ui/component/detail/highaudio/CodecVO;", "refreshCodecList", "list", "", "Lcom/oplus/melody/ui/component/detail/highaudio/CodecItem;", "onConnectionChanged", "state", "mRadioPreferenceChangeListener", "Landroidx/preference/Preference$OnPreferenceChangeListener;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HighAudioPreferenceFragment extends b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public PreferenceCategory f21084A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public SwitchPreference f21085B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public HighAudioViewModel f21086C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public String f21087D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final q1 f21088E = new q1(this, 24);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PreferenceCategory f21089z;

    /* JADX INFO: compiled from: HighAudioPreferenceFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21090a;

        public a(l lVar) {
            this.f21090a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21090a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21090a.d(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        O7.l<Integer> lVar;
        super.onCreate(savedInstanceState);
        Fragment parentFragment = getParentFragment();
        h.c(parentFragment, "null cannot be cast to non-null type com.oplus.melody.ui.component.detail.highaudio.HighAudioDetailFragment");
        g gVar = (g) parentFragment;
        this.f21087D = gVar.f28410q;
        androidx.fragment.app.f activity = getActivity();
        if (activity == null || this.f21087D == null) {
            A.h("HighAudioPreferenceFragment", "onCreate act is null");
            return;
        }
        this.f21089z = (PreferenceCategory) a("key_high_audio_codec_list_category");
        this.f21084A = (PreferenceCategory) a("key_high_audio_hires_switch_category");
        this.f21085B = (SwitchPreference) a("key_high_audio_hires_switch");
        O store = gVar.getViewModelStore();
        N.b factory = gVar.getDefaultViewModelProviderFactory();
        W.a defaultViewModelCreationExtras = gVar.getDefaultViewModelCreationExtras();
        h.e(store, "store");
        h.e(factory, "factory");
        d dVarB = A6.g.b(defaultViewModelCreationExtras, "defaultCreationExtras", store, factory, defaultViewModelCreationExtras);
        kotlin.jvm.internal.b bVarA = j.a(HighAudioViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f21086C = (HighAudioViewModel) dVarB.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        SwitchPreference switchPreference = this.f21085B;
        if (switchPreference != null) {
            switchPreference.setOnPreferenceChangeListener(new t(this, 9));
        }
        HighAudioViewModel highAudioViewModel = this.f21086C;
        if (highAudioViewModel != null) {
            String str = this.f21087D;
            h.b(str);
            final int i10 = 0;
            C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new t(highAudioViewModel, 10))).e(activity, new a(new l(this) { // from class: v9.h

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ HighAudioPreferenceFragment f28419b;

                {
                    this.f28419b = this;
                }

                @Override // Wb.l
                public final Object d(Object obj) {
                    switch (i10) {
                        case 0:
                            d hiResVO = (d) obj;
                            kotlin.jvm.internal.h.e(hiResVO, "hiResVO");
                            HighAudioPreferenceFragment highAudioPreferenceFragment = this.f28419b;
                            Fragment parentFragment2 = highAudioPreferenceFragment.getParentFragment();
                            kotlin.jvm.internal.h.c(parentFragment2, "null cannot be cast to non-null type com.oplus.melody.ui.component.detail.highaudio.HighAudioDetailFragment");
                            boolean z2 = ((g) parentFragment2).f28413t;
                            A.c("HighAudioPreferenceFragment", new D6.b(hiResVO, z2, 12));
                            if (!z2) {
                                HighAudioViewModel highAudioViewModel2 = highAudioPreferenceFragment.f21086C;
                                List<C1582a> list = highAudioViewModel2 != null ? highAudioViewModel2.h : null;
                                if (list != null) {
                                    int size = list.size();
                                    int i11 = 0;
                                    while (true) {
                                        if (i11 < size) {
                                            if (list.get(i11).f28400a == hiResVO.getCodecType()) {
                                                HighAudioViewModel highAudioViewModel3 = highAudioPreferenceFragment.f21086C;
                                                if (highAudioViewModel3 != null) {
                                                    highAudioViewModel3.e(i11);
                                                }
                                            } else {
                                                i11++;
                                            }
                                        }
                                    }
                                }
                                highAudioPreferenceFragment.t(hiResVO.getCodecType());
                                SwitchPreference switchPreference2 = highAudioPreferenceFragment.f21085B;
                                if (switchPreference2 != null) {
                                    switchPreference2.setChecked(hiResVO.getHiResOpened());
                                }
                            }
                            break;
                        default:
                            int iIntValue = ((Integer) obj).intValue();
                            HighAudioPreferenceFragment highAudioPreferenceFragment2 = this.f28419b;
                            if (iIntValue == 2) {
                                PreferenceCategory preferenceCategory = highAudioPreferenceFragment2.f21089z;
                                if (preferenceCategory != null) {
                                    preferenceCategory.setEnabled(true);
                                }
                                SwitchPreference switchPreference3 = highAudioPreferenceFragment2.f21085B;
                                if (switchPreference3 != null) {
                                    switchPreference3.setEnabled(true);
                                }
                            } else {
                                PreferenceCategory preferenceCategory2 = highAudioPreferenceFragment2.f21089z;
                                if (preferenceCategory2 != null) {
                                    preferenceCategory2.setEnabled(false);
                                }
                                SwitchPreference switchPreference4 = highAudioPreferenceFragment2.f21085B;
                                if (switchPreference4 != null) {
                                    switchPreference4.setEnabled(false);
                                }
                            }
                            break;
                    }
                    return Jb.l.f2618a;
                }
            }));
        }
        HighAudioViewModel highAudioViewModel2 = this.f21086C;
        if (highAudioViewModel2 != null && (lVar = highAudioViewModel2.f21094e) != null) {
            lVar.e(activity, new a(new C1017a(this, 9)));
        }
        if (this.f21086C != null) {
            String str2 = this.f21087D;
            h.b(str2);
            c cVar = (c) C0379m.b(C0379m.g(AbstractC0939b.E().v(str2), new e(23))).d();
            if (cVar != null) {
                A.b("HighAudioPreferenceFragment", "onCreate getCodecList");
                s(cVar);
            }
        }
        if (this.f21086C != null) {
            String str3 = this.f21087D;
            h.b(str3);
            C0379m.b(C0379m.g(AbstractC0939b.E().v(str3), new e(23))).e(activity, new a(new C0531H(this, 20)));
        }
        if (this.f21086C != null) {
            String str4 = this.f21087D;
            h.b(str4);
            C0379m.b(C0379m.g(AbstractC0939b.E().v(str4), new e(24))).e(activity, new a(new C1479c(this, 3)));
        }
        if (this.f21086C != null) {
            String str5 = this.f21087D;
            h.b(str5);
            final int i11 = 1;
            C0379m.b(C0379m.g(AbstractC0939b.E().v(str5), new C1064c(27))).e(activity, new a(new l(this) { // from class: v9.h

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ HighAudioPreferenceFragment f28419b;

                {
                    this.f28419b = this;
                }

                @Override // Wb.l
                public final Object d(Object obj) {
                    switch (i11) {
                        case 0:
                            d hiResVO = (d) obj;
                            kotlin.jvm.internal.h.e(hiResVO, "hiResVO");
                            HighAudioPreferenceFragment highAudioPreferenceFragment = this.f28419b;
                            Fragment parentFragment2 = highAudioPreferenceFragment.getParentFragment();
                            kotlin.jvm.internal.h.c(parentFragment2, "null cannot be cast to non-null type com.oplus.melody.ui.component.detail.highaudio.HighAudioDetailFragment");
                            boolean z2 = ((g) parentFragment2).f28413t;
                            A.c("HighAudioPreferenceFragment", new D6.b(hiResVO, z2, 12));
                            if (!z2) {
                                HighAudioViewModel highAudioViewModel22 = highAudioPreferenceFragment.f21086C;
                                List<C1582a> list = highAudioViewModel22 != null ? highAudioViewModel22.h : null;
                                if (list != null) {
                                    int size = list.size();
                                    int i112 = 0;
                                    while (true) {
                                        if (i112 < size) {
                                            if (list.get(i112).f28400a == hiResVO.getCodecType()) {
                                                HighAudioViewModel highAudioViewModel3 = highAudioPreferenceFragment.f21086C;
                                                if (highAudioViewModel3 != null) {
                                                    highAudioViewModel3.e(i112);
                                                }
                                            } else {
                                                i112++;
                                            }
                                        }
                                    }
                                }
                                highAudioPreferenceFragment.t(hiResVO.getCodecType());
                                SwitchPreference switchPreference2 = highAudioPreferenceFragment.f21085B;
                                if (switchPreference2 != null) {
                                    switchPreference2.setChecked(hiResVO.getHiResOpened());
                                }
                            }
                            break;
                        default:
                            int iIntValue = ((Integer) obj).intValue();
                            HighAudioPreferenceFragment highAudioPreferenceFragment2 = this.f28419b;
                            if (iIntValue == 2) {
                                PreferenceCategory preferenceCategory = highAudioPreferenceFragment2.f21089z;
                                if (preferenceCategory != null) {
                                    preferenceCategory.setEnabled(true);
                                }
                                SwitchPreference switchPreference3 = highAudioPreferenceFragment2.f21085B;
                                if (switchPreference3 != null) {
                                    switchPreference3.setEnabled(true);
                                }
                            } else {
                                PreferenceCategory preferenceCategory2 = highAudioPreferenceFragment2.f21089z;
                                if (preferenceCategory2 != null) {
                                    preferenceCategory2.setEnabled(false);
                                }
                                SwitchPreference switchPreference4 = highAudioPreferenceFragment2.f21085B;
                                if (switchPreference4 != null) {
                                    switchPreference4.setEnabled(false);
                                }
                            }
                            break;
                    }
                    return Jb.l.f2618a;
                }
            }));
        }
        if (this.f21086C != null) {
            AbstractC0939b.E().D(this.f21087D);
        }
        if (this.f21086C != null) {
            AbstractC0939b.E().t(this.f21087D);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() == 16908332) {
            A.b("HighAudioPreferenceFragment", "onOptionsItemSelected home");
            androidx.fragment.app.f activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // F8.b, com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.tool_bar);
        h.d(viewFindViewById, "findViewById(...)");
        androidx.fragment.app.f activity = getActivity();
        h.c(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        i iVar = (i) activity;
        iVar.y((MelodyCompatToolbar) viewFindViewById);
        androidx.appcompat.app.a aVarX = iVar.x();
        if (aVarX != null) {
            aVarX.t(R.string.melody_common_high_audio_title);
        }
        setHasOptionsMenu(true);
        androidx.appcompat.app.a aVarX2 = iVar.x();
        if (aVarX2 != null) {
            aVarX2.n(true);
        }
        androidx.appcompat.app.a aVarX3 = iVar.x();
        if (aVarX3 != null) {
            aVarX3.r(true);
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        o(R.xml.melody_ui_high_audio_preference);
    }

    public final void s(c cVar) {
        A.f("HighAudioPreferenceFragment", "onCodecListChanged: " + cVar.getCodecList());
        HighAudioViewModel highAudioViewModel = this.f21086C;
        if (highAudioViewModel != null) {
            List<C1582a> codecList = cVar.getCodecList();
            h.e(codecList, "<set-?>");
            highAudioViewModel.h = codecList;
        }
        View view = getView();
        if (view != null) {
            view.post(new RunnableC0903i(15, this, cVar));
        }
    }

    public final void t(int i10) {
        PreferenceCategory preferenceCategory = this.f21084A;
        if (preferenceCategory != null) {
            preferenceCategory.setVisible(i10 == 3 || i10 == 8);
        }
    }
}
