package com.oplus.melody.ui.component.detail.voiceassist;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0914u;
import s8.AbstractC1508a;

/* JADX INFO: loaded from: classes3.dex */
public class VoiceAssistActivity extends F8.a {
    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WhitelistConfigDTO whitelistConfigDTOA = AbstractC1508a.f().a(C0914u.h(getIntent(), "device_mac_info"));
        if (whitelistConfigDTOA == null || whitelistConfigDTOA.getFunction() == null || whitelistConfigDTOA.getFunction().getVoiceWake() != 3) {
            Fragment fragmentD = u().D("VoiceAssistFragment");
            if (fragmentD == null) {
                androidx.fragment.app.j jVarI = u().I();
                getClassLoader();
                fragmentD = jVarI.a(c.class.getName());
            }
            fragmentD.setArguments(getIntent().getExtras());
            p pVarU = u();
            pVarU.getClass();
            A6.g.c(pVarU, R.id.melody_ui_fragment_container, fragmentD, "VoiceAssistFragment").h(true, true);
            return;
        }
        Fragment fragmentD2 = u().D("VoiceAssistFragmentV3");
        if (fragmentD2 == null) {
            androidx.fragment.app.j jVarI2 = u().I();
            getClassLoader();
            fragmentD2 = jVarI2.a(VoiceAssistFragmentV3.class.getName());
        }
        fragmentD2.setArguments(getIntent().getExtras());
        p pVarU2 = u();
        pVarU2.getClass();
        A6.g.c(pVarU2, R.id.melody_ui_fragment_container, fragmentD2, "VoiceAssistFragmentV3").h(true, true);
        A.b("VoiceAssistActivity", "openFragmentV3 ok");
    }
}
