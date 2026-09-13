package com.oplus.melody.ui.base;

import F8.a;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;

/* JADX INFO: loaded from: classes3.dex */
public final class StandardActivity extends a {
    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.melody_ui_activity_standard);
        D(R.id.activity_standard_layout_main, true);
        y((MelodyCompatToolbar) findViewById(R.id.toolbar));
        Intent intent = getIntent();
        p pVarU = u();
        if (pVarU.D("melodyFragmentTag") == null) {
            String strH = C0914u.h(intent, "route_class");
            if (TextUtils.isEmpty(strH)) {
                A.h("StandardActivity", "openFragment failed from " + getCallingActivity());
                return;
            }
            j jVarI = pVarU.I();
            getClassLoader();
            Fragment fragmentA = jVarI.a(strH);
            fragmentA.setArguments(intent.getExtras());
            C0585a c0585a = new C0585a(pVarU);
            c0585a.d(R.id.melody_ui_fragment_container, fragmentA, "melodyFragmentTag");
            c0585a.h(true, true);
        }
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
