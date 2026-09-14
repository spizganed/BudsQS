package com.oplus.melody.app.discovery;

import com.oplus.melody.model.db.PersonalDressEntity;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import java.io.File;
import java.util.ArrayList;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.c0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0840c0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19047b;

    public /* synthetic */ C0840c0(Object obj, int i10) {
        this.f19046a = i10;
        this.f19047b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19046a) {
            case 0:
                return "getDiscoveries: select item change,productId:" + ((DiscoveryRecycleItemVO) this.f19047b).getProductId();
            case 1:
                return "discoverGet: size=" + ((ArrayList) this.f19047b).size();
            case 2:
                return "sppCoverOpen: IGNORE boxOpen " + com.oplus.melody.common.util.A.r(((EarphoneDTO) this.f19047b).getMacAddress());
            case 3:
                StringBuilder sb2 = new StringBuilder("getAttireZipConfig isDirectory:");
                File file = (File) this.f19047b;
                sb2.append(file.isDirectory());
                sb2.append(" exist:");
                sb2.append(file.exists());
                return sb2.toString();
            default:
                StringBuilder sb3 = new StringBuilder("getAttireZipConfig dressEntity:");
                PersonalDressEntity personalDressEntity = (PersonalDressEntity) this.f19047b;
                sb3.append(personalDressEntity != null ? personalDressEntity.getThemeId() : "null");
                return sb3.toString();
        }
    }
}
