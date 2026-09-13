package com.heytap.headset.component.mydevicelist;

import F8.i;
import Wb.l;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.widget.Button;
import com.heytap.headset.component.mydevicelist.a;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import java.util.List;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MyDeviceListFragment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c implements a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MyDeviceListFragment f17499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f17500b;

    public c(MyDeviceListFragment myDeviceListFragment, a aVar) {
        this.f17499a = myDeviceListFragment;
        this.f17500b = aVar;
    }

    @Override // com.heytap.headset.component.mydevicelist.a.c
    public final void a(V3.a aVar) {
        MyDeviceListFragment myDeviceListFragment = this.f17499a;
        if (MyDeviceListFragment.r(myDeviceListFragment, aVar)) {
            return;
        }
        E8.a.w().getClass();
        Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/detail");
        iVarA.f("device_mac_info", aVar.getAddress());
        iVarA.f("device_name", aVar.getName());
        iVarA.a(1);
        iVarA.b(myDeviceListFragment.requireContext());
        myDeviceListFragment.requireActivity().finishAffinity();
    }

    @Override // com.heytap.headset.component.mydevicelist.a.c
    public final void b(V3.a aVar) {
        MyDeviceListFragment myDeviceListFragment = this.f17499a;
        if (MyDeviceListFragment.r(myDeviceListFragment, aVar)) {
            return;
        }
        if (!com.oplus.drs.core.d.d(BluetoothAdapter.getDefaultAdapter())) {
            C0905k.k(myDeviceListFragment.requireActivity(), new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
            return;
        }
        myDeviceListFragment.f17440y = true;
        myDeviceListFragment.f17439x = aVar;
        myDeviceListFragment.f17441z = aVar.getAddress();
        String address = aVar.getAddress();
        if (address != null) {
            if (myDeviceListFragment.f17436u != null) {
                AbstractC0939b.E().f(address);
            } else {
                h.i("deviceListViewModel");
                throw null;
            }
        }
    }

    @Override // com.heytap.headset.component.mydevicelist.a.c
    public final void c() {
        MyDeviceListFragment myDeviceListFragment = this.f17499a;
        if (myDeviceListFragment.f17427D) {
            Button button = myDeviceListFragment.f17434s;
            if (button != null) {
                button.setVisibility(this.f17500b.f17468c.f7498c > 0 ? 0 : 8);
            } else {
                h.i("deleteDeviceButton");
                throw null;
            }
        }
    }
}
