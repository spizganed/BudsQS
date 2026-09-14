package com.oplus.melody.alive.component.health.module;

import A6.i;
import D7.C0368b;
import D7.C0379m;
import Jb.l;
import androidx.lifecycle.v;
import com.heytap.health.rpc.RpcMsg;
import com.oplus.melody.btsdk.protocol.commands.q;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.common.util.O;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import org.json.JSONException;
import org.json.JSONObject;
import z6.C1722a;

/* JADX INFO: compiled from: HealthCalibrationModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000e\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/oplus/melody/alive/component/health/module/HealthCalibrationModule;", "Lcom/oplus/melody/alive/component/health/module/BaseHealthModule;", "<init>", "()V", "msgId", "", "onSpineCalibrationResultChanged", "", "calibrationResult", "", "handleHealthEvent", "msg", "Lcom/heytap/health/rpc/RpcMsg;", "processCalibration", "Bean", "Companion", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HealthCalibrationModule extends BaseHealthModule {
    public static final int CID_SPINE_CALIBRATION = 7;
    public static final String KEY_ACTION = "action";
    public static final String KEY_RESULT = "result";
    public static final String KEY_RESULT_CODE = "resultCode";
    public static final String TAG = "HealthCalibrationModule";
    private int msgId;

    /* JADX INFO: renamed from: com.oplus.melody.alive.component.health.module.HealthCalibrationModule$1, reason: invalid class name */
    /* JADX INFO: compiled from: HealthCalibrationModule.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 implements v, kotlin.jvm.internal.f {
        public AnonymousClass1() {
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, HealthCalibrationModule.this, HealthCalibrationModule.class, "onSpineCalibrationResultChanged", "onSpineCalibrationResultChanged(Ljava/util/List;)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final void onChanged(List<Integer> list) throws JSONException {
            HealthCalibrationModule.this.onSpineCalibrationResultChanged(list);
        }
    }

    /* JADX INFO: compiled from: HealthCalibrationModule.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/oplus/melody/alive/component/health/module/HealthCalibrationModule$Bean;", "", "action", "", "<init>", "(I)V", "getAction", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Bean {
        private final int action;

        public Bean(int i10) {
            this.action = i10;
        }

        public static /* synthetic */ Bean copy$default(Bean bean, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = bean.action;
            }
            return bean.copy(i10);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getAction() {
            return this.action;
        }

        public final Bean copy(int action) {
            return new Bean(action);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Bean) && this.action == ((Bean) other).action;
        }

        public final int getAction() {
            return this.action;
        }

        public int hashCode() {
            return Integer.hashCode(this.action);
        }

        public String toString() {
            return A6.e.e(this.action, "Bean(action=", ")");
        }
    }

    public HealthCalibrationModule() {
        C0379m.i(C0379m.b(C0379m.g(getMSpineHealthModel().f68a, new A6.e(0))), new AnonymousClass1(), C0379m.f1127a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSpineCalibrationResultChanged(List<Integer> calibrationResult) throws JSONException {
        int i10 = 0;
        if (calibrationResult == null || calibrationResult.isEmpty()) {
            A.x(TAG, "onSpineCalibrationResultChanged: result is empty");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        int iIntValue = calibrationResult.get(0).intValue();
        A.c("SpineHealthUtil", new q(iIntValue, 20));
        if (iIntValue == 0) {
            iIntValue = 1;
        } else if (iIntValue == 1) {
            iIntValue = 0;
        }
        jSONObject.put("resultCode", iIntValue);
        int i11 = C1722a.f29471a;
        C1722a.b(7, this.msgId, jSONObject);
        A.c(TAG, new b(jSONObject, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onSpineCalibrationResultChanged$lambda$1(JSONObject jSONObject) {
        return "onSpineCalibrationResultChanged: " + jSONObject;
    }

    private final void processCalibration(RpcMsg msg) {
        Bean bean = (Bean) C0917x.e(msg.getData(), Bean.class);
        if (bean != null) {
            this.msgId = msg.getMsgId();
            AbstractC0939b.E().B0(getMSpineHealthModel().a(), bean.getAction() == 1).thenAccept((Consumer<? super SetCommandStateDTO>) new C0368b(new c(msg, 0), 14)).exceptionally((Function<Throwable, ? extends Void>) new i(22));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l processCalibration$lambda$0$0(RpcMsg rpcMsg, SetCommandStateDTO setCommandStateDTO) throws JSONException {
        int i10 = 1;
        A.c(TAG, new I8.v(i10, setCommandStateDTO));
        if (setCommandStateDTO.getSetCommandStatus() != 0) {
            JSONObject jSONObject = new JSONObject();
            int setCommandStatus = setCommandStateDTO.getSetCommandStatus();
            A.c("SpineHealthUtil", new O(setCommandStatus, 16));
            if (setCommandStatus != 0) {
                if (setCommandStatus != 1) {
                    switch (setCommandStatus) {
                        case 8:
                            i10 = 6;
                            break;
                        case 9:
                            i10 = 7;
                            break;
                        case 10:
                            i10 = 8;
                            break;
                        case 11:
                            i10 = 9;
                            break;
                        default:
                            i10 = setCommandStatus;
                            break;
                    }
                } else {
                    i10 = 0;
                }
            }
            jSONObject.put(KEY_RESULT, i10);
            int i11 = C1722a.f29471a;
            C1722a.b(7, rpcMsg.getMsgId(), jSONObject);
        }
        return l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String processCalibration$lambda$0$0$0(SetCommandStateDTO setCommandStateDTO) {
        return A6.b.d(setCommandStateDTO.getSetCommandStatus(), "processCalibration: commandStatus=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void processCalibration$lambda$0$2(Throwable th) {
        A.i(TAG, "processCalibration", th);
        return null;
    }

    @Override // com.oplus.melody.alive.component.health.module.BaseHealthModule
    public void handleHealthEvent(RpcMsg msg) {
        h.e(msg, "msg");
        if (checkDeviceAvailable(msg) && msg.getCid() == 7) {
            processCalibration(msg);
        }
    }
}
