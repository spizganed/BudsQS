package com.oplus.melody.model.scan;

import D1.f;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: DiscoveryActionManager.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends K7.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f20224c;

    public a() {
        super(20000);
        this.f20224c = new AtomicInteger(0);
    }

    public static a a() {
        return (a) f.r(a.class);
    }

    public abstract boolean b();

    public void c(int i10) {
        this.f20224c.set(i10);
    }

    public abstract void d(String str, boolean z2);

    public abstract void e(boolean z2);
}
