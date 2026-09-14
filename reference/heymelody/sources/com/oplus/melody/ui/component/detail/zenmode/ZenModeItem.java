package com.oplus.melody.ui.component.detail.zenmode;

import A6.b;
import A6.l;
import D7.C0379m;
import F8.i;
import S7.c;
import Z7.a;
import aa.C0556c;
import aa.C0557d;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.preference.Preference;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.zenmode.ZenModeRepository;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.detail.zenmode.scene.b;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import java.util.List;
import kc.C1264t;
import s8.AbstractC1508a;

/* JADX INFO: loaded from: classes3.dex */
public class ZenModeItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "ZenModeItem";
    public static final String TAG = "ZenModeItem";

    public ZenModeItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        int zenMode;
        super(context);
        setTitle(R.string.melody_ui_zen_mode_title);
        setSummary(R.string.melody_ui_zen_mode_summary);
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(detailMainViewModel.f20400e, detailMainViewModel.f20398c);
        if (whitelistConfigDTOC == null || whitelistConfigDTOC.getFunction() == null) {
            zenMode = 0;
        } else {
            zenMode = whitelistConfigDTOC.getFunction().getZenMode();
            if (zenMode == 2) {
                setSummary((CharSequence) null);
            }
        }
        setOnPreferenceClickListener(new C0556c(zenMode, detailMainViewModel, context));
        C0379m.b(C0379m.g(AbstractC0939b.E().v(detailMainViewModel.f20397b), new b(16))).e(interfaceC0601m, new l(this, 14));
        A.c("ZenModeItem", new c(detailMainViewModel, 12));
        if (zenMode == 2) {
            ZenModeRepository.j().t(detailMainViewModel.f20401f, detailMainViewModel.f20397b, detailMainViewModel.f20400e, "ZenModeItem");
            return;
        }
        a.g().d(detailMainViewModel.f20401f, 5, detailMainViewModel.f20400e);
        b.C0235b.f21441a.b(context, detailMainViewModel.f20400e, Integer.toString(detailMainViewModel.f20401f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean lambda$new$0(int i10, DetailMainViewModel detailMainViewModel, Context context, Preference preference) {
        A.b("ZenModeItem", "setOnClickListener ");
        String str = i10 == 2 ? "/ui/zen_mode/main_v2" : "/ui/zen_mode/main";
        E8.a.w().getClass();
        Jb.b<List<Wb.l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a(str);
        iVarA.f("device_mac_info", detailMainViewModel.f20397b);
        iVarA.f("device_name", detailMainViewModel.f20398c);
        iVarA.f("product_id", detailMainViewModel.f20400e);
        iVarA.f("product_color", String.valueOf(detailMainViewModel.f20401f));
        iVarA.b(context);
        String str2 = detailMainViewModel.f20400e;
        String str3 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.ZEN_MODE.getFunType(), str2, str3, N.t(detailMainViewModel.i(str3)), "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String lambda$new$1(DetailMainViewModel detailMainViewModel) {
        return "ZenModeItem pid=" + detailMainViewModel.f20400e + " color=" + detailMainViewModel.f20401f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEarphoneDataChanged(C0557d c0557d) {
        setEnabled(c0557d.getConnectionState() == 2);
    }
}
