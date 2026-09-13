package com.oplus.melody.alive.component.health.module;

import com.oplus.melody.alive.component.health.module.HealthHistoryDataModule;
import com.oplus.melody.model.repository.earphone.EarStatusDTO;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import java.util.function.Supplier;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18796b;

    public /* synthetic */ d(Object obj, int i10) {
        this.f18795a = i10;
        this.f18796b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f18795a) {
            case 0:
                return HealthHistoryDataModule.handleHealthEvent$lambda$0$0((HealthHistoryDataModule.RequestBean) this.f18796b);
            case 1:
                return HealthActivityDetectModule.processSpineDetect$lambda$0$0$0((SetCommandStateDTO) this.f18796b);
            case 2:
                return HealthHistoryDataModule.processDeviceChanged$lambda$0$0((Ref$IntRef) this.f18796b);
            default:
                return MelodyInfoModule.isWearing$lambda$0((EarStatusDTO) this.f18796b);
        }
    }
}
