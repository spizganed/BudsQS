package com.oplus.melody.model.repository.sharedpreferences;

import D7.C0379m;
import D7.U;
import a9.C0531H;
import android.content.SharedPreferences;
import androidx.lifecycle.s;
import com.google.gson.reflect.TypeToken;
import com.oplus.melody.model.repository.zenmode.e;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.h;
import p8.AbstractC1403a;
import p8.SharedPreferencesEditorC1404b;

/* JADX INFO: compiled from: SharedPreferencesRepositoryClientImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SharedPreferencesRepositoryClientImpl extends AbstractC1403a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Type f20097p = new TypeToken<Map<String, ? extends String>>() { // from class: com.oplus.melody.model.repository.sharedpreferences.SharedPreferencesRepositoryClientImpl$mStringMapType$1
    }.getType();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConcurrentHashMap<String, U<Map<String, String>>> f20098q = new ConcurrentHashMap<>();

    @Override // p8.AbstractC1403a
    public final SharedPreferences.Editor a() {
        return new SharedPreferencesEditorC1404b(this);
    }

    @Override // p8.AbstractC1403a
    public final s<Map<String, ?>> b(String str) {
        U<Map<String, String>> uComputeIfAbsent = this.f20098q.computeIfAbsent("melody-model-privacy", new e(new C0531H(this, 15), 15));
        h.d(uComputeIfAbsent, "computeIfAbsent(...)");
        return C0379m.g(uComputeIfAbsent, new g0.e(19));
    }
}
