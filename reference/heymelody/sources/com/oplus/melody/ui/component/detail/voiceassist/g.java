package com.oplus.melody.ui.component.detail.voiceassist;

import java.util.function.Supplier;
import kotlin.Pair;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoiceAssistFragmentV3 f21374b;

    public /* synthetic */ g(VoiceAssistFragmentV3 voiceAssistFragmentV3, int i10) {
        this.f21373a = i10;
        this.f21374b = voiceAssistFragmentV3;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f21373a) {
            case 0:
                return A6.e.f("onCreate mIsInTutorialGuide ", this.f21374b.f21333S);
            case 1:
                VoiceAssistFragmentV3 voiceAssistFragmentV3 = this.f21374b;
                return new Pair(Boolean.valueOf(voiceAssistFragmentV3.B()), Boolean.valueOf(voiceAssistFragmentV3.C()));
            default:
                return "initVoiceAssist, voice wake not support remove " + this.f21374b.f21321F;
        }
    }
}
