package com.heytap.headset.component.scan;

import D7.C0373g;
import D7.o0;
import E8.a;
import F8.i;
import Jb.b;
import Wb.l;
import X3.e;
import X3.f;
import X3.g;
import X7.b;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: ScanFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ScanFragment$onViewCreated$2$1 extends FunctionReferenceImpl implements l<List<? extends f>, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(List<? extends f> list) {
        String macAddress;
        String macAddress2;
        int i10 = 0;
        List<? extends f> p02 = list;
        h.e(p02, "p0");
        ScanFragment scanFragment = (ScanFragment) this.receiver;
        scanFragment.getClass();
        Iterator<? extends f> it = p02.iterator();
        while (true) {
            if (it.hasNext()) {
                f next = it.next();
                A.f("ScanFragment", "onScanItemListChange scanDevice = " + next);
                f fVar = scanFragment.f17510F;
                if (fVar != null) {
                    if (h.a(fVar.getMacAddress(), next.getMacAddress())) {
                        f fVar2 = scanFragment.f17510F;
                        if (fVar2 == null || fVar2.getConnectionState() != next.getConnectionState()) {
                            androidx.appcompat.app.f fVar3 = scanFragment.H;
                            boolean z2 = fVar3 != null && fVar3.isShowing();
                            if (next.getConnectionState() == 2) {
                                scanFragment.f17510F = null;
                                if (C0373g.f1086l) {
                                    a.w().getClass();
                                    b<List<l<String, Class<?>>>> bVar = i.f1668g;
                                    i iVarA = i.a.a("/heymelody_app/device_list_combine");
                                    iVarA.a(1);
                                    iVarA.f("route_from", "ScanFragment");
                                    iVarA.b(scanFragment.requireActivity());
                                } else {
                                    Object obj = X7.b.f5996c;
                                    X7.b bVarA = b.a.a();
                                    String macAddress3 = next.getMacAddress();
                                    h.b(macAddress3);
                                    bVarA.d(macAddress3, next.getDeviceName(), next.getProductId(), next.getCoverImage());
                                    a.w().getClass();
                                    Jb.b<List<l<String, Class<?>>>> bVar2 = i.f1668g;
                                    i iVarA2 = i.a.a("/ui/detail");
                                    iVarA2.f("device_mac_info", next.getMacAddress());
                                    iVarA2.f("device_name", next.getDeviceName());
                                    iVarA2.a(1);
                                    iVarA2.b(scanFragment.requireActivity());
                                }
                                scanFragment.requireActivity().finishAffinity();
                            } else if (next.getConnectionState() == 5) {
                                if (!z2) {
                                    a.S(scanFragment.requireContext(), R.string.melody_ui_connect_fail_toast);
                                    scanFragment.f17510F = null;
                                }
                            } else if (next.getConnectionState() == 3) {
                                if (!z2) {
                                    scanFragment.f17510F = null;
                                    A.b("ScanFragment", "onScanItemListChange connectionState is DISCONNECTED");
                                }
                            } else if (next.getConnectionState() == 0 && !z2) {
                                scanFragment.f17510F = null;
                                A.b("ScanFragment", "onScanItemListChange connectionState is NONE");
                            }
                        }
                        f fVar4 = scanFragment.f17510F;
                        if (!h.a(fVar4 != null ? fVar4.getPariState() : null, next.getPariState())) {
                            Integer pariState = next.getPariState();
                            if (pariState != null && pariState.intValue() == 1) {
                                f fVar5 = scanFragment.f17510F;
                                if (fVar5 != null) {
                                    fVar5.setPariState(1);
                                }
                                f fVar6 = scanFragment.f17510F;
                                if (fVar6 != null && (macAddress2 = fVar6.getMacAddress()) != null) {
                                    if (scanFragment.f17508D != null) {
                                        AbstractC0939b.E().f(macAddress2);
                                    }
                                    androidx.appcompat.app.f fVar7 = scanFragment.H;
                                    if (fVar7 != null && fVar7.isShowing()) {
                                        fVar7.dismiss();
                                    }
                                }
                            } else {
                                Integer pariState2 = next.getPariState();
                                if (pariState2 != null && pariState2.intValue() == 4) {
                                    f fVar8 = scanFragment.f17510F;
                                    if (fVar8 != null) {
                                        fVar8.setPariState(next.getPariState());
                                    }
                                    f fVar9 = scanFragment.f17510F;
                                    if (fVar9 != null && (macAddress = fVar9.getMacAddress()) != null && scanFragment.f17508D != null) {
                                        AbstractC0939b.E().f(macAddress);
                                    }
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                } else if (C0373g.f1086l && !scanFragment.f17509E && h.a(scanFragment.f17511G, next.getMacAddress()) && next.getConnectionState() == 2) {
                    if (scanFragment.isResumed()) {
                        a.w().getClass();
                        Jb.b<List<l<String, Class<?>>>> bVar3 = i.f1668g;
                        i iVarA3 = i.a.a("/heymelody_app/device_list_combine");
                        iVarA3.a(1);
                        iVarA3.f("route_from", "ScanFragment");
                        iVarA3.b(scanFragment.requireActivity());
                        scanFragment.requireActivity().finishAffinity();
                    } else {
                        scanFragment.f17520Q = true;
                    }
                }
            } else {
                if (!p02.isEmpty()) {
                    o0.c.f1143a.postDelayed(new g(scanFragment, i10), 200L);
                }
                if (scanFragment.f17516M) {
                    e eVar = scanFragment.f17507C;
                    if (eVar == null) {
                        h.i("mScanDeviceAdapter");
                        throw null;
                    }
                    eVar.d(p02);
                }
            }
        }
        return Jb.l.f2618a;
    }
}
