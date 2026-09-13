package com.oplus.melody.ui.component.detail.functionintroduction;

import E8.a;
import F8.i;
import G8.u;
import Jb.b;
import Wb.l;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.preference.Preference;
import com.heytap.headset.R;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import java.util.List;
import kc.C1264t;

/* JADX INFO: loaded from: classes3.dex */
public class FunctionIntroductionItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "functionIntroduction";

    public FunctionIntroductionItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        super(context);
        setTitle(R.string.melody_ui_function_introduction_title);
        setOnPreferenceClickListener(new u(this, detailMainViewModel, context, 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lambda$new$0(DetailMainViewModel detailMainViewModel, Context context, Preference preference) {
        a.w().getClass();
        b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/guide");
        iVarA.f("device_mac_info", detailMainViewModel.f20397b);
        iVarA.f("product_id", detailMainViewModel.f20400e);
        iVarA.f("product_color", String.valueOf(detailMainViewModel.f20401f));
        iVarA.b(context);
        setEnabled(true);
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.FUNCTION_GUIDE.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
        return true;
    }
}
