package com.heytap.headset.component.scan;

import D7.C0373g;
import O3.a;
import X3.C0493a;
import android.os.Bundle;
import com.heytap.headset.R;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import kotlin.Metadata;

/* JADX INFO: compiled from: ConnectGuideActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0014¨\u0006\t"}, d2 = {"Lcom/heytap/headset/component/scan/ConnectGuideActivity;", "Lcom/heytap/headset/base/HeyMelodyBaseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setCustomTheme", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class ConnectGuideActivity extends a {
    @Override // F8.a
    public final void E() {
        if (C0373g.f1086l) {
            setTheme(R.style.CombineMelodyActivityTheme);
        }
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.melody_ui_activity_standard);
        D(R.id.activity_standard_layout_main, true);
        MelodyCompatToolbar melodyCompatToolbar = (MelodyCompatToolbar) findViewById(R.id.toolbar);
        if (melodyCompatToolbar != null) {
            y(melodyCompatToolbar);
        }
        I(C0493a.class.getName(), "ConnectGuideFragment", null);
    }
}
