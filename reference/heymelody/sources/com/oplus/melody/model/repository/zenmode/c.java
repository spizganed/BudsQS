package com.oplus.melody.model.repository.zenmode;

import android.os.Handler;
import androidx.media3.session.U;

/* JADX INFO: compiled from: IDownloadListener.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static Handler.Callback g(c cVar) {
        return cVar == null ? new G6.b(1) : new U(cVar, 2);
    }

    public void c(String str) {
    }

    public void e(int i10) {
    }

    public void f(String str) {
    }

    public void a(String str, String str2) {
    }

    public void d(int i10, String str) {
    }

    public void b(int i10, String str, String str2) {
    }
}
