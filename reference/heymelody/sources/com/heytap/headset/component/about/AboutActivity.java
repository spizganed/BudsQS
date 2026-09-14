package com.heytap.headset.component.about;

import A6.g;
import Ba.b;
import D7.C0373g;
import F8.a;
import P3.e;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import kotlin.Metadata;

/* JADX INFO: compiled from: AboutActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0014J\"\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0014¨\u0006\u0012"}, d2 = {"Lcom/heytap/headset/component/about/AboutActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setCustomTheme", "openFragment", "fragmentClassName", "", "fragmentTag", "bundle", "onNetworkChanged", SpeechFindManager.TYPE, "", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class AboutActivity extends a {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final /* synthetic */ int f17357U = 0;

    @Override // F8.a
    public final void B(int i10) {
        super.B(i10);
        A.c("AboutActivity", new b(i10, 10));
        if (i10 >= 0) {
            J7.b.a().d();
        }
    }

    @Override // F8.a
    public final void E() {
        if (C0373g.f1086l) {
            setTheme(R.style.CombineMelodyPreferenceTheme);
        }
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String name = e.class.getName();
        Fragment fragmentD = u().D("AboutFragment");
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
        g.c(pVarU, R.id.melody_ui_fragment_container, fragmentD, "AboutFragment").h(true, true);
    }
}
