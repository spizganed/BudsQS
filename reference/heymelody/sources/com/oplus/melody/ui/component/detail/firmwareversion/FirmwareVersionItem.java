package com.oplus.melody.ui.component.detail.firmwareversion;

import A6.l;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.InterfaceC0601m;
import com.coui.appcompat.preference.COUIPreference;
import com.heytap.headset.R;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import l9.C1286a;

/* JADX INFO: loaded from: classes3.dex */
public class FirmwareVersionItem extends COUIPreference {
    public static final String ITEM_NAME = "firmwareVersion";
    private Context mContext;
    private InterfaceC0601m mLifecycleOwner;
    private DetailMainViewModel mViewModel;

    public FirmwareVersionItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        super(context);
        this.mContext = context;
        this.mViewModel = detailMainViewModel;
        this.mLifecycleOwner = interfaceC0601m;
        setTitle(R.string.melody_ui_firmware_version_title);
        if ("OPPO O-Free".equals(detailMainViewModel.f20398c)) {
            setSummary("O-Free_11_327");
        } else {
            setSummary(" ");
        }
        DetailMainViewModel detailMainViewModel2 = this.mViewModel;
        detailMainViewModel2.n(detailMainViewModel2.f20397b).e(this.mLifecycleOwner, new l(this, 28));
        DetailMainViewModel detailMainViewModel3 = this.mViewModel;
        AbstractC0939b.E().P(this.mContext, detailMainViewModel3.f20397b, detailMainViewModel3.f20398c);
        AbstractC0939b.E().U(this.mViewModel.f20397b);
    }

    public void onEarphoneDataChanged(C1286a c1286a) {
        c1286a.getIsSpp();
        String strU = N.u(c1286a.getEarphoneType(), c1286a.getDeviceVersionList(), c1286a.getHeadsetVersionList());
        if (TextUtils.isEmpty(strU)) {
            return;
        }
        setSummary(strU);
    }
}
