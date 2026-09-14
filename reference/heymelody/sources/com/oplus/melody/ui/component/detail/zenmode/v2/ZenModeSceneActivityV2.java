package com.oplus.melody.ui.component.detail.zenmode.v2;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0909o;
import ea.AbstractActivityC1022a;
import ea.C1027f;

/* JADX INFO: loaded from: classes3.dex */
public class ZenModeSceneActivityV2 extends AbstractActivityC1022a {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public C1027f f21520c0;

    @Override // F8.a
    public final boolean G() {
        return false;
    }

    @Override // ea.AbstractActivityC1022a
    public final void M(Bundle bundle) {
        if (A.l()) {
            StringBuilder sb2 = new StringBuilder("openFragment: (mZenModeSceneFragment == null) is ");
            sb2.append(this.f21520c0 == null);
            A.b(this.f1646Q, sb2.toString());
        }
        if (this.f21520c0 == null) {
            j jVarI = u().I();
            getClassLoader();
            this.f21520c0 = (C1027f) jVarI.a(C1027f.class.getName());
        }
        this.f21520c0.setArguments(bundle);
        p pVarU = u();
        pVarU.getClass();
        C0585a c0585a = new C0585a(pVarU);
        c0585a.d(R.id.melody_ui_fragment_container, this.f21520c0, null);
        c0585a.h(true, true);
    }

    @Override // ea.AbstractActivityC1022a, F8.d, F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0909o.i(this, false, false);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(7, 7, 7)));
    }
}
