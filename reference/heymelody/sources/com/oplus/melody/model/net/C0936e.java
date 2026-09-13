package com.oplus.melody.model.net;

import java.io.IOException;
import uc.q;
import uc.r;

/* JADX INFO: renamed from: com.oplus.melody.model.net.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0936e implements uc.o {
    @Override // uc.o
    public final uc.r a(zc.f fVar) throws IOException {
        uc.q qVar = fVar.f29612e;
        String strA = qVar.a("Melody-Download-Uuid");
        if (strA == null) {
            return fVar.b(qVar);
        }
        q.a aVarB = qVar.b();
        aVarB.f28233c.d("Melody-Download-Uuid");
        uc.r rVarB = fVar.b(new uc.q(aVarB));
        h hVar = (h) C0938g.f19823b.get(strA);
        if (hVar == null) {
            return rVarB;
        }
        r.a aVarC = rVarB.c();
        aVarC.f28258g = new j(rVarB.f28244s, hVar);
        return aVarC.a();
    }
}
