package com.oplus.melody.model.repository.zenmode;

import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: IDownloadListener.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkedList f20160a;

    public b(LinkedList linkedList) {
        this.f20160a = linkedList;
    }

    @Override // com.oplus.melody.model.repository.zenmode.c
    public final void a(String str, String str2) {
        Iterator it = this.f20160a.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(str, str2);
        }
    }

    @Override // com.oplus.melody.model.repository.zenmode.c
    public final void b(int i10, String str, String str2) {
        Iterator it = this.f20160a.iterator();
        while (it.hasNext()) {
            ((c) it.next()).b(i10, str, str2);
        }
    }

    @Override // com.oplus.melody.model.repository.zenmode.c
    public final void c(String str) {
        Iterator it = this.f20160a.iterator();
        while (it.hasNext()) {
            ((c) it.next()).c(str);
        }
    }

    @Override // com.oplus.melody.model.repository.zenmode.c
    public final void d(int i10, String str) {
        Iterator it = this.f20160a.iterator();
        while (it.hasNext()) {
            ((c) it.next()).d(i10, str);
        }
    }

    @Override // com.oplus.melody.model.repository.zenmode.c
    public final void e(int i10) {
        Iterator it = this.f20160a.iterator();
        while (it.hasNext()) {
            ((c) it.next()).e(i10);
        }
    }

    @Override // com.oplus.melody.model.repository.zenmode.c
    public final void f(String str) {
        Iterator it = this.f20160a.iterator();
        while (it.hasNext()) {
            ((c) it.next()).f(str);
        }
    }
}
