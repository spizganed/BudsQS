package com.oplus.melody.ui.component.detail.personalnoise;

import D7.C0370d;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.s;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.component.detail.personalnoise.PersonalNoiseItem;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f21194b;

    public /* synthetic */ l(s sVar, int i10) {
        this.f21193a = i10;
        this.f21194b = sVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f21193a) {
            case 0:
                m mVar = (m) this.f21194b;
                A.c("PersonalizedNoiseFailedDialogFragment", new com.oplus.melody.model.db.s(mVar, 4));
                PersonalNoiseItem.c cVar = mVar.f21197c;
                if (cVar == null) {
                    A.b("PersonalizedNoiseFailedDialogFragment", "onStart: mOnClickListener is null...");
                    if (!mVar.f21199q) {
                        String string = mVar.getContext().getString(R.string.melody_ui_personalized_noise_reduction_wear_check);
                        Toast toast = mVar.f21198p;
                        if (toast != null) {
                            toast.cancel();
                        }
                        Toast toastMakeText = Toast.makeText(mVar.getContext().getApplicationContext(), string, 0);
                        mVar.f21198p = toastMakeText;
                        toastMakeText.show();
                        A.b("PersonalizedNoiseFailedDialogFragment", "onRetry: !mBothInEar warm...");
                    } else {
                        C0370d.a(new a(1));
                        mVar.dismiss();
                    }
                } else {
                    A.b(PersonalNoiseItem.ITEM_NAME, "onPositiveButtonClick: start recheck ...");
                    PersonalNoiseItem.this.onRetry();
                }
                break;
            default:
                n nVar = (n) this.f21194b;
                PersonalNoiseItem.b bVar = nVar.f21202a;
                if (bVar != null) {
                    PersonalNoiseItem.this.onRetry();
                } else if (!nVar.f21205p) {
                    String string2 = nVar.getContext().getString(R.string.melody_ui_personalized_noise_reduction_wear_check);
                    Toast toast2 = nVar.f21206q;
                    if (toast2 != null) {
                        toast2.cancel();
                    }
                    Toast toastMakeText2 = Toast.makeText(nVar.getContext().getApplicationContext(), string2, 0);
                    nVar.f21206q = toastMakeText2;
                    toastMakeText2.show();
                    A.b("PersonalizedNoiseNotExistDialogFragment", "onRetry: !mBothInEar warm...");
                } else {
                    C0370d.a(new a(1));
                    nVar.dismiss();
                }
                break;
        }
    }
}
