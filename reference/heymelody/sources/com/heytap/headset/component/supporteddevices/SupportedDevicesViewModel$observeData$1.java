package com.heytap.headset.component.supporteddevices;

import C6.g;
import D1.f;
import Kb.m;
import Wb.l;
import X7.a;
import X7.b;
import a4.C0516a;
import b9.C0738g;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.net.n;
import j4.C1205a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: SupportedDevicesViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class SupportedDevicesViewModel$observeData$1 extends FunctionReferenceImpl implements l<List<? extends WhitelistConfigDTO>, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(List<? extends WhitelistConfigDTO> list) {
        int i10;
        List<? extends WhitelistConfigDTO> p02 = list;
        h.e(p02, "p0");
        SupportedDevicesViewModel supportedDevicesViewModel = (SupportedDevicesViewModel) this.receiver;
        supportedDevicesViewModel.getClass();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Object obj = b.f5996c;
        List<a> listD = b.a.a().c().d();
        Iterator<? extends WhitelistConfigDTO> it = p02.iterator();
        while (true) {
            i10 = 0;
            if (!it.hasNext()) {
                break;
            }
            WhitelistConfigDTO next = it.next();
            WhitelistConfigDTO.Function function = next.getFunction();
            if (Y.e(function != null ? function.getHideFromUIList() : -1, false)) {
                if (listD != null) {
                    for (a aVar : listD) {
                        if (!h.a(aVar.mProductId, next.getId()) || !h.a(aVar.mName, next.getName())) {
                        }
                    }
                }
            }
            int iM = f.m(next.getId());
            J7.b.a().d();
            if (394260 != iM && 395284 != iM) {
                C0516a c0516a = new C0516a(null, null, null, null, null, 31, null);
                c0516a.setProductName(next.getName());
                c0516a.setProductId(next.getId());
                String brand = next.getBrand();
                if (brand == null) {
                    brand = "";
                }
                c0516a.setBrandName(brand);
                c0516a.setEarphoneType(next.getType());
                ConcurrentHashMap<String, String> concurrentHashMap = supportedDevicesViewModel.f17581e;
                if (concurrentHashMap.containsKey(next.getId())) {
                    c0516a.setImageUrl((String) kotlin.collections.a.c0(concurrentHashMap, next.getId()));
                }
                if ("OPPO".equalsIgnoreCase(c0516a.getBrandName())) {
                    arrayList.add(c0516a);
                    arrayList2.add(c0516a);
                } else if ("OnePlus".equalsIgnoreCase(c0516a.getBrandName())) {
                    arrayList.add(c0516a);
                    arrayList3.add(c0516a);
                }
            }
        }
        supportedDevicesViewModel.f17578b.m(arrayList);
        supportedDevicesViewModel.f17579c.m(arrayList2);
        supportedDevicesViewModel.f17580d.m(arrayList3);
        C1205a c1205a = C1205a.C0275a.f25026a;
        ArrayList arrayList4 = new ArrayList(m.i(arrayList));
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj2 = arrayList.get(i11);
            i11++;
            arrayList4.add(((C0516a) obj2).getProductId());
        }
        ArrayList arrayList5 = new ArrayList();
        int size2 = arrayList4.size();
        while (i10 < size2) {
            Object obj3 = arrayList4.get(i10);
            i10++;
            int iM2 = f.m((String) obj3);
            if (iM2 != 0 && (16777215 & iM2) == iM2) {
                arrayList5.add(obj3);
            }
        }
        c1205a.getClass();
        ArrayList arrayListB = C0901g.b(arrayList5);
        Map<String, String> mapD = c1205a.f25025a.d();
        if (mapD == null) {
            mapD = Collections.EMPTY_MAP;
        }
        arrayListB.removeAll(mapD.keySet());
        if (C0901g.a(arrayListB)) {
            A.x("SupportedDevicesImageRepository", "requestImageUrls: productIds is empty");
        } else {
            A.c("SupportedDevicesImageRepository", new g(arrayListB, 8));
            n nVarB = n.b();
            nVarB.c(arrayListB).thenApply((Function) new C0738g(nVarB, 9)).thenAccept((Consumer) new G8.h(c1205a, 13)).exceptionally((Function<Throwable, ? extends Void>) new com.oplus.melody.model.repository.zenmode.f(5));
        }
        return Jb.l.f2618a;
    }
}
