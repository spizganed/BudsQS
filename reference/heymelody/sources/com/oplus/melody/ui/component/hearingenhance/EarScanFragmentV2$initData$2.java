package com.oplus.melody.ui.component.hearingenhance;

import Wb.l;
import com.oplus.melody.model.repository.hearingenhance.EarScanResultDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: EarScanFragmentV2.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class EarScanFragmentV2$initData$2 extends FunctionReferenceImpl implements l<EarScanResultDTO, Jb.l> {
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b1  */
    @Override // Wb.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final Jb.l d(com.oplus.melody.model.repository.hearingenhance.EarScanResultDTO r8) {
        /*
            r7 = this;
            com.oplus.melody.model.repository.hearingenhance.EarScanResultDTO r8 = (com.oplus.melody.model.repository.hearingenhance.EarScanResultDTO) r8
            java.lang.Object r0 = r7.receiver
            com.oplus.melody.ui.component.hearingenhance.EarScanFragmentV2 r0 = (com.oplus.melody.ui.component.hearingenhance.EarScanFragmentV2) r0
            r0.getClass()
            if (r8 == 0) goto Lbf
            int r1 = r8.getUniqueId()
            int r2 = r0.f21554q
            if (r1 != r2) goto Lbf
            java.lang.String r1 = r8.getAddress()
            com.oplus.melody.ui.component.hearingenhance.HearingEnhancementViewModel r2 = r0.f21556s
            r3 = 0
            java.lang.String r4 = "mViewModel"
            if (r2 == 0) goto Lbb
            java.lang.String r2 = r2.f21582c
            boolean r1 = kotlin.jvm.internal.h.a(r1, r2)
            if (r1 != 0) goto L28
            goto Lbf
        L28:
            r0.f21545B = r8
            X3.l r1 = new X3.l
            r2 = 29
            r1.<init>(r8, r2)
            java.lang.String r2 = "EarScanFragmentV2"
            com.oplus.melody.common.util.A.c(r2, r1)
            byte[] r1 = r8.getResultData()
            if (r1 == 0) goto Lb1
            int r1 = r1.length
            r5 = 0
            r6 = 1
            if (r1 != 0) goto L43
            r1 = r6
            goto L44
        L43:
            r1 = r5
        L44:
            r1 = r1 ^ r6
            if (r1 != r6) goto Lb1
            java.util.List<java.lang.Integer> r1 = la.C1296i.f25838a
            r8.getResultData()
            r0.x(r5)
            com.oplus.melody.ui.component.hearingenhance.EarScanFragmentV2$a r8 = r0.f21551I
            r8.cancel()
            android.widget.Button r8 = r0.f21557t
            if (r8 == 0) goto Lab
            r8.setVisibility(r5)
            android.widget.TextView r8 = r0.f21558u
            if (r8 == 0) goto La5
            r1 = 2131886740(0x7f120294, float:1.9408067E38)
            r8.setText(r1)
            android.widget.TextView r8 = r0.f21559v
            if (r8 == 0) goto L9f
            r1 = 2131886741(0x7f120295, float:1.940807E38)
            r8.setText(r1)
            com.oplus.melody.ui.component.hearingenhance.HearingEnhancementViewModel r8 = r0.f21556s
            if (r8 == 0) goto L9b
            java.lang.String r8 = r8.f21582c
            boolean r8 = android.bluetooth.BluetoothAdapter.checkBluetoothAddress(r8)
            if (r8 == 0) goto Lbf
            androidx.lifecycle.t r8 = r0.f21546C
            if (r8 != 0) goto L90
            com.oplus.melody.ui.component.hearingenhance.HearingEnhancementViewModel r8 = r0.f21556s
            if (r8 == 0) goto L8c
            java.lang.String r1 = r8.f21582c
            androidx.lifecycle.t r8 = r8.f(r1)
            r0.f21546C = r8
            goto L90
        L8c:
            kotlin.jvm.internal.h.i(r4)
            throw r3
        L90:
            androidx.lifecycle.t r8 = r0.f21546C
            kotlin.jvm.internal.h.b(r8)
            ea.b r1 = r0.f21552J
            r8.e(r0, r1)
            goto Lbf
        L9b:
            kotlin.jvm.internal.h.i(r4)
            throw r3
        L9f:
            java.lang.String r8 = "mScanTips"
            kotlin.jvm.internal.h.i(r8)
            throw r3
        La5:
            java.lang.String r8 = "mScanTitle"
            kotlin.jvm.internal.h.i(r8)
            throw r3
        Lab:
            java.lang.String r8 = "mContinueBtn"
            kotlin.jvm.internal.h.i(r8)
            throw r3
        Lb1:
            java.lang.String r8 = "onEarScanResult called, resultData is empty..."
            com.oplus.melody.common.util.A.b(r2, r8)
            r8 = -1
            r0.t(r8)
            goto Lbf
        Lbb:
            kotlin.jvm.internal.h.i(r4)
            throw r3
        Lbf:
            Jb.l r8 = Jb.l.f2618a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.hearingenhance.EarScanFragmentV2$initData$2.d(java.lang.Object):java.lang.Object");
    }
}
