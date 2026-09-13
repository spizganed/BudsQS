package com.oplus.melody.model.db;

import q1.InterfaceC1431a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class I implements Wb.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f19698c;

    public /* synthetic */ I(String str, String str2, int i10) {
        this.f19696a = i10;
        this.f19697b = str;
        this.f19698c = str2;
    }

    @Override // Wb.l
    public final Object d(Object obj) throws Exception {
        q1.c cVarV0;
        InterfaceC1431a interfaceC1431a = (InterfaceC1431a) obj;
        switch (this.f19696a) {
            case 0:
                cVarV0 = interfaceC1431a.v0("UPDATE provisional_whitelist SET type = ? WHERE pid = ?");
                try {
                    cVarV0.V(1, this.f19697b);
                    String str = this.f19698c;
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
                cVarV0 = interfaceC1431a.v0("UPDATE provisional_whitelist SET brand = ? WHERE pid = ?");
                try {
                    cVarV0.V(1, this.f19697b);
                    String str2 = this.f19698c;
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
}
