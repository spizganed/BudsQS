package com.oplus.melody.ui.component.detail.voiceassist;

import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class l implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoiceAssistFragmentV3 f21384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f21385c;

    public /* synthetic */ l(VoiceAssistFragmentV3 voiceAssistFragmentV3, long j5, int i10) {
        this.f21383a = i10;
        this.f21384b = voiceAssistFragmentV3;
        this.f21385c = j5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f21383a) {
            case 0:
                return "initVoiceAssist ok, isAssistInit: " + this.f21384b.f21336z + ", cost: " + (System.currentTimeMillis() - this.f21385c);
            default:
                return "isVoiceWakeOpen, isAssistInit: " + this.f21384b.f21336z + ", cost: " + (System.currentTimeMillis() - this.f21385c);
        }
    }
}
