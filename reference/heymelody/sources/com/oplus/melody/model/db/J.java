package com.oplus.melody.model.db;

import java.util.ArrayList;
import q1.InterfaceC1431a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class J implements Wb.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f19701c;

    public /* synthetic */ J(String str, String str2, int i10) {
        this.f19699a = i10;
        this.f19700b = str;
        this.f19701c = str2;
    }

    @Override // Wb.l
    public final Object d(Object obj) throws Exception {
        q1.c cVarV0;
        switch (this.f19699a) {
            case 0:
                cVarV0 = ((InterfaceC1431a) obj).v0("UPDATE provisional_whitelist SET name = ? WHERE pid = ?");
                try {
                    cVarV0.V(1, this.f19700b);
                    String str = this.f19701c;
                    if (str == null) {
                        cVarV0.a(2);
                    } else {
                        cVarV0.V(2, str);
                    }
                    cVarV0.l0();
                    cVarV0.close();
                    return null;
                } finally {
                }
            default:
                cVarV0 = ((InterfaceC1431a) obj).v0("SELECT * FROM zenmode_resource_info WHERE productId = ? AND color = ?");
                String str2 = this.f19700b;
                try {
                    if (str2 == null) {
                        cVarV0.a(1);
                    } else {
                        cVarV0.V(1, str2);
                    }
                    String str3 = this.f19701c;
                    if (str3 == null) {
                        cVarV0.a(2);
                    } else {
                        cVarV0.V(2, str3);
                    }
                    int iT = E8.a.t(cVarV0, "resid");
                    int iT2 = E8.a.t(cVarV0, "randomid");
                    int iT3 = E8.a.t(cVarV0, "name_cn");
                    int iT4 = E8.a.t(cVarV0, "name_en");
                    int iT5 = E8.a.t(cVarV0, "imgurl");
                    int iT6 = E8.a.t(cVarV0, "audiourl");
                    int iT7 = E8.a.t(cVarV0, "audiobinurl");
                    int iT8 = E8.a.t(cVarV0, "audiobinmd5");
                    int iT9 = E8.a.t(cVarV0, "createtime");
                    int iT10 = E8.a.t(cVarV0, "updatetime");
                    int iT11 = E8.a.t(cVarV0, "audioexist");
                    int iT12 = E8.a.t(cVarV0, "productId");
                    int iT13 = E8.a.t(cVarV0, "color");
                    ArrayList arrayList = new ArrayList();
                    while (cVarV0.l0()) {
                        int i10 = iT2;
                        int i11 = iT3;
                        arrayList.add(new N(cVarV0.isNull(iT2) ? null : cVarV0.o(iT2), cVarV0.isNull(iT) ? null : cVarV0.o(iT), cVarV0.isNull(iT3) ? null : cVarV0.o(iT3), cVarV0.isNull(iT4) ? null : cVarV0.o(iT4), cVarV0.isNull(iT5) ? null : cVarV0.o(iT5), cVarV0.isNull(iT6) ? null : cVarV0.o(iT6), cVarV0.isNull(iT7) ? null : cVarV0.o(iT7), cVarV0.isNull(iT8) ? null : cVarV0.o(iT8), cVarV0.isNull(iT9) ? null : cVarV0.o(iT9), cVarV0.isNull(iT10) ? null : cVarV0.o(iT10), (int) cVarV0.getLong(iT11), cVarV0.isNull(iT12) ? null : cVarV0.o(iT12), cVarV0.isNull(iT13) ? null : cVarV0.o(iT13)));
                        iT2 = i10;
                        iT3 = i11;
                        break;
                    }
                    cVarV0.close();
                    return arrayList;
                } finally {
                }
        }
    }
}
