package com.oplus.melody.ui.component.detail.equalizer;

import A6.g;
import F8.a;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CheckBox;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.ui.widget.MelodyCompatNavigationView;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;

/* JADX INFO: loaded from: classes3.dex */
public class CustomEqActivity extends a {
    @Override // F8.a
    public final boolean F() {
        return true;
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment fragmentD = u().D("CustomEqFragment");
        if (fragmentD == null) {
            j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(g9.j.class.getName());
        }
        if (fragmentD == null) {
            throw MelodyException.e(0, "unable to create WearDetectionFragment");
        }
        fragmentD.setArguments(getIntent().getExtras());
        p pVarU = u();
        pVarU.getClass();
        g.c(pVarU, R.id.melody_ui_fragment_container, fragmentD, "CustomEqFragment").h(true, true);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        MelodyCompatToolbar melodyCompatToolbar;
        MenuItem menuItemFindItem;
        MenuItem menuItemFindItem2;
        Fragment fragmentD = u().D("CustomEqFragment");
        if (!(fragmentD instanceof g9.j)) {
            return super.onOptionsItemSelected(menuItem);
        }
        g9.j jVar = (g9.j) fragmentD;
        jVar.getClass();
        if (menuItem != null) {
            if (menuItem.getItemId() == 16908332) {
                if (jVar.x() == 1) {
                    jVar.v();
                    return true;
                }
                if (jVar.x() == 2) {
                    jVar.B();
                    return true;
                }
            } else if (menuItem.getItemId() == R.id.edit && (melodyCompatToolbar = jVar.f23382z) != null && (menuItemFindItem = melodyCompatToolbar.getMenu().findItem(R.id.edit)) != null && (menuItemFindItem2 = jVar.f23382z.getMenu().findItem(R.id.select_all)) != null) {
                jVar.f23355W.m(2);
                jVar.f23341I.setPadding(0, 0, 0, jVar.f23354V + jVar.f23377s0);
                menuItemFindItem.setVisible(false);
                menuItemFindItem2.setVisible(true);
                jVar.f23336C.setVisible(false);
                jVar.f23334A.setEnabled(false);
                jVar.f23338E.setEnabled(false);
                jVar.f23339F.setEnabled(false);
                for (int i10 = 0; i10 < jVar.f23335B.f11662c.size(); i10++) {
                    if (jVar.f23335B.h(i10) instanceof CustomEqPreference) {
                        CustomEqPreference customEqPreference = (CustomEqPreference) jVar.f23335B.h(i10);
                        customEqPreference.f(null);
                        customEqPreference.setOnPreferenceChangeListener(null);
                        CheckBox checkBox = customEqPreference.f20955c;
                        if (checkBox != null && customEqPreference.f20954b != null) {
                            checkBox.setChecked(false);
                            customEqPreference.f20954b.setChecked(false);
                            customEqPreference.f20955c.jumpDrawablesToCurrentState();
                            customEqPreference.f20954b.jumpDrawablesToCurrentState();
                        }
                        customEqPreference.setChecked(false);
                        customEqPreference.setOnPreferenceChangeListener(jVar.f23378t0);
                        customEqPreference.f20958r = true;
                        customEqPreference.h();
                    }
                }
                MelodyCompatNavigationView melodyCompatNavigationView = jVar.f23346N;
                if (melodyCompatNavigationView != null) {
                    melodyCompatNavigationView.setVisibility(0);
                }
                MenuItem menuItem2 = jVar.f23342J;
                if (menuItem2 != null) {
                    menuItem2.setEnabled(false);
                }
                jVar.f23343K.setState(0);
            }
        }
        return true;
    }
}
