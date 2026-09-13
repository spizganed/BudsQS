package com.oplus.melody.common.util;

import android.os.Bundle;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.oplus.melody.common.util.C0917x;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.oplus.melody.common.util.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CallableC0916w implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19515b;

    public /* synthetic */ CallableC0916w(Object obj, int i10) {
        this.f19514a = i10;
        this.f19515b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f19514a) {
            case 0:
                Object obj = this.f19515b;
                TypeAdapter typeAdapterA = C0917x.a(obj.getClass(), C0917x.a.f19518c);
                StringBuilder sb2 = new StringBuilder();
                try {
                    typeAdapterA.c(new L3.b(com.google.gson.internal.g.a(sb2)), obj);
                    return sb2.toString();
                } catch (IOException e10) {
                    throw new JsonIOException(e10);
                }
            default:
                Bundle bundle = new Bundle();
                JSONObject jSONObject = new JSONObject((String) this.f19515b);
                Iterator<String> itKeys = jSONObject.keys();
                if (itKeys.hasNext()) {
                    String next = itKeys.next();
                    bundle.putString(next, jSONObject.getString(next));
                }
                return bundle;
        }
    }
}
