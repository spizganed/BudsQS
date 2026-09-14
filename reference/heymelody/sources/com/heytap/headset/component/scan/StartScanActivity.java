package com.heytap.headset.component.scan;

import D.g;
import D7.C0373g;
import O3.a;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup;
import com.heytap.headset.R;
import com.oplus.melody.common.util.C0909o;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import kotlin.Metadata;

/* JADX INFO: compiled from: StartScanActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0014¨\u0006\n"}, d2 = {"Lcom/heytap/headset/component/scan/StartScanActivity;", "Lcom/heytap/headset/base/HeyMelodyBaseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setCustomTheme", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StartScanActivity extends a {
    @Override // F8.a
    public final void E() {
        if (C0373g.f1086l) {
            setTheme(R.style.CombineMelodyActivityTheme);
        }
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C0909o.i(this, false, false);
        setContentView(R.layout.melody_ui_activity_standard);
        D(R.id.melody_ui_fragment_container, false);
        MelodyCompatToolbar melodyCompatToolbar = (MelodyCompatToolbar) findViewById(R.id.toolbar);
        if (melodyCompatToolbar != null) {
            y(melodyCompatToolbar);
            melodyCompatToolbar.setBackgroundColor(getColor(R.color.melody_ui_transparent));
            ViewGroup.LayoutParams layoutParams = melodyCompatToolbar.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = Ja.a.a(this);
            }
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.activity_standard_layout_main);
        if (viewGroup != null) {
            Resources resources = getResources();
            ThreadLocal<TypedValue> threadLocal = g.f872a;
            viewGroup.setBackground(resources.getDrawable(R.drawable.heymelody_app_bg_startup, null));
        }
        I(StartScanFragment.class.getName(), "StartScanFragment", null);
    }
}
