package com.oplus.melody.alive.component.health.module;

import A6.i;
import D7.C0368b;
import D7.C0379m;
import Jb.l;
import X3.w;
import androidx.lifecycle.v;
import com.heytap.health.rpc.RpcMsg;
import com.oplus.melody.btsdk.protocol.commands.q;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.common.util.O;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;
import java.util.function.Function;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import org.json.JSONException;
import org.json.JSONObject;
import z6.C1722a;

/* JADX INFO: compiled from: HealthActivityDetectModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/oplus/melody/alive/component/health/module/HealthActivityDetectModule;", "Lcom/oplus/melody/alive/component/health/module/BaseHealthModule;", "<init>", "()V", "msgId", "", "onSpineDetectResultChanged", "", "detectionResult", "", "", "handleHealthEvent", "msg", "Lcom/heytap/health/rpc/RpcMsg;", "processSpineDetect", "RequestBean", "Companion", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HealthActivityDetectModule extends BaseHealthModule {
    public static final int CID_SPINE_ACTIVITY_DETECT = 3;
    public static final String KEY_ACTION = "action";
    public static final String KEY_ANGLE = "angle";
    public static final String KEY_DETECT_TYPE = "detectType";
    public static final String KEY_RESULT_CODE = "resultCode";
    public static final int RESULT_SIZE = 3;
    public static final String TAG = "HealthActivityDetectModule";
    private int msgId;

    /* JADX INFO: renamed from: com.oplus.melody.alive.component.health.module.HealthActivityDetectModule$1, reason: invalid class name */
    /* JADX INFO: compiled from: HealthActivityDetectModule.kt */
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
            return new FunctionReferenceImpl(1, HealthActivityDetectModule.this, HealthActivityDetectModule.class, "onSpineDetectResultChanged", "onSpineDetectResultChanged(Ljava/util/List;)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final void onChanged(List<Float> list) throws JSONException {
            HealthActivityDetectModule.this.onSpineDetectResultChanged(list);
        }
    }

    /* JADX INFO: compiled from: HealthActivityDetectModule.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/oplus/melody/alive/component/health/module/HealthActivityDetectModule$RequestBean;", "", HealthActivityDetectModule.KEY_DETECT_TYPE, "", "action", "<init>", "(II)V", "getDetectType", "()I", "getAction", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class RequestBean {
        private final int action;
        private final int detectType;

        public RequestBean(int i10, int i11) {
            this.detectType = i10;
            this.action = i11;
        }

        public static /* synthetic */ RequestBean copy$default(RequestBean requestBean, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = requestBean.detectType;
            }
            if ((i12 & 2) != 0) {
                i11 = requestBean.action;
            }
            return requestBean.copy(i10, i11);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getDetectType() {
            return this.detectType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getAction() {
            return this.action;
        }

        public final RequestBean copy(int detectType, int action) {
            return new RequestBean(detectType, action);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestBean)) {
                return false;
            }
            RequestBean requestBean = (RequestBean) other;
            return this.detectType == requestBean.detectType && this.action == requestBean.action;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getDetectType() {
            return this.detectType;
        }

        public int hashCode() {
            return Integer.hashCode(this.action) + (Integer.hashCode(this.detectType) * 31);
        }

        public String toString() {
            return "RequestBean(detectType=" + this.detectType + ", action=" + this.action + ")";
        }
    }

    public HealthActivityDetectModule() {
        C0379m.i(C0379m.b(C0379m.g(getMSpineHealthModel().f68a, new A6.g(0))), new AnonymousClass1(), C0379m.f1127a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSpineDetectResultChanged(List<Float> detectionResult) throws JSONException {
        int i10 = 0;
        if (detectionResult == null || detectionResult.size() < 3) {
            A.x(TAG, "onSpineDetectResultChanged: result is not valid " + detectionResult);
            return;
        }
        int iFloatValue = (int) detectionResult.get(1).floatValue();
        A.c("SpineHealthUtil", new q(iFloatValue, 20));
        int i11 = iFloatValue != 0 ? iFloatValue != 1 ? iFloatValue : 0 : 1;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("resultCode", i11);
        jSONObject.put(KEY_DETECT_TYPE, (int) detectionResult.get(0).floatValue());
        jSONObject.put(KEY_ANGLE, detectionResult.get(2));
        int i12 = C1722a.f29471a;
        C1722a.b(3, this.msgId, jSONObject);
        A.c(TAG, new a(jSONObject, i10));
        if (((int) detectionResult.get(0).floatValue()) == 4) {
            ForkJoinPool.commonPool().execute(new w(this, 16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onSpineDetectResultChanged$lambda$1(JSONObject jSONObject) {
        return "onSpineDetectResultChanged: " + jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSpineDetectResultChanged$lambda$2(HealthActivityDetectModule healthActivityDetectModule) {
        EarphoneDTO earphoneDTOB = healthActivityDetectModule.getMSpineHealthModel().b();
        if (earphoneDTOB != null) {
            C1264t.t(AppConstant$FunctionType.SPINE_HEALTH.getFunType(), earphoneDTOB.getProductId(), earphoneDTOB.getMacAddress(), N.t(earphoneDTOB), BaseHealthModule.TRACK_ACTIVE_DETECT);
        }
    }

    private final void processSpineDetect(RpcMsg msg) {
        RequestBean requestBean = (RequestBean) C0917x.e(msg.getData(), RequestBean.class);
        if (requestBean != null) {
            AbstractC0939b.E().C0(requestBean.getDetectType(), requestBean.getAction() == 1, getMSpineHealthModel().a()).thenAccept((Consumer) new C0368b(new B9.d(this, 29), 13)).exceptionally((Function<Throwable, ? extends Void>) new i(21));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l processSpineDetect$lambda$0$0(HealthActivityDetectModule healthActivityDetectModule, SetCommandStateDTO setCommandStateDTO) throws JSONException {
        int i10 = 1;
        A.c(TAG, new d(setCommandStateDTO, i10));
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
            jSONObject.put("resultCode", i10);
            int i11 = C1722a.f29471a;
            C1722a.b(3, healthActivityDetectModule.msgId, jSONObject);
        }
        return l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String processSpineDetect$lambda$0$0$0(SetCommandStateDTO setCommandStateDTO) {
        return A6.b.d(setCommandStateDTO.getSetCommandStatus(), "processSpineDetect: commandStatus=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void processSpineDetect$lambda$0$2(Throwable th) {
        A.i(TAG, "processSpineDetect", th);
        return null;
    }

    @Override // com.oplus.melody.alive.component.health.module.BaseHealthModule
    public void handleHealthEvent(RpcMsg msg) {
        h.e(msg, "msg");
        if (checkDeviceAvailable(msg)) {
            if (msg.getData() == null) {
                A.h(TAG, "handleHealthEvent: data is null");
                return;
            }
            this.msgId = msg.getMsgId();
            if (msg.getCid() == 3) {
                processSpineDetect(msg);
            }
        }
    }
}
