package com.oplus.melody.ui.component.detail.personalnoise;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.s;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import com.heytap.headset.R;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.detail.personalnoise.PersonalNoiseItem;

/* JADX INFO: compiled from: PersonalizedNoiseNotExistDialogFragment.java */
/* JADX INFO: loaded from: classes3.dex */
public class n extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PersonalNoiseItem.b f21202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DetailMainViewModel f21204c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f21205p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Toast f21206q;

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
        this.f21204c = (DetailMainViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
    }

    @Override // androidx.appcompat.app.s, androidx.fragment.app.DialogInterfaceOnCancelListenerC0586b
    public final Dialog onCreateDialog(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("key_address");
            this.f21203b = string;
            if (!TextUtils.isEmpty(string)) {
                this.f21204c.e(this.f21203b);
            }
            this.f21204c.m(this.f21203b).e(this, new C6.e(this, 27));
            this.f21204c.d(this.f21203b).e(this, new E9.a(this, 11));
        }
        G7.b bVar = new G7.b(getContext());
        bVar.n(R.string.melody_ui_personalized_noise_reduction_ear_check_title);
        bVar.f(R.string.melody_ui_personalized_noise_reduction_ear_check_info_2);
        bVar.l(R.string.melody_ui_personalized_noise_reduction_ear_check_start, null);
        bVar.h(R.string.melody_ui_personalized_noise_reduction_ear_check_cancel, new G8.j(this, 8));
        return bVar.setCancelable(false).create();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Toast toast = this.f21206q;
        if (toast != null) {
            toast.cancel();
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0586b, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("key_address", this.f21203b);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0586b, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((androidx.appcompat.app.f) getDialog()).d(-1).setOnClickListener(new l(this, 1));
    }
}
