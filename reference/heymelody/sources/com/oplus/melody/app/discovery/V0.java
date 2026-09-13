package com.oplus.melody.app.discovery;

import F8.i;
import android.content.Intent;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.ui.component.control.guide.GuideEntranceFragment;
import java.util.List;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class V0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.oplus.melody.common.data.a f19010c;

    public /* synthetic */ V0(int i10, com.oplus.melody.common.data.a aVar, Object obj) {
        this.f19008a = i10;
        this.f19009b = obj;
        this.f19010c = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f19008a) {
            case 0:
                C0850f1 c0850f1 = (C0850f1) this.f19009b;
                G0.c cVar = c0850f1.f19081Q;
                if (cVar != null) {
                    cVar.z();
                } else {
                    com.oplus.melody.common.util.A.x("DiscoveryViewStateConnectedImpl", "showValidBattery mBatteryGroup is null");
                }
                c0850f1.t((C1) this.f19010c, true);
                break;
            default:
                String str = (String) this.f19009b;
                E0 e02 = (E0) this.f19010c;
                if (com.oplus.melody.common.util.S.t(C0906l.f19501a)) {
                    J7.b.a().d();
                }
                com.oplus.melody.common.util.A.c("DiscoveryViewStateConnectedImpl", new C0845e(str, 6));
                GuideEntranceFragment.GuideEntranceMode guideEntranceMode = GuideEntranceFragment.GuideEntranceMode.f20547a;
                if ("TUTORIAL_GUIDE".equals(str) || "INTRO_CONTROL_GUIDE".equals(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("device_mac_info", e02.getId());
                    intent.putExtra("device_name", e02.getName());
                    intent.putExtra("product_id", e02.getProductId());
                    intent.putExtra("product_color", String.valueOf(e02.getProductColorId()));
                    intent.putExtra("route_from", "discover");
                    intent.putExtra("route_value2", "TUTORIAL_GUIDE".equals(str));
                    E8.a.w().getClass();
                    Jb.b<List<Wb.l<String, Class<?>>>> bVar = F8.i.f1668g;
                    F8.i iVarA = i.a.a("/ui/detail");
                    iVarA.f("route_from", "DiscoveryViewStateConnectedImpl");
                    iVarA.f("device_mac_info", e02.getId());
                    iVarA.a(1);
                    iVarA.f("second_navigation", "/ui/control_guide/ear_detect");
                    iVarA.f1670b.putExtra("second_intent", intent);
                    iVarA.b(C0906l.f19501a);
                } else {
                    E8.a.w().getClass();
                    Jb.b<List<Wb.l<String, Class<?>>>> bVar2 = F8.i.f1668g;
                    F8.i iVarA2 = i.a.a("/ui/guide_entrance");
                    iVarA2.f("device_mac_info", e02.getId());
                    iVarA2.f("product_id", e02.getProductId());
                    iVarA2.f("device_name", e02.getName());
                    iVarA2.f("product_color", String.valueOf(e02.getProductColorId()));
                    iVarA2.f("route_from", "discover");
                    iVarA2.f("route_value", str);
                    iVarA2.b(C0906l.f19501a);
                }
                break;
        }
    }
}
