package com.oplus.melody.common.util;

import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.oplus.melody.common.util.C0917x;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.oplus.melody.common.util.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CallableC0915v implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19513b;

    public /* synthetic */ CallableC0915v(Object obj, int i10) {
        this.f19512a = i10;
        this.f19513b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f19512a) {
            case 0:
                com.oplus.melody.common.data.a aVar = (com.oplus.melody.common.data.a) this.f19513b;
                TypeAdapter typeAdapterA = C0917x.a(aVar.getClass(), C0917x.a.f19518c);
                typeAdapterA.getClass();
                try {
                    com.google.gson.internal.bind.b bVar = new com.google.gson.internal.bind.b();
                    typeAdapterA.c(bVar, aVar);
                    ArrayList arrayList = bVar.f17310A;
                    if (!arrayList.isEmpty()) {
                        throw new IllegalStateException("Expected one JSON element but was " + arrayList);
                    }
                    com.google.gson.h hVar = bVar.f17312C;
                    try {
                        com.google.gson.internal.bind.a aVar2 = new com.google.gson.internal.bind.a(com.google.gson.internal.bind.a.f17302F);
                        aVar2.f17304B = new Object[32];
                        aVar2.f17305C = 0;
                        aVar2.f17306D = new String[32];
                        aVar2.f17307E = new int[32];
                        aVar2.N0(hVar);
                        return typeAdapterA.b(aVar2);
                    } catch (IOException e10) {
                        throw new JsonIOException(e10);
                    }
                } catch (IOException e11) {
                    throw new JsonIOException(e11);
                }
            default:
                return C0917x.a(DeviceInfo.class, C0917x.a.f19519d).b(new L3.a(new StringReader((String) this.f19513b)));
        }
    }
}
