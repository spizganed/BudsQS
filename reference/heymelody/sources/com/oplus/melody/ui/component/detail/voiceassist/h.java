package com.oplus.melody.ui.component.detail.voiceassist;

import java.util.function.Supplier;
import kotlin.Pair;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoiceAssistFragmentV3 f21376b;

    public /* synthetic */ h(VoiceAssistFragmentV3 voiceAssistFragmentV3, int i10) {
        this.f21375a = i10;
        this.f21376b = voiceAssistFragmentV3;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f21375a) {
            case 0:
                return VoiceAssistFragmentV3.v(this.f21376b);
            default:
                VoiceAssistFragmentV3 voiceAssistFragmentV3 = this.f21376b;
                return new Pair(Boolean.valueOf(voiceAssistFragmentV3.B()), Boolean.valueOf(voiceAssistFragmentV3.C()));
        }
    }
}
