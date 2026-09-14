package com.oplus.melody.model.repository.earphone;

import android.os.Build;
import android.os.SystemClock;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.T, reason: from Kotlin metadata */
/* JADX INFO: compiled from: WearDetectDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003JQ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015¨\u0006!"}, d2 = {"Lcom/oplus/melody/model/repository/earphone/WearDetectDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "address", "", "switchStatus", "", "isEarStatusValid", "", "a2dpConnected", "leftStatus", "rightStatus", "isChannelSwitchOn", "<init>", "(Ljava/lang/String;IZZIIZ)V", "earphone", "Lcom/oplus/melody/model/repository/earphone/EarphoneDTO;", "(Lcom/oplus/melody/model/repository/earphone/EarphoneDTO;)V", "getAddress", "()Ljava/lang/String;", "getSwitchStatus", "()I", "()Z", "getA2dpConnected", "getLeftStatus", "getRightStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class WearDetectDTO extends com.oplus.melody.common.data.a {
    private final boolean a2dpConnected;
    private final String address;
    private final boolean isChannelSwitchOn;
    private final boolean isEarStatusValid;
    private final int leftStatus;
    private final int rightStatus;
    private final int switchStatus;

    public WearDetectDTO() {
        this(null, 0, false, false, 0, 0, false, 127, null);
    }

    public static /* synthetic */ WearDetectDTO copy$default(WearDetectDTO wearDetectDTO, String str, int i10, boolean z2, boolean z4, int i11, int i12, boolean z10, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = wearDetectDTO.address;
        }
        if ((i13 & 2) != 0) {
            i10 = wearDetectDTO.switchStatus;
        }
        if ((i13 & 4) != 0) {
            z2 = wearDetectDTO.isEarStatusValid;
        }
        if ((i13 & 8) != 0) {
            z4 = wearDetectDTO.a2dpConnected;
        }
        if ((i13 & 16) != 0) {
            i11 = wearDetectDTO.leftStatus;
        }
        if ((i13 & 32) != 0) {
            i12 = wearDetectDTO.rightStatus;
        }
        if ((i13 & 64) != 0) {
            z10 = wearDetectDTO.isChannelSwitchOn;
        }
        int i14 = i12;
        boolean z11 = z10;
        int i15 = i11;
        boolean z12 = z2;
        return wearDetectDTO.copy(str, i10, z12, z4, i15, i14, z11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSwitchStatus() {
        return this.switchStatus;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsEarStatusValid() {
        return this.isEarStatusValid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getA2dpConnected() {
        return this.a2dpConnected;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getLeftStatus() {
        return this.leftStatus;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getRightStatus() {
        return this.rightStatus;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsChannelSwitchOn() {
        return this.isChannelSwitchOn;
    }

    public final WearDetectDTO copy(String str, int i10, boolean z2, boolean z4, int i11, int i12, boolean z10) {
        return new WearDetectDTO(str, i10, z2, z4, i11, i12, z10);
    }

    public final boolean getA2dpConnected() {
        return this.a2dpConnected;
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getLeftStatus() {
        return this.leftStatus;
    }

    public final int getRightStatus() {
        return this.rightStatus;
    }

    public final int getSwitchStatus() {
        return this.switchStatus;
    }

    public final boolean isChannelSwitchOn() {
        return this.isChannelSwitchOn;
    }

    public final boolean isEarStatusValid() {
        return this.isEarStatusValid;
    }

    public WearDetectDTO(String str, int i10, boolean z2, boolean z4, int i11, int i12, boolean z10) {
        this.address = str;
        this.switchStatus = i10;
        this.isEarStatusValid = z2;
        this.a2dpConnected = z4;
        this.leftStatus = i11;
        this.rightStatus = i12;
        this.isChannelSwitchOn = z10;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ WearDetectDTO(java.lang.String r2, int r3, boolean r4, boolean r5, int r6, int r7, boolean r8, int r9, kotlin.jvm.internal.d r10) {
        /*
            r1 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L5
            r2 = 0
        L5:
            r10 = r9 & 2
            r0 = 0
            if (r10 == 0) goto Lb
            r3 = r0
        Lb:
            r10 = r9 & 4
            if (r10 == 0) goto L10
            r4 = r0
        L10:
            r10 = r9 & 8
            if (r10 == 0) goto L15
            r5 = r0
        L15:
            r10 = r9 & 16
            if (r10 == 0) goto L1a
            r6 = r0
        L1a:
            r10 = r9 & 32
            if (r10 == 0) goto L1f
            r7 = r0
        L1f:
            r9 = r9 & 64
            if (r9 == 0) goto L2c
            r10 = r0
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L34
        L2c:
            r10 = r8
            r9 = r7
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L34:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.model.repository.earphone.WearDetectDTO.<init>(java.lang.String, int, boolean, boolean, int, int, boolean, int, kotlin.jvm.internal.d):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public WearDetectDTO(EarphoneDTO earphone) {
        int i10;
        Long l4;
        kotlin.jvm.internal.h.e(earphone, "earphone");
        String macAddress = earphone.getMacAddress();
        Pattern pattern = N.f19941a;
        long aclConnectionTime = earphone.getAclConnectionState() == 2 ? earphone.getAclConnectionTime() : 0L;
        aclConnectionTime = earphone.getHeadsetConnectionState() == 2 ? N.r(aclConnectionTime, earphone.getHeadsetConnectionTime()) : aclConnectionTime;
        aclConnectionTime = earphone.getA2dpConnectionState() == 2 ? N.r(aclConnectionTime, earphone.getA2dpConnectionTime()) : aclConnectionTime;
        aclConnectionTime = earphone.getConnectionState() == 2 ? N.r(aclConnectionTime, earphone.getSppConnectionTime()) : aclConnectionTime;
        for (Map.Entry<String, Integer> entry : earphone.getLeAudioConnectionStateMap().entrySet()) {
            if (entry.getValue().intValue() == 2 && (l4 = earphone.getLeAudioConnectionTimeMap().get(entry.getKey())) != null) {
                aclConnectionTime = N.r(aclConnectionTime, l4.longValue());
            }
        }
        long j5 = aclConnectionTime - 3000;
        long jCurrentTimeMillis = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - earphone.getEarStatusReceivedMillis());
        boolean z2 = false;
        if (j5 <= 0 || j5 > jCurrentTimeMillis) {
            i10 = 0;
        } else {
            i10 = 0;
            z2 = true;
        }
        boolean z4 = (Build.VERSION.SDK_INT <= 34 || earphone.getA2dpConnectionState() != 2) ? i10 : 1;
        int wearDetectionStatus = earphone.getWearDetectionStatus();
        EarStatusDTO earStatus = earphone.getEarStatus();
        int leftStatus = earStatus != null ? earStatus.getLeftStatus() : i10;
        EarStatusDTO earStatus2 = earphone.getEarStatus();
        this(macAddress, wearDetectionStatus, z2, z4, leftStatus, earStatus2 != null ? earStatus2.getRightStatus() : i10, N.m(earphone));
    }
}
