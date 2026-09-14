package com.oplus.melody.ui.component.detail.spatialaudio;

import Wb.l;
import android.widget.LinearLayout;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.widget.devicecontrol.DeviceControlWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: SpatialAudioContentFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class SpatialAudioContentFragment$initDataObserver$1 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(Integer num) {
        int iIntValue = num.intValue();
        SpatialAudioContentFragment spatialAudioContentFragment = (SpatialAudioContentFragment) this.receiver;
        spatialAudioContentFragment.f21261B = iIntValue;
        if (iIntValue == 2 && !spatialAudioContentFragment.f21262C) {
            spatialAudioContentFragment.t().i();
            DeviceControlWidget deviceControlWidget = spatialAudioContentFragment.f21279q;
            if (deviceControlWidget == null) {
                h.i("mControlView");
                throw null;
            }
            deviceControlWidget.setEnable(true);
            LinearLayout linearLayout = spatialAudioContentFragment.f21282t;
            if (linearLayout == null) {
                h.i("mAudioPreviewLayout");
                throw null;
            }
            linearLayout.setEnabled(true);
            spatialAudioContentFragment.f21268J = false;
        } else if (iIntValue != 3 && !spatialAudioContentFragment.f21262C) {
            A.c("SpatialAudioContentFragment", new Ba.b(iIntValue, 13));
        } else if (spatialAudioContentFragment.getContext() != null) {
            if (!spatialAudioContentFragment.f21267I) {
                E8.a.S(spatialAudioContentFragment.getContext(), R.string.melody_ui_spatial_audio_disconnected);
            }
            LinearLayout linearLayout2 = spatialAudioContentFragment.f21282t;
            if (linearLayout2 == null) {
                h.i("mAudioPreviewLayout");
                throw null;
            }
            linearLayout2.setSelected(false);
            DeviceControlWidget deviceControlWidget2 = spatialAudioContentFragment.f21279q;
            if (deviceControlWidget2 == null) {
                h.i("mControlView");
                throw null;
            }
            deviceControlWidget2.setEnable(false);
            spatialAudioContentFragment.v();
        }
        A.c("SpatialAudioContentFragment", new Ga.a(iIntValue, spatialAudioContentFragment, 1));
        return Jb.l.f2618a;
    }
}
