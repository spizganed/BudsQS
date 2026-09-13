package com.oplus.melody.ui.component.multidevicesconnnect;

import A6.g;
import F8.a;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.heytap.headset.R;
import com.oplus.melody.btsdk.protocol.commands.k;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import java.util.List;
import oa.i;
import pa.l;
import s8.AbstractC1508a;

/* JADX INFO: loaded from: classes3.dex */
public class MultipleDevicesConnectionActivity extends a {

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final /* synthetic */ int f21642V = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public String f21643U = null;

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Class cls;
        String str;
        super.onCreate(bundle);
        String strH = C0914u.h(getIntent(), "device_mac_info");
        this.f21643U = strH;
        if (TextUtils.isEmpty(strH)) {
            A.h("MultipleDevicesConnectionActivity", "onCreate mAddress is empty!");
            finish();
            return;
        }
        EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(this.f21643U);
        if (earphoneDTOW == null) {
            A.h("MultipleDevicesConnectionActivity", "openFragment earphoneDTO is null!");
            finish();
            return;
        }
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(earphoneDTOW.getProductId(), earphoneDTOW.getName());
        if (whitelistConfigDTOC == null) {
            A.h("MultipleDevicesConnectionActivity", "openFragment whitelistConfig is null!");
            finish();
            return;
        }
        if (whitelistConfigDTOC.getFunction() == null) {
            A.h("MultipleDevicesConnectionActivity", "openFragment whitelistConfig.getFunction() is null!");
            finish();
            return;
        }
        List<WhitelistConfigDTO.MultiConnectFunction> multiConnectFunctions = whitelistConfigDTOC.getFunction().getMultiConnectFunctions();
        if (C0901g.a(multiConnectFunctions)) {
            A.b("MultipleDevicesConnectionActivity", "openFragment isFunctionsEmpty is true!");
        } else if (N.k(1065, earphoneDTOW.getEarCapability())) {
            int iG = N.g(earphoneDTOW.getMacAddress(), earphoneDTOW.getDeviceVersionList());
            A.c("MultipleDevicesConnectionActivity", new k(iG, 22));
            for (WhitelistConfigDTO.MultiConnectFunction multiConnectFunction : multiConnectFunctions) {
                if (multiConnectFunction != null && (multiConnectFunction.getMinFirmVersion() == 0 || iG >= multiConnectFunction.getMinFirmVersion())) {
                    cls = l.class;
                    str = "MultipleDevicesConnectionFragmentV2";
                    break;
                }
            }
        } else {
            A.b("MultipleDevicesConnectionActivity", "openFragment hasCapabilityMultiConnectControl is false!");
        }
        cls = i.class;
        str = "MultipleConnection";
        Fragment fragmentD = u().D(str);
        if (fragmentD == null) {
            j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(cls.getName());
        }
        if (fragmentD == null) {
            throw MelodyException.e(0, "unable to create MultipleDevicesConnectionFragment");
        }
        fragmentD.setArguments(getIntent().getExtras());
        p pVarU = u();
        pVarU.getClass();
        g.c(pVarU, R.id.melody_ui_fragment_container, fragmentD, str).h(true, true);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
