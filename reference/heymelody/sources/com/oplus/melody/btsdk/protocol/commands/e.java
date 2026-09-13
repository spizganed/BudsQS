package com.oplus.melody.btsdk.protocol.commands;

import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f19300c;

    public /* synthetic */ e(int i10, int i11, boolean z2) {
        this.f19298a = i11;
        this.f19299b = i10;
        this.f19300c = z2;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19298a) {
            case 0:
                return "GAME_MODE_CHANGED gameMode = " + this.f19299b + ", shouldOffset2 = " + this.f19300c;
            case 1:
                return "setGameSoundTypeEnable  complete, type = " + this.f19299b + " enable:" + this.f19300c;
            default:
                return "onCheckCodecTypeChanged " + this.f19299b + " isApplying:" + this.f19300c;
        }
    }
}
