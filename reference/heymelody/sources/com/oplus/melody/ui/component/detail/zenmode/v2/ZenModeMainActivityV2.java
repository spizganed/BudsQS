package com.oplus.melody.ui.component.detail.zenmode.v2;

import X3.l;
import android.os.Bundle;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0909o;
import ea.AbstractActivityC1022a;
import ea.C1024c;

/* JADX INFO: loaded from: classes3.dex */
public class ZenModeMainActivityV2 extends AbstractActivityC1022a {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final /* synthetic */ int f21518d0 = 0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public C1024c f21519c0;

    @Override // ea.AbstractActivityC1022a
    public final void M(Bundle bundle) {
        A.c(this.f1646Q, new l(this, 21));
        if (this.f21519c0 == null) {
            j jVarI = u().I();
            getClassLoader();
            this.f21519c0 = (C1024c) jVarI.a(C1024c.class.getName());
        }
        this.f21519c0.setArguments(bundle);
        p pVarU = u();
        pVarU.getClass();
        C0585a c0585a = new C0585a(pVarU);
        c0585a.d(R.id.melody_ui_fragment_container, this.f21519c0, null);
        c0585a.h(true, true);
    }

    @Override // ea.AbstractActivityC1022a, F8.d, F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0909o.h(this, getColor(R.color.melody_ui_zen_mode_background_color));
        C0909o.g(this, getColor(R.color.melody_ui_zen_mode_background_color));
    }
}
