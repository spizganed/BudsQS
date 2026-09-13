package com.oplus.melody.ui.component.finddevice;

import A6.g;
import F8.a;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.O;
import com.oplus.melody.common.util.P;
import fa.l;

/* JADX INFO: loaded from: classes3.dex */
public class FindDeviceActivity extends a {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final /* synthetic */ int f21521U = 0;

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment fragmentD = u().D("FindDeviceFragment");
        if (fragmentD == null) {
            j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(l.class.getName());
        }
        if (fragmentD == null) {
            throw MelodyException.e(0, "unable to create FindDeviceFragment");
        }
        fragmentD.setArguments(getIntent().getExtras());
        p pVarU = u();
        pVarU.getClass();
        g.c(pVarU, R.id.melody_ui_fragment_container, fragmentD, "FindDeviceFragment").h(true, true);
    }

    @Override // c.i, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // F8.a, androidx.fragment.app.f, android.app.Activity
    public final void onResume() {
        super.onResume();
        int intExtra = getIntent().getIntExtra("notification_id", 0);
        if (intExtra > 0) {
            P p6 = P.f19456a;
            P.a(this, intExtra);
        }
        A.c("FindDeviceActivity", new O(intExtra, 4));
    }
}
