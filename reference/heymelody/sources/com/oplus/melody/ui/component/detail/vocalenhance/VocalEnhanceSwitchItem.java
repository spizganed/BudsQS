package com.oplus.melody.ui.component.detail.vocalenhance;

import A6.g;
import C6.e;
import D7.C0379m;
import F9.s;
import L8.Y;
import X9.a;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.heytap.headset.R;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import java.util.function.Consumer;
import kc.C1264t;

/* JADX INFO: loaded from: classes3.dex */
public class VocalEnhanceSwitchItem extends COUISwitchPreference {
    public static final String ITEM_NAME = "vocalEnhance";

    public VocalEnhanceSwitchItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        super(context);
        setTitle(R.string.melody_ui_vocal_enhancement_switch_title);
        setOnPreferenceChangeListener(new s(detailMainViewModel, 15));
        C0379m.b(C0379m.g(AbstractC0939b.E().v(detailMainViewModel.f20397b), new g(14))).e(interfaceC0601m, new e(this, 17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean lambda$new$0(DetailMainViewModel detailMainViewModel, Preference preference, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        AbstractC0939b.E().E0(9, zBooleanValue, detailMainViewModel.f20397b).thenAccept((Consumer) new Y());
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.VOICE_ENHANCE.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), zBooleanValue ? BaseHealthModule.TRACK_FATIGUE_REMIND : VersionInfo.VENDOR_CODE_DEFAULT_VERSION);
        return true;
    }

    public void onEarphoneDataChanged(a aVar) {
        setChecked(aVar.isVocalEnhanceOn());
        setEnabled(aVar.isConnected());
    }
}
