package com.oplus.melody.ui.component.detail.rlmmorefunction;

import K9.a;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.preference.Preference;
import com.heytap.headset.R;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import kc.C1264t;

/* JADX INFO: loaded from: classes3.dex */
public class RlmMoreFunctionItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "rlmMoreFunctionItem";

    public RlmMoreFunctionItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        super(context);
        setTitle(R.string.melody_ui_more_function);
        setOnPreferenceClickListener(new a(context, detailMainViewModel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean lambda$new$0(Context context, DetailMainViewModel detailMainViewModel, Preference preference) {
        P7.a.a(context, detailMainViewModel.f20397b);
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.RLM_MORE_FUNCTIONS.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
        return true;
    }
}
