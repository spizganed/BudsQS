package com.oplus.melody.ui.component.tutorialguide.noise;

import F8.a;
import android.os.Bundle;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import kotlin.Metadata;

/* JADX INFO: compiled from: TutorialGuideNoiseActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0006\u0010\b\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/oplus/melody/ui/component/tutorialguide/noise/TutorialGuideNoiseActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "openFragment", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TutorialGuideNoiseActivity extends a {
    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.melody_ui_activity_standard);
        D(R.id.activity_standard_layout_main, true);
        y((MelodyCompatToolbar) findViewById(R.id.toolbar));
        Fragment fragmentD = u().D("TutorialGuideNoiseFragment");
        if (fragmentD == null) {
            j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(TutorialGuideNoiseFragment.class.getName());
        }
        p pVarU = u();
        pVarU.getClass();
        C0585a c0585a = new C0585a(pVarU);
        c0585a.d(R.id.melody_ui_fragment_container, fragmentD, "TutorialGuideNoiseFragment");
        c0585a.h(true, true);
    }
}
