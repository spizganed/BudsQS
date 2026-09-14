package com.oplus.melody.btsdk.manager;

import android.content.Intent;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.btsdk.ota.IUpgradeListener;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.C0906l;

/* JADX INFO: loaded from: classes.dex */
public class ZenModeUpgradeListener implements IUpgradeListener {
    private final String mPackageName = C0906l.f19501a.getPackageName();

    @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
    public final void S(int i10, String str) {
        Intent intent = new Intent("com.oplus.melody.btsdk.action.ZEN_MODE_OTA");
        intent.setPackage(this.mPackageName);
        intent.putExtra("stage", 2);
        intent.putExtra(ClientDataEntity.COL_STATUS, i10);
        C0905k.i(C0906l.f19501a, intent, null);
    }

    @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
    public final void b(int i10, String str) {
        Intent intent = new Intent("com.oplus.melody.btsdk.action.ZEN_MODE_OTA");
        intent.setPackage(this.mPackageName);
        intent.putExtra("stage", 1);
        intent.putExtra("progress", i10);
        C0905k.i(C0906l.f19501a, intent, null);
    }

    @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
    public final void c(String str) {
        Intent intent = new Intent("com.oplus.melody.btsdk.action.ZEN_MODE_OTA");
        intent.setPackage(this.mPackageName);
        intent.putExtra("stage", 0);
        C0905k.i(C0906l.f19501a, intent, null);
    }
}
