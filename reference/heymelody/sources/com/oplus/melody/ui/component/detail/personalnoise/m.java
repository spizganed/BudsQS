package com.oplus.melody.ui.component.detail.personalnoise;

import I8.DialogInterfaceOnClickListenerC0428d;
import android.app.Dialog;
import android.content.Context;
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

/* JADX INFO: compiled from: PersonalizedNoiseFailedDialogFragment.java */
/* JADX INFO: loaded from: classes3.dex */
public class m extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.appcompat.app.f f21195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21196b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PersonalNoiseItem.c f21197c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Toast f21198p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f21199q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DetailMainViewModel f21200r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f21201s;

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0586b, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        A.b("PersonalizedNoiseFailedDialogFragment", "onCreate: ");
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
        this.f21200r = (DetailMainViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
    }

    @Override // androidx.appcompat.app.s, androidx.fragment.app.DialogInterfaceOnCancelListenerC0586b
    public final Dialog onCreateDialog(Bundle bundle) {
        if (bundle != null) {
            this.f21196b = bundle.getInt("key_noise_result", 0);
            String string = bundle.getString("key_address");
            this.f21201s = string;
            if (!TextUtils.isEmpty(string)) {
                this.f21200r.e(this.f21201s);
            }
            this.f21200r.m(this.f21201s).e(this, new i(this, 1));
            this.f21200r.d(this.f21201s).e(this, new C6.e(this, 26));
        }
        G7.b bVar = new G7.b(getActivity());
        bVar.n(R.string.melody_ui_personalized_noise_reduction_check_failed);
        bVar.l(R.string.melody_ui_personalized_noise_reduction_check_retry, null);
        bVar.h(R.string.melody_ui_personalized_noise_reduction_check_give_up, new DialogInterfaceOnClickListenerC0428d(this, 8));
        this.f21195a = bVar.setCancelable(false).create();
        A.c("PersonalizedNoiseFailedDialogFragment", new k(this, 0));
        Context context = getContext();
        if (context != null && this.f21196b != 0) {
            A.c("PersonalizedNoiseFailedDialogFragment", new X3.l(this, 16));
            int i10 = this.f21196b;
            if (i10 == 1) {
                this.f21195a.e(context.getString(R.string.melody_ui_personalized_noise_reduction_ear_check_fail_three));
            } else if (i10 == 2) {
                this.f21195a.e(context.getString(R.string.melody_ui_personalized_noise_reduction_ear_check_fail_five));
            } else if (i10 == 3) {
                this.f21195a.e(context.getString(R.string.melody_ui_personalized_noise_reduction_ear_check_fail_four));
            } else if (i10 == 4) {
                this.f21195a.e(context.getString(R.string.melody_ui_personalized_noise_reduction_ear_check_fail_two));
            } else if (i10 == 5) {
                this.f21195a.e(context.getString(R.string.melody_ui_personalized_noise_reduction_ear_check_fail_one));
            }
        }
        return this.f21195a;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Toast toast = this.f21198p;
        if (toast != null) {
            toast.cancel();
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0586b, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("key_address", this.f21201s);
        bundle.putInt("key_noise_result", this.f21196b);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0586b, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((androidx.appcompat.app.f) getDialog()).d(-1).setOnClickListener(new l(this, 0));
    }
}
