package com.heytap.headset.component.supporteddevices;

import Kb.m;
import Wb.l;
import a4.C0516a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: SupportedDevicesViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class SupportedDevicesViewModel$observeData$2 extends FunctionReferenceImpl implements l<Map<String, ? extends String>, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Map<String, ? extends String> map) {
        Map<String, ? extends String> p02 = map;
        h.e(p02, "p0");
        SupportedDevicesViewModel supportedDevicesViewModel = (SupportedDevicesViewModel) this.receiver;
        ConcurrentHashMap<String, String> concurrentHashMap = supportedDevicesViewModel.f17581e;
        concurrentHashMap.clear();
        concurrentHashMap.putAll(p02);
        O7.l<List<C0516a>> lVar = supportedDevicesViewModel.f17578b;
        List<C0516a> listD = lVar.d();
        if (listD == null) {
            listD = Collections.EMPTY_LIST;
        }
        h.d(listD, "nullToEmpty(...)");
        ArrayList arrayList = new ArrayList(m.i(listD));
        for (C0516a c0516a : listD) {
            String str = concurrentHashMap.get(c0516a.getProductId());
            arrayList.add(str != null ? C0516a.copy$default(c0516a, null, null, null, null, str, 15, null) : C0516a.copy$default(c0516a, null, null, null, null, null, 31, null));
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            if ("OPPO".equalsIgnoreCase(((C0516a) obj).getBrandName())) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayList.size();
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            if ("OnePlus".equalsIgnoreCase(((C0516a) obj2).getBrandName())) {
                arrayList3.add(obj2);
            }
        }
        lVar.m(arrayList);
        supportedDevicesViewModel.f17579c.m(arrayList2);
        supportedDevicesViewModel.f17580d.m(arrayList3);
        return Jb.l.f2618a;
    }
}
