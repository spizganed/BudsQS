package com.heytap.headset.component.scan;

import Wb.l;
import X3.f;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0901g;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: ScanViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class ScanViewModel$startObserve$4 extends FunctionReferenceImpl implements l<f, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(f fVar) {
        f fVar2 = fVar;
        ScanViewModel scanViewModel = (ScanViewModel) this.receiver;
        scanViewModel.getClass();
        A.f("ScanViewModel", "onBrDeviceRemove scanDeviceVO = " + fVar2);
        if (fVar2 != null) {
            fVar2.setViewType(1);
            CopyOnWriteArrayList<f> copyOnWriteArrayList = scanViewModel.f17538g;
            if (!C0901g.a(copyOnWriteArrayList)) {
                Iterator<f> it = copyOnWriteArrayList.iterator();
                h.d(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    f next = it.next();
                    if (h.a(next.getMacAddress(), fVar2.getMacAddress())) {
                        if (next.getViewType() != 2) {
                            copyOnWriteArrayList.remove(next);
                        }
                    }
                }
            }
            scanViewModel.f17533b.m(ScanViewModel.d(scanViewModel.i()));
        }
        return Jb.l.f2618a;
    }
}
