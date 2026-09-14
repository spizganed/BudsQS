package com.oplus.melody.model.repository.earphone;

import com.oplus.melody.btsdk.api.data.DeviceInfo;
import com.oplus.melody.btsdk.api.data.EarTone;
import com.oplus.melody.model.db.C0928l;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0945h implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19948a;

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f19948a) {
            case 0:
                ((EarphoneStatusDO) obj2).setSpineCalibrateState(((DeviceInfo) obj).getSpineCalibrationState());
                break;
            case 1:
                EarphoneStatusDO earphoneStatusDO = (EarphoneStatusDO) obj2;
                List<EarTone> earTone = ((DeviceInfo) obj).getEarTone();
                if (earTone == null) {
                    earTone = Collections.EMPTY_LIST;
                }
                List<EarToneDTO> list = (List) earTone.stream().map(new C0928l(18)).collect(Collectors.toList());
                if (com.oplus.melody.common.util.A.l()) {
                    com.oplus.melody.common.util.A.b("EarphoneRepository", "onEarphoneEarToneChange earTone = " + list);
                }
                earphoneStatusDO.setEarTones(list);
                break;
            case 2:
                boolean zIsSupportBindAccount = ((DeviceInfo) obj).isSupportBindAccount();
                com.oplus.melody.common.util.A.c("EarphoneRepository", new A9.i(18, zIsSupportBindAccount));
                ((EarphoneStatusDO) obj2).setSupportBindAccount(zIsSupportBindAccount);
                break;
            case 3:
                ((EarphoneStatusDO) obj2).setSpineRangeDetection(((DeviceInfo) obj).getSpineRangeDetection());
                break;
            case 4:
                DeviceInfo deviceInfo = (DeviceInfo) obj;
                EarphoneStatusDO earphoneStatusDO2 = (EarphoneStatusDO) obj2;
                earphoneStatusDO2.setHeadsetActive(deviceInfo.isHeadsetActive() ? 1 : 0);
                earphoneStatusDO2.setA2dpActive(deviceInfo.isA2dpActive() ? 1 : 0);
                earphoneStatusDO2.setLeActive(deviceInfo.isLeAudioActive() ? 1 : 0);
                break;
            case 5:
                EarphoneStatusDO earphoneStatusDO3 = (EarphoneStatusDO) obj2;
                List<DeviceVersionDTO> listFromVersionList = DeviceVersionDTO.fromVersionList(((DeviceInfo) obj).getVersionInfo());
                if (com.oplus.melody.common.util.A.l()) {
                    com.oplus.melody.common.util.A.b("EarphoneRepository", "refreshVersion:after convert refreshVersion size:" + listFromVersionList.size() + ", " + listFromVersionList);
                }
                earphoneStatusDO3.setVersionListReceived(true);
                earphoneStatusDO3.setDeviceVersionList(listFromVersionList);
                break;
            case 6:
                ((EarphoneStatusDO) obj2).setDeviceBonded(((Boolean) obj).booleanValue());
                break;
            case 7:
                DeviceInfo deviceInfo2 = (DeviceInfo) obj;
                com.oplus.melody.common.util.A.c("EarphoneRepository", new q(deviceInfo2, 0));
                ((EarphoneStatusDO) obj2).setBoxSn(deviceInfo2.getBoxSn());
                break;
            case 8:
                break;
            default:
                String str = (String) obj;
                ConcurrentHashMap concurrentHashMap = t8.q.f27951c;
                Object obj3 = t8.q.f27949a;
                if (obj2 == null) {
                    obj2 = obj3;
                }
                concurrentHashMap.put(str, obj2);
                break;
        }
    }
}
