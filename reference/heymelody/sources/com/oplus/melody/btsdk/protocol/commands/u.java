package com.oplus.melody.btsdk.protocol.commands;

import android.os.Message;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Message f19353b;

    public /* synthetic */ u(int i10, Message message) {
        this.f19352a = i10;
        this.f19353b = message;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19352a) {
            case 0:
                return "Not handled message " + this.f19353b.what;
            default:
                return "handleMessage " + this.f19353b.what;
        }
    }
}
