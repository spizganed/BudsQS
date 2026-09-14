package com.oplus.melody.app.discovery;

import android.text.TextUtils;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import s8.AbstractC1508a;
import u8.C1557e;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.v0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0886v0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19204b;

    public /* synthetic */ C0886v0(Object obj, int i10) {
        this.f19203a = i10;
        this.f19204b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        Object obj2 = this.f19204b;
        switch (this.f19203a) {
            case 0:
                final String str = (String) obj;
                final E0 e02 = (E0) obj2;
                return CompletableFuture.supplyAsync(new C0848f(str, 1)).exceptionally((Function) new C0837b0(1)).thenApply(new Function() { // from class: com.oplus.melody.app.discovery.x0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj3) {
                        WhitelistConfigDTO whitelistConfigDTOC;
                        String name = (String) obj3;
                        if (TextUtils.isEmpty(name)) {
                            E0 e03 = e02;
                            String name2 = e03.getName();
                            name = (!TextUtils.isEmpty(name2) || (whitelistConfigDTOC = AbstractC1508a.f().c(e03.getProductId(), null)) == null) ? name2 : whitelistConfigDTOC.getName();
                        }
                        if (com.oplus.melody.common.util.A.l()) {
                            com.oplus.melody.common.util.A.b("DiscoveryDialogViewModel", "getCompatibleDeviceName mac=" + com.oplus.melody.common.util.A.r(str));
                        }
                        return name == null ? "" : name;
                    }
                });
            case 1:
                C1557e c1557eB = ((I0) obj2).b((C1) obj);
                if (c1557eB == null || c1557eB.getTitleRes() == null) {
                    return null;
                }
                return c1557eB.getTitleRes();
            default:
                l1 l1Var = (l1) obj2;
                return J6.d.f(0, 0, l1Var.f19137n, l1Var.f18931d);
        }
    }
}
