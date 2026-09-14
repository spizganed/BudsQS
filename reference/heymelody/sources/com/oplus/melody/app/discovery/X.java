package com.oplus.melody.app.discovery;

import android.os.SystemClock;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.HeadsetRssiDetectionDTO;
import com.oplus.melody.track.constant.AppConstant$DiscoverOpType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class X implements androidx.lifecycle.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19017b;

    public /* synthetic */ X(Object obj, int i10) {
        this.f19016a = i10;
        this.f19017b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // androidx.lifecycle.v
    public final void onChanged(Object obj) {
        HeadsetRssiDetectionDTO headsetRssiDetectionDTO;
        int i10;
        ?? r12;
        Object obj2 = this.f19017b;
        int i11 = 0;
        switch (this.f19016a) {
            case 0:
                List list = (List) obj;
                if (list != null && !list.isEmpty()) {
                    androidx.lifecycle.t tVar = (androidx.lifecycle.t) obj2;
                    List<DiscoveryRecycleItemVO> list2 = (List) tVar.d();
                    if (list2 != null && !list2.isEmpty()) {
                        int size = list2.size();
                        ArrayList arrayList = new ArrayList(size);
                        for (DiscoveryRecycleItemVO discoveryRecycleItemVO : list2) {
                            if (discoveryRecycleItemVO != null && com.oplus.melody.common.util.Y.a(list, discoveryRecycleItemVO.getProductId(), discoveryRecycleItemVO.getProductName()) != null) {
                                arrayList.add(discoveryRecycleItemVO);
                            }
                        }
                        if (size != arrayList.size()) {
                            tVar.l(arrayList);
                        }
                        break;
                    }
                }
                break;
            default:
                E0 e02 = (E0) obj;
                int i12 = DiscoveryDialogActivity.f18836L0;
                final DiscoveryDialogActivity discoveryDialogActivity = (DiscoveryDialogActivity) obj2;
                discoveryDialogActivity.getClass();
                if (com.oplus.melody.common.util.A.l()) {
                    StringBuilder sb2 = new StringBuilder("onEarphoneChanged ");
                    sb2.append(e02);
                    sb2.append(" hashCode:");
                    sb2.append(e02 != null ? Integer.valueOf(e02.hashCode()) : "null");
                    com.oplus.melody.common.util.A.f("DiscoveryDialogActivity", sb2.toString());
                }
                int iAbs = Math.abs(discoveryDialogActivity.f18854a0);
                I0 i0J0 = discoveryDialogActivity.j0(iAbs);
                if (i0J0 != null && iAbs == e02.getDiscoveryState()) {
                    i0J0.f(e02);
                }
                int discoveryState = (((discoveryDialogActivity.f18853Z.k() || discoveryDialogActivity.f18853Z.l()) && e02.getAccountBindingState() == 1 && iAbs == 0) || iAbs > 2) ? e02.getDiscoveryState() : Math.max(iAbs, e02.getDiscoveryState());
                if (discoveryState > 2 && discoveryState == iAbs) {
                    discoveryDialogActivity.e0(false, true);
                }
                final int i13 = (discoveryState == iAbs || iAbs == 0) ? 0 : 1;
                if (e02.getShareAudioState() > 0) {
                    if (com.oplus.melody.common.util.A.l()) {
                        StringBuilder sbN = androidx.appcompat.widget.a.n(discoveryState, "newState:", " discoveryViewState:");
                        sbN.append(e02.getDiscoveryState());
                        sbN.append(" shareAudioState:");
                        sbN.append(e02.getShareAudioState());
                        sbN.append(" getPairingState:");
                        sbN.append(e02.getPairingState());
                        com.oplus.melody.common.util.A.b("DiscoveryDialogActivity", sbN.toString());
                    }
                    if (e02.getPairingState() == 1 && e02.getShareAudioState() == 1) {
                        discoveryState = 4;
                    }
                    if (e02.getShareAudioState() == 2) {
                        discoveryState = 7;
                    }
                    if (e02.getShareAudioState() == 3) {
                        discoveryState = 8;
                    }
                }
                final int i14 = discoveryState;
                final int iHashCode = e02.hashCode();
                int i15 = discoveryDialogActivity.f18855b0;
                discoveryDialogActivity.f18855b0 = i14;
                if (i15 == i14) {
                    r12 = 0;
                    i10 = 6;
                } else {
                    CompletableFuture<?> completableFuture = discoveryDialogActivity.f18870q0;
                    final boolean z2 = completableFuture == null || completableFuture.isDone();
                    com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new Supplier() { // from class: com.oplus.melody.app.discovery.A
                        @Override // java.util.function.Supplier
                        public final Object get() {
                            int i16 = DiscoveryDialogActivity.f18836L0;
                            return "moveToState " + i14 + " viewFlags=" + i13 + " immediatelyExecute:" + z2 + " traceHashCode:" + iHashCode;
                        }
                    });
                    if (z2) {
                        discoveryDialogActivity.f18870q0 = discoveryDialogActivity.W(i15, i14, i13, iHashCode);
                        headsetRssiDetectionDTO = null;
                        i10 = 6;
                    } else {
                        headsetRssiDetectionDTO = null;
                        i10 = 6;
                        discoveryDialogActivity.f18870q0 = discoveryDialogActivity.f18870q0.thenCompose((Function<? super Object, ? extends CompletionStage<U>>) new J(discoveryDialogActivity, i15, i14, i13, iHashCode, 1));
                    }
                    final E0 e0S = discoveryDialogActivity.S();
                    r12 = headsetRssiDetectionDTO;
                    if (e0S != null) {
                        if (i14 == 4 && discoveryDialogActivity.f18853Z.m()) {
                            CompletableFuture.supplyAsync(new B(e0S, i11)).whenComplete((BiConsumer) new C(discoveryDialogActivity, e0S, i14, i11));
                            r12 = headsetRssiDetectionDTO;
                        } else if (i14 == i10 && discoveryDialogActivity.f18853Z.m()) {
                            DiscoveryDialogActivity.g0(e0S.getProductId(), e0S.getId(), AppConstant$DiscoverOpType.CONNECTED, Integer.toString(i14), headsetRssiDetectionDTO);
                            r12 = headsetRssiDetectionDTO;
                        } else if (i14 == i10 && discoveryDialogActivity.f18853Z.l()) {
                            CompletableFuture.supplyAsync(new D(i11, discoveryDialogActivity, e0S)).whenComplete(new BiConsumer() { // from class: com.oplus.melody.app.discovery.E
                                @Override // java.util.function.BiConsumer
                                public final void accept(Object obj3, Object obj4) {
                                    int i16 = DiscoveryDialogActivity.f18836L0;
                                    discoveryDialogActivity.getClass();
                                    E0 e03 = e0S;
                                    DiscoveryDialogActivity.g0(e03.getProductId(), e03.getId(), AppConstant$DiscoverOpType.BACK_CONNECT, (String) obj3, null);
                                }
                            });
                            r12 = headsetRssiDetectionDTO;
                        } else {
                            r12 = headsetRssiDetectionDTO;
                            if (i14 == 7) {
                                DiscoveryDialogActivity.g0(e0S.getProductId(), e0S.getId(), AppConstant$DiscoverOpType.ERROR, Integer.toString(i14), headsetRssiDetectionDTO);
                                r12 = headsetRssiDetectionDTO;
                            }
                        }
                    }
                }
                if (i14 == i10 && i14 != iAbs) {
                    DiscoveryDialogViewModel discoveryDialogViewModel = discoveryDialogActivity.f18853Z;
                    String id = e02.getId();
                    discoveryDialogViewModel.getClass();
                    AbstractC0939b.E().i0(id, "DiscoveryDialogViewModel");
                }
                if (!discoveryDialogActivity.f18849V && iAbs == 0 && i14 != iAbs) {
                    discoveryDialogActivity.f18849V = true;
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - discoveryDialogActivity.f18848U;
                    com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new V3.g(2, jElapsedRealtime));
                    if (com.oplus.melody.common.util.A.k() && jElapsedRealtime > 2000) {
                        com.oplus.melody.common.util.A.w("DiscoveryDialogActivity", "弹窗需要优化，显示耗时 " + jElapsedRealtime + " 毫秒", r12);
                        break;
                    }
                }
                break;
        }
    }
}
