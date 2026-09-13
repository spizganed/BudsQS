package com.oplus.melody.alive.component.health.module;

import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f18801b;

    public /* synthetic */ f(JSONObject jSONObject, int i10) {
        this.f18800a = i10;
        this.f18801b = jSONObject;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f18800a) {
            case 0:
                return HealthSettingsModule.readSettings$lambda$1(this.f18801b);
            default:
                return HealthSettingsModule.writeSettings$lambda$0$0$0(this.f18801b);
        }
    }
}
