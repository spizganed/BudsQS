package com.oplus.melody.ui.component.detail.dress.carousel;

import Ca.n;
import D7.o0;
import E9.t;
import G8.k;
import Wb.l;
import X.d;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.f;
import androidx.appcompat.app.i;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.K;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.s;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.preference.COUIInputPreference;
import com.coui.appcompat.preference.COUIMenuPreference;
import com.coui.appcompat.preference.g;
import com.heytap.headset.R;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.ui.widget.MelodyDraggableListPreference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: CarouselDressEditFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005*\u0001(\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010!\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J\b\u0010*\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)¨\u0006,"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressEditFragment;", "Lcom/coui/appcompat/preference/COUIPreferenceFragment;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressEditViewModel;", "mNameInputPreference", "Lcom/coui/appcompat/preference/COUIInputPreference;", "mCyclePreference", "Lcom/coui/appcompat/preference/COUIMenuPreference;", "mSelectedListPreference", "Lcom/oplus/melody/ui/widget/MelodyDraggableListPreference;", "mNameEditText", "Lcom/coui/appcompat/edittext/COUIEditText;", "mExitConfirmDialog", "Landroidx/appcompat/app/AlertDialog;", "mUpdateNameRunnable", "Ljava/lang/Runnable;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", "view", "Landroid/view/View;", "initDraggableList", "onNameChanged", "name", "onCycleTypeChanged", SpeechFindManager.TYPE, "", "onSelectedListChanged", "selectedThemes", "", "Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressSelectVO;", "preferenceChangeListener", "Landroidx/preference/Preference$OnPreferenceChangeListener;", "mNameTextWatcher", "com/oplus/melody/ui/component/detail/dress/carousel/CarouselDressEditFragment$mNameTextWatcher$1", "Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressEditFragment$mNameTextWatcher$1;", "showExitConfirmDialog", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CarouselDressEditFragment extends g {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public COUIEditText f20773A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public f f20774B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final t f20775C = new t(this, 29);

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final n f20776D = new n(this, 21);

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final a f20777E = new a();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CarouselDressEditViewModel f20778w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public COUIInputPreference f20779x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public COUIMenuPreference f20780y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public MelodyDraggableListPreference f20781z;

    /* JADX INFO: compiled from: CarouselDressEditFragment.kt */
    public static final class b extends s {
        public b() {
            super(true);
        }

        @Override // c.s
        public final void b() {
            CarouselDressEditFragment carouselDressEditFragment = CarouselDressEditFragment.this;
            androidx.fragment.app.f activity = carouselDressEditFragment.getActivity();
            if (activity == null) {
                return;
            }
            f fVar = carouselDressEditFragment.f20774B;
            if (fVar == null || !fVar.isShowing()) {
                G7.b bVar = new G7.b(activity);
                bVar.n(R.string.melody_common_carousel_dress_exit_create_confirm_title);
                bVar.h(R.string.melody_ui_common_cancel, new k(4));
                bVar.l(R.string.melody_ui_common_exit, new H8.f(carouselDressEditFragment, 6));
                carouselDressEditFragment.f20774B = bVar.show();
            }
        }
    }

    /* JADX INFO: compiled from: CarouselDressEditFragment.kt */
    public static final class c implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20784a;

        public c(l lVar) {
            this.f20784a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20784a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20784a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.carousel.CarouselDressEditFragment$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: CarouselDressEditFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/oplus/melody/ui/component/detail/dress/carousel/CarouselDressEditFragment$onViewCreated$1", "Landroidx/recyclerview/widget/LinearLayoutManager;", "canScrollVertically", "", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends LinearLayoutManager {
        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
        public final boolean q() {
            return false;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.carousel.CarouselDressEditFragment$onViewCreated$3, reason: invalid class name */
    /* JADX INFO: compiled from: CarouselDressEditFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements l<String, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(String str) {
            COUIEditText cOUIEditText;
            String p02 = str;
            h.e(p02, "p0");
            CarouselDressEditFragment carouselDressEditFragment = (CarouselDressEditFragment) this.receiver;
            COUIEditText cOUIEditText2 = carouselDressEditFragment.f20773A;
            if (!h.a(p02, String.valueOf(cOUIEditText2 != null ? cOUIEditText2.getText() : null)) && (cOUIEditText = carouselDressEditFragment.f20773A) != null) {
                cOUIEditText.setText(p02);
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.dress.carousel.CarouselDressEditFragment$onViewCreated$4, reason: invalid class name */
    /* JADX INFO: compiled from: CarouselDressEditFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            int iIntValue = num.intValue();
            CarouselDressEditFragment carouselDressEditFragment = (CarouselDressEditFragment) this.receiver;
            String string = iIntValue != 0 ? (iIntValue == 1 || iIntValue != 2) ? carouselDressEditFragment.getString(R.string.melody_common_carousel_dress_update_cycle_every_day) : carouselDressEditFragment.getString(R.string.melody_common_carousel_dress_update_cycle_every_week) : carouselDressEditFragment.getString(R.string.melody_common_carousel_dress_update_cycle_every_time);
            h.b(string);
            COUIMenuPreference cOUIMenuPreference = carouselDressEditFragment.f20780y;
            if (cOUIMenuPreference != null) {
                cOUIMenuPreference.h(string);
            }
            COUIMenuPreference cOUIMenuPreference2 = carouselDressEditFragment.f20780y;
            if (cOUIMenuPreference2 != null) {
                cOUIMenuPreference2.setAssignment(cOUIMenuPreference2.f14646q);
            }
            return Jb.l.f2618a;
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        u<List<b9.v>> uVar;
        u<Integer> uVar2;
        u<String> uVar3;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.f11714c.setNestedScrollingEnabled(false);
        RecyclerView recyclerView = this.f11714c;
        getActivity();
        recyclerView.setLayoutManager(new AnonymousClass1(1));
        androidx.fragment.app.f activity = getActivity();
        h.c(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        i iVar = (i) activity;
        O viewModelStore = iVar.getViewModelStore();
        N.b defaultViewModelProviderFactory = iVar.getDefaultViewModelProviderFactory();
        d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, iVar.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(CarouselDressEditViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20778w = (CarouselDressEditViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        COUIInputPreference cOUIInputPreference = this.f20779x;
        COUIEditText cOUIEditText = cOUIInputPreference != null ? cOUIInputPreference.f14589a : null;
        this.f20773A = cOUIEditText;
        if (cOUIEditText != null) {
            cOUIEditText.setInputType(131072 | cOUIEditText.getInputType());
            cOUIEditText.addTextChangedListener(this.f20777E);
            cOUIEditText.setMaxLines(10000);
        }
        COUIMenuPreference cOUIMenuPreference = this.f20780y;
        if (cOUIMenuPreference != null) {
            cOUIMenuPreference.setOnPreferenceChangeListener(this.f20776D);
        }
        MelodyDraggableListPreference melodyDraggableListPreference = this.f20781z;
        if (melodyDraggableListPreference != null) {
            String string = getString(R.string.melody_common_carousel_dress_empty_selected_hint);
            melodyDraggableListPreference.f21838r = string;
            TextView textView = melodyDraggableListPreference.f21834b;
            if (textView != null) {
                textView.setText(string);
            }
            melodyDraggableListPreference.f();
        }
        MelodyDraggableListPreference melodyDraggableListPreference2 = this.f20781z;
        if (melodyDraggableListPreference2 != null) {
            melodyDraggableListPreference2.e(EmptyList.f25350a);
        }
        MelodyDraggableListPreference melodyDraggableListPreference3 = this.f20781z;
        if (melodyDraggableListPreference3 != null) {
            melodyDraggableListPreference3.f21840t = new A9.j(this, 24);
        }
        if (melodyDraggableListPreference3 != null) {
            melodyDraggableListPreference3.f21841u = new H6.a(4);
        }
        CarouselDressEditViewModel carouselDressEditViewModel = this.f20778w;
        if (carouselDressEditViewModel != null && (uVar3 = carouselDressEditViewModel.f20793k) != null) {
            K.a(uVar3).e(getViewLifecycleOwner(), new c(new AnonymousClass3(1, this, CarouselDressEditFragment.class, "onNameChanged", "onNameChanged(Ljava/lang/String;)V", 0)));
        }
        CarouselDressEditViewModel carouselDressEditViewModel2 = this.f20778w;
        if (carouselDressEditViewModel2 != null && (uVar2 = carouselDressEditViewModel2.f20794l) != null) {
            K.a(uVar2).e(getViewLifecycleOwner(), new c(new AnonymousClass4(1, this, CarouselDressEditFragment.class, "onCycleTypeChanged", "onCycleTypeChanged(I)V", 0)));
        }
        CarouselDressEditViewModel carouselDressEditViewModel3 = this.f20778w;
        if (carouselDressEditViewModel3 != null && (uVar = carouselDressEditViewModel3.f20799q) != null) {
            K.a(uVar).e(getViewLifecycleOwner(), new c(new D9.a(this, 21)));
        }
        CarouselDressEditViewModel carouselDressEditViewModel4 = this.f20778w;
        if (carouselDressEditViewModel4 == null || carouselDressEditViewModel4.f20789f >= 0) {
            return;
        }
        c.u onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        InterfaceC0601m viewLifecycleOwner = getViewLifecycleOwner();
        h.d(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.a(viewLifecycleOwner, new b());
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        o(R.xml.melody_ui_carousel_dress_edit_preference);
        this.f20779x = (COUIInputPreference) a("carousel_dress_name_input");
        this.f20780y = (COUIMenuPreference) a("carousel_dress_update_cycle");
        this.f20781z = (MelodyDraggableListPreference) a("carousel_dress_selected_list");
    }

    /* JADX INFO: compiled from: CarouselDressEditFragment.kt */
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            Handler handler = o0.c.f1143a;
            t tVar = CarouselDressEditFragment.this.f20775C;
            handler.removeCallbacks(tVar);
            handler.postDelayed(tVar, 500L);
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
