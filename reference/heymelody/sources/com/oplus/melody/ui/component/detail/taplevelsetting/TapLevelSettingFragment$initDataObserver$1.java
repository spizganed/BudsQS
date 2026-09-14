package com.oplus.melody.ui.component.detail.taplevelsetting;

import D7.C0386u;
import Wb.l;
import android.widget.TextView;
import com.coui.appcompat.seekbar.FixCOUISectionSeekBar;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.component.detail.taplevelsetting.TapLevelSettingFragment;
import com.oplus.melody.ui.widget.MelodyTapLevelSettingSeekBarPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: TapLevelSettingFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class TapLevelSettingFragment$initDataObserver$1 extends FunctionReferenceImpl implements l<V9.a, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(V9.a aVar) {
        V9.a p02 = aVar;
        h.e(p02, "p0");
        TapLevelSettingFragment tapLevelSettingFragment = (TapLevelSettingFragment) this.receiver;
        tapLevelSettingFragment.getClass();
        A.f("TapLevelSettingFragment", "onTapLevelSettingValueStateChanged tapLevelSettingInfoVO = " + p02);
        if (p02.getConnectionState() != 2) {
            tapLevelSettingFragment.requireActivity().finish();
        } else {
            MelodyTapLevelSettingSeekBarPreference melodyTapLevelSettingSeekBarPreference = tapLevelSettingFragment.f21301A;
            if (melodyTapLevelSettingSeekBarPreference != null) {
                A.c("MelodyTapLevelSettingSeekBarPreference", new C0386u(6, p02, melodyTapLevelSettingSeekBarPreference));
                int settingValue = p02.getSettingValue();
                if (settingValue != 0 && settingValue != melodyTapLevelSettingSeekBarPreference.f21941q) {
                    melodyTapLevelSettingSeekBarPreference.f21941q = settingValue;
                    FixCOUISectionSeekBar fixCOUISectionSeekBar = melodyTapLevelSettingSeekBarPreference.f21937a;
                    if (fixCOUISectionSeekBar != null) {
                        fixCOUISectionSeekBar.setProgress(settingValue - 1);
                    }
                    TextView textView = melodyTapLevelSettingSeekBarPreference.f21938b;
                    if (textView != null) {
                        textView.setText(String.valueOf(melodyTapLevelSettingSeekBarPreference.f21941q));
                    }
                }
                if (p02.getDefaultValue() != 0) {
                    melodyTapLevelSettingSeekBarPreference.f21942r = p02.getDefaultValue();
                    melodyTapLevelSettingSeekBarPreference.e();
                    TapLevelSettingFragment.b bVar = melodyTapLevelSettingSeekBarPreference.f21940p;
                    if (bVar != null) {
                        bVar.a(melodyTapLevelSettingSeekBarPreference.f21941q < melodyTapLevelSettingSeekBarPreference.f21942r);
                    }
                }
            }
        }
        return Jb.l.f2618a;
    }
}
