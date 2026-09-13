package com.heytap.headset.component.supporteddevices;

import A6.g;
import F8.a;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: SupportedDevicesActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\"\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006\r"}, d2 = {"Lcom/heytap/headset/component/supporteddevices/SupportedDevicesActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "openFragment", "fragmentClassName", "", "fragmentTag", "bundle", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SupportedDevicesActivity extends a {
    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.melody_ui_activity_standard);
        D(R.id.activity_standard_layout_main, true);
        View viewFindViewById = findViewById(R.id.toolbar);
        h.d(viewFindViewById, "findViewById(...)");
        y((MelodyCompatToolbar) viewFindViewById);
        String name = SupportedDevicesFragment.class.getName();
        Fragment fragmentD = u().D("SupportedDevicesFragment");
        if (fragmentD == null) {
            j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(name);
        }
        if (fragmentD == null) {
            throw MelodyException.e(0, "unable to create ".concat(name));
        }
        fragmentD.setArguments(null);
        p pVarU = u();
        pVarU.getClass();
        g.c(pVarU, R.id.melody_ui_fragment_container, fragmentD, "SupportedDevicesFragment").h(true, true);
    }
}
