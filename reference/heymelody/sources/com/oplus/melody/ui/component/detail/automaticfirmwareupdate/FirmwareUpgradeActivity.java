package com.oplus.melody.ui.component.detail.automaticfirmwareupdate;

import A6.g;
import F8.a;
import F9.s;
import J7.b;
import R8.x;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import f.e;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: FirmwareUpgradeActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/oplus/melody/ui/component/detail/automaticfirmwareupdate/FirmwareUpgradeActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "mStatementResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onStart", "openFragment", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FirmwareUpgradeActivity extends a {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final /* synthetic */ int f20639U = 0;

    public FirmwareUpgradeActivity() {
        t(new e(), new s(this, 10));
    }

    public final void I() {
        j jVarI = u().I();
        getClassLoader();
        Fragment fragmentA = jVarI.a(x.class.getName());
        h.d(fragmentA, "instantiate(...)");
        fragmentA.setArguments(getIntent().getExtras());
        p pVarU = u();
        pVarU.getClass();
        g.c(pVarU, R.id.melody_ui_fragment_container, fragmentA, "FirmwareUpgradeFragment").h(true, true);
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.melody_ui_activity_standard);
        D(R.id.activity_standard_layout_main, true);
        y((MelodyCompatToolbar) findViewById(R.id.toolbar));
        b.a().d();
        I();
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

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onStart() {
        x xVar;
        String str;
        int i10;
        EarphoneDTO earphoneDTOW;
        Fragment fragmentD = u().D("FirmwareUpgradeFragment");
        if (fragmentD != null && (str = (xVar = (x) fragmentD).f4657p) != null && (((i10 = xVar.f4640O) == 3 || i10 == 2) && ((xVar.f4660s == null || FirmwareUpgradeViewModel.d(str) != 0) && (earphoneDTOW = AbstractC0939b.E().w(str)) != null && earphoneDTOW.getConnectionState() == 2))) {
            I();
        }
        super.onStart();
    }
}
