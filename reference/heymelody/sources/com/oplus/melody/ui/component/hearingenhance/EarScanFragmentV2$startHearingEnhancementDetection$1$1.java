package com.oplus.melody.ui.component.hearingenhance;

import Wb.l;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.widget.MelodyVideoAnimationView;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import la.C1305s;
import la.C1306t;
import la.n0;

/* JADX INFO: compiled from: EarScanFragmentV2.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class EarScanFragmentV2$startHearingEnhancementDetection$1$1 extends FunctionReferenceImpl implements l<SetCommandStateDTO, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(SetCommandStateDTO setCommandStateDTO) throws Exception {
        Intent intent;
        SetCommandStateDTO p02 = setCommandStateDTO;
        h.e(p02, "p0");
        EarScanFragmentV2 earScanFragmentV2 = (EarScanFragmentV2) this.receiver;
        earScanFragmentV2.getClass();
        if (p02.getSetCommandStatus() == 0) {
            A.b("EarScanFragmentV2", "startHearingEnhancementDetection send success...");
            earScanFragmentV2.f21563z = true;
            HearingEnhancementActivity hearingEnhancementActivity = earScanFragmentV2.f21553p;
            if (hearingEnhancementActivity != null && (intent = hearingEnhancementActivity.getIntent()) != null) {
                intent.putExtra("detection_id", earScanFragmentV2.f21554q);
                intent.putExtra("ear_scan_data", earScanFragmentV2.f21545B);
            }
            Fragment parentFragment = earScanFragmentV2.getParentFragment();
            C1306t c1306t = parentFragment instanceof C1306t ? (C1306t) parentFragment : null;
            if (c1306t != null) {
                A.c("GoldHearingDetectFragmentV2", new C1305s(c1306t, 0));
                A.b("GoldHearingDetectFragmentV2", "doLeftDetectingAnim");
                MelodyVideoAnimationView melodyVideoAnimationView = c1306t.f25942r;
                if (melodyVideoAnimationView == null) {
                    h.i("mAnimView");
                    throw null;
                }
                melodyVideoAnimationView.g(12150);
                MelodyVideoAnimationView melodyVideoAnimationView2 = c1306t.f25942r;
                if (melodyVideoAnimationView2 == null) {
                    h.i("mAnimView");
                    throw null;
                }
                if (!melodyVideoAnimationView2.c()) {
                    MelodyVideoAnimationView melodyVideoAnimationView3 = c1306t.f25942r;
                    if (melodyVideoAnimationView3 == null) {
                        h.i("mAnimView");
                        throw null;
                    }
                    melodyVideoAnimationView3.h();
                }
                c1306t.f25949y = true;
                c1306t.r(14066L, 16066L, true);
                c1306t.t(n0.class.getName());
            }
        } else {
            A.h("EarScanFragmentV2", "startHearingEnhancementDetection send fail, setCommandState:" + A.e(p02));
            earScanFragmentV2.f21563z = true;
            earScanFragmentV2.s(p02.getSetCommandStatus());
        }
        return Jb.l.f2618a;
    }
}
