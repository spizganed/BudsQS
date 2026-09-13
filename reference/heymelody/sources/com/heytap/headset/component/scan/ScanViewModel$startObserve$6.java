package com.heytap.headset.component.scan;

import Wb.l;
import X3.f;
import f4.C1043b;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: ScanViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class ScanViewModel$startObserve$6 extends FunctionReferenceImpl implements l<Map<String, ? extends String>, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Map<String, ? extends String> map) {
        Map<String, ? extends String> p02 = map;
        h.e(p02, "p0");
        ScanViewModel scanViewModel = (ScanViewModel) this.receiver;
        ConcurrentHashMap<String, String> concurrentHashMap = scanViewModel.f17540j;
        concurrentHashMap.clear();
        concurrentHashMap.putAll(p02);
        Iterator<f> it = scanViewModel.f17537f.iterator();
        h.d(it, "iterator(...)");
        while (it.hasNext()) {
            f next = it.next();
            String productId = next.getProductId();
            if (productId != null && concurrentHashMap.containsKey(C1043b.a(next.getColorId(), productId))) {
                next.setCoverImage(concurrentHashMap.get(C1043b.a(next.getColorId(), productId)));
            }
        }
        Iterator<f> it2 = scanViewModel.f17538g.iterator();
        h.d(it2, "iterator(...)");
        while (it2.hasNext()) {
            f next2 = it2.next();
            String productId2 = next2.getProductId();
            if (productId2 != null && concurrentHashMap.containsKey(C1043b.a(next2.getColorId(), productId2))) {
                next2.setCoverImage(concurrentHashMap.get(C1043b.a(next2.getColorId(), productId2)));
            }
        }
        Iterator<f> it3 = scanViewModel.h.iterator();
        h.d(it3, "iterator(...)");
        while (it3.hasNext()) {
            f next3 = it3.next();
            String productId3 = next3.getProductId();
            if (productId3 != null && concurrentHashMap.containsKey(C1043b.a(next3.getColorId(), productId3))) {
                next3.setCoverImage(concurrentHashMap.get(C1043b.a(next3.getColorId(), productId3)));
            }
        }
        scanViewModel.f17533b.m(ScanViewModel.d(scanViewModel.i()));
        return Jb.l.f2618a;
    }
}
