package com.oplus.melody.model.repository.earphone;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.oplus.melody.btsdk.api.data.BatteryInfo;
import com.oplus.melody.btsdk.api.data.DeviceInfo;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.model.bluetooth.BluetoothReceiveDTO;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import com.oplus.melody.model.repository.earphone.EarphoneStatusDO;
import ea.AbstractActivityC1022a;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import o5.C1371d;
import s8.AbstractC1508a;

/* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0949l implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Cloneable f19958c;

    public /* synthetic */ C0949l(Object obj, Cloneable cloneable, int i10) {
        this.f19956a = i10;
        this.f19957b = obj;
        this.f19958c = cloneable;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        Activity activity = null;
        switch (this.f19956a) {
            case 0:
                L l4 = (L) this.f19957b;
                BluetoothReceiveDTO bluetoothReceiveDTO = (BluetoothReceiveDTO) this.f19958c;
                DeviceInfo deviceInfo = (DeviceInfo) obj;
                EarphoneStatusDO earphoneStatusDO = (EarphoneStatusDO) obj2;
                l4.getClass();
                if (!com.oplus.melody.common.util.S.s(C0906l.f19501a)) {
                    if (deviceInfo == null || deviceInfo.getBatteryInfo() == null || deviceInfo.getBatteryInfo().isEmpty() || TextUtils.isEmpty(deviceInfo.getDeviceAddress())) {
                        com.oplus.melody.common.util.A.b("EarphoneRepository", "updateHeadsetBattery deviceInfo null, return!");
                    } else {
                        WhitelistConfigDTO whitelistConfigDTOB = AbstractC1508a.f().b(deviceInfo.getProductId(), deviceInfo.getDeviceName());
                        if (whitelistConfigDTOB != null && "realme".equals(whitelistConfigDTOB.getBrand())) {
                            int i10 = 0;
                            int i11 = 0;
                            int i12 = 0;
                            for (BatteryInfo batteryInfo : deviceInfo.getBatteryInfo()) {
                                if (batteryInfo != null) {
                                    int i13 = batteryInfo.mDeviceType;
                                    if (i13 == 1) {
                                        i11 = batteryInfo.mLevel;
                                    } else if (i13 == 2) {
                                        i12 = batteryInfo.mLevel;
                                    } else if (i13 == 3) {
                                        i10 = batteryInfo.mLevel;
                                    }
                                }
                            }
                            W6.d.a(i10, i11, i12, deviceInfo.getDeviceAddress());
                            C1371d.q(C0906l.f19501a, deviceInfo.getDeviceName());
                        }
                    }
                }
                EarphoneStatusDO.a aVar = (EarphoneStatusDO.a) com.oplus.melody.common.data.a.copyOf(earphoneStatusDO.getBoxBatteryStatus(), EarphoneStatusDO.a.class);
                N.x(aVar, 3, deviceInfo.getBatteryInfo());
                EarphoneStatusDO.a aVar2 = (EarphoneStatusDO.a) com.oplus.melody.common.data.a.copyOf(earphoneStatusDO.getLeftBatteryStatus(), EarphoneStatusDO.a.class);
                N.x(aVar2, 1, deviceInfo.getBatteryInfo());
                EarphoneStatusDO.a aVar3 = (EarphoneStatusDO.a) com.oplus.melody.common.data.a.copyOf(earphoneStatusDO.getRightBatteryStatus(), EarphoneStatusDO.a.class);
                N.x(aVar3, 2, deviceInfo.getBatteryInfo());
                earphoneStatusDO.setBoxBatteryStatus(aVar);
                earphoneStatusDO.setLeftBatteryStatus(aVar2);
                earphoneStatusDO.setRightBatteryStatus(aVar3);
                if (com.oplus.melody.common.util.A.l()) {
                    com.oplus.melody.common.util.A.b("EarphoneRepository", "refreshBattery eventId: 0x" + Integer.toHexString(bluetoothReceiveDTO.getEventId()) + ", left: " + aVar2 + ", right: " + aVar3 + ", box: " + aVar + ", mac: " + com.oplus.melody.common.util.A.r(deviceInfo.getDeviceAddress()));
                }
                if (L.h1(deviceInfo) && l4.f19917R.containsKey(deviceInfo.getDeviceAddress())) {
                    l4.k1(deviceInfo, "refreshBattery");
                    return;
                }
                return;
            case 1:
                EarphoneStatusDO earphoneStatusDO2 = (EarphoneStatusDO) obj2;
                ((L) this.f19957b).getClass();
                int mAclConnectState = earphoneStatusDO2.getMAclConnectState();
                int[] iArr = (int[]) this.f19958c;
                earphoneStatusDO2.setAclConnectionState(L.T0(iArr, mAclConnectState));
                earphoneStatusDO2.setHeadsetConnectionState(L.T0(iArr, earphoneStatusDO2.getMHeadsetConnectionState()));
                earphoneStatusDO2.setA2dpConnectionState(L.T0(iArr, earphoneStatusDO2.getMA2dpConnectionState()));
                earphoneStatusDO2.setConnectionState(L.T0(iArr, earphoneStatusDO2.getMConnectionState()));
                return;
            case 2:
                com.oplus.melody.model.repository.zenmode.s sVar = (com.oplus.melody.model.repository.zenmode.s) this.f19957b;
                ZenModeInfoDO zenModeInfoDO = (ZenModeInfoDO) this.f19958c;
                ZenModeInfoDO zenModeInfoDO2 = (ZenModeInfoDO) obj;
                Throwable th = (Throwable) obj2;
                sVar.getClass();
                com.oplus.melody.common.util.A.c("ZenModeRepository", new B9.f(18, zenModeInfoDO2, th));
                Optional.ofNullable(sVar.f20216w.get(zenModeInfoDO.getResId())).ifPresent(new c8.s(2, th, zenModeInfoDO));
                synchronized (sVar.f20218y) {
                    try {
                        Map<String, Boolean> mapD = sVar.f20215v.d();
                        if (mapD != null && mapD.containsKey(zenModeInfoDO2.getResId())) {
                            androidx.collection.a aVarC = C0901g.c(mapD);
                            aVarC.remove(zenModeInfoDO2.getResId());
                            sVar.f20215v.m(aVarC);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                    break;
                }
                if (sVar.f20217x.get(zenModeInfoDO.getResId()) != null) {
                    sVar.f20217x.get(zenModeInfoDO.getResId()).complete(null);
                    sVar.f20217x.remove(zenModeInfoDO.getResId());
                    return;
                }
                return;
            default:
                com.oplus.melody.model.repository.zenmode.t tVar = (com.oplus.melody.model.repository.zenmode.t) obj;
                Throwable th3 = (Throwable) obj2;
                int i14 = AbstractActivityC1022a.f22940b0;
                AbstractActivityC1022a abstractActivityC1022a = (AbstractActivityC1022a) this.f19957b;
                abstractActivityC1022a.getClass();
                Context baseContext = abstractActivityC1022a;
                while (true) {
                    if (baseContext instanceof ContextWrapper) {
                        if (!Activity.class.isInstance(baseContext)) {
                            baseContext = ((ContextWrapper) baseContext).getBaseContext();
                        } else if (baseContext instanceof Activity) {
                            activity = (Activity) baseContext;
                        }
                    }
                }
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
                com.oplus.melody.common.util.A.o(5, abstractActivityC1022a.f1646Q, "fetchResource", th3);
                if (tVar == null) {
                    abstractActivityC1022a.K(3);
                    return;
                }
                abstractActivityC1022a.K(1);
                Bundle extras = ((Intent) this.f19958c).getExtras();
                if (extras == null) {
                    extras = new Bundle();
                }
                extras.putString("resZipConfig", C0917x.i(tVar));
                abstractActivityC1022a.M(extras);
                return;
        }
    }
}
