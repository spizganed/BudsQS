package com.oplus.melody.ui.component.detail.zenmode.scene;

import aa.AbstractActivityC0555b;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.p;
import c.s;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.ui.component.detail.zenmode.scene.b;
import com.oplus.melody.ui.component.detail.zenmode.scene.e;

/* JADX INFO: loaded from: classes3.dex */
public class ZenModeSceneActivity extends AbstractActivityC0555b {

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final /* synthetic */ int f21424f0 = 0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public g f21425c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public String f21426d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public String f21427e0;

    public class a extends s {
        public a() {
            super(true);
        }

        @Override // c.s
        public final void b() {
            ZenModeSceneActivity.this.f21425c0.r();
        }
    }

    @Override // aa.AbstractActivityC0555b
    public final void M(Bundle bundle) {
        A.c("ZenModeSceneActivity", new com.oplus.melody.model.db.s(this, 7));
        g gVar = (g) u().C(R.id.melody_ui_fragment_container);
        this.f21425c0 = gVar;
        if (gVar == null) {
            androidx.fragment.app.j jVarI = u().I();
            getClassLoader();
            this.f21425c0 = (g) jVarI.a(g.class.getName());
        }
        this.f21425c0.setArguments(bundle);
        p pVarU = u();
        pVarU.getClass();
        C0585a c0585a = new C0585a(pVarU);
        c0585a.d(R.id.melody_ui_fragment_container, this.f21425c0, null);
        c0585a.h(true, true);
    }

    @Override // android.app.Activity
    public final void finish() {
        finishAndRemoveTask();
    }

    @Override // aa.AbstractActivityC0555b, F8.d, F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null || intent.getExtras() == null) {
            A.h("ZenModeSceneActivity", "onCreate intent is null");
            finishAndRemoveTask();
            return;
        }
        this.f21426d0 = C0914u.h(intent, "product_id");
        C0914u.h(intent, "device_mac_info");
        this.f21427e0 = C0914u.h(intent, "product_color");
        C0914u.h(intent, "device_name");
        Intent intent2 = getIntent();
        if (intent2 != null && (intent2.getBooleanExtra("extra_is_created_by_failure", false) || intent2.getBooleanExtra("extra_is_created_by_success", false))) {
            b.C0235b.f21441a.b(this, this.f21426d0, this.f21427e0);
        }
        getOnBackPressedDispatcher().a(this, new a());
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        e.a.f21449a.a();
    }
}
