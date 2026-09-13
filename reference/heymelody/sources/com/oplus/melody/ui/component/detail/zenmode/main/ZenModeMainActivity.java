package com.oplus.melody.ui.component.detail.zenmode.main;

import X3.l;
import aa.AbstractActivityC0555b;
import android.os.Bundle;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import ba.C0742c;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;

/* JADX INFO: loaded from: classes3.dex */
public class ZenModeMainActivity extends AbstractActivityC0555b {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final /* synthetic */ int f21415d0 = 0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public C0742c f21416c0;

    @Override // aa.AbstractActivityC0555b
    public final void M(Bundle bundle) {
        A.c("ZenModeMainActivity", new l(this, 8));
        if (this.f21416c0 == null) {
            j jVarI = u().I();
            getClassLoader();
            this.f21416c0 = (C0742c) jVarI.a(C0742c.class.getName());
        }
        this.f21416c0.setArguments(bundle);
        p pVarU = u();
        pVarU.getClass();
        C0585a c0585a = new C0585a(pVarU);
        c0585a.d(R.id.melody_ui_fragment_container, this.f21416c0, null);
        c0585a.h(true, true);
    }
}
