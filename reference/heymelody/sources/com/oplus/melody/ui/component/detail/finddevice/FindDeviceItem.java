package com.oplus.melody.ui.component.detail.finddevice;

import F8.i;
import Jb.b;
import Q8.a;
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
public class FindDeviceItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "findDevice";

    public FindDeviceItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        super(context);
        setTitle(R.string.melody_ui_find_device_title);
        setOnPreferenceClickListener(new a(detailMainViewModel, context, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean lambda$new$0(DetailMainViewModel detailMainViewModel, Context context, Preference preference) {
        E8.a.w().getClass();
        b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/find_device");
        iVarA.f("product_id", detailMainViewModel.f20400e);
        iVarA.f("device_mac_info", detailMainViewModel.f20397b);
        iVarA.f("device_name", detailMainViewModel.f20398c);
        iVarA.f("device_title", detailMainViewModel.f20399d);
        iVarA.b(context);
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.FIND_EARBUDS.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
        return true;
    }
}
