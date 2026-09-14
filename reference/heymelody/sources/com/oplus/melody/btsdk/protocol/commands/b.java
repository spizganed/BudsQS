package com.oplus.melody.btsdk.protocol.commands;

import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ byte[] f19297b;

    public /* synthetic */ b(byte[] bArr, int i10) {
        this.f19296a = i10;
        this.f19297b = bArr;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19296a) {
            case 0:
                return "parseNoiseReductionResult: Length is not valid when receive PersonalizedNoiseReductionResult, length =" + this.f19297b.length;
            default:
                return "handleRecvFullDialogRecoveryTime: " + ((int) this.f19297b[1]);
        }
    }
}
