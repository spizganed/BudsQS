package com.oplus.melody.ui.component.detail.personalnoise;

import D7.C0370d;
import D7.C0379m;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.s;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import com.heytap.headset.R;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;

/* JADX INFO: compiled from: PersonalizedNoiseCheckDialogFragment.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f21178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DetailMainViewModel f21180c;

    /* JADX INFO: compiled from: PersonalizedNoiseCheckDialogFragment.java */
    public class a extends c.s {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.f f21181d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(androidx.appcompat.app.f fVar) {
            super(true);
            this.f21181d = fVar;
        }

        @Override // c.s
        public final void b() {
            e eVar = h.this.f21178a;
            if (eVar != null) {
                eVar.f21175a.cancelCheck();
            } else {
                C0370d.a(new com.oplus.melody.ui.component.detail.personalnoise.a(3));
            }
            this.f21181d.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0586b, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.fragment.app.f owner = getActivity();
        kotlin.jvm.internal.h.e(owner, "owner");
        O viewModelStore = owner.getViewModelStore();
        N.b defaultViewModelProviderFactory = owner.getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, owner.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(DetailMainViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f21180c = (DetailMainViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
    }

    @Override // androidx.appcompat.app.s, androidx.fragment.app.DialogInterfaceOnCancelListenerC0586b
    public final Dialog onCreateDialog(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("key_address");
            this.f21179b = string;
            if (!TextUtils.isEmpty(string)) {
                this.f21180c.e(this.f21179b);
            }
            this.f21180c.d(this.f21179b).e(this, new C6.e(this, 25));
            DetailMainViewModel detailMainViewModel = this.f21180c;
            String str = this.f21179b;
            detailMainViewModel.getClass();
            C0379m.b(AbstractC0939b.E().G(str)).e(getActivity(), new E9.a(this, 10));
        }
        androidx.fragment.app.f context = getActivity();
        String string2 = getActivity().getString(R.string.melody_ui_personalized_noise_reduction_checking);
        kotlin.jvm.internal.h.e(context, "context");
        R1.l lVar = new R1.l(context, string2);
        lVar.h = true;
        androidx.appcompat.app.f fVarA = lVar.a();
        fVarA.setCancelable(true);
        fVarA.setOnCancelListener(null);
        fVarA.setCanceledOnTouchOutside(false);
        fVarA.getOnBackPressedDispatcher().a(this, new a(fVarA));
        return fVarA;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0586b, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("key_address", this.f21179b);
    }
}
