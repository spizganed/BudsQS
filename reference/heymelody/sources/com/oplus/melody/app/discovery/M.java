package com.oplus.melody.app.discovery;

import android.os.SystemClock;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class M implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f18973c;

    public /* synthetic */ M(int i10, int i11, long j5) {
        this.f18971a = i11;
        this.f18972b = i10;
        this.f18973c = j5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        long j5 = this.f18973c;
        int i10 = this.f18972b;
        switch (this.f18971a) {
            case 0:
                int i11 = DiscoveryDialogActivity.f18836L0;
                return "seekVideoWithAnimation fadeOut seek=" + i10 + " delay=" + (SystemClock.elapsedRealtime() - j5);
            default:
                return "showNotification delay " + i10 + " delayMillis=" + j5;
        }
    }
}
