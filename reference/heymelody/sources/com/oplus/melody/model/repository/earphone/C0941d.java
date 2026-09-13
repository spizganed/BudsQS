package com.oplus.melody.model.repository.earphone;

import android.os.Bundle;
import com.oplus.melody.btsdk.api.data.MultiConnectInformationElement;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.model.db.HearingEnhancementEntity;
import com.oplus.melody.model.repository.earphone.L;
import com.oplus.melody.model.repository.multidevicesconnect.MultiConnectStateDTO;
import com.oplus.melody.model.repository.zenmode.ZenModeRepositoryClientImpl;
import com.oplus.melody.ui.component.hearingenhance.HearingEnhancementActivity;
import java.io.File;
import java.util.List;
import java.util.function.Function;
import la.C1307u;
import la.n0;
import t8.C1532B;
import u8.C1554b;

/* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0941d implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19944a;

    public /* synthetic */ C0941d(int i10) {
        this.f19944a = i10;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f19944a) {
            case 0:
                return (EarphoneDTO) obj;
            case 1:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 2:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 3:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 4:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 5:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 6:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 7:
                return (BoxCoverActionDTO) C0917x.c(BoxCoverActionDTO.class, (String) obj);
            case 8:
                return Integer.valueOf(((EarStatusDTO) obj).getBoxStatus());
            case 9:
                return new L.a();
            case 10:
                return (HearingEnhancementEntity) C0917x.c(HearingEnhancementEntity.class, (String) obj);
            case 11:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 12:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 13:
                return (HearingEnhancementEntity) C0914u.g((Bundle) obj, "value", HearingEnhancementEntity.class);
            case 14:
                return (C1554b) C1532B.d((File) obj, C1554b.class);
            case 15:
                int i10 = ZenModeRepositoryClientImpl.f20158s;
                return null;
            case 16:
                com.oplus.melody.common.util.A.i("ZenModeRepository", "getZenModeServerInformationList or database operation", (Throwable) obj);
                return null;
            case 17:
                return new O7.l();
            case 18:
                com.oplus.melody.common.util.A.o(5, "DevicePicRepository", "requestPicUrls", ((Throwable) obj).getCause());
                return null;
            case 19:
                return Integer.valueOf(((a7.d) obj).f7074b);
            case 20:
                return new O7.l();
            case 21:
                MultiConnectInformationElement multiConnectInformationElement = (MultiConnectInformationElement) obj;
                return new MultiConnectStateDTO.Element(multiConnectInformationElement.getAddress(), multiConnectInformationElement.getDeviceName(), multiConnectInformationElement.getConnectionState(), multiConnectInformationElement.isCurrentDevice(), multiConnectInformationElement.isMainAudioDevice(), multiConnectInformationElement.isAudioActive(), multiConnectInformationElement.getDeviceType());
            case 22:
                com.oplus.melody.common.util.A.o(5, "EarScanFragmentV2", "stopEarScan cancel or exception", (Throwable) obj);
                return null;
            case 23:
                File file = (File) obj;
                int i11 = HearingEnhancementActivity.f21566m0;
                if (file != null && file.isDirectory()) {
                    return (C1307u) C1532B.d(file, C1307u.class);
                }
                throw MelodyException.e(0, "Unknown file " + file);
            case 24:
                com.oplus.melody.common.util.A.i("HearingEnhancementDetectingFragment", "pauseCurrentNode cancel or exception", (Throwable) obj);
                return null;
            case 25:
                List<Integer> list = n0.f25864d0;
                com.oplus.melody.common.util.A.o(5, "HearingEnhancementDetectingFragmentV2", "stopHearingDetection cancel or exception", (Throwable) obj);
                return null;
            case 26:
                List<Integer> list2 = n0.f25864d0;
                com.oplus.melody.common.util.A.i("HearingEnhancementDetectingFragmentV2", "switchCurrentNodeEnhancementInfo cancel or exception", (Throwable) obj);
                return null;
            case 27:
                String it = (String) obj;
                kotlin.jvm.internal.h.e(it, "it");
                return Boolean.valueOf(Boolean.parseBoolean(it));
            case 28:
                String it2 = (String) obj;
                kotlin.jvm.internal.h.e(it2, "it");
                return it2;
            default:
                return Boolean.valueOf(kotlin.jvm.internal.h.a(obj, Boolean.TRUE));
        }
    }
}
