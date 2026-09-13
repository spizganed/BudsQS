package com.oplus.melody.ui.component.detail.personalnoise;

import androidx.appcompat.app.s;
import androidx.lifecycle.v;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.EarStatusDTO;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f21184b;

    public /* synthetic */ i(s sVar, int i10) {
        this.f21183a = i10;
        this.f21184b = sVar;
    }

    @Override // androidx.lifecycle.v
    public final void onChanged(Object obj) {
        switch (this.f21183a) {
            case 0:
                j jVar = (j) this.f21184b;
                jVar.getClass();
                if (((Integer) obj).intValue() != 2) {
                    jVar.dismiss();
                }
                break;
            default:
                EarStatusDTO earStatusDTO = (EarStatusDTO) obj;
                m mVar = (m) this.f21184b;
                if (earStatusDTO != null) {
                    mVar.f21199q = earStatusDTO.bothInEar();
                    A.c("PersonalizedNoiseFailedDialogFragment", new k(mVar, 1));
                } else {
                    A.b("PersonalizedNoiseFailedDialogFragment", "PersonalNoiseItem: earStatusDTO is null");
                }
                break;
        }
    }
}
