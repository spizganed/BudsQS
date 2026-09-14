package com.oplus.melody.alive.component.health.module;

import A6.k;
import D7.C0379m;
import com.heytap.health.rpc.RpcMsg;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.EarStatusDTO;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import org.json.JSONException;
import org.json.JSONObject;
import z6.C1722a;

/* JADX INFO: compiled from: MelodyInfoModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/oplus/melody/alive/component/health/module/MelodyInfoModule;", "Lcom/oplus/melody/alive/component/health/module/BaseHealthModule;", "<init>", "()V", "mLastDeviceAddress", "", "handleHealthEvent", "", "msg", "Lcom/heytap/health/rpc/RpcMsg;", "handleActiveEarphoneEvent", "dto", "Lcom/oplus/melody/alive/component/health/repo/SpineHeadsetDO;", MelodyInfoModule.KEY_WEAR_STATUS, "", "isCalibrated", "Companion", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyInfoModule extends BaseHealthModule {
    public static final int CID_DEVICE_CHANGED = 6;
    public static final int CID_SUPPORT_SPINE_HEALTH = 5;
    public static final String KEY_CALIBRATED_STATE = "isCalibration";
    public static final String KEY_RESULT_CODE = "resultCode";
    public static final String KEY_SUPPORT_SPINE_HEALTH = "support";
    public static final String KEY_UID = "uid";
    public static final String KEY_WEAR_STATUS = "isWearing";
    public static final String TAG = "MelodyInfoModule";
    private String mLastDeviceAddress = "";

    public MelodyInfoModule() {
        k mSpineHealthModel = getMSpineHealthModel();
        C0379m.i(C0379m.b(C0379m.g(mSpineHealthModel.f68a, new A6.b(1))), new C6.e(this, 20), C0379m.f1127a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(MelodyInfoModule melodyInfoModule, A6.a aVar) throws JSONException {
        h.b(aVar);
        melodyInfoModule.handleActiveEarphoneEvent(aVar);
    }

    private final void handleActiveEarphoneEvent(A6.a aVar) throws JSONException {
        if (!aVar.isConnected()) {
            this.mLastDeviceAddress = "";
            return;
        }
        if (h.a(this.mLastDeviceAddress, aVar.getAddress())) {
            return;
        }
        A.x(TAG, "handleActiveEarphoneEvent: active device changed to " + A.r(aVar.getAddress()));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_UID, aVar.getAddress());
        C1722a.b(6, 0, jSONObject);
        this.mLastDeviceAddress = aVar.getAddress();
    }

    private final boolean isCalibrated() {
        EarphoneDTO earphoneDTOB = getMSpineHealthModel().b();
        Integer numValueOf = earphoneDTOB != null ? Integer.valueOf(earphoneDTOB.getSpineCalibratedStatus()) : null;
        A.c(TAG, new L8.A(3, numValueOf));
        return numValueOf != null && numValueOf.intValue() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String isCalibrated$lambda$0(Integer num) {
        return "isCalibrated: " + num;
    }

    private final boolean isWearing() {
        EarphoneDTO earphoneDTOB = getMSpineHealthModel().b();
        EarStatusDTO earStatus = earphoneDTOB != null ? earphoneDTOB.getEarStatus() : null;
        A.c(TAG, new d(earStatus, 3));
        return earStatus != null && earStatus.bothInEar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String isWearing$lambda$0(EarStatusDTO earStatusDTO) {
        return "isWearing: " + earStatusDTO;
    }

    @Override // com.oplus.melody.alive.component.health.module.BaseHealthModule
    public void handleHealthEvent(RpcMsg msg) throws JSONException {
        h.e(msg, "msg");
        if (checkDeviceAvailable(msg) && msg.getCid() == 5) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 1);
            jSONObject.put("support", getMSpineHealthModel().c());
            jSONObject.put(KEY_WEAR_STATUS, isWearing());
            jSONObject.put(KEY_CALIBRATED_STATE, isCalibrated());
            int i10 = C1722a.f29471a;
            C1722a.b(5, msg.getMsgId(), jSONObject);
        }
    }
}
