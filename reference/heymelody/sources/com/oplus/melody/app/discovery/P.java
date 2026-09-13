package com.oplus.melody.app.discovery;

import com.oplus.melody.common.util.ServiceUtils;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class P implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f18982b;

    public /* synthetic */ P(int i10, long j5) {
        this.f18981a = i10;
        this.f18982b = j5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        long j5 = this.f18982b;
        switch (this.f18981a) {
            case 0:
                int i10 = DiscoveryDialogActivity.f18836L0;
                return "onCreate end timeMillis=" + j5;
            case 1:
                return ServiceUtils.lambda$enableBackgroundService$1(j5);
            case 2:
                return "cleanSoundAudioCache deleteFile cost = " + (System.currentTimeMillis() - j5);
            default:
                return A6.b.d((int) j5, "onVideoEndDelayed seekTo = ");
        }
    }
}
