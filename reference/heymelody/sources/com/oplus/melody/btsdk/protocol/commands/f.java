package com.oplus.melody.btsdk.protocol.commands;

import com.oplus.melody.btsdk.api.data.NoiseReductionInfo;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NoiseReductionInfo f19302b;

    public /* synthetic */ f(NoiseReductionInfo noiseReductionInfo, int i10) {
        this.f19301a = i10;
        this.f19302b = noiseReductionInfo;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19301a) {
            case 0:
                return "Receive Earbuds noise reduction data = " + this.f19302b;
            default:
                return "Receive Earbuds support noise reduction data = " + this.f19302b;
        }
    }
}
