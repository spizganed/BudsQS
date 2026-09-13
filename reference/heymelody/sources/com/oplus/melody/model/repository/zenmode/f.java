package com.oplus.melody.model.repository.zenmode;

import D7.j0;
import androidx.lifecycle.u;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.data.WhitelistContentDO;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.model.db.PersonalDressEntity;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import com.oplus.melody.ui.component.detail.personalnoise.PersonalNoiseItem;
import java.util.concurrent.CancellationException;
import java.util.function.Function;
import la.L;
import y7.InterfaceC1709a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20163a;

    public /* synthetic */ f(int i10) {
        this.f20163a = i10;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f20163a) {
            case 0:
                t tVar = new t();
                tVar.setDefaultSceneV2((ZenModeInfoDO) obj);
                return tVar;
            case 1:
                return new u();
            case 2:
                return Integer.valueOf(((WhitelistConfigDTO.Function) obj).getZenMode());
            case 3:
                return PersonalNoiseItem.lambda$useDirectly$18((Throwable) obj);
            case 4:
                return PersonalNoiseItem.lambda$startPersonalizedNoise$14((Throwable) obj);
            case 5:
                A.o(5, "SupportedDevicesImageRepository", "requestImageUrls", ((Throwable) obj).getCause());
                return null;
            case 6:
                return j0.f(obj);
            case 7:
                A.i("FitDetectionViewModel", "requestControlSource", (Throwable) obj);
                return null;
            case 8:
                return new O7.l();
            case 9:
                return new O7.l();
            case 10:
                float[] fArr = L.f25669Q0;
                A.i("HearingEnhancementDetectCompleteFragment", "tryInitHearingEnhancementAuditionMusic error ", (Throwable) obj);
                return null;
            case 11:
                String it = (String) obj;
                kotlin.jvm.internal.h.e(it, "it");
                return (PersonalDressEntity) C0917x.c(PersonalDressEntity.class, it);
            case 12:
                return Jb.l.f2618a;
            case 13:
                return Boolean.valueOf(kotlin.jvm.internal.h.a(obj, Boolean.TRUE));
            case 14:
                A.i("MultipleConnection", "triggerEarphoneMultiConnectState: ", (Throwable) obj);
                return null;
            case 15:
                Throwable th = (Throwable) obj;
                if (th.getCause() instanceof CancellationException) {
                    A.h("MultipleDevicesConnectionFragmentV2", "unpairHandheldDevice user operator canceled, return");
                } else {
                    A.i("MultipleDevicesConnectionFragmentV2", "unpairHandheldDevice exception", th);
                }
                return null;
            case 16:
                if (obj instanceof WhitelistContentDO) {
                    return (WhitelistContentDO) obj;
                }
                Class<WhitelistContentDO> cls = WhitelistContentDO.class;
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    return (WhitelistContentDO) (bArr != null ? C0917x.j("parseJsonBlob", new com.oplus.anim.s(2, bArr, cls)) : null);
                }
                if (obj instanceof String) {
                    return (WhitelistContentDO) C0917x.c(WhitelistContentDO.class, (String) obj);
                }
                throw MelodyException.e(0, "Unknown value type " + obj.getClass());
            case 17:
                A.i("HighAudioDetailFragment", "set codec type", (Throwable) obj);
                return null;
            default:
                return ((InterfaceC1709a) obj).getName();
        }
    }
}
