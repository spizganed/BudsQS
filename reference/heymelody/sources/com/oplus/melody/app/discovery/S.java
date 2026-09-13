package com.oplus.melody.app.discovery;

import androidx.viewpager2.widget.ViewPager2;
import com.oplus.melody.app.discovery.DiscoveryDialogViewModel;

/* JADX INFO: compiled from: DiscoveryDialogActivity.java */
/* JADX INFO: loaded from: classes.dex */
public final class S extends ViewPager2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiscoveryDialogActivity f18991a;

    public S(DiscoveryDialogActivity discoveryDialogActivity) {
        this.f18991a = discoveryDialogActivity;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public final void c(int i10) {
        DiscoveryDialogActivity discoveryDialogActivity = this.f18991a;
        int size = discoveryDialogActivity.f18869p0.f18900d.size();
        if (i10 < 0 || i10 >= size) {
            com.oplus.melody.common.util.A.x("DiscoveryDialogActivity", "onPageSelected out of bounds index=" + i10 + " size=" + size);
            return;
        }
        com.oplus.melody.common.util.A.c("DiscoveryDialogActivity", new Ba.b(i10, 24));
        DiscoveryDialogViewModel discoveryDialogViewModel = discoveryDialogActivity.f18853Z;
        DiscoveryRecycleItemVO discoveryRecycleItemVO = discoveryDialogActivity.f18869p0.f18900d.get(i10);
        discoveryDialogViewModel.getClass();
        DiscoveryDialogViewModel.b bVar = new DiscoveryDialogViewModel.b();
        bVar.setMacAddress(discoveryRecycleItemVO.getMacAddress());
        bVar.setIndex(i10);
        discoveryDialogViewModel.f18883b.l(bVar);
    }
}
