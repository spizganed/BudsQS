package com.oplus.melody.ui.component.detail.personalnoise;

import E9.o;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.s;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.detail.personalnoise.PersonalNoiseItem;

/* JADX INFO: compiled from: PersonalizedNoiseExistDialogFragment.java */
/* JADX INFO: loaded from: classes3.dex */
public class j extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.appcompat.app.f f21185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PersonalNoiseItem.a f21186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21187c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DetailMainViewModel f21188p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f21189q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Toast f21190r;

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
        this.f21188p = (DetailMainViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
    }

    @Override // androidx.appcompat.app.s, androidx.fragment.app.DialogInterfaceOnCancelListenerC0586b
    public final Dialog onCreateDialog(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("key_address");
            this.f21187c = string;
            if (!TextUtils.isEmpty(string)) {
                this.f21188p.e(this.f21187c);
            }
            this.f21188p.m(this.f21187c).e(this, new A6.l(this, 19));
            this.f21188p.d(this.f21187c).e(this, new i(this, 0));
        }
        G7.b bVar = new G7.b(getActivity());
        bVar.n(R.string.melody_ui_personalized_noise_reduction_use_exist_title);
        bVar.f(R.string.melody_ui_personalized_noise_reduction_use_exist_info);
        bVar.l(R.string.melody_ui_personalized_noise_reduction_direct_use, new H8.f(this, 8));
        bVar.h(R.string.melody_ui_personalized_noise_reduction_recheck, null);
        this.f21185a = bVar.create();
        A.b("PersonalizedNoiseExistDialogFragment", "onCreateDialog: ");
        this.f21185a.setCanceledOnTouchOutside(false);
        return this.f21185a;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Toast toast = this.f21190r;
        if (toast != null) {
            toast.cancel();
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0586b, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("key_address", this.f21187c);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0586b, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((androidx.appcompat.app.f) getDialog()).d(-2).setOnClickListener(new o(this, 14));
    }
}
