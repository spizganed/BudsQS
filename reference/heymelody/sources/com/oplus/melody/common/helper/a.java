package com.oplus.melody.common.helper;

import B9.d;
import android.text.TextUtils;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.F;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Wb.a {
    @Override // Wb.a
    public final Object invoke() {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        if (TextUtils.equals(heyMelodyApplication.getPackageName(), E7.a.c(heyMelodyApplication))) {
            Nc.a aVar = Pc.a.f4080b;
            if (aVar != null) {
                return new MelodyAlivePreferencesHelper$sharedPreferencesGetter$1(1, (F) ((Wc.b) aVar.f3515c).f5616d.b(j.a(F.class), null, null), F.class, "getSharedPreferences", "getSharedPreferences(Ljava/lang/String;)Landroid/content/SharedPreferences;", 0);
            }
            throw new IllegalStateException("KoinApplication has not been started");
        }
        HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
        if (heyMelodyApplication2 != null) {
            return new d(heyMelodyApplication2, 1);
        }
        h.i("context");
        throw null;
    }
}
