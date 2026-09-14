package com.oplus.melody.ui.component.detail.sound.settings;

import A6.g;
import F8.a;
import P9.e;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import kotlin.Metadata;

/* JADX INFO: compiled from: SoundSettingsActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0002¨\u0006\t"}, d2 = {"Lcom/oplus/melody/ui/component/detail/sound/settings/SoundSettingsActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "openFragment", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SoundSettingsActivity extends a {
    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fragment fragmentD = u().D("SoundSettingsFragment");
        if (fragmentD == null) {
            j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(e.class.getName());
        }
        fragmentD.setArguments(getIntent().getExtras());
        p pVarU = u();
        pVarU.getClass();
        g.c(pVarU, R.id.melody_ui_fragment_container, fragmentD, "SoundSettingsFragment").h(true, true);
    }
}
