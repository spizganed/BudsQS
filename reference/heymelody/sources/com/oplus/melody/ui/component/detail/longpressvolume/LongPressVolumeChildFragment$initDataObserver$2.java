package com.oplus.melody.ui.component.detail.longpressvolume;

import A9.d;
import A9.m;
import G7.b;
import G8.k;
import Wb.l;
import android.content.Context;
import androidx.appcompat.app.f;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: LongPressVolumeChildFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class LongPressVolumeChildFragment$initDataObserver$2 extends FunctionReferenceImpl implements l<m, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(m mVar) {
        LongPressVolumeViewModel longPressVolumeViewModel;
        m p02 = mVar;
        h.e(p02, "p0");
        LongPressVolumeChildFragment longPressVolumeChildFragment = (LongPressVolumeChildFragment) this.receiver;
        longPressVolumeChildFragment.getClass();
        A.c("LongPressVolumeChildFragment", new d(p02, 0));
        if (p02.getConnectionState() != 2) {
            longPressVolumeChildFragment.requireActivity().finish();
        } else {
            boolean z2 = p02.getStatus() == 1;
            COUISwitchPreference cOUISwitchPreference = longPressVolumeChildFragment.f21129z;
            if (cOUISwitchPreference != null) {
                cOUISwitchPreference.setChecked(z2);
            }
            COUIPreferenceCategory cOUIPreferenceCategory = longPressVolumeChildFragment.f21120A;
            if (cOUIPreferenceCategory != null) {
                cOUIPreferenceCategory.setVisible(z2);
            }
            COUIPreferenceCategory cOUIPreferenceCategory2 = longPressVolumeChildFragment.f21121B;
            if (cOUIPreferenceCategory2 != null) {
                cOUIPreferenceCategory2.setVisible(z2);
            }
            if (z2 && (longPressVolumeViewModel = longPressVolumeChildFragment.f21124E) != null && longPressVolumeViewModel.f21119c) {
                if (longPressVolumeChildFragment.f21128J == null) {
                    Context contextRequireContext = longPressVolumeChildFragment.requireContext();
                    h.d(contextRequireContext, "requireContext(...)");
                    b bVar = new b(contextRequireContext, R.style.COUIAlertDialog_Bottom);
                    bVar.n(R.string.melody_ui_long_press_volume_notice_title);
                    bVar.f(R.string.melody_ui_long_press_volume_tips);
                    bVar.h(R.string.melody_ui_got_it, new k(3));
                    longPressVolumeChildFragment.f21128J = bVar.setCancelable(false).create();
                    Jb.l lVar = Jb.l.f2618a;
                }
                f fVar = longPressVolumeChildFragment.f21128J;
                if (fVar != null) {
                    fVar.show();
                }
            }
            LongPressVolumeViewModel longPressVolumeViewModel2 = longPressVolumeChildFragment.f21124E;
            if (longPressVolumeViewModel2 != null) {
                longPressVolumeViewModel2.f21119c = true;
            }
        }
        return Jb.l.f2618a;
    }
}
