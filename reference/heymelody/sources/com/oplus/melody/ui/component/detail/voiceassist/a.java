package com.oplus.melody.ui.component.detail.voiceassist;

import D7.o0;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.component.detail.freedialog.FreeDialogItem;
import com.oplus.melody.ui.component.detail.headmotion.HeadMotionFragment;
import com.oplus.melody.ui.component.detail.hearingoptimize.HearingOptimizeItem;
import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f21350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f21351c;

    public /* synthetic */ a(Object obj, boolean z2, int i10) {
        this.f21349a = i10;
        this.f21351c = obj;
        this.f21350b = z2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        switch (this.f21349a) {
            case 0:
                COUISwitchPreference cOUISwitchPreference = ((c) this.f21351c).f21362I;
                boolean z2 = this.f21350b;
                cOUISwitchPreference.setChecked(!z2);
                A.i("VoiceAssistFragment", "setIncomingCallControlEnable failed, enable: " + z2, th);
                return null;
            case 1:
                VoiceAssistFragmentV3 voiceAssistFragmentV3 = (VoiceAssistFragmentV3) this.f21351c;
                boolean z4 = this.f21350b;
                o0.d(new com.google.android.material.internal.e(voiceAssistFragmentV3, z4, 1));
                A.i("VoiceAssistFragmentV3", "setVoiceWakeEnable, enable: " + z4 + ", error: ", th);
                return null;
            case 2:
                return FreeDialogItem.setFreeDialogModeEnable$lambda$2((FreeDialogItem) this.f21351c, this.f21350b, th);
            case 3:
                A.i("HeadMotionFragment", "setHeadMotionEnable error", th);
                HeadMotionFragment headMotionFragment = (HeadMotionFragment) this.f21351c;
                androidx.fragment.app.f activity = headMotionFragment.getActivity();
                if (activity == null) {
                    return null;
                }
                activity.runOnUiThread(new com.google.android.material.internal.e(this.f21350b, headMotionFragment));
                return null;
            default:
                return HearingOptimizeItem.setHearingOptimizeEnable$lambda$2((HearingOptimizeItem) this.f21351c, this.f21350b, th);
        }
    }

    public /* synthetic */ a(boolean z2, VoiceAssistFragmentV3 voiceAssistFragmentV3) {
        this.f21349a = 1;
        this.f21350b = z2;
        this.f21351c = voiceAssistFragmentV3;
    }
}
