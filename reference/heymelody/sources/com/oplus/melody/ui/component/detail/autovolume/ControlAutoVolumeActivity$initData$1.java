package com.oplus.melody.ui.component.detail.autovolume;

import S8.a;
import Wb.l;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.widget.MelodySwitchPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: ControlAutoVolumeActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class ControlAutoVolumeActivity$initData$1 extends FunctionReferenceImpl implements l<a, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(a aVar) {
        a p02 = aVar;
        h.e(p02, "p0");
        ControlAutoVolumeActivity controlAutoVolumeActivity = (ControlAutoVolumeActivity) this.receiver;
        int i10 = ControlAutoVolumeActivity.f20641Z;
        controlAutoVolumeActivity.getClass();
        A.c("AutoVolumeActivity", new B6.a(p02, 25));
        if (p02.isConnected()) {
            MelodySwitchPreference melodySwitchPreference = controlAutoVolumeActivity.f20645X;
            if (melodySwitchPreference == null) {
                h.i("mAutoVolumeSwitch");
                throw null;
            }
            melodySwitchPreference.setEnabled(true);
            MelodySwitchPreference melodySwitchPreference2 = controlAutoVolumeActivity.f20645X;
            if (melodySwitchPreference2 == null) {
                h.i("mAutoVolumeSwitch");
                throw null;
            }
            melodySwitchPreference2.setChecked(p02.isAutoVolumeOn());
        } else {
            MelodySwitchPreference melodySwitchPreference3 = controlAutoVolumeActivity.f20645X;
            if (melodySwitchPreference3 == null) {
                h.i("mAutoVolumeSwitch");
                throw null;
            }
            melodySwitchPreference3.setEnabled(false);
        }
        return Jb.l.f2618a;
    }
}
