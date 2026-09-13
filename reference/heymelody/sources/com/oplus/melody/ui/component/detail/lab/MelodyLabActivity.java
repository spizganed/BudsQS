package com.oplus.melody.ui.component.detail.lab;

import A6.g;
import F8.a;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import x9.C1674a;

/* JADX INFO: loaded from: classes3.dex */
public class MelodyLabActivity extends a {
    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment fragmentD = u().D("MelodyLabFragment");
        if (fragmentD == null) {
            j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(C1674a.class.getName());
        }
        fragmentD.setArguments(getIntent().getExtras());
        p pVarU = u();
        pVarU.getClass();
        g.c(pVarU, R.id.melody_ui_fragment_container, fragmentD, "MelodyLabFragment").h(true, true);
    }
}
