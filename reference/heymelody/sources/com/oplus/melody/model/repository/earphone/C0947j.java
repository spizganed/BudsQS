package com.oplus.melody.model.repository.earphone;

import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.util.C0906l;
import java.util.function.BiConsumer;

/* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0947j implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19952b;

    public /* synthetic */ C0947j(String str, int i10) {
        this.f19951a = i10;
        this.f19952b = str;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f19951a) {
            case 0:
                Integer num = (Integer) obj;
                EarphoneStatusDO earphoneStatusDO = (EarphoneStatusDO) obj2;
                if (com.oplus.melody.common.util.A.l()) {
                    com.oplus.melody.common.util.A.b("EarphoneRepository", "m_spp_le.refreshSppOverGattConnectionState newState=" + num + " oldState=" + earphoneStatusDO.getSppOverGattConnectionState() + " mac=" + com.oplus.melody.common.util.A.r(this.f19952b));
                }
                earphoneStatusDO.setSppOverGattConnectionState(num.intValue());
                break;
            case 1:
                Integer num2 = (Integer) obj;
                EarphoneStatusDO earphoneStatusDO2 = (EarphoneStatusDO) obj2;
                com.oplus.melody.common.util.A.c("EarphoneRepository", new s(num2, earphoneStatusDO2, this.f19952b, 2));
                earphoneStatusDO2.setHeadsetConnectionState(num2.intValue());
                break;
            default:
                String str = this.f19952b;
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                A6.g.i(heyMelodyApplication, 1053, "param_address", str, heyMelodyApplication);
                break;
        }
    }
}
