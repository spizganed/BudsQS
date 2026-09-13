package com.oplus.melody.btsdk.protocol.upgrade;

import Y6.a;
import a7.AbstractC0522b;
import a7.InterfaceC0521a;
import com.oplus.melody.btsdk.api.data.BatteryInfo;
import com.oplus.melody.btsdk.protocol.upgrade.UpgradeManager;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import z7.C1725a;

/* JADX INFO: compiled from: UpgradeManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements InterfaceC0521a<BatteryInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0522b f19385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UpgradeManager f19386b;

    public b(UpgradeManager upgradeManager, AbstractC0522b abstractC0522b) {
        this.f19386b = upgradeManager;
        this.f19385a = abstractC0522b;
    }

    @Override // a7.InterfaceC0521a
    public final void a(String str, List list) {
        int minOtaBattery;
        WhitelistConfigDTO.Function function;
        UpgradeManager upgradeManager = this.f19386b;
        if (list == null || list.isEmpty()) {
            C1725a.f("UpgradeManager", "No valid battery information.");
            upgradeManager.f(0, 257, str);
            return;
        }
        UpgradeManager.a aVarC = upgradeManager.c(str);
        if (aVarC == null) {
            C1725a.m("UpgradeManager", "Can't find the item when check battery", str);
            upgradeManager.f(0, 257, str);
            return;
        }
        WhitelistConfigDTO whitelistConfigDTOA = a.C0090a.f6690a.a(str);
        if (whitelistConfigDTOA == null || (function = whitelistConfigDTOA.getFunction()) == null) {
            minOtaBattery = 30;
        } else {
            minOtaBattery = function.getMinOtaBattery();
            A.a aVar = C1725a.f29476a;
            if (A.l()) {
                StringBuilder sbN = androidx.appcompat.widget.a.n(minOtaBattery, "minOtaBattery:", " mac=");
                sbN.append(A.r(str));
                C1725a.a("UpgradeManager", sbN.toString());
            }
        }
        androidx.collection.b bVar = new androidx.collection.b(aVarC.f19365c);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BatteryInfo batteryInfo = (BatteryInfo) it.next();
            if (batteryInfo.mLevel < minOtaBattery) {
                int iC = com.google.android.play.core.appupdate.c.C(batteryInfo.mDeviceType);
                if (bVar.remove(Integer.valueOf(iC))) {
                    C1725a.m("UpgradeManager", "checkBatteryLevel " + batteryInfo.mLevel + " remove " + iC, str);
                }
            }
        }
        Set<Integer> setUnmodifiableSet = Collections.unmodifiableSet(bVar);
        aVarC.f19365c = setUnmodifiableSet;
        if (!setUnmodifiableSet.isEmpty()) {
            upgradeManager.f(4, 1, this.f19385a);
        } else {
            C1725a.l("UpgradeManager", "No device is valid after check battery.");
            upgradeManager.f(0, 16, str);
        }
    }
}
