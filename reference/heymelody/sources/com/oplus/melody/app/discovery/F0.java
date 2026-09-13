package com.oplus.melody.app.discovery;

import android.text.TextUtils;
import androidx.recyclerview.widget.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DiscoveryRecycleAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class F0 extends p.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f18906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f18907b;

    public F0(List list, ArrayList arrayList) {
        this.f18906a = list;
        this.f18907b = arrayList;
    }

    @Override // androidx.recyclerview.widget.p.b
    public final boolean a(int i10, int i11) {
        DiscoveryRecycleItemVO discoveryRecycleItemVO = (DiscoveryRecycleItemVO) this.f18906a.get(i10);
        DiscoveryRecycleItemVO discoveryRecycleItemVO2 = (DiscoveryRecycleItemVO) this.f18907b.get(i11);
        return TextUtils.equals(discoveryRecycleItemVO.getMacAddress(), discoveryRecycleItemVO2.getMacAddress()) && TextUtils.equals(discoveryRecycleItemVO.getProductId(), discoveryRecycleItemVO2.getProductId()) && TextUtils.equals(discoveryRecycleItemVO.getType(), discoveryRecycleItemVO2.getType()) && discoveryRecycleItemVO.getColorId() == discoveryRecycleItemVO2.getColorId();
    }

    @Override // androidx.recyclerview.widget.p.b
    public final boolean b(int i10, int i11) {
        return TextUtils.equals(((DiscoveryRecycleItemVO) this.f18906a.get(i10)).getMacAddress(), ((DiscoveryRecycleItemVO) this.f18907b.get(i11)).getMacAddress());
    }

    @Override // androidx.recyclerview.widget.p.b
    public final int d() {
        return this.f18907b.size();
    }

    @Override // androidx.recyclerview.widget.p.b
    public final int e() {
        return this.f18906a.size();
    }
}
