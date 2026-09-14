package com.oplus.melody.app.discovery;

import java.util.function.Function;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.m0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0869m0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f19142c;

    public /* synthetic */ C0869m0(int i10, String str, int i11) {
        this.f19140a = i10;
        this.f19141b = str;
        this.f19142c = i11;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        E0 e02 = (E0) obj;
        int i10 = this.f19140a;
        String str = this.f19141b;
        if (e02 == null) {
            Y.r.l(str, "DiscoveryDialogViewModel", androidx.appcompat.widget.a.n(i10, "setDiscoveryState ", " failed, earphone is null. macAddress="));
            return null;
        }
        int i11 = this.f19142c;
        if (i11 != 0 && i11 != e02.getDiscoveryState()) {
            StringBuilder sbM = androidx.appcompat.widget.a.m(i10, i11, "setDiscoveryState ", " failed, expect old=", " but now=");
            sbM.append(e02.getDiscoveryState());
            sbM.append(" macAddress=");
            sbM.append(com.oplus.melody.common.util.A.r(str));
            com.oplus.melody.common.util.A.x("DiscoveryDialogViewModel", sbM.toString());
            return e02;
        }
        E0 e03 = (E0) com.oplus.melody.common.data.a.copyOf(e02, E0.class);
        e03.setDiscoveryState(i10);
        if (com.oplus.melody.common.util.A.l()) {
            StringBuilder sbN = androidx.appcompat.widget.a.n(i10, "setDiscoveryState ", " macAddress=");
            sbN.append(com.oplus.melody.common.util.A.r(str));
            sbN.append(" hashCode=");
            sbN.append(e03.hashCode());
            com.oplus.melody.common.util.A.b("DiscoveryDialogViewModel", sbN.toString());
        }
        return e03;
    }
}
