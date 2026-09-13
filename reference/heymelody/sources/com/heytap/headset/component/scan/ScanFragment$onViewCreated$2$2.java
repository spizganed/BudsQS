package com.heytap.headset.component.scan;

import Ba.b;
import Wb.l;
import android.content.Intent;
import androidx.fragment.app.f;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0905k;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: ScanFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ScanFragment$onViewCreated$2$2 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Integer num) {
        int iIntValue = num.intValue();
        ScanFragment scanFragment = (ScanFragment) this.receiver;
        scanFragment.getClass();
        A.c("ScanFragment", new b(iIntValue, 16));
        if (iIntValue == 10) {
            f activity = scanFragment.getActivity();
            if (activity != null) {
                C0905k.k(activity, new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
            }
            f activity2 = scanFragment.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
        return Jb.l.f2618a;
    }
}
