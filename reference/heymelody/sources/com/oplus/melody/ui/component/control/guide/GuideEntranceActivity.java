package com.oplus.melody.ui.component.control.guide;

import Ea.r;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.p;
import com.oplus.melody.ui.component.control.guide.GuideEntranceFragment;
import ka.g;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: GuideEntranceActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/oplus/melody/ui/component/control/guide/GuideEntranceActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "guideShowHelper", "Lcom/oplus/melody/ui/component/guide/GuideShowHelper;", "getGuideShowHelper", "()Lcom/oplus/melody/ui/component/guide/GuideShowHelper;", "setGuideShowHelper", "(Lcom/oplus/melody/ui/component/guide/GuideShowHelper;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "onDestroy", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GuideEntranceActivity extends F8.a {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public g f20545U;

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Bundle extras;
        super.onCreate(savedInstanceState);
        if (getResources() != null && getResources().getConfiguration() != null && getResources().getConfiguration().smallestScreenWidthDp <= 360) {
            setRequestedOrientation(1);
        }
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            finish();
            return;
        }
        g gVar = new g(null);
        this.f20545U = gVar;
        gVar.b(true);
        String string = extras.getString("route_value");
        if (string == null) {
            return;
        }
        GuideEntranceFragment.GuideEntranceMode guideEntranceModeValueOf = GuideEntranceFragment.GuideEntranceMode.valueOf(string);
        String string2 = extras.getString("product_color");
        Integer numValueOf = string2 != null ? Integer.valueOf(Integer.parseInt(string2)) : null;
        g gVar2 = this.f20545U;
        if (gVar2 != null) {
            p pVarU = u();
            h.d(pVarU, "getSupportFragmentManager(...)");
            gVar2.c(pVarU, numValueOf, extras.getString("product_id"), extras.getString("device_mac_info"), extras.getString("device_name"), guideEntranceModeValueOf, extras.getString("route_from"));
        }
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        g gVar = this.f20545U;
        if (gVar != null) {
            gVar.a();
        }
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onStop() {
        r rVar;
        super.onStop();
        g gVar = this.f20545U;
        if (gVar == null || (rVar = gVar.f25286c) == null) {
            return;
        }
        p pVarU = u();
        pVarU.getClass();
        C0585a c0585a = new C0585a(pVarU);
        c0585a.m(rVar);
        c0585a.h(true, true);
    }
}
