package com.oplus.melody.btsdk.protocol.upgrade;

import D7.d0;
import a7.InterfaceC0521a;
import android.util.Pair;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.btsdk.protocol.upgrade.UpgradeManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import z7.C1725a;

/* JADX INFO: compiled from: UpgradeManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements InterfaceC0521a<VersionInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UpgradeManager f19388b;

    public c(UpgradeManager upgradeManager, int i10) {
        this.f19388b = upgradeManager;
        this.f19387a = i10;
    }

    @Override // a7.InterfaceC0521a
    public final void a(String str, List list) {
        UpgradeManager upgradeManager = this.f19388b;
        if (list == null || list.isEmpty()) {
            C1725a.f("UpgradeManager", "Can't get protocol version information from the remote.");
            upgradeManager.f(0, 259, str);
            return;
        }
        UpgradeManager.a aVarC = upgradeManager.c(str);
        if (aVarC == null) {
            C1725a.m("UpgradeManager", "Can't find the item when filter version for ", str);
            upgradeManager.f(0, 257, str);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            VersionInfo versionInfo = (VersionInfo) it.next();
            if (aVarC.f19365c.contains(Integer.valueOf(com.google.android.play.core.appupdate.c.C(versionInfo.getDeviceType())))) {
                arrayList.add(versionInfo);
            }
        }
        if (arrayList.isEmpty()) {
            C1725a.m("UpgradeManager", "No valid version for device ", str);
            upgradeManager.f(0, 257, str);
        } else {
            C1725a.d("UpgradeManager", new d0(arrayList, 5), str);
            upgradeManager.f(5, this.f19387a, Pair.create(str, arrayList));
        }
    }
}
