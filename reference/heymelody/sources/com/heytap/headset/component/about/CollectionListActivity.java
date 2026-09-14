package com.heytap.headset.component.about;

import A6.g;
import D7.C0373g;
import F8.a;
import P3.k;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import com.oplus.melody.common.helper.MelodyException;
import kotlin.Metadata;

/* JADX INFO: compiled from: CollectionListActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0014J\"\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/heytap/headset/component/about/CollectionListActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setCustomTheme", "openFragment", "fragmentClassName", "", "fragmentTag", "bundle", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CollectionListActivity extends a {
    @Override // F8.a
    public final void E() {
        if (C0373g.f1086l) {
            setTheme(R.style.CombineMelodyPreferenceTheme);
        }
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String name = k.class.getName();
        Fragment fragmentD = u().D("CollectionListFragment");
        if (fragmentD == null) {
            j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(name);
        }
        if (fragmentD == null) {
            throw MelodyException.e(0, "unable to create ".concat(name));
        }
        fragmentD.setArguments(null);
        p pVarU = u();
        pVarU.getClass();
        g.c(pVarU, R.id.melody_ui_fragment_container, fragmentD, "CollectionListFragment").h(true, true);
    }
}
