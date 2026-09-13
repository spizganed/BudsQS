package com.oplus.melody.model.db;

import q1.InterfaceC1431a;

/* JADX INFO: renamed from: com.oplus.melody.model.db.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0925g implements Wb.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConnectedDeviceDao_Impl f19767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0929m f19768c;

    public /* synthetic */ C0925g(ConnectedDeviceDao_Impl connectedDeviceDao_Impl, C0929m c0929m, int i10) {
        this.f19766a = i10;
        this.f19767b = connectedDeviceDao_Impl;
        this.f19768c = c0929m;
    }

    @Override // Wb.l
    public final Object d(Object obj) {
        switch (this.f19766a) {
            case 0:
                return Integer.valueOf(super/*com.oplus.melody.model.db.ConnectedDeviceDao*/.f(this.f19768c));
            default:
                return Integer.valueOf(this.f19767b.f19674c.i((InterfaceC1431a) obj, this.f19768c));
        }
    }
}
