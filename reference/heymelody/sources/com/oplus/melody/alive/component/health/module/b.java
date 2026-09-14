package com.oplus.melody.alive.component.health.module;

import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f18792b;

    public /* synthetic */ b(JSONObject jSONObject, int i10) {
        this.f18791a = i10;
        this.f18792b = jSONObject;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f18791a) {
            case 0:
                return HealthCalibrationModule.onSpineCalibrationResultChanged$lambda$1(this.f18792b);
            default:
                return HealthSettingsModule.writeSettings$lambda$0$3$0(this.f18792b);
        }
    }
}
