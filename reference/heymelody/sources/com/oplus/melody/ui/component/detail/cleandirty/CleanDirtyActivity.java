package com.oplus.melody.ui.component.detail.cleandirty;

import F8.d;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: CleanDirtyActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u0005H\u0014¨\u0006\u0011"}, d2 = {"Lcom/oplus/melody/ui/component/detail/cleandirty/CleanDirtyActivity;", "Lcom/oplus/melody/ui/base/BaseLoadingActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "setLoadingState", "state", "", "onRetryClick", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CleanDirtyActivity extends d {
    @Override // F8.d
    public final void J() {
        Fragment fragmentD = u().D(this.f1646Q);
        if (fragmentD instanceof CleanDirtyFragment) {
            CleanDirtyFragment cleanDirtyFragment = (CleanDirtyFragment) fragmentD;
            cleanDirtyFragment.getClass();
            A.b("CleanDirtyFragment", "onRetryClick");
            CleanDirtyViewModel cleanDirtyViewModel = cleanDirtyFragment.f20648a;
            if (cleanDirtyViewModel == null) {
                h.i("mViewModel");
                throw null;
            }
            cleanDirtyViewModel.f20659c.m(2);
            CleanDirtyViewModel cleanDirtyViewModel2 = cleanDirtyFragment.f20648a;
            if (cleanDirtyViewModel2 == null) {
                h.i("mViewModel");
                throw null;
            }
            cleanDirtyViewModel2.d(cleanDirtyFragment.f20655t, cleanDirtyFragment.f20654s);
        }
    }

    @Override // F8.d, F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p pVarU = u();
        String str = this.f1646Q;
        Fragment fragmentD = pVarU.D(str);
        if (fragmentD == null) {
            j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(CleanDirtyFragment.class.getName());
            h.d(fragmentD, "instantiate(...)");
        }
        fragmentD.setArguments(getIntent().getExtras());
        p pVarU2 = u();
        pVarU2.getClass();
        C0585a c0585a = new C0585a(pVarU2);
        c0585a.d(R.id.melody_ui_fragment_container, fragmentD, str);
        c0585a.g();
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        onBackPressed();
        return true;
    }
}
