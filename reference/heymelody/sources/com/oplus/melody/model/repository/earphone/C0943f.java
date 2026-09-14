package com.oplus.melody.model.repository.earphone;

import com.oplus.melody.btsdk.api.data.DeviceInfo;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0943f implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19946a;

    public /* synthetic */ C0943f(int i10) {
        this.f19946a = i10;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f19946a) {
            case 0:
                DeviceInfo deviceInfo = (DeviceInfo) obj;
                EarphoneStatusDO earphoneStatusDO = (EarphoneStatusDO) obj2;
                int tapLevelSettingValue = deviceInfo.getTapLevelSettingValue();
                int tapLevelDefaultValue = deviceInfo.getTapLevelDefaultValue();
                earphoneStatusDO.setTapLevelSettingValue(tapLevelSettingValue);
                earphoneStatusDO.setTapLevelDefaultValue(tapLevelDefaultValue);
                break;
            case 1:
                ((EarphoneStatusDO) obj2).setSpineCalibrationResult(((DeviceInfo) obj).getSpineCalibrationResult());
                break;
            case 2:
                ((EarphoneStatusDO) obj2).setVolumeValueInfo(((DeviceInfo) obj).getVolumeValueInfo());
                break;
            case 3:
                ((EarphoneStatusDO) obj2).setAiTranslationAppStatus(((DeviceInfo) obj).getAITranslationAppStatus());
                break;
            case 4:
                int gameMode = ((DeviceInfo) obj).getGameMode();
                com.oplus.melody.common.util.A.c("EarphoneRepository", new com.oplus.melody.btsdk.protocol.commands.k(gameMode, 10));
                ((EarphoneStatusDO) obj2).setGameModeStatus(gameMode);
                break;
            case 5:
                ((EarphoneStatusDO) obj2).setCodecList(((DeviceInfo) obj).getCodecList());
                break;
            case 6:
                Boolean bool = (Boolean) obj;
                EarphoneStatusDO earphoneStatusDO2 = (EarphoneStatusDO) obj2;
                earphoneStatusDO2.setConnectedShown(bool.booleanValue());
                earphoneStatusDO2.setVersionListReceived(bool.booleanValue());
                break;
            case 7:
                EarphoneStatusDO earphoneStatusDO3 = (EarphoneStatusDO) obj2;
                int iIntValue = ((Integer) obj).intValue();
                Pattern pattern = N.f19941a;
                int i10 = 2;
                if (iIntValue != 2) {
                    i10 = 1;
                    if (iIntValue != 1) {
                        i10 = 3;
                        if (iIntValue == 3) {
                            i10 = 4;
                        }
                    }
                }
                earphoneStatusDO3.setHeadsetConnectionState(i10);
                break;
            case 8:
                ((EarphoneStatusDO) obj2).setCodecType(((DeviceInfo) obj).getCodecType());
                break;
            default:
                ((EarphoneStatusDO) obj2).setZenModeStatus(((DeviceInfo) obj).getZenModeSwitchStatus());
                break;
        }
    }
}
