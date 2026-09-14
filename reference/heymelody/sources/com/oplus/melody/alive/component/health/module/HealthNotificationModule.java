package com.oplus.melody.alive.component.health.module;

import A6.i;
import A6.j;
import D7.C0379m;
import D7.ExecutorC0375i;
import O7.l;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import com.heytap.health.rpc.RpcMsg;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.common.util.A;
import g8.AbstractC1073a;
import java.util.List;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import org.json.JSONException;
import org.json.JSONObject;
import z6.C1722a;

/* JADX INFO: compiled from: HealthNotificationModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH\u0002J\u0017\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0013"}, d2 = {"Lcom/oplus/melody/alive/component/health/module/HealthNotificationModule;", "Lcom/oplus/melody/alive/component/health/module/BaseHealthModule;", "<init>", "()V", "onWearStatusChanged", "", HealthNotificationModule.EVENT_WEAR_STATUS, "", "", "onConnectStatusChanged", ClientDataEntity.COL_STATUS, "onCervicalSpineRemindEvent", "time", "(Ljava/lang/Integer;)V", "onSpineFatigueRemindEvent", "handleHealthEvent", "msg", "Lcom/heytap/health/rpc/RpcMsg;", "Companion", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HealthNotificationModule extends BaseHealthModule {
    public static final int CID_NOTIFICATION_EVENT = 8;
    public static final int CID_REMINDER_EVENT = 9;
    public static final String EVENT_CONNECT_STATUS = "connectStatus";
    public static final int EVENT_CONNECT_STATUS_MSGID = 2;
    public static final String EVENT_REMIND_TIME = "remindTime";
    public static final int EVENT_SPINE_CERVICAL_EVENT_MSGID = 3;
    public static final int EVENT_SPINE_FATIGUE_EVENT_MSGID = 2;
    public static final String EVENT_WEAR_STATUS = "wearStatus";
    public static final int EVENT_WEAR_STATUS_MSGID = 1;
    public static final String KEY_REMIND_TYPE = "remindType";
    public static final int REMIND_TYPE_CERVICAL_SPINE = 2;
    public static final int REMIND_TYPE_SPINE_TIRED = 1;
    public static final String TAG = "HealthNotificationModule";

    /* JADX INFO: renamed from: com.oplus.melody.alive.component.health.module.HealthNotificationModule$1, reason: invalid class name */
    /* JADX INFO: compiled from: HealthNotificationModule.kt */
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
            return new FunctionReferenceImpl(1, HealthNotificationModule.this, HealthNotificationModule.class, "onConnectStatusChanged", "onConnectStatusChanged(I)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final void onChanged(int i10) throws JSONException {
            HealthNotificationModule.this.onConnectStatusChanged(i10);
        }

        @Override // androidx.lifecycle.v
        public /* bridge */ /* synthetic */ void onChanged(Object obj) throws JSONException {
            onChanged(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.alive.component.health.module.HealthNotificationModule$2, reason: invalid class name */
    /* JADX INFO: compiled from: HealthNotificationModule.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 implements v, kotlin.jvm.internal.f {
        public AnonymousClass2() {
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, HealthNotificationModule.this, HealthNotificationModule.class, "onWearStatusChanged", "onWearStatusChanged(Ljava/util/List;)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final void onChanged(List<Integer> p02) throws JSONException {
            h.e(p02, "p0");
            HealthNotificationModule.this.onWearStatusChanged(p02);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.alive.component.health.module.HealthNotificationModule$3, reason: invalid class name */
    /* JADX INFO: compiled from: HealthNotificationModule.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass3 implements v, kotlin.jvm.internal.f {
        public AnonymousClass3() {
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, HealthNotificationModule.this, HealthNotificationModule.class, "onSpineFatigueRemindEvent", "onSpineFatigueRemindEvent(Ljava/lang/Integer;)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final void onChanged(Integer num) throws JSONException {
            HealthNotificationModule.this.onSpineFatigueRemindEvent(num);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.alive.component.health.module.HealthNotificationModule$4, reason: invalid class name */
    /* JADX INFO: compiled from: HealthNotificationModule.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass4 implements v, kotlin.jvm.internal.f {
        public AnonymousClass4() {
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, HealthNotificationModule.this, HealthNotificationModule.class, "onCervicalSpineRemindEvent", "onCervicalSpineRemindEvent(Ljava/lang/Integer;)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final void onChanged(Integer num) throws JSONException {
            HealthNotificationModule.this.onCervicalSpineRemindEvent(num);
        }
    }

    public HealthNotificationModule() {
        t tVarB = C0379m.b(C0379m.g(getMSpineHealthModel().f68a, new A6.f(0)));
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        ExecutorC0375i executorC0375i = C0379m.f1127a;
        C0379m.i(tVarB, anonymousClass1, executorC0375i);
        C0379m.i(C0379m.b(C0379m.g(getMSpineHealthModel().f68a, new A6.b(0))), new AnonymousClass2(), executorC0375i);
        getMSpineHealthModel().getClass();
        int i10 = AbstractC1073a.f23306c;
        C0379m.i((l) Optional.ofNullable((AbstractC1073a) D1.f.x(AbstractC1073a.class)).map(new A6.c(0)).orElseGet(new j(0)), new AnonymousClass3(), executorC0375i);
        getMSpineHealthModel().getClass();
        C0379m.i((l) Optional.ofNullable((AbstractC1073a) D1.f.x(AbstractC1073a.class)).map(new i(0)).orElseGet(new j(0)), new AnonymousClass4(), executorC0375i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCervicalSpineRemindEvent(Integer time) throws JSONException {
        if (checkDeviceAvailable()) {
            if (time == null || time.intValue() == 0) {
                A.h(TAG, "onCervicalSpineRemindEvent: invalid value " + time);
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(KEY_REMIND_TYPE, 2);
                jSONObject.put(EVENT_REMIND_TIME, time.intValue());
                C1722a.b(9, 3, jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onConnectStatusChanged(int status) throws JSONException {
        if (checkDeviceAvailable()) {
            if (status == 0) {
                A.x(TAG, "onConnectStatusChanged: connect state is none");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(EVENT_CONNECT_STATUS, status);
            C1722a.b(8, 2, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSpineFatigueRemindEvent(Integer time) throws JSONException {
        if (checkDeviceAvailable()) {
            if (time == null || time.intValue() == 0) {
                A.h(TAG, "onSpineFatigueRemindEvent: invalid value " + time);
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(KEY_REMIND_TYPE, 1);
                jSONObject.put(EVENT_REMIND_TIME, time.intValue());
                C1722a.b(9, 2, jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onWearStatusChanged(List<Integer> wearStatus) throws JSONException {
        if (checkDeviceAvailable()) {
            if (wearStatus.isEmpty()) {
                A.b(TAG, "onWearStatusChanged: no wear status");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(EVENT_WEAR_STATUS, wearStatus);
            C1722a.b(8, 1, jSONObject);
        }
    }

    @Override // com.oplus.melody.alive.component.health.module.BaseHealthModule
    public void handleHealthEvent(RpcMsg msg) {
        h.e(msg, "msg");
    }
}
