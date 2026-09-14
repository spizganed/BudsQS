package com.oplus.melody.app.statement;

import D7.l0;
import Q7.n;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import e.C0984e;
import e.InterfaceC0980a;
import f.e;

/* JADX INFO: loaded from: classes.dex */
public class MyDeviceStatementRqActivity extends F8.a {

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final /* synthetic */ int f19252V = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final C0984e f19253U = (C0984e) t(new e(), new a());

    public class a implements InterfaceC0980a {
        public a() {
        }

        @Override // e.InterfaceC0980a
        public final void h(Object obj) {
            Object obj2 = n.f4193c;
            n.a.a().s(false);
            if (obj instanceof ActivityResult) {
                A.c("MyDeviceStatementRqActivity", new l0(obj, 1));
                if (((ActivityResult) obj).getResultCode() == -1) {
                    n.a.a().r(100, true);
                } else {
                    n.a.a().r(101, true);
                }
            } else {
                n.a.a().r(-1, true);
                A.h("MyDeviceStatementRqActivity", "onActivityResult not instanceof ActivityResult, result = " + obj);
            }
            MyDeviceStatementRqActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(R.anim.coui_center_dialog_enter, R.anim.coui_center_dialog_exit);
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        A.c("MyDeviceStatementRqActivity", new L6.a(0, bundle));
        A.b("MyDeviceStatementRqActivity", "showUserStatement");
        try {
            Intent intent = new Intent();
            intent.setAction("com.oplus.mydevices.action.USER_STATEMENT");
            intent.setPackage("com.heytap.mydevices");
            this.f19253U.a(intent);
        } catch (ActivityNotFoundException e10) {
            A.i("MyDeviceStatementRqActivity", "showUserStatement", e10);
        }
        Object obj = n.f4193c;
        n.a.a().s(true);
    }
}
