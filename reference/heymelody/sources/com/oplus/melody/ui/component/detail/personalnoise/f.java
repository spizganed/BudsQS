package com.oplus.melody.ui.component.detail.personalnoise;

import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f21177b;

    public /* synthetic */ f(Object obj, int i10) {
        this.f21176a = i10;
        this.f21177b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f21176a) {
            case 0:
                return "CountDownTimer detect overtime, detect Fail, isStarted = " + PersonalNoiseItem.this.mViewModel.f20597l;
            default:
                return "PersonalNoiseItem: mBothInEar:" + ((n) this.f21177b).f21205p;
        }
    }
}
