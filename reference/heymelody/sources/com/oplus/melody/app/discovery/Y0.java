package com.oplus.melody.app.discovery;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.heytap.headset.R;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.common.util.C0912s;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.repository.firmware.FirmwareDTO;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import kc.C1264t;
import x3.C1656o;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Y0 implements androidx.lifecycle.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0850f1 f19023b;

    public /* synthetic */ Y0(C0850f1 c0850f1, int i10) {
        this.f19022a = i10;
        this.f19023b = c0850f1;
    }

    @Override // androidx.lifecycle.v
    public final void onChanged(Object obj) {
        switch (this.f19022a) {
            case 0:
                W9.g gVar = (W9.g) obj;
                final C0850f1 c0850f1 = this.f19023b;
                c0850f1.getClass();
                if (gVar.isHighToneQualityOn() && 8 == gVar.getCodecType()) {
                    b.C0229b.f19632a.a(gVar.getAddress(), LeFilterConstants.FunType.HI_QUALITY_AUDIO.getFunType(), new b.c() { // from class: com.oplus.melody.app.discovery.a1
                        @Override // com.oplus.melody.leaudio.b.c
                        public final void j(boolean z2) {
                            C0850f1 c0850f12 = c0850f1;
                            c0850f12.H = !z2;
                            c0850f12.u();
                        }
                    });
                } else {
                    c0850f1.H = false;
                    c0850f1.u();
                }
                break;
            default:
                final FirmwareDTO firmwareDTO = (FirmwareDTO) obj;
                final C0850f1 c0850f12 = this.f19023b;
                final E0 e0S = c0850f12.f18929b.S();
                if (e0S != null && e0S.isOtaEnabled() && !e0S.isAutoOtaOn() && !TextUtils.isEmpty(e0S.getSoftwareVersion()) && TextUtils.equals(firmwareDTO.getProductId(), e0S.getProductId()) && C0912s.b(e0S.getSoftwareVersion(), firmwareDTO.getSoftwareVersion()) < 0) {
                    b.C0229b.f19632a.a(e0S.getId(), LeFilterConstants.FunType.FIRMWARE_UPDATE.getFunType(), new b.c() { // from class: com.oplus.melody.app.discovery.S0
                        @Override // com.oplus.melody.leaudio.b.c
                        public final void j(boolean z2) {
                            C0850f1 c0850f13 = c0850f12;
                            c0850f13.getClass();
                            FirmwareDTO firmwareDTO2 = firmwareDTO;
                            com.oplus.melody.common.util.A.c("DiscoveryViewStateConnectedImpl", new Ea.K(z2, firmwareDTO2, 5));
                            if (z2) {
                                return;
                            }
                            DiscoveryDialogActivity discoveryDialogActivity = c0850f13.f18929b;
                            String string = discoveryDialogActivity.getString(R.string.melody_common_discovery_firmware_click);
                            String string2 = discoveryDialogActivity.getString(R.string.melody_common_discovery_firmware_info, string);
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string2);
                            O1.a aVar = new O1.a(discoveryDialogActivity);
                            int iIndexOf = string2.indexOf(string);
                            spannableStringBuilder.setSpan(aVar, iIndexOf, string.length() + iIndexOf, 33);
                            String str = ":" + firmwareDTO2.getSoftwareVersion();
                            E0 e02 = e0S;
                            C1264t.t(AppConstant$FunctionType.FIRMWARE_UPGRADE_GUIDE.getFunType(), e02.getProductId(), e02.getId(), e02.getSoftwareVersion(), C1656o.a(BaseHealthModule.TRACK_ACTIVE_DETECT, str));
                            c0850f13.f19071F = spannableStringBuilder;
                            c0850f13.f19072G = new P0(c0850f13, e02, str);
                            c0850f13.u();
                        }
                    });
                    break;
                }
                break;
        }
    }
}
