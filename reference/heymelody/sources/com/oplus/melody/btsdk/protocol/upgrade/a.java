package com.oplus.melody.btsdk.protocol.upgrade;

import a7.AbstractC0522b;
import a7.InterfaceC0521a;
import a7.d;
import com.oplus.melody.btsdk.protocol.upgrade.UpgradeManager;
import com.oplus.melody.model.repository.earphone.C0941d;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import z7.C1725a;

/* JADX INFO: compiled from: UpgradeManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements InterfaceC0521a<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0522b f19383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UpgradeManager f19384b;

    public a(UpgradeManager upgradeManager, AbstractC0522b abstractC0522b) {
        this.f19384b = upgradeManager;
        this.f19383a = abstractC0522b;
    }

    @Override // a7.InterfaceC0521a
    public final void a(String str, List list) {
        UpgradeManager upgradeManager = this.f19384b;
        if (list == null || list.isEmpty()) {
            C1725a.m("UpgradeManager", "Can't get upgrade information from the remote ", str);
            upgradeManager.f(0, 257, str);
            return;
        }
        UpgradeManager.a aVarC = upgradeManager.c(str);
        if (aVarC == null) {
            C1725a.m("UpgradeManager", "Can't find the item when get upgrade info for device ", str);
            upgradeManager.f(0, 257, str);
            return;
        }
        Set<Integer> set = (Set) list.stream().filter(new W6.a(2)).map(new C0941d(19)).collect(Collectors.toSet());
        aVarC.f19365c = set;
        if (!set.isEmpty()) {
            upgradeManager.f(3, -1, this.f19383a);
        } else {
            C1725a.l("UpgradeManager", "No device support ota.");
            upgradeManager.f(0, 259, str);
        }
    }
}
