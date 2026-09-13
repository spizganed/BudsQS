package com.oplus.melody.model.net;

import okhttp3.Protocol;
import uc.r;

/* JADX INFO: renamed from: com.oplus.melody.model.net.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0937f implements uc.o {
    @Override // uc.o
    public final uc.r a(zc.f fVar) {
        uc.q qVar = fVar.f29612e;
        if (O7.m.c()) {
            return fVar.b(qVar);
        }
        r.a aVar = new r.a();
        aVar.f28252a = qVar;
        aVar.f28253b = Protocol.HTTP_1_1;
        aVar.f28254c = 406;
        aVar.f28255d = "network request disabled";
        aVar.f28262l = -1L;
        aVar.f28263m = System.currentTimeMillis();
        return aVar.a();
    }
}
