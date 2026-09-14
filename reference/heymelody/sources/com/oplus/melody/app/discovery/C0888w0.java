package com.oplus.melody.app.discovery;

import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.w0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0888w0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DiscoveryDialogViewModel f19211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f19212c;

    public /* synthetic */ C0888w0(DiscoveryDialogViewModel discoveryDialogViewModel, Object obj, int i10) {
        this.f19210a = i10;
        this.f19211b = discoveryDialogViewModel;
        this.f19212c = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19210a) {
            case 0:
                StringBuilder sb2 = new StringBuilder("getAttireZipConfig mDisablePersonalDress=");
                DiscoveryDialogViewModel discoveryDialogViewModel = this.f19211b;
                sb2.append(discoveryDialogViewModel.f18888g);
                sb2.append(" attireId:");
                sb2.append((String) this.f19212c);
                sb2.append(" from=");
                sb2.append(discoveryDialogViewModel.f18890j);
                return sb2.toString();
            default:
                DiscoveryDialogViewModel discoveryDialogViewModel2 = this.f19211b;
                discoveryDialogViewModel2.getClass();
                return "getDiscoveries itemSize=" + ((List) this.f19212c).size() + " from " + discoveryDialogViewModel2.f18890j;
        }
    }
}
