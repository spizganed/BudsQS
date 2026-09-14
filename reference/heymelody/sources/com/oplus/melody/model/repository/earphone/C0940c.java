package com.oplus.melody.model.repository.earphone;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.oplus.melody.btsdk.api.data.KeyFunctionInfo;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.model.db.HearingEnhancementEntity;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import com.oplus.melody.ui.component.detail.equalizer.EqualizerItem;
import com.oplus.melody.ui.component.detail.personalnoise.PersonalNoiseItem;
import com.oplus.melody.ui.component.hearingenhance.HearingEnhancementActivity;
import java.io.File;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import t8.C1532B;
import u8.C1554b;

/* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0940c implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19943a;

    public /* synthetic */ C0940c(int i10) {
        this.f19943a = i10;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f19943a) {
            case 0:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 1:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 2:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 3:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 4:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 5:
                return (EarphoneDTO) C0917x.c(EarphoneDTO.class, (String) obj);
            case 6:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 7:
                return (HeadsetRssiDetectionDTO) C0917x.c(HeadsetRssiDetectionDTO.class, (String) obj);
            case 8:
                return (EarphoneDTO) C0917x.c(EarphoneDTO.class, (String) obj);
            case 9:
                KeyFunctionInfoDTO keyFunctionInfoDTO = (KeyFunctionInfoDTO) obj;
                return new KeyFunctionInfo(keyFunctionInfoDTO.getDeviceType(), keyFunctionInfoDTO.getDeviceButton(), keyFunctionInfoDTO.getButtonAction(), keyFunctionInfoDTO.getFunction());
            case 10:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 11:
                String str = (String) obj;
                return str != null ? Boolean.valueOf(str) : Boolean.FALSE;
            case 12:
                return (HearingEnhancementEntity) C0914u.g((Bundle) obj, "value", HearingEnhancementEntity.class);
            case 13:
                File file = (File) obj;
                if (file != null && file.isDirectory()) {
                    return (com.oplus.melody.model.repository.zenmode.t) C1532B.d(file, com.oplus.melody.model.repository.zenmode.t.class);
                }
                throw MelodyException.e(0, "Unknown file " + file);
            case 14:
                return (ZenModeInfoDO) C0914u.g((Bundle) obj, "value", ZenModeInfoDO.class);
            case 15:
                return new CompletableFuture();
            case 16:
                return PersonalNoiseItem.lambda$onRetry$23((Throwable) obj);
            case 17:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 18:
                return EqualizerItem.lambda$refreshEqualizerModeInfo$11((File) obj);
            case 19:
                return EqualizerItem.lambda$new$4((FragmentManager) obj);
            case 20:
                return Integer.valueOf(Integer.bitCount(((Integer) obj).intValue()));
            case 21:
                return new O7.l();
            case 22:
                com.oplus.melody.common.util.A.o(5, "EarScanFragmentV2", "stopEarScan cancel or exception", (Throwable) obj);
                return null;
            case 23:
                int i10 = HearingEnhancementActivity.f21566m0;
                return null;
            case 24:
                com.oplus.melody.common.util.A.o(5, "HearingEnhancementDetectingFragment", "stopHearingDetection cancel or exception", (Throwable) obj);
                return null;
            case 25:
                com.oplus.melody.common.util.A.i("HearingEnhancementListFragment", "setSwitchFeature cancel or exception", (Throwable) obj);
                return null;
            case 26:
                return Optional.of((C1554b) C1532B.d((File) obj, C1554b.class));
            case 27:
                String it = (String) obj;
                kotlin.jvm.internal.h.e(it, "it");
                return it;
            case 28:
                return Jb.l.f2618a;
            default:
                com.oplus.melody.common.util.A.i("GameSetFragment", "setGameModeMainEnable", (Throwable) obj);
                return null;
        }
    }

    public /* synthetic */ C0940c(D7.G g3) {
        this.f19943a = 28;
    }
}
