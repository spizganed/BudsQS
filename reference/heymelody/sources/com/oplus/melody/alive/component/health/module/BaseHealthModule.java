package com.oplus.melody.alive.component.health.module;

import A6.k;
import D7.L;
import com.heytap.health.rpc.RpcMsg;
import com.oplus.melody.common.util.A;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import org.json.JSONException;
import org.json.JSONObject;
import z6.C1722a;

/* JADX INFO: compiled from: BaseHealthModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0004J\b\u0010\f\u001a\u00020\rH\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/oplus/melody/alive/component/health/module/BaseHealthModule;", "", "<init>", "()V", "mSpineHealthModel", "Lcom/oplus/melody/alive/component/health/repo/SpineHealthModel;", "getMSpineHealthModel", "()Lcom/oplus/melody/alive/component/health/repo/SpineHealthModel;", "handleHealthEvent", "", "msg", "Lcom/heytap/health/rpc/RpcMsg;", "checkDeviceAvailable", "", "Companion", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class BaseHealthModule {
    public static final String KEY_RESULT_CODE = "resultCode";
    public static final int SPINE_HEALTH_SID = 1;
    private static final String TAG = "BaseHealthModule";
    public static final String TRACK_ACTIVE_DETECT = "3";
    public static final String TRACK_CERVICAL_REMIND = "2";
    public static final String TRACK_FATIGUE_REMIND = "1";
    private final k mSpineHealthModel;

    public BaseHealthModule() {
        k kVar = k.a.f69a;
        h.d(kVar, "getInstance(...)");
        this.mSpineHealthModel = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String checkDeviceAvailable$lambda$0(int i10) {
        return A6.b.d(i10, "checkDeviceAvailable code=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String checkDeviceAvailable$lambda$1(int i10) {
        return A6.b.d(i10, "checkDeviceAvailable code=");
    }

    public final boolean checkDeviceAvailable(RpcMsg msg) throws JSONException {
        h.e(msg, "msg");
        int iC = this.mSpineHealthModel.c();
        A.c(TAG, new L(iC, 24));
        int i10 = iC != 2 ? iC != 3 ? iC != 4 ? 0 : 12 : 11 : 8;
        if (i10 == 0) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("resultCode", i10);
        int i11 = C1722a.f29471a;
        C1722a.b(msg.getCid(), msg.getMsgId(), jSONObject);
        return false;
    }

    public final k getMSpineHealthModel() {
        return this.mSpineHealthModel;
    }

    public abstract void handleHealthEvent(RpcMsg msg);

    public final boolean checkDeviceAvailable() {
        int iC = this.mSpineHealthModel.c();
        A.c(TAG, new Ba.b(iC, 21));
        return (iC == 3 || iC == 4) ? false : true;
    }
}
