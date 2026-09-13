package com.oplus.melody.ui.component.detail.voiceassist;

import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import kc.C1264t;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoiceAssistFragmentV3 f21368b;

    public /* synthetic */ d(VoiceAssistFragmentV3 voiceAssistFragmentV3, int i10) {
        this.f21367a = i10;
        this.f21368b = voiceAssistFragmentV3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f21367a) {
            case 0:
                this.f21368b.D();
                break;
            default:
                AbstractC0939b abstractC0939bE = AbstractC0939b.E();
                VoiceAssistFragmentV3 voiceAssistFragmentV3 = this.f21368b;
                EarphoneDTO earphoneDTOW = abstractC0939bE.w(voiceAssistFragmentV3.f21316A);
                if (earphoneDTOW != null) {
                    C1264t.t(AppConstant$FunctionType.VOICE_CALL_AND_MSG.getFunType(), earphoneDTOW.getProductId(), voiceAssistFragmentV3.f21316A, N.t(earphoneDTOW), "");
                }
                break;
        }
    }
}
