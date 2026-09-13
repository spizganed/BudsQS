package com.oplus.melody.ui.component.control;

import G8.q;
import G8.y;
import android.os.Bundle;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import s8.AbstractC1508a;

/* JADX INFO: loaded from: classes3.dex */
public class EarControlActivity extends F8.a {

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final /* synthetic */ int f20411V = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public Fragment f20412U;

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.melody_ui_activity_standard);
        D(R.id.activity_standard_layout_main, true);
        y((MelodyCompatToolbar) findViewById(R.id.toolbar));
        p pVarU = u();
        this.f20412U = pVarU.D("earControlFragment");
        A.c("EarControlActivity", new B6.a(this, 10));
        if (this.f20412U == null) {
            String strH = C0914u.h(getIntent(), "device_name");
            WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(C0914u.h(getIntent(), "product_id"), strH);
            if (whitelistConfigDTOC == null || !"N".equals(whitelistConfigDTOC.getType())) {
                j jVarI = pVarU.I();
                getClassLoader();
                this.f20412U = jVarI.a(q.class.getName());
            } else {
                j jVarI2 = pVarU.I();
                getClassLoader();
                this.f20412U = jVarI2.a(y.class.getName());
            }
        }
        this.f20412U.setArguments(getIntent().getExtras());
        C0585a c0585a = new C0585a(pVarU);
        c0585a.d(R.id.melody_ui_fragment_container, this.f20412U, "earControlFragment");
        c0585a.h(true, true);
    }
}
