package com.oplus.melody.ui.component.detail.highaudio;

import F8.a;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import v9.g;

/* JADX INFO: loaded from: classes3.dex */
public class HighAudioActivity extends a {
    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment fragmentD = u().D("HighAudioDetailFragment");
        if (fragmentD == null) {
            j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(g.class.getName());
        }
        fragmentD.setArguments(getIntent().getExtras());
        p pVarU = u();
        pVarU.getClass();
        A6.g.c(pVarU, R.id.melody_ui_fragment_container, fragmentD, "HighAudioDetailFragment").h(true, true);
    }
}
