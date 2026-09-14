package com.oplus.melody.alive.component.health.module;

import Wb.l;
import com.heytap.health.rpc.RpcMsg;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RpcMsg f18794b;

    public /* synthetic */ c(RpcMsg rpcMsg, int i10) {
        this.f18793a = i10;
        this.f18794b = rpcMsg;
    }

    @Override // Wb.l
    public final Object d(Object obj) {
        switch (this.f18793a) {
            case 0:
                return HealthCalibrationModule.processCalibration$lambda$0$0(this.f18794b, (SetCommandStateDTO) obj);
            default:
                return HealthSettingsModule.writeSettings$lambda$0$6(this.f18794b, (SetCommandStateDTO) obj);
        }
    }
}
