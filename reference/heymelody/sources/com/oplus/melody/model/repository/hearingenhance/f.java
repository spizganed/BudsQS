package com.oplus.melody.model.repository.hearingenhance;

import com.oplus.melody.btsdk.api.data.HearingEnhanceFreqPacketInfo;
import com.oplus.melody.btsdk.api.data.HearingStatusInfo;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f20029b;

    public /* synthetic */ f(Object obj, int i10) {
        this.f20028a = i10;
        this.f20029b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f20028a) {
            case 0:
                return "EVENT_ID_BT_HEARING_ENHANCE_STATUS_CHANGED, statusInfo: " + ((HearingStatusInfo) this.f20029b);
            case 1:
                return "EVENT_ID_BT_EAR_SCAN_FREQ_PARAMS, packetInfo: " + ((HearingEnhanceFreqPacketInfo) this.f20029b);
            default:
                return "HearingEnhancementRepository, mEntityMap.size: " + ((l) this.f20029b).f20041q.size();
        }
    }
}
