package com.oplus.melody.ui.component.detail.voiceassist;

import D7.o0;
import Wb.p;
import X3.w;
import androidx.preference.PreferenceScreen;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.oplus.melody.common.util.A;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoiceAssistFragmentV3 f21378b;

    public /* synthetic */ i(VoiceAssistFragmentV3 voiceAssistFragmentV3, int i10) {
        this.f21377a = i10;
        this.f21378b = voiceAssistFragmentV3;
    }

    @Override // Wb.p
    public final Object invoke(Object obj, Object obj2) {
        PreferenceScreen preferenceScreen;
        PreferenceScreen preferenceScreen2;
        COUIPreferenceCategory cOUIPreferenceCategory;
        switch (this.f21377a) {
            case 0:
                VoiceAssistFragmentV3 voiceAssistFragmentV3 = this.f21378b;
                if (VoiceAssistFragmentV3.z() && VoiceAssistFragmentV3.A()) {
                    o0.b.f1142a.schedule(new w(voiceAssistFragmentV3, 20), 500L, TimeUnit.MILLISECONDS);
                    COUIPreferenceCategory cOUIPreferenceCategory2 = voiceAssistFragmentV3.f21321F;
                    if (cOUIPreferenceCategory2 != null) {
                        cOUIPreferenceCategory2.setVisible(true);
                    }
                } else {
                    COUIPreferenceCategory cOUIPreferenceCategory3 = voiceAssistFragmentV3.f21321F;
                    if (cOUIPreferenceCategory3 != null && (preferenceScreen2 = voiceAssistFragmentV3.f11713b.f11752g) != null) {
                        preferenceScreen2.j(cOUIPreferenceCategory3);
                    }
                    COUIPreferenceCategory cOUIPreferenceCategory4 = voiceAssistFragmentV3.f21323I;
                    if (cOUIPreferenceCategory4 != null && (preferenceScreen = voiceAssistFragmentV3.f11713b.f11752g) != null) {
                        preferenceScreen.j(cOUIPreferenceCategory4);
                    }
                    A.c("VoiceAssistFragmentV3", new g(voiceAssistFragmentV3, 2));
                }
                if (!VoiceAssistFragmentV3.x()) {
                    COUIJumpPreference cOUIJumpPreference = voiceAssistFragmentV3.f21329O;
                    if (cOUIJumpPreference != null && (cOUIPreferenceCategory = voiceAssistFragmentV3.f21327M) != null) {
                        cOUIPreferenceCategory.j(cOUIJumpPreference);
                    }
                    A.c("VoiceAssistFragmentV3", new k(voiceAssistFragmentV3, 1));
                }
                break;
            case 1:
                Pair pair = (Pair) obj;
                this.f21378b.s(((Boolean) pair.e()).booleanValue(), ((Boolean) pair.f()).booleanValue());
                break;
            default:
                Pair pair2 = (Pair) obj;
                this.f21378b.s(((Boolean) pair2.e()).booleanValue(), ((Boolean) pair2.f()).booleanValue());
                break;
        }
        return Jb.l.f2618a;
    }
}
