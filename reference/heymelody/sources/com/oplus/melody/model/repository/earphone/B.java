package com.oplus.melody.model.repository.earphone;

import o.InterfaceC1361a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class B implements InterfaceC1361a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ L f19864b;

    public /* synthetic */ B(L l4, int i10) {
        this.f19863a = i10;
        this.f19864b = l4;
    }

    @Override // o.InterfaceC1361a, com.google.common.base.b
    public final Object apply(Object obj) {
        String macAddress;
        switch (this.f19863a) {
            case 0:
                BoxCoverActionDTO boxCoverActionDTO = (BoxCoverActionDTO) obj;
                L l4 = this.f19864b;
                if (boxCoverActionDTO != null) {
                    l4.getClass();
                    macAddress = boxCoverActionDTO.getMacAddress();
                } else {
                    macAddress = null;
                }
                return l4.V0(macAddress);
            default:
                return this.f19864b.X0((String) obj);
        }
    }
}
