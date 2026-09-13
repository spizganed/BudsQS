package com.oplus.melody.app.discovery;

import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.HeadsetRssiDetectionDTO;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.track.constant.AppConstant$DiscoverOpType;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import java.util.function.BiConsumer;
import kc.C1264t;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f18823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f18824d;

    public /* synthetic */ C(Object obj, Object obj2, int i10, int i11) {
        this.f18821a = i11;
        this.f18823c = obj;
        this.f18824d = obj2;
        this.f18822b = i10;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        Object obj3 = this.f18824d;
        int i10 = this.f18822b;
        Object obj4 = this.f18823c;
        switch (this.f18821a) {
            case 0:
                int i11 = DiscoveryDialogActivity.f18836L0;
                ((DiscoveryDialogActivity) obj4).getClass();
                E0 e02 = (E0) obj3;
                DiscoveryDialogActivity.g0(e02.getProductId(), e02.getId(), AppConstant$DiscoverOpType.CONNECTING, Integer.toString(i10), (HeadsetRssiDetectionDTO) obj);
                break;
            default:
                SetCommandStateDTO setCommandStateDTO = (SetCommandStateDTO) obj;
                Throwable th = (Throwable) obj2;
                com.oplus.melody.model.repository.earphone.L l4 = (com.oplus.melody.model.repository.earphone.L) obj4;
                l4.getClass();
                if (th != null) {
                    com.oplus.melody.common.util.A.i("EarphoneRepository", "setTapLevelSettingValue set value " + i10, th);
                } else {
                    int setCommandStatus = setCommandStateDTO.getSetCommandStatus();
                    if (setCommandStatus != 0) {
                        com.oplus.melody.common.util.A.h("EarphoneRepository", "setTapLevelSettingValue fail, getSetCommandStatus " + setCommandStatus);
                    } else {
                        String str = (String) obj3;
                        EarphoneDTO earphoneDTOW = l4.w(str);
                        C1264t.t(AppConstant$FunctionType.TAP_LEVEL.getFunType(), earphoneDTOW.getProductId(), str, com.oplus.melody.model.repository.earphone.N.t(earphoneDTOW), String.valueOf(i10));
                    }
                }
                break;
        }
    }
}
