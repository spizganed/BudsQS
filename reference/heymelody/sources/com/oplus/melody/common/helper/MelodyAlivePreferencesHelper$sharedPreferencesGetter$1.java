package com.oplus.melody.common.helper;

import Wb.l;
import android.content.SharedPreferences;
import com.oplus.melody.common.util.F;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyAlivePreferencesHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class MelodyAlivePreferencesHelper$sharedPreferencesGetter$1 extends FunctionReferenceImpl implements l<String, SharedPreferences> {
    @Override // Wb.l
    public final SharedPreferences d(String str) {
        String p02 = str;
        h.e(p02, "p0");
        return ((F) this.receiver).e(p02);
    }
}
