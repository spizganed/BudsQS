package com.oplus.melody.model.db;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConnectedDeviceDao extends w<C0929m> {
    public abstract int d(C0929m c0929m);

    public abstract int e();

    public int f(C0929m c0929m) {
        long[] jArrB = b(Collections.singletonList(c0929m));
        com.oplus.melody.common.util.A.c("ConnectedDeviceDao", new C0919a(jArrB, 1));
        return (jArrB == null || jArrB.length <= 0 || jArrB[0] < 0) ? h(c0929m) : jArrB.length;
    }

    public abstract androidx.lifecycle.s<List<C0929m>> g();

    public abstract int h(C0929m c0929m);

    public abstract void i(String str, long j5);
}
