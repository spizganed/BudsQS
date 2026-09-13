package com.oplus.melody.app.discovery;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.e0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0846e0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f19059b;

    public /* synthetic */ C0846e0(ArrayList arrayList, int i10) {
        this.f19058a = i10;
        this.f19059b = arrayList;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        ArrayList arrayList = this.f19059b;
        switch (this.f19058a) {
            case 0:
                return "getDiscoveries: select item change,newList.size():" + arrayList.size();
            default:
                SimpleDateFormat simpleDateFormat = t8.z.f27961a;
                return "tipCleanLiveData:".concat(t8.z.a(arrayList));
        }
    }
}
