package com.heytap.headset.component.mydevicelist;

import A6.g;
import F8.i;
import Wb.l;
import X7.b;
import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import c.s;
import com.heytap.headset.R;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import m4.f;

/* JADX INFO: compiled from: MyDeviceListActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/heytap/headset/component/mydevicelist/MyDeviceListActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "mAddress", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "openFragment", "fragmentClassName", "fragmentTag", "bundle", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MyDeviceListActivity extends F8.a {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public String f17417U;

    /* JADX INFO: compiled from: MyDeviceListActivity.kt */
    public static final class a extends s {
        public a() {
            super(true);
        }

        @Override // c.s
        public final void b() {
            MyDeviceListActivity myDeviceListActivity = MyDeviceListActivity.this;
            String str = myDeviceListActivity.f17417U;
            if (str == null) {
                myDeviceListActivity.finish();
                return;
            }
            Object obj = X7.b.f5996c;
            if (!b.a.a().e(str)) {
                myDeviceListActivity.finishAffinity();
            } else {
                f(false);
                myDeviceListActivity.getOnBackPressedDispatcher().c();
            }
        }
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeakHashMap<Activity, f> weakHashMap = f.f26302s;
        if (!f.a.b(this)) {
            A.h("MyDeviceListActivity", "onCreate has no must Permission, go startup page!");
            E8.a.w().getClass();
            Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
            i iVarA = i.a.a("/heymelody_app/start_up");
            iVarA.a(1);
            iVarA.b(this);
            finishAffinity();
            return;
        }
        String name = MyDeviceListFragment.class.getName();
        Bundle extras = getIntent().getExtras();
        Fragment fragmentD = u().D("MyDeviceListFragment");
        if (fragmentD == null) {
            j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(name);
        }
        if (fragmentD == null) {
            throw MelodyException.e(0, "unable to create ".concat(name));
        }
        fragmentD.setArguments(extras);
        p pVarU = u();
        pVarU.getClass();
        g.c(pVarU, R.id.melody_ui_fragment_container, fragmentD, "MyDeviceListFragment").h(true, true);
        this.f17417U = getIntent().getStringExtra("device_mac_info");
        getOnBackPressedDispatcher().a(this, new a());
    }
}
