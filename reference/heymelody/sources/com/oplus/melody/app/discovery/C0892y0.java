package com.oplus.melody.app.discovery;

import D7.o0;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.y0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0892y0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19231b;

    public /* synthetic */ C0892y0(Object obj, int i10) {
        this.f19230a = i10;
        this.f19231b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f19230a) {
            case 0:
                final DiscoveryRecycleItemVO discoveryRecycleItemVO = (DiscoveryRecycleItemVO) obj;
                final DiscoveryDialogViewModel discoveryDialogViewModel = (DiscoveryDialogViewModel) this.f19231b;
                discoveryDialogViewModel.getClass();
                final String macAddress = discoveryRecycleItemVO.getMacAddress();
                com.oplus.melody.common.util.A.c("DiscoveryDialogViewModel", new C0839c(macAddress, 2));
                CompletableFuture.supplyAsync(new C0842d(macAddress, 2)).thenAcceptAsync(new Consumer() { // from class: com.oplus.melody.app.discovery.W
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj2) {
                        DiscoveryDialogViewModel discoveryDialogViewModel2 = discoveryDialogViewModel;
                        discoveryDialogViewModel2.getClass();
                        DiscoveryRecycleItemVO discoveryRecycleItemVO2 = discoveryRecycleItemVO;
                        String productId = discoveryRecycleItemVO2.getProductId();
                        int colorId = discoveryRecycleItemVO2.getColorId();
                        String str = macAddress;
                        discoveryDialogViewModel2.i(colorId, productId, str);
                        discoveryDialogViewModel2.h(str).a(new C0864k0(discoveryDialogViewModel2, str, (EarphoneDTO) obj2, 0));
                    }
                }, (Executor) o0.c.f1145c);
                break;
            default:
                ((C0850f1) this.f19231b).u();
                break;
        }
    }
}
