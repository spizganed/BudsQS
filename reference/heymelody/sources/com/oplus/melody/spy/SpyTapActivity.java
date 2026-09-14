package com.oplus.melody.spy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: SpyTapActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0015J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/oplus/melody/spy/SpyTapActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "openFragment", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "Companion", "spy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SpyTapActivity extends F8.a {
    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    @SuppressLint({"MissingInflatedId"})
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.melody_spy_activity);
        D(R.id.spy_activity_layout_main, true);
        y((MelodyCompatToolbar) findViewById(R.id.toolbar));
        Fragment fragmentD = u().D(this.f1646Q);
        if (fragmentD == null) {
            j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(SpyTapFragment.class.getName());
            h.d(fragmentD, "instantiate(...)");
        }
        fragmentD.setArguments(getIntent().getExtras());
        SpyTapFragment spyTapFragment = fragmentD instanceof SpyTapFragment ? (SpyTapFragment) fragmentD : null;
        if (spyTapFragment != null) {
            spyTapFragment.f20260z = (MelodyCompatButton) findViewById(R.id.btn_status);
        }
        p pVarU = u();
        pVarU.getClass();
        C0585a c0585a = new C0585a(pVarU);
        c0585a.d(R.id.melody_ui_fragment_container, fragmentD, null);
        c0585a.g();
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        getOnBackPressedDispatcher().c();
        return true;
    }
}
