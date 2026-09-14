package com.oplus.melody.common.util;

import D7.q0;
import androidx.media3.exoplayer.C0625v;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.common.util.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0899e implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f19488c;

    public /* synthetic */ C0899e(String str, boolean z2, int i10) {
        this.f19486a = i10;
        this.f19487b = str;
        this.f19488c = z2;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19486a) {
            case 0:
                return "isSupportQuickPhoto support=" + this.f19488c + ", packageName=" + this.f19487b;
            case 1:
                com.google.android.play.core.appupdate.c.R(C0906l.f19501a, this.f19487b, this.f19488c);
                return new q0(5L, TimeUnit.SECONDS);
            case 2:
                com.google.android.play.core.appupdate.c.U(C0906l.f19501a, this.f19487b, 11, this.f19488c, true);
                return new q0(5L, TimeUnit.SECONDS);
            default:
                StringBuilder sb2 = new StringBuilder("handleHighPriorityChanged isAuto = ");
                sb2.append(this.f19488c);
                sb2.append(", adr = ");
                return C0625v.i(this.f19487b, sb2);
        }
    }

    public /* synthetic */ C0899e(boolean z2, String str, int i10) {
        this.f19486a = i10;
        this.f19488c = z2;
        this.f19487b = str;
    }
}
