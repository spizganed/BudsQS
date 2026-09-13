package com.oplus.melody.ui.component.hearingenhance;

import Wb.l;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.hearingenhance.EarScanStatusDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: EarScanFragmentV2.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class EarScanFragmentV2$initData$1 extends FunctionReferenceImpl implements l<EarScanStatusDTO, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(EarScanStatusDTO earScanStatusDTO) {
        EarScanStatusDTO earScanStatusDTO2 = earScanStatusDTO;
        EarScanFragmentV2 earScanFragmentV2 = (EarScanFragmentV2) this.receiver;
        earScanFragmentV2.getClass();
        if (earScanStatusDTO2 != null) {
            String address = earScanStatusDTO2.getAddress();
            HearingEnhancementViewModel hearingEnhancementViewModel = earScanFragmentV2.f21556s;
            if (hearingEnhancementViewModel == null) {
                h.i("mViewModel");
                throw null;
            }
            if (h.a(address, hearingEnhancementViewModel.f21582c)) {
                A.c("EarScanFragmentV2", new X3.l(earScanStatusDTO2, 28));
                earScanFragmentV2.t(earScanStatusDTO2.getStatus());
            }
        }
        return Jb.l.f2618a;
    }
}
