package com.oplus.melody.app.discovery;

import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0842d implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19051b;

    public /* synthetic */ C0842d(String str, int i10) {
        this.f19050a = i10;
        this.f19051b = str;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19050a) {
            case 0:
                return "m_bt_bat.showBatteryViews ALL" + this.f19051b;
            case 1:
                return "m_bt_bat.showBatteryViews ONE" + this.f19051b;
            default:
                return AbstractC0939b.E().w(this.f19051b);
        }
    }
}
