package com.oplus.melody.ui.component.detail.voiceassist;

import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoiceAssistFragmentV3 f21382b;

    public /* synthetic */ k(VoiceAssistFragmentV3 voiceAssistFragmentV3, int i10) {
        this.f21381a = i10;
        this.f21382b = voiceAssistFragmentV3;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f21381a) {
            case 0:
                return Boolean.valueOf(this.f21382b.B());
            default:
                return "initVoiceAssist, call and msg not support, remove " + this.f21382b.f21329O;
        }
    }
}
