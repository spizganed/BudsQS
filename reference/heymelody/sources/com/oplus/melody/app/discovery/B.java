package com.oplus.melody.app.discovery;

import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class B implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18819b;

    public /* synthetic */ B(Object obj, int i10) {
        this.f18818a = i10;
        this.f18819b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        Object obj = this.f18819b;
        switch (this.f18818a) {
            case 0:
                int i10 = DiscoveryDialogActivity.f18836L0;
                return AbstractC0939b.E().z(((E0) obj).getId());
            default:
                return "bindOrUnbindAccount resultCode is " + ((Integer) obj);
        }
    }
}
