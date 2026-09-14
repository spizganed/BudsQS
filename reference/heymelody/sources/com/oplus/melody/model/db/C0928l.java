package com.oplus.melody.model.db;

import android.bluetooth.BluetoothDevice;
import com.oplus.melody.btsdk.api.data.CompactnessDetectionInfo;
import com.oplus.melody.btsdk.api.data.EarTone;
import com.oplus.melody.btsdk.api.data.KeyFunctionInfo;
import com.oplus.melody.btsdk.api.data.MultiConnectInformationElement;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.model.net.data.PersonalDressInfoDO;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import com.oplus.melody.model.net.n;
import com.oplus.melody.model.repository.earphone.EarStatusDTO;
import com.oplus.melody.model.repository.earphone.EarToneDTO;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.FitDetectionDTO;
import com.oplus.melody.model.repository.earphone.KeyFunctionInfoDTO;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.model.repository.multidevicesconnect.MultiConnectStateDTO;
import com.oplus.melody.ui.component.hearingenhance.HearingEnhancementActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import la.C1307u;
import t8.C1532B;

/* JADX INFO: renamed from: com.oplus.melody.model.db.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0928l implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19776a;

    public /* synthetic */ C0928l(int i10) {
        this.f19776a = i10;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f19776a) {
            case 0:
                return new ArrayList();
            case 1:
                return new O7.l();
            case 2:
                return (PersonalDressInfoDO) com.oplus.melody.model.net.n.m(n.d.class, (String) obj);
            case 3:
                return (List) com.oplus.melody.model.net.n.m(n.e.class, (String) obj);
            case 4:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 5:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 6:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 7:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 8:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 9:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 10:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 11:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 12:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 13:
                return (EarphoneDTO) C0917x.c(EarphoneDTO.class, (String) obj);
            case 14:
                CompactnessDetectionInfo compactnessDetectionInfo = (CompactnessDetectionInfo) obj;
                return new FitDetectionDTO(compactnessDetectionInfo.getDeviceType(), compactnessDetectionInfo.getCompactStatus());
            case 15:
                return new KeyFunctionInfoDTO((KeyFunctionInfo) obj);
            case 16:
                return Integer.valueOf(((EarStatusDTO) obj).getRightStatus());
            case 17:
                return ((BluetoothDevice) obj).getAddress();
            case 18:
                return new EarToneDTO((EarTone) obj);
            case 19:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 20:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 21:
                return (SetCommandStateDTO) C0917x.c(SetCommandStateDTO.class, (String) obj);
            case 22:
                return (N) C0917x.c(N.class, (String) obj);
            case 23:
                return N.covertToZenModeInformationEntity((ZenModeInfoDO) obj, null);
            case 24:
                com.oplus.melody.common.util.A.i("CustomEqFragment", "setBassEngineValue", (Throwable) obj);
                return null;
            case 25:
                com.oplus.melody.common.util.A.i("KeepAliveFgServiceManager", "forceUpdateNotification", (Throwable) obj);
                return null;
            case 26:
                String it = (String) obj;
                kotlin.jvm.internal.h.e(it, "it");
                return (MultiConnectStateDTO) C0917x.c(MultiConnectStateDTO.class, it);
            case 27:
                MultiConnectInformationElement multiConnectInformationElement = (MultiConnectInformationElement) obj;
                return com.oplus.melody.common.util.A.q(multiConnectInformationElement.getDeviceName()) + ": " + multiConnectInformationElement.getConnectionState();
            case 28:
                com.oplus.melody.common.util.A.o(5, "EarScanFragmentV2", "startEarScan cancel or exception", (Throwable) obj);
                return null;
            default:
                File file = (File) obj;
                int i10 = HearingEnhancementActivity.f21566m0;
                if (file != null && file.isDirectory()) {
                    return (C1307u) C1532B.d(file, C1307u.class);
                }
                throw MelodyException.e(0, "Unknown file " + file);
        }
    }

    public /* synthetic */ C0928l(com.oplus.melody.model.net.n nVar, int i10) {
        this.f19776a = i10;
    }
}
