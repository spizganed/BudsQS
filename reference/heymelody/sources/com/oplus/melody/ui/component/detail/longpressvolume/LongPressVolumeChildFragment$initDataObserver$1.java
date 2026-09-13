package com.oplus.melody.ui.component.detail.longpressvolume;

import Wb.l;
import androidx.fragment.app.f;
import com.oplus.melody.model.repository.earphone.KeyFunctionInfoDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.ui.component.control.preference.ColorSingleSelectPreference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: LongPressVolumeChildFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class LongPressVolumeChildFragment$initDataObserver$1 extends FunctionReferenceImpl implements l<List<? extends KeyFunctionInfoDTO>, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(List<? extends KeyFunctionInfoDTO> list) {
        List<? extends KeyFunctionInfoDTO> p02 = list;
        h.e(p02, "p0");
        LongPressVolumeChildFragment longPressVolumeChildFragment = (LongPressVolumeChildFragment) this.receiver;
        longPressVolumeChildFragment.getClass();
        for (KeyFunctionInfoDTO keyFunctionInfoDTO : p02) {
            if (keyFunctionInfoDTO.getButtonAction() == 4) {
                int deviceType = keyFunctionInfoDTO.getDeviceType();
                ColorSingleSelectPreference colorSingleSelectPreference = deviceType != 1 ? deviceType != 2 ? null : longPressVolumeChildFragment.f21123D : longPressVolumeChildFragment.f21122C;
                f activity = longPressVolumeChildFragment.getActivity();
                int buttonAction = keyFunctionInfoDTO.getButtonAction();
                int function = keyFunctionInfoDTO.getFunction();
                String str = longPressVolumeChildFragment.f21127I;
                if (str == null) {
                    h.i("mProductName");
                    throw null;
                }
                K8.a.g(activity, colorSingleSelectPreference, buttonAction, N.b(function, str), 1);
            }
        }
        return Jb.l.f2618a;
    }
}
