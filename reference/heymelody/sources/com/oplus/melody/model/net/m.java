package com.oplus.melody.model.net;

/* JADX INFO: compiled from: SmartHomeIotCallHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends com.oplus.melody.model.repository.zenmode.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.oplus.melody.model.repository.zenmode.c f19831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19832b;

    public m(com.oplus.melody.model.repository.zenmode.c cVar, String str) {
        this.f19831a = cVar;
        this.f19832b = str;
    }

    @Override // com.oplus.melody.model.repository.zenmode.c
    public final void d(int i10, String str) {
        com.oplus.melody.model.repository.zenmode.c cVar = this.f19831a;
        if (cVar != null) {
            cVar.d(i10, this.f19832b);
        }
    }
}
