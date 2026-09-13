package com.oplus.melody.model.db;

import java.util.ArrayList;
import q1.InterfaceC1431a;

/* JADX INFO: renamed from: com.oplus.melody.model.db.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0920b implements Wb.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f19761c;

    public /* synthetic */ C0920b(int i10, String str) {
        this.f19759a = 2;
        this.f19761c = i10;
        this.f19760b = str;
    }

    @Override // Wb.l
    public final Object d(Object obj) throws Exception {
        q1.c cVarV0;
        switch (this.f19759a) {
            case 0:
                int i10 = this.f19761c;
                cVarV0 = ((InterfaceC1431a) obj).v0("SELECT * FROM carousel_dress WHERE productId = ? AND colorId = ?");
                String str = this.f19760b;
                try {
                    if (str == null) {
                        cVarV0.a(1);
                    } else {
                        cVarV0.V(1, str);
                    }
                    cVarV0.h(2, i10);
                    int iT = E8.a.t(cVarV0, "carouselId");
                    int iT2 = E8.a.t(cVarV0, "productId");
                    int iT3 = E8.a.t(cVarV0, "colorId");
                    int iT4 = E8.a.t(cVarV0, "name");
                    int iT5 = E8.a.t(cVarV0, "carouselType");
                    int iT6 = E8.a.t(cVarV0, "themeIdList");
                    ArrayList arrayList = new ArrayList();
                    while (cVarV0.l0()) {
                        arrayList.add(new CarouselDressEntity((int) cVarV0.getLong(iT), cVarV0.isNull(iT2) ? null : cVarV0.o(iT2), (int) cVarV0.getLong(iT3), cVarV0.isNull(iT4) ? null : cVarV0.o(iT4), (int) cVarV0.getLong(iT5), MelodyTypeConverters.a(cVarV0.isNull(iT6) ? null : cVarV0.o(iT6))));
                        break;
                    }
                    return arrayList;
                } finally {
                }
            case 1:
                int i11 = this.f19761c;
                InterfaceC1431a interfaceC1431a = (InterfaceC1431a) obj;
                cVarV0 = interfaceC1431a.v0("DELETE FROM carousel_dress WHERE productId = ? AND colorId = ?");
                try {
                    cVarV0.V(1, this.f19760b);
                    cVarV0.h(2, i11);
                    cVarV0.l0();
                    return Integer.valueOf(D1.f.z(interfaceC1431a));
                } finally {
                    cVarV0.close();
                }
            default:
                int i12 = this.f19761c;
                cVarV0 = ((InterfaceC1431a) obj).v0("UPDATE melody_equipment SET multiConversationSwitch = ? WHERE macAddress = ?");
                try {
                    cVarV0.h(1, i12);
                    String str2 = this.f19760b;
                    if (str2 == null) {
                        cVarV0.a(2);
                    } else {
                        cVarV0.V(2, str2);
                    }
                    cVarV0.l0();
                    cVarV0.close();
                    return null;
                } finally {
                }
        }
    }

    public /* synthetic */ C0920b(String str, int i10, int i11) {
        this.f19759a = i11;
        this.f19760b = str;
        this.f19761c = i10;
    }
}
