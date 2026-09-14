package com.oplus.melody.app.discovery;

import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.f0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0849f0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EarphoneDTO f19065b;

    public /* synthetic */ C0849f0(EarphoneDTO earphoneDTO, int i10) {
        this.f19064a = i10;
        this.f19065b = earphoneDTO;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19064a) {
            case 0:
                StringBuilder sb2 = new StringBuilder("discoverGet: productId=");
                EarphoneDTO earphoneDTO = this.f19065b;
                sb2.append(earphoneDTO.getProductId());
                sb2.append(" address=");
                sb2.append(com.oplus.melody.common.util.A.r(earphoneDTO.getMacAddress()));
                return sb2.toString();
            case 1:
                return "sppCoverOpen: IGNORE boxOpen " + com.oplus.melody.common.util.A.r(this.f19065b.getMacAddress());
            default:
                return "sppCoverOpen productId:" + this.f19065b.getProductId();
        }
    }
}
