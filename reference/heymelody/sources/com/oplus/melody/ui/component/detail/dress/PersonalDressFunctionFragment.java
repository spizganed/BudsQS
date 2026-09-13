package com.oplus.melody.ui.component.detail.dress;

import A6.b;
import D7.C0379m;
import Wb.l;
import X.d;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.K;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.g;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.ui.widget.MelodyTagJumpPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import n8.AbstractC1353a;
import n8.g;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: PersonalDressFunctionFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/PersonalDressFunctionFragment;", "Lcom/coui/appcompat/preference/COUIPreferenceFragment;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/dress/PersonalDressViewModel;", "mCustomDressPreference", "Lcom/coui/appcompat/preference/COUIJumpPreference;", "mCarouselDressPreference", "Lcom/oplus/melody/ui/widget/MelodyTagJumpPreference;", "mExistCarousel", "", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", "view", "Landroid/view/View;", "onExistCarouselChanged", "existCarousel", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PersonalDressFunctionFragment extends g {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public PersonalDressViewModel f20723w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public COUIJumpPreference f20724x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public MelodyTagJumpPreference f20725y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f20726z;

    /* JADX INFO: compiled from: PersonalDressFunctionFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20727a;

        public a(l lVar) {
            this.f20727a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20727a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20727a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.PersonalDressFunctionFragment$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: PersonalDressFunctionFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/oplus/melody/ui/component/detail/dress/PersonalDressFunctionFragment$onViewCreated$1", "Landroidx/recyclerview/widget/LinearLayoutManager;", "canScrollVertically", "", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends LinearLayoutManager {
        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
        public final boolean q() {
            return false;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.PersonalDressFunctionFragment$onViewCreated$3, reason: invalid class name */
    /* JADX INFO: compiled from: PersonalDressFunctionFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements l<Boolean, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Boolean bool) {
            ((PersonalDressFunctionFragment) this.receiver).f20726z = bool.booleanValue();
            return Jb.l.f2618a;
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        PersonalDressFunctionFragment personalDressFunctionFragment;
        String str;
        WhitelistConfigDTO.Function function;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = this.f11714c;
        getActivity();
        recyclerView.setLayoutManager(new AnonymousClass1(1));
        androidx.fragment.app.f activity = getActivity();
        if (activity != null) {
            O viewModelStore = activity.getViewModelStore();
            N.b defaultViewModelProviderFactory = activity.getDefaultViewModelProviderFactory();
            d dVarC = b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, activity.getDefaultViewModelCreationExtras());
            kotlin.jvm.internal.b bVarA = j.a(PersonalDressViewModel.class);
            String strA = bVarA.a();
            if (strA == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            this.f20723w = (PersonalDressViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
            AbstractC1508a abstractC1508aF = AbstractC1508a.f();
            PersonalDressViewModel personalDressViewModel = this.f20723w;
            WhitelistConfigDTO whitelistConfigDTOC = abstractC1508aF.c(personalDressViewModel != null ? personalDressViewModel.f20757d : null, personalDressViewModel != null ? personalDressViewModel.f20756c : null);
            boolean zE = Y.e((whitelistConfigDTOC == null || (function = whitelistConfigDTOC.getFunction()) == null) ? -1 : function.getCarouselDress(), false);
            MelodyTagJumpPreference melodyTagJumpPreference = this.f20725y;
            if (melodyTagJumpPreference != null) {
                melodyTagJumpPreference.setVisible(zE);
            }
            if (zE) {
                PersonalDressViewModel personalDressViewModel2 = this.f20723w;
                if (personalDressViewModel2 != null) {
                    Object obj = AbstractC1353a.f26467c;
                    personalDressFunctionFragment = this;
                    C0379m.g(K.a(AbstractC1353a.C0292a.a().c(personalDressViewModel2.f20758e, personalDressViewModel2.f20757d)), new A6.f(27)).e(getViewLifecycleOwner(), new a(new AnonymousClass3(1, personalDressFunctionFragment, PersonalDressFunctionFragment.class, "onExistCarouselChanged", "onExistCarouselChanged(Z)V", 0)));
                } else {
                    personalDressFunctionFragment = this;
                }
                PersonalDressViewModel personalDressViewModel3 = personalDressFunctionFragment.f20723w;
                if (personalDressViewModel3 == null || (str = personalDressViewModel3.f20755b) == null) {
                    return;
                }
                Object obj2 = n8.g.f26485c;
                g.a.a().d(str).e(getViewLifecycleOwner(), new a(new B9.d(this, 24)));
            }
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        o(R.xml.melody_ui_dress_function_preference);
        this.f20724x = (COUIJumpPreference) a("custom_dress");
        this.f20725y = (MelodyTagJumpPreference) a("carousel_dress");
        COUIJumpPreference cOUIJumpPreference = this.f20724x;
        if (cOUIJumpPreference != null) {
            cOUIJumpPreference.setOnPreferenceClickListener(new C0.a(this, 20));
        }
        MelodyTagJumpPreference melodyTagJumpPreference = this.f20725y;
        if (melodyTagJumpPreference != null) {
            melodyTagJumpPreference.setOnPreferenceClickListener(new E9.h(this, 10));
        }
    }
}
