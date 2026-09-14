package com.oplus.melody.alive.component.health.module;

import A6.i;
import D7.C0368b;
import D7.C0379m;
import D7.H;
import Jb.l;
import a9.C0531H;
import androidx.lifecycle.v;
import b9.C0738g;
import com.heytap.health.rpc.RpcMsg;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.common.util.O;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import org.json.JSONException;
import org.json.JSONObject;
import z6.C1722a;

/* JADX INFO: compiled from: HealthSettingsModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/oplus/melody/alive/component/health/module/HealthSettingsModule;", "Lcom/oplus/melody/alive/component/health/module/BaseHealthModule;", "<init>", "()V", "readMsgId", "", "writeMsgId", "onSpineHealthSettingsChanged", "", "settings", "", "handleHealthEvent", "msg", "Lcom/heytap/health/rpc/RpcMsg;", "writeSettings", "checkIfNeedChangeSetting", "", SpeechFindManager.TYPE, "enabled", "readSettings", "Bean", "Companion", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HealthSettingsModule extends BaseHealthModule {
    public static final int CID_READ_SETTINGS = 2;
    public static final int CID_WRITE_SETTINGS = 1;
    public static final String KEY_RESULT_CODE = "resultCode";
    public static final String KEY_SPINE_CERVICAL_REMIND = "cervicalSpineRemind";
    public static final String KEY_SPINE_FATIGUE_REMIND = "fatigueRemind";
    public static final String KEY_SPINE_LIVE_MONITOR = "realtime";
    public static final int RESULT_SIZE = 3;
    public static final int SWITCH_SPINE_CERVICAL_REMIND = 3;
    public static final int SWITCH_SPINE_FATIGUE_REMIND = 2;
    public static final int SWITCH_SPINE_LIVE_MONITOR = 1;
    public static final String TAG = "HealthSettingsModule";
    private int readMsgId = -1;
    private int writeMsgId = -1;

    /* JADX INFO: renamed from: com.oplus.melody.alive.component.health.module.HealthSettingsModule$1, reason: invalid class name */
    /* JADX INFO: compiled from: HealthSettingsModule.kt */
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
            return new FunctionReferenceImpl(1, HealthSettingsModule.this, HealthSettingsModule.class, "onSpineHealthSettingsChanged", "onSpineHealthSettingsChanged(Ljava/util/List;)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final void onChanged(List<Integer> list) throws JSONException {
            HealthSettingsModule.this.onSpineHealthSettingsChanged(list);
        }
    }

    /* JADX INFO: compiled from: HealthSettingsModule.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/oplus/melody/alive/component/health/module/HealthSettingsModule$Bean;", "", SpeechFindManager.TYPE, "", "value", "", "<init>", "(IZ)V", "getType", "()I", "getValue", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Bean {
        private final int type;
        private final boolean value;

        public Bean(int i10, boolean z2) {
            this.type = i10;
            this.value = z2;
        }

        public static /* synthetic */ Bean copy$default(Bean bean, int i10, boolean z2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = bean.type;
            }
            if ((i11 & 2) != 0) {
                z2 = bean.value;
            }
            return bean.copy(i10, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getValue() {
            return this.value;
        }

        public final Bean copy(int type, boolean value) {
            return new Bean(type, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Bean)) {
                return false;
            }
            Bean bean = (Bean) other;
            return this.type == bean.type && this.value == bean.value;
        }

        public final int getType() {
            return this.type;
        }

        public final boolean getValue() {
            return this.value;
        }

        public int hashCode() {
            return Boolean.hashCode(this.value) + (Integer.hashCode(this.type) * 31);
        }

        public String toString() {
            return "Bean(type=" + this.type + ", value=" + this.value + ")";
        }
    }

    public HealthSettingsModule() {
        C0379m.i(C0379m.b(C0379m.g(getMSpineHealthModel().f68a, new A6.g(1))), new AnonymousClass1(), C0379m.f1127a);
    }

    private final boolean checkIfNeedChangeSetting(int type, boolean enabled) throws JSONException {
        EarphoneDTO earphoneDTOB = getMSpineHealthModel().b();
        boolean z2 = type == 1 ? !(earphoneDTOB == null || earphoneDTOB.getSpineLiveMonitorStatus() != 1) : !(type == 2 ? earphoneDTOB == null || earphoneDTOB.getSpineCervicalStatus() != 1 : !(type == 3 && earphoneDTOB != null && earphoneDTOB.getSpineExerciseRemindStatus() == 1));
        if (z2 == enabled) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 1);
            jSONObject.put(KEY_SPINE_LIVE_MONITOR, earphoneDTOB != null && earphoneDTOB.getSpineLiveMonitorStatus() == 1);
            jSONObject.put(KEY_SPINE_FATIGUE_REMIND, earphoneDTOB != null && earphoneDTOB.getSpineCervicalStatus() == 1);
            jSONObject.put(KEY_SPINE_CERVICAL_REMIND, earphoneDTOB != null && earphoneDTOB.getSpineExerciseRemindStatus() == 1);
            int i10 = C1722a.f29471a;
            C1722a.b(1, this.writeMsgId, jSONObject);
        }
        return z2 != enabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSpineHealthSettingsChanged(List<Integer> settings) throws JSONException {
        if (settings == null || settings.size() < 3) {
            A.h(TAG, "onSpineHealthSettingsChanged is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("resultCode", 1);
        jSONObject.put(KEY_SPINE_LIVE_MONITOR, settings.get(0).intValue() == 1);
        jSONObject.put(KEY_SPINE_FATIGUE_REMIND, settings.get(1).intValue() == 1);
        jSONObject.put(KEY_SPINE_CERVICAL_REMIND, settings.get(2).intValue() == 1);
        int i10 = C1722a.f29471a;
        C1722a.b(1, this.writeMsgId, jSONObject);
    }

    private final void readSettings(RpcMsg msg) throws JSONException {
        EarphoneDTO earphoneDTOB = getMSpineHealthModel().b();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("resultCode", 1);
        int i10 = 0;
        jSONObject.put(KEY_SPINE_LIVE_MONITOR, earphoneDTOB != null && earphoneDTOB.getSpineLiveMonitorStatus() == 1);
        jSONObject.put(KEY_SPINE_FATIGUE_REMIND, earphoneDTOB != null && earphoneDTOB.getSpineCervicalStatus() == 1);
        jSONObject.put(KEY_SPINE_CERVICAL_REMIND, earphoneDTOB != null && earphoneDTOB.getSpineExerciseRemindStatus() == 1);
        int i11 = C1722a.f29471a;
        C1722a.b(2, msg.getMsgId(), jSONObject);
        A.c(TAG, new f(jSONObject, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String readSettings$lambda$1(JSONObject jSONObject) {
        return "readSettings " + jSONObject;
    }

    private final void writeSettings(RpcMsg msg) {
        if (msg.getData() == null) {
            A.h(TAG, "writeSettings: msg:" + msg.getCid() + ", data is null");
            return;
        }
        Bean bean = (Bean) C0917x.e(msg.getData(), Bean.class);
        if (bean != null) {
            if (!checkIfNeedChangeSetting(bean.getType(), bean.getValue())) {
                A.x(TAG, "writeSettings: SAME, " + bean.getType() + " " + bean.getValue());
                return;
            }
            int type = bean.getType();
            if (type == 1) {
                CompletableFuture completableFutureE0 = AbstractC0939b.E().E0(34, bean.getValue(), getMSpineHealthModel().a());
                final C0531H c0531h = new C0531H(msg, 7);
                completableFutureE0.thenAccept(new Consumer() { // from class: com.oplus.melody.alive.component.health.module.g
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        c0531h.d(obj);
                    }
                }).exceptionally((Function<Throwable, ? extends Void>) new C0738g(4));
                return;
            }
            if (type == 2) {
                AbstractC0939b.E().E0(35, bean.getValue(), getMSpineHealthModel().a()).thenAccept((Consumer) new H(new D9.a(msg, 25), 19)).exceptionally((Function<Throwable, ? extends Void>) new A6.c(26));
            } else {
                if (type != 3) {
                    return;
                }
                AbstractC0939b.E().E0(36, bean.getValue(), getMSpineHealthModel().a()).thenAccept((Consumer) new C0368b(new c(msg, 1), 15)).exceptionally((Function<Throwable, ? extends Void>) new i(23));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l writeSettings$lambda$0$0(RpcMsg rpcMsg, SetCommandStateDTO setCommandStateDTO) throws JSONException {
        int i10 = 1;
        JSONObject jSONObject = new JSONObject();
        if (setCommandStateDTO.getSetCommandStatus() != 0) {
            jSONObject.put("resultCode", setCommandStateDTO.getSetCommandStatus());
            int i11 = C1722a.f29471a;
            C1722a.b(1, rpcMsg.getMsgId(), jSONObject);
        }
        A.c(TAG, new f(jSONObject, i10));
        return l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String writeSettings$lambda$0$0$0(JSONObject jSONObject) {
        return "writeSettings: SWITCH_SPINE_LIVE_MONITOR " + jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void writeSettings$lambda$0$2(Throwable th) {
        A.i(TAG, "writeSettings: SWITCH_SPINE_LIVE_MONITOR", th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l writeSettings$lambda$0$3(RpcMsg rpcMsg, SetCommandStateDTO setCommandStateDTO) throws JSONException {
        int i10 = 1;
        JSONObject jSONObject = new JSONObject();
        if (setCommandStateDTO.getSetCommandStatus() != 0) {
            int setCommandStatus = setCommandStateDTO.getSetCommandStatus();
            A.c("SpineHealthUtil", new O(setCommandStatus, 16));
            if (setCommandStatus == 0) {
                setCommandStatus = 1;
            } else if (setCommandStatus != 1) {
                switch (setCommandStatus) {
                    case 8:
                        setCommandStatus = 6;
                        break;
                    case 9:
                        setCommandStatus = 7;
                        break;
                    case 10:
                        setCommandStatus = 8;
                        break;
                    case 11:
                        setCommandStatus = 9;
                        break;
                }
            } else {
                setCommandStatus = 0;
            }
            jSONObject.put("resultCode", setCommandStatus);
            int i11 = C1722a.f29471a;
            C1722a.b(1, rpcMsg.getMsgId(), jSONObject);
        }
        A.c(TAG, new b(jSONObject, i10));
        return l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String writeSettings$lambda$0$3$0(JSONObject jSONObject) {
        return "writeSettings: SWITCH_SPINE_FATIGUE_REMIND " + jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void writeSettings$lambda$0$5(Throwable th) {
        A.i(TAG, "writeSettings: SWITCH_SPINE_FATIGUE_REMIND", th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l writeSettings$lambda$0$6(RpcMsg rpcMsg, SetCommandStateDTO setCommandStateDTO) throws JSONException {
        int i10 = 1;
        JSONObject jSONObject = new JSONObject();
        if (setCommandStateDTO.getSetCommandStatus() != 0) {
            int setCommandStatus = setCommandStateDTO.getSetCommandStatus();
            A.c("SpineHealthUtil", new O(setCommandStatus, 16));
            if (setCommandStatus == 0) {
                setCommandStatus = 1;
            } else if (setCommandStatus != 1) {
                switch (setCommandStatus) {
                    case 8:
                        setCommandStatus = 6;
                        break;
                    case 9:
                        setCommandStatus = 7;
                        break;
                    case 10:
                        setCommandStatus = 8;
                        break;
                    case 11:
                        setCommandStatus = 9;
                        break;
                }
            } else {
                setCommandStatus = 0;
            }
            jSONObject.put("resultCode", setCommandStatus);
            int i11 = C1722a.f29471a;
            C1722a.b(1, rpcMsg.getMsgId(), jSONObject);
        }
        A.c(TAG, new a(jSONObject, i10));
        return l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String writeSettings$lambda$0$6$0(JSONObject jSONObject) {
        return "writeSettings: SWITCH_SPINE_CERVICAL_REMIND " + jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void writeSettings$lambda$0$8(Throwable th) {
        A.i(TAG, "writeSettings: SWITCH_SPINE_CERVICAL_REMIND", th);
        return null;
    }

    @Override // com.oplus.melody.alive.component.health.module.BaseHealthModule
    public void handleHealthEvent(RpcMsg msg) throws JSONException {
        h.e(msg, "msg");
        if (checkDeviceAvailable(msg)) {
            int cid = msg.getCid();
            if (cid == 1) {
                this.writeMsgId = msg.getMsgId();
                writeSettings(msg);
            } else {
                if (cid != 2) {
                    return;
                }
                this.readMsgId = msg.getMsgId();
                readSettings(msg);
            }
        }
    }
}
