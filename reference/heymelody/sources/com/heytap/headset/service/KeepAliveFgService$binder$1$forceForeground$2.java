package com.heytap.headset.service;

import D7.o0;
import Wb.l;
import android.os.Handler;
import androidx.media3.session.N0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import t8.q;

/* JADX INFO: compiled from: KeepAliveFgService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class KeepAliveFgService$binder$1$forceForeground$2 extends FunctionReferenceImpl implements l<Map<String, ? extends V3.a>, Jb.l> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // Wb.l
    public final Jb.l d(Map<String, ? extends V3.a> map) {
        Map<String, ? extends V3.a> p02 = map;
        h.e(p02, "p0");
        KeepAliveFgService keepAliveFgService = (KeepAliveFgService) this.receiver;
        int i10 = KeepAliveFgService.f17591s;
        keepAliveFgService.getClass();
        if (q.l()) {
            keepAliveFgService.f17592b = p02;
            Handler handler = o0.c.f1143a;
            N0 n02 = keepAliveFgService.f17596r;
            handler.removeCallbacks(n02);
            handler.postDelayed(n02, 50L);
        }
        return Jb.l.f2618a;
    }
}
