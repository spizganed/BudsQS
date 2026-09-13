package com.oplus.melody.common.util;

import android.os.SystemClock;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.common.util.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0910p implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f19509b;

    public /* synthetic */ C0910p(int i10, long j5) {
        this.f19508a = i10;
        this.f19509b = j5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        long j5 = this.f19509b;
        switch (this.f19508a) {
            case 0:
                return C0911q.a(j5);
            case 1:
                return "seekToAsync success time=" + (SystemClock.elapsedRealtime() - j5);
            case 2:
                float[] fArr = la.L.f25669Q0;
                return "drawDetectionLine, cost time: " + (System.currentTimeMillis() - j5);
            default:
                return "createTimer:" + j5;
        }
    }
}
