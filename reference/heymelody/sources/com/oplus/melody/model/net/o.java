package com.oplus.melody.model.net;

import D7.S;
import android.os.Bundle;
import b9.C0738g;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.common.util.C0901g;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/* JADX INFO: compiled from: SmartHomeIotCallHelperClientImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends n {
    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture<File> a(String str, String str2, String str3, com.oplus.melody.model.repository.zenmode.c cVar) {
        Bundle bundleE = androidx.appcompat.widget.a.e("fileUrl", str, "checkCode", str2);
        bundleE.putString("algorithm", str3);
        D7.E e10 = S.f1011a;
        return S.d(2009, bundleE, com.oplus.melody.model.repository.zenmode.c.g(cVar)).thenApplyAsync((Function) new C0738g(11));
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture c(ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("productIds", C0901g.b(arrayList));
        return S.h(2006, bundle, String.class);
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture d(int i10, String str, String str2) {
        Bundle bundleE = androidx.appcompat.widget.a.e("productId", str, "language", str2);
        bundleE.putInt("intColor", i10);
        return S.h(2005, bundleE, String.class);
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture e(int i10, String str, String str2) {
        Bundle bundleE = androidx.appcompat.widget.a.e("productId", str, "language", str2);
        bundleE.putInt("intColor", i10);
        return S.h(2007, bundleE, String.class);
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture<String> f(String str, String str2, String str3, String str4, String str5, String str6) {
        Bundle bundleE = androidx.appcompat.widget.a.e("arg1", str, "arg2", str2);
        bundleE.putString("arg3", str3);
        bundleE.putString("arg4", str4);
        bundleE.putString("arg5", str5);
        bundleE.putString("arg6", str6);
        return S.h(2003, bundleE, String.class);
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture<String> g(String str, String str2, int i10, int i11) {
        Bundle bundleE = androidx.appcompat.widget.a.e("productId", str, "language", str2);
        bundleE.putInt("intColor", i10);
        bundleE.putInt("seriesId", i11);
        return S.h(2011, bundleE, String.class);
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture h(int i10, String str, String str2) {
        Bundle bundleE = androidx.appcompat.widget.a.e("productId", str, "language", str2);
        bundleE.putInt("intColor", i10);
        return S.h(2004, bundleE, String.class);
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture i(int i10, String str, String str2) {
        Bundle bundleE = androidx.appcompat.widget.a.e("productId", str, "language", str2);
        bundleE.putInt("intColor", i10);
        return S.h(2010, bundleE, String.class);
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture j(int i10, int i11, String str) {
        Bundle bundleD = A6.e.d(i10, "arg1", str, "arg2");
        bundleD.putInt("arg3", i11);
        return S.h(2013, bundleD, String.class);
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture k(int i10, String str, String str2) {
        Bundle bundleE = androidx.appcompat.widget.a.e(SpeechFindManager.TYPE, str, "productId", str2);
        bundleE.putInt("intColor", i10);
        return S.h(2001, bundleE, String.class);
    }

    @Override // com.oplus.melody.model.net.n
    public final CompletableFuture<String> l(String str, String str2, String str3) {
        Bundle bundleE = androidx.appcompat.widget.a.e("arg1", str, "arg2", str2);
        bundleE.putString("arg3", str3);
        return S.h(2002, bundleE, String.class);
    }
}
