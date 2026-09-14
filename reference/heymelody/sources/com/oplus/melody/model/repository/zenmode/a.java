package com.oplus.melody.model.repository.zenmode;

import D7.E;
import D7.h0;
import android.os.Bundle;
import android.os.Message;

/* JADX INFO: compiled from: IDownloadListener.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Message f20159a;

    public a(Message message) {
        this.f20159a = message;
    }

    @Override // com.oplus.melody.model.repository.zenmode.c
    public final void a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("event", 5);
        bundle.putString("arg1", str);
        bundle.putString("arg2", str2);
        E e10 = h0.f1099c;
        h0.h(this.f20159a, bundle);
    }

    @Override // com.oplus.melody.model.repository.zenmode.c
    public final void b(int i10, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("event", 4);
        bundle.putString("arg1", str);
        bundle.putInt("arg2", i10);
        bundle.putString("arg3", str2);
        E e10 = h0.f1099c;
        h0.h(this.f20159a, bundle);
    }

    @Override // com.oplus.melody.model.repository.zenmode.c
    public final void c(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("event", 3);
        bundle.putString("arg1", str);
        E e10 = h0.f1099c;
        h0.h(this.f20159a, bundle);
    }

    @Override // com.oplus.melody.model.repository.zenmode.c
    public final void d(int i10, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("event", 1);
        bundle.putString("arg1", str);
        bundle.putInt("arg2", i10);
        E e10 = h0.f1099c;
        h0.h(this.f20159a, bundle);
    }

    @Override // com.oplus.melody.model.repository.zenmode.c
    public final void e(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("event", 2);
        bundle.putInt("arg1", i10);
        E e10 = h0.f1099c;
        h0.h(this.f20159a, bundle);
    }

    @Override // com.oplus.melody.model.repository.zenmode.c
    public final void f(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("event", 0);
        bundle.putString("arg1", str);
        E e10 = h0.f1099c;
        h0.h(this.f20159a, bundle);
    }
}
