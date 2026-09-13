package com.oplus.melody.ui.component.hearingenhance;

import Wb.l;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.db.s;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: EarScanFragmentV2.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class EarScanFragmentV2$startEarScan$1 extends FunctionReferenceImpl implements l<SetCommandStateDTO, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(SetCommandStateDTO setCommandStateDTO) {
        SetCommandStateDTO p02 = setCommandStateDTO;
        h.e(p02, "p0");
        EarScanFragmentV2 earScanFragmentV2 = (EarScanFragmentV2) this.receiver;
        earScanFragmentV2.getClass();
        if (p02.getSetCommandStatus() == 0) {
            A.c("EarScanFragmentV2", new s(earScanFragmentV2, 22));
        } else {
            A.h("EarScanFragmentV2", "earScanCallback send fail, setCommandState = " + A.e(p02));
            earScanFragmentV2.s(p02.getSetCommandStatus());
        }
        return Jb.l.f2618a;
    }
}
