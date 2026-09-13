package com.oplus.melody.btsdk.protocol.commands;

import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ byte[] f19295b;

    public /* synthetic */ a(byte[] bArr, int i10) {
        this.f19294a = i10;
        this.f19295b = bArr;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19294a) {
            case 0:
                return "parseConnectDevicesInfo length error data = " + E8.a.e(this.f19295b);
            case 1:
                return "handleReceiveHeadMotionType " + E8.a.e(this.f19295b);
            case 2:
                return "handleRecvFullDialogRecoveryTime: " + ((int) this.f19295b[0]);
            default:
                StringBuilder sb2 = new StringBuilder("setHighAudioCodecType: ");
                byte[] bArr = this.f19295b;
                sb2.append((int) bArr[0]);
                sb2.append("  ");
                sb2.append((int) bArr[1]);
                sb2.append(" ");
                sb2.append((int) bArr[2]);
                return sb2.toString();
        }
    }
}
