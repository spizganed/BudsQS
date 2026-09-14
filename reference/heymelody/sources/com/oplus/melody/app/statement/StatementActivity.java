package com.oplus.melody.app.statement;

import D7.L;
import D7.o0;
import E9.t;
import Ea.D;
import F8.a;
import F9.s;
import G7.b;
import G8.j;
import I8.DialogInterfaceOnClickListenerC0428d;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.appcompat.app.f;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.S;
import java.util.concurrent.TimeUnit;
import t8.q;

/* JADX INFO: loaded from: classes.dex */
public class StatementActivity extends a {

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public static final /* synthetic */ int f19266Z = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final t f19267U = new t(this, 10);

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public boolean f19268V = false;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public Intent f19269W = null;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public String f19270X = null;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public f f19271Y;

    @Override // android.app.Activity
    public final void finish() {
        A.b("StatementActivity", "finish: ");
        setResult(this.f19268V ? 1 : 2, this.f19269W);
        super.finish();
        overridePendingTransition(0, R.anim.coui_fade_out_fast);
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.oplus.melody.model.scan.a aVarA = com.oplus.melody.model.scan.a.a();
        int iIncrementAndGet = aVarA.f20224c.incrementAndGet();
        aVarA.c(iIncrementAndGet);
        A.c("StatementActivity", new D(iIncrementAndGet, 3));
        Intent intent = getIntent();
        if (intent != null) {
            this.f19270X = C0914u.h(intent, "route_from");
            this.f19269W = new Intent(intent);
        }
        f fVar = this.f19271Y;
        if (fVar != null && fVar.isShowing()) {
            this.f19271Y.dismiss();
        }
        DialogInterfaceOnClickListenerC0428d dialogInterfaceOnClickListenerC0428d = new DialogInterfaceOnClickListenerC0428d(this, 1);
        j jVar = new j(this, 1);
        b bVar = new b(this);
        bVar.n(R.string.melody_app_user_instructions);
        bVar.l(R.string.coui_allow_text, jVar);
        bVar.h(R.string.melody_ui_common_exit, dialogInterfaceOnClickListenerC0428d);
        int i10 = q.h() == 1 ? R.string.melody_app_permission_guide_declare_content_part : R.string.melody_app_permission_guide_declare_content;
        String string = getString(S.f(this));
        String string2 = getString(R.string.melody_app_permission_guide_declare_link_content);
        String string3 = getString(i10, string, string2);
        int iIndexOf = string3.indexOf(string2);
        int length = string2.length();
        O1.a aVar = new O1.a(this);
        aVar.f3562a = new s(this, 6);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string3);
        spannableStringBuilder.setSpan(aVar, iIndexOf, length + iIndexOf, 33);
        bVar.g(spannableStringBuilder);
        bVar.setCancelable(false);
        f fVarShow = bVar.show();
        this.f19271Y = fVarShow;
        TextView textView = (TextView) fVarShow.findViewById(android.R.id.message);
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        o0.c.f1143a.postDelayed(this.f19267U, TimeUnit.MINUTES.toMillis(1L));
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onDestroy() {
        o0.c.f1143a.removeCallbacks(this.f19267U);
        com.oplus.melody.model.scan.a aVarA = com.oplus.melody.model.scan.a.a();
        int iDecrementAndGet = aVarA.f20224c.decrementAndGet();
        aVarA.c(iDecrementAndGet);
        A.c("StatementActivity", new L(iDecrementAndGet, 9));
        super.onDestroy();
    }

    @Override // F8.a, androidx.fragment.app.f, android.app.Activity
    public final void onResume() {
        super.onResume();
        A.b("StatementActivity", "onResume: ");
        overridePendingTransition(R.anim.coui_fade_in_fast, R.anim.coui_fade_out_fast);
    }
}
