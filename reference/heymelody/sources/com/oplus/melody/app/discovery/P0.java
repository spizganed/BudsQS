package com.oplus.melody.app.discovery;

import F8.i;
import android.text.TextUtils;
import android.view.View;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import java.util.List;
import kc.C1264t;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class P0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0850f1 f18983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ E0 f18984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f18985c;

    public /* synthetic */ P0(C0850f1 c0850f1, E0 e02, String str) {
        this.f18983a = c0850f1;
        this.f18984b = e02;
        this.f18985c = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0850f1 c0850f1 = this.f18983a;
        if (TextUtils.equals(c0850f1.f19071F, c0850f1.f18932e.getText())) {
            E0 e02 = this.f18984b;
            String productId = e02.getProductId();
            String id = e02.getId();
            String softwareVersion = e02.getSoftwareVersion();
            C1264t.t(AppConstant$FunctionType.FIRMWARE_UPGRADE_GUIDE.getFunType(), productId, id, softwareVersion, "4" + this.f18985c);
            E8.a.w().getClass();
            Jb.b<List<Wb.l<String, Class<?>>>> bVar = F8.i.f1668g;
            F8.i iVarA = i.a.a("/ui/firmware_upgrade");
            iVarA.f("device_mac_info", e02.getId());
            iVarA.f("product_id", e02.getProductId());
            iVarA.f("device_name", e02.getName());
            iVarA.f("product_color", String.valueOf(e02.getProductColorId()));
            iVarA.f("auto_firmware_update", Boolean.toString(true));
            DiscoveryDialogActivity discoveryDialogActivity = c0850f1.f18929b;
            iVarA.b(discoveryDialogActivity);
            discoveryDialogActivity.R();
        }
    }
}
