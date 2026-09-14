package com.oplus.melody.alive.component.health.module;

import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f18790b;

    public /* synthetic */ a(JSONObject jSONObject, int i10) {
        this.f18789a = i10;
        this.f18790b = jSONObject;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f18789a) {
            case 0:
                return HealthActivityDetectModule.onSpineDetectResultChanged$lambda$1(this.f18790b);
            default:
                return HealthSettingsModule.writeSettings$lambda$0$6$0(this.f18790b);
        }
    }
}
