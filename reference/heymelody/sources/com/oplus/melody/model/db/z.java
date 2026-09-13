package com.oplus.melody.model.db;

import q1.InterfaceC1431a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class z implements Wb.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f19794c;

    public /* synthetic */ z(String str, String str2, int i10) {
        this.f19792a = i10;
        this.f19793b = str;
        this.f19794c = str2;
    }

    @Override // Wb.l
    public final Object d(Object obj) throws Exception {
        q1.c cVarV0;
        InterfaceC1431a interfaceC1431a = (InterfaceC1431a) obj;
        switch (this.f19792a) {
            case 0:
                cVarV0 = interfaceC1431a.v0("UPDATE melody_equipment SET popTheme = ? WHERE macAddress = ?");
                String str = this.f19793b;
                try {
                    if (str == null) {
                        cVarV0.a(1);
                    } else {
                        cVarV0.V(1, str);
                    }
                    String str2 = this.f19794c;
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
            default:
                cVarV0 = interfaceC1431a.v0("UPDATE provisional_whitelist SET uuid = ? WHERE pid = ?");
                try {
                    cVarV0.V(1, this.f19793b);
                    String str3 = this.f19794c;
                    if (str3 == null) {
                        cVarV0.a(2);
                    } else {
                        cVarV0.V(2, str3);
                    }
                    cVarV0.l0();
                    cVarV0.close();
                    return null;
                } finally {
                }
        }
    }
}
