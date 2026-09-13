package com.oplus.melody.model.db;

import androidx.media3.exoplayer.C0625v;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f19666c;

    public /* synthetic */ C(String str, String str2, int i10) {
        this.f19664a = i10;
        this.f19665b = str;
        this.f19666c = str2;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19664a) {
            case 0:
                StringBuilder sb2 = new StringBuilder("setPopTheme ");
                sb2.append(this.f19665b);
                sb2.append(' ');
                return C0625v.i(this.f19666c, sb2);
            case 1:
                return "callPkg:" + this.f19665b + " call:" + this.f19666c;
            default:
                return "updateCustomDressData productId:" + this.f19665b + " colorId:" + this.f19666c;
        }
    }
}
