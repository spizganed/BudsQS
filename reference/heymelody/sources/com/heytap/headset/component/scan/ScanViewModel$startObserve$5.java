package com.heytap.headset.component.scan;

import Wb.l;
import X3.f;
import com.oplus.melody.common.util.A;
import f4.C1043b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: ScanViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class ScanViewModel$startObserve$5 extends FunctionReferenceImpl implements l<List<? extends f>, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(List<? extends f> list) {
        List<? extends f> p02 = list;
        h.e(p02, "p0");
        ScanViewModel scanViewModel = (ScanViewModel) this.receiver;
        CopyOnWriteArrayList<f> copyOnWriteArrayList = scanViewModel.h;
        copyOnWriteArrayList.clear();
        copyOnWriteArrayList.addAll(p02);
        Iterator<f> it = copyOnWriteArrayList.iterator();
        h.d(it, "iterator(...)");
        while (it.hasNext()) {
            f next = it.next();
            A.f("ScanViewModel", "onConnectedDeviceListFound newScanDevice = " + next.getMacAddress() + ", connectionState" + next.getConnectionState());
            String productId = next.getProductId();
            if (productId != null) {
                ConcurrentHashMap<String, String> concurrentHashMap = scanViewModel.f17540j;
                if (concurrentHashMap.containsKey(C1043b.a(next.getColorId(), productId))) {
                    next.setCoverImage(concurrentHashMap.get(C1043b.a(next.getColorId(), productId)));
                } else {
                    C1043b.a.f23099a.b(next.getColorId(), productId);
                }
            }
        }
        scanViewModel.f17533b.m(ScanViewModel.d(scanViewModel.i()));
        return Jb.l.f2618a;
    }
}
