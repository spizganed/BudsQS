package com.oplus.melody.app.discovery;

import D7.C0391z;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0848f implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19063b;

    public /* synthetic */ C0848f(String str, int i10) {
        this.f19062a = i10;
        this.f19063b = str;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19062a) {
            case 0:
                return "m_bt_bat.showBatteryViews BOX only" + this.f19063b;
            default:
                C0391z c0391z = C0391z.f1171d;
                c0391z.getClass();
                return c0391z.a(C0391z.i(this.f19063b));
        }
    }
}
