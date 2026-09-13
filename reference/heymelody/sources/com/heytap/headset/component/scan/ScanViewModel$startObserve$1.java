package com.heytap.headset.component.scan;

import Wb.l;
import X3.f;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import f4.C1043b;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: ScanViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class ScanViewModel$startObserve$1 extends FunctionReferenceImpl implements l<f, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(f fVar) {
        f fVar2 = fVar;
        ScanViewModel scanViewModel = (ScanViewModel) this.receiver;
        scanViewModel.getClass();
        A.f("ScanViewModel", "onBleDeviceFound scanDeviceVO = " + fVar2);
        if (fVar2 != null) {
            String productId = fVar2.getProductId();
            if (productId != null) {
                if (scanViewModel.f17540j.containsKey(C1043b.a(fVar2.getColorId(), productId))) {
                    fVar2.setCoverImage(scanViewModel.f17540j.get(C1043b.a(fVar2.getColorId(), productId)));
                } else {
                    C1043b.a.f23099a.b(fVar2.getColorId(), productId);
                }
            }
            if (C0901g.a(scanViewModel.f17537f) || !scanViewModel.h(fVar2)) {
                AbstractC0939b.E().Q(fVar2.getColorId(), fVar2.getMacAddress(), fVar2.getDeviceName(), fVar2.getProductId());
                if (scanViewModel.f17536e) {
                    scanViewModel.f17537f.add(fVar2);
                }
            } else {
                CopyOnWriteArrayList<f> copyOnWriteArrayList = scanViewModel.f17537f;
                int i10 = -1;
                if (!C0901g.a(copyOnWriteArrayList)) {
                    int size = copyOnWriteArrayList.size();
                    int i11 = 0;
                    while (true) {
                        if (i11 >= size) {
                            break;
                        }
                        if (h.a(fVar2.getMacAddress(), copyOnWriteArrayList.get(i11).getMacAddress())) {
                            i10 = i11;
                            break;
                        }
                        i11++;
                    }
                }
                if (i10 >= 0) {
                    fVar2.setConnectionState(scanViewModel.f17537f.get(i10).getConnectionState());
                    fVar2.setConnectEnabled(scanViewModel.f17537f.get(i10).getConnectEnabled());
                    scanViewModel.f17537f.set(i10, fVar2);
                }
            }
            scanViewModel.f17533b.m(ScanViewModel.d(scanViewModel.i()));
        }
        return Jb.l.f2618a;
    }
}
